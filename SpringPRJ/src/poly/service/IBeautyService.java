package poly.service;

import java.util.List;

import poly.dto.BeautyDTO;

public interface IBeautyService {

	List<BeautyDTO> getMemberList() throws Exception;

	int insertMember(BeautyDTO bDTO) throws Exception;
	
	

}
