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
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Util;
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
public class AAllUsersForm extends ABaseForm {
String id1;
    public AAllUsersForm(String id) {
        this(com.codename1.ui.util.Resources.getGlobalResources(),id);
        id1=id;
    }

    @Override
    protected boolean isCurrentInbox() {
        return true;
    }



    public AAllUsersForm(com.codename1.ui.util.Resources resourceObjectInstance, String id) {
        id1=id;
        initGuiBuilderComponents(resourceObjectInstance);

        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("All Users", "Title")
                )
        );

        installSidemenu(resourceObjectInstance,id);




        FloatingActionButton fab  = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        RoundBorder rb = (RoundBorder)fab.getUnselectedStyle().getBorder();
        rb.uiid(true);

    }

    //-- DON'T EDIT BELOW THIS LINE!!!



    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private Container gui_Container_tab = new Container(new TableLayout(3,4));
    private Label title=new Label("All Users");
    private Label clas=new Label(" ");
    private Label id=new Label("Name");
    private Label ln=new Label("User Type");
    private Label us=new Label("Username");
    Container gui_Container_tab2 = new Container(new TableLayout(3,4));
    Container gui_Container_1 =new Container(new BoxLayout(BoxLayout.Y_AXIS));



    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        title.setUIID("titles");
        clas.setUIID("coloredLabel");
        us.setUIID("coloredLabel"); ln.setUIID("coloredLabel"); id.setUIID("coloredLabel");
        gui_Container_tab.add(id).add(us).add(ln).add(clas);
        for(int i = 0; i< ServiceUser.getInstance().ShowAllUsers().size(); i++){
Label id11=new Label(ServiceUser.getInstance().ShowAllUsers().get(i).getId());
Label l2 = new Label("Delete");



            gui_Container_tab.add(ServiceUser.getInstance().ShowAllUsers().get(i).getFirstName()+" "+ServiceUser.getInstance().ShowAllUsers().get(i).getLastName()).add(ServiceUser.getInstance().ShowAllUsers().get(i).getUsername()).add(ServiceUser.getInstance().ShowAllUsers().get(i).getUserType()).add(l2);
            System.out.println(ServiceUser.getInstance().ShowAllUsers().get(0).getUserType());
l2.addPointerPressedListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent evt) {
        ServiceUser.getInstance().deleteUser(id11.getText());
        new AAllUsersForm(id1).show();
    }
});
        }
    addAll(title,gui_Container_tab,gui_Container_tab2,gui_Container_1);
        Button btnConfirm = new Button("Download All Users Data");
        gui_Container_1.addComponent(btnConfirm);
        btnConfirm.addActionListener(e -> {
            FileSystemStorage fs = FileSystemStorage.getInstance();
            String fileName = fs.getAppHomePath() + "pdf-sample.pdf";
            if(!fs.exists(fileName)) {
                Util.downloadUrlToFile("http://127.0.0.1:8000/DisplayPDF", fileName, true);
            }
            Display.getInstance().execute(fileName);
        });

    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
