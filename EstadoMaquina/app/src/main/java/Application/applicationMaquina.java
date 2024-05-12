package Application;

import android.app.Application;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;

import com.example.estadomaquina.R;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import Modelo.Partida;
import Modelo.modeloMaquina;

public class applicationMaquina extends Application {
    private List<modeloMaquina> historico;
    private modeloMaquina actual;

    @Override
    public void onCreate(){

        super.onCreate();
        ParseObject.registerSubclass(modeloMaquina.class);

        historico = new ArrayList<>();
        iniciarActual();

        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId(getString(R.string.back4app_app_id))
                .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                .build());
    }



    public void reiniciarHistorico(){historico.clear();
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
    public List<modeloMaquina> getHistorico(){
        return historico;
    }

    public void setActual(Integer i){
        actual=historico.get(i);
    }
    public void resetActual(){
        actual = new modeloMaquina();
    }
    public modeloMaquina getActual(){return actual;}
    public String imprimeActual(){
        String aux = "Boton1: "+actual.isPulsa1()+"\nBoton2: "+actual.isPulsa2()+"\nBoton3: "+actual.isPulsa3()+"\nBoton4: "+actual.isPulsa4();
        aux += "\nPuntuacion: "+actual.getPuntuacion();
        aux += "\nidPartida: "+actual.getIdPartida();
        return aux;
    }
    public String imprimePartida(){
        //OBTENER PARTIDA, COMO NO SE LA GENERO AQUI PERO PILLARLA DEL BACKFORAPP
        Partida p = new Partida();
        return p.toString();
    }
    public void getServerMaquinaUpdate(ListView listView){
        ParseQuery<modeloMaquina> query = ParseQuery.getQuery("modeloMaquina");
        query.findInBackground((objects,e)->{
            if(e == null){
                historico = objects;
                ArrayAdapter<modeloMaquina> adapter =
                        new ArrayAdapter<modeloMaquina>(listView.getContext(),R.layout.row_layout,
                                R.id.listText,historico);
                listView.setAdapter((adapter));
                adapter.notifyDataSetChanged();
                Log.e("Query del server Ok","server point update");
            }
            else{
                Log.e("Error: "+e.getMessage(),"server point update");
            }

        });
    }
    public void addObjectUpdate(@NonNull modeloMaquina actual, ListView listView){
        actual.saveInBackground(e->{
        if(e == null){
            historico.add(actual);
            ArrayAdapter<modeloMaquina> adapter =
                    new ArrayAdapter<modeloMaquina>(listView.getContext(),R.layout.row_layout,
                            R.id.listText,historico);
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();

            Log.d("object saved server OK:", "addObjectUpdate()");
        } else {
            Log.d("fail save, reason: ", e.getMessage()+ "addObjectUpdate()");
        }
        });
    }
    public void updateObjectUpdate(@NonNull modeloMaquina actual, ListView listView){
        actual.saveInBackground(e -> {
            if (e == null) {
                ArrayAdapter<modeloMaquina> adapter;
                adapter = (ArrayAdapter<modeloMaquina>) listView.getAdapter();
                adapter.notifyDataSetChanged();

                Log.d("object updated srv OK:", "updateObjectUpdate()");
            } else {
                Log.d("fail update, reason: "+ e.getMessage(), "updateObjectUpdate()");
            }
        });

    }


}
