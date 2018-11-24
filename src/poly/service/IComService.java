package poly.service;

import java.util.List;

import poly.dto.ComDTO;

public interface IComService {

	List<ComDTO> getMemberList() throws Exception;

	void insertMember(ComDTO cDTO) throws Exception;
	
	

}
