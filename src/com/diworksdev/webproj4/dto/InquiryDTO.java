package com.diworksdev.webproj4.dto;

public class InquiryDTO {

	//テーブルから取得するデータに対応したフィールド変数を宣言
	private String name;
	private String qtype;
	private String body;

	//フィールド変数に対応したgetterとsetterを定義
	//Actionクラスから呼び出され、nameフィールドの値をActionに渡す
	public String getName() {
		return name;
	}

	//フィールド変数に対応したgetterとsetterを定義
	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のnameフィールドに格納
	public void setName(String name) {
		this.name = name;
	}

	//フィールド変数に対応したgetterとsetterを定義
	//Actionクラスから呼び出され、qtypeフィールドの値をActionに渡す
	public String getQtype() {
		return qtype;
	}

	//フィールド変数に対応したgetterとsetterを定義
	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のqtypeフィールドに格納
	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	//フィールド変数に対応したgetterとsetterを定義
	//Actionクラスから呼び出され、bodyフィールドの値をActionに渡す
	public String getBody() {
		return body;
	}

	//フィールド変数に対応したgetterとsetterを定義
	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のbodyフィールドに格納
	public void setBody(String body) {
		this.body = body;

	}

}
