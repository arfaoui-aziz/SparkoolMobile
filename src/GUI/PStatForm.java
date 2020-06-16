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
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.util.Resources;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class PStatForm extends PBaseForm {
String id1="";
    public PStatForm(String id) {

        this(Resources.getGlobalResources(),id);
        id1=id;
        System.out.println("il id mta3 stat "+id1);
    }



    @Override
    protected boolean isCurrentInbox() {
        return true;
    }



    public PStatForm(Resources resourceObjectInstance, String id) {
        id1=id;

        initGuiBuilderComponents(resourceObjectInstance);

        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Home", "Title")
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
    protected CategorySeries buildCategoryDataset(String title, double[] values) {
        CategorySeries series = new CategorySeries(title);
        int k = 0;
        for (double value : values) {
            if (k==0){

                series.add("Average between 15 and 20", value);
            }
            if (k==1){
                series.add("Average between 10 and 15", value);
            }
            if (k==2){
                series.add("Average between 0 and 10", value);
            }
            k++;
        }

        return series;
    }
    private void initGuiBuilderComponents(Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
        setInlineStylesTheme(resourceObjectInstance);
        setTitle("MyForm");
        setName("MyForm");

int i1=0,i2=0,i3=0;

        System.out.println("il id mta3 stat22 = "+id1);

        for(int i = 0; i< ServiceUser.getInstance().getMarks(id1).size(); i++){
Double cc = Double.parseDouble(ServiceUser.getInstance().getMarks(id1).get(i).getCc())*0.4;
Double exam = Double.parseDouble(ServiceUser.getInstance().getMarks(id1).get(i).getExam())*0.6;


            if ((cc+exam)<10 ){
                i1++;
            }
            else if ((cc+exam)>=10 && (cc+exam)<15){
                i2++;
            }
            else i3++;

        }
        double[] values = new double[]{i3, i2, i1};

        // Set up the renderer
        int[] colors = new int[]{ColorUtil.rgb(154,205, 50), ColorUtil.rgb(255,127,36), ColorUtil.rgb(238,59,59)};
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
        Label lb1=new Label("Average between 15 and 20");
        gui_Container_1.addComponent(lb1);
        lb1.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new PSubjectListForm(id1,15.0,20.0).show();
                System.out.println("cbn clicked");
            }
        });
        Label lb2=new Label("Average between 10 and 15");
        gui_Container_1.addComponent(lb2);
        lb2.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new PSubjectListForm(id1,10.0,15.0).show();
                System.out.println("cbn clicked");
            }
        });
        Label lb3=new Label("Average between 0 and 10");
        gui_Container_1.addComponent(lb3);
        lb1.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new PSubjectListForm(id1,0.0,10.0).show();
                System.out.println("cbn clicked");
            }
        });

        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_1);


    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
