package com.example.rent.supercv.items;

import android.content.Context;

/**
 * Created by RENT on 2017-06-26.
 */

public class NoActionItem extends CVItem {
    public NoActionItem(int imageId, String name) {
        super(imageId, name);
    }

    @Override
    public void makeAction(Context context) {
        noAction(context);

    }
    private void noAction(Context context){

    }
}
