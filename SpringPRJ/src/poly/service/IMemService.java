package poly.service;

import java.util.List;

import poly.dto.MemDTO;
import poly.dto.TalkDTO;

public interface IMemService {

	List<MemDTO> getMemberList(MemDTO mDTO) throws Exception;

	int insertMember(MemDTO mDTO) throws Exception;

	MemDTO getMemberdetail(MemDTO mDTO) throws Exception;

	MemDTO getWritedetail(MemDTO mDTO) throws Exception;

	int writerevise(MemDTO mDTO) throws Exception;

	List<MemDTO> getReviewList() throws Exception;

	int writedelete(MemDTO mDTO) throws Exception;

	int mylistdelete(String userId) throws Exception;

	

}