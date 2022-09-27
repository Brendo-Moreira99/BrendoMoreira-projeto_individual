<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Alteração do Cliente ${cliente.nome}</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
	crossorigin="anonymous"></script>

</head>
<body>
	<div class="w-100 p-3 mb-2 text-warning bg-dark ">
		<h3>Alteração do Cliente</h3>
	</div>
	<div class="container ">

		<form action="editarcliente" method="post" class="form-control ">
			<h5 class="text-">Atualize os dados de ${cliente.nome}</h5>

			<input type="hidden" name="id_cliente" value="${cliente.id_Cliente}">
			<p>Nome:</p>
			<p>
				<input class="form-control mb-2" type="text" name="nome"
					value="${cliente.nome}">
			</p>
			<p>Telefone:</p>
			<p>
				<input class="form-control mb-2" type="tel" name="telefone"
					value="${cliente.telefone}">
			</p>
			<p>Rua:</p>
			<p>
				<input class="form-control mb-2" type="text" name="rua"
					value="${cliente.rua}">
			</p>
			<p>Estado:</p>
			<p>
				<input class="form-control mb-2" type="text" name="estado"
					value="${cliente.estado}">
			</p>

			<p>Municipio:</p>
			<p>
				<input class="form-control mb-2" type="text" name="municipio"
					value="${cliente.municipio}">
			</p>
			<p>CEP:</p>
			<p>
				<input class="form-control mb-2" type="text" name="cep"
					value="${cliente.cep}">
			</p>
			<p>CPF:</p>
			<p>
				<input class="form-control mb-2" type="text" name="cpf"
					value="${cliente.CPF}">
			</p>
			<p>Bairro:</p>
			<p>
				<input class="form-control mb-2" type="text" name="bairro"
					value="${cliente.bairro}">
			</p>
			<p>Numero:</p>
			<p>
				<input class="form-control mb-2" type="number" name="numero"
					value="${cliente.numero}">
			</p>
			<div class="d-flex justify-content-center">
				<button type="submit"
					class="btn btn-success d-grid gap-2 col-6 mx-auto">Atualizar</button>
			</div>

		</form>
	</div>
</body>
</html>