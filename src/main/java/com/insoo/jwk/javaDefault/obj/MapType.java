package com.insoo.jwk.javaDefault.obj;

import java.util.HashMap;
import java.util.Map;

public class MapType {
    public static void main(String[] args){

        /**
         * Map
         */
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "A");
        hashMap.put(2, "B");
        hashMap.put(3, "C");
        hashMap.put(4, "D");
        System.out.printf("2. ##### %s %n", hashMap.get(3));

        /**
         *
         */
        // Set<Integer> keySet = hashMap.keySet();
        // List<Integer> keySetToArray = new ArrayList<>(keySet);
        // keySetToArray.forEach(key -> System.out.println("3. ##### " + hashMap.get(key)));
    }
}
