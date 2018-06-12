package com.lcn.copy.db.relational;

import com.lcn.copy.thread.HookRunnable;

import java.sql.SQLException;

public abstract class AbstractTransactionThread {

    private volatile boolean hasStartTransaction = false;

    public void startRunable(){
        if(hasStartTransaction){
            if(hasStartTransaction ){
                return ;
            }
            hasStartTransaction = true;
            Runnable runnable = new HookRunnable() {
                @Override
                public void run0() {
                    try {
                        transaction();
                    } catch (Exception e) {
                        try {
                            rollbackConnection();
                        }catch (Exception e2){
                            e2.printStackTrace();
                        }
                    } finally {
                        try {
                            closeConnection();
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                    }
                }

            };
        }
    }


    protected abstract void transaction() throws SQLException;

    protected abstract void closeConnection() throws SQLException;

    protected abstract void rollbackConnection() throws SQLException;
}
