package com.diworksdev.webproj4.action;

import java.util.ArrayList;
import java.util.List;

import com.diworksdev.webproj4.dao.TestDAO;
import com.diworksdev.webproj4.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

//Actionクラスでは、画面から送られてきたリクエストを取得する
//内部処理に応じてDAOやDTOクラスを呼び出し、最終的に次のJSPへ値を返すファイル

//struts2が持つActionSupportというクラスを継承
//（Actionクラスは基本的にこのクラスを継承）
//LoginAciton（子クラス） extends（継承） ActionSupport（親クラス）
//すでにあるクラスとにたクラスを作る場合、元のクラスに必要な機能だけを追加する形で、新しいクラスを作ることを継承
public class TestAction extends ActionSupport {

	//フィールド変数
	//JSPから受け取る値、ここではnameとpassword を定義
	//※必ずJSPでの定義と同じ名前にする
	private String username;
	private String password;

	//フィールド変数
	//JSPから受け取る値
	//※必ずJSPでの定義と同じ名前にする
	private List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();

	//管理コマンド・メッセージをコマンド・サーバーに送信し、何らかの応答メッセージを待ちます
	public String execute() {

		//メソッドの戻り値「ret」 String ret = ERROR; を定義し、初期値としてERRORを代入
		String ret = ERROR;

		//②インスタンス化
		//DAOと会話するためのコード
		TestDAO dao = new TestDAO();

		//①クラス、メソッドの定義
		// HelloStrutsDTOはHelloStrutsDAOクラスのselectメソッドを呼び出す
		//JSPから送られてきたnameとpasswordを引数として、
		//LoginDAOクラスのselectメソッドを呼び出す
		//その後、DAOで取得した結果をLoginDTOに代入する
		int count = dao.insert(username, password);

		//もしcountが0より大きい場合ret=SUCCESS
		if (count > 0) {

			ret = SUCCESS;

		//そうでない場合ERROR
		} else {

			ret = ERROR;

		}

		//JSPから送られてきたnameとpasswordを引数として、
		//LoginDAOクラスのselectメソッドを呼び出す
		//その後、DAOで取得した結果をLoginDTOに代入する
		loginDTOList = dao.select(username, password);

		//retに入った値を呼び出し元であるActionクラスに渡す
		return ret;

	}


	//フィールド変数に対応したgetterとsetterを定義
	//Actionクラスから呼び出され、usernameフィールドの値をActionに渡す
	public String getUsername() {
		return username;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のusernameフィールドに格納
	public void setUsername(String username) {
		this.username = username;

	}


	//フィールド変数に対応したgetterとsetterを定義
	//Actionクラスから呼び出され、passwordフィールドの値をActionに渡す
	public String getPassword() {
		return password;

	}
	//フィールド変数に対応したgetterとsetterを定義
	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のpasswordフィールドに格納
	public void setPassword(String password) {
		this.password = password;

	}


	//フィールド変数に対応したgetterとsetterを定義
	//Actionクラスから呼び出され、 loginDTOListフィールドの値をActionに渡す
	public List<LoginDTO> getLoginDTOList() {
		return loginDTOList;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身の loginDTOListフィールドに格納
	public void setLoginDTOList(List<LoginDTO> loginDTOList) {
		this.loginDTOList = loginDTOList;

	}

}
