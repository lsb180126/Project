package poly.service;

import java.util.List;

import poly.dto.MemDTO;

public interface IMemService {

	List<MemDTO> getMemberList() throws Exception;

	int insertMember(MemDTO mDTO) throws Exception;

	MemDTO getMemberdetail(MemDTO mDTO) throws Exception;
	
	

}
