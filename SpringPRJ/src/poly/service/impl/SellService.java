package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.FileDTO;
import poly.dto.PagingDTO;
import poly.dto.SellDTO;
import poly.persistance.mapper.SellMapper;

import poly.service.ISellService;

@Service("SellService")
public class SellService implements ISellService{
	
	@Resource(name="SellMapper")
	private SellMapper sellMapper;

	@Override
	public List<SellDTO> getSellList(PagingDTO paging) throws Exception {
		
		return sellMapper.getSellList(paging);
	}

	@Override
	public int insertMember(SellDTO sDTO, FileDTO fDTO) throws Exception {
		
		int a = sellMapper.insertMember(sDTO);
		int b = sellMapper.insertFile(fDTO);
		return a*b;
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
	public int sellrevise(SellDTO sDTO, FileDTO fDTO) throws Exception {
		
		int a = sellMapper.sellrevise(sDTO);
		int b = sellMapper.filerevise(fDTO);
		return a*b;
	}

	@Override
	public int selldelete(SellDTO sDTO, FileDTO fDTO) throws Exception {
		// TODO Auto-generated method stub
		int a = sellMapper.selldelete(sDTO);
		int b = sellMapper.filedelete(fDTO);
		return a*b;
	}

	@Override
	public int mylistdelete(String userId) throws Exception {
		// TODO Auto-generated method stub
		return sellMapper.mylistdelete(userId);
	}

	@Override
	public List<SellDTO> getSellList3(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return sellMapper.getSellList3(keyword);
	}

	@Override
	public int getSellListTotalCount(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return sellMapper.getSellListTotalCount(keyword);
	}

}