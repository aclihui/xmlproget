package com.aclihui.xmlproget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    private Button search2;
    private EditText questionId;
    TextView t1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        search2 = (Button) findViewById(R.id.button6);
        questionId = (EditText) findViewById(R.id.editText7);
        t1 = (TextView) findViewById(R.id.textView10);
        search2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str = questionId.getText().toString();
                Question question = MainActivity.questionDao.searchquestion(str);
                t1.setText(question.toString());
               Toast.makeText(getBaseContext(), "查询成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
