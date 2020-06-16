package Services;

import Entity.ContactTeacher;
import Utils.Statics;
import com.codename1.io.*;
import com.codename1.ui.events.ActionListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServiceContactTeacher {
    private ConnectionRequest req;
    public ArrayList<ContactTeacher> contacts;
    String ch="";
    public boolean resultOK;

    public static ServiceContactTeacher instance=null;

    private ServiceContactTeacher() {
        req = new ConnectionRequest();
    }

    public static ServiceContactTeacher getInstance() {
        if (instance == null) {
            instance = new ServiceContactTeacher();
        }
        return instance;
    }
    public String parseString(String jsonText){
        String ch= "";
        try {

            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>)tasksListJson.get("root");
            for(Map<String, Object> obj : list){


                ch=obj.get("nb").toString();

            }


        } catch (IOException ignored) {

        }
        return ch;
    }
    public String nbNotShowed(String id) {

        String url = Statics.BASE_URL+"nbNotShowed?id=" + id;
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
    }


    public ArrayList<ContactTeacher> parseContact(String jsonText){
        try {
            contacts=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>)tasksListJson.get("root");
            for(Map<String, Object> obj : list){
                ContactTeacher c = new ContactTeacher();
               // System.out.println(obj.get("id"));
              //  int nbShow


                c.setId(obj.get("id").toString());
                c.setDateCreation((obj.get("datecreation").toString()));
                c.setFile(obj.get("file").toString());
                c.setMessage(obj.get("message").toString());
                c.setReply(obj.get("rely").toString());
                c.setShowed( obj.get("showed").toString());
                c.setSubject(obj.get("subject").toString());
                c.setReceiverType(obj.get("receivertype").toString());

                contacts.add(c);
            }


        } catch (IOException ignored) {

        }
        return contacts;
    }

    public ArrayList<ContactTeacher> ShowMsgs(String id) {
        String url = Statics.BASE_URL+"showMsgDetail?id=" + id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                contacts = parseContact(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return contacts;
    }
    public int nbMsg(String id) {

        String url = Statics.BASE_URL+"nbMsg?id=" + id;
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
        return Integer.parseInt(ch);
    }

    public boolean addReply(String id, String rep){
        String url = Statics.BASE_URL + "addReply?id="+id+"&rep=-Teacher: "+rep;
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

    public boolean addMsg(String sub, String msg, String id, String file){
        String url = Statics.BASE_URL + "addMsg?sub="+sub+"&date="+"2020/05/25"+"&msg="+msg+"&idT="+id+"&file="+file;
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
