package com.lcn.copy.db;

import org.aspectj.lang.ProceedingJoinPoint;

import java.sql.Connection;

public interface IConnection {
    Connection getConnection(ProceedingJoinPoint pj);
}
