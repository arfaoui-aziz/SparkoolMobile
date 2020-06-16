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
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.RoundBorder;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class PInboxForm extends PBaseForm {
String id1="";
    public PInboxForm(String id) {
        this(com.codename1.ui.util.Resources.getGlobalResources(),id);
        id1=id;
    }

    @Override
    protected boolean isCurrentInbox() {
        return true;
    }



    public PInboxForm(com.codename1.ui.util.Resources resourceObjectInstance, String id) {
        id1=id;
        initGuiBuilderComponents(resourceObjectInstance);

        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Inbox", "Title")
                )
        );
        
        installSidemenu(resourceObjectInstance,id);
        
       // getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("toolbar-profile-pic.png"), e -> {});
        
       /* gui_Label_5.setShowEvenIfBlank(true);
        gui_Label_6.setShowEvenIfBlank(true);
        gui_Label_7.setShowEvenIfBlank(true);
        gui_Label_8.setShowEvenIfBlank(true);
        gui_Label_9.setShowEvenIfBlank(true);
        
        gui_Text_Area_1.setRows(2);
        gui_Text_Area_1.setColumns(100);
        gui_Text_Area_1.setEditable(false);
        gui_Text_Area_1_1.setRows(2);
        gui_Text_Area_1_1.setColumns(100);
        gui_Text_Area_1_1.setEditable(false);
        gui_Text_Area_1_2.setRows(2);
        gui_Text_Area_1_2.setColumns(100);
        gui_Text_Area_1_2.setEditable(false);
        gui_Text_Area_1_3.setRows(2);
        gui_Text_Area_1_3.setColumns(100);
        gui_Text_Area_1_3.setEditable(false);
        gui_Text_Area_1_4.setRows(2);
        gui_Text_Area_1_4.setColumns(100);
        gui_Text_Area_1_4.setEditable(false);*/
        
        FloatingActionButton fab  = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        RoundBorder rb = (RoundBorder)fab.getUnselectedStyle().getBorder();
        rb.uiid(true);
        fab.bindFabToContainer(getContentPane());
        fab.addActionListener(e -> {
            fab.setUIID("FloatingActionButtonClose");
            Image oldImage = fab.getIcon();
            FontImage image = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "FloatingActionButton", 3.8f);
            fab.setIcon(image);
            Dialog popup = new Dialog();
            popup.setDialogUIID("Container");
            popup.setLayout(new LayeredLayout());


            Button trans = new Button(" ");
            trans.setUIID("Container");







            int t = PInboxForm.this.getTintColor();
            PInboxForm.this.setTintColor(0);
            popup.showPopupDialog(new Rectangle(PInboxForm.this.getWidth() - 10, PInboxForm.this.getHeight() - 10, 10, 10));
            PInboxForm.this.setTintColor(t);
            fab.setUIID("FloatingActionButton");
            fab.setIcon(oldImage);

            fab.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    new PComposeForm(id1).show();
                    System.out.println("clicked");
                }
            });
        });
    }

//-- DON'T EDIT BELOW THIS LINE!!!
  /*  private Container gui_Container_1 = new Container(new com.codename1.ui.layouts.BorderLayout());
    private Container gui_Container_2 = new Container(new FlowLayout());
    private Label gui_Label_1 = new Label();
    private Container gui_Container_4 = new Container(new FlowLayout());
    private Label gui_Label_4 = new Label();
    private Container gui_Container_3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    private Label gui_Label_3 = new Label();
    private Label gui_Label_2 = new Label();
    private com.codename1.ui.TextArea gui_Text_Area_1 = new com.codename1.ui.TextArea();
    private Label gui_Label_6 = new Label();


    private com.codename1.ui.TextArea gui_Text_Area_1_1 = new com.codename1.ui.TextArea();
    private Label gui_Label_7 = new Label();
    private Container gui_Container_1_2 = new Container(new com.codename1.ui.layouts.BorderLayout());
    private Container gui_Container_2_2 = new Container(new FlowLayout());
    private Container gui_Container_4_2 = new Container(new FlowLayout());
    private Label gui_Label_4_2 = new Label();
    private Container gui_Container_3_2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    private Label gui_Label_3_2 = new Label();
    private Label gui_Label_2_2 = new Label();
    private com.codename1.ui.TextArea gui_Text_Area_1_2 = new com.codename1.ui.TextArea();
    private Label gui_Label_8 = new Label();
    private Container gui_Container_1_3 = new Container(new com.codename1.ui.layouts.BorderLayout());
    private Container gui_Container_2_3 = new Container(new FlowLayout());

    private com.codename1.ui.TextArea gui_Text_Area_1_3 = new com.codename1.ui.TextArea();
    private Label gui_Label_9 = new Label();

    private com.codename1.ui.TextArea gui_Text_Area_1_4 = new com.codename1.ui.TextArea();
    private Label gui_Label_5 = new Label();*/


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        setTitle("InboxForm");
        setName("InboxForm");
        for (int i = 0; i< ServiceUser.getInstance().getClaims(id1).size() ; i++) {
            int i1=i;
             Container gui_Container_2 = new Container(new FlowLayout());
             Container gui_Container_1 = new Container(new com.codename1.ui.layouts.BorderLayout());
             Label gui_Label_1 = new Label();
             Container gui_Container_4 = new Container(new FlowLayout());
             Label gui_Label_4 = new Label();
             Container gui_Container_3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
             Label gui_Label_3 = new Label();
             Label gui_Label_2 = new Label();
             TextArea gui_Text_Area_1 = new TextArea();
             Label gui_Label_6 = new Label();


             TextArea gui_Text_Area_1_1 = new TextArea();
             Label gui_Label_7 = new Label();
             Container gui_Container_1_2 = new Container(new com.codename1.ui.layouts.BorderLayout());
             Container gui_Container_2_2 = new Container(new FlowLayout());
             Container gui_Container_4_2 = new Container(new FlowLayout());
             Label gui_Label_4_2 = new Label();
             Container gui_Container_3_2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
             Label gui_Label_3_2 = new Label();
             Label gui_Label_2_2 = new Label();
             TextArea gui_Text_Area_1_2 = new TextArea();
             Label gui_Label_8 = new Label();
             Container gui_Container_1_3 = new Container(new com.codename1.ui.layouts.BorderLayout());
             Container gui_Container_2_3 = new Container(new FlowLayout());

             TextArea gui_Text_Area_1_3 = new TextArea();
             Label gui_Label_9 = new Label();

             TextArea gui_Text_Area_1_4 = new TextArea();
             Label gui_Label_5 = new Label();




            addComponent(gui_Container_1);
            gui_Container_1.setName("Container_1");
            gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Container_2);
            gui_Container_2.setName("Container_2");
            gui_Container_2.addComponent(gui_Label_1);
            gui_Label_1.setText(ServiceUser.getInstance().getClaims(id1).get(i).getDatecree());
            gui_Label_1.setUIID("SmallFontLabel");
            gui_Label_1.setName("Label_1");
            gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, gui_Container_4);
            gui_Container_4.setName("Container_4");
            ((FlowLayout)gui_Container_4.getLayout()).setAlign(Component.CENTER);
            gui_Container_4.addComponent(gui_Label_4);
            gui_Label_4.setUIID("Padding2");
            gui_Label_4.setName("Label_4");


            gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_3);
            gui_Container_3.setName("Container_3");
            gui_Container_3.addComponent(gui_Label_3);
            gui_Container_3.addComponent(gui_Label_2);
            gui_Container_3.addComponent(gui_Text_Area_1);

            gui_Label_3.setText(ServiceUser.getInstance().getClaims(id1).get(i).getType());
            gui_Label_3.setName("Label_3");
                gui_Label_2.setText(ServiceUser.getInstance().getClaims(id1).get(i).getMessage());


            gui_Label_2.setUIID("RedLabel");
            gui_Label_2.setName("Label_2");
            gui_Text_Area_1.setText("-Reply: "+ ServiceUser.getInstance().getClaims(id1).get(i).getReponse());
            gui_Text_Area_1.setUIID("SmallFontLabel");
            gui_Text_Area_1.setName("Text_Area_1");
            gui_Container_2.setName("Container_2");
            gui_Container_4.setName("Container_4");
            ((FlowLayout)gui_Container_4.getLayout()).setAlign(Component.CENTER);
            gui_Container_3.setName("Container_3");
            addComponent(gui_Label_6);

            gui_Container_4_2.setName("Container_4_2");
            ((FlowLayout)gui_Container_4_2.getLayout()).setAlign(Component.CENTER);
            gui_Container_4_2.addComponent(gui_Label_4_2);
            gui_Label_4_2.setUIID("Padding2");
            gui_Label_4_2.setName("Label_4_2");
            gui_Label_4_2.setIcon(resourceObjectInstance.getImage("label_round.png"));
            gui_Container_1_2.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_3_2);
            gui_Container_3_2.setName("Container_3_2");
            gui_Container_3_2.addComponent(gui_Label_3_2);
            gui_Container_3_2.addComponent(gui_Label_2_2);
            gui_Container_3_2.addComponent(gui_Text_Area_1_2);
            gui_Label_3_2.setText("Product Hunt");
            gui_Label_3_2.setName("Label_3_2");
            gui_Label_2_2.setText("Our favorite GIF apps");
            gui_Label_2_2.setUIID("RedLabel");
            gui_Label_2_2.setName("Label_2_2");
            gui_Text_Area_1_2.setText("We know that you spend a lot of time admiring the hard work of GIF-makers the world over. ");
            gui_Text_Area_1_2.setUIID("SmallFontLabel");
            gui_Text_Area_1_2.setName("Text_Area_1_2");
            gui_Container_2_2.setName("Container_2_2");
            gui_Container_4_2.setName("Container_4_2");
            ((FlowLayout)gui_Container_4_2.getLayout()).setAlign(Component.CENTER);
            gui_Container_3_2.setName("Container_3_2");
            addComponent(gui_Label_8);
            addComponent(gui_Container_1_3);
            gui_Container_1_3.setName("Container_1_3");
            gui_Container_1_3.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Container_2_3);



            gui_Label_6.setText("");
            gui_Label_6.setUIID("Separator");
            gui_Label_6.setName("Label_6");


            gui_Label_3.addPointerPressedListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    new MsgDetailForm(id1,i1).show();
                }
            });

        }







    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
