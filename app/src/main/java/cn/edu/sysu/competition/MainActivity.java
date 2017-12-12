package cn.edu.sysu.competition;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import cn.edu.sysu.competition.Regular;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewAdapter pagerAdapter;
    private ViewPager viewPager;
    private Regular regular;
//    private BlurUtil blurUtil;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        regular = new Regular();
//        blurUtil = new BlurUtil();
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
            case R.id.login_cancel:
                setLoginEmpty(view);
                viewPager.setCurrentItem(1, true);
                break;
            case R.id.signin_cancel:
                setSignInEmpty(view);
                viewPager.setCurrentItem(1, true);
                break;
            case R.id.login_do:
                String result1 = check1(view);
                if (result1.equals("match")) {
                    Intent intent = new Intent(MainActivity.this, HomePage.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, result1, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.signin_do:
                String result2 = check2(view);
                if (result2.equals("right")) {
                    Intent intent2 = new Intent(MainActivity.this, HomePage.class);
                    startActivity(intent2);
                    //传注册数据
                } else {
                    Toast.makeText(MainActivity.this, result2, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    public String check1(View view) {
        String valid = "match";
        Toast.makeText(MainActivity.this, valid, Toast.LENGTH_SHORT).show();
        View parent = (View) view.getParent().getParent();
        String username, password;
        EditText userText = (EditText) parent.findViewById(R.id.username);
        EditText psdText = (EditText) parent.findViewById(R.id.password);
        username = userText.getText().toString();
        password = psdText.getText().toString();
//        if (username.equals(data)) {
//            if (password.equals(data)) {
//                return valid;
//            } else {
//                return "密码错误"；
//            }
//        } else {
//            return "用户不存在";
//        }
        return valid;
    }

    public String check2(View view) {
        String valid = "valid";
        View parent = (View) view.getParent().getParent();
        String username, mailbox, password, confirmpsd;
        EditText userText = (EditText) parent.findViewById(R.id.username);
        EditText mailText = (EditText) parent.findViewById(R.id.mailbox);
        EditText psdText = (EditText) parent.findViewById(R.id.password);
        EditText confirmPsdText = (EditText) parent.findViewById(R.id.confirmPassword);
        username = userText.getText().toString();
        mailbox = mailText.getText().toString();
        password = psdText.getText().toString();
        confirmpsd = confirmPsdText.getText().toString();
        if (!regular.validUsername(username)) {
            valid = "用户名长度在6-10且以英文字母开头";
        } else if (!regular.validMailbox(mailbox)) {
            valid =  "邮箱含有非法字符";
        } else if (!regular.validPassword(password)) {
            valid = "密码长度在6-16且不含非法字符";
        } else if (!regular.samePassword(password, confirmpsd)) {
            valid = "密码不一致";
        }
        if (valid.equals("valid")) {
            userText.setText("");
            mailText.setText("");
            psdText.setText("");
            confirmPsdText.setText("");
            return "right";
        } else {
            return valid;
        }
    }

    public void setLoginEmpty(View view) {
        View parent = (View) view.getParent().getParent();
        EditText userText = (EditText) parent.findViewById(R.id.username);
        EditText psdText = (EditText) parent.findViewById(R.id.password);
        userText.setText("");
        psdText.setText("");
    }

    public void setSignInEmpty(View view) {
        View parent = (View) view.getParent().getParent();
        EditText userText = (EditText) parent.findViewById(R.id.username);
        EditText mailText = (EditText) parent.findViewById(R.id.mailbox);
        EditText psdText = (EditText) parent.findViewById(R.id.password);
        EditText confirmPsdText = (EditText) parent.findViewById(R.id.confirmPassword);
        userText.setText("");
        mailText.setText("");
        psdText.setText("");
        confirmPsdText.setText("");
    }
}