package Services;

import Entity.Mark;
import Entity.Reclamation;
import Entity.User;
import Utils.Statics;
import com.codename1.io.*;
import com.codename1.ui.events.ActionListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServiceUser {
    private ConnectionRequest req;
    public ArrayList<User> users;
    public ArrayList<Mark> marks;
    public ArrayList<Reclamation> claims;

    public static ServiceUser instance = null;
    public boolean resultOK;
    String ch = "";

    private ServiceUser() {
        req = new ConnectionRequest();
    }

    public static ServiceUser getInstance() {
        if (instance == null) {
            instance = new ServiceUser();
        }
        return instance;
    }


    public ArrayList<User> parseUser(String jsonText) {
        try {
            users = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                User u = new User();

                u.setId(obj.get("id").toString());
                u.setUsername(obj.get("username").toString());
                u.setFirstName(obj.get("firstname").toString());
                u.setLastName(obj.get("lastname").toString());
                u.setPhone(obj.get("phone").toString());
                u.setEmail(obj.get("email").toString());
                u.setGender(obj.get("gender").toString());
                //u.setPicture(obj.get("picture").toString());
                u.setPicture(" ");

                u.setUserType(obj.get("usertype").toString());
                u.setEmail(obj.get("email").toString());
                u.setAddress(obj.get("address").toString());
                u.setPassword(obj.get("password").toString());
                users.add(u);
            }


        } catch (IOException ignored) {

        }
        return users;
    }

    public String parseString(String jsonText) {
        String ch = "";
        try {

            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {


                ch = obj.get("nb").toString();

            }


        } catch (IOException ignored) {

        }
        return ch;
    }

    public ArrayList<User> ShowUser(String id) {
        String url = Statics.BASE_URL + "showUser?id=" + id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                users = parseUser(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return users;
    }

    public String nbDelay(String id) {

        String url = Statics.BASE_URL + "nbDelays?id=" + id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ch = parseString(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return ch;
    }
   /* public String nbAbsence(String id) {

        String url = Statics.BASE_URL+"nbAbsences?id=" + id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ch = parseString(new String(req.getResponseData()));
                System.out.println(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return ch;
    }*/

    public String parseId(String jsonText) {
        String ch = "";
        try {

            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {


                ch = obj.get("id").toString();

            }


        } catch (IOException ignored) {

        }
        return ch;
    }

    public ArrayList<User> verifLogin(String username) {

        String url = Statics.BASE_URL + "verifLogin?username=" + username;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                users = parseUser(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return users;
    }

    public boolean changePass(String id, String pass) {
        String url = Statics.BASE_URL + "UpdateLogin?id=" + id + "&psw=" + pass;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<User> notMarked(String id) {
        String url = Statics.BASE_URL + "showNotMarked?id=" + id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                users = parseUser(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return users;
    }

    public boolean addMark(String sub, String cc, String exam, String note, String tea, String stu) {
        String url = Statics.BASE_URL + "addMark?sub=" + sub + "&cc=" + cc + "&exam=" + exam + "&note=" + note + "&tea=" + tea + "&stu=" + stu;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }


    //Parent Youssef Ghedas
    public ArrayList<User> getChild(String id) {
        String url = Statics.BASE_URL + "getChild?id=" + id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                users = parseUser(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return users;
    }

    public ArrayList<Mark> parseMark(String jsonText) {
        try {
            marks = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                User u = new User();

                Mark m = new Mark();
                m.setId(obj.get("id").toString());
                m.setExam(obj.get("exam").toString());
                m.setNote(obj.get("note").toString());
                m.setCc(obj.get("cc").toString());
                m.setSubject(obj.get("subject").toString());
                m.setId_Student(obj.get("idStudent").toString());
                m.setId_Teacher(obj.get("idTeacher").toString());

                marks.add(m);
            }


        } catch (IOException ignored) {

        }
        return marks;
    }

    public ArrayList<Mark> getMarks(String id) {
        String url = Statics.BASE_URL + "getMarks?id=" + id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                marks = parseMark(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return marks;
    }

    public ArrayList<Reclamation> parseClaim(String jsonText) {
        try {
            claims = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                Reclamation r = new Reclamation();
                r.setId(obj.get("id").toString());
                r.setType(obj.get("type").toString());
                r.setDatecree(obj.get("datecree").toString());
                r.setMessage(obj.get("message").toString());
                r.setEtat(obj.get("etat").toString());
                r.setReponse(obj.get("reponse").toString());
                r.setId_Parent("23");


                claims.add(r);
            }


        } catch (IOException ignored) {

        }
        return claims;
    }

    public ArrayList<Reclamation> getClaims(String id) {
        String url = Statics.BASE_URL + "ShowClaim?id=" + id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                claims = parseClaim(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return claims;
    }


    public boolean addMsg(String sub, String msg, String id, String file) {
        String url = Statics.BASE_URL + "addMsg?sub=" + sub + "&date=" + "2020/05/25" + "&msg=" + msg + "&idT=" + id + "&file=" + file;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    //APIs

    public void sendMailLogin(String i, String fn, String ln, String us) {
        String url = Statics.BASE_URL + "SendMail" + i + "?mail=youssefghedas100@gmail.com&fn=" + fn + "&ln=" + ln + "&us=" + us;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        //return resultOK;
    }

    public boolean addClaim(String type, String id, String msg) {
        String url = Statics.BASE_URL + "addClaim?type=" + type + "&id=" + id + "&msg=" + msg;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    /*************************************** Aziz Arfaoui  (Partie Admin)****************************************/
    public void MailForgetPass(String Mail, String vCode) {
        String url = Statics.BASE_URL + "MailforgetPassword?mail=" + Mail + "&vCode=" + vCode;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        //return resultOK;
    }

    public boolean updatePass(String mail, String pass) {
        String url = Statics.BASE_URL + "UpdatePass?mail=" + mail + "&psw=" + pass;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<User> ShowAllUsers() {
        String url = Statics.BASE_URL + "allUsers";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                users = parseUser(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return users;
    }

    public boolean deleteUser(String id) {
        String url = Statics.BASE_URL + "deleteuser?id="+id;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
}


