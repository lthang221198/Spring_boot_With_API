package practice.spring.hlthang.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class UserService {
	private static List<User> users = new ArrayList<>();
	static {
		users.add(new User(1,"Huynh Long Thang", "lthang221198", "221198"));
		users.add(new User(2,"Huynh Long Thang 2", "lthang221192", "221198"));
		users.add(new User(3,"Huynh Long Thang 2", "lthang221193", "221198"));
	}

	public List<User> findAllUser() {
		return users;
	}

	public User AddUser(User user) {
		if(user.getFullname()!="" && user.getUsername()!="" && user.getPassword()!="")
		{users.add(user);}
		return user;
	}
	public User findById(int id) {
		for(User course:users)
		{
			if(((User) users).getId()==id)
			{
				return course;
			}
		}
		return null;
	}
}
