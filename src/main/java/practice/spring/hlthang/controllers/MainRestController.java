package practice.spring.hlthang.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import practice.spring.hlthang.mapper.MapperUsr;
import practice.spring.hlthang.model.User;
import practice.spring.hlthang.model.UserService;

@RestController
public class MainRestController {
	//Thao tac voi database static
	@Autowired
	private UserService userMangagement;

	@GetMapping("/getListUser")
	public List<User> getAllUser() {
		return userMangagement.findAllUser();
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Boolean> checkLogin(User userDTO) {
		if (userDTO.getUsername().equals("lthang221198") && userDTO.getPassword().equals("221198")) {
			return ResponseEntity.ok(true);
		} else {
			return ResponseEntity.ok(false);
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public User addUser(User user) {
		return userMangagement.AddUser(user);
	}
//thao tac voi database my sql
	@Autowired
	MapperUsr userService;

//	@GetMapping("/findalluser")
//	public List<User> selectAllUser() {
//		return userService.selectAllUser();
//	}
	
	/* API tra ve danh sach toan bo users */
	@GetMapping("/users")
	public ResponseEntity<List<User>> listAllUsers() {
	    List<User> users = userService.selectAllUser();
	    if(users.isEmpty()){
	        return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	    }
	    return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	/*API lay thong tin cua 1 user*/
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUser(@PathVariable("id") int id) {
	    System.out.println("Fetching User with id " + id);
	    User user = userService.findById(id);
	    if (user == null) {
	        System.out.println("User with id " + id + " not found");
	        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<User>(user, HttpStatus.OK);
	}
    /*API xoa di 1 user theo id*/
	@DeleteMapping("/deletebyId/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable int id) {
		userService.deleteById(id);
		return ResponseEntity.notFound().build();// ResponseEntity.notFound().build() - If delete failed, return error - resource
		// not found.
	}
	/*API update mot user */
	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user) {
	    System.out.println("Updating User " + id);
	     
	    User currentUser = userService.findById(id);
	     
	    if (currentUser==null) {
	        System.out.println("User with id " + id + " not found");
	        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	    }

	    currentUser.setFullname(user.getFullname());
	    currentUser.setUsername(user.getUsername());
	    currentUser.setPassword(user.getPassword());
	     
	    userService.updateUser(currentUser);
	    return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}
    //modify
    @RequestMapping("/userupdate/{id}")
    public void update(User user,@PathVariable("id") Integer id) {
        userService.updateUser(user);
    }
	
}