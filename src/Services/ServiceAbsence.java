package Services;

import Utils.Statics;
import com.codename1.io.*;
import com.codename1.ui.events.ActionListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServiceAbsence {
    private ConnectionRequest req;
    String ch="";
    public static ServiceAbsence instance=null;
    public ArrayList<String> ach;

    private ServiceAbsence() {
        req = new ConnectionRequest();
    }

    public static ServiceAbsence getInstance() {
        if (instance == null) {
            instance = new ServiceAbsence();
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
    public ArrayList<String> parseString2(String jsonText){
        try {
            ach=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>)tasksListJson.get("root");
            for(Map<String, Object> obj : list){

                ach.add(obj.get("jour").toString());
            }


        } catch (IOException ignored) {

        }
        return ach;
    }
    public String nbAbsence(String id) {

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
    }
    public ArrayList<String> ShowUser(String id, String nb) {
        String url = Statics.BASE_URL+"ShowAbByWeek?id="+id+"&sem="+nb+"&au=2019-20";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ach = parseString2(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return ach;
    }

}
