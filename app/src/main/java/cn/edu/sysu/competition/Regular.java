package cn.edu.sysu.competition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular {
    private static final String userPattern = "^[a-zA-Z]\\w{6,10}$";//英文开头长度为6-10用户名
    private static final String mailPattern = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    private static final String psdPattern = "^[a-zA-Z0-9]{6,16}$";//不含特殊字符6-16位密码

    public boolean validUsername(String username) {
        Pattern pattern = Pattern.compile(userPattern);
        Matcher m = pattern.matcher(username);
        return m.matches();
    }

    public boolean validMailbox(String mailbox) {
        Pattern pattern = Pattern.compile(mailPattern);
        Matcher m = pattern.matcher(mailbox);
        return m.matches();
    }

    public boolean validPassword(String password) {
        Pattern pattern = Pattern.compile(psdPattern);
        Matcher m = pattern.matcher(password);
        return m.matches();
    }

    public boolean samePassword(String psd, String confirmPsd) {
        return psd.equals(confirmPsd);
    }
}