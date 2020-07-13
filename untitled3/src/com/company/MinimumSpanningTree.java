package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinimumSpanningTree {
    private static class Node implements Comparable<Node>{
        int forward, weight;
        public Node(int forw, int weigh){
            forward= forw;
            weight = weigh;
        }
        @Override
        public int compareTo(Node otherEdge){
            return weight-otherEdge.weight;
        }
    }
    public static class myPriorityQueue<E extends Comparable<E>>{

        private int size;
        private E[] heap;
        public myPriorityQueue(int c){
            heap = (E[]) new Node[c];
            size=0;
        }
        public void add(E e){
            int i = size;
            heap[i] =  e;
            while(i > 0 && heap[parent(i)].compareTo(heap[i]) > 0){
                swap(parent(i), i);
                i = parent(i);
            }
            size++;
        }
        public boolean isEmpty(){
            return (size==0);
        }
        private int parent(int child){
            return (child-1)/2;
        }
        private int left(int i){
            return (2*i+1);
        }
        private int right(int i){
            return (2*i+2);
        }
        public void swap(int i, int j){
            E temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
        private void heapify(int i){
            int l = left(i);
            int r = right(i);
            int smallone = i;
            if (l < size && heap[l].compareTo(heap[i]) < 0)
                smallone = l;
            if (r < size && heap[r].compareTo(heap[smallone]) < 0)
                smallone = r;
            if (smallone != i)
            {
                swap(i, smallone);
                heapify(smallone);
            }
        }
        public E poll(){
            E root = heap[0];
            size--;
            if(size==0){
                return root;
            }
            heap[0] = heap[size];
            heapify(0);
            return root;
        }

    }
    private static List<Node>[] adjcentlist;
    private static int num, k, sum;
    public static void prim(){
        boolean[] visited = new boolean[num+1];
        myPriorityQueue<Node> piority = new myPriorityQueue<>(num+5);
        piority.add(new Node(1, 0));
        visited[1] = true;
        while(!piority.isEmpty()){
            Node e = piority.poll();
            sum-=(Math.abs(e.weight));
            for(Node u : adjcentlist[e.forward]){
                if(!visited[u.forward]){
                    visited[u.forward]=true;
                    piority.add(u);
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        k = scanner.nextInt();
        adjcentlist= new List[num+1];
        for(int i = 1; i <= num; ++i){
            adjcentlist[i] = new ArrayList<>();
        }
        sum = 0;
        while(k-->0){
            int one, two;
            one = scanner.nextInt();
            two = scanner.nextInt();
            adjcentlist[one].add(new Node(two, (-Math.abs(one-two))));
            adjcentlist[two].add(new Node(one, (-Math.abs(one-two))));
            sum+=Math.abs(one-two);
        }
        prim();
        System.out.println(sum);
    }
}
