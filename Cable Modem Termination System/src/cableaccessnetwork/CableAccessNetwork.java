/*
 * This prototype of lab 3 code does not follow the design shown in the class diagram
 * in lab3.jpg.  See if you can find the bugs in the code.  Look in 
 * Uchannel.matchCM(CM) for an example of fragile code based on an incomplete design
 * implementation.
 * Based on this code can you make an object diagram of this instance of the program
 */
package cableaccessnetwork;

/**
 *
 * @author Admin
 */
public class CableAccessNetwork {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //create a CMTS
        //give the CMTS 2 US Channels
        //and 2 DS Channels
        //set the bandwidth for the channels
        //create a few CMs of version1 and version2 types
        //set the requested speed for the CMs
        //have the CMs request registration from the CMTS
        CMTS myCmts = new CMTS();
        System.out.println("created a CMTS");
        
        //now create two Upstream Channels 
        UsChannel us1 = new UsChannel(1000000,1);
        us1.setMyModulationProfile(ModulationProfile.TDMA);
        myCmts.addUsChan(us1);
        System.out.println("created a TDMA Upstream Channel");
        
        UsChannel us2 = new UsChannel(10000000,2);
        us2.setMyModulationProfile(ModulationProfile.SCDMA);
        myCmts.addUsChan(us2);
        System.out.println("created an SCDMA Upstream Channel");
        
        //now create two downstream channels
        DsChannel ds1 = new DsChannel(30000000, 1);
        myCmts.addDsChan(ds1);
        System.out.println("created one downstream Channel");
        
        DsChannel ds2 = new DsChannel(40000000, 2);
        myCmts.addDsChan(ds2);
        System.out.println("created second downstream Channel");
        
        //now create 4 CMs
        Version1Cm cm1 = new Version1Cm (1500000, myCmts);
        Version2Cm cm2 = new Version2Cm (1500000, myCmts);
        Version1Cm cm3 = new Version1Cm (100000, myCmts);
        Version2Cm cm4 = new Version2Cm (1500000, myCmts);
        
        System.out.println("created 2 Version1 CMs and 2 Version2 CMs");
        System.out.println("version1 CM request Register");
        cm1.requestReg();
        System.out.println("version2 CM request Register");
        cm2.requestReg();
        System.out.println("version1 CM request Register");
        cm3.requestReg();
        System.out.println("version2 CM request Register");
        cm4.requestReg();
        
        
        
        
        
    }
}
