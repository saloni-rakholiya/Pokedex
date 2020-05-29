package com.example.alien.models;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.alien.FINALLL;
import com.example.alien.R;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class ListaPokemonAdapter extends RecyclerView.Adapter<ListaPokemonAdapter.ViewHolder>{
    private ArrayList<Pokemon> dataset;
    private Context context;


    public ListaPokemonAdapter(Context context) {
        this.context=context;
        dataset=new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon,parent,false);




        return new ViewHolder(view);




    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    final Pokemon p=dataset.get(position);
    final String sno=String.valueOf(p.getNumber());
    //final String sname=p.getName();
        final String sname=p.getName();
        final String sabilities=p.getHeight();
    holder.notextview.setText(p.getName());
// Glide.with(context)
//                .load("https://github.com/PokeAPI/sprites/blob/master/sprites/pokemon/"+p.getNumber()+".png")
       // Glide.with(context)
         //       .load("http://pokeapi.co/media/sprites/pokemon/"+p.getNumber()+".png")
          Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+p.getNumber()+".png")
                  .centerCrop()
                  .crossFade()
                  .diskCacheStrategy(DiskCacheStrategy.ALL)
                  .into(holder.fotoImageView);

          //  Glide.with(context)
            //    .load("http://www.serebii.net/pokemongo/pokemon/00"+p.getNumber()+".png")
                holder.fotoImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(context,sabilities+" is clicked",4000).show();
                        Intent intent=new Intent(context, FINALLL.class);
                        intent.putExtra("name",sname);
                        intent.putExtra("number",sno);
                        context.startActivity(intent);


                    }
                });




    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarlistapokemon(ArrayList<Pokemon> listapokemon) {

        dataset.addAll(listapokemon);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView fotoImageView;
        private TextView notextview;
        public ViewHolder(View itemView)
           { super(itemView);
           fotoImageView=(ImageView) itemView.findViewById(R.id.fotoImageView);
           notextview=(TextView) itemView.findViewById(R.id.notextview);

           //here
               itemView.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                      // Toast.makeText(context,"CLICKED",4000).show();
                   }
               });
               //till


           }
    }

}
