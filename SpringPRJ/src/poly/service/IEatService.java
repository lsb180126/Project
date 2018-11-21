package poly.service;

import java.util.List;

import poly.dto.EatDTO;
import poly.dto.FileDTO;

public interface IEatService {

	List<EatDTO> getEatList() throws Exception;

	int insertMember(EatDTO uDTO, FileDTO fDTO) throws Exception;

	EatDTO getEatdetail(EatDTO eDTO) throws Exception;

	List<EatDTO> getEatList2(EatDTO eDTO) throws Exception;

	int eatrevise(EatDTO eDTO) throws Exception;

	int eatdelete(EatDTO eDTO) throws Exception;

	int mylistdelete(String userId) throws Exception;
	
	

}
