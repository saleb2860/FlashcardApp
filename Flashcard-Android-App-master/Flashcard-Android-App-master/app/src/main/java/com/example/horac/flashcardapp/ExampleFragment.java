package com.example.horac.flashcardapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.List;


public class ExampleFragment extends Fragment {
    public ExampleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View x = inflater.inflate(R.layout.fragment_example, container, false);
        x.findViewById(R.id.MinusButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                ExampleFragment.this.startActivity(intent);
                getActivity().overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        x.findViewById(R.id.SaveButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newQuestion = ((EditText)getView().findViewById(R.id.editText)).getText().toString();
                String newAnswer = ((EditText)getView().findViewById(R.id.editText2)).getText().toString();
                Intent data = new Intent();
                data.putExtra("string1", newQuestion);
                data.putExtra("string2", newAnswer);
                getActivity().setResult(AddCardActivity.RESULT_OK, data);
                getActivity().finish();
            }
        });
        return x;
    }
}