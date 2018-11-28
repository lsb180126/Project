package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.FileDTO;
import poly.dto.PagingDTO;
import poly.dto.TalkDTO;
import poly.persistance.mapper.TalkMapper;

import poly.service.ITalkService;

@Service("TalkService")
public class TalkService implements ITalkService{
	
	@Resource(name="TalkMapper")
	private TalkMapper talkMapper;

	@Override
	public List<TalkDTO> getTalkList(PagingDTO paging) throws Exception {
		
		return talkMapper.getTalkList(paging);
	}

	@Override
	public int insertMember(TalkDTO tDTO, FileDTO fDTO) throws Exception {
		
		int a = talkMapper.insertMember(tDTO);
		int b;
		if(fDTO !=null) {
			b = talkMapper.insertFile(fDTO);
		}else {
			b =1;
		}
		
		return a*b;
	}

	@Override
	public TalkDTO getTalkdetail(TalkDTO tDTO) throws Exception {
		
		return talkMapper.getTalkdetail(tDTO);
	}

	@Override
	public List<TalkDTO> getTalkList2(TalkDTO tDTO) throws Exception {
		
		return talkMapper.getTalkList2(tDTO);
	}


	@Override
	public int talkrevise(TalkDTO tDTO, FileDTO fDTO) throws Exception {
		
		int a = talkMapper.talkrevise(tDTO);
		int b;
		if(fDTO !=null) {
			b = talkMapper.filerevise(fDTO);
		}else {
			b =1;
		}
		return a*b;
	}

	@Override
	public int talkdelete(TalkDTO tDTO, FileDTO fDTO) throws Exception {
		
		int a = talkMapper.talkdelete(tDTO);
		int b;
		if(fDTO !=null) {
			b = talkMapper.filedelete(fDTO);
		}else {
			b =1;
		}
		return a*b;
	}

	@Override
	public int mylistdelete(String userId) throws Exception {
		// TODO Auto-generated method stub
		return talkMapper.mylistdelete(userId);
	}

	@Override
	public List<TalkDTO> getTalkList3(String keyword) throws Exception {
		
		return talkMapper.getTalkList3(keyword);
	}

	@Override
	public int getTalkListTotalCount(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return talkMapper.getTalkListTotalCount(keyword);
	}

	
	

}