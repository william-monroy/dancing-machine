package Application;

import android.app.Application;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import Modelo.modeloMaquina;
import Modelo.ModeloPartida;
import Vistas.InfoMaquina;
import dev.wimo.dancingmachineuserapp.R;

public class applicationPartida extends Application {

    private List<ModeloPartida> historico;
    private ModeloPartida actual;
    private modeloMaquina maquinaActual;

    private InfoMaquina view;

    @Override
    public void onCreate(){
        super.onCreate();
        ParseObject.registerSubclass(ModeloPartida.class);
        ParseObject.registerSubclass(modeloMaquina.class);

        historico = new ArrayList<>();
        iniciarActual();

        this.maquinaActual = new modeloMaquina();

        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId(getString(R.string.back4app_app_id))
                .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                .build());
    }

    public void setId(String id) { actual.setId(id);}
    public void setCancion(String cancion) { actual.setCancion(cancion);}
    public void setDificultad(String dificultad) { actual.setDificultad(dificultad);}
    public void setLatitud(Float latitud){actual.setLatitud(latitud);}
    public void setLongitud(Float longitud){actual.setLongitud(longitud);}
    public void iniciarActual() { actual = new ModeloPartida();}
    public List<ModeloPartida> getHistorico() { return historico;}
    public void setActual(int i){actual=historico.get(i);}
    public ModeloPartida getActual() {return actual;}
    public void resetActual(){actual=new ModeloPartida();}
    public String imprimeActual(){
        String aux = "ID: "+actual.getId()+"\nCancion: "+actual.getCancion()+"\nDificultad: "+actual.getDificultad()+"\nLatitud: "+actual.getLatitud();
        aux += "\nLongitud: "+actual.getLongitud();
        return aux;
    }

    public void getServerPartidaUpdate(ListView listView){
        ParseQuery<ModeloPartida> query = ParseQuery.getQuery("ModeloPartida");
        query.findInBackground((objects,e)->{
            if(e == null){
                historico = objects;
                ArrayAdapter<ModeloPartida> adapter =
                        new ArrayAdapter<ModeloPartida>(listView.getContext(),R.layout.row_layout,
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
    public void addObjectUpdate(@NonNull ModeloPartida actual, ListView listView){
        actual.saveInBackground(e->{
            if(e == null){
                historico.add(actual);
                ArrayAdapter<ModeloPartida> adapter =
                        new ArrayAdapter<ModeloPartida>(listView.getContext(),R.layout.row_layout,
                                R.id.listText,historico);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

                Log.d("object saved server OK:", "addObjectUpdate()");
            } else {
                Log.d("fail save, reason: ", e.getMessage()+ "addObjectUpdate()");
            }
        });
    }
    public void updateObjectUpdate(@NonNull ModeloPartida actual, ListView listView){
        actual.saveInBackground(e -> {
            if (e == null) {
                ArrayAdapter<ModeloPartida> adapter;
                adapter = (ArrayAdapter<ModeloPartida>) listView.getAdapter();
                adapter.notifyDataSetChanged();

                Log.d("object updated srv OK:", "updateObjectUpdate()");
            } else {
                Log.d("fail update, reason: "+ e.getMessage(), "updateObjectUpdate()");
            }
        });
    }

    public void updateData(int puntuacion, boolean pulsa1, boolean pulsa2, boolean pulsa3, boolean pulsa4, String idPartida) {
        this.maquinaActual.setPuntuacion(puntuacion);
        this.maquinaActual.setPulsa1(pulsa1);
        this.maquinaActual.setPulsa2(pulsa2);
        this.maquinaActual.setPulsa3(pulsa3);
        this.maquinaActual.setPulsa4(pulsa4);
        this.maquinaActual.setIdPartida(idPartida);
    }

    public modeloMaquina getMaquina(String idPartida) {
        return new modeloMaquina(idPartida);
    }



}
