<%@taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
<link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css"
	rel="stylesheet" />
<title>Lista de tarefas</title>
</head>
<body>
	<div class="container">
		<h3>Bem-vindo ${name}!</h3>
		<hr />
		<h1>Lista de tarefas</h1>

		<table class="table">
			<thead>
				<tr>
					<th>id</th>
					<th>Descrição</th>
					<th>Data Limite</th>
					<th>Concluído?</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.id}</td>
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="add-todo" class="btn btn-success">Adicionar tarefa</a>
	</div>
	<script type="text/javascript"
		src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="webjars/jquery/3.7.1/jquery.min.js"></script>

</body>
</html>