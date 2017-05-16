package lesson4;

import java.util.ArrayList;

public class Admin {

    void delete_worker (ArrayList<Worker> workers, int index) {
        workers.remove(index);
    }

    void set_salary (ArrayList<Worker> workers, int index, int salary, String comment) {
        Worker worker = workers.get(index);
        worker.setSalary(salary);
        worker.add_history_note(salary, comment);
        workers.set(index, worker);
    }

    void show_history (ArrayList<Worker> workers, int index) {
        workers.get(index).show_history();
    }
}
