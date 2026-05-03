package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.preference.DialogPreference;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceDialogFragmentCompat;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FontPreviewDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/studiolaganne/lengendarylens/FontPreviewDialogFragment;", "Landroidx/preference/PreferenceDialogFragmentCompat;", "<init>", "()V", "onPrepareDialogBuilder", "", "builder", "Landroidx/appcompat/app/AlertDialog$Builder;", "onDialogClosed", "positiveResult", "", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FontPreviewDialogFragment extends PreferenceDialogFragmentCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: FontPreviewDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/studiolaganne/lengendarylens/FontPreviewDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/FontPreviewDialogFragment;", SubscriberAttributeKt.JSON_NAME_KEY, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FontPreviewDialogFragment newInstance(String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            FontPreviewDialogFragment fontPreviewDialogFragment = new FontPreviewDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString(SubscriberAttributeKt.JSON_NAME_KEY, key);
            fontPreviewDialogFragment.setArguments(bundle);
            return fontPreviewDialogFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPrepareDialogBuilder$lambda$0$0(ListPreference listPreference, CharSequence[] charSequenceArr, int i, FontPreviewDialogFragment fontPreviewDialogFragment, View view) {
        listPreference.setValue(charSequenceArr[i].toString());
        fontPreviewDialogFragment.dismiss();
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    public void onDialogClosed(boolean positiveResult) {
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    protected void onPrepareDialogBuilder(AlertDialog.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        super.onPrepareDialogBuilder(builder);
        DialogPreference preference = getPreference();
        Intrinsics.checkNotNull(preference, "null cannot be cast to non-null type androidx.preference.ListPreference");
        final ListPreference listPreference = (ListPreference) preference;
        CharSequence[] entries = listPreference.getEntries();
        final CharSequence[] entryValues = listPreference.getEntryValues();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(contextRequireContext);
        View viewInflate = layoutInflaterFrom.inflate(R.layout.dialog_font_preview, (ViewGroup) null);
        ViewGroup viewGroup = (ViewGroup) viewInflate.findViewById(R.id.font_preview_list);
        Intrinsics.checkNotNull(entries);
        int length = entries.length;
        int i = 0;
        final int i2 = 0;
        while (i < length) {
            CharSequence charSequence = entries[i];
            int i3 = i2 + 1;
            View viewInflate2 = layoutInflaterFrom.inflate(R.layout.item_font_preview, viewGroup, false);
            Intrinsics.checkNotNull(viewInflate2, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) viewInflate2;
            textView.setText(((Object) charSequence) + " - 0123456789");
            Typeface font = FontUtils.INSTANCE.getFont(contextRequireContext, entryValues[i2].toString());
            if (font == null) {
                font = Typeface.DEFAULT;
            }
            textView.setTypeface(font);
            viewGroup.addView(textView);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.FontPreviewDialogFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FontPreviewDialogFragment.onPrepareDialogBuilder$lambda$0$0(listPreference, entryValues, i2, this, view);
                }
            });
            i++;
            i2 = i3;
        }
        builder.setView(viewInflate);
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.studiolaganne.lengendarylens.FontPreviewDialogFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                dialogInterface.dismiss();
            }
        });
    }
}
