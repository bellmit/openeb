package com.gsccs.b2c.plat.pay.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.pay.model.PayNoteExample;
import com.gsccs.eb.api.domain.trade.PayNote;

public interface PayNoteMapper {

	int countByExample(PayNoteExample example);

	int deleteByExample(PayNoteExample example);

	int deleteByPrimaryKey(Long id);

	int insert(PayNote record);

	int insertSelective(PayNote record);

	List<PayNote> selectByExample(PayNoteExample example);

	PayNote selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") PayNote record,
			@Param("example") PayNoteExample example);

	int updateByExample(@Param("record") PayNote record,
			@Param("example") PayNoteExample example);

	int updateByPrimaryKeySelective(PayNote record);

	int updateByPrimaryKey(PayNote record);
}