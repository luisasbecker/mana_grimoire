package io.customer.sdk.core.extensions;

import io.customer.sdk.core.di.DiGraph;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DiGraphExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002\"\u0010\b\u0001\u0010\u0003\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00030\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0003H\u0086\b¢\u0006\u0002\u0010\u0007\u001aI\u0010\b\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002\"\u0010\b\u0001\u0010\u0003\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00030\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, d2 = {"getOrNull", "Dependency", "", "Key", "", "Lio/customer/sdk/core/di/DiGraph;", "identifier", "(Lio/customer/sdk/core/di/DiGraph;Ljava/lang/Enum;)Ljava/lang/Object;", "registerDependency", "newInstanceCreator", "Lkotlin/Function0;", "(Lio/customer/sdk/core/di/DiGraph;Ljava/lang/Enum;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DiGraphExtKt {
    public static final /* synthetic */ <Dependency, Key extends Enum<Key>> Dependency getOrNull(DiGraph diGraph, Key identifier) {
        String name;
        Intrinsics.checkNotNullParameter(diGraph, "<this>");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        String strName = identifier.name();
        ConcurrentHashMap<String, Object> overrides = diGraph.getOverrides();
        if (strName == null) {
            Intrinsics.reifiedOperationMarker(4, "Dependency");
            name = Object.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        } else {
            name = strName;
        }
        Dependency dependency = (Dependency) overrides.get(name);
        Intrinsics.reifiedOperationMarker(2, "Dependency");
        if (dependency != null) {
            return dependency;
        }
        ConcurrentHashMap<String, Object> singletons = diGraph.getSingletons();
        if (strName == null) {
            Intrinsics.reifiedOperationMarker(4, "Dependency");
            strName = Object.class.getName();
            Intrinsics.checkNotNullExpressionValue(strName, "getName(...)");
        }
        Dependency dependency2 = (Dependency) singletons.get(strName);
        Intrinsics.reifiedOperationMarker(2, "Dependency");
        return dependency2;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x003d A[Catch: all -> 0x0055, TryCatch #0 {, blocks: (B:5:0x001a, B:6:0x0031, B:8:0x003d, B:12:0x004a), top: B:18:0x001a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ <Dependency, Key extends Enum<Key>> Dependency registerDependency(DiGraph diGraph, Key identifier, Function0<? extends Dependency> newInstanceCreator) {
        Dependency dependency;
        Intrinsics.checkNotNullParameter(diGraph, "<this>");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(newInstanceCreator, "newInstanceCreator");
        String strName = identifier.name();
        synchronized (diGraph.getSingletons()) {
            if (strName == null) {
                Intrinsics.reifiedOperationMarker(4, "Dependency");
                strName = Object.class.getName();
                Intrinsics.checkNotNullExpressionValue(strName, "getName(...)");
                String str = strName;
                ConcurrentHashMap<String, Object> singletons = diGraph.getSingletons();
                dependency = (Dependency) singletons.get(strName);
                if (dependency == null) {
                    Dependency dependencyInvoke = newInstanceCreator.invoke();
                    Object objPutIfAbsent = singletons.putIfAbsent(strName, dependencyInvoke);
                    dependency = objPutIfAbsent == null ? dependencyInvoke : (Dependency) objPutIfAbsent;
                }
                Intrinsics.reifiedOperationMarker(1, "Dependency");
                Object obj = dependency;
            } else {
                ConcurrentHashMap<String, Object> singletons2 = diGraph.getSingletons();
                dependency = (Dependency) singletons2.get(strName);
                if (dependency == null) {
                }
                Intrinsics.reifiedOperationMarker(1, "Dependency");
                Object obj2 = dependency;
            }
        }
        return dependency;
    }
}
