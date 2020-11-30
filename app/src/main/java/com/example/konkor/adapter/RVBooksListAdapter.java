package com.example.konkor.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.konkor.R;
import com.example.konkor.activity.QuestionActivity;
import com.example.konkor.models.Book;

import java.util.List;

public class RVBooksListAdapter extends RecyclerView.Adapter<RVBooksListAdapter.ViewHolder> {
    private Context mContext;
    private List<Book> books;
    private String IMAGE_URL = "https://edit.org/images/cat/book-covers-big-2019101610.jpg";
    public RVBooksListAdapter(Context context, List<Book> books) {
        this.mContext = context;
        this.books = books;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.rv_books_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtBookTitle.setText(books.get(position).getTitle());
        holder.txtBookAuthor.setText(books.get(position).getAuthor());
        holder.txtBookCredit.setText(String.valueOf(books.get(position).getCredit()));
        holder.rlBookDetail.setVisibility(View.GONE);
        Glide.with(mContext)
                .load(this.IMAGE_URL)
                .into(holder.imgBookImage);
        
        holder.imgBookImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, QuestionActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });
        holder.imgShowExpandable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.rlBookDetail.getVisibility() == View.GONE){
                    holder.rlBookDetail.setVisibility(View.VISIBLE);
                    holder.imgShowExpandable.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_baseline_keyboard_arrow_up_30));
                }else {
                    holder.rlBookDetail.setVisibility(View.GONE);
                    holder.imgShowExpandable.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_baseline_keyboard_arrow_down_30));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtBookTitle, txtBookAuthor, txtBookCredit, txtBookAverageResult;
        ImageButton imgShowExpandable;
        RelativeLayout rlBookDetail;
        ImageView imgBookImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtBookTitle = itemView.findViewById(R.id.txt_book_title);
            txtBookAuthor = itemView.findViewById(R.id.txt_book_author_value);
            txtBookCredit = itemView.findViewById(R.id.txt_book_credit_value);
            txtBookAverageResult = itemView.findViewById(R.id.txt_quiz_average_result_value);
            imgShowExpandable = itemView.findViewById(R.id.img_switch_detail);
            rlBookDetail = itemView.findViewById(R.id.layout_book_expandable);
            imgBookImage = itemView.findViewById(R.id.img_book_image);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext, QuestionActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(intent);
        }
    }
}
