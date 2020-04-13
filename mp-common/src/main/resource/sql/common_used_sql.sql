
/*统计表的空间大小*/
select concat(round(sum(data_length/1024/1024),2),'MB') as data_length_MB,
concat(round(sum(index_length/1024/1024),2),'MB') as index_length_MB
from tables where table_schema='test' and table_name = 'metrics_table';

/*查看分区情况*/
select * from information_schema.`PARTITIONS` where TABLE_schema = DATABASE()
/*查看表的所有信息*/
show VARIABLES
/*查看InnoDB版本*/
show VARIABLES like 'innodb_version'
/*查看InnoDB缓冲池大小*/
show VARIABLES like 'innodb_buffer_pool_size' /*128M*/
/*查看InnoDB缓冲池实例*/
show VARIABLES like 'innodb_buffer_pool_instances' /*128M*/
/*查看InnoDB changebuffer最大空间*/
show VARIABLES like 'innodb_change_buffer_max_size'

/*查看InnoDB引擎状态*/
show ENGINE INNODB STATUS
/*显示有关存储引擎的操作信息*/
show ENGINE INNODB MUTEX
/*来查看当前运行的所有事务*/
select * from information_schema.INNODB_TRX
select * from information_schema.INNODB_LOCKS

/*EXPLAIN查看SQL执行计划*/
EXPLAIN select * from report_kpi_config where kpi_name = "JAVA代码重复率"
EXPLAIN select * from report_kpi_config where kpi_name like '%JAVA%'
EXPLAIN select * from report_kpi_config where id > 10 and id < 30
EXPLAIN select count(*) from metrics_table ORDER BY metrics_table_config_id

/*查看表的索引*/
show index from report_kpi_config
/*查看表的状态*/
show table status like 'report_kpi_config'
/*ANALYZE TABLE语句分析并存储表中索引的分布情况*/
/*（分析索引的统计信息，Cardinality值计算）*/
ANALYZE table report_kpi_config

