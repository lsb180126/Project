package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.FileDTO;
import poly.dto.PagingDTO;
import poly.dto.SellDTO;

@Mapper("SellMapper")
public interface SellMapper  {

	List<SellDTO> getSellList(PagingDTO paging)throws Exception;
	
	int insertMember(SellDTO uDTO) throws Exception;

	SellDTO getSelldetail(SellDTO sDTO) throws Exception;

	List<SellDTO> getSellList2(SellDTO sDTO) throws Exception;

	int sellrevise(SellDTO sDTO) throws Exception;

	int selldelete(SellDTO sDTO) throws Exception;

	int mylistdelete(String userId) throws Exception;

	int insertFile(FileDTO fDTO) throws Exception;

	int filerevise(FileDTO fDTO) throws Exception;

	int filedelete(FileDTO fDTO) throws Exception;

	List<SellDTO> getSellList3(String keyword) throws Exception;

	int getSellListTotalCount(String keyword) throws Exception;

	String getSellSeqNo() throws Exception;

	
}