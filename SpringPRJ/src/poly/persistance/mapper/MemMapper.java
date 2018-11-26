package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.AllDTO;
import poly.dto.FileDTO;
import poly.dto.MemDTO;
import poly.dto.PagingDTO;

@Mapper("MemMapper")
public interface MemMapper  {

	List<MemDTO> getMemberList(MemDTO mDTO)throws Exception;
	
	int insertMember(MemDTO mDTO) throws Exception;

	MemDTO getMemberdetail(MemDTO mDTO) throws Exception;

	int writerevise(MemDTO mDTO) throws Exception;

	List<MemDTO> getReviewList(PagingDTO paging) throws Exception;

	int writedelete(MemDTO mDTO) throws Exception;

	int mylistdelete(String userId) throws Exception;

	int insertFile(FileDTO fDTO) throws Exception;

	List<MemDTO> getReviewList2(PagingDTO paging) throws Exception;

	int filerevise(FileDTO fDTO) throws Exception;

	int filedelete(FileDTO fDTO) throws Exception;

	int getMemberListTotalCount(String keyword) throws Exception;

	List<AllDTO> getAllList(PagingDTO paging) throws Exception;

	int getMemberListTotalCount2(String userId) throws Exception;

	

	

	

	
}