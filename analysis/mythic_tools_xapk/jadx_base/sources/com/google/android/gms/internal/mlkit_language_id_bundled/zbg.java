package com.google.android.gms.internal.mlkit_language_id_bundled;

/* JADX INFO: compiled from: com.google.mlkit:language-id@@17.0.6 */
/* JADX INFO: loaded from: classes4.dex */
final class zbg extends zbe {
    private final zbi zba;

    zbg(zbi zbiVar, int i) {
        super(zbiVar.size(), i);
        this.zba = zbiVar;
    }

    @Override // com.google.android.gms.internal.mlkit_language_id_bundled.zbe
    protected final Object zba(int i) {
        return this.zba.get(i);
    }
}
