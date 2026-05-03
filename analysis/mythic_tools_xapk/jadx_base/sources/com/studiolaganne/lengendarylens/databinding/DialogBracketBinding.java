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
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogBracketBinding implements ViewBinding {
    public final ConstraintLayout autoBracketIconLayout;
    public final LinearLayout autoBracketInfoLayout;
    public final ConstraintLayout autoBracketLayout;
    public final LinearLayout autoBracketLinearLayout;
    public final TextView autoBracketSubtitle;
    public final TextView autoBracketTitle;
    public final ConstraintLayout bracket1Layout;
    public final TextView bracket1Name;
    public final TextView bracket1Number;
    public final ConstraintLayout bracket2Layout;
    public final TextView bracket2Name;
    public final TextView bracket2Number;
    public final ConstraintLayout bracket3Layout;
    public final TextView bracket3Name;
    public final TextView bracket3Number;
    public final ConstraintLayout bracket4Layout;
    public final TextView bracket4Name;
    public final TextView bracket4Number;
    public final ConstraintLayout bracket5Layout;
    public final TextView bracket5Name;
    public final TextView bracket5Number;
    public final ConstraintLayout bracketLayout;
    public final TextView bracketNameTextView;
    public final TextView bracketValueTextView;
    public final ConstraintLayout cancelLayout;
    public final MaterialButton clearButton;
    public final TextView closeBracketTextView;
    public final TextView extraTurnsHeader;
    public final TextView extraTurnsValue;
    public final TextView fastManaHeader;
    public final TextView fastManaValue;
    public final TextView gameChangersHeader;
    public final TextView gameChangersValue;
    public final TextView helpTextView;
    public final LinearLayout line1;
    public final LinearLayout line1Left;
    public final LinearLayout line1Right;
    public final LinearLayout line2;
    public final LinearLayout line2Left;
    public final LinearLayout line2Right;
    public final LinearLayout line3;
    public final LinearLayout line3Left;
    public final LinearLayout line3Right;
    public final LinearLayout linearLayoutBottom;
    public final LinearLayout linearLayoutLast;
    public final LinearLayout linearLayoutTop;
    public final ConstraintLayout manualRecalcButtonLayout;
    public final TextView manualRecalcTextView;
    public final TextView massLandDenialHeader;
    public final TextView massLandDenialValue;
    public final MaterialButton negativeButton;
    public final TextView openBracketTextView;
    public final ConstraintLayout player2Layout;
    public final ConstraintLayout recalcButtonLayout;
    public final LinearLayout recalcHintLinearLayout;
    public final TextView recalcHintSubtitle;
    public final TextView recalcTextView;
    public final LinearLayout rootLayout;
    private final LinearLayout rootView;
    public final View separator;
    public final ImageView spellImageBracket;
    public final TextView title;
    public final TextView tutorsHeader;
    public final TextView tutorsValue;
    public final TextView twoCardCombosHeader;
    public final TextView twoCardCombosValue;

    private DialogBracketBinding(LinearLayout linearLayout, ConstraintLayout constraintLayout, LinearLayout linearLayout2, ConstraintLayout constraintLayout2, LinearLayout linearLayout3, TextView textView, TextView textView2, ConstraintLayout constraintLayout3, TextView textView3, TextView textView4, ConstraintLayout constraintLayout4, TextView textView5, TextView textView6, ConstraintLayout constraintLayout5, TextView textView7, TextView textView8, ConstraintLayout constraintLayout6, TextView textView9, TextView textView10, ConstraintLayout constraintLayout7, TextView textView11, TextView textView12, ConstraintLayout constraintLayout8, TextView textView13, TextView textView14, ConstraintLayout constraintLayout9, MaterialButton materialButton, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, TextView textView22, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout8, LinearLayout linearLayout9, LinearLayout linearLayout10, LinearLayout linearLayout11, LinearLayout linearLayout12, LinearLayout linearLayout13, LinearLayout linearLayout14, LinearLayout linearLayout15, ConstraintLayout constraintLayout10, TextView textView23, TextView textView24, TextView textView25, MaterialButton materialButton2, TextView textView26, ConstraintLayout constraintLayout11, ConstraintLayout constraintLayout12, LinearLayout linearLayout16, TextView textView27, TextView textView28, LinearLayout linearLayout17, View view, ImageView imageView, TextView textView29, TextView textView30, TextView textView31, TextView textView32, TextView textView33) {
        this.rootView = linearLayout;
        this.autoBracketIconLayout = constraintLayout;
        this.autoBracketInfoLayout = linearLayout2;
        this.autoBracketLayout = constraintLayout2;
        this.autoBracketLinearLayout = linearLayout3;
        this.autoBracketSubtitle = textView;
        this.autoBracketTitle = textView2;
        this.bracket1Layout = constraintLayout3;
        this.bracket1Name = textView3;
        this.bracket1Number = textView4;
        this.bracket2Layout = constraintLayout4;
        this.bracket2Name = textView5;
        this.bracket2Number = textView6;
        this.bracket3Layout = constraintLayout5;
        this.bracket3Name = textView7;
        this.bracket3Number = textView8;
        this.bracket4Layout = constraintLayout6;
        this.bracket4Name = textView9;
        this.bracket4Number = textView10;
        this.bracket5Layout = constraintLayout7;
        this.bracket5Name = textView11;
        this.bracket5Number = textView12;
        this.bracketLayout = constraintLayout8;
        this.bracketNameTextView = textView13;
        this.bracketValueTextView = textView14;
        this.cancelLayout = constraintLayout9;
        this.clearButton = materialButton;
        this.closeBracketTextView = textView15;
        this.extraTurnsHeader = textView16;
        this.extraTurnsValue = textView17;
        this.fastManaHeader = textView18;
        this.fastManaValue = textView19;
        this.gameChangersHeader = textView20;
        this.gameChangersValue = textView21;
        this.helpTextView = textView22;
        this.line1 = linearLayout4;
        this.line1Left = linearLayout5;
        this.line1Right = linearLayout6;
        this.line2 = linearLayout7;
        this.line2Left = linearLayout8;
        this.line2Right = linearLayout9;
        this.line3 = linearLayout10;
        this.line3Left = linearLayout11;
        this.line3Right = linearLayout12;
        this.linearLayoutBottom = linearLayout13;
        this.linearLayoutLast = linearLayout14;
        this.linearLayoutTop = linearLayout15;
        this.manualRecalcButtonLayout = constraintLayout10;
        this.manualRecalcTextView = textView23;
        this.massLandDenialHeader = textView24;
        this.massLandDenialValue = textView25;
        this.negativeButton = materialButton2;
        this.openBracketTextView = textView26;
        this.player2Layout = constraintLayout11;
        this.recalcButtonLayout = constraintLayout12;
        this.recalcHintLinearLayout = linearLayout16;
        this.recalcHintSubtitle = textView27;
        this.recalcTextView = textView28;
        this.rootLayout = linearLayout17;
        this.separator = view;
        this.spellImageBracket = imageView;
        this.title = textView29;
        this.tutorsHeader = textView30;
        this.tutorsValue = textView31;
        this.twoCardCombosHeader = textView32;
        this.twoCardCombosValue = textView33;
    }

    public static DialogBracketBinding bind(View view) {
        int i = R.id.autoBracketIconLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.autoBracketInfoLayout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.autoBracketLayout;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout2 != null) {
                    i = R.id.autoBracketLinearLayout;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = R.id.autoBracketSubtitle;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.autoBracketTitle;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.bracket1Layout;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout3 != null) {
                                    i = R.id.bracket1Name;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.bracket1Number;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R.id.bracket2Layout;
                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                            if (constraintLayout4 != null) {
                                                i = R.id.bracket2Name;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null) {
                                                    i = R.id.bracket2Number;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView6 != null) {
                                                        i = R.id.bracket3Layout;
                                                        ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                        if (constraintLayout5 != null) {
                                                            i = R.id.bracket3Name;
                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView7 != null) {
                                                                i = R.id.bracket3Number;
                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView8 != null) {
                                                                    i = R.id.bracket4Layout;
                                                                    ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (constraintLayout6 != null) {
                                                                        i = R.id.bracket4Name;
                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView9 != null) {
                                                                            i = R.id.bracket4Number;
                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView10 != null) {
                                                                                i = R.id.bracket5Layout;
                                                                                ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (constraintLayout7 != null) {
                                                                                    i = R.id.bracket5Name;
                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView11 != null) {
                                                                                        i = R.id.bracket5Number;
                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView12 != null) {
                                                                                            i = R.id.bracketLayout;
                                                                                            ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                            if (constraintLayout8 != null) {
                                                                                                i = R.id.bracketNameTextView;
                                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView13 != null) {
                                                                                                    i = R.id.bracketValueTextView;
                                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView14 != null) {
                                                                                                        i = R.id.cancelLayout;
                                                                                                        ConstraintLayout constraintLayout9 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                        if (constraintLayout9 != null) {
                                                                                                            i = R.id.clear_button;
                                                                                                            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                                                                                            if (materialButton != null) {
                                                                                                                i = R.id.closeBracketTextView;
                                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView15 != null) {
                                                                                                                    i = R.id.extraTurnsHeader;
                                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView16 != null) {
                                                                                                                        i = R.id.extraTurnsValue;
                                                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView17 != null) {
                                                                                                                            i = R.id.fastManaHeader;
                                                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView18 != null) {
                                                                                                                                i = R.id.fastManaValue;
                                                                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView19 != null) {
                                                                                                                                    i = R.id.gameChangersHeader;
                                                                                                                                    TextView textView20 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (textView20 != null) {
                                                                                                                                        i = R.id.gameChangersValue;
                                                                                                                                        TextView textView21 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (textView21 != null) {
                                                                                                                                            i = R.id.helpTextView;
                                                                                                                                            TextView textView22 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (textView22 != null) {
                                                                                                                                                i = R.id.line1;
                                                                                                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (linearLayout3 != null) {
                                                                                                                                                    i = R.id.line1Left;
                                                                                                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (linearLayout4 != null) {
                                                                                                                                                        i = R.id.line1Right;
                                                                                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (linearLayout5 != null) {
                                                                                                                                                            i = R.id.line2;
                                                                                                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (linearLayout6 != null) {
                                                                                                                                                                i = R.id.line2Left;
                                                                                                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (linearLayout7 != null) {
                                                                                                                                                                    i = R.id.line2Right;
                                                                                                                                                                    LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (linearLayout8 != null) {
                                                                                                                                                                        i = R.id.line3;
                                                                                                                                                                        LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                        if (linearLayout9 != null) {
                                                                                                                                                                            i = R.id.line3Left;
                                                                                                                                                                            LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                            if (linearLayout10 != null) {
                                                                                                                                                                                i = R.id.line3Right;
                                                                                                                                                                                LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                if (linearLayout11 != null) {
                                                                                                                                                                                    i = R.id.linearLayoutBottom;
                                                                                                                                                                                    LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                    if (linearLayout12 != null) {
                                                                                                                                                                                        i = R.id.linearLayoutLast;
                                                                                                                                                                                        LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                        if (linearLayout13 != null) {
                                                                                                                                                                                            i = R.id.linearLayoutTop;
                                                                                                                                                                                            LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                            if (linearLayout14 != null) {
                                                                                                                                                                                                i = R.id.manualRecalcButtonLayout;
                                                                                                                                                                                                ConstraintLayout constraintLayout10 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                if (constraintLayout10 != null) {
                                                                                                                                                                                                    i = R.id.manualRecalcTextView;
                                                                                                                                                                                                    TextView textView23 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                    if (textView23 != null) {
                                                                                                                                                                                                        i = R.id.massLandDenialHeader;
                                                                                                                                                                                                        TextView textView24 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                        if (textView24 != null) {
                                                                                                                                                                                                            i = R.id.massLandDenialValue;
                                                                                                                                                                                                            TextView textView25 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                            if (textView25 != null) {
                                                                                                                                                                                                                i = R.id.negative_button;
                                                                                                                                                                                                                MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                if (materialButton2 != null) {
                                                                                                                                                                                                                    i = R.id.openBracketTextView;
                                                                                                                                                                                                                    TextView textView26 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                    if (textView26 != null) {
                                                                                                                                                                                                                        i = R.id.player2Layout;
                                                                                                                                                                                                                        ConstraintLayout constraintLayout11 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                        if (constraintLayout11 != null) {
                                                                                                                                                                                                                            i = R.id.recalcButtonLayout;
                                                                                                                                                                                                                            ConstraintLayout constraintLayout12 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                            if (constraintLayout12 != null) {
                                                                                                                                                                                                                                i = R.id.recalcHintLinearLayout;
                                                                                                                                                                                                                                LinearLayout linearLayout15 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                if (linearLayout15 != null) {
                                                                                                                                                                                                                                    i = R.id.recalcHintSubtitle;
                                                                                                                                                                                                                                    TextView textView27 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                    if (textView27 != null) {
                                                                                                                                                                                                                                        i = R.id.recalcTextView;
                                                                                                                                                                                                                                        TextView textView28 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                        if (textView28 != null) {
                                                                                                                                                                                                                                            LinearLayout linearLayout16 = (LinearLayout) view;
                                                                                                                                                                                                                                            i = R.id.separator;
                                                                                                                                                                                                                                            View viewFindChildViewById = ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                            if (viewFindChildViewById != null) {
                                                                                                                                                                                                                                                i = R.id.spellImageBracket;
                                                                                                                                                                                                                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                if (imageView != null) {
                                                                                                                                                                                                                                                    i = R.id.title;
                                                                                                                                                                                                                                                    TextView textView29 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                    if (textView29 != null) {
                                                                                                                                                                                                                                                        i = R.id.tutorsHeader;
                                                                                                                                                                                                                                                        TextView textView30 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                        if (textView30 != null) {
                                                                                                                                                                                                                                                            i = R.id.tutorsValue;
                                                                                                                                                                                                                                                            TextView textView31 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                            if (textView31 != null) {
                                                                                                                                                                                                                                                                i = R.id.twoCardCombosHeader;
                                                                                                                                                                                                                                                                TextView textView32 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                if (textView32 != null) {
                                                                                                                                                                                                                                                                    i = R.id.twoCardCombosValue;
                                                                                                                                                                                                                                                                    TextView textView33 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                    if (textView33 != null) {
                                                                                                                                                                                                                                                                        return new DialogBracketBinding(linearLayout16, constraintLayout, linearLayout, constraintLayout2, linearLayout2, textView, textView2, constraintLayout3, textView3, textView4, constraintLayout4, textView5, textView6, constraintLayout5, textView7, textView8, constraintLayout6, textView9, textView10, constraintLayout7, textView11, textView12, constraintLayout8, textView13, textView14, constraintLayout9, materialButton, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, linearLayout9, linearLayout10, linearLayout11, linearLayout12, linearLayout13, linearLayout14, constraintLayout10, textView23, textView24, textView25, materialButton2, textView26, constraintLayout11, constraintLayout12, linearLayout15, textView27, textView28, linearLayout16, viewFindChildViewById, imageView, textView29, textView30, textView31, textView32, textView33);
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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

    public static DialogBracketBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogBracketBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_bracket, viewGroup, false);
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
