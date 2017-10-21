<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>請求書新規作成</title>
</head>
<body>
    <% request.setCharacterEncoding("UTF-8"); %>
    <h1>新規</h1>
    <form method="POST" action="">
        <input type="hidden" name="token" value="">
        請求書ID : <input type="text" readonly="readonly" name="invoiceId" value="" /> 
        <br /> 
        タイトル : <input type="text" name="title" value="" />
        <br /> 
        詳細 : <input type="text" name="detail" value="" /> 
        <br /> 
        請求金額 : <input type="text" name="totalFee" value="" /> 
        <br /> 
        <input type="submit" value="追加" /> 
    </form>
    <a href="ListAction">一覧へ戻る</a> 
</body>
</html>