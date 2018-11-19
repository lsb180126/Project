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
	public List<SellDTO> getSellList() throws Exception {
		
		return sellMapper.getSellList();
	}

	@Override
	public int insertMember(SellDTO sDTO) throws Exception {
		
		return sellMapper.insertMember(sDTO);
		
	}

	@Override
	public SellDTO getSelldetail(SellDTO sDTO) throws Exception {
		
		return sellMapper.getSelldetail(sDTO);
	}

	@Override
	public List<SellDTO> getSellList2(SellDTO sDTO) throws Exception {
		
		return sellMapper.getSellList2(sDTO);
	}

	@Override
	public int sellrevise(SellDTO sDTO) throws Exception {
		
		return sellMapper.sellrevise(sDTO);
	}

	@Override
	public int selldelete(SellDTO sDTO) throws Exception {
		// TODO Auto-generated method stub
		return sellMapper.selldelete(sDTO);
	}

}
