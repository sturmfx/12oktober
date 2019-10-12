package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static List<Person> persons = new ArrayList<Person>();
    public static JFrame windows = new JFrame();

    public static JTextField name = new JTextField("NAME");
    public static JTextField second_name = new JTextField("SECOND NAME");
    public static JTextField age = new JTextField("AGE");
    public static JButton add = new JButton("ADD PERSON");
    public static JButton print = new JButton("PRINT ALL");
    public static void main(String[] args)
    {
        add.addActionListener(e ->
        {
            persons.add(new Person(name.getText(), second_name.getText(), age.getText()));
        });
        print.addActionListener(e ->
        {
            printP();
        });
        windows.setSize(new Dimension(200, 500));
        windows.setLayout(new FlowLayout());
        windows.add(name);
        windows.add(second_name);
        windows.add(age);
        windows.add(add);
        windows.add(print);

        windows.setVisible(true);

        windows.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void printP()
    {
        String text = "";
        for(Person p: persons)
        {
            text = p.print();
        }
        try(FileWriter writer = new FileWriter("result.txt", false))
        {
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}

class Person
{
    String name = "";
    String second_name = "";
    String age = "";

    public Person(String name1, String second_name1, String age1)
    {
        name = name1;
        second_name = second_name1;
        age = age1;
    }

    public String print()
    {
        return name + " " + second_name + " " + age + "\n";
    }
}
