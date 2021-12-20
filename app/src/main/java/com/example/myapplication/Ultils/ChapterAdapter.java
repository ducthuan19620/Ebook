package com.example.myapplication.Ultils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.Chapter;
import com.example.myapplication.R;

import java.util.List;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ChapterViewHolder>{

    private List<Chapter> mListChapter;
    private ItemClickListener clickListener;

    public ChapterAdapter(List<Chapter> mListChapter, ItemClickListener clickListener) {
        this.mListChapter = mListChapter;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ChapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_profilelayout, parent, false);
        return new ChapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterViewHolder holder, int position) {

        final Chapter chapter = mListChapter.get(position);
        if (chapter == null){
            return;
        }

        holder.ctName.setText(chapter.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onItemClick(mListChapter.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {

        if (mListChapter != null){
            return mListChapter.size();
        }
        return 0;
    }

    public class ChapterViewHolder extends RecyclerView.ViewHolder{

        private TextView ctName;


        public ChapterViewHolder(@NonNull View itemView) {
            super(itemView);

            ctName = itemView.findViewById(R.id.choose_prof);
        }
    }

    public  interface ItemClickListener{
        public void onItemClick(Chapter chapter);
    }

}
