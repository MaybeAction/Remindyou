package com.pcm.maybe.remindyou.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pcm.maybe.remindyou.R;
import com.pcm.maybe.remindyou.entity.RemindInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maybe on 2017/3/26.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>{
    private List<RemindInfo> datas;
    private Context context;
    private LayoutInflater inflater;
    private MyRecyclerViewClick myRecyclerViewClick;

    public void setMyRecyclerViewClick(MyRecyclerViewClick myRecyclerViewClick) {
        this.myRecyclerViewClick = myRecyclerViewClick;
    }

    public MyRecyclerViewAdapter(Context context) {
        this.context=context;
        inflater=inflater.from(context);
        datas=new ArrayList<>();
    }
    public void add(List<RemindInfo> list){
            if(datas!=null){
                datas.clear();
            }
            datas.addAll(list);
        notifyDataSetChanged();
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.item_remind_recycleriew,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
                            RemindInfo info=datas.get(position);
                            holder.remindTime.setText(info.getRemindtime());
                            holder.remindContent.setText(info.getRenmidContent());
                            holder.ll_rc.setTag(position);

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView remindTime,remindContent;
        private LinearLayout ll_rc;
        public MyViewHolder(View itemView) {
            super(itemView);
            remindContent= (TextView) itemView.findViewById(R.id.remindContent);
            remindTime= (TextView) itemView.findViewById(R.id.remindTime);
            ll_rc= (LinearLayout) itemView.findViewById(R.id.ll_rc);
            ll_rc.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            myRecyclerViewClick.ItemClick((Integer) view.getTag());
        }

    }

    public interface  MyRecyclerViewClick{
        void ItemClick(int position);
    }
}
