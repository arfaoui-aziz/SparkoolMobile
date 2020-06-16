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

import Services.ServiceUser;
import com.codename1.components.FloatingActionButton;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.table.TableLayout;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class AInfoForm extends ABaseForm {
String id1="";
    public AInfoForm(String id) {
        this(com.codename1.ui.util.Resources.getGlobalResources(),id);
    }

    @Override
    protected boolean isCurrentInbox() {
        return true;
    }



    public AInfoForm(com.codename1.ui.util.Resources resourceObjectInstance, String id) {
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

    private Label lgen = new Label();
    private Label gen = new Label();
    private Label lmail = new Label();
    private Label mail = new Label();



    private Label title=new Label();
    private Container gui_Container_tab1 = new Container(new TableLayout(6,2));


    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        lname.setText("Name :");
        lname.setUIID("coloredLabel");
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

        title.setText("Personal Information");
        title.setUIID("titles");

        gui_Container_1.addComponent(title);




        gui_Container_tab1.add(lname).add(name).
                add(lid).add(id).
                add(lgen).add(gen).
                add(lphone).add(phone).
                add(lmail).add(mail).


                add(new Label(" ")).add(new Label(" "))

        ;
        gui_Container_1.addComponent(gui_Container_tab1);









        addAll(gui_Container_1);


    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
