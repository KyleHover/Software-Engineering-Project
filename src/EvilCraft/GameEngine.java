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
import BridgePattern.IGameEngine;
import BridgePattern.ISoundDevice;
import java.util.ArrayList;

/**
 *
 * @author csc190
 */
public class GameEngine implements IGameEngine{
    // -------------- DATA MEBERS ------------------
    protected String mapPath;
    protected Map map;
    protected ICanvasDevice mainview;
    protected ICanvasDevice minimap;
    protected ISoundDevice soundDevice;
    protected ICanvasDevice buttonCanvas;
    protected static GameEngine ge_instance = null;
    protected ArrayList<Sprite> arrSprites = new ArrayList<Sprite>(); //moving objects
    protected ArrayList<StaticObject> arrMapTiles = new ArrayList<StaticObject>();
    protected ArrayList<Team> arrTeams = new ArrayList<Team>();
    protected ButtonController humanController;
<<<<<<< HEAD
=======
    protected ArrayList<Sprite> arrSelected = null;
    protected MouseSprite mouseSprite = null;

>>>>>>> origin/NEW_MODULE_B
    
    protected boolean [][] taken;
    //---------------- OPERATIONS ------------------
    /**
     * Constructor.
     * An evil craft game engine has 3 canvases: main view, mini map and a panel for manufacturing units
     * @param mapPath
     * @param mainview
     * @param minimap
     * @param factoryPanel
     * @param sound 
     */
    public GameEngine(String mapPath, ICanvasDevice mainview, ICanvasDevice minimap, ICanvasDevice factoryPanel, ISoundDevice sound){
        this.mapPath = mapPath;
        this.mainview = mainview;
        this.minimap = minimap;
        this.buttonCanvas = factoryPanel;
        this.soundDevice = soundDevice;
        Team team1 = new Team(10000, "Human");
        Team team2 = new Team(10000, "AI");
        this.arrTeams.add(team1);
        this.arrTeams.add(team2);
        this.loadGameMap(mapPath);
<<<<<<< HEAD
        
=======
        this.mouseSprite = new MouseSprite(this.mainview, this.minimap);
>>>>>>> origin/NEW_MODULE_B
        
        
        //TEMPORARY
        taken = new boolean [20][];
        for(int i=0; i<20; i++){
            taken[i] = new boolean [20];
            for(int j=0; j<20; j++){
                taken[i][j] = false;
            }
        }
        //TEMPORARY REMOVE ABOVE
        ge_instance = this;
    }
    
    public static GameEngine getInstance(){
        
        return ge_instance;
    }

    @Override
    public void init() {
        //DON'T KILL THE following line
<<<<<<< HEAD
        //set up the ButtonController
        humanController = new ButtonController(this.arrTeams.get(0), this.buttonCanvas);
        this.mainview.setupEventHandler(this);
=======
        //set up the ButtonController        
        this.mainview.setupEventHandler(this);
        this.minimap.setupEventHandler(this);
        for(Sprite sp: this.arrMapTiles){
            sp.drawOnMiniMap(minimap);
        }
        this.createBackground();
>>>>>>> origin/NEW_MODULE_B
        ge_instance  = this;
        
        //DON'T KILL THE ABOVE LINE
    }

    @Override
    public void onTick() {
<<<<<<< HEAD
        for(int i=0; i<this.arrMapTiles.size(); i++){
            this.arrMapTiles.get(i).drawOnMainView(mainview);
        }
=======
        this.mainview.clear();
        this.minimap.clear();
        for(int i=0; i<this.arrMapTiles.size(); i++){
            this.arrMapTiles.get(i).drawOnMainView(mainview);
        }
        this.drawBackgroundOfMiniMap();
>>>>>>> origin/NEW_MODULE_B
        for(int i=0; i<this.arrSprites.size(); i++){
            this.arrSprites.get(i).update();
            this.arrSprites.get(i).drawOnMainView(mainview);
            this.arrSprites.get(i).drawOnMiniMap(minimap);
        }
<<<<<<< HEAD
        Team winner = this.CheckWinner();
        if(winner!=null){
            this.endGame(winner);
        }
        
        this.humanController.onTick();
=======
        
        this.mouseSprite.update();
        this.mouseSprite.drawOnMainView(mainview);
        
        
        
>>>>>>> origin/NEW_MODULE_B
    }

    @Override
    public void onRightClick(ICanvasDevice canvas, int x, int y) {
<<<<<<< HEAD
=======
        Point pt = this.getGlobalCoordinates(canvas, x, y, map);
        Point pt1 = new Point(pt.x-25, pt.y-25);
        Point pt2 = new Point(pt.x+25, pt.y+25);
        ArrayList<Sprite> targets = this.getArrSprites(pt1, pt2, this.getAITeam());
        Sprite target = targets==null || targets.size()==0? null: targets.get(0);
        if(this.arrSelected!=null && this.arrSelected.size()>0){
            for(Sprite sprite: this.arrSelected){
                sprite.setNavigationGoal(pt);
                sprite.setAttackGoal(target);
            }
        }
        this.mouseSprite.handleEvnet(MouseEvent.RightClick, canvas, x, y, this.arrSelected);
>>>>>>> origin/NEW_MODULE_B
        
    }

    @Override
    public void onLeftClick(ICanvasDevice canvas, int x, int y) {
<<<<<<< HEAD
        
=======
        this.arrSelected = null;
        if(canvas==this.minimap){
            Point pt = this.getGlobalCoordinates(canvas, x, y, map);
            this.mainview.setViewPort(pt.x-mainview.getWidth()/2, pt.y-mainview.getHeight()/2);
        }
        this.mouseSprite.handleEvnet(MouseEvent.LeftClick, canvas, x, y, null);
>>>>>>> origin/NEW_MODULE_B
    }

    @Override
    public void onRegionSelected(ICanvasDevice canvas, int x1, int y1, int x2, int y2) {
<<<<<<< HEAD
        
=======
        Point pt1 = this.getGlobalCoordinates(canvas, x1, y1, map);
        Point pt2 = this.getGlobalCoordinates(canvas, x2, y2, map);
        this.arrSelected = this.getArrSprites(pt1, pt2, this.getPlayerTeam());
>>>>>>> origin/NEW_MODULE_B
    }
    
    /**
     * Load map tils and load them into the arrMapTiles of the GameEngine.
     * Also create the Map object
     * @param mapPath 
     */
    public void loadGameMap(String mapPath){
        this.mapPath = mapPath;
<<<<<<< HEAD
        this.map = new Map(mapPath);
=======
        this.map = new Map(mapPath, this.mainview);
>>>>>>> origin/NEW_MODULE_B
        for(int i=0; i<map.getNumRows(); i++){
            for(int j=0; j<map.getNumCols(); j++){
                String maptile = this.map.getMapTile(i, j);
               
                if(maptile.equals("b1")){
                    Base b1 = new Base(this.arrTeams.get(0), j*100, i*100, 100, 100, maptile);
                    this.arrTeams.get(0).setBase(b1);
                    this.arrMapTiles.add(b1);
                }else if(maptile.equals("b2")){
                    Base b2 = new Base(this.arrTeams.get(1), j*100, i*100, 100, 100, maptile);
                    this.arrTeams.get(1).setBase(b2);
                    this.arrMapTiles.add(b2);
                }else{
                    StaticObject s1 = new StaticObject(null, j*100, i*100, 100, 100, maptile);
                     this.arrMapTiles.add(s1);
                }
                
            }
        }
    }
    
    /**
     * Return the left top corner of a free space close to (x,y)
     * The requested free space's dimension is (w,h)
     * @param x
     * @param y
     * @param w
     * @param h
     * @return 
     */
    
    public Point getFreeSpace(int x, int y, int w, int h){
<<<<<<< HEAD
        for(int i=0; i<20; i++){
            for(int j=0; j<20; j++){
                if(!taken[i][j]){
                    int x1 = x+50*j;
                    int y1 = y + 50*i;
                    if(x1>=0 && x1<this.map.getNumCols()*100 && y1>=0 && y1<this.map.getNumRows()*100){
                        taken[i][j] = true;
                        return new Point(x1, y1);
                    }
                }
            }
        }
=======
        
>>>>>>> origin/NEW_MODULE_B
        throw new UnsupportedOperationException("not implemented yet!");
    }
    
    public void addSprite(Sprite s){
        this.arrSprites.add(s);
    }
    
    public void removeSprite(Sprite s){
        this.arrSprites.remove(s);
    }
    
    /**
     * return null if no winner
     * @return 
     */
    public Team CheckWinner(){
<<<<<<< HEAD
        for(int i=0; i<=1; i++){
            Team team = this.arrTeams.get(i);
            if(team.getBase().isDead()){
                return this.arrTeams.get(1-i);
            }
        }
        return null;
=======
        
        throw new UnsupportedOperationException("not implemented");  
>>>>>>> origin/NEW_MODULE_B
    }
    
    /**
     * Display the message correspondingly
     * @param winner 
     */
    public void endGame(Team winner){
<<<<<<< HEAD
        String msg = winner.getName().equals("Human")? "You Win!": "You Lose";
        this.mainview.drawText(msg, 400, 400, 20);
=======
     throw new UnsupportedOperationException("not implemented");  
    }

    /**
     * Translates the (x1,y1) in canvas into the coordinates in Map
     * @param canvas
     * @param x1
     * @param y1
     * @return 
     */
    public Point getGlobalCoordinates(ICanvasDevice canvas, int x1, int y1, Map map){
        int cw = canvas.getWidth();
        int ch = canvas.getHeight();
        int mw = map.getNumCols()*100;
        int mh = map.getNumRows()*100;
        int x2 = canvas==this.mainview? canvas.getX()+x1: canvas.getX() + x1 * mw/cw;
        int y2 = canvas==this.mainview? canvas.getY() + y1: canvas.getY() + y1*mh/ch;
        return new Point(x2,y2);
    }
    
    /**
     * Return the new left-top corner of mainview so that center point is now
     * located at the center of the mainview
     * @param center
     * @param mainview
     * @return 
     */
    public Point getNewLeftTopCoordinates(Point center, ICanvasDevice mainview){
        Point nl = new Point(center.x- mainview.getWidth()/2, center.y - mainview.getHeight()/2);
        return nl;
    }
    /**
     * 
     * @return human player team (by default it's arrTeams[0])
     */
    public Team getPlayerTeam(){
        return this.arrTeams.get(0);
    
    }
    
    /**
     * 
     * @return computer team (by default it's arrTeams[1])
     */
    public Team getAITeam(){
         return this.arrTeams.get(1);
    }
    
    protected boolean isCollide(int x1, int y1, int w1, int h1, int x2, int y2, int w2, int h2){
       int xmax = Integer.max(x1, x2);
       int xmin = Integer.min(x1+w1-1, x2+w2-1);
       int ymax = Integer.max(y1, y2);
       int ymin = Integer.min(y1 + h1-1, y2 + h2-1);
       return xmin>=xmax && ymin>=ymax;
    }
    /**
     * Get the units (including base but not map tiles) in between pt1 and pt2 that
     * belongs to the given team. If team is null, then both team's units will be 
     * included. Suggestion: use some advanced data storage to guarantee quick response!
     * @param pt1
     * @param pt2
     * @param team
     * @return 
     */
    public ArrayList<Sprite> getArrSprites(Point pt1, Point pt2, Team team){
         //slow version
         ArrayList<Sprite> toRet = new ArrayList<Sprite>();
         for(int i=0; i<this.arrSprites.size(); i++){
             Sprite sp = this.arrSprites.get(i);
             if(team==null || sp.getTeam()==team){
                 int x1 = sp.x;
                 int y1 = sp.y;
                 int w1 = sp.w;
                 int h1 = sp.h;
                 int x2 = pt1.x;
                 int y2 = pt1.y;
                 int w2 = pt2.x-pt1.x;
                 int h2 = pt2.y-pt1.y;
                 if(isCollide(x1, y1, w1, h1, x2, y2, w2, h2)){
                     toRet.add(sp);
                 }
             }
         }
         return toRet;
    }

    @Override
    public void onMouseMoved(ICanvasDevice canvas, int x, int y) {
        Point pt = this.getGlobalCoordinates(canvas, x, y, map);
        ArrayList<Sprite> arrSprites = this.getArrSprites(new Point(pt.x-25, pt.y-25), new Point(pt.x+25, pt.y+25), this.getAITeam());
        this.mouseSprite.handleEvnet(MouseEvent.MouseMove, canvas, x, y, arrSprites);
        
    }
    
    /**
     * Create a background WritableImage for the MiniMap.
     * Implementation idea: draw all maptiles as colored squares on the mini maps
     * canvas and take a snapshot and save it as a WritableImage. Later you can simply
     * draw that image in the minimap's canvas.
     * Note: call canvas.takeSnapshot function.
     */
    public void createBackground(){
        this.minimap.takeSnapshot("miniview_snapshot");
    }
    
    /**
     * Take the previously saved snapshot of Minimap background and draw it.
     */
    public void drawBackgroundOfMiniMap(){
        this.minimap.clear();
        this.minimap.drawImg("miniview_snapshot", 0, 0, minimap.getWidth(), minimap.getHeight(), 0);
>>>>>>> origin/NEW_MODULE_B
    }
    
}
