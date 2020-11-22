package com.example.konkor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.konkor.R;
import com.example.konkor.models.Comment;

import java.util.List;

public class RVCommentListAdapter extends RecyclerView.Adapter<RVCommentListAdapter.ViewHolder> {
    private List<Comment> comments;
    private Context mContext;

    public RVCommentListAdapter(Context context, List<Comment> comments) {
        this.mContext = context;
        this.comments = comments;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.rv_comments_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtComment.setText(comments.get(position).getComment());
        //TODO: get user name from database
        holder.txtUserName.setText("mnagafi23");
        holder.imgLikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.imgLikeButton.getDrawable() == mContext.getResources().getDrawable(R.drawable.ic_outline_thumb_up_24)){
                    holder.imgLikeButton.setImageResource(R.drawable.ic_baseline_thumb_up_24);
                    Toast.makeText(mContext, "Outlined clicked", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(mContext, "baseline clicked", Toast.LENGTH_SHORT).show();
                    holder.imgLikeButton.setImageResource(R.drawable.ic_outline_thumb_up_24);
                }
                notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtUserName, txtComment;
        ImageView imgLikeButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtUserName = itemView.findViewById(R.id.txt_user_name);
            txtComment = itemView.findViewById(R.id.txt_layout_comment);
            imgLikeButton = itemView.findViewById(R.id.img_like_button);
        }
    }

}
