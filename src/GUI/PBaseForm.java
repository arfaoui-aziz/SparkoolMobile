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
import com.codename1.ui.*;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;

/**
 * Utility methods common to forms e.g. for binding the side menu
 *
 * @author Shai Almog
 */
public class PBaseForm extends Form {
    public void installSidemenu(Resources res,String id) {
        Image selection = res.getImage("selection-in-sidemenu.png");
        Image inboxImage = null;
        if(isCurrentInbox()) inboxImage = selection;

        Image trendingImage = null;
        if(isCurrentTrending()) trendingImage = selection;
        
        Image calendarImage = null;
        if(isCurrentCalendar()) calendarImage = selection;
        
        Image statsImage = null;
        if(isCurrentStats()) statsImage = selection;
        Image HomeImage = null;
        if(isCurrentStats()) HomeImage = selection;

        getToolbar().addCommandToSideMenu("Home", HomeImage, e -> new PMyForm(res,id).show());
        getToolbar().addCommandToSideMenu("Information", statsImage, e -> new PInfoForm(res,id).show());
        getToolbar().addCommandToSideMenu("Claims", statsImage, e -> new PInboxForm(res,id).show());



        getToolbar().addCommandToSideMenu("Marks", null, e -> new PMarksForm(id).show());
        getToolbar().addCommandToSideMenu("Statistics", null, e -> new PStatForm(id).show());
        getToolbar().addCommandToSideMenu("Event", null, e -> new EEventForm(id).show());
        getToolbar().addCommandToSideMenu("Clubs", null, e -> new EClubsForm(id).show());

        getToolbar().addCommandToSideMenu("Account", null, e -> new ShareButton());
        getToolbar().addCommandToSideMenu("Signout", null, e -> new SignInForm(res,id).show());
        
        // spacer
        getToolbar().addComponentToSideMenu(new Label(" ", "SideCommand"));
       // getToolbar().addComponentToSideMenu(new Label(res.getImage("profile_image.png"), "Container"));
        getToolbar().addComponentToSideMenu(new Label(ServiceUser.getInstance().ShowUser(id).get(0).getFirstName()+" "+ServiceUser.getInstance().ShowUser(id).get(0).getLastName(), "SideCommandNoPad"));
    }

        
    protected boolean isCurrentInbox() {
        return false;
    }
    
    protected boolean isCurrentTrending() {
        return false;
    }

    protected boolean isCurrentCalendar() {
        return false;
    }

    protected boolean isCurrentStats() {
        return false;
    }
}
