<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Alteração do Voo
	${viagem.destino}/${viagem.local_Partida}</title>

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
		<h3>Alteração de Viagens</h3>
	</div>
	<div class="container ">

		<form action="editarvoo" method="post" class="form-control ">
			<h5>Atualize os dados da viagem
				${viagem.destino}/${viagem.local_Partida}</h5>

			<input type="hidden" name="id_voo" value="${viagem.ID_Voo}">
			<p>Local Partida:</p>
			<p>
				<input class="form-control mb-2" type="text" name="local_partida"
					value="${viagem.local_Partida}">
			</p>
			<p>Destino:</p>
			<p>
				<input class="form-control mb-2" type="text" name="destino"
					value="${viagem.destino}">
			</p>
			<p>Quantidade de pessoas:</p>
			<p>
				<input class="form-control mb-2" type="number"
					name="quantidade_pessoas" value="${viagem.quantidade_Pessoas}">
			</p>
			<p>Data de volta:</p>
			<p>
				<input class="form-control mb-2" type="text" name="data_volta"
					value="${viagem.data_volta}">
			</p>

			<p>Data de ida:</p>
			<p>
				<input class="form-control mb-2" type="text" name="data_ida"
					value="${viagem.data_ida}">
			</p>
			<!-- 			<p>Transfer:</p> -->
			<!-- 			<p> -->
			<%-- 				<input class="form-control mb-2" type="text" name="transfer" value="${viagem.transfer}"> --%>
			<!-- 			</p> -->

			<p>
				<select id="transfer" name="transfer" value="${viagem.transfer}"
					class="form-select">
					<option>In</option>
					<option>Out</option>
					<option>In/Out</option>
				</select>
			</p>
			<p>Valor do Voo:</p>
			<p>
				<input class="form-control mb-2" type="number" name="valor_viagem"
					value="${viagem.valor_viagem}">
			</p>

			<div class="d-flex justify-content-center">
				<button type="submit"
					class="btn btn-success d-grid gap-2 col-6 mx-auto">Atualizar</button>
			</div>

		</form>
	</div>
</body>
</html>