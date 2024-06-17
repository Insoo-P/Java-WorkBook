package com.insoo.jwk.javaDefault.test;

import com.insoo.jwk.javaDefault.utils.Utils;

import java.util.*;
import java.util.Map.Entry;

public class Test {


    public static void main(String[] args){

        Map<String, Object> map = new HashMap<>();
        Map<Integer, String> eng = new HashMap<>();
        Map<String, String> ko = new HashMap<>();
        Map<Object, Object> obj = new HashMap<>();
        Map<Object, Object> obj2 = new HashMap<>();

        eng.put(1,"A");
        eng.put(2,"B");
        eng.put(3,"C");
        eng.put(4,"D");
        eng.put(5,"D");

        ko.put("1","가");
        ko.put("2","나");
        ko.put("3","다");
        ko.put("4","라");

        obj.put("1", ko);
        obj.put("2", "A");
        obj.put(3, 3);

        map.put("영어", eng);
        map.put("한글", ko);


        String key = (String) Utils.findKeyByValue(obj,"");
        System.out.println("########key?: " + key);
        Entry<?, ?> entry = (Entry<?, ?>) Utils.findEntryByValue(obj, "A");
        System.out.println("########Entry?: " + entry.getValue());

        Set<Integer> key2 = eng.keySet();
        key2.stream()
                .filter(h -> h == 1)
                .forEach(f -> System.out.println("########Stream : " + f));

        Collection<String> engValues = eng.values();
        engValues.stream()
                .filter(f -> "D".equals(f))
                .forEach(l -> System.out.println("########Stream Value D : " + l));

        List<String> listType = engValues.stream()
                .map(m -> m + "MM")
                .toList();
        listType.forEach(v -> System.out.println("#########list Value : " + v));

        List<String> disListType = engValues.stream()
                .distinct()
                .toList();
        disListType.forEach(v -> System.out.println("#########dislist Value : " + v));


        ///////////////////////////////////////////////////////////////////////

        List<String> listTest = new ArrayList<>();
        listTest.add("A");
        listTest.add("A");
        listTest.add("A");
        listTest.add("A");
        listTest.add("B");
        listTest.add("C");
        listTest.add("D");
        listTest.add("A");

        List<String> listTest2 = new ArrayList<>();
        listTest2.add("r");
        listTest2.add("e");
        listTest2.add("w");
        listTest2.add("q");
        listTest2.add("a");
        listTest2.add("s");
        listTest2.add("d");
        listTest2.add("f");
        listTest2.add("f");

        List<String> listSetTest = Utils.removeDuplicatesList(listTest);

        listSetTest.forEach(p -> System.out.println("##### listSetTest : " + p));

        ///////////////////////////////////////////////////////////////////////

//        Map<Integer, String> listMapTest = Utils.listToMap(listTest);
//        listMapTest.forEach((k, v) -> System.out.println("k + v" + k + ":" + v));

        Map<String, String> listMapTest2 = Utils.listToMapWithKey(listTest, listTest2);
        if (listMapTest2 != null) {
            listMapTest2.forEach((k, v) -> System.out.println(k + ":" + v));
        }

        ///////////////////////////////////////////////////////////////////////


    }


}

