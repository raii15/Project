import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       Scanner fileIn;
        PrintWriter fileOut;
        String  fileNameIn;
        String fileNameOut;
        int dotIndex;
        String line =null;
        System.out.println("Enter file name or path");
        fileNameIn = sc.nextLine();
        try{
            fileIn =new Scanner(new FileReader(fileNameIn));
            dotIndex = fileNameIn.lastIndexOf(".");
            if(dotIndex == -1){
               fileNameOut = fileNameIn+".html";

            }else{
                fileNameOut = fileNameIn.substring(0,dotIndex)+".html";
            }fileOut = new PrintWriter(fileNameOut);
            try{
                line= fileIn.nextLine();
            }catch (NoSuchElementException e ){
                System.out.println("Error "+ e.getMessage());
            }
            if(line == null){
                System.out.println("This file is empty");
            }else{
                fileOut.println("<html>");
                fileOut.println("<head>");
                fileOut.println("</head>");
                fileOut.println("<body>");
                fileOut.println(line);

                while(fileIn.hasNextLine()){

                }
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }
}