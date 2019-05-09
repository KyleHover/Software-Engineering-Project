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
<<<<<<< HEAD
public class Tank extends Sprite{

    protected String pic = "resources/images/team_red/tank/body.png";
    public Tank(Team team, int x, int y, int w, int h) {
        super(team, x, y, w, h);
=======
public class Tank extends Sprite {

    protected String body = "resources/images/team_red/tank/body.png";
    protected String gun = "resources/images/team_red/tank/gun.png";
    protected int body_degree = 0;
    protected int gun_degree = 0;

    public Tank(Team team, int x, int y, int w, int h) {
        super(team, x, y, w, h, 300, 0, 2);
        GameEngine ge = GameEngine.getInstance();
        body = this.team==ge.getPlayerTeam()? "resources/images/team_red/tank/body.png": "resources/images/team_yellow/tank/body.png";
        gun = this.team==ge.getPlayerTeam()? "resources/images/team_red/tank/gun.png": "resources/images/team_yellow/tank/gun.png";
>>>>>>> origin/NEW_MODULE_C
    }

    @Override
    public void update() {
<<<<<<< HEAD
        if(this.navigationGoal!=null){
            if(this.x<navigationGoal.x){
                x++;
            }else{
                x--;
            }
            if(this.y<navigationGoal.y){
                y++;
            }else{
                y--;
            }
        }        
=======

>>>>>>> origin/NEW_MODULE_C
    }

    @Override
    public void drawOnMainView(ICanvasDevice mainview) {
<<<<<<< HEAD
        mainview.drawImg(pic, x, y, w, h, 0);
=======
        mainview.drawImg(body, this.getX() - this.getW() / 2, this.getY() - this.getH() / 2, this.getW(), this.getH(), body_degree);
        mainview.drawImg(gun, this.getX() - this.getW() / 2, this.getY() - this.getH() / 2, this.getW(), this.getH(), gun_degree);
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
        return this.defaultGetNextMove(5);
    }

    @Override
    public boolean isFacing(Point pt) {
        return this.defaultIsFacing(body_degree, pt);
    }

    @Override
    public void adjustBodyHeading(Point pt) {
        float targetDegree = this.getAngle(new Point(this.getX(), this.getY()), pt);
        int iTargetDegree = (int) targetDegree;
        int diff = (iTargetDegree-this.body_degree+360)%360;
        if (diff > 180) {
            //turn left
            diff = diff - 180;
            int offset = diff < 10 ? diff : 10;
            this.body_degree -= offset;
        } else {
            int offset = diff < 10 ? diff : 10;
            this.body_degree += offset;
        }
        this.body_degree = (this.body_degree+360)%360;
    }

>>>>>>> origin/NEW_MODULE_C
}
