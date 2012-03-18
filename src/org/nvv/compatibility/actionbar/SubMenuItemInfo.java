package org.nvv.compatibility.actionbar;

public class SubMenuItemInfo {
    
    private int mId;
    private int mIcon;
    private String mTitle;

    public SubMenuItemInfo(int mId, int mIcon, String mTitle) {
        this.mId = mId;
        this.mIcon = mIcon;
        this.mTitle = mTitle;
    }

    public int getmId() {
        return mId;
    }

    public int getmIcon() {
        return mIcon;
    }

    public String getmTitle() {
        return mTitle;
    }
}
