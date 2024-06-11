<!-- このファイルが通常のHTMLファイルではなく、JSPであることを示している -->
<!-- strutsタグ（下の補足参照）を使用する際に記述します。ここでは”s”としてタグを使用 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>HelloStruts</title>
    </head>
    <body>
    <!-- strutsファイルのhelloStrutsDTOList部分がsuccessの場合に表示される -->
        <h1>HelloStruts2!</h1>
        <br>
        <table>
            <tbody>
                <tr>
                    <th>USERID</th>
                    <th>USERNAME</th>
                    <th>PASSWORD</th>
                    <th>RESULT</th>
                </tr>
                <s:iterator value="helloStrutsDTOList">
                    <tr>
                        <td><s:property value="userId"/></td>
                        <td><s:property value="userName"/></td>
                        <td><s:property value="password"/></td>
                        <td><s:property value="result"/></td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
    </body>
</html>