package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.TalkDTO;

@Mapper("TalkMapper")
public interface TalkMapper  {

	List<TalkDTO> getMemberList()throws Exception;
	
	int insertMember(TalkDTO tDTO) throws Exception;

	TalkDTO getTalkdetail(TalkDTO tDTO) throws Exception;

	
}
