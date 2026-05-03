package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.MonarchCoin;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentGameOptionsBinding implements ViewBinding {
    public final GridLayout addonsGridLayout;
    public final ImageView addonsIcon;
    public final TextView addonsLabelText;
    public final ConstraintLayout addonsLayout;
    public final ConstraintLayout addonsOverlay;
    public final ImageView archenemyCheckmark;
    public final ImageView archenemyIcon;
    public final TextView archenemyLabelText;
    public final ConstraintLayout archenemyLayout;
    public final SwitchCompat batterySavingSwitch;
    public final TextView batteryText;
    public final ImageView blessingIcon;
    public final TextView blessingLabelText;
    public final ConstraintLayout blessingLayout;
    public final TextView clockHeader;
    public final TextView clockText;
    public final SwitchCompat commanderSwitch;
    public final SwitchCompat dayNightSwitch;
    public final TextView diceLabelText;
    public final ConstraintLayout diceLayout;
    public final TextView diceText;
    public final ImageView eventsIcon;
    public final TextView eventsLabelText;
    public final ConstraintLayout eventsLayout;
    public final ImageView initiativeIcon;
    public final ConstraintLayout initiativeLayout;
    public final ConstraintLayout innerAddonsLayout;
    public final ConstraintLayout innerTokensLayout;
    public final TextView intiativeLabelText;
    public final GridLayout legalityGridLayout;
    public final MonarchCoin monarchCoin;
    public final ConstraintLayout monarchHelpLayout;
    public final ConstraintLayout monarchLayout;
    public final TextView monarchText;
    public final ConstraintLayout optionsLayout;
    public final ConstraintLayout optionsLayout2;
    public final TextView optionsText;
    public final ImageView planechaseCheckmark;
    public final ImageView planechaseIcon;
    public final TextView planechaseLabelText;
    public final ConstraintLayout planechaseLayout;
    public final LinearLayout poisonDayNightLayout;
    public final SwitchCompat poisonSwitch;
    private final ConstraintLayout rootView;
    public final ImageView theRingIcon;
    public final TextView theRingLabelText;
    public final ConstraintLayout theRingLayout;
    public final ConstraintLayout timerLayout;
    public final TextView timerLeftHeader;
    public final ImageView timerLeftIcon;
    public final ConstraintLayout timerLeftLayout;
    public final SwitchCompat timerSwitch;
    public final TextView timerValue;
    public final ImageView tokensIcon;
    public final TextView tokensLabelText;
    public final ConstraintLayout tokensLayout;
    public final ConstraintLayout tokensOverlay;
    public final TextView turnTimerHeader;
    public final ConstraintLayout turnTimerLayout;
    public final SwitchCompat turnTimerSwitch;

    private FragmentGameOptionsBinding(ConstraintLayout constraintLayout, GridLayout gridLayout, ImageView imageView, TextView textView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView2, ImageView imageView3, TextView textView2, ConstraintLayout constraintLayout4, SwitchCompat switchCompat, TextView textView3, ImageView imageView4, TextView textView4, ConstraintLayout constraintLayout5, TextView textView5, TextView textView6, SwitchCompat switchCompat2, SwitchCompat switchCompat3, TextView textView7, ConstraintLayout constraintLayout6, TextView textView8, ImageView imageView5, TextView textView9, ConstraintLayout constraintLayout7, ImageView imageView6, ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10, TextView textView10, GridLayout gridLayout2, MonarchCoin monarchCoin, ConstraintLayout constraintLayout11, ConstraintLayout constraintLayout12, TextView textView11, ConstraintLayout constraintLayout13, ConstraintLayout constraintLayout14, TextView textView12, ImageView imageView7, ImageView imageView8, TextView textView13, ConstraintLayout constraintLayout15, LinearLayout linearLayout, SwitchCompat switchCompat4, ImageView imageView9, TextView textView14, ConstraintLayout constraintLayout16, ConstraintLayout constraintLayout17, TextView textView15, ImageView imageView10, ConstraintLayout constraintLayout18, SwitchCompat switchCompat5, TextView textView16, ImageView imageView11, TextView textView17, ConstraintLayout constraintLayout19, ConstraintLayout constraintLayout20, TextView textView18, ConstraintLayout constraintLayout21, SwitchCompat switchCompat6) {
        this.rootView = constraintLayout;
        this.addonsGridLayout = gridLayout;
        this.addonsIcon = imageView;
        this.addonsLabelText = textView;
        this.addonsLayout = constraintLayout2;
        this.addonsOverlay = constraintLayout3;
        this.archenemyCheckmark = imageView2;
        this.archenemyIcon = imageView3;
        this.archenemyLabelText = textView2;
        this.archenemyLayout = constraintLayout4;
        this.batterySavingSwitch = switchCompat;
        this.batteryText = textView3;
        this.blessingIcon = imageView4;
        this.blessingLabelText = textView4;
        this.blessingLayout = constraintLayout5;
        this.clockHeader = textView5;
        this.clockText = textView6;
        this.commanderSwitch = switchCompat2;
        this.dayNightSwitch = switchCompat3;
        this.diceLabelText = textView7;
        this.diceLayout = constraintLayout6;
        this.diceText = textView8;
        this.eventsIcon = imageView5;
        this.eventsLabelText = textView9;
        this.eventsLayout = constraintLayout7;
        this.initiativeIcon = imageView6;
        this.initiativeLayout = constraintLayout8;
        this.innerAddonsLayout = constraintLayout9;
        this.innerTokensLayout = constraintLayout10;
        this.intiativeLabelText = textView10;
        this.legalityGridLayout = gridLayout2;
        this.monarchCoin = monarchCoin;
        this.monarchHelpLayout = constraintLayout11;
        this.monarchLayout = constraintLayout12;
        this.monarchText = textView11;
        this.optionsLayout = constraintLayout13;
        this.optionsLayout2 = constraintLayout14;
        this.optionsText = textView12;
        this.planechaseCheckmark = imageView7;
        this.planechaseIcon = imageView8;
        this.planechaseLabelText = textView13;
        this.planechaseLayout = constraintLayout15;
        this.poisonDayNightLayout = linearLayout;
        this.poisonSwitch = switchCompat4;
        this.theRingIcon = imageView9;
        this.theRingLabelText = textView14;
        this.theRingLayout = constraintLayout16;
        this.timerLayout = constraintLayout17;
        this.timerLeftHeader = textView15;
        this.timerLeftIcon = imageView10;
        this.timerLeftLayout = constraintLayout18;
        this.timerSwitch = switchCompat5;
        this.timerValue = textView16;
        this.tokensIcon = imageView11;
        this.tokensLabelText = textView17;
        this.tokensLayout = constraintLayout19;
        this.tokensOverlay = constraintLayout20;
        this.turnTimerHeader = textView18;
        this.turnTimerLayout = constraintLayout21;
        this.turnTimerSwitch = switchCompat6;
    }

    public static FragmentGameOptionsBinding bind(View view) {
        int i = R.id.addons_grid_layout;
        GridLayout gridLayout = (GridLayout) ViewBindings.findChildViewById(view, i);
        if (gridLayout != null) {
            i = R.id.addons_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.addons_label_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.addons_layout;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        i = R.id.addonsOverlay;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout2 != null) {
                            i = R.id.archenemy_checkmark;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = R.id.archenemy_icon;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView3 != null) {
                                    i = R.id.archenemy_label_text;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = R.id.archenemy_layout;
                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                        if (constraintLayout3 != null) {
                                            i = R.id.battery_saving_switch;
                                            SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, i);
                                            if (switchCompat != null) {
                                                i = R.id.battery_text;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView3 != null) {
                                                    i = R.id.blessing_icon;
                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView4 != null) {
                                                        i = R.id.blessing_label_text;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView4 != null) {
                                                            i = R.id.blessing_layout;
                                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                            if (constraintLayout4 != null) {
                                                                i = R.id.clock_header;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView5 != null) {
                                                                    i = R.id.clock_text;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView6 != null) {
                                                                        i = R.id.commander_switch;
                                                                        SwitchCompat switchCompat2 = (SwitchCompat) ViewBindings.findChildViewById(view, i);
                                                                        if (switchCompat2 != null) {
                                                                            i = R.id.day_night_switch;
                                                                            SwitchCompat switchCompat3 = (SwitchCompat) ViewBindings.findChildViewById(view, i);
                                                                            if (switchCompat3 != null) {
                                                                                i = R.id.dice_label_text;
                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView7 != null) {
                                                                                    i = R.id.dice_layout;
                                                                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                    if (constraintLayout5 != null) {
                                                                                        i = R.id.dice_text;
                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView8 != null) {
                                                                                            i = R.id.events_icon;
                                                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                            if (imageView5 != null) {
                                                                                                i = R.id.events_label_text;
                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView9 != null) {
                                                                                                    i = R.id.events_layout;
                                                                                                    ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                    if (constraintLayout6 != null) {
                                                                                                        i = R.id.initiative_icon;
                                                                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (imageView6 != null) {
                                                                                                            i = R.id.initiative_layout;
                                                                                                            ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                            if (constraintLayout7 != null) {
                                                                                                                i = R.id.innerAddonsLayout;
                                                                                                                ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                if (constraintLayout8 != null) {
                                                                                                                    i = R.id.innerTokensLayout;
                                                                                                                    ConstraintLayout constraintLayout9 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (constraintLayout9 != null) {
                                                                                                                        i = R.id.intiative_label_text;
                                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView10 != null) {
                                                                                                                            i = R.id.legality_grid_layout;
                                                                                                                            GridLayout gridLayout2 = (GridLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (gridLayout2 != null) {
                                                                                                                                i = R.id.monarch_coin;
                                                                                                                                MonarchCoin monarchCoin = (MonarchCoin) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (monarchCoin != null) {
                                                                                                                                    i = R.id.monarch_help_layout;
                                                                                                                                    ConstraintLayout constraintLayout10 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (constraintLayout10 != null) {
                                                                                                                                        i = R.id.monarch_layout;
                                                                                                                                        ConstraintLayout constraintLayout11 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (constraintLayout11 != null) {
                                                                                                                                            i = R.id.monarch_text;
                                                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (textView11 != null) {
                                                                                                                                                i = R.id.options_layout;
                                                                                                                                                ConstraintLayout constraintLayout12 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (constraintLayout12 != null) {
                                                                                                                                                    i = R.id.options_layout2;
                                                                                                                                                    ConstraintLayout constraintLayout13 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (constraintLayout13 != null) {
                                                                                                                                                        i = R.id.options_text;
                                                                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (textView12 != null) {
                                                                                                                                                            i = R.id.planechase_checkmark;
                                                                                                                                                            ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (imageView7 != null) {
                                                                                                                                                                i = R.id.planechase_icon;
                                                                                                                                                                ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (imageView8 != null) {
                                                                                                                                                                    i = R.id.planechase_label_text;
                                                                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (textView13 != null) {
                                                                                                                                                                        i = R.id.planechase_layout;
                                                                                                                                                                        ConstraintLayout constraintLayout14 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                        if (constraintLayout14 != null) {
                                                                                                                                                                            i = R.id.poisonDayNightLayout;
                                                                                                                                                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                            if (linearLayout != null) {
                                                                                                                                                                                i = R.id.poison_switch;
                                                                                                                                                                                SwitchCompat switchCompat4 = (SwitchCompat) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                if (switchCompat4 != null) {
                                                                                                                                                                                    i = R.id.the_ring_icon;
                                                                                                                                                                                    ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                    if (imageView9 != null) {
                                                                                                                                                                                        i = R.id.the_ring_label_text;
                                                                                                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                        if (textView14 != null) {
                                                                                                                                                                                            i = R.id.the_ring_layout;
                                                                                                                                                                                            ConstraintLayout constraintLayout15 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                            if (constraintLayout15 != null) {
                                                                                                                                                                                                i = R.id.timer_layout;
                                                                                                                                                                                                ConstraintLayout constraintLayout16 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                if (constraintLayout16 != null) {
                                                                                                                                                                                                    i = R.id.timer_left_header;
                                                                                                                                                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                    if (textView15 != null) {
                                                                                                                                                                                                        i = R.id.timer_left_icon;
                                                                                                                                                                                                        ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                        if (imageView10 != null) {
                                                                                                                                                                                                            i = R.id.timer_left_layout;
                                                                                                                                                                                                            ConstraintLayout constraintLayout17 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                            if (constraintLayout17 != null) {
                                                                                                                                                                                                                i = R.id.timer_switch;
                                                                                                                                                                                                                SwitchCompat switchCompat5 = (SwitchCompat) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                if (switchCompat5 != null) {
                                                                                                                                                                                                                    i = R.id.timer_value;
                                                                                                                                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                    if (textView16 != null) {
                                                                                                                                                                                                                        i = R.id.tokens_icon;
                                                                                                                                                                                                                        ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                        if (imageView11 != null) {
                                                                                                                                                                                                                            i = R.id.tokens_label_text;
                                                                                                                                                                                                                            TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                            if (textView17 != null) {
                                                                                                                                                                                                                                i = R.id.tokens_layout;
                                                                                                                                                                                                                                ConstraintLayout constraintLayout18 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                if (constraintLayout18 != null) {
                                                                                                                                                                                                                                    i = R.id.tokensOverlay;
                                                                                                                                                                                                                                    ConstraintLayout constraintLayout19 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                    if (constraintLayout19 != null) {
                                                                                                                                                                                                                                        i = R.id.turn_timer_header;
                                                                                                                                                                                                                                        TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                        if (textView18 != null) {
                                                                                                                                                                                                                                            i = R.id.turn_timer_layout;
                                                                                                                                                                                                                                            ConstraintLayout constraintLayout20 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                            if (constraintLayout20 != null) {
                                                                                                                                                                                                                                                i = R.id.turn_timer_switch;
                                                                                                                                                                                                                                                SwitchCompat switchCompat6 = (SwitchCompat) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                if (switchCompat6 != null) {
                                                                                                                                                                                                                                                    return new FragmentGameOptionsBinding((ConstraintLayout) view, gridLayout, imageView, textView, constraintLayout, constraintLayout2, imageView2, imageView3, textView2, constraintLayout3, switchCompat, textView3, imageView4, textView4, constraintLayout4, textView5, textView6, switchCompat2, switchCompat3, textView7, constraintLayout5, textView8, imageView5, textView9, constraintLayout6, imageView6, constraintLayout7, constraintLayout8, constraintLayout9, textView10, gridLayout2, monarchCoin, constraintLayout10, constraintLayout11, textView11, constraintLayout12, constraintLayout13, textView12, imageView7, imageView8, textView13, constraintLayout14, linearLayout, switchCompat4, imageView9, textView14, constraintLayout15, constraintLayout16, textView15, imageView10, constraintLayout17, switchCompat5, textView16, imageView11, textView17, constraintLayout18, constraintLayout19, textView18, constraintLayout20, switchCompat6);
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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

    public static FragmentGameOptionsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentGameOptionsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_game_options, viewGroup, false);
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
