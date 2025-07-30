# java crud処理練習

このリポジトリーはJavaとMySQLを使ったcrud処理の学習用アプリケーションです。

## 機能概要
- ユーザーの登録・検索・更新
- csvファイルの読み込み(単一スレッド)

## 使用技術
言語：java 24.0.1
ビルド：手動(Maven未使用)
DB：MySQL

## セットアップ手順

1. 'lib/' フォルダに必要なJARファイルを配置
2. 'src/' 以下をEclipse等で読み込み
3. 'DBUtil.java'のDB接続設定を環境に合わせて変更
4. MySQLで'users'テーブルを作成
5. 'Main.java' を実行

## テストについて
JUnitによる単体テストを一部実装。
