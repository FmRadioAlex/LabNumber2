package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class Persons {
    boolean isCorrectly = false;
    double deposit;
    int contractTerm;
   Scanner in= new Scanner(System.in);
   private Person[] list;

   public Person[] getList(){
       return list;
   }
   public  Persons(){
       Person[] Person=new Person[0];
   }
    public Persons(int length) {
        this.list = new Person[length];
    }

    public void add(Person person, int id) {
        this.list[id - 1] = person;
    }
    public String print() {
        String persons = "";
        for (int i = 0; i < this.list.length; i++) {
            persons += ("\nFIO: " + this.list[i].FIO
                    + '\n' + "Номер договора: " + (i + 1)
                    + '\n' + "Домашний адресс: "
                    + this.list[i].address
                    + '\n' + "Депозит: "
                    + this.list[i].deposit
                    + '\n' + "Срок договора: "
                    + this.list[i].contractTerm + '\n');
        }
        return persons;
    }
    public String remove(String surname) {
        for (int i = 0; i < this.list.length; i++) {
            if (this.list[i].FIO.contains(surname)) {
                this.list[i].FIO = null;
                this.list[i].contractTerm = 0;
                this.list[i].deposit = 0;
                this.list[i].address = null;
            }
        }
        return ("Такой фамилии не существует!");
    }
    public String getDataByFullName(String surname) {
        for (int i = 0; i < this.list.length; i++) {
            if (this.list[i].FIO != null) {
                if (this.list[i].FIO.contains(surname)) {
                    isCorrectly = true;
                    return ("FIO: " + this.list[i].FIO
                            + '\n' + "Номер договора: " + (i + 1)
                            + '\n' + "Домашний адресс: "
                            + this.list[i].address + '\n'
                            + "Депозит: " +
                            this.list[i].deposit
                            + '\n' + "Срок договора: "
                            + this.list[i].contractTerm + '\n');

                }
            }
        }
        return ("Такой клиент не найден!");
    }
    public String getDataByPrice(String deposit){
        for (int i = 0; i < this.list.length; i++) {
            if (this.deposit < this.list[i].deposit) {
                return ("FIO: " + this.list[i].FIO
                        + '\n' + "Номер договора: " + (i + 1)
                        + '\n' + "Домашний адресс: "
                        + this.list[i].address + '\n'
                        + "Депозит: " +
                        this.list[i].deposit
                        + '\n' + "Срок договора: "
                        + this.list[i].contractTerm + '\n');
            } else if (i == this.list.length - 1) {
                return ("Такого вклада не существует!");
            }
        }
        return null;
    }
    public String getDataTermin(String mounth) {
        for (int i = 0; i < this.list.length; i++) {
            if (this.contractTerm < this.list[i].contractTerm) {
                return ("FIO: " + this.list[i].FIO
                        + '\n' + "Номер договора: " + (i + 1)
                        + '\n' + "Домашний адресс: "
                        + this.list[i].address + '\n'
                        + "Депозит: " +
                        this.list[i].deposit
                        + '\n' + "Срок договора: "
                        + this.list[i].contractTerm + '\n');            } else if (i == this.list.length - 1) {
                return ("Вклады с более 12 месяцев не найдено!");
            }
        }
        return null;
    }
   
}
