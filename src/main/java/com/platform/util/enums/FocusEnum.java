package com.platform.util.enums;

import java.util.Arrays;
import java.util.List;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/12 16:22
 */
public enum FocusEnum {


    ONE_OFF_TWO(false,false, "1---2",0),
    ONE_IN_TWO(true,false, "1-->2",1),
    ONE_ON_TWO(false,true, "1<--2",2),
    ONE_OR_TWO(true,true, "1<-->2",3);

    private boolean focus;
    private boolean focused;
    private String desc;
    private Integer value;

    public boolean isFocus() {
        return focus;
    }

    public void setFocus(boolean focus) {
        this.focus = focus;
    }

    public boolean isFocused() {
        return focused;
    }

    public void setFocused(boolean focused) {
        this.focused = focused;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    FocusEnum(boolean focus, boolean focused, String desc, Integer value) {
        this.focus = focus;
        this.focused = focused;
        this.desc = desc;
        this.value = value;
    }
    public static  Integer getVal(boolean focus,boolean focused){
        FocusEnum result = Arrays.stream(FocusEnum.values()).filter(f -> f.isFocus() == focus&& f.isFocused()==focused).findFirst().orElse(FocusEnum.ONE_OFF_TWO);
        return result.getValue();
    }

    public static int getFocusedStatus(List<Long> fm, List<Long> fmd, Long uid){
        boolean focus=false;
        boolean focused=false;
        if(fm.isEmpty()){
            focus=false;
        }else if(fm.contains(uid)){
            focus=true;
        }
        if(fmd.isEmpty()){
            focused=false;
        }else if(fmd.contains(uid)){
            focused=true;
        }

        return FocusEnum.getVal(focus,focused);
    }
    public static int getFocusedStatus(Integer fm, Integer fmd){
        boolean focus=fm==1?true:false;
        boolean focused=fmd==1?true:false;
        return FocusEnum.getVal(focus,focused);
    }

    /**
     * 我关注的并且关注我的
     * @param fm 关注我的
     * @param userid 我关注的
     * @return
     */
    public static int getFocusMyStatus(List<Long> fm, Long userid ){
        boolean focus=true;
        boolean focused=false;

        if(fm.isEmpty()){
            focused=false;
        }else if(fm.contains(userid)){
            focused=true;
        }
        return FocusEnum.getVal(focus,focused);
    }
}
