package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentDraftTableBinding implements ViewBinding {
    public final LinearLayoutCompat leftColumn;
    public final LinearLayout mainLayout;
    public final LinearLayoutCompat middle1;
    public final LinearLayoutCompat middle2;
    public final LinearLayoutCompat middle3;
    public final LinearLayoutCompat middle4;
    public final LinearLayoutCompat middleColumn;
    public final LinearLayoutCompat rightColumn;
    private final LinearLayout rootView;
    public final TextView textViewNum1;
    public final TextView textViewNum2;
    public final TextView textViewNum3;
    public final TextView textViewNum4;
    public final TextView textViewNum5;
    public final TextView textViewNum6;
    public final TextView textViewNum7;
    public final TextView textViewNum8;
    public final TextView textViewPlayer1;
    public final TextView textViewPlayer2;
    public final TextView textViewPlayer3;
    public final TextView textViewPlayer4;
    public final TextView textViewPlayer5;
    public final TextView textViewPlayer6;
    public final TextView textViewPlayer7;
    public final TextView textViewPlayer8;

    private FragmentDraftTableBinding(LinearLayout linearLayout, LinearLayoutCompat linearLayoutCompat, LinearLayout linearLayout2, LinearLayoutCompat linearLayoutCompat2, LinearLayoutCompat linearLayoutCompat3, LinearLayoutCompat linearLayoutCompat4, LinearLayoutCompat linearLayoutCompat5, LinearLayoutCompat linearLayoutCompat6, LinearLayoutCompat linearLayoutCompat7, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16) {
        this.rootView = linearLayout;
        this.leftColumn = linearLayoutCompat;
        this.mainLayout = linearLayout2;
        this.middle1 = linearLayoutCompat2;
        this.middle2 = linearLayoutCompat3;
        this.middle3 = linearLayoutCompat4;
        this.middle4 = linearLayoutCompat5;
        this.middleColumn = linearLayoutCompat6;
        this.rightColumn = linearLayoutCompat7;
        this.textViewNum1 = textView;
        this.textViewNum2 = textView2;
        this.textViewNum3 = textView3;
        this.textViewNum4 = textView4;
        this.textViewNum5 = textView5;
        this.textViewNum6 = textView6;
        this.textViewNum7 = textView7;
        this.textViewNum8 = textView8;
        this.textViewPlayer1 = textView9;
        this.textViewPlayer2 = textView10;
        this.textViewPlayer3 = textView11;
        this.textViewPlayer4 = textView12;
        this.textViewPlayer5 = textView13;
        this.textViewPlayer6 = textView14;
        this.textViewPlayer7 = textView15;
        this.textViewPlayer8 = textView16;
    }

    public static FragmentDraftTableBinding bind(View view) {
        int i = R.id.left_column;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
        if (linearLayoutCompat != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i = R.id.middle_1;
            LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
            if (linearLayoutCompat2 != null) {
                i = R.id.middle_2;
                LinearLayoutCompat linearLayoutCompat3 = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
                if (linearLayoutCompat3 != null) {
                    i = R.id.middle_3;
                    LinearLayoutCompat linearLayoutCompat4 = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
                    if (linearLayoutCompat4 != null) {
                        i = R.id.middle_4;
                        LinearLayoutCompat linearLayoutCompat5 = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
                        if (linearLayoutCompat5 != null) {
                            i = R.id.middle_column;
                            LinearLayoutCompat linearLayoutCompat6 = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
                            if (linearLayoutCompat6 != null) {
                                i = R.id.right_column;
                                LinearLayoutCompat linearLayoutCompat7 = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
                                if (linearLayoutCompat7 != null) {
                                    i = R.id.text_view_num_1;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        i = R.id.text_view_num_2;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = R.id.text_view_num_3;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = R.id.text_view_num_4;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    i = R.id.text_view_num_5;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView5 != null) {
                                                        i = R.id.text_view_num_6;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView6 != null) {
                                                            i = R.id.text_view_num_7;
                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView7 != null) {
                                                                i = R.id.text_view_num_8;
                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView8 != null) {
                                                                    i = R.id.text_view_player_1;
                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView9 != null) {
                                                                        i = R.id.text_view_player_2;
                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView10 != null) {
                                                                            i = R.id.text_view_player_3;
                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView11 != null) {
                                                                                i = R.id.text_view_player_4;
                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView12 != null) {
                                                                                    i = R.id.text_view_player_5;
                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView13 != null) {
                                                                                        i = R.id.text_view_player_6;
                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView14 != null) {
                                                                                            i = R.id.text_view_player_7;
                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView15 != null) {
                                                                                                i = R.id.text_view_player_8;
                                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView16 != null) {
                                                                                                    return new FragmentDraftTableBinding(linearLayout, linearLayoutCompat, linearLayout, linearLayoutCompat2, linearLayoutCompat3, linearLayoutCompat4, linearLayoutCompat5, linearLayoutCompat6, linearLayoutCompat7, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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

    public static FragmentDraftTableBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDraftTableBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_draft_table, viewGroup, false);
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
