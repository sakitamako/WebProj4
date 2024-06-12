<!-- このファイルが通常のHTMLファイルではなく、JSPであることを示している -->
<!-- strutsタグ（下の補足参照）を使用する際に記述します。ここでは”s”としてタグを使用 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="./css/style.css">
        <title>お問合せ受付完了</title>
    </head>
    <body>
        <table>
            <tbody>
            <!-- 登録ボタンを押した後の最後のページ -->
                <tr>
                    <th>名前</th>
                    <th>お問い合わせの種類</th>
                    <th>お問い合わせ内容</th>
                </tr>
                <s:iterator value="inquiryDTOList">
                    <tr>
                        <td>
                            <s:property value="name" />
                        </td>
                        <s:if test='qtype=="company"'>
                            <td>会社について</td>
                        </s:if>
                        <s:if test='qtype=="product"'>
                            <td>製品について</td>
                        </s:if>
                        <s:if test='qtype=="support"'>
                            <td>アフターサポートについて</td>
                        </s:if>
                        <td>
                            <s:property value="body" />
                        </td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
    </body>
</html>