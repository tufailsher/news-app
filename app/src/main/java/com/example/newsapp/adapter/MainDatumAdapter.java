package com.example.newsapp.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.R;
import com.example.newsapp.activity.MainActivity;
import com.example.newsapp.model.Datum;
import com.example.newsapp.utils.OnReclerViewItemClickListener;

import java.util.List;

public class MainDatumAdapter extends RecyclerView.Adapter<MainDatumAdapter.ViewHolder> {
    private List<Datum> DatumArrayList;
    private Context context;
    private OnReclerViewItemClickListener onRecyclerViewItemClickListener;

    public MainDatumAdapter(List<Datum> DatumArrayList) {
        this.DatumArrayList = DatumArrayList;
    }

    @Override
    public MainDatumAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_main_article_adapter, viewGroup, false);
        return new MainDatumAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainDatumAdapter.ViewHolder viewHolder, int position) {
        final Datum DatumModel = DatumArrayList.get(position);
        if (!TextUtils.isEmpty(DatumModel.getCjobTitle())) {
            viewHolder.titleText.setText(DatumModel.getCjobTitle());
        }
        if (!TextUtils.isEmpty(DatumModel.getClogo())) {
            viewHolder.descriptionText.setText(DatumModel.getClogo());
        }
        viewHolder.artilceAdapterParentLinear.setTag(DatumModel);
    }

    @Override
    public int getItemCount() {
        return DatumArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titleText;
        private TextView descriptionText;
        private LinearLayout artilceAdapterParentLinear;

        ViewHolder(View view)
        {

            super(view);
            titleText = view.findViewById(R.id.article_adapter_tv_title);
            descriptionText = view.findViewById(R.id.article_adapter_tv_description);
            artilceAdapterParentLinear = view.findViewById(R.id.article_adapter_ll_parent);
            artilceAdapterParentLinear.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    if (onRecyclerViewItemClickListener != null) {
                        onRecyclerViewItemClickListener.onItemClick(getAdapterPosition(), view);
                    }
                }
            });

        }
    }

    public void setOnRecyclerViewItemClickListener(MainActivity onRecyclerViewItemClickListener) {
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;

    }
}
