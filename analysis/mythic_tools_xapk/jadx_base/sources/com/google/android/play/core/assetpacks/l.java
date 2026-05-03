package com.google.android.play.core.assetpacks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.camera.video.AudioStats;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.revenuecat.purchases.amazon.purchasing.ProxyAmazonBillingActivity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class l implements AssetPackManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.google.android.play.core.assetpacks.internal.o f350a = new com.google.android.play.core.assetpacks.internal.o("AssetPackManager");
    private final bm b;
    private final bc c;
    private final bh d;
    private final com.google.android.play.core.assetpacks.internal.ad e;
    private final dt f;
    private final dd g;
    private final ci h;
    private final er i;
    private final Handler j = new Handler(Looper.getMainLooper());
    private boolean k;
    private final com.google.android.play.core.assetpacks.internal.aq l;
    private final com.google.android.play.core.assetpacks.internal.aq m;

    l(bm bmVar, com.google.android.play.core.assetpacks.internal.aq aqVar, bc bcVar, bh bhVar, com.google.android.play.core.assetpacks.internal.ad adVar, dt dtVar, dd ddVar, ci ciVar, com.google.android.play.core.assetpacks.internal.aq aqVar2, er erVar) {
        this.b = bmVar;
        this.l = aqVar;
        this.c = bcVar;
        this.d = bhVar;
        this.e = adVar;
        this.f = dtVar;
        this.g = ddVar;
        this.h = ciVar;
        this.m = aqVar2;
        this.i = erVar;
    }

    public static /* synthetic */ void c(l lVar) {
        lVar.b.y();
        lVar.b.w();
        lVar.b.x();
    }

    public static /* synthetic */ void d(l lVar, String str, TaskCompletionSource taskCompletionSource) {
        if (!lVar.b.D(str)) {
            taskCompletionSource.setException(new IOException(String.format("Failed to remove pack %s.", str)));
        } else {
            taskCompletionSource.setResult(null);
            ((z) lVar.l.a()).j(str);
        }
    }

    public static /* synthetic */ void e(l lVar) {
        Task taskD = ((z) lVar.l.a()).d(lVar.b.u());
        Executor executor = (Executor) lVar.m.a();
        final bm bmVar = lVar.b;
        Objects.requireNonNull(bmVar);
        taskD.addOnSuccessListener(executor, new OnSuccessListener() { // from class: com.google.android.play.core.assetpacks.e
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                bmVar.C((List) obj);
            }
        }).addOnFailureListener((Executor) lVar.m.a(), new OnFailureListener() { // from class: com.google.android.play.core.assetpacks.f
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                l.f350a.e(String.format("Could not sync active asset packs. %s", exc), new Object[0]);
            }
        });
    }

    private final Task h(Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", this.h.a());
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        intent.putExtra(ProxyAmazonBillingActivity.EXTRAS_RESULT_RECEIVER, new k(this, this.j, taskCompletionSource));
        activity.startActivity(intent);
        return taskCompletionSource.getTask();
    }

    private final void i() {
        ((Executor) this.m.a()).execute(new Runnable() { // from class: com.google.android.play.core.assetpacks.g
            @Override // java.lang.Runnable
            public final void run() {
                l.e(this.f324a);
            }
        });
    }

    final int a(int i, String str) {
        if (!this.b.G(str) && i == 4) {
            return 8;
        }
        if (!this.b.G(str) || i == 4) {
            return i;
        }
        return 4;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final AssetPackStates cancel(List<String> list) {
        Map mapH = this.f.h(list);
        HashMap map = new HashMap();
        for (String str : list) {
            Integer num = (Integer) mapH.get(str);
            map.put(str, AssetPackState.a(str, num == null ? 0 : num.intValue(), 0, 0L, 0L, AudioStats.AUDIO_AMPLITUDE_NONE, 0, "", ""));
        }
        ((z) this.l.a()).e(list);
        return new bt(0L, map);
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final void clearListeners() {
        this.d.a();
        this.c.d();
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final Task<AssetPackStates> fetch(List<String> list) {
        Map mapU = this.b.u();
        ArrayList arrayList = new ArrayList(list);
        if (!arrayList.isEmpty()) {
            return ((z) this.l.a()).c(arrayList, mapU);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", 0);
        bundle.putInt("error_code", 0);
        for (String str : list) {
            bundle.putInt(com.google.android.play.core.assetpacks.model.b.a("status", str), 4);
            bundle.putInt(com.google.android.play.core.assetpacks.model.b.a("error_code", str), 0);
            bundle.putLong(com.google.android.play.core.assetpacks.model.b.a("total_bytes_to_download", str), 0L);
            bundle.putLong(com.google.android.play.core.assetpacks.model.b.a("bytes_downloaded", str), 0L);
        }
        bundle.putStringArrayList("pack_names", new ArrayList<>(list));
        bundle.putLong("total_bytes_to_download", 0L);
        bundle.putLong("bytes_downloaded", 0L);
        return Tasks.forResult(AssetPackStates.a(bundle, this.g, this.i));
    }

    final void g(boolean z) {
        bc bcVar = this.c;
        boolean zI = bcVar.i();
        bcVar.f(z);
        if (!z || zI) {
            return;
        }
        i();
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final AssetLocation getAssetLocation(String str, String str2) {
        AssetPackLocation assetPackLocationF;
        if (!this.k) {
            ((Executor) this.m.a()).execute(new j(this));
            this.k = true;
        }
        if (this.b.G(str)) {
            try {
                assetPackLocationF = this.b.f(str);
            } catch (IOException unused) {
            }
        } else {
            assetPackLocationF = this.e.a().contains(str) ? AssetPackLocation.a() : null;
        }
        if (assetPackLocationF == null) {
            return null;
        }
        if (assetPackLocationF.packStorageMethod() == 1) {
            bm bmVar = this.b;
            return bmVar.d(str, str2, bmVar.s(str));
        }
        if (assetPackLocationF.packStorageMethod() == 0) {
            return this.b.e(str, str2, assetPackLocationF);
        }
        f350a.a("The asset %s is not present in Asset Pack %s", str2, str);
        return null;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final AssetPackLocation getPackLocation(String str) {
        if (!this.k) {
            ((Executor) this.m.a()).execute(new j(this));
            this.k = true;
        }
        if (this.b.G(str)) {
            try {
                return this.b.f(str);
            } catch (IOException unused) {
                return null;
            }
        }
        if (this.e.a().contains(str)) {
            return AssetPackLocation.a();
        }
        return null;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final Map<String, AssetPackLocation> getPackLocations() {
        Map<String, AssetPackLocation> mapV = this.b.v();
        HashMap map = new HashMap();
        Iterator it = this.e.a().iterator();
        while (it.hasNext()) {
            map.put((String) it.next(), AssetPackLocation.a());
        }
        mapV.putAll(map);
        return mapV;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final Task<AssetPackStates> getPackStates(List<String> list) {
        return ((z) this.l.a()).b(list, new h(this), this.b.u());
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final synchronized void registerListener(AssetPackStateUpdateListener assetPackStateUpdateListener) {
        this.d.b(assetPackStateUpdateListener);
        bc bcVar = this.c;
        boolean zI = bcVar.i();
        bcVar.e(assetPackStateUpdateListener);
        if (zI) {
            return;
        }
        i();
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final Task<Void> removePack(final String str) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        ((Executor) this.m.a()).execute(new Runnable() { // from class: com.google.android.play.core.assetpacks.i
            @Override // java.lang.Runnable
            public final void run() {
                l.d(this.f326a, str, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final Task<Integer> showCellularDataConfirmation(Activity activity) {
        return activity == null ? Tasks.forException(new AssetPackException(-3)) : this.h.a() == null ? Tasks.forException(new AssetPackException(-12)) : h(activity);
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final boolean showCellularDataConfirmation(ActivityResultLauncher<IntentSenderRequest> activityResultLauncher) {
        if (activityResultLauncher == null || this.h.a() == null) {
            return false;
        }
        activityResultLauncher.launch(new IntentSenderRequest.Builder(this.h.a().getIntentSender()).build());
        return true;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final Task<Integer> showConfirmationDialog(Activity activity) {
        return activity == null ? Tasks.forException(new AssetPackException(-3)) : this.h.a() == null ? Tasks.forException(new AssetPackException(-14)) : h(activity);
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final boolean showConfirmationDialog(ActivityResultLauncher<IntentSenderRequest> activityResultLauncher) {
        if (activityResultLauncher == null || this.h.a() == null) {
            return false;
        }
        activityResultLauncher.launch(new IntentSenderRequest.Builder(this.h.a().getIntentSender()).build());
        return true;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final void unregisterListener(AssetPackStateUpdateListener assetPackStateUpdateListener) {
        this.d.c(assetPackStateUpdateListener);
        this.c.g(assetPackStateUpdateListener);
    }
}
