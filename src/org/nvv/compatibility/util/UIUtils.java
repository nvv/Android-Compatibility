package org.nvv.compatibility.util;

import android.os.Build;

public class UIUtils {

    public static boolean isHoneycombOrHigher() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    }

}
