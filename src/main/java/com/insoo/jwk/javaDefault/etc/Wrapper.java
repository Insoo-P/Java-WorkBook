package com.insoo.jwk.javaDefault.etc;

import java.util.Arrays;

public class Wrapper {
    static int rawAge = 30;

    static int age = 30;
    static Integer wrapperAge = age;

    public static int rawAgeTransform(int rawAge){
        rawAge = rawAge + 3;
        System.out.println("#### 변경된 age : " + rawAge);
        return rawAge;
    }

    public static Integer wrapperAgeTransform(Integer wrapperAge){
        wrapperAge = wrapperAge + 3;
        System.out.println("#### 변경된 wrapperAge : " + wrapperAge);
        return wrapperAge;
    }


    public static void main(String[] args){

        int rawAgeResult = rawAgeTransform(rawAge);

        Integer wrapperResult = wrapperAgeTransform(wrapperAge);

        rawAgeResult = rawAgeResult + 10;
        System.out.println("###### rawAge 결과값 : " + rawAgeResult);
        System.out.println("###### rawAge 기본값 : " + rawAge);


        wrapperResult = wrapperResult + 10;
        System.out.println("###### wrapperAge 결과값 : " + wrapperResult);
        System.out.println("###### wrapperAge 기본값 : " + wrapperAge);

        /**
         *
         * 1. 래퍼 클래스는 기본 데이터 타입을 Object로 변환할 수 있다.
         * 메소드에 전달된 인수를 수정하려는 경우 오브젝트가 필요하다. ( 기본 유형은 값에 의한 변경 Object는 참조에 의한 변경이기 때문이다. )
         * 2. java.util 패키지의 클래스는 객체만 처리하므로 Wrapper class는 이 경우에도 도움이 된다.
         * 3. ArrayList 등과 같은 Collection 프레임 워크의 데이터 구조는 기본 타입이 아닌 객체만 저장하게 되고 Wrapper Class를 사용하여 자동 방식과 언방식이 일어 난다.
         * 4. 멀티스레딩에서 동기화를 지원하려면 객체가 필요하다.
         */

        /**
         * Wrapper Class 쓰는 이유
         * :
         * Number
         *  Integer
         *  Double
         *  Float
         *  Long
         *  Short
         *  Byte
         */
        int num = 50;
        String str = "가";

        String strNum = Integer.toString(num);
        System.out.println("#### strNum Type : " + strNum.getClass());

        Integer intNum = Integer.parseInt(strNum);
        System.out.println("#### IntegerNum Type : " + intNum.getClass());

        byte[] bytes = str.getBytes();
        System.out.println("#### byteNum Type : " + Arrays.toString(bytes));




    }


}
