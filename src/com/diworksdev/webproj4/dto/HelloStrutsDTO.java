package com.diworksdev.webproj4.dto;

//DTOクラスは、DAOがDBから取得した値をActionへ戻す時、値を格納するのに利用されるファイル
public class HelloStrutsDTO {

	//テーブルから取得するデータに対応したフィールド変数を宣言
	private int userId;
	private String userName;
	private String password;
	private String result;

	//フィールド変数に対応したgetterとsetterを定義
	//Actionクラスから呼び出され、userIdフィールドの値をActionに渡す
	public int getUserId() {
		return userId;

	}

	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserIdフィールドに格納
	public void setUserId(int userId) {
		this.userId = userId;

	}

	//Actionクラスから呼び出され、userNameフィールドの値をActionに渡す
	public String getUserName() {
		return userName;

	}

	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserNameフィールドに格納
	public void setUserName(String userName) {
		this.userName = userName;

	}

	//Actionクラスから呼び出され、passwordフィールドの値をActionに渡す
	public String getPassword() {
		return password;

	}

	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のpasswordフィールドに格納
	public void setPassword(String password) {
		this.password = password;

	}

	//Actionクラスから呼び出され、resultフィールドの値をActionに渡す
	public String getResult() {
		return result;

	}

	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のresultフィールドに格納
	public void setResult(String result) {
		this.result = result;

	}

}
