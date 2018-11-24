package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.FileDTO;
import poly.dto.MemDTO;

@Mapper("MemMapper")
public interface MemMapper  {

	List<MemDTO> getMemberList(MemDTO mDTO)throws Exception;
	
	int insertMember(MemDTO mDTO) throws Exception;

	MemDTO getMemberdetail(MemDTO mDTO) throws Exception;

	int writerevise(MemDTO mDTO) throws Exception;

	List<MemDTO> getReviewList() throws Exception;

	int writedelete(MemDTO mDTO) throws Exception;

	int mylistdelete(String userId) throws Exception;

	int insertFile(FileDTO fDTO) throws Exception;

	List<MemDTO> getReviewList2(String keyword) throws Exception;

	int filerevise(FileDTO fDTO) throws Exception;

	int filedelete(FileDTO fDTO) throws Exception;

	

	

	
}