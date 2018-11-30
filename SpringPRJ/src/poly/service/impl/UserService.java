package poly.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.PagingDTO;
import poly.dto.UserDTO;
import poly.persistance.mapper.UserMapper;

import poly.service.IUserService;

@Service("UserService")
public class UserService implements IUserService{
	
	@Resource(name="UserMapper")
	private UserMapper userMapper;

	@Override
	public List<UserDTO> getMemberList() throws Exception {
		
		return userMapper.getMemberList();
	}

	@Override
	public int insertMember(UserDTO uDTO) throws Exception {
		
		return userMapper.insertMember(uDTO);
	}

	@Override
	public int checkDuplication(String id) throws Exception {
		
		return userMapper.checkDuplication(id);
	}

	@Override
	public UserDTO getLoginInfo(UserDTO uDTO) throws Exception {
		
		return userMapper.getLoginInfo(uDTO);
	}

	@Override
	public UserDTO getmyList(UserDTO uDTO) throws Exception {
		
		return userMapper.getmyList(uDTO);
	}

	@Override
	public int mylistrevise(UserDTO uDTO) throws Exception {
		
		return userMapper.mylistrevise(uDTO);
	}

	@Override
	public int mylistdelete(UserDTO uDTO) throws Exception {
		
		return userMapper.mylistdelete(uDTO);
	}

	@Override
	public UserDTO getIdfind(UserDTO uDTO) throws Exception {
		
		return userMapper.getIdfind(uDTO);
	}

	@Override
	public UserDTO getmylist2(UserDTO uDTO) throws Exception {
		
		return userMapper.getmylist2(uDTO);
	}

	@Override
	public UserDTO getPWfind(UserDTO uDTO) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.getPWfind(uDTO);
	}

	@Override
	public int pwrevise(UserDTO uDTO) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.pwrevise(uDTO);
	}

	@Override
	public UserDTO getUserInfo(UserDTO uDTO) throws Exception {
		
		return userMapper.getUserInfo(uDTO);
	}

	@Override
	public int EmailConfirm(UserDTO uDTO) throws Exception {
		
		return userMapper.EmailConfirm(uDTO);
	}

	@Override
	public int getUserListTotalCount(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.getUserListTotalCount(keyword);
	}

	@Override
	public List<UserDTO> getUserList(PagingDTO paging) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.getUserList(paging);
	}

	@Override
	public UserDTO getUserdetail(UserDTO uDTO) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.getUserdetail(uDTO);
	}

	@Override
	public int userrevise(UserDTO uDTO) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.userrevise(uDTO);
	}

	@Override
	public int userdelete(UserDTO uDTO) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.userdelete(uDTO);
	}

	@Override
	public void getLoginInfo2(UserDTO uDTO3) throws Exception {
		// TODO Auto-generated method stub
		userMapper.getLoginInfo2(uDTO3);
	}

	@Override
	public int checkDuplicationEmail(String email) throws Exception {
		return userMapper.checkDuplicationEmail(email);
	}

	@Override
	public int checkDuplicationName(String name) throws Exception {
		return userMapper.checkDuplicationName(name);
	}

}