package lesson4;

import java.util.ArrayList;
import java.util.Date;

public class Worker {
    private String full_name;
    private String position;
    private String phone;
    private int salary;
    private int age;
    private ArrayList<ElementOfHistory> history = new ArrayList<ElementOfHistory>();

    Worker () { }

    Worker (String full_name, String position, String phone, int salary, int age) {
        this.full_name = full_name;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    private class ElementOfHistory {
        private Date date;
        private int salary;
        private String comment;


        ElementOfHistory (int salary, String comment) {
            this.date = new Date();
            this.salary = salary;
            this.comment = comment;
        }
    }

    void add_history_note (int salary, String comment) {
        history.add(new ElementOfHistory(salary, comment));
    }

    void show_history () {
        System.out.println("Дата" + "\t\t\t\t\t\t\t" + "Зарплата" + "\t\t" + "Комментарий");
        for (ElementOfHistory element : history) {
            System.out.println(element.date + "\t" + element.salary + "\t\t\t\t" + element.comment);
        }
    }

//  Геттеры
    String getFull_name () { return full_name; }
    String getPosition () {
        return position;
    }
    String getPhone () {
        return phone;
    }
    int getSalary () {
        return salary;
    }
    int getAge () {
        return age;
    }

//  Сеттеры
    void setFullname (String full_name) {
        this.full_name = full_name;
    }
    void setPosition (String position) {
        this.position = position;
    }
    void setPhone (String phone) {
        this.phone = phone;
    }
    void setSalary (int salary) { this.salary = salary; }
    void setAge (int age) {
        this.age = age;
    }
}
