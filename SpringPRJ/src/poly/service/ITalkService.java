package poly.service;

import java.util.List;

import poly.dto.TalkDTO;

public interface ITalkService {

	List<TalkDTO> getMemberList() throws Exception;

	int insertMember(TalkDTO tDTO) throws Exception;
	
	

}
