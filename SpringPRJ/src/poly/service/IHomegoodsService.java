package poly.service;

import java.util.List;

import poly.dto.HomegoodsDTO;

public interface IHomegoodsService {

	List<HomegoodsDTO> getHomegoodsList() throws Exception;

	int insertMember(HomegoodsDTO hDTO) throws Exception;

	HomegoodsDTO getHomegoodsdetail(HomegoodsDTO hDTO) throws Exception;

	int homegoodsrevise(HomegoodsDTO hDTO) throws Exception;

	int homegoodsdelete(HomegoodsDTO hDTO) throws Exception;

	List<HomegoodsDTO> getHomegoodsList2(HomegoodsDTO hDTO) throws Exception;

	int mylistdelete(String userId) throws Exception;
	
	

}
