package sample01;

public class Fibonacci {

	public int fib(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 0;
		}

		return fib(n - 1) + fib(n - 2);

	}

}
