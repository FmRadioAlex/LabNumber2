

package com.company;

import java.util.Scanner;

public class Main {
    public static Persons persons;

    public static void main(String[] args) {
        persons = new Persons(10);

        persons.add(new Person("Атанасов Александр Александровичь", "г.Одесса, ул.филатова 5",      500, 6),      1);
        persons.add(new Person("Кочкин Виталий Сергеевич", "г.Львов, вул.Говорова 2",               12000, 20),            2);
        persons.add(new Person("Павловский Александр Александровичь", "г.АТ-172, Проспект Шевченка", 20, 1), 3);
        persons.add(new Person("На деревню дедушке", "г.Киев, вул.Черняховского 7Б",                47000, 16),             4);
        persons.add(new Person("Акакий Акакъевичь Башмачкин", "г.Одесса, вул.Дерибасовская 34",     2310, 6),     5);
        persons.add(new Person("Мартынюк Никита Староста", "г.Южный, вул.Житомерская 43",           5400, 12),     6);
        persons.add(new Person("Златов Евгений Евгениевич", "г.Одесса, вул.Добровольского 2А",      3400, 14),     7);
        persons.add(new Person("Сиваченко Максим Виталъевичь", "г.Одесса, вул.Гоголя",              50, 6),     8);
        persons.add(new Person("Грибанов Борис Бритва", "г.Одесса, вул.Королева",                   1, 1),     9);
        persons.add(new Person("Фотеско Владислав Александровичь", "г.Одесса, вул.Проспект Шевченка 2А", 20000000, 35),     10);

        Menu();
    }

    public static void Menu() {
        int menuNumber;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите требуемый пункт: " +
                    "\n1) Выдача сведений о каждом из вкладчиков по фамилии: " +
                    "\n2) Выдача сведений о вкладчиках, вклад которых превышает заданную сумму: " +
                    "\n3) Выдача сведений о вкладчиках, у которых срок договора свыше 12 месяцев: " +
                    "\n4) Удаление записей о вкладчиках с заданной фамилией: " +
                    "\n5) Просмотр полного списка: " +
                    "\n6) Выход" +
                    "\n Введите нужный пункт и нажмите Enter:");
            boolean isCorrectly = false;
            String tempMenuNumber="";
            while (!isCorrectly) {
                tempMenuNumber = scanner.next();
                scanner.nextLine();
                if(tempMenuNumber.matches("[1-5,0]{1}")){
                    isCorrectly=true;
                }
                else {
                    System.out.println("Введите корректное значение: ");
                }
            }
            menuNumber = Integer.parseInt(tempMenuNumber);
            switch (menuNumber){
                case 1: {
                    isCorrectly = false;
                    while (!isCorrectly){
                        System.out.println("Введите фамилию клиента: ");
                        String Surname = scanner.next();
                        if (Surname.matches("[А-Я][а-я]{4,}")){
                            System.out.println(persons.getDataByFullName(Surname));
                            isCorrectly=true;
                        }
                        else {
                            System.out.println("Фамилия введена не правильно!");
                        }
                    }
                }break;

                case 2: {
                    isCorrectly= false; {
                        String deposit;
                        System.out.println("Введите сумму вклада: ");
                        deposit = scanner.next();
                        if (deposit.matches("[0-100000]")){
                            System.out.println(persons.getDataByPrice(deposit));
                            isCorrectly = true;
                        }
                        else {
                            System.out.println("Превышение заданной суммы, введите другое значение:");
                        }
                    }
                }
                case 3:{
                    String contractTermin;
                    System.out.println("Введите число из условия: ");
                    contractTermin = scanner.next();
                    System.out.println(persons.getDataTermin(contractTermin));
                }

                case 4:{
                    isCorrectly = false;
                    while (!isCorrectly){
                        System.out.println("Введите фамилию клиента: ");
                        String Surname = scanner.next();
                        if (Surname.matches("[А-Я][а-я]{4,}")){
                            System.out.println(persons.remove(Surname));
                            isCorrectly=true;
                        }
                        else {
                            System.out.println("Фамилия введена не правильно!");
                        }
                    }
                }break;

                case 5:
                {System.out.println(persons.print());}
                case 6: System.exit(0);break;
                default:System.out.println("Введите номер из списка!"); menuNumber=0;
            }
        }
    }
}