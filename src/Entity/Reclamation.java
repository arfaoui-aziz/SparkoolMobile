package Entity;

public class Reclamation {
    private String id;
    private String type;
    private String datecree;
    private String message;
    private String etat;
    private String id_Parent;
    private String reponse;

    public Reclamation(String id, String type, String datecree, String message, String etat, String id_Parent, String reponse) {
        this.id = id;
        this.type = type;
        this.datecree = datecree;
        this.message = message;
        this.etat = etat;
        this.id_Parent = id_Parent;
        this.reponse = reponse;
    }

    public Reclamation() {

    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDatecree() {
        return datecree;
    }

    public void setDatecree(String datecree) {
        this.datecree = datecree;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getId_Parent() {
        return id_Parent;
    }

    public void setId_Parent(String id_Parent) {
        this.id_Parent = id_Parent;
    }
}
