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
import com.codename1.components.FloatingActionButton;
import com.codename1.io.FileSystemStorage;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.table.TableLayout;

import java.io.IOException;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class EClubsForm extends PBaseForm {
String id1;
    public EClubsForm(String id) {
        this(com.codename1.ui.util.Resources.getGlobalResources(),id);
        id1=id;
    }

    @Override
    protected boolean isCurrentInbox() {
        return true;
    }



    public EClubsForm(com.codename1.ui.util.Resources resourceObjectInstance, String id) {
        id1=id;
        initGuiBuilderComponents(resourceObjectInstance);

        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Clubs", "Title")
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
    private  Label title=new Label("All Clubs");
    private  Label clas=new Label("Name");
    private  Label id=new Label("Activity");
    private  Label fn=new Label("Members");
    private  Label dt=new Label("Creation Date");
    Container gui_Container_tab2 = new Container(new TableLayout(3,4));


    public void captureAudio(ActionListener response) {
        String p = FileSystemStorage.getInstance().getAppHomePath();
        if(!p.endsWith("/")) {
            p += "/";
        }
        try {
            final Media media = MediaManager.createMediaRecorder(p + "cn1TempAudioFile", MediaManager.getAvailableRecordingMimeTypes()[0]);
            media.play();

            boolean b = Dialog.show("Recording", "", "Save", "Cancel");
            final Dialog d = new Dialog("Recording");

            media.pause();
            media.cleanup();
            d.dispose();
            if(b) {
                response.actionPerformed(new ActionEvent(p + "cn1TempAudioFile"));
            } else {
                FileSystemStorage.getInstance().delete(p + "cn1TempAudioFile");
                response.actionPerformed(null);
            }
        } catch(IOException err) {
            err.printStackTrace();
            response.actionPerformed(null);
        }
    }



    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        title.setUIID("titles");
        clas.setUIID("coloredLabel");
        fn.setUIID("coloredLabel"); id.setUIID("coloredLabel");dt.setUIID("coloredLabel");
        gui_Container_tab.add(clas).add(id).add(fn).add(dt);
        for(int i = 0; i< ServiceClub.getInstance().ShowClubs().size(); i++){


Label id2=new Label(ServiceClub.getInstance().ShowClubs().get(i).getNomClub());
Label id3=new Label(ServiceClub.getInstance().ShowClubs().get(i).getIdClub());
            gui_Container_tab.add(id2).add(ServiceClub.getInstance().ShowClubs().get(i).getActivity()).add(ServiceClub.getInstance().ShowClubs().get(i).getMembers()).add(ServiceClub.getInstance().ShowClubs().get(i).getDateCreation());

            id2.addPointerPressedListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    new EClubDetailsForm(id1,id3.getText()).show();
                }
            });

        }
    addAll(title,gui_Container_tab,gui_Container_tab2);
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
