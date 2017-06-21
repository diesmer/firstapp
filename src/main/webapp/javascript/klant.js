var value;
$(document).ready(
		function info() {
			$.get("restservices/user", function(data, status) {
				for ( var key in data) {
					var value = data[key];
					var id = value.id;
					console.log("lukt");
					console.log(value.id);
					var voornaam = value.voornaam;
					var achternaam = value.achternaam;
					console.log(value.id, voornaam, achternaam);
					$('#tabel1').append(
							$('<tr></tr>').append($('<td></td>').text(id),
									$('<td></td>').text(voornaam),
									$('<td></td>').text(achternaam)))
					
				}

			});
		});

$(document).ready(function(){
	$("#button").click(function() {
		$('#tabel2').append(
				$('<tr></tr>').append($('<td></td>').text("Id"),
						$('<td></td>').text("Voornaam"),
						$('<td></td>').text("Achternaam"),
						$('<td></td>').text("Geboortedatum"),
						$('<td></td>').text("Emailadres"),
						$('<td></td>').text("Wachtwoord")))
		$.get("restservices/user", function(data, status) {
			for ( var key in data) {
				var value = data[key];
				var id = value.id;
				var voornaam = value.voornaam;
				var achternaam = value.achternaam;
				var input = document.getElementById("id").value;
				if(input == id){
					$('#tabel2').append(
							$('<tr></tr>').append(
									$('<td></td>').text(id),
											$('<td></td>').text(voornaam),
											$('<td></td>').text(achternaam),
											$('<td></td>').text(value.geboortedatum),
											$('<td></td>').text(value.emailadres),
											$('<td></td>').text(value.wachtwoord)))
					console.log(value.user_id, value.datum, value.naam_behandeling);
					}
				}
			});
		});
	$("#verwijder").click(function (){
		var uri = "restservices/user/delete/" + $("#idver").val();
		$.ajax(uri, {
			method: "delete",
			succes: function(response) {
				console.log("shit is verwijderd");
			}
		});
	});
	$("#toevoegen").click(function () {
		var form_data = $("#id").val() + ',' +
		$("#role").val() + ',' +
		$("#vnaam").val() + ',' +
		$("#anaam").val() + ',' +
		$("#gb").val() + ',' +
		$("#ww").val() + ',' +
		$("#email").val();
		console.log(form_data);
		
		var uri = "restservices/user/new";
		$.ajax(uri, {
			method: "post",
			data: form_data,
			dataType: 'application/json',
			contentType: 'application/json',
			succes: function(result){
				alert("Klant is toegevoegd!");
			}
		});
	});
	$("#wijzigen").click(function() {
		var uri = "restservices/user/update/" + wijzig;
		$.ajax(uri, {
			method: "post",
			succes: function(response) {
				console.log("Gelukt");
			},
			error: function(response) {
				alert("Er is iets fout gegaan!");
			}
		})
	})
});