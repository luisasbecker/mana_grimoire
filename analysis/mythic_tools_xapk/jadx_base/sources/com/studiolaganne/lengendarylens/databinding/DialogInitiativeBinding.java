package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogInitiativeBinding implements ViewBinding {
    public final ConstraintLayout cancelButtonLayout;
    public final TextView cancelButtonText;
    public final ImageView cardImage;
    public final ConstraintLayout cardLayout;
    public final ImageView closeImage;
    public final TextView closeLabel;
    public final TextView dragHelpTextView;
    public final Guideline guidelineRoom1EndH;
    public final Guideline guidelineRoom1EndW;
    public final Guideline guidelineRoom1StartH;
    public final Guideline guidelineRoom1StartW;
    public final Guideline guidelineRoom2EndH;
    public final Guideline guidelineRoom2EndW;
    public final Guideline guidelineRoom2StartH;
    public final Guideline guidelineRoom2StartW;
    public final Guideline guidelineRoom3EndH;
    public final Guideline guidelineRoom3EndW;
    public final Guideline guidelineRoom3StartH;
    public final Guideline guidelineRoom3StartW;
    public final Guideline guidelineRoom4EndH;
    public final Guideline guidelineRoom4EndW;
    public final Guideline guidelineRoom4StartH;
    public final Guideline guidelineRoom4StartW;
    public final Guideline guidelineRoom5EndH;
    public final Guideline guidelineRoom5EndW;
    public final Guideline guidelineRoom5StartH;
    public final Guideline guidelineRoom5StartW;
    public final Guideline guidelineRoom6EndH;
    public final Guideline guidelineRoom6EndW;
    public final Guideline guidelineRoom6StartH;
    public final Guideline guidelineRoom6StartW;
    public final Guideline guidelineRoom7EndH;
    public final Guideline guidelineRoom7EndW;
    public final Guideline guidelineRoom7StartH;
    public final Guideline guidelineRoom7StartW;
    public final Guideline guidelineRoom8EndH;
    public final Guideline guidelineRoom8EndW;
    public final Guideline guidelineRoom8StartH;
    public final Guideline guidelineRoom8StartW;
    public final Guideline guidelineRoom9EndH;
    public final Guideline guidelineRoom9EndW;
    public final Guideline guidelineRoom9StartH;
    public final Guideline guidelineRoom9StartW;
    public final View room1Box;
    public final View room1Overlay;
    public final View room2Box;
    public final View room2Overlay;
    public final View room3Box;
    public final View room3Overlay;
    public final View room4Box;
    public final View room4Overlay;
    public final View room5Box;
    public final View room5Overlay;
    public final View room6Box;
    public final View room6Overlay;
    public final View room7Box;
    public final View room7Overlay;
    public final View room8Box;
    public final View room8Overlay;
    public final View room9Box;
    public final View room9Overlay;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;

    private DialogInitiativeBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, ImageView imageView, ConstraintLayout constraintLayout3, ImageView imageView2, TextView textView2, TextView textView3, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, Guideline guideline6, Guideline guideline7, Guideline guideline8, Guideline guideline9, Guideline guideline10, Guideline guideline11, Guideline guideline12, Guideline guideline13, Guideline guideline14, Guideline guideline15, Guideline guideline16, Guideline guideline17, Guideline guideline18, Guideline guideline19, Guideline guideline20, Guideline guideline21, Guideline guideline22, Guideline guideline23, Guideline guideline24, Guideline guideline25, Guideline guideline26, Guideline guideline27, Guideline guideline28, Guideline guideline29, Guideline guideline30, Guideline guideline31, Guideline guideline32, Guideline guideline33, Guideline guideline34, Guideline guideline35, Guideline guideline36, View view, View view2, View view3, View view4, View view5, View view6, View view7, View view8, View view9, View view10, View view11, View view12, View view13, View view14, View view15, View view16, View view17, View view18, ConstraintLayout constraintLayout4) {
        this.rootView = constraintLayout;
        this.cancelButtonLayout = constraintLayout2;
        this.cancelButtonText = textView;
        this.cardImage = imageView;
        this.cardLayout = constraintLayout3;
        this.closeImage = imageView2;
        this.closeLabel = textView2;
        this.dragHelpTextView = textView3;
        this.guidelineRoom1EndH = guideline;
        this.guidelineRoom1EndW = guideline2;
        this.guidelineRoom1StartH = guideline3;
        this.guidelineRoom1StartW = guideline4;
        this.guidelineRoom2EndH = guideline5;
        this.guidelineRoom2EndW = guideline6;
        this.guidelineRoom2StartH = guideline7;
        this.guidelineRoom2StartW = guideline8;
        this.guidelineRoom3EndH = guideline9;
        this.guidelineRoom3EndW = guideline10;
        this.guidelineRoom3StartH = guideline11;
        this.guidelineRoom3StartW = guideline12;
        this.guidelineRoom4EndH = guideline13;
        this.guidelineRoom4EndW = guideline14;
        this.guidelineRoom4StartH = guideline15;
        this.guidelineRoom4StartW = guideline16;
        this.guidelineRoom5EndH = guideline17;
        this.guidelineRoom5EndW = guideline18;
        this.guidelineRoom5StartH = guideline19;
        this.guidelineRoom5StartW = guideline20;
        this.guidelineRoom6EndH = guideline21;
        this.guidelineRoom6EndW = guideline22;
        this.guidelineRoom6StartH = guideline23;
        this.guidelineRoom6StartW = guideline24;
        this.guidelineRoom7EndH = guideline25;
        this.guidelineRoom7EndW = guideline26;
        this.guidelineRoom7StartH = guideline27;
        this.guidelineRoom7StartW = guideline28;
        this.guidelineRoom8EndH = guideline29;
        this.guidelineRoom8EndW = guideline30;
        this.guidelineRoom8StartH = guideline31;
        this.guidelineRoom8StartW = guideline32;
        this.guidelineRoom9EndH = guideline33;
        this.guidelineRoom9EndW = guideline34;
        this.guidelineRoom9StartH = guideline35;
        this.guidelineRoom9StartW = guideline36;
        this.room1Box = view;
        this.room1Overlay = view2;
        this.room2Box = view3;
        this.room2Overlay = view4;
        this.room3Box = view5;
        this.room3Overlay = view6;
        this.room4Box = view7;
        this.room4Overlay = view8;
        this.room5Box = view9;
        this.room5Overlay = view10;
        this.room6Box = view11;
        this.room6Overlay = view12;
        this.room7Box = view13;
        this.room7Overlay = view14;
        this.room8Box = view15;
        this.room8Overlay = view16;
        this.room9Box = view17;
        this.room9Overlay = view18;
        this.rootLayout = constraintLayout4;
    }

    public static DialogInitiativeBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        View viewFindChildViewById3;
        View viewFindChildViewById4;
        View viewFindChildViewById5;
        View viewFindChildViewById6;
        View viewFindChildViewById7;
        View viewFindChildViewById8;
        View viewFindChildViewById9;
        View viewFindChildViewById10;
        View viewFindChildViewById11;
        View viewFindChildViewById12;
        View viewFindChildViewById13;
        View viewFindChildViewById14;
        View viewFindChildViewById15;
        View viewFindChildViewById16;
        View viewFindChildViewById17;
        View viewFindChildViewById18;
        int i = R.id.cancelButtonLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.cancelButtonText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.cardImage;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.cardLayout;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout2 != null) {
                        i = R.id.closeImage;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.closeLabel;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.dragHelpTextView;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.guidelineRoom1EndH;
                                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                                    if (guideline != null) {
                                        i = R.id.guidelineRoom1EndW;
                                        Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                        if (guideline2 != null) {
                                            i = R.id.guidelineRoom1StartH;
                                            Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                                            if (guideline3 != null) {
                                                i = R.id.guidelineRoom1StartW;
                                                Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                if (guideline4 != null) {
                                                    i = R.id.guidelineRoom2EndH;
                                                    Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                    if (guideline5 != null) {
                                                        i = R.id.guidelineRoom2EndW;
                                                        Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                        if (guideline6 != null) {
                                                            i = R.id.guidelineRoom2StartH;
                                                            Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                            if (guideline7 != null) {
                                                                i = R.id.guidelineRoom2StartW;
                                                                Guideline guideline8 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                if (guideline8 != null) {
                                                                    i = R.id.guidelineRoom3EndH;
                                                                    Guideline guideline9 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                    if (guideline9 != null) {
                                                                        i = R.id.guidelineRoom3EndW;
                                                                        Guideline guideline10 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                        if (guideline10 != null) {
                                                                            i = R.id.guidelineRoom3StartH;
                                                                            Guideline guideline11 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                            if (guideline11 != null) {
                                                                                i = R.id.guidelineRoom3StartW;
                                                                                Guideline guideline12 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                if (guideline12 != null) {
                                                                                    i = R.id.guidelineRoom4EndH;
                                                                                    Guideline guideline13 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                    if (guideline13 != null) {
                                                                                        i = R.id.guidelineRoom4EndW;
                                                                                        Guideline guideline14 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                        if (guideline14 != null) {
                                                                                            i = R.id.guidelineRoom4StartH;
                                                                                            Guideline guideline15 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                            if (guideline15 != null) {
                                                                                                i = R.id.guidelineRoom4StartW;
                                                                                                Guideline guideline16 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                if (guideline16 != null) {
                                                                                                    i = R.id.guidelineRoom5EndH;
                                                                                                    Guideline guideline17 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                    if (guideline17 != null) {
                                                                                                        i = R.id.guidelineRoom5EndW;
                                                                                                        Guideline guideline18 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                        if (guideline18 != null) {
                                                                                                            i = R.id.guidelineRoom5StartH;
                                                                                                            Guideline guideline19 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                            if (guideline19 != null) {
                                                                                                                i = R.id.guidelineRoom5StartW;
                                                                                                                Guideline guideline20 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                if (guideline20 != null) {
                                                                                                                    i = R.id.guidelineRoom6EndH;
                                                                                                                    Guideline guideline21 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (guideline21 != null) {
                                                                                                                        i = R.id.guidelineRoom6EndW;
                                                                                                                        Guideline guideline22 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (guideline22 != null) {
                                                                                                                            i = R.id.guidelineRoom6StartH;
                                                                                                                            Guideline guideline23 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (guideline23 != null) {
                                                                                                                                i = R.id.guidelineRoom6StartW;
                                                                                                                                Guideline guideline24 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (guideline24 != null) {
                                                                                                                                    i = R.id.guidelineRoom7EndH;
                                                                                                                                    Guideline guideline25 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (guideline25 != null) {
                                                                                                                                        i = R.id.guidelineRoom7EndW;
                                                                                                                                        Guideline guideline26 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (guideline26 != null) {
                                                                                                                                            i = R.id.guidelineRoom7StartH;
                                                                                                                                            Guideline guideline27 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (guideline27 != null) {
                                                                                                                                                i = R.id.guidelineRoom7StartW;
                                                                                                                                                Guideline guideline28 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (guideline28 != null) {
                                                                                                                                                    i = R.id.guidelineRoom8EndH;
                                                                                                                                                    Guideline guideline29 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (guideline29 != null) {
                                                                                                                                                        i = R.id.guidelineRoom8EndW;
                                                                                                                                                        Guideline guideline30 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (guideline30 != null) {
                                                                                                                                                            i = R.id.guidelineRoom8StartH;
                                                                                                                                                            Guideline guideline31 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (guideline31 != null) {
                                                                                                                                                                i = R.id.guidelineRoom8StartW;
                                                                                                                                                                Guideline guideline32 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (guideline32 != null) {
                                                                                                                                                                    i = R.id.guidelineRoom9EndH;
                                                                                                                                                                    Guideline guideline33 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (guideline33 != null) {
                                                                                                                                                                        i = R.id.guidelineRoom9EndW;
                                                                                                                                                                        Guideline guideline34 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                        if (guideline34 != null) {
                                                                                                                                                                            i = R.id.guidelineRoom9StartH;
                                                                                                                                                                            Guideline guideline35 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                            if (guideline35 != null) {
                                                                                                                                                                                i = R.id.guidelineRoom9StartW;
                                                                                                                                                                                Guideline guideline36 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                if (guideline36 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.room1Box))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.room1Overlay))) != null && (viewFindChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.room2Box))) != null && (viewFindChildViewById4 = ViewBindings.findChildViewById(view, (i = R.id.room2Overlay))) != null && (viewFindChildViewById5 = ViewBindings.findChildViewById(view, (i = R.id.room3Box))) != null && (viewFindChildViewById6 = ViewBindings.findChildViewById(view, (i = R.id.room3Overlay))) != null && (viewFindChildViewById7 = ViewBindings.findChildViewById(view, (i = R.id.room4Box))) != null && (viewFindChildViewById8 = ViewBindings.findChildViewById(view, (i = R.id.room4Overlay))) != null && (viewFindChildViewById9 = ViewBindings.findChildViewById(view, (i = R.id.room5Box))) != null && (viewFindChildViewById10 = ViewBindings.findChildViewById(view, (i = R.id.room5Overlay))) != null && (viewFindChildViewById11 = ViewBindings.findChildViewById(view, (i = R.id.room6Box))) != null && (viewFindChildViewById12 = ViewBindings.findChildViewById(view, (i = R.id.room6Overlay))) != null && (viewFindChildViewById13 = ViewBindings.findChildViewById(view, (i = R.id.room7Box))) != null && (viewFindChildViewById14 = ViewBindings.findChildViewById(view, (i = R.id.room7Overlay))) != null && (viewFindChildViewById15 = ViewBindings.findChildViewById(view, (i = R.id.room8Box))) != null && (viewFindChildViewById16 = ViewBindings.findChildViewById(view, (i = R.id.room8Overlay))) != null && (viewFindChildViewById17 = ViewBindings.findChildViewById(view, (i = R.id.room9Box))) != null && (viewFindChildViewById18 = ViewBindings.findChildViewById(view, (i = R.id.room9Overlay))) != null) {
                                                                                                                                                                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) view;
                                                                                                                                                                                    return new DialogInitiativeBinding(constraintLayout3, constraintLayout, textView, imageView, constraintLayout2, imageView2, textView2, textView3, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, guideline7, guideline8, guideline9, guideline10, guideline11, guideline12, guideline13, guideline14, guideline15, guideline16, guideline17, guideline18, guideline19, guideline20, guideline21, guideline22, guideline23, guideline24, guideline25, guideline26, guideline27, guideline28, guideline29, guideline30, guideline31, guideline32, guideline33, guideline34, guideline35, guideline36, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3, viewFindChildViewById4, viewFindChildViewById5, viewFindChildViewById6, viewFindChildViewById7, viewFindChildViewById8, viewFindChildViewById9, viewFindChildViewById10, viewFindChildViewById11, viewFindChildViewById12, viewFindChildViewById13, viewFindChildViewById14, viewFindChildViewById15, viewFindChildViewById16, viewFindChildViewById17, viewFindChildViewById18, constraintLayout3);
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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

    public static DialogInitiativeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogInitiativeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_initiative, viewGroup, false);
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
