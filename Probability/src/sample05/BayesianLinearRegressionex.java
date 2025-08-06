package sample05;

import java.util.Arrays;

public class BayesianLinearRegressionex {

	public static void main(String[] args) {
		// 説明変数（気温、季節）
		double[][] X = {
				{ 1.0, 25.0, 2.0 }, // 1.0はバイアス項（切片）
				{ 1.0, 30.0, 2.0 },
				{ 1.0, 20.0, 1.0 },
				{ 1.0, 15.0, 4.0 },
				{ 1.0, 10.0, 4.0 },
				{ 1.0, 18.0, 3.0 }
		};
		double[] y = { 200, 300, 150, 50, 30, 100 };

		// 観測誤差の分散（σ²）
		double sigma2 = 100.0;

		// 事前平均（ゼロベクトル）
		double[] m0 = { 0.0, 0.0, 0.0 };

		// 事前分散（単位行列 × 1000）
		double[][] S0 = {
				{ 1000, 0, 0 },
				{ 0, 1000, 0 },
				{ 0, 0, 1000 }
		};

		// X^T * X
		double[][] Xt = transpose(X);
		double[][] XtX = multiply(Xt, X);

		// X^T * y
		double[] Xty = multiplyVec(Xt, y);

		// S0^-1
		double[][] S0inv = inverseDiagonal(S0);

		// 事後分散 Sn = (S0^-1 + 1/σ² * X^T X)^-1
		double[][] SnInv = add(S0inv, scale(XtX, 1.0 / sigma2));
		double[][] Sn = inverseDiagonal(SnInv);

		// 事後平均 mn = Sn * (S0^-1 * m0 + 1/σ² * X^T y)
		double[] part1 = multiplyVec(S0inv, m0);
		double[] part2 = scaleVec(Xty, 1.0 / sigma2);
		double[] sum = addVec(part1, part2);
		double[] mn = multiplyVec(Sn, sum);

		// 結果表示
		System.out.printf("事後平均 β: %s\n", Arrays.toString(mn));
		System.out.printf("予測売上（28℃ 夏）: %.2f\n", mn[0] + mn[1] * 28.0 + mn[2] * 2.0);
	}

	// 行列・ベクトル計算ユーティリティ（簡易）

	public static double[][] transpose(double[][] A) {
		int rows = A.length, cols = A[0].length;
		double[][] T = new double[cols][rows];
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				T[j][i] = A[i][j];
		return T;
	}

	public static double[][] multiply(double[][] A, double[][] B) {
		int n = A.length, m = B[0].length, p = B.length;
		double[][] result = new double[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				for (int k = 0; k < p; k++)
					result[i][j] += A[i][k] * B[k][j];
		return result;
	}

	public static double[] multiplyVec(double[][] A, double[] v) {
		int n = A.length, m = A[0].length;
		double[] result = new double[n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				result[i] += A[i][j] * v[j];
		return result;
	}

	public static double[][] scale(double[][] A, double s) {
		int n = A.length, m = A[0].length;
		double[][] result = new double[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				result[i][j] = A[i][j] * s;
		return result;
	}

	public static double[] scaleVec(double[] v, double s) {
		double[] result = new double[v.length];
		for (int i = 0; i < v.length; i++)
			result[i] = v[i] * s;
		return result;
	}

	public static double[] addVec(double[] a, double[] b) {
		double[] result = new double[a.length];
		for (int i = 0; i < a.length; i++)
			result[i] = a[i] + b[i];
		return result;
	}

	public static double[][] add(double[][] A, double[][] B) {
		int n = A.length, m = A[0].length;
		double[][] result = new double[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				result[i][j] = A[i][j] + B[i][j];
		return result;
	}

	// 対角行列の逆行列（簡易用）
	public static double[][] inverseDiagonal(double[][] A) {
		int n = A.length;
		double[][] inv = new double[n][n];
		for (int i = 0; i < n; i++)
			inv[i][i] = 1.0 / A[i][i];
		return inv;
	}
}
