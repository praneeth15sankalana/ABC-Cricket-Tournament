public class PlayerDetails {

    private String playerName;
    private String playerSchool;
    private String playerAge;
    private String playerRole;
    public PlayerDetails(String playerName,String playerSchool,String playerAge,String playerRole){
        this.playerName=playerName;
        this.playerSchool=playerSchool;
        this.playerAge=playerAge;
        this.playerRole=playerRole;

    }



    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerSchool() {
        return playerSchool;
    }

    public void setPlayerSchool(String playerSchool) {
        this.playerSchool = playerSchool;
    }

    public String getPlayerAge() {
        return playerAge;
    }

    public void setPlayerAge(String age) {
        this.playerAge = age;
    }

    public String getPlayerRole() {
        return playerRole;
    }

    public void setPlayerRole(String playerRole) {
        this.playerRole = playerRole;
    }


}
