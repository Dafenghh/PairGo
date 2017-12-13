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
 * Created by Emilia on 2017/11/27.
 */

public class TaskListFragment extends Fragment implements View.OnClickListener{

    static private List<Task> taskList = new ArrayList<>();
    private ViewGroup mContainer;
    private TaskAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =  LayoutInflater.from(container.getContext()).inflate(R.layout.task_list, container, false);

        taskList.clear();
        Task exampleTask1 = new Task(0, R.drawable.example1, R.drawable.example2, false
        , "跑步","游泳", 1, 1, 2, 2);
        Task exampleTask2 = new Task(0,R.drawable.example1, R.drawable.example2, false
                ,"背单词","学JAVA", 17, 15, 36, 36);
        taskList.add(exampleTask1);
        taskList.add(exampleTask2);

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.task_recycler);
        adapter = new TaskAdapter(taskList);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        recyclerView.setAdapter(adapter);

        mContainer = container;
        View addButton = view.findViewById(R.id.add_task_button);
        addButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.add_task_button:
                Intent intent = new Intent(mContainer.getContext(), CreateTask.class);
                startActivity(intent);
                break;

        }
    }

    static public List<Task> getTaskList() {
        return taskList;
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}
