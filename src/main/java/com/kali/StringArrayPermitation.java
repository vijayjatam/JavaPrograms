package com.kali;

import java.util.*;

/**
 * Created by mpalavelli on 01-12-2017.
 */
public class StringArrayPermitation {
    public static long stringLength=0;
    public static List<String> finalStringValue;
    public static void main(String[] args) {

       List<String> list = new ArrayList<String>();
       list.add("Site");
       list.add("demo");
       list.add("live");
       Set<List<String>> finalResult = permitationOnStringArray(list);
        System.out.println(finalResult);

    }
    public static Set<List<String>> permitationOnStringArray(List<String> list){
        Set<List<String>> permiResult = new HashSet<List<String>>();
        if (list == null) {
            return null;
        } else if (list.size() == 0) {
            permiResult.add(new ArrayList<String>());
            return permiResult;
        }
        String firstString = list.get(0);
        List<String> remingList = list.subList(1,list.size());
        Set<List<String>> words = permitationOnStringArray(remingList);
        for (List<String> newString : words) {
            for (int i = 0; i <= newString.size(); i++) {
                finalStringValue = stringAdd(newString, firstString, i);
                permiResult.add(finalStringValue);
            }
        }

        return permiResult;
    }
    public static String charAdd(String str, char c, int i) {
        String first = str.substring(0, i);
        String last = str.substring(i);
        return first + c + last;
    }
    public static List<String> stringAdd(List<String> list, String str, int i){
        List<String> intialList = new ArrayList<String>();

        if(list!=null){
            intialList.addAll(list.subList(0,i));
        }
        List<String> returnList = intialList;
        returnList.add(str);
        if(list.size()>=1){
            returnList.addAll(list.subList(i,list.size()));
        } /*else if(list.size()>1){
            returnList.addAll(list.subList(1,list.size()));
        }*/
        return returnList;
    }

}
