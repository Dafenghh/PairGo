package cn.edu.sysu.competition;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewAdapter pagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<View> list = new ArrayList<>();
        viewPager = (ViewPager)findViewById(R.id.welcome_pager);
        LayoutInflater inflater = LayoutInflater.from(this);
        View view1 = inflater.inflate(R.layout.login_page, null);
        View view2 = inflater.inflate(R.layout.main_page, null);
        View view3 = inflater.inflate(R.layout.signin_page, null);
        list.add(view1);
        list.add(view2);
        list.add(view3);
        pagerAdapter = new ViewAdapter(list);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(1);

        view2.findViewById(R.id.log_in).setOnClickListener(this);
        view2.findViewById(R.id.sign_in).setOnClickListener(this);
        view1.findViewById(R.id.login_do).setOnClickListener(this);
        view1.findViewById(R.id.login_cancel).setOnClickListener(this);
        view3.findViewById(R.id.signin_do).setOnClickListener(this);
        view3.findViewById(R.id.signin_cancel).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.log_in:
                viewPager.setCurrentItem(0, true);
                break;
            case R.id.sign_in:
                viewPager.setCurrentItem(2, true);
                break;
            case R.id.login_cancel:case R.id.signin_cancel:
                viewPager.setCurrentItem(1, true);
                break;
            case R.id.login_do:case R.id.signin_do:
                Intent intent = new Intent(MainActivity.this, HomePage.class);
                startActivity(intent);
            default:
                break;
        }
    }
}
