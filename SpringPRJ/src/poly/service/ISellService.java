package poly.service;

import java.util.List;

import poly.dto.SellDTO;

public interface ISellService {

	List<SellDTO> getSellList() throws Exception;

	int insertMember(SellDTO sDTO) throws Exception;

	SellDTO getSelldetail(SellDTO sDTO) throws Exception;
	
	

}
