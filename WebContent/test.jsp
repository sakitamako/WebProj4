<!-- このファイルが通常のHTMLファイルではなく、JSPであることを示している -->
<!-- strutsタグ（下の補足参照）を使用する際に記述します。ここでは”s”としてタグを使用 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="./css/style.css">
        <title>TEST</title>
    </head>
    <body>
    <!-- GETとPOST通信の欄を入力して送信ボタンを押すとstrutsファイルにアクションし処理結果を下記に表示する -->
        <br>
        <h1>以下の新規ユーザーが登録されました。</h1>
        <br>
        <table>
            <tbody>
                <tr>
                    <th>USERNAME</th>
                    <th>PASSWORD</th>
                </tr>
                <s:iterator value="loginDTOList">
                    <tr>
                        <td><s:property value="username"/></td>
                        <td><s:property value="password"/></td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
    </body>
</html>