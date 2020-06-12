<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<!-- Required meta tags -->
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	    <!-- Bootstrap CSS -->
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
	    	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
		<script src="https://kit.fontawesome.com/f90d3bf50d.js" crossorigin="anonymous"></script>
		<title>Editar Clientes</title>
	</head>
	<body>
		<!-- agregando la cabecera común para todas las páginas -->
		<jsp:include page="/WEB-INF/paginas/commons/header.jsp"></jsp:include>
		
		<form action="${pageContext.request.contextPath}/ServletController?accion=edit" 
				method="post" class="was-validated">
			<!-- agregando botones de navegación -->
			<jsp:include page="/WEB-INF/paginas/commons/botonesNavEdicion.jsp"></jsp:include>
		
			<section class="details">
				<div class="container">
					<div class="row">
						<div class="col" >
							<div class="card" >
								<div class="card-header" >
									<h4>Editar Cliente</h4>
								</div>
								<div class="card-body">									
									<input type="hidden" name="idCliente" value="${cliente.id}" />
									<div class="form-group">
										<label for="nombre">Nombre</label>
										<input type="text" class="form-control" name="name" value="${cliente.name}" required />
									</div>
									<div class="form-group">
										<label for="lastname">Apellidos</label>
										<input type="text" class="form-control" name="lastname" value="${cliente.lastname}" required />
									</div>
									<div class="form-group">
										<label for="balance">Saldo</label>
										<input type="number" class="form-control" name="balance" value="${cliente.balance}" required step="any" />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</form>
		
		<!-- agregando pie página común para todas las páginas -->
		<jsp:include page="/WEB-INF/paginas/commons/footer.jsp"></jsp:include>
		
    	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
    	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" 
    			crossorigin="anonymous"></script>
    	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" 
    		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" 
    		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
	</body>
</html>