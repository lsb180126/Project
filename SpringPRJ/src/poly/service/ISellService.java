package poly.service;

import java.util.List;

import poly.dto.SellDTO;

public interface ISellService {

	List<SellDTO> getMemberList() throws Exception;

	int insertMember(SellDTO sDTO) throws Exception;
	
	

}
