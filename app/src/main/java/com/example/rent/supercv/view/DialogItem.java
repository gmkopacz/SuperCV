package com.example.rent.supercv.view;

import android.app.AlertDialog;
import android.content.Context;

/**
 * Created by RENT on 2017-06-30.
 */

public class DialogItem extends CvItem{
    private String text;

    public DialogItem(int imageId, String name, String text){
        super(imageId,name);
        this.text=text;
    }

    @Override
    public void makeAction(Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle(name)
                .setIcon(imageId)
                .setMessage(text);

        AlertDialog alertdialog =builder.create();
        alertdialog.show();
    }
}
