package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.HospitalDTO;
import poly.dto.PagingDTO;
import poly.dto.PharmacyDTO;
import poly.dto.UserDTO;

@Mapper("PharmacyMapper")
public interface PharmacyMapper  {

	List<PharmacyDTO> getPharmacyList(String address) throws Exception;

	
	

	
}