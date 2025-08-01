# Multi-Threaded を使う練習(CSVファイル)

このプロジェクトは、CSVファイルからユーザーデータを読み込み、マルチスレッドで`User`オブジェクトに変換し、データベースに保存するJavaアプリケーションです。ログはデータベースとLog4jの両方に記録されます。


---

## 使用技術

- Java
- MySQL
- Log4j2
- マルチスレッド（ExecutorService, BlockingQueue, CountDownLatch）

---

## 必要ライブラリ

以下のJARを `lib/` フォルダに配置し、ビルドパスに追加してください：

- `mysql-connector-java-9.3.0.jar`
- `log4j-api-2.25.0.jar`
- `log4j-core-2.25.0.jar`

---

## CSVファイル形式

1行目はヘッダーとして無視されます。  
2行目以降は以下のフォーマットで記述してください：

id,name,email
1,Taro Yamada,taro@example.com
2,Hanako Sato,hanako@example.com


---

## 使用方法

### 1. `MultiInsert` を実行

```java
MultiInsert multiInsert = new MultiInsert();
List<User> users = multiInsert.multithread("users.csv");

InsertDao dao = new InsertDao();
for (User user : users) {
    dao.insert(user);
}
```
## DBテーブル仕様

### users テーブル
```

| カラム名     | 型              | 制約                | 説明                   |
|--------------|----------------|---------------------|------------------------|
| id           | INT            | PRIMARY KEY         | ユーザーID             |
| name         | VARCHAR(100)   | NOT NULL            | ユーザー名             |
| email        | VARCHAR(255)   | NOT NULL, UNIQUE    | ユーザーのメールアドレス |
| created_at   | DATETIME       | DEFAULT CURRENT_TIMESTAMP | 登録日時         |



### process_logs テーブル

| カラム名     | 型              | 制約                | 説明                       |
|--------------|----------------|---------------------|----------------------------|
| id           | INT            | AUTO_INCREMENT, PRIMARY KEY | ログID               |
| log_time     | DATETIME       | NOT NULL, DEFAULT CURRENT_TIMESTAMP | ログ記録時間 |
| thread_name  | VARCHAR(50)    | NOT NULL            | スレッド名または処理名       |
| log_level    | VARCHAR(10)    | NOT NULL            | ログレベル（例: INFO, ERROR）|
| message      | TEXT           | NOT NULL            | エラーメッセージまたはログ内容 |

```

## 課題点
- トランザクション処理を導入したい
- DBの書き込みに加えて、ファイルへの書き出し
- ログの選定
