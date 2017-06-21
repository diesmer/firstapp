var value;
$(document).ready(
		function info() {
			$.get("restservices/afspraak", function(data, status) {
				for ( var key in data) {
					var value = data[key];
					var id = value.id;
					var datum = value.datum;
					var userid = value.user_id;
					console.log(id, datum, userid);
					$('#tabel1').append(
							$('<tr></tr>').append($('<td></td>').text(id),
									$('<td></td>').text(userid),
									$('<td></td>').text(datum)))
				}

			});
		});
$(document).ready(function(){
	$("#button").click(function() {
		$('#tabel2').append(
				$('<tr></tr>').append($('<td></td>').text("userid"),
						$('<td></td>').text("datum"),
						$('<td></td>').text("naam behandeling")))
		$.get("restservices/afspraak", function(data, status) {
			for ( var key in data) {
				var value = data[key];
				var id = value.id;
				var datum = value.datum;
				var userid = value.user_id;
				var input = document.getElementById("id").value;
				if(input == id){
					$('#tabel2').append(
							$('<tr></tr>').append(
									$('<td></td>').text(id),
											$('<td></td>').text(userid),
											$('<td></td>').text(datum),
											$('<td></td>').text(value.naam_behandeling)))
					console.log(value.user_id, value.datum, value.naam_behandeling);
				}
			}

		});

});
	$("#verwijder").click(function (){
		var uri = "restservices/afspraak/delete/" + $("#idver").val();
		$.ajax(uri, {
			method: "delete",
			succes: function(response) {
				console.log("shit is verwijderd");
			}
		});
	});
	$("#toevoegen").click(function () {
		var form_data = $("#id").val() + ',' +
		$("#behandeling").val() + ',' +
		$("#datum").val() + ',' +
		$("#tijd").val() + ',' +
		$("#lengte").val() + ',' +
		$("#userid").val();
		console.log(form_data);
		
		var uri = "restservices/afspraak/new";
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
});
