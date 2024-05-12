package Modelo;

public class Maquina {

    private int puntuacion;
    private boolean pulsa1;
    private boolean pulsa2;
    private boolean pulsa3;
    private boolean pulsa4;
    private String idPartida;
    public Maquina(){}

    public Maquina(String idPartida){
        this.idPartida = idPartida;
        // TODO: Traer informacion de base de datos
    }
    public boolean getPulsa1() {return pulsa1;}
    public boolean getPulsa2() {return pulsa2;}
    public boolean getPulsa3() {return pulsa3;}
    public boolean getPulsa4() {return pulsa4;}
    public int getPuntuacion() {
        return puntuacion;
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
