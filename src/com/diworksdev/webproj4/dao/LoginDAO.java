package com.diworksdev.webproj4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.diworksdev.webproj4.dto.LoginDTO;
import com.diworksdev.webproj4.util.DBConnector;

//DAOクラスでは、Actionから送られてきた情報を使ってDBへ問い合わせを行うファイル
//問い合わせて取得した値をDTOクラスに格納するファイル
public class LoginDAO {

	public String username;
	public String password;

	public List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();

	//①クラス、メソッドの定義
	//LoginDTO型を最後に呼び出し元に渡すので、LoginDTO型を戻り値にしたメソッドを作る
	//Actionクラスの値を引数として受け取る
	public List<LoginDTO> select(String username,String password) {

		//②DBConnectorのインスタンス化
		//DBへの接続準備、DBと会話するためのコード、これでログインできる
		//Connectionは特定のデータベースとの接続
		DBConnector db = new DBConnector();

		//③getConnectionの呼び出し（DBと接続する）
		Connection con = db.getConnection();

		//④sql文を書く：値は ? を入れておく（どんな値でも使いまわしできるようにするため）
		//SELECT データを抽出する
		//＊ テーブルに含まれる項目全て
		//FROM 〇〇 〇〇という名前のテーブルからデータを選択する
		//WHERE ＜条件＞抽出条件を指定
		//usersに入っているデータuser_name=? password = ?に入る条件を満たしたデータがsqlに代入される
		String sql = "select * from users where user_name=? and password=?";

		//try.catchはjavaの例外処理のための構文
		try {

			//tryの中にはエラーが発生しそうな処理を書く
			//⑤PreparedStatement（DBまで運んでくれる箱のイメージ）に代入
			//定義したSQL文の1番目の?にActionから送られたname、
			//2番目の?にActionから送られたpasswordがそれぞれ入る
			PreparedStatement ps = con.prepareStatement(sql);

			//⑥sql文の?に入れる値をsetする
			ps.setString(1, username);
			ps.setString(2, password);

			//⑦executeQuery()/executeUpdate()で実行
			//（select文の場合はexectuteQuery()を使う）
			// select文のSQL文を実行するメソッドで戻り値はResultSet
			ResultSet rs = ps.executeQuery();

			//ここでは2つのことをしている
			//下に1行ずらすこと
			//データが存在している限り表示する
			while (rs.next()) {

				//LoginDTOインスタンス化
				LoginDTO dto = new LoginDTO();

				//⑧結果の処理（select文で取得した値をDTOに格納）
				//select文でDBから取得した情報をString型に変換してDTOクラスに格納
				//LoginDTOクラスのsetName、setPassword（setter）を利用
				dto.setUsername(rs.getString("user_name"));
				dto.setPassword(rs.getString("password"));

				loginDTOList.add(dto);
			}

			//もしloginDTOList.size() が 0以下の場合、インスタンス化して該当なしと表示する
			if (loginDTOList.size() <= 0) {

				//インスタンス化
				LoginDTO dto = new LoginDTO();

				//⑧結果の処理（select文で取得した値をDTOに格納）
				//select文でDBから取得した情報をString型に変換してDTOクラスに格納
				//LoginDTOクラスのsetName、setPassword（setter）を利用
				dto.setUsername("該当なし");
				dto.setPassword("該当なし");

				loginDTOList.add(dto);
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

		//dtoに入った値を呼び出し元であるアクションクラスに渡す
		return loginDTOList;
	}

}
