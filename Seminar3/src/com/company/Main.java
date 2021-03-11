package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;


public class Main {

    public static void main(String[] args) {
        int[] nrContainere=new int[]{2,1,0,1};
        TipContainer[]tip=new TipContainer[4];
        tip=TipContainer.values();

        PortContainer portContainer=new PortContainer("Port Container 1",tip,nrContainere);


        System.out.println(portContainer);
        PortContainer portContainer1=new PortContainer();

        try {
            portContainer1 = (PortContainer)    portContainer.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Nu s-a putut clona!");

        }
        System.out.println("\n Clona:\n");
        System.out.println(portContainer1);
        portContainer1.setEticheta("SS Tipton");
        int[] nrContainerePort2=new int[]{3,1,2,0};

        System.out.println("Capacitatea navei "+portContainer.getEticheta()+" este "+
                portContainer.getCapacitate());
        PortContainer portContainer2=new PortContainer("Port Container 3",tip,nrContainerePort2);
        int[] nrContainerePort3=new int[]{3,4,2,1};

        PortContainer portContainer3=new PortContainer("Port Container 4",tip,nrContainerePort3);
        ArrayList<PortContainer> listaContainere=new ArrayList<PortContainer>();
        listaContainere.add(portContainer);
        listaContainere.add(portContainer1);
        listaContainere.add(portContainer2);
        listaContainere.add(portContainer3);

        System.out.println("\n------ Flota de port containere (ArrayList)-------- \n");
        for(var i:listaContainere){
        System.out.println(i);
        }


        FileWriter outFile = null;
        BufferedWriter writer = null;
        try {
            outFile = new FileWriter("PortContainere.csv", false);
            writer = new BufferedWriter(outFile);

            for (PortContainer i:listaContainere) {
                writer.write(i.toCSVFormat());
                writer.newLine();
            }
            writer.close();
            outFile.close();
        } catch (IOException e) {
            System.out.println("\n AJUTOR, NU POT SA SCRIU IN FISIER!!\n");
            e.printStackTrace();
        }


        System.out.println("\n----CITIRE COLECTIE DIN FISIER SI SALVARE IN ALTA COLECTIE----\n");
        LinkedList<PortContainer> listaNoua = new LinkedList<PortContainer>();
        try {
            FileInputStream fileInputStream = new FileInputStream("PortContainere.csv");
            InputStreamReader streamReader = new InputStreamReader(fileInputStream);
            BufferedReader reader = new BufferedReader(streamReader);
            for (PortContainer i : listaContainere) {
                String linieFisierCSV = reader.readLine();
                String[] text = linieFisierCSV.split(",");

                PortContainer portContainerCitit = new PortContainer();
                portContainerCitit.setEticheta(text[0]);
                String[] unu=text[1].split(";");
                TipContainer[] tipContainerCitit=new TipContainer[unu.length];
                for(int k=0;k<unu.length;k++){
                    tipContainerCitit[k]=TipContainer.valueOf(unu[k]);
                }
                portContainerCitit.setTipContainer(tipContainerCitit);
                String[] vectornou = text[2].split(";");
                int[] vectorulmeu = new int[vectornou.length];
                for (int j = 0; j < vectornou.length; j++) {
                    vectorulmeu[j] = Integer.parseInt(vectornou[j]);
                }
                portContainerCitit.setNrContainere(vectorulmeu);
                listaNoua.add(portContainerCitit);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("\n Ajutor, nu merge citirea din fisier :( \n");
            e.printStackTrace();
        }
        System.out.println("\n------ Colectia de port containere (LinkedList)-------- \n");
        for (PortContainer gigi : listaNoua) {
            System.out.println(gigi);
        }








        }
    }

