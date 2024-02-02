package com.example.applisae;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;

import android.widget.Button;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import android.util.Log;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button buttonCaptures;
    private Button buttonFavoris;

    // TAG utilisé pour les logs, généralement défini comme le nom de la classe
    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCaptures = findViewById(R.id.Capture);
        buttonFavoris = findViewById(R.id.Favoris);

        // Obtient une instance de l'interface ApiService à partir de GetAPI
        ApiService apiService = GetAPI.getApiService();

        // Effectue la requête API pour obtenir une liste d'items
        Call<List<Item>> call = apiService.getData();
        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (response.isSuccessful()) {
                    // Traitement des données réussi
                    List<Item> data = response.body();
                    // Fais quelque chose avec les données récupérées
                    Log.d(TAG, "Data received: " + data.toString());
                } else {
                    // Traitement des erreurs (code d'erreur HTTP non 2xx)
                    Log.e(TAG, "Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                // Gestion des erreurs lors de la requête (connexion perdue, timeout, etc.)
                Log.e(TAG, "Error: " + t.getMessage());
            }
        });


        buttonCaptures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(com.example.applisae.MainActivity.this, MainActivity2.class);

                startActivity(i);
            }
        });

    }


    @Override
    public <T extends View> T findViewById(int id) {
        return super.findViewById(id);
    }
}

