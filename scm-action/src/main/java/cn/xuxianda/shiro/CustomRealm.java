package cn.xuxianda.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import cn.xuxianda.entity.Account;
import cn.xuxianda.entity.Permission;
import cn.xuxianda.service.AccountService;
import cn.xuxianda.service.PermissionService;

public class CustomRealm extends AuthorizingRealm {

	@Autowired
	public AccountService accountService;

	@Autowired
	public PermissionService permissionService;

	// 设置realm的名称
	@Override
	public void setName(String name) {
		super.setName("customRealm");
	}

	// 用于认证
	// 没有连接数据库的方法
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {

		// token是用户输入的用户名和密码
		// 第一步从token中取出用户名
		String accLogin = (String) token.getPrincipal();

		// 第二步：根据用户输入的userCode从数据库查询
		// ....
		Account account = null;
		try {
			account = accountService.findAccountByAccountLogin(accLogin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (account == null) {
 			return null;
		}
		// 从数据库查询到密码
		String password = account.getAccPass();
		// 盐
		String salt = account.getSalt();

		List<Permission> menus = null;
		// 查询词用的菜单
		try {
			menus = permissionService.findPermissionByLoginId(
					account.getAccId(), "menu");
		} catch (Exception e) {
			e.printStackTrace();
		}

		Account real = new Account();
		real.setAccLogin(account.getAccLogin());
		real.setAccId(account.getAccId());
		real.setMenus(menus);

		// 将activeUser设置simpleAuthenticationInfo
		  SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
				  real, password, ByteSource.Util.bytes(salt) ,this.getName());
		return simpleAuthenticationInfo;
	}

	// 用于授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		Account account = (Account) principals.getPrimaryPrincipal();
		List<Permission> permissionObject = null;
		try {
			Integer accId = account.getAccId();
			permissionObject = permissionService.findPermissionByLoginId(accId,
					"permission");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		List<String> permissions = new ArrayList<String>();
		for (Permission temp : permissionObject) {
			permissions.add(temp.getPercode());
		}
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addStringPermissions(permissions);
		return simpleAuthorizationInfo;
	}

	// 清除缓存
	public void clearCached() {
		PrincipalCollection principals = SecurityUtils.getSubject()
				.getPrincipals();
		super.clearCache(principals);
	}

}
