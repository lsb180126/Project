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
	public List<HomegoodsDTO> getHomegoodsList() throws Exception {
		
		return homegoodsMapper.getHomegoodsList();
	}

	@Override
	public int insertMember(HomegoodsDTO hDTO) throws Exception {
		
		return homegoodsMapper.insertMember(hDTO);
		
	}

	@Override
	public HomegoodsDTO getHomegoodsdetail(HomegoodsDTO hDTO) throws Exception {
		
		return homegoodsMapper.getHomegoodsdetail(hDTO);
	}

	@Override
	public int homegoodsrevise(HomegoodsDTO hDTO) throws Exception {
		// TODO Auto-generated method stub
		return homegoodsMapper.homegoodsrevise(hDTO);
	}

	@Override
	public int homegoodsdelete(HomegoodsDTO hDTO) throws Exception {
		// TODO Auto-generated method stub
		return homegoodsMapper.homegoodsdelete(hDTO);
	}

	@Override
	public List<HomegoodsDTO> getHomegoodsList2(HomegoodsDTO hDTO) throws Exception {
		// TODO Auto-generated method stub
		return homegoodsMapper.getHomegoodsList2(hDTO);
	}

}