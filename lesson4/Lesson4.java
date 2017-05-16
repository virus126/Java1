package lesson4;

import java.util.ArrayList;
import java.util.Scanner;

public class Lesson4 {
    static Scanner sc;

    static void print_list (ArrayList<Worker> workers) {
        System.out.println("СПИСОК СОТРУДНИКОВ");
        for (int i = 0; i < workers.size(); i++) {
            System.out.println((i + 1) + "\t" + workers.get(i).getPosition() + "\t" + workers.get(i).getFull_name());
        }
    }

    static ArrayList<Worker> initialize_list () {
        ArrayList<Worker> workers = new ArrayList<Worker>();
        workers.add(new Worker("Putin Vladimir Vladimirovich", "Mr.President", "1111111111", 200000, 64));
        workers.add(new Worker("Medvedev Dmitrii Anatolievich", "Mr.Lzhe-Dmitrii", "2222222222", 150000, 51));
        workers.add(new Worker("Peskov Dmitrii Sergeevich", "Mr.Bla-bla-bla", "3333333333", 100000, 49));
        workers.add(new Worker("Shoigu Sergei Kuzhugetovich", "Mr.Defense", "4444444444", 150000, 61));
        workers.add(new Worker("Barack Hussein Obama ", "Mr.Clown", "6666666666", 1, 15));
        return workers;
    }

    static void choice_1 (ArrayList<Worker> workers) {
        System.out.println("---------------------------------------------------------");
        System.out.println();
        print_list(workers);
    }

    static void choice_2 (ArrayList<Worker> workers, Admin admin) {
        while (true) {
            try {
                Worker worker = new Worker();
                System.out.println("---------------------------------------------------------");
                System.out.println();
                System.out.print("Введите ФИО сотрудника: ");
                sc = new Scanner(System.in);
                worker.setFullname(sc.nextLine());
                System.out.print("Введите должность сотрудника: ");
                worker.setPosition(sc.nextLine());
                System.out.print("Введите номер телефона сотрудника: ");
                worker.setPhone(sc.nextLine());
                System.out.print("Введите зарплату сотрудника: ");
                worker.setSalary(sc.nextInt());
                System.out.print("Введите возраст сотрудника: ");
                worker.setAge(sc.nextInt());
                workers.add(worker);
                return;
            } catch (Exception e) {
                System.out.println("Вы ввели неверное значение. Попробуйте еще раз");
            }
        }
    }

    static void choice_3 (ArrayList<Worker> workers, Admin admin) {
        while (true) {
            try {
                System.out.println("---------------------------------------------------------");
                System.out.println();
                print_list(workers);
                System.out.println();
                System.out.println((workers.size() + 1) + "\t" + "Назад");
                System.out.print("Выберите номер сотрудника: ");
                sc = new Scanner(System.in);
                int choice = sc.nextInt();
                if (choice >= 1 & choice <= workers.size()) {
                    // удаление сотрудника
                    admin.delete_worker(workers, choice - 1);
                    return;
                } else if (choice == workers.size() + 1)
                            return;
                       else
                            System.out.println("Вы ввели неверное значение. Попробуйте еще раз");
            } catch (Exception e) {
                System.out.println("Вы ввели неверное значение. Попробуйте еще раз");
            }
        }
    }

    static void choice_4 (ArrayList<Worker> workers, Admin admin) {
        while (true) {
            try {
                System.out.println("---------------------------------------------------------");
                System.out.println();
                print_list(workers);
                System.out.println();
                System.out.println((workers.size() + 1) + "\t" + "Назад");
                System.out.print("Выберите номер сотрудника: ");
                sc = new Scanner(System.in);
                int choice = sc.nextInt();
                if (choice >= 1 & choice <= workers.size()) {
                    // удаление сотрудника
                    System.out.print("Введите новую зарплату: ");
                    sc = new Scanner(System.in);
                    int salary = sc.nextInt();
                    System.out.print("Введите комментарий: ");
                    sc = new Scanner(System.in);
                    String comment = sc.nextLine();
                    admin.set_salary(workers, choice - 1, salary, comment);
                    return;
                } else if (choice == workers.size() + 1)
                            return;
                       else
                            System.out.println("Вы ввели неверное значение. Попробуйте еще раз");
            } catch (Exception e) {
                System.out.println("Вы ввели неверное значение. Попробуйте еще раз");
            }
        }
    }

    static void choice_5 (ArrayList<Worker> workers, Admin admin) {
        while (true) {
            try {
                System.out.println("---------------------------------------------------------");
                System.out.println();
                print_list(workers);
                System.out.println();
                System.out.println((workers.size() + 1) + "\t" + "Назад");
                System.out.print("Выберите номер сотрудника: ");
                sc = new Scanner(System.in);
                int choice = sc.nextInt();
                if (choice >= 1 & choice <= workers.size()) {
                    // удаление сотрудника
                    admin.show_history(workers, choice - 1);
                    return;
                } else if (choice == workers.size() + 1)
                            return;
                       else
                            System.out.println("Вы ввели неверное значение. Попробуйте еще раз");
            } catch (Exception e) {
                System.out.println("Вы ввели неверное значение. Попробуйте еще раз");
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Worker> workers = initialize_list();
        Admin admin;
        while (true) {
            System.out.print("Для доступа к функциям администратора введите пароль: ");
            sc = new Scanner(System.in);
            String s = sc.nextLine();
            if (s.equals("pass")) {
                admin = new Admin();
                System.out.println("Доступ к функциям администратора разрешен");
                break;
            }
            System.out.println("Вы ввели неверный пароль. Попробуйте еще раз");
            System.out.println("---------------------------------------------------------");
            System.out.println();
        }
        while (true) {
            try {
                System.out.println("---------------------------------------------------------");
                System.out.println();
                System.out.println("1. Распечатать список сотрудников");
                System.out.println("2. Добавить сотрудника");
                System.out.println("3. Удалить сотрудника");
                System.out.println("4. Изменить зарплату сотрудника");
                System.out.println("5. Распечатать историю сотрудника");
                System.out.println("6. Выход");
                System.out.println();
                System.out.print("Выберите пункт меню: ");
                sc = new Scanner(System.in);
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        choice_1(workers);
                        break;
                    case 2:
                        choice_2(workers, admin);
                        break;
                    case 3:
                        choice_3(workers, admin);
                        break;
                    case 4:
                        choice_4(workers, admin);
                        break;
                    case 5:
                        choice_5(workers,admin);
                        break;
                    case 6:
                        System.exit(0);
                    default:
                        System.out.println("Вы ввели неверное значение. Попробуйте еще раз");
                        System.out.println("---------------------------------------------------------");
                        System.out.println();
                }
            }
            catch (Exception e) {}
        }
    }
}
