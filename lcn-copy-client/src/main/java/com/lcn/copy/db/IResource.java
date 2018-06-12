package com.lcn.copy.db;

import com.lcn.copy.compensate.TransactionRecover;
import com.lcn.copy.task.TxTask;

import java.util.List;

public interface IResource<T> {
    void close() throws Exception;

    TxTask getWaitTask();

    String getGroupId();

    void transaction() throws Exception;

    void setHasIsGroup(boolean isGroup);

    void addCompensate(TransactionRecover recover);

    T get();

    List<TransactionRecover> getCompensateList();

    int getMaxOutTime();

}
