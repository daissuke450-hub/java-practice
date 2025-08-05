# ベイズの定理（Bayes' Theorem）解説

---

## 1. ベイズの定理とは？

ベイズの定理は、**条件付き確率の逆方向を計算する公式**です。

\[
P(A|B) = \frac{P(B|A) \cdot P(A)}{P(B)}
\]

- \(P(A|B)\)：Bが起きたときにAが起きる確率（求めたい確率）
- \(P(B|A)\)：Aが起きたときにBが起きる確率（既知）
- \(P(A)\)：Aが起きる確率（事前確率）
- \(P(B)\)：Bが起きる確率（周辺確率、正規化のための値）

---

## 2. 具体例：「病気の検査」

| 項目 | 値 | 意味 |
|---|---|---|
| \(P(D)\) | 0.01 | 病気にかかっている確率（事前確率） |
| \(P(\neg D)\) | 0.99 | 病気でない確率 |
| \(P(Pos|D)\) | 0.99 | 病気の人が陽性と判定される確率（真陽性率） |
| \(P(Pos|\neg D)\) | 0.05 | 健康な人が誤って陽性になる確率（偽陽性率） |

---

## 3. 問題

検査で陽性だった場合、本当に病気である確率 \(P(D|Pos)\) は？

---

## 4. ベイズの定理による計算

\[
P(D|Pos) = \frac{P(Pos|D) \cdot P(D)}{P(Pos)}
\]

\[
P(Pos) = P(Pos|D) \cdot P(D) + P(Pos|\neg D) \cdot P(\neg D)
\]

数値を代入すると、

\[
P(D|Pos) = \frac{0.99 \times 0.01}{0.99 \times 0.01 + 0.05 \times 0.99} = \frac{0.0099}{0.0594} \approx 0.1667 = 16.67\%
\]

---

## 5. 解説

- 検査で陽性でも、実際に病気である確率は約16.67%と低い。
- これは、病気の人が非常に少ない（1%）ため、健康な人の誤検出が結果に大きく影響するため。

---

## 6. Javaコード例

```java
public class BayesTheoremCorrect {

    public static void main(String[] args) {
        double pDisease = 0.01;
        double pNoDisease = 1 - pDisease;

        double pPosGivenDisease = 0.99;
        double pPosGivenNoDisease = 0.05;

        double numerator = pPosGivenDisease * pDisease;
        double denominator = numerator + (pPosGivenNoDisease * pNoDisease);

        double result = numerator / denominator;

        System.out.printf("検査で陽性だったとき、実際に病気である確率: %.5f (%.2f%%)\n", result, result * 100);
    }
}
