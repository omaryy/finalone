package com.company;

import java.util.Scanner;

public class BinarySearchTree {
    private static class BST{

        int distnination, repetition;
        double maximumrate;
        private class Node{
            int value;
            Node leftchild;
            Node rightchild;
            public Node(int v){
                this.value = v;
            }
        }
        Node root;
        public BST(double rate){
            maximumrate = rate;
        }
        private boolean contains(int v, Node currentNode){
            if(currentNode==null)
                return false;
            if(currentNode.value==v)
                return true;
            else if(currentNode.value < v){
                return contains(v, currentNode.rightchild);
            }else{
                return contains(v, currentNode.leftchild);
            }
        }
        private boolean checkRate(){
            if((1.00*(distnination+repetition)/distnination)>=maximumrate)
                return true;
            return false;
        }
        private void addNode(int v, Node currentNode){
            if(root==null){
                root = new Node(v);
            }else if(currentNode.value < v){
                if(currentNode.rightchild==null)
                    currentNode.rightchild = new Node(v);
                else
                    addNode(v, currentNode.rightchild);
            }else{
                if(currentNode.leftchild==null)
                    currentNode.leftchild = new Node(v);
                else
                    addNode(v, currentNode.leftchild);
            }
        }
        public boolean insert(int v){
            if(contains(v, root) || v==-1){
                if(v==-1){
                    System.out.println("ratio="+(distnination+repetition)+"/"+distnination+"="+(1.0*(distnination+repetition)/distnination)+"\n"+"only few repetitions");
                    return false;
                }
                repetition++;
                if(checkRate()){
                    System.out.println("ratio="+(distnination+repetition)+"/"+distnination+"="+(1.0*(distnination+repetition)/distnination)+"\n"+"many repetitions");
                    return false;
                }
            }else{
                distnination++;
                addNode(v, root);
            }
            return true;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double ratio = scanner.nextDouble();
        BST bst = new BST(ratio);
        while(true){
            int n = scanner.nextInt();
            if(bst.insert(n))
                continue;
            break;
        }
    }
}
