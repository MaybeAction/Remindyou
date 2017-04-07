package com.pcm.maybe.remindyou.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 创建数据库
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper{
    public MySQLiteOpenHelper(Context context) {
        super(context, "remind", null, 1);
    }
    private static final String CREATE_SAVE_NEWS_TABLE="create table remindyou("+
            "id integer primary key autoincrement,"+
            "context text,"+
            "time text)";
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
            //创建数据库
                sqLiteDatabase.execSQL(CREATE_SAVE_NEWS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public static String getCreateSaveNewsTable(){
        return "remindyou";
    }
}
