package cn.xuxianda.service;

import cn.xuxianda.entity.Account;

public interface AccountService extends BaseService<Account> {
	public Account login(Account account);
	public int updateSelectParams(Account account);
	public Account findAccountByAccountLogin(String accLogin);
}
