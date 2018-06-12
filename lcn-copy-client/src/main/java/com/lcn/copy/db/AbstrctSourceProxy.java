package com.lcn.copy.db;

import com.lcn.copy.bean.TxTransactionLocal;
import com.lcn.copy.task.Task;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstrctSourceProxy<C,T extends  IResource> implements  IBaseProxy  {
    protected Map<String, T> pools = new ConcurrentHashMap<>();


    protected  volatile  int maxCount = 4;
    // second
    protected  volatile  int maxWaitTime = 30;

    protected  volatile  int nowCount = 0;

    protected  ICallClose<T> subNowount = new ICallClose<T>() {
        @Override
        public void close(T connection) {
           Task task =  connection.getWaitTask();
           if(task != null ) {
               if (!task.isRemove(task.getKey())) {
                   task.removeTask();
               }
               pools.remove(connection.getGroupId());
           }
           nowCount -- ;
        }
    };

    protected abstract C createLcnConnection(C connection, TxTransactionLocal txTransactionLocal);


    public T loadConnetion(){
     TxTransactionLocal txTransactionLocal =    TxTransactionLocal.getCurr();
         if(txTransactionLocal == null){
             return null;
         }
         T old = pools.get(txTransactionLocal.getGroupId());
         if(old != null){
             old.setHasIsGroup(true);
             //添加补偿组件
             old.addCompensate(txTransactionLocal.getTransactionRecover());
             txTransactionLocal.setHasGroupId(true);
             TxTransactionLocal.setCurr(txTransactionLocal);
         }
         return old;


    }

    private   C createConnection(C connection, TxTransactionLocal txTransactionLocal)  {
        if(nowCount < maxCount){
            return createLcnConnection(connection,txTransactionLocal);
        }else if(nowCount == maxCount){
            for(int i = 0;i< maxWaitTime ; i++){
                for(int j = 0;j<100;j++) {
                    try {
                        Thread.sleep(10);
                    }catch (Exception e){

                    }
                    if (nowCount < maxCount) {
                        return createLcnConnection(connection, txTransactionLocal);
                    }
                }
            }
        }
        else{
            System.out.println("connetion was over");
            return null;
        }
        return null;
    }


    protected abstract void initDbType();

    public C InitConnetion(C connection){
        C lcnConnection = connection;
        TxTransactionLocal txTransactionLocal = TxTransactionLocal.getCurr();
        if(txTransactionLocal  != null){
            if(txTransactionLocal.isReadOnly()){
                return connection;
            }else if(txTransactionLocal.isHasStart() ){
                lcnConnection = createConnection(connection,txTransactionLocal);
            }


        }
        return lcnConnection;
    }



}
