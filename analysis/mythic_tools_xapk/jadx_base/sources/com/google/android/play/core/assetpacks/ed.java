package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.common.LocalTestingException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class ed implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f295a = 0;
    private static final com.google.android.play.core.assetpacks.internal.o b = new com.google.android.play.core.assetpacks.internal.o("FakeAssetPackService");
    private static final AtomicInteger c = new AtomicInteger(1);
    private final String d;
    private final bc e;
    private final dd f;
    private final Context g;
    private final et h;
    private final er i;
    private final Handler j = new Handler(Looper.getMainLooper());
    private final com.google.android.play.core.assetpacks.internal.aq k;

    ed(File file, bc bcVar, dd ddVar, Context context, et etVar, com.google.android.play.core.assetpacks.internal.aq aqVar, er erVar) {
        this.d = file.getAbsolutePath();
        this.e = bcVar;
        this.f = ddVar;
        this.g = context;
        this.h = etVar;
        this.k = aqVar;
        this.i = erVar;
    }

    static long k(int i, long j) {
        if (i == 2) {
            return j / 2;
        }
        if (i == 3 || i == 4) {
            return j;
        }
        return 0L;
    }

    private final Bundle p(int i, String str, int i2) throws LocalTestingException {
        Bundle bundle = new Bundle();
        bundle.putInt("app_version_code", this.h.a());
        bundle.putInt("session_id", i);
        File[] fileArrV = v(str);
        ArrayList<String> arrayList = new ArrayList<>();
        long length = 0;
        for (File file : fileArrV) {
            length += file.length();
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
            arrayList2.add(i2 == 3 ? new Intent().setData(Uri.EMPTY) : null);
            String strA = com.google.android.play.core.assetpacks.internal.ak.a(file);
            bundle.putParcelableArrayList(com.google.android.play.core.assetpacks.model.b.b("chunk_intents", str, strA), arrayList2);
            bundle.putString(com.google.android.play.core.assetpacks.model.b.b("uncompressed_hash_sha256", str, strA), r(file));
            bundle.putLong(com.google.android.play.core.assetpacks.model.b.b("uncompressed_size", str, strA), file.length());
            arrayList.add(strA);
        }
        bundle.putStringArrayList(com.google.android.play.core.assetpacks.model.b.a("slice_ids", str), arrayList);
        bundle.putLong(com.google.android.play.core.assetpacks.model.b.a("pack_version", str), this.h.a());
        bundle.putInt(com.google.android.play.core.assetpacks.model.b.a("status", str), i2);
        bundle.putInt(com.google.android.play.core.assetpacks.model.b.a("error_code", str), 0);
        bundle.putLong(com.google.android.play.core.assetpacks.model.b.a("bytes_downloaded", str), k(i2, length));
        bundle.putLong(com.google.android.play.core.assetpacks.model.b.a("total_bytes_to_download", str), length);
        bundle.putStringArrayList("pack_names", new ArrayList<>(Arrays.asList(str)));
        bundle.putLong("bytes_downloaded", k(i2, length));
        bundle.putLong("total_bytes_to_download", length);
        final Intent intentPutExtra = new Intent("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE").putExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE", bundle);
        this.j.post(new Runnable() { // from class: com.google.android.play.core.assetpacks.ec
            @Override // java.lang.Runnable
            public final void run() {
                ed edVar = this.f294a;
                edVar.e.c(edVar.g, intentPutExtra);
            }
        });
        return bundle;
    }

    private final AssetPackState q(String str, int i) throws LocalTestingException {
        long length = 0;
        for (File file : v(str)) {
            length += file.length();
        }
        return AssetPackState.a(str, i, 0, k(i, length), length, this.f.a(str), 1, String.valueOf(this.h.a()), this.i.a(str));
    }

    private static String r(File file) throws LocalTestingException {
        try {
            return ef.a(Arrays.asList(file));
        } catch (IOException e) {
            throw new LocalTestingException(String.format("Could not digest file: %s.", file), e);
        } catch (NoSuchAlgorithmException e2) {
            throw new LocalTestingException("SHA256 algorithm not supported.", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final /* synthetic */ void s(List list, bf bfVar, TaskCompletionSource taskCompletionSource) {
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                AssetPackState assetPackStateQ = q(str, ((h) bfVar).f325a.a(8, str));
                j += assetPackStateQ.totalBytesToDownload();
                map.put(str, assetPackStateQ);
            } catch (LocalTestingException e) {
                taskCompletionSource.setException(e);
                return;
            }
        }
        taskCompletionSource.setResult(new bt(j, map));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final /* synthetic */ void t(int i, String str) {
        try {
            p(i, str, 4);
        } catch (LocalTestingException e) {
            b.e("notifyModuleCompleted failed", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final /* synthetic */ void u(List list, TaskCompletionSource taskCompletionSource) {
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                AssetPackState assetPackStateQ = q(str, 1);
                j += assetPackStateQ.totalBytesToDownload();
                map.put(str, assetPackStateQ);
            } catch (LocalTestingException e) {
                taskCompletionSource.setException(e);
                return;
            }
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            try {
                int andIncrement = c.getAndIncrement();
                p(andIncrement, str2, 1);
                p(andIncrement, str2, 2);
                p(andIncrement, str2, 3);
            } catch (LocalTestingException e2) {
                taskCompletionSource.setException(e2);
                return;
            }
        }
        taskCompletionSource.setResult(new bt(j, map));
    }

    private final File[] v(final String str) throws LocalTestingException {
        File file = new File(this.d);
        if (!file.isDirectory()) {
            throw new LocalTestingException(String.format("Local testing directory '%s' not found.", file));
        }
        File[] fileArrListFiles = file.listFiles(new FilenameFilter() { // from class: com.google.android.play.core.assetpacks.dy
            @Override // java.io.FilenameFilter
            public final boolean accept(File file2, String str2) {
                int i = ed.f295a;
                return str2.startsWith(String.valueOf(str).concat("-")) && str2.endsWith(".apk");
            }
        });
        if (fileArrListFiles == null) {
            throw new LocalTestingException(String.format("Failed fetching APKs for pack '%s'.", str));
        }
        if (fileArrListFiles.length == 0) {
            throw new LocalTestingException(String.format("No APKs available for pack '%s'.", str));
        }
        for (File file2 : fileArrListFiles) {
            if (com.google.android.play.core.assetpacks.internal.ak.a(file2).equals(str)) {
                return fileArrListFiles;
            }
        }
        throw new LocalTestingException(String.format("No main slice available for pack '%s'.", str));
    }

    @Override // com.google.android.play.core.assetpacks.z
    public final Task a(int i, String str, String str2, int i2) {
        int i3;
        b.d("getChunkFileDescriptor(session=%d, %s, %s, %d)", Integer.valueOf(i), str, str2, Integer.valueOf(i2));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
        } catch (LocalTestingException e) {
            b.e("getChunkFileDescriptor failed", e);
            taskCompletionSource.setException(e);
        } catch (FileNotFoundException e2) {
            b.e("getChunkFileDescriptor failed", e2);
            taskCompletionSource.setException(new LocalTestingException("Asset Slice file not found.", e2));
        }
        for (File file : v(str)) {
            if (com.google.android.play.core.assetpacks.internal.ak.a(file).equals(str2)) {
                taskCompletionSource.setResult(ParcelFileDescriptor.open(file, 268435456));
                return taskCompletionSource.getTask();
            }
        }
        throw new LocalTestingException(String.format("Local testing slice for '%s' not found.", str2));
    }

    @Override // com.google.android.play.core.assetpacks.z
    public final Task b(final List list, final bf bfVar, Map map) {
        b.d("getPackStates(%s)", list);
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        ((Executor) this.k.a()).execute(new Runnable() { // from class: com.google.android.play.core.assetpacks.eb
            @Override // java.lang.Runnable
            public final void run() {
                this.f293a.s(list, bfVar, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // com.google.android.play.core.assetpacks.z
    public final Task c(final List list, Map map) {
        b.d("startDownload(%s)", list);
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        ((Executor) this.k.a()).execute(new Runnable() { // from class: com.google.android.play.core.assetpacks.ea
            @Override // java.lang.Runnable
            public final void run() {
                this.f292a.u(list, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // com.google.android.play.core.assetpacks.z
    public final Task d(Map map) {
        b.d("syncPacks()", new Object[0]);
        return Tasks.forResult(new ArrayList());
    }

    @Override // com.google.android.play.core.assetpacks.z
    public final void e(List list) {
        b.d("cancelDownload(%s)", list);
    }

    @Override // com.google.android.play.core.assetpacks.z
    public final void f() {
        b.d("keepAlive", new Object[0]);
    }

    @Override // com.google.android.play.core.assetpacks.z
    public final void g(int i, String str, String str2, int i2) {
        b.d("notifyChunkTransferred", new Object[0]);
    }

    @Override // com.google.android.play.core.assetpacks.z
    public final void h(final int i, final String str) {
        b.d("notifyModuleCompleted", new Object[0]);
        ((Executor) this.k.a()).execute(new Runnable() { // from class: com.google.android.play.core.assetpacks.dz
            @Override // java.lang.Runnable
            public final void run() {
                this.f290a.t(i, str);
            }
        });
    }

    @Override // com.google.android.play.core.assetpacks.z
    public final void i(int i) {
        b.d("notifySessionFailed", new Object[0]);
    }

    @Override // com.google.android.play.core.assetpacks.z
    public final void j(String str) {
        b.d("removePack(%s)", str);
    }
}
