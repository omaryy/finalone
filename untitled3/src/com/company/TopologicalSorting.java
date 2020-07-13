package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TopologicalSorting {
    private static List<Integer>[] adjcentlist;
    private static int[] frequency;
    private static int maximum;
    private static void DFS(int v, int parent){
        for(int u : adjcentlist[v]){
            if(u != parent){
                DFS(u, v);
            }
        }
        maximum = Math.max(++frequency[v], maximum);
    }
    public static void main(String[] args){
        int n, m, r;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        r = scanner.nextInt();
        adjcentlist = new List[n+1];
        frequency = new int[n+1];
        for(int i=0;i<frequency.length;i++)
        {
            frequency[i]=0;
        }
        for(int i = 1; i <= n; ++i){
            adjcentlist[i] = new ArrayList<>();
        }
        while(m-->0){
            int a, b;
            a = scanner.nextInt();
            b = scanner.nextInt();
            adjcentlist[a].add(b);
        }
        DFS(r, -1);
        for(int i = 1; i <= n; ++i){
            if(frequency[i]==maximum){
                System.out.print(i+" ");
            }
        }
    }
}