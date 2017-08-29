package com.example.rent.supercv.items;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.example.rent.supercv.R;

/**
 * Created by RENT on 2017-06-26.
 */

public class MailItem extends CVItem{


    public static final String TAG_MAIL_NAME = "gmkopacz@gmil.com";
    public static final String TAG_SUBJECT = "Mail z mojego CV";
    public static final String TAG_MAIL_TO = "mailto:";

    public MailItem() {
        super(R.drawable.ic_drafts_black_24dp, TAG_MAIL_NAME);
    }

    private void mail(Context context){

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse(TAG_MAIL_TO));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{TAG_MAIL_NAME});
        intent.putExtra(Intent.EXTRA_SUBJECT, TAG_SUBJECT);
        context.startActivity(intent);



    }

    @Override
    public void makeAction(Context context) {
        mail(context);
    }
}
