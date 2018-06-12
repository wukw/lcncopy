package com.lcn.copy.dubbofilter;

import com.alibaba.dubbo.rpc.*;

public class DubboTransectionFilter implements Filter {

    public static String groupId ="groupId";

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        String groupId = null;
        RpcContext.getContext().setAttachment("tx-group",groupId);
        return null;
    }
}
