package poly.service;

import java.util.List;

import poly.dto.BeautyDTO;
import poly.dto.FileDTO;
import poly.dto.PagingDTO;

public interface IBeautyService {

	int insertMember(BeautyDTO bDTO, FileDTO fDTO) throws Exception;

	List<BeautyDTO> getBeautyList(PagingDTO paging) throws Exception;

	BeautyDTO getBeautydetail(BeautyDTO bDTO) throws Exception;

	List<BeautyDTO> getBeautyList2(BeautyDTO bDTO) throws Exception;

	int beautyrevise(BeautyDTO bDTO, FileDTO fDTO) throws Exception;

	int beautydelete(BeautyDTO bDTO, FileDTO fDTO) throws Exception;

	int mylistdelete(String userId) throws Exception;

	List<BeautyDTO> getBeautyList3(String keyword) throws Exception;

	int getBeautyListTotalCount(String keyword) throws Exception;
	
	

}