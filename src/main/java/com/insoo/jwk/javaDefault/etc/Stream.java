package com.insoo.jwk.javaDefault.etc;

import java.util.*;

/**
    filter
    map
    flatMap
    distinct
    toList
    forEach
    reduce

    Collectors

    sorted
    parallelStream
    anyMatch
    skip
    findFirst
 */
public class Stream {
    public static void main(String[] args){

        Map<Integer, String> map = new HashMap<>();
        map.put(1,"A");
        map.put(2,"B");
        map.put(3,"C");
        map.put(4,"D");
        map.put(5,"D");

        Collection<String> mapValues = map.values();
        mapValues.stream()
                // 중복 제거
                .distinct()
                // 값 변형
                .map(m -> m + "-SS")
                // true인것만 남고 나머지는 제거
                .filter(f -> "D-SS".equals(f))
                .forEach(v -> System.out.println("#### Map, Filter : " + v));

        /**
           flatMap
           Stream<String[]> -> flatMap -> Stream<String>
           Stream<Set<String>> -> flatmap -> Stream<String>
           Stream<List<String>> -> flatmap -> Stream<String>
         */
        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        List<Integer> flattenedList = numbers.stream()
                // 안에 어떤 형태의 Collection이든 모든걸 꺼내서 같은 위치에 나열해준다.
                .flatMap(Collection::stream) // list -> list.stream()
                .toList();

        System.out.println("Flattened list: " + flattenedList);


        Optional<Integer> sum1 = flattenedList.stream()
                // (x, y) → x + y
                .reduce(Integer::sum);
        Integer sum2 = flattenedList.stream()
                // 줄이다 → 다 합치는 등..
                .reduce(10, Integer::sum);

        System.out.println("reduce sum1: " + sum1.get());
        System.out.println("reduce sum2: " + sum2);

    }
}
