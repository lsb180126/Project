package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.EatDTO;
import poly.dto.FileDTO;

@Mapper("EatMapper")
public interface EatMapper  {

	List<EatDTO> getEatList()throws Exception;
	
	int insertMember(EatDTO eDTO) throws Exception;

	EatDTO getEatdetail(EatDTO eDTO) throws Exception;

	List<EatDTO> getEatList2(EatDTO eDTO) throws Exception;

	int eatrevise(EatDTO eDTO) throws Exception;

	int eatdelete(EatDTO eDTO) throws Exception;

	int mylistdelete(String userId) throws Exception;

	int insertFile(FileDTO fDTO) throws Exception;

	int filerevise(FileDTO fDTO) throws Exception;

	
}
