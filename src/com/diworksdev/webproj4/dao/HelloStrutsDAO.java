package com.diworksdev.webproj4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.diworksdev.webproj4.dto.HelloStrutsDTO;
import com.diworksdev.webproj4.util.DBConnector;

public class HelloStrutsDAO {

	//インスタンス化
	List<HelloStrutsDTO> helloStrutsDTOList = new ArrayList<HelloStrutsDTO>();

	//クラス、メソッドの定義
	//HelloStrutsDTO型を最後に呼び出し元に渡すので、HelloStrutsDTO型を戻り値にしたメソッドを作る
	public List<HelloStrutsDTO> select() {

		//DBConnectorのインスタンス化
		//DBへの接続準備、DBと会話するためのコード、これでログインできる
		//Connectionは特定のデータベースとの接続
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		//sql文を書く
		//SELECT データを抽出する
		//＊ テーブルに含まれる項目全て
		//FROM 〇〇 〇〇という名前のテーブルからデータを選択する
		String sql = "select * from users";

		//try.catchはjavaの例外処理のための構文
		try {

			//tryの中にはエラーが発生しそうな処理を書く
			//PreparedStatement（DBまで運んでくれる箱のイメージ）に代入
			PreparedStatement ps = con.prepareStatement(sql);

			//executeQuery()/executeUpdate()で実行
			//（select文の場合はexectuteQuery()を使う）
			// select文のSQL文を実行するメソッドで戻り値はResultSet
			ResultSet rs = ps.executeQuery();

			//ここでは2つのことをしている
			//下に1行ずらすこと
			//データが存在する限り表示する
			while(rs.next()) {

				//getConnectionの呼び出し（DBと接続する）
				HelloStrutsDTO dto = new HelloStrutsDTO();

				dto.setUserId(rs.getInt("user_id"));
				dto.setUserName(rs.getString("user_name"));
				dto.setPassword(rs.getString("password"));
				dto.setResult("MySQL と接続できます。");

				helloStrutsDTOList.add(dto);
			}

		//処理中にSQL関連のエラーが発生した際に実行する処理
		//tryの中でエラーが発生した場合、catchが受け取り
		//例外がスローされる原因となったエラーまたは動作の説明を返す
		} catch (SQLException e) {
			e.printStackTrace();

		}

		//try.catchはjavaの例外処理のための構文
		try {

			//⑨con.close()で接続を切る
			//データベースとの接続をクローズ
			//これをしないとデータベースを接続したまま作業が実行されてしまってメモリに負荷がかかる
			con.close();

		//処理中にSQL関連のエラーが発生した際に実行する処理
		//tryの中でエラーが発生した場合、catchが受け取り
		//例外がスローされる原因となったエラーまたは動作の説明を返す
		} catch (SQLException e) {
			e.printStackTrace();

		}

		//dtoに入った値を呼び出し元であるHelloStrutsDTOクラスに渡す
		return helloStrutsDTOList;

	}

}
