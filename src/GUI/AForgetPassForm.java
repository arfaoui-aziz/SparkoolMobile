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

import Utils.verificationCode;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

/**
 * GUI builder created Form
 *
 * @author Shai Almog
 */
public class AForgetPassForm extends Form {

    public AForgetPassForm(String id) {
        this(com.codename1.ui.util.Resources.getGlobalResources(),id);
    }

    public AForgetPassForm(com.codename1.ui.util.Resources resourceObjectInstance, String id) {
        initGuiBuilderComponents(resourceObjectInstance);
        getTitleArea().setUIID("Container");
        getToolbar().setUIID("Container");
        getToolbar().getTitleComponent().setUIID("SigninTitle");
        FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "SigninTitle", 3.5f);
        getToolbar().addCommandToLeftBar("", mat, e -> new SplashForm().show());
        getContentPane().setUIID("SignInForm");
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private Container gui_Container_1 = new Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private Label gui_Label_1 = new Label();
    private ComponentGroup gui_Component_Group_1 = new ComponentGroup();
    private TextField gui_Text_Field_2 = new TextField("", "Email...", 20, TextArea.ANY);
    private Button gui_Button_2 = new Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Button_2.addActionListener(callback);
    }

    class EventCallbackClass implements ActionListener, com.codename1.ui.events.DataChangedListener {
        private Component cmp;
        public EventCallbackClass(Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(ActionEvent ev) {
            Component sourceComponent = ev.getComponent();
            if(sourceComponent.getParent().getLeadParent() != null) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if(sourceComponent == gui_Button_2) {

            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setTitle("Reset Password");
        setName("SignInForm");
        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(gui_Label_1);
        gui_Container_1.addComponent(gui_Component_Group_1);
        gui_Component_Group_1.setName("Component_Group_1");
        gui_Component_Group_1.addComponent(gui_Text_Field_2);


        gui_Text_Field_2.setName("Text_Field_2");

        gui_Container_1.addComponent(gui_Button_2);
        gui_Label_1.setUIID("CenterLabel");
        gui_Label_1.setName("Label_1");
        gui_Label_1.setIcon(resourceObjectInstance.getImage("logoSignIn.png"));
        gui_Component_Group_1.setName("Component_Group_1");
        gui_Button_2.setText("Confirm");
        gui_Button_2.setName("Button_2");

        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");

        gui_Button_2.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent evt) {

        String verifCode = verificationCode.getAlphaNumericString(8);
        String Mail = gui_Text_Field_2.getText() ;
        ServiceUser.getInstance().MailForgetPass(Mail,verifCode);
        new AVerifCodeForm(Mail,verifCode).show();
    }
});
       /* gui_Button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println(ServiceUser.getInstance().verifLogin(gui_Text_Field_2.getText()).get(0).getFirstName());
                if (bcrypt.checkpw(gui_Text_Field_1.getText(), ServiceUser.getInstance().verifLogin(gui_Text_Field_2.getText()).get(0).getPassword())){
                    System.out.println("kif kif");
                }
            }
        });*/




    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!


}
