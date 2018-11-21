package poly.service;

import java.util.List;

import poly.dto.FileDTO;
import poly.dto.TalkDTO;

public interface ITalkService {

	List<TalkDTO> getTalkList() throws Exception;

	int insertMember(TalkDTO tDTO, FileDTO fDTO) throws Exception;

	TalkDTO getTalkdetail(TalkDTO tDTO) throws Exception;

	List<TalkDTO> getTalkList2(TalkDTO tDTO) throws Exception;


	int talkrevise(TalkDTO tDTO) throws Exception;

	int talkdelete(TalkDTO tDTO) throws Exception;

	int mylistdelete(String userId) throws Exception;

	
	
	

}
