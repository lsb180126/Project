package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.BeautyDTO;
import poly.dto.FileDTO;
import poly.dto.PagingDTO;
import poly.persistance.mapper.BeautyMapper;

import poly.service.IBeautyService;

@Service("BeautyService")
public class BeautyService implements IBeautyService{
	
	@Resource(name="BeautyMapper")
	private BeautyMapper beautyMapper;

	@Override
	public int insertMember(BeautyDTO bDTO, FileDTO fDTO) throws Exception {
		
		int a = beautyMapper.insertMember(bDTO);
		String beauty_seq_no = beautyMapper.getBeautySeqNo();
		int b;
		if(fDTO !=null) {
			fDTO.setBrdSeqNo(beauty_seq_no);
			b = beautyMapper.insertFile(fDTO);
		}else {
			b =1;
		}
		return a*b;
	}

	@Override
	public List<BeautyDTO> getBeautyList(PagingDTO paging) throws Exception {
		
		return beautyMapper.getBeautyList(paging);
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
	public int beautyrevise(BeautyDTO bDTO, FileDTO fDTO) throws Exception {
		// TODO Auto-generated method stub
		int a = beautyMapper.beautyrevise(bDTO);
		int b = 0;
		if(fDTO == null) {
			System.out.println("사진등록없음");
			b=1;
		}else if("null".equals(fDTO.getFileSeq())) {
			fDTO.setBrdSeqNo(bDTO.getBeautySeqNo());
			b = beautyMapper.insertFile(fDTO);
		} else if(fDTO !=null) {
			System.out.println("사진 업로드");
			b = beautyMapper.filerevise(fDTO);
		} 
		return a*b;
	}

	@Override
	public int beautydelete(BeautyDTO bDTO, FileDTO fDTO) throws Exception {
		// TODO Auto-generated method stub
		int a = beautyMapper.beautydelete(bDTO);
		int b;
		if(fDTO !=null) {
			b = beautyMapper.filedelete(fDTO);
		}else {
			b =1;
		}
		return a*b;
	}

	@Override
	public int mylistdelete(String userId) throws Exception {
		// TODO Auto-generated method stub
		return beautyMapper.mylistdelete(userId);
	}

	@Override
	public List<BeautyDTO> getBeautyList3(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return beautyMapper.getBeautyList3(keyword);
	}

	@Override
	public int getBeautyListTotalCount(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return beautyMapper.getBeautyListTotalCount(keyword);
	}

}