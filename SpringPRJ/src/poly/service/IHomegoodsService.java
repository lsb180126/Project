package poly.service;

import java.util.List;

import poly.dto.HomegoodsDTO;

public interface IHomegoodsService {

	List<HomegoodsDTO> getMemberList() throws Exception;

	int insertMember(HomegoodsDTO hDTO) throws Exception;
	
	

}
