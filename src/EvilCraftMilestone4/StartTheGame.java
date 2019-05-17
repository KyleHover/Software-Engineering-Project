/*
 * Copyright (C) 2019 khover
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
package EvilCraftMilestone4;

import BridgePattern.ICanvasDevice;
import BridgePattern.ISoundDevice;
import EvilCraft.AI;
import EvilCraft.ButtonController;
import EvilCraft.GameEngine;
import EvilCraft.MouseSprite;
import EvilCraft.Sprite;

/**
 *
 * @author khover
 */
public class StartTheGame extends GameEngine{

    /**
     *
     * @param mapPath
     * @param mainview
     * @param minimap
     * @param factoryPanel
     * @param sound
     */
    public StartTheGame(String mapPath, ICanvasDevice mainview, ICanvasDevice minimap, ICanvasDevice factoryPanel, ISoundDevice sound) {
        super(mapPath, mainview, minimap, factoryPanel, sound);
    }
    @Override 
    public void init(){
        //DON'T KILL THE following line
        ge_instance  = this;
        //DON'T KILL THE ABOVE LINE
        this.humanController = new ButtonController(this.arrTeams.get(0), this.buttonCanvas);
        this.loadGameMap(this.mapPath);
        this.mainview.setupEventHandler(this);
        this.minimap.setupEventHandler(this);
        for(Sprite sp: this.arrMapTiles){
            sp.drawOnMiniMap(minimap);
        }
        this.createBackground();  
        this.mouseSprite = new MouseSprite(mainview, minimap);   
        this.mainview.setupEventHandler(this);   
        
        this.aiButtonController = new ButtonController(this.getAITeam(), null); //no display device
        this.ai = new AI(this.getAITeam(), this.aiButtonController);
    }
    protected int ticks = 0;
}
