<html>
<head>
<link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css"
	rel="stylesheet" />
<title>Login</title>
</head>
<body>
	<div class="container">
		<h1>Login</h1>
		<form action="" method="POST">
			<p>
				Usuário: <input type="text" name="name" />
			</p>
			<p>
				Senha: <input type="password" name="password" />
			</p>
			<p>
				<input type="submit" value="Entrar">
			</p>
		</form>
		<pre>${errorMessage}</pre>
	</div>
	<script type="text/javascript"
		src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="webjars/jquery/3.7.1/jquery.min.js"></script>
</body>
</html>