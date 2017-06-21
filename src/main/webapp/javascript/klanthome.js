$(document).ready(function() {
	$("#inzien").click(function() {
		window.location.assign("http://localhost:8081/firstapp/Afspraak_inzien.html");
	});
	$("#wijzigen").click(function() {
		window.location.assign("http://localhost:8081/firstapp/Afspraak_wijzigen.html");
	});
	$("#verwijderen").click(function(){
		window.location.assign("http://localhost:8081/firstapp/Afspraak_verwijderen.html");
	});
	$("#aanmaken").click(function() {
		window.location.assign("http://localhost:8081/firstapp/Afspraak_toevoegen.html");
	});
})