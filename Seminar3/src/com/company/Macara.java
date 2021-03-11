package com.company;

public class Macara implements Descarcare,Runnable{
    private TipContainer tipContainer;
    private int timpManipulare;

    public Macara(TipContainer tipContainer, int timpManipulare) {
        this.tipContainer = tipContainer;
        this.timpManipulare = timpManipulare;
    }

    public Macara() {
        this.tipContainer=TipContainer.Mic_10mc;
        this.timpManipulare=0;
    }

    public TipContainer getTipContainer() {
        return tipContainer;
    }

    public void setTipContainer(TipContainer tipContainer) {
        this.tipContainer = tipContainer;
    }

    public int getTimpManipulare() {
        return timpManipulare;
    }

    public void setTimpManipulare(int timpManipulare) {
        this.timpManipulare = timpManipulare;
    }

    @Override
    public int DescarcaContainer(PortContainer pc, Macara m) {
        int nrcont=0;
        for(int i=1;i<pc.getTipContainer().length;i++){
                 if(pc.getTipContainerIndex(i).toString()==m.tipContainer.toString()){
                        pc.setContainer(i,pc.getNrContainereIndex(i)-1);
                         nrcont=pc.getNrContainereIndex(i);
                    }


        }
        return nrcont;
       }

    @Override
    public void run() {


        while (true) {

               try {
                Thread.currentThread().sleep(timpManipulare);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
