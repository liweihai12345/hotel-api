package com.platform.util;

import com.platform.entity.HomeConfigDO;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/3/9 15:31
 */
@Slf4j
public class ListUtils {

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    public static List<Integer> distant(List<HomeConfigDO> list) {
//        Set<Integer> set = new HashSet<>();
////        List<HomeConfigDO> lists = list.stream().filter(o -> set.add(o.getType())).collect(Collectors.toList());
        List<Integer> types = list.stream().map(HomeConfigDO::getType).distinct().collect(Collectors.toList());
        return types;
    }
    public static List<Integer> convertInteger(List<String> list) {
        List<Integer> lists = list.stream().map(o -> Integer.valueOf(o)).collect(Collectors.toList());
        return lists;
    }


}
