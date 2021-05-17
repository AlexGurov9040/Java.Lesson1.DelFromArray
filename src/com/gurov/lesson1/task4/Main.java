package com.gurov.lesson1.task4;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        try{
            System.out.println("Введите количество элементов массива");
            int n = in.nextInt();
            if (n < 1){
                throw new Exception("Количество элементов массива должно быть больше 0");
            }
            int mas[] = new int[n];
            try{
                System.out.println("Введите диапазон значений элементов массива (от.. до..)");
                int a = in.nextInt();
                int b = in.nextInt();
                if (a > b){
                    throw new Exception("Диапазон значений элементов должен следовать правилу (от < до)");
                }
                FillMas(mas,a,b);//filling in the array
                System.out.println("Исходный массив");
                DisplayMas(mas);//display an array mas
                System.out.println("Введите число, которое нужно удалить из массива");
                int number = in.nextInt();
                DelArray(mas,number);//deleting a number from an array
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static int[] FillMas(int[] mas,int a,int b){

        for (int i=0;i < mas.length;i++){
            mas[i] = a + (int)Math.round(Math.random()*(b-a));
        }
        return mas;
    }

    public static void DisplayMas(int[] mas){

        System.out.println(Arrays.toString(mas));
    }

    public static void DelArray(int mas[],int number){

        int count = 0;
        for (int i=0;i<mas.length;i++){
            if (mas[i] == number){
                count++;
            }
            else{
                mas[i-count] = mas[i];
            }
        }
        int copyMas[] = Arrays.copyOf(mas,mas.length-count);
        System.out.println("Получен массив");
        DisplayMas(copyMas);
    }
}
