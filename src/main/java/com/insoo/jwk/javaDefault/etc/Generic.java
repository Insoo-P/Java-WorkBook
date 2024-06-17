package com.insoo.jwk.javaDefault.etc;

/**
    T : Type
    K : Key
    V : Value
    E : Element(자료구조에 들어가는 원소들을 나타낼 때 사용함)
 */
public class Generic {
    public static void main(String[] args){

        Box<Integer> integerBox = new Box<>();
        integerBox.setValue(10);
        System.out.println("Box value: " + integerBox.getValue());
        Box.printValue("Hello, Generics!");

        double sumResult = doubleSum(3.24, 3);
        System.out.println("#### doubleSum : " + sumResult);
    }

    /**
     * 제네릭 클래스
     */
    public static class Box<T> {
        private T value;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        /**
         * 제네릭 메서드
         */
        public static <T> void printValue(T value) {
            System.out.println("Value: " + value);
        }
    }

    /**
        제한된 타입 파라미터
        : T 옆에 extends Number로 통해서 적어도 Number타입 또는 Number의 자식들만 오게 할 수 있다.
     */
    public static <T extends Number> Double doubleSum(T num1, T num2){
        double v1 = num1.doubleValue();
        double v2 = num1.doubleValue();

        return Double.sum(v1, v2);
    }

}

