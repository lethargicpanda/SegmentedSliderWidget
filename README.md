# Segmented Slider Widget
## 

Segmented Slider is an Android custom view.It can be used as a replacement for tabs.
The slider is draggable. You can also tap a label to set it as selected.

![Sample Image](https://raw.githubusercontent.com/lethargicpanda/SegmentedSliderWidget/master/art/hello_activity.png)

##Usage
```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools" 
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".ExampleActivity">

    <RelativeLayout
        android:id="@+id/slider_layout"
        android:layout_width="wrap_content"
        android:layout_height="55dp"
        android:background="#456577"
        android:gravity="center"
        android:paddingLeft="20dp"
        android:paddingRight="20dp"
        >
        <com.thomasezan.segmentedsliderwidget.SliderSelector
            android:id="@+id/slider_selector"
            android:layout_width="match_parent"
            android:layout_height="40dp"
            />
    </RelativeLayout>

    <RelativeLayout
        android:layout_below="@id/slider_layout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:paddingLeft="@dimen/activity_horizontal_margin"
        android:paddingRight="@dimen/activity_horizontal_margin"
        android:paddingTop="@dimen/activity_vertical_margin"
        android:paddingBottom="@dimen/activity_vertical_margin"
        >
        <TextView
            android:id="@+id/hello_textview"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            tools:text="Hello world!"
            />
    </RelativeLayout>
</RelativeLayout>
```

```java
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
```
