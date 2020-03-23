
	function loginFunc(username,password) {
		// username, password
		var data = $( "form" ).serialize();
	    console.log(data);
		axios.post('/login', data)
			.then(response => {
				console.log(response['data']);
				if (response['data'] == true) {
					window.location = "/personList";
				}
				else if (response['data'] == false) {
					document.getElementById("check-login").innerHTML = "Username or Password is incorrect!";
				}
			})
			.catch(error => console.log(error));
	}
