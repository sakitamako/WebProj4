package com.diworksdev.webproj4.action;

import java.util.ArrayList;
import java.util.List;

import com.diworksdev.webproj4.dao.HelloStrutsDAO;
import com.diworksdev.webproj4.dto.HelloStrutsDTO;
import com.opensymphony.xwork2.ActionSupport;

//struts2が持つActionSupportというクラスを継承
//（Actionクラスは基本的にこのクラスを継承）
//LoginAciton（子クラス） extends（継承） ActionSupport（親クラス）
//すでにあるクラスとにたクラスを作る場合、元のクラスに必要な機能だけを追加する形で、新しいクラスを作ることを継承
public class HelloStrutsAction extends ActionSupport {

	private List<HelloStrutsDTO> HelloStrutsDTOList = new ArrayList<HelloStrutsDTO>();

	//メソッド名は「execute」
	//管理コマンド・メッセージをコマンド・サーバーに送信し、何らかの応答メッセージを待ちます
	public String execute() {
		String ret = ERROR;

		//②HelloStrutsDAOとHelloStrutsDTOのインスタンス化
		HelloStrutsDAO dao = new HelloStrutsDAO();

		//HelloStrutsDTOはHelloStrutsDAOクラスのselectメソッドを呼び出す
		HelloStrutsDTOList = dao.select();

		//もし下記の場合、ret=SUCCESS
		//そうでない場合、ERROR
		if (HelloStrutsDTOList.size() > 0) {

			ret = SUCCESS;

		} else {
			ret = ERROR;

		}

		//戻り値
		//処理結果を返す
		return ret;

	}

	//getterは値を引っ張ってくるメソッド
	//メソッド＝オブジェクトの操作を定義したもの
	public List<HelloStrutsDTO> getHelloStrutsDTOList() {
		return HelloStrutsDTOList;

	}

	//setterは値を代入するメソッド
	//メソッド＝オブジェクトの操作を定義したもの
	public void setHelloStrutsDTOList(List<HelloStrutsDTO> helloStrutsDTOList) {
		HelloStrutsDTOList = helloStrutsDTOList;

	}

}
