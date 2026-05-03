package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentEventSettingsBinding implements ViewBinding {
    public final SwitchCompat crossPodSwitch;
    public final TextView eventTypeTextView;
    public final Guideline guidelineEnd;
    public final Guideline guidelineStart;
    public final TextView matchTypeTextView;
    public final TextView maxRoundMinutes;
    public final EditText maxRoundsEditText;
    public final TextView maxRoundsTextView;
    public final MaterialButton nextButton;
    public final TextView numPlayersTextView;
    public final TextView pairingTypeTextView;
    public final TextView playersHeader;
    private final View rootView;
    public final SwitchCompat roundTimerSwitch;
    public final TextView roundsHeader;
    public final LinearLayout roundsLayout;
    public final TextView roundsValue;
    public final SeekBar seekBar;

    private FragmentEventSettingsBinding(View view, SwitchCompat switchCompat, TextView textView, Guideline guideline, Guideline guideline2, TextView textView2, TextView textView3, EditText editText, TextView textView4, MaterialButton materialButton, TextView textView5, TextView textView6, TextView textView7, SwitchCompat switchCompat2, TextView textView8, LinearLayout linearLayout, TextView textView9, SeekBar seekBar) {
        this.rootView = view;
        this.crossPodSwitch = switchCompat;
        this.eventTypeTextView = textView;
        this.guidelineEnd = guideline;
        this.guidelineStart = guideline2;
        this.matchTypeTextView = textView2;
        this.maxRoundMinutes = textView3;
        this.maxRoundsEditText = editText;
        this.maxRoundsTextView = textView4;
        this.nextButton = materialButton;
        this.numPlayersTextView = textView5;
        this.pairingTypeTextView = textView6;
        this.playersHeader = textView7;
        this.roundTimerSwitch = switchCompat2;
        this.roundsHeader = textView8;
        this.roundsLayout = linearLayout;
        this.roundsValue = textView9;
        this.seekBar = seekBar;
    }

    public static FragmentEventSettingsBinding bind(View view) {
        int i = R.id.cross_pod_switch;
        SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, i);
        if (switchCompat != null) {
            i = R.id.event_type_text_view;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, R.id.guideline_end);
                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, R.id.guideline_start);
                i = R.id.match_type_text_view;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.max_round_minutes;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.max_rounds_edit_text;
                        EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                        if (editText != null) {
                            i = R.id.max_rounds_text_view;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                i = R.id.next_button;
                                MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                if (materialButton != null) {
                                    i = R.id.num_players_text_view;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView5 != null) {
                                        i = R.id.pairing_type_text_view;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView6 != null) {
                                            i = R.id.players_header;
                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView7 != null) {
                                                i = R.id.round_timer_switch;
                                                SwitchCompat switchCompat2 = (SwitchCompat) ViewBindings.findChildViewById(view, i);
                                                if (switchCompat2 != null) {
                                                    i = R.id.rounds_header;
                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView8 != null) {
                                                        i = R.id.rounds_layout;
                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout != null) {
                                                            i = R.id.rounds_value;
                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView9 != null) {
                                                                i = R.id.seekBar;
                                                                SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, i);
                                                                if (seekBar != null) {
                                                                    return new FragmentEventSettingsBinding(view, switchCompat, textView, guideline, guideline2, textView2, textView3, editText, textView4, materialButton, textView5, textView6, textView7, switchCompat2, textView8, linearLayout, textView9, seekBar);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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

    public static FragmentEventSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentEventSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_event_settings, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }
}
