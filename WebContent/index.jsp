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
    <!-- "HelloStrutsAction"の部分はstruts.xmlファイルの一部分にアクションし,整理した情報を次のページで表示する -->
        <body>
        <s:form action="HelloStrutsAction">
            <s:submit value="HelloStruts"/>
        </s:form>
    </body>
</html>