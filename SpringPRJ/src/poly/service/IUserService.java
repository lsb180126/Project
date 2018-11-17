package poly.service;


import java.util.List;

import poly.dto.UserDTO;

public interface IUserService {

	List<UserDTO> getMemberList() throws Exception;

	int insertMember(UserDTO uDTO) throws Exception;

	int checkDuplication(String id) throws Exception;

	UserDTO getLoginInfo(UserDTO uDTO) throws Exception;

	UserDTO getmyList(UserDTO uDTO) throws Exception;

	int mylistrevise(UserDTO uDTO) throws Exception;

	int mylistdelete(UserDTO uDTO) throws Exception;

	

}