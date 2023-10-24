
package com.mycompany.tablica_ogloszen;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
import java.nio.file.FileSystem;
import java.util.Scanner;

import model.NoticeBoard;
import view.View;
import model.Functions;
/**
 * @author Jagoda Więcek
 */
public class Tablica_ogloszen {

    public static void main(String[] args) throws FileNotFoundException {
        int numberOfParameters = args.length;
        View obj = new View();
        NoticeBoard noticeBoard = new NoticeBoard();
        if(numberOfParameters==1){
            
            if(args[0].equals("display") || args[0].equals("Display") ){
                
                Scanner input = new Scanner(new File("Tytuly.txt")); ///
                List<String> titles = new ArrayList();
                Functions functions = new Functions();
                functions.uploadData(titles, input);
                System.out.println(args[0]);
            }
            else if(args[0].equals("add") || args[0].equals("Add"))
            {
                Scanner author = new Scanner(System.in);
                Scanner title = new Scanner(System.in);
                Scanner text = new Scanner(System.in);
                System.out.print(args[0]);
            }
        } else{
            obj.wrongParameters();
        }
     }
    }

