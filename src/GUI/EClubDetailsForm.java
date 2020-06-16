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
public class EClubDetailsForm extends PBaseForm {
String id1="";
String idC1="";
    public EClubDetailsForm(String id,String idC) {
        this(com.codename1.ui.util.Resources.getGlobalResources(),id,idC);
    }

    @Override
    protected boolean isCurrentInbox() {
        return true;
    }



    public EClubDetailsForm(com.codename1.ui.util.Resources resourceObjectInstance, String id,String idC) {
        id1=id;
        idC1=idC;
        initGuiBuilderComponents(resourceObjectInstance);

        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Club Details", "Title")
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
    private Label lactivity = new Label();
    private Label activity= new Label();
    private Label lmembers = new Label();
    private Label members = new Label();
    Button btnConfirm = new Button("Join");
    Button btnCancel = new Button("Exit");


    private Label ldate = new Label();
    private Label date = new Label();
    private Label lbudget = new Label();
    private Label budget = new Label();

    private  Label title=new Label();
    private Container gui_Container_tab = new Container(new TableLayout(2,7));
    private Container gui_Container_tab1 = new Container(new TableLayout(9,2));
    ShareButton sb = new ShareButton();


    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        lname.setText("Name :");
        lname.setUIID("coloredLabel");
        System.out.println("k,kf:  " +idC1);
        // child.setText(ServiceUser.getInstance().getChild(id1).get(0).getFirstName()+" "+ServiceUser.getInstance().getChild(id1).get(0).getLastName());
        name.setText(ServiceClub.getInstance().ShowClubDetail(idC1).get(0).getNomClub());
        lactivity.setText("Activity :");
        lactivity.setUIID("coloredLabel");
        activity.setText(ServiceClub.getInstance().ShowClubDetail(idC1).get(0).getActivity());
        lmembers.setText("Members :");
        lmembers.setUIID("coloredLabel");
        members.setText(ServiceClub.getInstance().ShowClubDetail(idC1).get(0).getMembers());
        ldate.setText("Date :");
        ldate.setUIID("coloredLabel");
        date.setText(ServiceClub.getInstance().ShowClubDetail(idC1).get(0).getDateCreation());
        lbudget.setText("Budget :");
        lbudget.setUIID("coloredLabel");
        budget.setText(ServiceClub.getInstance().ShowClubDetail(idC1).get(0).getBudget()+ " DT");

        title.setText("Club Details");
        title.setUIID("titles");

        gui_Container_1.addComponent(title);




        gui_Container_tab1.add(lname).add(name).
                add(lactivity).add(activity).
                add(lmembers).add(members).
                add(ldate).add(date).


                add(lbudget).add(budget)
        ;
        gui_Container_1.addComponent(gui_Container_tab1);
        if (ServiceClub.getInstance().checkPart(id1,idC1)){
            gui_Container_1.addComponent(btnCancel);

        }
        else {
            gui_Container_1.addComponent(btnConfirm);

        }

        addComponent(sb);




        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {



                ServiceClub.getInstance().participate(id1,idC1);
                ServiceClub.getInstance().sendMailClub(ServiceUser.getInstance().ShowUser(id1).get(0).getFirstName(),ServiceUser.getInstance().ShowUser(id1).get(0).getLastName(),ServiceUser.getInstance().ShowUser(id1).get(0).getUsername(),name.getText());

                new EClubsForm(id1).show();




            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                    ServiceClub.getInstance().cancel(id1,idC1);

                    new EClubsForm(id1).show();



            }
        });










        addAll(gui_Container_1);



    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
