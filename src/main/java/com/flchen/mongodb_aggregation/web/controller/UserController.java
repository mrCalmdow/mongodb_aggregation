package com.flchen.mongodb_aggregation.web.controller;

import com.flchen.mongodb_aggregation.common.controller.BaseController;
import com.flchen.mongodb_aggregation.common.mo.ResponseMO;
import com.flchen.mongodb_aggregation.entity.UserDO;
import com.flchen.mongodb_aggregation.repository.UserAutoRepo;
import com.flchen.mongodb_aggregation.web.mo.UserAddMO;
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
 * Time 10:36
 **/
@RestController
@RequestMapping("/users")
public class UserController extends BaseController {

    @Autowired
    private UserAutoRepo userAutoRepo;

    @PostMapping
    public ResponseMO addUser(@RequestBody @Valid UserAddMO userAddMO) {

        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userAddMO, userDO);
        addCreateInfo(userDO);
        userAutoRepo.save(userDO);
        return success(userDO);
    }
}
