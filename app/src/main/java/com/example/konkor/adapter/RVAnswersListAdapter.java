package com.example.konkor.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.konkor.R;
import com.example.konkor.activity.SingleAnswerActivity;
import com.example.konkor.models.Question;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class RVAnswersListAdapter extends RecyclerView.Adapter <RVAnswersListAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<Question> questions;
    private int[] userAnswers;
    private int mPosition;

    public RVAnswersListAdapter(Context mContext, ArrayList<Question> questions, int[] userAnswers) {
        this.mContext = mContext;
        this.questions = questions;
        this.userAnswers = userAnswers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.rv_answers_list_item,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        mPosition = position;
        Question currentQuestion = questions.get(position);
        holder.txtQuestionNumber.setText("سوال شماره "+ String.valueOf(position +1));
        holder.txtQuestion.setText(currentQuestion.getQuestion());
        if (userAnswers[position] == -1){
            holder.txtUserAnswer.setText("-");

        }else {
            holder.txtUserAnswer.setText(currentQuestion.getAnswers()[userAnswers[position]]);
        }
        holder.txtCorrectAnswer.setText(currentQuestion.getAnswers()[currentQuestion.getCorrectAnswerIndex()]);

        if (userAnswers[position] == -1){
            holder.imgAnswerStatus.setImageResource(R.drawable.ic_yellow_explanation);
        }else if (currentQuestion.getCorrectAnswerIndex() == userAnswers[position]){
            holder.imgAnswerStatus.setImageResource(R.drawable.ic_green_check);
        }else {
            holder.imgAnswerStatus.setImageResource(R.drawable.ic_red_cross);
        }
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtQuestionNumber, txtQuestion, txtUserAnswer, txtCorrectAnswer;
        ImageView imgAnswerStatus;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtQuestionNumber = itemView.findViewById(R.id.txt_question_number);
            txtQuestion = itemView.findViewById(R.id.txt_question);
            txtUserAnswer = itemView.findViewById(R.id.txt_user_answer_value);
            txtCorrectAnswer = itemView.findViewById(R.id.txt_correct_answer_value);
            imgAnswerStatus = itemView.findViewById(R.id.img_answer_status);
            itemView.setOnClickListener(this::onClick);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext, SingleAnswerActivity.class);
            mContext.startActivity(intent);
        }
    }
}
