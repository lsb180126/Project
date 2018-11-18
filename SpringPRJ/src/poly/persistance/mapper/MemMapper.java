package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.MemDTO;

@Mapper("MemMapper")
public interface MemMapper  {

	List<MemDTO> getMemberList()throws Exception;
	
	int insertMember(MemDTO mDTO) throws Exception;

	MemDTO getMemberdetail(MemDTO mDTO) throws Exception;

	
}
