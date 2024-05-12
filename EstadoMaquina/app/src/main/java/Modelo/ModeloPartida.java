package Modelo;

import com.parse.ParseObject;
import com.parse.ParseClassName;

@ParseClassName("ModeloPartida")
public class ModeloPartida extends ParseObject{
    public ModeloPartida(){
    }

    public String getId() {
        return getString("Id");
    }

    public void setId(String id) {
        put("id", id);
    }

    public String getCancion() {
        return getString("cancion");
    }

    public void setCancion(String cancion) {
        put("cancion", cancion);
    }

    public String getDificultad() {
        return getString("dificultad");
    }

    public void setDificultad(String dificultad) {
        put("dificultad", dificultad);
    }

    public float getLatitud() {
        return (float)getNumber("Latitud");
    }
    public void setLatitud(float latitud) {
        put("Latitud",latitud);
    }

    public float getLongitud() {
        return (float) getNumber("Longitud");
    }

    public void setLongitud(float longitud) {
        put("Longitud" , longitud);
    }
    @Override
    public String toString(){
        String aux = "Id partida: "+getId()+"\nDificultad: "+getDificultad()+"\nCancion:"+getCancion();
        //aux += "\n\n\nLatitud: "+getLatitud()+"\nLongitud: "+getLongitud();
        return aux;
    }
}
