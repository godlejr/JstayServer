package com.djunderworld.jstay.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.djunderworld.jstay.common.dao.File;

@Repository
public interface FileMapper {
	
	/**
	 * 파일 리스트 생성 함수
	 * 
	 * @author dongjooKim
	 * 
	 * @param files
	 * 
	 * @throws Exception
	 * 
	 */
	void saveFiles(@Param("files") List<File> files) throws Exception;

}
