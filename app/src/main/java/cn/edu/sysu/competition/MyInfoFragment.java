package cn.edu.sysu.competition;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by 911 on 2017/12/3.
 */

public class MyInfoFragment extends Fragment implements View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =  LayoutInflater.from(container.getContext()).inflate(R.layout.my_info, container, false);

        return view;
    }

    @Override
    public void onClick(View view) {

    }

}
