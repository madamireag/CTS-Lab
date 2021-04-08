package ro.ase.acs.facade;

public class Lights {
    private boolean areHeadLightsOn;
    private boolean areBrakeLightsOn;
    private boolean areHazardLightsOn; // avarii
    private boolean isSignalLeftOn;
    private boolean isSignalRightOn;

    public boolean areHeadLightsOn() {
        return areHeadLightsOn;
    }

    public void setHeadLightsOn(boolean areHeadLightsOn) {
        this.areHeadLightsOn = areHeadLightsOn;
        System.out.println(areHeadLightsOn? "Headlights on" : "Headlights off");
    }

    public boolean areBrakeLightsOn() {
        return areBrakeLightsOn;
    }

    public void setBrakeLightsOn(boolean areBreakLightsOn) {
        this.areBrakeLightsOn = areBreakLightsOn;
        System.out.println(areBreakLightsOn? "BrakeLights on" : "BrakeLights off");
    }

    public boolean areHazardLightsOn() {
        return areHazardLightsOn;
    }

    public void setHazardLightsOn(boolean areHazardLightsOn) {
        this.areHazardLightsOn = areHazardLightsOn;
        System.out.println(areHazardLightsOn? "HazardLights on" : "HazardLights off");
    }

    public boolean isSignalLeftOn() {
        return isSignalLeftOn;
    }

    public void setSignalLeftOn(boolean signalLeftOn) {
        isSignalLeftOn = signalLeftOn;
        System.out.println(isSignalLeftOn? "SignalLeft on" : "SignalLeft off");
    }

    public boolean isSignalRightOn() {
        return isSignalRightOn;
    }

    public void setSignalRightOn(boolean signalRightOn) {
        isSignalRightOn = signalRightOn;
        System.out.println(isSignalRightOn? "SignalRight on" : "SignalRight off");
    }
}
