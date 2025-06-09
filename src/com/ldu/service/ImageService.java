package com.ldu.service;

import java.util.List;

import com.ldu.pojo.Image;


public interface ImageService {
    int insert(Image record);

    public List<Image> getImagesByGoodsPrimaryKey(Integer goodsId);


    int deleteImagesByGoodsPrimaryKey(Integer goodsId);
}