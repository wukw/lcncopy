package com.lcn.copy.service.impl;

import com.lcn.copy.bean.TxTransactionLocal;
import com.lcn.copy.annotation.TXTransecation;
import com.lcn.copy.service.AspectBeforeService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class AspectBeforeServiceImpl implements AspectBeforeService {

    /**
     * 创建事物消息 创建事物服务
     * @param pj
     * @param groupId
     * @return
     */
    @Override
    public Object before(ProceedingJoinPoint pj, String groupId) {

        MethodSignature methodSignature =(MethodSignature) pj.getSignature();
        Method method = methodSignature.getMethod();
        TXTransecation txTransecation = method.getAnnotation(TXTransecation.class);



        TxTransactionLocal local = TxTransactionLocal.getCurr();

        return null;
    }
}
