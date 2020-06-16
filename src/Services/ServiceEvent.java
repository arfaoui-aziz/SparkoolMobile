package Services;

import Entity.Event;
import Utils.Statics;
import com.codename1.io.*;
import com.codename1.ui.events.ActionListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServiceEvent {
    private ConnectionRequest req;
    public static ServiceEvent instance=null;
    public ArrayList<Event> events;
    Boolean ok=false;
    String ch="";



    private ServiceEvent() {
        req = new ConnectionRequest();
    }

    public static ServiceEvent getInstance() {
        if (instance == null) {
            instance = new ServiceEvent();
        }
        return instance;
    }

    public ArrayList<Event> parseevent(String jsonText){
        try {
            events=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Event u = new Event();

                u.setId(obj.get("id").toString());
                u.setNomEvent(obj.get("nomevent").toString());
                u.setTypeEvent(obj.get("typeevent").toString());
                u.setDescription(obj.get("description").toString());
                u.setDateEvent(obj.get("dateevent").toString());
                u.setPlaceEvent(obj.get("placeevent").toString());
                u.setNbParticipants(obj.get("nbparticipants").toString()) ;
                u.setTheme(" ");
                u.setDestination(obj.get("destination").toString());
                u.setAward(" ");
                u.setBudget(obj.get("budget").toString());
                u.setPrice(obj.get("price").toString());




                events.add(u);
            }


        } catch (IOException ignored) {

        }
        return events;
    }

    public ArrayList<Event> ShowEvents() {
        String url = "http://localhost/amenSYMFONY/web/app_dev.php/showEvent";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                events = parseevent(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return events;
    }

    public ArrayList<Event> ShowEventDetail(String id) {
        String url = Statics.BASE_URL+"showEventDetails?id="+id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                events = parseevent(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return events;
    }


    public String parseString(String jsonText){
        try {
            events=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                ch=obj.get("id").toString();

            }


        } catch (IOException ignored) {

        }
        return ch;
    }

    public Boolean checkPart(String idu,String idc) {
        String url = Statics.BASE_URL+"checkParticipationEvent?idU="+idu+"&idC="+idc;

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


    public boolean participateEvent(String idu,String idc){
        String url = Statics.BASE_URL + "ParticipateEvent?idU="+idu+"&idC="+idc;
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

    public boolean cancelEvent(String idu,String idc){
        String url = Statics.BASE_URL + "CancelEvent?idU="+idu+"&idC="+idc;
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



    public void sendMailevent(String fn,String ln,String us,String event){
        String url = Statics.BASE_URL + "SendMail?mail=sonia.hadouej@esprit.tn&fn="+fn+"&ln="+ln+"&us="+us+"&event="+event;
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
