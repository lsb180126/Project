package poly.service;

import java.util.List;

import poly.dto.TalkDTO;

public interface ITalkService {

	List<TalkDTO> getTalkList() throws Exception;

	int insertMember(TalkDTO tDTO) throws Exception;

	TalkDTO getTalkdetail(TalkDTO tDTO) throws Exception;
	
	

}
