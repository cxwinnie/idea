package cn.xuxianda.test;

import java.util.UUID;


public class TestUUID {

	public static void main(String[] args){
		UUID randomUUID = UUID.randomUUID();
		System.out.println(randomUUID.toString().replace("-", "").length());
	}
	
}
