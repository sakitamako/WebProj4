package com.diworksdev.webproj4.action;

import java.util.ArrayList;
import java.util.List;

import com.diworksdev.webproj4.dao.HelloStrutsDAO;
import com.diworksdev.webproj4.dto.HelloStrutsDTO;
import com.opensymphony.xwork2.ActionSupport;

//Actionクラスでは、画面から送られてきたリクエストを取得する
//内部処理に応じてDAOやDTOクラスを呼び出し、最終的に次のJSPへ値を返すファイル

//struts2が持つActionSupportというクラスを継承
//（Actionクラスは基本的にこのクラスを継承）
//LoginAciton（子クラス） extends（継承） ActionSupport（親クラス）
//すでにあるクラスとにたクラスを作る場合、元のクラスに必要な機能だけを追加する形で、新しいクラスを作ることを継承
public class HelloStrutsAction extends ActionSupport {

	//フィールド変数
	//JSPから受け取る値
	//※必ずJSPでの定義と同じ名前にする
	private List<HelloStrutsDTO> HelloStrutsDTOList = new ArrayList<HelloStrutsDTO>();

	//メソッド名は「execute」
	//管理コマンド・メッセージをコマンド・サーバーに送信し、何らかの応答メッセージを待ちます
	public String execute() {

		//メソッドの戻り値「ret」 String ret = ERROR; を定義し、初期値としてERRORを代入
		String ret = ERROR;

		//②インスタンス化
		//DAOと会話するためのコード
		HelloStrutsDAO dao = new HelloStrutsDAO();

		// HelloStrutsDTOはHelloStrutsDAOクラスのselectメソッドを呼び出す
		//JSPから送られてきたnameとpasswordを引数として、
		//LoginDAOクラスのselectメソッドを呼び出す
		//その後、DAOで取得した結果をLoginDTOに代入する
		HelloStrutsDTOList = dao.select();

		//もし下記の場合、ret=SUCCESS
		//そうでない場合、ERROR
		if (HelloStrutsDTOList.size() > 0) {

			ret = SUCCESS;

		} else {
			ret = ERROR;

		}

		//retに入った値を呼び出し元であるActionクラスに渡す
		return ret;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//Actionクラスから呼び出され、HelloStrutsDTOListフィールドの値をActionに渡す
	public List<HelloStrutsDTO> getHelloStrutsDTOList() {
		return HelloStrutsDTOList;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のDTO HelloStrutsDTOListフィールドに格納
	public void setHelloStrutsDTOList(List<HelloStrutsDTO> helloStrutsDTOList) {
		HelloStrutsDTOList = helloStrutsDTOList;

	}

}
