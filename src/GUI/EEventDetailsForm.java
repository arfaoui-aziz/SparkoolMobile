/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package GUI;

import Services.ServiceClub;
import Services.ServiceEvent;
import Services.ServiceUser;
import com.codename1.components.FloatingActionButton;
import com.codename1.io.Log;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.table.TableLayout;

import java.io.IOException;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class EEventDetailsForm extends PBaseForm {
String id1="";
String idC1="";
    public EEventDetailsForm(String id, String idC) {
        this(com.codename1.ui.util.Resources.getGlobalResources(),id,idC);
    }

    @Override
    protected boolean isCurrentInbox() {
        return true;
    }



    public EEventDetailsForm(com.codename1.ui.util.Resources resourceObjectInstance, String id, String idC) {
        id1=id;
        idC1=idC;
        initGuiBuilderComponents(resourceObjectInstance);

        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Event Details", "Title")
                )
        );

        installSidemenu(resourceObjectInstance,id);
        id1=id;
        System.out.println(id1);




        FloatingActionButton fab  = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        RoundBorder rb = (RoundBorder)fab.getUnselectedStyle().getBorder();
        rb.uiid(true);



    }

    //-- DON'T EDIT BELOW THIS LINE!!!



    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    Container gui_Container_1 =new Container(new BoxLayout(BoxLayout.Y_AXIS));
    private Label lname = new Label();
    private Label name = new Label();
    private Label ltype = new Label();
    private Label type= new Label();
    private Label ldesc = new Label();
    private Label desc = new Label();
    Button btnConfirm = new Button("Participate");
    Button btnCancel = new Button("Cancel");


    private Label ldate = new Label();
    private Label date = new Label();
    private Label lparti = new Label();
    private Label parti = new Label();

    private Label ldest = new Label();
    private Label dest = new Label();

    private Label lprice = new Label();
    private Label price = new Label();

    private  Label title=new Label();
    private Container gui_Container_tab = new Container(new TableLayout(2,7));
    private Container gui_Container_tab1 = new Container(new TableLayout(9,2));
    Button btn = new Button("media");


    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        lname.setText("Name :");
        lname.setUIID("coloredLabel");
        System.out.println("k,kf:  " +idC1);
        // child.setText(ServiceUser.getInstance().getChild(id1).get(0).getFirstName()+" "+ServiceUser.getInstance().getChild(id1).get(0).getLastName());
        name.setText(ServiceEvent.getInstance().ShowEventDetail(idC1).get(0).getNomEvent());
        ltype.setText("Type :");
        ltype.setUIID("coloredLabel");
        type.setText(ServiceEvent.getInstance().ShowEventDetail(idC1).get(0).getTypeEvent());
        ldesc.setText("Description :");
        ldesc.setUIID("coloredLabel");
        desc.setText(ServiceEvent.getInstance().ShowEventDetail(idC1).get(0).getDescription());
        ldate.setText("Date :");
        ldate.setUIID("coloredLabel");
        date.setText(ServiceEvent.getInstance().ShowEventDetail(idC1).get(0).getDateEvent());
        lparti.setText("Place Available :");
        lparti.setUIID("coloredLabel");
        parti.setText(ServiceEvent.getInstance().ShowEventDetail(idC1).get(0).getNbParticipants());
        ldest.setText("Destination :");
        ldest.setUIID("coloredLabel");
        dest.setText(ServiceEvent.getInstance().ShowEventDetail(idC1).get(0).getDestination());
        lprice.setText("Price :");
        lprice.setUIID("coloredLabel");
        price.setText(ServiceEvent.getInstance().ShowEventDetail(idC1).get(0).getPrice()+ " DT");

        title.setText("Event Details");
        title.setUIID("titles");

        gui_Container_1.addComponent(title);




        gui_Container_tab1.add(lname).add(name).
                add(ltype).add(type).
                add(ldesc).add(desc).
                add(ldate).add(date).


                add(lparti).add(parti).
                add(lprice).add(price).
                add(ldest).add(dest);
        gui_Container_1.addComponent(gui_Container_tab1);
        System.out.println(ServiceEvent.getInstance().checkPart(id1,idC1));
        if (ServiceEvent.getInstance().checkPart(id1,idC1))
        {
            gui_Container_1.addComponent(btnCancel); }

        else {
            gui_Container_1.addComponent(btnConfirm);

        }
        gui_Container_1.addComponent(btn);


        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
if (!parti.getText().equals("0.0")){

    ServiceEvent.getInstance().participateEvent(id1,idC1);
    ServiceEvent.getInstance().sendMailevent(ServiceUser.getInstance().ShowUser(id1).get(0).getFirstName(),ServiceUser.getInstance().ShowUser(id1).get(0).getLastName(),ServiceUser.getInstance().ShowUser(id1).get(0).getUsername(),name.getText());

        new EEventForm(id1).show();
}
else {
    Dialog.show("Failed", "There Are no more empty places :(", new Command("OK"));

}

            }
        });

        btnCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {

                    ServiceEvent.getInstance().cancelEvent(id1,idC1);

                    new EEventForm(id1).show();



                }
        });

             //VIDEO YOUTUBE
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Display.getInstance().execute("https://www.youtube.com/watch?v=Pncl3fnK3WQ");
            }
        });

              addAll(gui_Container_1);


    }// </editor-fold>



//-- DON'T EDIT ABOVE THIS LINE!!!
}
