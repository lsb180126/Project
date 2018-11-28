package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.HospitalDTO;
import poly.dto.PagingDTO;
import poly.dto.UserDTO;

@Mapper("HospitalMapper")
public interface HospitalMapper  {

	List<HospitalDTO> getHospitalList(String address) throws Exception;

	

	
	

	
}