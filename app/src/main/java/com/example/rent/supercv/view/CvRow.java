package com.example.rent.supercv.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rent.supercv.items.CVItem;
import com.example.rent.supercv.items.MailItem;
import com.example.rent.supercv.items.PhoneItem;

/**
 * Created by RENT on 2017-06-21.
 */

public class CvRow extends LinearLayout {

    private final Context context;


    private Resources resources;
    private final CVItem cvItem;
    private final DisplayMetrics metrics;
    private float px;


    public CvRow(final Context context, final CVItem cvItem) {
        super(context);

        this.context = context;
        this.cvItem = cvItem;
        resources = context.getResources();
        metrics = resources.getDisplayMetrics();

        setupMainLayout();
        ImageView imageView = createImageView(cvItem.getImageId());
        TextView textView = createTextView(cvItem.getName());
        addViews(imageView, textView);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                cvItem.makeAction(context);
            }
        });

    }

    private void addViews(ImageView imageView, TextView textView) {
        this.addView(imageView);
        this.addView(textView);
    }

    @NonNull
    private TextView createTextView(String text) {
        TextView textView = new TextView(context);
        textView.setText(text);
        LayoutParams textParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textView.setTextSize(16);
        textParams.gravity = Gravity.CENTER_VERTICAL;
        textView.setLayoutParams(textParams);
        textView.setPadding(dpToPx(32), 0, 0, 0);
        return textView;
    }

    @NonNull
    private ImageView createImageView(int imageId) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(imageId);
        LayoutParams imageParams = new LayoutParams(dpToPx(24), dpToPx(24));
        imageParams.gravity = Gravity.CENTER_VERTICAL;
        imageView.setLayoutParams(imageParams);
        return imageView;
    }

    private void setupMainLayout() {
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dpToPx(48));
        this.setLayoutParams(params);
        this.setOrientation(LinearLayout.HORIZONTAL);
        this.setPadding(dpToPx(16), 0, dpToPx(16), 0);
    }

    private int dpToPx(int dp) {
        px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return (int) px;
    }
}
