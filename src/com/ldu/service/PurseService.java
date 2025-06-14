package com.ldu.service;

import java.util.List;

import com.ldu.pojo.Purse;

public interface PurseService {
	
	public void updatePurseByuserId(Integer userId, Float balance);

	public void updatePurseOfdel(Integer user_id, Float balance);

	public void addPurse(Integer userId);


	public Purse getPurseByUserId(Integer user_id);


	public void updatePurse(Purse purse);

	public int getPurseNum();

	public List<Purse> getPagePurse(int pageNum, int pageSize);

	public List<Purse> getPagePurseByPurse(Integer userId,Integer state, int pageNum, int pageSize);

	public Purse getPurseById(int id);

	public void updateByPrimaryKey(Integer id, Purse purse);

	public void updatePursePassById(Integer id, Purse purse);

	public void updatePurseRefuseById(Integer id,Purse purse);



}
