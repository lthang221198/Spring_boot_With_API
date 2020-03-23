
	function registerEvent(fullname,username,password) {	
		var data = $( "form" ).serialize();
	    console.log(data);
		axios.post('/register', data)
			.then(response => {
				console.log(response['data']);
				var data=response['data'];
				if(data.fullname!="" &&data.username!=""&&data.password!="")
					window.location = "/login";
			})
			.catch(error => console.log(error));
	}