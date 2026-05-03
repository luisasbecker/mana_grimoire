package com.revenuecat.purchases.ui.revenuecatui.helpers;

import ai.onnxruntime.BuildConfig;
import androidx.exifinterface.media.ExifInterface;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import com.studiolaganne.lengendarylens.GameUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Result.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0084\u0001\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u0002\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\u0006\"\u0004\b\u0003\u0010\b2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u00022\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u00022\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u00060\u000eH\u0080\bø\u0001\u0000\u001aª\u0001\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u0002\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0006\"\u0004\b\u0004\u0010\b2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u00022\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u00022\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u0002H\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u00022\u001e\u0010\r\u001a\u001a\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u00060\u0011H\u0080\bø\u0001\u0000\u001aÐ\u0001\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u0002\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0012\"\u0004\b\u0004\u0010\u0006\"\u0004\b\u0005\u0010\b2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u00022\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u00022\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u0002H\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u00022\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u0002H\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u00022$\u0010\r\u001a \u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00060\u0014H\u0080\bø\u0001\u0000\u001aö\u0001\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u0002\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0012\"\u0004\b\u0004\u0010\u0015\"\u0004\b\u0005\u0010\u0006\"\u0004\b\u0006\u0010\b2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u00022\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u00022\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u0002H\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u00022\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u0002H\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u00022\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u0002H\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u00022*\u0010\r\u001a&\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00060\u0017H\u0080\bø\u0001\u0000\u001a\u009c\u0002\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u0002\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0012\"\u0004\b\u0004\u0010\u0015\"\u0004\b\u0005\u0010\u0018\"\u0004\b\u0006\u0010\u0006\"\u0004\b\u0007\u0010\b2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u00022\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u00022\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u0002H\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u00022\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u0002H\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u00022\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u0002H\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u00022\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u0002H\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u000220\u0010\r\u001a,\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00060\u001aH\u0080\bø\u0001\u0000\u001aÂ\u0002\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u00070\u0002\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0012\"\u0004\b\u0004\u0010\u0015\"\u0004\b\u0005\u0010\u0018\"\u0004\b\u0006\u0010\u0006\"\u0004\b\u0007\u0010\b\"\u0004\b\b\u0010\u001b2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u00070\u00022\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u00070\u00022\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u0002H\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u00070\u00022\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u0002H\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u00070\u00022\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u0002H\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u00070\u00022\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u0002H\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u00070\u00022\u0018\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u00070\u000226\u0010\r\u001a2\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\b0\u001dH\u0080\bø\u0001\u0000\u001a6\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001f\"\u0004\b\u0000\u0010 \"\u0004\b\u0001\u0010\u0018*\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H \u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u00070\u00020\u001fH\u0002\u001a8\u0010!\u001a\u0010\u0012\u0006\u0012\u0004\b\u0002H\t\u0012\u0004\u0012\u0002H\n0\u0002\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n*\u0004\u0018\u0001H\t2\u0006\u0010\"\u001a\u0002H\nH\u0000ø\u0001\u0001¢\u0006\u0002\u0010#\u001a+\u0010$\u001a\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n*\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\u0002H\u0000¢\u0006\u0002\u0010%\u001ai\u0010&\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H\n0\u0002\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010'*\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\u00022-\u0010\r\u001a)\u0012\u0013\u0012\u0011H\t¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H\n0\u00020(H\u0080\bø\u0001\u0000\u001ai\u0010,\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H'0\u0002\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010'*\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\u00022-\u0010\r\u001a)\u0012\u0013\u0012\u0011H\n¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H'0\u00020(H\u0080\bø\u0001\u0000\u001aZ\u0010-\u001a\u0002H'\"\b\b\u0000\u0010\t*\u0002H'\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010'*\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\u00022!\u0010.\u001a\u001d\u0012\u0013\u0012\u0011H\n¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H'0(H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010/\u001a+\u00100\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n*\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\u0002H\u0000¢\u0006\u0002\u0010%\u001a)\u00101\u001a\u0002H\t\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n*\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\u0002H\u0000¢\u0006\u0002\u0010%\u001a]\u00102\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H\n0\u0002\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010'*\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\u00022!\u0010\r\u001a\u001d\u0012\u0013\u0012\u0011H\t¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002H'0(H\u0080\bø\u0001\u0000\u001a]\u00103\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H'0\u0002\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010'*\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\u00022!\u0010\r\u001a\u001d\u0012\u0013\u0012\u0011H\n¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002H'0(H\u0080\bø\u0001\u0000\u001af\u00104\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u00070\u0002\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\u0015*\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u00070\u0002052\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0(H\u0080\bø\u0001\u0000\u001ax\u00106\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H\n07\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u00070\u0002\"\u0004\b\u0000\u00108\"\u0004\b\u0001\u0010\t\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010\u0015* \u0012\u0004\u0012\u0002H8\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u00070\u0002072\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0(H\u0080\bø\u0001\u0000\u001ax\u00106\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H\n09\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u00070\u0002\"\u0004\b\u0000\u00108\"\u0004\b\u0001\u0010\t\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010\u0015* \u0012\u0004\u0012\u0002H8\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u00070\u0002092\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0(H\u0080\bø\u0001\u0000\u001aW\u0010:\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\u0002\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n*\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\u00022!\u0010;\u001a\u001d\u0012\u0013\u0012\u0011H\n¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020<0(H\u0080\bø\u0001\u0000\u001a4\u0010=\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\t\u0012\u0004\u0012\u0002H\n0\u0002\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n*\u0010\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0018\u00010\u0002H\u0000\" \u0010\u0000\u001a\u00020\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\" \u0010\u0004\u001a\u00020\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0003\u0082\u0002\u000b\n\u0005\b\u009920\u0001\n\u0002\b9¨\u0006>"}, d2 = {"isError", "", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "(Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;)Z", "isSuccess", "zipOrAccumulate", GameUtils.CONDITION_GOOD, "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "H", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "first", "second", "transform", "Lkotlin/Function2;", "C", "third", "Lkotlin/Function3;", "D", "fourth", "Lkotlin/Function4;", ExifInterface.LONGITUDE_EAST, "fifth", "Lkotlin/Function5;", "F", "sixth", "Lkotlin/Function6;", "I", "seventh", "Lkotlin/Function7;", "collectErrors", "", ExifInterface.GPS_DIRECTION_TRUE, "errorIfNull", "error", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "errorOrNull", "(Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;)Ljava/lang/Object;", "flatMap", "R", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "flatMapError", "getOrElse", "onFailure", "(Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrNull", "getOrThrow", "map", "mapError", "mapOrAccumulate", "", "mapValuesOrAccumulate", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;", "K", "", "onError", "block", "", "orSuccessfullyNull", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class ResultKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final <T, F> List<F> collectErrors(List<? extends Result<? extends T, ? extends NonEmptyList<? extends F>>> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Result result = (Result) it.next();
            Result.Error error = result instanceof Result.Error ? (Result.Error) result : null;
            NonEmptyList nonEmptyList = error != null ? (NonEmptyList) error.getValue() : null;
            if (nonEmptyList != null) {
                arrayList.add(nonEmptyList);
            }
        }
        return CollectionsKt.flatten(arrayList);
    }

    public static final /* synthetic */ Result errorIfNull(Object obj, Object obj2) {
        return obj != null ? new Result.Success(obj) : new Result.Error(obj2);
    }

    public static final /* synthetic */ Object errorOrNull(Result result) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        if (result instanceof Result.Success) {
            return null;
        }
        if (result instanceof Result.Error) {
            return ((Result.Error) result).getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <A, B, R> Result<R, B> flatMap(Result<? extends A, ? extends B> result, Function1<? super A, ? extends Result<? extends R, ? extends B>> transform) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (result instanceof Result.Success) {
            return transform.invoke((Object) ((Result.Success) result).getValue());
        }
        if (result instanceof Result.Error) {
            return result;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <A, B, R> Result<A, R> flatMapError(Result<? extends A, ? extends B> result, Function1<? super B, ? extends Result<? extends A, ? extends R>> transform) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (result instanceof Result.Success) {
            return result;
        }
        if (result instanceof Result.Error) {
            return transform.invoke((Object) ((Result.Error) result).getValue());
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ <A extends R, B, R> R getOrElse(Result<? extends A, ? extends B> result, Function1<? super B, ? extends R> onFailure) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        if (result instanceof Result.Success) {
            return (R) ((Result.Success) result).getValue();
        }
        if (result instanceof Result.Error) {
            return onFailure.invoke((Object) ((Result.Error) result).getValue());
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ Object getOrNull(Result result) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        if (result instanceof Result.Success) {
            return ((Result.Success) result).getValue();
        }
        if (result instanceof Result.Error) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ Object getOrThrow(Result result) throws Throwable {
        Intrinsics.checkNotNullParameter(result, "<this>");
        if (result instanceof Result.Success) {
            return ((Result.Success) result).getValue();
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        Result.Error error = (Result.Error) result;
        if (error.getValue() instanceof Throwable) {
            throw ((Throwable) error.getValue());
        }
        throw new IllegalStateException(("Result was unsuccessful: " + error.getValue()).toString());
    }

    public static final /* synthetic */ boolean isError(Result result) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        return result instanceof Result.Error;
    }

    public static final /* synthetic */ boolean isSuccess(Result result) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        return result instanceof Result.Success;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <A, B, R> Result<R, B> map(Result<? extends A, ? extends B> result, Function1<? super A, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (result instanceof Result.Success) {
            return new Result.Success(transform.invoke((Object) ((Result.Success) result).getValue()));
        }
        if (result instanceof Result.Error) {
            return result;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <A, B, R> Result<A, R> mapError(Result<? extends A, ? extends B> result, Function1<? super B, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (result instanceof Result.Success) {
            return result;
        }
        if (result instanceof Result.Error) {
            return new Result.Error(transform.invoke((Object) ((Result.Error) result).getValue()));
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ <A, B, E> Result<List<B>, NonEmptyList<E>> mapOrAccumulate(Iterable<? extends Result<? extends A, ? extends NonEmptyList<? extends E>>> iterable, Function1<? super A, ? extends B> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Result<? extends A, ? extends NonEmptyList<? extends E>> result : iterable) {
            if (result instanceof Result.Success) {
                if (arrayList2.isEmpty()) {
                    arrayList.add(transform.invoke((Object) ((Result.Success) result).getValue()));
                }
            } else if (result instanceof Result.Error) {
                arrayList2.addAll((Collection) ((Result.Error) result).getValue());
            }
        }
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(arrayList2);
        return nonEmptyListOrNull != null ? new Result.Error(nonEmptyListOrNull) : new Result.Success(arrayList);
    }

    public static final /* synthetic */ <K, A, B, E> Result<NonEmptyMap<K, B>, NonEmptyList<E>> mapValuesOrAccumulate(NonEmptyMap<K, ? extends Result<? extends A, ? extends NonEmptyList<? extends E>>> nonEmptyMap, Function1<? super A, ? extends B> transform) {
        Intrinsics.checkNotNullParameter(nonEmptyMap, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        Result.Success success = (Result) nonEmptyMap.getEntry().getValue();
        if (success instanceof Result.Success) {
            success = new Result.Success(transform.invoke((Object) ((Result.Success) success).getValue()));
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            success = new Result.Success(TuplesKt.to(nonEmptyMap.getEntry().getKey(), ((Result.Success) success).getValue()));
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!(success instanceof Result.Success) && (success instanceof Result.Error)) {
            arrayList.addAll((NonEmptyList) ((Result.Error) success).getValue());
        }
        for (Map.Entry<K, ? extends Result<? extends A, ? extends NonEmptyList<? extends E>>> entry : nonEmptyMap.entrySet()) {
            K key = entry.getKey();
            Result<? extends A, ? extends NonEmptyList<? extends E>> value = entry.getValue();
            if (value instanceof Result.Success) {
                if (arrayList.isEmpty() && !Intrinsics.areEqual(key, nonEmptyMap.getEntry().getKey())) {
                    linkedHashMap.put(key, transform.invoke((Object) ((Result.Success) value).getValue()));
                }
            } else if (value instanceof Result.Error) {
                arrayList.addAll((Collection) ((Result.Error) value).getValue());
            }
        }
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(arrayList);
        return nonEmptyListOrNull != null ? new Result.Error(nonEmptyListOrNull) : new Result.Success(NonEmptyMapKt.nonEmptyMapOf((Pair) getOrThrow(success), linkedHashMap));
    }

    public static final /* synthetic */ <K, A, B, E> Result<Map<K, B>, NonEmptyList<E>> mapValuesOrAccumulate(Map<K, ? extends Result<? extends A, ? extends NonEmptyList<? extends E>>> map, Function1<? super A, ? extends B> transform) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<K, ? extends Result<? extends A, ? extends NonEmptyList<? extends E>>> entry : map.entrySet()) {
            K key = entry.getKey();
            Result<? extends A, ? extends NonEmptyList<? extends E>> value = entry.getValue();
            if (value instanceof Result.Success) {
                if (arrayList.isEmpty()) {
                    linkedHashMap.put(key, transform.invoke((Object) ((Result.Success) value).getValue()));
                }
            } else if (value instanceof Result.Error) {
                arrayList.addAll((Collection) ((Result.Error) value).getValue());
            }
        }
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(arrayList);
        return nonEmptyListOrNull != null ? new Result.Error(nonEmptyListOrNull) : new Result.Success(linkedHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <A, B> Result<A, B> onError(Result<? extends A, ? extends B> result, Function1<? super B, Unit> block) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!(result instanceof Result.Success) && (result instanceof Result.Error)) {
            block.invoke((Object) ((Result.Error) result).getValue());
        }
        return result;
    }

    public static final /* synthetic */ Result orSuccessfullyNull(Result result) {
        return result == null ? new Result.Success(null) : result;
    }

    public static final /* synthetic */ <A, B, C, D, E, F, G, H, I> Result<H, NonEmptyList<I>> zipOrAccumulate(Result<? extends A, ? extends NonEmptyList<? extends I>> first, Result<? extends B, ? extends NonEmptyList<? extends I>> second, Result<? extends C, ? extends NonEmptyList<? extends I>> third, Result<? extends D, ? extends NonEmptyList<? extends I>> fourth, Result<? extends E, ? extends NonEmptyList<? extends I>> fifth, Result<? extends F, ? extends NonEmptyList<? extends I>> sixth, Result<? extends G, ? extends NonEmptyList<? extends I>> seventh, Function7<? super A, ? super B, ? super C, ? super D, ? super E, ? super F, ? super G, ? extends H> transform) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        Intrinsics.checkNotNullParameter(third, "third");
        Intrinsics.checkNotNullParameter(fourth, "fourth");
        Intrinsics.checkNotNullParameter(fifth, "fifth");
        Intrinsics.checkNotNullParameter(sixth, "sixth");
        Intrinsics.checkNotNullParameter(seventh, "seventh");
        Intrinsics.checkNotNullParameter(transform, "transform");
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(collectErrors(CollectionsKt.listOf((Object[]) new Result[]{first, second, third, fourth, fifth, sixth})));
        return nonEmptyListOrNull != null ? new Result.Error(nonEmptyListOrNull) : new Result.Success(transform.invoke((Object) ((Result.Success) first).getValue(), (Object) ((Result.Success) second).getValue(), (Object) ((Result.Success) third).getValue(), (Object) ((Result.Success) fourth).getValue(), (Object) ((Result.Success) fifth).getValue(), (Object) ((Result.Success) sixth).getValue(), (Object) ((Result.Success) seventh).getValue()));
    }

    public static final /* synthetic */ <A, B, C, D, E, F, G, H> Result<G, NonEmptyList<H>> zipOrAccumulate(Result<? extends A, ? extends NonEmptyList<? extends H>> first, Result<? extends B, ? extends NonEmptyList<? extends H>> second, Result<? extends C, ? extends NonEmptyList<? extends H>> third, Result<? extends D, ? extends NonEmptyList<? extends H>> fourth, Result<? extends E, ? extends NonEmptyList<? extends H>> fifth, Result<? extends F, ? extends NonEmptyList<? extends H>> sixth, Function6<? super A, ? super B, ? super C, ? super D, ? super E, ? super F, ? extends G> transform) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        Intrinsics.checkNotNullParameter(third, "third");
        Intrinsics.checkNotNullParameter(fourth, "fourth");
        Intrinsics.checkNotNullParameter(fifth, "fifth");
        Intrinsics.checkNotNullParameter(sixth, "sixth");
        Intrinsics.checkNotNullParameter(transform, "transform");
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(collectErrors(CollectionsKt.listOf((Object[]) new Result[]{first, second, third, fourth, fifth, sixth})));
        return nonEmptyListOrNull != null ? new Result.Error(nonEmptyListOrNull) : new Result.Success(transform.invoke((Object) ((Result.Success) first).getValue(), (Object) ((Result.Success) second).getValue(), (Object) ((Result.Success) third).getValue(), (Object) ((Result.Success) fourth).getValue(), (Object) ((Result.Success) fifth).getValue(), (Object) ((Result.Success) sixth).getValue()));
    }

    public static final /* synthetic */ <A, B, C, D, E, G, H> Result<G, NonEmptyList<H>> zipOrAccumulate(Result<? extends A, ? extends NonEmptyList<? extends H>> first, Result<? extends B, ? extends NonEmptyList<? extends H>> second, Result<? extends C, ? extends NonEmptyList<? extends H>> third, Result<? extends D, ? extends NonEmptyList<? extends H>> fourth, Result<? extends E, ? extends NonEmptyList<? extends H>> fifth, Function5<? super A, ? super B, ? super C, ? super D, ? super E, ? extends G> transform) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        Intrinsics.checkNotNullParameter(third, "third");
        Intrinsics.checkNotNullParameter(fourth, "fourth");
        Intrinsics.checkNotNullParameter(fifth, "fifth");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Result.Success success = new Result.Success(Unit.INSTANCE);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(collectErrors(CollectionsKt.listOf((Object[]) new Result[]{first, second, third, fourth, fifth, success})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        BuildConfig buildConfig = (Object) ((Result.Success) first).getValue();
        BuildConfig buildConfig2 = (Object) ((Result.Success) second).getValue();
        BuildConfig buildConfig3 = (Object) ((Result.Success) third).getValue();
        BuildConfig buildConfig4 = (Object) ((Result.Success) fourth).getValue();
        BuildConfig buildConfig5 = (Object) ((Result.Success) fifth).getValue();
        return new Result.Success(transform.invoke(buildConfig, buildConfig2, buildConfig3, buildConfig4, buildConfig5));
    }

    public static final /* synthetic */ <A, B, C, D, G, H> Result<G, NonEmptyList<H>> zipOrAccumulate(Result<? extends A, ? extends NonEmptyList<? extends H>> first, Result<? extends B, ? extends NonEmptyList<? extends H>> second, Result<? extends C, ? extends NonEmptyList<? extends H>> third, Result<? extends D, ? extends NonEmptyList<? extends H>> fourth, Function4<? super A, ? super B, ? super C, ? super D, ? extends G> transform) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        Intrinsics.checkNotNullParameter(third, "third");
        Intrinsics.checkNotNullParameter(fourth, "fourth");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Result.Success success = new Result.Success(Unit.INSTANCE);
        Result.Success success2 = new Result.Success(Unit.INSTANCE);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(collectErrors(CollectionsKt.listOf((Object[]) new Result[]{first, second, third, fourth, success, success2})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        BuildConfig buildConfig = (Object) ((Result.Success) first).getValue();
        BuildConfig buildConfig2 = (Object) ((Result.Success) second).getValue();
        BuildConfig buildConfig3 = (Object) ((Result.Success) third).getValue();
        BuildConfig buildConfig4 = (Object) ((Result.Success) fourth).getValue();
        Object value = success.getValue();
        return new Result.Success(transform.invoke(buildConfig, buildConfig2, buildConfig3, buildConfig4));
    }

    public static final /* synthetic */ <A, B, C, G, H> Result<G, NonEmptyList<H>> zipOrAccumulate(Result<? extends A, ? extends NonEmptyList<? extends H>> first, Result<? extends B, ? extends NonEmptyList<? extends H>> second, Result<? extends C, ? extends NonEmptyList<? extends H>> third, Function3<? super A, ? super B, ? super C, ? extends G> transform) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        Intrinsics.checkNotNullParameter(third, "third");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Result.Success success = new Result.Success(Unit.INSTANCE);
        Result.Success success2 = new Result.Success(Unit.INSTANCE);
        Result.Success success3 = new Result.Success(Unit.INSTANCE);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(collectErrors(CollectionsKt.listOf((Object[]) new Result[]{first, second, third, success, success2, success3})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        BuildConfig buildConfig = (Object) ((Result.Success) first).getValue();
        BuildConfig buildConfig2 = (Object) ((Result.Success) second).getValue();
        BuildConfig buildConfig3 = (Object) ((Result.Success) third).getValue();
        Object value = success.getValue();
        Object value2 = success2.getValue();
        return new Result.Success(transform.invoke(buildConfig, buildConfig2, buildConfig3));
    }

    public static final /* synthetic */ <A, B, G, H> Result<G, NonEmptyList<H>> zipOrAccumulate(Result<? extends A, ? extends NonEmptyList<? extends H>> first, Result<? extends B, ? extends NonEmptyList<? extends H>> second, Function2<? super A, ? super B, ? extends G> transform) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Result.Success success = new Result.Success(Unit.INSTANCE);
        Result.Success success2 = new Result.Success(Unit.INSTANCE);
        Result.Success success3 = new Result.Success(Unit.INSTANCE);
        Result.Success success4 = new Result.Success(Unit.INSTANCE);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(collectErrors(CollectionsKt.listOf((Object[]) new Result[]{first, second, success, success2, success3, success4})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        BuildConfig buildConfig = (Object) ((Result.Success) first).getValue();
        BuildConfig buildConfig2 = (Object) ((Result.Success) second).getValue();
        Object value = success.getValue();
        Object value2 = success2.getValue();
        Object value3 = success3.getValue();
        return new Result.Success(transform.invoke(buildConfig, buildConfig2));
    }
}
