package org.akshay;

import com.google.gson.Gson;
import org.akshay.dto.Group;
import org.akshay.dto.SplitManager;
import org.akshay.dto.User;

import java.io.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class SplitMain {

    public static void main(String[] args) {
        SplitManager splitManager = readFromFile();
        terminalInput(splitManager);
        saveToJsonFile(splitManager);
    }
    public static void terminalInput(SplitManager splitManager) {
        Scanner scanner = new Scanner(System.in);
        printHelp();
        while (true) {
            System.out.print("> ");
            String input = scanner.next();
            switch (input){
                case "q","quit" :{
                    System.out.println("Exiting...");
                    return;
                }
                case "help","h":{
                    printHelp();
                    break;
                }
                case "add":{
                    String userName = scanner.next();
                    User user = splitManager.addUser(userName);
                    System.out.println("added user  : " + user);
                    break;
                }
                case "create":{
                    int userId = scanner.nextInt();
                    String groupName = scanner.next();
                    Group group = splitManager.addGroup(userId,groupName);
                    System.out.println("created group : " + group);
                    break;
                }
                case "list":{
                    String type = scanner.next();
                    if(type.equals("user"))   splitManager.getUsers().forEach(System.out::println);
                    if(type.equals("group"))  splitManager.getGroups().forEach(System.out::println);
                    break;
                }
                case "transaction":{
                    int userId  = scanner.nextInt();
                    int groupId = scanner.nextInt();
                    double amount = scanner.nextDouble();
                    int splitType = scanner.nextInt();
                   break;
                }
            }
            scanner.nextLine();
            System.out.println("Enter 'q' to quit q, print h for help");
        }
//        scanner.close();
    }
    public  static void printHelp(){
        System.out.println("h,help -> to print help");
        System.out.println("q,quit -> to quit the application");
        System.out.println("add user -> add userName , ex add ramesh");
        System.out.println("create group -> create userid groupName, ex add ramesh");
        System.out.println("list user/group -> list user/group , ex list user");


    }

    public static void saveToJsonFile(SplitManager splitManager) {
        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter("data.json")) {
            gson.toJson(splitManager, writer);
            System.out.println("Saved to person.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SplitManager readFromFile() {
        try (FileReader reader = new FileReader("data.json")) {
            SplitManager splitManager = new Gson().fromJson(reader,SplitManager.class);
            System.out.println("Loaded: " + splitManager);
            return splitManager;
        } catch (FileNotFoundException e) {
            System.err.println("File not found: data.json");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
        return  new SplitManager();
    }
}