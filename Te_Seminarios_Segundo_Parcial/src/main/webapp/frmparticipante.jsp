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

        <title>Punto de participante</title>
    </head>

    <body>
        
        <jsp:include page="WEB-INF/menu.jsp">
            <jsp:param name="opcion" value="participantes" />
        </jsp:include>
        <div class="container">
            <h1>Formulario de participantes</h1>

            <br>
            <form action="ParticipanteController" method="post">
                <input type="hidden" name="id" value="${participante.id}"/>
                <div class="mb-3">
                    <label for="" class="form-label">Nombres</label>
                    <input type="text" class="form-control" name="nombres" value="${participante.nombres}" placeholder="Escriba su nombre">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Apellidos</label>
                    <input type="text" class="form-control" name="apellidos" value="${participante.apellidos}" placeholder="Escriba su apellido">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Seminario</label>

                    <select name="id_seminario" class="form-control">

                        <option value="">--Seleccione--</option>
                        <c:forEach var="item" items="${lista_seminarios}">
                            <option value="${item.id}"
                                    <c:if test="${participante.id_seminario == item.id}">
                                        selected
                                    </c:if>
                                    >${item.titulo}</option>
                        </c:forEach>
                    </select>
                </div>
                <br>
                <div class="mb-3">
                    <label for="" class="form-label">Confirmado</label>
                    
                    <input type="checkbox" name="confirmado" value="1" placeholder="Confirme">

                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    </body>

</html>
