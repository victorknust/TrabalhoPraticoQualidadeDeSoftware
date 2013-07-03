<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/default.css" />
		<script src="javascript/jQuery.js"></script>
		<script src="javascript/default.js"></script>
		<title>Calculo Peso Ideal</title>
	</head>
	<body>
		<div id="footer"><%@ include file="include/footer.jsp" %></div>
		<div id="body">
			<form action="calculoPesoIdeal" method="post" objeto="pesoIdeal">
				<fieldset>
					<legend>Cálculo TGC</legend>
					
					<label for="txtAltura">Altura</label><input type="text" id="txtAltura" />
					<label for="slSexo">Sexo</label>
					<select id="slSexo">
						<option value="M">Masculino</option>
						<option value="F">Feminino</option>
					</select>
					
					<input type="submit" id="btnSubmit" value="Calcular" />
				</fieldset>
				
				<fieldset id="resultado">
					<legend>Resultado</legend>
					<div></div>
				</fieldset>
			</form>
		</div>
		<div id="rodape"><%@ include file="include/rodape.jsp" %></div>
	</body>
</html>