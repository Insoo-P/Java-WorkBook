package com.insoo.jwk.javaDefault.obj;

import java.util.*;

public class CollectionType {
    public static void main(String[] args){

        /**
         1. List
         2. Set
         3. Map
         4. Queue
         */

        /**
         * List
         */
        List<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        for(int i=0; i<arrayList.size(); i++){
            System.out.printf("1. ##### %d : %s %n", i, arrayList.get(i));
        }

        /**
         * Set
         */
        Set<String> hashSet = new HashSet<>();
        hashSet.add("A");
        hashSet.add("B");
        hashSet.add("C");
        hashSet.add("D");
        hashSet.forEach(str -> System.out.printf("2. ##### %s %n", str));


        /**
         * Map
         */
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "A");
        hashMap.put(2, "B");
        hashMap.put(3, "C");
        hashMap.put(4, "D");
        System.out.printf("2. ##### %s %n", hashMap.get(3));

        // Set<Integer> keySet = hashMap.keySet();
        // List<Integer> keySetToArray = new ArrayList<>(keySet);
        // keySetToArray.forEach(key -> System.out.println("3. ##### " + hashMap.get(key)));

        /**
         * Queue
         */
        Queue<String> queue = new LinkedList<>();
    }


}
