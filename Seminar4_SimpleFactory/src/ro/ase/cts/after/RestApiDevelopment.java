package ro.ase.cts.after;

import ro.ase.cts.after.contract.RestApi;

public class RestApiDevelopment implements RestApi {

    public RestApiDevelopment() {
        System.out.println("Api development");
    }

    @Override
    public void connect(){
        System.out.println("Connected successfully");
    }

}
