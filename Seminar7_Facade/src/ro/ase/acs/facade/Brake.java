package ro.ase.acs.facade;

public class Brake {
    private float load = 0;

    public float getLoad() {
        return load;
    }

    public void setLoad(float load) {
        if(load >= 0 && load <= 1) {
            this.load = load;
            System.out.print("New brake value:" + load * 100 + "%");
        }
    }
}
