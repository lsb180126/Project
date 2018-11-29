package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.EatDTO;
import poly.dto.FileDTO;
import poly.dto.PagingDTO;
import poly.persistance.mapper.EatMapper;

import poly.service.IEatService;

@Service("EatService")
public class EatService implements IEatService{
	
	@Resource(name="EatMapper")
	private EatMapper eatMapper;

	@Override
	public List<EatDTO> getEatList(PagingDTO paging) throws Exception {
		
		return eatMapper.getEatList(paging);
	}

	@Override
	public int insertMember(EatDTO eDTO, FileDTO fDTO) throws Exception {
		
		int a = eatMapper.insertMember(eDTO);
		int b;
		if(fDTO !=null) {
			b = eatMapper.insertFile(fDTO);
		}else {
			b =1;
		}
		return a*b;
	}

	@Override
	public EatDTO getEatdetail(EatDTO eDTO) throws Exception {
		
		return eatMapper.getEatdetail(eDTO);
	}

	@Override
	public List<EatDTO> getEatList2(EatDTO eDTO) throws Exception {
		
		return eatMapper.getEatList2(eDTO);
	}

	@Override
	public int eatrevise(EatDTO eDTO, FileDTO fDTO) throws Exception {
		
		int a = eatMapper.eatrevise(eDTO);
		int b;
		if(fDTO !=null) {
			b = eatMapper.filerevise(fDTO);
		}else {
			b =1;
		}
		return a*b;
	}

	@Override
	public int eatdelete(EatDTO eDTO, FileDTO fDTO) throws Exception {
		
		int a = eatMapper.eatdelete(eDTO);
		int b;
		if(fDTO !=null) {
			b = eatMapper.filedelete(fDTO);
		}else {
			b =1;
		}
		return a*b;
	}

	@Override
	public int mylistdelete(String userId) throws Exception {
		// TODO Auto-generated method stub
		return eatMapper.mylistdelete(userId);
	}

	@Override
	public List<EatDTO> getEatList3(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return eatMapper.getEatList3(keyword);
	}

	@Override
	public int getEatListTotalCount(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return eatMapper.getEatListTotalCount(keyword);
	}
	
	
	
	

}