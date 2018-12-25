package com.aclihui.xmlproget;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class QuestionDao {
    private MyDbHelper myDbHelper;
    public  QuestionDao(Context context) {
        myDbHelper = new MyDbHelper(context);
    }

    //插入数据
    public void insert(Question question) {
        //得到一个可写的数据库
        SQLiteDatabase db = myDbHelper.getWritableDatabase();
        //ContentValues 键值的用法   key要跟列名一致
        ContentValues cv = new ContentValues();
        cv.put("questionId", question.getquestionId());
        cv.put("title", question.gettitle());
        cv.put("optionA", question.getoptionA());
        cv.put("optionB", question.getoptionB());
        cv.put("optionC", question.getoptionC());
        db.insert("info", null,cv);
        db.close();
    }

    //查询一条数据
    public Question searchquestion(String id) {
        SQLiteDatabase db = myDbHelper.getReadableDatabase();
        // ?为占位符  用下一个参数来匹配
        Cursor cs = db.query("info", null, "questionId = ? ", new String[]{id}, null, null, null);
        Question question = null;
        if (cs.moveToNext()) {
            question = new  Question();
            question.setquestionId(cs.getString(cs.getColumnIndex("questionId")));
            question.settitle(cs.getString(cs.getColumnIndex("title")));
            question.setoptionA(cs.getString(cs.getColumnIndex("optionA")));
            question.setoptionB(cs.getString(cs.getColumnIndex("optionB")));
            question.setoptionC(cs.getString(cs.getColumnIndex("optionC")));
        }
        cs.close();
        db.close();
        return question;
    }

    //删除一条数据
    public void deleteQuestion(String id) {
        SQLiteDatabase db = myDbHelper.getWritableDatabase();
        db.delete("info", "questionId= ? ", new String[]{id});
        db.close();
    }

    //修改数据
    public void update(Question question) {
        SQLiteDatabase db = myDbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("title", question.gettitle());
        cv.put("optionA", question.getoptionA());
        cv.put("optionB", question.getoptionB());
        cv.put("optionC", question.getoptionC());
        String id = String.valueOf( question.getquestionId());
        db.update("info", cv, "questionId= ? ", new String[]{id});
        db.close();
    }
}
