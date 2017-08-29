package com.example.rent.supercv.items;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.example.rent.supercv.R;

/**
 * Created by RENT on 2017-06-26.
 */

public class WebBrowserItem extends CVItem {

    private String address;

    public WebBrowserItem(String address) {
        super(R.drawable.browser, address);
        this.address=address;
    }
    private void openBrowser(Context context){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
        browserIntent.setData(Uri.parse(address));
        context.startActivity(browserIntent);
    }

    @Override
    public void makeAction(Context context) {
        openBrowser(context);
    }

}
