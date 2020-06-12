<div class="modal fade" id="agregarClienteModal">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header bg-info text-white">
				<h5 class="modal-title">Agregar Cliente</h5>
				<button class="close" data-dismiss="modal">
					<span>&times;</span>
				</button>
			</div>
			<form action="${pageContext.request.contextPath}/ServletController?accion=insert" 
				method="post" class="was-validated">
				<input type="hidden" name="idCliente" value="${clientesTotal}" />
				<div class="modal-body">
					<div class="form-group">
						<label for="nombre">Nombre</label>
						<input type="text" class="form-control" name="name" required />
					</div>
					<div class="form-group">
						<label for="lastname">Apellidos</label>
						<input type="text" class="form-control" name="lastname" required />
					</div>
					<div class="form-group">
						<label for="balance">Saldo</label>
						<input type="number" class="form-control" name="balance" required step="any" />
					</div>					
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary" type="submit">Guardar</button>
				</div>
			</form>
		</div>
	</div>
</div>