package org.nvv.compatibility;

import android.app.Application;

/**
 * Base application object.
 */
public class GApp extends Application {

    public static GApp sInstance;

    public GApp() {
        sInstance = this;
    }

    public int getResourceId(String type, String identifier) {
        return getResources().getIdentifier(identifier, type, getPackageName());
    }
}
