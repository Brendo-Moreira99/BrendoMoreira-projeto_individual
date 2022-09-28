<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Voo cadastro</title>

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
	<nav class="navbar navbar-expand-lg navbar-light bg-light p-2">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Central do ADM</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item active"><a class="nav-link "
						href="Cliente.jsp">Cliente</a></li>
					<li class="nav-item"><a
						class="nav-link active bg-gradient text-warning bg-dark my-1 p-3 py-lg-1 py-md-1 "
						href="Voo.jsp">Voo</a></li>
					<li class="nav-item"><a class="nav-link" href="Pacote.jsp">Pacote</a></li>
					<li class="nav-item"><a class="nav-link "
						href="DiariasHotelaria.jsp">Hoteis</a></li>
				</ul>
			</div>
		</div>
		<a class="btn btn-success btn-sm float-right"
			href="./views/Pagina principal/Página inicial.html">Voltar para
			o site</a>

	</nav>

	<div class="w-100 p-3 mb-2 text-warning bg-dark "
		style="height: 100px;">
		<h3>Cadastro de Voo</h3>
	</div>
	<div class="container ">



		<form action="Inserirvoo" method="post" class="form-control">
			<fieldset>
				<legend>Dados do Voo</legend>

				<div class="row ">
					<div class="col-md-6 mb-2">
						<label for="nome">Local de Partida:</label> <input type="text"
							id="nome" name="local_partida" class="form-control" required>
					</div>

					<div class="col-md-6 mb-2">
						<label for="telefone">Quantidade de pessoas:</label> <input
							type="number" id="telefone" name="quantidade_pessoas"
							class="form-control" required>
					</div>
					<div class="col-md-6 mb-2">
						<label for="telefone">Data de ida:</label> <input type="text"
							id="telefone" name="data_ida" class="form-control" required>
					</div>
					<div class="col-md-6 mb-2">
						<label for="telefone">Data de volta:</label> <input type="text"
							id="telefone" name="data_volta" class="form-control" required>
					</div>


					<div class="col-md-6 mb-2">
						<label for="telefone">Destino:</label> <input type="text"
							id="telefone" name="destino_voo" class="form-control" required>
					</div>
					<div class="col-md-6 mb-2">
						<label for="telefone">Transfer:</label> <select name="transfer"
							id="" class="form-select">
							<option selected>Selecione</option>
							<option>In</option>
							<option>Out</option>
							<option>In/Out</option>
						</select>

					</div>
					<br>
					<div class="col-md-6 mb-2">
						<label for="telefone">Valor da viagem:</label> <input type="text"
							id="telefone" name="valor_viagem" class="form-control" required>
					</div>

				</div>
				<br>


				<button type="button" class="btn btn-primary" data-bs-toggle="modal"
					data-bs-target="#staticBackdrop">Cadastrar Viagem</button>

				<!-- Modal -->
				<div class="modal fade" id="staticBackdrop"
					data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
					aria-labelledby="staticBackdropLabel" aria-hidden="true">
					<div class="modal-dialog">

						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="staticBackdropLabel">Cadastro
									Realizado com Sucesso</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">O Voo já se encontra em nosso banco
								de dados</div>
							<div class="modal-footer">

								<input type="submit" value="Ok" class="btn btn-primary">
							</div>
						</div>
					</div>
				</div>

			</fieldset>
		</form>
		<br> <br> <br>
		<div class="container  table-responsive">
			<table
				class="table table-hover table-light table-striped text-center border">
				<thead>
					<tr class="success ">
						<th class="border" scope="col">Local de Partida</th>
						<th class="border" scope="col">Destino</th>
						<th class="border" scope="col">Quantidade de pessoas</th>
						<th class="border" scope="col">Data de volta</th>
						<th class="border" scope="col">Data de ida</th>
						<th class="border" scope="col">Transfer</th>
						<th class="border" scope="col">Valor da viagem</th>


						<th>Ações</th>
					</tr>
				</thead>
				<tbody>
					<jstl:forEach items="${listaVoos}" var="viagem">
						<tr>
							<td scope="row">${viagem.local_Partida}</td>
							<td class="border">${viagem.destino}</td>
							<td class="border">${viagem.quantidade_Pessoas}</td>
							<td class="border">${viagem.data_ida}</td>
							<td class="border">${viagem.data_volta}</td>
							<td class="border">${viagem.transfer}</td>
							<td class="border">${viagem.valor_viagem}</td>


							<td><a href="editarvoo?id_voo=${viagem.ID_Voo}"
								class="btn btn-success btn-md">Editar</a> <br> <br> <a
								href="excluirvoo?id_voo=${viagem.ID_Voo}"
								onclick="return confirm('Deseja Excluir?')"
								class="btn btn-danger btn-md">Excluir</a></td>

						</tr>
					</jstl:forEach>

				</tbody>
			</table>


		</div>


	</div>
</body>
</html>
