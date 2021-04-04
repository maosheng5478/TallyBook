package com.android.tallybook.utils;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static boolean isSpace(final String s) {
        if (s == null) return true;
        for (int i = 0, len = s.length(); i < len; ++i) {
            if (!Character.isWhitespace(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符串是否位位0.00格式
     * @param str
     * @return
     */
    public static boolean isTwoDecimal(String str) {
        if (StringUtils.existString(str,".")){
            String s = StringUtils.afterString(str,".");
            return s.length() > 1;
        }
        Pattern pattern = Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,1})?$");
        Matcher match = pattern.matcher(str);
        return !match.matches();
    }

    /**
     * 设置字符串位0.00格式
     * @param string
     * @return
     */
    public static String setTwoDecimal(String string){
        BigDecimal big = new BigDecimal(string);
        big = big.setScale(2, BigDecimal.ROUND_DOWN);
        return big.toString();
    }

    /**
     * 判断字符串中是否有某个字符串
     * @param str  传入判断的字符串
     * @param exist 条件字符串
     * @return
     */
    public static boolean existString (String str,String exist){
        return str.contains(exist);
    }

    /**
     * 删除字符串最后一位
     * @param s
     * @return
     */
    public static String minusString(String s){
        return s.substring(0,s.length()-1);
    }

    /**
     * 截取str中key之前的String
     * @param str
     * @param key
     * @return
     */
    public static String beforeString(String str,String key){
        return str.substring(0, str.indexOf(key));
    }

    /**
     * 截取str中key之后的String
     * @param str
     * @param key
     * @return
     */
    public static String afterString(String str,String key){
        return str.substring(beforeString(str,key).length()+1,str.length());
    }

    public static String finalString(String s){
        return s.substring(s.length()-1);
    }
}
