package practice.spring.hlthang.controllers;



import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;




import practice.spring.hlthang.model.User;

@Controller
public class mainController {
	private static List<User> persons = new ArrayList<User>();
	static {
		persons.add(new User("Thang", "Huynh"));
		persons.add(new User("Tien", "Huynh"));
	}
	@GetMapping(value = { "/", "/index","/login","login.html" })
    public String index() {
        return "login";
    }
	@GetMapping(value = { "/register","/register.html" })
    public String register() {
        return "register";
    }
	
	@GetMapping(value = { "/personList" })
    public String personList() {
        return "personList";
    }

	@GetMapping("/userinfo/{id}")
	public String personDetail() {
		return "personDetail";
	}
	
	@GetMapping("getInfo")
	public ResponseEntity<List<User>> getInfo() {
		List<User> persons = new ArrayList<User>();
		 {
			
		}
	    return ResponseEntity.ok(persons);
	}
	
	@GetMapping("getdataList")
	public ResponseEntity<List<User>> getRole() {
		List<User> persons = new ArrayList<User>();
		 {
			persons.add(new User("lthang221198", "221198"));
			persons.add(new User("lthang221192", "981122"));
			persons.add(new User(1,"Huynh Long Thang","lthang221198","221198"));
		}
	    return ResponseEntity.ok(persons);
	}
	
}
