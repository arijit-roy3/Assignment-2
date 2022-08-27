package com.test;

import exceptions.PlayerNotFoundException;
import model.Player;

import java.util.*;

public class Operations {
    Scanner sc=new Scanner(System.in);
    public List<Player> initialInput(List<Player> list) {
//        for(int i=1;i<=20;i++){
//            System.out.println("Enter player "+i+" Name, Matches Played, Runs Scored, Wickets Taken,Ducks and Player Type(Batsman, Bowler, Wicketkeeper)");
//            String name= sc.next();
//            int matches=sc.nextInt();
//            int runs=sc.nextInt();
//            int wickets=sc.nextInt();
//            int ducks=sc.nextInt();
//            String type=sc.next();
//            Player p=new Player(i,name,matches,runs,wickets,ducks,type);
//            list.add(p);
//        }
//        return list;
        //The following code is for testing
        Player p1=new Player(1,"A",10,100,1,0,"Batsman");
        list.add(p1);
        Player p2=new Player(2,"B",11,1111,1,1,"Batsman");
        list.add(p2);
        Player p3=new Player(3,"C",15,1209,2,2,"Batsman");
        list.add(p3);
        Player p4=new Player(4,"D",10,1120,1,0,"Batsman");
        list.add(p4);
        Player p5=new Player(5,"E",19,1909,1,0,"Batsman");
        list.add(p5);
        Player p6=new Player(6,"F",180,1907,10,7,"Batsman");
        list.add(p6);
        Player p7=new Player(7,"G",190,1201,1,9,"Batsman");
        list.add(p7);
        Player p8=new Player(8,"H",102,1780,11,3,"Batsman");
        list.add(p8);
        Player p9=new Player(9,"I",103,1609,1,0,"Batsman");
        list.add(p9);
        Player p10=new Player(10,"J",111,1108,1,0,"Batsman");
        list.add(p10);
        Player p11=new Player(11,"K",9,100,1,0,"Batsman");
        list.add(p11);
        Player p12=new Player(12,"L",13,1603,11,1,"Batsman");
        list.add(p12);
        Player p13=new Player(13,"M",10,3,101,0,"Bowler");
        list.add(p13);
        Player p14=new Player(14,"N",11,51,98,0,"Bowler");
        list.add(p14);
        Player p15=new Player(15,"O",12,62,77,0,"Bowler");
        list.add(p15);
        Player p16=new Player(16,"P",13,89,89,0,"Bowler");
        list.add(p16);
        Player p17=new Player(17,"Q",14,67,97,0,"Bowler");
        list.add(p17);
        Player p18=new Player(18,"R",15,9,109,0,"Bowler");
        list.add(p18);
        Player p19=new Player(19,"S",160,8902,0,0,"WicketKeeper");
        list.add(p19);
        Player p20=new Player(20,"T",17,790,0,0,"WicketKeeper");
        list.add(p20);
        return list;
    }
    public void displayAllPlayers(List<Player> list) {
        //
        list.sort((o1,o2)->o1.getName().compareTo(o2.getName()));
        System.out.println("ID\tName\tMatches Played\tRuns Scored\tWickets Taken\tDucks\tPlayer Type");
        for(Player p:list){
            System.out.println(p.getId()+"\t"+p.getName()+"\t"+p.getMatches()+"\t"+p.getRuns()+"\t"+p.getWickets()+"\t"+p.getDuck()+"\t"+p.getType());
        }
    }

    public List<Player> updateByName(List<Player> list) throws PlayerNotFoundException {
        try{
            String name= sc.next();
            boolean flag=false;
            for(Player p:list){
                if(p.getName().equalsIgnoreCase(name)){
                    System.out.println("Updating Info");
                    System.out.println("Enter Matches, Runs, Wickets, Ducks, Type");
                    p.setMatches(sc.nextInt());
                    p.setRuns(sc.nextInt());
                    p.setWickets(sc.nextInt());
                    p.setDuck(sc.nextInt());
                    p.setType(sc.next());
                    flag=true;
                }
                break;
            }
            if(flag=false)
                throw new PlayerNotFoundException("Player not found");
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public void displayFinalTeam(List<Player> list) {
        list=selectTeam(list);
        list.sort((o1,o2)->o1.getName().compareTo(o2.getName()));
        System.out.println("ID\tName\tMatches Played\tRuns Scored\tWickets Taken\tDucks\tPlayer Type");
        for(Player p:list){
            System.out.println(p.getId()+"\t"+p.getName()+"\t"+p.getMatches()+"\t"+p.getRuns()+"\t"+p.getWickets()+"\t"+p.getDuck()+"\t"+p.getType());
        }
    }

    public List<Player> addPlayerInfo(List<Player> list,int count) {
        System.out.println("Enter player "+count+" Name, Matches Played, Runs Scored, Wickets Taken,Ducks and Player Type(Batsman, Bowler, Wicketkeeper)");
        String name= sc.next();
        int matches=sc.nextInt();
        int runs=sc.nextInt();
        int wickets=sc.nextInt();
        int ducks=sc.nextInt();
        String type=sc.next();
        Player p=new Player(count,name,matches,runs,wickets,ducks,type);
        list.add(p);
        return list;
    }

    public List<Player> selectTeam(List<Player>list){
        List<Player> finalTeam=new ArrayList<>();
        Map<Float, Player> mapBatsman=new TreeMap<>(Collections.reverseOrder());
        Map<Float, Player> mapBowler=new TreeMap<>(Collections.reverseOrder());
        Map<Float, Player> mapKeeper=new TreeMap<>(Collections.reverseOrder());
        for(Player p:list){
            float avg=p.getRuns()/p.getMatches();
            if(p.getType().equalsIgnoreCase("WicketKeeper"))
                mapKeeper.put(avg,p);
            else if (p.getType().equalsIgnoreCase("Bowler"))
                mapBowler.put(avg,p);
            else
                mapBatsman.put(avg,p);
        }
        //Add one wicketKeeper
        Iterator<Map.Entry<Float, Player>> itr1=mapKeeper.entrySet().iterator();
        Map.Entry<Float, Player> entry=null;
        while(itr1.hasNext()){
            entry= itr1.next();
            finalTeam.add(entry.getValue());
            break;
        }
        //add n bowlers
        Iterator<Map.Entry<Float, Player>> itr2=mapBowler.entrySet().iterator();
        System.out.println("Enter the no of Bowlers Minimum 3");
        int n= sc.nextInt();
        int count =1;
        while(itr2.hasNext()){
            entry= itr2.next();
            finalTeam.add(entry.getValue());
            count++;
            if(count==n+1)
                break;

        }
        //add remaining batsman
        Iterator<Map.Entry<Float, Player>> itr3=mapBatsman.entrySet().iterator();

        while(itr3.hasNext()){
            entry= itr3.next();
            finalTeam.add(entry.getValue());
            count++;
            if(count==11)
                break;
        }
        return finalTeam;

    }
    public boolean validateInitialTeam(List<Player> list){
        int countBowler=0;
        int countKeeper=0;
        for(Player p:list){
            if(p.getType().equalsIgnoreCase("Bowler"))
                countBowler++;
            else if(p.getType().equalsIgnoreCase("WicketKeeper"))
                countKeeper++;
        }
        if(countBowler>3 && countKeeper>1)
            return true;
        else
            return false;

    }
}
