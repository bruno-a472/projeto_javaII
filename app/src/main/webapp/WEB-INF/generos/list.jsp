<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8" />
        <title>Gêneros</title>
    </head>
    <body>
        <h1>Gêneros</h1>
        <a href="/livros/insert">Novo Livro</a>
        <a href="/generos/insert">Novo Genero</a>
        <!-- <a href="/livros/insert">Novo Gêrnero</a> -->
        <table>
            <tr>
                <th>Id</th>
                <th>Nomes</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach var="g" items="${generos}">
                <tr>
                    <td>${g.getId()}</td>
                    <td>${g.getNome()}</td>
                    <td>
                        <a href="/generos/update/${g.getId()}">Editar</a>
                        <a href="/generos/delete/${g.getId()}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="/livros/list">Lista de Livros</a>
        <a href="/generos/list">Lista de Gêneros</a>
    </body>
</html>