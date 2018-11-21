package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.EatDTO;
import poly.dto.FileDTO;
import poly.persistance.mapper.EatMapper;

import poly.service.IEatService;

@Service("EatService")
public class EatService implements IEatService{
	
	@Resource(name="EatMapper")
	private EatMapper eatMapper;

	@Override
	public List<EatDTO> getEatList() throws Exception {
		
		return eatMapper.getEatList();
	}

	@Override
	public int insertMember(EatDTO eDTO, FileDTO fDTO) throws Exception {
		
		int a = eatMapper.insertMember(eDTO);
		int b = eatMapper.insertFile(fDTO);
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
	public int eatrevise(EatDTO eDTO) throws Exception {
		
		return eatMapper.eatrevise(eDTO);
	}

	@Override
	public int eatdelete(EatDTO eDTO) throws Exception {
		
		return eatMapper.eatdelete(eDTO);
	}

	@Override
	public int mylistdelete(String userId) throws Exception {
		// TODO Auto-generated method stub
		return eatMapper.mylistdelete(userId);
	}

}
