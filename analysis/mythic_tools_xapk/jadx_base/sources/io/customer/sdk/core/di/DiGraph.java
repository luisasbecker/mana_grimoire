package io.customer.sdk.core.di;

import io.customer.base.internal.InternalCustomerIOApi;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DiGraph.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u000b\u001a\u00020\u0006\"\n\b\u0000\u0010\f\u0018\u0001*\u00020\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0086\bJ&\u0010\u000e\u001a\u0004\u0018\u0001H\f\"\n\b\u0000\u0010\f\u0018\u0001*\u00020\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0086\b¢\u0006\u0002\u0010\u000fJ5\u0010\u0010\u001a\u0002H\f\"\n\b\u0000\u0010\f\u0018\u0001*\u00020\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\f0\u0012H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0013J7\u0010\u0014\u001a\u0002H\f\"\n\b\u0000\u0010\f\u0018\u0001*\u00020\u00012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\f0\u0012H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0013J(\u0010\u0015\u001a\u0004\u0018\u0001H\f\"\n\b\u0000\u0010\f\u0018\u0001*\u00020\u00012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0086\b¢\u0006\u0002\u0010\u000fJ7\u0010\u0016\u001a\u0002H\f\"\n\b\u0000\u0010\f\u0018\u0001*\u00020\u00012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\f0\u0012H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0013J.\u0010\u0017\u001a\u00020\u0018\"\n\b\u0000\u0010\f\u0018\u0001*\u00020\u00012\u0006\u0010\u0019\u001a\u0002H\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0086\b¢\u0006\u0002\u0010\u001aJ7\u0010\u001b\u001a\u0002H\f\"\n\b\u0000\u0010\f\u0018\u0001*\u00020\u00012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\f0\u0012H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0013J\b\u0010\u001c\u001a\u00020\u0018H\u0017R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, d2 = {"Lio/customer/sdk/core/di/DiGraph;", "", "<init>", "()V", "overrides", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getOverrides", "()Ljava/util/concurrent/ConcurrentHashMap;", "singletons", "getSingletons", "dependencyKey", "Dependency", "identifier", "getOverriddenInstance", "(Ljava/lang/String;)Ljava/lang/Object;", "getOrCreateSingletonInstance", "newInstanceCreator", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "newInstance", "getOrNull", "singleton", "overrideDependency", "", "value", "(Ljava/lang/Object;Ljava/lang/String;)V", "registerDependency", "reset", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DiGraph {
    private final ConcurrentHashMap<String, Object> overrides = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> singletons = new ConcurrentHashMap<>();

    public static /* synthetic */ Object getOrNull$default(DiGraph diGraph, String str, int i, Object obj) {
        String name;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOrNull");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        ConcurrentHashMap<String, Object> overrides = diGraph.getOverrides();
        if (str == null) {
            Intrinsics.reifiedOperationMarker(4, "Dependency");
            name = Object.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        } else {
            name = str;
        }
        Object obj2 = overrides.get(name);
        Intrinsics.reifiedOperationMarker(2, "Dependency");
        if (obj2 != null) {
            return obj2;
        }
        ConcurrentHashMap<String, Object> singletons = diGraph.getSingletons();
        if (str == null) {
            Intrinsics.reifiedOperationMarker(4, "Dependency");
            str = Object.class.getName();
            Intrinsics.checkNotNullExpressionValue(str, "getName(...)");
        }
        Object obj3 = singletons.get(str);
        Intrinsics.reifiedOperationMarker(2, "Dependency");
        return obj3;
    }

    public static /* synthetic */ Object newInstance$default(DiGraph diGraph, String str, Function0 newInstanceCreator, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: newInstance");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        Intrinsics.checkNotNullParameter(newInstanceCreator, "newInstanceCreator");
        ConcurrentHashMap<String, Object> overrides = diGraph.getOverrides();
        if (str == null) {
            Intrinsics.reifiedOperationMarker(4, "Dependency");
            str = Object.class.getName();
            Intrinsics.checkNotNullExpressionValue(str, "getName(...)");
        }
        Object obj2 = overrides.get(str);
        Intrinsics.reifiedOperationMarker(2, "Dependency");
        return obj2 == null ? newInstanceCreator.invoke() : obj2;
    }

    public static /* synthetic */ void overrideDependency$default(DiGraph diGraph, Object value, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: overrideDependency");
        }
        if ((i & 2) != 0) {
            str = null;
        }
        Intrinsics.checkNotNullParameter(value, "value");
        if (str == null) {
            Intrinsics.reifiedOperationMarker(4, "Dependency");
            str = Object.class.getName();
            Intrinsics.checkNotNullExpressionValue(str, "getName(...)");
        }
        diGraph.getOverrides().put(str, value);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0036 A[Catch: all -> 0x004d, TryCatch #0 {, blocks: (B:9:0x0013, B:10:0x002a, B:12:0x0036, B:16:0x0043), top: B:24:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ Object registerDependency$default(DiGraph diGraph, String str, Function0 newInstanceCreator, int i, Object obj) {
        Object obj2;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerDependency");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        Intrinsics.checkNotNullParameter(newInstanceCreator, "newInstanceCreator");
        synchronized (diGraph.getSingletons()) {
            if (str == null) {
                Intrinsics.reifiedOperationMarker(4, "Dependency");
                str = Object.class.getName();
                Intrinsics.checkNotNullExpressionValue(str, "getName(...)");
                ConcurrentHashMap<String, Object> singletons = diGraph.getSingletons();
                obj2 = singletons.get(str);
                if (obj2 == null) {
                    Object objInvoke = newInstanceCreator.invoke();
                    Object objPutIfAbsent = singletons.putIfAbsent(str, objInvoke);
                    obj2 = objPutIfAbsent == null ? objInvoke : objPutIfAbsent;
                }
                Intrinsics.reifiedOperationMarker(1, "Dependency");
            } else {
                ConcurrentHashMap<String, Object> singletons2 = diGraph.getSingletons();
                obj2 = singletons2.get(str);
                if (obj2 == null) {
                }
                Intrinsics.reifiedOperationMarker(1, "Dependency");
            }
        }
        return obj2;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0063 A[Catch: all -> 0x007a, TryCatch #0 {, blocks: (B:15:0x0041, B:16:0x0057, B:18:0x0063, B:22:0x0070), top: B:31:0x0041 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ Object singleton$default(DiGraph diGraph, String str, Function0 newInstanceCreator, int i, Object obj) {
        String name;
        Object obj2;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: singleton");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        Intrinsics.checkNotNullParameter(newInstanceCreator, "newInstanceCreator");
        ConcurrentHashMap<String, Object> overrides = diGraph.getOverrides();
        if (str == null) {
            Intrinsics.reifiedOperationMarker(4, "Dependency");
            name = Object.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        } else {
            name = str;
        }
        Object obj3 = overrides.get(name);
        Intrinsics.reifiedOperationMarker(2, "Dependency");
        if (obj3 != null) {
            return obj3;
        }
        synchronized (diGraph.getSingletons()) {
            if (str == null) {
                Intrinsics.reifiedOperationMarker(4, "Dependency");
                str = Object.class.getName();
                Intrinsics.checkNotNullExpressionValue(str, "getName(...)");
                ConcurrentHashMap<String, Object> singletons = diGraph.getSingletons();
                obj2 = singletons.get(str);
                if (obj2 == null) {
                    Object objInvoke = newInstanceCreator.invoke();
                    Object objPutIfAbsent = singletons.putIfAbsent(str, objInvoke);
                    obj2 = objPutIfAbsent == null ? objInvoke : objPutIfAbsent;
                }
                Intrinsics.reifiedOperationMarker(1, "Dependency");
            } else {
                ConcurrentHashMap<String, Object> singletons2 = diGraph.getSingletons();
                obj2 = singletons2.get(str);
                if (obj2 == null) {
                }
                Intrinsics.reifiedOperationMarker(1, "Dependency");
            }
        }
        return obj2;
    }

    public final /* synthetic */ <Dependency> String dependencyKey(String identifier) {
        if (identifier != null) {
            return identifier;
        }
        Intrinsics.reifiedOperationMarker(4, "Dependency");
        String name = Object.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return name;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002f A[Catch: all -> 0x0047, TryCatch #0 {, blocks: (B:5:0x000c, B:6:0x0023, B:8:0x002f, B:12:0x003c), top: B:18:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ <Dependency> Dependency getOrCreateSingletonInstance(String identifier, Function0<? extends Dependency> newInstanceCreator) {
        Dependency dependency;
        Intrinsics.checkNotNullParameter(newInstanceCreator, "newInstanceCreator");
        synchronized (getSingletons()) {
            if (identifier == null) {
                Intrinsics.reifiedOperationMarker(4, "Dependency");
                identifier = Object.class.getName();
                Intrinsics.checkNotNullExpressionValue(identifier, "getName(...)");
                String str = identifier;
                ConcurrentHashMap<String, Object> singletons = getSingletons();
                dependency = (Dependency) singletons.get(identifier);
                if (dependency == null) {
                    Dependency dependencyInvoke = newInstanceCreator.invoke();
                    Object objPutIfAbsent = singletons.putIfAbsent(identifier, dependencyInvoke);
                    dependency = objPutIfAbsent == null ? dependencyInvoke : (Dependency) objPutIfAbsent;
                }
                Intrinsics.reifiedOperationMarker(1, "Dependency");
                Object obj = dependency;
            } else {
                ConcurrentHashMap<String, Object> singletons2 = getSingletons();
                dependency = (Dependency) singletons2.get(identifier);
                if (dependency == null) {
                }
                Intrinsics.reifiedOperationMarker(1, "Dependency");
                Object obj2 = dependency;
            }
        }
        return dependency;
    }

    public final /* synthetic */ <Dependency> Dependency getOrNull(String identifier) {
        String name;
        ConcurrentHashMap<String, Object> overrides = getOverrides();
        if (identifier == null) {
            Intrinsics.reifiedOperationMarker(4, "Dependency");
            name = Object.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        } else {
            name = identifier;
        }
        Dependency dependency = (Dependency) overrides.get(name);
        Intrinsics.reifiedOperationMarker(2, "Dependency");
        if (dependency != null) {
            return dependency;
        }
        ConcurrentHashMap<String, Object> singletons = getSingletons();
        if (identifier == null) {
            Intrinsics.reifiedOperationMarker(4, "Dependency");
            identifier = Object.class.getName();
            Intrinsics.checkNotNullExpressionValue(identifier, "getName(...)");
        }
        Dependency dependency2 = (Dependency) singletons.get(identifier);
        Intrinsics.reifiedOperationMarker(2, "Dependency");
        return dependency2;
    }

    public final /* synthetic */ <Dependency> Dependency getOverriddenInstance(String identifier) {
        ConcurrentHashMap<String, Object> overrides = getOverrides();
        if (identifier == null) {
            Intrinsics.reifiedOperationMarker(4, "Dependency");
            identifier = Object.class.getName();
            Intrinsics.checkNotNullExpressionValue(identifier, "getName(...)");
        }
        Dependency dependency = (Dependency) overrides.get(identifier);
        Intrinsics.reifiedOperationMarker(2, "Dependency");
        return dependency;
    }

    public final ConcurrentHashMap<String, Object> getOverrides() {
        return this.overrides;
    }

    public final ConcurrentHashMap<String, Object> getSingletons() {
        return this.singletons;
    }

    public final /* synthetic */ <Dependency> Dependency newInstance(String identifier, Function0<? extends Dependency> newInstanceCreator) {
        Intrinsics.checkNotNullParameter(newInstanceCreator, "newInstanceCreator");
        ConcurrentHashMap<String, Object> overrides = getOverrides();
        if (identifier == null) {
            Intrinsics.reifiedOperationMarker(4, "Dependency");
            identifier = Object.class.getName();
            Intrinsics.checkNotNullExpressionValue(identifier, "getName(...)");
        }
        Dependency dependency = (Dependency) overrides.get(identifier);
        Intrinsics.reifiedOperationMarker(2, "Dependency");
        return dependency == null ? newInstanceCreator.invoke() : dependency;
    }

    public final /* synthetic */ <Dependency> void overrideDependency(Dependency value, String identifier) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (identifier == null) {
            Intrinsics.reifiedOperationMarker(4, "Dependency");
            identifier = Object.class.getName();
            Intrinsics.checkNotNullExpressionValue(identifier, "getName(...)");
        }
        getOverrides().put(identifier, value);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002f A[Catch: all -> 0x0047, TryCatch #0 {, blocks: (B:5:0x000c, B:6:0x0023, B:8:0x002f, B:12:0x003c), top: B:18:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ <Dependency> Dependency registerDependency(String identifier, Function0<? extends Dependency> newInstanceCreator) {
        Dependency dependency;
        Intrinsics.checkNotNullParameter(newInstanceCreator, "newInstanceCreator");
        synchronized (getSingletons()) {
            if (identifier == null) {
                Intrinsics.reifiedOperationMarker(4, "Dependency");
                identifier = Object.class.getName();
                Intrinsics.checkNotNullExpressionValue(identifier, "getName(...)");
                String str = identifier;
                ConcurrentHashMap<String, Object> singletons = getSingletons();
                dependency = (Dependency) singletons.get(identifier);
                if (dependency == null) {
                    Dependency dependencyInvoke = newInstanceCreator.invoke();
                    Object objPutIfAbsent = singletons.putIfAbsent(identifier, dependencyInvoke);
                    dependency = objPutIfAbsent == null ? dependencyInvoke : (Dependency) objPutIfAbsent;
                }
                Intrinsics.reifiedOperationMarker(1, "Dependency");
                Object obj = dependency;
            } else {
                ConcurrentHashMap<String, Object> singletons2 = getSingletons();
                dependency = (Dependency) singletons2.get(identifier);
                if (dependency == null) {
                }
                Intrinsics.reifiedOperationMarker(1, "Dependency");
                Object obj2 = dependency;
            }
        }
        return dependency;
    }

    @InternalCustomerIOApi
    public void reset() {
        synchronized (this.overrides) {
            this.overrides.clear();
            Unit unit = Unit.INSTANCE;
        }
        synchronized (this.singletons) {
            this.singletons.clear();
            Unit unit2 = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005c A[Catch: all -> 0x0074, TryCatch #0 {, blocks: (B:11:0x003a, B:12:0x0050, B:14:0x005c, B:18:0x0069), top: B:25:0x003a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ <Dependency> Dependency singleton(String identifier, Function0<? extends Dependency> newInstanceCreator) {
        String name;
        Dependency dependency;
        Intrinsics.checkNotNullParameter(newInstanceCreator, "newInstanceCreator");
        ConcurrentHashMap<String, Object> overrides = getOverrides();
        if (identifier == null) {
            Intrinsics.reifiedOperationMarker(4, "Dependency");
            name = Object.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        } else {
            name = identifier;
        }
        Dependency dependency2 = (Dependency) overrides.get(name);
        Intrinsics.reifiedOperationMarker(2, "Dependency");
        if (dependency2 != null) {
            return dependency2;
        }
        synchronized (getSingletons()) {
            if (identifier == null) {
                Intrinsics.reifiedOperationMarker(4, "Dependency");
                identifier = Object.class.getName();
                Intrinsics.checkNotNullExpressionValue(identifier, "getName(...)");
                String str = identifier;
                ConcurrentHashMap<String, Object> singletons = getSingletons();
                dependency = (Dependency) singletons.get(identifier);
                if (dependency == null) {
                    Dependency dependencyInvoke = newInstanceCreator.invoke();
                    Object objPutIfAbsent = singletons.putIfAbsent(identifier, dependencyInvoke);
                    dependency = objPutIfAbsent == null ? dependencyInvoke : (Dependency) objPutIfAbsent;
                }
                Intrinsics.reifiedOperationMarker(1, "Dependency");
                Object obj = dependency;
            } else {
                ConcurrentHashMap<String, Object> singletons2 = getSingletons();
                dependency = (Dependency) singletons2.get(identifier);
                if (dependency == null) {
                }
                Intrinsics.reifiedOperationMarker(1, "Dependency");
                Object obj2 = dependency;
            }
        }
        return dependency;
    }
}
