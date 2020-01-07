package payroll;

public enum Tax {
    FICA(23),
    STATE(5),
    LOCAL(1),
    MEDICARE(3),
    SOCIALSECURITY(7.5),;

    private final double taxPercentage;

    private Tax(double taxPercentage){
        this.taxPercentage = taxPercentage;
    }

    public double taxValue(){
        return taxPercentage;
    }
}

