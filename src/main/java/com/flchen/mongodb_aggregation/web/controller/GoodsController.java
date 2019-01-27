package com.flchen.mongodb_aggregation.web.controller;

import com.flchen.mongodb_aggregation.common.controller.BaseController;
import com.flchen.mongodb_aggregation.common.mo.ResponseMO;
import com.flchen.mongodb_aggregation.entity.GoodsDO;
import com.flchen.mongodb_aggregation.repository.GoodsAutoRepo;
import com.flchen.mongodb_aggregation.web.mo.GoodsAddMO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * author fl.chen
 * Date 2019-01-27
 * Time 15:04
 **/
@RestController
@RequestMapping("/goods")
public class GoodsController extends BaseController {

    @Autowired
    private GoodsAutoRepo goodsAutoRepo;

    @PostMapping
    public ResponseMO addGoods(@RequestBody @Valid GoodsAddMO goodsAddMO) {

        GoodsDO goodsDO = new GoodsDO();
        BeanUtils.copyProperties(goodsAddMO, goodsDO);
        addCreateInfo(goodsDO);
        goodsAutoRepo.save(goodsDO);
        return success(goodsDO);
    }
}
