package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class Utililty {

    static String readConsoleInput(){
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        return input;
    }

    static boolean isValidOption(String option, List<String> optionsList){
        boolean isValid = true;
        try{
            int options = Integer.parseInt(option);
            if(options > optionsList.size() ){
                isValid = false;
                System.out.println("Please, select a valid option!");
            }
        }catch(NumberFormatException e){
            System.out.println("Please, select a number");
            isValid = false;
        }
        return isValid;
    }

    static String concatList(List<String> newList){
        String result = "";
        for (String b: newList){
            result += b + "\n";
        }
        return result;
    }
}
