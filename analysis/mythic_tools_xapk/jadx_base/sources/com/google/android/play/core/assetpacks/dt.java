package com.google.android.play.core.assetpacks;

import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class dt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.google.android.play.core.assetpacks.internal.o f285a = new com.google.android.play.core.assetpacks.internal.o("ExtractorSessionStoreView");
    private final bm b;
    private final dd c;
    private final Map d = new HashMap();
    private final ReentrantLock e = new ReentrantLock();
    private final com.google.android.play.core.assetpacks.internal.aq f;
    private final com.google.android.play.core.assetpacks.internal.aq g;

    dt(bm bmVar, com.google.android.play.core.assetpacks.internal.aq aqVar, dd ddVar, com.google.android.play.core.assetpacks.internal.aq aqVar2) {
        this.b = bmVar;
        this.f = aqVar;
        this.c = ddVar;
        this.g = aqVar2;
    }

    public static /* synthetic */ Boolean a(dt dtVar, Bundle bundle) {
        boolean z;
        int i = bundle.getInt("session_id");
        boolean z2 = false;
        if (i == 0) {
            return false;
        }
        Map map = dtVar.d;
        Integer numValueOf = Integer.valueOf(i);
        boolean z3 = true;
        if (map.containsKey(numValueOf)) {
            dq dqVarQ = dtVar.q(i);
            int i2 = bundle.getInt(com.google.android.play.core.assetpacks.model.b.a("status", dqVarQ.c.f282a));
            dp dpVar = dqVarQ.c;
            int i3 = dpVar.d;
            if (bl.c(i3, i2)) {
                f285a.a("Found stale update for session %s with status %d.", numValueOf, Integer.valueOf(i3));
                dp dpVar2 = dqVarQ.c;
                int i4 = dpVar2.d;
                String str = dpVar2.f282a;
                if (i4 == 4) {
                    ((z) dtVar.f.a()).h(i, str);
                } else if (i4 == 5) {
                    ((z) dtVar.f.a()).i(i);
                } else if (i4 == 6) {
                    ((z) dtVar.f.a()).e(Arrays.asList(str));
                }
            } else {
                dpVar.d = i2;
                if (bl.d(i2)) {
                    dtVar.n(i);
                    dtVar.c.c(dqVarQ.c.f282a);
                } else {
                    for (dr drVar : dpVar.f) {
                        ArrayList parcelableArrayList = bundle.getParcelableArrayList(com.google.android.play.core.assetpacks.model.b.b("chunk_intents", dqVarQ.c.f282a, drVar.f284a));
                        if (parcelableArrayList != null) {
                            for (int i5 = 0; i5 < parcelableArrayList.size(); i5++) {
                                if (parcelableArrayList.get(i5) != null && ((Intent) parcelableArrayList.get(i5)).getData() != null) {
                                    ((Cdo) drVar.d.get(i5)).f281a = true;
                                }
                            }
                        }
                    }
                }
            }
            z = true;
        } else {
            String strS = s(bundle);
            long j = bundle.getLong(com.google.android.play.core.assetpacks.model.b.a("pack_version", strS));
            String string = bundle.getString(com.google.android.play.core.assetpacks.model.b.a("pack_version_tag", strS), "");
            int i6 = bundle.getInt(com.google.android.play.core.assetpacks.model.b.a("status", strS));
            long j2 = bundle.getLong(com.google.android.play.core.assetpacks.model.b.a("total_bytes_to_download", strS));
            ArrayList<String> stringArrayList = bundle.getStringArrayList(com.google.android.play.core.assetpacks.model.b.a("slice_ids", strS));
            ArrayList arrayList = new ArrayList();
            Iterator it = t(stringArrayList).iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(com.google.android.play.core.assetpacks.model.b.b("chunk_intents", strS, str2));
                boolean z4 = z3;
                ArrayList arrayList2 = new ArrayList();
                Iterator it2 = t(parcelableArrayList2).iterator();
                while (it2.hasNext()) {
                    if (((Intent) it2.next()) != null) {
                        z2 = z4;
                    }
                    arrayList2.add(new Cdo(z2));
                    it = it;
                    z2 = false;
                }
                Iterator it3 = it;
                String string2 = bundle.getString(com.google.android.play.core.assetpacks.model.b.b("uncompressed_hash_sha256", strS, str2));
                long j3 = bundle.getLong(com.google.android.play.core.assetpacks.model.b.b("uncompressed_size", strS, str2));
                int i7 = bundle.getInt(com.google.android.play.core.assetpacks.model.b.b("patch_format", strS, str2), 0);
                arrayList.add(i7 != 0 ? new dr(str2, string2, j3, arrayList2, 0, i7) : new dr(str2, string2, j3, arrayList2, bundle.getInt(com.google.android.play.core.assetpacks.model.b.b("compression_format", strS, str2), 0), 0));
                z2 = false;
                z3 = z4;
                it = it3;
            }
            z = z3;
            dtVar.d.put(Integer.valueOf(i), new dq(i, bundle.getInt("app_version_code"), new dp(strS, j, i6, j2, arrayList, string)));
        }
        return Boolean.valueOf(z);
    }

    public static /* synthetic */ Boolean b(dt dtVar, Bundle bundle) {
        int i = bundle.getInt("session_id");
        if (i == 0) {
            return true;
        }
        Map map = dtVar.d;
        Integer numValueOf = Integer.valueOf(i);
        if (!map.containsKey(numValueOf)) {
            return true;
        }
        if (((dq) dtVar.d.get(numValueOf)).c.d == 6) {
            return false;
        }
        return Boolean.valueOf(!bl.c(r4.c.d, bundle.getInt(com.google.android.play.core.assetpacks.model.b.a("status", s(bundle)))));
    }

    public static /* synthetic */ Object c(dt dtVar, String str, int i, long j) {
        dq dqVar = (dq) dtVar.u(Arrays.asList(str)).get(str);
        if (dqVar == null || bl.d(dqVar.c.d)) {
            f285a.b(String.format("Could not find pack %s while trying to complete it", str), new Object[0]);
        }
        dtVar.b.E(str, i, j);
        dqVar.c.d = 4;
        return null;
    }

    public static /* synthetic */ Object d(dt dtVar, int i) {
        dq dqVarQ = dtVar.q(i);
        dp dpVar = dqVarQ.c;
        if (!bl.d(dpVar.d)) {
            throw new cz(String.format("Could not safely delete session %d because it is not in a terminal state.", Integer.valueOf(i)), i);
        }
        dtVar.b.E(dpVar.f282a, dqVarQ.b, dpVar.b);
        dp dpVar2 = dqVarQ.c;
        int i2 = dpVar2.d;
        if (i2 != 5 && i2 != 6) {
            return null;
        }
        dtVar.b.F(dpVar2.f282a, dqVarQ.b, dpVar2.b);
        return null;
    }

    public static /* synthetic */ Object e(dt dtVar, int i, int i2) {
        dtVar.q(i).c.d = 5;
        return null;
    }

    public static /* synthetic */ Map f(dt dtVar, List list) {
        HashMap map = new HashMap();
        for (dq dqVar : dtVar.d.values()) {
            String str = dqVar.c.f282a;
            if (list.contains(str)) {
                dq dqVar2 = (dq) map.get(str);
                if ((dqVar2 == null ? -1 : dqVar2.f283a) < dqVar.f283a) {
                    map.put(str, dqVar);
                }
            }
        }
        return map;
    }

    public static /* synthetic */ Map g(final dt dtVar, List list) {
        Map mapU = dtVar.u(list);
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            final dq dqVar = (dq) mapU.get(str);
            if (dqVar == null) {
                map.put(str, 8);
            } else {
                dp dpVar = dqVar.c;
                if (bl.a(dpVar.d)) {
                    try {
                        dpVar.d = 6;
                        ((Executor) dtVar.g.a()).execute(new Runnable() { // from class: com.google.android.play.core.assetpacks.dm
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f279a.n(dqVar.f283a);
                            }
                        });
                        dtVar.c.c(str);
                    } catch (cz unused) {
                        f285a.d("Session %d with pack %s does not exist, no need to cancel.", Integer.valueOf(dqVar.f283a), str);
                    }
                }
                map.put(str, Integer.valueOf(dqVar.c.d));
            }
        }
        return map;
    }

    private final dq q(int i) {
        Map map = this.d;
        Integer numValueOf = Integer.valueOf(i);
        dq dqVar = (dq) map.get(numValueOf);
        if (dqVar != null) {
            return dqVar;
        }
        throw new cz(String.format("Could not find session %d while trying to get it", numValueOf), i);
    }

    private final Object r(ds dsVar) {
        try {
            this.e.lock();
            return dsVar.a();
        } finally {
            this.e.unlock();
        }
    }

    private static String s(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
        if (stringArrayList == null || stringArrayList.isEmpty()) {
            throw new cz("Session without pack received.");
        }
        return stringArrayList.get(0);
    }

    private static List t(List list) {
        return list == null ? Collections.emptyList() : list;
    }

    private final Map u(final List list) {
        return (Map) r(new ds() { // from class: com.google.android.play.core.assetpacks.dk
            @Override // com.google.android.play.core.assetpacks.ds
            public final Object a() {
                return dt.f(this.f277a, list);
            }
        });
    }

    final Map h(final List list) {
        return (Map) r(new ds() { // from class: com.google.android.play.core.assetpacks.dj
            @Override // com.google.android.play.core.assetpacks.ds
            public final Object a() {
                return dt.g(this.f276a, list);
            }
        });
    }

    final Map i() {
        return this.d;
    }

    final void j() {
        this.e.lock();
    }

    final void k(final String str, final int i, final long j) {
        r(new ds() { // from class: com.google.android.play.core.assetpacks.dh
            @Override // com.google.android.play.core.assetpacks.ds
            public final Object a() {
                dt.c(this.f274a, str, i, j);
                return null;
            }
        });
    }

    final void l() {
        this.e.unlock();
    }

    final void m(final int i, int i2) {
        final int i3 = 5;
        r(new ds(i, i3) { // from class: com.google.android.play.core.assetpacks.di
            public final /* synthetic */ int b;

            @Override // com.google.android.play.core.assetpacks.ds
            public final Object a() {
                dt.e(this.f275a, this.b, 5);
                return null;
            }
        });
    }

    final void n(final int i) {
        r(new ds() { // from class: com.google.android.play.core.assetpacks.dg
            @Override // com.google.android.play.core.assetpacks.ds
            public final Object a() {
                dt.d(this.f273a, i);
                return null;
            }
        });
    }

    final boolean o(final Bundle bundle) {
        return ((Boolean) r(new ds() { // from class: com.google.android.play.core.assetpacks.dn
            @Override // com.google.android.play.core.assetpacks.ds
            public final Object a() {
                return dt.b(this.f280a, bundle);
            }
        })).booleanValue();
    }

    final boolean p(final Bundle bundle) {
        return ((Boolean) r(new ds() { // from class: com.google.android.play.core.assetpacks.dl
            @Override // com.google.android.play.core.assetpacks.ds
            public final Object a() {
                return dt.a(this.f278a, bundle);
            }
        })).booleanValue();
    }
}
