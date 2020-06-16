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
import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.components.FloatingActionButton;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.util.Resources;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class AStatUsersForm extends ABaseForm {
String id1="";
    public AStatUsersForm(String id) {

        this(Resources.getGlobalResources(),id);
        id1=id;

    }



    @Override
    protected boolean isCurrentInbox() {
        return true;
    }



    public AStatUsersForm(Resources resourceObjectInstance, String id) {
        id1=id;

        initGuiBuilderComponents(resourceObjectInstance);

        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Users Stat", "Title")
                )
        );

        installSidemenu(resourceObjectInstance,id);




        FloatingActionButton fab  = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        RoundBorder rb = (RoundBorder)fab.getUnselectedStyle().getBorder();
        rb.uiid(true);

    }

    //-- DON'T EDIT BELOW THIS LINE!!!



    // <editor-fold defaultstate="collapsed" desc="Generated Code">

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    Container gui_Container_1 =new Container(new BoxLayout(BoxLayout.Y_AXIS));

    private DefaultRenderer buildCategoryRenderer(int[] colors) {
        DefaultRenderer renderer = new DefaultRenderer();
        renderer.setLabelsTextSize(50);
        renderer.setLegendTextSize(50);
        renderer.setMargins(new int[]{20, 30, 15, 0});
        for (int color : colors) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(color);
            renderer.addSeriesRenderer(r);
        }
        return renderer;
    }

    int TeacherNbr=0,StudentNbr=0,ParentNbr=0,TotalNbr=0;
    private void initGuiBuilderComponents(Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
        setInlineStylesTheme(resourceObjectInstance);
        setTitle("MyForm");
        setName("MyForm");





        for(int i = 0; i< ServiceUser.getInstance().ShowAllUsers().size(); i++){
            if (ServiceUser.getInstance().ShowAllUsers().get(i).getUserType().equals("Teacher")){
                TeacherNbr++;
            } else if (ServiceUser.getInstance().ShowAllUsers().get(i).getUserType().equals("Student")){
                StudentNbr++;
            }else if (ServiceUser.getInstance().ShowAllUsers().get(i).getUserType().equals("Parent")){
                ParentNbr++;
            }

        }
        TotalNbr=TeacherNbr+StudentNbr+ParentNbr;
        double[] values = new double[]{(TeacherNbr*100)/TotalNbr , (StudentNbr*100)/TotalNbr , (ParentNbr*100)/TotalNbr};

        // Set up the renderer
        int[] colors = new int[]{ColorUtil.rgb(77, 175, 74), ColorUtil.rgb(228, 26, 28), ColorUtil.rgb(55, 126, 184)};
        DefaultRenderer renderer = buildCategoryRenderer(colors);
        renderer.setZoomButtonsVisible(true);
        renderer.setZoomEnabled(true);
        renderer.setChartTitleTextSize(50);
        renderer.setDisplayValues(true);
        renderer.setShowLabels(true);


        // Create the chart ... pass the values and renderer to the chart object.
        PieChart chart = new PieChart(buildCategoryDataset("Marks Zone", values), renderer);

        // Wrap the chart in a Component so we can add it to a form
        ChartComponent c = new ChartComponent(chart);
        gui_Container_1.addComponent(c);
        Button btnConfirm = new Button("Users Statistics");
        gui_Container_1.addComponent(btnConfirm);





        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_1);


    }// </editor-fold>

    protected CategorySeries buildCategoryDataset(String title, double[] values) {
        CategorySeries series = new CategorySeries(title);
        int k = 0;
        for (double value : values) {
            if (k==0){

                series.add("Teachers : "+TeacherNbr+" Teachers   ", value);
            }
            if (k==1){
                series.add("Students : "+StudentNbr+" Students   ", value);
            }
            if (k==2){
                series.add("Parents : "+ParentNbr+" Parents   ", value);
            }

            k++;
        }

        return series;
    }

//-- DON'T EDIT ABOVE THIS LINE!!!
}