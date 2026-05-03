package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.navigation.NavigationView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityRulesBinding implements ViewBinding {
    public final ConstraintLayout closeButton;
    public final MaterialButton copyButton;
    public final LinearLayout copyLayout;
    public final DrawerLayout drawerLayout;
    public final TextView effectiveDateTextView;
    public final EditText filterEditText;
    public final CardView flagContainer;
    public final ImageView flagImage;
    public final ImageView menuImage;
    public final NavigationView navView;
    public final ConstraintLayout rootLayout;
    private final DrawerLayout rootView;
    public final RecyclerView rulesRecyclerView;
    public final TextView searchButtonText;
    public final LinearLayout topLayout;

    private ActivityRulesBinding(DrawerLayout drawerLayout, ConstraintLayout constraintLayout, MaterialButton materialButton, LinearLayout linearLayout, DrawerLayout drawerLayout2, TextView textView, EditText editText, CardView cardView, ImageView imageView, ImageView imageView2, NavigationView navigationView, ConstraintLayout constraintLayout2, RecyclerView recyclerView, TextView textView2, LinearLayout linearLayout2) {
        this.rootView = drawerLayout;
        this.closeButton = constraintLayout;
        this.copyButton = materialButton;
        this.copyLayout = linearLayout;
        this.drawerLayout = drawerLayout2;
        this.effectiveDateTextView = textView;
        this.filterEditText = editText;
        this.flagContainer = cardView;
        this.flagImage = imageView;
        this.menuImage = imageView2;
        this.navView = navigationView;
        this.rootLayout = constraintLayout2;
        this.rulesRecyclerView = recyclerView;
        this.searchButtonText = textView2;
        this.topLayout = linearLayout2;
    }

    public static ActivityRulesBinding bind(View view) {
        int i = R.id.close_button;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.copy_button;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton != null) {
                i = R.id.copyLayout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    DrawerLayout drawerLayout = (DrawerLayout) view;
                    i = R.id.effectiveDateTextView;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.filterEditText;
                        EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                        if (editText != null) {
                            i = R.id.flag_container;
                            CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
                            if (cardView != null) {
                                i = R.id.flag_image;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView != null) {
                                    i = R.id.menuImage;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView2 != null) {
                                        i = R.id.nav_view;
                                        NavigationView navigationView = (NavigationView) ViewBindings.findChildViewById(view, i);
                                        if (navigationView != null) {
                                            i = R.id.root_layout;
                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                            if (constraintLayout2 != null) {
                                                i = R.id.rulesRecyclerView;
                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                if (recyclerView != null) {
                                                    i = R.id.searchButtonText;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView2 != null) {
                                                        i = R.id.topLayout;
                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout2 != null) {
                                                            return new ActivityRulesBinding(drawerLayout, constraintLayout, materialButton, linearLayout, drawerLayout, textView, editText, cardView, imageView, imageView2, navigationView, constraintLayout2, recyclerView, textView2, linearLayout2);
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

    public static ActivityRulesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityRulesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_rules, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public DrawerLayout getRoot() {
        return this.rootView;
    }
}
