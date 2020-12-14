package com.example.newsclient.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.newsclient.R;
import com.example.newsclient.http.response.NewsBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsViewHolder> {
    private List<NewsBean> newsBeans;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setNewsBeans(List<NewsBean> newsBeans) {
        this.newsBeans = newsBeans;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
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
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onClick(position);
            }
        });

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

    public interface OnItemClickListener {
        void onClick(int position);
    }
}
