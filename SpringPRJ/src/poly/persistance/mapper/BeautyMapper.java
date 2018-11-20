package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.BeautyDTO;

@Mapper("BeautyMapper")
public interface BeautyMapper  {

	int insertMember(BeautyDTO bDTO) throws Exception;

	List<BeautyDTO> getBeautyList() throws Exception;

	BeautyDTO getBeautydetail(BeautyDTO bDTO) throws Exception;

	List<BeautyDTO> getBeautyList2(BeautyDTO bDTO) throws Exception;

	int beautyrevise(BeautyDTO bDTO) throws Exception;

	int beautydelete(BeautyDTO bDTO) throws Exception;

	
}