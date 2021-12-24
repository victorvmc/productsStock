<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Criar</title>
<style type="text/css">
	label {
	width: 80px;float: left;
}
</style>
</head>
<body>

<h1>Cadastro de Produtos</h1>
<form name="create" action="ProductController" method="post">
                    <input type="hidden" name="id" value="${product.id}"><br>
<label>Name:</label><input type="text" name="name" value="${product.name}"><br>
<label>Category:</label><input type="text" name="category" value="${product.category}"><br>
<label>Amount:</label><input type="text" name="amount" value="${product.amount}"><br>
<label>&nbsp;</label><input type=submit  name="btCadastro" value="${not empty product ? "Atualizar" : "Cadastrar"}">
</form>
</body>
</html>