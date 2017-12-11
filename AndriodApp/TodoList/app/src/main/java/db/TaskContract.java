package com.aziflaj.todolist.db;

import android.provider.BaseColumns;

public class TaskContract   //Defines constants used to access data in the db
{
    public static final String DB_NAME = "com.aziflaj.todolist.db";
    public static final int DB_VERSION = 1;    //Database needs a table before it can store any tasks.

    public class TaskEntry implements BaseColumns
    {
        public static final String TABLE = "tasks";
        public static final String COL_TASK_TITLE = "title";
    }
}