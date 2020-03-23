
function getId(){
		var url = window.location.pathname;
		var id = url.substring(url.lastIndexOf('/') + 1);
		document.getElementById("id").value = id;	
	}
	
function updateData(){
		var url = window.location.pathname;
		var id = url.substring(url.lastIndexOf('/') + 1);
		document.getElementById("id").value = id;
		var link="localhost:8080/userupdate/"+id;
		console.log(link);
		// document.getElementById("formUpdate").action = link2;
		var apiGetInfo='/userupdate/'+id;
		// console.log(apiGetInfo);
		var data = $( "form" ).serialize();
	    console.log(data);
		axios.put(apiGetInfo, data)
			  .then(function (response) {
			    // handle success
			    console.log('Update thanh cong!');
			    alert('Cập nhật thông tin user thành công!');
			    window.location = "/personList";
			    
			  })
			  .catch(function (error) {
			    // handle error
			    console.log(error);
			  })
		
	
	}
function returnList(){
	window.location="/personList";
}
	
	
	