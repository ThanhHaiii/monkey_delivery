package com.example.delivery_monkey_be.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.delivery_monkey_be.R;

public class BaseFragment extends Fragment {

    private BaseFragmentActivity baseFragmentActivity;
    private View backWhite;
    private View backBlack;
    private TextView mTitleHeader;
    private ImageView mShoppingCartBlack;
    private ImageView mShoppingCartWhite;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    protected void initHeaderView(View rootView, int titleHeader) {
        View header = rootView.findViewById(R.id.header);
        mTitleHeader = header.findViewById(R.id.title_header);
        mShoppingCartBlack = header.findViewById(R.id.shopping_cart_black);
        mShoppingCartWhite = header.findViewById(R.id.shopping_cart_white);
        backBlack = header.findViewById(R.id.back_black);
        backWhite = header.findViewById(R.id.back_white);

        mTitleHeader.setText(titleHeader);
        setBackBlackAction(rootView);
    }

    protected void setBackBlackAction(View rootView) {
        backBlack.setOnClickListener(view -> baseFragmentActivity.onBackPressed());
    }

    protected void setBackWhiteAction(View rootView) {
        backWhite.setOnClickListener(view -> baseFragmentActivity.onBackPressed());
    }

    protected void setShoppingCartBlackAction(View rootView) {
        mShoppingCartBlack.setOnClickListener(view -> {

        });
    }

    protected void setShoppingCartWhiteAction(View rootView) {
        mShoppingCartWhite.setOnClickListener(view -> {

        });
    }
}
