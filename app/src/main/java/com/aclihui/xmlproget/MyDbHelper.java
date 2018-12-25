package com.aclihui.xmlproget;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHelper extends SQLiteOpenHelper {
    private final String DBNAME = "user.db";
    private final String TABLE_NAME = "info";
    //在SQLite里用作特殊标识的要加下划线(主键)
    private final String INFO_COLUM_questionId = "questionId";
    private final String INFO_COLUM_title = "title";
    private final String INFO_COLUM_optionA = "optionA";
    private final String INFO_COLUM_optionB = "optionB";
    private final String INFO_COLUM_optionC = "optionC";

    public MyDbHelper(Context context) {
        //版本号不能为0
        super(context, "user.db", null, 1);
    }

    public MyDbHelper(Context context, String title, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, title, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //如果没有数据库及数据表 就会在OnCreate里自动创建
        StringBuilder sql = new StringBuilder();
        sql.append("Create table if not exists ");
        sql.append(TABLE_NAME + " ( ");
        sql.append(INFO_COLUM_questionId + " varchar(10), ");
        sql.append(INFO_COLUM_title + " varchar(10),");
        sql.append(INFO_COLUM_optionA + " varchar(10),");
        sql.append(INFO_COLUM_optionB + " varchar(10),");
        sql.append(INFO_COLUM_optionC + " varchar(10) ");
        sql.append(" ) ");
        //执行SQL
        db.execSQL(sql.toString());
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //删除表（delete是删除表里的数据）
        String sql = " drop table if exists " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }

}
