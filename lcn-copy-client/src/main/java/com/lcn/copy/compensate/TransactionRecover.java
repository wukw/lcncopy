package com.lcn.copy.compensate;

import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Date;

public class TransactionRecover implements Serializable {
    /**
     * 主键id
     */
    private String id;
    /**
     *  同一模块表示
     */
    private String unique;
    /**
     *
     * 重试次数
     */
    private  int retriedCount = 0;
    /**
     * 创建时间
     */
    private Date createTime = new Date();


    /**
     * 创建时间
     */
    private Date lastTime = new Date();


    /**
     * 事务组id
     */
    private String groupId;

    /**
     * 任务id
     */
    private String taskId;


    /**
     * 事务执行方法
     */
    //private TransactionInvocation invocation;

    /**
     * 数据状态
     * 0 : 未处理
     * 1 : 执行中
     * 2 : task任务扫描中
     */
    private int state;


}
