package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0003\b\u009f\u0001\b\u0087\b\u0018\u00002\u00020\u0001B\u0081\u0004\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b4\u00105J\n\u0010\u009f\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010 \u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¡\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010¢\u0001\u001a\u00020\u0003HÆ\u0003J\u0011\u0010£\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010CJ\n\u0010¤\u0001\u001a\u00020\tHÆ\u0003J\f\u0010¥\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010¦\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010§\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010¨\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010©\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010ª\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010«\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010¬\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\f\u0010®\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010¯\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010°\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010±\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010CJ\f\u0010²\u0001\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u0011\u0010³\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010lJ\u0011\u0010´\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010lJ\u0011\u0010µ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010lJ\u0011\u0010¶\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010CJ\f\u0010·\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010¸\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010¹\u0001\u001a\u0004\u0018\u00010\"HÆ\u0003J\f\u0010º\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010»\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010¼\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010½\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010¾\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010¿\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010À\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010Á\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010lJ\u0011\u0010Â\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010lJ\f\u0010Ã\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010Ä\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010Å\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010Æ\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010Ç\u0001\u001a\u0004\u0018\u000101HÆ\u0003J\u0011\u0010È\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010CJ\u0011\u0010É\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010CJ\u008a\u0004\u0010Ê\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0003\u0010Ë\u0001J\u0015\u0010Ì\u0001\u001a\u00020\t2\t\u0010Í\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010Î\u0001\u001a\u00020\u0003HÖ\u0001J\n\u0010Ï\u0001\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00107\"\u0004\b;\u00109R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00107\"\u0004\bA\u00109R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010F\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010=\"\u0004\bL\u0010?R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010=\"\u0004\bN\u0010?R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010=\"\u0004\bP\u0010?R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010=\"\u0004\bR\u0010?R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010=\"\u0004\bT\u0010?R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010=\"\u0004\bV\u0010?R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010=\"\u0004\bX\u0010?R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010=\"\u0004\bZ\u0010?R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010=\"\u0004\b`\u0010?R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010=\"\u0004\bb\u0010?R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010=\"\u0004\bd\u0010?R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010F\u001a\u0004\be\u0010C\"\u0004\bf\u0010ER\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010o\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010o\u001a\u0004\bp\u0010l\"\u0004\bq\u0010nR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010o\u001a\u0004\br\u0010l\"\u0004\bs\u0010nR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010F\u001a\u0004\bt\u0010C\"\u0004\bu\u0010ER\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010=\"\u0004\bw\u0010?R\u001c\u0010 \u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010=\"\u0004\by\u0010?R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R\u001c\u0010#\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010=\"\u0004\b\u007f\u0010?R\u001e\u0010$\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010=\"\u0005\b\u0081\u0001\u0010?R\u001e\u0010%\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010=\"\u0005\b\u0083\u0001\u0010?R\u001e\u0010&\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010=\"\u0005\b\u0085\u0001\u0010?R\u001e\u0010'\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010=\"\u0005\b\u0087\u0001\u0010?R\u001e\u0010(\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u0010=\"\u0005\b\u0089\u0001\u0010?R\u001e\u0010)\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010=\"\u0005\b\u008b\u0001\u0010?R \u0010*\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0012\n\u0002\u0010o\u001a\u0005\b\u008c\u0001\u0010l\"\u0005\b\u008d\u0001\u0010nR \u0010+\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0012\n\u0002\u0010o\u001a\u0005\b\u008e\u0001\u0010l\"\u0005\b\u008f\u0001\u0010nR\u001e\u0010,\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010=\"\u0005\b\u0091\u0001\u0010?R\u001e\u0010-\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010=\"\u0005\b\u0093\u0001\u0010?R\u001e\u0010.\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010=\"\u0005\b\u0095\u0001\u0010?R\u001e\u0010/\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u0010=\"\u0005\b\u0097\u0001\u0010?R \u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001f\u00102\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0011\n\u0002\u0010F\u001a\u0004\b2\u0010C\"\u0005\b\u009c\u0001\u0010ER \u00103\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0012\n\u0002\u0010F\u001a\u0005\b\u009d\u0001\u0010C\"\u0005\b\u009e\u0001\u0010E¨\u0006Ð\u0001"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTDeck;", "", "id", "", "formatid", "name", "", "type", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "", "temporary", "colors", "description", "commander", "partner", "signaturespell", "partnersignaturespell", "leftplaymat", "rightplaymat", "stats", "Lcom/studiolaganne/lengendarylens/MTStats;", "externalurl", "created_at", "updated_at", "ghost", "bracket", "Lcom/studiolaganne/lengendarylens/MTBracket;", "listid", "maybeboardlistid", "sideboardlistid", "auto_update", "commander_color_override", "partner_color_override", "values", "Lcom/studiolaganne/lengendarylens/MTDeckValues;", "commander_card_id", "partner_card_id", "signature_spell_card_id", "partner_signature_spell_card_id", "companion_card_id", "leftplaymat_card_id", "rightplaymat_card_id", "leftplaymat_face_index", "rightplaymat_face_index", "leftplaymat_image", "leftplaymat_image_type", "rightplaymat_image", "rightplaymat_image_type", "owner", "Lcom/studiolaganne/lengendarylens/MTPrivacyUser;", "is_smart_deck", "has_smart_deck", "<init>", "(IILjava/lang/String;ILjava/lang/Boolean;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTStats;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/studiolaganne/lengendarylens/MTBracket;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTDeckValues;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTPrivacyUser;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getId", "()I", "setId", "(I)V", "getFormatid", "setFormatid", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getType", "setType", "getActive", "()Ljava/lang/Boolean;", "setActive", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTemporary", "()Z", "setTemporary", "(Z)V", "getColors", "setColors", "getDescription", "setDescription", "getCommander", "setCommander", "getPartner", "setPartner", "getSignaturespell", "setSignaturespell", "getPartnersignaturespell", "setPartnersignaturespell", "getLeftplaymat", "setLeftplaymat", "getRightplaymat", "setRightplaymat", "getStats", "()Lcom/studiolaganne/lengendarylens/MTStats;", "setStats", "(Lcom/studiolaganne/lengendarylens/MTStats;)V", "getExternalurl", "setExternalurl", "getCreated_at", "setCreated_at", "getUpdated_at", "setUpdated_at", "getGhost", "setGhost", "getBracket", "()Lcom/studiolaganne/lengendarylens/MTBracket;", "setBracket", "(Lcom/studiolaganne/lengendarylens/MTBracket;)V", "getListid", "()Ljava/lang/Integer;", "setListid", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMaybeboardlistid", "setMaybeboardlistid", "getSideboardlistid", "setSideboardlistid", "getAuto_update", "setAuto_update", "getCommander_color_override", "setCommander_color_override", "getPartner_color_override", "setPartner_color_override", "getValues", "()Lcom/studiolaganne/lengendarylens/MTDeckValues;", "setValues", "(Lcom/studiolaganne/lengendarylens/MTDeckValues;)V", "getCommander_card_id", "setCommander_card_id", "getPartner_card_id", "setPartner_card_id", "getSignature_spell_card_id", "setSignature_spell_card_id", "getPartner_signature_spell_card_id", "setPartner_signature_spell_card_id", "getCompanion_card_id", "setCompanion_card_id", "getLeftplaymat_card_id", "setLeftplaymat_card_id", "getRightplaymat_card_id", "setRightplaymat_card_id", "getLeftplaymat_face_index", "setLeftplaymat_face_index", "getRightplaymat_face_index", "setRightplaymat_face_index", "getLeftplaymat_image", "setLeftplaymat_image", "getLeftplaymat_image_type", "setLeftplaymat_image_type", "getRightplaymat_image", "setRightplaymat_image", "getRightplaymat_image_type", "setRightplaymat_image_type", "getOwner", "()Lcom/studiolaganne/lengendarylens/MTPrivacyUser;", "setOwner", "(Lcom/studiolaganne/lengendarylens/MTPrivacyUser;)V", "set_smart_deck", "getHas_smart_deck", "setHas_smart_deck", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "copy", "(IILjava/lang/String;ILjava/lang/Boolean;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTStats;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/studiolaganne/lengendarylens/MTBracket;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTDeckValues;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTPrivacyUser;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/studiolaganne/lengendarylens/MTDeck;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTDeck {
    public static final int $stable = 8;
    private Boolean active;
    private Boolean auto_update;
    private MTBracket bracket;
    private String colors;
    private String commander;
    private String commander_card_id;
    private String commander_color_override;
    private String companion_card_id;
    private String created_at;
    private String description;
    private String externalurl;
    private int formatid;
    private Boolean ghost;
    private Boolean has_smart_deck;
    private int id;
    private Boolean is_smart_deck;
    private String leftplaymat;
    private String leftplaymat_card_id;
    private Integer leftplaymat_face_index;
    private String leftplaymat_image;
    private String leftplaymat_image_type;
    private Integer listid;
    private Integer maybeboardlistid;
    private String name;
    private MTPrivacyUser owner;
    private String partner;
    private String partner_card_id;
    private String partner_color_override;
    private String partner_signature_spell_card_id;
    private String partnersignaturespell;
    private String rightplaymat;
    private String rightplaymat_card_id;
    private Integer rightplaymat_face_index;
    private String rightplaymat_image;
    private String rightplaymat_image_type;
    private Integer sideboardlistid;
    private String signature_spell_card_id;
    private String signaturespell;
    private MTStats stats;
    private boolean temporary;
    private int type;
    private String updated_at;
    private MTDeckValues values;

    public MTDeck() {
        this(0, 0, null, 0, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 2047, null);
    }

    public MTDeck(int i, int i2, String name, int i3, Boolean bool, boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, MTStats mTStats, String str9, String str10, String str11, Boolean bool2, MTBracket mTBracket, Integer num, Integer num2, Integer num3, Boolean bool3, String str12, String str13, MTDeckValues mTDeckValues, String str14, String str15, String str16, String str17, String str18, String str19, String str20, Integer num4, Integer num5, String str21, String str22, String str23, String str24, MTPrivacyUser mTPrivacyUser, Boolean bool4, Boolean bool5) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i;
        this.formatid = i2;
        this.name = name;
        this.type = i3;
        this.active = bool;
        this.temporary = z;
        this.colors = str;
        this.description = str2;
        this.commander = str3;
        this.partner = str4;
        this.signaturespell = str5;
        this.partnersignaturespell = str6;
        this.leftplaymat = str7;
        this.rightplaymat = str8;
        this.stats = mTStats;
        this.externalurl = str9;
        this.created_at = str10;
        this.updated_at = str11;
        this.ghost = bool2;
        this.bracket = mTBracket;
        this.listid = num;
        this.maybeboardlistid = num2;
        this.sideboardlistid = num3;
        this.auto_update = bool3;
        this.commander_color_override = str12;
        this.partner_color_override = str13;
        this.values = mTDeckValues;
        this.commander_card_id = str14;
        this.partner_card_id = str15;
        this.signature_spell_card_id = str16;
        this.partner_signature_spell_card_id = str17;
        this.companion_card_id = str18;
        this.leftplaymat_card_id = str19;
        this.rightplaymat_card_id = str20;
        this.leftplaymat_face_index = num4;
        this.rightplaymat_face_index = num5;
        this.leftplaymat_image = str21;
        this.leftplaymat_image_type = str22;
        this.rightplaymat_image = str23;
        this.rightplaymat_image_type = str24;
        this.owner = mTPrivacyUser;
        this.is_smart_deck = bool4;
        this.has_smart_deck = bool5;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ MTDeck(int i, int i2, String str, int i3, Boolean bool, boolean z, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, MTStats mTStats, String str10, String str11, String str12, Boolean bool2, MTBracket mTBracket, Integer num, Integer num2, Integer num3, Boolean bool3, String str13, String str14, MTDeckValues mTDeckValues, String str15, String str16, String str17, String str18, String str19, String str20, String str21, Integer num4, Integer num5, String str22, String str23, String str24, String str25, MTPrivacyUser mTPrivacyUser, Boolean bool4, Boolean bool5, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        int i6 = (i4 & 1) != 0 ? -1 : i;
        this(i6, (i4 & 2) == 0 ? i2 : -1, (i4 & 4) != 0 ? "" : str, (i4 & 8) != 0 ? 0 : i3, (i4 & 16) != 0 ? true : bool, (i4 & 32) != 0 ? false : z, (i4 & 64) != 0 ? "" : str2, (i4 & 128) == 0 ? str3 : "", (i4 & 256) != 0 ? null : str4, (i4 & 512) != 0 ? null : str5, (i4 & 1024) != 0 ? null : str6, (i4 & 2048) != 0 ? null : str7, (i4 & 4096) != 0 ? null : str8, (i4 & 8192) != 0 ? null : str9, (i4 & 16384) != 0 ? null : mTStats, (i4 & 32768) != 0 ? null : str10, (i4 & 65536) != 0 ? null : str11, (i4 & 131072) != 0 ? null : str12, (i4 & 262144) != 0 ? false : bool2, (i4 & 524288) != 0 ? null : mTBracket, (i4 & 1048576) != 0 ? null : num, (i4 & 2097152) != 0 ? null : num2, (i4 & 4194304) != 0 ? null : num3, (i4 & 8388608) != 0 ? null : bool3, (i4 & 16777216) != 0 ? null : str13, (i4 & 33554432) != 0 ? null : str14, (i4 & 67108864) != 0 ? null : mTDeckValues, (i4 & 134217728) != 0 ? null : str15, (i4 & 268435456) != 0 ? null : str16, (i4 & 536870912) != 0 ? null : str17, (i4 & 1073741824) != 0 ? null : str18, (i4 & Integer.MIN_VALUE) != 0 ? null : str19, (i5 & 1) != 0 ? null : str20, (i5 & 2) != 0 ? null : str21, (i5 & 4) != 0 ? null : num4, (i5 & 8) != 0 ? null : num5, (i5 & 16) != 0 ? null : str22, (i5 & 32) != 0 ? null : str23, (i5 & 64) != 0 ? null : str24, (i5 & 128) != 0 ? null : str25, (i5 & 256) != 0 ? null : mTPrivacyUser, (i5 & 512) != 0 ? null : bool4, (i5 & 1024) != 0 ? null : bool5);
    }

    public static /* synthetic */ MTDeck copy$default(MTDeck mTDeck, int i, int i2, String str, int i3, Boolean bool, boolean z, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, MTStats mTStats, String str10, String str11, String str12, Boolean bool2, MTBracket mTBracket, Integer num, Integer num2, Integer num3, Boolean bool3, String str13, String str14, MTDeckValues mTDeckValues, String str15, String str16, String str17, String str18, String str19, String str20, String str21, Integer num4, Integer num5, String str22, String str23, String str24, String str25, MTPrivacyUser mTPrivacyUser, Boolean bool4, Boolean bool5, int i4, int i5, Object obj) {
        int i6 = (i4 & 1) != 0 ? mTDeck.id : i;
        return mTDeck.copy(i6, (i4 & 2) != 0 ? mTDeck.formatid : i2, (i4 & 4) != 0 ? mTDeck.name : str, (i4 & 8) != 0 ? mTDeck.type : i3, (i4 & 16) != 0 ? mTDeck.active : bool, (i4 & 32) != 0 ? mTDeck.temporary : z, (i4 & 64) != 0 ? mTDeck.colors : str2, (i4 & 128) != 0 ? mTDeck.description : str3, (i4 & 256) != 0 ? mTDeck.commander : str4, (i4 & 512) != 0 ? mTDeck.partner : str5, (i4 & 1024) != 0 ? mTDeck.signaturespell : str6, (i4 & 2048) != 0 ? mTDeck.partnersignaturespell : str7, (i4 & 4096) != 0 ? mTDeck.leftplaymat : str8, (i4 & 8192) != 0 ? mTDeck.rightplaymat : str9, (i4 & 16384) != 0 ? mTDeck.stats : mTStats, (i4 & 32768) != 0 ? mTDeck.externalurl : str10, (i4 & 65536) != 0 ? mTDeck.created_at : str11, (i4 & 131072) != 0 ? mTDeck.updated_at : str12, (i4 & 262144) != 0 ? mTDeck.ghost : bool2, (i4 & 524288) != 0 ? mTDeck.bracket : mTBracket, (i4 & 1048576) != 0 ? mTDeck.listid : num, (i4 & 2097152) != 0 ? mTDeck.maybeboardlistid : num2, (i4 & 4194304) != 0 ? mTDeck.sideboardlistid : num3, (i4 & 8388608) != 0 ? mTDeck.auto_update : bool3, (i4 & 16777216) != 0 ? mTDeck.commander_color_override : str13, (i4 & 33554432) != 0 ? mTDeck.partner_color_override : str14, (i4 & 67108864) != 0 ? mTDeck.values : mTDeckValues, (i4 & 134217728) != 0 ? mTDeck.commander_card_id : str15, (i4 & 268435456) != 0 ? mTDeck.partner_card_id : str16, (i4 & 536870912) != 0 ? mTDeck.signature_spell_card_id : str17, (i4 & 1073741824) != 0 ? mTDeck.partner_signature_spell_card_id : str18, (i4 & Integer.MIN_VALUE) != 0 ? mTDeck.companion_card_id : str19, (i5 & 1) != 0 ? mTDeck.leftplaymat_card_id : str20, (i5 & 2) != 0 ? mTDeck.rightplaymat_card_id : str21, (i5 & 4) != 0 ? mTDeck.leftplaymat_face_index : num4, (i5 & 8) != 0 ? mTDeck.rightplaymat_face_index : num5, (i5 & 16) != 0 ? mTDeck.leftplaymat_image : str22, (i5 & 32) != 0 ? mTDeck.leftplaymat_image_type : str23, (i5 & 64) != 0 ? mTDeck.rightplaymat_image : str24, (i5 & 128) != 0 ? mTDeck.rightplaymat_image_type : str25, (i5 & 256) != 0 ? mTDeck.owner : mTPrivacyUser, (i5 & 512) != 0 ? mTDeck.is_smart_deck : bool4, (i5 & 1024) != 0 ? mTDeck.has_smart_deck : bool5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getPartner() {
        return this.partner;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getSignaturespell() {
        return this.signaturespell;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getPartnersignaturespell() {
        return this.partnersignaturespell;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getLeftplaymat() {
        return this.leftplaymat;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getRightplaymat() {
        return this.rightplaymat;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final MTStats getStats() {
        return this.stats;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getExternalurl() {
        return this.externalurl;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getCreated_at() {
        return this.created_at;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getUpdated_at() {
        return this.updated_at;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final Boolean getGhost() {
        return this.ghost;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getFormatid() {
        return this.formatid;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final MTBracket getBracket() {
        return this.bracket;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final Integer getListid() {
        return this.listid;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final Integer getMaybeboardlistid() {
        return this.maybeboardlistid;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final Integer getSideboardlistid() {
        return this.sideboardlistid;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final Boolean getAuto_update() {
        return this.auto_update;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final String getCommander_color_override() {
        return this.commander_color_override;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final String getPartner_color_override() {
        return this.partner_color_override;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final MTDeckValues getValues() {
        return this.values;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final String getCommander_card_id() {
        return this.commander_card_id;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final String getPartner_card_id() {
        return this.partner_card_id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final String getSignature_spell_card_id() {
        return this.signature_spell_card_id;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final String getPartner_signature_spell_card_id() {
        return this.partner_signature_spell_card_id;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final String getCompanion_card_id() {
        return this.companion_card_id;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final String getLeftplaymat_card_id() {
        return this.leftplaymat_card_id;
    }

    /* JADX INFO: renamed from: component34, reason: from getter */
    public final String getRightplaymat_card_id() {
        return this.rightplaymat_card_id;
    }

    /* JADX INFO: renamed from: component35, reason: from getter */
    public final Integer getLeftplaymat_face_index() {
        return this.leftplaymat_face_index;
    }

    /* JADX INFO: renamed from: component36, reason: from getter */
    public final Integer getRightplaymat_face_index() {
        return this.rightplaymat_face_index;
    }

    /* JADX INFO: renamed from: component37, reason: from getter */
    public final String getLeftplaymat_image() {
        return this.leftplaymat_image;
    }

    /* JADX INFO: renamed from: component38, reason: from getter */
    public final String getLeftplaymat_image_type() {
        return this.leftplaymat_image_type;
    }

    /* JADX INFO: renamed from: component39, reason: from getter */
    public final String getRightplaymat_image() {
        return this.rightplaymat_image;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component40, reason: from getter */
    public final String getRightplaymat_image_type() {
        return this.rightplaymat_image_type;
    }

    /* JADX INFO: renamed from: component41, reason: from getter */
    public final MTPrivacyUser getOwner() {
        return this.owner;
    }

    /* JADX INFO: renamed from: component42, reason: from getter */
    public final Boolean getIs_smart_deck() {
        return this.is_smart_deck;
    }

    /* JADX INFO: renamed from: component43, reason: from getter */
    public final Boolean getHas_smart_deck() {
        return this.has_smart_deck;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getActive() {
        return this.active;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getTemporary() {
        return this.temporary;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getColors() {
        return this.colors;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getCommander() {
        return this.commander;
    }

    public final MTDeck copy(int id, int formatid, String name, int type, Boolean active, boolean temporary, String colors, String description, String commander, String partner, String signaturespell, String partnersignaturespell, String leftplaymat, String rightplaymat, MTStats stats, String externalurl, String created_at, String updated_at, Boolean ghost, MTBracket bracket, Integer listid, Integer maybeboardlistid, Integer sideboardlistid, Boolean auto_update, String commander_color_override, String partner_color_override, MTDeckValues values, String commander_card_id, String partner_card_id, String signature_spell_card_id, String partner_signature_spell_card_id, String companion_card_id, String leftplaymat_card_id, String rightplaymat_card_id, Integer leftplaymat_face_index, Integer rightplaymat_face_index, String leftplaymat_image, String leftplaymat_image_type, String rightplaymat_image, String rightplaymat_image_type, MTPrivacyUser owner, Boolean is_smart_deck, Boolean has_smart_deck) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new MTDeck(id, formatid, name, type, active, temporary, colors, description, commander, partner, signaturespell, partnersignaturespell, leftplaymat, rightplaymat, stats, externalurl, created_at, updated_at, ghost, bracket, listid, maybeboardlistid, sideboardlistid, auto_update, commander_color_override, partner_color_override, values, commander_card_id, partner_card_id, signature_spell_card_id, partner_signature_spell_card_id, companion_card_id, leftplaymat_card_id, rightplaymat_card_id, leftplaymat_face_index, rightplaymat_face_index, leftplaymat_image, leftplaymat_image_type, rightplaymat_image, rightplaymat_image_type, owner, is_smart_deck, has_smart_deck);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTDeck)) {
            return false;
        }
        MTDeck mTDeck = (MTDeck) other;
        return this.id == mTDeck.id && this.formatid == mTDeck.formatid && Intrinsics.areEqual(this.name, mTDeck.name) && this.type == mTDeck.type && Intrinsics.areEqual(this.active, mTDeck.active) && this.temporary == mTDeck.temporary && Intrinsics.areEqual(this.colors, mTDeck.colors) && Intrinsics.areEqual(this.description, mTDeck.description) && Intrinsics.areEqual(this.commander, mTDeck.commander) && Intrinsics.areEqual(this.partner, mTDeck.partner) && Intrinsics.areEqual(this.signaturespell, mTDeck.signaturespell) && Intrinsics.areEqual(this.partnersignaturespell, mTDeck.partnersignaturespell) && Intrinsics.areEqual(this.leftplaymat, mTDeck.leftplaymat) && Intrinsics.areEqual(this.rightplaymat, mTDeck.rightplaymat) && Intrinsics.areEqual(this.stats, mTDeck.stats) && Intrinsics.areEqual(this.externalurl, mTDeck.externalurl) && Intrinsics.areEqual(this.created_at, mTDeck.created_at) && Intrinsics.areEqual(this.updated_at, mTDeck.updated_at) && Intrinsics.areEqual(this.ghost, mTDeck.ghost) && Intrinsics.areEqual(this.bracket, mTDeck.bracket) && Intrinsics.areEqual(this.listid, mTDeck.listid) && Intrinsics.areEqual(this.maybeboardlistid, mTDeck.maybeboardlistid) && Intrinsics.areEqual(this.sideboardlistid, mTDeck.sideboardlistid) && Intrinsics.areEqual(this.auto_update, mTDeck.auto_update) && Intrinsics.areEqual(this.commander_color_override, mTDeck.commander_color_override) && Intrinsics.areEqual(this.partner_color_override, mTDeck.partner_color_override) && Intrinsics.areEqual(this.values, mTDeck.values) && Intrinsics.areEqual(this.commander_card_id, mTDeck.commander_card_id) && Intrinsics.areEqual(this.partner_card_id, mTDeck.partner_card_id) && Intrinsics.areEqual(this.signature_spell_card_id, mTDeck.signature_spell_card_id) && Intrinsics.areEqual(this.partner_signature_spell_card_id, mTDeck.partner_signature_spell_card_id) && Intrinsics.areEqual(this.companion_card_id, mTDeck.companion_card_id) && Intrinsics.areEqual(this.leftplaymat_card_id, mTDeck.leftplaymat_card_id) && Intrinsics.areEqual(this.rightplaymat_card_id, mTDeck.rightplaymat_card_id) && Intrinsics.areEqual(this.leftplaymat_face_index, mTDeck.leftplaymat_face_index) && Intrinsics.areEqual(this.rightplaymat_face_index, mTDeck.rightplaymat_face_index) && Intrinsics.areEqual(this.leftplaymat_image, mTDeck.leftplaymat_image) && Intrinsics.areEqual(this.leftplaymat_image_type, mTDeck.leftplaymat_image_type) && Intrinsics.areEqual(this.rightplaymat_image, mTDeck.rightplaymat_image) && Intrinsics.areEqual(this.rightplaymat_image_type, mTDeck.rightplaymat_image_type) && Intrinsics.areEqual(this.owner, mTDeck.owner) && Intrinsics.areEqual(this.is_smart_deck, mTDeck.is_smart_deck) && Intrinsics.areEqual(this.has_smart_deck, mTDeck.has_smart_deck);
    }

    public final Boolean getActive() {
        return this.active;
    }

    public final Boolean getAuto_update() {
        return this.auto_update;
    }

    public final MTBracket getBracket() {
        return this.bracket;
    }

    public final String getColors() {
        return this.colors;
    }

    public final String getCommander() {
        return this.commander;
    }

    public final String getCommander_card_id() {
        return this.commander_card_id;
    }

    public final String getCommander_color_override() {
        return this.commander_color_override;
    }

    public final String getCompanion_card_id() {
        return this.companion_card_id;
    }

    public final String getCreated_at() {
        return this.created_at;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getExternalurl() {
        return this.externalurl;
    }

    public final int getFormatid() {
        return this.formatid;
    }

    public final Boolean getGhost() {
        return this.ghost;
    }

    public final Boolean getHas_smart_deck() {
        return this.has_smart_deck;
    }

    public final int getId() {
        return this.id;
    }

    public final String getLeftplaymat() {
        return this.leftplaymat;
    }

    public final String getLeftplaymat_card_id() {
        return this.leftplaymat_card_id;
    }

    public final Integer getLeftplaymat_face_index() {
        return this.leftplaymat_face_index;
    }

    public final String getLeftplaymat_image() {
        return this.leftplaymat_image;
    }

    public final String getLeftplaymat_image_type() {
        return this.leftplaymat_image_type;
    }

    public final Integer getListid() {
        return this.listid;
    }

    public final Integer getMaybeboardlistid() {
        return this.maybeboardlistid;
    }

    public final String getName() {
        return this.name;
    }

    public final MTPrivacyUser getOwner() {
        return this.owner;
    }

    public final String getPartner() {
        return this.partner;
    }

    public final String getPartner_card_id() {
        return this.partner_card_id;
    }

    public final String getPartner_color_override() {
        return this.partner_color_override;
    }

    public final String getPartner_signature_spell_card_id() {
        return this.partner_signature_spell_card_id;
    }

    public final String getPartnersignaturespell() {
        return this.partnersignaturespell;
    }

    public final String getRightplaymat() {
        return this.rightplaymat;
    }

    public final String getRightplaymat_card_id() {
        return this.rightplaymat_card_id;
    }

    public final Integer getRightplaymat_face_index() {
        return this.rightplaymat_face_index;
    }

    public final String getRightplaymat_image() {
        return this.rightplaymat_image;
    }

    public final String getRightplaymat_image_type() {
        return this.rightplaymat_image_type;
    }

    public final Integer getSideboardlistid() {
        return this.sideboardlistid;
    }

    public final String getSignature_spell_card_id() {
        return this.signature_spell_card_id;
    }

    public final String getSignaturespell() {
        return this.signaturespell;
    }

    public final MTStats getStats() {
        return this.stats;
    }

    public final boolean getTemporary() {
        return this.temporary;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUpdated_at() {
        return this.updated_at;
    }

    public final MTDeckValues getValues() {
        return this.values;
    }

    public int hashCode() {
        int iHashCode = ((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.formatid)) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.type)) * 31;
        Boolean bool = this.active;
        int iHashCode2 = (((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31) + Boolean.hashCode(this.temporary)) * 31;
        String str = this.colors;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.commander;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.partner;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.signaturespell;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.partnersignaturespell;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.leftplaymat;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.rightplaymat;
        int iHashCode10 = (iHashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        MTStats mTStats = this.stats;
        int iHashCode11 = (iHashCode10 + (mTStats == null ? 0 : mTStats.hashCode())) * 31;
        String str9 = this.externalurl;
        int iHashCode12 = (iHashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.created_at;
        int iHashCode13 = (iHashCode12 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.updated_at;
        int iHashCode14 = (iHashCode13 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Boolean bool2 = this.ghost;
        int iHashCode15 = (iHashCode14 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        MTBracket mTBracket = this.bracket;
        int iHashCode16 = (iHashCode15 + (mTBracket == null ? 0 : mTBracket.hashCode())) * 31;
        Integer num = this.listid;
        int iHashCode17 = (iHashCode16 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.maybeboardlistid;
        int iHashCode18 = (iHashCode17 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.sideboardlistid;
        int iHashCode19 = (iHashCode18 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Boolean bool3 = this.auto_update;
        int iHashCode20 = (iHashCode19 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str12 = this.commander_color_override;
        int iHashCode21 = (iHashCode20 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.partner_color_override;
        int iHashCode22 = (iHashCode21 + (str13 == null ? 0 : str13.hashCode())) * 31;
        MTDeckValues mTDeckValues = this.values;
        int iHashCode23 = (iHashCode22 + (mTDeckValues == null ? 0 : mTDeckValues.hashCode())) * 31;
        String str14 = this.commander_card_id;
        int iHashCode24 = (iHashCode23 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.partner_card_id;
        int iHashCode25 = (iHashCode24 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.signature_spell_card_id;
        int iHashCode26 = (iHashCode25 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.partner_signature_spell_card_id;
        int iHashCode27 = (iHashCode26 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.companion_card_id;
        int iHashCode28 = (iHashCode27 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.leftplaymat_card_id;
        int iHashCode29 = (iHashCode28 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.rightplaymat_card_id;
        int iHashCode30 = (iHashCode29 + (str20 == null ? 0 : str20.hashCode())) * 31;
        Integer num4 = this.leftplaymat_face_index;
        int iHashCode31 = (iHashCode30 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.rightplaymat_face_index;
        int iHashCode32 = (iHashCode31 + (num5 == null ? 0 : num5.hashCode())) * 31;
        String str21 = this.leftplaymat_image;
        int iHashCode33 = (iHashCode32 + (str21 == null ? 0 : str21.hashCode())) * 31;
        String str22 = this.leftplaymat_image_type;
        int iHashCode34 = (iHashCode33 + (str22 == null ? 0 : str22.hashCode())) * 31;
        String str23 = this.rightplaymat_image;
        int iHashCode35 = (iHashCode34 + (str23 == null ? 0 : str23.hashCode())) * 31;
        String str24 = this.rightplaymat_image_type;
        int iHashCode36 = (iHashCode35 + (str24 == null ? 0 : str24.hashCode())) * 31;
        MTPrivacyUser mTPrivacyUser = this.owner;
        int iHashCode37 = (iHashCode36 + (mTPrivacyUser == null ? 0 : mTPrivacyUser.hashCode())) * 31;
        Boolean bool4 = this.is_smart_deck;
        int iHashCode38 = (iHashCode37 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.has_smart_deck;
        return iHashCode38 + (bool5 != null ? bool5.hashCode() : 0);
    }

    public final Boolean is_smart_deck() {
        return this.is_smart_deck;
    }

    public final void setActive(Boolean bool) {
        this.active = bool;
    }

    public final void setAuto_update(Boolean bool) {
        this.auto_update = bool;
    }

    public final void setBracket(MTBracket mTBracket) {
        this.bracket = mTBracket;
    }

    public final void setColors(String str) {
        this.colors = str;
    }

    public final void setCommander(String str) {
        this.commander = str;
    }

    public final void setCommander_card_id(String str) {
        this.commander_card_id = str;
    }

    public final void setCommander_color_override(String str) {
        this.commander_color_override = str;
    }

    public final void setCompanion_card_id(String str) {
        this.companion_card_id = str;
    }

    public final void setCreated_at(String str) {
        this.created_at = str;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setExternalurl(String str) {
        this.externalurl = str;
    }

    public final void setFormatid(int i) {
        this.formatid = i;
    }

    public final void setGhost(Boolean bool) {
        this.ghost = bool;
    }

    public final void setHas_smart_deck(Boolean bool) {
        this.has_smart_deck = bool;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setLeftplaymat(String str) {
        this.leftplaymat = str;
    }

    public final void setLeftplaymat_card_id(String str) {
        this.leftplaymat_card_id = str;
    }

    public final void setLeftplaymat_face_index(Integer num) {
        this.leftplaymat_face_index = num;
    }

    public final void setLeftplaymat_image(String str) {
        this.leftplaymat_image = str;
    }

    public final void setLeftplaymat_image_type(String str) {
        this.leftplaymat_image_type = str;
    }

    public final void setListid(Integer num) {
        this.listid = num;
    }

    public final void setMaybeboardlistid(Integer num) {
        this.maybeboardlistid = num;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setOwner(MTPrivacyUser mTPrivacyUser) {
        this.owner = mTPrivacyUser;
    }

    public final void setPartner(String str) {
        this.partner = str;
    }

    public final void setPartner_card_id(String str) {
        this.partner_card_id = str;
    }

    public final void setPartner_color_override(String str) {
        this.partner_color_override = str;
    }

    public final void setPartner_signature_spell_card_id(String str) {
        this.partner_signature_spell_card_id = str;
    }

    public final void setPartnersignaturespell(String str) {
        this.partnersignaturespell = str;
    }

    public final void setRightplaymat(String str) {
        this.rightplaymat = str;
    }

    public final void setRightplaymat_card_id(String str) {
        this.rightplaymat_card_id = str;
    }

    public final void setRightplaymat_face_index(Integer num) {
        this.rightplaymat_face_index = num;
    }

    public final void setRightplaymat_image(String str) {
        this.rightplaymat_image = str;
    }

    public final void setRightplaymat_image_type(String str) {
        this.rightplaymat_image_type = str;
    }

    public final void setSideboardlistid(Integer num) {
        this.sideboardlistid = num;
    }

    public final void setSignature_spell_card_id(String str) {
        this.signature_spell_card_id = str;
    }

    public final void setSignaturespell(String str) {
        this.signaturespell = str;
    }

    public final void setStats(MTStats mTStats) {
        this.stats = mTStats;
    }

    public final void setTemporary(boolean z) {
        this.temporary = z;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final void setUpdated_at(String str) {
        this.updated_at = str;
    }

    public final void setValues(MTDeckValues mTDeckValues) {
        this.values = mTDeckValues;
    }

    public final void set_smart_deck(Boolean bool) {
        this.is_smart_deck = bool;
    }

    public String toString() {
        return "MTDeck(id=" + this.id + ", formatid=" + this.formatid + ", name=" + this.name + ", type=" + this.type + ", active=" + this.active + ", temporary=" + this.temporary + ", colors=" + this.colors + ", description=" + this.description + ", commander=" + this.commander + ", partner=" + this.partner + ", signaturespell=" + this.signaturespell + ", partnersignaturespell=" + this.partnersignaturespell + ", leftplaymat=" + this.leftplaymat + ", rightplaymat=" + this.rightplaymat + ", stats=" + this.stats + ", externalurl=" + this.externalurl + ", created_at=" + this.created_at + ", updated_at=" + this.updated_at + ", ghost=" + this.ghost + ", bracket=" + this.bracket + ", listid=" + this.listid + ", maybeboardlistid=" + this.maybeboardlistid + ", sideboardlistid=" + this.sideboardlistid + ", auto_update=" + this.auto_update + ", commander_color_override=" + this.commander_color_override + ", partner_color_override=" + this.partner_color_override + ", values=" + this.values + ", commander_card_id=" + this.commander_card_id + ", partner_card_id=" + this.partner_card_id + ", signature_spell_card_id=" + this.signature_spell_card_id + ", partner_signature_spell_card_id=" + this.partner_signature_spell_card_id + ", companion_card_id=" + this.companion_card_id + ", leftplaymat_card_id=" + this.leftplaymat_card_id + ", rightplaymat_card_id=" + this.rightplaymat_card_id + ", leftplaymat_face_index=" + this.leftplaymat_face_index + ", rightplaymat_face_index=" + this.rightplaymat_face_index + ", leftplaymat_image=" + this.leftplaymat_image + ", leftplaymat_image_type=" + this.leftplaymat_image_type + ", rightplaymat_image=" + this.rightplaymat_image + ", rightplaymat_image_type=" + this.rightplaymat_image_type + ", owner=" + this.owner + ", is_smart_deck=" + this.is_smart_deck + ", has_smart_deck=" + this.has_smart_deck + ")";
    }
}
