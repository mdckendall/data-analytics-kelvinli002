import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.InputMismatchException;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) throws FileNotFoundException {
    ArrayList<String> namesList = new ArrayList<>();
    FileReader namesReader = new FileReader("names.txt");
    Scanner namesScanner = new Scanner(namesReader);    
    Scanner sc = new Scanner(System.in);
    int choice;    
    boolean runnerino = true;

    while (runnerino) {
      System.out.println("Press 1 to learn about salary.");
      System.out.println("Press 2 to learn about the job.");
      System.out.println("Press 3 to learn about demand.");
      System.out.println("Press 4 to view current students.");
      System.out.println("Press 5 to quit.");
      
      try {
        choice = sc.nextInt();
      } catch (InputMismatchException ex) {
        Messages.invalidInput();
        sc.next();
        continue;
      }      
      switch (choice) {
        case 1:
          System.out.println("$98,345 average salary in South Florida!");
          break;
        case 2:
          System.out.println("US News - 100 Best Jobs!");
          break;
        case 3:
          System.out.println("Top 10 Forbes In-Demand Jobs!");
          break;
        case 4:
          System.out.println("Current Students:");
          try {
            while (runnerino) {
              namesList.add(namesScanner.nextLine());
            }
          } catch (NoSuchElementException ex) {
            
          }          
          for (int i = 0; i < namesList.size(); i++) {
            System.out.println(namesList.get(i));
          }          
          //System.out.println("All names printed (" + namesList.size() + " total)");          
          break;
        case 5:
          Messages.exitProgram();
          runnerino = false;
          break;
        default:
          Messages.invalidInput();
          continue;
      }
    }
    namesScanner.close();
    sc.close();
  }
}

class Messages {
  static void invalidInput() {
    System.out.println("Invalid input, try again...");
  }
  static void exitProgram() {
    System.out.println("Exiting program...");
  }
}