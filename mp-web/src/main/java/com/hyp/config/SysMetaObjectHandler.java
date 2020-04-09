package com.hyp.config;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;

/**
 * Mybatis-Plus自定义填充公共字段 ,即没有传的字段自动填充
 * add
 */
@Slf4j
//@Component
public class SysMetaObjectHandler extends MetaObjectHandler {

    /**
     * inset
     * @param metaObject MetaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.debug("[SysMetaObjectHandler#insertFill] ---> insert set createTime createBy updateTime updateBy param");
    }

    /**
     * update
     * @param metaObject MetaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.debug("[SysMetaObjectHandler#updateFill] ---> update set  updateTime updateBy param");
    }

}
