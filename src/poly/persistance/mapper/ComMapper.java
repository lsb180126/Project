package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.ComDTO;
import poly.dto.NoticeDTO;

@Mapper("ComMapper")
public interface ComMapper  {

	List<ComDTO> getMemberList()throws Exception;
	
	void insertMember(ComDTO pDTO) throws Exception;

	
}
