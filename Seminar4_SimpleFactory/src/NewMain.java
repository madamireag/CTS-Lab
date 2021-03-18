import ro.ase.cts.after.RestApiFactory;
import ro.ase.cts.after.contract.RestApi;


public class NewMain {

    public static void main(String[] args){
       RestApi api = RestApiFactory.createConnection("release");
       api.connect();
    }
}
