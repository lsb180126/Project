package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.HomegoodsDTO;
import poly.persistance.mapper.HomegoodsMapper;

import poly.service.IHomegoodsService;

@Service("HomegoodsService")
public class HomegoodsService implements IHomegoodsService{
	
	@Resource(name="HomegoodsMapper")
	private HomegoodsMapper homegoodsMapper;

	@Override
	public List<HomegoodsDTO> getMemberList() throws Exception {
		
		return homegoodsMapper.getMemberList();
	}

	@Override
	public int insertMember(HomegoodsDTO hDTO) throws Exception {
		
		return homegoodsMapper.insertMember(hDTO);
		
	}

}
