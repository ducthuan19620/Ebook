package com.example.myapplication.Activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Model.Book;
import com.example.myapplication.R;
import com.example.myapplication.Ultils.BookAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoryFragment extends Fragment {


    private RecyclerView rcvBook;
    private BookAdapter bookAdapter;
    
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;

    public HistoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HistoryFragment newInstance(String param1, String param2) {
        HistoryFragment fragment = new HistoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        rcvBook = view.findViewById(R.id.rcv_book);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rcvBook.setLayoutManager(linearLayoutManager);

        bookAdapter = new BookAdapter(getActivity(), getListBook());
        rcvBook.setAdapter(bookAdapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        rcvBook.addItemDecoration(itemDecoration);

        return view;
    }

    private List<Book> getListBook() {
        List<Book> list = new ArrayList<>();
        list.add(new Book("Tên sách 1", R.drawable.ic_book));
        list.add(new Book("Tên sách 2", R.drawable.ic_book));
        list.add(new Book("Tên sách 3", R.drawable.ic_book));
        list.add(new Book("Tên sách 4", R.drawable.ic_book));
        return list;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (bookAdapter != null){
            bookAdapter.release();
        }
    }
}