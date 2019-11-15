
package ohtu;

public class Player implements Comparable<Player> {
    private String name;
    private String nationality;
    private String team;
    private String birthdate;
    private int goals;
    private int assists;
    private int penalties;

    public void setName(String name) {
        this.name = name;
    }

    public int getAssists() {
        return assists;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public int getGoals() {
        return goals;
    }

    public String getNationality() {
        return nationality;
    }

    public int getPenalties() {
        return penalties;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " " + team + ", goals: " + goals + ", assists: " + assists + ", combined: " + (goals + assists);
    }

    @Override
    public int compareTo(Player p) {
        int thisGA = goals + assists;
        int pGA = p.getGoals() + p.getAssists();
        return pGA - thisGA;
    }

    
      
}
