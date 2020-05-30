package com.example.demo.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author 阿康
 * @date 2020/5/30 17:14
 * @ClassName: StringReverse
 * @description: 反转字符串
 */
@SuppressWarnings("ALL")
public class StringReverse {

    public static void main(String[] args) {
        StringReverse reverse = new StringReverse();
        reverse.reverseWithStringBuilderBuiltinMethod("ABCDEFG");

        String str = "javaGuides";
        str = reverseStack(str);
        System.out.println("Reverse of the given string is : " + str);

        String strSubstring = "javaguides";
        strSubstring = reverseSubstring(strSubstring);
        System.out.println("Reverse of the given string is : " + strSubstring);

        String strRecursion = "abc";
        String s = reverseRecursion(strRecursion);
        System.out.println(s);
    }


    /**
     *  1.使用 + (String连接) 操作符(charAt)
     *  说明:使用charAt截取字符串字符,从第string.length()个开始截取,使用+拼接
     */
    private String reverseWithStringConcat(String input) {
        String output = "";
        for (int i = (input.length() - 1); i >= 0; i--) {
            output += (input.charAt(i));
        }
        display(input, output);
        return output;
    }
    private void display(String input, String output) {
        System.out.println(" input string :: " + input);
        System.out.println(" output string :: " + output);
    }

    /**
     *  2. 使用 StringBuilder
     *  说明:使用StringBuilder的reverse()方法进行字符串反转
     */
    public String reverseWithStringBuilderBuiltinMethod(String string) {
        final StringBuilder builder = new StringBuilder(string);
        display(string, builder.reverse().toString());
        return builder.reverse().toString();
    }

    /**
     * 3.使用 String charAt 方法
     * 说明:使用charAt截取使用append拼接(类似 "+" 拼接 )
     */
    public String reverseWithStringChatAt(String string) {
        final StringBuilder builder = new StringBuilder();
        for (int i = (string.length() - 1); i >= 0; i--) {
            builder.append(string.charAt(i));
        }
        display(string, builder.toString());
        return builder.toString();
    }

    /**
     * 4. 通过交换字符反转
     * 说明: 把字符串转换成char类型数组(然后对字符进行转换(让第一个字符和最后一个字符换位置,一直交换到中间位置[数组长度的一半]))
     * (Math.floor() 向下取整，即小于这个数的最大的那个整数)
     */
    public String reverseWithSwaps(String string) {
        final char[] array = string.toCharArray();
        final int length = array.length - 1;
        final int half = (int) Math.floor(array.length >> 1);
        char c;
        for (int i = length; i >= half; i--) {
            c = array[length - i];
            array[length - i] = array[i];
            array[i] = c;
        }
        display(string, String.valueOf(array));
        return String.valueOf(array);
    }

    /**
     * 5.使用栈
     * (根据栈原则实现)
     */
    public static String reverseStack(String str) {
        if (str == null || "".equals(str)) {
            return str;
        }
        Stack<Character> stack = new Stack <> ();
        char[] ch = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            stack.push(ch[i]);
        }
        int k = 0;
        while (!stack.isEmpty()) {
            ch[k++] = stack.pop();
        }
        return String.copyValueOf(ch);
    }

    /**
     * 6.Collections工具类
     * 使用Collections 的 reverse的反转方法
     * 说明:把string转换成char数组把数组元素放到list集合中使用reverse进行反转(遍历list集合)
     */
    public static String reverseCollections(String str) {
        if (str == null || "".equals(str)) {
            return str;
        }
        List<Character> list = new ArrayList<>();
        for (char c: str.toCharArray()) {
            list.add(c);
        }
        Collections.reverse(list);
        StringBuilder builder = new StringBuilder(list.size());
        for (Character c: list) {
            builder.append(c);
        }
        return builder.toString();
    }

    /**
     * 7. 使用 substring() 方法
     * 说明:使用字符串的subString方法截取最后一个字符进行拼接
     */
    private static String reverseSubstring(String str) {
        if (str == null || "".equals(str)) {
            return str;
        }
        return str.charAt(str.length() - 1) + reverseSubstring(str.substring(0, str.length() - 1));
    }

    /**
     * 8.使用递归
     * 说明:使用递归下进行字符反转(先把string转换成char数组,找到边界条件,对字符串第一个字符和最后一个字符调换位置重复调用)
     */
    static int i = 0;
    private static void reverse(char[] str, int k) {
        if (k == str.length) {
            return;
        }
        reverse(str, k + 1);
        if (i <= k) {
            char temp = str[k];
            str[k] = str[i];
            str[i++] = temp;
        }
    }
    public static String reverseRecursion(String str) {
        if (str == null || "".equals(str)) {
            return str;
        }
        char[] a = str.toCharArray();
        reverse(a, 0);
        return String.copyValueOf(a);
    }


}
