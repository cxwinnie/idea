package cn.xuxianda.entity;

import java.io.Serializable;
import java.util.List;

//用户表
public class Account implements Serializable{
   
	private static final long serialVersionUID = 651249684843712155L;

	private Integer accId;

    private String accLogin;

    private String accName;

    private String accPass;

    private String headImage;
    
    private String salt;
    
    private boolean locked;
    
    private List<Permission> menus;
    
    private List<Permission> permissions;
    
    public Integer getAccId() {
        return accId;
    }

    public void setAccId(Integer accId) {
        this.accId = accId;
    }

    public String getAccLogin() {
        return accLogin;
    }

    public void setAccLogin(String accLogin) {
        this.accLogin = accLogin;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAccPass() {
        return accPass;
    }

    public void setAccPass(String accPass) {
        this.accPass = accPass;
    }

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public List<Permission> getMenus() {
		return menus;
	}

	public void setMenus(List<Permission> menus) {
		this.menus = menus;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}
}