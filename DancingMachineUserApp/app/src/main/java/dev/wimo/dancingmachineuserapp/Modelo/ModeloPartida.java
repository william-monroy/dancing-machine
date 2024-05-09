package dev.wimo.dancingmachineuserapp.Modelo;

public class ModeloPartida {
    private String id;
    private String cancion;
    private String dificultad;
    private float Latitud;
    private float Longitud;
    public ModeloPartida(){
        setId("nobihkjkpjhivhjnkjiohibhkj");
        setCancion("cancionejemplo");
        setDificultad("dificultadEjemplo");
        setLatitud(42);
        setLongitud(-1);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCancion() {
        return cancion;
    }

    public void setCancion(String cancion) {
        this.cancion = cancion;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public float getLatitud() {
        return Latitud;
    }

    public void setLatitud(float latitud) {
        Latitud = latitud;
    }

    public float getLongitud() {
        return Longitud;
    }

    public void setLongitud(float longitud) {
        Longitud = longitud;
    }
    @Override
    public String toString(){
        String aux = "Id partida: "+getId()+"\nDificultad: "+getDificultad()+"\nCancion:"+getCancion();
        aux += "\n\n\nLatitud: "+getLatitud()+"\nLongitud: "+getLongitud();
        return aux;
    }
}
