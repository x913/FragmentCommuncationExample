package com.k3kc.fragmentcommuncationexample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {

    private EditText mEditText;
    private Button button;
    private OnMessageReadListener mOnMessageReadListener;

    public interface OnMessageReadListener {
        public void onMessageRead(String message);
    }

    public MessageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity = (Activity)context;
        try {
            mOnMessageReadListener = (OnMessageReadListener)activity;

        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnMessageReadListener interface");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        mEditText = view.findViewById(R.id.text_message);
        button = view.findViewById(R.id.bn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = mEditText.getText().toString();
                mOnMessageReadListener.onMessageRead(message);
            }
        });


        return view;
    }
}
