package task2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Задание 2
        try {

            // a b c d 1 2 3 4 com1
            // aa b2 c dr 5 2 45 4 com2
            // 2a b2 c d 33 12 65 77 com1
            // a2 3b c df 44 21 4 12 com2

            boolean c = true;
            Scanner in = new Scanner(System.in);
            ArrayList<tour> t1 = new ArrayList<tour>();
            ArrayList t2 = new ArrayList<tour>();
            Filerw fi = new Filerw();
            while(c){
                System.out.println("1.Добавить тур\n2.Записать массив туров\n3.Прочитать из  файла 2го пункта и получить массив туров с заданной компанией" +
                        "\n4.Увеличить на 10% цену тура с указанным индексом среди туров из 3го пункта\n5.Выход");
                int a = Integer.parseInt(in.next());
                switch (a){
                    case 1:
                        System.out.println("Введите тур ");
                        tour t = new tour(in.next(), in.next(), in.next(), in.next(), Integer.parseInt(in.next()), Integer.parseInt(in.next()), Integer.parseInt(in.next()), Double.parseDouble(in.next()), in.next());
                        t1.add(t);
                        break;
                    case 2:
                        if (t1.isEmpty()){
                            System.out.println("Массив пуст");
                            break;
                        }
                        fi.write(t1);
                        break;
                    case 3:
                        if (t1.isEmpty()){
                            System.out.println("Массив пуст");
                            break;
                        }
                        System.out.println("Введите название компании");
                        String s = in.next();
                        t2 = fi.read(s);
                        System.out.println(t2.toString());
                        break;
                    case 4:
                        if (t2.isEmpty()){
                            System.out.println("Массив пуст");
                            break;
                        }
                        System.out.println("Введите индекс");
                        int i = in.nextInt();
                        fi.raf(t2, i);

                        break;
                    case 5:
                        c = false;
                        break;

                }
            }

             
        }catch (Exception e){
            System.out.println("Ошибка");
        }
    }
}