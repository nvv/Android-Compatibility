package org.nvv.compatibility;

import android.app.Application;

/**
 * Base application object.
 */
public class BaseApp extends Application {

    public static BaseApp sInstance;

    public BaseApp() {
        sInstance = this;
    }

    public int getResourceId(String type, String identifier) {
        return getResources().getIdentifier(identifier, type, getPackageName());
    }
}
