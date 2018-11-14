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
	public void insertMember(UserDTO uDTO) throws Exception {
		
		userMapper.insertMember(uDTO);
	}

	@Override
	public int checkDuplication(String id) throws Exception {
		
		
		
		return userMapper.checkDuplication(id);
	}

	
	
	
	
	

}
