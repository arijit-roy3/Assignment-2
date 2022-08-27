package com.test;
import exceptions.PlayerNotFoundException;
import model.Player;

import java.util.*;
public class Test {
    public static void main(String[] args) throws PlayerNotFoundException {
        Scanner sc=new Scanner(System.in);
        Operations obj=new Operations();
        List<Player> list=new ArrayList<>();
        int count=20;//initial no of players are 20
        boolean isValidated=false;
        while(isValidated!=true){
            System.out.println("Taking initial input");
            System.out.println("Enter more than 3 bowlers and 1 wicket keeper");
            list=obj.initialInput(list);
            isValidated= obj.validateInitialTeam(list);
        }
        while(true){
            System.out.println("\t1\tDisplay All Players");
            System.out.println("\t2\tUpdate Player Information By Name");
            System.out.println("\t3\tDisplay Final Team");
            System.out.println("\t4\tAdd Player Information");
            System.out.println("\t5\tExit");
            System.out.println("Enter your choice");
            int ch=sc.nextInt();
            switch (ch){
                case 1:
                    obj.displayAllPlayers(list);
                    break;
                case 2:
                    list=obj.updateByName(list);
                    break;
                case 3:
                    obj.displayFinalTeam(list);
                    break;
                case 4:
                    count++;
                    list=obj.addPlayerInfo(list,count);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong Choice!!!");
            }
        }
    }
}
