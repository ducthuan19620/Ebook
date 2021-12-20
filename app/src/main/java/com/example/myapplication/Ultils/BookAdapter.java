package com.example.myapplication.Ultils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Activity.DetailBookActivity;
import com.example.myapplication.Model.Book;
import com.example.myapplication.R;

import java.net.ProtocolFamily;
import java.util.ConcurrentModificationException;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>{

    private List<Book> mListBook;
    private Context mContext;

    public BookAdapter(Context context, List<Book> mListBook) {
        this.mContext = context;
        this.mListBook = mListBook;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {

        final Book book = mListBook.get(position);
        if (book == null){
            return;
        }

        holder.imgBook.setImageResource(book.getResourceID());
        holder.tvName.setText(book.getName());

        holder.layoutBookItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoToDetail(book);
            }
        });

    }

    private void onClickGoToDetail(Book book) {
        Intent intent = new Intent(mContext, DetailBookActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_book", book);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    public void release(){
        mContext = null;
    }

    @Override
    public int getItemCount() {

        if (mListBook != null){
            return mListBook.size();
        }

        return 0;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder{

        private RelativeLayout layoutBookItem;
        private TextView tvName;
        private ImageView imgBook;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);

            layoutBookItem = itemView.findViewById(R.id.layout_bookitem);
            tvName = itemView.findViewById(R.id.name_book);
            imgBook = itemView.findViewById(R.id.image_book);
        }
    }

}
