package com.webuzz.intelligent.model.db;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = WebuzzDB.NAME, version = WebuzzDB.VERSION)
public final class WebuzzDB {
    public static final String NAME = "AppDatabase";

    public static final int VERSION = 1;
}
