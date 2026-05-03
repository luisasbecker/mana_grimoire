package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogPrivacySettingsBinding implements ViewBinding {
    public final MaterialButton cancelButton;
    public final LinearLayout circlesContainer;
    public final LinearLayout circlesSection;
    public final View circlesSeparator;
    public final TextView closeButton;
    public final TextView createCircleButton;
    public final LinearLayout deckOptionsSection;
    public final View deckOptionsSeparator;
    public final ImageView privacyChevron;
    public final TextView privacyDescription;
    public final TextView privacyLabel;
    public final LinearLayout privacySelectorContainer;
    public final LinearLayout profileOptionsSection;
    public final View profileOptionsSeparator;
    private final LinearLayout rootView;
    public final MaterialButton saveButton;
    public final SwitchCompat shareGamesSwitch;
    public final SwitchCompat shareProfileFriendCodeSwitch;
    public final SwitchCompat shareProfileGamesSwitch;
    public final SwitchCompat shareProfileStatsSwitch;
    public final SwitchCompat shareStatsSwitch;
    public final TextView titleTextView;

    private DialogPrivacySettingsBinding(LinearLayout linearLayout, MaterialButton materialButton, LinearLayout linearLayout2, LinearLayout linearLayout3, View view, TextView textView, TextView textView2, LinearLayout linearLayout4, View view2, ImageView imageView, TextView textView3, TextView textView4, LinearLayout linearLayout5, LinearLayout linearLayout6, View view3, MaterialButton materialButton2, SwitchCompat switchCompat, SwitchCompat switchCompat2, SwitchCompat switchCompat3, SwitchCompat switchCompat4, SwitchCompat switchCompat5, TextView textView5) {
        this.rootView = linearLayout;
        this.cancelButton = materialButton;
        this.circlesContainer = linearLayout2;
        this.circlesSection = linearLayout3;
        this.circlesSeparator = view;
        this.closeButton = textView;
        this.createCircleButton = textView2;
        this.deckOptionsSection = linearLayout4;
        this.deckOptionsSeparator = view2;
        this.privacyChevron = imageView;
        this.privacyDescription = textView3;
        this.privacyLabel = textView4;
        this.privacySelectorContainer = linearLayout5;
        this.profileOptionsSection = linearLayout6;
        this.profileOptionsSeparator = view3;
        this.saveButton = materialButton2;
        this.shareGamesSwitch = switchCompat;
        this.shareProfileFriendCodeSwitch = switchCompat2;
        this.shareProfileGamesSwitch = switchCompat3;
        this.shareProfileStatsSwitch = switchCompat4;
        this.shareStatsSwitch = switchCompat5;
        this.titleTextView = textView5;
    }

    public static DialogPrivacySettingsBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        View viewFindChildViewById3;
        int i = R.id.cancelButton;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.circlesContainer;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.circlesSection;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.circlesSeparator))) != null) {
                    i = R.id.closeButton;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.createCircleButton;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.deckOptionsSection;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout3 != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.deckOptionsSeparator))) != null) {
                                i = R.id.privacyChevron;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView != null) {
                                    i = R.id.privacyDescription;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.privacyLabel;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R.id.privacySelectorContainer;
                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout4 != null) {
                                                i = R.id.profileOptionsSection;
                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout5 != null && (viewFindChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.profileOptionsSeparator))) != null) {
                                                    i = R.id.saveButton;
                                                    MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                                    if (materialButton2 != null) {
                                                        i = R.id.shareGamesSwitch;
                                                        SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, i);
                                                        if (switchCompat != null) {
                                                            i = R.id.shareProfileFriendCodeSwitch;
                                                            SwitchCompat switchCompat2 = (SwitchCompat) ViewBindings.findChildViewById(view, i);
                                                            if (switchCompat2 != null) {
                                                                i = R.id.shareProfileGamesSwitch;
                                                                SwitchCompat switchCompat3 = (SwitchCompat) ViewBindings.findChildViewById(view, i);
                                                                if (switchCompat3 != null) {
                                                                    i = R.id.shareProfileStatsSwitch;
                                                                    SwitchCompat switchCompat4 = (SwitchCompat) ViewBindings.findChildViewById(view, i);
                                                                    if (switchCompat4 != null) {
                                                                        i = R.id.shareStatsSwitch;
                                                                        SwitchCompat switchCompat5 = (SwitchCompat) ViewBindings.findChildViewById(view, i);
                                                                        if (switchCompat5 != null) {
                                                                            i = R.id.titleTextView;
                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView5 != null) {
                                                                                return new DialogPrivacySettingsBinding((LinearLayout) view, materialButton, linearLayout, linearLayout2, viewFindChildViewById, textView, textView2, linearLayout3, viewFindChildViewById2, imageView, textView3, textView4, linearLayout4, linearLayout5, viewFindChildViewById3, materialButton2, switchCompat, switchCompat2, switchCompat3, switchCompat4, switchCompat5, textView5);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DialogPrivacySettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogPrivacySettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_privacy_settings, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
