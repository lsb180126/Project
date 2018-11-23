package poly.service;

import java.util.List;

import poly.dto.BeautyDTO;
import poly.dto.FileDTO;

public interface IBeautyService {

	int insertMember(BeautyDTO bDTO, FileDTO fDTO) throws Exception;

	List<BeautyDTO> getBeautyList() throws Exception;

	BeautyDTO getBeautydetail(BeautyDTO bDTO) throws Exception;

	List<BeautyDTO> getBeautyList2(BeautyDTO bDTO) throws Exception;

	int beautyrevise(BeautyDTO bDTO, FileDTO fDTO) throws Exception;

	int beautydelete(BeautyDTO bDTO, FileDTO fDTO) throws Exception;

	int mylistdelete(String userId) throws Exception;
	
	

}
