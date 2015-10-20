package com.example.fragmenttest;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainFragment extends Fragment {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ArrayList<String> menuLists;
    private ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mDrawerLayout = (DrawerLayout) view.findViewById(R.id.drawer_layout);
//        mDrawerList = (ListView) view.findViewById(R.id.left_drawer);
//        menuLists = new ArrayList<String>();
////        for (int i = 0; i < 5; i++)
////            menuLists.add("项目0" + i);
//        menuLists.add("登录/更改账户");
//        menuLists.add("设置");
//        menuLists.add("退出账户");
//        adapter = new ArrayAdapter<String>(getActivity(),
//                android.R.layout.simple_list_item_1, menuLists);
//        mDrawerList.setAdapter(adapter);
//        mDrawerList.setOnItemClickListener(this);

        return view;
    }

//    @Override
//    public void onItemClick(AdapterView<?> arg0, View arg1, int position,
//                            long arg3) {
//        // 动态插入一个Fragment到FrameLayout当中
//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        if(position==0){
//            ft.hide(fm.findFragmentByTag("mainFragment"));
//            ft.add(R.id.content, new loginaty(), "loginFragment");
//            ft.addToBackStack(null);
//            ft.commit();
//        }else{
//            ft.hide(fm.findFragmentByTag("mainFragment"));
//            ft.add(R.id.content, new ContentFragment(), "contentFragment");
//            ft.addToBackStack(null);
//            ft.commit();
//        }
////        Bundle args = new Bundle();
////        args.putString("text", menuLists.get(position));
////        contentFragment.setArguments(args);
//        /*switch (position){
//            case 0:{
//                ft.hide(fm.findFragmentByTag("mainFragment"));
//                ft.add(R.id.content, new ContentFragment(), "contentFragment");
//                ft.commit();
//            }
//        }*/
//
//
////        fm.beginTransaction().replace(R.id.content_frame, contentFragment)
////                .commit();
//
//        mDrawerLayout.closeDrawer(mDrawerList);
//    }
}
