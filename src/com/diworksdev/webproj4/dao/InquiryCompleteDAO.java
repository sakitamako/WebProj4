package com.diworksdev.webproj4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.diworksdev.webproj4.dto.InquiryDTO;
import com.diworksdev.webproj4.util.DBConnector;

public class InquiryCompleteDAO {

	//インスタンス化
	List<InquiryDTO> inquiryDTOList = new ArrayList<InquiryDTO>();

	//①クラス、メソッドの定義
	//LoginDTO型を最後に呼び出し元に渡すので、LoginDTO型を戻り値にしたメソッドを作る
	//Actionクラスの値を引数として受け取る
	public List<InquiryDTO> select() {

		//②DBConnectorのインスタンス化
		//DBへの接続準備、DBと会話するためのコード、これでログインできる
		//Connectionは特定のデータベースとの接続
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		//④sql文を書く：値は ? を入れておく（どんな値でも使いまわしできるようにするため
		//?に入る条件を満たしたデータがsqlに代入される
		String sql = "select * from inquiry";

		//try.catchはjavaの例外処理のための構文
		try {

			//tryの中にはエラーが発生しそうな処理を書く
			//⑤PreparedStatement（DBまで運んでくれる箱のイメージ）に代入
			//定義したSQL文の1番目の?にActionから送られたname、
			//2番目の?にActionから送られたpasswordがそれぞれ入る
			PreparedStatement ps = con.prepareStatement(sql);

			//⑦executeQuery()/executeUpdate()で実行
			//（select文の場合はexectuteQuery()を使う）
			// select文のSQL文を実行するメソッドで戻り値はResultSet
			ResultSet rs = ps.executeQuery();

			//ここでは2つのことをしている
			//下に1行ずらすこと
			//データが存在している限り表示する
			while(rs.next()) {

				//インスタンス化
				InquiryDTO dto = new InquiryDTO();

				//⑧結果の処理（select文で取得した値をDTOに格納）
				//select文でDBから取得した情報をString型に変換してDTOクラスに格納
				//LoginDTOクラスのsetName、setPassword（setter）を利用
				dto.setName(rs.getString("name"));
				dto.setQtype(rs.getString("qtype"));
				dto.setBody(rs.getString("body"));

				inquiryDTOList.add(dto);

			}

		//DB接続を終了する際、必ず書くメソッド
		//最後に実行されるものを指定するための構文
		//例外が発生しcatchされてもされなくても、共通してやってほしい処理や、やらなければいけない処理を書くところ。
		} catch (SQLException e) {
			e.printStackTrace();

		}

		//try.catchはjavaの例外処理のための構文
		try {
			con.close();

		//DB接続を終了する際、必ず書くメソッド
		//最後に実行されるものを指定するための構文
		//例外が発生しcatchされてもされなくても、共通してやってほしい処理や、やらなければいけない処理を書くところ。
		} catch (SQLException e) {
			e.printStackTrace();

		}

		//戻り値
		//処理結果を返す
		return inquiryDTOList;

	}

	//①クラス、メソッドの定義
	//LoginDTO型を最後に呼び出し元に渡すので、LoginDTO型を戻り値にしたメソッドを作る
	//Actionクラスの値を引数として受け取る
	public int insert(String name, String qtype, String body) {
		int ret = 0;

		//②DBConnectorのインスタンス化
		//DBへの接続準備、DBと会話するためのコード、これでログインできる
		//Connectionは特定のデータベースとの接続
		DBConnector db = new DBConnector();

		//③getConnectionの呼び出し（DBと接続する
		Connection con = db.getConnection();

		String sql = "insert into inquiry values(?,?,?)";

		//try.catchはjavaの例外処理のための構文
		try {

			//tryの中にはエラーが発生しそうな処理を書く
			//⑤PreparedStatement（DBまで運んでくれる箱のイメージ）に代入
			//定義したSQL文の1番目の?にActionから送られたname、
			//2番目の?にActionから送られたpasswordがそれぞれ入る
			PreparedStatement ps = con.prepareStatement(sql);

			//sql文の?に入れる値をsetする
			ps.setString(1, name);
			ps.setString(2, qtype);
			ps.setString(3, body);

			//⑦executeQuery()/executeUpdate()で実行
			//（select文の場合はexectuteQuery()を使う）
			// select文のSQL文を実行するメソッドで戻り値はResultSet
			int i = ps.executeUpdate();

			//もしiが０より大きい場合i件表示されましたと表示
			if (i > 0) {

				System.out.println(i + "件登録されました");

				ret = i;

			}

		//DB接続を終了する際、必ず書くメソッド
		//最後に実行されるものを指定するための構文
		//例外が発生しcatchされてもされなくても、共通してやってほしい処理や、やらなければいけない処理を書くところ。
		} catch (SQLException e) {
			e.printStackTrace();

		}

		//try.catchはjavaの例外処理のための構文
		try {

			//⑨con.close()で接続を切る
			//データベースとの接続をクローズ
			con.close();

		//DB接続を終了する際、必ず書くメソッド
		//最後に実行されるものを指定するための構文
		//例外が発生しcatchされてもされなくても、共通してやってほしい処理や、やらなければいけない処理を書くところ。
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//戻り値
		//処理結果を返す
		return ret;
	}

}
