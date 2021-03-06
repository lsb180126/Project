package poly.service;

import java.util.List;

import poly.dto.FileDTO;
import poly.dto.SellDTO;

public interface ISellService {

	List<SellDTO> getSellList() throws Exception;

	int insertMember(SellDTO sDTO, FileDTO fDTO) throws Exception;

	SellDTO getSelldetail(SellDTO sDTO) throws Exception;

	List<SellDTO> getSellList2(SellDTO sDTO) throws Exception;

	int sellrevise(SellDTO sDTO, FileDTO fDTO) throws Exception;

	int selldelete(SellDTO sDTO, FileDTO fDTO) throws Exception;

	int mylistdelete(String userId) throws Exception;

	List<SellDTO> getSellList3(String keyword) throws Exception;
	
	

}
