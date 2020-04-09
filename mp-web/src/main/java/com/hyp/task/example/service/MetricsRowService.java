package com.hyp.task.example.service;

import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hyp.task.example.entity.MetricsRow;
import com.hyp.task.example.mapper.MetricsRowDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chenjiabin
 * @createtime 2019-12-11
 */
@Service
@Transactional
public class MetricsRowService extends ServiceImpl<MetricsRowDao, MetricsRow> implements IService<MetricsRow> {

    @Transactional(rollbackFor = Exception.class)
    public void merge(MetricsRow metricsRow) {
        insert(metricsRow);
    }

}