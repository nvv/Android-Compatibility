package org.nvv.compatibility.actionbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class ActionBarSubMenu extends ActionBarMenu implements SubMenu {

    private CharSequence mHeaderTitle;
    private MenuItem mItem;

    public ActionBarSubMenu(Context context, MenuItem item) {
        super(context);
        mItem = item;
    }

    @Override
    public SubMenu setHeaderTitle(int i) {
        mHeaderTitle = getResources().getString(i);
        return this;
    }

    @Override
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        mHeaderTitle = charSequence;
        return this;
    }

    @Override
    public SubMenu setHeaderIcon(int i) {
        return this;
    }

    @Override
    public SubMenu setHeaderIcon(Drawable drawable) {
        return this;
    }

    @Override
    public SubMenu setHeaderView(View view) {
        return this;
    }

    @Override
    public void clearHeader() {
    }

    @Override
    public SubMenu setIcon(int i) {
        return this;
    }

    @Override
    public SubMenu setIcon(Drawable drawable) {
        return this;
    }

    @Override
    public MenuItem getItem() {
        return mItem;
    }
}
