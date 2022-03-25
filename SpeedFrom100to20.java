// for speed values 100 to 20

import java.io.*;
import java.util.*;

public class SpeedFrom100to20{
   public static void main(String[]args) throws FileNotFoundException{
      
      Scanner console = new Scanner(System.in);
      System.out.print("file name (put .txt at end of file name): "); //have to add .txt to end of file name 
      String filename = console.next();
      Scanner file = new Scanner(new File(filename));
      System.out.println();
      
      PrintStream output = new PrintStream(new File("Speed20.txt"));
      
      int numberOfCols = getNumCols(file);
      Scanner file1 = new Scanner(new File(filename));
      double[][] values = new double[100][numberOfCols];
      getArray(file1, values, numberOfCols);
      average(values, numberOfCols, output);
   }
   
   public static int getNumCols(Scanner file){
      Scanner lineScanner = new Scanner(file.nextLine());
      int numberOfCols = 0;
      while (lineScanner.hasNextDouble()) {
         lineScanner.nextDouble();
         numberOfCols++;
      }
      return numberOfCols;
   }
   
   public static void getArray(Scanner file1, double[][] values, int numberOfCols){
      for (int i = 0; i < 99; i++) {
         Scanner lineScanner = new Scanner(file1.nextLine());
         for (int j = 0; j < numberOfCols ; j++){
            values[i][j] = lineScanner.nextDouble();
         }
      }
   }
   
   public static void average(double[][] values, int numberOfCols, PrintStream output){ 
      for (int i = 0; i < 99; i += 5) {
         for (int j = 0; j < numberOfCols; j++) {
            double average = 0;
            for (int k = 0; k < 5; k++){
               average += values[i + k][j];
            }
            average /= 5;
            output.print(average + "/t");
         }
         output.println();
      }
   }
}