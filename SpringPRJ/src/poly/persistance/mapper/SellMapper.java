package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.SellDTO;

@Mapper("SellMapper")
public interface SellMapper  {

	List<SellDTO> getMemberList()throws Exception;
	
	int insertMember(SellDTO uDTO) throws Exception;

	
}
