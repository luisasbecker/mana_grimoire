package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreferencesManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000+\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b@\n\u0002\u0010\u0007\n\u0003\bü\u0001\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0097\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010G\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010G\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\bQ\u0010RJ\f\u0010ó\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ô\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010õ\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\u0011\u0010ö\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\f\u0010÷\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010ø\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\f\u0010ù\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010ú\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\u0011\u0010û\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\u0011\u0010ü\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\u0011\u0010ý\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\u0011\u0010þ\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\u0011\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\f\u0010\u0080\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0081\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\f\u0010\u0082\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\f\u0010\u0084\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0085\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0086\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0087\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0088\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0089\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008a\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u008b\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\u0011\u0010\u008c\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\f\u0010\u008d\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008e\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u008f\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\u0011\u0010\u0090\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\u0011\u0010\u0091\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\u0011\u0010\u0092\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\u0011\u0010\u0093\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\f\u0010\u0094\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0095\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\f\u0010\u0096\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0097\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\u0011\u0010\u0098\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\u0011\u0010\u0099\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\f\u0010\u009a\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u009b\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\u0011\u0010\u009c\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\f\u0010\u009d\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u009e\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u009f\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\u0011\u0010 \u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\u0011\u0010¡\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\u0011\u0010¢\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\f\u0010£\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¤\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¥\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¦\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010§\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\f\u0010¨\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010©\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ª\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010«\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\f\u0010¬\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u00ad\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010®\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\f\u0010¯\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010°\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\f\u0010±\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010²\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\f\u0010³\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010´\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\u0012\u0010µ\u0002\u001a\u0004\u0018\u00010GHÆ\u0003¢\u0006\u0003\u0010Ý\u0001J\u0011\u0010¶\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\f\u0010·\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010¸\u0002\u001a\u0004\u0018\u00010GHÆ\u0003¢\u0006\u0003\u0010Ý\u0001J\u0011\u0010¹\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\u0011\u0010º\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\u0011\u0010»\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\u0011\u0010¼\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ\f\u0010½\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010¾\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010ZJ \u0007\u0010¿\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010F\u001a\u0004\u0018\u00010G2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010J\u001a\u0004\u0018\u00010G2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0003\u0010À\u0002J\u0015\u0010Á\u0002\u001a\u00020\u00062\t\u0010Â\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000b\u0010Ã\u0002\u001a\u00030Ä\u0002HÖ\u0001J\n\u0010Å\u0002\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010T\"\u0004\bX\u0010VR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010]\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010]\u001a\u0004\b^\u0010Z\"\u0004\b_\u0010\\R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010T\"\u0004\ba\u0010VR\u001e\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010]\u001a\u0004\bb\u0010Z\"\u0004\bc\u0010\\R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010T\"\u0004\be\u0010VR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010]\u001a\u0004\bf\u0010Z\"\u0004\bg\u0010\\R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010]\u001a\u0004\bh\u0010Z\"\u0004\bi\u0010\\R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010]\u001a\u0004\bj\u0010Z\"\u0004\bk\u0010\\R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010]\u001a\u0004\bl\u0010Z\"\u0004\bm\u0010\\R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010]\u001a\u0004\bn\u0010Z\"\u0004\bo\u0010\\R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010]\u001a\u0004\bp\u0010Z\"\u0004\bq\u0010\\R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010T\"\u0004\bs\u0010VR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010]\u001a\u0004\bt\u0010Z\"\u0004\bu\u0010\\R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010T\"\u0004\bw\u0010VR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010]\u001a\u0004\bx\u0010Z\"\u0004\by\u0010\\R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010T\"\u0004\b{\u0010VR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010T\"\u0004\b}\u0010VR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010T\"\u0004\b\u007f\u0010VR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010T\"\u0005\b\u0081\u0001\u0010VR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010T\"\u0005\b\u0083\u0001\u0010VR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010T\"\u0005\b\u0085\u0001\u0010VR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010T\"\u0005\b\u0087\u0001\u0010VR \u0010\u001c\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0012\n\u0002\u0010]\u001a\u0005\b\u0088\u0001\u0010Z\"\u0005\b\u0089\u0001\u0010\\R \u0010\u001d\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0012\n\u0002\u0010]\u001a\u0005\b\u008a\u0001\u0010Z\"\u0005\b\u008b\u0001\u0010\\R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010T\"\u0005\b\u008d\u0001\u0010VR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010T\"\u0005\b\u008f\u0001\u0010VR \u0010 \u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0012\n\u0002\u0010]\u001a\u0005\b\u0090\u0001\u0010Z\"\u0005\b\u0091\u0001\u0010\\R \u0010!\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0012\n\u0002\u0010]\u001a\u0005\b\u0092\u0001\u0010Z\"\u0005\b\u0093\u0001\u0010\\R \u0010\"\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0012\n\u0002\u0010]\u001a\u0005\b\u0094\u0001\u0010Z\"\u0005\b\u0095\u0001\u0010\\R \u0010#\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0012\n\u0002\u0010]\u001a\u0005\b\u0096\u0001\u0010Z\"\u0005\b\u0097\u0001\u0010\\R \u0010$\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0012\n\u0002\u0010]\u001a\u0005\b\u0098\u0001\u0010Z\"\u0005\b\u0099\u0001\u0010\\R\u001e\u0010%\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009a\u0001\u0010T\"\u0005\b\u009b\u0001\u0010VR \u0010&\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0012\n\u0002\u0010]\u001a\u0005\b\u009c\u0001\u0010Z\"\u0005\b\u009d\u0001\u0010\\R\u001e\u0010'\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009e\u0001\u0010T\"\u0005\b\u009f\u0001\u0010VR \u0010(\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0012\n\u0002\u0010]\u001a\u0005\b \u0001\u0010Z\"\u0005\b¡\u0001\u0010\\R \u0010)\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0012\n\u0002\u0010]\u001a\u0005\b¢\u0001\u0010Z\"\u0005\b£\u0001\u0010\\R \u0010*\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0012\n\u0002\u0010]\u001a\u0005\b¤\u0001\u0010Z\"\u0005\b¥\u0001\u0010\\R\u001e\u0010+\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¦\u0001\u0010T\"\u0005\b§\u0001\u0010VR \u0010,\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0012\n\u0002\u0010]\u001a\u0005\b¨\u0001\u0010Z\"\u0005\b©\u0001\u0010\\R \u0010-\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0012\n\u0002\u0010]\u001a\u0005\bª\u0001\u0010Z\"\u0005\b«\u0001\u0010\\R\u001e\u0010.\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¬\u0001\u0010T\"\u0005\b\u00ad\u0001\u0010VR\u001e\u0010/\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b®\u0001\u0010T\"\u0005\b¯\u0001\u0010VR \u00100\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0012\n\u0002\u0010]\u001a\u0005\b°\u0001\u0010Z\"\u0005\b±\u0001\u0010\\R \u00101\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0012\n\u0002\u0010]\u001a\u0005\b²\u0001\u0010Z\"\u0005\b³\u0001\u0010\\R \u00102\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0012\n\u0002\u0010]\u001a\u0005\b´\u0001\u0010Z\"\u0005\bµ\u0001\u0010\\R \u00103\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0012\n\u0002\u0010]\u001a\u0005\b¶\u0001\u0010Z\"\u0005\b·\u0001\u0010\\R\u001e\u00104\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¸\u0001\u0010T\"\u0005\b¹\u0001\u0010VR\u001e\u00105\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bº\u0001\u0010T\"\u0005\b»\u0001\u0010VR\u001e\u00106\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¼\u0001\u0010T\"\u0005\b½\u0001\u0010VR\u001e\u00107\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¾\u0001\u0010T\"\u0005\b¿\u0001\u0010VR \u00108\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0012\n\u0002\u0010]\u001a\u0005\bÀ\u0001\u0010Z\"\u0005\bÁ\u0001\u0010\\R\u001e\u00109\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÂ\u0001\u0010T\"\u0005\bÃ\u0001\u0010VR\u001e\u0010:\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÄ\u0001\u0010T\"\u0005\bÅ\u0001\u0010VR\u001e\u0010;\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÆ\u0001\u0010T\"\u0005\bÇ\u0001\u0010VR \u0010<\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0012\n\u0002\u0010]\u001a\u0005\bÈ\u0001\u0010Z\"\u0005\bÉ\u0001\u0010\\R\u001e\u0010=\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÊ\u0001\u0010T\"\u0005\bË\u0001\u0010VR\u001e\u0010>\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÌ\u0001\u0010T\"\u0005\bÍ\u0001\u0010VR \u0010?\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0012\n\u0002\u0010]\u001a\u0005\bÎ\u0001\u0010Z\"\u0005\bÏ\u0001\u0010\\R\u001e\u0010@\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÐ\u0001\u0010T\"\u0005\bÑ\u0001\u0010VR \u0010A\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0012\n\u0002\u0010]\u001a\u0005\bÒ\u0001\u0010Z\"\u0005\bÓ\u0001\u0010\\R\u001e\u0010B\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÔ\u0001\u0010T\"\u0005\bÕ\u0001\u0010VR \u0010C\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0012\n\u0002\u0010]\u001a\u0005\bÖ\u0001\u0010Z\"\u0005\b×\u0001\u0010\\R\u001e\u0010D\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bØ\u0001\u0010T\"\u0005\bÙ\u0001\u0010VR \u0010E\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0012\n\u0002\u0010]\u001a\u0005\bÚ\u0001\u0010Z\"\u0005\bÛ\u0001\u0010\\R#\u0010F\u001a\u0004\u0018\u00010GX\u0086\u000e¢\u0006\u0015\n\u0003\u0010à\u0001\u001a\u0006\bÜ\u0001\u0010Ý\u0001\"\u0006\bÞ\u0001\u0010ß\u0001R \u0010H\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0012\n\u0002\u0010]\u001a\u0005\bá\u0001\u0010Z\"\u0005\bâ\u0001\u0010\\R\u001e\u0010I\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bã\u0001\u0010T\"\u0005\bä\u0001\u0010VR#\u0010J\u001a\u0004\u0018\u00010GX\u0086\u000e¢\u0006\u0015\n\u0003\u0010à\u0001\u001a\u0006\bå\u0001\u0010Ý\u0001\"\u0006\bæ\u0001\u0010ß\u0001R \u0010K\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0012\n\u0002\u0010]\u001a\u0005\bç\u0001\u0010Z\"\u0005\bè\u0001\u0010\\R \u0010L\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0012\n\u0002\u0010]\u001a\u0005\bé\u0001\u0010Z\"\u0005\bê\u0001\u0010\\R \u0010M\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0012\n\u0002\u0010]\u001a\u0005\bë\u0001\u0010Z\"\u0005\bì\u0001\u0010\\R \u0010N\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0012\n\u0002\u0010]\u001a\u0005\bí\u0001\u0010Z\"\u0005\bî\u0001\u0010\\R\u001e\u0010O\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bï\u0001\u0010T\"\u0005\bð\u0001\u0010VR \u0010P\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0012\n\u0002\u0010]\u001a\u0005\bñ\u0001\u0010Z\"\u0005\bò\u0001\u0010\\¨\u0006Æ\u0002"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTUserSettings;", "", "low_life_anim_default", "", PreferencesManager.LOW_LIFE_THRESHOLD, PreferencesManager.ENABLE_LOW_LIFE_BKG, "", PreferencesManager.ENABLE_LOW_LIFE_ANIM, PreferencesManager.HIGH_CMD_DAMAGE_THRESHOLD, PreferencesManager.ENABLE_HIGH_CMD_DAMAGE_ANIM, PreferencesManager.HIGH_POISON_THRESHOLD, PreferencesManager.ENABLE_HIGH_POISON_ANIM, PreferencesManager.ENABLE_KO_MESSAGES, "enable_cmd_damage_by_default", PreferencesManager.ENABLE_POISON_COUNTERS_BY_DEFAULT, PreferencesManager.ENABLE_COMMANDER_TAX_BY_DEFAULT, PreferencesManager.DISPLAY_GAME_EVENTS, PreferencesManager.BACKGROUND_BY_DEFAULT, PreferencesManager.ENABLE_PLAYER_TOSS, PreferencesManager.GAME_FONT_DEFAULT, PreferencesManager.CONDENSE_SEARCH, PreferencesManager.CURRENT_SEARCH_LANGUAGE, PreferencesManager.SEARCH_LANGUAGE_FILTER, PreferencesManager.CURRENT_SEARCH, PreferencesManager.CURRENT_SET_FILTER, PreferencesManager.PREFERRED_CURRENCY, PreferencesManager.DEFAULT_DRAFT_DURATION, PreferencesManager.DEFAULT_DECK_DURATION, PreferencesManager.GAME_TUTORIAL_SHOWN, PreferencesManager.TRANSLATE_RULINGS, PreferencesManager.SCAN_DISPLAY_LANGUAGE, PreferencesManager.PREFERRED_CARDS_LAYOUT, PreferencesManager.ENABLE_UDED_Q, PreferencesManager.TIMER_HINT_SHOWN, PreferencesManager.BO_HELP_DISMISSED, PreferencesManager.STORE_BANNER_DISMISSED, PreferencesManager.ALWAYS_SHOW_TIMER, PreferencesManager.DEFAULT_TIMER_TIME, PreferencesManager.TIMER_SHOW_SECONDS, PreferencesManager.CREATOR_CODE, PreferencesManager.DISABLE_WIN_LOSE_QUESTIONS, PreferencesManager.DISABLE_WIN_LOSE_ANIMATIONS, PreferencesManager.AUTO_ENABLE_TURN_TIMER, PreferencesManager.TURN_TIMER_DISPLAY, PreferencesManager.ENABLE_FULLSCREEN_MODE, PreferencesManager.ENABLE_BATTERY_SAVING_PROMPTS, PreferencesManager.LAST_RULEBOOK_LANGUAGE, PreferencesManager.LAST_CARD_PICKER_LANGUAGE, PreferencesManager.ENABLE_STREAMING, PreferencesManager.ENABLE_SCAN_BEEPS, PreferencesManager.ENABLE_TIMER_BY_DEFAULT, PreferencesManager.AUTO_START_TIMER, PreferencesManager.APP_LANGUAGE, PreferencesManager.LAST_GROUP_BY, PreferencesManager.LAST_ORDER_BY, PreferencesManager.LAST_ORDER_DIRECTION, PreferencesManager.SAVE_SORTING_GROUPING_SETTINGS, PreferencesManager.LAST_DECK_LIST_GROUP_BY, PreferencesManager.LAST_DECK_LIST_ORDER_BY, PreferencesManager.LAST_DECK_LIST_ORDER_DIRECTION, PreferencesManager.SAVE_DECK_LIST_SORTING_GROUPING_SETTINGS, PreferencesManager.PREFERRED_CURRENCY_V2, PreferencesManager.PREFERRED_MARKET, PreferencesManager.SCAN_OVERRIDE_LANGUAGE_ENABLED, PreferencesManager.SCAN_OVERRIDE_LANGUAGE, PreferencesManager.SCAN_OVERRIDE_SET_ENABLED, PreferencesManager.SCAN_OVERRIDE_SET, PreferencesManager.SCAN_OVERRIDE_FINISH_ENABLED, PreferencesManager.SCAN_OVERRIDE_FINISH, PreferencesManager.SCAN_HIGH_PRICE_BEEP_ENABLED, PreferencesManager.SCAN_HIGH_PRICE_THRESHOLD, "", PreferencesManager.SCAN_PURCHASE_PRICE_ENABLED, PreferencesManager.SCAN_PURCHASE_PRICE_MODE, PreferencesManager.SCAN_PURCHASE_PRICE_FIXED, PreferencesManager.IGNORE_BASIC_LANDS, PreferencesManager.IGNORE_COLLECTION, PreferencesManager.IGNORE_PRINTINGS, PreferencesManager.CLEAR_SCAN_LIST_AFTER_ADD, PreferencesManager.DECK_SORT_ORDER, PreferencesManager.EMAIL_OPT_IN, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)V", "getLow_life_anim_default", "()Ljava/lang/String;", "setLow_life_anim_default", "(Ljava/lang/String;)V", "getLow_life_threshold", "setLow_life_threshold", "getEnable_low_life_bkg", "()Ljava/lang/Boolean;", "setEnable_low_life_bkg", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getEnable_low_life_anim", "setEnable_low_life_anim", "getHigh_cmd_damage_threshold", "setHigh_cmd_damage_threshold", "getEnable_high_cmd_damage_anim", "setEnable_high_cmd_damage_anim", "getHigh_poison_threshold", "setHigh_poison_threshold", "getEnable_high_poison_counters_anim", "setEnable_high_poison_counters_anim", "getEnable_ko_messages", "setEnable_ko_messages", "getEnable_cmd_damage_by_default", "setEnable_cmd_damage_by_default", "getEnable_poison_counters_by_default", "setEnable_poison_counters_by_default", "getEnable_commander_tax_by_default", "setEnable_commander_tax_by_default", "getDisplay_game_events", "setDisplay_game_events", "getDefault_background", "setDefault_background", "getEnable_player_toss", "setEnable_player_toss", "getGame_font_default", "setGame_font_default", "getCondense_search", "setCondense_search", "getCurrent_search_language", "setCurrent_search_language", "getSearch_language_filter", "setSearch_language_filter", "getCurrent_search", "setCurrent_search", "getCurrent_set_filter", "setCurrent_set_filter", "getPreferred_currency", "setPreferred_currency", "getDefault_draft_duration", "setDefault_draft_duration", "getDefault_deck_duration", "setDefault_deck_duration", "getGame_tutorial_shown", "setGame_tutorial_shown", "getTranslate_rulings", "setTranslate_rulings", "getScan_display_language", "setScan_display_language", "getPreferred_card_layout", "setPreferred_card_layout", "getEnable_uded_q", "setEnable_uded_q", "getTimer_hint_shown", "setTimer_hint_shown", "getBo_help_dismissed", "setBo_help_dismissed", "getStore_banner_dismissed", "setStore_banner_dismissed", "getAlways_show_timer", "setAlways_show_timer", "getDefault_timer_time", "setDefault_timer_time", "getTimer_show_seconds", "setTimer_show_seconds", "getCreator_code", "setCreator_code", "getDisable_win_lose_questions", "setDisable_win_lose_questions", "getDisable_win_lose_animations", "setDisable_win_lose_animations", "getAuto_enable_turn_timer", "setAuto_enable_turn_timer", "getTurn_timer_display", "setTurn_timer_display", "getEnable_fullscreen_mode", "setEnable_fullscreen_mode", "getEnable_battery_saving_prompts", "setEnable_battery_saving_prompts", "getLast_rulebook_language", "setLast_rulebook_language", "getLast_card_picker_language", "setLast_card_picker_language", "getEnable_streaming", "setEnable_streaming", "getEnable_scan_beeps", "setEnable_scan_beeps", "getEnable_timer_by_default", "setEnable_timer_by_default", "getAuto_start_timer", "setAuto_start_timer", "getApp_language", "setApp_language", "getLast_group_by", "setLast_group_by", "getLast_order_by", "setLast_order_by", "getLast_order_direction", "setLast_order_direction", "getSave_sorting_grouping_settings", "setSave_sorting_grouping_settings", "getLast_deck_list_group_by", "setLast_deck_list_group_by", "getLast_deck_list_order_by", "setLast_deck_list_order_by", "getLast_deck_list_order_direction", "setLast_deck_list_order_direction", "getSave_deck_list_sorting_grouping_settings", "setSave_deck_list_sorting_grouping_settings", "getPreferred_currency_v2", "setPreferred_currency_v2", "getPreferred_market", "setPreferred_market", "getScan_override_language_enabled", "setScan_override_language_enabled", "getScan_override_language", "setScan_override_language", "getScan_override_set_enabled", "setScan_override_set_enabled", "getScan_override_set", "setScan_override_set", "getScan_override_finish_enabled", "setScan_override_finish_enabled", "getScan_override_finish", "setScan_override_finish", "getScan_high_price_beep_enabled", "setScan_high_price_beep_enabled", "getScan_high_price_threshold", "()Ljava/lang/Float;", "setScan_high_price_threshold", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getScan_purchase_price_enabled", "setScan_purchase_price_enabled", "getScan_purchase_price_mode", "setScan_purchase_price_mode", "getScan_purchase_price_fixed", "setScan_purchase_price_fixed", "getIgnore_basic_lands", "setIgnore_basic_lands", "getIgnore_collection", "setIgnore_collection", "getIgnore_printings", "setIgnore_printings", "getClear_scan_list_after_add", "setClear_scan_list_after_add", "getDeck_sort_order", "setDeck_sort_order", "getEmail_opt_in", "setEmail_opt_in", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", "component69", "component70", "component71", "component72", "component73", "component74", "component75", "component76", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/studiolaganne/lengendarylens/MTUserSettings;", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTUserSettings {
    public static final int $stable = 8;
    private Boolean always_show_timer;
    private String app_language;
    private Boolean auto_enable_turn_timer;
    private Boolean auto_start_timer;
    private Boolean bo_help_dismissed;
    private Boolean clear_scan_list_after_add;
    private Boolean condense_search;
    private String creator_code;
    private String current_search;
    private String current_search_language;
    private String current_set_filter;
    private String deck_sort_order;
    private String default_background;
    private String default_deck_duration;
    private String default_draft_duration;
    private String default_timer_time;
    private Boolean disable_win_lose_animations;
    private Boolean disable_win_lose_questions;
    private Boolean display_game_events;
    private Boolean email_opt_in;
    private Boolean enable_battery_saving_prompts;
    private Boolean enable_cmd_damage_by_default;
    private Boolean enable_commander_tax_by_default;
    private Boolean enable_fullscreen_mode;
    private Boolean enable_high_cmd_damage_anim;
    private Boolean enable_high_poison_counters_anim;
    private Boolean enable_ko_messages;
    private Boolean enable_low_life_anim;
    private Boolean enable_low_life_bkg;
    private Boolean enable_player_toss;
    private Boolean enable_poison_counters_by_default;
    private Boolean enable_scan_beeps;
    private Boolean enable_streaming;
    private Boolean enable_timer_by_default;
    private Boolean enable_uded_q;
    private String game_font_default;
    private Boolean game_tutorial_shown;
    private String high_cmd_damage_threshold;
    private String high_poison_threshold;
    private Boolean ignore_basic_lands;
    private Boolean ignore_collection;
    private Boolean ignore_printings;
    private String last_card_picker_language;
    private String last_deck_list_group_by;
    private String last_deck_list_order_by;
    private String last_deck_list_order_direction;
    private String last_group_by;
    private String last_order_by;
    private String last_order_direction;
    private String last_rulebook_language;
    private String low_life_anim_default;
    private String low_life_threshold;
    private String preferred_card_layout;
    private String preferred_currency;
    private String preferred_currency_v2;
    private String preferred_market;
    private Boolean save_deck_list_sorting_grouping_settings;
    private Boolean save_sorting_grouping_settings;
    private String scan_display_language;
    private Boolean scan_high_price_beep_enabled;
    private Float scan_high_price_threshold;
    private String scan_override_finish;
    private Boolean scan_override_finish_enabled;
    private String scan_override_language;
    private Boolean scan_override_language_enabled;
    private String scan_override_set;
    private Boolean scan_override_set_enabled;
    private Boolean scan_purchase_price_enabled;
    private Float scan_purchase_price_fixed;
    private String scan_purchase_price_mode;
    private String search_language_filter;
    private Boolean store_banner_dismissed;
    private Boolean timer_hint_shown;
    private Boolean timer_show_seconds;
    private Boolean translate_rulings;
    private String turn_timer_display;

    public MTUserSettings() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 4095, null);
    }

    public MTUserSettings(String str, String str2, Boolean bool, Boolean bool2, String str3, Boolean bool3, String str4, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, String str5, Boolean bool10, String str6, Boolean bool11, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Boolean bool12, Boolean bool13, String str14, String str15, Boolean bool14, Boolean bool15, Boolean bool16, Boolean bool17, Boolean bool18, String str16, Boolean bool19, String str17, Boolean bool20, Boolean bool21, Boolean bool22, String str18, Boolean bool23, Boolean bool24, String str19, String str20, Boolean bool25, Boolean bool26, Boolean bool27, Boolean bool28, String str21, String str22, String str23, String str24, Boolean bool29, String str25, String str26, String str27, Boolean bool30, String str28, String str29, Boolean bool31, String str30, Boolean bool32, String str31, Boolean bool33, String str32, Boolean bool34, Float f, Boolean bool35, String str33, Float f2, Boolean bool36, Boolean bool37, Boolean bool38, Boolean bool39, String str34, Boolean bool40) {
        this.low_life_anim_default = str;
        this.low_life_threshold = str2;
        this.enable_low_life_bkg = bool;
        this.enable_low_life_anim = bool2;
        this.high_cmd_damage_threshold = str3;
        this.enable_high_cmd_damage_anim = bool3;
        this.high_poison_threshold = str4;
        this.enable_high_poison_counters_anim = bool4;
        this.enable_ko_messages = bool5;
        this.enable_cmd_damage_by_default = bool6;
        this.enable_poison_counters_by_default = bool7;
        this.enable_commander_tax_by_default = bool8;
        this.display_game_events = bool9;
        this.default_background = str5;
        this.enable_player_toss = bool10;
        this.game_font_default = str6;
        this.condense_search = bool11;
        this.current_search_language = str7;
        this.search_language_filter = str8;
        this.current_search = str9;
        this.current_set_filter = str10;
        this.preferred_currency = str11;
        this.default_draft_duration = str12;
        this.default_deck_duration = str13;
        this.game_tutorial_shown = bool12;
        this.translate_rulings = bool13;
        this.scan_display_language = str14;
        this.preferred_card_layout = str15;
        this.enable_uded_q = bool14;
        this.timer_hint_shown = bool15;
        this.bo_help_dismissed = bool16;
        this.store_banner_dismissed = bool17;
        this.always_show_timer = bool18;
        this.default_timer_time = str16;
        this.timer_show_seconds = bool19;
        this.creator_code = str17;
        this.disable_win_lose_questions = bool20;
        this.disable_win_lose_animations = bool21;
        this.auto_enable_turn_timer = bool22;
        this.turn_timer_display = str18;
        this.enable_fullscreen_mode = bool23;
        this.enable_battery_saving_prompts = bool24;
        this.last_rulebook_language = str19;
        this.last_card_picker_language = str20;
        this.enable_streaming = bool25;
        this.enable_scan_beeps = bool26;
        this.enable_timer_by_default = bool27;
        this.auto_start_timer = bool28;
        this.app_language = str21;
        this.last_group_by = str22;
        this.last_order_by = str23;
        this.last_order_direction = str24;
        this.save_sorting_grouping_settings = bool29;
        this.last_deck_list_group_by = str25;
        this.last_deck_list_order_by = str26;
        this.last_deck_list_order_direction = str27;
        this.save_deck_list_sorting_grouping_settings = bool30;
        this.preferred_currency_v2 = str28;
        this.preferred_market = str29;
        this.scan_override_language_enabled = bool31;
        this.scan_override_language = str30;
        this.scan_override_set_enabled = bool32;
        this.scan_override_set = str31;
        this.scan_override_finish_enabled = bool33;
        this.scan_override_finish = str32;
        this.scan_high_price_beep_enabled = bool34;
        this.scan_high_price_threshold = f;
        this.scan_purchase_price_enabled = bool35;
        this.scan_purchase_price_mode = str33;
        this.scan_purchase_price_fixed = f2;
        this.ignore_basic_lands = bool36;
        this.ignore_collection = bool37;
        this.ignore_printings = bool38;
        this.clear_scan_list_after_add = bool39;
        this.deck_sort_order = str34;
        this.email_opt_in = bool40;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ MTUserSettings(String str, String str2, Boolean bool, Boolean bool2, String str3, Boolean bool3, String str4, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, String str5, Boolean bool10, String str6, Boolean bool11, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Boolean bool12, Boolean bool13, String str14, String str15, Boolean bool14, Boolean bool15, Boolean bool16, Boolean bool17, Boolean bool18, String str16, Boolean bool19, String str17, Boolean bool20, Boolean bool21, Boolean bool22, String str18, Boolean bool23, Boolean bool24, String str19, String str20, Boolean bool25, Boolean bool26, Boolean bool27, Boolean bool28, String str21, String str22, String str23, String str24, Boolean bool29, String str25, String str26, String str27, Boolean bool30, String str28, String str29, Boolean bool31, String str30, Boolean bool32, String str31, Boolean bool33, String str32, Boolean bool34, Float f, Boolean bool35, String str33, Float f2, Boolean bool36, Boolean bool37, Boolean bool38, Boolean bool39, String str34, Boolean bool40, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        String str35 = (i & 1) != 0 ? "RANDOM" : str;
        String str36 = (i & 2) != 0 ? "10" : str2;
        Boolean bool41 = (i & 4) != 0 ? true : bool;
        Boolean bool42 = (i & 8) != 0 ? true : bool2;
        String str37 = (i & 16) != 0 ? "15" : str3;
        Boolean bool43 = (i & 32) != 0 ? true : bool3;
        String str38 = (i & 64) != 0 ? "8" : str4;
        Boolean bool44 = (i & 128) != 0 ? true : bool4;
        Boolean bool45 = (i & 256) != 0 ? true : bool5;
        Boolean bool46 = (i & 512) != 0 ? true : bool6;
        Boolean bool47 = (i & 1024) != 0 ? false : bool7;
        Boolean bool48 = (i & 2048) != 0 ? false : bool8;
        Boolean bool49 = (i & 4096) != 0 ? true : bool9;
        String str39 = str35;
        String str40 = (i & 8192) != 0 ? PreferencesManager.BACKGROUND_PLAYMAT : str5;
        Boolean bool50 = (i & 16384) != 0 ? true : bool10;
        String str41 = (i & 32768) != 0 ? "big_shoulders_semibold" : str6;
        Boolean bool51 = (i & 65536) != 0 ? false : bool11;
        String str42 = (i & 131072) != 0 ? "en" : str7;
        String str43 = (i & 262144) != 0 ? "" : str8;
        String str44 = (i & 524288) != 0 ? "" : str9;
        String str45 = (i & 1048576) != 0 ? "" : str10;
        String str46 = (i & 2097152) != 0 ? "USD" : str11;
        String str47 = (i & 4194304) != 0 ? "45" : str12;
        String str48 = (i & 8388608) != 0 ? "45" : str13;
        Boolean bool52 = (i & 16777216) != 0 ? false : bool12;
        Boolean bool53 = (i & 33554432) != 0 ? false : bool13;
        String str49 = (i & 67108864) != 0 ? "TRANSLATED" : str14;
        String str50 = (i & 134217728) != 0 ? "GRID_2" : str15;
        Boolean bool54 = (i & 268435456) != 0 ? true : bool14;
        Boolean bool55 = (i & 536870912) != 0 ? false : bool15;
        Boolean bool56 = (i & 1073741824) != 0 ? false : bool16;
        Boolean bool57 = (i & Integer.MIN_VALUE) != 0 ? false : bool17;
        Boolean bool58 = (i2 & 1) != 0 ? true : bool18;
        String str51 = (i2 & 2) != 0 ? "90" : str16;
        Boolean bool59 = (i2 & 4) != 0 ? false : bool19;
        String str52 = (i2 & 8) != 0 ? "" : str17;
        Boolean bool60 = (i2 & 16) != 0 ? false : bool20;
        Boolean bool61 = (i2 & 32) != 0 ? false : bool21;
        Boolean bool62 = (i2 & 64) != 0 ? false : bool22;
        Boolean bool63 = bool57;
        String str53 = (i2 & 128) != 0 ? PreferencesManager.TURN_TIMER_DISPLAY_CURRENT : str18;
        Boolean bool64 = (i2 & 256) != 0 ? true : bool23;
        Boolean bool65 = (i2 & 512) != 0 ? true : bool24;
        String str54 = (i2 & 1024) != 0 ? "" : str19;
        String str55 = (i2 & 2048) != 0 ? "" : str20;
        Boolean bool66 = (i2 & 4096) != 0 ? false : bool25;
        Boolean bool67 = (i2 & 8192) != 0 ? true : bool26;
        Boolean bool68 = (i2 & 16384) != 0 ? true : bool27;
        Boolean bool69 = (i2 & 32768) != 0 ? true : bool28;
        String str56 = (i2 & 65536) != 0 ? AndroidContextPlugin.DEVICE_KEY : str21;
        String str57 = (i2 & 131072) != 0 ? null : str22;
        String str58 = (i2 & 262144) != 0 ? null : str23;
        String str59 = (i2 & 524288) != 0 ? null : str24;
        Boolean bool70 = (i2 & 1048576) != 0 ? true : bool29;
        String str60 = (i2 & 2097152) != 0 ? null : str25;
        String str61 = (i2 & 4194304) != 0 ? null : str26;
        String str62 = (i2 & 8388608) != 0 ? null : str27;
        Boolean bool71 = (i2 & 16777216) != 0 ? true : bool30;
        String str63 = (i2 & 33554432) != 0 ? null : str28;
        String str64 = (i2 & 67108864) != 0 ? null : str29;
        Boolean bool72 = (i2 & 134217728) != 0 ? false : bool31;
        String str65 = (i2 & 268435456) != 0 ? "en" : str30;
        Boolean bool73 = (i2 & 536870912) != 0 ? false : bool32;
        String str66 = (i2 & 1073741824) == 0 ? str31 : "";
        Boolean bool74 = bool42;
        String str67 = str37;
        Boolean bool75 = bool43;
        String str68 = str38;
        Boolean bool76 = bool44;
        Boolean bool77 = bool45;
        Boolean bool78 = bool46;
        Boolean bool79 = bool47;
        this(str39, str36, bool41, bool74, str67, bool75, str68, bool76, bool77, bool78, bool79, bool48, bool49, str40, bool50, str41, bool51, str42, str43, str44, str45, str46, str47, str48, bool52, bool53, str49, str50, bool54, bool55, bool56, bool63, bool58, str51, bool59, str52, bool60, bool61, bool62, str53, bool64, bool65, str54, str55, bool66, bool67, bool68, bool69, str56, str57, str58, str59, bool70, str60, str61, str62, bool71, str63, str64, bool72, str65, bool73, str66, (i2 & Integer.MIN_VALUE) != 0 ? false : bool33, (i3 & 1) != 0 ? "nonfoil" : str32, (i3 & 2) != 0 ? false : bool34, (i3 & 4) != 0 ? Float.valueOf(2.0f) : f, (i3 & 8) != 0 ? false : bool35, (i3 & 16) != 0 ? "current" : str33, (i3 & 32) != 0 ? Float.valueOf(0.0f) : f2, (i3 & 64) != 0 ? true : bool36, (i3 & 128) != 0 ? false : bool37, (i3 & 256) != 0 ? false : bool38, (i3 & 512) != 0 ? false : bool39, (i3 & 1024) != 0 ? "UPDATED_AT" : str34, (i3 & 2048) != 0 ? null : bool40);
    }

    public static /* synthetic */ MTUserSettings copy$default(MTUserSettings mTUserSettings, String str, String str2, Boolean bool, Boolean bool2, String str3, Boolean bool3, String str4, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, String str5, Boolean bool10, String str6, Boolean bool11, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Boolean bool12, Boolean bool13, String str14, String str15, Boolean bool14, Boolean bool15, Boolean bool16, Boolean bool17, Boolean bool18, String str16, Boolean bool19, String str17, Boolean bool20, Boolean bool21, Boolean bool22, String str18, Boolean bool23, Boolean bool24, String str19, String str20, Boolean bool25, Boolean bool26, Boolean bool27, Boolean bool28, String str21, String str22, String str23, String str24, Boolean bool29, String str25, String str26, String str27, Boolean bool30, String str28, String str29, Boolean bool31, String str30, Boolean bool32, String str31, Boolean bool33, String str32, Boolean bool34, Float f, Boolean bool35, String str33, Float f2, Boolean bool36, Boolean bool37, Boolean bool38, Boolean bool39, String str34, Boolean bool40, int i, int i2, int i3, Object obj) {
        String str35 = (i & 1) != 0 ? mTUserSettings.low_life_anim_default : str;
        String str36 = (i & 2) != 0 ? mTUserSettings.low_life_threshold : str2;
        Boolean bool41 = (i & 4) != 0 ? mTUserSettings.enable_low_life_bkg : bool;
        Boolean bool42 = (i & 8) != 0 ? mTUserSettings.enable_low_life_anim : bool2;
        String str37 = (i & 16) != 0 ? mTUserSettings.high_cmd_damage_threshold : str3;
        Boolean bool43 = (i & 32) != 0 ? mTUserSettings.enable_high_cmd_damage_anim : bool3;
        String str38 = (i & 64) != 0 ? mTUserSettings.high_poison_threshold : str4;
        Boolean bool44 = (i & 128) != 0 ? mTUserSettings.enable_high_poison_counters_anim : bool4;
        Boolean bool45 = (i & 256) != 0 ? mTUserSettings.enable_ko_messages : bool5;
        Boolean bool46 = (i & 512) != 0 ? mTUserSettings.enable_cmd_damage_by_default : bool6;
        Boolean bool47 = (i & 1024) != 0 ? mTUserSettings.enable_poison_counters_by_default : bool7;
        Boolean bool48 = (i & 2048) != 0 ? mTUserSettings.enable_commander_tax_by_default : bool8;
        String str39 = str35;
        Boolean bool49 = (i & 4096) != 0 ? mTUserSettings.display_game_events : bool9;
        String str40 = (i & 8192) != 0 ? mTUserSettings.default_background : str5;
        Boolean bool50 = (i & 16384) != 0 ? mTUserSettings.enable_player_toss : bool10;
        String str41 = (i & 32768) != 0 ? mTUserSettings.game_font_default : str6;
        Boolean bool51 = (i & 65536) != 0 ? mTUserSettings.condense_search : bool11;
        String str42 = (i & 131072) != 0 ? mTUserSettings.current_search_language : str7;
        String str43 = (i & 262144) != 0 ? mTUserSettings.search_language_filter : str8;
        String str44 = (i & 524288) != 0 ? mTUserSettings.current_search : str9;
        String str45 = (i & 1048576) != 0 ? mTUserSettings.current_set_filter : str10;
        String str46 = (i & 2097152) != 0 ? mTUserSettings.preferred_currency : str11;
        String str47 = (i & 4194304) != 0 ? mTUserSettings.default_draft_duration : str12;
        String str48 = (i & 8388608) != 0 ? mTUserSettings.default_deck_duration : str13;
        Boolean bool52 = (i & 16777216) != 0 ? mTUserSettings.game_tutorial_shown : bool12;
        Boolean bool53 = (i & 33554432) != 0 ? mTUserSettings.translate_rulings : bool13;
        String str49 = (i & 67108864) != 0 ? mTUserSettings.scan_display_language : str14;
        String str50 = (i & 134217728) != 0 ? mTUserSettings.preferred_card_layout : str15;
        Boolean bool54 = (i & 268435456) != 0 ? mTUserSettings.enable_uded_q : bool14;
        Boolean bool55 = (i & 536870912) != 0 ? mTUserSettings.timer_hint_shown : bool15;
        Boolean bool56 = (i & 1073741824) != 0 ? mTUserSettings.bo_help_dismissed : bool16;
        Boolean bool57 = (i & Integer.MIN_VALUE) != 0 ? mTUserSettings.store_banner_dismissed : bool17;
        Boolean bool58 = (i2 & 1) != 0 ? mTUserSettings.always_show_timer : bool18;
        String str51 = (i2 & 2) != 0 ? mTUserSettings.default_timer_time : str16;
        Boolean bool59 = (i2 & 4) != 0 ? mTUserSettings.timer_show_seconds : bool19;
        String str52 = (i2 & 8) != 0 ? mTUserSettings.creator_code : str17;
        Boolean bool60 = (i2 & 16) != 0 ? mTUserSettings.disable_win_lose_questions : bool20;
        Boolean bool61 = (i2 & 32) != 0 ? mTUserSettings.disable_win_lose_animations : bool21;
        Boolean bool62 = (i2 & 64) != 0 ? mTUserSettings.auto_enable_turn_timer : bool22;
        String str53 = (i2 & 128) != 0 ? mTUserSettings.turn_timer_display : str18;
        Boolean bool63 = (i2 & 256) != 0 ? mTUserSettings.enable_fullscreen_mode : bool23;
        Boolean bool64 = (i2 & 512) != 0 ? mTUserSettings.enable_battery_saving_prompts : bool24;
        String str54 = (i2 & 1024) != 0 ? mTUserSettings.last_rulebook_language : str19;
        String str55 = (i2 & 2048) != 0 ? mTUserSettings.last_card_picker_language : str20;
        Boolean bool65 = (i2 & 4096) != 0 ? mTUserSettings.enable_streaming : bool25;
        Boolean bool66 = (i2 & 8192) != 0 ? mTUserSettings.enable_scan_beeps : bool26;
        Boolean bool67 = (i2 & 16384) != 0 ? mTUserSettings.enable_timer_by_default : bool27;
        Boolean bool68 = (i2 & 32768) != 0 ? mTUserSettings.auto_start_timer : bool28;
        String str56 = (i2 & 65536) != 0 ? mTUserSettings.app_language : str21;
        String str57 = (i2 & 131072) != 0 ? mTUserSettings.last_group_by : str22;
        String str58 = (i2 & 262144) != 0 ? mTUserSettings.last_order_by : str23;
        String str59 = (i2 & 524288) != 0 ? mTUserSettings.last_order_direction : str24;
        Boolean bool69 = (i2 & 1048576) != 0 ? mTUserSettings.save_sorting_grouping_settings : bool29;
        String str60 = (i2 & 2097152) != 0 ? mTUserSettings.last_deck_list_group_by : str25;
        String str61 = (i2 & 4194304) != 0 ? mTUserSettings.last_deck_list_order_by : str26;
        String str62 = (i2 & 8388608) != 0 ? mTUserSettings.last_deck_list_order_direction : str27;
        Boolean bool70 = (i2 & 16777216) != 0 ? mTUserSettings.save_deck_list_sorting_grouping_settings : bool30;
        String str63 = (i2 & 33554432) != 0 ? mTUserSettings.preferred_currency_v2 : str28;
        String str64 = (i2 & 67108864) != 0 ? mTUserSettings.preferred_market : str29;
        Boolean bool71 = (i2 & 134217728) != 0 ? mTUserSettings.scan_override_language_enabled : bool31;
        String str65 = (i2 & 268435456) != 0 ? mTUserSettings.scan_override_language : str30;
        Boolean bool72 = (i2 & 536870912) != 0 ? mTUserSettings.scan_override_set_enabled : bool32;
        String str66 = (i2 & 1073741824) != 0 ? mTUserSettings.scan_override_set : str31;
        return mTUserSettings.copy(str39, str36, bool41, bool42, str37, bool43, str38, bool44, bool45, bool46, bool47, bool48, bool49, str40, bool50, str41, bool51, str42, str43, str44, str45, str46, str47, str48, bool52, bool53, str49, str50, bool54, bool55, bool56, bool57, bool58, str51, bool59, str52, bool60, bool61, bool62, str53, bool63, bool64, str54, str55, bool65, bool66, bool67, bool68, str56, str57, str58, str59, bool69, str60, str61, str62, bool70, str63, str64, bool71, str65, bool72, str66, (i2 & Integer.MIN_VALUE) != 0 ? mTUserSettings.scan_override_finish_enabled : bool33, (i3 & 1) != 0 ? mTUserSettings.scan_override_finish : str32, (i3 & 2) != 0 ? mTUserSettings.scan_high_price_beep_enabled : bool34, (i3 & 4) != 0 ? mTUserSettings.scan_high_price_threshold : f, (i3 & 8) != 0 ? mTUserSettings.scan_purchase_price_enabled : bool35, (i3 & 16) != 0 ? mTUserSettings.scan_purchase_price_mode : str33, (i3 & 32) != 0 ? mTUserSettings.scan_purchase_price_fixed : f2, (i3 & 64) != 0 ? mTUserSettings.ignore_basic_lands : bool36, (i3 & 128) != 0 ? mTUserSettings.ignore_collection : bool37, (i3 & 256) != 0 ? mTUserSettings.ignore_printings : bool38, (i3 & 512) != 0 ? mTUserSettings.clear_scan_list_after_add : bool39, (i3 & 1024) != 0 ? mTUserSettings.deck_sort_order : str34, (i3 & 2048) != 0 ? mTUserSettings.email_opt_in : bool40);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLow_life_anim_default() {
        return this.low_life_anim_default;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Boolean getEnable_cmd_damage_by_default() {
        return this.enable_cmd_damage_by_default;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Boolean getEnable_poison_counters_by_default() {
        return this.enable_poison_counters_by_default;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Boolean getEnable_commander_tax_by_default() {
        return this.enable_commander_tax_by_default;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Boolean getDisplay_game_events() {
        return this.display_game_events;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getDefault_background() {
        return this.default_background;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Boolean getEnable_player_toss() {
        return this.enable_player_toss;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getGame_font_default() {
        return this.game_font_default;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Boolean getCondense_search() {
        return this.condense_search;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getCurrent_search_language() {
        return this.current_search_language;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getSearch_language_filter() {
        return this.search_language_filter;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLow_life_threshold() {
        return this.low_life_threshold;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getCurrent_search() {
        return this.current_search;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getCurrent_set_filter() {
        return this.current_set_filter;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getPreferred_currency() {
        return this.preferred_currency;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getDefault_draft_duration() {
        return this.default_draft_duration;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final String getDefault_deck_duration() {
        return this.default_deck_duration;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final Boolean getGame_tutorial_shown() {
        return this.game_tutorial_shown;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final Boolean getTranslate_rulings() {
        return this.translate_rulings;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final String getScan_display_language() {
        return this.scan_display_language;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final String getPreferred_card_layout() {
        return this.preferred_card_layout;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final Boolean getEnable_uded_q() {
        return this.enable_uded_q;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getEnable_low_life_bkg() {
        return this.enable_low_life_bkg;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final Boolean getTimer_hint_shown() {
        return this.timer_hint_shown;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final Boolean getBo_help_dismissed() {
        return this.bo_help_dismissed;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final Boolean getStore_banner_dismissed() {
        return this.store_banner_dismissed;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final Boolean getAlways_show_timer() {
        return this.always_show_timer;
    }

    /* JADX INFO: renamed from: component34, reason: from getter */
    public final String getDefault_timer_time() {
        return this.default_timer_time;
    }

    /* JADX INFO: renamed from: component35, reason: from getter */
    public final Boolean getTimer_show_seconds() {
        return this.timer_show_seconds;
    }

    /* JADX INFO: renamed from: component36, reason: from getter */
    public final String getCreator_code() {
        return this.creator_code;
    }

    /* JADX INFO: renamed from: component37, reason: from getter */
    public final Boolean getDisable_win_lose_questions() {
        return this.disable_win_lose_questions;
    }

    /* JADX INFO: renamed from: component38, reason: from getter */
    public final Boolean getDisable_win_lose_animations() {
        return this.disable_win_lose_animations;
    }

    /* JADX INFO: renamed from: component39, reason: from getter */
    public final Boolean getAuto_enable_turn_timer() {
        return this.auto_enable_turn_timer;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getEnable_low_life_anim() {
        return this.enable_low_life_anim;
    }

    /* JADX INFO: renamed from: component40, reason: from getter */
    public final String getTurn_timer_display() {
        return this.turn_timer_display;
    }

    /* JADX INFO: renamed from: component41, reason: from getter */
    public final Boolean getEnable_fullscreen_mode() {
        return this.enable_fullscreen_mode;
    }

    /* JADX INFO: renamed from: component42, reason: from getter */
    public final Boolean getEnable_battery_saving_prompts() {
        return this.enable_battery_saving_prompts;
    }

    /* JADX INFO: renamed from: component43, reason: from getter */
    public final String getLast_rulebook_language() {
        return this.last_rulebook_language;
    }

    /* JADX INFO: renamed from: component44, reason: from getter */
    public final String getLast_card_picker_language() {
        return this.last_card_picker_language;
    }

    /* JADX INFO: renamed from: component45, reason: from getter */
    public final Boolean getEnable_streaming() {
        return this.enable_streaming;
    }

    /* JADX INFO: renamed from: component46, reason: from getter */
    public final Boolean getEnable_scan_beeps() {
        return this.enable_scan_beeps;
    }

    /* JADX INFO: renamed from: component47, reason: from getter */
    public final Boolean getEnable_timer_by_default() {
        return this.enable_timer_by_default;
    }

    /* JADX INFO: renamed from: component48, reason: from getter */
    public final Boolean getAuto_start_timer() {
        return this.auto_start_timer;
    }

    /* JADX INFO: renamed from: component49, reason: from getter */
    public final String getApp_language() {
        return this.app_language;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getHigh_cmd_damage_threshold() {
        return this.high_cmd_damage_threshold;
    }

    /* JADX INFO: renamed from: component50, reason: from getter */
    public final String getLast_group_by() {
        return this.last_group_by;
    }

    /* JADX INFO: renamed from: component51, reason: from getter */
    public final String getLast_order_by() {
        return this.last_order_by;
    }

    /* JADX INFO: renamed from: component52, reason: from getter */
    public final String getLast_order_direction() {
        return this.last_order_direction;
    }

    /* JADX INFO: renamed from: component53, reason: from getter */
    public final Boolean getSave_sorting_grouping_settings() {
        return this.save_sorting_grouping_settings;
    }

    /* JADX INFO: renamed from: component54, reason: from getter */
    public final String getLast_deck_list_group_by() {
        return this.last_deck_list_group_by;
    }

    /* JADX INFO: renamed from: component55, reason: from getter */
    public final String getLast_deck_list_order_by() {
        return this.last_deck_list_order_by;
    }

    /* JADX INFO: renamed from: component56, reason: from getter */
    public final String getLast_deck_list_order_direction() {
        return this.last_deck_list_order_direction;
    }

    /* JADX INFO: renamed from: component57, reason: from getter */
    public final Boolean getSave_deck_list_sorting_grouping_settings() {
        return this.save_deck_list_sorting_grouping_settings;
    }

    /* JADX INFO: renamed from: component58, reason: from getter */
    public final String getPreferred_currency_v2() {
        return this.preferred_currency_v2;
    }

    /* JADX INFO: renamed from: component59, reason: from getter */
    public final String getPreferred_market() {
        return this.preferred_market;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Boolean getEnable_high_cmd_damage_anim() {
        return this.enable_high_cmd_damage_anim;
    }

    /* JADX INFO: renamed from: component60, reason: from getter */
    public final Boolean getScan_override_language_enabled() {
        return this.scan_override_language_enabled;
    }

    /* JADX INFO: renamed from: component61, reason: from getter */
    public final String getScan_override_language() {
        return this.scan_override_language;
    }

    /* JADX INFO: renamed from: component62, reason: from getter */
    public final Boolean getScan_override_set_enabled() {
        return this.scan_override_set_enabled;
    }

    /* JADX INFO: renamed from: component63, reason: from getter */
    public final String getScan_override_set() {
        return this.scan_override_set;
    }

    /* JADX INFO: renamed from: component64, reason: from getter */
    public final Boolean getScan_override_finish_enabled() {
        return this.scan_override_finish_enabled;
    }

    /* JADX INFO: renamed from: component65, reason: from getter */
    public final String getScan_override_finish() {
        return this.scan_override_finish;
    }

    /* JADX INFO: renamed from: component66, reason: from getter */
    public final Boolean getScan_high_price_beep_enabled() {
        return this.scan_high_price_beep_enabled;
    }

    /* JADX INFO: renamed from: component67, reason: from getter */
    public final Float getScan_high_price_threshold() {
        return this.scan_high_price_threshold;
    }

    /* JADX INFO: renamed from: component68, reason: from getter */
    public final Boolean getScan_purchase_price_enabled() {
        return this.scan_purchase_price_enabled;
    }

    /* JADX INFO: renamed from: component69, reason: from getter */
    public final String getScan_purchase_price_mode() {
        return this.scan_purchase_price_mode;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getHigh_poison_threshold() {
        return this.high_poison_threshold;
    }

    /* JADX INFO: renamed from: component70, reason: from getter */
    public final Float getScan_purchase_price_fixed() {
        return this.scan_purchase_price_fixed;
    }

    /* JADX INFO: renamed from: component71, reason: from getter */
    public final Boolean getIgnore_basic_lands() {
        return this.ignore_basic_lands;
    }

    /* JADX INFO: renamed from: component72, reason: from getter */
    public final Boolean getIgnore_collection() {
        return this.ignore_collection;
    }

    /* JADX INFO: renamed from: component73, reason: from getter */
    public final Boolean getIgnore_printings() {
        return this.ignore_printings;
    }

    /* JADX INFO: renamed from: component74, reason: from getter */
    public final Boolean getClear_scan_list_after_add() {
        return this.clear_scan_list_after_add;
    }

    /* JADX INFO: renamed from: component75, reason: from getter */
    public final String getDeck_sort_order() {
        return this.deck_sort_order;
    }

    /* JADX INFO: renamed from: component76, reason: from getter */
    public final Boolean getEmail_opt_in() {
        return this.email_opt_in;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Boolean getEnable_high_poison_counters_anim() {
        return this.enable_high_poison_counters_anim;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Boolean getEnable_ko_messages() {
        return this.enable_ko_messages;
    }

    public final MTUserSettings copy(String low_life_anim_default, String low_life_threshold, Boolean enable_low_life_bkg, Boolean enable_low_life_anim, String high_cmd_damage_threshold, Boolean enable_high_cmd_damage_anim, String high_poison_threshold, Boolean enable_high_poison_counters_anim, Boolean enable_ko_messages, Boolean enable_cmd_damage_by_default, Boolean enable_poison_counters_by_default, Boolean enable_commander_tax_by_default, Boolean display_game_events, String default_background, Boolean enable_player_toss, String game_font_default, Boolean condense_search, String current_search_language, String search_language_filter, String current_search, String current_set_filter, String preferred_currency, String default_draft_duration, String default_deck_duration, Boolean game_tutorial_shown, Boolean translate_rulings, String scan_display_language, String preferred_card_layout, Boolean enable_uded_q, Boolean timer_hint_shown, Boolean bo_help_dismissed, Boolean store_banner_dismissed, Boolean always_show_timer, String default_timer_time, Boolean timer_show_seconds, String creator_code, Boolean disable_win_lose_questions, Boolean disable_win_lose_animations, Boolean auto_enable_turn_timer, String turn_timer_display, Boolean enable_fullscreen_mode, Boolean enable_battery_saving_prompts, String last_rulebook_language, String last_card_picker_language, Boolean enable_streaming, Boolean enable_scan_beeps, Boolean enable_timer_by_default, Boolean auto_start_timer, String app_language, String last_group_by, String last_order_by, String last_order_direction, Boolean save_sorting_grouping_settings, String last_deck_list_group_by, String last_deck_list_order_by, String last_deck_list_order_direction, Boolean save_deck_list_sorting_grouping_settings, String preferred_currency_v2, String preferred_market, Boolean scan_override_language_enabled, String scan_override_language, Boolean scan_override_set_enabled, String scan_override_set, Boolean scan_override_finish_enabled, String scan_override_finish, Boolean scan_high_price_beep_enabled, Float scan_high_price_threshold, Boolean scan_purchase_price_enabled, String scan_purchase_price_mode, Float scan_purchase_price_fixed, Boolean ignore_basic_lands, Boolean ignore_collection, Boolean ignore_printings, Boolean clear_scan_list_after_add, String deck_sort_order, Boolean email_opt_in) {
        return new MTUserSettings(low_life_anim_default, low_life_threshold, enable_low_life_bkg, enable_low_life_anim, high_cmd_damage_threshold, enable_high_cmd_damage_anim, high_poison_threshold, enable_high_poison_counters_anim, enable_ko_messages, enable_cmd_damage_by_default, enable_poison_counters_by_default, enable_commander_tax_by_default, display_game_events, default_background, enable_player_toss, game_font_default, condense_search, current_search_language, search_language_filter, current_search, current_set_filter, preferred_currency, default_draft_duration, default_deck_duration, game_tutorial_shown, translate_rulings, scan_display_language, preferred_card_layout, enable_uded_q, timer_hint_shown, bo_help_dismissed, store_banner_dismissed, always_show_timer, default_timer_time, timer_show_seconds, creator_code, disable_win_lose_questions, disable_win_lose_animations, auto_enable_turn_timer, turn_timer_display, enable_fullscreen_mode, enable_battery_saving_prompts, last_rulebook_language, last_card_picker_language, enable_streaming, enable_scan_beeps, enable_timer_by_default, auto_start_timer, app_language, last_group_by, last_order_by, last_order_direction, save_sorting_grouping_settings, last_deck_list_group_by, last_deck_list_order_by, last_deck_list_order_direction, save_deck_list_sorting_grouping_settings, preferred_currency_v2, preferred_market, scan_override_language_enabled, scan_override_language, scan_override_set_enabled, scan_override_set, scan_override_finish_enabled, scan_override_finish, scan_high_price_beep_enabled, scan_high_price_threshold, scan_purchase_price_enabled, scan_purchase_price_mode, scan_purchase_price_fixed, ignore_basic_lands, ignore_collection, ignore_printings, clear_scan_list_after_add, deck_sort_order, email_opt_in);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTUserSettings)) {
            return false;
        }
        MTUserSettings mTUserSettings = (MTUserSettings) other;
        return Intrinsics.areEqual(this.low_life_anim_default, mTUserSettings.low_life_anim_default) && Intrinsics.areEqual(this.low_life_threshold, mTUserSettings.low_life_threshold) && Intrinsics.areEqual(this.enable_low_life_bkg, mTUserSettings.enable_low_life_bkg) && Intrinsics.areEqual(this.enable_low_life_anim, mTUserSettings.enable_low_life_anim) && Intrinsics.areEqual(this.high_cmd_damage_threshold, mTUserSettings.high_cmd_damage_threshold) && Intrinsics.areEqual(this.enable_high_cmd_damage_anim, mTUserSettings.enable_high_cmd_damage_anim) && Intrinsics.areEqual(this.high_poison_threshold, mTUserSettings.high_poison_threshold) && Intrinsics.areEqual(this.enable_high_poison_counters_anim, mTUserSettings.enable_high_poison_counters_anim) && Intrinsics.areEqual(this.enable_ko_messages, mTUserSettings.enable_ko_messages) && Intrinsics.areEqual(this.enable_cmd_damage_by_default, mTUserSettings.enable_cmd_damage_by_default) && Intrinsics.areEqual(this.enable_poison_counters_by_default, mTUserSettings.enable_poison_counters_by_default) && Intrinsics.areEqual(this.enable_commander_tax_by_default, mTUserSettings.enable_commander_tax_by_default) && Intrinsics.areEqual(this.display_game_events, mTUserSettings.display_game_events) && Intrinsics.areEqual(this.default_background, mTUserSettings.default_background) && Intrinsics.areEqual(this.enable_player_toss, mTUserSettings.enable_player_toss) && Intrinsics.areEqual(this.game_font_default, mTUserSettings.game_font_default) && Intrinsics.areEqual(this.condense_search, mTUserSettings.condense_search) && Intrinsics.areEqual(this.current_search_language, mTUserSettings.current_search_language) && Intrinsics.areEqual(this.search_language_filter, mTUserSettings.search_language_filter) && Intrinsics.areEqual(this.current_search, mTUserSettings.current_search) && Intrinsics.areEqual(this.current_set_filter, mTUserSettings.current_set_filter) && Intrinsics.areEqual(this.preferred_currency, mTUserSettings.preferred_currency) && Intrinsics.areEqual(this.default_draft_duration, mTUserSettings.default_draft_duration) && Intrinsics.areEqual(this.default_deck_duration, mTUserSettings.default_deck_duration) && Intrinsics.areEqual(this.game_tutorial_shown, mTUserSettings.game_tutorial_shown) && Intrinsics.areEqual(this.translate_rulings, mTUserSettings.translate_rulings) && Intrinsics.areEqual(this.scan_display_language, mTUserSettings.scan_display_language) && Intrinsics.areEqual(this.preferred_card_layout, mTUserSettings.preferred_card_layout) && Intrinsics.areEqual(this.enable_uded_q, mTUserSettings.enable_uded_q) && Intrinsics.areEqual(this.timer_hint_shown, mTUserSettings.timer_hint_shown) && Intrinsics.areEqual(this.bo_help_dismissed, mTUserSettings.bo_help_dismissed) && Intrinsics.areEqual(this.store_banner_dismissed, mTUserSettings.store_banner_dismissed) && Intrinsics.areEqual(this.always_show_timer, mTUserSettings.always_show_timer) && Intrinsics.areEqual(this.default_timer_time, mTUserSettings.default_timer_time) && Intrinsics.areEqual(this.timer_show_seconds, mTUserSettings.timer_show_seconds) && Intrinsics.areEqual(this.creator_code, mTUserSettings.creator_code) && Intrinsics.areEqual(this.disable_win_lose_questions, mTUserSettings.disable_win_lose_questions) && Intrinsics.areEqual(this.disable_win_lose_animations, mTUserSettings.disable_win_lose_animations) && Intrinsics.areEqual(this.auto_enable_turn_timer, mTUserSettings.auto_enable_turn_timer) && Intrinsics.areEqual(this.turn_timer_display, mTUserSettings.turn_timer_display) && Intrinsics.areEqual(this.enable_fullscreen_mode, mTUserSettings.enable_fullscreen_mode) && Intrinsics.areEqual(this.enable_battery_saving_prompts, mTUserSettings.enable_battery_saving_prompts) && Intrinsics.areEqual(this.last_rulebook_language, mTUserSettings.last_rulebook_language) && Intrinsics.areEqual(this.last_card_picker_language, mTUserSettings.last_card_picker_language) && Intrinsics.areEqual(this.enable_streaming, mTUserSettings.enable_streaming) && Intrinsics.areEqual(this.enable_scan_beeps, mTUserSettings.enable_scan_beeps) && Intrinsics.areEqual(this.enable_timer_by_default, mTUserSettings.enable_timer_by_default) && Intrinsics.areEqual(this.auto_start_timer, mTUserSettings.auto_start_timer) && Intrinsics.areEqual(this.app_language, mTUserSettings.app_language) && Intrinsics.areEqual(this.last_group_by, mTUserSettings.last_group_by) && Intrinsics.areEqual(this.last_order_by, mTUserSettings.last_order_by) && Intrinsics.areEqual(this.last_order_direction, mTUserSettings.last_order_direction) && Intrinsics.areEqual(this.save_sorting_grouping_settings, mTUserSettings.save_sorting_grouping_settings) && Intrinsics.areEqual(this.last_deck_list_group_by, mTUserSettings.last_deck_list_group_by) && Intrinsics.areEqual(this.last_deck_list_order_by, mTUserSettings.last_deck_list_order_by) && Intrinsics.areEqual(this.last_deck_list_order_direction, mTUserSettings.last_deck_list_order_direction) && Intrinsics.areEqual(this.save_deck_list_sorting_grouping_settings, mTUserSettings.save_deck_list_sorting_grouping_settings) && Intrinsics.areEqual(this.preferred_currency_v2, mTUserSettings.preferred_currency_v2) && Intrinsics.areEqual(this.preferred_market, mTUserSettings.preferred_market) && Intrinsics.areEqual(this.scan_override_language_enabled, mTUserSettings.scan_override_language_enabled) && Intrinsics.areEqual(this.scan_override_language, mTUserSettings.scan_override_language) && Intrinsics.areEqual(this.scan_override_set_enabled, mTUserSettings.scan_override_set_enabled) && Intrinsics.areEqual(this.scan_override_set, mTUserSettings.scan_override_set) && Intrinsics.areEqual(this.scan_override_finish_enabled, mTUserSettings.scan_override_finish_enabled) && Intrinsics.areEqual(this.scan_override_finish, mTUserSettings.scan_override_finish) && Intrinsics.areEqual(this.scan_high_price_beep_enabled, mTUserSettings.scan_high_price_beep_enabled) && Intrinsics.areEqual((Object) this.scan_high_price_threshold, (Object) mTUserSettings.scan_high_price_threshold) && Intrinsics.areEqual(this.scan_purchase_price_enabled, mTUserSettings.scan_purchase_price_enabled) && Intrinsics.areEqual(this.scan_purchase_price_mode, mTUserSettings.scan_purchase_price_mode) && Intrinsics.areEqual((Object) this.scan_purchase_price_fixed, (Object) mTUserSettings.scan_purchase_price_fixed) && Intrinsics.areEqual(this.ignore_basic_lands, mTUserSettings.ignore_basic_lands) && Intrinsics.areEqual(this.ignore_collection, mTUserSettings.ignore_collection) && Intrinsics.areEqual(this.ignore_printings, mTUserSettings.ignore_printings) && Intrinsics.areEqual(this.clear_scan_list_after_add, mTUserSettings.clear_scan_list_after_add) && Intrinsics.areEqual(this.deck_sort_order, mTUserSettings.deck_sort_order) && Intrinsics.areEqual(this.email_opt_in, mTUserSettings.email_opt_in);
    }

    public final Boolean getAlways_show_timer() {
        return this.always_show_timer;
    }

    public final String getApp_language() {
        return this.app_language;
    }

    public final Boolean getAuto_enable_turn_timer() {
        return this.auto_enable_turn_timer;
    }

    public final Boolean getAuto_start_timer() {
        return this.auto_start_timer;
    }

    public final Boolean getBo_help_dismissed() {
        return this.bo_help_dismissed;
    }

    public final Boolean getClear_scan_list_after_add() {
        return this.clear_scan_list_after_add;
    }

    public final Boolean getCondense_search() {
        return this.condense_search;
    }

    public final String getCreator_code() {
        return this.creator_code;
    }

    public final String getCurrent_search() {
        return this.current_search;
    }

    public final String getCurrent_search_language() {
        return this.current_search_language;
    }

    public final String getCurrent_set_filter() {
        return this.current_set_filter;
    }

    public final String getDeck_sort_order() {
        return this.deck_sort_order;
    }

    public final String getDefault_background() {
        return this.default_background;
    }

    public final String getDefault_deck_duration() {
        return this.default_deck_duration;
    }

    public final String getDefault_draft_duration() {
        return this.default_draft_duration;
    }

    public final String getDefault_timer_time() {
        return this.default_timer_time;
    }

    public final Boolean getDisable_win_lose_animations() {
        return this.disable_win_lose_animations;
    }

    public final Boolean getDisable_win_lose_questions() {
        return this.disable_win_lose_questions;
    }

    public final Boolean getDisplay_game_events() {
        return this.display_game_events;
    }

    public final Boolean getEmail_opt_in() {
        return this.email_opt_in;
    }

    public final Boolean getEnable_battery_saving_prompts() {
        return this.enable_battery_saving_prompts;
    }

    public final Boolean getEnable_cmd_damage_by_default() {
        return this.enable_cmd_damage_by_default;
    }

    public final Boolean getEnable_commander_tax_by_default() {
        return this.enable_commander_tax_by_default;
    }

    public final Boolean getEnable_fullscreen_mode() {
        return this.enable_fullscreen_mode;
    }

    public final Boolean getEnable_high_cmd_damage_anim() {
        return this.enable_high_cmd_damage_anim;
    }

    public final Boolean getEnable_high_poison_counters_anim() {
        return this.enable_high_poison_counters_anim;
    }

    public final Boolean getEnable_ko_messages() {
        return this.enable_ko_messages;
    }

    public final Boolean getEnable_low_life_anim() {
        return this.enable_low_life_anim;
    }

    public final Boolean getEnable_low_life_bkg() {
        return this.enable_low_life_bkg;
    }

    public final Boolean getEnable_player_toss() {
        return this.enable_player_toss;
    }

    public final Boolean getEnable_poison_counters_by_default() {
        return this.enable_poison_counters_by_default;
    }

    public final Boolean getEnable_scan_beeps() {
        return this.enable_scan_beeps;
    }

    public final Boolean getEnable_streaming() {
        return this.enable_streaming;
    }

    public final Boolean getEnable_timer_by_default() {
        return this.enable_timer_by_default;
    }

    public final Boolean getEnable_uded_q() {
        return this.enable_uded_q;
    }

    public final String getGame_font_default() {
        return this.game_font_default;
    }

    public final Boolean getGame_tutorial_shown() {
        return this.game_tutorial_shown;
    }

    public final String getHigh_cmd_damage_threshold() {
        return this.high_cmd_damage_threshold;
    }

    public final String getHigh_poison_threshold() {
        return this.high_poison_threshold;
    }

    public final Boolean getIgnore_basic_lands() {
        return this.ignore_basic_lands;
    }

    public final Boolean getIgnore_collection() {
        return this.ignore_collection;
    }

    public final Boolean getIgnore_printings() {
        return this.ignore_printings;
    }

    public final String getLast_card_picker_language() {
        return this.last_card_picker_language;
    }

    public final String getLast_deck_list_group_by() {
        return this.last_deck_list_group_by;
    }

    public final String getLast_deck_list_order_by() {
        return this.last_deck_list_order_by;
    }

    public final String getLast_deck_list_order_direction() {
        return this.last_deck_list_order_direction;
    }

    public final String getLast_group_by() {
        return this.last_group_by;
    }

    public final String getLast_order_by() {
        return this.last_order_by;
    }

    public final String getLast_order_direction() {
        return this.last_order_direction;
    }

    public final String getLast_rulebook_language() {
        return this.last_rulebook_language;
    }

    public final String getLow_life_anim_default() {
        return this.low_life_anim_default;
    }

    public final String getLow_life_threshold() {
        return this.low_life_threshold;
    }

    public final String getPreferred_card_layout() {
        return this.preferred_card_layout;
    }

    public final String getPreferred_currency() {
        return this.preferred_currency;
    }

    public final String getPreferred_currency_v2() {
        return this.preferred_currency_v2;
    }

    public final String getPreferred_market() {
        return this.preferred_market;
    }

    public final Boolean getSave_deck_list_sorting_grouping_settings() {
        return this.save_deck_list_sorting_grouping_settings;
    }

    public final Boolean getSave_sorting_grouping_settings() {
        return this.save_sorting_grouping_settings;
    }

    public final String getScan_display_language() {
        return this.scan_display_language;
    }

    public final Boolean getScan_high_price_beep_enabled() {
        return this.scan_high_price_beep_enabled;
    }

    public final Float getScan_high_price_threshold() {
        return this.scan_high_price_threshold;
    }

    public final String getScan_override_finish() {
        return this.scan_override_finish;
    }

    public final Boolean getScan_override_finish_enabled() {
        return this.scan_override_finish_enabled;
    }

    public final String getScan_override_language() {
        return this.scan_override_language;
    }

    public final Boolean getScan_override_language_enabled() {
        return this.scan_override_language_enabled;
    }

    public final String getScan_override_set() {
        return this.scan_override_set;
    }

    public final Boolean getScan_override_set_enabled() {
        return this.scan_override_set_enabled;
    }

    public final Boolean getScan_purchase_price_enabled() {
        return this.scan_purchase_price_enabled;
    }

    public final Float getScan_purchase_price_fixed() {
        return this.scan_purchase_price_fixed;
    }

    public final String getScan_purchase_price_mode() {
        return this.scan_purchase_price_mode;
    }

    public final String getSearch_language_filter() {
        return this.search_language_filter;
    }

    public final Boolean getStore_banner_dismissed() {
        return this.store_banner_dismissed;
    }

    public final Boolean getTimer_hint_shown() {
        return this.timer_hint_shown;
    }

    public final Boolean getTimer_show_seconds() {
        return this.timer_show_seconds;
    }

    public final Boolean getTranslate_rulings() {
        return this.translate_rulings;
    }

    public final String getTurn_timer_display() {
        return this.turn_timer_display;
    }

    public int hashCode() {
        String str = this.low_life_anim_default;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.low_life_threshold;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.enable_low_life_bkg;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.enable_low_life_anim;
        int iHashCode4 = (iHashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str3 = this.high_cmd_damage_threshold;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool3 = this.enable_high_cmd_damage_anim;
        int iHashCode6 = (iHashCode5 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str4 = this.high_poison_threshold;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool4 = this.enable_high_poison_counters_anim;
        int iHashCode8 = (iHashCode7 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.enable_ko_messages;
        int iHashCode9 = (iHashCode8 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this.enable_cmd_damage_by_default;
        int iHashCode10 = (iHashCode9 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Boolean bool7 = this.enable_poison_counters_by_default;
        int iHashCode11 = (iHashCode10 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
        Boolean bool8 = this.enable_commander_tax_by_default;
        int iHashCode12 = (iHashCode11 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
        Boolean bool9 = this.display_game_events;
        int iHashCode13 = (iHashCode12 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
        String str5 = this.default_background;
        int iHashCode14 = (iHashCode13 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool10 = this.enable_player_toss;
        int iHashCode15 = (iHashCode14 + (bool10 == null ? 0 : bool10.hashCode())) * 31;
        String str6 = this.game_font_default;
        int iHashCode16 = (iHashCode15 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Boolean bool11 = this.condense_search;
        int iHashCode17 = (iHashCode16 + (bool11 == null ? 0 : bool11.hashCode())) * 31;
        String str7 = this.current_search_language;
        int iHashCode18 = (iHashCode17 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.search_language_filter;
        int iHashCode19 = (iHashCode18 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.current_search;
        int iHashCode20 = (iHashCode19 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.current_set_filter;
        int iHashCode21 = (iHashCode20 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.preferred_currency;
        int iHashCode22 = (iHashCode21 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.default_draft_duration;
        int iHashCode23 = (iHashCode22 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.default_deck_duration;
        int iHashCode24 = (iHashCode23 + (str13 == null ? 0 : str13.hashCode())) * 31;
        Boolean bool12 = this.game_tutorial_shown;
        int iHashCode25 = (iHashCode24 + (bool12 == null ? 0 : bool12.hashCode())) * 31;
        Boolean bool13 = this.translate_rulings;
        int iHashCode26 = (iHashCode25 + (bool13 == null ? 0 : bool13.hashCode())) * 31;
        String str14 = this.scan_display_language;
        int iHashCode27 = (iHashCode26 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.preferred_card_layout;
        int iHashCode28 = (iHashCode27 + (str15 == null ? 0 : str15.hashCode())) * 31;
        Boolean bool14 = this.enable_uded_q;
        int iHashCode29 = (iHashCode28 + (bool14 == null ? 0 : bool14.hashCode())) * 31;
        Boolean bool15 = this.timer_hint_shown;
        int iHashCode30 = (iHashCode29 + (bool15 == null ? 0 : bool15.hashCode())) * 31;
        Boolean bool16 = this.bo_help_dismissed;
        int iHashCode31 = (iHashCode30 + (bool16 == null ? 0 : bool16.hashCode())) * 31;
        Boolean bool17 = this.store_banner_dismissed;
        int iHashCode32 = (iHashCode31 + (bool17 == null ? 0 : bool17.hashCode())) * 31;
        Boolean bool18 = this.always_show_timer;
        int iHashCode33 = (iHashCode32 + (bool18 == null ? 0 : bool18.hashCode())) * 31;
        String str16 = this.default_timer_time;
        int iHashCode34 = (iHashCode33 + (str16 == null ? 0 : str16.hashCode())) * 31;
        Boolean bool19 = this.timer_show_seconds;
        int iHashCode35 = (iHashCode34 + (bool19 == null ? 0 : bool19.hashCode())) * 31;
        String str17 = this.creator_code;
        int iHashCode36 = (iHashCode35 + (str17 == null ? 0 : str17.hashCode())) * 31;
        Boolean bool20 = this.disable_win_lose_questions;
        int iHashCode37 = (iHashCode36 + (bool20 == null ? 0 : bool20.hashCode())) * 31;
        Boolean bool21 = this.disable_win_lose_animations;
        int iHashCode38 = (iHashCode37 + (bool21 == null ? 0 : bool21.hashCode())) * 31;
        Boolean bool22 = this.auto_enable_turn_timer;
        int iHashCode39 = (iHashCode38 + (bool22 == null ? 0 : bool22.hashCode())) * 31;
        String str18 = this.turn_timer_display;
        int iHashCode40 = (iHashCode39 + (str18 == null ? 0 : str18.hashCode())) * 31;
        Boolean bool23 = this.enable_fullscreen_mode;
        int iHashCode41 = (iHashCode40 + (bool23 == null ? 0 : bool23.hashCode())) * 31;
        Boolean bool24 = this.enable_battery_saving_prompts;
        int iHashCode42 = (iHashCode41 + (bool24 == null ? 0 : bool24.hashCode())) * 31;
        String str19 = this.last_rulebook_language;
        int iHashCode43 = (iHashCode42 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.last_card_picker_language;
        int iHashCode44 = (iHashCode43 + (str20 == null ? 0 : str20.hashCode())) * 31;
        Boolean bool25 = this.enable_streaming;
        int iHashCode45 = (iHashCode44 + (bool25 == null ? 0 : bool25.hashCode())) * 31;
        Boolean bool26 = this.enable_scan_beeps;
        int iHashCode46 = (iHashCode45 + (bool26 == null ? 0 : bool26.hashCode())) * 31;
        Boolean bool27 = this.enable_timer_by_default;
        int iHashCode47 = (iHashCode46 + (bool27 == null ? 0 : bool27.hashCode())) * 31;
        Boolean bool28 = this.auto_start_timer;
        int iHashCode48 = (iHashCode47 + (bool28 == null ? 0 : bool28.hashCode())) * 31;
        String str21 = this.app_language;
        int iHashCode49 = (iHashCode48 + (str21 == null ? 0 : str21.hashCode())) * 31;
        String str22 = this.last_group_by;
        int iHashCode50 = (iHashCode49 + (str22 == null ? 0 : str22.hashCode())) * 31;
        String str23 = this.last_order_by;
        int iHashCode51 = (iHashCode50 + (str23 == null ? 0 : str23.hashCode())) * 31;
        String str24 = this.last_order_direction;
        int iHashCode52 = (iHashCode51 + (str24 == null ? 0 : str24.hashCode())) * 31;
        Boolean bool29 = this.save_sorting_grouping_settings;
        int iHashCode53 = (iHashCode52 + (bool29 == null ? 0 : bool29.hashCode())) * 31;
        String str25 = this.last_deck_list_group_by;
        int iHashCode54 = (iHashCode53 + (str25 == null ? 0 : str25.hashCode())) * 31;
        String str26 = this.last_deck_list_order_by;
        int iHashCode55 = (iHashCode54 + (str26 == null ? 0 : str26.hashCode())) * 31;
        String str27 = this.last_deck_list_order_direction;
        int iHashCode56 = (iHashCode55 + (str27 == null ? 0 : str27.hashCode())) * 31;
        Boolean bool30 = this.save_deck_list_sorting_grouping_settings;
        int iHashCode57 = (iHashCode56 + (bool30 == null ? 0 : bool30.hashCode())) * 31;
        String str28 = this.preferred_currency_v2;
        int iHashCode58 = (iHashCode57 + (str28 == null ? 0 : str28.hashCode())) * 31;
        String str29 = this.preferred_market;
        int iHashCode59 = (iHashCode58 + (str29 == null ? 0 : str29.hashCode())) * 31;
        Boolean bool31 = this.scan_override_language_enabled;
        int iHashCode60 = (iHashCode59 + (bool31 == null ? 0 : bool31.hashCode())) * 31;
        String str30 = this.scan_override_language;
        int iHashCode61 = (iHashCode60 + (str30 == null ? 0 : str30.hashCode())) * 31;
        Boolean bool32 = this.scan_override_set_enabled;
        int iHashCode62 = (iHashCode61 + (bool32 == null ? 0 : bool32.hashCode())) * 31;
        String str31 = this.scan_override_set;
        int iHashCode63 = (iHashCode62 + (str31 == null ? 0 : str31.hashCode())) * 31;
        Boolean bool33 = this.scan_override_finish_enabled;
        int iHashCode64 = (iHashCode63 + (bool33 == null ? 0 : bool33.hashCode())) * 31;
        String str32 = this.scan_override_finish;
        int iHashCode65 = (iHashCode64 + (str32 == null ? 0 : str32.hashCode())) * 31;
        Boolean bool34 = this.scan_high_price_beep_enabled;
        int iHashCode66 = (iHashCode65 + (bool34 == null ? 0 : bool34.hashCode())) * 31;
        Float f = this.scan_high_price_threshold;
        int iHashCode67 = (iHashCode66 + (f == null ? 0 : f.hashCode())) * 31;
        Boolean bool35 = this.scan_purchase_price_enabled;
        int iHashCode68 = (iHashCode67 + (bool35 == null ? 0 : bool35.hashCode())) * 31;
        String str33 = this.scan_purchase_price_mode;
        int iHashCode69 = (iHashCode68 + (str33 == null ? 0 : str33.hashCode())) * 31;
        Float f2 = this.scan_purchase_price_fixed;
        int iHashCode70 = (iHashCode69 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Boolean bool36 = this.ignore_basic_lands;
        int iHashCode71 = (iHashCode70 + (bool36 == null ? 0 : bool36.hashCode())) * 31;
        Boolean bool37 = this.ignore_collection;
        int iHashCode72 = (iHashCode71 + (bool37 == null ? 0 : bool37.hashCode())) * 31;
        Boolean bool38 = this.ignore_printings;
        int iHashCode73 = (iHashCode72 + (bool38 == null ? 0 : bool38.hashCode())) * 31;
        Boolean bool39 = this.clear_scan_list_after_add;
        int iHashCode74 = (iHashCode73 + (bool39 == null ? 0 : bool39.hashCode())) * 31;
        String str34 = this.deck_sort_order;
        int iHashCode75 = (iHashCode74 + (str34 == null ? 0 : str34.hashCode())) * 31;
        Boolean bool40 = this.email_opt_in;
        return iHashCode75 + (bool40 != null ? bool40.hashCode() : 0);
    }

    public final void setAlways_show_timer(Boolean bool) {
        this.always_show_timer = bool;
    }

    public final void setApp_language(String str) {
        this.app_language = str;
    }

    public final void setAuto_enable_turn_timer(Boolean bool) {
        this.auto_enable_turn_timer = bool;
    }

    public final void setAuto_start_timer(Boolean bool) {
        this.auto_start_timer = bool;
    }

    public final void setBo_help_dismissed(Boolean bool) {
        this.bo_help_dismissed = bool;
    }

    public final void setClear_scan_list_after_add(Boolean bool) {
        this.clear_scan_list_after_add = bool;
    }

    public final void setCondense_search(Boolean bool) {
        this.condense_search = bool;
    }

    public final void setCreator_code(String str) {
        this.creator_code = str;
    }

    public final void setCurrent_search(String str) {
        this.current_search = str;
    }

    public final void setCurrent_search_language(String str) {
        this.current_search_language = str;
    }

    public final void setCurrent_set_filter(String str) {
        this.current_set_filter = str;
    }

    public final void setDeck_sort_order(String str) {
        this.deck_sort_order = str;
    }

    public final void setDefault_background(String str) {
        this.default_background = str;
    }

    public final void setDefault_deck_duration(String str) {
        this.default_deck_duration = str;
    }

    public final void setDefault_draft_duration(String str) {
        this.default_draft_duration = str;
    }

    public final void setDefault_timer_time(String str) {
        this.default_timer_time = str;
    }

    public final void setDisable_win_lose_animations(Boolean bool) {
        this.disable_win_lose_animations = bool;
    }

    public final void setDisable_win_lose_questions(Boolean bool) {
        this.disable_win_lose_questions = bool;
    }

    public final void setDisplay_game_events(Boolean bool) {
        this.display_game_events = bool;
    }

    public final void setEmail_opt_in(Boolean bool) {
        this.email_opt_in = bool;
    }

    public final void setEnable_battery_saving_prompts(Boolean bool) {
        this.enable_battery_saving_prompts = bool;
    }

    public final void setEnable_cmd_damage_by_default(Boolean bool) {
        this.enable_cmd_damage_by_default = bool;
    }

    public final void setEnable_commander_tax_by_default(Boolean bool) {
        this.enable_commander_tax_by_default = bool;
    }

    public final void setEnable_fullscreen_mode(Boolean bool) {
        this.enable_fullscreen_mode = bool;
    }

    public final void setEnable_high_cmd_damage_anim(Boolean bool) {
        this.enable_high_cmd_damage_anim = bool;
    }

    public final void setEnable_high_poison_counters_anim(Boolean bool) {
        this.enable_high_poison_counters_anim = bool;
    }

    public final void setEnable_ko_messages(Boolean bool) {
        this.enable_ko_messages = bool;
    }

    public final void setEnable_low_life_anim(Boolean bool) {
        this.enable_low_life_anim = bool;
    }

    public final void setEnable_low_life_bkg(Boolean bool) {
        this.enable_low_life_bkg = bool;
    }

    public final void setEnable_player_toss(Boolean bool) {
        this.enable_player_toss = bool;
    }

    public final void setEnable_poison_counters_by_default(Boolean bool) {
        this.enable_poison_counters_by_default = bool;
    }

    public final void setEnable_scan_beeps(Boolean bool) {
        this.enable_scan_beeps = bool;
    }

    public final void setEnable_streaming(Boolean bool) {
        this.enable_streaming = bool;
    }

    public final void setEnable_timer_by_default(Boolean bool) {
        this.enable_timer_by_default = bool;
    }

    public final void setEnable_uded_q(Boolean bool) {
        this.enable_uded_q = bool;
    }

    public final void setGame_font_default(String str) {
        this.game_font_default = str;
    }

    public final void setGame_tutorial_shown(Boolean bool) {
        this.game_tutorial_shown = bool;
    }

    public final void setHigh_cmd_damage_threshold(String str) {
        this.high_cmd_damage_threshold = str;
    }

    public final void setHigh_poison_threshold(String str) {
        this.high_poison_threshold = str;
    }

    public final void setIgnore_basic_lands(Boolean bool) {
        this.ignore_basic_lands = bool;
    }

    public final void setIgnore_collection(Boolean bool) {
        this.ignore_collection = bool;
    }

    public final void setIgnore_printings(Boolean bool) {
        this.ignore_printings = bool;
    }

    public final void setLast_card_picker_language(String str) {
        this.last_card_picker_language = str;
    }

    public final void setLast_deck_list_group_by(String str) {
        this.last_deck_list_group_by = str;
    }

    public final void setLast_deck_list_order_by(String str) {
        this.last_deck_list_order_by = str;
    }

    public final void setLast_deck_list_order_direction(String str) {
        this.last_deck_list_order_direction = str;
    }

    public final void setLast_group_by(String str) {
        this.last_group_by = str;
    }

    public final void setLast_order_by(String str) {
        this.last_order_by = str;
    }

    public final void setLast_order_direction(String str) {
        this.last_order_direction = str;
    }

    public final void setLast_rulebook_language(String str) {
        this.last_rulebook_language = str;
    }

    public final void setLow_life_anim_default(String str) {
        this.low_life_anim_default = str;
    }

    public final void setLow_life_threshold(String str) {
        this.low_life_threshold = str;
    }

    public final void setPreferred_card_layout(String str) {
        this.preferred_card_layout = str;
    }

    public final void setPreferred_currency(String str) {
        this.preferred_currency = str;
    }

    public final void setPreferred_currency_v2(String str) {
        this.preferred_currency_v2 = str;
    }

    public final void setPreferred_market(String str) {
        this.preferred_market = str;
    }

    public final void setSave_deck_list_sorting_grouping_settings(Boolean bool) {
        this.save_deck_list_sorting_grouping_settings = bool;
    }

    public final void setSave_sorting_grouping_settings(Boolean bool) {
        this.save_sorting_grouping_settings = bool;
    }

    public final void setScan_display_language(String str) {
        this.scan_display_language = str;
    }

    public final void setScan_high_price_beep_enabled(Boolean bool) {
        this.scan_high_price_beep_enabled = bool;
    }

    public final void setScan_high_price_threshold(Float f) {
        this.scan_high_price_threshold = f;
    }

    public final void setScan_override_finish(String str) {
        this.scan_override_finish = str;
    }

    public final void setScan_override_finish_enabled(Boolean bool) {
        this.scan_override_finish_enabled = bool;
    }

    public final void setScan_override_language(String str) {
        this.scan_override_language = str;
    }

    public final void setScan_override_language_enabled(Boolean bool) {
        this.scan_override_language_enabled = bool;
    }

    public final void setScan_override_set(String str) {
        this.scan_override_set = str;
    }

    public final void setScan_override_set_enabled(Boolean bool) {
        this.scan_override_set_enabled = bool;
    }

    public final void setScan_purchase_price_enabled(Boolean bool) {
        this.scan_purchase_price_enabled = bool;
    }

    public final void setScan_purchase_price_fixed(Float f) {
        this.scan_purchase_price_fixed = f;
    }

    public final void setScan_purchase_price_mode(String str) {
        this.scan_purchase_price_mode = str;
    }

    public final void setSearch_language_filter(String str) {
        this.search_language_filter = str;
    }

    public final void setStore_banner_dismissed(Boolean bool) {
        this.store_banner_dismissed = bool;
    }

    public final void setTimer_hint_shown(Boolean bool) {
        this.timer_hint_shown = bool;
    }

    public final void setTimer_show_seconds(Boolean bool) {
        this.timer_show_seconds = bool;
    }

    public final void setTranslate_rulings(Boolean bool) {
        this.translate_rulings = bool;
    }

    public final void setTurn_timer_display(String str) {
        this.turn_timer_display = str;
    }

    public String toString() {
        return "MTUserSettings(low_life_anim_default=" + this.low_life_anim_default + ", low_life_threshold=" + this.low_life_threshold + ", enable_low_life_bkg=" + this.enable_low_life_bkg + ", enable_low_life_anim=" + this.enable_low_life_anim + ", high_cmd_damage_threshold=" + this.high_cmd_damage_threshold + ", enable_high_cmd_damage_anim=" + this.enable_high_cmd_damage_anim + ", high_poison_threshold=" + this.high_poison_threshold + ", enable_high_poison_counters_anim=" + this.enable_high_poison_counters_anim + ", enable_ko_messages=" + this.enable_ko_messages + ", enable_cmd_damage_by_default=" + this.enable_cmd_damage_by_default + ", enable_poison_counters_by_default=" + this.enable_poison_counters_by_default + ", enable_commander_tax_by_default=" + this.enable_commander_tax_by_default + ", display_game_events=" + this.display_game_events + ", default_background=" + this.default_background + ", enable_player_toss=" + this.enable_player_toss + ", game_font_default=" + this.game_font_default + ", condense_search=" + this.condense_search + ", current_search_language=" + this.current_search_language + ", search_language_filter=" + this.search_language_filter + ", current_search=" + this.current_search + ", current_set_filter=" + this.current_set_filter + ", preferred_currency=" + this.preferred_currency + ", default_draft_duration=" + this.default_draft_duration + ", default_deck_duration=" + this.default_deck_duration + ", game_tutorial_shown=" + this.game_tutorial_shown + ", translate_rulings=" + this.translate_rulings + ", scan_display_language=" + this.scan_display_language + ", preferred_card_layout=" + this.preferred_card_layout + ", enable_uded_q=" + this.enable_uded_q + ", timer_hint_shown=" + this.timer_hint_shown + ", bo_help_dismissed=" + this.bo_help_dismissed + ", store_banner_dismissed=" + this.store_banner_dismissed + ", always_show_timer=" + this.always_show_timer + ", default_timer_time=" + this.default_timer_time + ", timer_show_seconds=" + this.timer_show_seconds + ", creator_code=" + this.creator_code + ", disable_win_lose_questions=" + this.disable_win_lose_questions + ", disable_win_lose_animations=" + this.disable_win_lose_animations + ", auto_enable_turn_timer=" + this.auto_enable_turn_timer + ", turn_timer_display=" + this.turn_timer_display + ", enable_fullscreen_mode=" + this.enable_fullscreen_mode + ", enable_battery_saving_prompts=" + this.enable_battery_saving_prompts + ", last_rulebook_language=" + this.last_rulebook_language + ", last_card_picker_language=" + this.last_card_picker_language + ", enable_streaming=" + this.enable_streaming + ", enable_scan_beeps=" + this.enable_scan_beeps + ", enable_timer_by_default=" + this.enable_timer_by_default + ", auto_start_timer=" + this.auto_start_timer + ", app_language=" + this.app_language + ", last_group_by=" + this.last_group_by + ", last_order_by=" + this.last_order_by + ", last_order_direction=" + this.last_order_direction + ", save_sorting_grouping_settings=" + this.save_sorting_grouping_settings + ", last_deck_list_group_by=" + this.last_deck_list_group_by + ", last_deck_list_order_by=" + this.last_deck_list_order_by + ", last_deck_list_order_direction=" + this.last_deck_list_order_direction + ", save_deck_list_sorting_grouping_settings=" + this.save_deck_list_sorting_grouping_settings + ", preferred_currency_v2=" + this.preferred_currency_v2 + ", preferred_market=" + this.preferred_market + ", scan_override_language_enabled=" + this.scan_override_language_enabled + ", scan_override_language=" + this.scan_override_language + ", scan_override_set_enabled=" + this.scan_override_set_enabled + ", scan_override_set=" + this.scan_override_set + ", scan_override_finish_enabled=" + this.scan_override_finish_enabled + ", scan_override_finish=" + this.scan_override_finish + ", scan_high_price_beep_enabled=" + this.scan_high_price_beep_enabled + ", scan_high_price_threshold=" + this.scan_high_price_threshold + ", scan_purchase_price_enabled=" + this.scan_purchase_price_enabled + ", scan_purchase_price_mode=" + this.scan_purchase_price_mode + ", scan_purchase_price_fixed=" + this.scan_purchase_price_fixed + ", ignore_basic_lands=" + this.ignore_basic_lands + ", ignore_collection=" + this.ignore_collection + ", ignore_printings=" + this.ignore_printings + ", clear_scan_list_after_add=" + this.clear_scan_list_after_add + ", deck_sort_order=" + this.deck_sort_order + ", email_opt_in=" + this.email_opt_in + ")";
    }
}
