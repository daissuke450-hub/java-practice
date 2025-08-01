# 条件付き確率（風邪検査の例）

このドキュメントでは、Javaを使って「条件付き確率」の考え方を風邪検査の例で学びます。

---

## 条件付き確率の概要

条件付き確率とは、**ある条件が与えられたもとで、特定の事象が起こる確率**です。  
次の式で定義されます：


この式は、「Bが起こったという条件のもとで、Aが起こる確率」を意味します。

---

## シナリオ（風邪検査）

ある集団1000人を対象に風邪検査を行ったところ、以下のような結果が得られました。

| 状況         | 陽性（Positive） | 陰性（Negative） | 合計 |
|--------------|------------------|------------------|------|
| 風邪あり     | 80               | 20               | 100  |
| 風邪なし     | 90               | 810              | 900  |
| **合計**     | 170              | 830              | 1000 |

---

## Javaによるシミュレーション

以下に、上記のデータを使って「陽性のとき、実際に風邪である確率（条件付き確率）」を求めるJavaコードを示します。

```java
public class FluTestSimulation {
    public static void main(String[] args) {
        // 1. 風邪検査のデータを定義する
        int fluAndPositive = 80;
        int fluAndNegative = 20;
        int noFluAndPositive = 90;
        int noFluAndNegative = 810;

        // 2. 必要な合計を計算する
        int totalPositive = fluAndPositive + noFluAndPositive; // 陽性の合計
        int totalTested = fluAndPositive + fluAndNegative + noFluAndPositive + noFluAndNegative; // 全体人数

        // 3. 条件付き確率を計算する
        double pFluGivenPositive = (double) fluAndPositive / totalPositive;

        // 4. 結果を出力する
        System.out.println("P(風邪あり | 陽性) = " + pFluGivenPositive);
    }
}
```
## 出力例
P(風邪あり | 陽性) = 0.47058823529411764
