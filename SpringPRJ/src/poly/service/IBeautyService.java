package poly.service;

import java.util.List;

import poly.dto.BeautyDTO;

public interface IBeautyService {

	int insertMember(BeautyDTO bDTO) throws Exception;

	List<BeautyDTO> getBeautyList() throws Exception;

	BeautyDTO getBeautydetail(BeautyDTO bDTO) throws Exception;
	
	

}
