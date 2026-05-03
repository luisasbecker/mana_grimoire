package com.vanniktech.emoji;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmojiLayoutFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004J,\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\"\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/vanniktech/emoji/EmojiLayoutFactory;", "Landroid/view/LayoutInflater$Factory2;", "delegate", "<init>", "(Landroid/view/LayoutInflater$Factory2;)V", "onCreateView", "Landroid/view/View;", "parent", "name", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class EmojiLayoutFactory implements LayoutInflater.Factory2 {
    private final LayoutInflater.Factory2 delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public EmojiLayoutFactory() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public EmojiLayoutFactory(LayoutInflater.Factory2 factory2) {
        this.delegate = factory2;
    }

    public /* synthetic */ EmojiLayoutFactory(LayoutInflater.Factory2 factory2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : factory2);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        if (Intrinsics.areEqual(name, "TextView")) {
            return new EmojiTextView(context, attrs);
        }
        if (Intrinsics.areEqual(name, "EditText")) {
            return new EmojiEditText(context, attrs);
        }
        if (Intrinsics.areEqual(name, "Button")) {
            return new EmojiButton(context, attrs);
        }
        if (Intrinsics.areEqual(name, "Checkbox")) {
            return new EmojiCheckbox(context, attrs);
        }
        if (Intrinsics.areEqual(name, "AutoCompleteTextView")) {
            return new EmojiAutoCompleteTextView(context, attrs);
        }
        if (Intrinsics.areEqual(name, "MultiAutoCompleteTextView")) {
            return new EmojiMultiAutoCompleteTextView(context, attrs);
        }
        LayoutInflater.Factory2 factory2 = this.delegate;
        if (factory2 != null) {
            return factory2.onCreateView(parent, name, context, attrs);
        }
        return null;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        return onCreateView(null, name, context, attrs);
    }
}
