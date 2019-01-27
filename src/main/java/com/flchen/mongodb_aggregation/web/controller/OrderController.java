package com.flchen.mongodb_aggregation.web.controller;

import com.flchen.mongodb_aggregation.common.controller.BaseController;
import com.flchen.mongodb_aggregation.common.mo.ResponseMO;
import com.flchen.mongodb_aggregation.entity.GoodsDO;
import com.flchen.mongodb_aggregation.entity.OrderDO;
import com.flchen.mongodb_aggregation.entity.TO.OrderTO;
import com.flchen.mongodb_aggregation.entity.UserDO;
import com.flchen.mongodb_aggregation.repository.GoodsAutoRepo;
import com.flchen.mongodb_aggregation.repository.OrderAutoRepo;
import com.flchen.mongodb_aggregation.repository.OrderRepo;
import com.flchen.mongodb_aggregation.repository.UserAutoRepo;
import com.flchen.mongodb_aggregation.web.mo.OrderAddMO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

/**
 * author fl.chen
 * Date 2019-01-27
 * Time 15:12
 **/
@RestController
@RequestMapping("/orders")
public class OrderController extends BaseController {

    @Autowired
    private OrderAutoRepo orderAutoRepo;

    @Autowired
    private UserAutoRepo userAutoRepo;

    @Autowired
    private GoodsAutoRepo goodsAutoRepo;

    @Autowired
    private OrderRepo orderRepo;


    @PostMapping
    public ResponseMO addOrder(@RequestBody @Valid OrderAddMO orderAddMO) {

        UserDO userDO = userAutoRepo.findByuserIdAndEnableIsTrue(orderAddMO.getUserId());


        GoodsDO goodsDO = new GoodsDO();
        Optional<GoodsDO> goodsDOOptional = goodsAutoRepo.findById(orderAddMO.getGoodsId());
        if(goodsDOOptional.isPresent()) {
            goodsDO = goodsDOOptional.get();
        }

        OrderDO orderDO = new OrderDO();
        addCreateInfo(orderDO);
        orderDO.setUserId(userDO.getUserId());
        orderDO.setOrderNo(String.valueOf(System.currentTimeMillis()));
        orderDO.setGoods(goodsDO);
        orderDO.setQuantity(orderAddMO.getQuantity());
        orderDO.setTotalPrice(orderAddMO.getQuantity() * goodsDO.getPrice());
        orderDO.setOrderState(OrderDO.STATE_WAIT_SHIPPING);
        orderAutoRepo.save(orderDO);

        return success(orderDO);
    }

    @GetMapping("/{userId}")
    public ResponseMO searchOrdersByUserId(@PathVariable("userId") @NotBlank String userId) {

        List<OrderTO> orderTOS = orderRepo.findByUserIdOrderByGoods_priceOrderByGoods_shelfState(userId);
        return success(orderTOS);
    }
}
