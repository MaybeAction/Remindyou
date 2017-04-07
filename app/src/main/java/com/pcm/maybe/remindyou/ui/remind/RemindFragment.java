package com.pcm.maybe.remindyou.ui.remind;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pcm.maybe.remindyou.R;
import com.pcm.maybe.remindyou.db.MySQLiteDB;
import com.pcm.maybe.remindyou.adapter.MyRecyclerViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class RemindFragment extends Fragment implements MyRecyclerViewAdapter.MyRecyclerViewClick {
    private MySQLiteDB db;
    private RecyclerView recyclerView;
    private MyRecyclerViewAdapter adapter;

    public RemindFragment() {
        db = new MySQLiteDB();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_remind, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
            db.qureSQLForRemind(getContext());
    }

    private void initView(View view) {
        adapter=new MyRecyclerViewAdapter(getContext());
        recyclerView= (RecyclerView) view.findViewById(R.id.rc);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        adapter.setMyRecyclerViewClick(this);
        db=new MySQLiteDB();
    }


    @Override
    public void ItemClick(int position) {
    }
}
