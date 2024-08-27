package vip.hoode.jpa.repository.support;

import vip.hoode.jpa.entity.support.EntityState;

public final class Queries {

    private Queries() {

    }

    public static final String DELETE_COLUMN_NAME = "is_deleted";
    public static final String DELETE_FIELD_NAME = "isDeleted";

    // --- SQL BEGIN---
    public static final String INVALID_ALL_SQL = "update #{#entityName} set " + DELETE_FIELD_NAME + " = '" + EntityState.INVALID_STATE + "'";
    public static final String INVALID_SQL = INVALID_ALL_SQL + " where id = :id";
    public static final String CHECK_VALID_SQL = DELETE_COLUMN_NAME + " <> '" + EntityState.INVALID_STATE + "'";
    // --- SQL END---


}
