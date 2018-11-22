package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.FileDTO;
import poly.dto.MemDTO;
import poly.persistance.mapper.MemMapper;

import poly.service.IMemService;

@Service("MemberService")
public class MemberService implements IMemService{
	
	@Resource(name="MemMapper")
	private MemMapper memMapper;


	@Override
	public int insertMember(MemDTO mDTO, FileDTO fDTO) throws Exception {
		
		
		int a = memMapper.insertMember(mDTO);
		int b = memMapper.insertFile(fDTO);
		return a*b;
	}

	@Override
	public MemDTO getMemberdetail(MemDTO mDTO) throws Exception {
		
		return memMapper.getMemberdetail(mDTO);
	}

	@Override
	public MemDTO getWritedetail(MemDTO mDTO) throws Exception {
		
		return memMapper.getWritedetail(mDTO);
	}

	@Override
	public int writerevise(MemDTO mDTO, FileDTO fDTO) throws Exception {
		
		int a = memMapper.writerevise(mDTO);
		int b = memMapper.filerevise(fDTO);
		return a*b;
	}

	@Override
	public List<MemDTO> getMemberList(MemDTO mDTO) throws Exception {
		return memMapper.getMemberList(mDTO);
	}

	@Override
	public List<MemDTO> getReviewList() throws Exception {
		
		return memMapper.getReviewList();
	}

	@Override
	public int writedelete(MemDTO mDTO) throws Exception {
		
		return memMapper.writedelete(mDTO);
	}

	@Override
	public int mylistdelete(String userId) throws Exception {
		// TODO Auto-generated method stub
		return memMapper.mylistdelete(userId);
	}

	@Override
	public List<MemDTO> getReviewList2(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return memMapper.getReviewList2(keyword);
	}

	

	

	
}
