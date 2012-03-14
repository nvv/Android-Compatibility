package android.support.compatibility;

import android.app.Activity;
import android.content.Context;

public class ActionBarHelperICS extends ActionBarHelperHoneycomb {
    protected ActionBarHelperICS(Activity activity) {
        super(activity);
    }

    @Override
    protected Context getActionBarThemedContext() {
        return mActivity.getActionBar().getThemedContext();
    }
}
