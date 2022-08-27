package model;

public class Player{
    private int id;
    private String name;
    private int matches;
    private int runs;
    private int wickets;
    private int duck;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public int getDuck() {
        return duck;
    }

    public void setDuck(int duck) {
        this.duck = duck;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Player() {
    }

    public Player(int id, String name, int matches, int runs, int wickets, int duck, String type) {
        this.id = id;
        this.name = name;
        this.matches = matches;
        this.runs = runs;
        this.wickets = wickets;
        this.duck = duck;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", matches=" + matches +
                ", runs=" + runs +
                ", wickets=" + wickets +
                ", duck=" + duck +
                ", type='" + type + '\'' +
                '}';
    }

}
