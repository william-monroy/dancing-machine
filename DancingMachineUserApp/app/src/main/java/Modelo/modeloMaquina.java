package Modelo;

import android.util.Log;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;


@ParseClassName("modeloMaquina")
public class modeloMaquina extends ParseObject {

    private int puntuacion;
    private boolean pulsa1;
    private boolean pulsa2;
    private boolean pulsa3;
    private boolean pulsa4;
    private String idPartida;
    public modeloMaquina(){}

    public modeloMaquina(String idPartida){
        this.idPartida = idPartida;
        Log.d("INICIALIZACION MAQUINA",idPartida);
        ParseQuery<ParseObject> query = ParseQuery.getQuery("modeloMaquina");
        query.whereEqualTo("idPartida", idPartida);
        query.orderByDescending("createdAt");  // Asume que quieres el más reciente basado en cuándo fue creado
        query.setLimit(1);  // Solo queremos el registro más reciente
        query.findInBackground((objects, e) -> {
            Log.d("MAQUINA","Inicializacion estado maquina");
            if (e == null) {
                if (!objects.isEmpty()) {
                    ParseObject mostRecent = objects.get(0);
                    int puntuacion = mostRecent.getInt("puntuacion");
                    boolean pulsa1 = mostRecent.getBoolean("pulsa1");
                    boolean pulsa2 = mostRecent.getBoolean("pulsa2");
                    boolean pulsa3 = mostRecent.getBoolean("pulsa3");
                    boolean pulsa4 = mostRecent.getBoolean("pulsa4");
                    // Actualizamos los valores de Maquina
                    this.pulsa1 = pulsa1;
                    this.pulsa2 = pulsa2;
                    this.pulsa3 = pulsa3;
                    this.pulsa4 = pulsa4;
                    this.puntuacion = puntuacion;

                    Log.d("App", "Puntuación: " + puntuacion);
                } else {
                    Log.d("App", "No se encontraron registros.");
                }
            } else {
                Log.e("App", "Error al buscar registros: " + e.getLocalizedMessage());
            }
        });

    }
    public boolean getPulsa1() {return this.pulsa1;}
    public boolean getPulsa2() {return this.pulsa2;}
    public boolean getPulsa3() {return this.pulsa3;}
    public boolean getPulsa4() {return this.pulsa4;}

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setPulsa1(boolean pulsa1) {
        this.pulsa1 = pulsa1;
    }

    public void setPulsa2(boolean pulsa2) {
        this.pulsa2 = pulsa2;
    }

    public void setPulsa3(boolean pulsa3) {
        this.pulsa3 = pulsa3;
    }

    public void setPulsa4(boolean pulsa4) {
        this.pulsa4 = pulsa4;
    }

    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
    }
    public int getPuntuacion() {
        return this.puntuacion;
    }
    public String getIdPartida() {
        return this.idPartida;
    }

}
