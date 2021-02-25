package com.company;

import java.util.Arrays;

public class PortContainer implements Cloneable,Numarabil {
    private String eticheta;
    private TipContainer[] tipContainer;
    private int[] NrContainere;

    public PortContainer(String eticheta, TipContainer[] tipContainer, int[] nrContainere) {
        this.eticheta = eticheta;
        this.tipContainer = tipContainer;
        this.NrContainere=nrContainere;

         }

    @Override
    public int getCapacitate() {
        int capacitate=0;
       capacitate=10*this.NrContainere[0]+25*NrContainere[1]+50*NrContainere[2]+100*NrContainere[3];

        return capacitate;


    }

    public PortContainer() {
        this.eticheta="Eticheta necunoscuta";


    }

    public int[] getNrContainere() {
        return NrContainere;
    }

    public void setNrContainere(int[] nrContainere) {
        NrContainere = nrContainere;
    }
    public void setContainer(int index,int value){this.NrContainere[index]=value;}
    public int getNrContainereIndex(int index){
        return  this.NrContainere[index];
    }

    public String getEticheta() {
        return eticheta;
    }

    public void setEticheta(String eticheta) {
        this.eticheta = eticheta;
    }

    public TipContainer[] getTipContainer() {
        return tipContainer;
    }
    public TipContainer getTipContainerIndex(int index){return tipContainer[index];}
    public void setTipContainer(TipContainer[] tipContainer) {
        this.tipContainer = tipContainer;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Eticheta: ");
        builder.append(this.eticheta);
        builder.append(", Tipuri Containere: ");
        for(int i=0;i<this.tipContainer.length;i++)
        {
            builder.append(this.tipContainer[i]);
            builder.append(" ");
        }
        builder.append(", Nr containere: [ ");
        for(int i=0; i<this.NrContainere.length;i++) {
            builder.append(this.NrContainere[i]);
            builder.append(" ");
        }
        builder.append("]");

        return builder.toString();
    }

    @Override
     protected Object clone() throws CloneNotSupportedException {

       PortContainer clona=(PortContainer) super.clone();
       clona.eticheta=eticheta;
       clona.tipContainer=tipContainer;
       clona.NrContainere=new int[NrContainere.length];
       for(int j=0; j<NrContainere.length; j++)
       {
           clona.NrContainere[j]=NrContainere[j];
       }

       return clona;
    }

    public String toCSVFormat() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.eticheta);
        builder.append(",");
        for(int i=0; i<this.tipContainer.length;i++) {
            builder.append(this.tipContainer[i].toString());
            if (i!= this.tipContainer.length-1) {
                builder.append(";");
            }}
        builder.append(",");
        for(int j=0; j<this.NrContainere.length;j++) {
            builder.append(this.NrContainere[j]);
            if (j!= this.NrContainere.length-1) {
                builder.append(";");
            }
        }
        return builder.toString();


}
}
