package Modelo;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("ModeloPartida")
public class ModeloPartida extends ParseObject {
    public ModeloPartida(){
    }

    public String getId() {
        return getString("Id");
    }

    public void setId(String id) {
        put("Id",id);
    }

    public String getCancion() {
        return getString("cancion");
    }

    public void setCancion(String cancion) {
        put("cancion",cancion);
    }

    public String getDificultad() {
        return getString("dificultad");
    }

    public void setDificultad(String dificultad) {
        put("dificultad",dificultad);
    }

    public Number getLatitud() {
        return  getNumber("latitud");
    }

    public void setLatitud(Number latitud) {
        put("latitud",latitud);
    }

    public Number getLongitud() {
        return getNumber("longitud");
    }

    public void setLongitud(Number longitud) {
        put("longitud",longitud);
    }
    @Override
    public String toString(){
        String aux = "Id partida: "+getId()+"\nDificultad: "+getDificultad()+"\nCancion:"+getCancion();
        aux += "\n\nLatitud: "+getLatitud()+"\nLongitud: "+getLongitud();
        return aux;
    }
}
