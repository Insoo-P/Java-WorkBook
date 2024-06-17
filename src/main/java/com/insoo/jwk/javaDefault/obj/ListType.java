package com.insoo.jwk.javaDefault.obj;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * add(E element): 리스트에 지정된 요소를 추가합니다.
 * addAll(Collection<? extends E> c): 다른 컬렉션의 모든 요소를 리스트에 추가합니다.
 * remove(Object o): 리스트에서 지정된 요소를 제거합니다.
 * remove(int index): 리스트에서 지정된 인덱스에 있는 요소를 제거합니다.
 * clear(): 리스트의 모든 요소를 제거합니다.
 * get(int index): 리스트에서 지정된 인덱스에 있는 요소를 반환합니다.
 * set(int index, E element): 리스트에서 지정된 인덱스에 있는 요소를 새 요소로 대체합니다.
 * contains(Object o): 리스트가 지정된 요소를 포함하고 있는지 여부를 반환합니다.
 * isEmpty(): 리스트가 비어 있는지 여부를 반환합니다.
 * size(): 리스트의 요소 수를 반환합니다.
 * indexOf(Object o): 리스트에서 지정된 요소의 인덱스를 반환합니다.
 * lastIndexOf(Object o): 리스트에서 지정된 요소의 마지막 인덱스를 반환합니다.
 * toArray(): 리스트의 요소를 배열로 반환합니다.
 */
public class ListType {
    public static void main(String[] args){

        List<Number> numList = new ArrayList<>();
        numList.add(3);
        numList.add(3.3);
        numList.add(10f);
        
        List<String> strList = new ArrayList<>();
        strList.add("가");
        strList.add("나");
        strList.add("다");

        List<String> engList = new ArrayList<>();
        engList.add("A");
        engList.add("B");
        engList.add("C");
        
        List<String> koList = new ArrayList<>();
        koList.add("가");
        koList.add("나");
        koList.add("다");


        // 1. add, addAll
        koList.addAll(engList);
        koList.forEach(s -> System.out.println("### ko,engList : " + s));


        // *2. Iterator를 사용하여 요소 삭제
        for(Iterator<Number> numItor = numList.iterator(); numItor.hasNext();){
            Integer addNum = 10;
            Number numItorValue = numItor.next();
            String numItorType = String.valueOf(numItorValue.getClass());
            String addNumType = String.valueOf(addNum.getClass());

            if(addNumType.equals(numItorType)){
                numItorValue = 10;
            }
        }


        // 3-1. 삭제
        List<String> strRemoveList = strList.stream()
                .filter(f -> !f.equals("가"))
                .toList();


        // 3-2.
        // strList.remove(0);
        strRemoveList.forEach(f -> System.out.println("### strRemoveList : " + f));


        // 4. contains
        boolean result = strRemoveList.contains("나");
        System.out.println("### strRemoveList Result : " + result);


        // 5. set
        strList.set(0,"가가");
        // strRemoveList.set(0, "가가"); → 변경 불가능한 리스트
        strList.forEach(p -> System.out.println("#### strList set :" + p));
        
        
        // 6. 변경 가능, 불가능 리스트
        /**
         * 변경 가능한 리스트 (Mutable List):
         * ArrayList: 크기가 동적으로 조정되며, 요소를 추가하거나 제거할 수 있습니다.
         * LinkedList: 이중 연결 리스트로 구현되어 있어 요소를 추가하거나 제거할 때 빠르게 작동합니다.
         * CopyOnWriteArrayList: 동기화된 리스트로, 병행성 문제를 방지하면서 안전하게 요소를 추가하거나 제거할 수 있습니다.
         * 
         * 변경 불가능한 리스트 (Immutable List):
         * List.of(): Java 9부터 추가된 메서드로, 요소를 변경할 수 없는 리스트를 생성합니다.
         * Collections.unmodifiableList(): 변경할 수 없는 뷰를 생성하여 원본 리스트를 변경할 수 없게 만듭니다.
         */

        // 7. Stream은 Stream.Java 참고
        List<String> transformStrList = strList.stream()
                .map(m -> m + "-SS")
                .toList();

        transformStrList.forEach(p -> System.out.println(p));

        // 8. indexOf → 없으면 -1 반환
        // indexOf는 처음부터 lastIndexOf는 마지막부터 찾는다.
        int indexOf = strList.indexOf("가가");
        int lastIndexOf = strList.lastIndexOf("가가");
        System.out.println("#### indexOf : " + indexOf);
        System.out.println("#### lastIndexOf : " + lastIndexOf);

    }
}

