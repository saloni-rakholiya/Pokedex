package com.example.alien;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.alien.models.ListaPokemonAdapter;
import com.example.alien.models.Pokemon;
import com.example.alien.models.Pokemonreput;
import com.example.alien.pokeapi.PokeapiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity {
    private static final String TAG="POKEDEX";
    private Retrofit retrofit;
    private  int offset;
    private boolean apto;
    private RecyclerView recyclerView;
    private ListaPokemonAdapter listaPokemonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toast.makeText(this,"ALL YOU NEED TO KNOW",4000).show();
        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        listaPokemonAdapter=new ListaPokemonAdapter(this);
        recyclerView.setAdapter(listaPokemonAdapter);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(dy>0)
                {int visibleitemcount=layoutManager.getChildCount();
                 int totalitemcount=layoutManager.getItemCount();
                 int pastvisibleitems=layoutManager.findFirstVisibleItemPosition();

                 if(apto)
                 {
                     if((visibleitemcount+pastvisibleitems)>=totalitemcount){
                         Log.i(TAG,"FINALalalla");
                         apto=false;
                         offset=offset+20;
                         obtenerDatos(offset);
                     }
                 }

                }
            }
        });




        retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        offset=0;
        apto=true;
        obtenerDatos(offset);
    }
    private void obtenerDatos(int offset)
    {
        PokeapiService service=retrofit.create(PokeapiService.class);
        Call<Pokemonreput> pokemonreputcall= service.obtenerListPokemon(150,0);
        pokemonreputcall.enqueue(new Callback<Pokemonreput>() {
            @Override
            public void onResponse(Call<Pokemonreput> call, Response<Pokemonreput> response) {
                apto=true;
                if(response.isSuccessful())
                {
                    Pokemonreput Pokemonreput=response.body();
                    ArrayList<Pokemon> listapokemon =Pokemonreput.getResults();

                    listaPokemonAdapter.adicionarlistapokemon(listapokemon);

                }
                else
                 {
                    Log.e(TAG," onResponse: "+response.errorBody());
                 }
            }

            @Override
            public void onFailure(Call<Pokemonreput> call, Throwable t) {
                    Log.e(TAG," onFailure: "+t.getMessage());
                    apto=true;
            }
        });
    }

}
