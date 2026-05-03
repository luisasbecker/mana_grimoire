package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.CachedImageView;
import com.studiolaganne.lengendarylens.NonInteractiveRecyclerView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentNewGameBinding implements ViewBinding {
    public final LinearLayout accountInfoVerticalLayout1;
    public final LinearLayout accountInfoVerticalLayout2;
    public final LinearLayout accountInfoVerticalLayout3;
    public final ImageView backImage;
    public final TextView backLabel;
    public final ConstraintLayout backLayout;
    public final LinearLayout backLinearLayout;
    public final View backgroundOverlay;
    public final ImageView createFromPlaygroupIcon;
    public final TextView createFromPlaygroupText;
    public final ImageView createGuestIcon;
    public final LinearLayout createWithGuestsInnerLayout;
    public final TextView createWithGuestsText;
    public final ImageView defaultProfileImage1;
    public final ImageView defaultProfileImage2;
    public final ImageView defaultProfileImage3;
    public final ImageView eventIcon;
    public final LinearLayout eventInnerLayout;
    public final ConstraintLayout eventLayout;
    public final TextView eventSubtitleText;
    public final TextView eventText;
    public final TextView eventsText;
    public final ImageView expandSetupIcon;
    public final ConstraintLayout favSetupLayout;
    public final ConstraintLayout favSetupLayout1;
    public final ConstraintLayout favSetupLayout2;
    public final ConstraintLayout favSetupLayout3;
    public final TextView favoriteSetupsText;
    public final TextView favoriteSetupsTextSubtitle;
    public final LinearLayout firstLayout1;
    public final LinearLayout firstLayout2;
    public final LinearLayout firstLayout3;
    public final ConstraintLayout fromPlaygroupLayout;
    public final LinearLayout nameAndPlaygroupLayout1;
    public final LinearLayout nameAndPlaygroupLayout2;
    public final LinearLayout nameAndPlaygroupLayout3;
    public final TextView newGameButtonText;
    public final TextView newGameHeader;
    public final ImageView newGameIcon;
    public final ConstraintLayout newGameLayout;
    public final TextView pickThemeTitle;
    public final TextView playgroupName1;
    public final TextView playgroupName2;
    public final TextView playgroupName3;
    public final CachedImageView profileImage1;
    public final CachedImageView profileImage2;
    public final CachedImageView profileImage3;
    public final ConstraintLayout profileLayout1;
    public final ConstraintLayout profileLayout2;
    public final ConstraintLayout profileLayout3;
    public final TextView questionText;
    private final ConstraintLayout rootView;
    public final LinearLayout secondLayout1;
    public final LinearLayout secondLayout2;
    public final LinearLayout secondLayout3;
    public final TextView setupName1;
    public final TextView setupName2;
    public final TextView setupName3;
    public final TextView setupSummary1;
    public final TextView setupSummary2;
    public final TextView setupSummary3;
    public final ImageView themeButton;
    public final View themeOverlay;
    public final ConstraintLayout themePickerLayout;
    public final TextView themeSelection;
    public final TextView themeTitle;
    public final RecyclerView themesRecyclerView;
    public final LinearLayout topLayout1;
    public final LinearLayout topLayout2;
    public final LinearLayout topLayout3;
    public final NonInteractiveRecyclerView usersRecyclerView1;
    public final NonInteractiveRecyclerView usersRecyclerView2;
    public final NonInteractiveRecyclerView usersRecyclerView3;
    public final ConstraintLayout withGuestsLayout;

    private FragmentNewGameBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, ImageView imageView, TextView textView, ConstraintLayout constraintLayout2, LinearLayout linearLayout4, View view, ImageView imageView2, TextView textView2, ImageView imageView3, LinearLayout linearLayout5, TextView textView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, LinearLayout linearLayout6, ConstraintLayout constraintLayout3, TextView textView4, TextView textView5, TextView textView6, ImageView imageView8, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7, TextView textView7, TextView textView8, LinearLayout linearLayout7, LinearLayout linearLayout8, LinearLayout linearLayout9, ConstraintLayout constraintLayout8, LinearLayout linearLayout10, LinearLayout linearLayout11, LinearLayout linearLayout12, TextView textView9, TextView textView10, ImageView imageView9, ConstraintLayout constraintLayout9, TextView textView11, TextView textView12, TextView textView13, TextView textView14, CachedImageView cachedImageView, CachedImageView cachedImageView2, CachedImageView cachedImageView3, ConstraintLayout constraintLayout10, ConstraintLayout constraintLayout11, ConstraintLayout constraintLayout12, TextView textView15, LinearLayout linearLayout13, LinearLayout linearLayout14, LinearLayout linearLayout15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, ImageView imageView10, View view2, ConstraintLayout constraintLayout13, TextView textView22, TextView textView23, RecyclerView recyclerView, LinearLayout linearLayout16, LinearLayout linearLayout17, LinearLayout linearLayout18, NonInteractiveRecyclerView nonInteractiveRecyclerView, NonInteractiveRecyclerView nonInteractiveRecyclerView2, NonInteractiveRecyclerView nonInteractiveRecyclerView3, ConstraintLayout constraintLayout14) {
        this.rootView = constraintLayout;
        this.accountInfoVerticalLayout1 = linearLayout;
        this.accountInfoVerticalLayout2 = linearLayout2;
        this.accountInfoVerticalLayout3 = linearLayout3;
        this.backImage = imageView;
        this.backLabel = textView;
        this.backLayout = constraintLayout2;
        this.backLinearLayout = linearLayout4;
        this.backgroundOverlay = view;
        this.createFromPlaygroupIcon = imageView2;
        this.createFromPlaygroupText = textView2;
        this.createGuestIcon = imageView3;
        this.createWithGuestsInnerLayout = linearLayout5;
        this.createWithGuestsText = textView3;
        this.defaultProfileImage1 = imageView4;
        this.defaultProfileImage2 = imageView5;
        this.defaultProfileImage3 = imageView6;
        this.eventIcon = imageView7;
        this.eventInnerLayout = linearLayout6;
        this.eventLayout = constraintLayout3;
        this.eventSubtitleText = textView4;
        this.eventText = textView5;
        this.eventsText = textView6;
        this.expandSetupIcon = imageView8;
        this.favSetupLayout = constraintLayout4;
        this.favSetupLayout1 = constraintLayout5;
        this.favSetupLayout2 = constraintLayout6;
        this.favSetupLayout3 = constraintLayout7;
        this.favoriteSetupsText = textView7;
        this.favoriteSetupsTextSubtitle = textView8;
        this.firstLayout1 = linearLayout7;
        this.firstLayout2 = linearLayout8;
        this.firstLayout3 = linearLayout9;
        this.fromPlaygroupLayout = constraintLayout8;
        this.nameAndPlaygroupLayout1 = linearLayout10;
        this.nameAndPlaygroupLayout2 = linearLayout11;
        this.nameAndPlaygroupLayout3 = linearLayout12;
        this.newGameButtonText = textView9;
        this.newGameHeader = textView10;
        this.newGameIcon = imageView9;
        this.newGameLayout = constraintLayout9;
        this.pickThemeTitle = textView11;
        this.playgroupName1 = textView12;
        this.playgroupName2 = textView13;
        this.playgroupName3 = textView14;
        this.profileImage1 = cachedImageView;
        this.profileImage2 = cachedImageView2;
        this.profileImage3 = cachedImageView3;
        this.profileLayout1 = constraintLayout10;
        this.profileLayout2 = constraintLayout11;
        this.profileLayout3 = constraintLayout12;
        this.questionText = textView15;
        this.secondLayout1 = linearLayout13;
        this.secondLayout2 = linearLayout14;
        this.secondLayout3 = linearLayout15;
        this.setupName1 = textView16;
        this.setupName2 = textView17;
        this.setupName3 = textView18;
        this.setupSummary1 = textView19;
        this.setupSummary2 = textView20;
        this.setupSummary3 = textView21;
        this.themeButton = imageView10;
        this.themeOverlay = view2;
        this.themePickerLayout = constraintLayout13;
        this.themeSelection = textView22;
        this.themeTitle = textView23;
        this.themesRecyclerView = recyclerView;
        this.topLayout1 = linearLayout16;
        this.topLayout2 = linearLayout17;
        this.topLayout3 = linearLayout18;
        this.usersRecyclerView1 = nonInteractiveRecyclerView;
        this.usersRecyclerView2 = nonInteractiveRecyclerView2;
        this.usersRecyclerView3 = nonInteractiveRecyclerView3;
        this.withGuestsLayout = constraintLayout14;
    }

    public static FragmentNewGameBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.accountInfoVerticalLayout1;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.accountInfoVerticalLayout2;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = R.id.accountInfoVerticalLayout3;
                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout3 != null) {
                    i = R.id.backImage;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.backLabel;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.backLayout;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout != null) {
                                i = R.id.backLinearLayout;
                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout4 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.backgroundOverlay))) != null) {
                                    i = R.id.createFromPlaygroupIcon;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView2 != null) {
                                        i = R.id.createFromPlaygroupText;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = R.id.createGuestIcon;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView3 != null) {
                                                i = R.id.createWithGuestsInnerLayout;
                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout5 != null) {
                                                    i = R.id.createWithGuestsText;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView3 != null) {
                                                        i = R.id.defaultProfileImage1;
                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView4 != null) {
                                                            i = R.id.defaultProfileImage2;
                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                            if (imageView5 != null) {
                                                                i = R.id.defaultProfileImage3;
                                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                if (imageView6 != null) {
                                                                    i = R.id.eventIcon;
                                                                    ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                    if (imageView7 != null) {
                                                                        i = R.id.eventInnerLayout;
                                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (linearLayout6 != null) {
                                                                            i = R.id.eventLayout;
                                                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (constraintLayout2 != null) {
                                                                                i = R.id.eventSubtitleText;
                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView4 != null) {
                                                                                    i = R.id.eventText;
                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView5 != null) {
                                                                                        i = R.id.events_text;
                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView6 != null) {
                                                                                            i = R.id.expandSetupIcon;
                                                                                            ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                            if (imageView8 != null) {
                                                                                                i = R.id.favSetupLayout;
                                                                                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                if (constraintLayout3 != null) {
                                                                                                    i = R.id.favSetupLayout1;
                                                                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                    if (constraintLayout4 != null) {
                                                                                                        i = R.id.favSetupLayout2;
                                                                                                        ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                        if (constraintLayout5 != null) {
                                                                                                            i = R.id.favSetupLayout3;
                                                                                                            ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                            if (constraintLayout6 != null) {
                                                                                                                i = R.id.favoriteSetupsText;
                                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView7 != null) {
                                                                                                                    i = R.id.favoriteSetupsTextSubtitle;
                                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView8 != null) {
                                                                                                                        i = R.id.firstLayout1;
                                                                                                                        LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (linearLayout7 != null) {
                                                                                                                            i = R.id.firstLayout2;
                                                                                                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (linearLayout8 != null) {
                                                                                                                                i = R.id.firstLayout3;
                                                                                                                                LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (linearLayout9 != null) {
                                                                                                                                    i = R.id.fromPlaygroupLayout;
                                                                                                                                    ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (constraintLayout7 != null) {
                                                                                                                                        i = R.id.nameAndPlaygroupLayout1;
                                                                                                                                        LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (linearLayout10 != null) {
                                                                                                                                            i = R.id.nameAndPlaygroupLayout2;
                                                                                                                                            LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (linearLayout11 != null) {
                                                                                                                                                i = R.id.nameAndPlaygroupLayout3;
                                                                                                                                                LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (linearLayout12 != null) {
                                                                                                                                                    i = R.id.newGameButtonText;
                                                                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (textView9 != null) {
                                                                                                                                                        i = R.id.newGameHeader;
                                                                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (textView10 != null) {
                                                                                                                                                            i = R.id.newGameIcon;
                                                                                                                                                            ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (imageView9 != null) {
                                                                                                                                                                i = R.id.newGameLayout;
                                                                                                                                                                ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (constraintLayout8 != null) {
                                                                                                                                                                    i = R.id.pickThemeTitle;
                                                                                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (textView11 != null) {
                                                                                                                                                                        i = R.id.playgroupName1;
                                                                                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                        if (textView12 != null) {
                                                                                                                                                                            i = R.id.playgroupName2;
                                                                                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                            if (textView13 != null) {
                                                                                                                                                                                i = R.id.playgroupName3;
                                                                                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                if (textView14 != null) {
                                                                                                                                                                                    i = R.id.profileImage1;
                                                                                                                                                                                    CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                    if (cachedImageView != null) {
                                                                                                                                                                                        i = R.id.profileImage2;
                                                                                                                                                                                        CachedImageView cachedImageView2 = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                        if (cachedImageView2 != null) {
                                                                                                                                                                                            i = R.id.profileImage3;
                                                                                                                                                                                            CachedImageView cachedImageView3 = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                            if (cachedImageView3 != null) {
                                                                                                                                                                                                i = R.id.profileLayout1;
                                                                                                                                                                                                ConstraintLayout constraintLayout9 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                if (constraintLayout9 != null) {
                                                                                                                                                                                                    i = R.id.profileLayout2;
                                                                                                                                                                                                    ConstraintLayout constraintLayout10 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                    if (constraintLayout10 != null) {
                                                                                                                                                                                                        i = R.id.profileLayout3;
                                                                                                                                                                                                        ConstraintLayout constraintLayout11 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                        if (constraintLayout11 != null) {
                                                                                                                                                                                                            i = R.id.question_text;
                                                                                                                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                            if (textView15 != null) {
                                                                                                                                                                                                                i = R.id.secondLayout1;
                                                                                                                                                                                                                LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                if (linearLayout13 != null) {
                                                                                                                                                                                                                    i = R.id.secondLayout2;
                                                                                                                                                                                                                    LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                    if (linearLayout14 != null) {
                                                                                                                                                                                                                        i = R.id.secondLayout3;
                                                                                                                                                                                                                        LinearLayout linearLayout15 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                        if (linearLayout15 != null) {
                                                                                                                                                                                                                            i = R.id.setupName1;
                                                                                                                                                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                            if (textView16 != null) {
                                                                                                                                                                                                                                i = R.id.setupName2;
                                                                                                                                                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                if (textView17 != null) {
                                                                                                                                                                                                                                    i = R.id.setupName3;
                                                                                                                                                                                                                                    TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                    if (textView18 != null) {
                                                                                                                                                                                                                                        i = R.id.setupSummary1;
                                                                                                                                                                                                                                        TextView textView19 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                        if (textView19 != null) {
                                                                                                                                                                                                                                            i = R.id.setupSummary2;
                                                                                                                                                                                                                                            TextView textView20 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                            if (textView20 != null) {
                                                                                                                                                                                                                                                i = R.id.setupSummary3;
                                                                                                                                                                                                                                                TextView textView21 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                if (textView21 != null) {
                                                                                                                                                                                                                                                    i = R.id.themeButton;
                                                                                                                                                                                                                                                    ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                    if (imageView10 != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.themeOverlay))) != null) {
                                                                                                                                                                                                                                                        i = R.id.themePickerLayout;
                                                                                                                                                                                                                                                        ConstraintLayout constraintLayout12 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                        if (constraintLayout12 != null) {
                                                                                                                                                                                                                                                            i = R.id.themeSelection;
                                                                                                                                                                                                                                                            TextView textView22 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                            if (textView22 != null) {
                                                                                                                                                                                                                                                                i = R.id.themeTitle;
                                                                                                                                                                                                                                                                TextView textView23 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                if (textView23 != null) {
                                                                                                                                                                                                                                                                    i = R.id.themesRecyclerView;
                                                                                                                                                                                                                                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                    if (recyclerView != null) {
                                                                                                                                                                                                                                                                        i = R.id.topLayout1;
                                                                                                                                                                                                                                                                        LinearLayout linearLayout16 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                        if (linearLayout16 != null) {
                                                                                                                                                                                                                                                                            i = R.id.topLayout2;
                                                                                                                                                                                                                                                                            LinearLayout linearLayout17 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                            if (linearLayout17 != null) {
                                                                                                                                                                                                                                                                                i = R.id.topLayout3;
                                                                                                                                                                                                                                                                                LinearLayout linearLayout18 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                if (linearLayout18 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.usersRecyclerView1;
                                                                                                                                                                                                                                                                                    NonInteractiveRecyclerView nonInteractiveRecyclerView = (NonInteractiveRecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                    if (nonInteractiveRecyclerView != null) {
                                                                                                                                                                                                                                                                                        i = R.id.usersRecyclerView2;
                                                                                                                                                                                                                                                                                        NonInteractiveRecyclerView nonInteractiveRecyclerView2 = (NonInteractiveRecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                        if (nonInteractiveRecyclerView2 != null) {
                                                                                                                                                                                                                                                                                            i = R.id.usersRecyclerView3;
                                                                                                                                                                                                                                                                                            NonInteractiveRecyclerView nonInteractiveRecyclerView3 = (NonInteractiveRecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                            if (nonInteractiveRecyclerView3 != null) {
                                                                                                                                                                                                                                                                                                i = R.id.withGuestsLayout;
                                                                                                                                                                                                                                                                                                ConstraintLayout constraintLayout13 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                if (constraintLayout13 != null) {
                                                                                                                                                                                                                                                                                                    return new FragmentNewGameBinding((ConstraintLayout) view, linearLayout, linearLayout2, linearLayout3, imageView, textView, constraintLayout, linearLayout4, viewFindChildViewById, imageView2, textView2, imageView3, linearLayout5, textView3, imageView4, imageView5, imageView6, imageView7, linearLayout6, constraintLayout2, textView4, textView5, textView6, imageView8, constraintLayout3, constraintLayout4, constraintLayout5, constraintLayout6, textView7, textView8, linearLayout7, linearLayout8, linearLayout9, constraintLayout7, linearLayout10, linearLayout11, linearLayout12, textView9, textView10, imageView9, constraintLayout8, textView11, textView12, textView13, textView14, cachedImageView, cachedImageView2, cachedImageView3, constraintLayout9, constraintLayout10, constraintLayout11, textView15, linearLayout13, linearLayout14, linearLayout15, textView16, textView17, textView18, textView19, textView20, textView21, imageView10, viewFindChildViewById2, constraintLayout12, textView22, textView23, recyclerView, linearLayout16, linearLayout17, linearLayout18, nonInteractiveRecyclerView, nonInteractiveRecyclerView2, nonInteractiveRecyclerView3, constraintLayout13);
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

    public static FragmentNewGameBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentNewGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_new_game, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
