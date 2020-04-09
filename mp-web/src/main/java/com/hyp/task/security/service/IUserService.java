package com.hyp.task.security.service;


import com.hyp.task.security.pojo.SysUser;

public interface IUserService {
    SysUser findByUsername(String userName);
}
