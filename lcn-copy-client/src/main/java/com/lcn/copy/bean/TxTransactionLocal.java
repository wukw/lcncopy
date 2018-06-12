package com.lcn.copy.bean;

import com.lcn.copy.compensate.TransactionRecover;
import org.springframework.transaction.annotation.Transactional;

public class TxTransactionLocal {

    private String groupId;

    private boolean isHasroupId;

    private boolean isReadOnly;

    private boolean hasStart = false;

    private int maxTimeOut ;


    Transactional transactional;

    TransactionRecover transactionRecover ;


    public static ThreadLocal<TxTransactionLocal> currlocal = new InheritableThreadLocal();

    public static TxTransactionLocal getCurr(){
        return currlocal.get();
    }

    public String getGroupId(){
        return groupId;
    }

    public void setHasGroupId(boolean isHasroupId ){
         this.isHasroupId = isHasroupId;
    }

    public static  void setCurr(TxTransactionLocal t){
        currlocal.set(t);

    }

    public void setTransactionRecover(TransactionRecover transactionRecover){
        this.transactionRecover = transactionRecover;
    }

    public TransactionRecover getTransactionRecover(){
        return transactionRecover;
    }

    public boolean isReadOnly() {
        return isReadOnly;
    }

    public boolean isHasStart() {
        return hasStart;
    }

    public void setHasStart(boolean hasStart) {
        this.hasStart = hasStart;
    }

    public void setReadOnly(boolean readOnly) {
        isReadOnly = readOnly;
    }

    public void setTransectional(Transactional Transactional){
        this.transactional = transactional;
        if(Transactional == null){
            isReadOnly = false;
        }else{
            isReadOnly = true;
        }

    }

    public int getMaxTimeOut() {
        return maxTimeOut;
    }

    public void setMaxTimeOut(int maxTimeOut) {
        this.maxTimeOut = maxTimeOut;
    }
}
