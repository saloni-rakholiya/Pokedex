package com.example.alien.pokeapi;

import com.example.alien.models.Pokemonreput;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokeapiService {


    @GET("pokemon")
    Call<Pokemonreput> obtenerListPokemon(@Query("limit") int limit,@Query("offset") int offset);
}
