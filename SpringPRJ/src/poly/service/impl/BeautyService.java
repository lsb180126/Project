package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.BeautyDTO;
import poly.dto.FileDTO;
import poly.persistance.mapper.BeautyMapper;

import poly.service.IBeautyService;

@Service("BeautyService")
public class BeautyService implements IBeautyService{
	
	@Resource(name="BeautyMapper")
	private BeautyMapper beautyMapper;

	@Override
	public int insertMember(BeautyDTO bDTO, FileDTO fDTO) throws Exception {
		
		int a = beautyMapper.insertMember(bDTO);
		int b = beautyMapper.insertFile(fDTO);
		return a*b;
	}

	@Override
	public List<BeautyDTO> getBeautyList() throws Exception {
		
		return beautyMapper.getBeautyList();
	}

	@Override
	public BeautyDTO getBeautydetail(BeautyDTO bDTO) throws Exception {
		
		return beautyMapper.getBeautydetail(bDTO);
	}

	@Override
	public List<BeautyDTO> getBeautyList2(BeautyDTO bDTO) throws Exception {
		
		return beautyMapper.getBeautyList2(bDTO);
	}

	@Override
	public int beautyrevise(BeautyDTO bDTO) throws Exception {
		// TODO Auto-generated method stub
		return beautyMapper.beautyrevise(bDTO);
	}

	@Override
	public int beautydelete(BeautyDTO bDTO) throws Exception {
		// TODO Auto-generated method stub
		return beautyMapper.beautydelete(bDTO);
	}

	@Override
	public int mylistdelete(String userId) throws Exception {
		// TODO Auto-generated method stub
		return beautyMapper.mylistdelete(userId);
	}

}
