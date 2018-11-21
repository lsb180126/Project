package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.FileDTO;
import poly.dto.TalkDTO;

@Mapper("TalkMapper")
public interface TalkMapper  {

	List<TalkDTO> getTalkList()throws Exception;
	
	int insertMember(TalkDTO tDTO) throws Exception;

	TalkDTO getTalkdetail(TalkDTO tDTO) throws Exception;

	List<TalkDTO> getTalkList2(TalkDTO tDTO) throws Exception;


	int talkrevise(TalkDTO tDTO) throws Exception;

	int talkdelete(TalkDTO tDTO) throws Exception;

	int mylistdelete(String userId) throws Exception;

	int insertFile(FileDTO fDTO) throws Exception;

	

	

	
}
