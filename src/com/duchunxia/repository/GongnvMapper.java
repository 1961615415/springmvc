package com.duchunxia.repository;

import com.duchunxia.domain.Gongnv;
import com.duchunxia.domain.GongnvExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface GongnvMapper {
    /**
     * @mbggenerated
     */
    int countByExample(GongnvExample example);

    /**
     * @mbggenerated
     */
    int deleteByExample(GongnvExample example);

    /**
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @mbggenerated
     */
    int insert(Gongnv record);

    /**
     * @mbggenerated
     */
    int insertSelective(Gongnv record);

    /**
     * @mbggenerated
     */
    List<Gongnv> selectByExample(GongnvExample example);

    /**
     * @mbggenerated
     */
    Gongnv selectByPrimaryKey(Integer id);

    /**
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Gongnv record, @Param("example") GongnvExample example);

    /**
     * @mbggenerated
     */
    int updateByExample(@Param("record") Gongnv record, @Param("example") GongnvExample example);

    /**
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Gongnv record);

    /**
     * @mbggenerated
     */
    int updateByPrimaryKey(Gongnv record);
}