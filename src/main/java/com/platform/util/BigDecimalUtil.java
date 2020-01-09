package com.platform.util;

import java.math.BigDecimal;

/**
 * @program:
 * @Description: 处理浮点数
 * @Author: liweihai
 * @Date: Created in 2018/10/12 14:50
 */
public class BigDecimalUtil {

    //格式化位数
    public static BigDecimal format(BigDecimal decimal) {
        return decimal == null ? BigDecimal.valueOf(0) : BigDecimal.ZERO.compareTo(decimal) == 0 ? BigDecimal.valueOf(0) : decimal.setScale(5, BigDecimal.ROUND_DOWN);
    }
    public static BigDecimal format(BigDecimal decimal,int len) {
        return decimal == null ? BigDecimal.valueOf(0) : BigDecimal.ZERO.compareTo(decimal) == 0 ? BigDecimal.valueOf(0) : decimal.setScale(len, BigDecimal.ROUND_DOWN);
    }
    public static String formatStr(BigDecimal decimal,int len) {
        return decimal == null ? "0" : BigDecimal.ZERO.compareTo(decimal) == 0 ? "0" : decimal.setScale(len, BigDecimal.ROUND_DOWN).toString();
    }
    // 去空设默认
    public static BigDecimal add(BigDecimal v1, BigDecimal v2) {
        if (v1 == null) {
            v1 = BigDecimal.valueOf(0);
        }
        if (v2 == null) {
            v2 = BigDecimal.valueOf(0);
        }
        return v1.add(v2);
    }

    // 去空设默认
    public static BigDecimal subtract(BigDecimal v1, BigDecimal v2) {
        if (v1 == null) {
            v1 = BigDecimal.valueOf(0);
        }
        if (v2 == null) {
            v2 = BigDecimal.valueOf(0);
        }
        return v1.subtract(v2);
    }
    // 去空设默认
    public static BigDecimal subtract(BigDecimal v1, BigDecimal v2,int len) {
        if (v1 == null) {
            v1 = BigDecimal.valueOf(0);
        }
        if (v2 == null) {
            v2 = BigDecimal.valueOf(0);
        }
        return v1.subtract(v2).setScale(len,BigDecimal.ROUND_DOWN);
    }
    // 去空设默认
    public static BigDecimal multiply(BigDecimal v1, BigDecimal v2) {
        if (v1 == null || v2 == null) {
            return BigDecimal.valueOf(0).setScale(2, BigDecimal.ROUND_DOWN);
        }
        return v1.multiply(v2);
    }

    // 去空设默认
    public static BigDecimal divide(BigDecimal v1, BigDecimal v2) {
        if (v1 == null || v2 == null) {
            return BigDecimal.valueOf(0);
        }
        return v1.divide(v2,2, BigDecimal.ROUND_DOWN);
    }
    // 去空设默认
    public static BigDecimal remainder(BigDecimal v1, BigDecimal v2) {
        if (v1 == null || v2 == null) {
            return BigDecimal.valueOf(0);
        }
        return v1.divideAndRemainder(v2)[1];
    }



    // 去空设默认
    public static BigDecimal multiply(BigDecimal v1, BigDecimal v2,int len) {
        if (v1 == null || v2 == null) {
            return BigDecimal.valueOf(0).setScale(len, BigDecimal.ROUND_DOWN);
        }
        return v1.multiply(v2);
    }

    // 去空设默认
    public static BigDecimal divide(BigDecimal v1, BigDecimal v2,int len) {
        if (v1 == null || v2 == null) {
            return BigDecimal.valueOf(0);
        }
        return v1.divide(v2,len, BigDecimal.ROUND_DOWN);
    }

}
