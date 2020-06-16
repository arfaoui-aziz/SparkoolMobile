package Entity;

public class ContactTeacher {

    private String id;
    private String receiverType;
    private String subject;
    private String dateCreation;
    private String message;
    private String reply;
    private String file;
    private String id_Teacher;
    private String showed;

    public ContactTeacher(String id, String receiverType, String subject, String dateCreation, String message, String reply, String file, String id_Teacher, String showed) {
        this.id = id;
        this.receiverType = receiverType;
        this.subject = subject;
        this.dateCreation = dateCreation;
        this.message = message;
        this.reply = reply;
        this.file = file;
        this.id_Teacher = id_Teacher;
        this.showed = showed;
    }

    public ContactTeacher(String id, String receiverType, String subject, String dateCreation, String message, String file, String id_Teacher, String showed) {
        this.id = id;
        this.receiverType = receiverType;
        this.subject = subject;
        this.dateCreation = dateCreation;
        this.message = message;
        this.file = file;
        this.id_Teacher = id_Teacher;
        this.showed = showed;
    }

    public ContactTeacher() {

    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReceiverType() {
        return receiverType;
    }

    public void setReceiverType(String receiverType) {
        this.receiverType = receiverType;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getId_Teacher() {
        return id_Teacher;
    }

    public void setId_Teacher(String id_Teacher) {
        this.id_Teacher = id_Teacher;
    }

    public String getShowed() {
        return showed;
    }

    public void setShowed(String showed) {
        this.showed = showed;
    }
}
