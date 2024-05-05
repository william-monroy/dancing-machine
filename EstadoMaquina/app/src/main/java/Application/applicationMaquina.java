package Application;

import android.app.Application;

import java.util.ArrayList;

import Modelo.modeloMaquina;

public class applicationMaquina extends Application {
    private ArrayList<modeloMaquina> historico;
    private modeloMaquina actual;
    public applicationMaquina(){
        historico = new ArrayList<>();
        iniciarActual();
    }
    public void reiniciarHistorico(){historico.clear();
    }
    public void guardarActual(){
        historico.add(actual);
    }
    public void setPuntuacion(int puntuacion){
        actual.setPuntuacion(puntuacion);
    }
    public void asociarPartida(String id){
        actual.setIdPartida(id);
    }
    public void pulsar1(){
        actual.setPulsa1(true);
    }
    public void pulsar2(){
        actual.setPulsa2(true);
    }
    public void pulsar3(){
        actual.setPulsa3(true);
    }
    public void pulsar4(){
        actual.setPulsa4(true);
    }
    public void iniciarActual(){ actual = new modeloMaquina();}
    public ArrayList<modeloMaquina> getHistorico(){
        return historico;
    }

    public void setActual(Integer i){
        actual=historico.get(i);
    }
    public void resetActual(){
        actual = new modeloMaquina();
    }
    public String imprimeActual(){
        String aux = "Boton1: "+actual.isPulsa1()+"\nBoton2: "+actual.isPulsa2()+"\nBoton3: "+actual.isPulsa3()+"\nBoton4: "+actual.isPulsa4();
        aux += "\nPuntuacion: "+actual.getPuntuacion();
        aux += "\nidPartida: "+actual.getIdPartida();
        return aux;
    }


}
