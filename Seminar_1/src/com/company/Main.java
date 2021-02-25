package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;


public class Main {

    public static void main(String[] args) {
        int[] nrCont1=new int[]{2,1,0,1};
        TipContainer[]tip=new TipContainer[4];
        tip=TipContainer.values();

        PortContainer pc1=new PortContainer("Port Container 1",tip,nrCont1);
        System.out.println(pc1);
        PortContainer pc2=new PortContainer();
        //TESTARE CLONE ---------------------------------------------------------
        try {
            pc2 = (PortContainer)    pc1.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Nu s-a putut clona!");

        }
        System.out.println("\n Clona:\n");
        System.out.println(pc2);
        pc2.setEticheta("SS Tipton");
        int[] nrCont2=new int[]{3,1,2,0};
        //TESTARE GETCAPACITATE->pc1: 10*2+1*25+0*50+1*100=145 -------------------------
        System.out.println("Capacitatea navei "+pc1.getEticheta()+" este "+
                pc1.getCapacitate());
        PortContainer pc3=new PortContainer("Port Container 3",tip,nrCont2);
        int[] nrCont3=new int[]{3,4,2,1};
        PortContainer pc4=new PortContainer("Port Container 4",tip,nrCont3);
        //COLECTIE PORT CONTAINERE-----------------------------------------------------
        ArrayList<PortContainer> listaContainere=new ArrayList<PortContainer>();
        listaContainere.add(pc1);
        listaContainere.add(pc2);
        listaContainere.add(pc3);
        listaContainere.add(pc4);

        System.out.println("\n------ Flota de port containere (ArrayList)-------- \n");
        for(var i:listaContainere){
        System.out.println(i);
        }

        //SALVARE COLECTIE IN FISIER------------------------------------------------
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

     //CITIRE COLECTIE(ARRAYLIST) DIN FISIER SI SALVARE IN ALTA COLECTIE(LINKEDLIST)---------------
        System.out.println("\n----CITIRE COLECTIE DIN FISIER SI SALVARE IN ALTA COLECTIE----\n");
        LinkedList<PortContainer> listaNoua = new LinkedList<PortContainer>();
        try {
            FileInputStream fileInputStream = new FileInputStream("PortContainere.csv");
            InputStreamReader streamReader = new InputStreamReader(fileInputStream);
            BufferedReader reader = new BufferedReader(streamReader);
            for (PortContainer i : listaContainere) {
                String linieCsv = reader.readLine();
                String[] text = linieCsv.split(",");

                PortContainer pc = new PortContainer();
                pc.setEticheta(text[0]);
                String[] unu=text[1].split(";");
                TipContainer[] noul=new TipContainer[unu.length];
                for(int k=0;k<unu.length;k++){
                    noul[k]=TipContainer.valueOf(unu[k]);
                }
                pc.setTipContainer(noul);
                String[] vectornou = text[2].split(";");
                int[] vectorulmeu = new int[vectornou.length];
                for (int j = 0; j < vectornou.length; j++) {
                    vectorulmeu[j] = Integer.parseInt(vectornou[j]);
                }
                pc.setNrContainere(vectorulmeu);
                listaNoua.add(pc);
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
        //TESTARE METODA DESCARCA CONTAINER----------------------------------------------
        System.out.println("\n---------TESTARE METODA DESCARCA CONTAINER----------");
        Macara macaraMic=new Macara(TipContainer.Mic_10mc,200);
        Macara macaraMica=new Macara(TipContainer.Mic_10mc,400);
        Macara macaraJumbo=new Macara(TipContainer.Jumbo_100mc,500);
        Macara macaraMediu=new Macara(TipContainer.Mediu_25mc,400);
        System.out.println("\n Numar initial de containere de tip "+macaraMica.getTipContainer()+
                " din nava "+pc1.getEticheta()+" este "+pc1.getNrContainereIndex(0));
        int nrCRamase=macaraMica.DescarcaContainer(pc1,macaraMica);
        System.out.println("\n Numarul de containere de tipul "+macaraMica.getTipContainer()+
                " ramase din nava "+pc1.getEticheta()+" este "+nrCRamase);



        //MacaraRobotizata MacaraRobot=new MacaraRobotizata(pc2,macaraMica);



        }
    }

