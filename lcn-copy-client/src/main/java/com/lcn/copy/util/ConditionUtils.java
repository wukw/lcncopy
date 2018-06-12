package com.lcn.copy.util;

import com.lcn.copy.task.Task;
import com.lcn.copy.task.TxTask;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConditionUtils {
    private static ConditionUtils instance = null;

    private Map<String, Task> taskMap = new ConcurrentHashMap<String, Task>();

    /**
     * 单列
     * @return
     */
    public static   ConditionUtils getInstance(){
        if (instance == null) {
            synchronized (ConditionUtils.class) {
                if(instance==null){
                    instance = new ConditionUtils();
                }
            }
        }
        return instance;
    }

    public Task createTask(String key){
        TxTask task = new TxTask();
        task.setKey(key);
        taskMap.put(key,task);
        return task;
    }

    public Task getTask(String key){
          return   taskMap.get(key);
    }
    public void removeTask(String key){
        if(key != null)
            taskMap.remove(key);
    }
    public boolean hasKey(String key) {
        return taskMap.containsKey(key);
    }


}
