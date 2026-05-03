package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import com.studiolaganne.lengendarylens.NonInteractiveRecyclerView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityGameDetailsBinding implements ViewBinding {
    public final ImageView addTagIcon;
    public final ConstraintLayout addTagLayout;
    public final ImageView arrowIcon;
    public final ConstraintLayout arrowLayout;
    public final ImageView backArrow;
    public final ConstraintLayout backLayout;
    public final LinearLayout buttonsLayout;
    public final MaterialButton cancelNoteButton;
    public final TextView connectingTextView;
    public final ImageView deleteIcon;
    public final ConstraintLayout deleteNoteLayout;
    public final LinearLayout detailsLayout;
    public final TextView durationLabel;
    public final ImageView emptyTagIcon;
    public final TextView gameNameLabel;
    public final TextView gameSummaryLabel;
    public final ConstraintLayout infoLayout;
    public final LinearLayout leftLayout;
    public final LinearLayoutCompat linearLayout;
    public final LottieAnimationView loadingAnimationView;
    public final ConstraintLayout mtApiOverlay;
    public final LinearLayout noteContentLayout;
    public final LinearLayout noteEditLayout;
    public final EditText noteEditText;
    public final ImageView noteIcon;
    public final LinearLayout noteLayout;
    public final TextView noteText;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final MaterialButton saveNoteButton;
    public final View separator;
    public final TabLayout tabs;
    public final LinearLayout tagsAndNotesLayout;
    public final FlexboxLayout tagsFlexboxLayout;
    public final LinearLayout tagsLayout;
    public final TextView victoryLabel;
    public final ViewPager2 viewPager;
    public final LinearLayout winnerLayout;
    public final TextView winnerNamesLabel;
    public final TextView winnersHeaderLabel;
    public final ConstraintLayout winnersLayout;
    public final NonInteractiveRecyclerView winnersRecyclerView;

    private ActivityGameDetailsBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, ImageView imageView2, ConstraintLayout constraintLayout3, ImageView imageView3, ConstraintLayout constraintLayout4, LinearLayout linearLayout, MaterialButton materialButton, TextView textView, ImageView imageView4, ConstraintLayout constraintLayout5, LinearLayout linearLayout2, TextView textView2, ImageView imageView5, TextView textView3, TextView textView4, ConstraintLayout constraintLayout6, LinearLayout linearLayout3, LinearLayoutCompat linearLayoutCompat, LottieAnimationView lottieAnimationView, ConstraintLayout constraintLayout7, LinearLayout linearLayout4, LinearLayout linearLayout5, EditText editText, ImageView imageView6, LinearLayout linearLayout6, TextView textView5, ConstraintLayout constraintLayout8, MaterialButton materialButton2, View view, TabLayout tabLayout, LinearLayout linearLayout7, FlexboxLayout flexboxLayout, LinearLayout linearLayout8, TextView textView6, ViewPager2 viewPager2, LinearLayout linearLayout9, TextView textView7, TextView textView8, ConstraintLayout constraintLayout9, NonInteractiveRecyclerView nonInteractiveRecyclerView) {
        this.rootView = constraintLayout;
        this.addTagIcon = imageView;
        this.addTagLayout = constraintLayout2;
        this.arrowIcon = imageView2;
        this.arrowLayout = constraintLayout3;
        this.backArrow = imageView3;
        this.backLayout = constraintLayout4;
        this.buttonsLayout = linearLayout;
        this.cancelNoteButton = materialButton;
        this.connectingTextView = textView;
        this.deleteIcon = imageView4;
        this.deleteNoteLayout = constraintLayout5;
        this.detailsLayout = linearLayout2;
        this.durationLabel = textView2;
        this.emptyTagIcon = imageView5;
        this.gameNameLabel = textView3;
        this.gameSummaryLabel = textView4;
        this.infoLayout = constraintLayout6;
        this.leftLayout = linearLayout3;
        this.linearLayout = linearLayoutCompat;
        this.loadingAnimationView = lottieAnimationView;
        this.mtApiOverlay = constraintLayout7;
        this.noteContentLayout = linearLayout4;
        this.noteEditLayout = linearLayout5;
        this.noteEditText = editText;
        this.noteIcon = imageView6;
        this.noteLayout = linearLayout6;
        this.noteText = textView5;
        this.rootLayout = constraintLayout8;
        this.saveNoteButton = materialButton2;
        this.separator = view;
        this.tabs = tabLayout;
        this.tagsAndNotesLayout = linearLayout7;
        this.tagsFlexboxLayout = flexboxLayout;
        this.tagsLayout = linearLayout8;
        this.victoryLabel = textView6;
        this.viewPager = viewPager2;
        this.winnerLayout = linearLayout9;
        this.winnerNamesLabel = textView7;
        this.winnersHeaderLabel = textView8;
        this.winnersLayout = constraintLayout9;
        this.winnersRecyclerView = nonInteractiveRecyclerView;
    }

    public static ActivityGameDetailsBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.addTagIcon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.addTagLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.arrowIcon;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.arrowLayout;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout2 != null) {
                        i = R.id.backArrow;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView3 != null) {
                            i = R.id.backLayout;
                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout3 != null) {
                                i = R.id.buttonsLayout;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    i = R.id.cancelNoteButton;
                                    MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                    if (materialButton != null) {
                                        i = R.id.connectingTextView;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView != null) {
                                            i = R.id.deleteIcon;
                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView4 != null) {
                                                i = R.id.deleteNoteLayout;
                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                if (constraintLayout4 != null) {
                                                    i = R.id.detailsLayout;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout2 != null) {
                                                        i = R.id.durationLabel;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView2 != null) {
                                                            i = R.id.emptyTagIcon;
                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                            if (imageView5 != null) {
                                                                i = R.id.gameNameLabel;
                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView3 != null) {
                                                                    i = R.id.gameSummaryLabel;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView4 != null) {
                                                                        i = R.id.infoLayout;
                                                                        ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (constraintLayout5 != null) {
                                                                            i = R.id.leftLayout;
                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (linearLayout3 != null) {
                                                                                i = R.id.linearLayout;
                                                                                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
                                                                                if (linearLayoutCompat != null) {
                                                                                    i = R.id.loadingAnimationView;
                                                                                    LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                                                                                    if (lottieAnimationView != null) {
                                                                                        i = R.id.mtApiOverlay;
                                                                                        ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (constraintLayout6 != null) {
                                                                                            i = R.id.noteContentLayout;
                                                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                            if (linearLayout4 != null) {
                                                                                                i = R.id.noteEditLayout;
                                                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                if (linearLayout5 != null) {
                                                                                                    i = R.id.noteEditText;
                                                                                                    EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                                                                                    if (editText != null) {
                                                                                                        i = R.id.noteIcon;
                                                                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (imageView6 != null) {
                                                                                                            i = R.id.noteLayout;
                                                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                            if (linearLayout6 != null) {
                                                                                                                i = R.id.noteText;
                                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView5 != null) {
                                                                                                                    ConstraintLayout constraintLayout7 = (ConstraintLayout) view;
                                                                                                                    i = R.id.saveNoteButton;
                                                                                                                    MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (materialButton2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.separator))) != null) {
                                                                                                                        i = R.id.tabs;
                                                                                                                        TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (tabLayout != null) {
                                                                                                                            i = R.id.tagsAndNotesLayout;
                                                                                                                            LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (linearLayout7 != null) {
                                                                                                                                i = R.id.tagsFlexboxLayout;
                                                                                                                                FlexboxLayout flexboxLayout = (FlexboxLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (flexboxLayout != null) {
                                                                                                                                    i = R.id.tagsLayout;
                                                                                                                                    LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (linearLayout8 != null) {
                                                                                                                                        i = R.id.victoryLabel;
                                                                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (textView6 != null) {
                                                                                                                                            i = R.id.view_pager;
                                                                                                                                            ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (viewPager2 != null) {
                                                                                                                                                i = R.id.winnerLayout;
                                                                                                                                                LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (linearLayout9 != null) {
                                                                                                                                                    i = R.id.winnerNamesLabel;
                                                                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (textView7 != null) {
                                                                                                                                                        i = R.id.winnersHeaderLabel;
                                                                                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (textView8 != null) {
                                                                                                                                                            i = R.id.winnersLayout;
                                                                                                                                                            ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (constraintLayout8 != null) {
                                                                                                                                                                i = R.id.winnersRecyclerView;
                                                                                                                                                                NonInteractiveRecyclerView nonInteractiveRecyclerView = (NonInteractiveRecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (nonInteractiveRecyclerView != null) {
                                                                                                                                                                    return new ActivityGameDetailsBinding(constraintLayout7, imageView, constraintLayout, imageView2, constraintLayout2, imageView3, constraintLayout3, linearLayout, materialButton, textView, imageView4, constraintLayout4, linearLayout2, textView2, imageView5, textView3, textView4, constraintLayout5, linearLayout3, linearLayoutCompat, lottieAnimationView, constraintLayout6, linearLayout4, linearLayout5, editText, imageView6, linearLayout6, textView5, constraintLayout7, materialButton2, viewFindChildViewById, tabLayout, linearLayout7, flexboxLayout, linearLayout8, textView6, viewPager2, linearLayout9, textView7, textView8, constraintLayout8, nonInteractiveRecyclerView);
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

    public static ActivityGameDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityGameDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_game_details, viewGroup, false);
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
