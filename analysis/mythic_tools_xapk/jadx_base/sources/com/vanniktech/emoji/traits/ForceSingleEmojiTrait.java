package com.vanniktech.emoji.traits;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.widget.EditText;
import com.vanniktech.emoji.inputfilters.OnlyEmojisInputFilter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ForceSingleEmojiTrait.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/vanniktech/emoji/traits/ForceSingleEmojiTrait;", "Lcom/vanniktech/emoji/traits/EmojiTraitable;", "<init>", "()V", "install", "Lcom/vanniktech/emoji/traits/EmojiTrait;", "editText", "Landroid/widget/EditText;", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ForceSingleEmojiTrait implements EmojiTraitable {
    /* JADX WARN: Type inference failed for: r2v2, types: [com.vanniktech.emoji.traits.ForceSingleEmojiTrait$install$listener$1] */
    @Override // com.vanniktech.emoji.traits.EmojiTraitable
    public EmojiTrait install(final EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        final ?? r2 = new TextWatcher() { // from class: com.vanniktech.emoji.traits.ForceSingleEmojiTrait$install$listener$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Intrinsics.checkNotNullParameter(s, "s");
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Intrinsics.checkNotNullParameter(s, "s");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Intrinsics.checkNotNullParameter(s, "s");
                ForceSingleEmojiTrait$install$listener$1 forceSingleEmojiTrait$install$listener$1 = this;
                editText.removeTextChangedListener(forceSingleEmojiTrait$install$listener$1);
                CharSequence charSequenceTrim = StringsKt.trim(s.subSequence(start, count + start));
                editText.setText((CharSequence) null);
                editText.append(charSequenceTrim);
                editText.addTextChangedListener(forceSingleEmojiTrait$install$listener$1);
            }
        };
        InputFilter[] filters = editText.getFilters();
        Intrinsics.checkNotNullExpressionValue(filters, "getFilters(...)");
        editText.setFilters((InputFilter[]) ArraysKt.plus((OnlyEmojisInputFilter[]) filters, new OnlyEmojisInputFilter()));
        editText.addTextChangedListener((TextWatcher) r2);
        return new EmojiTrait() { // from class: com.vanniktech.emoji.traits.ForceSingleEmojiTrait.install.1
            @Override // com.vanniktech.emoji.traits.EmojiTrait
            public void uninstall() {
                EditText editText2 = editText;
                InputFilter[] filters2 = editText2.getFilters();
                Intrinsics.checkNotNullExpressionValue(filters2, "getFilters(...)");
                ArrayList arrayList = new ArrayList();
                for (InputFilter inputFilter : filters2) {
                    if (!(inputFilter instanceof OnlyEmojisInputFilter)) {
                        arrayList.add(inputFilter);
                    }
                }
                editText2.setFilters((InputFilter[]) arrayList.toArray(new InputFilter[0]));
                editText.removeTextChangedListener(r2);
            }
        };
    }
}
