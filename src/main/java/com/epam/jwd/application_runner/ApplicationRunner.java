package com.epam.jwd.application_runner;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ApplicationRunner {

    public static void main(String[] args) {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream("Test.txt"), "UTF-8"))){

            String s = "";
            StringBuilder builder = new StringBuilder();

            while((s = reader.readLine()) != null){
                builder.append(s).append("\n");
            }

            System.out.println(builder);
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
