package com.pcm.maybe.remindyou.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.pcm.maybe.remindyou.entity.RemindInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * 对数据库进行操作
 */

public class MySQLiteDB {
    private RemindInfo info;
    private MySQLiteOpenHelper mySQLiteOpenHlper;
    private List<RemindInfo> list;

    public List<RemindInfo> qureSQLForRemind(Context context){
        list=new ArrayList<>();
        //如果集合有数据就先清空集合
        if (list != null) {
            list.clear();
        }
        mySQLiteOpenHlper=new MySQLiteOpenHelper(context);
        SQLiteDatabase db=mySQLiteOpenHlper.getWritableDatabase();
        String str="select * from remindyou";
        Cursor c=db.rawQuery(str,null);
        //遍历
        if(c.moveToFirst()){
                info=new RemindInfo();
            do{
                String content=c.getString(c.getColumnIndex("content"));
                String time=c.getString(c.getColumnIndex("time"));
                info.setRenmidContent(content);
                info.setRemindtime(time);
                list.add(info);
            }while (c.moveToNext());
            c.close();
        }
        return list;
    }

}
