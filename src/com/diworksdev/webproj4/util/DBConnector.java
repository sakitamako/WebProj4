package com.diworksdev.webproj4.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//データベースを使う必要がある場合、DB接続 (コネクション)の設定を行うファイル
//DBConnectorでは、接続するDBの「場所」「名前」や接続する「ユーザ名」「パスワード」の設定を行う
public class DBConnector {

	//JDBC ドライバー名
	private static String driverName = "com.mysql.jdbc.Driver";

	//データベース接続 URL
	private static String url = "jdbc:mysql://localhost/testdb";

	//データベース接続ユーザ名
	private static String user = "root";

	//データベース接続パスワード
	private static String password = "root";

	public Connection getConnection() {

		//接続オブジェクトの定義
		Connection con = null;

		//try.catchはjavaの例外処理のための構文
		try{

			//tryの中にはエラーが発生しそうな処理を書く
			Class.forName(driverName);

			//ドライバーがロードされ使えるような状態にしている、覚える。
			//設定した情報を使って自分のパソコンにインストールされているMySQLサーバへ接続するための記述
			con = DriverManager.getConnection(url,user,password);

		//tryの中でエラーが発生した場合、catchが受け取り
		//例外がスローされる原因となったエラーまたは動作の説明を返します
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		//tryの中でエラーが発生した場合、catchが受け取り
		//例外がスローされる原因となったエラーまたは動作の説明を返します
		} catch (SQLException e) {
			e.printStackTrace();

		}

		//MySQLサーバに接続した結果を,
		//メソッドの呼び出し元に渡します
		return con;
	}

}
