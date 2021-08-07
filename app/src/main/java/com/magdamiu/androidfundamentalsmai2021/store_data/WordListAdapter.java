package com.magdamiu.androidfundamentalsmai2021.store_data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.magdamiu.androidfundamentalsmai2021.R;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordViewHolder> {

   private final LayoutInflater layoutInflater;
   private List<Word> words; // Cached copy of words

   WordListAdapter(Context context) { layoutInflater = LayoutInflater.from(context); }

   @Override
   public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View itemView = layoutInflater.inflate(R.layout.recyclerview_item, parent, false);
       return new WordViewHolder(itemView);
   }

   @Override
   public void onBindViewHolder(WordViewHolder holder, int position) {
       if (words != null) {
           Word current = words.get(position);
           holder.getWordItemView().setText(current.getWord());
       } else {
           // Covers the case of data not being ready yet.
           holder.getWordItemView().setText("No Word");
       }
   }

   void setWords(List<Word> words){
       this.words = words;
       notifyDataSetChanged();
   }

   // getItemCount() is called many times, and when it is first called,
   // mWords has not been updated (means initially, it's null, and we can't return null).
   @Override
   public int getItemCount() {
       if (words != null)
           return words.size();
       else return 0;
   }
}