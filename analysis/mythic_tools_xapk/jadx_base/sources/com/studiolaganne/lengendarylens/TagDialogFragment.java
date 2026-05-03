package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: TagDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\bH\u0002J\u0018\u0010 \u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\bH\u0002J&\u0010\"\u001a\u0004\u0018\u00010\u001e2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0006\u0010)\u001a\u00020\u001bJ\u001a\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u001e2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\fR \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\fR\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/studiolaganne/lengendarylens/TagDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/studiolaganne/lengendarylens/TagDialogListener;", "initialTags", "", "Lcom/studiolaganne/lengendarylens/MTTag;", "getInitialTags", "()Ljava/util/List;", "setInitialTags", "(Ljava/util/List;)V", "userTags", "getUserTags", "setUserTags", "addedTags", "", "", "getAddedTags", "setAddedTags", "removedTags", "getRemovedTags", "setRemovedTags", "saveButton", "Lcom/google/android/material/button/MaterialButton;", "onStart", "", "onTopTagTapped", "tagView", "Landroid/view/View;", ViewHierarchyConstants.TAG_KEY, "onBottomTagTapped", "theTag", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "updateSaveButtonState", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TagDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private TagDialogListener listener;
    private MaterialButton saveButton;
    private List<MTTag> initialTags = CollectionsKt.emptyList();
    private List<MTTag> userTags = CollectionsKt.emptyList();
    private List<String> addedTags = new ArrayList();
    private List<String> removedTags = new ArrayList();

    /* JADX INFO: compiled from: TagDialogFragment.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u000b\u001a\u00020\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0014\u0010\u000f\u001a\u00020\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/TagDialogFragment$Builder;", "", "<init>", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/studiolaganne/lengendarylens/TagDialogListener;", "initialTags", "", "Lcom/studiolaganne/lengendarylens/MTTag;", "getInitialTags", "()Ljava/util/List;", "setInitialTags", "(Ljava/util/List;)V", "userTags", "getUserTags", "setUserTags", "tags", InAppPurchaseConstants.METHOD_SET_LISTENER, "build", "Lcom/studiolaganne/lengendarylens/TagDialogFragment;", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private TagDialogListener listener;
        private List<MTTag> initialTags = CollectionsKt.emptyList();
        private List<MTTag> userTags = CollectionsKt.emptyList();

        public final TagDialogFragment build() {
            TagDialogFragment tagDialogFragment = new TagDialogFragment();
            tagDialogFragment.listener = this.listener;
            tagDialogFragment.setInitialTags(this.initialTags);
            tagDialogFragment.setUserTags(this.userTags);
            return tagDialogFragment;
        }

        public final List<MTTag> getInitialTags() {
            return this.initialTags;
        }

        public final List<MTTag> getUserTags() {
            return this.userTags;
        }

        public final Builder setInitialTags(List<MTTag> tags) {
            Intrinsics.checkNotNullParameter(tags, "tags");
            this.initialTags = tags;
            return this;
        }

        /* JADX INFO: renamed from: setInitialTags, reason: collision with other method in class */
        public final void m11265setInitialTags(List<MTTag> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.initialTags = list;
        }

        public final Builder setListener(TagDialogListener listener) {
            this.listener = listener;
            return this;
        }

        public final Builder setUserTags(List<MTTag> tags) {
            Intrinsics.checkNotNullParameter(tags, "tags");
            this.userTags = tags;
            return this;
        }

        /* JADX INFO: renamed from: setUserTags, reason: collision with other method in class */
        public final void m11266setUserTags(List<MTTag> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.userTags = list;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(build(), manager, tag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onBottomTagTapped(final View tagView, final MTTag theTag) {
        String lowerCase = theTag.getName().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        List<String> list = this.addedTags;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                String lowerCase2 = ((String) it.next()).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (Intrinsics.areEqual(lowerCase2, lowerCase)) {
                    return;
                }
            }
        }
        ImageView imageView = (ImageView) tagView.findViewById(R.id.deleteTagImage);
        View view = getView();
        FlexboxLayout flexboxLayout = view != null ? (FlexboxLayout) view.findViewById(R.id.flexboxLayoutExistingTags) : null;
        View view2 = getView();
        FlexboxLayout flexboxLayout2 = view2 != null ? (FlexboxLayout) view2.findViewById(R.id.flexboxLayoutAvailableTags) : null;
        this.addedTags.add(lowerCase);
        this.removedTags.remove(lowerCase);
        updateSaveButtonState();
        tagView.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.TagDialogFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.f$0.onTopTagTapped(tagView, theTag);
            }
        });
        if (flexboxLayout2 != null) {
            flexboxLayout2.removeView(tagView);
        }
        if (flexboxLayout != null) {
            flexboxLayout.addView(tagView);
        }
        imageView.setVisibility(0);
    }

    static final void onCreateView$lambda$1(TagDialogFragment tagDialogFragment, View view, MTTag mTTag, View view2) {
        Intrinsics.checkNotNull(view);
        tagDialogFragment.onTopTagTapped(view, mTTag);
    }

    static final void onCreateView$lambda$4(TagDialogFragment tagDialogFragment, View view, MTTag mTTag, View view2) {
        Intrinsics.checkNotNull(view);
        tagDialogFragment.onBottomTagTapped(view, mTTag);
    }

    static final Unit onCreateView$lambda$5(EditText editText, final TagDialogFragment tagDialogFragment, View view) {
        String string;
        String strValueOf;
        final String string2 = editText.getText().toString();
        String str = string2;
        if (str.length() > 0) {
            List<String> list = tagDialogFragment.addedTags;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    String lowerCase = ((String) it.next()).toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    String lowerCase2 = string2.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                        return Unit.INSTANCE;
                    }
                }
            }
            List<MTTag> list2 = tagDialogFragment.userTags;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    String lowerCase3 = ((MTTag) it2.next()).getName().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                    String lowerCase4 = string2.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                    if (Intrinsics.areEqual(lowerCase3, lowerCase4)) {
                        return Unit.INSTANCE;
                    }
                }
            }
            String lowerCase5 = string2.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase5, "toLowerCase(...)");
            tagDialogFragment.addedTags.add(lowerCase5);
            tagDialogFragment.updateSaveButtonState();
            FlexboxLayout flexboxLayout = (FlexboxLayout) view.findViewById(R.id.flexboxLayoutExistingTags);
            final View viewInflate = tagDialogFragment.getLayoutInflater().inflate(R.layout.tag_item_box, (ViewGroup) null);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tagName);
            if (str.length() > 0) {
                StringBuilder sb = new StringBuilder();
                char cCharAt = string2.charAt(0);
                if (Character.isLowerCase(cCharAt)) {
                    Locale localeForLanguageTag = Locale.forLanguageTag("en");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag, "forLanguageTag(...)");
                    strValueOf = CharsKt.titlecase(cCharAt, localeForLanguageTag);
                } else {
                    strValueOf = String.valueOf(cCharAt);
                }
                StringBuilder sbAppend = sb.append((Object) strValueOf);
                String strSubstring = string2.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                string = sbAppend.append(strSubstring).toString();
            } else {
                string = string2;
            }
            textView.setText(string);
            viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.TagDialogFragment$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TagDialogFragment.onCreateView$lambda$5$3(this.f$0, viewInflate, string2, view2);
                }
            });
            flexboxLayout.addView(viewInflate);
            editText.getText().clear();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$5$3(TagDialogFragment tagDialogFragment, View view, String str, View view2) {
        Intrinsics.checkNotNull(view);
        tagDialogFragment.onTopTagTapped(view, new MTTag(null, str, 1, null));
    }

    static final Unit onCreateView$lambda$6(TagDialogFragment tagDialogFragment) {
        TagDialogListener tagDialogListener = tagDialogFragment.listener;
        if (tagDialogListener != null) {
            tagDialogListener.onTagDialogSaveButton(tagDialogFragment.removedTags, tagDialogFragment.addedTags);
        }
        tagDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$7(TagDialogFragment tagDialogFragment) {
        tagDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onTopTagTapped(final View tagView, final MTTag tag) {
        ImageView imageView = (ImageView) tagView.findViewById(R.id.deleteTagImage);
        View view = getView();
        FlexboxLayout flexboxLayout = view != null ? (FlexboxLayout) view.findViewById(R.id.flexboxLayoutExistingTags) : null;
        View view2 = getView();
        FlexboxLayout flexboxLayout2 = view2 != null ? (FlexboxLayout) view2.findViewById(R.id.flexboxLayoutAvailableTags) : null;
        if (tag.getId() != null) {
            List<MTTag> list = this.initialTags;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (Intrinsics.areEqual(((MTTag) it.next()).getId(), tag.getId())) {
                        this.removedTags.add(tag.getName());
                        updateSaveButtonState();
                        break;
                    }
                }
            }
        }
        if (flexboxLayout != null) {
            flexboxLayout.removeView(tagView);
        }
        this.addedTags.remove(tag.getName());
        if (tag.getId() != null) {
            imageView.setVisibility(8);
            tagView.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.TagDialogFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    this.f$0.onBottomTagTapped(tagView, tag);
                }
            });
            if (flexboxLayout2 != null) {
                flexboxLayout2.addView(tagView);
            }
        }
    }

    public final List<String> getAddedTags() {
        return this.addedTags;
    }

    public final List<MTTag> getInitialTags() {
        return this.initialTags;
    }

    public final List<String> getRemovedTags() {
        return this.removedTags;
    }

    public final List<MTTag> getUserTags() {
        return this.userTags;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String strValueOf;
        String strValueOf2;
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        int i = 0;
        final View viewInflate = inflater.inflate(R.layout.tag_dialog, container, false);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        for (final MTTag mTTag : this.initialTags) {
            FlexboxLayout flexboxLayout = (FlexboxLayout) viewInflate.findViewById(R.id.flexboxLayoutExistingTags);
            final View viewInflate2 = getLayoutInflater().inflate(R.layout.tag_item_box, (ViewGroup) null);
            TextView textView = (TextView) viewInflate2.findViewById(R.id.tagName);
            ((ImageView) viewInflate2.findViewById(R.id.deleteTagImage)).setVisibility(0);
            String name = mTTag.getName();
            if (name.length() > 0) {
                StringBuilder sb = new StringBuilder();
                char cCharAt = name.charAt(0);
                if (Character.isLowerCase(cCharAt)) {
                    Locale localeForLanguageTag = Locale.forLanguageTag("en");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag, "forLanguageTag(...)");
                    strValueOf2 = CharsKt.titlecase(cCharAt, localeForLanguageTag);
                } else {
                    strValueOf2 = String.valueOf(cCharAt);
                }
                StringBuilder sbAppend = sb.append((Object) strValueOf2);
                String strSubstring = name.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                name = sbAppend.append(strSubstring).toString();
            }
            textView.setText(name);
            viewInflate2.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.TagDialogFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TagDialogFragment.onCreateView$lambda$1(this.f$0, viewInflate2, mTTag, view);
                }
            });
            flexboxLayout.addView(viewInflate2);
        }
        for (final MTTag mTTag2 : this.userTags) {
            List<MTTag> list = this.initialTags;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    String lowerCase = ((MTTag) it.next()).getName().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    String lowerCase2 = mTTag2.getName().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                        break;
                    }
                }
            }
            FlexboxLayout flexboxLayout2 = (FlexboxLayout) viewInflate.findViewById(R.id.flexboxLayoutAvailableTags);
            final View viewInflate3 = getLayoutInflater().inflate(R.layout.tag_item_box, (ViewGroup) null);
            TextView textView2 = (TextView) viewInflate3.findViewById(R.id.tagName);
            ((ImageView) viewInflate3.findViewById(R.id.deleteTagImage)).setVisibility(8);
            String name2 = mTTag2.getName();
            if (name2.length() > 0) {
                StringBuilder sb2 = new StringBuilder();
                char cCharAt2 = name2.charAt(i);
                if (Character.isLowerCase(cCharAt2)) {
                    Locale localeForLanguageTag2 = Locale.forLanguageTag("en");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag2, "forLanguageTag(...)");
                    strValueOf = CharsKt.titlecase(cCharAt2, localeForLanguageTag2);
                } else {
                    strValueOf = String.valueOf(cCharAt2);
                }
                StringBuilder sbAppend2 = sb2.append((Object) strValueOf);
                String strSubstring2 = name2.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                name2 = sbAppend2.append(strSubstring2).toString();
            }
            textView2.setText(name2);
            flexboxLayout2.addView(viewInflate3);
            viewInflate3.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.TagDialogFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TagDialogFragment.onCreateView$lambda$4(this.f$0, viewInflate3, mTTag2, view);
                }
            });
            i = 0;
        }
        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.addTagButton);
        final EditText editText = (EditText) viewInflate.findViewById(R.id.tagNameEditText);
        Intrinsics.checkNotNull(materialButton);
        ViewExtensionsKt.setOnClickWithFade(materialButton, new Function0() { // from class: com.studiolaganne.lengendarylens.TagDialogFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TagDialogFragment.onCreateView$lambda$5(editText, this, viewInflate);
            }
        });
        MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R.id.saveButton);
        this.saveButton = materialButton2;
        if (materialButton2 != null) {
            ViewExtensionsKt.setOnClickWithFade(materialButton2, new Function0() { // from class: com.studiolaganne.lengendarylens.TagDialogFragment$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TagDialogFragment.onCreateView$lambda$6(this.f$0);
                }
            });
        }
        MaterialButton materialButton3 = (MaterialButton) viewInflate.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(materialButton3);
        ViewExtensionsKt.setOnClickWithFade(materialButton3, new Function0() { // from class: com.studiolaganne.lengendarylens.TagDialogFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TagDialogFragment.onCreateView$lambda$7(this.f$0);
            }
        });
        updateSaveButtonState();
        return viewInflate;
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

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
    }

    public final void setAddedTags(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.addedTags = list;
    }

    public final void setInitialTags(List<MTTag> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.initialTags = list;
    }

    public final void setRemovedTags(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.removedTags = list;
    }

    public final void setUserTags(List<MTTag> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.userTags = list;
    }

    public final void updateSaveButtonState() {
        MaterialButton materialButton = this.saveButton;
        if (materialButton != null) {
            materialButton.setEnabled((this.addedTags.isEmpty() && this.removedTags.isEmpty()) ? false : true);
        }
        MaterialButton materialButton2 = this.saveButton;
        if (materialButton2 != null) {
            materialButton2.setAlpha((materialButton2 == null || !materialButton2.isEnabled()) ? 0.5f : 1.0f);
        }
    }
}
