package com.example.ezchat;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View;

import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
    private List<Msg> mMsgList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout left;
        LinearLayout right;
        TextView leftMsg;
        TextView rightMsg;
        public ViewHolder(View view){
            super(view);
            left=(LinearLayout)view.findViewById(R.id.left_view);
            right=(LinearLayout)view.findViewById(R.id.right_view);
            leftMsg=(TextView)view.findViewById(R.id.left_msg);
            rightMsg=(TextView)view.findViewById(R.id.right_msg);
        }
    }
    public MsgAdapter(List<Msg> msgList){
       mMsgList=msgList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item,parent,false);
       return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Msg msg=mMsgList.get(position);
        if(msg.getType()==0){
            holder.left.setVisibility(View.VISIBLE);
            holder.right.setVisibility(View.GONE);
            holder.leftMsg.setText(msg.getContent());
        }
        else if(msg.getType()==1){
            holder.left.setVisibility(View.GONE);
            holder.right.setVisibility(View.VISIBLE);
            holder.rightMsg.setText(msg.getContent());
        }
    }
    @Override
    public int getItemCount(){
        return mMsgList.size();
    }
}
