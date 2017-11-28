package cn.edu.sysu.competition;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

/**
 * Created by Emilia on 2017/11/27.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private List<Task> mTaskList;

    static class ViewHolder extends  RecyclerView.ViewHolder {
        View taskView;
        TextView taskTitle;
        TextView taskDone;
        TextView taskProcess;

        public ViewHolder(View view) {
            super(view);
            taskView = view;
            taskTitle = (TextView) view.findViewById(R.id.task_title);
            taskDone = (TextView) view.findViewById(R.id.task_done);
            taskProcess = (TextView) view.findViewById(R.id.task_process);
        }
    }

    public TaskAdapter(List<Task> taskList) {
        mTaskList = taskList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);

        // onClick event here

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Task task = mTaskList.get(position);
        holder.taskTitle.setText(task.getContent());
        holder.taskDone.setText("已进行" + task.getDone() + "天");
        holder.taskProcess.setText("完成度" + (task.getDone()
        / task.getGoal()) + "%");
    }

    @Override
    public int getItemCount() {
        return mTaskList.size();
    }
}
