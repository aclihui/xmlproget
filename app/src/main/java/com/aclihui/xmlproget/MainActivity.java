package com.aclihui.xmlproget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText questionId,title, optionA, optionB,optionC;
    private Button insert, search, delete, update;
    public static QuestionDao questionDao;
    private Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionId = (EditText) findViewById(R.id.editText);
        title = (EditText) findViewById(R.id.editText2);
        optionA = (EditText) findViewById(R.id.editText3);
        optionB = (EditText) findViewById(R.id.editText5);
        optionC = (EditText) findViewById(R.id.editText6);
        search = (Button) findViewById(R.id.button4);
        insert = (Button) findViewById(R.id.button);
        delete = (Button) findViewById(R.id.button2);
        update = (Button) findViewById(R.id.button3);
        questionDao = new QuestionDao(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Question question = new Question();
                question.setquestionId(questionId.getText().toString());
                question.settitle(title.getText().toString());
                question.setoptionA(optionA.getText().toString());
                question.setoptionB(optionB.getText().toString());
                question.setoptionC(optionC.getText().toString());
                questionDao.insert(question);
                Toast.makeText(getBaseContext(), "xml数据新增成功", Toast.LENGTH_SHORT).show();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String str = questionId.getText().toString();
                Question question = questionDao.searchquestion(str);
                question.settitle(title.getText().toString());
                question.setoptionA(optionA.getText().toString());
                question.setoptionB(optionB.getText().toString());
                question.setoptionC(optionC.getText().toString());
                questionDao.update(question);
                Toast.makeText(getBaseContext(), "xml文件修改成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
