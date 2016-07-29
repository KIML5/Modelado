/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Trinity
 */
public class Controller {

    // Variables globales para el método del centro congruencial
    double moda1 = -1;
    ArrayList<String> resultMCC;

    public Controller() {
    }

    public void metodoCentroCongruencial(int seed) {
        resultMCC = new ArrayList<String>();
        int lseed = lenghtNum(seed);
        int i = 0;

        String xiS;
        String completo;
        String medios;
        String Uis;

        int xi;
        int l1;
        int l1_greater=0;
        int l2;
        double ui;
        double M[] = new double[i + 1];
        l1 = 2 * lenghtNum(seed);
        
        while (moda1 == -1) {

            //variable2 - cuadrado
            xi = seed * seed;
            xiS = Integer.toString(xi);
            //variable3 - completos
            l2 = lenghtNum(xi);
            
            
       
            
            if (l1 != l2) {
                String cant = "%0" + Integer.toString(l1) + "d";
                completo = String.format(cant, xi);
            } else {
                completo = Integer.toString(xi);
            }

            //variable4 - medios
            medios = completo.substring((lseed / 2), ((lseed / 2) + lseed));

            //variable5 - Ui
            String div = "1" + String.format("%0" + lseed + "d", 0);
            ui = Double.parseDouble(medios) / Double.parseDouble(div);
            String r = seed + ";" + xiS + ";" + completo + ";" + medios + ";" + Double.toString(ui);
            System.out.println(r);
            resultMCC.add(r);
            seed = Integer.parseInt(medios);
            
            M[i] = (double) ui;
            i++;

//            if (i >= 3) {
                moda1 = moda(M);
                System.out.println(moda1);
  //          }

            //resize method
            M = Arrays.copyOf(M, i + 1);

        }
        for (int k = 0; k < 2; k++) {
            //variable2 - cuadrado
            xi = seed * seed;
            xiS = Integer.toString(xi);
            //variable3 - completos
       

            l2 = lenghtNum(xi);
            if (l1 != l2) {
                String cant = "%0" + Integer.toString(l1) + "d";
                completo = String.format(cant, xi);
            } else {
                completo = Integer.toString(xi);
            }

            //variable4 - medios
            medios = completo.substring((lseed / 2), ((lseed / 2) + lseed));

            //variable5 - Ui
            String div = "1" + String.format("%0" + lseed + "d", 0);
            ui = Double.parseDouble(medios) / Double.parseDouble(div);
            String r = String.format("%0" + l1/2 + "d", seed) + ";" + xiS + ";" + completo + ";" + medios + ";" + Double.toString(ui);
            System.out.println(r);
            resultMCC.add(r);
            seed = Integer.parseInt(medios);
            M[i] = (double) ui;
            i++;
            M = Arrays.copyOf(M, i + 1);
        }
    }

    public double moda(double M[]) {
        int maximaVecesQueSeRepite = 0;
        double moda = 0;

        for (int i = 0; i < M.length; i++) {
            int vecesQueSeRepite = 0;
            for (int j = 0; j < M.length; j++) {
                if (M[i] == M[j]) {
                    vecesQueSeRepite++;
                }
            }
            if (vecesQueSeRepite > maximaVecesQueSeRepite) {
                moda = M[i];
                maximaVecesQueSeRepite = vecesQueSeRepite;
            }
        }

        if(maximaVecesQueSeRepite>2){
            return moda;
        }else{
            return -1;
        }
        
    }

    public int lenghtNum(int cadena) {
        
        String scadena = Integer.toString(cadena);
        return  scadena.length();
    }

}
