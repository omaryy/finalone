package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Hashing {
    public static class HashMap{
        private int[] myhashtable;
        public HashMap(){
            myhashtable = new int[256];
        }
        public int[] getMaximumoccurence(){
            int [] answer = new int[2];
            for(int i = 0; i < 256; ++i){
                if(myhashtable[i]>answer[0]){
                    answer[0] = myhashtable[i];
                    answer[1] = i;
                }
            }
            return answer;
        }
        public void insert(char nchar){
            myhashtable[nchar]++;
        }

    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String newString = scanner.nextLine();
        HashMap hashtable = new HashMap();
        for(char nchar : newString.toCharArray()){
            hashtable.insert(nchar);
        }
        int[] ans = hashtable.getMaximumoccurence();
        System.out.println(((char)ans[1])+" "+ans[0]);
    }
}
