/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cubeproblem_bfs;

import java.util.*;

/**
 *
 * @author Lenovo
 */
public class Program {

    public static void main(String[] args) {

        //Noued Initial
        Noeud initial = new Noeud();
        initial.Initial();
        System.out.println("Noeud initial");
        System.out.println(initial);

        // noeud but
        Noeud BUT = new Noeud();
        BUT.but();
        System.out.println("Noeud But");
        System.out.println(BUT);

        System.out.println("Noeud solution(BFS)");
        Noeud solution = BFS(initial,BUT);
        System.out.println(solution);

        System.out.println("Noeud solution(DFS)");
        Noeud solution2 = DFS(initial,BUT);
        System.out.println(solution2);
    }

    //Algorithm Breadth first search
    public static Noeud BFS(Noeud initial, Noeud BUT){

        // si l'etat initial est le but
        if(compareLists(initial.GetEtat(),BUT.GetEtat())){
            return initial;
        }

        // le type List<List<Integer>> est le type de output GetEtat et input de SetEtat
        //création de la frontiere
        Queue<List<List<Integer>>> Frontiere = new LinkedList<>();
        Frontiere.offer(initial.GetEtat());

        // création de visité
        List<List<List<Integer>>> visite = new ArrayList<>();

        Noeud fils = null;
        Noeud noeud;
        while (true){

            if(Frontiere.isEmpty()) return null;

            fils = new Noeud();
            noeud = new Noeud();

            noeud.SetEtat(Frontiere.poll());
            visite.add(noeud.GetEtat());

            fils.SetEtat(noeud.GetEtat());

            // tester tous les actions
            for(int i = 1 ; i <= 6  ; i++){
                if(fils.Action(i)){
                    if(!Frontiere.contains(fils.GetEtat()) && !visite.contains(fils.GetEtat())){
                        if(compareLists(fils.GetEtat(),BUT.GetEtat())) {
                            return fils;
                        }
                        Frontiere.add(fils.GetEtat());
                        fils = new Noeud();
                        fils.SetEtat(noeud.GetEtat());
                    }
                }
            }
        }
    }

    //Algorithm Depth first search
    public static Noeud DFS(Noeud initial, Noeud BUT){

        // le type List<List<Integer>> est le type de output GetEtat et input de SetEtat
        //création de la frontiere
        Queue<List<List<Integer>>> Frontiere = new LinkedList<>();

        //Empiler dans la frontiere
        Frontiere.offer(initial.GetEtat());

        // création de visité
        List<List<List<Integer>>> visite = new ArrayList<>();

        Noeud fils = null;
        Noeud noeud;
        while (true){

            if(Frontiere.isEmpty()) return null;

            fils = new Noeud();
            noeud = new Noeud();

            noeud.SetEtat(Frontiere.poll());

            if(compareLists(noeud.GetEtat(),BUT.GetEtat())) return noeud;

            visite.add(noeud.GetEtat());

            fils.SetEtat(noeud.GetEtat());
            for(int i = 1 ; i <= 6  ; i++){
                if(fils.Action(i)) {
                    if(!Frontiere.contains(fils.GetEtat()) && !visite.contains(fils.GetEtat())){
                        Frontiere.add(fils.GetEtat());
                        fils = new Noeud();
                        fils.SetEtat(noeud.GetEtat());
                    }
                }
            }
        }
    }


    public static boolean compareLists(List<List<Integer>> list1, List<List<Integer>> list2) {
        // Compare sizes of the two lists
        if (list1.size() != list2.size()) {
            return false;
        }

        // Compare elements of the two lists
        for (int i = 0; i < list1.size(); i++) {
            List<Integer> subList1 = list1.get(i);
            List<Integer> subList2 = list2.get(i);

            // Compare sizes of the two sublists
            if (subList1.size() != subList2.size()) {
                return false;
            }

            // Compare elements of the two sublists
            for (int j = 0; j < subList1.size(); j++) {
                if (subList1.get(j) != subList2.get(j)) {
                    return false;
                }
            }
        }

        // Lists are equal
        return true;
    }

}
