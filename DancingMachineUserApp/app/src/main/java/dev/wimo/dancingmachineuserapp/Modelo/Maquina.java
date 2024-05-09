package dev.wimo.dancingmachineuserapp.Modelo;

public class Maquina {

    private int puntuacion;
    private boolean pulsa1;
    private boolean pulsa2;
    private boolean pulsa3;
    private boolean pulsa4;
    private String idPartida;
    public Maquina(){
        setIdPartida("");
        setPulsa1(false);
        setPulsa2(false);
        setPulsa3(false);
        setPulsa4(false);
        setPuntuacion(0);
    }
    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public boolean isPulsa1() {
        return pulsa1;
    }

    public void setPulsa1(boolean pulsa1) {
        this.pulsa1 = pulsa1;
    }

    public boolean isPulsa2() {
        return pulsa2;
    }

    public void setPulsa2(boolean pulsa2) {
        this.pulsa2 = pulsa2;
    }

    public boolean isPulsa3() {
        return pulsa3;
    }

    public void setPulsa3(boolean pulsa3) {
        this.pulsa3 = pulsa3;
    }

    public boolean isPulsa4() {
        return pulsa4;
    }

    public void setPulsa4(boolean pulsa4) {
        this.pulsa4 = pulsa4;
    }

    public String getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
    }
    @Override
    public String toString(){
        String aux = "Boton1: "+pulsa1+"\nBoton2: "+pulsa2+"\nBoton3: "+pulsa3+"\nBoton4: "+pulsa4;
        aux += "Puntuacion: "+ puntuacion;
        aux += "\nidPartida: "+ idPartida;
        return aux;
    }
}
