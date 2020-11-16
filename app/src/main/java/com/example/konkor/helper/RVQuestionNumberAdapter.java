package com.example.konkor.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.konkor.R;
import com.example.konkor.activity.QuestionActivity;

public class RVQuestionNumberAdapter extends RecyclerView.Adapter<RVQuestionNumberAdapter.ViewHolder> {
    private Context mContext;
    private String [] mData;
    private int row_index = -1;


    public RVQuestionNumberAdapter(Context context, String[] data) {
        mContext = context;
        mData= data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.rv_question_number_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtQuestionNumber.setText(mData[position]);
        if (position ==0){
            holder.txtQuestionNumber.setTextColor(mContext.getResources().getColor(R.color.white));
            holder.txtQuestionNumber.setBackground(mContext.getResources().getDrawable(R.drawable.solid_circle));
            QuestionActivity.questionIndex = 0;
        }
        holder.txtQuestionNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index = position;
                notifyDataSetChanged();
            }
        });
        if(row_index==position){
            holder.txtQuestionNumber.setTextColor(mContext.getResources().getColor(R.color.white));
            holder.txtQuestionNumber.setBackground(mContext.getResources().getDrawable(R.drawable.solid_circle));
            QuestionActivity.questionIndex = row_index;
        }else{
            holder.txtQuestionNumber.setTextColor(mContext.getResources().getColor(R.color.black));
            holder.txtQuestionNumber.setBackgroundResource(0);
        }
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtQuestionNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtQuestionNumber = itemView.findViewById(R.id.txt_question_number_item);
        }
    }
}
