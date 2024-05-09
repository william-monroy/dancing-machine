package dev.wimo.dancingmachineuserapp.Application;

import android.app.Application;

import java.util.ArrayList;

import dev.wimo.dancingmachineuserapp.Modelo.Maquina;
import dev.wimo.dancingmachineuserapp.Modelo.ModeloPartida;

public class applicationPartida extends Application {

    private ArrayList<ModeloPartida> historico;
    private ModeloPartida actual;

    public applicationPartida(){
        historico = new ArrayList<>();
        iniciarActual();
    }

    public void reiniciarHistorico(){historico.clear();
    }
    public void guardarActual(){
        historico.add(actual);
    }
    public void setId(String id) { actual.setId(id);}
    public void setCancion(String cancion) { actual.setCancion(cancion);}
    public void setDificultad(String dificultad) { actual.setDificultad(dificultad);}
    public void setLatitud(Float latitud){actual.setLatitud(latitud);}
    public void setLongitud(Float longitud){actual.setLongitud(longitud);}
    public void iniciarActual() { actual = new ModeloPartida();}
    public ArrayList<ModeloPartida> getHistorico() { return historico;}
    public void setActual(int i){actual=historico.get(i);}
    public void resetActual(){actual=new ModeloPartida();}
    public String imprimeActual(){
        String aux = "ID: "+actual.getId()+"\nCancion: "+actual.getCancion()+"\nDificultad: "+actual.getDificultad()+"\nLatitud: "+actual.getLatitud();
        aux += "\nLongitud: "+actual.getLongitud();
        return aux;
    }

    public String imprimeMaquina(){
        Maquina maquina = new Maquina();
        return maquina.toString();
    }


}
