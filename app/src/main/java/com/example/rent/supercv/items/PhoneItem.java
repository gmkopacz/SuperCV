package com.example.rent.supercv.items;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.example.rent.supercv.Constants;
import com.example.rent.supercv.R;

/**
 * Created by RENT on 2017-06-26.
 */

public class PhoneItem extends CVItem{

    private String number;

    //private static final String TAG_PHONE_NUMBER = "+48665610788";

    public PhoneItem(String number) {
        super(R.drawable.ic_call_black_24dp, number);
        this.number = number;

    }

    public PhoneItem(int imgId,String number){
        super(imgId,number);
    }

    private void call(Context context){
        Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
        phoneIntent.setData(Uri.parse("tel:"+number));
        context.startActivity(phoneIntent);
    }
    public PhoneItem() {
        super(R.drawable.ic_call_black_24dp, "Moj numer: " + Constants.PHONE_NUMBER);
        number = Constants.PHONE_NUMBER;
    }

    @Override
    public void makeAction(Context context) {
        call(context);
    }
}
