package lesson3;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1:");
        Integer[] intArr = new Integer[2];
        intArr[0] = 12;
        intArr[1] = 55;
        System.out.println(Arrays.deepToString(intArr));
        swap(intArr, 0, 1);
        ArrayList<Integer> arrayList = toArrayList(intArr);
        System.out.println(arrayList);

        System.out.println("\nЗадание 2:");
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Apple apple5 = new Apple();
        Apple apple6 = new Apple();


        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Orange orange4 = new Orange();


        Box<Apple> box1 = new Box<>(apple1, apple2, apple3,apple4,apple5,apple6);
        System.out.println("Коробка №1 весит: " + box1.getWeight());
        Box<Orange> box2 = new Box<>(orange1, orange2,orange3,orange4);
        System.out.println("Коробка №2 весит: " + box2.getWeight());

        //сраниваем вес коробок
        System.out.println("Сравниваем вес: "+box1.compare(box2));

        System.out.println("\nСоздаем коробку №3 и высыпаем в нее апельсины из второй");
        Box<Orange> box3 = new Box<>();
        box2.transfer(box3);
        System.out.println("Вес коробки №3: " + box3.getWeight());
    }
    public static void swap(Object[] arr, int index1, int index2) {
        Object tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
    public static <T> ArrayList<T> toArrayList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }
}