package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: SkinManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b|\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 Â\u00012\u00020\u0001:\u0004Á\u0001Â\u0001BË\u0004\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0015\u0012\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000102\u0012\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b8\u00109B\u008d\u0004\b\u0010\u0012\u0006\u0010:\u001a\u00020\u0003\u0012\u0006\u0010;\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0015\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0006\u0012\b\u0010!\u001a\u0004\u0018\u00010\b\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010%\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015\u0012\b\u0010'\u001a\u0004\u0018\u00010(\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010*\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0015\u0012\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010/\u001a\u0004\u0018\u00010(\u0012\b\u00100\u001a\u0004\u0018\u00010(\u0012\b\u00101\u001a\u0004\u0018\u000102\u0012\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015\u0012\b\u00104\u001a\u0004\u0018\u00010\u0006\u0012\b\u00105\u001a\u0004\u0018\u00010\u0003\u0012\b\u00106\u001a\u0004\u0018\u00010\u0006\u0012\b\u00107\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010<\u001a\u0004\u0018\u00010=¢\u0006\u0004\b8\u0010>J\n\u0010\u0086\u0001\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010BJ\f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0089\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010GJ\u0011\u0010\u008a\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010GJ\u0011\u0010\u008b\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010GJ\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u008d\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010GJ\u0011\u0010\u008e\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010GJ\f\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0090\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010GJ\f\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0092\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010GJ\u0011\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010BJ\f\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0012\u0010\u0095\u0001\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015HÆ\u0003J\u0011\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010BJ\f\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0098\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010GJ\f\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u0012\u0010\u009a\u0001\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0015HÆ\u0003J\f\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u009c\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010GJ\f\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\f\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u009f\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010GJ\f\u0010 \u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0012\u0010¡\u0001\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015HÆ\u0003J\f\u0010¢\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010£\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010GJ\u0012\u0010¤\u0001\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015HÆ\u0003J\u0011\u0010¥\u0001\u001a\u0004\u0018\u00010(HÆ\u0003¢\u0006\u0002\u0010iJ\f\u0010¦\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010§\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010GJ\u0012\u0010¨\u0001\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0015HÆ\u0003J\u0012\u0010©\u0001\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015HÆ\u0003J\u0011\u0010ª\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010BJ\u0011\u0010«\u0001\u001a\u0004\u0018\u00010(HÆ\u0003¢\u0006\u0002\u0010iJ\u0011\u0010¬\u0001\u001a\u0004\u0018\u00010(HÆ\u0003¢\u0006\u0002\u0010iJ\f\u0010\u00ad\u0001\u001a\u0004\u0018\u000102HÆ\u0003J\u0012\u0010®\u0001\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015HÆ\u0003J\f\u0010¯\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010°\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010BJ\f\u0010±\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010²\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010BJÔ\u0004\u0010³\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00152\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00152\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00152\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00152\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00152\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010/\u001a\u0004\u0018\u00010(2\n\b\u0002\u00100\u001a\u0004\u0018\u00010(2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00152\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0003\u0010´\u0001J\u0015\u0010µ\u0001\u001a\u00020(2\t\u0010¶\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010·\u0001\u001a\u00020\u0003HÖ\u0001J\n\u0010¸\u0001\u001a\u00020\u0006HÖ\u0001J-\u0010¹\u0001\u001a\u00030º\u00012\u0007\u0010»\u0001\u001a\u00020\u00002\b\u0010¼\u0001\u001a\u00030½\u00012\b\u0010¾\u0001\u001a\u00030¿\u0001H\u0001¢\u0006\u0003\bÀ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010C\u001a\u0004\bA\u0010BR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010H\u001a\u0004\bF\u0010GR\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010H\u001a\u0004\bI\u0010GR\u0015\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010H\u001a\u0004\bJ\u0010GR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bK\u0010ER\u0015\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010H\u001a\u0004\bL\u0010GR\u0015\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010H\u001a\u0004\bM\u0010GR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010E\"\u0004\bO\u0010PR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010H\u001a\u0004\bQ\u0010GR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bR\u0010ER\u0015\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010H\u001a\u0004\bS\u0010GR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010C\u001a\u0004\bT\u0010BR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bU\u0010ER\u0019\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010C\u001a\u0004\bX\u0010BR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ER\u0015\u0010\u0018\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010H\u001a\u0004\bZ\u0010GR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R\u0019\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b]\u0010WR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b^\u0010ER\u0015\u0010\u001e\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010H\u001a\u0004\b_\u0010GR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b`\u0010\\R\u0013\u0010 \u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\ba\u0010ER\u0015\u0010!\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010H\u001a\u0004\bb\u0010GR\u0013\u0010\"\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bc\u0010ER\u0019\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\bd\u0010WR\u0013\u0010$\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\be\u0010ER\u0015\u0010%\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010H\u001a\u0004\bf\u0010GR\u0019\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\bg\u0010WR\u0015\u0010'\u001a\u0004\u0018\u00010(¢\u0006\n\n\u0002\u0010j\u001a\u0004\bh\u0010iR\u0013\u0010)\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bk\u0010ER\u0015\u0010*\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010H\u001a\u0004\bl\u0010GR\u0019\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\bm\u0010WR\u0019\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\bn\u0010WR\u001e\u0010.\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010C\u001a\u0004\bo\u0010B\"\u0004\bp\u0010qR\u001e\u0010/\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u0010\n\u0002\u0010j\u001a\u0004\br\u0010i\"\u0004\bs\u0010tR\u001e\u00100\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u0010\n\u0002\u0010j\u001a\u0004\bu\u0010i\"\u0004\bv\u0010tR\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\"\u00103\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010W\"\u0004\b|\u0010}R\u001c\u00104\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010E\"\u0004\b\u007f\u0010PR \u00105\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0012\n\u0002\u0010C\u001a\u0005\b\u0080\u0001\u0010B\"\u0005\b\u0081\u0001\u0010qR\u001e\u00106\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010E\"\u0005\b\u0083\u0001\u0010PR \u00107\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0012\n\u0002\u0010C\u001a\u0005\b\u0084\u0001\u0010B\"\u0005\b\u0085\u0001\u0010q¨\u0006Ã\u0001"}, d2 = {"Lcom/studiolaganne/lengendarylens/SkinDefinition;", "", "version", "", "extraMargin", "menuImage", "", "menuScale", "", "playmatAlpha", "playernameAlpha", "customFont", "playerNameFontMultiplier", "lifeFontMultiplier", "lifeFontColor", "symbolsAlpha", "glowColor", "glowAlpha", "glowRadius", "borderColor", "borderColors", "", "borderWidth", "koFont", "koFontMultiplier", "koMessages", "Lcom/studiolaganne/lengendarylens/Messages;", "lowLifeAnims", "Lcom/studiolaganne/lengendarylens/LowLifeAnimDefinition;", "winnerFont", "winnerFontMultiplier", "winnerMessages", "winnerAnimation", "winnerAnimationScale", "lowLifeFlashColor", "lowLifeFlashColors", "backgroundImage", "backgroundAlpha", "playmats", "overridePlaymats", "", "koAnimation", "koAnimationScale", "accessories", "Lcom/studiolaganne/lengendarylens/Accessory;", "decors", "cornerRadius", "fullscreenPlaymats", "disableDropShadows", "customPlayerToss", "Lcom/studiolaganne/lengendarylens/PlayerToss;", "unlockedPlaymats", "cmdDamageAnim", "cmdDamageAnimDuration", "poisonAnim", "poisonAnimDuration", "<init>", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Float;Lcom/studiolaganne/lengendarylens/Messages;Ljava/util/List;Ljava/lang/String;Ljava/lang/Float;Lcom/studiolaganne/lengendarylens/Messages;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Float;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Float;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/studiolaganne/lengendarylens/PlayerToss;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "seen0", "seen1", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Float;Lcom/studiolaganne/lengendarylens/Messages;Ljava/util/List;Ljava/lang/String;Ljava/lang/Float;Lcom/studiolaganne/lengendarylens/Messages;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Float;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Float;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/studiolaganne/lengendarylens/PlayerToss;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getVersion", "()I", "getExtraMargin", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMenuImage", "()Ljava/lang/String;", "getMenuScale", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getPlaymatAlpha", "getPlayernameAlpha", "getCustomFont", "getPlayerNameFontMultiplier", "getLifeFontMultiplier", "getLifeFontColor", "setLifeFontColor", "(Ljava/lang/String;)V", "getSymbolsAlpha", "getGlowColor", "getGlowAlpha", "getGlowRadius", "getBorderColor", "getBorderColors", "()Ljava/util/List;", "getBorderWidth", "getKoFont", "getKoFontMultiplier", "getKoMessages", "()Lcom/studiolaganne/lengendarylens/Messages;", "getLowLifeAnims", "getWinnerFont", "getWinnerFontMultiplier", "getWinnerMessages", "getWinnerAnimation", "getWinnerAnimationScale", "getLowLifeFlashColor", "getLowLifeFlashColors", "getBackgroundImage", "getBackgroundAlpha", "getPlaymats", "getOverridePlaymats", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getKoAnimation", "getKoAnimationScale", "getAccessories", "getDecors", "getCornerRadius", "setCornerRadius", "(Ljava/lang/Integer;)V", "getFullscreenPlaymats", "setFullscreenPlaymats", "(Ljava/lang/Boolean;)V", "getDisableDropShadows", "setDisableDropShadows", "getCustomPlayerToss", "()Lcom/studiolaganne/lengendarylens/PlayerToss;", "setCustomPlayerToss", "(Lcom/studiolaganne/lengendarylens/PlayerToss;)V", "getUnlockedPlaymats", "setUnlockedPlaymats", "(Ljava/util/List;)V", "getCmdDamageAnim", "setCmdDamageAnim", "getCmdDamageAnimDuration", "setCmdDamageAnimDuration", "getPoisonAnim", "setPoisonAnim", "getPoisonAnimDuration", "setPoisonAnimDuration", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "copy", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Float;Lcom/studiolaganne/lengendarylens/Messages;Ljava/util/List;Ljava/lang/String;Ljava/lang/Float;Lcom/studiolaganne/lengendarylens/Messages;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Float;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Float;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/studiolaganne/lengendarylens/PlayerToss;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/SkinDefinition;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final /* data */ class SkinDefinition {
    private final List<Accessory> accessories;
    private final Float backgroundAlpha;
    private final String backgroundImage;
    private final String borderColor;
    private final List<String> borderColors;
    private final Integer borderWidth;
    private String cmdDamageAnim;
    private Integer cmdDamageAnimDuration;
    private Integer cornerRadius;
    private final String customFont;
    private PlayerToss customPlayerToss;
    private final List<String> decors;
    private Boolean disableDropShadows;
    private final Integer extraMargin;
    private Boolean fullscreenPlaymats;
    private final Float glowAlpha;
    private final String glowColor;
    private final Integer glowRadius;
    private final String koAnimation;
    private final Float koAnimationScale;
    private final String koFont;
    private final Float koFontMultiplier;
    private final Messages koMessages;
    private String lifeFontColor;
    private final Float lifeFontMultiplier;
    private final List<LowLifeAnimDefinition> lowLifeAnims;
    private final String lowLifeFlashColor;
    private final List<String> lowLifeFlashColors;
    private final String menuImage;
    private final Float menuScale;
    private final Boolean overridePlaymats;
    private final Float playerNameFontMultiplier;
    private final Float playernameAlpha;
    private final Float playmatAlpha;
    private final List<String> playmats;
    private String poisonAnim;
    private Integer poisonAnimDuration;
    private final Float symbolsAlpha;
    private List<String> unlockedPlaymats;
    private final int version;
    private final String winnerAnimation;
    private final Float winnerAnimationScale;
    private final String winnerFont;
    private final Float winnerFontMultiplier;
    private final Messages winnerMessages;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.studiolaganne.lengendarylens.SkinDefinition$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SkinDefinition._childSerializers$_anonymous_();
        }
    }), null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.studiolaganne.lengendarylens.SkinDefinition$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SkinDefinition._childSerializers$_anonymous_$0();
        }
    }), null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.studiolaganne.lengendarylens.SkinDefinition$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SkinDefinition._childSerializers$_anonymous_$1();
        }
    }), null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.studiolaganne.lengendarylens.SkinDefinition$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SkinDefinition._childSerializers$_anonymous_$2();
        }
    }), null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.studiolaganne.lengendarylens.SkinDefinition$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SkinDefinition._childSerializers$_anonymous_$3();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.studiolaganne.lengendarylens.SkinDefinition$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SkinDefinition._childSerializers$_anonymous_$4();
        }
    }), null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.studiolaganne.lengendarylens.SkinDefinition$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SkinDefinition._childSerializers$_anonymous_$5();
        }
    }), null, null, null, null};

    /* JADX INFO: compiled from: SkinManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/studiolaganne/lengendarylens/SkinDefinition$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/studiolaganne/lengendarylens/SkinDefinition;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SkinDefinition> serializer() {
            return SkinDefinition$$serializer.INSTANCE;
        }
    }

    public SkinDefinition() {
        this(0, (Integer) null, (String) null, (Float) null, (Float) null, (Float) null, (String) null, (Float) null, (Float) null, (String) null, (Float) null, (String) null, (Float) null, (Integer) null, (String) null, (List) null, (Integer) null, (String) null, (Float) null, (Messages) null, (List) null, (String) null, (Float) null, (Messages) null, (String) null, (Float) null, (String) null, (List) null, (String) null, (Float) null, (List) null, (Boolean) null, (String) null, (Float) null, (List) null, (List) null, (Integer) null, (Boolean) null, (Boolean) null, (PlayerToss) null, (List) null, (String) null, (Integer) null, (String) null, (Integer) null, -1, 8191, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ SkinDefinition(int i, int i2, int i3, Integer num, String str, Float f, Float f2, Float f3, String str2, Float f4, Float f5, String str3, Float f6, String str4, Float f7, Integer num2, String str5, List list, Integer num3, String str6, Float f8, Messages messages, List list2, String str7, Float f9, Messages messages2, String str8, Float f10, String str9, List list3, String str10, Float f11, List list4, Boolean bool, String str11, Float f12, List list5, List list6, Integer num4, Boolean bool2, Boolean bool3, PlayerToss playerToss, List list7, String str12, Integer num5, String str13, Integer num6, SerializationConstructorMarker serializationConstructorMarker) {
        this.version = (i & 1) == 0 ? 1 : i3;
        if ((i & 2) == 0) {
            this.extraMargin = 12;
        } else {
            this.extraMargin = num;
        }
        if ((i & 4) == 0) {
            this.menuImage = "";
        } else {
            this.menuImage = str;
        }
        if ((i & 8) == 0) {
            this.menuScale = Float.valueOf(1.0f);
        } else {
            this.menuScale = f;
        }
        if ((i & 16) == 0) {
            this.playmatAlpha = Float.valueOf(0.25f);
        } else {
            this.playmatAlpha = f2;
        }
        if ((i & 32) == 0) {
            this.playernameAlpha = Float.valueOf(0.3f);
        } else {
            this.playernameAlpha = f3;
        }
        if ((i & 64) == 0) {
            this.customFont = "";
        } else {
            this.customFont = str2;
        }
        if ((i & 128) == 0) {
            this.playerNameFontMultiplier = Float.valueOf(0.5f);
        } else {
            this.playerNameFontMultiplier = f4;
        }
        if ((i & 256) == 0) {
            this.lifeFontMultiplier = Float.valueOf(0.85f);
        } else {
            this.lifeFontMultiplier = f5;
        }
        if ((i & 512) == 0) {
            this.lifeFontColor = null;
        } else {
            this.lifeFontColor = str3;
        }
        if ((i & 1024) == 0) {
            this.symbolsAlpha = Float.valueOf(0.125f);
        } else {
            this.symbolsAlpha = f6;
        }
        if ((i & 2048) == 0) {
            this.glowColor = "";
        } else {
            this.glowColor = str4;
        }
        this.glowAlpha = (i & 4096) == 0 ? Float.valueOf(0.9f) : f7;
        this.glowRadius = (i & 8192) == 0 ? 0 : num2;
        if ((i & 16384) == 0) {
            this.borderColor = "";
        } else {
            this.borderColor = str5;
        }
        if ((32768 & i) == 0) {
            this.borderColors = null;
        } else {
            this.borderColors = list;
        }
        this.borderWidth = (65536 & i) == 0 ? 0 : num3;
        if ((131072 & i) == 0) {
            this.koFont = "";
        } else {
            this.koFont = str6;
        }
        this.koFontMultiplier = (262144 & i) == 0 ? Float.valueOf(1.0f) : f8;
        if ((524288 & i) == 0) {
            this.koMessages = null;
        } else {
            this.koMessages = messages;
        }
        this.lowLifeAnims = (1048576 & i) == 0 ? CollectionsKt.emptyList() : list2;
        if ((2097152 & i) == 0) {
            this.winnerFont = "";
        } else {
            this.winnerFont = str7;
        }
        this.winnerFontMultiplier = (4194304 & i) == 0 ? Float.valueOf(1.0f) : f9;
        if ((8388608 & i) == 0) {
            this.winnerMessages = null;
        } else {
            this.winnerMessages = messages2;
        }
        if ((16777216 & i) == 0) {
            this.winnerAnimation = null;
        } else {
            this.winnerAnimation = str8;
        }
        this.winnerAnimationScale = (33554432 & i) == 0 ? Float.valueOf(1.0f) : f10;
        if ((67108864 & i) == 0) {
            this.lowLifeFlashColor = "";
        } else {
            this.lowLifeFlashColor = str9;
        }
        if ((134217728 & i) == 0) {
            this.lowLifeFlashColors = null;
        } else {
            this.lowLifeFlashColors = list3;
        }
        if ((268435456 & i) == 0) {
            this.backgroundImage = null;
        } else {
            this.backgroundImage = str10;
        }
        this.backgroundAlpha = (536870912 & i) == 0 ? Float.valueOf(1.0f) : f11;
        if ((1073741824 & i) == 0) {
            this.playmats = null;
        } else {
            this.playmats = list4;
        }
        this.overridePlaymats = (i & Integer.MIN_VALUE) == 0 ? false : bool;
        if ((i2 & 1) == 0) {
            this.koAnimation = null;
        } else {
            this.koAnimation = str11;
        }
        this.koAnimationScale = (i2 & 2) == 0 ? Float.valueOf(1.0f) : f12;
        this.accessories = (i2 & 4) == 0 ? CollectionsKt.emptyList() : list5;
        this.decors = (i2 & 8) == 0 ? CollectionsKt.emptyList() : list6;
        if ((i2 & 16) == 0) {
            this.cornerRadius = null;
        } else {
            this.cornerRadius = num4;
        }
        this.fullscreenPlaymats = (i2 & 32) == 0 ? false : bool2;
        this.disableDropShadows = (i2 & 64) == 0 ? false : bool3;
        if ((i2 & 128) == 0) {
            this.customPlayerToss = null;
        } else {
            this.customPlayerToss = playerToss;
        }
        if ((i2 & 256) == 0) {
            this.unlockedPlaymats = null;
        } else {
            this.unlockedPlaymats = list7;
        }
        if ((i2 & 512) == 0) {
            this.cmdDamageAnim = null;
        } else {
            this.cmdDamageAnim = str12;
        }
        if ((i2 & 1024) == 0) {
            this.cmdDamageAnimDuration = null;
        } else {
            this.cmdDamageAnimDuration = num5;
        }
        if ((i2 & 2048) == 0) {
            this.poisonAnim = null;
        } else {
            this.poisonAnim = str13;
        }
        if ((i2 & 4096) == 0) {
            this.poisonAnimDuration = null;
        } else {
            this.poisonAnimDuration = num6;
        }
    }

    public SkinDefinition(int i, Integer num, String str, Float f, Float f2, Float f3, String str2, Float f4, Float f5, String str3, Float f6, String str4, Float f7, Integer num2, String str5, List<String> list, Integer num3, String str6, Float f8, Messages messages, List<LowLifeAnimDefinition> list2, String str7, Float f9, Messages messages2, String str8, Float f10, String str9, List<String> list3, String str10, Float f11, List<String> list4, Boolean bool, String str11, Float f12, List<Accessory> list5, List<String> list6, Integer num4, Boolean bool2, Boolean bool3, PlayerToss playerToss, List<String> list7, String str12, Integer num5, String str13, Integer num6) {
        this.version = i;
        this.extraMargin = num;
        this.menuImage = str;
        this.menuScale = f;
        this.playmatAlpha = f2;
        this.playernameAlpha = f3;
        this.customFont = str2;
        this.playerNameFontMultiplier = f4;
        this.lifeFontMultiplier = f5;
        this.lifeFontColor = str3;
        this.symbolsAlpha = f6;
        this.glowColor = str4;
        this.glowAlpha = f7;
        this.glowRadius = num2;
        this.borderColor = str5;
        this.borderColors = list;
        this.borderWidth = num3;
        this.koFont = str6;
        this.koFontMultiplier = f8;
        this.koMessages = messages;
        this.lowLifeAnims = list2;
        this.winnerFont = str7;
        this.winnerFontMultiplier = f9;
        this.winnerMessages = messages2;
        this.winnerAnimation = str8;
        this.winnerAnimationScale = f10;
        this.lowLifeFlashColor = str9;
        this.lowLifeFlashColors = list3;
        this.backgroundImage = str10;
        this.backgroundAlpha = f11;
        this.playmats = list4;
        this.overridePlaymats = bool;
        this.koAnimation = str11;
        this.koAnimationScale = f12;
        this.accessories = list5;
        this.decors = list6;
        this.cornerRadius = num4;
        this.fullscreenPlaymats = bool2;
        this.disableDropShadows = bool3;
        this.customPlayerToss = playerToss;
        this.unlockedPlaymats = list7;
        this.cmdDamageAnim = str12;
        this.cmdDamageAnimDuration = num5;
        this.poisonAnim = str13;
        this.poisonAnimDuration = num6;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SkinDefinition(int i, Integer num, String str, Float f, Float f2, Float f3, String str2, Float f4, Float f5, String str3, Float f6, String str4, Float f7, Integer num2, String str5, List list, Integer num3, String str6, Float f8, Messages messages, List list2, String str7, Float f9, Messages messages2, String str8, Float f10, String str9, List list3, String str10, Float f11, List list4, Boolean bool, String str11, Float f12, List list5, List list6, Integer num4, Boolean bool2, Boolean bool3, PlayerToss playerToss, List list7, String str12, Integer num5, String str13, Integer num6, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        int i4 = (i2 & 1) != 0 ? 1 : i;
        Integer num7 = (i2 & 2) != 0 ? 12 : num;
        String str14 = (i2 & 4) != 0 ? "" : str;
        Float fValueOf = (i2 & 8) != 0 ? Float.valueOf(1.0f) : f;
        Float fValueOf2 = (i2 & 16) != 0 ? Float.valueOf(0.25f) : f2;
        Float fValueOf3 = (i2 & 32) != 0 ? Float.valueOf(0.3f) : f3;
        String str15 = (i2 & 64) != 0 ? "" : str2;
        Float fValueOf4 = (i2 & 128) != 0 ? Float.valueOf(0.5f) : f4;
        Float fValueOf5 = (i2 & 256) != 0 ? Float.valueOf(0.85f) : f5;
        String str16 = (i2 & 512) != 0 ? null : str3;
        Float fValueOf6 = (i2 & 1024) != 0 ? Float.valueOf(0.125f) : f6;
        String str17 = (i2 & 2048) != 0 ? "" : str4;
        this(i4, num7, str14, fValueOf, fValueOf2, fValueOf3, str15, fValueOf4, fValueOf5, str16, fValueOf6, str17, (i2 & 4096) != 0 ? Float.valueOf(0.9f) : f7, (i2 & 8192) != 0 ? 0 : num2, (i2 & 16384) != 0 ? "" : str5, (i2 & 32768) != 0 ? null : list, (i2 & 65536) != 0 ? 0 : num3, (i2 & 131072) != 0 ? "" : str6, (i2 & 262144) != 0 ? Float.valueOf(1.0f) : f8, (i2 & 524288) != 0 ? null : messages, (i2 & 1048576) != 0 ? CollectionsKt.emptyList() : list2, (i2 & 2097152) != 0 ? "" : str7, (i2 & 4194304) != 0 ? Float.valueOf(1.0f) : f9, (i2 & 8388608) != 0 ? null : messages2, (i2 & 16777216) != 0 ? null : str8, (i2 & 33554432) != 0 ? Float.valueOf(1.0f) : f10, (i2 & 67108864) == 0 ? str9 : "", (i2 & 134217728) != 0 ? null : list3, (i2 & 268435456) != 0 ? null : str10, (i2 & 536870912) != 0 ? Float.valueOf(1.0f) : f11, (i2 & 1073741824) != 0 ? null : list4, (i2 & Integer.MIN_VALUE) != 0 ? false : bool, (i3 & 1) != 0 ? null : str11, (i3 & 2) != 0 ? Float.valueOf(1.0f) : f12, (i3 & 4) != 0 ? CollectionsKt.emptyList() : list5, (i3 & 8) != 0 ? CollectionsKt.emptyList() : list6, (i3 & 16) != 0 ? null : num4, (i3 & 32) != 0 ? false : bool2, (i3 & 64) != 0 ? false : bool3, (i3 & 128) != 0 ? null : playerToss, (i3 & 256) != 0 ? null : list7, (i3 & 512) != 0 ? null : str12, (i3 & 1024) != 0 ? null : num5, (i3 & 2048) != 0 ? null : str13, (i3 & 4096) != 0 ? null : num6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(LowLifeAnimDefinition$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$3() {
        return new ArrayListSerializer(Accessory$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$4() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$5() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SkinDefinition copy$default(SkinDefinition skinDefinition, int i, Integer num, String str, Float f, Float f2, Float f3, String str2, Float f4, Float f5, String str3, Float f6, String str4, Float f7, Integer num2, String str5, List list, Integer num3, String str6, Float f8, Messages messages, List list2, String str7, Float f9, Messages messages2, String str8, Float f10, String str9, List list3, String str10, Float f11, List list4, Boolean bool, String str11, Float f12, List list5, List list6, Integer num4, Boolean bool2, Boolean bool3, PlayerToss playerToss, List list7, String str12, Integer num5, String str13, Integer num6, int i2, int i3, Object obj) {
        int i4 = (i2 & 1) != 0 ? skinDefinition.version : i;
        return skinDefinition.copy(i4, (i2 & 2) != 0 ? skinDefinition.extraMargin : num, (i2 & 4) != 0 ? skinDefinition.menuImage : str, (i2 & 8) != 0 ? skinDefinition.menuScale : f, (i2 & 16) != 0 ? skinDefinition.playmatAlpha : f2, (i2 & 32) != 0 ? skinDefinition.playernameAlpha : f3, (i2 & 64) != 0 ? skinDefinition.customFont : str2, (i2 & 128) != 0 ? skinDefinition.playerNameFontMultiplier : f4, (i2 & 256) != 0 ? skinDefinition.lifeFontMultiplier : f5, (i2 & 512) != 0 ? skinDefinition.lifeFontColor : str3, (i2 & 1024) != 0 ? skinDefinition.symbolsAlpha : f6, (i2 & 2048) != 0 ? skinDefinition.glowColor : str4, (i2 & 4096) != 0 ? skinDefinition.glowAlpha : f7, (i2 & 8192) != 0 ? skinDefinition.glowRadius : num2, (i2 & 16384) != 0 ? skinDefinition.borderColor : str5, (i2 & 32768) != 0 ? skinDefinition.borderColors : list, (i2 & 65536) != 0 ? skinDefinition.borderWidth : num3, (i2 & 131072) != 0 ? skinDefinition.koFont : str6, (i2 & 262144) != 0 ? skinDefinition.koFontMultiplier : f8, (i2 & 524288) != 0 ? skinDefinition.koMessages : messages, (i2 & 1048576) != 0 ? skinDefinition.lowLifeAnims : list2, (i2 & 2097152) != 0 ? skinDefinition.winnerFont : str7, (i2 & 4194304) != 0 ? skinDefinition.winnerFontMultiplier : f9, (i2 & 8388608) != 0 ? skinDefinition.winnerMessages : messages2, (i2 & 16777216) != 0 ? skinDefinition.winnerAnimation : str8, (i2 & 33554432) != 0 ? skinDefinition.winnerAnimationScale : f10, (i2 & 67108864) != 0 ? skinDefinition.lowLifeFlashColor : str9, (i2 & 134217728) != 0 ? skinDefinition.lowLifeFlashColors : list3, (i2 & 268435456) != 0 ? skinDefinition.backgroundImage : str10, (i2 & 536870912) != 0 ? skinDefinition.backgroundAlpha : f11, (i2 & 1073741824) != 0 ? skinDefinition.playmats : list4, (i2 & Integer.MIN_VALUE) != 0 ? skinDefinition.overridePlaymats : bool, (i3 & 1) != 0 ? skinDefinition.koAnimation : str11, (i3 & 2) != 0 ? skinDefinition.koAnimationScale : f12, (i3 & 4) != 0 ? skinDefinition.accessories : list5, (i3 & 8) != 0 ? skinDefinition.decors : list6, (i3 & 16) != 0 ? skinDefinition.cornerRadius : num4, (i3 & 32) != 0 ? skinDefinition.fullscreenPlaymats : bool2, (i3 & 64) != 0 ? skinDefinition.disableDropShadows : bool3, (i3 & 128) != 0 ? skinDefinition.customPlayerToss : playerToss, (i3 & 256) != 0 ? skinDefinition.unlockedPlaymats : list7, (i3 & 512) != 0 ? skinDefinition.cmdDamageAnim : str12, (i3 & 1024) != 0 ? skinDefinition.cmdDamageAnimDuration : num5, (i3 & 2048) != 0 ? skinDefinition.poisonAnim : str13, (i3 & 4096) != 0 ? skinDefinition.poisonAnimDuration : num6);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_release(SkinDefinition self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Integer num;
        Integer num2;
        Integer num3;
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.version != 1) {
            output.encodeIntElement(serialDesc, 0, self.version);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || (num3 = self.extraMargin) == null || num3.intValue() != 12) {
            output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.extraMargin);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.menuImage, "")) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.menuImage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual((Object) self.menuScale, (Object) Float.valueOf(1.0f))) {
            output.encodeNullableSerializableElement(serialDesc, 3, FloatSerializer.INSTANCE, self.menuScale);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual((Object) self.playmatAlpha, (Object) Float.valueOf(0.25f))) {
            output.encodeNullableSerializableElement(serialDesc, 4, FloatSerializer.INSTANCE, self.playmatAlpha);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual((Object) self.playernameAlpha, (Object) Float.valueOf(0.3f))) {
            output.encodeNullableSerializableElement(serialDesc, 5, FloatSerializer.INSTANCE, self.playernameAlpha);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.customFont, "")) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.customFont);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual((Object) self.playerNameFontMultiplier, (Object) Float.valueOf(0.5f))) {
            output.encodeNullableSerializableElement(serialDesc, 7, FloatSerializer.INSTANCE, self.playerNameFontMultiplier);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || !Intrinsics.areEqual((Object) self.lifeFontMultiplier, (Object) Float.valueOf(0.85f))) {
            output.encodeNullableSerializableElement(serialDesc, 8, FloatSerializer.INSTANCE, self.lifeFontMultiplier);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.lifeFontColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.lifeFontColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || !Intrinsics.areEqual((Object) self.symbolsAlpha, (Object) Float.valueOf(0.125f))) {
            output.encodeNullableSerializableElement(serialDesc, 10, FloatSerializer.INSTANCE, self.symbolsAlpha);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || !Intrinsics.areEqual(self.glowColor, "")) {
            output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.glowColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || !Intrinsics.areEqual((Object) self.glowAlpha, (Object) Float.valueOf(0.9f))) {
            output.encodeNullableSerializableElement(serialDesc, 12, FloatSerializer.INSTANCE, self.glowAlpha);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || (num2 = self.glowRadius) == null || num2.intValue() != 0) {
            output.encodeNullableSerializableElement(serialDesc, 13, IntSerializer.INSTANCE, self.glowRadius);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || !Intrinsics.areEqual(self.borderColor, "")) {
            output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.borderColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.borderColors != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, lazyArr[15].getValue(), self.borderColors);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || (num = self.borderWidth) == null || num.intValue() != 0) {
            output.encodeNullableSerializableElement(serialDesc, 16, IntSerializer.INSTANCE, self.borderWidth);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || !Intrinsics.areEqual(self.koFont, "")) {
            output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.koFont);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) || !Intrinsics.areEqual((Object) self.koFontMultiplier, (Object) Float.valueOf(1.0f))) {
            output.encodeNullableSerializableElement(serialDesc, 18, FloatSerializer.INSTANCE, self.koFontMultiplier);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 19) || self.koMessages != null) {
            output.encodeNullableSerializableElement(serialDesc, 19, Messages$$serializer.INSTANCE, self.koMessages);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 20) || !Intrinsics.areEqual(self.lowLifeAnims, CollectionsKt.emptyList())) {
            output.encodeNullableSerializableElement(serialDesc, 20, lazyArr[20].getValue(), self.lowLifeAnims);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 21) || !Intrinsics.areEqual(self.winnerFont, "")) {
            output.encodeNullableSerializableElement(serialDesc, 21, StringSerializer.INSTANCE, self.winnerFont);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 22) || !Intrinsics.areEqual((Object) self.winnerFontMultiplier, (Object) Float.valueOf(1.0f))) {
            output.encodeNullableSerializableElement(serialDesc, 22, FloatSerializer.INSTANCE, self.winnerFontMultiplier);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 23) || self.winnerMessages != null) {
            output.encodeNullableSerializableElement(serialDesc, 23, Messages$$serializer.INSTANCE, self.winnerMessages);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 24) || self.winnerAnimation != null) {
            output.encodeNullableSerializableElement(serialDesc, 24, StringSerializer.INSTANCE, self.winnerAnimation);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 25) || !Intrinsics.areEqual((Object) self.winnerAnimationScale, (Object) Float.valueOf(1.0f))) {
            output.encodeNullableSerializableElement(serialDesc, 25, FloatSerializer.INSTANCE, self.winnerAnimationScale);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 26) || !Intrinsics.areEqual(self.lowLifeFlashColor, "")) {
            output.encodeNullableSerializableElement(serialDesc, 26, StringSerializer.INSTANCE, self.lowLifeFlashColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 27) || self.lowLifeFlashColors != null) {
            output.encodeNullableSerializableElement(serialDesc, 27, lazyArr[27].getValue(), self.lowLifeFlashColors);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 28) || self.backgroundImage != null) {
            output.encodeNullableSerializableElement(serialDesc, 28, StringSerializer.INSTANCE, self.backgroundImage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 29) || !Intrinsics.areEqual((Object) self.backgroundAlpha, (Object) Float.valueOf(1.0f))) {
            output.encodeNullableSerializableElement(serialDesc, 29, FloatSerializer.INSTANCE, self.backgroundAlpha);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 30) || self.playmats != null) {
            output.encodeNullableSerializableElement(serialDesc, 30, lazyArr[30].getValue(), self.playmats);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 31) || !Intrinsics.areEqual((Object) self.overridePlaymats, (Object) false)) {
            output.encodeNullableSerializableElement(serialDesc, 31, BooleanSerializer.INSTANCE, self.overridePlaymats);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 32) || self.koAnimation != null) {
            output.encodeNullableSerializableElement(serialDesc, 32, StringSerializer.INSTANCE, self.koAnimation);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 33) || !Intrinsics.areEqual((Object) self.koAnimationScale, (Object) Float.valueOf(1.0f))) {
            output.encodeNullableSerializableElement(serialDesc, 33, FloatSerializer.INSTANCE, self.koAnimationScale);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 34) || !Intrinsics.areEqual(self.accessories, CollectionsKt.emptyList())) {
            output.encodeNullableSerializableElement(serialDesc, 34, lazyArr[34].getValue(), self.accessories);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 35) || !Intrinsics.areEqual(self.decors, CollectionsKt.emptyList())) {
            output.encodeNullableSerializableElement(serialDesc, 35, lazyArr[35].getValue(), self.decors);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 36) || self.cornerRadius != null) {
            output.encodeNullableSerializableElement(serialDesc, 36, IntSerializer.INSTANCE, self.cornerRadius);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 37) || !Intrinsics.areEqual((Object) self.fullscreenPlaymats, (Object) false)) {
            output.encodeNullableSerializableElement(serialDesc, 37, BooleanSerializer.INSTANCE, self.fullscreenPlaymats);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 38) || !Intrinsics.areEqual((Object) self.disableDropShadows, (Object) false)) {
            output.encodeNullableSerializableElement(serialDesc, 38, BooleanSerializer.INSTANCE, self.disableDropShadows);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 39) || self.customPlayerToss != null) {
            output.encodeNullableSerializableElement(serialDesc, 39, PlayerToss$$serializer.INSTANCE, self.customPlayerToss);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 40) || self.unlockedPlaymats != null) {
            output.encodeNullableSerializableElement(serialDesc, 40, lazyArr[40].getValue(), self.unlockedPlaymats);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 41) || self.cmdDamageAnim != null) {
            output.encodeNullableSerializableElement(serialDesc, 41, StringSerializer.INSTANCE, self.cmdDamageAnim);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 42) || self.cmdDamageAnimDuration != null) {
            output.encodeNullableSerializableElement(serialDesc, 42, IntSerializer.INSTANCE, self.cmdDamageAnimDuration);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 43) || self.poisonAnim != null) {
            output.encodeNullableSerializableElement(serialDesc, 43, StringSerializer.INSTANCE, self.poisonAnim);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 44) && self.poisonAnimDuration == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 44, IntSerializer.INSTANCE, self.poisonAnimDuration);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getLifeFontColor() {
        return this.lifeFontColor;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Float getSymbolsAlpha() {
        return this.symbolsAlpha;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getGlowColor() {
        return this.glowColor;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Float getGlowAlpha() {
        return this.glowAlpha;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Integer getGlowRadius() {
        return this.glowRadius;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getBorderColor() {
        return this.borderColor;
    }

    public final List<String> component16() {
        return this.borderColors;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Integer getBorderWidth() {
        return this.borderWidth;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getKoFont() {
        return this.koFont;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final Float getKoFontMultiplier() {
        return this.koFontMultiplier;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getExtraMargin() {
        return this.extraMargin;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final Messages getKoMessages() {
        return this.koMessages;
    }

    public final List<LowLifeAnimDefinition> component21() {
        return this.lowLifeAnims;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getWinnerFont() {
        return this.winnerFont;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final Float getWinnerFontMultiplier() {
        return this.winnerFontMultiplier;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final Messages getWinnerMessages() {
        return this.winnerMessages;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final String getWinnerAnimation() {
        return this.winnerAnimation;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final Float getWinnerAnimationScale() {
        return this.winnerAnimationScale;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final String getLowLifeFlashColor() {
        return this.lowLifeFlashColor;
    }

    public final List<String> component28() {
        return this.lowLifeFlashColors;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final String getBackgroundImage() {
        return this.backgroundImage;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMenuImage() {
        return this.menuImage;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final Float getBackgroundAlpha() {
        return this.backgroundAlpha;
    }

    public final List<String> component31() {
        return this.playmats;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final Boolean getOverridePlaymats() {
        return this.overridePlaymats;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final String getKoAnimation() {
        return this.koAnimation;
    }

    /* JADX INFO: renamed from: component34, reason: from getter */
    public final Float getKoAnimationScale() {
        return this.koAnimationScale;
    }

    public final List<Accessory> component35() {
        return this.accessories;
    }

    public final List<String> component36() {
        return this.decors;
    }

    /* JADX INFO: renamed from: component37, reason: from getter */
    public final Integer getCornerRadius() {
        return this.cornerRadius;
    }

    /* JADX INFO: renamed from: component38, reason: from getter */
    public final Boolean getFullscreenPlaymats() {
        return this.fullscreenPlaymats;
    }

    /* JADX INFO: renamed from: component39, reason: from getter */
    public final Boolean getDisableDropShadows() {
        return this.disableDropShadows;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Float getMenuScale() {
        return this.menuScale;
    }

    /* JADX INFO: renamed from: component40, reason: from getter */
    public final PlayerToss getCustomPlayerToss() {
        return this.customPlayerToss;
    }

    public final List<String> component41() {
        return this.unlockedPlaymats;
    }

    /* JADX INFO: renamed from: component42, reason: from getter */
    public final String getCmdDamageAnim() {
        return this.cmdDamageAnim;
    }

    /* JADX INFO: renamed from: component43, reason: from getter */
    public final Integer getCmdDamageAnimDuration() {
        return this.cmdDamageAnimDuration;
    }

    /* JADX INFO: renamed from: component44, reason: from getter */
    public final String getPoisonAnim() {
        return this.poisonAnim;
    }

    /* JADX INFO: renamed from: component45, reason: from getter */
    public final Integer getPoisonAnimDuration() {
        return this.poisonAnimDuration;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Float getPlaymatAlpha() {
        return this.playmatAlpha;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Float getPlayernameAlpha() {
        return this.playernameAlpha;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getCustomFont() {
        return this.customFont;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Float getPlayerNameFontMultiplier() {
        return this.playerNameFontMultiplier;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Float getLifeFontMultiplier() {
        return this.lifeFontMultiplier;
    }

    public final SkinDefinition copy(int version, Integer extraMargin, String menuImage, Float menuScale, Float playmatAlpha, Float playernameAlpha, String customFont, Float playerNameFontMultiplier, Float lifeFontMultiplier, String lifeFontColor, Float symbolsAlpha, String glowColor, Float glowAlpha, Integer glowRadius, String borderColor, List<String> borderColors, Integer borderWidth, String koFont, Float koFontMultiplier, Messages koMessages, List<LowLifeAnimDefinition> lowLifeAnims, String winnerFont, Float winnerFontMultiplier, Messages winnerMessages, String winnerAnimation, Float winnerAnimationScale, String lowLifeFlashColor, List<String> lowLifeFlashColors, String backgroundImage, Float backgroundAlpha, List<String> playmats, Boolean overridePlaymats, String koAnimation, Float koAnimationScale, List<Accessory> accessories, List<String> decors, Integer cornerRadius, Boolean fullscreenPlaymats, Boolean disableDropShadows, PlayerToss customPlayerToss, List<String> unlockedPlaymats, String cmdDamageAnim, Integer cmdDamageAnimDuration, String poisonAnim, Integer poisonAnimDuration) {
        return new SkinDefinition(version, extraMargin, menuImage, menuScale, playmatAlpha, playernameAlpha, customFont, playerNameFontMultiplier, lifeFontMultiplier, lifeFontColor, symbolsAlpha, glowColor, glowAlpha, glowRadius, borderColor, borderColors, borderWidth, koFont, koFontMultiplier, koMessages, lowLifeAnims, winnerFont, winnerFontMultiplier, winnerMessages, winnerAnimation, winnerAnimationScale, lowLifeFlashColor, lowLifeFlashColors, backgroundImage, backgroundAlpha, playmats, overridePlaymats, koAnimation, koAnimationScale, accessories, decors, cornerRadius, fullscreenPlaymats, disableDropShadows, customPlayerToss, unlockedPlaymats, cmdDamageAnim, cmdDamageAnimDuration, poisonAnim, poisonAnimDuration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkinDefinition)) {
            return false;
        }
        SkinDefinition skinDefinition = (SkinDefinition) other;
        return this.version == skinDefinition.version && Intrinsics.areEqual(this.extraMargin, skinDefinition.extraMargin) && Intrinsics.areEqual(this.menuImage, skinDefinition.menuImage) && Intrinsics.areEqual((Object) this.menuScale, (Object) skinDefinition.menuScale) && Intrinsics.areEqual((Object) this.playmatAlpha, (Object) skinDefinition.playmatAlpha) && Intrinsics.areEqual((Object) this.playernameAlpha, (Object) skinDefinition.playernameAlpha) && Intrinsics.areEqual(this.customFont, skinDefinition.customFont) && Intrinsics.areEqual((Object) this.playerNameFontMultiplier, (Object) skinDefinition.playerNameFontMultiplier) && Intrinsics.areEqual((Object) this.lifeFontMultiplier, (Object) skinDefinition.lifeFontMultiplier) && Intrinsics.areEqual(this.lifeFontColor, skinDefinition.lifeFontColor) && Intrinsics.areEqual((Object) this.symbolsAlpha, (Object) skinDefinition.symbolsAlpha) && Intrinsics.areEqual(this.glowColor, skinDefinition.glowColor) && Intrinsics.areEqual((Object) this.glowAlpha, (Object) skinDefinition.glowAlpha) && Intrinsics.areEqual(this.glowRadius, skinDefinition.glowRadius) && Intrinsics.areEqual(this.borderColor, skinDefinition.borderColor) && Intrinsics.areEqual(this.borderColors, skinDefinition.borderColors) && Intrinsics.areEqual(this.borderWidth, skinDefinition.borderWidth) && Intrinsics.areEqual(this.koFont, skinDefinition.koFont) && Intrinsics.areEqual((Object) this.koFontMultiplier, (Object) skinDefinition.koFontMultiplier) && Intrinsics.areEqual(this.koMessages, skinDefinition.koMessages) && Intrinsics.areEqual(this.lowLifeAnims, skinDefinition.lowLifeAnims) && Intrinsics.areEqual(this.winnerFont, skinDefinition.winnerFont) && Intrinsics.areEqual((Object) this.winnerFontMultiplier, (Object) skinDefinition.winnerFontMultiplier) && Intrinsics.areEqual(this.winnerMessages, skinDefinition.winnerMessages) && Intrinsics.areEqual(this.winnerAnimation, skinDefinition.winnerAnimation) && Intrinsics.areEqual((Object) this.winnerAnimationScale, (Object) skinDefinition.winnerAnimationScale) && Intrinsics.areEqual(this.lowLifeFlashColor, skinDefinition.lowLifeFlashColor) && Intrinsics.areEqual(this.lowLifeFlashColors, skinDefinition.lowLifeFlashColors) && Intrinsics.areEqual(this.backgroundImage, skinDefinition.backgroundImage) && Intrinsics.areEqual((Object) this.backgroundAlpha, (Object) skinDefinition.backgroundAlpha) && Intrinsics.areEqual(this.playmats, skinDefinition.playmats) && Intrinsics.areEqual(this.overridePlaymats, skinDefinition.overridePlaymats) && Intrinsics.areEqual(this.koAnimation, skinDefinition.koAnimation) && Intrinsics.areEqual((Object) this.koAnimationScale, (Object) skinDefinition.koAnimationScale) && Intrinsics.areEqual(this.accessories, skinDefinition.accessories) && Intrinsics.areEqual(this.decors, skinDefinition.decors) && Intrinsics.areEqual(this.cornerRadius, skinDefinition.cornerRadius) && Intrinsics.areEqual(this.fullscreenPlaymats, skinDefinition.fullscreenPlaymats) && Intrinsics.areEqual(this.disableDropShadows, skinDefinition.disableDropShadows) && Intrinsics.areEqual(this.customPlayerToss, skinDefinition.customPlayerToss) && Intrinsics.areEqual(this.unlockedPlaymats, skinDefinition.unlockedPlaymats) && Intrinsics.areEqual(this.cmdDamageAnim, skinDefinition.cmdDamageAnim) && Intrinsics.areEqual(this.cmdDamageAnimDuration, skinDefinition.cmdDamageAnimDuration) && Intrinsics.areEqual(this.poisonAnim, skinDefinition.poisonAnim) && Intrinsics.areEqual(this.poisonAnimDuration, skinDefinition.poisonAnimDuration);
    }

    public final List<Accessory> getAccessories() {
        return this.accessories;
    }

    public final Float getBackgroundAlpha() {
        return this.backgroundAlpha;
    }

    public final String getBackgroundImage() {
        return this.backgroundImage;
    }

    public final String getBorderColor() {
        return this.borderColor;
    }

    public final List<String> getBorderColors() {
        return this.borderColors;
    }

    public final Integer getBorderWidth() {
        return this.borderWidth;
    }

    public final String getCmdDamageAnim() {
        return this.cmdDamageAnim;
    }

    public final Integer getCmdDamageAnimDuration() {
        return this.cmdDamageAnimDuration;
    }

    public final Integer getCornerRadius() {
        return this.cornerRadius;
    }

    public final String getCustomFont() {
        return this.customFont;
    }

    public final PlayerToss getCustomPlayerToss() {
        return this.customPlayerToss;
    }

    public final List<String> getDecors() {
        return this.decors;
    }

    public final Boolean getDisableDropShadows() {
        return this.disableDropShadows;
    }

    public final Integer getExtraMargin() {
        return this.extraMargin;
    }

    public final Boolean getFullscreenPlaymats() {
        return this.fullscreenPlaymats;
    }

    public final Float getGlowAlpha() {
        return this.glowAlpha;
    }

    public final String getGlowColor() {
        return this.glowColor;
    }

    public final Integer getGlowRadius() {
        return this.glowRadius;
    }

    public final String getKoAnimation() {
        return this.koAnimation;
    }

    public final Float getKoAnimationScale() {
        return this.koAnimationScale;
    }

    public final String getKoFont() {
        return this.koFont;
    }

    public final Float getKoFontMultiplier() {
        return this.koFontMultiplier;
    }

    public final Messages getKoMessages() {
        return this.koMessages;
    }

    public final String getLifeFontColor() {
        return this.lifeFontColor;
    }

    public final Float getLifeFontMultiplier() {
        return this.lifeFontMultiplier;
    }

    public final List<LowLifeAnimDefinition> getLowLifeAnims() {
        return this.lowLifeAnims;
    }

    public final String getLowLifeFlashColor() {
        return this.lowLifeFlashColor;
    }

    public final List<String> getLowLifeFlashColors() {
        return this.lowLifeFlashColors;
    }

    public final String getMenuImage() {
        return this.menuImage;
    }

    public final Float getMenuScale() {
        return this.menuScale;
    }

    public final Boolean getOverridePlaymats() {
        return this.overridePlaymats;
    }

    public final Float getPlayerNameFontMultiplier() {
        return this.playerNameFontMultiplier;
    }

    public final Float getPlayernameAlpha() {
        return this.playernameAlpha;
    }

    public final Float getPlaymatAlpha() {
        return this.playmatAlpha;
    }

    public final List<String> getPlaymats() {
        return this.playmats;
    }

    public final String getPoisonAnim() {
        return this.poisonAnim;
    }

    public final Integer getPoisonAnimDuration() {
        return this.poisonAnimDuration;
    }

    public final Float getSymbolsAlpha() {
        return this.symbolsAlpha;
    }

    public final List<String> getUnlockedPlaymats() {
        return this.unlockedPlaymats;
    }

    public final int getVersion() {
        return this.version;
    }

    public final String getWinnerAnimation() {
        return this.winnerAnimation;
    }

    public final Float getWinnerAnimationScale() {
        return this.winnerAnimationScale;
    }

    public final String getWinnerFont() {
        return this.winnerFont;
    }

    public final Float getWinnerFontMultiplier() {
        return this.winnerFontMultiplier;
    }

    public final Messages getWinnerMessages() {
        return this.winnerMessages;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.version) * 31;
        Integer num = this.extraMargin;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.menuImage;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Float f = this.menuScale;
        int iHashCode4 = (iHashCode3 + (f == null ? 0 : f.hashCode())) * 31;
        Float f2 = this.playmatAlpha;
        int iHashCode5 = (iHashCode4 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Float f3 = this.playernameAlpha;
        int iHashCode6 = (iHashCode5 + (f3 == null ? 0 : f3.hashCode())) * 31;
        String str2 = this.customFont;
        int iHashCode7 = (iHashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Float f4 = this.playerNameFontMultiplier;
        int iHashCode8 = (iHashCode7 + (f4 == null ? 0 : f4.hashCode())) * 31;
        Float f5 = this.lifeFontMultiplier;
        int iHashCode9 = (iHashCode8 + (f5 == null ? 0 : f5.hashCode())) * 31;
        String str3 = this.lifeFontColor;
        int iHashCode10 = (iHashCode9 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Float f6 = this.symbolsAlpha;
        int iHashCode11 = (iHashCode10 + (f6 == null ? 0 : f6.hashCode())) * 31;
        String str4 = this.glowColor;
        int iHashCode12 = (iHashCode11 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Float f7 = this.glowAlpha;
        int iHashCode13 = (iHashCode12 + (f7 == null ? 0 : f7.hashCode())) * 31;
        Integer num2 = this.glowRadius;
        int iHashCode14 = (iHashCode13 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str5 = this.borderColor;
        int iHashCode15 = (iHashCode14 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<String> list = this.borderColors;
        int iHashCode16 = (iHashCode15 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num3 = this.borderWidth;
        int iHashCode17 = (iHashCode16 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str6 = this.koFont;
        int iHashCode18 = (iHashCode17 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Float f8 = this.koFontMultiplier;
        int iHashCode19 = (iHashCode18 + (f8 == null ? 0 : f8.hashCode())) * 31;
        Messages messages = this.koMessages;
        int iHashCode20 = (iHashCode19 + (messages == null ? 0 : messages.hashCode())) * 31;
        List<LowLifeAnimDefinition> list2 = this.lowLifeAnims;
        int iHashCode21 = (iHashCode20 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str7 = this.winnerFont;
        int iHashCode22 = (iHashCode21 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Float f9 = this.winnerFontMultiplier;
        int iHashCode23 = (iHashCode22 + (f9 == null ? 0 : f9.hashCode())) * 31;
        Messages messages2 = this.winnerMessages;
        int iHashCode24 = (iHashCode23 + (messages2 == null ? 0 : messages2.hashCode())) * 31;
        String str8 = this.winnerAnimation;
        int iHashCode25 = (iHashCode24 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Float f10 = this.winnerAnimationScale;
        int iHashCode26 = (iHashCode25 + (f10 == null ? 0 : f10.hashCode())) * 31;
        String str9 = this.lowLifeFlashColor;
        int iHashCode27 = (iHashCode26 + (str9 == null ? 0 : str9.hashCode())) * 31;
        List<String> list3 = this.lowLifeFlashColors;
        int iHashCode28 = (iHashCode27 + (list3 == null ? 0 : list3.hashCode())) * 31;
        String str10 = this.backgroundImage;
        int iHashCode29 = (iHashCode28 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Float f11 = this.backgroundAlpha;
        int iHashCode30 = (iHashCode29 + (f11 == null ? 0 : f11.hashCode())) * 31;
        List<String> list4 = this.playmats;
        int iHashCode31 = (iHashCode30 + (list4 == null ? 0 : list4.hashCode())) * 31;
        Boolean bool = this.overridePlaymats;
        int iHashCode32 = (iHashCode31 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str11 = this.koAnimation;
        int iHashCode33 = (iHashCode32 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Float f12 = this.koAnimationScale;
        int iHashCode34 = (iHashCode33 + (f12 == null ? 0 : f12.hashCode())) * 31;
        List<Accessory> list5 = this.accessories;
        int iHashCode35 = (iHashCode34 + (list5 == null ? 0 : list5.hashCode())) * 31;
        List<String> list6 = this.decors;
        int iHashCode36 = (iHashCode35 + (list6 == null ? 0 : list6.hashCode())) * 31;
        Integer num4 = this.cornerRadius;
        int iHashCode37 = (iHashCode36 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Boolean bool2 = this.fullscreenPlaymats;
        int iHashCode38 = (iHashCode37 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.disableDropShadows;
        int iHashCode39 = (iHashCode38 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        PlayerToss playerToss = this.customPlayerToss;
        int iHashCode40 = (iHashCode39 + (playerToss == null ? 0 : playerToss.hashCode())) * 31;
        List<String> list7 = this.unlockedPlaymats;
        int iHashCode41 = (iHashCode40 + (list7 == null ? 0 : list7.hashCode())) * 31;
        String str12 = this.cmdDamageAnim;
        int iHashCode42 = (iHashCode41 + (str12 == null ? 0 : str12.hashCode())) * 31;
        Integer num5 = this.cmdDamageAnimDuration;
        int iHashCode43 = (iHashCode42 + (num5 == null ? 0 : num5.hashCode())) * 31;
        String str13 = this.poisonAnim;
        int iHashCode44 = (iHashCode43 + (str13 == null ? 0 : str13.hashCode())) * 31;
        Integer num6 = this.poisonAnimDuration;
        return iHashCode44 + (num6 != null ? num6.hashCode() : 0);
    }

    public final void setCmdDamageAnim(String str) {
        this.cmdDamageAnim = str;
    }

    public final void setCmdDamageAnimDuration(Integer num) {
        this.cmdDamageAnimDuration = num;
    }

    public final void setCornerRadius(Integer num) {
        this.cornerRadius = num;
    }

    public final void setCustomPlayerToss(PlayerToss playerToss) {
        this.customPlayerToss = playerToss;
    }

    public final void setDisableDropShadows(Boolean bool) {
        this.disableDropShadows = bool;
    }

    public final void setFullscreenPlaymats(Boolean bool) {
        this.fullscreenPlaymats = bool;
    }

    public final void setLifeFontColor(String str) {
        this.lifeFontColor = str;
    }

    public final void setPoisonAnim(String str) {
        this.poisonAnim = str;
    }

    public final void setPoisonAnimDuration(Integer num) {
        this.poisonAnimDuration = num;
    }

    public final void setUnlockedPlaymats(List<String> list) {
        this.unlockedPlaymats = list;
    }

    public String toString() {
        return "SkinDefinition(version=" + this.version + ", extraMargin=" + this.extraMargin + ", menuImage=" + this.menuImage + ", menuScale=" + this.menuScale + ", playmatAlpha=" + this.playmatAlpha + ", playernameAlpha=" + this.playernameAlpha + ", customFont=" + this.customFont + ", playerNameFontMultiplier=" + this.playerNameFontMultiplier + ", lifeFontMultiplier=" + this.lifeFontMultiplier + ", lifeFontColor=" + this.lifeFontColor + ", symbolsAlpha=" + this.symbolsAlpha + ", glowColor=" + this.glowColor + ", glowAlpha=" + this.glowAlpha + ", glowRadius=" + this.glowRadius + ", borderColor=" + this.borderColor + ", borderColors=" + this.borderColors + ", borderWidth=" + this.borderWidth + ", koFont=" + this.koFont + ", koFontMultiplier=" + this.koFontMultiplier + ", koMessages=" + this.koMessages + ", lowLifeAnims=" + this.lowLifeAnims + ", winnerFont=" + this.winnerFont + ", winnerFontMultiplier=" + this.winnerFontMultiplier + ", winnerMessages=" + this.winnerMessages + ", winnerAnimation=" + this.winnerAnimation + ", winnerAnimationScale=" + this.winnerAnimationScale + ", lowLifeFlashColor=" + this.lowLifeFlashColor + ", lowLifeFlashColors=" + this.lowLifeFlashColors + ", backgroundImage=" + this.backgroundImage + ", backgroundAlpha=" + this.backgroundAlpha + ", playmats=" + this.playmats + ", overridePlaymats=" + this.overridePlaymats + ", koAnimation=" + this.koAnimation + ", koAnimationScale=" + this.koAnimationScale + ", accessories=" + this.accessories + ", decors=" + this.decors + ", cornerRadius=" + this.cornerRadius + ", fullscreenPlaymats=" + this.fullscreenPlaymats + ", disableDropShadows=" + this.disableDropShadows + ", customPlayerToss=" + this.customPlayerToss + ", unlockedPlaymats=" + this.unlockedPlaymats + ", cmdDamageAnim=" + this.cmdDamageAnim + ", cmdDamageAnimDuration=" + this.cmdDamageAnimDuration + ", poisonAnim=" + this.poisonAnim + ", poisonAnimDuration=" + this.poisonAnimDuration + ")";
    }
}
