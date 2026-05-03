package com.vanniktech.emoji.internal;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.vanniktech.emoji.Emoji;
import com.vanniktech.emoji.EmojiTheming;
import com.vanniktech.emoji.R;
import com.vanniktech.emoji.internal.EmojiSearchDialog;
import com.vanniktech.emoji.search.SearchEmoji;
import com.vanniktech.emoji.search.SearchEmojiResult;
import com.vanniktech.ui.AndroidViewKt;
import com.vanniktech.ui.Color;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmojiSearchDialog.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/vanniktech/emoji/internal/EmojiSearchDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "delegate", "Lcom/vanniktech/emoji/internal/EmojiSearchDialogDelegate;", "searchEmoji", "Lcom/vanniktech/emoji/search/SearchEmoji;", "handler", "Landroid/os/Handler;", "future", "Ljava/util/concurrent/ScheduledFuture;", "executorService", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "", "dialog", "Landroid/content/DialogInterface;", "Companion", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EmojiSearchDialog extends DialogFragment {
    private static final String ARG_THEMING = "arg-theming";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "EmojiSearchDialog";
    private EmojiSearchDialogDelegate delegate;
    private ScheduledFuture<?> future;
    private SearchEmoji searchEmoji;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    /* JADX INFO: compiled from: EmojiSearchDialog.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/vanniktech/emoji/internal/EmojiSearchDialog$Companion;", "", "<init>", "()V", "TAG", "", "ARG_THEMING", "show", "", "context", "Landroid/content/Context;", "delegate", "Lcom/vanniktech/emoji/internal/EmojiSearchDialogDelegate;", "searchEmoji", "Lcom/vanniktech/emoji/search/SearchEmoji;", "theming", "Lcom/vanniktech/emoji/EmojiTheming;", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void show(Context context, EmojiSearchDialogDelegate delegate, SearchEmoji searchEmoji, EmojiTheming theming) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            Intrinsics.checkNotNullParameter(searchEmoji, "searchEmoji");
            Intrinsics.checkNotNullParameter(theming, "theming");
            EmojiSearchDialog emojiSearchDialog = new EmojiSearchDialog();
            Bundle bundle = new Bundle(1);
            bundle.putParcelable(EmojiSearchDialog.ARG_THEMING, theming);
            emojiSearchDialog.setArguments(bundle);
            emojiSearchDialog.delegate = delegate;
            emojiSearchDialog.searchEmoji = searchEmoji;
            Activity activityAsActivity$emoji_release = Utils.INSTANCE.asActivity$emoji_release(context);
            Intrinsics.checkNotNull(activityAsActivity$emoji_release, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            emojiSearchDialog.show(((FragmentActivity) activityAsActivity$emoji_release).getSupportFragmentManager(), EmojiSearchDialog.TAG);
        }
    }

    /* JADX INFO: renamed from: com.vanniktech.emoji.internal.EmojiSearchDialog$onCreateDialog$1, reason: invalid class name */
    /* JADX INFO: compiled from: EmojiSearchDialog.kt */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J*\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"com/vanniktech/emoji/internal/EmojiSearchDialog$onCreateDialog$1", "Landroid/text/TextWatcher;", "beforeTextChanged", "", "s", "", "start", "", "count", "after", "onTextChanged", "before", "afterTextChanged", "Landroid/text/Editable;", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 implements TextWatcher {
        final /* synthetic */ EmojiAdapter $adapter;

        AnonymousClass1(EmojiAdapter emojiAdapter) {
            this.$adapter = emojiAdapter;
        }

        static final void afterTextChanged$lambda$0(EmojiSearchDialog emojiSearchDialog, String str, final EmojiAdapter emojiAdapter) {
            SearchEmoji searchEmoji = emojiSearchDialog.searchEmoji;
            final List<SearchEmojiResult> listSearch = searchEmoji != null ? searchEmoji.search(str) : null;
            if (listSearch == null) {
                listSearch = CollectionsKt.emptyList();
            }
            emojiSearchDialog.handler.post(new Runnable() { // from class: com.vanniktech.emoji.internal.EmojiSearchDialog$onCreateDialog$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    emojiAdapter.update(listSearch, null);
                }
            });
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            Intrinsics.checkNotNullParameter(s, "s");
            final String string = s.toString();
            ScheduledFuture scheduledFuture = EmojiSearchDialog.this.future;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            EmojiSearchDialog.this.handler.removeCallbacksAndMessages(null);
            EmojiSearchDialog emojiSearchDialog = EmojiSearchDialog.this;
            ScheduledExecutorService scheduledExecutorService = emojiSearchDialog.executorService;
            final EmojiSearchDialog emojiSearchDialog2 = EmojiSearchDialog.this;
            final EmojiAdapter emojiAdapter = this.$adapter;
            emojiSearchDialog.future = scheduledExecutorService.schedule(new Runnable() { // from class: com.vanniktech.emoji.internal.EmojiSearchDialog$onCreateDialog$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    EmojiSearchDialog.AnonymousClass1.afterTextChanged$lambda$0(emojiSearchDialog2, string, emojiAdapter);
                }
            }, 300L, TimeUnit.MILLISECONDS);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    }

    static final void onCreateDialog$lambda$0(EmojiSearchDialog emojiSearchDialog, Emoji it) {
        Intrinsics.checkNotNullParameter(it, "it");
        EmojiSearchDialogDelegate emojiSearchDialogDelegate = emojiSearchDialog.delegate;
        if (emojiSearchDialogDelegate != null) {
            emojiSearchDialogDelegate.onSearchEmojiClick(it);
        }
        emojiSearchDialog.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        AlertDialog alertDialogShow = new AlertDialog.Builder(fragmentActivityRequireActivity, getTheme()).setView(R.layout.emoji_dialog_search).show();
        View viewFindViewById = alertDialogShow.findViewById(R.id.root);
        Bundle bundleRequireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(bundleRequireArguments, "requireArguments(...)");
        Parcelable parcelable = bundleRequireArguments.getParcelable(ARG_THEMING);
        if (!(parcelable instanceof EmojiTheming)) {
            parcelable = null;
        }
        EmojiTheming emojiTheming = (EmojiTheming) parcelable;
        Intrinsics.checkNotNull(emojiTheming);
        EmojiTheming emojiTheming2 = emojiTheming;
        if (viewFindViewById != null) {
            viewFindViewById.setBackgroundColor(emojiTheming2.backgroundColor);
        }
        View viewFindViewById2 = alertDialogShow.findViewById(R.id.editText);
        Intrinsics.checkNotNull(viewFindViewById2);
        final EditText editText = (EditText) viewFindViewById2;
        editText.setTextColor(emojiTheming2.textColor);
        AndroidViewKt.m11338themeEditTextCoujqA8(editText, Color.m11372constructorimpl(emojiTheming2.secondaryColor), Color.m11372constructorimpl(emojiTheming2.textColor), Color.m11372constructorimpl(emojiTheming2.textSecondaryColor));
        MaxHeightSearchRecyclerView maxHeightSearchRecyclerView = (MaxHeightSearchRecyclerView) alertDialogShow.findViewById(R.id.recyclerView);
        EmojiAdapter emojiAdapter = new EmojiAdapter(emojiTheming2, new EmojiSearchDialogDelegate() { // from class: com.vanniktech.emoji.internal.EmojiSearchDialog$$ExternalSyntheticLambda0
            @Override // com.vanniktech.emoji.internal.EmojiSearchDialogDelegate
            public final void onSearchEmojiClick(Emoji emoji) {
                EmojiSearchDialog.onCreateDialog$lambda$0(this.f$0, emoji);
            }
        });
        if (maxHeightSearchRecyclerView != null) {
            maxHeightSearchRecyclerView.tint(emojiTheming2);
        }
        if (maxHeightSearchRecyclerView != null) {
            maxHeightSearchRecyclerView.setAdapter(emojiAdapter);
        }
        editText.addTextChangedListener(new AnonymousClass1(emojiAdapter));
        editText.postDelayed(new Runnable() { // from class: com.vanniktech.emoji.internal.EmojiSearchDialog$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                UtilsKt.showKeyboardAndFocus(editText);
            }
        }, 300L);
        Intrinsics.checkNotNull(alertDialogShow);
        return alertDialogShow;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        ScheduledFuture<?> scheduledFuture = this.future;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ScheduledExecutorService scheduledExecutorService = this.executorService;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
        this.handler.removeCallbacksAndMessages(null);
        this.delegate = null;
    }
}
