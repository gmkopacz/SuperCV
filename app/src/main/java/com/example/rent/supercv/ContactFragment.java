package com.example.rent.supercv;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.rent.supercv.items.MailItem;
import com.example.rent.supercv.items.MessengerItem;
import com.example.rent.supercv.items.PhoneItem;
import com.example.rent.supercv.items.WebBrowserItem;
import com.example.rent.supercv.view.CvItem;
import com.example.rent.supercv.view.CvRow;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ContactFragment extends Fragment {

    private SnackBarShower snackBarShower;

    @BindView(R.id.contactFragmentContainer)
    LinearLayout container;

//    private OnFragmentInteractionListener mListener;

    public ContactFragment() {
        // Required empty public constructor
    }

    public static ContactFragment newInstance() {
        ContactFragment fragment = new ContactFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        ButterKnife.bind(this, view);
//        LinearLayout container2 = view.findViewById(R.id.contactFragmentContainer)
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final PhoneItem phoneItem = new PhoneItem();
        CvRow phoneRow = new CvRow(getActivity(), phoneItem);


        final MailItem mailItem = new MailItem();
        CvRow mailRow = new CvRow(getActivity(), mailItem);

        WebBrowserItem webBrowserItem = new WebBrowserItem("http://9gag.com");
        CvRow webRow = new CvRow(getActivity(),webBrowserItem);

        MessengerItem messengerItem = new MessengerItem();
        CvRow messengerRow = new CvRow(getActivity(),messengerItem);

        messengerRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(/*mamy messengera*/ false){
                    //pokaż mesengera
                }else{
                    //((MainActivity) getActivity()).showSnackbar("Brak messengera");
                    snackBarShower.showSnackBar("Brak Messengera");
                }
            }
        });



        container.addView(phoneRow);
        container.addView(mailRow);
        container.addView(webRow);
        container.addView(messengerRow);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof SnackBarShower)
            snackBarShower = (SnackBarShower) context;
    }

    @Override
    public void onDetach(){
        super.onDetach();
        snackBarShower=null;
    }

    public void showSnackbar(){

    }



    public void call() {
        Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
        phoneIntent.setData(Uri.parse("tel:997"));
        startActivity(phoneIntent);
    }

    //
//    @OnClick(R.id.secondElement)
    public void sendMail() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"mail@mail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Mail z mojego CV");
        startActivity(intent);
    }

}