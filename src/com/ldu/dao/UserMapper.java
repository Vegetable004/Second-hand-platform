package com.ldu.dao;

import org.apache.ibatis.annotations.Param;

import com.ldu.pojo.User;

import java.util.List;

public interface UserMapper{
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getUserByPhone(String phone);

    int updateGoodsNum(@Param("id") Integer id, @Param("goodsNum") Integer goodsNum);

    public List<User> getUserList();

	int findCount();

	User getUserById(int id);

	List<User> getUserListByUser(@Param("phone") String phone,@Param("username") String username,@Param("qq") String qq);

	List<User> getUserListOrderByCreateAt();
}