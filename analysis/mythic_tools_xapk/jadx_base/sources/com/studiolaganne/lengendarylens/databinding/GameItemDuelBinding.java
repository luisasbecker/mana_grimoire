package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.flexbox.FlexboxLayout;
import com.studiolaganne.lengendarylens.CachedImageView;
import com.studiolaganne.lengendarylens.NonInteractiveRecyclerView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class GameItemDuelBinding implements ViewBinding {
    public final LinearLayout accountInfoVerticalLayout;
    public final ImageView bestOfChevron;
    public final TextView bestOfLabel;
    public final ConstraintLayout bottomLayout;
    public final ImageView defaultProfileImage;
    public final ImageView dotsImage;
    public final ConstraintLayout dotsLayout;
    public final LinearLayout firstLayout;
    public final LinearLayout game1InnerLayout;
    public final TextView game1Label;
    public final ConstraintLayout game1Layout;
    public final ConstraintLayout game1player1Layout;
    public final LinearLayout game1player1MainLayout;
    public final NonInteractiveRecyclerView game1player1RecyclerView;
    public final TextView game1player1WinnerHeaderLabel;
    public final ConstraintLayout game1player2Layout;
    public final LinearLayout game1player2MainLayout;
    public final NonInteractiveRecyclerView game1player2RecyclerView;
    public final TextView game1player2WinnerHeaderLabel;
    public final TextView game1playerSeparator;
    public final LinearLayout game2InnerLayout;
    public final TextView game2Label;
    public final ConstraintLayout game2Layout;
    public final ConstraintLayout game2layer1Layout;
    public final LinearLayout game2player1MainLayout;
    public final NonInteractiveRecyclerView game2player1RecyclerView;
    public final TextView game2player1WinnerHeaderLabel;
    public final ConstraintLayout game2player2Layout;
    public final LinearLayout game2player2MainLayout;
    public final NonInteractiveRecyclerView game2player2RecyclerView;
    public final TextView game2player2WinnerHeaderLabel;
    public final TextView game2playerSeparator;
    public final LinearLayout game3InnerLayout;
    public final TextView game3Label;
    public final ConstraintLayout game3Layout;
    public final ConstraintLayout game3player1Layout;
    public final LinearLayout game3player1MainLayout;
    public final NonInteractiveRecyclerView game3player1RecyclerView;
    public final TextView game3player1WinnerHeaderLabel;
    public final ConstraintLayout game3player2Layout;
    public final LinearLayout game3player2MainLayout;
    public final NonInteractiveRecyclerView game3player2RecyclerView;
    public final TextView game3player2WinnerHeaderLabel;
    public final TextView game3playerSeparator;
    public final LinearLayout game4InnerLayout;
    public final TextView game4Label;
    public final ConstraintLayout game4Layout;
    public final ConstraintLayout game4player1Layout;
    public final LinearLayout game4player1MainLayout;
    public final NonInteractiveRecyclerView game4player1RecyclerView;
    public final TextView game4player1WinnerHeaderLabel;
    public final ConstraintLayout game4player2Layout;
    public final LinearLayout game4player2MainLayout;
    public final NonInteractiveRecyclerView game4player2RecyclerView;
    public final TextView game4player2WinnerHeaderLabel;
    public final TextView game4playerSeparator;
    public final LinearLayout game5InnerLayout;
    public final TextView game5Label;
    public final ConstraintLayout game5Layout;
    public final ConstraintLayout game5player1Layout;
    public final LinearLayout game5player1MainLayout;
    public final NonInteractiveRecyclerView game5player1RecyclerView;
    public final TextView game5player1WinnerHeaderLabel;
    public final ConstraintLayout game5player2Layout;
    public final LinearLayout game5player2MainLayout;
    public final NonInteractiveRecyclerView game5player2RecyclerView;
    public final TextView game5player2WinnerHeaderLabel;
    public final TextView game5playerSeparator;
    public final TextView gameName;
    public final LinearLayout nameAndPlaygroupLayout;
    public final ImageView noteImage;
    public final TextView player1Label;
    public final ConstraintLayout player1Layout;
    public final LinearLayout player1MainLayout;
    public final NonInteractiveRecyclerView player1RecyclerView;
    public final TextView player1Score;
    public final TextView player1WinnerHeaderLabel;
    public final TextView player2Label;
    public final ConstraintLayout player2Layout;
    public final LinearLayout player2MainLayout;
    public final NonInteractiveRecyclerView player2RecyclerView;
    public final TextView player2Score;
    public final TextView player2WinnerHeaderLabel;
    public final TextView playerSeparator;
    public final ConstraintLayout playgroundInfoLayout;
    public final ConstraintLayout playgroupInfoInnerLayout;
    public final TextView playgroupName;
    public final CachedImageView profileImage;
    public final ConstraintLayout profileLayout;
    public final LinearLayout rightLayout;
    public final LinearLayout rootLayout;
    public final LinearLayout rootLinearLayout;
    private final LinearLayout rootView;
    public final LinearLayout scoreLayout;
    public final FlexboxLayout tagsFlexboxLayout;
    public final TextView timeLabel;
    public final LinearLayout topLayout;
    public final TextView victoryLabel;

    private GameItemDuelBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, TextView textView, ConstraintLayout constraintLayout, ImageView imageView2, ImageView imageView3, ConstraintLayout constraintLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, LinearLayout linearLayout5, NonInteractiveRecyclerView nonInteractiveRecyclerView, TextView textView3, ConstraintLayout constraintLayout5, LinearLayout linearLayout6, NonInteractiveRecyclerView nonInteractiveRecyclerView2, TextView textView4, TextView textView5, LinearLayout linearLayout7, TextView textView6, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7, LinearLayout linearLayout8, NonInteractiveRecyclerView nonInteractiveRecyclerView3, TextView textView7, ConstraintLayout constraintLayout8, LinearLayout linearLayout9, NonInteractiveRecyclerView nonInteractiveRecyclerView4, TextView textView8, TextView textView9, LinearLayout linearLayout10, TextView textView10, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10, LinearLayout linearLayout11, NonInteractiveRecyclerView nonInteractiveRecyclerView5, TextView textView11, ConstraintLayout constraintLayout11, LinearLayout linearLayout12, NonInteractiveRecyclerView nonInteractiveRecyclerView6, TextView textView12, TextView textView13, LinearLayout linearLayout13, TextView textView14, ConstraintLayout constraintLayout12, ConstraintLayout constraintLayout13, LinearLayout linearLayout14, NonInteractiveRecyclerView nonInteractiveRecyclerView7, TextView textView15, ConstraintLayout constraintLayout14, LinearLayout linearLayout15, NonInteractiveRecyclerView nonInteractiveRecyclerView8, TextView textView16, TextView textView17, LinearLayout linearLayout16, TextView textView18, ConstraintLayout constraintLayout15, ConstraintLayout constraintLayout16, LinearLayout linearLayout17, NonInteractiveRecyclerView nonInteractiveRecyclerView9, TextView textView19, ConstraintLayout constraintLayout17, LinearLayout linearLayout18, NonInteractiveRecyclerView nonInteractiveRecyclerView10, TextView textView20, TextView textView21, TextView textView22, LinearLayout linearLayout19, ImageView imageView4, TextView textView23, ConstraintLayout constraintLayout18, LinearLayout linearLayout20, NonInteractiveRecyclerView nonInteractiveRecyclerView11, TextView textView24, TextView textView25, TextView textView26, ConstraintLayout constraintLayout19, LinearLayout linearLayout21, NonInteractiveRecyclerView nonInteractiveRecyclerView12, TextView textView27, TextView textView28, TextView textView29, ConstraintLayout constraintLayout20, ConstraintLayout constraintLayout21, TextView textView30, CachedImageView cachedImageView, ConstraintLayout constraintLayout22, LinearLayout linearLayout22, LinearLayout linearLayout23, LinearLayout linearLayout24, LinearLayout linearLayout25, FlexboxLayout flexboxLayout, TextView textView31, LinearLayout linearLayout26, TextView textView32) {
        this.rootView = linearLayout;
        this.accountInfoVerticalLayout = linearLayout2;
        this.bestOfChevron = imageView;
        this.bestOfLabel = textView;
        this.bottomLayout = constraintLayout;
        this.defaultProfileImage = imageView2;
        this.dotsImage = imageView3;
        this.dotsLayout = constraintLayout2;
        this.firstLayout = linearLayout3;
        this.game1InnerLayout = linearLayout4;
        this.game1Label = textView2;
        this.game1Layout = constraintLayout3;
        this.game1player1Layout = constraintLayout4;
        this.game1player1MainLayout = linearLayout5;
        this.game1player1RecyclerView = nonInteractiveRecyclerView;
        this.game1player1WinnerHeaderLabel = textView3;
        this.game1player2Layout = constraintLayout5;
        this.game1player2MainLayout = linearLayout6;
        this.game1player2RecyclerView = nonInteractiveRecyclerView2;
        this.game1player2WinnerHeaderLabel = textView4;
        this.game1playerSeparator = textView5;
        this.game2InnerLayout = linearLayout7;
        this.game2Label = textView6;
        this.game2Layout = constraintLayout6;
        this.game2layer1Layout = constraintLayout7;
        this.game2player1MainLayout = linearLayout8;
        this.game2player1RecyclerView = nonInteractiveRecyclerView3;
        this.game2player1WinnerHeaderLabel = textView7;
        this.game2player2Layout = constraintLayout8;
        this.game2player2MainLayout = linearLayout9;
        this.game2player2RecyclerView = nonInteractiveRecyclerView4;
        this.game2player2WinnerHeaderLabel = textView8;
        this.game2playerSeparator = textView9;
        this.game3InnerLayout = linearLayout10;
        this.game3Label = textView10;
        this.game3Layout = constraintLayout9;
        this.game3player1Layout = constraintLayout10;
        this.game3player1MainLayout = linearLayout11;
        this.game3player1RecyclerView = nonInteractiveRecyclerView5;
        this.game3player1WinnerHeaderLabel = textView11;
        this.game3player2Layout = constraintLayout11;
        this.game3player2MainLayout = linearLayout12;
        this.game3player2RecyclerView = nonInteractiveRecyclerView6;
        this.game3player2WinnerHeaderLabel = textView12;
        this.game3playerSeparator = textView13;
        this.game4InnerLayout = linearLayout13;
        this.game4Label = textView14;
        this.game4Layout = constraintLayout12;
        this.game4player1Layout = constraintLayout13;
        this.game4player1MainLayout = linearLayout14;
        this.game4player1RecyclerView = nonInteractiveRecyclerView7;
        this.game4player1WinnerHeaderLabel = textView15;
        this.game4player2Layout = constraintLayout14;
        this.game4player2MainLayout = linearLayout15;
        this.game4player2RecyclerView = nonInteractiveRecyclerView8;
        this.game4player2WinnerHeaderLabel = textView16;
        this.game4playerSeparator = textView17;
        this.game5InnerLayout = linearLayout16;
        this.game5Label = textView18;
        this.game5Layout = constraintLayout15;
        this.game5player1Layout = constraintLayout16;
        this.game5player1MainLayout = linearLayout17;
        this.game5player1RecyclerView = nonInteractiveRecyclerView9;
        this.game5player1WinnerHeaderLabel = textView19;
        this.game5player2Layout = constraintLayout17;
        this.game5player2MainLayout = linearLayout18;
        this.game5player2RecyclerView = nonInteractiveRecyclerView10;
        this.game5player2WinnerHeaderLabel = textView20;
        this.game5playerSeparator = textView21;
        this.gameName = textView22;
        this.nameAndPlaygroupLayout = linearLayout19;
        this.noteImage = imageView4;
        this.player1Label = textView23;
        this.player1Layout = constraintLayout18;
        this.player1MainLayout = linearLayout20;
        this.player1RecyclerView = nonInteractiveRecyclerView11;
        this.player1Score = textView24;
        this.player1WinnerHeaderLabel = textView25;
        this.player2Label = textView26;
        this.player2Layout = constraintLayout19;
        this.player2MainLayout = linearLayout21;
        this.player2RecyclerView = nonInteractiveRecyclerView12;
        this.player2Score = textView27;
        this.player2WinnerHeaderLabel = textView28;
        this.playerSeparator = textView29;
        this.playgroundInfoLayout = constraintLayout20;
        this.playgroupInfoInnerLayout = constraintLayout21;
        this.playgroupName = textView30;
        this.profileImage = cachedImageView;
        this.profileLayout = constraintLayout22;
        this.rightLayout = linearLayout22;
        this.rootLayout = linearLayout23;
        this.rootLinearLayout = linearLayout24;
        this.scoreLayout = linearLayout25;
        this.tagsFlexboxLayout = flexboxLayout;
        this.timeLabel = textView31;
        this.topLayout = linearLayout26;
        this.victoryLabel = textView32;
    }

    public static GameItemDuelBinding bind(View view) {
        int i = R.id.accountInfoVerticalLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.bestOfChevron;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.bestOfLabel;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.bottomLayout;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        i = R.id.defaultProfileImage;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.dotsImage;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView3 != null) {
                                i = R.id.dotsLayout;
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout2 != null) {
                                    i = R.id.firstLayout;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout2 != null) {
                                        i = R.id.game1InnerLayout;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout3 != null) {
                                            i = R.id.game1Label;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView2 != null) {
                                                i = R.id.game1Layout;
                                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                if (constraintLayout3 != null) {
                                                    i = R.id.game1player1Layout;
                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                    if (constraintLayout4 != null) {
                                                        i = R.id.game1player1MainLayout;
                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout4 != null) {
                                                            i = R.id.game1player1RecyclerView;
                                                            NonInteractiveRecyclerView nonInteractiveRecyclerView = (NonInteractiveRecyclerView) ViewBindings.findChildViewById(view, i);
                                                            if (nonInteractiveRecyclerView != null) {
                                                                i = R.id.game1player1WinnerHeaderLabel;
                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView3 != null) {
                                                                    i = R.id.game1player2Layout;
                                                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (constraintLayout5 != null) {
                                                                        i = R.id.game1player2MainLayout;
                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (linearLayout5 != null) {
                                                                            i = R.id.game1player2RecyclerView;
                                                                            NonInteractiveRecyclerView nonInteractiveRecyclerView2 = (NonInteractiveRecyclerView) ViewBindings.findChildViewById(view, i);
                                                                            if (nonInteractiveRecyclerView2 != null) {
                                                                                i = R.id.game1player2WinnerHeaderLabel;
                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView4 != null) {
                                                                                    i = R.id.game1playerSeparator;
                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView5 != null) {
                                                                                        i = R.id.game2InnerLayout;
                                                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (linearLayout6 != null) {
                                                                                            i = R.id.game2Label;
                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView6 != null) {
                                                                                                i = R.id.game2Layout;
                                                                                                ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                if (constraintLayout6 != null) {
                                                                                                    i = R.id.game2layer1Layout;
                                                                                                    ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                    if (constraintLayout7 != null) {
                                                                                                        i = R.id.game2player1MainLayout;
                                                                                                        LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                        if (linearLayout7 != null) {
                                                                                                            i = R.id.game2player1RecyclerView;
                                                                                                            NonInteractiveRecyclerView nonInteractiveRecyclerView3 = (NonInteractiveRecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (nonInteractiveRecyclerView3 != null) {
                                                                                                                i = R.id.game2player1WinnerHeaderLabel;
                                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView7 != null) {
                                                                                                                    i = R.id.game2player2Layout;
                                                                                                                    ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (constraintLayout8 != null) {
                                                                                                                        i = R.id.game2player2MainLayout;
                                                                                                                        LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (linearLayout8 != null) {
                                                                                                                            i = R.id.game2player2RecyclerView;
                                                                                                                            NonInteractiveRecyclerView nonInteractiveRecyclerView4 = (NonInteractiveRecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (nonInteractiveRecyclerView4 != null) {
                                                                                                                                i = R.id.game2player2WinnerHeaderLabel;
                                                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView8 != null) {
                                                                                                                                    i = R.id.game2playerSeparator;
                                                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (textView9 != null) {
                                                                                                                                        i = R.id.game3InnerLayout;
                                                                                                                                        LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (linearLayout9 != null) {
                                                                                                                                            i = R.id.game3Label;
                                                                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (textView10 != null) {
                                                                                                                                                i = R.id.game3Layout;
                                                                                                                                                ConstraintLayout constraintLayout9 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (constraintLayout9 != null) {
                                                                                                                                                    i = R.id.game3player1Layout;
                                                                                                                                                    ConstraintLayout constraintLayout10 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (constraintLayout10 != null) {
                                                                                                                                                        i = R.id.game3player1MainLayout;
                                                                                                                                                        LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (linearLayout10 != null) {
                                                                                                                                                            i = R.id.game3player1RecyclerView;
                                                                                                                                                            NonInteractiveRecyclerView nonInteractiveRecyclerView5 = (NonInteractiveRecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (nonInteractiveRecyclerView5 != null) {
                                                                                                                                                                i = R.id.game3player1WinnerHeaderLabel;
                                                                                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (textView11 != null) {
                                                                                                                                                                    i = R.id.game3player2Layout;
                                                                                                                                                                    ConstraintLayout constraintLayout11 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (constraintLayout11 != null) {
                                                                                                                                                                        i = R.id.game3player2MainLayout;
                                                                                                                                                                        LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                        if (linearLayout11 != null) {
                                                                                                                                                                            i = R.id.game3player2RecyclerView;
                                                                                                                                                                            NonInteractiveRecyclerView nonInteractiveRecyclerView6 = (NonInteractiveRecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                            if (nonInteractiveRecyclerView6 != null) {
                                                                                                                                                                                i = R.id.game3player2WinnerHeaderLabel;
                                                                                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                if (textView12 != null) {
                                                                                                                                                                                    i = R.id.game3playerSeparator;
                                                                                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                    if (textView13 != null) {
                                                                                                                                                                                        i = R.id.game4InnerLayout;
                                                                                                                                                                                        LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                        if (linearLayout12 != null) {
                                                                                                                                                                                            i = R.id.game4Label;
                                                                                                                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                            if (textView14 != null) {
                                                                                                                                                                                                i = R.id.game4Layout;
                                                                                                                                                                                                ConstraintLayout constraintLayout12 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                if (constraintLayout12 != null) {
                                                                                                                                                                                                    i = R.id.game4player1Layout;
                                                                                                                                                                                                    ConstraintLayout constraintLayout13 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                    if (constraintLayout13 != null) {
                                                                                                                                                                                                        i = R.id.game4player1MainLayout;
                                                                                                                                                                                                        LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                        if (linearLayout13 != null) {
                                                                                                                                                                                                            i = R.id.game4player1RecyclerView;
                                                                                                                                                                                                            NonInteractiveRecyclerView nonInteractiveRecyclerView7 = (NonInteractiveRecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                            if (nonInteractiveRecyclerView7 != null) {
                                                                                                                                                                                                                i = R.id.game4player1WinnerHeaderLabel;
                                                                                                                                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                if (textView15 != null) {
                                                                                                                                                                                                                    i = R.id.game4player2Layout;
                                                                                                                                                                                                                    ConstraintLayout constraintLayout14 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                    if (constraintLayout14 != null) {
                                                                                                                                                                                                                        i = R.id.game4player2MainLayout;
                                                                                                                                                                                                                        LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                        if (linearLayout14 != null) {
                                                                                                                                                                                                                            i = R.id.game4player2RecyclerView;
                                                                                                                                                                                                                            NonInteractiveRecyclerView nonInteractiveRecyclerView8 = (NonInteractiveRecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                            if (nonInteractiveRecyclerView8 != null) {
                                                                                                                                                                                                                                i = R.id.game4player2WinnerHeaderLabel;
                                                                                                                                                                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                if (textView16 != null) {
                                                                                                                                                                                                                                    i = R.id.game4playerSeparator;
                                                                                                                                                                                                                                    TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                    if (textView17 != null) {
                                                                                                                                                                                                                                        i = R.id.game5InnerLayout;
                                                                                                                                                                                                                                        LinearLayout linearLayout15 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                        if (linearLayout15 != null) {
                                                                                                                                                                                                                                            i = R.id.game5Label;
                                                                                                                                                                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                            if (textView18 != null) {
                                                                                                                                                                                                                                                i = R.id.game5Layout;
                                                                                                                                                                                                                                                ConstraintLayout constraintLayout15 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                if (constraintLayout15 != null) {
                                                                                                                                                                                                                                                    i = R.id.game5player1Layout;
                                                                                                                                                                                                                                                    ConstraintLayout constraintLayout16 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                    if (constraintLayout16 != null) {
                                                                                                                                                                                                                                                        i = R.id.game5player1MainLayout;
                                                                                                                                                                                                                                                        LinearLayout linearLayout16 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                        if (linearLayout16 != null) {
                                                                                                                                                                                                                                                            i = R.id.game5player1RecyclerView;
                                                                                                                                                                                                                                                            NonInteractiveRecyclerView nonInteractiveRecyclerView9 = (NonInteractiveRecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                            if (nonInteractiveRecyclerView9 != null) {
                                                                                                                                                                                                                                                                i = R.id.game5player1WinnerHeaderLabel;
                                                                                                                                                                                                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                if (textView19 != null) {
                                                                                                                                                                                                                                                                    i = R.id.game5player2Layout;
                                                                                                                                                                                                                                                                    ConstraintLayout constraintLayout17 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                    if (constraintLayout17 != null) {
                                                                                                                                                                                                                                                                        i = R.id.game5player2MainLayout;
                                                                                                                                                                                                                                                                        LinearLayout linearLayout17 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                        if (linearLayout17 != null) {
                                                                                                                                                                                                                                                                            i = R.id.game5player2RecyclerView;
                                                                                                                                                                                                                                                                            NonInteractiveRecyclerView nonInteractiveRecyclerView10 = (NonInteractiveRecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                            if (nonInteractiveRecyclerView10 != null) {
                                                                                                                                                                                                                                                                                i = R.id.game5player2WinnerHeaderLabel;
                                                                                                                                                                                                                                                                                TextView textView20 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                if (textView20 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.game5playerSeparator;
                                                                                                                                                                                                                                                                                    TextView textView21 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                    if (textView21 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.gameName;
                                                                                                                                                                                                                                                                                        TextView textView22 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                        if (textView22 != null) {
                                                                                                                                                                                                                                                                                            i = R.id.nameAndPlaygroupLayout;
                                                                                                                                                                                                                                                                                            LinearLayout linearLayout18 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                            if (linearLayout18 != null) {
                                                                                                                                                                                                                                                                                                i = R.id.noteImage;
                                                                                                                                                                                                                                                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                if (imageView4 != null) {
                                                                                                                                                                                                                                                                                                    i = R.id.player1Label;
                                                                                                                                                                                                                                                                                                    TextView textView23 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                    if (textView23 != null) {
                                                                                                                                                                                                                                                                                                        i = R.id.player1Layout;
                                                                                                                                                                                                                                                                                                        ConstraintLayout constraintLayout18 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                        if (constraintLayout18 != null) {
                                                                                                                                                                                                                                                                                                            i = R.id.player1MainLayout;
                                                                                                                                                                                                                                                                                                            LinearLayout linearLayout19 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                            if (linearLayout19 != null) {
                                                                                                                                                                                                                                                                                                                i = R.id.player1RecyclerView;
                                                                                                                                                                                                                                                                                                                NonInteractiveRecyclerView nonInteractiveRecyclerView11 = (NonInteractiveRecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                                if (nonInteractiveRecyclerView11 != null) {
                                                                                                                                                                                                                                                                                                                    i = R.id.player1Score;
                                                                                                                                                                                                                                                                                                                    TextView textView24 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                                    if (textView24 != null) {
                                                                                                                                                                                                                                                                                                                        i = R.id.player1WinnerHeaderLabel;
                                                                                                                                                                                                                                                                                                                        TextView textView25 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                                        if (textView25 != null) {
                                                                                                                                                                                                                                                                                                                            i = R.id.player2Label;
                                                                                                                                                                                                                                                                                                                            TextView textView26 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                                            if (textView26 != null) {
                                                                                                                                                                                                                                                                                                                                i = R.id.player2Layout;
                                                                                                                                                                                                                                                                                                                                ConstraintLayout constraintLayout19 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                                                if (constraintLayout19 != null) {
                                                                                                                                                                                                                                                                                                                                    i = R.id.player2MainLayout;
                                                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout20 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                                                    if (linearLayout20 != null) {
                                                                                                                                                                                                                                                                                                                                        i = R.id.player2RecyclerView;
                                                                                                                                                                                                                                                                                                                                        NonInteractiveRecyclerView nonInteractiveRecyclerView12 = (NonInteractiveRecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                                                        if (nonInteractiveRecyclerView12 != null) {
                                                                                                                                                                                                                                                                                                                                            i = R.id.player2Score;
                                                                                                                                                                                                                                                                                                                                            TextView textView27 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                                                            if (textView27 != null) {
                                                                                                                                                                                                                                                                                                                                                i = R.id.player2WinnerHeaderLabel;
                                                                                                                                                                                                                                                                                                                                                TextView textView28 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                                                                if (textView28 != null) {
                                                                                                                                                                                                                                                                                                                                                    i = R.id.playerSeparator;
                                                                                                                                                                                                                                                                                                                                                    TextView textView29 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                                                                    if (textView29 != null) {
                                                                                                                                                                                                                                                                                                                                                        i = R.id.playgroundInfoLayout;
                                                                                                                                                                                                                                                                                                                                                        ConstraintLayout constraintLayout20 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                                                                        if (constraintLayout20 != null) {
                                                                                                                                                                                                                                                                                                                                                            i = R.id.playgroupInfoInnerLayout;
                                                                                                                                                                                                                                                                                                                                                            ConstraintLayout constraintLayout21 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                                                                            if (constraintLayout21 != null) {
                                                                                                                                                                                                                                                                                                                                                                i = R.id.playgroupName;
                                                                                                                                                                                                                                                                                                                                                                TextView textView30 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                                                                                if (textView30 != null) {
                                                                                                                                                                                                                                                                                                                                                                    i = R.id.profileImage;
                                                                                                                                                                                                                                                                                                                                                                    CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                                                                                    if (cachedImageView != null) {
                                                                                                                                                                                                                                                                                                                                                                        i = R.id.profileLayout;
                                                                                                                                                                                                                                                                                                                                                                        ConstraintLayout constraintLayout22 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                                                                                        if (constraintLayout22 != null) {
                                                                                                                                                                                                                                                                                                                                                                            i = R.id.rightLayout;
                                                                                                                                                                                                                                                                                                                                                                            LinearLayout linearLayout21 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                                                                                            if (linearLayout21 != null) {
                                                                                                                                                                                                                                                                                                                                                                                i = R.id.root_layout;
                                                                                                                                                                                                                                                                                                                                                                                LinearLayout linearLayout22 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                                                                                                if (linearLayout22 != null) {
                                                                                                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout23 = (LinearLayout) view;
                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.scoreLayout;
                                                                                                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout24 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                                                                                                    if (linearLayout24 != null) {
                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.tagsFlexboxLayout;
                                                                                                                                                                                                                                                                                                                                                                                        FlexboxLayout flexboxLayout = (FlexboxLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                                                                                                        if (flexboxLayout != null) {
                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.timeLabel;
                                                                                                                                                                                                                                                                                                                                                                                            TextView textView31 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                                                                                                            if (textView31 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.topLayout;
                                                                                                                                                                                                                                                                                                                                                                                                LinearLayout linearLayout25 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                                                                                                                if (linearLayout25 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.victoryLabel;
                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView32 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                                                                                                                    if (textView32 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                        return new GameItemDuelBinding(linearLayout23, linearLayout, imageView, textView, constraintLayout, imageView2, imageView3, constraintLayout2, linearLayout2, linearLayout3, textView2, constraintLayout3, constraintLayout4, linearLayout4, nonInteractiveRecyclerView, textView3, constraintLayout5, linearLayout5, nonInteractiveRecyclerView2, textView4, textView5, linearLayout6, textView6, constraintLayout6, constraintLayout7, linearLayout7, nonInteractiveRecyclerView3, textView7, constraintLayout8, linearLayout8, nonInteractiveRecyclerView4, textView8, textView9, linearLayout9, textView10, constraintLayout9, constraintLayout10, linearLayout10, nonInteractiveRecyclerView5, textView11, constraintLayout11, linearLayout11, nonInteractiveRecyclerView6, textView12, textView13, linearLayout12, textView14, constraintLayout12, constraintLayout13, linearLayout13, nonInteractiveRecyclerView7, textView15, constraintLayout14, linearLayout14, nonInteractiveRecyclerView8, textView16, textView17, linearLayout15, textView18, constraintLayout15, constraintLayout16, linearLayout16, nonInteractiveRecyclerView9, textView19, constraintLayout17, linearLayout17, nonInteractiveRecyclerView10, textView20, textView21, textView22, linearLayout18, imageView4, textView23, constraintLayout18, linearLayout19, nonInteractiveRecyclerView11, textView24, textView25, textView26, constraintLayout19, linearLayout20, nonInteractiveRecyclerView12, textView27, textView28, textView29, constraintLayout20, constraintLayout21, textView30, cachedImageView, constraintLayout22, linearLayout21, linearLayout22, linearLayout23, linearLayout24, flexboxLayout, textView31, linearLayout25, textView32);
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

    public static GameItemDuelBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GameItemDuelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.game_item_duel, viewGroup, false);
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
