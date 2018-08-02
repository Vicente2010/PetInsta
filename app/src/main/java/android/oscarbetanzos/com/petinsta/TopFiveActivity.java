package android.oscarbetanzos.com.petinsta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class TopFiveActivity extends AppCompatActivity {

    ArrayList<Mascota> topFiveMascotas;
    String[] topNombres;
    String[] topRates;
    int[] topFoto;
    RecyclerView listaTopFive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_five);

        if (getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        listaTopFive = (RecyclerView) findViewById(R.id.rvTopFive);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaTopFive.setLayoutManager(llm);

        Bundle parametros = getIntent().getExtras();
        if (parametros != null) {
            topNombres = parametros.getStringArray("TopNombres");
            topRates = parametros.getStringArray("TopRates");
            topFoto = parametros.getIntArray("TopFoto");
        }


        crearTopFive();

        inicializarAdaptador();

    }

    public void crearTopFive(){

        topFiveMascotas = new ArrayList<Mascota>();

        for (int i=0;i<5;i++){
            //Log.v("Caso",topNombres[i]+" "+topRates[i]);

            topFiveMascotas.add(new Mascota(
                    topFoto[i],
                    topNombres[i],
                    topRates[i]));

        }
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(topFiveMascotas);
        listaTopFive.setAdapter(adaptador);
    }
}
