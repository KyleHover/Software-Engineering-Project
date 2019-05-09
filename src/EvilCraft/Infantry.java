/*
 * Copyright (C) 2019 csc190
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package EvilCraft;

import BridgePattern.ICanvasDevice;

/**
 *
 * @author csc190
 */
public class Infantry extends Sprite{

<<<<<<< HEAD
    protected String pic = "resources/images/team_red/infantry/infantry.png";
    public Infantry(Team team, int x, int y, int w, int h) {
        super(team, x, y, w, h);
=======
    protected String pic;
    public Infantry(Team team, int x, int y, int w, int h) {
        super(team, x, y, w, h, 20, 0, 0);
        pic = this.team==GameEngine.getInstance().getPlayerTeam()?
                "resources/images/team_red/infantry/infantry.png":
                "resources/images/team_yellow/infantry/infantry.png";
>>>>>>> origin/NEW_MODULE_C
    }

    @Override
    public void update() {
<<<<<<< HEAD
        
=======
       
>>>>>>> origin/NEW_MODULE_C
    }

    @Override
    public void drawOnMainView(ICanvasDevice mainview) {
<<<<<<< HEAD
       mainview.drawImg(pic, x, y, w, h, 0);
=======
         mainview.drawImg(pic, this.getX() - this.getW() / 2, this.getY() - this.getH() / 2, this.getW(), this.getH(), 0);
        
>>>>>>> origin/NEW_MODULE_C
    }

    @Override
    public void drawOnMiniMap(ICanvasDevice minimap) {
<<<<<<< HEAD
        int mw = GameEngine.getInstance().map.getNumRows()*100;
        int vw = minimap.getWidth();
        String color = this.team.name.indexOf("Human")>=0? "#FF0000": "#0000FF";
        minimap.drawRectangle(x*vw/mw, y*vw/mw, w*vw/mw, h*vw/mw, color);
    }    
=======
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Point getNextMove() {
        return this.defaultGetNextMove(3);
    }

    @Override
    public boolean isFacing(Point pt) {
       return true;
    }

    @Override
    public void adjustBodyHeading(Point pt) {
        //do nothing
    }
    
>>>>>>> origin/NEW_MODULE_C
}
