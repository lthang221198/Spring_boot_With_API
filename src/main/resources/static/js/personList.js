
function helloFunc() {
		axios.get('/users')
		  .then(function (response) {
		    // handle success
		    var dataUsers=response['data'];
		    var table = document.getElementById('tablelist');
		    for(var i=0;i<dataUsers.length;i++){
		    	var dataUser=dataUsers[i];
		    	console.log(dataUser);
		    	 // create a row element to append cells to
		        var row = document.createElement('tr');
		        // properties of the array elements
		        var properties = ['id','fullname', 'username', 'password','update','delete'];
		        for (var j = 0; j < properties.length; ++j) {
		        	
		            // create new data cell for names
		            var cell = document.createElement('td');
					
		            // set name of property using bracket notation
					// (properties[j] is a string,
		            // which can be used to access properties of dataUser)
		            if(j<4)
		            {
		            	cell.innerHTML = dataUser[properties[j]];
		            }
		            else if(j==4) {
		            	 cell = document.createElement("BUTTON");
		            	 cell.className = 'btn_update';
		            	 cell.innerHTML = "UPDATE";
		            	 cell.setAttribute("id", i+1);
		            	 cell.setAttribute("value", i+1);
		            	 cell.onclick = function(){   
		            	 var userId=parseInt(this.id);
						 window.location = "/userinfo/"+userId;
		            		  };
		            
		            }
		            else {
		            	 cell = document.createElement("BUTTON");
		            	 cell.className = 'btn_delete';
		            	 cell.innerHTML = "DELETE";
		            }
		            // add to end of the row
		            row.appendChild(cell);
		            
		          }
		       
		          // add new row to table
		          table.appendChild(row);
		          
		         
		        }
			   
		    
		  })
		  .catch(function (error) {
		    // handle error
		    console.log(error);
		  })
	}
	function Delete(){
		axios.get
	}
