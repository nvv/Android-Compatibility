package org.nvv.compatibility.fragments;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import org.nvv.compatibility.BaseApp;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class TabListener implements ActionBar.TabListener {

    private Fragment mFragment;
    private FragmentManager mFragmentManager;

    public TabListener(FragmentManager fragmentManager, Fragment fragment) {
        mFragmentManager = fragmentManager;
        mFragment = fragment;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

        int layoutRootId = BaseApp.sInstance.getResourceId("id", "layout_root");
        if (layoutRootId == 0) {
            throw new RuntimeException("You must provide layout with View Id 'layout_root' at the top of ");
        }
        mFragmentManager.beginTransaction().add(layoutRootId, mFragment).commit();
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        mFragmentManager.beginTransaction().remove(mFragment).commit();
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

}
