# 正規分布の学習

## 概要

このプログラムは、Javaの `Random` クラスに用意されている `nextGaussian()` メソッドを用いて、**正規分布（ガウス分布）**に従う乱数を大量に生成し、その平均値と標準偏差を計算することで、理論値（平均0, 標準偏差1）に近づくことを確認するものです。

---

## 正規分布（Gaussian Distribution）とは？

正規分布とは、次の確率密度関数（PDF）で表される連続型確率分布です：


ここで：

- μ：平均（mean）
- σ：標準偏差（standard deviation）
- σ²：分散（variance）

**特徴：**
- 平均 μ を中心とした左右対称のベル型曲線
- データの68%は μ ± σ の範囲に収まる
- データの99.7%は μ ± 3σ の範囲に収まる（「68-95-99.7ルール」）

---

## コード解説

```java
package sample04;

import java.util.Random;

public class GaussianDistribution {

    public static void main(String[] args) {
        Random random = new Random();

        int trials = 100_000;
        double sum = 0;
        double sumSquares = 0;

        for (int i = 0; i < trials; i++) {
            double value = random.nextGaussian(); // 平均0, 標準偏差1
            sum += value;
            sumSquares += value * value;
        }

        double mean = sum / trials;
        double variance = (sumSquares / trials) - (mean * mean);
        double stddev = Math.sqrt(variance);

        System.out.printf("平均： %.5f\n", mean);
        System.out.printf("標準偏差： %.5f\n", stddev);
    }
}

```
## 応用できそうな場面
- 統計的推定
- ノイズ生成 <- 拡散モデルなどがキーワード
