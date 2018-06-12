package com.lcn.copy.task;

import com.lcn.copy.util.ConditionUtils;

import java.sql.Connection;
import java.util.concurrent.locks.Lock;

public class Task {

    private Lock lock ;

    private Connection connection ;

    private  Object object;

    private volatile boolean hasExecute = false;

    private volatile boolean isNotify = false;




    /**
     *  是否执行等待
     */
    private volatile boolean isAwait = false;


    /**
     * 唯一标示key
     */
    private String key;

    /**
     * 数据状态用于业务处理
     */
    private volatile int state = 0;

    /**
     * 是否被唤醒
     * @return true 是，false，否
     */
    public boolean isNotify() {
        return isNotify;
    }

    public boolean isAwait() {
        return isAwait;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isRemove(String key){
        return !ConditionUtils.getInstance().hasKey(key);
    }

    public void removeTask(){
        ConditionUtils.getInstance().removeTask(getKey());
    }


}
