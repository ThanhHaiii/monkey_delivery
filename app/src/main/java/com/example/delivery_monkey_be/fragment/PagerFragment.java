package com.example.delivery_monkey_be.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.delivery_monkey_be.R;

public class PagerFragment extends Fragment {
    private int position;
    private int imgPage;
    private String description;
    private String titlePager;
    private FragmentActivity fragmentActivity;

    private TextView mDescription;
    private TextView mTitlePager;
    private ImageView mImageview;

    public static PagerFragment newInstance(FragmentActivity context, String titlePager,
                                            String description, int imgPage, int position) {
        PagerFragment fragment = new PagerFragment();
        fragment.fragmentActivity = context;
        fragment.titlePager = titlePager;
        fragment.description = description;
        fragment.imgPage = imgPage;
        fragment.position = position;

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_page_tutorial, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mDescription = view.findViewById(R.id.description_tutorial);
        mTitlePager = view.findViewById(R.id.title_text);
        mImageview = view.findViewById(R.id.tutorial_img);

        initData();
    }

    public void initData() {
        mDescription.setText(description);
        mTitlePager.setText(titlePager);
        mImageview.setImageResource(imgPage);
    }
}
