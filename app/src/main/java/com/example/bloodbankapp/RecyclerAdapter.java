//package com.example.bloodbankapp;
//
//import android.content.Context;
//
//import android.support.v7.widget.RecyclerView;
//import android.text.TextUtils;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.squareup.picasso.MemoryPolicy;
//import com.squareup.picasso.NetworkPolicy;
//import com.squareup.picasso.Picasso;
//
//public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
//
//    private List<Article> articleArrayList;
//
//    private Context context;
//
//    private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;
//
//    public RecyclerAdapter(List<Article> articleArrayList, Context context) {
//
//        this.articleArrayList = articleArrayList;
//        this.context = context;
//
//    }
//
//    @Override
//
//    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//
//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card, viewGroup, false);
//
//        return new RecyclerAdapter.ViewHolder(view);
//
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerAdapter.ViewHolder viewHolder, int position) {
//
//        final Article articleModel = articleArrayList.get(position);
//
//        if(!TextUtils.isEmpty(articleModel.getTitle())) {
//
//            viewHolder.titleText.setText(articleModel.getTitle());
//
//        }
//
//        if(!TextUtils.isEmpty(articleModel.getDescription())) {
//
//            viewHolder.descriptionText.setText(articleModel.getDescription());
//
//        }
//
//        if(articleModel.getUrlToImage() != null){
//
//            Picasso.get()
//                    .load(articleModel.getUrlToImage())
//                    .noFade()
//                    .placeholder(R.drawable.imagenotfoun)
//                    .error(R.drawable.imagenotfoun)
//                    //we want to see changes immediately when the imageview is changed
//                    .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
//                    .networkPolicy(NetworkPolicy.NO_CACHE)
//                    .into(viewHolder.imageView);
//        }
//        else {
//            viewHolder.imageView.setImageResource(R.drawable.imagenotfoun);
//        }
//
//        viewHolder.artilceAdapterParentLinear.setTag(articleModel);
//
//    }
//
//    @Override
//
//    public int getItemCount() {
//
//        return articleArrayList.size();
//
//    }
//
//    class ViewHolder extends RecyclerView.ViewHolder{
//
//        private TextView titleText;
//
//        private TextView descriptionText;
//
//        private ImageView imageView;
//
//        private LinearLayout artilceAdapterParentLinear;
//
//        ViewHolder(View view) {
//
//            super(view);
//
//            titleText = view.findViewById(R.id.article_adapter_tv_title);
//
//            descriptionText = view.findViewById(R.id.article_adapter_tv_description);
//
//            imageView = view.findViewById(R.id.imageview);
//
//            artilceAdapterParentLinear = view.findViewById(R.id.article_adapter_ll_parent);
//
//            artilceAdapterParentLinear.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//
//                public void onClick(View view) {
//
//                    if (onRecyclerViewItemClickListener != null) {
//
//                        onRecyclerViewItemClickListener.onItemClick(getAdapterPosition(), view);
//
//                    }
//
//                }
//
//            });
//
//        }
//
//    }
//
//    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
//
//        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
//
//    }
//}