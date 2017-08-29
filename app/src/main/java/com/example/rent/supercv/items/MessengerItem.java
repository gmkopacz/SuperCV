package com.example.rent.supercv.items;

import android.content.Context;

import com.example.rent.supercv.MainActivity;
import com.example.rent.supercv.R;

/**
 * Created by RENT on 2017-06-30.
 */

public class MessengerItem extends CVItem {
    private static  final String MESSENGER="Messenger";

    public MessengerItem(){
        super(R.drawable.messenger,MESSENGER);
    }
    @Override
    public void makeAction(Context context) {

    }
}
