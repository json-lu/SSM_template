package com.ljx.exercise.helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 10:57 2020/12/22
 * @Author: Ljx
 * @Decription:
 */
public class Conv {

    //转字符串
    public static String toStr(Object obj){
        return obj==null?"":obj.toString();
    }
    //转整数
    public static Integer toInt(Object obj){
        return obj==null?0: Conv.toInt(Conv.toStr(obj));
    }

    //转整数
    public static Integer toInt(String str){
        Integer number = null;
            if (str !=null && !"".equals(str)){
                int split = str.indexOf(".");
                if (split>0){
                    number = Integer.parseInt(str.substring(0,split));
                }else {
                    number = Integer.parseInt(str);
                }
                return number;
            }else {
                return 0;
            }
    }

    //日期格式化
    public static String toDate(Date date,String pattern){
        boolean matches = pattern.matches("[y]{4}[-|/][M]{2}[-|/][d]{2}\\s[hh]{2}[:/-][mm]{2}[:/-][ss]{2}");
        if (!matches){
            return  null;
        }else {
            SimpleDateFormat sf = new SimpleDateFormat(pattern);
            return date==null?null:sf.format(date);
        }
    }

    //日期格式化
    public static String toDate(Date date){
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return date == null?null:sf.format(date);
    }

    //取后缀名
    public static String suffix(String fileName){
        if (fileName!=null && !"".equals(fileName)){
            int index = fileName.lastIndexOf(".");
            return fileName.substring(index);
        }else {
            return null;
        }
    }

    //判断是否为空
    public static boolean isEmpty(String str){
        return (str!=null && !"".equals(str))?true:false;
    }



}
