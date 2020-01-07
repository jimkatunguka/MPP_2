/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cableaccessnetwork;

/**
 *
 * @author Admin
 */
class Version1Cm extends CM {

    public Version1Cm(int speed, CMTS cmts) {
        super(speed, cmts);
    }

    @Override
    public String toString() {
        return "Version1Cm{ speed =" + super.getSpeed() +'}';
    }
    @Override
    public boolean matchUsChan(UsChannel us){
        if (us.getMyModulationProfile()== ModulationProfile.TDMA)
            return true;
        else
            return false;
    }
    
    
}
