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

import Services.ServiceAbsence;
import Services.ServiceUser;
import com.codename1.components.FloatingActionButton;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.table.TableLayout;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class InfoForm extends BaseForm {
String id1="";
    public InfoForm(String id) {
        this(com.codename1.ui.util.Resources.getGlobalResources(),id);
    }

    @Override
    protected boolean isCurrentInbox() {
        return true;
    }



    public InfoForm(com.codename1.ui.util.Resources resourceObjectInstance, String id) {
        id1=id;
        initGuiBuilderComponents(resourceObjectInstance);

        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Information", "Title")
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
    private Label lphone = new Label();
    private Label phone = new Label();
    private Label lid = new Label();
    private Label id = new Label();
    private Label lspec = new Label();
    private Label spec = new Label();
    private Label lgen = new Label();
    private Label gen = new Label();
    private Label lmail = new Label();
    private Label mail = new Label();
    private Label ldel = new Label("Number Of Delays :");
    private Label del = new Label(ServiceUser.getInstance().nbDelay(id1)+" Delays");
    private Label lab = new Label("Number Of Absences :");
    private Label ab = new Label(ServiceAbsence.getInstance().nbAbsence(id1)+" Absences");
    private Container gui_Container_SearchAb = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    TextField nbAb = new TextField("", "Week Number", 20, TextArea.NUMERIC);
    Button btnConfirm = new Button("Confirm");
    private Label title=new Label();
    private Container gui_Container_tab = new Container(new TableLayout(2,7));
    private Container gui_Container_tab1 = new Container(new TableLayout(9,2));


    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        lname.setText("Name :");
        lname.setUIID("coloredLabel");
del.setText(ServiceUser.getInstance().nbDelay(id1)+" Delays");
ab.setText(ServiceAbsence.getInstance().nbAbsence(id1)+" Absences");
        name.setText(ServiceUser.getInstance().ShowUser(id1).get(0).getFirstName());
        lphone.setText("Phone :");
        lphone.setUIID("coloredLabel");
        phone.setText(ServiceUser.getInstance().ShowUser(id1).get(0).getPhone());
        lid.setText("ID :");
        lid.setUIID("coloredLabel");
        id.setText(ServiceUser.getInstance().ShowUser(id1).get(0).getId());
        lmail.setText("mail :");
        lmail.setUIID("coloredLabel");
        mail.setText(ServiceUser.getInstance().ShowUser(id1).get(0).getEmail());
        lgen.setText("Gender :");
        lgen.setUIID("coloredLabel");
        gen.setText(ServiceUser.getInstance().ShowUser(id1).get(0).getGender());
        lspec.setText("Speciality :");
        lspec.setUIID("coloredLabel");
        spec.setText("Computer Science");
        lab.setUIID("coloredLabel");
        ldel.setUIID("coloredLabel");
        title.setText("Personal Information");
        title.setUIID("titles");

        gui_Container_1.addComponent(title);

        gui_Container_SearchAb.addComponent(nbAb);
        gui_Container_SearchAb.addComponent(btnConfirm);


        gui_Container_tab1.add(lname).add(name).
                add(lid).add(id).
                add(lgen).add(gen).
                add(lmail).add(mail).
                add(lphone).add(phone).
                add(lspec).add(spec).
                add(new Label(" ")).add(new Label(" ")).
                add(ldel).add(del).
                add(lab).add(ab).add(new Label(" ")).add(new Label(" ")).add(new Label(" ")).add(new Label(" "))
        ;
        gui_Container_1.addComponent(gui_Container_tab1);
       gui_Container_1.addComponent(gui_Container_SearchAb);

         Label mn=new Label("Mon");
         Label we=new Label("Wed");
         Label th=new Label("Thu");
         Label tu=new Label("Tue");
         Label fr=new Label("Fri");
        Label sat=new Label("Sat");
        Label wk=new Label("Week ");
         mn.setUIID("coloredLabel");
         we.setUIID("coloredLabel");
         th.setUIID("coloredLabel");
         tu.setUIID("coloredLabel");
         fr.setUIID("coloredLabel");
         wk.setUIID("coloredLabel");
         sat.setUIID("coloredLabel");

        Label mn1=new Label("");
        Label we1=new Label("");
        Label th1=new Label("");
        Label tu1=new Label("");
        Label fr1=new Label("");
        Label sa1=new Label("");
        mn1.setIcon(resourceObjectInstance.getImage("icons8-subtract.png"));
        we1.setIcon(resourceObjectInstance.getImage("icons8-subtract.png"));
        th1.setIcon(resourceObjectInstance.getImage("icons8-subtract.png"));
        tu1.setIcon(resourceObjectInstance.getImage("icons8-subtract.png"));
        fr1.setIcon(resourceObjectInstance.getImage("icons8-subtract.png"));
        sa1.setIcon(resourceObjectInstance.getImage("icons8-subtract.png"));



        gui_Container_tab.add(new Label(" ")).
                add(mn).
                add(tu).
                add(we).
                add(th).
               add(fr).
                add(sat).
               add(wk).
               add(mn1).
               add(tu1).
               add(we1).
               add(th1).
               add(fr1).
                add(sa1);

        gui_Container_1.addComponent(gui_Container_tab);
        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if((Integer.parseInt(nbAb.getText())>0) && (Integer.parseInt(nbAb.getText())<36)){


                mn1.setIcon(resourceObjectInstance.getImage("icons8-tick_box.png"));
                we1.setIcon(resourceObjectInstance.getImage("icons8-tick_box.png"));
                th1.setIcon(resourceObjectInstance.getImage("icons8-tick_box.png"));
                tu1.setIcon(resourceObjectInstance.getImage("icons8-tick_box.png"));
                fr1.setIcon(resourceObjectInstance.getImage("icons8-tick_box.png"));
                sa1.setIcon(resourceObjectInstance.getImage("icons8-tick_box.png"));
                wk.setText("Week "+nbAb.getText());

                for(int i = 0; i< ServiceAbsence.getInstance().ShowUser(id1,nbAb.getText()).size(); i++){
                    System.out.println(ServiceAbsence.getInstance().ShowUser(id1,nbAb.getText()).get(i));
                    if (ServiceAbsence.getInstance().ShowUser(id1,nbAb.getText()).get(i).equals("Monday")){
                        mn1.setIcon(resourceObjectInstance.getImage("icons8-close_window.png"));
                    }
                    if (ServiceAbsence.getInstance().ShowUser(id1,nbAb.getText()).get(i).equals("Wednesday")){
                        we1.setIcon(resourceObjectInstance.getImage("icons8-close_window.png"));
                    }
                    if (ServiceAbsence.getInstance().ShowUser(id1,nbAb.getText()).get(i).equals("Tuesday")){
                        tu1.setIcon(resourceObjectInstance.getImage("icons8-close_window.png"));

                    }
                    if (ServiceAbsence.getInstance().ShowUser(id1,nbAb.getText()).get(i).equals("Thursday")){
                        th1.setIcon(resourceObjectInstance.getImage("icons8-close_window.png"));

                    }
                    if (ServiceAbsence.getInstance().ShowUser(id1,nbAb.getText()).get(i).equals("Friday")){
                        fr1.setIcon(resourceObjectInstance.getImage("icons8-close_window.png"));

                    }
                    if (ServiceAbsence.getInstance().ShowUser(id1,nbAb.getText()).get(i).equals("Sturday")){
                        sa1.setIcon(resourceObjectInstance.getImage("icons8-close_window.png"));

                    }
                }
                }
                else {
                    Dialog.show("Invalid Input !", "Week number must be between 1 and 36", new Command("OK"));

                }
            }
        });



        addAll(gui_Container_1);


    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
