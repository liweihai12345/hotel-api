package com.platform.util;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/11 9:43
 */
public class PathUtils {
    public static String splitJoinPath(String endPoint, String fileName, String bucket,String dir) {
        String schema = endPoint.substring(0, endPoint.lastIndexOf("/")+1);
        String address = endPoint.substring(endPoint.lastIndexOf("/")+1);
        StringBuilder sb = new StringBuilder();
        sb.append(schema).append(bucket).append(".").append(address).append("/").append(dir).append("/").append(fileName);
        return sb.toString();
    }

}
