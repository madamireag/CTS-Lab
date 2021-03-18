package ro.ase.cts.after;

import ro.ase.cts.after.contract.RestApi;

public class RestApiRelease implements RestApi {

    public RestApiRelease() {
        System.out.println("Api release");
    }

    @Override
    public void connect(){
        System.out.println("Connected successfully");
    }

}
