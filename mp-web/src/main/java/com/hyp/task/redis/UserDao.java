package com.hyp.task.redis;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * @author lzh
 * createconsum 2019-09-18-22:32
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

    @Select("select * from user")
    List<User> queryAll();

}
