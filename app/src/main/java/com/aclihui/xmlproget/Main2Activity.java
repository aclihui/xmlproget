package com.aclihui.xmlproget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private Button delete2;
    private EditText questionId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        delete2 = (Button) findViewById(R.id.button5);
        questionId = (EditText) findViewById(R.id.editText4);
        delete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String str = questionId.getText().toString();
              MainActivity.questionDao.deleteQuestion(str);
               Toast.makeText(getBaseContext(), "xml数据删除成功"+str, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
