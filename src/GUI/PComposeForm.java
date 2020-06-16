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

import Services.ServiceContactTeacher;
import Services.ServiceUser;
import com.codename1.components.FloatingActionButton;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.RoundBorder;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class PComposeForm extends PBaseForm {
    String id1="";
    public PComposeForm(String id) {
        this(com.codename1.ui.util.Resources.getGlobalResources(),id);
    }

    @Override
    protected boolean isCurrentInbox() {
        return true;
    }



    public PComposeForm(com.codename1.ui.util.Resources resourceObjectInstance, String id) {
        id1=id;
        initGuiBuilderComponents(resourceObjectInstance);

        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Account", "Title")
                )
        );

        installSidemenu(resourceObjectInstance, id);




        FloatingActionButton fab  = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        RoundBorder rb = (RoundBorder)fab.getUnselectedStyle().getBorder();
        rb.uiid(true);

    }

    //-- DON'T EDIT BELOW THIS LINE!!!

    private Container gui_Container_tab = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    private  Label title=new Label("Compose Message");

    Button btnConfirm = new Button("Send");
    private  Label pass=new Label(" ");
    TextField psw = new TextField("", "Type...", 20, TextArea.ANY);
    TextField rpsw = new TextField("", "Message...", 20, TextArea.ANY);




    // <editor-fold defaultstate="collapsed" desc="Generated Code">

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        title.setUIID("titles");
        gui_Container_tab.add(pass).add(psw).add(rpsw).add(new Label(" ")).add(btnConfirm);
        addAll(title,gui_Container_tab);

        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (ServiceUser.getInstance().addClaim(psw.getText(),id1,rpsw.getText())){
                    new PInboxForm(id1).show();
                }

            }
        });

    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
