
package ia.redes.neuronales;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class IARedesNeuronales {    
    List<int[]> lista= new ArrayList();
    int entradaPerfil[] = new int[19];
    int perfilAR[] = new int[19];
    int perfilRR[] = new int[19];
    int perfilNR[] = new int[19];
    int matrizPerfiles[][] = new int[19][19];      
    
    
    public void obtenerPerfil(int[] entradaPerfil){
        //vector de entrada
        this.entradaPerfil = entradaPerfil;
        IARedesNeuronales objetoClase = new IARedesNeuronales();
        System.out.println("vector de entrada");
            System.out.println("");System.out.println("");
            for(int i=0;i<19;i++){
                System.out.print(entradaPerfil[i]+"\t");
            }
            System.out.println("");System.out.println("");
            
            System.out.println("perfilAR con entradaPerfil");System.out.println("");
            objetoClase.ortogonal(perfilAR, entradaPerfil);
            System.out.println("perfilRR con entradaPerfil");System.out.println("");
            objetoClase.ortogonal(perfilRR, entradaPerfil);
            System.out.println("perfilNR con entradaPerfil");System.out.println("");
            objetoClase.ortogonal(entradaPerfil, perfilNR);
            
            int acumulador;
            int iteracion = 0;
//            lista.add(entradaPerfil);
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

    public void recibirPerfiles(int[] perfilAR, int[] perfilRR, int[] perfilNR) {
        
        IARedesNeuronales objetoClase = new IARedesNeuronales();  
        this.perfilAR = perfilAR;
        this.perfilRR = perfilRR;
        this.perfilNR = perfilNR;
        System.out.println("perfilAR con perfilRR");System.out.println("");
        objetoClase.ortogonal(perfilAR, perfilRR);
        System.out.println("perfilAR con perfilNR");System.out.println("");
        objetoClase.ortogonal(perfilAR, perfilNR);
        System.out.println("perfilRR con perfilNR");System.out.println("");
        objetoClase.ortogonal(perfilRR, perfilNR);
        
        //aprendizaje 
        for(int i = 0;i<19;i++){
           for(int j = 0;j<19;j++){
               if (i==j){
                   matrizPerfiles[i][j] = 0;//diagonal siempre es cero
               }
               if(i<j){
                    matrizPerfiles[i][j] = perfilAR[i]*perfilAR[j]+
                                            perfilRR[i]*perfilRR[j]+
                                            perfilNR[i]*perfilNR[j];
                    matrizPerfiles[j][i] = matrizPerfiles[i][j];//espejo
               }
               System.out.print(matrizPerfiles[i][j]+"\t");
           }
            System.out.println("");System.out.println("");
        }
    }
    public void ortogonal(int vector1[], int vector2[]){
        int ortogonal = 0;    
        for(int i=0;i<19;i++){
                ortogonal = vector1[i]*vector2[i]+ortogonal;
            }
            if(ortogonal<0){
                System.out.println("porcentaje de datos iguales %"+(((19+ortogonal)/2)*100)/19);System.out.println("");
            }else{
                System.out.println("porcentaje de datos iguales %"+(((19+ortogonal)/2)*100)/19);System.out.println("");
        }
    }
    
    public String[] obtenerNombreCaracteristicas() {
        String[] caracteristicas = new String[19];
        caracteristicas[0] = "Matemática";
        caracteristicas[1] = "Química";
        caracteristicas[2] = "Física";
        caracteristicas[3] = "Programación";
        caracteristicas[4] = "Electrónica";
        caracteristicas[5] = "Simulación";
        caracteristicas[6] = "Historia";
        caracteristicas[7] = "Ciencias Sociales";
        caracteristicas[8] = "Biología";
        caracteristicas[9] = "Literatura";
        caracteristicas[10] = "Métodos Numéricos";
        caracteristicas[11] = "Inglés";
        caracteristicas[12] = "Buena comunicación";
        caracteristicas[13] = "Buena dicción";
        caracteristicas[14] = "Claridad de conceptos";
        caracteristicas[15] = "Buena Sintaxis";
        caracteristicas[16] = "Buena Caligrafía";
        caracteristicas[17] = "Prolijidad";
        caracteristicas[18] = "Alto porcentaje de Rtas.";
        
        return caracteristicas;
    }
      public void obtenerValoresIniciales(DefaultTableModel modeloTabla){

        
        String entradaPerfilAR[]  = {"1", "1", "1", "1", "1", "1","-1","-1","-1", "1", "1", "1","-1", "1", "1", "1","-1","-1", "1"};
        String entradaPerfilRR[]  = { "1","-1","-1", "1", "1","-1","-1","-1", "1","-1", "1","-1","-1","-1", "1","-1", "1","1","-1"};
        String entradaPerfilNR[]  = {"-1","-1","-1","-1","-1","-1","1", "1", "1", "1","-1", "1", "1","-1","-1","-1","-1","-1","-1"};  

        
        for (int i = 0; i < 19; i++) {
            
                modeloTabla.setValueAt(entradaPerfilAR[i], i, 1);
                modeloTabla.setValueAt(entradaPerfilRR[i], i, 2);
                modeloTabla.setValueAt(entradaPerfilNR[i], i, 3);
            }

             
    }

    public void limpiarLista() {
        lista.clear();
    }
}
