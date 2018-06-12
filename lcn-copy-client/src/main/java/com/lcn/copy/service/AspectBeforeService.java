package com.lcn.copy.service;

import org.aspectj.lang.ProceedingJoinPoint;

public interface AspectBeforeService {

    public Object before(ProceedingJoinPoint pj,String groupId);
}
