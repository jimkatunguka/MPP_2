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
class CMTS {
    private List<UsChannel> myUsChans = new ArrayList<UsChannel>();
    private List<DsChannel> myDsChans = new ArrayList<DsChannel>();
    private LoadBalancer myLoadBalancer = new LoadBalancer(this);

    public List<DsChannel> getMyDsChans() {
        return myDsChans;
    }

    public List<UsChannel> getMyUsChans() {
        return myUsChans;
    }

    public void requestReg(CM addCM) {
        System.out.println("call loadbalancer with " + addCM.toString());
       if (myLoadBalancer.addCM(addCM))
            System.out.println("CM successfully registered");
       else
            System.out.println("CM failed to register");
    }

    @Override
    public String toString() {
        
        return "CMTS{" + myDsChans.size()+"downstreams and"+ myUsChans.size() +"upstreams}";
    }

    public void leaveCmts(CM deleteCM) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public void addUsChan(UsChannel uchan){
        myUsChans.add(uchan);
    }

    void addDsChan(DsChannel dchan) {
        myDsChans.add(dchan);
    }
    
}
