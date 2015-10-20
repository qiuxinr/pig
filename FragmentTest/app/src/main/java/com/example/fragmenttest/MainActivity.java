package com.example.fragmenttest;

import java.util.ArrayList;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.app.FragmentTransaction;

public class MainActivity extends FragmentActivity  implements OnItemClickListener{

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ArrayList<String> menuLists;
    private ArrayAdapter<String> adapter;
    private String mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.content, new MainFragment(), "mainFragment");
        ft.commit();
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                            long arg3) {
        // 动态插入一个Fragment到FrameLayout当中
        Fragment contentFragment = new ContentFragment();
        Fragment mainFragment = new MainFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        
        mDrawerLayout.closeDrawer(mDrawerList);
    }

}
