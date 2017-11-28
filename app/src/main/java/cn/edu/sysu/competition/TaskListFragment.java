package cn.edu.sysu.competition;

import android.app.Fragment;
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

public class TaskListFragment extends Fragment {

    private List<Task> taskList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_list, container, false);
        Task exampleTask1 = new Task(0,0,0, false
        , "示例任务", 1, 2);
        taskList.add(exampleTask1);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.task_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        TaskAdapter adapter = new TaskAdapter(taskList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
