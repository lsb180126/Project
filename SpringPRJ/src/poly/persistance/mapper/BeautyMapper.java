package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.BeautyDTO;

@Mapper("BeautyMapper")
public interface BeautyMapper  {

	List<BeautyDTO> getMemberList()throws Exception;
	
	int insertMember(BeautyDTO bDTO) throws Exception;

	
}
