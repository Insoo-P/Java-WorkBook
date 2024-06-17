package com.insoo.jwk.javaDefault.obj;

import java.util.*;

public class SetType {
    public static void main(String[] args){

        Set<String> hashSetType = new HashSet<>();
        hashSetType.add("A");
        hashSetType.add("B");
        hashSetType.add("C");
        hashSetType.add("D");
        hashSetType.forEach(str -> System.out.printf("2. ##### %s %n", str));

        /**
         * Set → [] → ArrayList
         */
        String[] setToArray = hashSetType.toArray(new String[hashSetType.size()]);

        List<String> toArrayList1 = new ArrayList<>(Arrays.asList(setToArray));
        toArrayList1.add("F");
        toArrayList1.forEach(str -> System.out.printf("3. ##### %s %n", str));

        /**
         * Set → ArrayList
         * : ArrayList를 생성할 때 [] 배열로 변경한 다음에 List 타입으로 변경해준다.
         */
        List<String> toArrayList2 = new ArrayList<>(hashSetType);
        toArrayList2.add("F");
        toArrayList2.forEach(str -> System.out.printf("3. ##### %s %n", str));

        /**
            values
            keySet
            entrySet
         */
    }
}
