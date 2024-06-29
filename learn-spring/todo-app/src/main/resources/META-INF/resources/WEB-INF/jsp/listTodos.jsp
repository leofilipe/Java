

<%@include file="common/header.jspf"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">
	<h3>Bem-vindo ${name}!</h3>
	<hr />
	<h1>Lista de tarefas</h1>

	<table class="table">
		<thead>
			<tr>
				<!-- <th>id</th> -->
				<th>Descrição</th>
				<th>Data Limite</th>
				<th>Concluído?</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<!-- <td>${todo.id}</td> -->
					<td>${todo.description}</td>
					<!-- -<td>${todo.targetDate}</td> change in the properties file is not working for the list-->
					<td><fmt:parseDate value="${todo.targetDate}"
							pattern="yyyy-MM-dd" var="targetDate" type="date"></fmt:parseDate>
						<fmt:formatDate value="${targetDate}" pattern="dd/MM/yyyy" /></td>
					<td>${todo.done}</td>
					<td><a href="update-todo?id=${todo.id}"
						class="btn btn-primary">Editar</a></td>
					<td><a href="delete-todo?id=${todo.id}" class="btn btn-danger">Remover</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="add-todo" class="btn btn-success">Adicionar tarefa</a>
</div>
<%@include file="common/footer.jspf"%>
