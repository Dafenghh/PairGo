package cn.edu.sysu.competition;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 911 on 2017/12/3.
 */

public class ChatListFragment extends Fragment implements View.OnClickListener{

    private List<Task> taskList = TaskListFragment.getTaskList();
    private ViewGroup mContainer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =  LayoutInflater.from(container.getContext()).inflate(R.layout.chat_list, container, false);

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.chat_recycler);
        ChatAdapter adapter = new ChatAdapter(taskList);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        recyclerView.setAdapter(adapter);

        mContainer = container;
        return view;
    }

    @Override
    public void onClick(View view) {

    }

}
