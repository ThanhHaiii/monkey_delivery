package com.example.delivery_monkey_be.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.delivery_monkey_be.R;
import com.example.delivery_monkey_be.adapter.ItemProductAdapter;
import com.example.delivery_monkey_be.entities.ItemProductEntity;

import java.util.ArrayList;
import java.util.List;

public class ItemProductFragment extends BaseFragment {

    private ItemProductAdapter itemProductAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView mItemProductRV;
    private Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_product, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mItemProductRV = view.findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager itemProductLL = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mItemProductRV.setLayoutManager(itemProductLL);
        itemProductAdapter = new ItemProductAdapter(context, getListItemProduct());
        mRecyclerView.setAdapter(itemProductAdapter);
        mItemProductRV.setAdapter(itemProductAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private List<ItemProductEntity> getListItemProduct() {
        List<ItemProductEntity> itemProductEntityList = new ArrayList<>();
        itemProductEntityList.add(new ItemProductEntity(1, "Pizza", R.drawable.pizza_col_img));
        itemProductEntityList.add(new ItemProductEntity(2, "Pizza Cool", R.drawable.pizza_col_img));
        itemProductEntityList.add(new ItemProductEntity(3, "Chocolate", R.drawable.coffee_img));
        itemProductEntityList.add(new ItemProductEntity(4, "Noodle", R.drawable.pizza_col_img));
        itemProductEntityList.add(new ItemProductEntity(5, "Coffe", R.drawable.coffee_img));

        return itemProductEntityList;
    }
}
