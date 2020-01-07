/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cableaccessnetwork;

/**
 *
 * @author Admin
 */
abstract class CM {
    private final CMTS myCMTS;

    public CM(int speed, CMTS cmts) {
        this.speed = speed;
        this.myCMTS = cmts;
    }

    @Override
    public String toString() {
        return "CM{ speed=" + speed + '}';
    }

    public int getSpeed() {
        return speed;
    }
    private int speed;
    public void requestReg(){
        myCMTS.requestReg(this);    
    }
    public void leaveCmts() {
        myCMTS.leaveCmts(this);
    }

    void addChannel(Channel newChan) {
        System.out.println("CM added to "+ newChan.toString());
    }

    abstract public boolean matchUsChan(UsChannel usChan);
    
}
