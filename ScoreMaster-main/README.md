# 生徒成績管理システム

## 概要
このシステムは、生徒の成績データを管理し、教科ごとの平均点算出や評価を行い、結果をファイル出力するJavaベースの成績管理アプリケーションです。  
MyBatisを用いてMySQLデータベースと連携する。

---

## 必要ライブラリ

- MyBatis 3.5.19
- MySQL Connector/J 9.3.0

`lib/`フォルダにJARファイルを配置し、ビルドパスに追加してください。

---

## データベース設計

### テーブル一覧

| テーブル名       | 用途                     |
|--------------|------------------------|
| students     | 生徒情報管理                |
| subjects     | 教科情報管理                |
| subject_scores | 各生徒の教科ごとの点数と評価情報 |

## SQLテーブル定義（一部抜粋）

-- 生徒情報テーブル
CREATE TABLE students (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    grade INT NOT NULL,
    class_name VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 教科テーブル
CREATE TABLE subjects (
    subject_id INT PRIMARY KEY AUTO_INCREMENT,
    subject_name VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 教科点数テーブル
CREATE TABLE subject_scores (
    score_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    subject_id INT NOT NULL,
    score INT NOT NULL CHECK (score BETWEEN 0 AND 100),
    evaluation_absolute INT,
    evaluation_relative INT,
    evaluation_final INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (subject_id) REFERENCES subjects(subject_id)
);

---

## 主な機能

- CSVファイルから生徒の成績データを読み込みDB登録  
- 教科ごとの平均点算出  
- 点数の絶対評価と相対評価の算出および最終評価決定  
- 評価結果のテキストファイル出力  

---

## 設定ファイル

- `db.properties`  
  DB接続情報（ユーザー名、パスワード、URLなど）  
- `Mapper.xml`  
  SQL文やMyBatisのマッピング設定  

---

## 実行方法

1. MySQLにデータベースとテーブルを作成  
2. `db.properties` に接続情報を設定  
3. `lib/` フォルダのJARをプロジェクトに追加  
4. EclipseなどのIDEでプロジェクトをビルド  
5. `app.Main` の `main` メソッドから実行し動作確認  

