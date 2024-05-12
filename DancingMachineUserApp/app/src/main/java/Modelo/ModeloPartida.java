package Modelo;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("ModeloPartida")
public class ModeloPartida extends ParseObject {
//    private String id;
//    private String cancion;
//    private String dificultad;
//    private float Latitud;
//    private float Longitud;
    public ModeloPartida(){
        setId("1");
        setCancion("cancionejemplo");
        setDificultad("Fácil");
        setLatitud(42);
        setLongitud(-1);
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

    public float getLatitud() {
        return (float) getNumber("latitud");
    }

    public void setLatitud(float latitud) {
        put("latitud",latitud);
    }

    public float getLongitud() {
        return (float) getNumber("longitud");
    }

    public void setLongitud(float longitud) {
        put("longitud",longitud);
    }
    @Override
    public String toString(){
        String aux = "Id partida: "+getId()+"\nDificultad: "+getDificultad()+"\nCancion:"+getCancion();
        aux += "\n\nLatitud: "+getLatitud()+"\nLongitud: "+getLongitud();
        return aux;
    }
}
