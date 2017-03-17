package cn.xuxianda.dao;

import org.apache.ibatis.annotations.Param;

import cn.xuxianda.entity.Account;

public interface AccountMapper extends BaseMapper<Account> {
    
	Account login(Account account);
	
	int updateSelectParams(Account account);

	Account findAccountByAccountLogin(/*@Param("accLogin")*/ String accLogin);
	
}