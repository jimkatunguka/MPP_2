package payroll;

final public class Paycheck {
    private final double grossPay;
    private final double fica;
    private final double state;
    private final double local;
    private final double medicare;
    private final double socialSecurity;

    public Paycheck(double grossPay){
        this.grossPay = grossPay;
        fica = Tax.FICA.taxValue();
        state = Tax.STATE.taxValue();
        local = Tax.LOCAL.taxValue();
        medicare = Tax.MEDICARE.taxValue();
        socialSecurity = Tax.SOCIALSECURITY.taxValue();
    }

    
    public void print(){
    	StringBuilder sb = new StringBuilder();
    	sb.append("  Gross Pay: " + this.grossPay+"\n");
    	sb.append("  Fica: "+fica/100+"\n");
    	sb.append("  State: "+state/100+"\n");
    	sb.append("  Local: "+local/100+"\n");
    	sb.append("  Medicare: "+medicare/100+"\n");
    	sb.append("  SocialSecurity: "+socialSecurity/100+"\n");
    	sb.append("  NET PAY: " + getNetPay()+"\n");
    	System.out.println(sb.toString());
    }

    public double getNetPay(){
        double netPay = grossPay;
        
        netPay-=((fica/100)*grossPay);
        netPay-=((state/100)*grossPay);
        netPay-=((local/100)*grossPay);
        netPay-=((medicare/100)*grossPay);
        netPay-=((socialSecurity/100)*grossPay);

        return netPay;
    }
}
