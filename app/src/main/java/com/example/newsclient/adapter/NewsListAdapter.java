package com.example.newsclient.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.newsclient.R;
import com.example.newsclient.bean.NewsBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsViewHolder> {
    private List<NewsBean> newsBeans;
    private Context context;
    public void setNewsBeans(List<NewsBean> newsBeans) {
        this.newsBeans = newsBeans;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_news, parent, false);
        return new NewsViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        NewsBean newsBean = newsBeans.get(position);
        holder.tvTitle.setText(newsBean.getTitle());
        holder.tvTime.setText(newsBean.getCtime());
        holder.tvHomeDesc.setText(newsBean.getDescription());
        Glide.with(context).load(newsBean.getPicUrl()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return newsBeans == null ? 0 : newsBeans.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTime;
        private TextView tvHomeDesc;
        private TextView tvTitle;
        private ImageView imageView;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTime = itemView.findViewById(R.id.tv_home_time);
            tvHomeDesc = itemView.findViewById(R.id.tv_home_desc);
            tvTitle = itemView.findViewById(R.id.tv_home_name);
            imageView = itemView.findViewById(R.id.iv_home_item);
        }
    }
}
