package poly.service;

import java.util.List;

import poly.dto.FileDTO;
import poly.dto.HomegoodsDTO;
import poly.dto.PagingDTO;

public interface IHomegoodsService {

	List<HomegoodsDTO> getHomegoodsList(PagingDTO paging) throws Exception;

	int insertMember(HomegoodsDTO hDTO, FileDTO fDTO) throws Exception;

	HomegoodsDTO getHomegoodsdetail(HomegoodsDTO hDTO) throws Exception;

	int homegoodsrevise(HomegoodsDTO hDTO, FileDTO fDTO) throws Exception;

	int homegoodsdelete(HomegoodsDTO hDTO, FileDTO fDTO) throws Exception;

	List<HomegoodsDTO> getHomegoodsList2(HomegoodsDTO hDTO) throws Exception;

	int mylistdelete(String userId) throws Exception;

	List<HomegoodsDTO> getHomegoodsList3(String keyword) throws Exception;

	int getHomegoodsListTotalCount(String keyword) throws Exception;
	
	

}