package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private EditText nameInput;
    private TextView greetingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameInput);
        greetingText = findViewById(R.id.greetingText);
        Button helloButton = findViewById(R.id.helloButton);

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
            nameInput.setError(getString(R.string.empty_name_error));
            greetingText.setText(R.string.default_message);
            return;
        }

        nameInput.setError(null);
        greetingText.setText("Hello, " + name + "!");
    }
}
