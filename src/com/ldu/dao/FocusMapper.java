package com.ldu.dao;

import java.util.List;

import com.ldu.pojo.Focus;

public interface FocusMapper {
	

    public List<Focus> getFocusByUserId(Integer user_id);
    

    
    public void deleteFocusByUserIdAndGoodsId(Integer goods_id,Integer user_id);


	public void addFocusByUserIdAndGoodsId(Integer goods_id, Integer user_id);

}
