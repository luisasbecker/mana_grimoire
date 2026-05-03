package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.studiolaganne.lengendarylens.LoadingImageViewPlaymat;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class BottomSheetDeckBinding implements ViewBinding {
    public final ConstraintLayout autoBracketIconLayout;
    public final CheckBox autoSyncCheckbox;
    public final ImageView bColor;
    public final ImageView bMana;
    public final ConstraintLayout bracketLayout;
    public final TextView bracketNameTextView;
    public final TextView bracketValueTextView;
    public final LinearLayoutCompat buttonsLayout;
    public final ImageView cColor;
    public final ImageView cMana;
    public final ImageView chevronDown;
    public final TextView closeBracketTextView;
    public final LinearLayout colorsLayout;
    public final ImageView commanderColorB;
    public final ImageView commanderColorG;
    public final LinearLayout commanderColorOverrideLayout;
    public final ImageView commanderColorR;
    public final ImageView commanderColorU;
    public final ImageView commanderColorW;
    public final EditText commanderEditText;
    public final LinearLayout commanderLayout;
    public final TextView commanderTapToChange;
    public final TextView connectingTextView;
    public final TextView constructedType;
    public final ConstraintLayout createButtonLayout;
    public final TextView createButtonText;
    public final EditText deckName;
    public final LinearLayout externalLayout;
    public final EditText externalURL;
    public final ImageView formatChevron;
    public final LinearLayout formatLayout;
    public final TextView formatTextView;
    public final ImageView gColor;
    public final ImageView gMana;
    public final CheckBox importCheckbox;
    public final TextView limitedType;
    public final LottieAnimationView loadingAnimationView;
    public final LinearLayout manaLayout;
    public final TextView moxfieldIssueTextView;
    public final TextView openBracketTextView;
    public final ConstraintLayout overlay;
    public final ImageView partnerColorB;
    public final ImageView partnerColorG;
    public final LinearLayout partnerColorOverrideLayout;
    public final ImageView partnerColorR;
    public final ImageView partnerColorU;
    public final ImageView partnerColorW;
    public final EditText partnerEditText;
    public final LinearLayout partnerLayout;
    public final TextView partnerTapToChange;
    public final EditText playmatCardEditText;
    public final LinearLayout playmatCardLayout;
    public final TextView playmatCardTapToChange;
    public final ImageView playmatIcon;
    public final LoadingImageViewPlaymat playmatImageView;
    public final ConstraintLayout playmatLayout;
    public final TextView playmatText;
    public final TextView privacyLabel;
    public final LinearLayout privacySelectorContainer;
    public final ImageView rColor;
    public final ImageView rMana;
    public final LinearLayout rootFormatLayout;
    private final ConstraintLayout rootView;
    public final ImageView scanIconCommander;
    public final ImageView scanIconPartner;
    public final ImageView scanIconPlaymatCard;
    public final ScrollView scrollView;
    public final ImageView searchIconCommander;
    public final ImageView searchIconPartner;
    public final ImageView searchIconPlaymatCard;
    public final View spacer;
    public final ImageView spellImageBracket;
    public final LinearLayoutCompat textLayout;
    public final LinearLayout topLayout;
    public final View topSpacer;
    public final LinearLayout typeLayout;
    public final ImageView uColor;
    public final ImageView uMana;
    public final ImageView wColor;
    public final ImageView wMana;

    private BottomSheetDeckBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, CheckBox checkBox, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout3, TextView textView, TextView textView2, LinearLayoutCompat linearLayoutCompat, ImageView imageView3, ImageView imageView4, ImageView imageView5, TextView textView3, LinearLayout linearLayout, ImageView imageView6, ImageView imageView7, LinearLayout linearLayout2, ImageView imageView8, ImageView imageView9, ImageView imageView10, EditText editText, LinearLayout linearLayout3, TextView textView4, TextView textView5, TextView textView6, ConstraintLayout constraintLayout4, TextView textView7, EditText editText2, LinearLayout linearLayout4, EditText editText3, ImageView imageView11, LinearLayout linearLayout5, TextView textView8, ImageView imageView12, ImageView imageView13, CheckBox checkBox2, TextView textView9, LottieAnimationView lottieAnimationView, LinearLayout linearLayout6, TextView textView10, TextView textView11, ConstraintLayout constraintLayout5, ImageView imageView14, ImageView imageView15, LinearLayout linearLayout7, ImageView imageView16, ImageView imageView17, ImageView imageView18, EditText editText4, LinearLayout linearLayout8, TextView textView12, EditText editText5, LinearLayout linearLayout9, TextView textView13, ImageView imageView19, LoadingImageViewPlaymat loadingImageViewPlaymat, ConstraintLayout constraintLayout6, TextView textView14, TextView textView15, LinearLayout linearLayout10, ImageView imageView20, ImageView imageView21, LinearLayout linearLayout11, ImageView imageView22, ImageView imageView23, ImageView imageView24, ScrollView scrollView, ImageView imageView25, ImageView imageView26, ImageView imageView27, View view, ImageView imageView28, LinearLayoutCompat linearLayoutCompat2, LinearLayout linearLayout12, View view2, LinearLayout linearLayout13, ImageView imageView29, ImageView imageView30, ImageView imageView31, ImageView imageView32) {
        this.rootView = constraintLayout;
        this.autoBracketIconLayout = constraintLayout2;
        this.autoSyncCheckbox = checkBox;
        this.bColor = imageView;
        this.bMana = imageView2;
        this.bracketLayout = constraintLayout3;
        this.bracketNameTextView = textView;
        this.bracketValueTextView = textView2;
        this.buttonsLayout = linearLayoutCompat;
        this.cColor = imageView3;
        this.cMana = imageView4;
        this.chevronDown = imageView5;
        this.closeBracketTextView = textView3;
        this.colorsLayout = linearLayout;
        this.commanderColorB = imageView6;
        this.commanderColorG = imageView7;
        this.commanderColorOverrideLayout = linearLayout2;
        this.commanderColorR = imageView8;
        this.commanderColorU = imageView9;
        this.commanderColorW = imageView10;
        this.commanderEditText = editText;
        this.commanderLayout = linearLayout3;
        this.commanderTapToChange = textView4;
        this.connectingTextView = textView5;
        this.constructedType = textView6;
        this.createButtonLayout = constraintLayout4;
        this.createButtonText = textView7;
        this.deckName = editText2;
        this.externalLayout = linearLayout4;
        this.externalURL = editText3;
        this.formatChevron = imageView11;
        this.formatLayout = linearLayout5;
        this.formatTextView = textView8;
        this.gColor = imageView12;
        this.gMana = imageView13;
        this.importCheckbox = checkBox2;
        this.limitedType = textView9;
        this.loadingAnimationView = lottieAnimationView;
        this.manaLayout = linearLayout6;
        this.moxfieldIssueTextView = textView10;
        this.openBracketTextView = textView11;
        this.overlay = constraintLayout5;
        this.partnerColorB = imageView14;
        this.partnerColorG = imageView15;
        this.partnerColorOverrideLayout = linearLayout7;
        this.partnerColorR = imageView16;
        this.partnerColorU = imageView17;
        this.partnerColorW = imageView18;
        this.partnerEditText = editText4;
        this.partnerLayout = linearLayout8;
        this.partnerTapToChange = textView12;
        this.playmatCardEditText = editText5;
        this.playmatCardLayout = linearLayout9;
        this.playmatCardTapToChange = textView13;
        this.playmatIcon = imageView19;
        this.playmatImageView = loadingImageViewPlaymat;
        this.playmatLayout = constraintLayout6;
        this.playmatText = textView14;
        this.privacyLabel = textView15;
        this.privacySelectorContainer = linearLayout10;
        this.rColor = imageView20;
        this.rMana = imageView21;
        this.rootFormatLayout = linearLayout11;
        this.scanIconCommander = imageView22;
        this.scanIconPartner = imageView23;
        this.scanIconPlaymatCard = imageView24;
        this.scrollView = scrollView;
        this.searchIconCommander = imageView25;
        this.searchIconPartner = imageView26;
        this.searchIconPlaymatCard = imageView27;
        this.spacer = view;
        this.spellImageBracket = imageView28;
        this.textLayout = linearLayoutCompat2;
        this.topLayout = linearLayout12;
        this.topSpacer = view2;
        this.typeLayout = linearLayout13;
        this.uColor = imageView29;
        this.uMana = imageView30;
        this.wColor = imageView31;
        this.wMana = imageView32;
    }

    public static BottomSheetDeckBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.autoBracketIconLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.autoSyncCheckbox;
            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
            if (checkBox != null) {
                i = R.id.b_color;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.b_mana;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.bracketLayout;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout2 != null) {
                            i = R.id.bracketNameTextView;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.bracketValueTextView;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.buttonsLayout;
                                    LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
                                    if (linearLayoutCompat != null) {
                                        i = R.id.c_color;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView3 != null) {
                                            i = R.id.c_mana;
                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView4 != null) {
                                                i = R.id.chevron_down;
                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView5 != null) {
                                                    i = R.id.closeBracketTextView;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView3 != null) {
                                                        i = R.id.colorsLayout;
                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout != null) {
                                                            i = R.id.commander_color_b;
                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                            if (imageView6 != null) {
                                                                i = R.id.commander_color_g;
                                                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                if (imageView7 != null) {
                                                                    i = R.id.commanderColorOverrideLayout;
                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayout2 != null) {
                                                                        i = R.id.commander_color_r;
                                                                        ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                        if (imageView8 != null) {
                                                                            i = R.id.commander_color_u;
                                                                            ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                            if (imageView9 != null) {
                                                                                i = R.id.commander_color_w;
                                                                                ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                if (imageView10 != null) {
                                                                                    i = R.id.commanderEditText;
                                                                                    EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                                                                    if (editText != null) {
                                                                                        i = R.id.commanderLayout;
                                                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (linearLayout3 != null) {
                                                                                            i = R.id.commanderTapToChange;
                                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView4 != null) {
                                                                                                i = R.id.connectingTextView;
                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView5 != null) {
                                                                                                    i = R.id.constructedType;
                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView6 != null) {
                                                                                                        i = R.id.createButtonLayout;
                                                                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                        if (constraintLayout3 != null) {
                                                                                                            i = R.id.createButtonText;
                                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView7 != null) {
                                                                                                                i = R.id.deckName;
                                                                                                                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                                                                                                                if (editText2 != null) {
                                                                                                                    i = R.id.externalLayout;
                                                                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (linearLayout4 != null) {
                                                                                                                        i = R.id.externalURL;
                                                                                                                        EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (editText3 != null) {
                                                                                                                            i = R.id.formatChevron;
                                                                                                                            ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (imageView11 != null) {
                                                                                                                                i = R.id.formatLayout;
                                                                                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (linearLayout5 != null) {
                                                                                                                                    i = R.id.formatTextView;
                                                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (textView8 != null) {
                                                                                                                                        i = R.id.g_color;
                                                                                                                                        ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (imageView12 != null) {
                                                                                                                                            i = R.id.g_mana;
                                                                                                                                            ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (imageView13 != null) {
                                                                                                                                                i = R.id.importCheckbox;
                                                                                                                                                CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (checkBox2 != null) {
                                                                                                                                                    i = R.id.limitedType;
                                                                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (textView9 != null) {
                                                                                                                                                        i = R.id.loadingAnimationView;
                                                                                                                                                        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (lottieAnimationView != null) {
                                                                                                                                                            i = R.id.manaLayout;
                                                                                                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (linearLayout6 != null) {
                                                                                                                                                                i = R.id.moxfieldIssueTextView;
                                                                                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (textView10 != null) {
                                                                                                                                                                    i = R.id.openBracketTextView;
                                                                                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (textView11 != null) {
                                                                                                                                                                        i = R.id.overlay;
                                                                                                                                                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                        if (constraintLayout4 != null) {
                                                                                                                                                                            i = R.id.partner_color_b;
                                                                                                                                                                            ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                            if (imageView14 != null) {
                                                                                                                                                                                i = R.id.partner_color_g;
                                                                                                                                                                                ImageView imageView15 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                if (imageView15 != null) {
                                                                                                                                                                                    i = R.id.partnerColorOverrideLayout;
                                                                                                                                                                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                    if (linearLayout7 != null) {
                                                                                                                                                                                        i = R.id.partner_color_r;
                                                                                                                                                                                        ImageView imageView16 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                        if (imageView16 != null) {
                                                                                                                                                                                            i = R.id.partner_color_u;
                                                                                                                                                                                            ImageView imageView17 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                            if (imageView17 != null) {
                                                                                                                                                                                                i = R.id.partner_color_w;
                                                                                                                                                                                                ImageView imageView18 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                if (imageView18 != null) {
                                                                                                                                                                                                    i = R.id.partnerEditText;
                                                                                                                                                                                                    EditText editText4 = (EditText) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                    if (editText4 != null) {
                                                                                                                                                                                                        i = R.id.partnerLayout;
                                                                                                                                                                                                        LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                        if (linearLayout8 != null) {
                                                                                                                                                                                                            i = R.id.partnerTapToChange;
                                                                                                                                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                            if (textView12 != null) {
                                                                                                                                                                                                                i = R.id.playmatCardEditText;
                                                                                                                                                                                                                EditText editText5 = (EditText) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                if (editText5 != null) {
                                                                                                                                                                                                                    i = R.id.playmatCardLayout;
                                                                                                                                                                                                                    LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                    if (linearLayout9 != null) {
                                                                                                                                                                                                                        i = R.id.playmatCardTapToChange;
                                                                                                                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                        if (textView13 != null) {
                                                                                                                                                                                                                            i = R.id.playmatIcon;
                                                                                                                                                                                                                            ImageView imageView19 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                            if (imageView19 != null) {
                                                                                                                                                                                                                                i = R.id.playmatImageView;
                                                                                                                                                                                                                                LoadingImageViewPlaymat loadingImageViewPlaymat = (LoadingImageViewPlaymat) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                if (loadingImageViewPlaymat != null) {
                                                                                                                                                                                                                                    i = R.id.playmatLayout;
                                                                                                                                                                                                                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                    if (constraintLayout5 != null) {
                                                                                                                                                                                                                                        i = R.id.playmatText;
                                                                                                                                                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                        if (textView14 != null) {
                                                                                                                                                                                                                                            i = R.id.privacyLabel;
                                                                                                                                                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                            if (textView15 != null) {
                                                                                                                                                                                                                                                i = R.id.privacySelectorContainer;
                                                                                                                                                                                                                                                LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                if (linearLayout10 != null) {
                                                                                                                                                                                                                                                    i = R.id.r_color;
                                                                                                                                                                                                                                                    ImageView imageView20 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                    if (imageView20 != null) {
                                                                                                                                                                                                                                                        i = R.id.r_mana;
                                                                                                                                                                                                                                                        ImageView imageView21 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                        if (imageView21 != null) {
                                                                                                                                                                                                                                                            i = R.id.rootFormatLayout;
                                                                                                                                                                                                                                                            LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                            if (linearLayout11 != null) {
                                                                                                                                                                                                                                                                i = R.id.scanIconCommander;
                                                                                                                                                                                                                                                                ImageView imageView22 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                if (imageView22 != null) {
                                                                                                                                                                                                                                                                    i = R.id.scanIconPartner;
                                                                                                                                                                                                                                                                    ImageView imageView23 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                    if (imageView23 != null) {
                                                                                                                                                                                                                                                                        i = R.id.scanIconPlaymatCard;
                                                                                                                                                                                                                                                                        ImageView imageView24 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                        if (imageView24 != null) {
                                                                                                                                                                                                                                                                            i = R.id.scrollView;
                                                                                                                                                                                                                                                                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                            if (scrollView != null) {
                                                                                                                                                                                                                                                                                i = R.id.searchIconCommander;
                                                                                                                                                                                                                                                                                ImageView imageView25 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                if (imageView25 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.searchIconPartner;
                                                                                                                                                                                                                                                                                    ImageView imageView26 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                    if (imageView26 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.searchIconPlaymatCard;
                                                                                                                                                                                                                                                                                        ImageView imageView27 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                        if (imageView27 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.spacer))) != null) {
                                                                                                                                                                                                                                                                                            i = R.id.spellImageBracket;
                                                                                                                                                                                                                                                                                            ImageView imageView28 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                            if (imageView28 != null) {
                                                                                                                                                                                                                                                                                                i = R.id.textLayout;
                                                                                                                                                                                                                                                                                                LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                if (linearLayoutCompat2 != null) {
                                                                                                                                                                                                                                                                                                    i = R.id.topLayout;
                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                    if (linearLayout12 != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.top_spacer))) != null) {
                                                                                                                                                                                                                                                                                                        i = R.id.typeLayout;
                                                                                                                                                                                                                                                                                                        LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                        if (linearLayout13 != null) {
                                                                                                                                                                                                                                                                                                            i = R.id.u_color;
                                                                                                                                                                                                                                                                                                            ImageView imageView29 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                            if (imageView29 != null) {
                                                                                                                                                                                                                                                                                                                i = R.id.u_mana;
                                                                                                                                                                                                                                                                                                                ImageView imageView30 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                                if (imageView30 != null) {
                                                                                                                                                                                                                                                                                                                    i = R.id.w_color;
                                                                                                                                                                                                                                                                                                                    ImageView imageView31 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                                    if (imageView31 != null) {
                                                                                                                                                                                                                                                                                                                        i = R.id.w_mana;
                                                                                                                                                                                                                                                                                                                        ImageView imageView32 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                                                        if (imageView32 != null) {
                                                                                                                                                                                                                                                                                                                            return new BottomSheetDeckBinding((ConstraintLayout) view, constraintLayout, checkBox, imageView, imageView2, constraintLayout2, textView, textView2, linearLayoutCompat, imageView3, imageView4, imageView5, textView3, linearLayout, imageView6, imageView7, linearLayout2, imageView8, imageView9, imageView10, editText, linearLayout3, textView4, textView5, textView6, constraintLayout3, textView7, editText2, linearLayout4, editText3, imageView11, linearLayout5, textView8, imageView12, imageView13, checkBox2, textView9, lottieAnimationView, linearLayout6, textView10, textView11, constraintLayout4, imageView14, imageView15, linearLayout7, imageView16, imageView17, imageView18, editText4, linearLayout8, textView12, editText5, linearLayout9, textView13, imageView19, loadingImageViewPlaymat, constraintLayout5, textView14, textView15, linearLayout10, imageView20, imageView21, linearLayout11, imageView22, imageView23, imageView24, scrollView, imageView25, imageView26, imageView27, viewFindChildViewById, imageView28, linearLayoutCompat2, linearLayout12, viewFindChildViewById2, linearLayout13, imageView29, imageView30, imageView31, imageView32);
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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

    public static BottomSheetDeckBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BottomSheetDeckBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.bottom_sheet_deck, viewGroup, false);
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
