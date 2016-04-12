$(document).ready(function() {
$("#sourceNbId").blur(function() {
	$.ajax({
		url : 'ClimatisationAjax',
		type : 'GET',
		dataType : 'text',
		success : function(texte) {
			$("#nbId").html(texte);
		}
	});

});
});
