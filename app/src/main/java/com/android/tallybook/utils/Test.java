package com.android.tallybook.utils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        String s = "bitcoin take over the world maybe who knows perhaps";
        String result="";
        //whoLikesIt("Mafx", "John", "Mark");
        //System.out.println( decode( "morseCode")+"44");
        System.out.println(comp1(new int[]{2,2,3},new int[]{4,9,9}));
    }
    public static String high(String s) {
        // Your code here... 96
        int score = 0,max = 0;
        String[] strings = s.split("\\s+");
        String result = strings[0];
        for (String s1 : strings){
            char[] chars = s1.toCharArray();
            score = 0;
            for (char c : chars){
                score = score+c-96;
            }
            if (score > max){
                max = score;
                result = s1;
            }
        }
        return result;
    }
    public static int findOdd(int[] odd){
        for(int num : odd){
            if(num % 2 != 0){
                return num;
            }
        }
        return 0;
    }
    public static boolean comp1(int[] a, int[] b) {
        //判断数组是否为null 不判断会报错
        if(a==null||b==null){
            return false;
        }
        //变量求数组a中所有数的平方的和
        int sum1 = 0;
        //求数组b中所有数的和
        int sum2 = 0;
        //遍历数组b求和
        for (int value : b) {
            sum2 += value;
        }
        //遍历数组a
        for (int value : a) {
            //定义标记
            int tem = 0;
            //获得平方
            int aa = value * value;
            //将平方累加
            sum1 += aa;
            for (int j = 0; j < b.length; j++) {
                //判断是否存在符合条件的数据
                System.out.println(b[j]);
                if (aa == b[j]) {
                    //判断标记确保执行一次
                    if (tem == 0) {
                        //标记
                        tem++;
                        //将符合条件的数据置为无效,避免重复
                        b[j] = b[j] + 1;
                        System.out.println(b[j]+"----2");
                    }
                }
            }
            System.out.println("1____________");
            //判断标记,若没有标记返回false
            if (tem == 0) {

                return false;
            }
        }
        System.out.println("2____________");
        //判断数据总体的合法性
        return sum1 == sum2;
        //以上条件都通过则返回true
    }
    public static boolean comp(int[] a, int[] b) {
        int count = 0,sumA = 0,sumB = 0;
        if(a == null || b == null){
            return false;
        }
        System.out.println(b[1]);
        System.out.println(Arrays.toString(a)+"\n"+Arrays.toString(b));
        for(int arryB : b){
            sumB += arryB;
            for(int arryA : a){
                sumA += arryA;
                System.out.println(arryA*arryA+" "+arryB);
                if(arryA*arryA == arryB){
                    count++;
                    break;
                }
            }
        }
       System.out.println(count == b.length);
        return count == b.length;
    }
    public static String decode(String morseCode) {
        // your brilliant code here, remember that you can access the preloaded Morse code table through MorseCode.get(code)
        String[] word = morseCode.split(" {3}") ;
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder.toString()+"333");
        for (String s : word) {
            for (String str : s.split(" ")){
                stringBuilder.append(str.isEmpty() ? "" :"");
            }

            //letter[i] = MorseCode.get(word[i]);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().replace("null","");
    }
    public static int rowSumOddNumbers(int n) {
        //TODO
        int a = 0 ;
        int sum = 0;
        a=(n-1)*n+1;
        for(int j=1;j<=n;j++){
            sum+=a;
            a=a+2;
        }
        return a;
    }
    
    static String toCamelCase(String s){
        String[] strings = new String[]{};

      if (s.contains("-")){
          strings = s.split("-");
      }else if (s.contains("_")){
          strings = s.split("_");
      }else if(s.isEmpty()){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder().append(strings[0]);
      for (int i = 1;i < strings.length;i++){
          stringBuilder.append(strings[i].substring(0, 1).toUpperCase())
                  .append(strings[i].substring(1));
      }
        return stringBuilder.toString();
    }
    public static double findUniq(double[] arr) {
        // Do the magic
        for (double value : arr) {
            int count = 0;
            for (double v : arr) {
                if (value == v) {
                    count++;
                }
                if(count > 1){
                    break;
                }
            }
            if (count == 1) {
                return value;
            }
        }
        return arr[0];
    }
    public static boolean getXO (String str) {

        // Good Luck!!
        str = str.toLowerCase();

        Map<Character,Integer> map = new HashMap<Character, Integer>();
        for (int i = 0;i < str.length();i++){
            char c = str.charAt(i);
            if (map.get(c) != null){
                map.put(c,map.get(c) + 1);
            }else {
                map.put(c,1);
            }
        }
        for (Map.Entry entry :map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());

        } if (map.get('x') == map.get('o')){
            return true;
        }else if (map.get('x') == null || map.get('o') == null){
            return false;
        }
        return false;
    }
    public static String whoLikesIt(String... names) {
        //Do your magic here
        System.out.println(names[1]);
        return names.length > 3 ? names[0] +
                "," +
                names[1] +
                " and " +
                (names.length - 2) +
                "others like this" :(names.length > 2 ? names[0] +
                "," +
                names[1] +
                " and " +
                names[2] +
                " like this" : (names.length > 1 ? names[0] +
                " and " +
                names[1] +
                " like this" : (names.length > 0 ? names[0] +
                " like this" :  "no one likes this") ) );
    }
    public static String spinWords(String sentence) {
        //TODO: Code stuff here
        String[] str = sentence.split("\\s+");
        StringBuilder result = new StringBuilder();
        int i = 0;
        for (String s : str) {
            System.out.println(!s.equals(str[str.length-1]));
            if (i != str.length-1){
                if (s.length() >= 5) {
                    result.append(new StringBuilder(s).reverse().toString()).append(" ");
                } else {
                    result.append(s).append(" ");
                }
            }else {
                if (s.length() >= 5) {
                    result.append(new StringBuilder(s).reverse().toString());
                } else {
                    result.append(s);
                }
            }
            i++;
            /*result.append(new StringBuilder(s).reverse().toString());*/
        }
        return result.toString();
    }
    public static String disemvowel(String str) {
        // Code away...
        String result = str;
        String[] yuan = new String[]{"a","e","i","o","u","A","E","I","O","U"};
        for (String s : yuan) {
            System.out.println(s);
            result = result.replace(s, "");
            System.out.println(result);
        }
        for (int i=0;i <= yuan.length;i++){
            System.out.println(i);
        }
        return result;
    }
}
