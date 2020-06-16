package Entity;

public class Club {

    String idClub;
    String nomClub;
    String members;
    String activity;
    String budget;
    String dateCreation;


    public Club(String idClub, String nomClub, String members, String activity, String budget, String dateCreation ) {
        this.idClub=idClub;
        this.nomClub=nomClub;
        this.members=members;
        this.activity=activity;
        this.budget=budget;
        this.dateCreation=dateCreation;


    }

    public Club(String nomClub, String members, String activity, String budget, String dateCreation ) {

        this.nomClub=nomClub;
        this.members=members;
        this.activity=activity;
        this.budget=budget;
        this.dateCreation=dateCreation;

    }

    public Club() {

    }

    public String getIdClub() {
        return idClub;
    }

    public void setIdClub(String idClub) {
        this.idClub = idClub;
    }

    public String getNomClub() {
        return nomClub;
    }

    public void setNomClub(String nomClub) {
        this.nomClub = nomClub;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return "Club{" + "idClub=" + idClub + ", nomClub=" + nomClub + ", members=" + members + ", activity=" + activity + ", budget=" + budget + ", dateCreation=" + dateCreation + '}';
    }


}
