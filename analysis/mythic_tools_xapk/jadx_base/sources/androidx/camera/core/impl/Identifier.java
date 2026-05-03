package androidx.camera.core.impl;

/* JADX INFO: loaded from: classes.dex */
public abstract class Identifier {
    public static Identifier create(Object obj) {
        return new AutoValue_Identifier(obj);
    }

    public abstract Object getValue();
}
