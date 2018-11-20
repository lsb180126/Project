package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.EatDTO;

@Mapper("EatMapper")
public interface EatMapper  {

	List<EatDTO> getEatList()throws Exception;
	
	int insertMember(EatDTO eDTO) throws Exception;

	EatDTO getEatdetail(EatDTO eDTO) throws Exception;

	List<EatDTO> getEatList2(EatDTO eDTO) throws Exception;

	int eatrevise(EatDTO eDTO) throws Exception;

	int eatdelete(EatDTO eDTO) throws Exception;

	int mylistdelete(String userId) throws Exception;

	
}
