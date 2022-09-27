<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Alteração do Hotel ${diarias.nome_Hotel}</title>

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
		<h3>Alteração do Hotel</h3>
	</div>
	<div class="container ">

		<form action="editardiarias" method="post" class="form-control ">
			<h5 class="text-">Atualize os dados de ${diarias.nome_Hotel}</h5>

			<input type="hidden" name="id_hotel" value="${diarias.id_Hotel}">
			<p>Quantidade de dias:</p>
			<p>
				<input class="form-control mb-2" type="number" name="qtd_dias"
					value="${diarias.qtd_dias}">
			</p>

			<p>Rua:</p>
			<p>
				<input class="form-control mb-2" type="text" name="rua"
					value="${diarias.rua}">
			</p>
			<p>Numero do hotel:</p>
			<p>
				<input class="form-control mb-2" type="number" name="numero"
					value="${diarias.numero}">
			</p>
			<p>CEP:</p>
			<p>
				<input class="form-control mb-2" type="text" name="cep"
					value="${diarias.cep}">
			</p>
			<p>Municipio:</p>
			<p>
				<input class="form-control mb-2" type="text" name="municipio"
					value="${diarias.municipio}">
			</p>
			<p>Estado:</p>
			<p>
				<input class="form-control mb-2" type="text" name="estado"
					value="${diarias.estado}">
			</p>

			<p>Nome do Hotel:</p>
			<p>
				<input class="form-control mb-2" type="text" name="nome_hotel"
					value="${diarias.nome_Hotel}">
			</p>
			<p>Quantidade de quartos:</p>
			<p>
				<input class="form-control mb-2" type="number" name="qtd_quartos"
					value="${diarias.qtd_Quartos}">
			</p>

			<button type="submit"
				class="btn btn-success d-grid gap-2 col-6 mx-auto">Atualizar</button>
	</div>

	</form>
	</div>
</body>
</html>