public class Player {
    
    private String name;
    private int space;
    private int wins;
    private int gamesPlayed;
    private int nestTurns;
    
    public Player(String name){
        this.name = name;
        space = 0;
        wins = 0;
        gamesPlayed = 0;
    }
    
    public void resetSpace(){
        space = 0;
        nestTurns = 3;
    }
    
    public void addWin(){
        wins ++;
    }
    
    public void addGamePlayed(){
        gamesPlayed ++;
    }
    
    public int getWins(){
        return wins;
    }
    
    public int getGamesPlayed(){
        return gamesPlayed;
    }
    
    public String getName(){
        return name;
    }
    
    public int getSpace(){
        return space;
    }
    
    public void startTurn(){
        int rolledNum;
        int tempNum;
        boolean keepGoing = true;
        
        rolledNum = (((int)(Math.random() * 6) + 1) + ((int)(Math.random() * 6) + 1));
        //System.out.println(name + " rolled a " + rolledNum);
        if(nestTurns < 3){
            keepGoing = false;
            //System.out.println(name + " has spent a turn on the nest space!");
        }
        while(keepGoing){
            keepGoing = false;
            if(space + rolledNum > 63){
                tempNum = 63 - space;
                space = rolledNum - tempNum;
            } else {
                space += rolledNum;
            }
            checkSpace(space);
            if(space == 5 || space == 6 || space == 9 || space == 14 || space == 18 || space == 23 || space == 27 || space == 32 || space == 36 || space == 41 || space == 45 || space == 50 || space == 54 || space == 59){
                //System.out.println(name + " has landed on a goose square!");
                keepGoing = true;
            }
            if(space == 19){
                nestTurns = 0;
                //System.out.println(name + " has landed on the nest space!");
            }
        }
        if(nestTurns < 3){
            nestTurns ++;
        }
        
    }
    
    public void checkSpace(int currentSpace){
        if(currentSpace == 58){
            space = 1;
        }
        if(currentSpace == 42){
            space = 39;
        }
    }
    
    public boolean winThisTurn(){
        return space == 63;
    }
    
    public String toString(){
        return name + "\nWins: " + wins + "\nGames Played: " + gamesPlayed + "\nSpace: " + space + "\nWin Ratio: " + (((double)wins / gamesPlayed) * 100) + "%"; 
    }
    
    
    public static void main(String[] args) {
    }
}
