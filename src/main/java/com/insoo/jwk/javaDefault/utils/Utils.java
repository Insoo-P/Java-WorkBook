package com.insoo.jwk.javaDefault.utils;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Utils {

    /*
        값으로 키 찾기: 맵에서 특정 값에 해당하는 키를 찾는 기능은 유용합니다. 위의 코드처럼 맵과 값을 인자로 받아 특정 값에 해당하는 키를 반환하는 메서드를 만들 수 있습니다.
        값으로 특정 엔트리 찾기: 맵에서 특정 값에 해당하는 엔트리를 찾는 기능도 유용합니다. 이러한 기능은 맵의 특정 값에 대응하는 키-값 쌍을 찾을 때 유용합니다.
        중복 제거: 리스트나 집합(Set)에서 중복된 요소를 제거하는 기능은 유용합니다. 이를 통해 중복된 요소를 제거하고 유니크한 요소만을 남길 수 있습니다.
        필터링: 리스트나 집합에서 특정 조건을 만족하는 요소만을 남기는 기능도 유용합니다. 이를 통해 리스트나 집합의 요소들을 조건에 따라 필터링할 수 있습니다.
        정렬: 컬렉션을 정렬하는 기능은 많은 경우에 유용합니다. 정렬 기준에 따라 요소를 정렬할 수 있습니다.
        맵 변환: 리스트나 집합을 맵으로 변환하거나 맵의 키나 값들을 리스트나 집합으로 변환하는 기능도 유용합니다.
        집합 연산: 두 개 이상의 집합에 대해 합집합, 교집합, 차집합 등의 연산을 수행하는 기능도 유용합니다.
        요소 변환: 리스트나 집합의 요소들을 특정 방식으로 변환하는 기능도 유용합니다. 이를 통해 요소들을 변환하거나 조작할 수 있습니다.
     */


    /**
     * Type Map → Value값으로 Key값 찾기
     * @param map
     * @param paramValue
     * @return K
     */
    public static <K, V, T> K findKeyByValue(Map<K, V> map, T paramValue){

        if (paramValue == null || map == null) {
            return null;
        }

        for (Entry<K, V> entrySet : map.entrySet()) {
            if (Objects.equals(paramValue, entrySet.getValue())){
                return entrySet.getKey();
            }
        }
        return null;
    }

    /**
     * Type Map → Value값으로 Entry값 찾기
     * @param map
     * @param paramValue
     * @return Entry<K, V>
     */
    public static <K, V, T> Entry<K, V> findEntryByValue(Map<K, V> map, T paramValue){
        if (paramValue == null || map == null) {
            return null;
        }

        for (Entry<K, V> entrySet : map.entrySet()) {
            if (Objects.equals(paramValue, entrySet.getValue())){
                return entrySet;
            }
        }
        return null;
    }

    /**
     * Type List → 중복제거
     */
    public static <T> List<T> removeDuplicatesList(List<T> list) {
        // 1. List → Set으로 만들자
        // Set<T> tmpSet = new HashSet<>(list);
        // List<T> tmpList = new ArrayList<>(tmpSet);

        // 2. List의 값을 HashSet에 차례대로 넣으면서 중복 여부를 확인한다.
        Set<T> tmpSet = new HashSet<>();
        List<T> tmpList = list.stream()
                // tmpSet에 추가되면 true가 반환된다.
                .filter(f -> tmpSet.add(f))
                .collect(Collectors.toCollection(ArrayList::new));
                // .toList(); → toList()로 못하는 이유는 불변으로 생성하기 때문이다.
        return tmpList;
    }
//    public static <T> List<T> removeDuplicatesList(List<T> list) {
//        // 1. List → Set으로 만들고 중복 제거
//        Set<T> tmpSet = new HashSet<>(list);
//
//        // 2. 중복이 제거된 Set을 리스트로 변환하여 반환
//        return new ArrayList<>(tmpSet);
//    }

    /**
     * Type List → Map 변환
     * : List의 index가 key값으로 대체
     * @param list<T>
     * @return Map<Integer, T>
     */
    public static <T> Map<Integer, T> listToMap(List<T> list) {
        Map<Integer, T> tmpMap = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            tmpMap.put(i, list.get(i));
        }

        return tmpMap;
    }

    /**
     * Type List → Map 변환
     * : 두번째 파라미터에 넘어온 List가 key값으로 대체
     * @param value
     * @param key
     * @return Map<K, V>
     */
    public static <K, V, T> Map<K, V> listToMapWithKey(List<T> value, List<T> key){
        List<T> tmpList = removeDuplicatesList(key);
        if(tmpList.size() != value.size()){
            return null;
        }

        Map<K, V> tmpMap = new HashMap<>();

        for(int i=0; i<value.size(); i++){
            tmpMap.put((K) key.get(i), (V) value.get(i));
        }
        return tmpMap;
    }
}
