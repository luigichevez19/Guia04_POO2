<%@page import="java.util.List"%>
<%@page import="comv.sv.udb.controladores.CtrlTipos"%>
<%@page import="com.sv.udb.modelos.Tipos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
        <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <h4>Guía 04 - POO2</h4>
                    <form method="POST" action="TipoServ">
                        <input type="hidden" id="codi" name="codi" />
                        <div class="form-group">
                            <label for="nomb" class="contro-label">Nombre:</label>
                            <div class="input-group">
                                <span class="input-group-addon"> 1 </span>
                                <input class="form-control" id="nomb" name="nomb" />
                            </div>
                        </div>
                        <input type="submit" name="TipoBton" value="Guardar" class="btn btn-sm btn-success" />
                    </form>
                </div>
            </div>
            <table class="table">
	<thead>
		<tr>
			<th>No.</th>
			<th>Nombre</th>
		</tr>
	</thead>
	<tbody>
           
            <%
               List<Tipos> test = new CtrlTipos().cons();
               for (Tipos temp: test)
                {%>
		<tr>
			<td scope="row"><%=temp.getCodiTipo()%></td>
                        <td><%=temp.getNombTipo()%></td>
                </tr>
                <%}
                %>
		
	</tbody>
</table>
        </div>
    </body>
</html>
