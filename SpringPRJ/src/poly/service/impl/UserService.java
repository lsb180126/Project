package poly.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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
	public UserDTO getmylistrevise(String id) throws Exception {
		
		return userMapper.getmylistrevise(id);
	}

	

}
