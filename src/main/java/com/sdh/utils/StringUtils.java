package com.sdh.utils;

/**
 * @ClassName StringUtils
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/28 14:46
 * @Version 1.0
 */
public class StringUtils {
    public static boolean isEmpty(String str){
        if (str==null||str.trim().length()==0) {
            return true;
        }
        return false;
    }
}
