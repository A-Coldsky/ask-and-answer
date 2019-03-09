package com.example.ezchat;

import android.os.TestLooperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Msg> msgList=new ArrayList<>();
    private Button sendbutton;
    private TextView editview;
    private RecyclerView message;
    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsgs();
        editview=(EditText)findViewById(R.id.input_text);
        sendbutton=(Button)findViewById(R.id.send);
        message=(RecyclerView)findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        message.setLayoutManager(layoutManager);
        adapter=new MsgAdapter(msgList);
        message.setAdapter(adapter);
        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content=editview.getText().toString();
                if (!"".equals(content)){
                    Msg link=new Msg(content,1);
                    msgList.add(link);
                    adapter.notifyItemInserted(msgList.size()-1);
                    message.scrollToPosition(msgList.size()-1);
                    editview.setText("");
                }
            }
        });
    }
    private void initMsgs(){
        Msg msg1=new Msg("hello",0);
        msgList.add(msg1);
        Msg msg2=new Msg("hi",1);
        msgList.add(msg2);
        Msg msg3=new Msg("how are you",0);
        msgList.add(msg3);
    }
}
