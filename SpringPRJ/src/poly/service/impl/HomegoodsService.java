package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.FileDTO;
import poly.dto.HomegoodsDTO;
import poly.dto.PagingDTO;
import poly.persistance.mapper.HomegoodsMapper;

import poly.service.IHomegoodsService;

@Service("HomegoodsService")
public class HomegoodsService implements IHomegoodsService{
	
	@Resource(name="HomegoodsMapper")
	private HomegoodsMapper homegoodsMapper;

	@Override
	public List<HomegoodsDTO> getHomegoodsList(PagingDTO paging) throws Exception {
		
		return homegoodsMapper.getHomegoodsList(paging);
	}

	@Override
	public int insertMember(HomegoodsDTO hDTO, FileDTO fDTO) throws Exception {
		
		int a = homegoodsMapper.insertMember(hDTO);
		String homegoods_seq_no = homegoodsMapper.getHomegoodsSeqNo();
		int b;
		if(fDTO !=null) {
			fDTO.setBrdSeqNo(homegoods_seq_no);
			b = homegoodsMapper.insertFile(fDTO);
		}else {
			b =1;
		}
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
		int b = 0;
		if(fDTO ==null) {
			System.out.println("사진등록없음");
			b=1;
		}else if("null".equals(fDTO.getFileSeq())) {
			fDTO.setBrdSeqNo(hDTO.getHomegoodsSeqNo());
			b = homegoodsMapper.insertFile(fDTO);
		} else if(fDTO !=null) {
			System.out.println("사진 업로드");
			b = homegoodsMapper.filerevise(fDTO);
		} 
		return a*b;
	}

	@Override
	public int homegoodsdelete(HomegoodsDTO hDTO, FileDTO fDTO) throws Exception {
		// TODO Auto-generated method stub
		int a = homegoodsMapper.homegoodsdelete(hDTO);
		int b;
		if(fDTO !=null) {
			b = homegoodsMapper.filedelete(fDTO);
		}else {
			b =1;
		}
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

	@Override
	public List<HomegoodsDTO> getHomegoodsList3(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return homegoodsMapper.getHomegoodsList3(keyword);
	}

	@Override
	public int getHomegoodsListTotalCount(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return homegoodsMapper.getHomegoodsListTotalCount(keyword);
	}

}