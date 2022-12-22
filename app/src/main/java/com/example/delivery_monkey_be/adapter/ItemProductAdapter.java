package com.example.delivery_monkey_be.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.delivery_monkey_be.R;
import com.example.delivery_monkey_be.entities.ItemProductEntity;

import java.util.List;
import java.util.Objects;

public class ItemProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<ItemProductEntity> mItemProductEntityList;

    public ItemProductAdapter(Context context, List<ItemProductEntity> itemProductEntityList) {
        this.mContext = context;
        this.mItemProductEntityList = itemProductEntityList;
    }

    public void setList(List<ItemProductEntity> itemProductEntities) {
        setData(itemProductEntities);
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new  MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_product, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemProductEntity bean = mItemProductEntityList.get(position);
        MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.textView.setText(bean.getTitle());
        myViewHolder.imageView.setImageResource(bean.getImage());

    }

    @Override
    public int getItemCount() {
        return mItemProductEntityList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_product_img);
            textView = itemView.findViewById(R.id.item_product_txt);
        }
    }

    private void setData(List<ItemProductEntity> newItemProductEntityList) {
        DiffUtil.DiffResult diffUtil = DiffUtil.calculateDiff(new DiffUtil.Callback() {
            @Override
            public int getOldListSize() {
                return mItemProductEntityList.size();
            }

            @Override
            public int getNewListSize() {
                return newItemProductEntityList.size();
            }

            @Override
            public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                return newItemProductEntityList.get(newItemPosition).getId() == mItemProductEntityList.get(oldItemPosition).getId();
            }

            @Override
            public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                return Objects.equals(newItemProductEntityList.get(newItemPosition).getTitle(), mItemProductEntityList.get(oldItemPosition).getTitle());
            }
        });
        diffUtil.dispatchUpdatesTo(this);
    }
}
