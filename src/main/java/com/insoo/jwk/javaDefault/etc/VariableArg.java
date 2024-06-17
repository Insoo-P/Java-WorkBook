package com.insoo.jwk.javaDefault.etc;

import java.util.Arrays;

/**
 *  가변 인수 : 배열로 처리된다.
 */
public class VariableArg {

    public static void main(String[] args){
        int[] nums = { 100, 200, 300 };
        int sumNum = sumArr(nums);
        System.out.println("####sumNum : " + sumNum);
    }

    /**
     * 배열 인수
     * @param data
     * @return
     */
    public static int sumArr(int[] data){
        int sum = Arrays.stream(data).sum();
        return sum;
    }

    /**
     * 가변형 인수
     * @param data
     * @return
     */
    public static int sumArr2(int... data){
        int sum = Arrays.stream(data).sum();
        return sum;
    }
}
