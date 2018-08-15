package com.example.pokemoon.deneme2and;

import android.content.Context;
import android.speech.tts.TextToSpeech;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;



import java.util.ArrayList;

import java.util.List;
import java.util.Locale;

public class Adapterr extends RecyclerView.Adapter<Adapterr.ViewHolder> {

    private List<player> Listkisi = new ArrayList<>();
    private Context mContext;
    private TextToSpeech textspeech;
    Database database;

    public Adapterr(Context context,List<player> texts , Database database) {
        this.Listkisi = texts;
        this.mContext = context;
        this.database=database;
        textspeech = new TextToSpeech(mContext, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR)
                    textspeech.setLanguage(Locale.ENGLISH);
            }
        });


    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.box,parent,false);
      ViewHolder holder = new ViewHolder(view);
      return holder;


    }

    @Override
    public void onBindViewHolder(Adapterr.ViewHolder holder, final int position)
    {
        holder.textView.setText(Listkisi.get(position).getName());
        holder.button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                textspeech.speak(Listkisi.get(position).getName(),TextToSpeech.QUEUE_FLUSH,null);

            }



        });
        holder.sil.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                database.Kisisil(Listkisi.get(position).getId());
                Listkisi.remove(position);
                notifyDataSetChanged();


            }
        });



    }

    @Override
    public int getItemCount() {
        return Listkisi.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        Button button;
        Button sil;
        TextView textView;
        RelativeLayout relativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            button= itemView.findViewById(R.id.buttonRead);
            textView=itemView.findViewById(R.id.textView3);
            relativeLayout=itemView.findViewById(R.id.parent_layout);
            sil=itemView.findViewById(R.id.buttonsil);

        }
    }
}

