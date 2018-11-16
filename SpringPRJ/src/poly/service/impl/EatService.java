package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.EatDTO;
import poly.persistance.mapper.EatMapper;

import poly.service.IEatService;

@Service("EatService")
public class EatService implements IEatService{
	
	@Resource(name="EatMapper")
	private EatMapper eatMapper;

	@Override
	public List<EatDTO> getMemberList() throws Exception {
		
		return eatMapper.getMemberList();
	}

	@Override
	public int insertMember(EatDTO eDTO) throws Exception {
		
		return eatMapper.insertMember(eDTO);
		
	}

}
