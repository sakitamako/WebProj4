package com.diworksdev.webproj4.action;

import java.util.ArrayList;
import java.util.List;

import com.diworksdev.webproj4.dao.InquiryCompleteDAO;
import com.diworksdev.webproj4.dto.InquiryDTO;
import com.opensymphony.xwork2.ActionSupport;

//Actionクラスでは、画面から送られてきたリクエストを取得する
//内部処理に応じてDAOやDTOクラスを呼び出し、最終的に次のJSPへ値を返すファイル

//struts2が持つActionSupportというクラスを継承
//（Actionクラスは基本的にこのクラスを継承）
//LoginAciton（子クラス） extends（継承） ActionSupport（親クラス）
//すでにあるクラスとにたクラスを作る場合、元のクラスに必要な機能だけを追加する形で、新しいクラスを作ることを継承
public class InquiryCompleteAction extends ActionSupport {

	//フィールド変数
	//JSPから受け取る値、ここではnameとpassword を定義
	//※必ずJSPでの定義と同じ名前にする
	private String name;
	private String qtype;
	private String body;

	//フィールド変数
	//ArrayList=public ArrayList() 初期容量10で空のリストを作成
	//java.util.List<LoginDTO>順序付けられたコレクション。シーケンスとも呼ばれる。
	//このインタフェースのユーザーは、リスト内のどこに各要素が挿入されるかを精密に制御できる。
	//ユーザーは整数値のインデックス(リスト内の位置)によって要素にアクセスしたり、リスト内の要素を検索したりできる
	private List<InquiryDTO> inquiryDTOList = new ArrayList<InquiryDTO>();

	//管理コマンド・メッセージをコマンド・サーバーに送信し、何らかの応答メッセージを待ちます
	public String execute() {

		//メソッドの戻り値「ret」 String ret = ERROR; を定義し、初期値としてERRORを代入
		String ret = ERROR;

		//②インスタンス化
		//DAOと会話するためのコード
		InquiryCompleteDAO dao = new InquiryCompleteDAO();

		//①クラス、メソッドの定義
		// HelloStrutsDTOはHelloStrutsDAOクラスのselectメソッドを呼び出す
		//JSPから送られてきたnameとpasswordを引数として、
		//LoginDAOクラスのselectメソッドを呼び出す
		//その後、DAOで取得した結果をLoginDTOに代入する
		int count = dao.insert(name, qtype, body);

		//もしcountが0より大きい場合ret=SUCCESS
		if (count > 0) {
			inquiryDTOList = dao.select();
			ret = SUCCESS;
		}

		//retに入った値を呼び出し元であるActionクラスに渡す
		return ret;

	}

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

	//フィールド変数に対応したgetterとsetterを定義
	//Actionクラスから呼び出され、inquiryDTOListフィールドの値をActionに渡す
	public List<InquiryDTO> getInquiryDTOList() {
		return inquiryDTOList;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のinquiryDTOListフィールドに格納
	public void setInquiryDTOList(List<InquiryDTO> inquiryDTOList) {
		this.inquiryDTOList = inquiryDTOList;

	}

}
