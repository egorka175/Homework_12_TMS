package com.tms.Homework_12_TMS.Homework_12_TMS_ex0;



import java.io.*;
import java.util.*;

public class SortDocNum {


    public static void main(String[] args) {
        String docNum;
        Set<String> arrayDocNum = new HashSet<>();
        List<String> arrayDocName= new ArrayList<>();
        Map<String,String> arrayFileReport= new HashMap<>();
        //Цикл While который позволяет вводить файлы(путь и название файла) пока пользователь не введет значение 0.
        while (true) {
            //Выводит панель задач.
            System.out.println("Выберите: ");
            System.out.println("Для дальнейшего ввода файлов - 1 ");
            System.out.println("Для завершение программы - 0 ");
            System.out.println("Для проверки всех номеров документов на валидность - 2");
            System.out.println("-----------------------------");
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            System.out.println("-----------------------------");
            //Вводит путь файла и название файла.
            if (i == 1) {
                System.out.println("Введите путь к файлу и имя файла");
                Scanner scanner2 = new Scanner(System.in);
                String path = scanner2.nextLine();
                String nameDoc = scanner2.nextLine();
                System.out.println("----------------------------");
                //Добавляет названия документов в коллекцию ArrayList.
                arrayDocName.add(nameDoc);

                //Объявляем обект класса  BufferedReader для чтения из файла.
                try (BufferedReader fr = new BufferedReader(new FileReader(path))) {
                    System.out.println("Имя файла и номера документов этого файла.");
                    System.out.println("-----------------------------");
                    //Добавляет номера документов в массив HashSet.
                    //Выводит название файла и номера документов этого файла.
                    while ((docNum = fr.readLine()) != null) {
                        arrayDocNum.add(docNum);
                        System.out.println(nameDoc + "  " + docNum);
                    }
                    System.out.println("-----------------------------");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                }
                //Заканчивает работу программы , если пользователь ввел значение 0.
                 else if(i==0){
                    break;
                }
                // Объявляем обект класса BufferedWriter для записи в файл.
                try (BufferedWriter fileReport = new BufferedWriter(new FileWriter("C:\\Users\\User\\IdeaProjects\\p1\\src\\com\\tms\\Homework_12_TMS\\file-report.txt", true))) {
                //Проверка номера документа на валидность и записи этих номеров и коментариев к ним в массив HashMap..
                    if (i == 2) {
                    for (String item : arrayDocNum) {
                        if (item.length() == 15 && item.startsWith("docNum")) {
                             arrayFileReport.put(item, "Документ валиден");
                        } else {
                            arrayFileReport.put(item,"Номер документа не валиден так, как не начинается с последовательности символов (docnum) или его длина (>) или (<) 15 символов" );
                        }
                    }
                }
                    //Запись элементов массива HashMap в один файл отчет.
                fileReport.write(String.valueOf(arrayFileReport));
                }  catch (FileNotFoundException e) {
                e.printStackTrace();
                } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

