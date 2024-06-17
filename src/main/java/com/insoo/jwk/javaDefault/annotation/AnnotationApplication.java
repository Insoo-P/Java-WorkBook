package com.insoo.jwk.javaDefault.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

public class AnnotationApplication {
    public static void main(String[] args) {
        Method[] methods = AnnotationApplication.class.getMethods();
        Arrays.stream(methods).forEach(v -> {
            AnnotationMethod annotation = v.getAnnotation(AnnotationMethod.class);
            if(!Objects.isNull(annotation)){
                System.out.println("#### AnnotationMethd : " + v);
                try {
                    // invoke(Object, Object ...args)
                    // 1. 메서드를 실행하기 위한 메서드의 class를 생성하거나 생성된 객체
                    // 2. 메서드를 실행하기 위한 파라미터 객체(Object)로 구성된 배열
                    v.invoke(null);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    @AnnotationMethod
    public static void method1(){
        System.out.println("#### Test");
    }
}
