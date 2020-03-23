		function helloFunc() {
			axios.get('/getListUser')
			  .then(function (response) {
			    // handle success
			    var dataUser=response['data'];
			    console.log(dataUser[0]);
			    document.getElementById("demo").innerHTML =
			    	dataUser[0].getUsername() + " and " + dataUser[0].getFullname() + " years old."+dataUser[0].getPassword();
			  })
			  .catch(function (error) {
			    // handle error
			    console.log(error);
			  })
		}
		
	