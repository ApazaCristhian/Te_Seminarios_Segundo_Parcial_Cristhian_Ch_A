

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="es">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>Participantes</title>
    </head>

    <body>
        <div style="text-align: center" >
            
            <h3>PRIMER PARCIAL TEM-742</h3>
            <h3>Nombre: Cristhian Choquehuanca Apaza</h3>
            <h3>Carnet: 7099250</h3>

        </div>
        <br>
        <div class="container">
            <h1>REGISTRO PARTICIPANTES</h1>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="participante" />
            </jsp:include>
            <br>
            <a href="ParticipanteController?action=add" class="btn btn-primary btn-sn"><i class="fa-solid fa-circle-plus"></i>Nuevo</a>
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Nombre</th> 
                    <th>Apellido</th>
                    <th>Seminario</th>
                    <th>Confirmado</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="item" items="${participante}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.nombres}</td>
                        <td>${item.apellidos}</td>
                        <td>${item.titulo}</td>
                        
                        <td> <input type="checkbox" <c:if test="${item.confirmado==1}"> checked="true"</c:if>> </td>

                        <td><a href="ParticipanteController?action=edit&id=${item.id}"><i class="fa-solid fa-pen-to-square"></i></a></td>
                        <td><a href="ParticipanteController?action=delete&id=${item.id}" onclick="return(confirm('Estas seguro de eliminar'))"><i class="fa-solid fa-trash-can"></i></a></td>
                    </tr>
                </c:forEach>

            </table>
            
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    </body>
</html>
