package lesson4;

import java.util.HashMap;
public class Main {
    public static void main(String[] args) {
        String[] avto = {"AUDI", "ASTON MARTIN", "BENTLEY", "BMW", "CADILLAC", "FORD", "MAZDA", "MERCEDES", "MITSUBISHI",
                "NISSAN", "AUDI", "ASTON MARTIN", "BMW", "BMW", "BMW", "MAZDA", "MAZDA", "MAZDA", "MAZDA", "CADILLAC"};
        System.out.println("Всего автомбилей: " + avto.length);
        HashMap<String, Integer> uniqWords = new HashMap<>();
        for (String word : avto) {
            if (uniqWords.containsKey(word)) {
                uniqWords.put(word, uniqWords.get(word) + 1);
            } else {
                uniqWords.put(word, 1);}
        }
        System.out.println("Упоминаний марок автомобилей:\n" + uniqWords);}
}