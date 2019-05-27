
package ia.redes.neuronales;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IARedesNeuronales {    
    
    public static void main(String[] args) {
        //entrenamiento
            //perfiles
            List<int[]> lista= new ArrayList();
            int perfilAR[]  = { 1, 1, 1, 1, 1, 1,-1,-1,-1, 1, 1, 1,-1, 1, 1, 1,-1,-1, 1};
            int perfilRR[]  = { 1,-1,-1, 1, 1,-1,-1,-1, 1,-1, 1,-1,-1,-1, 1,-1, 1, 1,-1};
            int perfilNR[]  = {-1,-1,-1,-1,-1,-1, 1, 1, 1, 1,-1, 1, 1,-1,-1,-1,-1,-1,-1};
            int ortogonal = 0;
            for(int i=0;i<19;i++){
                ortogonal = perfilAR[i]*perfilRR[i]+ortogonal;
            }
            if(ortogonal<0){
                 System.out.println("más de 50% de diferencia entre vectores AR y RR");System.out.println("");
            }else{
                 System.out.println("menos de 50% de diferencia entre vectores AR y RR");System.out.println("");
            }
            ortogonal = 0;
            for(int i=0;i<19;i++){
                ortogonal = perfilAR[i]*perfilNR[i]+ortogonal;
            }
            if(ortogonal<0){
                 System.out.println("más de 50% de diferencia entre vectores AR y NR");System.out.println("");
            }else{
                 System.out.println("menos de 50% de diferencia entre vectores AR y NR");System.out.println("");
            }
            ortogonal = 0;
            for(int i=0;i<19;i++){
                ortogonal = perfilNR[i]*perfilRR[i]+ortogonal;
            }
            if(ortogonal<0){
                 System.out.println("más de 50% de diferencia entre vectores NR y RR");System.out.println("");
            }else{
                 System.out.println("menos de 50% de diferencia entre vectores NR y RR");System.out.println("");
            }
            //aprendizaje
            int matrizPerfiles[][] = new int[19][19];
            for(int i = 0;i<19;i++){
               for(int j = 0;j<19;j++){
                   if (i==j){
                       matrizPerfiles[i][j] = 0;
                   }
                   if(i<j){
                        matrizPerfiles[i][j] = perfilAR[i]*perfilAR[j]+
                                                perfilRR[i]*perfilRR[j]+
                                                perfilNR[i]*perfilNR[j];
                        matrizPerfiles[j][i] = matrizPerfiles[i][j];
                   }
                   System.out.print(matrizPerfiles[i][j]+"\t");
               }
                System.out.println("");System.out.println("");
            }
           
            //vector de entrada
            int acumulador;
            int iteracion = 0;
//            int entradaPerfil[]  = { 1, 1, 1, 1, 1, 1,-1,-1,-1, 1, 1, 1,-1, 1, 1, 1,-1,-1, 1};
//            int entradaPerfil[]  = { 1,-1,-1, 1, 1,-1,-1,-1, 1,-1, 1,-1,-1,-1, 1,-1, 1, 1,-1};
//            int entradaPerfil[]  = {-1,-1,-1,-1,-1,-1, 1, 1, 1, 1,-1, 1, 1,-1,-1,-1,-1,-1,-1};                     
              int entradaPerfil[]  = {-1, 1,-1, 1,-1, 1,-1,-1,-1, 1,-1, 1, 1,-1,-1,-1,-1,-1,-1};
            ortogonal = 0;
            for(int i=0;i<19;i++){
                ortogonal = entradaPerfil[i]*perfilRR[i]+ortogonal;
            }
            if(ortogonal<0){
                 System.out.println("más de 50% de diferencia entre vectores perfilEntrada y RR");System.out.println("");
            }else{
                 System.out.println("menos de 50% de diferencia entre vectores perfilEntrada y RR");System.out.println("");
            }
            ortogonal = 0;
            for(int i=0;i<19;i++){
                ortogonal = perfilAR[i]*entradaPerfil[i]+ortogonal;
            }
            if(ortogonal<0){
                 System.out.println("más de 50% de diferencia entre vectores AR y perfilEntrada");System.out.println("");
            }else{
                 System.out.println("menos de 50% de diferencia entre vectores AR y perfilEntrada");System.out.println("");
            }
            ortogonal = 0;
            for(int i=0;i<19;i++){
                ortogonal = entradaPerfil[i]*perfilNR[i]+ortogonal;
            }
            if(ortogonal<0){
                 System.out.println("más de 50% de diferencia entre vectores perfilEntrada y NR");System.out.println("");
            }else{
                 System.out.println("menos de 50% de diferencia entre vectores perfilEntrada y NR");System.out.println("");
            }
            
            System.out.println("vector de entrada ");
            System.out.println("");System.out.println("");
            for(int i=0;i<19;i++){
                System.out.print(entradaPerfil[i]+"\t");
            }
            System.out.println("");System.out.println("");
            
            lista.add(entradaPerfil);
            boolean bandera = false;
            boolean reconocio = false;
            while(bandera==false){
                
                int auxEntradaPerfil [] = new int[19];           
                iteracion = iteracion +1;
                System.out.println("-------vector-iteracion-----------  "+iteracion);
                for(int i = 0;i<19;i++){
                    acumulador = 0;
                    for(int j = 0;j<19;j++){
                        acumulador = acumulador + entradaPerfil[j]*matrizPerfiles[i][j];
                    }
                    if(acumulador >= 0){
                        auxEntradaPerfil [i] = 1;   
                    }
                    if(acumulador < 0){
                        auxEntradaPerfil [i] = -1;   
                    }
                    //mas que nada para verlo
//                    if(acumulador == 0){
//                        auxEntradaPerfil [i] = entradaPerfil [i];   
//                    }
                    System.out.print(auxEntradaPerfil[i]+"\t");
                }
                System.out.println("");System.out.println("");
                
                
            
                for(int i = 0;i < lista.size();i++){
                    if(Arrays.equals(lista.get(i),auxEntradaPerfil)==true){
                        bandera = true;
                        System.out.println("encontro vector igual a alguno de la lista indice "+i);System.out.println("");
                    }
                }   
                if(bandera==true){    
                    if(Arrays.equals(entradaPerfil,perfilAR)==true){
                        System.out.println("perfil aux igual a perfil AR ");
                        reconocio=true;
                    }    
                    if(Arrays.equals(entradaPerfil,perfilRR)==true){
                        System.out.println("perfil aux igual a perfil RR  ");
                        reconocio=true;
                    }
                    if(Arrays.equals(entradaPerfil,perfilNR)==true){
                        System.out.println("perfil aux igual a perfil NR ");
                        reconocio=true;
                    }    
                }else{
                    lista.add(auxEntradaPerfil);
                    System.out.println("entro a reemplazar vector ");
                    System.out.println("");
                    for(int i=0;i<19;i++){
                        entradaPerfil[i] = auxEntradaPerfil[i];
                    }
                    
                }
            }    
            if(reconocio==false){
                System.out.println("no se pudo asociar a un perfil ");
            }
    }
    
}
