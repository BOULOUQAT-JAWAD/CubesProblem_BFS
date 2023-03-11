/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cubeproblem_bfs;

import java.util.*;

/**
 *
 * @author Lenovo
 */
public class Noeud {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private Stack<Integer> s3;

    public Noeud(){
        s1 = new Stack<>();
        s2 = new Stack<>();
        s3 = new Stack<>();
    }
    public void but(){
        List<List<Integer>> list_but = new ArrayList<>();
        List<Integer> L1 = new ArrayList<>();
        List<Integer> L2 = new ArrayList<>();

        for(int i = 1 ; i <= 3 ; i++)
            L1.add(i);
        list_but.add(L2);
        list_but.add(L2);
        list_but.add(L1);
        this.SetEtat(list_but);
    }
    public void Initial(){
        for(int i = 1 ; i <= 3 ; i++)
            s1.push(i);
    }
    
    public List<List<Integer>> GetEtat(){
        List<List<Integer>> stacks = new ArrayList<>();
        
        List<Integer> listInt1 = new ArrayList<>();
        for(Integer value : s1)
            listInt1.add(value);
        stacks.add(listInt1);

        List<Integer> listInt2 = new ArrayList<>();
        for(Integer value : s2)
            listInt2.add(value);
        stacks.add(listInt2);

        List<Integer> listInt3 = new ArrayList<>();
        for(Integer value : s3)
            listInt3.add(value);
        stacks.add(listInt3);
        
        return stacks;
    }
    
    public void SetEtat(List<List<Integer>> stacks){
        for(int element : stacks.get(0))
            s1.add(element);
        
        for(int element : stacks.get(1))
            s2.add(element);
        
        for(int element : stacks.get(2))
            s3.add(element);
    }

    public boolean Action(int i) {
        if(i > 0 && i < 7){
            if (i == 1) {
                // action1 s1 => s2
                if (!s1.isEmpty()) {
                    if (s2.size() < 3) {
                        s2.push(s1.pop());
                        return true;
                    }
                }
                return false;
            }
            if (i == 2) {
                // action2 s1 => s3
                if (!s1.isEmpty()) {
                    if (s3.size() < 3) {
                        s3.push(s1.pop());
                        return true;
                    }
                }
                return false;
            }
            if (i == 3) {
                // action3 s2 => s1
                if(!s2.isEmpty()){
                    if(s1.size() < 3){
                        s1.push(s2.pop());
                        return true;
                    }
                }
                return false;
            }
            if (i == 4) {
                // action4 s2 => s3
                if(!s2.isEmpty()){
                    if(s3.size() < 3){
                        s3.push(s2.pop());
                        return true;
                    }
                }
                return false;
            }
            if (i == 5) {
                // action5 s3 => s1
                if(!s3.isEmpty()){
                    if(s1.size() < 3){
                        s1.push(s3.pop());
                        return true;
                    }
                }
                return false;
            }
            else { // i == 6
                // action6 s3 => s2
                if(!s3.isEmpty()){
                    if(s2.size() < 3){
                        s2.push(s3.pop());
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        List<List<Integer>> stacks = GetEtat();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stacks.size(); i++) {
            sb.append("Stack ").append(i + 1).append(": ").append(stacks.get(i)).append("\n");
        }
        return sb.toString();
    }

}
