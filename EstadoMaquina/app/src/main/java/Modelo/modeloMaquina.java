package Modelo;

import com.parse.ParseObject;
import com.parse.ParseClassName;

@ParseClassName("modeloMaquina")
public class modeloMaquina extends ParseObject {
    public modeloMaquina(){
        setIdPartida("");
        setPulsa1(false);
        setPulsa2(false);
        setPulsa3(false);
        setPulsa4(false);
        setPuntuacion(0);
    }
    public int getPuntuacion() {
        return getInt("puntuacion");
    }

    public void setPuntuacion(int puntuacion) {
        put("puntuacion",puntuacion);
    }

    public boolean isPulsa1() {
        return getBoolean("pulsa1");
    }

    public void setPulsa1(boolean pulsa1) {
        put("pulsa1",pulsa1);
    }

    public boolean isPulsa2() {
        return getBoolean("pulsa2");
    }

    public void setPulsa2(boolean pulsa2) {
        put("pulsa2",pulsa2);
    }

    public boolean isPulsa3() {
        return getBoolean("pulsa3");
    }

    public void setPulsa3(boolean pulsa3) {
        put("pulsa3", pulsa3);
    }

    public boolean isPulsa4() {
        return getBoolean("pulsa4");
    }

    public void setPulsa4(boolean pulsa4) {
        put("pulsa4", pulsa4);
    }

    public String getIdPartida() {
        return getString("idPartida");
    }

    public void setIdPartida(String idPartida) {
        put("idPartida",idPartida);
    }
    @Override
    public String toString(){
        String aux = "Puntuacion: "+ getPuntuacion();
        aux += "\nidPartida: "+ getIdPartida();
        return aux;
    }
}
