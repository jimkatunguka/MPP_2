/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cableaccessnetwork;

/**
 *
 * @author Admin
 */
class UsChannel extends Channel {
    private ModulationProfile myModulationProfile = null;

    public UsChannel(int totalBw, int chanId) {
        super(totalBw, chanId);
    }

    public ModulationProfile getMyModulationProfile() {
        return myModulationProfile;
    }

    public void setMyModulationProfile(ModulationProfile myModulationProfile) {
        this.myModulationProfile = myModulationProfile;
    }

    boolean matchCm(CM newCm) {
        boolean retVal = false;
        //WHAT"S WRONG WITH THIS DESIGN ??
        if(getMyModulationProfile() == ModulationProfile.TDMA &&
                newCm instanceof Version1Cm)
                retVal =true;
        else if(getMyModulationProfile() == ModulationProfile.SCDMA &&
                newCm instanceof Version2Cm)
                retVal = true;
        
        return retVal;
    }
    
}
