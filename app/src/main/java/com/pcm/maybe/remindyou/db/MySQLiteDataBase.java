package com.pcm.maybe.remindyou.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.pcm.maybe.remindyou.entity.RemindInfo;

/**
 * Created by maybe on 2017/3/26.
 */

public class MySQLiteDataBase {
    private static MySQLiteOpenHelper mySQLiteOpenHlper;

    public static void insertNews(Context context, RemindInfo info){
        //实例化MySQLiteOpenHelper对象，并不是创建数据库
        mySQLiteOpenHlper=new MySQLiteOpenHelper(context);
        //实例化SQLiteDatabase对象 并创建数据库
        SQLiteDatabase db=mySQLiteOpenHlper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("content",info.getRenmidContent());
        values.put("time",info.getRemindtime());
        //向数据库中插入一条数据
        db.insert(MySQLiteOpenHelper.getCreateSaveNewsTable(),null,values);
    }

}
