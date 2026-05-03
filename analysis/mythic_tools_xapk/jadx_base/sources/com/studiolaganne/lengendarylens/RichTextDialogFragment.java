package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RichTextDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0002&'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020%H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/studiolaganne/lengendarylens/RichTextDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", Constants.GP_IAP_TITLE, "", "body", "positiveButtonText", "negativeButtonText", "destructiveButtonText", "positiveButtonListener", "Lkotlin/Function1;", "", "negativeButtonListener", "destructiveButtonListener", "onDismiss", "Lkotlin/Function0;", "positiveButtonRed", "", Key.ROTATION, "", "links", "", "Lcom/studiolaganne/lengendarylens/RichTextDialogFragment$LinkData;", "onStart", "dialog", "Landroid/content/DialogInterface;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setupRichTextBody", "textView", "Landroid/widget/TextView;", "LinkData", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RichTextDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private Function1<? super RichTextDialogFragment, Unit> destructiveButtonListener;
    private Function1<? super RichTextDialogFragment, Unit> negativeButtonListener;
    private Function0<Unit> onDismiss;
    private Function1<? super RichTextDialogFragment, Unit> positiveButtonListener;
    private boolean positiveButtonRed;
    private int rotation;
    private String title = "";
    private String body = "";
    private String positiveButtonText = "";
    private String negativeButtonText = "";
    private String destructiveButtonText = "";
    private List<LinkData> links = CollectionsKt.emptyList();

    /* JADX INFO: compiled from: RichTextDialogFragment.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\bJ\u001e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bJ\"\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u0015J\u0006\u0010\u0017\u001a\u00020\u0000J\"\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u0015J\"\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u0015J\u0014\u0010\u001a\u001a\u00020\u00002\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001cJ\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/studiolaganne/lengendarylens/RichTextDialogFragment$Builder;", "", "<init>", "()V", "dialogFragment", "Lcom/studiolaganne/lengendarylens/RichTextDialogFragment;", "setTitle", Constants.GP_IAP_TITLE, "", "setRotation", Key.ROTATION, "", "setBody", "body", "addLink", "url", "startIndex", "endIndex", "setPositiveButton", "text", "onClick", "Lkotlin/Function1;", "", "setPositiveButtonRed", "setNegativeButton", "setDestructiveButton", "setOnDismissListener", "onDismiss", "Lkotlin/Function0;", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private final RichTextDialogFragment dialogFragment = new RichTextDialogFragment();

        public final Builder addLink(String url, int startIndex, int endIndex) {
            Intrinsics.checkNotNullParameter(url, "url");
            RichTextDialogFragment richTextDialogFragment = this.dialogFragment;
            richTextDialogFragment.links = CollectionsKt.plus((Collection<? extends LinkData>) richTextDialogFragment.links, new LinkData(url, startIndex, endIndex));
            return this;
        }

        public final Builder setBody(String body) {
            Intrinsics.checkNotNullParameter(body, "body");
            this.dialogFragment.body = body;
            return this;
        }

        public final Builder setDestructiveButton(String text, Function1<? super RichTextDialogFragment, Unit> onClick) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            this.dialogFragment.destructiveButtonText = text;
            this.dialogFragment.destructiveButtonListener = onClick;
            return this;
        }

        public final Builder setNegativeButton(String text, Function1<? super RichTextDialogFragment, Unit> onClick) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            this.dialogFragment.negativeButtonText = text;
            this.dialogFragment.negativeButtonListener = onClick;
            return this;
        }

        public final Builder setOnDismissListener(Function0<Unit> onDismiss) {
            Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
            this.dialogFragment.onDismiss = onDismiss;
            return this;
        }

        public final Builder setPositiveButton(String text, Function1<? super RichTextDialogFragment, Unit> onClick) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            this.dialogFragment.positiveButtonText = text;
            this.dialogFragment.positiveButtonListener = onClick;
            return this;
        }

        public final Builder setPositiveButtonRed() {
            this.dialogFragment.positiveButtonRed = true;
            return this;
        }

        public final Builder setRotation(int rotation) {
            this.dialogFragment.rotation = rotation;
            return this;
        }

        public final Builder setTitle(String title) {
            Intrinsics.checkNotNullParameter(title, "title");
            this.dialogFragment.title = title;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(this.dialogFragment, manager, tag);
        }
    }

    /* JADX INFO: compiled from: RichTextDialogFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/RichTextDialogFragment$LinkData;", "", "url", "", "startIndex", "", "endIndex", "<init>", "(Ljava/lang/String;II)V", "getUrl", "()Ljava/lang/String;", "getStartIndex", "()I", "getEndIndex", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class LinkData {
        public static final int $stable = 0;
        private final int endIndex;
        private final int startIndex;
        private final String url;

        public LinkData(String url, int i, int i2) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
            this.startIndex = i;
            this.endIndex = i2;
        }

        public static /* synthetic */ LinkData copy$default(LinkData linkData, String str, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = linkData.url;
            }
            if ((i3 & 2) != 0) {
                i = linkData.startIndex;
            }
            if ((i3 & 4) != 0) {
                i2 = linkData.endIndex;
            }
            return linkData.copy(str, i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getStartIndex() {
            return this.startIndex;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getEndIndex() {
            return this.endIndex;
        }

        public final LinkData copy(String url, int startIndex, int endIndex) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new LinkData(url, startIndex, endIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LinkData)) {
                return false;
            }
            LinkData linkData = (LinkData) other;
            return Intrinsics.areEqual(this.url, linkData.url) && this.startIndex == linkData.startIndex && this.endIndex == linkData.endIndex;
        }

        public final int getEndIndex() {
            return this.endIndex;
        }

        public final int getStartIndex() {
            return this.startIndex;
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            return (((this.url.hashCode() * 31) + Integer.hashCode(this.startIndex)) * 31) + Integer.hashCode(this.endIndex);
        }

        public String toString() {
            return "LinkData(url=" + this.url + ", startIndex=" + this.startIndex + ", endIndex=" + this.endIndex + ")";
        }
    }

    static final Unit onCreateView$lambda$6(RichTextDialogFragment richTextDialogFragment) {
        Function1<? super RichTextDialogFragment, Unit> function1 = richTextDialogFragment.positiveButtonListener;
        if (function1 != null) {
            function1.invoke(richTextDialogFragment);
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$7(RichTextDialogFragment richTextDialogFragment) {
        Function1<? super RichTextDialogFragment, Unit> function1 = richTextDialogFragment.negativeButtonListener;
        if (function1 != null) {
            function1.invoke(richTextDialogFragment);
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$8(RichTextDialogFragment richTextDialogFragment) {
        Function1<? super RichTextDialogFragment, Unit> function1 = richTextDialogFragment.destructiveButtonListener;
        if (function1 != null) {
            function1.invoke(richTextDialogFragment);
        }
        return Unit.INSTANCE;
    }

    private final void setupRichTextBody(TextView textView) {
        SpannableString spannableString = new SpannableString(this.body);
        int color = ContextCompat.getColor(requireContext(), R.color.link_color);
        for (final LinkData linkData : this.links) {
            spannableString.setSpan(new ClickableSpan() { // from class: com.studiolaganne.lengendarylens.RichTextDialogFragment$setupRichTextBody$1$clickableSpan$1
                @Override // android.text.style.ClickableSpan
                public void onClick(View widget) {
                    Intrinsics.checkNotNullParameter(widget, "widget");
                    try {
                        this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(linkData.getUrl())));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, linkData.getStartIndex(), linkData.getEndIndex(), 33);
            spannableString.setSpan(new ForegroundColorSpan(color), linkData.getStartIndex(), linkData.getEndIndex(), 33);
            spannableString.setSpan(new UnderlineSpan(), linkData.getStartIndex(), linkData.getEndIndex(), 33);
        }
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.dialog_custom, container, false);
        ((TextView) viewInflate.findViewById(R.id.title)).setText(this.title);
        TextView textView = (TextView) viewInflate.findViewById(R.id.body);
        Intrinsics.checkNotNull(textView);
        setupRichTextBody(textView);
        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.positive_button);
        MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R.id.negative_button);
        MaterialButton materialButton3 = (MaterialButton) viewInflate.findViewById(R.id.destructive_button);
        materialButton.setText(this.positiveButtonText);
        materialButton2.setText(this.negativeButtonText);
        materialButton3.setText(this.destructiveButtonText);
        ((RelativeLayout) viewInflate.findViewById(R.id.dialog_root)).setRotation(this.rotation);
        if (this.positiveButtonRed) {
            materialButton.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.custom_button_background));
        }
        if (this.positiveButtonListener != null) {
            materialButton.setVisibility(0);
        } else {
            materialButton.setVisibility(4);
        }
        if (this.negativeButtonListener != null) {
            materialButton2.setVisibility(0);
        } else {
            materialButton2.setVisibility(4);
        }
        if (this.destructiveButtonListener != null) {
            materialButton3.setVisibility(0);
        } else {
            materialButton3.setVisibility(4);
        }
        View viewFindViewById = viewInflate.findViewById(R.id.positive_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.RichTextDialogFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RichTextDialogFragment.onCreateView$lambda$6(this.f$0);
            }
        });
        View viewFindViewById2 = viewInflate.findViewById(R.id.negative_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById2, new Function0() { // from class: com.studiolaganne.lengendarylens.RichTextDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RichTextDialogFragment.onCreateView$lambda$7(this.f$0);
            }
        });
        View viewFindViewById3 = viewInflate.findViewById(R.id.destructive_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById3, new Function0() { // from class: com.studiolaganne.lengendarylens.RichTextDialogFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RichTextDialogFragment.onCreateView$lambda$8(this.f$0);
            }
        });
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        Function0<Unit> function0 = this.onDismiss;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d), -2);
    }
}
