package Services;

import Entity.Club;
import Utils.Statics;
import com.codename1.io.*;
import com.codename1.ui.events.ActionListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServiceClub {
    private ConnectionRequest req;
    public static ServiceClub instance=null;
    public ArrayList<Club> clubs;
    Boolean ok=false;
    String ch="";



    private ServiceClub() {
        req = new ConnectionRequest();
    }

    public static ServiceClub getInstance() {
        if (instance == null) {
            instance = new ServiceClub();
        }
        return instance;
    }

    public ArrayList<Club> parseClub(String jsonText){
        try {
            clubs=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>)tasksListJson.get("root");
            for(Map<String, Object> obj : list){
                Club u = new Club();
                // System.out.println(obj.get("id"));
                //  int nbShow

                u.setIdClub(obj.get("idclub").toString());
                u.setNomClub(obj.get("nomclub").toString());
                u.setMembers(obj.get("members").toString());
                u.setActivity(obj.get("activity").toString());
                u.setDateCreation(obj.get("datecreation").toString());
                u.setBudget(obj.get("budget").toString());


                clubs.add(u);
            }


        } catch (IOException ignored) {

        }
        return clubs;
    }

    public ArrayList<Club> ShowClubs() {
        String url = Statics.BASE_URL+"showClub";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                clubs = parseClub(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return clubs;
    }

    public ArrayList<Club> ShowClubDetail(String id) {
        String url = Statics.BASE_URL+"showClubDetails?id="+id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                clubs = parseClub(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return clubs;
    }


    public String parseString(String jsonText){
        try {
            clubs=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>)tasksListJson.get("root");
            for(Map<String, Object> obj : list){
                ch=obj.get("id").toString();

            }


        } catch (IOException ignored) {

        }
        return ch;
    }

    public Boolean checkPart(String idu, String idc) {
        String url = Statics.BASE_URL+"checkParticipation?idU="+idu+"&idC="+idc;

        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ch = parseString(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        if (ch.equals("")){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean participate(String idu, String idc){
        String url = Statics.BASE_URL + "Participate?idU="+idu+"&idC="+idc;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ok = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return ok;
    }

    public boolean cancel(String idu, String idc){
        String url = Statics.BASE_URL + "Cancel?idU="+idu+"&idC="+idc;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ok = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return ok;
    }


    public void sendMailClub(String fn, String ln, String us, String club){
        String url = Statics.BASE_URL + "SendMail?mail=sonia.hadouej@esprit.tn&fn="+fn+"&ln="+ln+"&us="+us+"&club="+club;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ok = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        //return resultOK;
    }
}
