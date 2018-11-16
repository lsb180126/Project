package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.SellDTO;
import poly.persistance.mapper.SellMapper;

import poly.service.ISellService;

@Service("SellService")
public class SellService implements ISellService{
	
	@Resource(name="SellMapper")
	private SellMapper sellMapper;

	@Override
	public List<SellDTO> getMemberList() throws Exception {
		
		return sellMapper.getMemberList();
	}

	@Override
	public int insertMember(SellDTO sDTO) throws Exception {
		
		return sellMapper.insertMember(sDTO);
		
	}

}
