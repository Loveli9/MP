
/*一、度量表配置*/
	/* 是否虚拟表、表类型：项目需求人员、周期：项目内，迭代内 */
	/* 新增：度量表字段（这个就是度量项） */
	select * from metrics_table_config where id = 1 
	select * from metrics_item_config where metrics_table_config_id = 1
	/*度量项关联指标*/
	/* 1,11,12,193,194,195,196,197 */
	select rkc.* from report_kpi_config_ref_mictrics_item_config rkcrmic 
	right join report_kpi_config rkc on rkcrmic.report_kpi_config_id = rkc.id 
	where rkcrmic.mictrics_item_config_id  = 1

	/*度量表管理*/
	select * from metrics_table_config where id = 1 
	/* 度量项配置 */
	select * from metrics_item_config where metrics_table_config_id = 1

	select * from metrics_table where metrics_table_config_id = 1 and project_id = 'HWHZP5FF1606F03X11'
	select * from metrics_row where metrics_table_id = 17
	/* 3092,3093,3094,3095,3096,3097,3098,3099,3100,3101,3103,3104,3105,3106,3108,3109,3110,3111,3112,3119,3120,3121,3122 */
	select * from metrics_item where metrics_row_id = 3093
	/* metrics_item_config_id : 194,195,196,197,1,11,12,193 */
	/* metrics_item_id : 36629,36630,36631,36632,36633,36634,36635,36636 */

	/* 度量表数据补齐【是一个度量行数据查全补齐的过程】 */
	select * from metrics_table where project_id = 'HWHZP5FF1606F03X11' and metrics_table_config_id = 1
	select * from metrics_row where metrics_table_id = 17
	/* 3092,3093,3094,3095,3096,3097,3098,3099,3100,3101,3103,3104,3105,3106,3108,3109,3110,3111,3112,3119,3120,3121,3122 */
    select * from metrics_item where metrics_row_id = 3092

    /* 工序管理 */
    select * from process_type
    select * from process_info where type_id = 24
    /* 109 110 */
    /* 查询工序引用的KPI */
    select k.id, k.kpi_name, k.data_type, k.expression from process_ref_kpi r
    left join report_kpi_config k on r.kpi_id = k.id
    where r.info_id = 109
    select * from process_ref_kpi where info_id = 109

/*二、指标管理*/
	select * from report_kpi_config

/*三、报表配置*/
	/* 第一步：查询 */
	select * from report_config where project_id = 'HWHZP5FF1606F03X11' or project_id is null
	/* 1,2,35,48,49,51,76,82,84,85,86,88,90,91,92,93,94,95 */
	/* 查询报表配置关联的报表KPI指标 */
	select * from report_kpi_config_reference where report_config_id = 1
	/* report_kpi_config_id : -910,-909,-908,2,24,26,25,27,28 */
	/* reportKpiConfigRefId : 1640,1641,1642,1643,1644,1645,1646,1647,1648 */
	/* 根据报表KPI配置关联表查询关联的KPI */
	select rkc.* from report_kpi_config rkc left join report_kpi_config_reference rkcr 
	on rkcr.report_kpi_config_id=rkc.id 
	where rkcr.id in (1640,1641,1642,1643,1644,1645,1646,1647,1648)
	select rkc.* from report_kpi_config rkc left join report_kpi_config_reference rkcr 
	on rkcr.report_kpi_config_id=rkc.id where rkcr.id = 1640

	/* 第一步：项目裁剪 */
	select * from report_config_excluded where project_id = 'HWHZP5FF1606F03X11'

/*四、项目报表配置+系统报表配置*/
	/*项目报表配置 type=1项目/2需求/3人员/4项目基础指标/5迭代基础指标/6人员基础指标/7需求基础指标 period=1项目内/2迭代内 */
	/*系统报表配置 type=1项目/2需求/3人员 period=1项目内/2迭代内 */
	select * from report_config where project_id is null
	/* 报表ID：reportConfigId = 1 */
	/*关联指标配置*/
	select * from report_kpi_config_reference where report_config_id = 1
	/*report_kpi_config_id*/
	/*-910 -909 -908 2 24 26 25 27  28*/
	select * from report_kpi_config where id in (-910,-909,-908,2,24,26,25,27,28)
	/*kpi_name : 关联的指标名称*/
	/*关联图配置*/
	/*根据报表ID查询关联的图配置(含轴及Series配置)*/
	select * from chart_config where report_config_id = 1
	/*223 224 225 226 227 228*/
	/*title：图配置名称*/
	/*关联轴及Series配置：*/
	select * from chart_config_series where chart_config_id = 223
	select * from chart_config_axis where chart_config_id = 223


/*五、报表管理*/
	/*第一步：查询报表的字段 根据项目查询项目报表及系统报表*/
	select * from report_config where project_id = 'HWHZP5FF1606F03X11' or project_id is NULL
	/*1,2,35,48,49,51,76,82,84,85,86,88,90,91,92,93,94,95*/
	/*根据报表ID查询关联的指标*/
	select * from report_kpi_config_reference where report_config_id = 1 order by idx asc
	/*report_kpi_config_id -910,-909,-908,2,24,26,25,27,28*/
	/*根据指标id查询指标*/
	select * from report_kpi_config where id in (-910,-909,-908,2,24,26,25,27,28)
	/*kpi_name：字段名、指标名*/
	/*迭代,迭代开始时间,迭代结束时间,JAVA代码量（L）,JAVA代码重复行（L）,C代码量（L）,JAVA代码重复率,C代码重复行（L）,C代码重复率*/
	/*第二步，查询具体的数据*/
	/*根据报表配置id及项目查询具体报表id  项目迭代报表测试（勿改）*/
	select * from report where project_id = 'HWHZP5FF1606F03X11' and report_config_id = 1
	/* id 42*/
	/*根据报表id查询所有报表数据行id*/
	select * from report_row where report_id = 42
	/* 527,528,530,531,532,533,534,535,536,537,538,539,541,542,630,631,632 */
	/*根据所有报表数据行id查询每行报表数据*/
	select * from report_kpi where report_row_id = 527

	/*其余功能：提交审核、撤回审核、数据补齐、重新计算*/
	/*一、数据补齐*/
	SELECT * FROM report WHERE (report_config_id = 1 AND project_id = 'HWHZP5FF1606F03X11') 
	/*报表行*/
	select * from report_row where report_id = 42
	SELECT * FROM report_check WHERE (project_id = 'HWHZP5FF1606F03X11' AND report_id = 42) ORDER BY id ASC 
	/*report_kpi ： 报表指标数据表*/
	SELECT * FROM report_kpi WHERE (report_row_id = 527) 
	/*根据报表类型补齐项目所有迭代或项目的指定报表（报表type为project时，补齐项目报表，报表type为iteration时补齐迭代报表）*/	
	select * from iteration_cycle where pro_no = 'HWHZP5FF1606F03X11' and end_date is not null and is_deleted = 0 order by start_date asc 

	SELECT * FROM report_row WHERE (period_id = 'b7e8f0cb4c604cc08cb6e5426616cb75' AND report_Id = 42) 
	/*generateAndCalculateReportRow*/
	/*getOrCreateReportRow  获取指定项目或迭代报表行，如果没有则生成一个新的(新报表行ID为null)*/
	/*这段代码主要是入表 report_row*/
	/*重点：根据项目、迭代、报表配置计算kpi指标的值*/
	
	/*select * from report_kpi_config 如果kpi类型在10/9/8/7 会设置KPI基础值*/
	/*****否则计算KPI的值  calculateKpi  */
		/* 加载数据源，用于计算 指标，加载过程中有任何一个数据源加载失败，则返回错误 */
			/* loadDatas(report, project, iterationCycle, reportKpiConfig, reportRow); */
		/*计算KPI*/
		/* expressionCalculateService.calculate(); */
			/* 检查表达式是否正确：!legalExpression(exp) */
			/* 转化为后缀表达式 */
			/* 计算后缀表达式 */
	/*二、提交审核*/
	/* /report/report_check/submit */
	/*INSERT INTO report_check */
	select * from report_check where report_row_ids = 533

	/* /report/table/get_full_by_project_id_and_report_config_id */
	SELECT * FROM report WHERE (report_config_id = 1 AND project_id = 'HWHZP5FF1606F03X11') 

	/*三、重新计算*/
	/*前提：报表行、报表、迭代信息均存在才能重新计算*/
	select * from report_row where id = 527
	select * from report_kpi where report_row_id = 527
	select * from report where id = 42
	select * from report_config where id = 1
	select * from report_kpi_config_reference where report_config_id = 1
	/** -910,-909,-908,2,24,26,25,27,28 */
	select * from report_kpi_config where id in (-910,-909,-908,2,24,26,25,27,28)
	SELECT * FROM `iteration_cycle` i WHERE i.`id` = '96815597f4c2416498196e5382ee4edd' and i.`is_deleted` = 0 


/*六、报表审核*/
	select * from report_check where id = 93
	/* report_row_ids = 532 */
	/*预警处理流程*/
	/*查看预警规则点灯的哪些指标（四个维度：质量、效率、进度、资源）*/
	select * from early_warning_rule where project_no = 'HWHZP5FF1606F03X11'
	select * from report_row where id = 532
	/* report_id = 42 */
	select * from report where id = 42
	/*initCheckinfo*/
	/*查看报表审核有哪些报表数据行*/
	SELECT * FROM report_check WHERE (project_id = 'HWHZP5FF1606F03X11' AND report_id = 42) ORDER BY id ASC 
	select * from report_row where report_id = 42
	/** 527,528,530,531,532,533,534,535,536,537,538,539,541,542,630,631,632,633,634,635,636,637 */
	select * from report_kpi where report_row_id in (527,528,530,531,532,533,534,535,536,537,538,539,541,542,630,631,632,633,634,635,636,637)
	/*报表数据的每个kpi的值*/
	select * from report_kpi where report_row_id = 527
	/*查询每个指标配置的管理维度*/
	select * from report_kpi_config where id in (-910,-909,-908,2,24,26,25,27,28)
	/*如果这个指标设置了点灯*/
	/*manage_group 1：质量、2：效率、3：进度、4：资源*/
	select * from report_row_warning where id = 532
	/* report_kpi_id ： 3586,3587,3588,3589,3590,3591,3592,3593,3594 */
	/** 亮灯规则包含指标 && 报表kpi状态为false **/
	insert into report_kpi_ref_dimension (report_kpi_id, dimension) values ('3586', '质量')
	select * from report_kpi_ref_dimension
	/*if (status == true)*/
	insert into report_row_warning 
	select * from report_row_warning
	/*触发预警的条件是：报表其中的某一指标配置了预警点灯，然后就是该项目质量预警的周期超过了质量预警规则配置的周期*/
	/** 发送邮件：mailService.sendMail(); **/

/*七、数据收集配置*/
	select * from collection_config where project_id = '16043'
	/* 102 */
	select * from collection_group where collection_config_id = 102
	/* 356,357,358,359,360,361,362 */
	select * from collection_field where collection_group_id in (356,357,358,359,360,361,362)
	select * from collection_field where collection_group_id = 356

