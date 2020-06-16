package Entity;

public class Event {
    String id;
    String nomEvent;
    String typeEvent;
    String description;
    String dateEvent;
    String placeEvent;
    String nbParticipants;
    String theme;
    String destination;
    String award;
    String budget;
    String price;

    public Event() {};
    public Event(String id, String nomEvent, String typeEvent, String description, String dateEvent, String placeEvent, String nbParticipants, String theme, String destination, String award, String budget, String price) {
        this.id=id;
        this.nomEvent = nomEvent;
        this.typeEvent = typeEvent;
        this.description = description;
        this.dateEvent = dateEvent;
        this.placeEvent = placeEvent;
        this.nbParticipants = nbParticipants;
        this.theme = theme;
        this.destination = destination;
        this.award = award;
        this.budget = budget;
        this.price = price;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomEvent() {
        return nomEvent;
    }

    public void setNomEvent(String nomEvent) {
        this.nomEvent = nomEvent;
    }

    public String getTypeEvent() {
        return typeEvent;
    }

    public void setTypeEvent(String typeEvent) {
        this.typeEvent = typeEvent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(String dateEvent) {
        this.dateEvent = dateEvent;
    }

    public String getPlaceEvent() {
        return placeEvent;
    }

    public void setPlaceEvent(String placeEvent) {
        this.placeEvent = placeEvent;
    }



    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


    public String getNbParticipants() {
        return nbParticipants;
    }

    public void setNbParticipants(String nbParticipants) {
        this.nbParticipants = nbParticipants;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
