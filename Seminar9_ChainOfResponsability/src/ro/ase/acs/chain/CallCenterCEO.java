package ro.ase.acs.chain;

public class CallCenterCEO extends CallCenterHandler{
    @Override
    public boolean refund(double sum) {
        System.out.println("Refund was handled by the call CEO");
        return true;
    }
}
