<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Alteração do Pacote com destino ${pacote.destino}</title>

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
		<h3>Alteração de Pacotes</h3>
	</div>

	<div class="container ">

		<form action="editarpacote" method="post" class="form-control ">

			<h5 class="text-">Atualize o pacote ${pacote.destino}</h5>

			<input type="hidden" name="id_itens" value="${pacote.id_itens}">
			<p>Id do hotel:</p>
			<p>
				<input class="form-control mb-2" type="number" name="id_hotel"
					value="${pacote.getHotelaria().id_Hotel}">
			</p>

			<p>Quantidade pessoas:</p>
			<p>
				<input class="form-control mb-2" type="number"
					name="quantidade_pessoas" value="${pacote.quantidade_Pessoas}">
			</p>
			<p>Valor do pacote:</p>
			<p>
				<input class="form-control mb-2" type="number" name="valor_pacote"
					value="${pacote.valor_Pacote}">
			</p>
			<p>Data de volta do pacote:</p>
			<p>
				<input class="form-control mb-2" type="text" name="data_volta"
					value="${pacote.pacote_volta}">
			</p>
			<p>Data de ida do pacote:</p>
			<p>
				<input class="form-control mb-2" type="text" name="data_ida"
					value="${pacote.pacote_ida}">
			</p>
			<p>Destino:</p>
			<p>
				<input class="form-control mb-2" type="text" name="destino"
					value="${pacote.destino}">
			</p>
			<p>Transfer do pacote:</p>
			<!-- 			<p> -->
			<!-- 				<input class="form-control mb-2" type="text" name="transfer" -->
			<%-- 					value="${pacote.transfer_pacote}"> --%>
			<!-- 			</p> -->
			<label for="telefone">Transfer:</label> <select name="transfer" id=""
				value="${pacote.transfer_pacote}" class="form-select">
				<option>In</option>
				<option>Out</option>
				<option>In/Out</option>
			</select> <br>
			<button type="submit"
				class="btn btn-success d-grid gap-2 col-6 mx-auto">Atualizar</button>
		</form>
	</div>


</body>
</html>