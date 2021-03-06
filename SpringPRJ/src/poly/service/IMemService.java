package poly.service;

import java.util.List;

import poly.dto.AllDTO;
import poly.dto.FileDTO;
import poly.dto.MemDTO;
import poly.dto.PagingDTO;
import poly.dto.TalkDTO;

public interface IMemService {

	List<MemDTO> getMemberList(MemDTO mDTO) throws Exception;

	int insertMember(MemDTO mDTO, FileDTO fDTO) throws Exception;

	MemDTO getMemberdetail(MemDTO mDTO) throws Exception;

	int writerevise(MemDTO mDTO, FileDTO fDTO) throws Exception;

	List<MemDTO> getReviewList(PagingDTO paging) throws Exception;

	int writedelete(MemDTO mDTO, FileDTO fDTO) throws Exception;

	int mylistdelete(String userId) throws Exception;

	List<MemDTO> getReviewList2(PagingDTO paging) throws Exception;

	int getMemberListTotalCount(String keyword) throws Exception;

	List<AllDTO> getAllList(PagingDTO paging) throws Exception;

	int getMemberListTotalCount2(String userId) throws Exception;

	AllDTO getAlldetail(AllDTO aDTO) throws Exception;

	

	

	

}