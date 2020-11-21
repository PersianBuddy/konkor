package com.example.konkor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.konkor.R;

public class RVQuestionNumberAdapter extends RecyclerView.Adapter<RVQuestionNumberAdapter.ViewHolder> {
    private Context mContext;
    private String [] mData;
    private int selectedItemIndex = 0;
    private int[] answerStatus;//1 for answered 0 for not answered


    public RVQuestionNumberAdapter(Context context, String[] data) {
        mContext = context;
        mData= data;
        answerStatus = new int [data.length];
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
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
        }
        holder.txtQuestionNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemIndex = position;
                notifyDataSetChanged();
            }
        });
        if(answerStatus[position]== 1){//if question is answered
            holder.txtQuestionNumber.setText("");
            holder.txtQuestionNumber.setBackground(mContext.getResources().getDrawable(R.drawable.ic_done));
            if (selectedItemIndex == position){//if it's the selected one
                holder.txtQuestionNumber.setBackground(mContext.getResources().getDrawable(R.drawable.solid_circle));
                holder.txtQuestionNumber.setTextColor(mContext.getResources().getColor(R.color.white));
                holder.txtQuestionNumber.setText(mData[position]);
            }
            return;
        }
        if(selectedItemIndex == position){
            holder.txtQuestionNumber.setTextColor(mContext.getResources().getColor(R.color.white));
            holder.txtQuestionNumber.setBackground(mContext.getResources().getDrawable(R.drawable.solid_circle));
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

    public int getSelectedItemIndex() {
        return selectedItemIndex;
    }

    public void setSelectedItemIndex(int selectedItemIndex) {
        this.selectedItemIndex = selectedItemIndex;
    }

    public void changeAnswerStatus(int questionIndex, boolean isAnswered){
        if (isAnswered){
            answerStatus[questionIndex] = 1;
        }else {
            answerStatus[questionIndex] = 0;
        }
    }
}
