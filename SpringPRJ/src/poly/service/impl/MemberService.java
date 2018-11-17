package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.MemDTO;
import poly.persistance.mapper.MemMapper;

import poly.service.IMemService;

@Service("MemberService")
public class MemberService implements IMemService{
	
	@Resource(name="MemMapper")
	private MemMapper memMapper;

	@Override
	public List<MemDTO> getMemberList() throws Exception {
		
		return memMapper.getMemberList();
	}

	@Override
	public int insertMember(MemDTO mDTO) throws Exception {
		
		return memMapper.insertMember(mDTO);
	}

}
