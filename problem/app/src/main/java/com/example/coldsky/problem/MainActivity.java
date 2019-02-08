package com.example.coldsky.problem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button truebutton;
    private Button falsebutton;
    private Button nextbutton;
    private TextView ToFV;
    private int proid=0;
    public class question{
        private int viewid;
        private boolean answer;
        public question(int viewid,boolean answer){
            this.viewid=viewid;
            this.answer=answer;
        }
        public int getViewid(){
            return viewid;
        }
        public boolean getanswer(){
            return answer;
        }
    }
    private question[] questionbank=new question[]{
            new question(R.string.q1,true),
            new question(R.string.q2,true),
            new question(R.string.q3,true),
    };
    private void nextquestion(){
        int questionid=questionbank[proid].getViewid();
        ToFV.setText(questionid);
    }
    private void istrue(boolean userflag){
        boolean flag=questionbank[proid].getanswer();
        if(userflag==flag)
            Toast.makeText(MainActivity.this,R.string.right,Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this,R.string.wrong,Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        truebutton=(Button)findViewById(R.id.true_button);
        falsebutton=(Button)findViewById(R.id.false_button);
        nextbutton=(Button)findViewById(R.id.next_button);
        ToFV=(TextView)findViewById(R.id.question_view);
        nextquestion();
        truebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                istrue(true);
                proid=(proid+1)%questionbank.length;
                nextquestion();
            }
        });
        falsebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                istrue(false);
            }
        });
        nextbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                proid=(proid+1)%questionbank.length;
                nextquestion();
            }
        });
    }
}
