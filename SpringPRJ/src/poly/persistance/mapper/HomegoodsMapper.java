package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.HomegoodsDTO;

@Mapper("HomegoodsMapper")
public interface HomegoodsMapper  {

	List<HomegoodsDTO> getHomegoodsList()throws Exception;
	
	int insertMember(HomegoodsDTO hDTO) throws Exception;

	HomegoodsDTO getHomegoodsdetail(HomegoodsDTO hDTO) throws Exception;

	int homegoodsrevise(HomegoodsDTO hDTO) throws Exception;

	int homegoodsdelete(HomegoodsDTO hDTO) throws Exception;

	List<HomegoodsDTO> getHomegoodsList2(HomegoodsDTO hDTO) throws Exception;

	
}
