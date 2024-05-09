import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.sun.source.util.TaskEvent;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;


import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userInput = choiceDetect();
        ArrayList<ToDo> tasks = new ArrayList<>();
        try {
            while (!(userInput.equals("0"))) {
                if (userInput.equals("1")) {
                    choice1(tasks);
                    userInput = choiceDetect();
                }
                if (userInput.equals("2")) {
                    choice2(tasks);
                    userInput = choiceDetect();
                }

                if (userInput.equals("3")) {
                    choice3(tasks);
                    userInput = choiceDetect();
                }

                if (userInput.equals("4")) {
                    choice4(tasks);
                    userInput = choiceDetect();
                }

                if (userInput.equals("5")) {
                    choice5();
                    userInput = choiceDetect();
                }
                if (!(userInput.equals("1") || userInput.equals("2") || userInput.equals("3") || userInput.equals("4") || userInput.equals("5"))) {
                    System.out.println("That is not a function, try again or type 5 for help.");
                    userInput = choiceDetect();
                    deserialize(tasks);
                }
            }
            serialize(tasks);
        } catch (Exception e){
            System.out.println("Sorry for the inconvenience, but, something went wrong, please restart.");
        }
    }
    public static String wholeNumber (String a) {
        Scanner input = new Scanner(System.in);
        while (!(a.equals("1") || a.equals("2") || a.equals("3") || a.equals("4") || a.equals("5") || a.equals("0"))) {
            System.out.println("Sorry, that is not an input, please try again.");
            a = input.nextLine();
        }
        return a;
    }
    public static int wholeNumber (int a) {
        Scanner input = new Scanner(System.in);
        while (!(a == 1) || (a == 2) || (a == 3) || (a == 4) || (a == 5) || (a == 0)) {
            System.out.println("Sorry, that is not an input, please try again.");
            a = input.nextInt();
        }
        return a;
    }
    public static String choiceDetect(){
        Scanner a = new Scanner(System.in);
        System.out.println("What do you want to do? (Press 5 for help)");
        return wholeNumber(a.nextLine());
    }
    public static String choice1(ArrayList<ToDo> tasks){
        Scanner input = new Scanner(System.in);
        System.out.println("What is the title of the task?");
        String title = input.nextLine();
        System.out.println("What is the description of the task?");
        String desc = input.nextLine();
        System.out.println("What is the priority of the task?");
        String priority = input.nextLine();
        priority = wholeNumber(priority);
        ToDo task = new ToDo(title, desc, priority);
        tasks.add(task);
        String blank = "";
        return blank;
    }
    static String choice2(ArrayList<ToDo> tasks){
        Scanner input = new Scanner(System.in);
        System.out.println("What's the index of the task you want to remove?");
        int remIndex = input.nextInt();
        remIndex = wholeNumber(remIndex);
        tasks.remove(remIndex - 1);
        String blank = "";
        return blank;
    }
    static String choice3(ArrayList<ToDo> tasks){
        Scanner input = new Scanner(System.in);
        System.out.println("Which task number do you want to update?");
        int upIndex = parseInt(input.nextLine());
        upIndex = wholeNumber(upIndex);
        System.out.println("What is the title of the updated task?");
        String title = input.nextLine();
        System.out.println("What is the description of the updated task?");
        String desc = input.nextLine();
        System.out.println("What is the priority of the updated task?");
        String priority = input.nextLine();
        priority = wholeNumber(priority);
        ToDo task = new ToDo(title, desc, priority);
        tasks.set((upIndex - 1), task);
        String blank = "";
        return blank;
    }
    static String choice4(ArrayList<ToDo> tasks){
        Collections.sort(tasks);
        System.out.println(tasks);
        String blank = "";
        return blank;
    }
    static String choice5(){
        System.out.println("(1) Add a task.\n(2) Remove a task.\n(3) Update a task.\n(4) List all tasks.\n(0) Exit.");
        String blank = "";
        return blank;
    }
    static String serialize(ArrayList<ToDo> tasks){
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("jsontasks.json")){
            gson.toJson(tasks, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String blank = "";
        return blank;
    }
    static String deserialize(ArrayList<ToDo> tasks){
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<ToDo>>(){}.getType();
        JsonParser parser = new JsonParser();
        try (FileReader reader = new FileReader("jsontasks.json")){
            JsonElement jsonElement = parser.parse(reader);
            tasks = gson.fromJson(jsonElement,type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String blank = "";
        return blank;
    }
}
