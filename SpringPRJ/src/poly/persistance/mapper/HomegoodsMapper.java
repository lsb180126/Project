package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.FileDTO;
import poly.dto.HomegoodsDTO;
import poly.dto.PagingDTO;

@Mapper("HomegoodsMapper")
public interface HomegoodsMapper  {

	List<HomegoodsDTO> getHomegoodsList(PagingDTO paging)throws Exception;
	
	int insertMember(HomegoodsDTO hDTO) throws Exception;

	HomegoodsDTO getHomegoodsdetail(HomegoodsDTO hDTO) throws Exception;

	int homegoodsrevise(HomegoodsDTO hDTO) throws Exception;

	int homegoodsdelete(HomegoodsDTO hDTO) throws Exception;

	List<HomegoodsDTO> getHomegoodsList2(HomegoodsDTO hDTO) throws Exception;

	int mylistdelete(String userId) throws Exception;

	int insertFile(FileDTO fDTO) throws Exception;

	int filerevise(FileDTO fDTO) throws Exception;

	int filedelete(FileDTO fDTO) throws Exception;

	List<HomegoodsDTO> getHomegoodsList3(String keyword) throws Exception;

	int getHomegoodsListTotalCount(String keyword) throws Exception;

	String getHomegoodsSeqNo() throws Exception;

	
}