import java.util.Scanner;

class StudentSystem {

    static int id[] = new int[100];
    static String name[] = new String[100];
    static double avg[] = new double[100];

    static int count = 0;

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {

            System.out.println("\n===== Student Record System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Leaderboard");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    id[count] = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    name[count] = sc.nextLine();

                    System.out.print("Enter Average Marks: ");
                    avg[count] = sc.nextDouble();

                    count++;

                    System.out.println("Student Added!");
                    break;

                case 2:
                    System.out.println("\nID\tName\tAverage");

                    for (int i = 0; i < count; i++) {

                        System.out.println(id[i] + "\t" + name[i] + "\t" + avg[i]);

                    }

                    break;

                case 3:

                    System.out.print("Enter ID to search: ");
                    int search = sc.nextInt();

                    for (int i = 0; i < count; i++) {

                        if (id[i] == search) {

                            System.out.println("Student Found:");
                            System.out.println(name[i] + " Avg: " + avg[i]);

                        }

                    }

                    break;

                case 4:

                    System.out.print("Enter ID to delete: ");
                    int del = sc.nextInt();

                    for (int i = 0; i < count; i++) {

                        if (id[i] == del) {

                            for (int j = i; j < count - 1; j++) {

                                id[j] = id[j + 1];
                                name[j] = name[j + 1];
                                avg[j] = avg[j + 1];

                            }

                            count--;
                            System.out.println("Student Deleted");

                        }

                    }

                    break;

                case 5:

                    for (int i = 0; i < count - 1; i++) {

                        for (int j = 0; j < count - i - 1; j++) {

                            if (avg[j] < avg[j + 1]) {

                                double temp = avg[j];
                                avg[j] = avg[j + 1];
                                avg[j + 1] = temp;

                                int tempid = id[j];
                                id[j] = id[j + 1];
                                id[j + 1] = tempid;

                                String tempname = name[j];
                                name[j] = name[j + 1];
                                name[j + 1] = tempname;

                            }

                        }

                    }

                    System.out.println("\n===== Leaderboard =====");

                    for (int i = 0; i < count; i++) {

                        System.out.println((i + 1) + ". " + name[i] + " - " + avg[i]);

                    }

                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");

            }

        } while (choice != 6);

    }

}