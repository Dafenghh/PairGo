package cn.edu.sysu.competition;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    private TaskListFragment taskListFragment;
    private ChatListFragment chatListFragment;
    private MyInfoFragment myInfoFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    transaction = fragmentManager.beginTransaction();
                    if (taskListFragment == null) {
                        taskListFragment = new TaskListFragment();
                    }
                    transaction.replace(R.id.frame_layout, taskListFragment);
                    transaction.commit();

                    return true;

                case R.id.navigation_dashboard:
                    transaction = fragmentManager.beginTransaction();
                    if (chatListFragment == null) {
                        chatListFragment = new ChatListFragment();
                    }
                    transaction.replace(R.id.frame_layout, chatListFragment);
                    transaction.commit();
                    return true;

                case R.id.navigation_notifications:
                    transaction = fragmentManager.beginTransaction();
                    if (myInfoFragment == null) {
                        myInfoFragment = new MyInfoFragment();
                    }
                    transaction.replace(R.id.frame_layout, myInfoFragment);
                    transaction.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        setDefaultFragment();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void setDefaultFragment() {
        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();
        taskListFragment = new TaskListFragment();
        transaction.replace(R.id.frame_layout, taskListFragment);
        transaction.commit();
    }

}
