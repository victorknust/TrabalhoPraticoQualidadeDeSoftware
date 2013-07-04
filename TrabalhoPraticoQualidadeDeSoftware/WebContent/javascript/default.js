/* Functions ============================================ */

function ajaxSubmitForm(formElement) {
	var form = $(formElement);
	var url = $(formElement).attr("action");
	var httpMethod = $(formElement).attr("method").toUpperCase();
	var parameters = getValuesFieldsForm(formElement);
	
	return executeAjaxRequest(url, httpMethod, parameters);
}

function getValuesFieldsForm(formElement) {
	var form = $(formElement);
	var dataForm = {};
	
	form.find("input[type='text'], select").each(function(k, elementChild) {
		var jqElement = $(elementChild);
		dataForm[jqElement.attr("id")] = jqElement.val();
	});
	
	return dataForm;
}

function executeAjaxRequest(url, httpMethod, parameters) {
	var data = {};
	
	$.ajax({
		"url": url,
		"type": httpMethod,
		"async": false,
		"data": parameters,
		"dataType": "json"
	})
	.done(function(response) {
		data = response;
	})
	.fail(function(jqXHR, textStatus, error) {
		console.log(jqXHR);
		console.log(textStatus);
		console.log(error);
		
		alert("Ocorreu um erro durante a requisição, verifique o console para mais detalhes!");
	});
	
	return data;
}

function calculeIMC(dataRequest) {
	var result = $("<div>").addClass("divResult").html(
		  "Altura: " + dataRequest.pessoa.altura
		+ "<br />"
		+ "Peso: " + dataRequest.pessoa.peso
		+ "<br />"
		+ "Sexo: " + dataRequest.pessoa.sexo
		+ "<br />"
		+ "IMC: " + dataRequest.imc
		+ "<br />"
		+ "Situação IMC: " + dataRequest.situacaoIMG);
	
	appendResultCalc(result);
}

function calculeTGC(dataRequest) {
	var result = $("<div>").addClass("divResult").html(
		  "Altura: " + dataRequest.pessoa.altura
		+ "<br />"
		+ "Peso: " + dataRequest.pessoa.peso
		+ "<br />"
		+ "Sexo: " + dataRequest.pessoa.sexo
		+ "<br />"
		+ "Idade: " + dataRequest.pessoa.idade
		+ "<br />"
		+ "TGC: " + dataRequest.tgc
		+ "<br />"
		+ "Situação TGC: " + dataRequest.situacaoTGC);
	
	appendResultCalc(result);
}

function calculePesoIdeal(dataRequest) {
	var result = $("<div>").addClass("divResult").html(
		  "Altura: " + dataRequest.altura
		+ "<br />"
		+ "Sexo: " + dataRequest.pessoa.sexo
		+ "<br />"
		+ "Peso Ideal: " + dataRequest.pesoIdeal);
	
	appendResultCalc(result);
}

function appendResultCalc(result) {
	$("#resultado > div").append(result);
}

/* Events =============================================== */

$(function() {
	
	$("form").submit(function() {
		var dataRequest = ajaxSubmitForm(this);
		var objectType = $(this).attr("objeto");
		
		if(objectType == "imc") {
			calculeIMC(dataRequest);
		}
		else if(objectType == "tgc") {
			calculeTGC(dataRequest);
		}
		else if(objectType == "pesoIdeal") {
			calculePesoIdeal(dataRequest);
		}
		else {
			alert("Objeto desconhecido!");
		}
		
		return false;
	});
});