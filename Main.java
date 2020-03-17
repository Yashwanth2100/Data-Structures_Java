package com.company;

import javax.swing.*;
import java.util.*;
class node{
    node left,right;
    int data;
}
public class Main {
    static Scanner in = new Scanner(System.in);

    static boolean search(node root, int key) {
        if (root == null) {
            return false;
        } else if (key == root.data) {
            return true;
        } else if (key < root.data) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    static node insert(node root, int key) {
        if (root == null) {
            root = new node();
            root.data = key;
            root.left = root.right = null;
            return root;
        } else if (key < root.data) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }return root;
    }
    static node Delete(node root,int key)
    {
        if(root==null)
        {
            return null;
        }else if(key<root.data)
        {
            root.left=Delete(root.left,key);
        }
        else if(key>root.data)
        {
            root.right=Delete(root.right,key);
        }
        else
        {
            if(root.left==null)
            {
                return root.right;
            }
            else if(root.right==null)
            {
                return root.left;
            }
            else
            {
                root.data=max(root.left);
                root.left=Delete(root.left,root.data);
            }

        }
        return root;
    }
    static int max(node root)
    {
        while(root.right!=null){
            root=root.right;
        }
        return root.data;
    }
    static void inorder(node root)
    {
        if (root!=null) {
            inorder(root.left);
            System.out.println(root.data + " ");
            inorder( root.right);
        }
    }
    static void preorder(node root)
    {
        if (root!=null) {
            System.out.println(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    static void postorder(node root)
    {
        if (root!=null)
            postorder(root.left);
        postorder(root.right);
        System.out.println(root.data+" ");
    }
    public static void main(String[]args) {
        node root = null;
        int option;
        while (true) {
            System.out.print("Enter Binary search tree"+"  ");
            System.out.println();
            System.out.println("1.Insertion \n2.Deletion \n3.Search \n4.Traversal \n5.Exit");
            option = in.nextInt();
            if (option > 5) {
                System.out.println("Invalid input");
            } else {
                switch (option) {
                    case 1:
                        System.out.println("Enter key to insert");
                        root = insert(root, in.nextInt());
                        inorder(root);
                        System.out.println();
                        break;
                    case 2:
                        System.out.println("Enter key to Delete");
                        root = Delete(root, in.nextInt());
                        inorder(root);
                        System.out.println();
                        break;
                    case 3:
                        System.out.println("Enter key to Delete");
                        if (search(root, in.nextInt())) {
                            System.out.println("Found");
                        } else {
                            System.out.println("Not Found");
                        }
                        System.out.println();
                        break;
                    case 4:
                        inorder(root);
                        System.out.println();
                        postorder(root);
                        System.out.println();
                        preorder(root);
                        System.out.println();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.print("Invalid");
                }

            }
              postorder(root);
        }
    }
}