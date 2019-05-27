
package visual;
import ia.redes.neuronales.IARedesNeuronales;

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
}
