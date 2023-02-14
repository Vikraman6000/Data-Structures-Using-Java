package Conceptual;

// Complete implementation of all functions

import java.util.Scanner;

public class MyLinkedList {

    static class Box {
        Box pointer;
        int data;

        public Box(int value) {
            this.data = value;
            this.pointer = null;
        }
    }

    static Scanner input = new Scanner(System.in);
    static MyLinkedList todo = new MyLinkedList();
    public Box head = null;
    public Box tail = null;
    public Box temp = null;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        todo.print();
        int option = input.nextInt();
        todo.start(option);
    }
    public void print(){
        System.out.println("\nWelcome to My Linked List\n");
        System.out.println("************************");
        System.out.println("Main Menu");
        System.out.println("1.Insert\n2.Delete\n3.Display\n4.Exit");
        System.out.println("************************");
        System.out.println("Insert Menu");
        System.out.println("1.Insert at the beginning\n2.Insert at the end");
        System.out.println("3.Insert Multiple elements\n4.Go back");
        System.out.println("************************");
        System.out.println("Delete Menu");
        System.out.println("1.Delete at beginning\n2.Delete at the end\n3.Go back");
        System.out.println("************************\n");
        System.out.println("Main Menu-Option:");
    }
    public void start(int num) {

        switch (num) {
            case 1:
                todo.insert();
                todo.switcher();
                break;
            case 2:
                todo.delete();
                todo.switcher();
                break;
            case 3:
                todo.display();
                todo.switcher();
                break;
            case 4:
                System.out.println("Thank You!!");
                return;

            default:
                System.out.println("Enter a valid option:");
                num = input.nextInt();
                todo.start(num);
        }
    }
    public void switcher(){
        System.out.println("\n___Going back to MainMenu___\nEnter an option:");
        int opt = input.nextInt();
        todo.start(opt);
    }

    public void insert() {

        System.out.println("Insert-Option:");
        int option = input.nextInt();
        switch (option) {
            case 1:
                System.out.println("Enter the element to be inserted at the start:");
                int element1 = input.nextInt();
                todo.insertFirst(element1);
                break;
            case 2:
                System.out.println("Enter the element to be inserted at the end:");
                int element2  = input.nextInt();
                todo.insertLast(element2);
                break;
            case 3:
                todo.superInsert();
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid Option");
        }
    }
    public void delete() {
        System.out.println("Delete-Option:");
        int option = input.nextInt();

        switch (option) {
            case 1:
                todo.deleteFirst();
                break;
            case 2:
                todo.deleteLast();
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid Option");
                todo.delete();
        }
    }
    public void display() {
        Box current = head;
        if(head == null) {
            System.out.println("List is empty");
        }else{
            System.out.println("The linked list is: ");
            while(current != null) {
                System.out.print(" ->"+current.data );
                current = current.pointer;
            }
            System.out.println();
        }
    }

    public void insertFirst(int value) {
        Box newValue = new Box(value);
        if(head==null){
            head = newValue;
            tail = newValue;
        }else {
            temp = head;
            head = newValue;
            head.pointer = temp;
        }
    }
    public void insertLast(int value) {
        Box newValue = new Box(value);
        if(head==null){
            head = newValue;
            tail = newValue;
        }else {
            temp = tail;
            tail = newValue;
            temp.pointer = tail;
        }
    }
    public void superInsert() {
        System.out.println("Disclaimer : Element gets inserted at the end");
        System.out.println("Press -999 to stop inserting");
        System.out.println("Enter the elements:");
        int element = input.nextInt();
        while(element!=-999){
            Box newValue = new Box(element);
            if(head==null){
                head = newValue;
                tail = newValue;
            }else {
                temp = tail;
                tail = newValue;
                temp.pointer = tail;
            }
            element = input.nextInt();
        }

    }

    public void deleteFirst() {
        if(head==null){
            System.out.println("The List is already empty");
        }else if(head.pointer==null){
            head = null;
        }else{
            temp = head.pointer;
            head = temp;
        }
    }
    public void deleteLast() {
        if(head==null){
            System.out.println("The List is already empty");
        }else if(head.pointer==null){
            head = null;
        }else{
            temp = head;
            while(!(temp.pointer==tail)){
                temp = temp.pointer;
            }
            tail = temp;
            tail.pointer = null;
        }
    }
}
