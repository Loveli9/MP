
/*
参考博客：
https://blog.csdn.net/baidu_39298625/article/details/98592631

1.在bin所在的文件夹下创建mongo.config(或者mongo.conf)配置文档，在文档中加入数据和日志路径配置
（mongodb目录下创建database，下面data和log两个文件，log下面创建mongodb.log）
dbpath = D:\MongoDB\database\data
logpath = D:\MongoDB\database\log\mongodb.log
2.打开新的命令窗口，切换至bin路径下，输入下边命令，路径改为自己的config文件路径,后边的mongodb为服务名
mongod --config "D:\Program Files\MongoDB\Server\4.0\mongo.config" -install -serviceName "mongodb"
3.打开新的命令窗口，输入命令：net start mongodb
*/

db
/*显示当前的数据库名称*/

show dbs	
/*显示当前服务器下数据库（非空的数据库）列表*/

use test	
/*如果test数据库不存在，则创建test数据库*/
/*如果test已存在，则切换到test数据库*/

show collections	
/*显示当前数据库下所包含的集合（表）列表（每个集合相当于mysql中的一个数据表）*/

db.person.insert({name:'huyapeng',age:26,sex:'male',price:2000000})
/*向person集合中插入数据*/
/*如果person集合存在，则直接插入数据，如果不存在，则创建person集合再插入数据*/

db.createCollection('person')
/*创建一个空集合person*/

db.person.insert([{name:'lishi'},{name:'wangwu'}])
db.person.insert([{price:12},{price:14},{price:16},{price:18},{price:20},{price:22},{price:24}])
/*推荐使用这个*/
db.person.insert([
{name:'huyapeng',age:26,sex:'male',price:2000000},
{name:'chenli',age:24,sex:'female',price:1000000},
{name:'huxiaopeng1',age:1,sex:'female',price:1000000},
{name:'huxiaopeng2',age:2,sex:'female',price:2000000},
{name:'huxiaopeng3',age:3,sex:'male',price:3000000},
{name:'huxiaopeng4',age:4,sex:'male',price:4000000},
])
/*一次插入多条数据*/

db.person.find()
/*查询person集合中所有的数据*/

db.person.find({name:'lishi'})
/*查询person集合中name='lishi'的数据*/

db.person.find({name:{$eq:'lishi'}})
/*同上，$eq=>等号，建议使用上面的方式，易记，易输入
eq = equal*/

db.person.find({age:{$gt:18}})
/*查询person集合中age>18的数据  */
 
/*把$gt换成如下的符号试试：
$gt=>大于   great
$gte=>大于等于 great equal
$lt=>小于   less than
$lte=>小于等于 less than equal
$ne=>不等于  not equal
$in=>在范围内
$nin=>不在范围内
以上几个符号格式总结为：{ field: {符号: value}}*/

db.person.find({name:/^华为/})
/*查找person集合中name域中以“华为”字符的开头的数据*/

db.person.find({name:{$in:['华为nova','华为P10']}})
db.person.find({name:{$in:['huyapeng','chenli']}})

/*查询person集合中name='手机1'和name='手机2'的数据
$in=>在范围内
$nin=>不在范围内*/
/*以上两个符号格式为：{ field:{符号:[value1,value2,....]}}*/

db.person.find({name:"huyapeng",price:18})
db.person.find({name:"chenli",price:20})
/*查找name="huyapeng"并且price:18的数据*/

db.person.find({$or:[{name:'huyapeng'},{price:{$lt:30}}]})
db.person.find({$or:[{name:'huyapeng'},{price:{$gt:18}}]})
db.person.find({$and:[{name:'huyapeng'},{price:{$gt:10}}]})
/*查询person集合中name='huyapeng' 或者 price<30的数据
$or=>或者  注意$or:[{},{},....]
$and=>并且  格式同$or, 例：{$and:[{},{},....]}
$nor=>not or 与$or相反， 格式同$or*/

db.person.find({price:{$not:{$gt:100}}})
db.person.find({price:{$not:{$lt:20}}})
/*查询person集合中price>=20的数据，不存在price属性的数据也会查询出来
$not=>取反 */

db.person.find({price:{$exists: true}})
/*查询person集合中包含域名称为price的数据*/

db.person.find({name:{$type:2}})
/*查询person集合中name属性为字符串类型的数据*/

db.person.find({
	$where: function(){
		return this.name == 'huyapeng'
	}
})
/*查询person集合中name='huyapeng’的数据*/

db.person.find({
	$where: function(){
 		return this.name.indexOf('huyapeng') > -1;
	}
})
/*查询person集合中name域中包含“huyapeng”字符的数据*/

db.person.update({name:'huyapeng'},{$set:{price:20}},{
	upsert: true,
	multi:false
})
/*把person集合中name='huyapeng'的那条数据，把price属性设置成20，其它属性保留
$set是指更改的属性列表，不在列表中其他属性会被保留，如果不加此符号，其它属性会被丢弃（_id属性比较特殊，不会丢失）
upsert:true如果没有符号条件的更新时，则插入一条，为false时，则不会插入, 默认是false
multi:false一次只能更新一条数据，为true时，可更新多条，默认是false*/

db.students.remove({})
/*清空集合students*/

db.person.remove({name:'huyapeng1'})
/*删除person集合中name='huyapeng1'的数据，注意，即使把集合person中的所有数据都删除了
person集合仍然存在，remove()是用来删除数据的，而drop()不仅会删除数据，还会把
集合的结构给删除*/

db.person.drop()
/*把stu集合彻底从当前数据中删除，集合stu不再存在，注意与remove()的区别*/

db.dropDatabase()
/*删除当前数据库*/

db.person.distinct('sex')
/*查询person集合中不重复的name属性，返回的是数组*/

db.person.count({sex:'female'})
/*查询person集合中name='zhangshan'的数据数量*/

db.person.find().limit(5)
/*查询person集合中前5条数据*/

db.person.find().skip(5)
/*查询person集合中跳过前5条后的数据*/

db.person.find().sort({name:1})
/*查询person集合中的全部数据，并按name属性正序排列  注：1：正序 -1: 倒序*/

/*由于mongodb的api接口方法很多，除以上命令外，其他的命令请多看官方文档
要求：根据官方文档中的方法原型，能够操作相应的方法*/
