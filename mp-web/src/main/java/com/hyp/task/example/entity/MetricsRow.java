package com.hyp.task.example.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.util.Date;

/**
 * @NAME: 度量表行数据
 * @Author: wwx550362
 * @Date: 2019/12/10 14:46
 * @Version 1.0
 */
@Data
@TableName(value = "metrics_row")
public class MetricsRow {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("metrics_Table_Id")
    private Integer metricsTableId;

    @TableField("period")
    private String period;

    @TableField("period_id")
    private String periodId;

    @TableField("period_name")
    private String periodName;

    @TableField("period_start_date")
    private Date periodStartDate;

    @TableField(value = "period_end_date")
    private Date periodEndDate;

}
