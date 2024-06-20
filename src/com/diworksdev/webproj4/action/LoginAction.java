package com.diworksdev.webproj4.action;

import java.util.ArrayList;
import java.util.List;

import com.diworksdev.webproj4.dao.LoginDAO;
import com.diworksdev.webproj4.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

//Actionクラスでは、画面から送られてきたリクエストを取得する
//内部処理に応じてDAOやDTOクラスを呼び出し、最終的に次のJSPへ値を返すファイル

//struts2が持つActionSupportというクラスを継承
//（Actionクラスは基本的にこのクラスを継承）
//LoginAciton（子クラス） extends（継承） ActionSupport（親クラス）
//すでにあるクラスとにたクラスを作る場合、元のクラスに必要な機能だけを追加する形で、新しいクラスを作ることを継承
public class LoginAction extends ActionSupport {

	//フィールド変数
	//JSPから受け取る値、ここではnameとpassword を定義
	//※必ずJSPでの定義と同じ名前にする
	private String username;
	private String password;

	//ArrayList=public ArrayList() 初期容量10で空のリストを作成
	//java.util.List<LoginDTO>順序付けられたコレクション。シーケンスとも呼ばれる。
	//このインタフェースのユーザーは、リスト内のどこに各要素が挿入されるかを精密に制御できる。
	//ユーザーは整数値のインデックス(リスト内の位置)によって要素にアクセスしたり、リスト内の要素を検索したりできる
	private List<LoginDTO> LoginDTOList = new ArrayList<LoginDTO>();

	//メソッド名は「execute」
	//管理コマンド・メッセージをコマンド・サーバーに送信し、何らかの応答メッセージを待ちます
	public String execute() {

		//メソッドの戻り値「ret」 String ret = ERROR; を定義し、初期値としてERRORを代入
		String ret = ERROR;

		System.out.println(username);
		System.out.println(password);

		//②インスタンス化
		//DAOと会話するためのコード
		LoginDAO dao = new LoginDAO();

		//JSPから送られてきたnameとpasswordを引数として、
		//LoginDAOクラスのselectメソッドを呼び出す
		//その後、DAOで取得した結果をLoginDTOに代入する
		LoginDTOList = dao.select(username, password);

		//aとbが共にtrueの時に処理を実行するそうでない場合はエラー
		//「this を使う場所 は フィールド変数名の 頭!
		//また、this は クラス内のメソッドの定義の中でのみ使用できる
		//thisはメソッドが呼ばれた時に、そのメソッドを呼び出しているインスタンスに置き換えられる
		//フィールドを宣言するとき、「 public 」や「 private 」などの アクセス修飾子 を記述
		if (this.username.equals(LoginDTOList.get(0).getUsername()) && this.password.equals(LoginDTOList.get(0).getPassword())){

			ret = SUCCESS;

		} else {

			ret = ERROR;

		}

		//戻り値
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
	//Actionクラスから呼び出され、LoginDTOListフィールドの値をActionに渡す
	public List<LoginDTO> getLoginDTOList() {
		return LoginDTOList;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のLoginDTOListフィールドに格納
	public void setLoginDTOList(List<LoginDTO> loginDTOList) {
		LoginDTOList = loginDTOList;

	}

}
