package poly.service;


import java.util.List;

import poly.dto.HospitalDTO;
import poly.dto.PagingDTO;
import poly.dto.UserDTO;

public interface IHospitalService {

	List<HospitalDTO> getHospitalList(String address) throws Exception;

	

	

	

}