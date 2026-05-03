package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChallengesFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0016\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\bH\u0002J.\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00052\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/studiolaganne/lengendarylens/ChallengesFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "challenges", "", "Lcom/studiolaganne/lengendarylens/MTChallenge;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setChallenges", "", "setupChallengesUI", ViewHierarchyConstants.VIEW_KEY, "getLocalizedTaskText", "", "defaultText", "localization", "Lcom/studiolaganne/lengendarylens/MTEntryLocalization;", AndroidContextPlugin.LOCALE_KEY, "isName", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChallengesFragment extends Fragment {
    public static final int $stable = 8;
    private List<MTChallenge> challenges;

    private final String getLocalizedTaskText(String defaultText, List<MTEntryLocalization> localization, String locale, boolean isName) {
        if (Intrinsics.areEqual(locale, "fr")) {
            Iterator<MTEntryLocalization> it = localization.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MTEntryLocalization next = it.next();
                if (Intrinsics.areEqual(next.getLocale(), "fr")) {
                    if (isName) {
                        return next.getName();
                    }
                    String description = next.getDescription();
                    if (description == null) {
                        break;
                    }
                    return description;
                }
            }
        }
        return defaultText;
    }

    static final WindowInsetsCompat onCreateView$lambda$0(View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        v.setPadding(0, 0, 0, insets2.bottom);
        return insets;
    }

    private final void setupChallengesUI(View view) {
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.contentLayout);
        TextView textView = (TextView) view.findViewById(R.id.noChallengesTextView);
        ArrayList arrayList = new ArrayList();
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getId() != R.id.noChallengesTextView) {
                Intrinsics.checkNotNull(childAt);
                arrayList.add(childAt);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            viewGroup.removeView((View) it.next());
        }
        List<MTChallenge> list = this.challenges;
        if (list == null || list.isEmpty()) {
            textView.setVisibility(0);
            return;
        }
        textView.setVisibility(8);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        String deviceLanguage = new PreferencesManager(contextRequireContext).getDeviceLanguage();
        List<MTChallenge> list2 = this.challenges;
        Intrinsics.checkNotNull(list2);
        for (MTChallenge mTChallenge : list2) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.item_challenge, viewGroup, false);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.challengeNameTextView);
            TextView textView3 = (TextView) viewInflate.findViewById(R.id.challengeEndDateTextView);
            ViewGroup viewGroup2 = (ViewGroup) viewInflate.findViewById(R.id.tasksContainer);
            textView2.setText(mTChallenge.getName());
            for (MTEntryLocalization mTEntryLocalization : mTChallenge.getLocalization()) {
                String lowerCase = mTEntryLocalization.getLocale().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                String lowerCase2 = deviceLanguage.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                    textView2.setText(mTEntryLocalization.getName());
                }
            }
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                SimpleDateFormat simpleDateFormat2 = Intrinsics.areEqual(deviceLanguage, "fr") ? new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.FRENCH) : new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.ENGLISH);
                simpleDateFormat2.setTimeZone(TimeZone.getDefault());
                Date date = simpleDateFormat.parse(mTChallenge.getEnd_date());
                if (date != null) {
                    textView3.setText(getString(R.string.ends_on_label, simpleDateFormat2.format(date)));
                }
            } catch (Exception unused) {
                textView3.setText(getString(R.string.ends_on_label, mTChallenge.getEnd_date()));
            }
            for (MTChallengeTask mTChallengeTask : mTChallenge.getTasks()) {
                View viewInflate2 = LayoutInflater.from(getContext()).inflate(R.layout.item_challenge_task, viewGroup2, false);
                ImageView imageView = (ImageView) viewInflate2.findViewById(R.id.checkmarkImageView);
                TextView textView4 = (TextView) viewInflate2.findViewById(R.id.taskNameTextView);
                TextView textView5 = (TextView) viewInflate2.findViewById(R.id.taskDescriptionTextView);
                if (mTChallengeTask.getCompleted()) {
                    imageView.setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                }
                textView4.setText(getLocalizedTaskText(mTChallengeTask.getName(), mTChallengeTask.getLocalization(), deviceLanguage, true));
                String description = mTChallengeTask.getDescription();
                if (description != null) {
                    textView5.setText(getLocalizedTaskText(description, mTChallengeTask.getLocalization(), deviceLanguage, false));
                    textView5.setVisibility(0);
                } else {
                    textView5.setVisibility(8);
                }
                viewGroup2.addView(viewInflate2);
            }
            viewGroup.addView(viewInflate, viewGroup.getChildCount() - 1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String string;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.fragment_challenges, container, false);
        ViewCompat.setOnApplyWindowInsetsListener(viewInflate, new OnApplyWindowInsetsListener() { // from class: com.studiolaganne.lengendarylens.ChallengesFragment$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return ChallengesFragment.onCreateView$lambda$0(view, windowInsetsCompat);
            }
        });
        Bundle arguments = getArguments();
        if (arguments != null && (string = arguments.getString("challengesJson")) != null) {
            this.challenges = (List) new Gson().fromJson(string, new TypeToken<List<? extends MTChallenge>>() { // from class: com.studiolaganne.lengendarylens.ChallengesFragment$onCreateView$2$listType$1
            }.getType());
        }
        Intrinsics.checkNotNull(viewInflate);
        setupChallengesUI(viewInflate);
        return viewInflate;
    }

    public final void setChallenges(List<MTChallenge> challenges) {
        this.challenges = challenges;
        View view = getView();
        if (view != null) {
            setupChallengesUI(view);
        }
    }
}
