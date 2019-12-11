package com.company;

    public class Person {
        String FIO;
        String contractNumber;
        String address;
        double deposit;
        int contractTerm;

        public Person(){
        }


        public Person(String FIO, String address, double deposit, int contractTerm) {
            this.FIO = FIO;
            this.address = address;
            this.deposit = deposit;
            this.contractTerm = contractTerm;
        }



    public static boolean CheckCorrectFIO(String str) {
        return str.matches("[А-Я][а-я]{4,}");
    }
  
    public static boolean CheckCorrectNumber(String str) {
        double deposit;
        try {
            deposit = Double.parseDouble(str) > 0 ? Double.parseDouble(str) : -1;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void String() {
        System.out.println( "Person{" +
                "FIO='" + FIO + '\'' +
                ", contractNumber='" + contractNumber + '\'' +
                ", address='" + address + '\'' +
                ", deposit=" + deposit +
                ", contractTerm=" + contractTerm +
                '}');
    }
}
