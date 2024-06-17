package com.insoo.jwk.javaDefault.loop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Loop {
    public static void main(String[] args){

        /**
         * Loop 성능 순
         * 1. Stream API 사용 2 (병렬 스트림)
         * 2. Iterator 사용 for문 (요소 삭제가 필요한 경우)
         * 2. Stream API 사용
         * 3. Enhanced for문
         * 4. 일반적인 for문 (인덱스 사용)
         * 5. 초기화식 (조건 검사 후 실행이 필요한 경우)
         */

        List<String> list = new ArrayList<>();
        list.add("하나");
        list.add("둘");
        list.add("셋");

        /**
         * 1. 일반적인 for문
         *    index를 사용해야 하는 경우 사용
         *    역순 반복도 가능
         */
        for(int i=0; i<list.size(); i++){
            System.out.printf("1. ##### %d : %s %n", i, list.get(i));
        }

        /**
         * 2. 향상된 for문
         *    요소의 순서가 중요하지 않고, 단순히 각 요소를 순회하면서 작업을 수행할 때 사용
         */
        for(String str : list){
            System.out.printf("2-1. ##### %s %n", str);
        }

        list.forEach(str -> System.out.printf("2-2. ##### %s %n", str));

        /**
         * 4. Iterator를 사용한 for문:
         *    리스트의 요소를 변경할 필요가 있거나, 특정한 조건에 따라 요소를 제어할 때 사용
         *    만약 일반적은 for문으로 리스트를 순회하는 중에 요소를 삭제했을 경우 index가 변경되어 일부 요소는 순회하지 않을 수 있다.
         *    List에서 문제가 발생할 수 있는 것을 감지하여 ConcurrentModificationException를 발생한다.
         *    Iterato는 순회 중에 요소를 삭제해도 ConcurrentModificationException가 발생하지 않도록 설계되었다.
         */
        for(Iterator<String> iterator = list.iterator(); iterator.hasNext();){
            // .next()를 이용하면 무조건 다음 단계로 넘어간다. ex) System.out.println(iterator.next()) 포함
            String str = iterator.next();
            System.out.printf("4-1. ##### %s %n", str);
        }

        // Iterator<Integer> iteratorKey = engkeys.iterator();
        // while(iteratorKey.hasNext()){
        //     System.out.printf("### engKeys : %d %n", iteratorKey.next());
        // }

        /**
         * 4. Enhanced for문
         *    JDK 1.5부터 추천
         */
        Iterator<String> iterator = list.iterator();
        iterator.forEachRemaining(str -> System.out.printf("4-2. ##### %s %n", str));

        /**
         * 5. 초기화식
         *    5-1. 먼저 조건 검사 후 충족 시 실행해야하는 경우 사용
         *    5-2. 조건이 맞지 않아도 처음에 실행 후 조건 검사
         */
        int reSetNum = 0;
        while(reSetNum < list.size()) {
            System.out.printf("5-1. ##### %d : %s %n", reSetNum, list.get(reSetNum));
            reSetNum++;
        }

        reSetNum = 0;
        do{
            System.out.printf("5-2. ##### %d : %s %n", reSetNum, list.get(reSetNum));
            reSetNum++;
        }while(reSetNum < list.size());

        /**
         * 6. Stream API 사용
         *    Iterator랑 비슷하지만 요소를 삭제 할 경우 Stream 또한 'ConcurrentModificationException'가 발생한다.
         *    Stream API에는 'filter', 'map, 'flatMap' 등 다양한 메서드 사용 가능
         */
        list.stream().forEach(str -> System.out.printf("6. ##### %s %n", str));

        /**
         * 7. Stream API 사용 2
         *    parallelStream()를 이용하면 병렬 처리를 수행할 수 있다.
         *    대용량 데이터를 효율적으로 처리할 때 유용
         *    병렬 스트림은 데이터가 충분히 크고 작업이 CPU 바운드일 때 가장 효과적으로 사용된다.
         *    그러나 데이터 크기가 작거나 작업이 I/O 바운드일 경우에는 병렬 처리의 이점이 제한될 있다.
         *    또한, 스레드를 사용하여 작업을 병렬로 처리하기 때문에 스레드 간의 동기화 문제나 성능 저하 등의 부작용에 유의해야 한다.
         */
        list.parallelStream().forEach(str -> System.out.printf("7. ##### %s %n", str));

    }
}
