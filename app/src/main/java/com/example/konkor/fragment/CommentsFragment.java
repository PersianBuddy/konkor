package com.example.konkor.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.konkor.R;
import com.example.konkor.adapter.RVCommentListAdapter;
import com.example.konkor.models.Comment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import static androidx.core.content.ContextCompat.getSystemService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CommentsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CommentsFragment extends Fragment {

    private FloatingActionButton fbAddComment;
    private LinearLayout llAddNewComment;
    private Button btnAddComment;
    private RecyclerView rvCommentList;
    private RVCommentListAdapter adapter;
    private TextInputLayout txtLayoutComment;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CommentsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuestoinComments.
     */
    // TODO: Rename and change types and number of parameters
    public static CommentsFragment newInstance(String param1, String param2) {
        CommentsFragment fragment = new CommentsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comments, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fbAddComment = view.findViewById(R.id.fb_add_comment);
        llAddNewComment = view.findViewById(R.id.new_comment_section);
        btnAddComment = view.findViewById(R.id.btn_add_comment);
        rvCommentList = view.findViewById(R.id.rv_comments_list);
        txtLayoutComment = view.findViewById(R.id.txt_layout_comment);
        List<Comment> comments = setDummyData();

        adapter = new RVCommentListAdapter(view.getContext(),comments);
        rvCommentList.setAdapter(adapter);
        rvCommentList.setLayoutManager(new LinearLayoutManager(view.getContext()));
        EditText editTextComment = txtLayoutComment.getEditText();
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);


        fbAddComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llAddNewComment.setVisibility(View.VISIBLE);
                imm.showSoftInput(editTextComment,0);
                fbAddComment.hide();
            }
        });
        btnAddComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtLayoutComment.clearFocus();
                imm.hideSoftInputFromWindow(editTextComment.getWindowToken(),0);
                llAddNewComment.setVisibility(View.GONE);
                fbAddComment.show();
            }
        });
    }

    private List<Comment> setDummyData() {
        List <Comment> comments = new ArrayList<>();
        comments.add(new Comment(getString(R.string.dummy_comment),1,1));
        comments.add(new Comment(getString(R.string.dummy_comment),1,1));
        comments.add(new Comment(getString(R.string.dummy_comment),1,1));
        comments.add(new Comment(getString(R.string.dummy_comment),1,1));
        comments.add(new Comment(getString(R.string.dummy_comment),1,1));
        comments.add(new Comment(getString(R.string.dummy_comment),1,1));
        comments.add(new Comment(getString(R.string.dummy_comment),1,1));
        comments.add(new Comment(getString(R.string.dummy_comment),1,1));
        comments.add(new Comment(getString(R.string.dummy_comment),1,1));
        comments.add(new Comment(getString(R.string.dummy_comment),1,1));
        comments.add(new Comment(getString(R.string.dummy_comment),1,1));
        comments.add(new Comment(getString(R.string.dummy_comment),1,1));
        comments.add(new Comment(getString(R.string.dummy_comment),1,1));
        comments.add(new Comment(getString(R.string.dummy_comment),1,1));
        comments.add(new Comment(getString(R.string.dummy_comment),1,1));
        return comments;
    }
}