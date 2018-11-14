package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.UserDTO;

@Mapper("UserMapper")
public interface UserMapper  {

	List<UserDTO> getMemberList()throws Exception;
	
	void insertMember(UserDTO uDTO) throws Exception;

	int checkDuplication(String id) throws Exception;

	
}