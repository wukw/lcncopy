package com.lcn.copy.intercept;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransecionAsepct {
    @Autowired
    TransectionInterpt transectionInterpt ;



    @Around("@annotation(com.lcn.copy.annotation.TXTransecation)")
    public Object TransectionAround(ProceedingJoinPoint pj){
        transectionInterpt.around(pj);
        return  null;

    }


}
