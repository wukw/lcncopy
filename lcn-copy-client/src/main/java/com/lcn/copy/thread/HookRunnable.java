package com.lcn.copy.thread;

import com.lcn.copy.Constants;

import java.util.concurrent.TimeUnit;

public abstract class HookRunnable implements  Runnable {

    private volatile boolean hasOver;
    @Override
    public void run() {
        Thread thread  = new Thread(){
            @Override
            public void run() {
                Constants.hasExit = true;
                while (!hasOver ){
                    try {
                        TimeUnit.MILLISECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };

        if(!Constants.hasExit){
            Runtime.getRuntime().addShutdownHook(thread);
        }else{
            return ;
        }
        try{
            run0();
        }finally {
            hasOver = true ;
            if(!thread.isAlive()){
                Runtime.getRuntime().removeShutdownHook(thread);
            }
        }


    }

    public abstract void run0();
}
