package com.lcn.copy.intercept;

import com.alibaba.dubbo.rpc.RpcContext;
import com.lcn.copy.dubbofilter.DubboTransectionFilter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class TransectionInterpt {
    /**
     * 进行事物拦截,获取rpc传递中的groupId
     * @param pj
     * @return
     */
    public  Object around(ProceedingJoinPoint pj){
        //获取rpc传递的事物id
        String groupId = RpcContext.getContext().getAttachment(DubboTransectionFilter.groupId);
        return  null;
    }
}
