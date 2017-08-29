package com.example.rent.supercv;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.rent.supercv.view.CvItem;
import com.example.rent.supercv.view.CvRow;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, SnackBarShower {
    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.snackbar_attach)
    CoordinatorLayout snackBarAttachLayour;
    @BindView(R.id.toolBar)
    Toolbar toolbar;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @BindView(R.id.navigationView)
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PasswordFragment.newInstance().show(getSupportFragmentManager(),"");
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupToolbar();

        navigationView.setNavigationItemSelectedListener(this);


        navigationView.getMenu().performIdentifierAction(R.id.menu_contact, 0);


    }
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        navigationView.getMenu().performIdentifierAction(R.id.menu_contact,0);
    }

    private void openFragment(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_contact:
                openFragment(ContactFragment.newInstance());

                break;
            case R.id.menu_skills:
                openFragment(SkillsFragment.newInstance());
                break;
            case R.id.menu_expirience:
                openFragment(ExpirienceFragment.newInstance());
                break;
            case R.id.menu_notes:
                openFragment(NotesFragment.newInstance());
                break;
        }
    }

    private void openFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle oreo = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(oreo);
        oreo.syncState();
    }


    public void call() {
        Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
        phoneIntent.setData(Uri.parse("tel:+48665610788"));
        startActivity(phoneIntent);
    }

    //    @OnClick(R.id.secondLayout)
    public void sendMail() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"mail@mail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Mail z mojego CV");
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        toolbar.setTitle(item.getTitle());
        item.setChecked(true);
        openFragment(item);
        drawerLayout.closeDrawer(Gravity.LEFT);
        return false;
    }

    @Override
    public void onClick(View v) {

    }

    @OnClick(R.id.fab)
    public void onFabClicked(){
        addToContacts();
    }

    private void addToContacts() {
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE)
                .putExtra(ContactsContract.Intents.Insert.NAME,Constants.NAME)
                .putExtra(ContactsContract.Intents.Insert.PHONE,Constants.PHONE_NUMBER)
                .putExtra(ContactsContract.Intents.Insert.EMAIL,Constants.EMAIL);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.options_info:
                showInfoDialog();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void showInfoDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder
                .setIcon(R.drawable.warn)
                .setTitle("Info")
                .setMessage("Jakie info")
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }
//    public void showSnackbar(String message){
//        Snackbar.make(snackBarAttachLayour,message,Snackbar.LENGTH_SHORT).show();
//    }

    @Override
    public void showSnackBar(String message) {

    }
//    @OnClick(R.id.thirdElement)
//    public void openWebSite(){
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse("http://google.com"));
//        startActivity(intent);
//
//
//    }


}
