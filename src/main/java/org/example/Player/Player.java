package org.example.Player;

public abstract class Player {
    protected String name;
    protected String team;
    protected String position;
    protected int goals;
    protected int assists;
    protected int matchesPlayed;
    protected int cardsReceived;
    protected int minutesPlayed;

    public void updateStats(){
        //TODO
    }
    public void viewStats(){
        //TODO
    }
    public int compareStats(Player otherPlayer){
        //TODO
        return 0;
    }
}
