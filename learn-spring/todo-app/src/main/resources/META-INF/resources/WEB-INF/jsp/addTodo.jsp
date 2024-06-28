
<%@include file="common/header.jspf"%>
<div class="container">
	<h3>Nova tarefa</h3>
	<hr />
	<h1>Detalhes da tarefa:</h1>

	<form:form action="" method="POST" modelAttribute="todo">

		<fieldset class="mb-3">
			<form:label path="description">Descrição:</form:label>
			<form:input type="text" path="description" required="required" />
			<form:errors path="description" cssClass="text-warning" />
		</fieldset>

		<fieldset class="mb-3">
			<form:label path="targetDate">Data Limite:</form:label>
			<form:input type="text" path="targetDate" required="required" />
			<form:errors path="targetDate" cssClass="text-warning" />
		</fieldset>

		<form:input type="text" path="id" value="0" hidden="hidden" />
		<form:input type="text" path="done" value="false" hidden="hidden" />

		<input type="submit" value="Salvar" class="btn btn-success" />
		<a href="cancel-todo" class="btn btn-danger">Cancelar</a>

	</form:form>

</div>
<%@include file="common/footer.jspf"%>

<script type="text/javascript">
	$('#targetDate').datepicker({
		format : 'dd/mm/yyyy'
	});
</script>