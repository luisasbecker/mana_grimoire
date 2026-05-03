package com.google.android.play.core.assetpacks;

import android.content.Intent;
import android.os.Bundle;
import androidx.work.Data;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class bw implements by {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f244a;
    private final Bundle b;
    private final Data.Builder c;

    /* synthetic */ bw(String str, Bundle bundle, Data.Builder builder, ca caVar) {
        this.f244a = str;
        this.b = bundle;
        this.c = builder;
    }

    @Override // com.google.android.play.core.assetpacks.by
    public final List a(String str) {
        ArrayList<String> stringArrayList = this.b.getStringArrayList(str);
        if (stringArrayList == null) {
            return new ArrayList();
        }
        String[] strArr = new String[stringArrayList.size()];
        for (int i = 0; i < stringArrayList.size(); i++) {
            String str2 = stringArrayList.get(i);
            if (str2 == null) {
                str2 = "";
            }
            strArr[i] = str2;
        }
        this.c.putStringArray(this.f244a.concat(str), strArr);
        return stringArrayList;
    }

    @Override // com.google.android.play.core.assetpacks.by
    public final void b(String str) {
        Bundle bundle = this.b;
        this.c.putBoolean(this.f244a.concat("notification_intent_reconstruct_from_data"), bundle.getBoolean("notification_intent_reconstruct_from_data"));
    }

    @Override // com.google.android.play.core.assetpacks.by
    public final void c(String str) {
        Bundle bundle = this.b;
        this.c.putInt(this.f244a.concat(str), bundle.getInt(str));
    }

    @Override // com.google.android.play.core.assetpacks.by
    public final void d(String str) {
        ArrayList parcelableArrayList = this.b.getParcelableArrayList(str);
        if (parcelableArrayList == null) {
            return;
        }
        String[] strArr = new String[parcelableArrayList.size()];
        for (int i = 0; i < parcelableArrayList.size(); i++) {
            Intent intent = (Intent) parcelableArrayList.get(i);
            strArr[i] = (intent == null || intent.getData() == null) ? "" : intent.getData().toString();
        }
        this.c.putStringArray(this.f244a + str + ":intent_data", strArr);
    }

    @Override // com.google.android.play.core.assetpacks.by
    public final /* synthetic */ void e(String str) {
        bx.a(this, str);
    }

    @Override // com.google.android.play.core.assetpacks.by
    public final void f(String str, long j) {
        Bundle bundle = this.b;
        this.c.putLong(this.f244a.concat(str), bundle.getLong(str, j));
    }

    @Override // com.google.android.play.core.assetpacks.by
    public final void g(String str) {
        String string = this.b.getString(str);
        if (string == null) {
            return;
        }
        this.c.putString(this.f244a.concat(str), string);
    }
}
