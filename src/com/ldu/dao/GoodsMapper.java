package com.ldu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldu.pojo.CommentExtend;
import com.ldu.pojo.Comments;
import com.ldu.pojo.Goods;

public interface GoodsMapper {

    int deleteByPrimaryKey(Integer id);
    
    int deleteByPrimaryKeys(Integer id);


    int insert(Goods record);


    int insertSelective(Goods record);


    Goods selectByPrimaryKey(Integer id);
    

	Goods selectById(Integer goodsId);


    int updateByPrimaryKeySelective(Goods record);


    int updateByPrimaryKeyWithBLOBs(Goods record);


    int updateByPrimaryKey(Goods record);


    public List<Goods> selectAllGoods();

    List<Goods> searchGoods(@Param("name") String name,@Param("describle") String describle);


    public List<Goods> selectByStr(@Param("limit")Integer limit,@Param("name") String name,@Param("describle") String describle);


    public List<Goods> selectByCatelog(@Param("catelog_id") Integer catelog_id,@Param("name") String name,@Param("describle") String describle);


    public List<Goods> selectByDate(int page,int maxResults);


    public List<Goods> selectByCatelogOrderByDate(@Param("catelogId")Integer catelogId,@Param("limit")Integer limit);

    

    public List<Goods> selectOrderByDate(@Param("limit")Integer limit);


    public List<Goods> getGoodsByUserId(Integer user_id);
    

    int updateGoodsByGoodsId(Goods goods);

	List<Goods> getGoodsList();

	List<Goods> getPageGoodsByGoods(@Param("id")Integer id, @Param("name")String name,@Param("status")Integer status);
	
	CommentExtend selectCommentsByGoodsId(@Param("id")Integer id);

	public void addComments(Comments comments);
}