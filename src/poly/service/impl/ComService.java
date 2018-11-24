package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.ComDTO;
import poly.persistance.mapper.ComMapper;

import poly.service.IComService;

@Service("ComService")
public class ComService implements IComService{
	
	@Resource(name="ComMapper")
	private ComMapper comMapper;

	@Override
	public List<ComDTO> getMemberList() throws Exception {
		
		return comMapper.getMemberList();
	}

	@Override
	public void insertMember(ComDTO cDTO) throws Exception {
		// TODO Auto-generated method stub
		comMapper.insertMember(cDTO);
	}

}
