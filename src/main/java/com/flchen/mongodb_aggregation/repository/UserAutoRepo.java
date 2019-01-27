package com.flchen.mongodb_aggregation.repository;

import com.flchen.mongodb_aggregation.entity.UserDO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * author fl.chen
 * Date 2019-01-27
 * Time 10:13
 **/
@Repository
public interface UserAutoRepo extends MongoRepository<UserDO, String> {

    UserDO findByuserIdAndEnableIsTrue(String userId);
}
