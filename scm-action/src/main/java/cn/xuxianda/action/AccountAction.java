package cn.xuxianda.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.xuxianda.entity.Account;
import cn.xuxianda.entity.DataElement;
import cn.xuxianda.entity.DataElementNlv;
import cn.xuxianda.exception.CustomException;
import cn.xuxianda.service.AccountService;
import cn.xuxianda.service.DataElementNlvService;
import cn.xuxianda.service.DataElementService;
import cn.xuxianda.utils.SpringPropertiesUtil;

@Controller
@RequestMapping("/account")
public class AccountAction extends BaseAction {

	@Autowired
	private AccountService accountService;

	@Autowired
	private DataElementService dataElementService;
	@Autowired
	private DataElementNlvService dataElementNlvService;

	/*public String login(Account account, HttpServletRequest request,
			HttpSession session) {
		Account ac = (Account) session.getAttribute("account");
		if (ac != null) {
			return "forward:/WEB-INF/main/main.jsp";
		}
		if (account == null || account.getAccLogin() == null
				&& account.getAccPass() == null) {
			return "redirect:/login.jsp";
		}
		Account acc = accountService.login(account);
		if (acc != null) {
			*//**
			 * 初始化数据加载
			 *//*
			Map<String, Object> sysParam = new HashMap<String, Object>();
			ServletContext application = session.getServletContext();
			List<DataElement> dataElementList = dataElementService.findAll();
			for (DataElement dataElement : dataElementList) {
				Map map = null;
				Long dataElementId = dataElement.getDataElementId();
				List<DataElementNlv> dataElementNlvList = dataElementNlvService
						.findAllByFK(dataElementId);
				if (dataElementNlvList != null
						&& dataElementNlvList.size() != 0) {
					map = new HashMap();
					for (DataElementNlv dataElementNlv : dataElementNlvList) {
						map.put(dataElementNlv.getKey(),
								dataElementNlv.getText());
					}
					sysParam.put(dataElement.getField(), map);
				}
			}
			application.setAttribute("sysParam", sysParam);
			// {supType={3=普通供应商, 2=二级供应商, 1=一级供应商}}
			// {supType={3=二级供应商, 2=一级供应商, 1=普通供应商}, goodsColor={red=红色,
			// blue=蓝色, green=绿色}}

			// 存session
			session.setAttribute("account", acc);
			return "forward:/WEB-INF/main/main.jsp";
		} else {
			request.setAttribute("msg", "用户名或密码错误");
			return "forward:/login.jsp";
		}
	}*/

	// 登陆提交地址，和applicationContext-shiro.xml中配置的loginurl一致
	@RequestMapping(value="/login"/*,method=RequestMethod.GET*/)
	public String login(HttpServletRequest request) throws Exception {
		// 如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
		String exceptionClassName = (String) request
				.getAttribute("shiroLoginFailure");
		// 根据shiro返回的异常类路径判断，抛出指定异常信息
		if (exceptionClassName != null) {
			if (UnknownAccountException.class.getName().equals(
					exceptionClassName)) {
				// 最终会抛给异常处理器
				throw new CustomException("账号不存在");
			} else if (IncorrectCredentialsException.class.getName().equals(
					exceptionClassName)) {
				throw new CustomException("用户名/密码错误");
			} else if ("randomCodeError".equals(exceptionClassName)) {
				throw new CustomException("验证码错误 ");
			} else {
				throw new Exception();// 最终在异常处理器生成未知错误
			}
		}
		// 此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
		return "forward:/login.jsp";
	}

	@RequestMapping("/first")
	public String firstPage(HttpServletRequest request,HttpSession session) {
		
		// 从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		// 取身份信息
		Account account = (Account) subject.getPrincipal();
		// 通过model传到页面
		account.getPermissions();
		account = accountService.findAccountByAccountLogin(account.getAccLogin());
		session.setAttribute("account", account);

		return "forward:/WEB-INF/main/main.jsp";

	}

	@RequestMapping("/login1")
	public void testInterceptor() {

	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login.jsp";
	}

	@RequestMapping("/testException")
	public void testException() throws Exception {
		throw new CustomException("不能除0");
	}

}
