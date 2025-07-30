package sample01;

public class Main {

	public static void main(String[] args) {
		MaxFinder finder = new MaxFinder();

		int[] num = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 18374 };

		System.out.println(finder.findMax(num));

		Fibonacci fibonacci = new Fibonacci();

		System.out.println(fibonacci.fib(2));

		LogicFab logicFab = new LogicFab();

		logicFab.ret(100, 200);

	}

}
