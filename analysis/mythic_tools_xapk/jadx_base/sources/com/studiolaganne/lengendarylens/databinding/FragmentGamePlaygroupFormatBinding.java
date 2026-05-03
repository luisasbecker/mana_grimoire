package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.CachedImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentGamePlaygroupFormatBinding implements ViewBinding {
    public final LinearLayout accountInfoVerticalLayout;
    public final ImageView bestOfChevron;
    public final LinearLayout bestOfLayout;
    public final TextView bestOfTextView;
    public final LinearLayout bottomLayout;
    public final LinearLayout bottomRowFormatsLayout;
    public final ImageView closeFormatIcon;
    public final ConstraintLayout closeFormatLayout;
    public final ImageView defaultProfileImage;
    public final LinearLayout duelOptionsLayout;
    public final ConstraintLayout formatButton1;
    public final ConstraintLayout formatButton2;
    public final ConstraintLayout formatButton3;
    public final ConstraintLayout formatButton4;
    public final ConstraintLayout formatButton5;
    public final ConstraintLayout formatButton6;
    public final ImageView formatChevron;
    public final CachedImageView formatImage1;
    public final CachedImageView formatImage2;
    public final CachedImageView formatImage3;
    public final CachedImageView formatImage4;
    public final CachedImageView formatImage5;
    public final CachedImageView formatImage6;
    public final LinearLayout formatLayout;
    public final TextView formatName;
    public final TextView formatName1;
    public final TextView formatName2;
    public final TextView formatName3;
    public final TextView formatName4;
    public final TextView formatName5;
    public final TextView formatName6;
    public final TextView formatTextView;
    public final ConstraintLayout iconBubbleLayout;
    public final ConstraintLayout lifeTotalLayout;
    public final TextView lifeTotalTextView;
    public final LinearLayout middleRowFormatsLayout;
    public final ConstraintLayout nextButtonLayout;
    public final TextView nextButtonText;
    public final ImageView nextIcon;
    public final TextView overrideLifeTotalTextView;
    public final TextView pendingText;
    public final TextView pickThemeTitle;
    public final ConstraintLayout playgroundInfoLayout;
    public final ConstraintLayout playgroupGameLayout;
    public final ConstraintLayout playgroupInfoInnerLayout;
    public final TextView playgroupName;
    public final RecyclerView playgroupUsersRecyclerView;
    public final ConstraintLayout profileIcon;
    public final CachedImageView profileImage;
    public final LinearLayout rootFormatsLayout;
    private final ConstraintLayout rootView;
    public final TextView selectFormatText;
    public final ConstraintLayout selectedFormatButton;
    public final CachedImageView selectedFormatImage;
    public final ConstraintLayout selectedFormatLayout;
    public final TextView selectedFormatName;
    public final TextView streamingActiveToggleText;
    public final ImageView streamingHelpImage;
    public final LinearLayout streamingLayout;
    public final TextView streamingTitleText;
    public final ImageView subformatChevron;
    public final LinearLayout subformatLayout;
    public final TextView subformatTextView;
    public final ImageView themeButton;
    public final View themeOverlay;
    public final ConstraintLayout themePickerLayout;
    public final TextView themeSelection;
    public final TextView themeTitle;
    public final RecyclerView themesRecyclerView;
    public final TextView timerLabel;
    public final LinearLayout timerLayout;
    public final SwitchCompat timerSwitch;
    public final TextView timerTimeTextView;
    public final LinearLayout topRowFormatsLayout;
    public final TextView turnTimerActiveToggleText;
    public final ImageView turnTimerHelpImage;
    public final LinearLayout turnTimerLayout;
    public final TextView turnTimerTitleText;
    public final TextView usersCount;
    public final ImageView usersIcon;

    private FragmentGamePlaygroupFormatBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, TextView textView, LinearLayout linearLayout3, LinearLayout linearLayout4, ImageView imageView2, ConstraintLayout constraintLayout2, ImageView imageView3, LinearLayout linearLayout5, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7, ConstraintLayout constraintLayout8, ImageView imageView4, CachedImageView cachedImageView, CachedImageView cachedImageView2, CachedImageView cachedImageView3, CachedImageView cachedImageView4, CachedImageView cachedImageView5, CachedImageView cachedImageView6, LinearLayout linearLayout6, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10, TextView textView10, LinearLayout linearLayout7, ConstraintLayout constraintLayout11, TextView textView11, ImageView imageView5, TextView textView12, TextView textView13, TextView textView14, ConstraintLayout constraintLayout12, ConstraintLayout constraintLayout13, ConstraintLayout constraintLayout14, TextView textView15, RecyclerView recyclerView, ConstraintLayout constraintLayout15, CachedImageView cachedImageView7, LinearLayout linearLayout8, TextView textView16, ConstraintLayout constraintLayout16, CachedImageView cachedImageView8, ConstraintLayout constraintLayout17, TextView textView17, TextView textView18, ImageView imageView6, LinearLayout linearLayout9, TextView textView19, ImageView imageView7, LinearLayout linearLayout10, TextView textView20, ImageView imageView8, View view, ConstraintLayout constraintLayout18, TextView textView21, TextView textView22, RecyclerView recyclerView2, TextView textView23, LinearLayout linearLayout11, SwitchCompat switchCompat, TextView textView24, LinearLayout linearLayout12, TextView textView25, ImageView imageView9, LinearLayout linearLayout13, TextView textView26, TextView textView27, ImageView imageView10) {
        this.rootView = constraintLayout;
        this.accountInfoVerticalLayout = linearLayout;
        this.bestOfChevron = imageView;
        this.bestOfLayout = linearLayout2;
        this.bestOfTextView = textView;
        this.bottomLayout = linearLayout3;
        this.bottomRowFormatsLayout = linearLayout4;
        this.closeFormatIcon = imageView2;
        this.closeFormatLayout = constraintLayout2;
        this.defaultProfileImage = imageView3;
        this.duelOptionsLayout = linearLayout5;
        this.formatButton1 = constraintLayout3;
        this.formatButton2 = constraintLayout4;
        this.formatButton3 = constraintLayout5;
        this.formatButton4 = constraintLayout6;
        this.formatButton5 = constraintLayout7;
        this.formatButton6 = constraintLayout8;
        this.formatChevron = imageView4;
        this.formatImage1 = cachedImageView;
        this.formatImage2 = cachedImageView2;
        this.formatImage3 = cachedImageView3;
        this.formatImage4 = cachedImageView4;
        this.formatImage5 = cachedImageView5;
        this.formatImage6 = cachedImageView6;
        this.formatLayout = linearLayout6;
        this.formatName = textView2;
        this.formatName1 = textView3;
        this.formatName2 = textView4;
        this.formatName3 = textView5;
        this.formatName4 = textView6;
        this.formatName5 = textView7;
        this.formatName6 = textView8;
        this.formatTextView = textView9;
        this.iconBubbleLayout = constraintLayout9;
        this.lifeTotalLayout = constraintLayout10;
        this.lifeTotalTextView = textView10;
        this.middleRowFormatsLayout = linearLayout7;
        this.nextButtonLayout = constraintLayout11;
        this.nextButtonText = textView11;
        this.nextIcon = imageView5;
        this.overrideLifeTotalTextView = textView12;
        this.pendingText = textView13;
        this.pickThemeTitle = textView14;
        this.playgroundInfoLayout = constraintLayout12;
        this.playgroupGameLayout = constraintLayout13;
        this.playgroupInfoInnerLayout = constraintLayout14;
        this.playgroupName = textView15;
        this.playgroupUsersRecyclerView = recyclerView;
        this.profileIcon = constraintLayout15;
        this.profileImage = cachedImageView7;
        this.rootFormatsLayout = linearLayout8;
        this.selectFormatText = textView16;
        this.selectedFormatButton = constraintLayout16;
        this.selectedFormatImage = cachedImageView8;
        this.selectedFormatLayout = constraintLayout17;
        this.selectedFormatName = textView17;
        this.streamingActiveToggleText = textView18;
        this.streamingHelpImage = imageView6;
        this.streamingLayout = linearLayout9;
        this.streamingTitleText = textView19;
        this.subformatChevron = imageView7;
        this.subformatLayout = linearLayout10;
        this.subformatTextView = textView20;
        this.themeButton = imageView8;
        this.themeOverlay = view;
        this.themePickerLayout = constraintLayout18;
        this.themeSelection = textView21;
        this.themeTitle = textView22;
        this.themesRecyclerView = recyclerView2;
        this.timerLabel = textView23;
        this.timerLayout = linearLayout11;
        this.timerSwitch = switchCompat;
        this.timerTimeTextView = textView24;
        this.topRowFormatsLayout = linearLayout12;
        this.turnTimerActiveToggleText = textView25;
        this.turnTimerHelpImage = imageView9;
        this.turnTimerLayout = linearLayout13;
        this.turnTimerTitleText = textView26;
        this.usersCount = textView27;
        this.usersIcon = imageView10;
    }

    public static FragmentGamePlaygroupFormatBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.accountInfoVerticalLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.bestOfChevron;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.bestOfLayout;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout2 != null) {
                    i = R.id.bestOfTextView;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.bottomLayout;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout3 != null) {
                            i = R.id.bottomRowFormatsLayout;
                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout4 != null) {
                                i = R.id.closeFormatIcon;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView2 != null) {
                                    i = R.id.closeFormatLayout;
                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout != null) {
                                        i = R.id.defaultProfileImage;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView3 != null) {
                                            i = R.id.duelOptionsLayout;
                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout5 != null) {
                                                i = R.id.formatButton1;
                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                if (constraintLayout2 != null) {
                                                    i = R.id.formatButton2;
                                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                    if (constraintLayout3 != null) {
                                                        i = R.id.formatButton3;
                                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                        if (constraintLayout4 != null) {
                                                            i = R.id.formatButton4;
                                                            ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                            if (constraintLayout5 != null) {
                                                                i = R.id.formatButton5;
                                                                ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                if (constraintLayout6 != null) {
                                                                    i = R.id.formatButton6;
                                                                    ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (constraintLayout7 != null) {
                                                                        i = R.id.formatChevron;
                                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                        if (imageView4 != null) {
                                                                            i = R.id.formatImage1;
                                                                            CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                                            if (cachedImageView != null) {
                                                                                i = R.id.formatImage2;
                                                                                CachedImageView cachedImageView2 = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                                                if (cachedImageView2 != null) {
                                                                                    i = R.id.formatImage3;
                                                                                    CachedImageView cachedImageView3 = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                                                    if (cachedImageView3 != null) {
                                                                                        i = R.id.formatImage4;
                                                                                        CachedImageView cachedImageView4 = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                                                        if (cachedImageView4 != null) {
                                                                                            i = R.id.formatImage5;
                                                                                            CachedImageView cachedImageView5 = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                                                            if (cachedImageView5 != null) {
                                                                                                i = R.id.formatImage6;
                                                                                                CachedImageView cachedImageView6 = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                                                                if (cachedImageView6 != null) {
                                                                                                    i = R.id.formatLayout;
                                                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                    if (linearLayout6 != null) {
                                                                                                        i = R.id.formatName;
                                                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView2 != null) {
                                                                                                            i = R.id.formatName1;
                                                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView3 != null) {
                                                                                                                i = R.id.formatName2;
                                                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView4 != null) {
                                                                                                                    i = R.id.formatName3;
                                                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView5 != null) {
                                                                                                                        i = R.id.formatName4;
                                                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView6 != null) {
                                                                                                                            i = R.id.formatName5;
                                                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView7 != null) {
                                                                                                                                i = R.id.formatName6;
                                                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView8 != null) {
                                                                                                                                    i = R.id.formatTextView;
                                                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (textView9 != null) {
                                                                                                                                        i = R.id.iconBubbleLayout;
                                                                                                                                        ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (constraintLayout8 != null) {
                                                                                                                                            i = R.id.lifeTotalLayout;
                                                                                                                                            ConstraintLayout constraintLayout9 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (constraintLayout9 != null) {
                                                                                                                                                i = R.id.lifeTotalTextView;
                                                                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (textView10 != null) {
                                                                                                                                                    i = R.id.middleRowFormatsLayout;
                                                                                                                                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (linearLayout7 != null) {
                                                                                                                                                        i = R.id.nextButtonLayout;
                                                                                                                                                        ConstraintLayout constraintLayout10 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (constraintLayout10 != null) {
                                                                                                                                                            i = R.id.nextButtonText;
                                                                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (textView11 != null) {
                                                                                                                                                                i = R.id.nextIcon;
                                                                                                                                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (imageView5 != null) {
                                                                                                                                                                    i = R.id.overrideLifeTotalTextView;
                                                                                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (textView12 != null) {
                                                                                                                                                                        i = R.id.pendingText;
                                                                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                        if (textView13 != null) {
                                                                                                                                                                            i = R.id.pickThemeTitle;
                                                                                                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                            if (textView14 != null) {
                                                                                                                                                                                i = R.id.playgroundInfoLayout;
                                                                                                                                                                                ConstraintLayout constraintLayout11 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                if (constraintLayout11 != null) {
                                                                                                                                                                                    i = R.id.playgroupGameLayout;
                                                                                                                                                                                    ConstraintLayout constraintLayout12 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                    if (constraintLayout12 != null) {
                                                                                                                                                                                        i = R.id.playgroupInfoInnerLayout;
                                                                                                                                                                                        ConstraintLayout constraintLayout13 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                        if (constraintLayout13 != null) {
                                                                                                                                                                                            i = R.id.playgroupName;
                                                                                                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                            if (textView15 != null) {
                                                                                                                                                                                                i = R.id.playgroupUsersRecyclerView;
                                                                                                                                                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                if (recyclerView != null) {
                                                                                                                                                                                                    i = R.id.profileIcon;
                                                                                                                                                                                                    ConstraintLayout constraintLayout14 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                    if (constraintLayout14 != null) {
                                                                                                                                                                                                        i = R.id.profileImage;
                                                                                                                                                                                                        CachedImageView cachedImageView7 = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                        if (cachedImageView7 != null) {
                                                                                                                                                                                                            i = R.id.rootFormatsLayout;
                                                                                                                                                                                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                            if (linearLayout8 != null) {
                                                                                                                                                                                                                i = R.id.selectFormatText;
                                                                                                                                                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                if (textView16 != null) {
                                                                                                                                                                                                                    i = R.id.selectedFormatButton;
                                                                                                                                                                                                                    ConstraintLayout constraintLayout15 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                    if (constraintLayout15 != null) {
                                                                                                                                                                                                                        i = R.id.selectedFormatImage;
                                                                                                                                                                                                                        CachedImageView cachedImageView8 = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                        if (cachedImageView8 != null) {
                                                                                                                                                                                                                            i = R.id.selectedFormatLayout;
                                                                                                                                                                                                                            ConstraintLayout constraintLayout16 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                            if (constraintLayout16 != null) {
                                                                                                                                                                                                                                i = R.id.selectedFormatName;
                                                                                                                                                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                if (textView17 != null) {
                                                                                                                                                                                                                                    i = R.id.streamingActiveToggleText;
                                                                                                                                                                                                                                    TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                    if (textView18 != null) {
                                                                                                                                                                                                                                        i = R.id.streamingHelpImage;
                                                                                                                                                                                                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                        if (imageView6 != null) {
                                                                                                                                                                                                                                            i = R.id.streamingLayout;
                                                                                                                                                                                                                                            LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                            if (linearLayout9 != null) {
                                                                                                                                                                                                                                                i = R.id.streamingTitleText;
                                                                                                                                                                                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                if (textView19 != null) {
                                                                                                                                                                                                                                                    i = R.id.subformatChevron;
                                                                                                                                                                                                                                                    ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                    if (imageView7 != null) {
                                                                                                                                                                                                                                                        i = R.id.subformatLayout;
                                                                                                                                                                                                                                                        LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                        if (linearLayout10 != null) {
                                                                                                                                                                                                                                                            i = R.id.subformatTextView;
                                                                                                                                                                                                                                                            TextView textView20 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                            if (textView20 != null) {
                                                                                                                                                                                                                                                                i = R.id.themeButton;
                                                                                                                                                                                                                                                                ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                if (imageView8 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.themeOverlay))) != null) {
                                                                                                                                                                                                                                                                    i = R.id.themePickerLayout;
                                                                                                                                                                                                                                                                    ConstraintLayout constraintLayout17 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                    if (constraintLayout17 != null) {
                                                                                                                                                                                                                                                                        i = R.id.themeSelection;
                                                                                                                                                                                                                                                                        TextView textView21 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                        if (textView21 != null) {
                                                                                                                                                                                                                                                                            i = R.id.themeTitle;
                                                                                                                                                                                                                                                                            TextView textView22 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                            if (textView22 != null) {
                                                                                                                                                                                                                                                                                i = R.id.themesRecyclerView;
                                                                                                                                                                                                                                                                                RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                if (recyclerView2 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.timerLabel;
                                                                                                                                                                                                                                                                                    TextView textView23 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                    if (textView23 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.timerLayout;
                                                                                                                                                                                                                                                                                        LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                        if (linearLayout11 != null) {
                                                                                                                                                                                                                                                                                            i = R.id.timerSwitch;
                                                                                                                                                                                                                                                                                            SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                            if (switchCompat != null) {
                                                                                                                                                                                                                                                                                                i = R.id.timerTimeTextView;
                                                                                                                                                                                                                                                                                                TextView textView24 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                if (textView24 != null) {
                                                                                                                                                                                                                                                                                                    i = R.id.topRowFormatsLayout;
                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                    if (linearLayout12 != null) {
                                                                                                                                                                                                                                                                                                        i = R.id.turnTimerActiveToggleText;
                                                                                                                                                                                                                                                                                                        TextView textView25 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                        if (textView25 != null) {
                                                                                                                                                                                                                                                                                                            i = R.id.turnTimerHelpImage;
                                                                                                                                                                                                                                                                                                            ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                            if (imageView9 != null) {
                                                                                                                                                                                                                                                                                                                i = R.id.turnTimerLayout;
                                                                                                                                                                                                                                                                                                                LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                                if (linearLayout13 != null) {
                                                                                                                                                                                                                                                                                                                    i = R.id.turnTimerTitleText;
                                                                                                                                                                                                                                                                                                                    TextView textView26 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                                    if (textView26 != null) {
                                                                                                                                                                                                                                                                                                                        i = R.id.usersCount;
                                                                                                                                                                                                                                                                                                                        TextView textView27 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                                        if (textView27 != null) {
                                                                                                                                                                                                                                                                                                                            i = R.id.usersIcon;
                                                                                                                                                                                                                                                                                                                            ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                                            if (imageView10 != null) {
                                                                                                                                                                                                                                                                                                                                return new FragmentGamePlaygroupFormatBinding((ConstraintLayout) view, linearLayout, imageView, linearLayout2, textView, linearLayout3, linearLayout4, imageView2, constraintLayout, imageView3, linearLayout5, constraintLayout2, constraintLayout3, constraintLayout4, constraintLayout5, constraintLayout6, constraintLayout7, imageView4, cachedImageView, cachedImageView2, cachedImageView3, cachedImageView4, cachedImageView5, cachedImageView6, linearLayout6, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, constraintLayout8, constraintLayout9, textView10, linearLayout7, constraintLayout10, textView11, imageView5, textView12, textView13, textView14, constraintLayout11, constraintLayout12, constraintLayout13, textView15, recyclerView, constraintLayout14, cachedImageView7, linearLayout8, textView16, constraintLayout15, cachedImageView8, constraintLayout16, textView17, textView18, imageView6, linearLayout9, textView19, imageView7, linearLayout10, textView20, imageView8, viewFindChildViewById, constraintLayout17, textView21, textView22, recyclerView2, textView23, linearLayout11, switchCompat, textView24, linearLayout12, textView25, imageView9, linearLayout13, textView26, textView27, imageView10);
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
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentGamePlaygroupFormatBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentGamePlaygroupFormatBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_game_playgroup_format, viewGroup, false);
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
