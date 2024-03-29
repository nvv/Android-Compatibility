package org.nvv.compatibility.actionbar;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import java.util.ArrayList;

/**
 * A <em>really</em> dumb implementation of the {@link android.view.Menu} interface, that's only
 * useful for our actionbar-compat purposes. See
 * <code>com.android.internal.view.menu.MenuBuilder</code> in AOSP for a more complete
 * implementation.
 */
public class ActionBarMenu implements Menu {

    private Context mContext;
    private Resources mResources;

    protected ArrayList<ActionBarMenuItem> mItems;

    public ActionBarMenu(Context context) {
        mContext = context;
        mResources = context.getResources();
        mItems = new ArrayList<ActionBarMenuItem>();
    }



    public Context getContext() {
        return mContext;
    }

    public Resources getResources() {
        return mResources;
    }

    public MenuItem add(CharSequence title) {
        return addInternal(0, 0, title);
    }

    public MenuItem add(int titleRes) {
        return addInternal(0, 0, mResources.getString(titleRes));
    }

    public MenuItem add(int groupId, int itemId, int order, CharSequence title) {
        return addInternal(itemId, order, title);
    }

    public MenuItem add(int groupId, int itemId, int order, int titleRes) {
        return addInternal(itemId, order, mResources.getString(titleRes));
    }

    /**
     * Adds an item to the menu.  The other add methods funnel to this.
     */
    private MenuItem addInternal(int itemId, int order, CharSequence title) {
        final ActionBarMenuItem item = new ActionBarMenuItem(this, itemId, order, title);
        mItems.add(findInsertIndex(mItems, order), item);
        return item;
    }

    private static int findInsertIndex(ArrayList<? extends MenuItem> items, int order) {
        for (int i = items.size() - 1; i >= 0; i--) {
            MenuItem item = items.get(i);
            if (item.getOrder() <= order) {
                return i + 1;
            }
        }

        return 0;
    }

    public int findItemIndex(int id) {
        final int size = size();

        for (int i = 0; i < size; i++) {
            ActionBarMenuItem item = mItems.get(i);
            if (item.getItemId() == id) {
                return i;
            }
        }

        return -1;
    }

    public void removeItem(int itemId) {
        removeItemAtInt(findItemIndex(itemId));
    }

    private void removeItemAtInt(int index) {
        if ((index < 0) || (index >= mItems.size())) {
            return;
        }
        mItems.remove(index);
    }

    public void clear() {
        mItems.clear();
    }

    public MenuItem findItem(int id) {
        final int size = size();
        for (int i = 0; i < size; i++) {
            ActionBarMenuItem item = mItems.get(i);
            if (item.getItemId() == id) {
                return item;
            }
        }

        return null;
    }

    public int size() {
        return mItems.size();
    }

    public MenuItem getItem(int index) {
        return mItems.get(index);
    }

    // Unsupported operations.

    public SubMenu addSubMenu(CharSequence title) {
        return new ActionBarSubMenu(mContext, addInternal(0, 0, title));
    }

    public SubMenu addSubMenu(int titleRes) {
        return new ActionBarSubMenu(mContext, addInternal(0, 0, getResources().getString(titleRes)));
    }

    public SubMenu addSubMenu(int groupId, int itemId, int order, CharSequence title) {
        return new ActionBarSubMenu(mContext, addInternal(itemId, order, title));
    }

    public SubMenu addSubMenu(int groupId, int itemId, int order, int titleRes) {
        return new ActionBarSubMenu(mContext, addInternal(itemId, order, getResources().getString(titleRes)));
    }

    public int addIntentOptions(int i, int i1, int i2, ComponentName componentName,
                                Intent[] intents, Intent intent, int i3, MenuItem[] menuItems) {
        throw new UnsupportedOperationException("This operation is not supported for ActionBarMenu");
    }

    public void removeGroup(int i) {
        throw new UnsupportedOperationException("This operation is not supported for ActionBarMenu");
    }

    public void setGroupCheckable(int i, boolean b, boolean b1) {
        throw new UnsupportedOperationException("This operation is not supported for ActionBarMenu");
    }

    public void setGroupVisible(int i, boolean b) {
        throw new UnsupportedOperationException("This operation is not supported for ActionBarMenu");
    }

    public void setGroupEnabled(int i, boolean b) {
        throw new UnsupportedOperationException("This operation is not supported for ActionBarMenu");
    }

    public boolean hasVisibleItems() {
        throw new UnsupportedOperationException("This operation is not supported for ActionBarMenu");
    }

    public void close() {
        throw new UnsupportedOperationException("This operation is not supported for ActionBarMenu");
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i1) {
        throw new UnsupportedOperationException("This operation is not supported for ActionBarMenu");
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        throw new UnsupportedOperationException("This operation is not supported for ActionBarMenu");
    }

    public boolean performIdentifierAction(int i, int i1) {
        return false;
    }

    public void setQwertyMode(boolean b) {
        throw new UnsupportedOperationException("This operation is not supported for ActionBarMenu");
    }
}