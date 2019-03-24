package com.londonappbrewery.destini;

import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mText;
    Button mButtonTop;
    Button mButtonBottom;
    int mStoryIndex=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mText = (TextView) findViewById(R.id.storyTextView);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mText.setText(getString(R.string.T1_Story));
        mButtonBottom.setText(getString(R.string.T1_Ans2));
        mButtonTop.setText(getString(R.string.T1_Ans1));

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("destini","Top button pressed");
                updateStory("top");

            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        mButtonBottom.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("destini","Botton button pressed");
                updateStory("bottom");
            }
        }));
    }
    private void updateStory(String ans){

        if (ans=="top" && mStoryIndex==1){
            mText.setText(getString(R.string.T3_Story));
            mButtonBottom.setText(getString(R.string.T3_Ans2));
            mButtonTop.setText(getString(R.string.T3_Ans1));
            mStoryIndex=3;
        } else if (ans=="bottom" && mStoryIndex==1) {
            mText.setText(getString(R.string.T2_Story));
            mButtonBottom.setText(getString(R.string.T2_Ans2));
            mButtonTop.setText(getString(R.string.T2_Ans1));
            mStoryIndex=2;
        }
        else if (ans=="top" && mStoryIndex==2) {
            mText.setText(getString(R.string.T4_End));
            mButtonBottom.setText(getString(R.string.T3_Ans2));
            mButtonTop.setText(getString(R.string.T3_Ans1));
            mStoryIndex=3;
        }
        else if (ans=="bottom" && mStoryIndex==2) {
            mText.setText(getString(R.string.T4_End));
            mButtonBottom.setVisibility(View.GONE);
            mButtonTop.setVisibility(View.GONE);
            mStoryIndex=4;
        }
        else if (ans=="top" && mStoryIndex==3) {
            mText.setText(getString(R.string.T6_End));
            mButtonBottom.setVisibility(View.GONE);
            mButtonTop.setVisibility(View.GONE);
            mStoryIndex=6;
        }
        else if (ans=="bottom" && mStoryIndex==3) {
            mText.setText(getString(R.string.T5_End));
            mButtonBottom.setVisibility(View.GONE);
            mButtonTop.setVisibility(View.GONE);
            mStoryIndex=5;
        }

    }
}
