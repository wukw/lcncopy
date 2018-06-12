package com.lcn.copy.db.relational;

import com.lcn.copy.db.IResource;

import java.sql.Connection;

public interface LCNConnection  extends Connection ,IResource<Connection>{
}
