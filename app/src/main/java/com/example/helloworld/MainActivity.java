package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private EditText nameInput;
    private Button helloButton;
    private TextView greetingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameInput);
        helloButton = findViewById(R.id.helloButton);
        greetingText = findViewById(R.id.greetingText);

        helloButton.setEnabled(false);
        nameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                helloButton.setEnabled(!s.toString().trim().isEmpty());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        helloButton.setOnClickListener(view -> sayHello());
        nameInput.setOnEditorActionListener((view, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                sayHello();
                return true;
            }
            return false;
        });
    }

    private void sayHello() {
        String name = nameInput.getText().toString().trim();
        if (name.isEmpty()) {
            return;
        }

        greetingText.setText("Hello, " + name + "!");
    }
}
