package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.os.LocaleList;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.core.os.LocaleListCompat;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class AccessibilityWindowInfoCompat {
    public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
    public static final int TYPE_APPLICATION = 1;
    public static final int TYPE_INPUT_METHOD = 2;
    public static final int TYPE_MAGNIFICATION_OVERLAY = 6;
    public static final int TYPE_SPLIT_SCREEN_DIVIDER = 5;
    public static final int TYPE_SYSTEM = 3;
    private final AccessibilityWindowInfo mInfo;

    private static class Api24Impl {
        private Api24Impl() {
        }

        static AccessibilityNodeInfo getAnchor(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getAnchor();
        }

        static CharSequence getTitle(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getTitle();
        }
    }

    private static class Api26Impl {
        private Api26Impl() {
        }

        static boolean isInPictureInPictureMode(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isInPictureInPictureMode();
        }
    }

    private static class Api30Impl {
        private Api30Impl() {
        }

        static AccessibilityWindowInfo instantiateAccessibilityWindowInfo() {
            return new AccessibilityWindowInfo();
        }
    }

    private static class Api33Impl {
        private Api33Impl() {
        }

        static int getDisplayId(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getDisplayId();
        }

        static void getRegionInScreen(AccessibilityWindowInfo accessibilityWindowInfo, Region region) {
            accessibilityWindowInfo.getRegionInScreen(region);
        }

        public static AccessibilityNodeInfoCompat getRoot(Object obj, int i) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(((AccessibilityWindowInfo) obj).getRoot(i));
        }
    }

    private static class Api34Impl {
        private Api34Impl() {
        }

        static LocaleList getLocales(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getLocales();
        }

        public static long getTransitionTimeMillis(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getTransitionTimeMillis();
        }
    }

    public AccessibilityWindowInfoCompat() {
        if (Build.VERSION.SDK_INT >= 30) {
            this.mInfo = Api30Impl.instantiateAccessibilityWindowInfo();
        } else {
            this.mInfo = null;
        }
    }

    private AccessibilityWindowInfoCompat(AccessibilityWindowInfo accessibilityWindowInfo) {
        this.mInfo = accessibilityWindowInfo;
    }

    public static AccessibilityWindowInfoCompat obtain() {
        return wrapNonNullInstance(AccessibilityWindowInfo.obtain());
    }

    public static AccessibilityWindowInfoCompat obtain(AccessibilityWindowInfoCompat accessibilityWindowInfoCompat) {
        if (accessibilityWindowInfoCompat == null) {
            return null;
        }
        return wrapNonNullInstance(AccessibilityWindowInfo.obtain(accessibilityWindowInfoCompat.mInfo));
    }

    private static String typeToString(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "<UNKNOWN>" : "TYPE_ACCESSIBILITY_OVERLAY" : "TYPE_SYSTEM" : "TYPE_INPUT_METHOD" : "TYPE_APPLICATION";
    }

    static AccessibilityWindowInfoCompat wrapNonNullInstance(AccessibilityWindowInfo accessibilityWindowInfo) {
        if (accessibilityWindowInfo != null) {
            return new AccessibilityWindowInfoCompat(accessibilityWindowInfo);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccessibilityWindowInfoCompat)) {
            return false;
        }
        AccessibilityWindowInfoCompat accessibilityWindowInfoCompat = (AccessibilityWindowInfoCompat) obj;
        AccessibilityWindowInfo accessibilityWindowInfo = this.mInfo;
        return accessibilityWindowInfo == null ? accessibilityWindowInfoCompat.mInfo == null : accessibilityWindowInfo.equals(accessibilityWindowInfoCompat.mInfo);
    }

    public AccessibilityNodeInfoCompat getAnchor() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(Api24Impl.getAnchor(this.mInfo));
    }

    public void getBoundsInScreen(Rect rect) {
        this.mInfo.getBoundsInScreen(rect);
    }

    public AccessibilityWindowInfoCompat getChild(int i) {
        return wrapNonNullInstance(this.mInfo.getChild(i));
    }

    public int getChildCount() {
        return this.mInfo.getChildCount();
    }

    public int getDisplayId() {
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.getDisplayId(this.mInfo);
        }
        return 0;
    }

    public int getId() {
        return this.mInfo.getId();
    }

    public int getLayer() {
        return this.mInfo.getLayer();
    }

    public LocaleListCompat getLocales() {
        return Build.VERSION.SDK_INT >= 34 ? LocaleListCompat.wrap(Api34Impl.getLocales(this.mInfo)) : LocaleListCompat.getEmptyLocaleList();
    }

    public AccessibilityWindowInfoCompat getParent() {
        return wrapNonNullInstance(this.mInfo.getParent());
    }

    public void getRegionInScreen(Region region) {
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.getRegionInScreen(this.mInfo, region);
            return;
        }
        Rect rect = new Rect();
        this.mInfo.getBoundsInScreen(rect);
        region.set(rect);
    }

    public AccessibilityNodeInfoCompat getRoot() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.getRoot());
    }

    public AccessibilityNodeInfoCompat getRoot(int i) {
        return Build.VERSION.SDK_INT >= 33 ? Api33Impl.getRoot(this.mInfo, i) : getRoot();
    }

    public CharSequence getTitle() {
        return Api24Impl.getTitle(this.mInfo);
    }

    public long getTransitionTimeMillis() {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.getTransitionTimeMillis(this.mInfo);
        }
        return 0L;
    }

    public int getType() {
        return this.mInfo.getType();
    }

    public int hashCode() {
        AccessibilityWindowInfo accessibilityWindowInfo = this.mInfo;
        if (accessibilityWindowInfo == null) {
            return 0;
        }
        return accessibilityWindowInfo.hashCode();
    }

    public boolean isAccessibilityFocused() {
        return this.mInfo.isAccessibilityFocused();
    }

    public boolean isActive() {
        return this.mInfo.isActive();
    }

    public boolean isFocused() {
        return this.mInfo.isFocused();
    }

    public boolean isInPictureInPictureMode() {
        return Api26Impl.isInPictureInPictureMode(this.mInfo);
    }

    @Deprecated
    public void recycle() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AccessibilityWindowInfo[id=");
        Rect rect = new Rect();
        getBoundsInScreen(rect);
        sb.append(getId());
        sb.append(", type=").append(typeToString(getType()));
        sb.append(", layer=").append(getLayer());
        sb.append(", bounds=").append(rect);
        sb.append(", focused=").append(isFocused());
        sb.append(", active=").append(isActive());
        sb.append(", hasParent=").append(getParent() != null);
        sb.append(", hasChildren=").append(getChildCount() > 0);
        sb.append(", transitionTime=").append(getTransitionTimeMillis());
        sb.append(", locales=").append(getLocales());
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    public AccessibilityWindowInfo unwrap() {
        return this.mInfo;
    }
}
