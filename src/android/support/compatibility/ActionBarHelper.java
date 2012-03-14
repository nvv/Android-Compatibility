package android.support.compatibility;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;

/**
 * An abstract class that handles some common action bar-related functionality in the app. This
 * class provides functionality useful for both phones and tablets, and does not require any Android
 * 3.0-specific features, although it uses them if available.
 *
 * Two implementations of this class are {@link android.support.compatibility.ActionBarHelperBase} for a pre-Honeycomb version of
 * the action bar, and {@link android.support.compatibility.ActionBarHelperHoneycomb}, which uses the built-in ActionBar features
 * in Android 3.0 and later.
 */
public abstract class ActionBarHelper {
    protected Activity mActivity;

    /**
     * Factory method for creating {@link com.compatibility.compatibility.ActionBarHelper} objects for a
     * given activity. Depending on which device the app is running, either a basic helper or
     * Honeycomb-specific helper will be returned.
     *
     * @param activity activity which holds created helper.
     *
     * @return action bar helper.
     */
    public static ActionBarHelper createInstance(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            return new ActionBarHelperICS(activity);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            return new ActionBarHelperHoneycomb(activity);
        } else {
            return new ActionBarHelperBase(activity);
        }
    }

    protected ActionBarHelper(Activity activity) {
        mActivity = activity;
    }

    /**
     * Action bar helper code to be run in {@link android.app.Activity#onCreate(android.os.Bundle)}.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously
     *      being shut down then this Bundle contains the data it most
     *      recently supplied in onSaveInstanceState(Bundle). Note: Otherwise it is null.
     */
    public void onCreate(Bundle savedInstanceState) {
    }

    /**
     * Action bar helper code to be run in {@link android.app.Activity#onPostCreate(android.os.Bundle)}.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously
     *      being shut down then this Bundle contains the data it most
     *      recently supplied in onSaveInstanceState(Bundle). Note: Otherwise it is null.
     */
    public void onPostCreate(Bundle savedInstanceState) {
    }

    /**
     * Action bar helper code to be run in {@link android.app.Activity#onCreateOptionsMenu(android.view.Menu)}.
     *
     * NOTE: Setting the visibility of menu items in <em>menu</em> is not currently supported.
     *
     * @param menu activity menu
     *
     * @return <code>true</code>
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    /**
     * Action bar helper code to be run in {@link android.app.Activity#onTitleChanged(CharSequence, int)}.
     */
    public void onTitleChanged(CharSequence title, int color) {
    }

    /**
     * Sets the indeterminate loading state of the item with ID
     * (where the item ID was menu_refresh).
     */
    public abstract void setRefreshActionItemState(boolean refreshing);

    /**
     * Returns a {@link android.view.MenuInflater} for use when inflating menus. The implementation of this
     * method in {@link android.support.compatibility.ActionBarHelperBase} returns a wrapped menu mInflater that can read
     * action bar metadata from a menu resource pre-Honeycomb.
     */
    public MenuInflater getMenuInflater(MenuInflater superMenuInflater) {
        return superMenuInflater;
    }

    /**
     * Add new tab to action bar.
     *
     * @param label to be displayed in tab list.
     * @param fragment which will be shown when tab is selected.
     */
    public abstract void addActionBarTab(String label, Fragment fragment);

    /**
     * Get currently selected tab.
     *
     * @return currently selected tab.
     */
    public abstract int getSelectedTab();

    /**
     * Compatibility method to create Search View. {@link android.widget.SearchView}.
     * For sdk version < 11 - custom implementation based on simple text view, for sdk >= 11 -
     * default Android {@link android.widget.SearchView}.
     *
     * @param listener used for notifications when text in search field is changed.
     */
    public abstract void createSearchMenuItem(SearchViewQueryListener listener);

}