<%@taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
<link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css"
	rel="stylesheet" />
<title>Adicionar tarefas</title>
</head>
<body>
	<div class="container">
		<h3>Nova tarefa</h3>
		<hr />
		<h1>Detalhes da tarefa:</h1>
		
		<form action="" method="POST">
		
		Descri��o: <input type="text" name="description" required/>
		<input type="submit" value="Salvar" class="btn btn-success"/>
		</form>

	</div>
	<script type="text/javascript"
		src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="webjars/jquery/3.7.1/jquery.min.js"></script>

</body>
</html>