var user = null;

$(document).ready(function() {
	$("#login").click(function() {
		$.get("restservices/user", function(data, status) {
			for ( var key in data) {
				var value = data[key];
				var email = document.getElementById('email').value;
				var ww = document.getElementById('wachtwoord').value;
				
				if ((value.emailadres == email) && (value.wachtwoord == ww)) {
					if (value.role == "admin") {
						console.log("admin");
						window.location.assign("http://localhost:8081/firstapp/HomeAdmin.html");
					} else if (value.role == "klant") {
						window.location.assign("http://localhost:8081/firstapp/HomeKlant.html");
					}
					console.log("t klopt");
				}
				console.log(value.emailadres, value.wachtwoord, email, ww);
			}

		});
	});
});