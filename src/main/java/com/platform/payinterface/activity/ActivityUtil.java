package com.platform.payinterface.activity;

import com.platform.payinterface.activity.model.ActivityModel;
import com.platform.payinterface.activity.model.OrderItems;

import java.util.ArrayList;
import java.util.List;

public class ActivityUtil {
    /**
     * 获取活动的优惠的价格
     *
     * @param ac
     * @param count
     * @param price
     * @return
     */
    public static Double getpreferential(ActivityModel ac, int count, Double price) {
        if (ac.getCond_type() == 1 && ac.getCond_money() >= price) {
            switch (ac.getExec_type()) {
                case 1:
                    return new ActivityMoney().createFullMoneyCut().getCalculateForMoney(ac.getExec_money());
                case 2:
                    return new ActivityMoney().createFullMoneyCut().getCalculateForDiscount(price, ac.getExec_discount());
                case 3:
                case 4:
                case 5:
            }
        } else if (ac.getCond_type() == 2 && count >= ac.getCond_count()) {
            switch (ac.getExec_type()) {
                case 1:
                    return new ActivityCount().createFullMoneyCut().getCalculateForMoney(ac.getExec_money());
                case 2:
                    return new ActivityCount().createFullMoneyCut().getCalculateForDiscount(price, ac.getExec_discount());
                case 3:
                case 4:
                case 5:
            }
        }
        return 0.0;

    }

    public static List<OrderItems> getItems(ActivityModel ac, List<OrderItems> list) {
        List<OrderItems> newList = new ArrayList<OrderItems>();
        for (int i = 0; i < list.size(); i++) {
            if (ac.getId() == list.get(i).getActivity_id()) {
                newList.add(list.get(i));
            }
        }
        return newList;
    }

    public static Double getPrice(List<OrderItems> list) {
        Double price = 0.0;
        for (int i = 0; i < list.size(); i++) {
            price += list.get(i).getPrice();
        }
        return price;
    }

    public static int getCount(List<OrderItems> list) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            count += list.get(i).getNumber();
        }
        return count;
    }

}
