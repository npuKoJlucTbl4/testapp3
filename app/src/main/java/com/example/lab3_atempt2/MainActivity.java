package com.example.lab3_atempt2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Binder;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.TextView;

import com.example.lab3_atempt2.databinding.ActivityMainBinding;

import org.w3c.dom.Text;

import java.time.format.TextStyle;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);
        binding.button.setOnClickListener(this::Send_Button);
    }
    private void Send_Button(View v){
        if(!binding.editTextText.getText().toString().matches("")) {
            TextView newMessage = new TextView(binding.textView.getContext());
            newMessage.setText(binding.editTextText.getText());
            newMessage.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
            newMessage.setTextSize(24);
            newMessage.setTypeface(binding.textView.getTypeface());
            binding.List.addView(newMessage);
            binding.editTextText.setText("");
            Answer(newMessage.getText().toString());
        }
    }
    public void Answer(String message){
        TextView newAnswer = new TextView(binding.textView.getContext());
        if(message.matches("privet")) {
            newAnswer.setText("poka");
        } else if (message.matches("kto ti\\?")){
            newAnswer.setText("zdravstvyite, user. eto ya, vash lechashiy vrach. vi nahodetes' v kome");
        }
        else {
            newAnswer.setText("i dont understand *" + message + "*");
        }
        newAnswer.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        newAnswer.setTextSize(24);
        newAnswer.setTypeface(binding.textView.getTypeface());
        binding.List.addView(newAnswer);

    }
}