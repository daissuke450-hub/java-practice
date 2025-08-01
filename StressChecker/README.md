# PHQ-9 ストレスチェック ＋ Zスコア診断システム

## 概要

本システムは、**PHQ-9（うつ病スクリーニングツール）**に基づいたストレスチェックを行い、  
- 通院の必要性の判断  
- Zスコアを活用した異常値の検出 -> 特異な生徒・患者の早期発見を目的とした Java アプリケーションです。
- mainクラスはGUI導入を想定しています。

---

## 開発目的

- PHQ-9のスコアから精神的健康状態を可視化
- 合計スコアから**診断レベル**（正常〜重度のうつ）を評価
- **Zスコアを用いた統計的異常検出**により、通院が必要だがスコア上は見逃されがちなケースにも対応
- 長期的には、スコア平均・標準偏差の推移から**治療効果のフィードバック**を得る

---

## 想定利用シーン

- 学校：全校生徒に対するストレスチェック（異常傾向の早期発見）
- 病院：患者の経過観察、特異なスコア傾向の把握
- 産業メンタルヘルス：社員の精神的健康のモニタリング

---

## システム構成

### 開発環境

- Java（JDK 8以降）
- Eclipse
- MySQL
- Apache DbUtils（DB接続用ライブラリ）


---

## データベース構成

```sql
CREATE TABLE phq9_results (
    id INT AUTO_INCREMENT PRIMARY KEY,
    assessment_date DATE NOT NULL,
    total_score INT NOT NULL,
    evaluation VARCHAR(50) NOT NULL
);

```

## 特徴的な機能
- カットオフ評価：合計スコアに応じて、正常・軽度・中等度・重度のうつを分類。
- Zスコア以上検出：平均 ± 2σ を超える異常スコアを自動で抽出可能。
