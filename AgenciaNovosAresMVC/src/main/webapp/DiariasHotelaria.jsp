<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserir Diarias</title>

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

<nav class="navbar navbar-expand-lg navbar-light bg-light p-2">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Central do ADM</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item active"><a class="nav-link "
					href="Cliente.jsp">Cliente</a></li>
				<li class="nav-item"><a style="height: 30px" class="nav-link"
					href="Voo.jsp">Voo</a></li>
				<li class="nav-item"><a class="nav-link" href="Pacote.jsp">Pacote</a></li>
				<li class="nav-item"><a
					class="nav-link active bg-gradient text-warning bg-dark my-1 p-3 py-lg-1 py-md-1"
					href="DiariasHotelaria.jsp">Hoteis</a></li>
			</ul>
		</div>
	</div>
	<a class="btn btn-success btn-sm float-right"
		href="./views/Pagina principal/Página inicial.html">Voltar para o
		site</a>

</nav>

<div class="w-100 p-3 mb-2 text-warning bg-dark " style="height: 100px;">
	<h3>Cadastro de Hoteis</h3>
</div>

<div class="container ">



	<form action="Inserirdiarias" method="post" class="form-control">
		<fieldset>
			<legend>Dados de Hoteis</legend>

			<div class="row ">
				<div class="col-md-6 mb-2">
					<label for="nome">Quantidade de dias:</label> <input type="number"
						id="nome" name="qtd_dias" class="form-control" required>
				</div>

				<div class="col-md-6 mb-2">
					<label for="telefone">Rua:</label> <input type="text" id="telefone"
						name="rua" class="form-control" required>
				</div>
				<br>
				<div class="col-md-6 mb-2">
					<label for="telefone">Numero do Hotel:</label> <input type="number"
						id="telefone" name="numero" class="form-control" required>
				</div>
				<div class="col-md-6 mb-2">
					<label for="telefone">CEP:</label> <input type="text" id="telefone"
						name="cep" class="form-control" required>
				</div>
				<br>
				<div class="col-md-6 mb-2">
					<label for="telefone">Municipio:</label> <input type="text"
						id="telefone" name="municipio" class="form-control" required>
				</div>
				<div class="col-md-6 mb-2">
					<label for="telefone">Estado:</label> <input type="text"
						id="telefone" name="estado" class="form-control" required>
				</div>
				<br>
				<div class="col-md-6 mb-2">
					<label for="telefone">Nome do hotel:</label> <input type="text"
						id="telefone" name="nome_hotel" class="form-control" required>
				</div>
				<div class="col-md-6 mb-2">
					<label for="telefone">Quantidade de quartos:</label> <input
						type="number" id="telefone" name="qtd_quartos"
						class="form-control" required>

				</div>
			</div>



			<button type="button" class="btn btn-primary" data-bs-toggle="modal"
				data-bs-target="#staticBackdrop">Cadastrar Cliente</button>
			<a type="button" class="btn btn-success" href="listardiarias">Listar
				Tabela</a>
			<!-- Modal -->
			<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static"
				data-bs-keyboard="false" tabindex="-1"
				aria-labelledby="staticBackdropLabel" aria-hidden="true">
				<div class="modal-dialog">

					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="staticBackdropLabel">Cadastro
								Realizado com Sucesso</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">As diarias já se encontram em nosso
							banco de dados</div>
						<div class="modal-footer">

							<input type="submit" value="Ok" class="btn btn-primary">

						</div>
					</div>
				</div>
			</div>

		</fieldset>
	</form>
	<br> <br> <br>
	<div class="container table-responsive">
		<table
			class="table table-hover table-light table-striped text-center border">
			<thead>
				<tr class="success ">
					<th class="border" scope="col">Quantidade de dias</th>
					<th class="border" scope="col">Rua</th>
					<th class="border" scope="col">Numero</th>
					<th class="border" scope="col">CEP</th>
					<th class="border" scope="col">Municipio</th>
					<th class="border" scope="col">Estado</th>
					<th class="border" scope="col">Nome do hotel</th>
					<th class="border" scope="col">Quantidade de quartos</th>

					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<jstl:forEach items="${listaDiarias}" var="diarias">
					<tr>
						<td class="border" scope="row">${diarias.qtd_dias}</td>
						<td class="border">${diarias.rua}</td>
						<td class="border">${diarias.numero}</td>
						<td class="border">${diarias.cep}</td>
						<td class="border">${diaris.municipio}</td>
						<td class="border">${diarias.estado}</td>
						<td class="border">${diarias.nome_Hotel}</td>
						<td class="border">${diarias.qtd_Quartos}</td>


						<td><a href="editardiarias?id_hotel=${diarias.id_Hotel}"
							class="btn btn-success btn-md">Editar</a> <br> <br> <a
							href="excluirdiarias?id_hotel=${diarias.id_Hotel}"
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