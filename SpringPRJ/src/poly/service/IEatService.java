package poly.service;

import java.util.List;

import poly.dto.EatDTO;

public interface IEatService {

	List<EatDTO> getMemberList() throws Exception;

	int insertMember(EatDTO uDTO) throws Exception;
	
	

}
