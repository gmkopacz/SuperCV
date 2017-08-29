package com.example.rent.supercv.view;

import android.content.Context;

/**
 * Created by RENT on 2017-06-22.
 */

public abstract class CvItem {

    protected final int imageId;
    protected final String name;

    public CvItem(int imageId, String name) {
        this.imageId = imageId;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getText() {
        return name;
    }

    public abstract void makeAction(Context context);
}
