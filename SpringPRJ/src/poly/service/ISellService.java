package poly.service;

import java.util.List;

import poly.dto.SellDTO;

public interface ISellService {

	List<SellDTO> getSellList() throws Exception;

	int insertMember(SellDTO sDTO) throws Exception;

	SellDTO getSelldetail(SellDTO sDTO) throws Exception;

	List<SellDTO> getSellList2(SellDTO sDTO) throws Exception;

	int sellrevise(SellDTO sDTO) throws Exception;

	int selldelete(SellDTO sDTO) throws Exception;
	
	

}
