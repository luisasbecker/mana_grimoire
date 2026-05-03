package androidx.browser.auth;

import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsIntent;

/* JADX INFO: loaded from: classes.dex */
public final class AuthTabColorSchemeParams {
    private final Integer mNavigationBarColor;
    private final Integer mNavigationBarDividerColor;
    private final Integer mToolbarColor;

    public static final class Builder {
        private Integer mNavigationBarColor;
        private Integer mNavigationBarDividerColor;
        private Integer mToolbarColor;

        public AuthTabColorSchemeParams build() {
            return new AuthTabColorSchemeParams(this.mToolbarColor, this.mNavigationBarColor, this.mNavigationBarDividerColor);
        }

        public Builder setNavigationBarColor(int i) {
            this.mNavigationBarColor = Integer.valueOf(i | (-16777216));
            return this;
        }

        public Builder setNavigationBarDividerColor(int i) {
            this.mNavigationBarDividerColor = Integer.valueOf(i);
            return this;
        }

        public Builder setToolbarColor(int i) {
            this.mToolbarColor = Integer.valueOf(i | (-16777216));
            return this;
        }
    }

    private AuthTabColorSchemeParams(Integer num, Integer num2, Integer num3) {
        this.mToolbarColor = num;
        this.mNavigationBarColor = num2;
        this.mNavigationBarDividerColor = num3;
    }

    static AuthTabColorSchemeParams fromBundle(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle(0);
        }
        return new AuthTabColorSchemeParams((Integer) bundle.get(CustomTabsIntent.EXTRA_TOOLBAR_COLOR), (Integer) bundle.get(CustomTabsIntent.EXTRA_NAVIGATION_BAR_COLOR), (Integer) bundle.get(CustomTabsIntent.EXTRA_NAVIGATION_BAR_DIVIDER_COLOR));
    }

    public Integer getNavigationBarColor() {
        return this.mNavigationBarColor;
    }

    public Integer getNavigationBarDividerColor() {
        return this.mNavigationBarDividerColor;
    }

    public Integer getToolbarColor() {
        return this.mToolbarColor;
    }

    Bundle toBundle() {
        Bundle bundle = new Bundle();
        Integer num = this.mToolbarColor;
        if (num != null) {
            bundle.putInt(CustomTabsIntent.EXTRA_TOOLBAR_COLOR, num.intValue());
        }
        Integer num2 = this.mNavigationBarColor;
        if (num2 != null) {
            bundle.putInt(CustomTabsIntent.EXTRA_NAVIGATION_BAR_COLOR, num2.intValue());
        }
        Integer num3 = this.mNavigationBarDividerColor;
        if (num3 != null) {
            bundle.putInt(CustomTabsIntent.EXTRA_NAVIGATION_BAR_DIVIDER_COLOR, num3.intValue());
        }
        return bundle;
    }

    AuthTabColorSchemeParams withDefaults(AuthTabColorSchemeParams authTabColorSchemeParams) {
        Integer num = this.mToolbarColor;
        if (num == null) {
            num = authTabColorSchemeParams.mToolbarColor;
        }
        Integer num2 = this.mNavigationBarColor;
        if (num2 == null) {
            num2 = authTabColorSchemeParams.mNavigationBarColor;
        }
        Integer num3 = this.mNavigationBarDividerColor;
        if (num3 == null) {
            num3 = authTabColorSchemeParams.mNavigationBarDividerColor;
        }
        return new AuthTabColorSchemeParams(num, num2, num3);
    }
}
