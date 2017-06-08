package com.example.fundamental;

import java.security.NoSuchAlgorithmException;

/**
 * Created by PC on 2017/6/8.
 */

public class MD5 {
    public static String getMD5(byte[] source)
    {
        String s = null;
        //用来将字节转换成十六进制表示的字符
        char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            md.update(source);
            byte tmp[] = md.digest();    //MD5的计算结果是一个128位的长整数
            //用字节表示就是16个字节
            char str[] = new char[16 * 2];   //每个字节用十六进制表示，使用2个字符,表示成十六进制需要32个字符
            int k = 0;   // 转换结果中对应的字符位置
            for (int i = 0; i < 16; i++)    //从第一个字节开始将MD5的每一个字节转换成十六进制字符
            {
                byte byte0 = tmp[i];   //取第i个字节
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];    //取字节中高4位的数字转换
                str[k++] = hexDigits[byte0 & 0xf];    // 取字节中低4位的数字转换
            }
            s = new String(str);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return s;
    }
}
