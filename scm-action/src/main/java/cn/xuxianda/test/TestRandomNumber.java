package cn.xuxianda.test;

import java.util.Random;

/**
 * 验证码原理
 * @author Xianda Xu
 *
 */
public class TestRandomNumber {

	public static String randomNumber(){
		String number = "";
		Random random = new Random();
		while(number.length()<6){
			number = String.valueOf(random.nextInt(1000000));//随机取一个大于0小于1000000的数
		}
		return number;
	}
	
	public static void main(String[] args) {
		for(int i = 0;i < 10;i++){
			System.out.println(TestRandomNumber.randomNumber());
		}
	}
}
