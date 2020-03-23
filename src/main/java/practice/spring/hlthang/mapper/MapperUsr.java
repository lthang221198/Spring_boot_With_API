package practice.spring.hlthang.mapper;
import practice.spring.hlthang.model.User;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface MapperUsr {
	public List<User> selectAllUser();
	public int deleteById(int id);
	public User findById(int id);
	public void updateUser(User currentUser);
	
}
