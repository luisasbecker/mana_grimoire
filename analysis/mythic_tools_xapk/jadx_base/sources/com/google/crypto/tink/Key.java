package com.google.crypto.tink;

import com.google.errorprone.annotations.Immutable;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Immutable
public abstract class Key {
    public abstract boolean equalsKey(Key key);

    @Nullable
    public abstract Integer getIdRequirementOrNull();

    public abstract Parameters getParameters();
}
