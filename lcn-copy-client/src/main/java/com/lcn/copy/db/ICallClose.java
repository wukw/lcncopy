package com.lcn.copy.db;

public interface ICallClose<T> {
    void close(T resource);

}
