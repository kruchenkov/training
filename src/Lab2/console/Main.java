package Lab2.console;

import Lab2.repository.BookRepositoryImpl;

import java.awt.print.Book;
import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input file name");
        String fileName = sc.nextLine();
        System.out.println("Input letter");
        char letter = sc.next().charAt(0);
        BookRepositoryImpl bookRepository = new BookRepositoryImpl(fileName, letter);
        sc.close();

    }
}
