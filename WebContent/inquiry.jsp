<!-- このファイルが通常のHTMLファイルではなく、JSPであることを示している -->
<!-- strutsタグ（下の補足参照）を使用する際に記述します。ここでは”s”としてタグを使用 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>お問合せフォーム</title>
    </head>
    <body>
    <!-- index.jspファイルのボタン押した次のページ -->
    <!-- 入力項目を入れて登録ボタンを押すとstrutsファイルにアクションし処理結果を次のページで表示する -->
        <s:form method="post" action="InquiryCompleteAction">
            名前:
            <input type="text" name="name"/><br>
            お問い合わせの種類:
            <br>
            <select name="qtype" >
                <option value="company">会社について</option>
                <option value="product">製品について</option>
                <option value="support">アフターサポートについて</option>
            </select>
            <br>
            お問い合わせ内容:
            <s:textarea name="body"/>
            <br>
            <s:submit value="登録"/>
        </s:form>
    </body>
</html>