package com.demo.report.stepover;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.text);
        final String textToDisplay = getTextToDisplay(1);

        textView.setText(textToDisplay); // Put a breakpoint here (Breakpoint A)
    }

    private String getTextToDisplay(int position) {
        switch (position) { // And another breakpoint here (Breakpoint B)
            case 0:
                return "First entry";
            case 1:
                return "Second entry";
            default:
                return "Further entries";
        }
    }

    // 1. Once the debugger hits breakpoint A, step over
    // 2. Step over again, and you are taken to the return value of case 1 (this is expected)
    // 3. Step over once again, and you are taken to the default return value (this is unexpected)
    // 4. Step over again, notice that textToDisplay will return the value for case 1 (this is expected)

    // Number 3 above should not happen, since it can be confusing :)
}
