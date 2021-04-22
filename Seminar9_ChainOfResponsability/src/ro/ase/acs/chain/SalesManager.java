package ro.ase.acs.chain;

public class SalesManager extends CallCenterHandler{
    @Override
    public boolean refund(double sum) {
        if(sum < 5000){
            System.out.println("Refund was handled by the sales manager");
            return true;
        } else if(nextHandler != null){
            return nextHandler.refund(sum);
        }
        System.out.println("The refund cannot be handled via call center");
        return false;


    }
}
