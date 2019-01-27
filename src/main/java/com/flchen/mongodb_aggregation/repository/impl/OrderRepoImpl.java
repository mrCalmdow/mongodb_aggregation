package com.flchen.mongodb_aggregation.repository.impl;

import com.flchen.mongodb_aggregation.entity.OrderDO;
import com.flchen.mongodb_aggregation.entity.TO.OrderTO;
import com.flchen.mongodb_aggregation.repository.OrderRepo;
import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.client.AggregateIterable;
import com.mongodb.util.JSON;
import org.bson.BSONObject;
import org.bson.Document;
import org.bson.codecs.BsonObjectIdCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

/**
 * author fl.chen
 * Date 2019-01-27
 * Time 15:56
 **/
@Repository
public class OrderRepoImpl implements OrderRepo {


    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public List<OrderTO> findByUserIdOrderByGoods_priceOrderByGoods_shelfState(String userId) {

        String orderCollectionName = "order";
        String goodsCollectionName = "goods";

        Aggregation pipeline = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("userId").is(userId)),
                Aggregation.project("userId", "orderState", "goods"),
                Aggregation.lookup(goodsCollectionName, "goods.id", "id", "goodsInfo")

        );
        AggregationResults<OrderTO> results = mongoTemplate.aggregate(pipeline, "order", OrderTO.class);
        if(CollectionUtils.isEmpty(results.getMappedResults())) {
            return new ArrayList<>();
        }
//        BasicDBObject match = BasicDBObject.parse("{'$match':{userId:" + userId + "}}");
//        BasicDBObject addFields = BasicDBObject.parse("{'$addFields':{'goodsIdObj':\n" +
//                "{$arrayToObject:{$map:{\n" +
//                "    input:{$objectToArray:'$goods'}, \n" +
//                "    in:{\n" +
//                "        k:{$cond:[ \n" +
//                "                {$eq:[{'$substrCP':['$$this.k',0,1]},{$literal:'$'}]},\n" +
//                "                {$substrCP:['$$this.k',1,{$strLenCP:'$$this.k'}]},\n" +
//                "                '$$this.k'\n" +
//                "        ]},\n" +
//                "        v:'$$this.v'\n" +
//                "    }\n" +
//                "    }}}}}");
//        BasicDBObject project = BasicDBObject.parse("{'$project': {goodsId : '$goodsIdObj.id',userId:1,orderState:1}}");
//        BasicDBObject lookup = BasicDBObject.parse("{'$lookup': {'from' : '" + goodsCollectionName +"', 'localField' : 'goodsId','foreignField' : '_id','as' : 'goods'}}");
//        BasicDBObject unwind = BasicDBObject.parse("{'$unwind': {path : '$goods'}}");
//        BasicDBObject sortByPrice = BasicDBObject.parse("{'$sort': {'goods.price':1}}");
//        BasicDBObject sortByState = BasicDBObject.parse("{'$sort': {'goods.shelfStatus': -1}}");
//        BasicDBObject finalProject = BasicDBObject.parse("{'$project': {'goodsId':'$goodsId','orderState':'$orderState','goodsPrice':'$goods.price', 'goodsShelfState':'$goods.shelfStatus'}}");
//
//        List<BasicDBObject> pipeline = new ArrayList<>();
//        pipeline.add(match);
//        pipeline.add(addFields);
//        pipeline.add(project);
//        pipeline.add(lookup);
//        pipeline.add(unwind);
//        pipeline.add(sortByPrice);
//        pipeline.add(sortByState);
//        pipeline.add(finalProject);
//        AggregateIterable output = mongoTemplate.getCollection("order").aggregate(pipeline);

        return null;
    }
}
