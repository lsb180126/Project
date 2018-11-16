package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.HomegoodsDTO;

@Mapper("HomegoodsMapper")
public interface HomegoodsMapper  {

	List<HomegoodsDTO> getMemberList()throws Exception;
	
	int insertMember(HomegoodsDTO hDTO) throws Exception;

	
}
