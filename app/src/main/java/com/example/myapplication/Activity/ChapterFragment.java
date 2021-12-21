package com.example.myapplication.Activity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Model.Chapter;
import com.example.myapplication.R;
import com.example.myapplication.Ultils.ChapterAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChapterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChapterFragment extends Fragment implements ChapterAdapter.ItemClickListener{

    private RecyclerView rcvChapter;
    private ChapterAdapter chapterAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;

    public ChapterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment ChapterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChapterFragment newInstance(String param1) {
        ChapterFragment fragment = new ChapterFragment();
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
        View view =  inflater.inflate(R.layout.fragment_chapter, container, false);

        rcvChapter = view.findViewById(R.id.rcv_chapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rcvChapter.setLayoutManager(linearLayoutManager);

        chapterAdapter = new ChapterAdapter(getListChapter(), this);
        rcvChapter.setAdapter(chapterAdapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        rcvChapter.addItemDecoration(itemDecoration);


        return view;
    }

    private List<Chapter> getListChapter() {
        List<Chapter> list = new  ArrayList<>();
        list.add(new Chapter("Chương 1"));
        list.add(new Chapter("Chương 2"));
        list.add(new Chapter("Chương 3"));
        list.add(new Chapter("Chương 4"));
        list.add(new Chapter("Chương 5"));
        return list;
    }

    @Override
    public void onItemClick(Chapter chapter) {
        Fragment fragment = BookContentFragment.newInstance(chapter.getName());

        int currentOrientation = getResources().getConfiguration().orientation;
        if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            //transaction.hide(getActivity().getSupportFragmentManager().findFragmentByTag("chapter_fragment"));
            transaction.replace(R.id.book_content, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            //transaction.hide(getActivity().getSupportFragmentManager().findFragmentByTag("chapter_fragment"));
            transaction.replace(R.id.bookDetail_layout, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }

        /*   FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            //transaction.hide(getActivity().getSupportFragmentManager().findFragmentByTag("chapter_fragment"));
            transaction.replace(R.id.bookDetail_layout, fragment);
            transaction.addToBackStack(null);
            transaction.commit();*/

    }

}