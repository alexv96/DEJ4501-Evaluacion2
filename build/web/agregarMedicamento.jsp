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


                <h2 class="texto-centrado">Ingresar Medicamento</h2>

                <form class="formulario" name="formularioMedicamento" id="formularioMedicamento" method="POST" action="agregarMedicamento"> <!--onsubmit="return validar_nombre()"-->
                    <div class="form-group row">
                        <label for="nombre" class="col-sm-2 col-form-label">Nombre:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="nombre" name="nombre"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="precio" class="col-sm-2 col-form-label">Precio:</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="precio" name="precio" min="0" onkeypress="return validarNumeros(event)"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="gramos" class="col-sm-2 col-form-label">Gramos:</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="gramos" name="gramos" min="0" onkeypress="return validarNumeros(event)"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="laboratorio" class="col-sm-2 col-form-label">Laboratorio:</label>
                        <div class="col-sm-10">
                            <select name="laboratorio" id="laboratorio" class="form-control">
                                <option disabled selected>Seleccione Laboratorio</option>
                                <c:forEach var="l" items="${laboratorios}">
                                    <option value="${l.getId()}">${l.getNombre()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-sm-12">
                        <input type="submit" class="btn btn-primary btn-block" name="accion" id="accion" value="Grabar" />
                    </div>
                </form>
            </main>
        </div>

        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

        <!-- Bootstrap Validation -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.5.3/js/bootstrapValidator.js"></script>


        <script src="js/validarFormulario.js" type="text/javascript"></script>


    </body>
</html>