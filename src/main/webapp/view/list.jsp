<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<style type="text/css">
.lclientes {
	text-align: center;
}
</style>
</head>
<body>
<div> <h1 class="lclientes"> Lista de Clientes </h1></div>
    <a href="ClienteController?app=cadastro">Cadastrar Cliente</a>
    <table border=1>
        <thead>
            <tr>
                
                <th>Nome do Cliente</th>
                <th>Endereço</th>
                <th>Fone</th>
                <th colspan=2>Ação</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${clientes}" var="cliente">
                <tr>
                    <td><c:out value="${cliente.nome}" /></td>
                    <td><c:out value="${cliente.endereco}" /></td>
                    <td><c:out value="${cliente.fone}" /></td>
                    <td><a href="ClienteController?app=excluir&clienteId=<c:out value="${cliente.id}"/>">Excluir</a></td>
                    <td><a href="ClienteController?app=update&clienteId=<c:out value="${cliente.id}"/>">Atualizar</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
	
</body>
</html>