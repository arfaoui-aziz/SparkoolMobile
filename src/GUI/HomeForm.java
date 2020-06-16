package GUI;

import com.codename1.components.FloatingActionButton;
import com.codename1.ui.*;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import java.util.List;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class HomeForm extends BaseForm {

    public HomeForm(String id) {
        this(com.codename1.ui.util.Resources.getGlobalResources(),id);
    }

    @Override
    protected boolean isCurrentInbox() {
        return true;
    }



    public HomeForm(com.codename1.ui.util.Resources resourceObjectInstance,String id) {
        initGuiBuilderComponents(resourceObjectInstance);

        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Messages", "Title"),
                        new Label("19", "InboxNumber")
                )
        );
        Label gui_Label_1 = new Label();
        Container gui_Container_1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));


        installSidemenu(resourceObjectInstance,id);

        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("toolbar-profile-pic.png"), e -> {});



        FloatingActionButton fab  = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        RoundBorder rb = (RoundBorder)fab.getUnselectedStyle().getBorder();
        rb.uiid(true);
        fab.bindFabToContainer(getContentPane());
        fab.addActionListener(e -> {

            Dialog popup = new Dialog();
            popup.setDialogUIID("Container");
            popup.setLayout(new LayeredLayout());







            ActionListener a = ee -> popup.dispose();




            popup.setTransitionInAnimator(CommonTransitions.createEmpty());
            popup.setTransitionOutAnimator(CommonTransitions.createEmpty());
            popup.setDisposeWhenPointerOutOfBounds(true);
            int t = HomeForm.this.getTintColor();
            HomeForm.this.setTintColor(0);
            popup.showPopupDialog(new Rectangle(HomeForm.this.getWidth() - 10, HomeForm.this.getHeight() - 10, 10, 10));
            HomeForm.this.setTintColor(t);
            fab.setUIID("FloatingActionButton");
        });
    }

    //-- DON'T EDIT BELOW THIS LINE!!!
    protected Label gui_Label = new Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new FlowLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("HomeForm");
        setName("HomeForm");
        ((FlowLayout)getLayout()).setAlign(Component.CENTER);
        ((FlowLayout)getLayout()).setValign(Component.CENTER);
        addComponent(gui_Label);
        gui_Label.setText("");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        gui_Label.setIcon(resourceObjectInstance.getImage("homebg.png"));
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
