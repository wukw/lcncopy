package com.lcn.copy.task;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TaskGroupManager {

    public static TaskGroupManager taskGroupManager = new TaskGroupManager();


    private Map<String, TaskGroup> taskMap = new ConcurrentHashMap<String, TaskGroup>();

    public TaskGroupManager  getInstance(){
        return taskGroupManager;
    }
}
