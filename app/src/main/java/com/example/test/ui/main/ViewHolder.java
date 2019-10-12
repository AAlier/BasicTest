package com.example.test.ui.main;

import android.view.View;
import android.widget.TextView;

import com.example.test.R;
import com.example.test.model.Answer;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;
    private Listener listener;

    public ViewHolder(@NonNull View itemView, Listener listener) {
        super(itemView);
        this.listener = listener;
        textView = itemView.findViewById(R.id.textView);
    }

    public void bind(final Answer answer, final int questionPosition) {
        String formattedAnswer = (char) (65 + getAdapterPosition()) + ") " + answer.getTitle();
        textView.setText(formattedAnswer);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClickAnswer(questionPosition, answer);
            }
        });
    }

    public void isAnswered(boolean value) {
        textView.setSelected(value);
    }
}
