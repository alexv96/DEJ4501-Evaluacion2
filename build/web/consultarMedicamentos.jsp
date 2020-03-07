<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Farmacia Cruz Negra</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" href="css/estiloPersonalizado.css"/>
        <script src="https://kit.fontawesome.com/837ecb9d5c.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <jsp:include page="header/menu.jsp"></jsp:include>
            <div class="container">
                <main class="contenido-principal">
                <c:if test="${!empty mensaje}">
                    <div class="alert alert-success alert-dismissible fade show" role="alert">
                        ${mensaje}
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:if>
                <c:if test="${!empty err}">
                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
                        ${err}
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:if>

                <h2 class="texto-centrado">Consultar Medicamentos</h2>

                <form method="POST" action="medicamentos">
                    <div class="form-group row">
                        <label for="buscar" class="col-sm-4 col-form-label">Seleccione el Laboratorio:</label>

                        <div class="col-sm-6">
                            <select name="laboratorio" class="form-control">
                                <option disabled selected>Buscar</option>
                                <c:forEach var="l" items="${laboratorios}">
                                    <option value="${l.getId()}">${l.getNombre()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <input type="submit" value="Buscar" name="btnAccion" class="col-sm-2 btn btn-info"/>
                    </div>
                </form>


                <table class="table table-stripped">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Precio</th>
                            <th>Gramos</th>
                            <th>Laboratorio</th>
                            <th>Accion</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${medicamentos}" var="m">   
                            <tr>
                                <td>${m.getNombre()}</td>
                                <td>$${m.getPrecio()}</td>
                                <td>${m.getGramos()}</td>
                                <td>${m.laboratorioID.getNombre()}</td>
                                <td>
                                    <form method="POST" action="medicamentos">
                                        <input type="hidden" name="id" value="${m.getIdMedicamento()}">
                                        <input type="submit" name="btnAccion" value="Eliminar" class="btn btn-danger"/>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </main>
        </div>

        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
