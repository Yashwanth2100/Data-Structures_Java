package com.company;
import java.util.*;
public class DLL {
    static class Node {
        int data;
        Node next, prev;

        Node(int d) {
            data = d;
            next = null;
            prev = null;
        }

    }

    static Node head = null, tail = null;
    static Scanner sc = new Scanner(System.in);

    static void InsBeg(int v) {
        System.out.println("Enter data");
        Node temp = new Node(sc.nextInt());
        if (head == null)
            head = tail = temp;
        else {
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
    }

    static void Inspos(int p) {
        Node c = head;
        int count = 1;
        while (c != null) {
            if (count == p - 1)
                break;
            c = c.next;
            count++;
        }
        Node temp = null;
        if (c != null) {
            System.out.println("Enter data");
            temp = new Node(sc.nextInt());
            temp.next = c.next;
            if (c.next != null)
                c.next.prev = temp;
            c.next = temp;
            temp.prev = c;
        }
        if (c == tail)
            tail = temp;
        else {
            System.out.println("Invalid position");
        }
    }

    static void InsEnd(int m) {
        System.out.println("Enter data");
        Node temp = new Node(sc.nextInt());
        if (head == null)
            head = tail = temp;
        else {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
    }

    static void DeleteBeg() {
        Node temp = head;
        if (head == tail)
            head = tail = null;
        else {
            head = head.next;
            head.prev = null;
            temp.next = null;
            temp = null;
        }
    }

    static void DeletePos(int pos) {
        Node c = head, p = null;
        int count = 1;
        while (c != null) {
            if (count == pos)
                break;
            p = c;
            c = c.next;
            count++;
        }
        if (c != null) {
            if (head == tail)
                head = tail = null;
            else {
                p.next = c.next;
                if (c.next != null)
                    c.next.prev = p;
                if (c == tail)   //if it is last positioned element
                    tail = p;
                c.prev = null;
                c.next = null;
                c = null;
            }
        } else {
            System.out.println("Invalid position");
        }
    }

    static void Deleteend() {
        Node temp = tail;
        if (head == tail)
            head = tail = temp = null;
        else {

            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
            temp = null;
        }
    }

    static void displayfwd() {
        if (head == null)
            System.out.println("List is Empty");
        else {
            Node temp;
            temp = head;
            while (temp != null) {
                System.out.print(temp.data + "  ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    static void displaybwd() {
        if (head == null)
            System.out.println("List is Empty");
        else {
            Node temp = tail;
            while (temp != null) {
                System.out.print(temp.data + "  ");
                temp = temp.prev;
            }
            System.out.println();
        }
    }

    public boolean search(Node head, int x) {
        Node current = head;
        while (current != null) {
            if (current.data == x)
                return true;
            current = current.next;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner in =new Scanner (System.in);
        DLL dList= new DLL();
        while(true){
            System.out.println("Enter Operation of Linked list");
            System.out.println("1.insert at begining \n2.insert at pos \n3.insert at end \n4.delete at beginning \n5.delete at end \n6.delete at pos \n7.display \n8.Exit");
            int opt = in.nextInt();
            if (opt >8 )
            {System.out.println("Invalid input");}
            else
            {
                switch (opt) {
                    case 1:
                        System.out.println("Enter data of new node to be inserted at beginnig");
                        int v=in.nextInt();
                        dList.InsBeg(v);

                        break;
                    case 2:
                        System.out.println("Enter data of new node to be inserted at position");
                        int n=in.nextInt();
                        dList.Inspos(n);

                        break;
                    case 3:
                        System.out.println("Enter data of new node to be inserted at end");
                        int m= in.nextInt();
                        dList.InsEnd(m);

                        break;
                    case 4:
                        System.out.println("1st node will be deleted");
                        dList.DeleteBeg();

                        break;
                    case 5:
                        System.out.println("Last node will be deleted");
                        dList.Deleteend();

                        break;
                    case 6:
                        System.out.println("position node will be deleted ");
                        int l=in.nextInt();
                        dList.DeletePos(l);
                        break;
                    case 7:
                        System.out.println("Display fwd");
                        dList.displayfwd();
                        System.out.println("Display bwd");
                        dList.displaybwd();

                        break;
                    case 8:
                        System.out.println("Exit");
                        System.exit(0);
                        break;
                    default:
                        break;
                }
            }
        }

    }}