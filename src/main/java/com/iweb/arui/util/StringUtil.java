package com.iweb.arui.util;

import java.util.Random;

/**
 * @author Guan
 * @date 2023/5/19 9:02
 */
public class StringUtil {
    public static String getRandomStr(int n){
        Random r = new Random();
        StringBuilder strPool = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            if(Character.isLetterOrDigit((char)i)){
                strPool.append((char)i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(strPool.charAt(r.nextInt(strPool.length())));
        }
        return sb.toString();

    }
}
