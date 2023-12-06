package Task;

import java.util.ArrayList;
import java.util.Scanner;

//Создать коллекцию класса ArrayList наполнить ее элементами типа Integer. С помощью
//Stream'ов:
//- Удалить дубликаты
//- Оставить только четные элементы
//- Вывести сумму оставшихся элементов в стриме
public class OneMain {
    public static void main(String[] args) {
        final int SIZE_ARRAY;
        Scanner scanner=new Scanner(System.in);
        System.out.print("Введите размер вашей коллекции: ");
        SIZE_ARRAY=scanner.nextInt();
        ArrayList<Integer> myArray=new ArrayList<>();
        for(int i=0;i<SIZE_ARRAY;i++){
            System.out.print("Ваш " + (i+1) +")" + " элемент коллекции: ");
            myArray.add(scanner.nextInt());
        }
        System.out.println("Ваша коллекция: " + myArray);
        ArrayList<Integer> myCollection = new ArrayList<>();
        myArray.stream().
                distinct().
                filter(x->x>0).
                forEach(x->myCollection.add(x));
        System.out.println(myCollection);
        int sum=myCollection.stream().reduce(0,Integer::sum);
        System.out.println("Ваша сумма оставшихся элементов: " + sum);
    }
}
