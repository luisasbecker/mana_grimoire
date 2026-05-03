package androidx.credentials.provider;

import android.app.PendingIntent;
import android.app.slice.Slice;
import android.app.slice.SliceItem;
import android.app.slice.SliceSpec;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.credentials.R;
import androidx.credentials.provider.utils.CryptoObjectUtils;
import com.facebook.appevents.internal.Constants;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.time.Instant;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomCredentialEntry.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0007\u0018\u0000 32\u00020\u0001:\u000501234B¡\u0001\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u0012\b\b\u0002\u0010\u0019\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001bBa\b\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001eB\u0081\u0001\b\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u001a\u0010\u001fBu\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010 R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010'R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010$R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u000e\u0010\u0018\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010.\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b.\u0010'R\u0011\u0010/\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b/\u0010'¨\u00065"}, d2 = {"Landroidx/credentials/provider/CustomCredentialEntry;", "Landroidx/credentials/provider/CredentialEntry;", "type", "", Constants.GP_IAP_TITLE, "", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "isAutoSelectAllowed", "", "subtitle", "typeDisplayName", "icon", "Landroid/graphics/drawable/Icon;", "lastUsedTime", "Ljava/time/Instant;", "beginGetCredentialOption", "Landroidx/credentials/provider/BeginGetCredentialOption;", "isDefaultIconPreferredAsSingleProvider", "entryGroupId", "affiliatedDomain", "biometricPromptData", "Landroidx/credentials/provider/BiometricPromptData;", "autoSelectAllowedFromOption", "isCreatedFromSlice", "isDefaultIconFromSlice", "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;Landroid/app/PendingIntent;ZLjava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/graphics/drawable/Icon;Ljava/time/Instant;Landroidx/credentials/provider/BeginGetCredentialOption;ZLjava/lang/CharSequence;Ljava/lang/CharSequence;Landroidx/credentials/provider/BiometricPromptData;ZZZ)V", "context", "Landroid/content/Context;", "(Landroid/content/Context;Ljava/lang/CharSequence;Landroid/app/PendingIntent;Landroidx/credentials/provider/BeginGetCredentialOption;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/time/Instant;Landroid/graphics/drawable/Icon;Z)V", "(Landroid/content/Context;Ljava/lang/CharSequence;Landroid/app/PendingIntent;Landroidx/credentials/provider/BeginGetCredentialOption;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/time/Instant;Landroid/graphics/drawable/Icon;ZLjava/lang/CharSequence;ZLandroidx/credentials/provider/BiometricPromptData;)V", "(Landroid/content/Context;Ljava/lang/CharSequence;Landroid/app/PendingIntent;Landroidx/credentials/provider/BeginGetCredentialOption;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/time/Instant;Landroid/graphics/drawable/Icon;ZLjava/lang/CharSequence;Z)V", "getType", "()Ljava/lang/String;", "getTitle", "()Ljava/lang/CharSequence;", "getPendingIntent", "()Landroid/app/PendingIntent;", "()Z", "getSubtitle", "getTypeDisplayName", "getIcon", "()Landroid/graphics/drawable/Icon;", "getLastUsedTime", "()Ljava/time/Instant;", "isAutoSelectAllowedFromOption", "hasDefaultIcon", "Api34Impl", "Api35Impl", "Api28Impl", "Companion", "Builder", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomCredentialEntry extends CredentialEntry {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "CredentialEntry";
    private final Icon icon;
    private final boolean isAutoSelectAllowed;
    private final boolean isAutoSelectAllowedFromOption;
    private boolean isCreatedFromSlice;
    private boolean isDefaultIconFromSlice;
    private final Instant lastUsedTime;
    private final PendingIntent pendingIntent;
    private final CharSequence subtitle;
    private final CharSequence title;
    private final String type;
    private final CharSequence typeDisplayName;

    /* JADX INFO: compiled from: CustomCredentialEntry.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\tH\u0007¨\u0006\u0010"}, d2 = {"Landroidx/credentials/provider/CustomCredentialEntry$Api28Impl;", "", "<init>", "()V", "isDefaultIcon", "", "entry", "Landroidx/credentials/provider/CustomCredentialEntry;", "toSlice", "Landroid/app/slice/Slice;", "addToSlice", "", "sliceBuilder", "Landroid/app/slice/Slice$Builder;", "fromSlice", "slice", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Api28Impl {
        public static final Api28Impl INSTANCE = new Api28Impl();

        private Api28Impl() {
        }

        @JvmStatic
        public static final CustomCredentialEntry fromSlice(Slice slice) {
            Iterator it;
            Intrinsics.checkNotNullParameter(slice, "slice");
            SliceSpec spec = slice.getSpec();
            Intrinsics.checkNotNull(spec);
            String type = spec.getType();
            Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            List<SliceItem> items = slice.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "getItems(...)");
            Iterator it2 = items.iterator();
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            CharSequence text = null;
            CharSequence text2 = null;
            PendingIntent action = null;
            CharSequence text3 = null;
            CharSequence text4 = null;
            Icon icon = null;
            Instant instantOfEpochMilli = null;
            CharSequence text5 = null;
            CharSequence text6 = null;
            while (it2.hasNext()) {
                SliceItem sliceItem = (SliceItem) it2.next();
                if (sliceItem.hasHint(CredentialEntry.SLICE_HINT_OPTION_ID)) {
                    text = sliceItem.getText();
                } else if (sliceItem.hasHint(CredentialEntry.SLICE_HINT_DEDUPLICATION_ID)) {
                    text5 = sliceItem.getText();
                } else {
                    it = it2;
                    if (sliceItem.hasHint(CredentialEntry.SLICE_HINT_IS_DEFAULT_ICON_PREFERRED)) {
                        if (Intrinsics.areEqual(sliceItem.getText(), "true")) {
                            z2 = true;
                        }
                    } else if (sliceItem.hasHint(CredentialEntry.SLICE_HINT_AFFILIATED_DOMAIN)) {
                        text6 = sliceItem.getText();
                    } else if (sliceItem.hasHint(CredentialEntry.SLICE_HINT_TYPE_DISPLAY_NAME)) {
                        text4 = sliceItem.getText();
                    } else if (sliceItem.hasHint(CredentialEntry.SLICE_HINT_TITLE)) {
                        text2 = sliceItem.getText();
                    } else if (sliceItem.hasHint(CredentialEntry.SLICE_HINT_SUBTITLE)) {
                        text3 = sliceItem.getText();
                    } else if (sliceItem.hasHint(CredentialEntry.SLICE_HINT_ICON)) {
                        icon = sliceItem.getIcon();
                    } else if (sliceItem.hasHint(CredentialEntry.SLICE_HINT_PENDING_INTENT)) {
                        action = sliceItem.getAction();
                    } else if (sliceItem.hasHint(CredentialEntry.SLICE_HINT_LAST_USED_TIME_MILLIS)) {
                        instantOfEpochMilli = Instant.ofEpochMilli(sliceItem.getLong());
                    } else if (sliceItem.hasHint(CredentialEntry.SLICE_HINT_AUTO_ALLOWED)) {
                        if (Intrinsics.areEqual(sliceItem.getText(), "true")) {
                            z = true;
                        }
                    } else if (sliceItem.hasHint(CredentialEntry.SLICE_HINT_AUTO_SELECT_FROM_OPTION)) {
                        z3 = true;
                    } else if (sliceItem.hasHint(CredentialEntry.SLICE_HINT_DEFAULT_ICON_RES_ID)) {
                        z4 = true;
                    }
                    it2 = it;
                }
                it = it2;
                it2 = it;
            }
            try {
                Intrinsics.checkNotNull(text2);
                Intrinsics.checkNotNull(action);
                Intrinsics.checkNotNull(icon);
                Intrinsics.checkNotNull(text);
                return new CustomCredentialEntry(type, text2, action, z, text3, text4, icon, instantOfEpochMilli, new BeginGetCustomCredentialOption(text.toString(), type, new Bundle()), z2, text5, text6, null, z3, true, z4, 4096, null);
            } catch (Exception e) {
                Log.i(CustomCredentialEntry.TAG, "fromSlice failed with: " + e.getMessage());
                return null;
            }
        }

        @JvmStatic
        public static final boolean isDefaultIcon(CustomCredentialEntry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            return entry.isCreatedFromSlice ? entry.isDefaultIconFromSlice : entry.getIcon().getType() == 2 && entry.getIcon().getResId() == R.drawable.adx_ic_other_sign_in;
        }

        @JvmStatic
        public static final Slice toSlice(CustomCredentialEntry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            Slice.Builder builder = new Slice.Builder(Uri.EMPTY, new SliceSpec(entry.getType(), 1));
            INSTANCE.addToSlice(entry, builder);
            Slice sliceBuild = builder.build();
            Intrinsics.checkNotNullExpressionValue(sliceBuild, "build(...)");
            return sliceBuild;
        }

        public final void addToSlice(CustomCredentialEntry entry, Slice.Builder sliceBuilder) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            Intrinsics.checkNotNullParameter(sliceBuilder, "sliceBuilder");
            BeginGetCredentialOption beginGetCredentialOption = entry.getBeginGetCredentialOption();
            sliceBuilder.addText(beginGetCredentialOption.getId(), null, CollectionsKt.listOf(CredentialEntry.SLICE_HINT_OPTION_ID)).addText(entry.getEntryGroupId(), null, CollectionsKt.listOf(CredentialEntry.SLICE_HINT_DEDUPLICATION_ID)).addText(entry.getIsDefaultIconPreferredAsSingleProvider() ? "true" : CredentialEntry.FALSE_STRING, null, CollectionsKt.listOf(CredentialEntry.SLICE_HINT_IS_DEFAULT_ICON_PREFERRED)).addText(entry.getAffiliatedDomain(), null, CollectionsKt.listOf(CredentialEntry.SLICE_HINT_AFFILIATED_DOMAIN));
            CharSequence title = entry.getTitle();
            CharSequence subtitle = entry.getSubtitle();
            PendingIntent pendingIntent = entry.getPendingIntent();
            CharSequence typeDisplayName = entry.getTypeDisplayName();
            Instant lastUsedTime = entry.getLastUsedTime();
            sliceBuilder.addText(typeDisplayName, null, CollectionsKt.listOf(CredentialEntry.SLICE_HINT_TYPE_DISPLAY_NAME)).addText(title, null, CollectionsKt.listOf(CredentialEntry.SLICE_HINT_TITLE)).addText(subtitle, null, CollectionsKt.listOf(CredentialEntry.SLICE_HINT_SUBTITLE)).addText(entry.getIsAutoSelectAllowed() ? "true" : CredentialEntry.FALSE_STRING, null, CollectionsKt.listOf(CredentialEntry.SLICE_HINT_AUTO_ALLOWED)).addIcon(entry.getIcon(), null, CollectionsKt.listOf(CredentialEntry.SLICE_HINT_ICON));
            try {
                if (entry.hasDefaultIcon()) {
                    sliceBuilder.addInt(1, null, CollectionsKt.listOf(CredentialEntry.SLICE_HINT_DEFAULT_ICON_RES_ID));
                }
            } catch (IllegalStateException unused) {
            }
            if (entry.getIsAutoSelectAllowedFromOption()) {
                sliceBuilder.addInt(1, null, CollectionsKt.listOf(CredentialEntry.SLICE_HINT_AUTO_SELECT_FROM_OPTION));
            }
            if (lastUsedTime != null) {
                sliceBuilder.addLong(lastUsedTime.toEpochMilli(), null, CollectionsKt.listOf(CredentialEntry.SLICE_HINT_LAST_USED_TIME_MILLIS));
            }
            sliceBuilder.addAction(pendingIntent, new Slice.Builder(sliceBuilder).addHints(Collections.singletonList(CredentialEntry.SLICE_HINT_PENDING_INTENT)).build(), null);
        }
    }

    /* JADX INFO: compiled from: CustomCredentialEntry.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Landroidx/credentials/provider/CustomCredentialEntry$Api34Impl;", "", "<init>", "()V", "fromCredentialEntry", "Landroidx/credentials/provider/CustomCredentialEntry;", "credentialEntry", "Landroid/service/credentials/CredentialEntry;", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Api34Impl {
        public static final Api34Impl INSTANCE = new Api34Impl();

        private Api34Impl() {
        }

        @JvmStatic
        public static final CustomCredentialEntry fromCredentialEntry(android.service.credentials.CredentialEntry credentialEntry) {
            Intrinsics.checkNotNullParameter(credentialEntry, "credentialEntry");
            Slice slice = credentialEntry.getSlice();
            Intrinsics.checkNotNullExpressionValue(slice, "getSlice(...)");
            return CustomCredentialEntry.INSTANCE.fromSlice(slice);
        }
    }

    /* JADX INFO: compiled from: CustomCredentialEntry.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u0005H\u0007¨\u0006\u000e"}, d2 = {"Landroidx/credentials/provider/CustomCredentialEntry$Api35Impl;", "", "<init>", "()V", "toSlice", "Landroid/app/slice/Slice;", "entry", "Landroidx/credentials/provider/CustomCredentialEntry;", "addToSlice", "", "sliceBuilder", "Landroid/app/slice/Slice$Builder;", "fromSlice", "slice", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Api35Impl {
        public static final Api35Impl INSTANCE = new Api35Impl();

        private Api35Impl() {
        }

        @JvmStatic
        public static final CustomCredentialEntry fromSlice(Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "slice");
            CustomCredentialEntry customCredentialEntryFromSlice = Api28Impl.fromSlice(slice);
            if (customCredentialEntryFromSlice == null) {
                return null;
            }
            List<SliceItem> items = slice.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "getItems(...)");
            Bundle bundle = null;
            for (SliceItem sliceItem : items) {
                if (sliceItem.hasHint(CredentialEntry.SLICE_HINT_BIOMETRIC_PROMPT_DATA)) {
                    bundle = sliceItem.getBundle();
                }
            }
            try {
                return new CustomCredentialEntry(customCredentialEntryFromSlice.getType(), customCredentialEntryFromSlice.getTitle(), customCredentialEntryFromSlice.getPendingIntent(), customCredentialEntryFromSlice.getIsAutoSelectAllowed(), customCredentialEntryFromSlice.getSubtitle(), customCredentialEntryFromSlice.getTypeDisplayName(), customCredentialEntryFromSlice.getIcon(), customCredentialEntryFromSlice.getLastUsedTime(), customCredentialEntryFromSlice.getBeginGetCredentialOption(), customCredentialEntryFromSlice.getIsDefaultIconPreferredAsSingleProvider(), customCredentialEntryFromSlice.getEntryGroupId(), customCredentialEntryFromSlice.getAffiliatedDomain(), bundle != null ? BiometricPromptData.INSTANCE.fromBundle(bundle) : null, customCredentialEntryFromSlice.getIsAutoSelectAllowedFromOption(), true, customCredentialEntryFromSlice.isDefaultIconFromSlice);
            } catch (Exception e) {
                Log.i(CustomCredentialEntry.TAG, "fromSlice failed with: " + e.getMessage());
                return null;
            }
        }

        @JvmStatic
        public static final Slice toSlice(CustomCredentialEntry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            Slice.Builder builder = new Slice.Builder(Uri.EMPTY, new SliceSpec(entry.getType(), 1));
            Api28Impl.INSTANCE.addToSlice(entry, builder);
            INSTANCE.addToSlice(entry, builder);
            Slice sliceBuild = builder.build();
            Intrinsics.checkNotNullExpressionValue(sliceBuild, "build(...)");
            return sliceBuild;
        }

        public final void addToSlice(CustomCredentialEntry entry, Slice.Builder sliceBuilder) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            Intrinsics.checkNotNullParameter(sliceBuilder, "sliceBuilder");
            BiometricPromptData biometricPromptData = entry.getBiometricPromptData();
            if (biometricPromptData != null) {
                sliceBuilder.addInt(biometricPromptData.getAllowedAuthenticators(), null, CollectionsKt.listOf(CredentialEntry.SLICE_HINT_ALLOWED_AUTHENTICATORS));
                if (biometricPromptData.getCryptoObject() != null) {
                    sliceBuilder.addLong(CryptoObjectUtils.INSTANCE.getOperationHandle(biometricPromptData.getCryptoObject()), null, CollectionsKt.listOf(CredentialEntry.SLICE_HINT_CRYPTO_OP_ID));
                }
                sliceBuilder.addBundle(BiometricPromptData.INSTANCE.toBundle(biometricPromptData), null, CollectionsKt.listOf(CredentialEntry.SLICE_HINT_BIOMETRIC_PROMPT_DATA));
            }
        }
    }

    /* JADX INFO: compiled from: CustomCredentialEntry.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u0012\u0010\u001d\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0007J\u0010\u0010 \u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0015J\u0006\u0010\"\u001a\u00020#R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Landroidx/credentials/provider/CustomCredentialEntry$Builder;", "", "context", "Landroid/content/Context;", "type", "", Constants.GP_IAP_TITLE, "", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "beginGetCredentialOption", "Landroidx/credentials/provider/BeginGetCredentialOption;", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/CharSequence;Landroid/app/PendingIntent;Landroidx/credentials/provider/BeginGetCredentialOption;)V", "subtitle", "lastUsedTime", "Ljava/time/Instant;", "typeDisplayName", "icon", "Landroid/graphics/drawable/Icon;", "autoSelectAllowed", "", "entryGroupId", "isDefaultIconPreferredAsSingleProvider", "biometricPromptData", "Landroidx/credentials/provider/BiometricPromptData;", "setSubtitle", "setTypeDisplayName", "setIcon", "setBiometricPromptData", "setAutoSelectAllowed", "setEntryGroupId", "setLastUsedTime", "setDefaultIconPreferredAsSingleProvider", "build", "Landroidx/credentials/provider/CustomCredentialEntry;", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder {
        private boolean autoSelectAllowed;
        private final BeginGetCredentialOption beginGetCredentialOption;
        private BiometricPromptData biometricPromptData;
        private final Context context;
        private CharSequence entryGroupId;
        private Icon icon;
        private boolean isDefaultIconPreferredAsSingleProvider;
        private Instant lastUsedTime;
        private final PendingIntent pendingIntent;
        private CharSequence subtitle;
        private final CharSequence title;
        private final String type;
        private CharSequence typeDisplayName;

        public Builder(Context context, String type, CharSequence title, PendingIntent pendingIntent, BeginGetCredentialOption beginGetCredentialOption) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
            Intrinsics.checkNotNullParameter(beginGetCredentialOption, "beginGetCredentialOption");
            this.context = context;
            this.type = type;
            this.title = title;
            this.pendingIntent = pendingIntent;
            this.beginGetCredentialOption = beginGetCredentialOption;
            this.entryGroupId = title;
        }

        public final CustomCredentialEntry build() {
            if (this.icon == null) {
                this.icon = Icon.createWithResource(this.context, R.drawable.adx_ic_other_sign_in);
            }
            String str = this.type;
            CharSequence charSequence = this.title;
            PendingIntent pendingIntent = this.pendingIntent;
            boolean z = this.autoSelectAllowed;
            CharSequence charSequence2 = this.subtitle;
            CharSequence charSequence3 = this.typeDisplayName;
            Icon icon = this.icon;
            Intrinsics.checkNotNull(icon);
            return new CustomCredentialEntry(str, charSequence, pendingIntent, z, charSequence2, charSequence3, icon, this.lastUsedTime, this.beginGetCredentialOption, this.isDefaultIconPreferredAsSingleProvider, this.entryGroupId, null, this.biometricPromptData, false, false, false, 59392, null);
        }

        public final Builder setAutoSelectAllowed(boolean autoSelectAllowed) {
            this.autoSelectAllowed = autoSelectAllowed;
            return this;
        }

        public final Builder setBiometricPromptData(BiometricPromptData biometricPromptData) {
            this.biometricPromptData = biometricPromptData;
            return this;
        }

        public final Builder setDefaultIconPreferredAsSingleProvider(boolean isDefaultIconPreferredAsSingleProvider) {
            this.isDefaultIconPreferredAsSingleProvider = isDefaultIconPreferredAsSingleProvider;
            return this;
        }

        public final Builder setEntryGroupId(CharSequence entryGroupId) {
            Intrinsics.checkNotNullParameter(entryGroupId, "entryGroupId");
            if (entryGroupId.length() <= 0) {
                throw new IllegalArgumentException("entryGroupId must not be empty".toString());
            }
            this.entryGroupId = entryGroupId;
            return this;
        }

        public final Builder setIcon(Icon icon) {
            Intrinsics.checkNotNullParameter(icon, "icon");
            this.icon = icon;
            return this;
        }

        public final Builder setLastUsedTime(Instant lastUsedTime) {
            this.lastUsedTime = lastUsedTime;
            return this;
        }

        public final Builder setSubtitle(CharSequence subtitle) {
            this.subtitle = subtitle;
            return this;
        }

        public final Builder setTypeDisplayName(CharSequence typeDisplayName) {
            this.typeDisplayName = typeDisplayName;
            return this;
        }
    }

    /* JADX INFO: compiled from: CustomCredentialEntry.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0007J!\u0010\u000f\u001a\u00020\u0010*\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015J'\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/credentials/provider/CustomCredentialEntry$Companion;", "", "<init>", "()V", "TAG", "", "toSlice", "Landroid/app/slice/Slice;", "entry", "Landroidx/credentials/provider/CustomCredentialEntry;", "fromSlice", "slice", "fromCredentialEntry", "credentialEntry", "Landroid/service/credentials/CredentialEntry;", "marshall", "", "bundle", "Landroid/os/Bundle;", FirebaseAnalytics.Param.INDEX, "", "marshall$credentials", "unmarshall", "type", "unmarshall$credentials", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final CustomCredentialEntry fromCredentialEntry(android.service.credentials.CredentialEntry credentialEntry) {
            Intrinsics.checkNotNullParameter(credentialEntry, "credentialEntry");
            if (Build.VERSION.SDK_INT >= 34) {
                return Api34Impl.fromCredentialEntry(credentialEntry);
            }
            return null;
        }

        @JvmStatic
        public final CustomCredentialEntry fromSlice(Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "slice");
            if (Build.VERSION.SDK_INT >= 35) {
                return Api35Impl.fromSlice(slice);
            }
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.fromSlice(slice);
            }
            return null;
        }

        public final void marshall$credentials(CustomCredentialEntry customCredentialEntry, Bundle bundle, int i) {
            Intrinsics.checkNotNullParameter(customCredentialEntry, "<this>");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            CredentialEntry.INSTANCE.marshallCommonProperties$credentials(customCredentialEntry, bundle, i);
            bundle.putParcelable(CredentialEntry.EXTRA_CREDENTIAL_ENTRY_PENDING_INTENT_PREFIX + i, customCredentialEntry.getPendingIntent());
            bundle.putBoolean(CredentialEntry.EXTRA_CREDENTIAL_ENTRY_IS_AUTO_SELECT_ALLOWED_PREFIX + i, customCredentialEntry.getIsAutoSelectAllowed());
            bundle.putBoolean(CredentialEntry.EXTRA_CREDENTIAL_ENTRY_IS_AUTO_SELECT_ALLOWED_FROM_OPTION_PREFIX + i, customCredentialEntry.getIsAutoSelectAllowedFromOption());
            bundle.putBoolean(CredentialEntry.EXTRA_CREDENTIAL_ENTRY_HAS_DEFAULT_ICON_PREFIX + i, customCredentialEntry.hasDefaultIcon());
            bundle.putCharSequence(CredentialEntry.EXTRA_CREDENTIAL_TITLE_PREFIX + i, customCredentialEntry.getTitle());
            bundle.putCharSequence(CredentialEntry.EXTRA_CREDENTIAL_TYPE_DISPLAY_NAME_PREFIX + i, customCredentialEntry.getTypeDisplayName());
            bundle.putParcelable(CredentialEntry.EXTRA_CREDENTIAL_TYPE_ICON_PREFIX + i, customCredentialEntry.getIcon());
            CharSequence subtitle = customCredentialEntry.getSubtitle();
            if (subtitle != null) {
                bundle.putCharSequence(CredentialEntry.EXTRA_CREDENTIAL_SUBTITLE_PREFIX + i, subtitle);
            }
            Instant lastUsedTime = customCredentialEntry.getLastUsedTime();
            if (lastUsedTime != null) {
                bundle.putLong(CredentialEntry.EXTRA_CREDENTIAL_ENTRY_LAST_USED_TIME_MILLIS_PREFIX + i, lastUsedTime.toEpochMilli());
            }
        }

        @JvmStatic
        public final Slice toSlice(CustomCredentialEntry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            if (Build.VERSION.SDK_INT >= 35) {
                return Api35Impl.toSlice(entry);
            }
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.toSlice(entry);
            }
            return null;
        }

        public final CustomCredentialEntry unmarshall$credentials(Bundle bundle, int index, String type) {
            Instant instantOfEpochMilli;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(type, "type");
            try {
                String string = bundle.getString(CredentialEntry.EXTRA_CREDENTIAL_ENTRY_OPTION_ID_PREFIX + index);
                Intrinsics.checkNotNull(string);
                Bundle bundle2 = bundle.getBundle(CredentialEntry.EXTRA_CREDENTIAL_ENTRY_OPTION_DATA_PREFIX + index);
                Intrinsics.checkNotNull(bundle2);
                CharSequence charSequence = bundle.getCharSequence(CredentialEntry.EXTRA_CREDENTIAL_ENTRY_ENTRY_GROUP_ID_PREFIX + index);
                boolean z = bundle.getBoolean(CredentialEntry.EXTRA_CREDENTIAL_ENTRY_IS_DEFAULT_ICON_PREFERRED_AS_SINGLE_PROV_PREFIX + index, false);
                CharSequence charSequence2 = bundle.getCharSequence(CredentialEntry.EXTRA_CREDENTIAL_ENTRY_AFFILIATED_DOMAIN_PREFIX + index);
                Parcelable parcelable = bundle.getParcelable(CredentialEntry.EXTRA_CREDENTIAL_ENTRY_PENDING_INTENT_PREFIX + index);
                Intrinsics.checkNotNull(parcelable);
                PendingIntent pendingIntent = (PendingIntent) parcelable;
                boolean z2 = bundle.getBoolean(CredentialEntry.EXTRA_CREDENTIAL_ENTRY_IS_AUTO_SELECT_ALLOWED_PREFIX + index, false);
                boolean z3 = bundle.getBoolean(CredentialEntry.EXTRA_CREDENTIAL_ENTRY_IS_AUTO_SELECT_ALLOWED_FROM_OPTION_PREFIX + index, false);
                boolean z4 = bundle.getBoolean(CredentialEntry.EXTRA_CREDENTIAL_ENTRY_HAS_DEFAULT_ICON_PREFIX + index, false);
                CharSequence charSequence3 = bundle.getCharSequence(CredentialEntry.EXTRA_CREDENTIAL_TITLE_PREFIX + index);
                Intrinsics.checkNotNull(charSequence3);
                CharSequence charSequence4 = bundle.getCharSequence(CredentialEntry.EXTRA_CREDENTIAL_TYPE_DISPLAY_NAME_PREFIX + index);
                Parcelable parcelable2 = bundle.getParcelable(CredentialEntry.EXTRA_CREDENTIAL_TYPE_ICON_PREFIX + index);
                Intrinsics.checkNotNull(parcelable2);
                Icon icon = (Icon) parcelable2;
                CharSequence charSequence5 = bundle.getCharSequence(CredentialEntry.EXTRA_CREDENTIAL_SUBTITLE_PREFIX + index);
                if (bundle.containsKey(CredentialEntry.EXTRA_CREDENTIAL_ENTRY_LAST_USED_TIME_MILLIS_PREFIX + index)) {
                    try {
                        instantOfEpochMilli = Instant.ofEpochMilli(bundle.getLong(CredentialEntry.EXTRA_CREDENTIAL_ENTRY_LAST_USED_TIME_MILLIS_PREFIX + index));
                    } catch (Exception unused) {
                        instantOfEpochMilli = null;
                    }
                } else {
                    instantOfEpochMilli = null;
                }
                return new CustomCredentialEntry(type, charSequence3, pendingIntent, z2, charSequence5, charSequence4, icon, instantOfEpochMilli, new BeginGetCustomCredentialOption(string, type, bundle2), z, charSequence, charSequence2, null, z3, true, z4);
            } catch (Exception unused2) {
                return null;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the constructor that allows setting all parameters.", replaceWith = @ReplaceWith(expression = "CustomCredentialEntry(context, title, pendingIntent,beginGetCredentialOption, subtitle, typeDisplayName, lastUsedTime, icon, isAutoSelectAllowed, entryGroupId, isDefaultIconPreferredAsSingleProvider,biometricPromptData)", imports = {}))
    public /* synthetic */ CustomCredentialEntry(Context context, CharSequence title, PendingIntent pendingIntent, BeginGetCredentialOption beginGetCredentialOption, CharSequence charSequence, CharSequence charSequence2, Instant instant, Icon icon, boolean z) {
        this(beginGetCredentialOption.getType(), title, pendingIntent, z, charSequence, charSequence2, icon, instant, beginGetCredentialOption, false, null, null, null, false, false, false, 64512, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        Intrinsics.checkNotNullParameter(beginGetCredentialOption, "beginGetCredentialOption");
        Intrinsics.checkNotNullParameter(icon, "icon");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CustomCredentialEntry(Context context, CharSequence charSequence, PendingIntent pendingIntent, BeginGetCredentialOption beginGetCredentialOption, CharSequence charSequence2, CharSequence charSequence3, Instant instant, Icon icon, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        charSequence2 = (i & 16) != 0 ? null : charSequence2;
        charSequence3 = (i & 32) != 0 ? null : charSequence3;
        instant = (i & 64) != 0 ? null : instant;
        if ((i & 128) != 0) {
            icon = Icon.createWithResource(context, R.drawable.adx_ic_other_sign_in);
            Intrinsics.checkNotNullExpressionValue(icon, "createWithResource(...)");
        }
        this(context, charSequence, pendingIntent, beginGetCredentialOption, charSequence2, charSequence3, instant, icon, (i & 256) != 0 ? false : z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomCredentialEntry(Context context, CharSequence title, PendingIntent pendingIntent, BeginGetCredentialOption beginGetCredentialOption, CharSequence charSequence, CharSequence charSequence2, Instant instant, Icon icon, boolean z, CharSequence entryGroupId, boolean z2) {
        this(beginGetCredentialOption.getType(), title, pendingIntent, z, charSequence, charSequence2, icon, instant, beginGetCredentialOption, z2, entryGroupId.length() == 0 ? title : entryGroupId, null, null, false, false, false, 63488, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        Intrinsics.checkNotNullParameter(beginGetCredentialOption, "beginGetCredentialOption");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(entryGroupId, "entryGroupId");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CustomCredentialEntry(Context context, CharSequence charSequence, PendingIntent pendingIntent, BeginGetCredentialOption beginGetCredentialOption, CharSequence charSequence2, CharSequence charSequence3, Instant instant, Icon icon, boolean z, CharSequence charSequence4, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        charSequence2 = (i & 16) != 0 ? null : charSequence2;
        charSequence3 = (i & 32) != 0 ? null : charSequence3;
        instant = (i & 64) != 0 ? null : instant;
        if ((i & 128) != 0) {
            icon = Icon.createWithResource(context, R.drawable.adx_ic_other_sign_in);
            Intrinsics.checkNotNullExpressionValue(icon, "createWithResource(...)");
        }
        this(context, charSequence, pendingIntent, beginGetCredentialOption, charSequence2, charSequence3, instant, icon, (i & 256) != 0 ? false : z, (i & 512) != 0 ? charSequence : charSequence4, (i & 1024) != 0 ? false : z2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomCredentialEntry(Context context, CharSequence title, PendingIntent pendingIntent, BeginGetCredentialOption beginGetCredentialOption, CharSequence charSequence, CharSequence charSequence2, Instant instant, Icon icon, boolean z, CharSequence entryGroupId, boolean z2, BiometricPromptData biometricPromptData) {
        this(beginGetCredentialOption.getType(), title, pendingIntent, z, charSequence, charSequence2, icon, instant, beginGetCredentialOption, z2, entryGroupId.length() == 0 ? title : entryGroupId, null, biometricPromptData, false, false, false, 59392, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        Intrinsics.checkNotNullParameter(beginGetCredentialOption, "beginGetCredentialOption");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(entryGroupId, "entryGroupId");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CustomCredentialEntry(Context context, CharSequence charSequence, PendingIntent pendingIntent, BeginGetCredentialOption beginGetCredentialOption, CharSequence charSequence2, CharSequence charSequence3, Instant instant, Icon icon, boolean z, CharSequence charSequence4, boolean z2, BiometricPromptData biometricPromptData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Context context2;
        Icon icon2;
        CharSequence charSequence5 = (i & 16) != 0 ? null : charSequence2;
        CharSequence charSequence6 = (i & 32) != 0 ? null : charSequence3;
        Instant instant2 = (i & 64) != 0 ? null : instant;
        if ((i & 128) != 0) {
            context2 = context;
            Icon iconCreateWithResource = Icon.createWithResource(context2, R.drawable.adx_ic_other_sign_in);
            Intrinsics.checkNotNullExpressionValue(iconCreateWithResource, "createWithResource(...)");
            icon2 = iconCreateWithResource;
        } else {
            context2 = context;
            icon2 = icon;
        }
        this(context2, charSequence, pendingIntent, beginGetCredentialOption, charSequence5, charSequence6, instant2, icon2, (i & 256) != 0 ? false : z, (i & 512) != 0 ? charSequence : charSequence4, (i & 1024) != 0 ? false : z2, (i & 2048) != 0 ? null : biometricPromptData);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomCredentialEntry(String type, CharSequence title, PendingIntent pendingIntent, boolean z, CharSequence charSequence, CharSequence charSequence2, Icon icon, Instant instant, BeginGetCredentialOption beginGetCredentialOption, boolean z2, CharSequence charSequence3, CharSequence charSequence4, BiometricPromptData biometricPromptData, boolean z3, boolean z4, boolean z5) {
        super(type, beginGetCredentialOption, charSequence3 == null ? title : charSequence3, z2, charSequence4, biometricPromptData);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(beginGetCredentialOption, "beginGetCredentialOption");
        this.type = type;
        this.title = title;
        this.pendingIntent = pendingIntent;
        this.isAutoSelectAllowed = z;
        this.subtitle = charSequence;
        this.typeDisplayName = charSequence2;
        this.icon = icon;
        this.lastUsedTime = instant;
        this.isCreatedFromSlice = z4;
        this.isDefaultIconFromSlice = z5;
        this.isAutoSelectAllowedFromOption = z3;
        if (getType().length() <= 0) {
            throw new IllegalArgumentException("type must not be empty".toString());
        }
        if (title.length() <= 0) {
            throw new IllegalArgumentException("title must not be empty".toString());
        }
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ CustomCredentialEntry(java.lang.String r20, java.lang.CharSequence r21, android.app.PendingIntent r22, boolean r23, java.lang.CharSequence r24, java.lang.CharSequence r25, android.graphics.drawable.Icon r26, java.time.Instant r27, androidx.credentials.provider.BeginGetCredentialOption r28, boolean r29, java.lang.CharSequence r30, java.lang.CharSequence r31, androidx.credentials.provider.BiometricPromptData r32, boolean r33, boolean r34, boolean r35, int r36, kotlin.jvm.internal.DefaultConstructorMarker r37) {
        /*
            r19 = this;
            r0 = r36
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L9
            r13 = r21
            goto Lb
        L9:
            r13 = r30
        Lb:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            r2 = 0
            if (r1 == 0) goto L12
            r14 = r2
            goto L14
        L12:
            r14 = r31
        L14:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L1a
            r15 = r2
            goto L1c
        L1a:
            r15 = r32
        L1c:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L2d
            androidx.credentials.CredentialOption$Companion r1 = androidx.credentials.CredentialOption.INSTANCE
            android.os.Bundle r2 = r28.getCandidateQueryData()
            boolean r1 = r1.extractAutoSelectValue$credentials(r2)
            r16 = r1
            goto L2f
        L2d:
            r16 = r33
        L2f:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            r2 = 0
            if (r1 == 0) goto L37
            r17 = r2
            goto L39
        L37:
            r17 = r34
        L39:
            r1 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r1
            if (r0 == 0) goto L58
            r18 = r2
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r27
            r11 = r28
            r12 = r29
            r2 = r19
            goto L70
        L58:
            r18 = r35
            r2 = r19
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r27
            r11 = r28
            r12 = r29
        L70:
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.provider.CustomCredentialEntry.<init>(java.lang.String, java.lang.CharSequence, android.app.PendingIntent, boolean, java.lang.CharSequence, java.lang.CharSequence, android.graphics.drawable.Icon, java.time.Instant, androidx.credentials.provider.BeginGetCredentialOption, boolean, java.lang.CharSequence, java.lang.CharSequence, androidx.credentials.provider.BiometricPromptData, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmStatic
    public static final CustomCredentialEntry fromCredentialEntry(android.service.credentials.CredentialEntry credentialEntry) {
        return INSTANCE.fromCredentialEntry(credentialEntry);
    }

    @JvmStatic
    public static final CustomCredentialEntry fromSlice(Slice slice) {
        return INSTANCE.fromSlice(slice);
    }

    @JvmStatic
    public static final Slice toSlice(CustomCredentialEntry customCredentialEntry) {
        return INSTANCE.toSlice(customCredentialEntry);
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final Instant getLastUsedTime() {
        return this.lastUsedTime;
    }

    public final PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }

    public final CharSequence getSubtitle() {
        return this.subtitle;
    }

    public final CharSequence getTitle() {
        return this.title;
    }

    @Override // androidx.credentials.provider.CredentialEntry
    public String getType() {
        return this.type;
    }

    public final CharSequence getTypeDisplayName() {
        return this.typeDisplayName;
    }

    public final boolean hasDefaultIcon() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.isDefaultIcon(this);
        }
        return false;
    }

    /* JADX INFO: renamed from: isAutoSelectAllowed, reason: from getter */
    public final boolean getIsAutoSelectAllowed() {
        return this.isAutoSelectAllowed;
    }

    /* JADX INFO: renamed from: isAutoSelectAllowedFromOption, reason: from getter */
    public final boolean getIsAutoSelectAllowedFromOption() {
        return this.isAutoSelectAllowedFromOption;
    }
}
