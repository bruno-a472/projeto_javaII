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
        <!-- <a href="/livros/insert">Novo Gêrnero</a> -->
        <table>
            <tr>
                <th>Id</th>
                <th>Nomes</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach var="l" items="${generos}">
                <tr>
                    <td>${l.getId()}</td>
                    <td>${l.getNome()}</td>
                    <td>
                        <a href="/generos/update/${l.getId()}">Editar</a>
                        <a href="/generos/delete/${l.getId()}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>