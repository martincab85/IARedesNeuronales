/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;
import ia.redes.neuronales.IARedesNeuronales;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pablo
 */
public class ControladoraVisual {
    
    IARedesNeuronales miLogica = new IARedesNeuronales();
    
    public void obtenerPerfil(int[] perfilEvaluado){
       miLogica.obtenerPerfil(perfilEvaluado);
    }
    
    public String[] obtenerNombreCaracteristicas(){
        return miLogica.obtenerNombreCaracteristicas();
    }
    
    public void enviarPerfiles(int[] perfilAR,int[] perfilRR, int[] perfilNR){
        miLogica.recibirPerfiles(perfilAR, perfilRR, perfilNR);
    }
    
    public void obtenerValoresIniciales(DefaultTableModel modeloTabla){
        miLogica.obtenerValoresIniciales(modeloTabla);
    }

    void limpiarLista() {
        miLogica.limpiarLista();
    }
}
