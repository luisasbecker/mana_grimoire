package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class ax implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.google.android.play.core.assetpacks.internal.o f225a = new com.google.android.play.core.assetpacks.internal.o("AssetPackServiceImpl");
    private static final Intent b = new Intent("com.google.android.play.core.assetmoduleservice.BIND_ASSET_MODULE_SERVICE").setPackage("com.android.vending");
    private final String c;
    private final dd d;
    private final er e;
    private com.google.android.play.core.assetpacks.internal.z f;
    private com.google.android.play.core.assetpacks.internal.z g;
    private final AtomicBoolean h = new AtomicBoolean();

    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.android.play.core.assetpacks.ab] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.google.android.play.core.assetpacks.ab] */
    ax(Context context, dd ddVar, er erVar) {
        this.c = context.getPackageName();
        this.d = ddVar;
        this.e = erVar;
        if (com.google.android.play.core.assetpacks.internal.ai.b(context)) {
            Context contextA = com.google.android.play.core.assetpacks.internal.ag.a(context);
            com.google.android.play.core.assetpacks.internal.o oVar = f225a;
            Intent intent = b;
            this.f = new com.google.android.play.core.assetpacks.internal.z(contextA, oVar, "AssetPackService", intent, new Object() { // from class: com.google.android.play.core.assetpacks.ab
            }, null);
            this.g = new com.google.android.play.core.assetpacks.internal.z(com.google.android.play.core.assetpacks.internal.ag.a(context), oVar, "AssetPackService-keepAlive", intent, new Object() { // from class: com.google.android.play.core.assetpacks.ab
            }, null);
        }
        f225a.a("AssetPackService initiated.", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle A() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 20300);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
        bundle.putIntegerArrayList("supported_compression_formats", arrayList);
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(1);
        arrayList2.add(2);
        bundle.putIntegerArrayList("supported_patch_formats", arrayList2);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle B(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", i);
        return bundle;
    }

    private static Task C() {
        f225a.b("onError(%d)", -11);
        return Tasks.forException(new AssetPackException(-11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(int i, String str, int i2) {
        if (this.f == null) {
            throw new cz("The Play Store app is not installed or is an unofficial version.", i);
        }
        f225a.d("notifyModuleCompleted", new Object[0]);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f.t(new ai(this, taskCompletionSource, i, str, taskCompletionSource, i2), taskCompletionSource);
    }

    static /* bridge */ /* synthetic */ Bundle k(int i, String str, String str2, int i2) {
        Bundle bundleZ = z(i, str);
        bundleZ.putString("slice_id", str2);
        bundleZ.putInt("chunk_number", i2);
        return bundleZ;
    }

    static /* bridge */ /* synthetic */ Bundle n(Map map) {
        Bundle bundleA = A();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()) {
            Bundle bundle = new Bundle();
            bundle.putString("installed_asset_module_name", (String) entry.getKey());
            bundle.putLong("installed_asset_module_version", ((Long) entry.getValue()).longValue());
            arrayList.add(bundle);
        }
        bundleA.putParcelableArrayList("installed_asset_module", arrayList);
        return bundleA;
    }

    static /* bridge */ /* synthetic */ ArrayList v(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("module_name", str);
            arrayList.add(bundle);
        }
        return arrayList;
    }

    static /* bridge */ /* synthetic */ List w(ax axVar, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AssetPackState next = AssetPackStates.a((Bundle) it.next(), axVar.d, axVar.e).packStates().values().iterator().next();
            if (next == null) {
                f225a.b("onGetSessionStates: Bundle contained no pack.", new Object[0]);
            }
            if (bl.a(next.status())) {
                arrayList.add(next.name());
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle z(int i, String str) {
        Bundle bundleB = B(i);
        bundleB.putString("module_name", str);
        return bundleB;
    }

    @Override // com.google.android.play.core.assetpacks.z
    public final Task a(int i, String str, String str2, int i2) {
        if (this.f == null) {
            return C();
        }
        f225a.d("getChunkFileDescriptor(%s, %s, %d, session=%d)", str, str2, Integer.valueOf(i2), Integer.valueOf(i));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f.t(new ak(this, taskCompletionSource, i, str, str2, i2, taskCompletionSource), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    @Override // com.google.android.play.core.assetpacks.z
    public final Task b(List list, bf bfVar, Map map) {
        if (this.f == null) {
            return C();
        }
        f225a.d("getPackStates(%s)", list);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f.t(new ag(this, taskCompletionSource, list, map, taskCompletionSource, bfVar), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    @Override // com.google.android.play.core.assetpacks.z
    public final Task c(List list, Map map) {
        if (this.f == null) {
            return C();
        }
        f225a.d("startDownload(%s)", list);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f.t(new ad(this, taskCompletionSource, list, map, taskCompletionSource), taskCompletionSource);
        taskCompletionSource.getTask().addOnSuccessListener(new OnSuccessListener() { // from class: com.google.android.play.core.assetpacks.aa
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                this.f213a.f();
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // com.google.android.play.core.assetpacks.z
    public final Task d(Map map) {
        if (this.f == null) {
            return C();
        }
        f225a.d("syncPacks", new Object[0]);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f.t(new af(this, taskCompletionSource, map, taskCompletionSource), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    @Override // com.google.android.play.core.assetpacks.z
    public final void e(List list) {
        if (this.f == null) {
            return;
        }
        f225a.d("cancelDownloads(%s)", list);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f.t(new ae(this, taskCompletionSource, list, taskCompletionSource), taskCompletionSource);
    }

    @Override // com.google.android.play.core.assetpacks.z
    public final synchronized void f() {
        if (this.g == null) {
            f225a.e("Keep alive connection manager is not initialized.", new Object[0]);
            return;
        }
        com.google.android.play.core.assetpacks.internal.o oVar = f225a;
        oVar.d("keepAlive", new Object[0]);
        if (!this.h.compareAndSet(false, true)) {
            oVar.d("Service is already kept alive.", new Object[0]);
        } else {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.g.t(new al(this, taskCompletionSource, taskCompletionSource), taskCompletionSource);
        }
    }

    @Override // com.google.android.play.core.assetpacks.z
    public final void g(int i, String str, String str2, int i2) {
        if (this.f == null) {
            throw new cz("The Play Store app is not installed or is an unofficial version.", i);
        }
        f225a.d("notifyChunkTransferred", new Object[0]);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f.t(new ah(this, taskCompletionSource, i, str, str2, i2, taskCompletionSource), taskCompletionSource);
    }

    @Override // com.google.android.play.core.assetpacks.z
    public final void h(int i, String str) {
        D(i, str, 10);
    }

    @Override // com.google.android.play.core.assetpacks.z
    public final void i(int i) {
        if (this.f == null) {
            throw new cz("The Play Store app is not installed or is an unofficial version.", i);
        }
        f225a.d("notifySessionFailed", new Object[0]);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f.t(new aj(this, taskCompletionSource, i, taskCompletionSource), taskCompletionSource);
    }

    @Override // com.google.android.play.core.assetpacks.z
    public final void j(String str) {
        if (this.f == null) {
            return;
        }
        f225a.d("removePack(%s)", str);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f.t(new ac(this, taskCompletionSource, str, taskCompletionSource), taskCompletionSource);
    }
}
