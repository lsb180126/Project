package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.PagingDTO;
import poly.dto.UserDTO;

@Mapper("UserMapper")
public interface UserMapper  {

	List<UserDTO> getMemberList()throws Exception;
	
	int insertMember(UserDTO uDTO) throws Exception;

	int checkDuplication(String id) throws Exception;

	UserDTO getLoginInfo(UserDTO uDTO) throws Exception;

	UserDTO getmyList(UserDTO uDTO) throws Exception;

	int mylistrevise(UserDTO uDTO) throws Exception;

	int mylistdelete(UserDTO uDTO) throws Exception;

	UserDTO getIdfind(UserDTO uDTO) throws Exception;

	UserDTO getmylist2(UserDTO uDTO) throws Exception;

	UserDTO getPWfind(UserDTO uDTO) throws Exception;

	int pwrevise(UserDTO uDTO) throws Exception;

	UserDTO getUserInfo(UserDTO uDTO) throws Exception;

	int EmailConfirm(UserDTO uDTO) throws Exception;

	int getUserListTotalCount(String keyword) throws Exception;

	List<UserDTO> getUserList(PagingDTO paging) throws Exception;

	UserDTO getUserdetail(UserDTO uDTO) throws Exception;

	int userrevise(UserDTO uDTO) throws Exception;

	int userdelete(UserDTO uDTO) throws Exception;

	void getLoginInfo2(UserDTO uDTO3) throws Exception;

	int checkDuplicationEmail(String email) throws Exception;

	int checkDuplicationName(String name) throws Exception;

	

	
}