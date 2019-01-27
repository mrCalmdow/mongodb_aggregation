// Stages that have been excluded from the aggregation pipeline query
__3tsoftwarelabs_disabled_aggregation_stages = [

	{
		// Stage 2 - excluded
		stage: 2,  source: {
			$project: {
			    userId:1,
			    orderState:1,
			    goods:1
			}
		}
	},
]

db.order.aggregate(

	// Pipeline
	[
		// Stage 1
		{
			$match: {
				userId: "1001"
			}
		},

		// Stage 3
		{
			$addFields: {
						    "goodsIdObj":
						     {$arrayToObject:{$map:{
						          input:{$objectToArray:"$goods"}, 
						          in:{
						             k:{$cond:[ 
						                     {$eq:[{"$substrCP":["$$this.k",0,1]},{$literal:"$"}]},
						                     {$substrCP:["$$this.k",1,{$strLenCP:"$$this.k"}]},
						                     "$$this.k"
						             ]},
						             v:"$$this.v"
						           }
						         }}}
			}
		},

		// Stage 4
		{
			$project: {
			    goodsId : "$goodsIdObj.id",
			    userId:1,
			    orderState:1
			}
		},

		// Stage 5
		{
			$lookup: {
			    "from" : "goods",
			    "localField" : "goodsId",
			    "foreignField" : "_id",
			    "as" : "goods"
			}
		},

		// Stage 6
		{
			$unwind: {
			    path : "$goods",
			    includeArrayIndex : "arrayIndex", // optional
			    preserveNullAndEmptyArrays : false // optional
			}
		},

		// Stage 7
		{
			$sort: {
				"goods.price":1
			}
		},

		// Stage 8
		{
			$sort: {
				"goods.shelfStatus": -1
			}
		},

		// Stage 9
		{
			$project: {
			    "goodsId":"$goodsId",
			    "orderState":"$orderState",
			    "goodsPrice":"$goods.price",
			    "goodsShelfState":"$goods.shelfStatus",
			}
		},

	]

	// Created with Studio 3T, the IDE for MongoDB - https://studio3t.com/

);
