package poly.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.HospitalDTO;
import poly.dto.PagingDTO;
import poly.dto.UserDTO;
import poly.persistance.mapper.HospitalMapper;
import poly.persistance.mapper.UserMapper;
import poly.service.IHospitalService;
import poly.service.IUserService;

@Service("HospitalService")
public class HospitalService implements IHospitalService{
	
	@Resource(name="HospitalMapper")
	private HospitalMapper hospitalMapper;

	@Override
	public List<HospitalDTO> getHospitalList(String address) throws Exception {
		// TODO Auto-generated method stub
		return hospitalMapper.getHospitalList(address);
	}

	

}