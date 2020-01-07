/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cableaccessnetwork;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
 public abstract class Channel {

    public Channel(int totalBw, int channelId) {
        this.totalBw = totalBw;
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        return "Channel{" + "totalBw=" + totalBw + ", allocatedBw=" + allocatedBw + ", channelId=" + channelId + '}';
    }

    public int getAllocatedBw() {
        return allocatedBw;
    }

    public int getTotalBw() {
        return totalBw;
    }
    
    public void addNewCm(CM newCm){
        myCms.add(newCm);
        allocatedBw += newCm.getSpeed();
        newCm.addChannel(this);
    }
    private int totalBw;
    private int allocatedBw;
    private int channelId;
    private List<CM> myCms = new ArrayList<CM>();
    
    
}
