package com.lcn.copy.compensate;

public class  TxTransactionCompensate  {



    public static ThreadLocal<TxTransactionCompensate> local = new ThreadLocal<>();

    public static TxTransactionCompensate getCurr(){
        return local.get();
    }
    public static void setCurr(TxTransactionCompensate txTransactionCompensate){
         local.set(txTransactionCompensate);
    }





}
