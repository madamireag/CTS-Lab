package com.company;

public class MacaraRobotizata implements Runnable {

 PortContainer pc;
 Macara mc;

    public MacaraRobotizata(PortContainer pc, Macara mc) {
        this.pc = pc;
        this.mc = mc;
    }

    public PortContainer getPc() {
        return pc;
    }

    public void setPc(PortContainer pc) {
        this.pc = pc;
    }

    public Macara getMc() {
        return mc;
    }

    public void setMc(Macara mc) {
        this.mc = mc;
    }

    @Override
    public void run() {
//        while (true){
//            for(int i=0;i<pc.getTipContainer().length;i++){
//
//                if(mc.getTipContainer().toString()==pc.getTipContainerIndex(i).toString())
//                         mc.DescarcaContainer(pc,mc);
//
//            }
//
//           Thread.currentThread();
//            try {
//                Thread.sleep(mc.getTimpManipulare());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
