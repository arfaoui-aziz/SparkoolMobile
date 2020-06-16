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
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.table.TableLayout;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class PSubjectListForm extends PBaseForm {
String id1;
Double min1;
Double max1;
    public PSubjectListForm(String id,Double min,Double max) {
        this(com.codename1.ui.util.Resources.getGlobalResources(),id,min,max);
        id1=id;
        min1=min;
        max1=max;
    }

    @Override
    protected boolean isCurrentInbox() {
        return true;
    }



    public PSubjectListForm(com.codename1.ui.util.Resources resourceObjectInstance, String id,Double min,Double max) {
        id1=id;
        min1=min;
        max1=max;
        initGuiBuilderComponents(resourceObjectInstance);

        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Marks", "Title")
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
    private  Label title=new Label("Average Between");
    private  Label clas=new Label("Teacher Note");
    private  Label id=new Label("Subject");
    private  Label fn=new Label("CC");
    private  Label ln=new Label("Exam");
    Container gui_Container_tab2 = new Container(new TableLayout(3,4));



    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        title.setUIID("titles");
        clas.setUIID("coloredLabel");
        fn.setUIID("coloredLabel"); ln.setUIID("coloredLabel"); id.setUIID("coloredLabel");

        gui_Container_tab.add(id).add(fn).add(ln).add(clas);
        for(int i=0;i< ServiceUser.getInstance().getMarks(id1).size();i++){


            Double cc = Double.parseDouble(ServiceUser.getInstance().getMarks(id1).get(i).getCc())*0.4;
            Double exam = Double.parseDouble(ServiceUser.getInstance().getMarks(id1).get(i).getExam())*0.6;

            if ((cc+exam)>=min1 && (cc+exam)<max1) {
                gui_Container_tab.add(ServiceUser.getInstance().getMarks(id1).get(i).getSubject()).add(ServiceUser.getInstance().getMarks(id1).get(i).getCc()).add(ServiceUser.getInstance().getMarks(id1).get(i).getExam()).add(ServiceUser.getInstance().getMarks(id1).get(i).getNote());
            }

        }
    addAll(title,gui_Container_tab,gui_Container_tab2);
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
