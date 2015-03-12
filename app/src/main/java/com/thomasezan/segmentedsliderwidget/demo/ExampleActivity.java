package com.thomasezan.segmentedsliderwidget.demo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.thomasezan.segmentedsliderwidget.OnSegmentSelectedListener;
import com.thomasezan.segmentedsliderwidget.SliderSelector;

import java.util.ArrayList;

public class ExampleActivity extends ActionBarActivity {

    // UI Objects
    private SliderSelector mSliderSelector;
    private TextView mHelloTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        // Init segments
        ArrayList<View> mViews = new ArrayList<>();
        mSliderSelector = (SliderSelector)findViewById(R.id.slider_selector);
        mHelloTextView = (TextView)findViewById(R.id.hello_textview);

        TextView mTextView1 = new TextView(this);
        mTextView1.setText("New York");
        mViews.add(mTextView1);

        TextView mTextView2 = new TextView(this);
        mTextView2.setText("Seattle");
        mViews.add(mTextView2);

        TextView mTextView3 = new TextView(this);
        mTextView3.setText("San Francisco");
        mViews.add(mTextView3);

        TextView mTextView4 = new TextView(this);
        mTextView4.setText("Austin");
        mViews.add(mTextView4);

        mHelloTextView.setText("Hello New York!");

        mSliderSelector.setSegmentViews(mViews);
        mSliderSelector.setSegmentSelectedListener(new OnSegmentSelectedListener() {
            @Override
            public void onSegmentSelected(int segmentIndex) {
                switch (segmentIndex){
                    case 0:
                        mHelloTextView.setText("Hello New York!");
                        break;
                    case 1:
                        mHelloTextView.setText("Hello Seattle!");
                        break;
                    case 2:
                        mHelloTextView.setText("Hello San Francisco!");
                        break;
                    case 3:
                        mHelloTextView.setText("Hello Austin!");
                        break;
                }
            }
        });
    }
}
