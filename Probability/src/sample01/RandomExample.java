package sample01;

import java.util.Random;

public class RandomExample {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Random random = new Random();

		// 0.0以上1.0未満のラインダムなdouble値
		double randomValue = random.nextDouble();
		System.out.println("乱数(0.0～1.0)：" + randomValue);

		// 0～5までの整数乱数
		int randomInt = random.nextInt(5);
		System.out.println("整数(0～5)：" + randomInt);

	}

}
