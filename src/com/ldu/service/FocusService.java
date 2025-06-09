package com.ldu.service;

import java.util.List;

import com.ldu.pojo.Focus;

public interface FocusService {
	

    public List<Focus> getFocusByUserId(Integer user_id);
    

    public void deleteFocusByUserIdAndGoodsId(Integer goods_id,Integer user_id);


	public void addFocusByUserIdAndId(Integer goods_id, Integer user_id);

}
