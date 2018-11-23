package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.FileDTO;
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
	public int insertMember(HomegoodsDTO hDTO, FileDTO fDTO) throws Exception {
		
		int a = homegoodsMapper.insertMember(hDTO);
		int b = homegoodsMapper.insertFile(fDTO);
		return a*b;
	}

	@Override
	public HomegoodsDTO getHomegoodsdetail(HomegoodsDTO hDTO) throws Exception {
		
		return homegoodsMapper.getHomegoodsdetail(hDTO);
	}

	@Override
	public int homegoodsrevise(HomegoodsDTO hDTO, FileDTO fDTO) throws Exception {
		// TODO Auto-generated method stub
		int a = homegoodsMapper.homegoodsrevise(hDTO);
		int b = homegoodsMapper.filerevise(fDTO);
		return a*b;
	}

	@Override
	public int homegoodsdelete(HomegoodsDTO hDTO, FileDTO fDTO) throws Exception {
		// TODO Auto-generated method stub
		int a = homegoodsMapper.homegoodsdelete(hDTO);
		int b = homegoodsMapper.filedelete(fDTO);
		return a*b;
	}

	@Override
	public List<HomegoodsDTO> getHomegoodsList2(HomegoodsDTO hDTO) throws Exception {
		// TODO Auto-generated method stub
		return homegoodsMapper.getHomegoodsList2(hDTO);
	}

	@Override
	public int mylistdelete(String userId) throws Exception {
		// TODO Auto-generated method stub
		return homegoodsMapper.mylistdelete(userId);
	}

}
