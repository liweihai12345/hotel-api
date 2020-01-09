package com.platform.util;

import com.platform.entity.LotteryConfigDO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/4/17 16:58
 */
public final class LotteryUtil {
    public static String sortBall(String strBall, LotteryConfigDO conf) {
        String[] reds = strBall.split("-");
        List<String> list = Arrays.asList(reds);
        List<String> slist = list.stream().distinct().sorted().collect(Collectors.toList());
        if (!checkBall(slist, conf)) {
            return null;
        }
        return slist.stream().collect(Collectors.joining(","));
    }

    public static boolean checkBall(List<String> reds, LotteryConfigDO conf) {

        if (reds.size() != 6) {
            return false;
        }
        for (String red : reds) {
            Integer redint = Integer.parseInt(red);
            if(redint==null)
                return false;
            if (redint <= 0 || redint > 33) {
                return false;
            }
        }
        return true;
    }

    public static String sortweekhappy(String strBall, LotteryConfigDO conf) {
        String[] reds = strBall.split("-");
        List<String> list = Arrays.asList(reds);
        List<String> slist = list.stream().distinct().sorted().collect(Collectors.toList());
        if (!checkweekhappy(slist, conf)) {
            return null;
        }
        return slist.stream().collect(Collectors.joining(","));
    }

    public static boolean checkweekhappy(List<String> reds, LotteryConfigDO conf) {

        if (reds.size() != 4) {
            return false;
        }
        for (String red : reds) {
            Integer redint = Integer.parseInt(red);
            if(redint==null)
                return false;
            if (redint < 101 || (redint > 113 && redint<201) || (redint > 213 && redint<301) || (redint > 313 && redint<401)  || redint > 413) {
                return false;
            }
        }
        return true;
    }
}

