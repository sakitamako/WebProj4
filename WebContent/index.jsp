<!-- このファイルが通常のHTMLファイルではなく、JSPであることを示している -->
<!-- strutsタグ（下の補足参照）を使用する際に記述します。ここでは”s”としてタグを使用 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>INDEX</title>
    </head>
    <body>
    <!-- 実行した時のブラウザに表示されるサブミットの部分 -->
    <!-- "HelloStrutsAction"の部分はstruts.xmlファイルの一部分にアクションし,整理した情報を次のページで表示する -->
        <body>
        <s:form action="HelloStrutsAction">
            <s:submit value="HelloStruts"/>
        </s:form>

        <s:form action="WelcomeAction">
            <s:submit value="Welcome"/>
        </s:form>

        <s:form action="InquiryAction">
            <s:submit value="問い合わせ"/>
        </s:form>
        <br>
        <h3>新規ユーザー登録</h3>
        GET 通信
        <s:form method="get" action="TestAction">
            <s:textfield name="username"/>
            <s:password name="password"/>
            <s:submit value="送信"/>
        </s:form>
        POST 通信
        <s:form method="post" action="TestAction">
            <s:textfield name="username"/>
            <s:password name="password"/>
            <s:submit value="送信"/>
        </s:form>
    </body>
</html>