$(document).ready(function() {
	$("#ainzien").click(function() {
		window.location.assign("http://localhost:8081/firstapp/Afspraak_inzien.html");
	});
	$("#awijzigen").click(function() {
		window.location.assign("http://localhost:8081/firstapp/Afspraak_wijzigen.html");
	});
	$("#averwijderen").click(function(){
		window.location.assign("http://localhost:8081/firstapp/Afspraak_verwijderen.html");
	});
	$("#aaanmaken").click(function() {
		window.location.assign("http://localhost:8081/firstapp/Afspraak_toevoegen.html");
	});
	$("#kinzien").click(function() {
		window.location.assign("http://localhost:8081/firstapp/Klant_inzien.html");
	});
	$("#kwijzigen").click(function() {
		window.location.assign("http://localhost:8081/firstapp/Klant_wijzigen.html");
	});
	$("#kverwijderen").click(function(){
		window.location.assign("http://localhost:8081/firstapp/Klant_verwijderen.html");
	});
	$("#kaanmaken").click(function() {
		window.location.assign("http://localhost:8081/firstapp/Klant_toevoegen.html");
	});
})