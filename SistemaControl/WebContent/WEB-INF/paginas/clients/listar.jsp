<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_PE" />

<section id="clientes">
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<div class="card">
					<div class="card-header">
						<h4>Listado de Clientes</h4>
					</div>
					<table class="table table-striped">
						<thead class="thead-dark">
							<tr>
								<th>#</th>
								<th>Nombre</th>
								<th>Saldo</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							
							<!-- iteramos los elementos de la lista -->
							<c:forEach var="cliente" items="${ clientes }" > <!-- varStatus="status" -->
							<tr>
								<td>${cliente.id}</td> <!-- ${status.count} ESTO mostrará el num item del registro-->
								<td>${cliente.name} ${cliente.lastname}</td>
								<td><fmt:formatNumber value="${cliente.balance}" type="currency" /></td>
								<td>
									<a href="${pageContext.request.contextPath}/ServletController?accion=edit&id=${cliente.id}"
									class="btn btn-secondary">
										<i class="fas fa-angle-double-right"></i> Editar
									</a>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<!-- Inicio tarjeta para los totales -->
			<div class="col-md-3">
				<div class="card text-center bg-danger text-white mb-3">
					<div class="card-body">
						<h3>Saldo total</h3>
						<h4 class="display-4">
							<fmt:formatNumber value="${saldoTotal}" type="currency"/>
						</h4>
					</div>
				</div>
				<div class="card text-center bg-success text-white mb-3">
					<div class="card-body">
						<h3>Total Clientes</h3>
						<h4 class="display-4">
							<i class="fas fa-users"></i> ${clientesTotal}
						</h4>
					</div>
				</div>
			</div>
			
		</div>
	</div>
</section>

<!-- Agregar cliente MODAL -->
<jsp:include page="/WEB-INF/paginas/clients/insert.jsp"></jsp:include>

