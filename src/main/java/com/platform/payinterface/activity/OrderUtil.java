package com.platform.payinterface.activity;

import com.platform.payinterface.activity.model.ActivityRecord;
import com.platform.payinterface.activity.model.OrderItems;
import com.platform.payinterface.activity.model.ShopCar;

import java.util.ArrayList;
import java.util.List;

public class OrderUtil {

    //构建要删除的购物车
    public static List<ShopCar> buildeCarList(List<OrderItems> items, Integer uid) {
        List<ShopCar> cars = new ArrayList<ShopCar>();
        for (int j = 0; j < items.size(); j++) {
            // 封装购物车数据
            ShopCar car = new ShopCar();
            car.setUid(uid);
            car.setProduct_id(items.get(j).getProduct_id());
            car.setFittingids(items.get(j).getFittings_ids());
            car.setFittings_group_ids(items.get(j).getFittings_group_ids());
            car.setCustomized_type(items.get(j).getCustomized_type());
            car.setCustomized_code(items.get(j).getCustomized_code());
            cars.add(car);
        }
        return cars;
    }

    //构建购买记录
    public static List<ActivityRecord> buildeActivityRecord(List<OrderItems> items) {
        List<ActivityRecord> listRecord = new ArrayList<ActivityRecord>();

        for (int j = 0; j < items.size(); j++) {

            ActivityRecord record = new ActivityRecord();
            record.setDiscount_activity_discount(items.get(j).getActivity_discount());
            record.setDiscount_activity_id(items.get(j).getActivity_id());
            double newprice = items.get(j).getPrice() * items.get(j).getActivity_discount();
            record.setNew_price(newprice);
            record.setOld_price(items.get(j).getPrice());
            record.setNumbers_code(items.get(j).getActivity_number());
            record.setIs_transaction(0);
            record.setOrder_code(items.get(j).getOrder_code());
            record.setProduct_id(items.get(j).getProduct_id());
            record.setRecord_unique_key(items.get(j).getOrder_code() + items.get(j).getStyle_id().toString() + items.get(j).getFittings_ids());
            listRecord.add(record);
        }
        return listRecord;

    }

    public static List<Integer> getPackingBoxIdList(List<OrderItems> items) {
        List<Integer> bids = new ArrayList<Integer>();
        for (int i = 0; i < items.size(); i++) {
            Integer bid = items.get(i).getBox_id();
            bids.add(bid);
        }
        return bids;
    }
}
