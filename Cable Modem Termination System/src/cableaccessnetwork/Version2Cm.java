/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cableaccessnetwork;

/**
 *
 * @author Admin
 */
class Version2Cm extends CM{

    public Version2Cm(int speed, CMTS cmts) {
        super(speed, cmts);
    }
    @Override
    public String toString() {
        return "Version2Cm{ speed =" + super.getSpeed() +'}';
    }
    @Override
    public boolean matchUsChan(UsChannel us){
        if (us.getMyModulationProfile()== ModulationProfile.SCDMA)
            return true;
        else
            return false;
    }
    
}
