#  THE IDOLM@STER API meets Spring Boot + Kotlin

## 概要
[yagi2/imas_api](https://github.com/yagi2/imas_api)をSpring Boot + Kotlinでやっていくリポジトリ。
作りたいAndroidアプリにAPIが必要で、せっかくだからKotlinでSpring Bootを使ってAPIを作ってみるための実装テストプロジェクト。

## データベースの設定
`$ psql -f SQL/init.sql -U <user>`  
`$ psql -f SQL/<sql file> -U <user>`

## 動かし方
1. postgresqlを設定する
2. ./gradlew bootRun する
3. localhost:8080/swagger-ui.html でドキュメントがみれる  