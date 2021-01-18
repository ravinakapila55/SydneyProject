package com.sydneyproject;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import com.sydneyproject.savedBills.SavedBills;
import com.sydneyproject.home.HomePage;
import com.sydneyproject.notification.NotificationList;
import com.sydneyproject.profile.Profile;
import de.hdodenhof.circleimageview.CircleImageView;

public class Drawer extends AppCompatActivity
{
    public View view, hview;
    FrameLayout frame;
    DrawerLayout drawer;
    NavigationView navigationView;
    androidx.appcompat.widget.Toolbar toolbar;
    ActionBarDrawerToggle drawerToggle;
    private CircleImageView ivheader;
    private TextView tvname, tvEmail;
    Menu menu;
    Menu nav_menu;
    public TextView tvheader;
    public static String TAG = "Drawer";
    ImageView ivCross;
    RelativeLayout rel_home,rl_profile,rl_saved;
    public ImageView img_home,img_profile,img_saved;
    public TextView tvHome,tvProfile,tvSaved;

    public MenuItem home,profile,notifications,terms,pricavy,faq,share,logout;


    @Override
    public void setContentView(@LayoutRes int layoutResID)
    {
        view = getLayoutInflater().inflate(R.layout.drawer, null);
        frame = (FrameLayout) view.findViewById(R.id.frame);
        getLayoutInflater().inflate(layoutResID, frame, true);

        super.setContentView(view);
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        navigationView = (NavigationView) findViewById(R.id.navigationView);
        hview = navigationView.getHeaderView(0);

        ivheader = (CircleImageView) hview.findViewById(R.id.ivheader);
        ivCross = (ImageView) hview.findViewById(R.id.ivCross);
        tvname = (TextView) hview.findViewById(R.id.tvname);
        tvEmail = (TextView) hview.findViewById(R.id.tvEmail);
        navigationView.inflateMenu(R.menu.menu_drawer);
        menu = navigationView.getMenu();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvheader = (TextView) findViewById(R.id.tvheader);
        rel_home = (RelativeLayout) findViewById(R.id.rel_home);
        rl_profile = (RelativeLayout) findViewById(R.id.rl_profile);
        rl_saved = (RelativeLayout) findViewById(R.id.rl_saved);
        img_home = (ImageView) findViewById(R.id.img_home);
        img_profile = (ImageView) findViewById(R.id.img_profile);
        img_saved = (ImageView) findViewById(R.id.img_saved);
        tvHome = (TextView) findViewById(R.id.tvHome);
        tvProfile = (TextView) findViewById(R.id.tvProfile);
        tvSaved = (TextView) findViewById(R.id.tvSaved);

        menu = navigationView.getMenu();
        home = (MenuItem) menu.findItem(R.id.home);
        profile = (MenuItem) menu.findItem(R.id.profile);
        notifications = (MenuItem) menu.findItem(R.id.notifications);
        terms = (MenuItem) menu.findItem(R.id.terms);
        notifications = (MenuItem) menu.findItem(R.id.notifications);
        pricavy = (MenuItem) menu.findItem(R.id.pricavy);
        faq = (MenuItem) menu.findItem(R.id.faq);
        share = (MenuItem) menu.findItem(R.id.share);
        logout = (MenuItem) menu.findItem(R.id.logout);

        toolbar.setNavigationIcon(R.drawable.menu_new);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        rel_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                setHomeSelected();
                Intent intent=new Intent(Drawer.this, HomePage.class);
                startActivity(intent);
            }
        });

        rl_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProfileSelected();
                Intent intent=new Intent(Drawer.this, Profile.class);
                startActivity(intent);
            }
        });
        rl_saved.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setSavedBills();
                Intent intent=new Intent(Drawer.this, SavedBills.class);
                startActivity(intent);
            }
        });


        drawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.app_name, R.string.app_name)
        {
            @Override
            public void onDrawerOpened(View drawerView)
            {
                super.onDrawerOpened(drawerView);
                supportInvalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView)
            {
                super.onDrawerClosed(drawerView);
                supportInvalidateOptionsMenu();
            }
        };

        drawerToggle.setDrawerIndicatorEnabled(false);//when using our custom drawer icon
        drawer.setDrawerListener(drawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerToggle.syncState();
        initializeView();

        drawerToggle.setToolbarNavigationClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);

                if (drawer.isDrawerOpen(GravityCompat.START))
                {
                    drawer.closeDrawer(GravityCompat.START);
                }
                else
                {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });

        nav_menu = navigationView.getMenu();
    }

    public void setHomeSelected()
    {
        tvProfile.setTextColor(getResources().getColor(R.color.dark_gray));
        tvHome.setTextColor(getResources().getColor(R.color.text_red));
        img_home.setImageDrawable(getResources().getDrawable(R.drawable.home_bottom));
        img_profile.setImageDrawable(getResources().getDrawable(R.drawable.profile_tab));
        tvSaved.setTextColor(getResources().getColor(R.color.dark_gray));
        img_saved.setImageDrawable(getResources().getDrawable(R.drawable.saved_bills_tab));
    }

    public void setProfileSelected()
    {
        tvProfile.setTextColor(getResources().getColor(R.color.text_red));
        tvHome.setTextColor(getResources().getColor(R.color.dark_gray));
        tvSaved.setTextColor(getResources().getColor(R.color.dark_gray));
        img_home.setImageDrawable(getResources().getDrawable(R.drawable.home_gray));
        img_profile.setImageDrawable(getResources().getDrawable(R.drawable.profile_orange));
        img_saved.setImageDrawable(getResources().getDrawable(R.drawable.saved_bills_tab));
    }


    public void setSavedBills()
    {
        tvSaved.setTextColor(getResources().getColor(R.color.text_red));
        tvHome.setTextColor(getResources().getColor(R.color.dark_gray));
        tvHome.setTextColor(getResources().getColor(R.color.dark_gray));
        img_home.setImageDrawable(getResources().getDrawable(R.drawable.home_gray));
        img_profile.setImageDrawable(getResources().getDrawable(R.drawable.profile_tab));
        img_saved.setImageDrawable(getResources().getDrawable(R.drawable.saved_bill_orange));
    }


    private void initializeView()
    {

        ivCross.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                drawer.closeDrawers();
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(MenuItem item)
            {
                drawer.closeDrawers();
                int id = item.getItemId();
                switch (id)
                {
                    case R.id.home:
                        break;

                    case R.id.profile:
                        Intent intent5=new Intent(Drawer.this, Profile.class);
                        startActivity(intent5);
                        break;

                    case R.id.notifications:
                        Intent intent23=new Intent(Drawer.this, NotificationList.class);
                        startActivity(intent23);
                        break;

                    case R.id.terms:

                        break;

                    case R.id.pricavy:
                        break;

                    case R.id.faq:
                        Intent it=new Intent(Drawer.this, FaqScreen.class);
                        startActivity(it);
                        break;

                    case R.id.share:
                        break;

                    case R.id.logout:
                    showLogout();
                     break;

                }
                return true;
            }
        });
    }

    public void showLogout()
    {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.logout_popup, null);

        TextView tvOk=(TextView)dialogView.findViewById(R.id.tvOk);
        TextView tvCancel=(TextView)dialogView.findViewById(R.id.tvCancel);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setCancelable(false);
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        int width = WindowManager.LayoutParams.WRAP_CONTENT;
        int height = WindowManager.LayoutParams.WRAP_CONTENT;

        tvOk.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                alertDialog.dismiss();
                Intent intent=new Intent(Drawer.this, Signin.class);
                startActivity(intent);
            }
        });

        tvCancel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                alertDialog.dismiss();
            }
        });

        alertDialog.show();
    }

}
