package poly.service;


import java.util.List;

import poly.dto.UserDTO;

public interface IUserService {

	List<UserDTO> getMemberList() throws Exception;

	void insertMember(UserDTO uDTO) throws Exception;

	int checkDuplication(String id) throws Exception;

	UserDTO getLoginInfo(UserDTO uDTO) throws Exception;


}