package org.apache.commons.io.output;

/* JADX INFO: loaded from: classes7.dex */
public interface UncheckedAppendable extends Appendable {
    static UncheckedAppendable on(Appendable appendable) {
        return new UncheckedAppendableImpl(appendable);
    }

    @Override // java.lang.Appendable
    UncheckedAppendable append(char c);

    @Override // java.lang.Appendable
    UncheckedAppendable append(CharSequence charSequence);

    @Override // java.lang.Appendable
    UncheckedAppendable append(CharSequence charSequence, int i, int i2);
}
