package poly.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.HospitalDTO;
import poly.dto.PagingDTO;
import poly.dto.PharmacyDTO;
import poly.dto.UserDTO;
import poly.persistance.mapper.HospitalMapper;
import poly.persistance.mapper.PharmacyMapper;
import poly.persistance.mapper.UserMapper;
import poly.service.IHospitalService;
import poly.service.IPharmacyService;
import poly.service.IUserService;

@Service("PharmacyService")
public class PharmacyService implements IPharmacyService{
	
	@Resource(name="PharmacyMapper")
	private PharmacyMapper pharmacyMapper;

	@Override
	public List<PharmacyDTO> getPharmacyList(String address) throws Exception {
		// TODO Auto-generated method stub
		return pharmacyMapper.getPharmacyList(address);
	}

	
	

}