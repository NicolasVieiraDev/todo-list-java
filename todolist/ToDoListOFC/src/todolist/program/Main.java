package todolist.program;

import todolist.tarefa.Tarefa;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("WELCOME TO YOUR TO-DO LIST");
        System.out.println();

        List<Tarefa> tasks = new ArrayList<>();

        int option;
        do {
            System.out.println("[1] Add task");
            System.out.println("[2] List taSks");
            System.out.println("[3] Remove by ID");
            System.out.println("[4] Mark as completed");
            System.out.println("[0] End program");

            System.out.println();
            System.out.print("Option: ");
            option = sc.nextInt();

            if (option > 4 || option < 0){
                System.out.println("Please choose a valid option.");
                    continue;
            }

            switch (option){
                case 1:
                    System.out.print("Enter the ID(identifier) of your task: ");
                    Integer id = sc.nextInt();
                    System.out.print("Enter the task you will perform: ");
                    sc.nextLine();
                    String task = sc.nextLine();

                    Tarefa tarefa = new Tarefa(id, task);

                    tasks.add(tarefa);

                    System.out.println("Task added successfully!");

                    break;
                case 2:
                    System.out.println("Tasks: ");
                    for (Tarefa actv : tasks){
                        System.out.println("-" + actv);
                    }
                    break;

                case 3:
                    System.out.print("Enter the ID of task you want to remove: ");
                    id = sc.nextInt();

                    Tarefa toRemove = null;
                    for (Tarefa t : tasks) {
                        if (t.getId().equals(id)) {
                            toRemove = t;
                            break;
                        }
                    }

                    if (toRemove != null) {
                        tasks.remove(toRemove);
                        System.out.println("Task removed successfully!");
                    } else {
                        System.out.println("No task found with this ID.");
                    }
                    break;

                case 4:
                    System.out.print("Enter the ID of the task you want to mark as completed: ");
                    id = sc.nextInt();

                    Tarefa toComplete = null;
                    for (Tarefa t : tasks) {
                        if (t.getId().equals(id)) {
                            toComplete = t;
                            break;
                        }
                    }

                    if (toComplete != null) {
                        toComplete.setStats(true);
                        System.out.println("Task marked as completed!");
                    } else {
                        System.out.println("No task found with this ID.");
                    }

                    break;

                default:
                    System.out.println("Thank you for using our services, ending program.");
                    break;
            }
        } while (option != 0);
    }
}
