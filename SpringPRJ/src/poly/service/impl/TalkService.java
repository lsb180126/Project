package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.TalkDTO;
import poly.persistance.mapper.TalkMapper;

import poly.service.ITalkService;

@Service("TalkService")
public class TalkService implements ITalkService{
	
	@Resource(name="TalkMapper")
	private TalkMapper talkMapper;

	@Override
	public List<TalkDTO> getMemberList() throws Exception {
		
		return talkMapper.getMemberList();
	}

	@Override
	public int insertMember(TalkDTO tDTO) throws Exception {
		
		return talkMapper.insertMember(tDTO);
		
	}

}
