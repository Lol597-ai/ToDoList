import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    
    // Deklaration der Liste und des Scanners 
    private static ArrayList<String> tasks = new ArrayList<>(); 
    private static Scanner s = new Scanner(System.in);
    static boolean menue = true;
    
    public static void main(String[] args) {
        
        while(menue){
            System.out.println("\nMenu:");
            System.out.println("1. Add Task ");
            System.out.println("2. Delete Task ");
            System.out.println("3. View Tasks ");
            System.out.println("4. Close operation");

            System.out.print("Enter your choice: ");
            
            //User Eingabe 
            int choice = s.nextInt();  
            s.nextLine();  // Konsumiert das neue Zeilenzeichen nach nextInt()
              
            // Switch-Case
            switch(choice) {
                case 1: // add Task    
                    addTask();
                    break;

                case 2: // delete Task
                    deleteTask();
                    break;

                case 3: // View Task
                    viewTasks();
                    break;

                case 4: //close Operation
                    System.out.println("Exiting...");
                    menue = false;
                    break;
                
                default: // Default
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void addTask() {
        System.out.print("Enter the task description: ");
        String task = s.nextLine();  // Nimmt die Benutzereingabe entgegen
        tasks.add(task);  // Fügt die Aufgabe zur Liste hinzu
        System.out.println("Task '" + task + "' added.");
    }

    public static void deleteTask() {
        viewTasks();
        System.out.print("Enter Task Number: ");
        try {
            int taskNum = Integer.parseInt(s.nextLine());
            if (taskNum < 1 || taskNum > tasks.size()) {
                System.out.println("Invalid task number.");
                return;
            }
            String removedTask = tasks.remove(taskNum - 1);  // Korrektur der eins-basierten Indexierung
            System.out.println("Task '" + removedTask + "' deleted.");
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("Invalid task number.");
        }
    }

    public static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
}
