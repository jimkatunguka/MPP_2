/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cableaccessnetwork;

/**
 *
 * @author Admin
 */
class LoadBalancer {
    private final CMTS myCMTS;

    LoadBalancer(CMTS cmts) {
        this.myCMTS = cmts;
    }
    public boolean addCM(CM newCm){
        boolean retVal = true;
        //first find a DS channel for this CM
        DsChannel bestDs =findBestDs(newCm);
        UsChannel bestUs = findBestUs(newCm);
        if (bestDs != null && bestUs != null){
            System.out.println("bestDs ="+bestDs.toString());
            System.out.println("bestUs ="+bestUs.toString());
            bestDs.addNewCm(newCm);
            bestUs.addNewCm(newCm);
            //the channels will notify the CM of the channel ids 
        }
        else
        {
            //could not find a DS - give up
            System.out.println("could not find a channels for this CM - registration failed");
            retVal = false;
        }
        return retVal;
    }

    private DsChannel findBestDs(CM newCm) {
        DsChannel bestDs = null;
        int bestAvailBw = 0;
        for (DsChannel dsChan: myCMTS.getMyDsChans()) 
        {
            int availBw = dsChan.getTotalBw() - dsChan.getAllocatedBw();
            if (availBw >= newCm.getSpeed() && 
                    availBw > bestAvailBw)
            {
                bestDs = dsChan;
                bestAvailBw = availBw;            
            }
        }
    return bestDs;
    }

    private UsChannel findBestUs(CM newCm) {
        UsChannel bestUs = null;
        int bestAvailBw = 0;
        int availBw = 0;
        for (UsChannel usChan: myCMTS.getMyUsChans()) 
        {
            if (newCm.matchUsChan(usChan))
            {
                availBw = usChan.getTotalBw() - usChan.getAllocatedBw();
            if (availBw >= newCm.getSpeed() && 
                    availBw > bestAvailBw)
            {
                bestUs = usChan;
                bestAvailBw = availBw;            
            }
            }
        }
    return bestUs;
    }
}
