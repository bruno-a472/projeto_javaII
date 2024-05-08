<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8" />
        <title>Editar Genero</title>
    </head>
    <body>
        <h1>Editar Genero</h1>
        <form action="/generos/update" method="post">
            <input type="hidden" name="id" value="${genero.getId()}" />
            <div>
                <label>Nome</label>
                <input type="text" name="nome" value="${genero.getNome()}"/>
            </div>
            <button type="submit">Salvar</button>
        </form>
    </body>
</html>