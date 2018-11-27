package poly.service;


import java.util.List;

import poly.dto.HospitalDTO;
import poly.dto.PagingDTO;
import poly.dto.PharmacyDTO;
import poly.dto.UserDTO;

public interface IPharmacyService {

	List<PharmacyDTO> getPharmacyList(String address) throws Exception;

	

	

	

}