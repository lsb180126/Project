package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.EatDTO;

@Mapper("EatMapper")
public interface EatMapper  {

	List<EatDTO> getMemberList()throws Exception;
	
	int insertMember(EatDTO eDTO) throws Exception;

	EatDTO getEatdetail(EatDTO eDTO) throws Exception;

	
}
