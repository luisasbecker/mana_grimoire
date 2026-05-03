package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0003\b«\u0001\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BÛ\u0003\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\b\b\u0002\u0010!\u001a\u00020\f\u0012\b\b\u0002\u0010\"\u001a\u00020\f\u0012\b\b\u0002\u0010#\u001a\u00020\f\u0012\b\b\u0002\u0010$\u001a\u00020\u0006\u0012\b\b\u0002\u0010%\u001a\u00020\u0006\u0012\b\b\u0002\u0010&\u001a\u00020\u0003\u0012\b\b\u0002\u0010'\u001a\u00020\u0003\u0012\b\b\u0002\u0010(\u001a\u00020\f\u0012\b\b\u0002\u0010)\u001a\u00020\f\u0012\b\b\u0002\u0010*\u001a\u00020\u0006\u0012\b\b\u0002\u0010+\u001a\u00020\f\u0012\b\b\u0002\u0010,\u001a\u00020\u0006\u0012\b\b\u0002\u0010-\u001a\u00020\f\u0012\b\b\u0002\u0010.\u001a\u00020\u0006\u0012\b\b\u0002\u0010/\u001a\u00020\f\u0012\b\b\u0002\u00100\u001a\u00020\u0006\u0012\b\b\u0002\u00101\u001a\u00020\f\u0012\b\b\u0002\u00102\u001a\u00020\u0006\u0012\b\b\u0002\u00103\u001a\u00020\f\u0012\b\b\u0002\u00104\u001a\u00020\u0006\u0012\b\b\u0002\u00105\u001a\u00020\u0006¢\u0006\u0004\b6\u00107J\n\u0010\u009a\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009b\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009c\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u009d\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u009e\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u009f\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010 \u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010¡\u0001\u001a\u00020\fHÆ\u0003J\n\u0010¢\u0001\u001a\u00020\fHÆ\u0003J\n\u0010£\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010¤\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010¥\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¦\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010§\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¨\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010©\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010ª\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010«\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¬\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u00ad\u0001\u001a\u00020\u0003HÆ\u0003J\u0010\u0010®\u0001\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bHÆ\u0003J\u0010\u0010¯\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u001eHÆ\u0003J\u0010\u0010°\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u001eHÆ\u0003J\n\u0010±\u0001\u001a\u00020\fHÆ\u0003J\n\u0010²\u0001\u001a\u00020\fHÆ\u0003J\n\u0010³\u0001\u001a\u00020\fHÆ\u0003J\n\u0010´\u0001\u001a\u00020\fHÆ\u0003J\n\u0010µ\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010¶\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010·\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¸\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¹\u0001\u001a\u00020\fHÆ\u0003J\n\u0010º\u0001\u001a\u00020\fHÆ\u0003J\n\u0010»\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010¼\u0001\u001a\u00020\fHÆ\u0003J\n\u0010½\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010¾\u0001\u001a\u00020\fHÆ\u0003J\n\u0010¿\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010À\u0001\u001a\u00020\fHÆ\u0003J\n\u0010Á\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010Â\u0001\u001a\u00020\fHÆ\u0003J\n\u0010Ã\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010Ä\u0001\u001a\u00020\fHÆ\u0003J\n\u0010Å\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010Æ\u0001\u001a\u00020\u0006HÆ\u0003JÞ\u0003\u0010Ç\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e2\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e2\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020\f2\b\b\u0002\u0010#\u001a\u00020\f2\b\b\u0002\u0010$\u001a\u00020\u00062\b\b\u0002\u0010%\u001a\u00020\u00062\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\f2\b\b\u0002\u0010)\u001a\u00020\f2\b\b\u0002\u0010*\u001a\u00020\u00062\b\b\u0002\u0010+\u001a\u00020\f2\b\b\u0002\u0010,\u001a\u00020\u00062\b\b\u0002\u0010-\u001a\u00020\f2\b\b\u0002\u0010.\u001a\u00020\u00062\b\b\u0002\u0010/\u001a\u00020\f2\b\b\u0002\u00100\u001a\u00020\u00062\b\b\u0002\u00101\u001a\u00020\f2\b\b\u0002\u00102\u001a\u00020\u00062\b\b\u0002\u00103\u001a\u00020\f2\b\b\u0002\u00104\u001a\u00020\u00062\b\b\u0002\u00105\u001a\u00020\u0006HÆ\u0001J\u0016\u0010È\u0001\u001a\u00020\f2\n\u0010É\u0001\u001a\u0005\u0018\u00010Ê\u0001HÖ\u0003J\n\u0010Ë\u0001\u001a\u00020\u0006HÖ\u0001J\n\u0010Ì\u0001\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00109\"\u0004\b=\u0010;R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010?\"\u0004\bC\u0010AR\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010?\"\u0004\bE\u0010AR\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010?\"\u0004\bG\u0010AR\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010?\"\u0004\bI\u0010AR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001a\u0010\r\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010K\"\u0004\bO\u0010MR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001a\u0010\u0010\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010Q\"\u0004\bU\u0010SR\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u00109\"\u0004\bW\u0010;R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u00109\"\u0004\bY\u0010;R\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u00109\"\u0004\b[\u0010;R\u001a\u0010\u0014\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u00109\"\u0004\b]\u0010;R\u001a\u0010\u0015\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u00109\"\u0004\b_\u0010;R\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u00109\"\u0004\ba\u0010;R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u00109\"\u0004\bc\u0010;R\u001a\u0010\u0018\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u00109\"\u0004\be\u0010;R\u001a\u0010\u0019\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u00109\"\u0004\bg\u0010;R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010i\"\u0004\bm\u0010kR \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010i\"\u0004\bo\u0010kR\u001a\u0010 \u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010K\"\u0004\bp\u0010MR\u001a\u0010!\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010K\"\u0004\br\u0010MR\u001a\u0010\"\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010K\"\u0004\bt\u0010MR\u001a\u0010#\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010K\"\u0004\bv\u0010MR\u001a\u0010$\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010?\"\u0004\bx\u0010AR\u001a\u0010%\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010?\"\u0004\bz\u0010AR\u001a\u0010&\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u00109\"\u0004\b|\u0010;R\u001a\u0010'\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u00109\"\u0004\b~\u0010;R\u001a\u0010(\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010K\"\u0004\b\u007f\u0010MR\u001c\u0010)\u001a\u00020\fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010K\"\u0005\b\u0081\u0001\u0010MR\u001c\u0010*\u001a\u00020\u0006X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010?\"\u0005\b\u0083\u0001\u0010AR\u001c\u0010+\u001a\u00020\fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010K\"\u0005\b\u0085\u0001\u0010MR\u001c\u0010,\u001a\u00020\u0006X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010?\"\u0005\b\u0087\u0001\u0010AR\u001c\u0010-\u001a\u00020\fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u0010K\"\u0005\b\u0089\u0001\u0010MR\u001c\u0010.\u001a\u00020\u0006X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010?\"\u0005\b\u008b\u0001\u0010AR\u001c\u0010/\u001a\u00020\fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010K\"\u0005\b\u008d\u0001\u0010MR\u001c\u00100\u001a\u00020\u0006X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010?\"\u0005\b\u008f\u0001\u0010AR\u001c\u00101\u001a\u00020\fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010K\"\u0005\b\u0091\u0001\u0010MR\u001c\u00102\u001a\u00020\u0006X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010?\"\u0005\b\u0093\u0001\u0010AR\u001c\u00103\u001a\u00020\fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010K\"\u0005\b\u0095\u0001\u0010MR\u001c\u00104\u001a\u00020\u0006X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u0010?\"\u0005\b\u0097\u0001\u0010AR\u001c\u00105\u001a\u00020\u0006X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u0010?\"\u0005\b\u0099\u0001\u0010A¨\u0006Í\u0001"}, d2 = {"Lcom/studiolaganne/lengendarylens/Player;", "Ljava/io/Serializable;", "version", "", "name", "lifeTotal", "", "startingLifeTotal", "poisonCounters", "energyCounters", "stormCount", "monarch", "", "cityBlessing", "backgroundType", "Lcom/studiolaganne/lengendarylens/BackgroundType;", "leftBackgroundType", "backgroundPlainColor", "backgroundCardId", "leftBackgroundCardId", "playmatId", "leftPlaymatId", "photoUri", "leftPhotoUri", "backgroundColor", "leftBackgroundColor", "backgroundMtgColors", "", "Lcom/studiolaganne/lengendarylens/MTGColor;", "commanderDamageList", "", "commanderDamageListPartner", "isKO", "hasPartners", "energyEnabled", "stormEnabled", "userId", "deckId", "scryfallId", "leftScryfallId", "isPlaneswalker", "leftIsPlaneswalker", "resultid", "taxEnabled", "taxCount", "experienceEnabled", "experienceCount", "radiationEnabled", "radiationCount", "initiative", "undercityRoomId", "theRing", "theRingLevel", "taxCountPartner", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIIIIZZLcom/studiolaganne/lengendarylens/BackgroundType;Lcom/studiolaganne/lengendarylens/BackgroundType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;ZZZZIILjava/lang/String;Ljava/lang/String;ZZIZIZIZIZIZII)V", "getVersion", "()Ljava/lang/String;", "setVersion", "(Ljava/lang/String;)V", "getName", "setName", "getLifeTotal", "()I", "setLifeTotal", "(I)V", "getStartingLifeTotal", "setStartingLifeTotal", "getPoisonCounters", "setPoisonCounters", "getEnergyCounters", "setEnergyCounters", "getStormCount", "setStormCount", "getMonarch", "()Z", "setMonarch", "(Z)V", "getCityBlessing", "setCityBlessing", "getBackgroundType", "()Lcom/studiolaganne/lengendarylens/BackgroundType;", "setBackgroundType", "(Lcom/studiolaganne/lengendarylens/BackgroundType;)V", "getLeftBackgroundType", "setLeftBackgroundType", "getBackgroundPlainColor", "setBackgroundPlainColor", "getBackgroundCardId", "setBackgroundCardId", "getLeftBackgroundCardId", "setLeftBackgroundCardId", "getPlaymatId", "setPlaymatId", "getLeftPlaymatId", "setLeftPlaymatId", "getPhotoUri", "setPhotoUri", "getLeftPhotoUri", "setLeftPhotoUri", "getBackgroundColor", "setBackgroundColor", "getLeftBackgroundColor", "setLeftBackgroundColor", "getBackgroundMtgColors", "()Ljava/util/List;", "setBackgroundMtgColors", "(Ljava/util/List;)V", "getCommanderDamageList", "setCommanderDamageList", "getCommanderDamageListPartner", "setCommanderDamageListPartner", "setKO", "getHasPartners", "setHasPartners", "getEnergyEnabled", "setEnergyEnabled", "getStormEnabled", "setStormEnabled", "getUserId", "setUserId", "getDeckId", "setDeckId", "getScryfallId", "setScryfallId", "getLeftScryfallId", "setLeftScryfallId", "setPlaneswalker", "getLeftIsPlaneswalker", "setLeftIsPlaneswalker", "getResultid", "setResultid", "getTaxEnabled", "setTaxEnabled", "getTaxCount", "setTaxCount", "getExperienceEnabled", "setExperienceEnabled", "getExperienceCount", "setExperienceCount", "getRadiationEnabled", "setRadiationEnabled", "getRadiationCount", "setRadiationCount", "getInitiative", "setInitiative", "getUndercityRoomId", "setUndercityRoomId", "getTheRing", "setTheRing", "getTheRingLevel", "setTheRingLevel", "getTaxCountPartner", "setTaxCountPartner", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "copy", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class Player implements Serializable {
    public static final int $stable = 8;
    private String backgroundCardId;
    private String backgroundColor;
    private List<? extends MTGColor> backgroundMtgColors;
    private String backgroundPlainColor;
    private BackgroundType backgroundType;
    private boolean cityBlessing;
    private List<Integer> commanderDamageList;
    private List<Integer> commanderDamageListPartner;
    private int deckId;
    private int energyCounters;
    private boolean energyEnabled;
    private int experienceCount;
    private boolean experienceEnabled;
    private boolean hasPartners;
    private boolean initiative;
    private boolean isKO;
    private boolean isPlaneswalker;
    private String leftBackgroundCardId;
    private String leftBackgroundColor;
    private BackgroundType leftBackgroundType;
    private boolean leftIsPlaneswalker;
    private String leftPhotoUri;
    private String leftPlaymatId;
    private String leftScryfallId;
    private int lifeTotal;
    private boolean monarch;
    private String name;
    private String photoUri;
    private String playmatId;
    private int poisonCounters;
    private int radiationCount;
    private boolean radiationEnabled;
    private int resultid;
    private String scryfallId;
    private int startingLifeTotal;
    private int stormCount;
    private boolean stormEnabled;
    private int taxCount;
    private int taxCountPartner;
    private boolean taxEnabled;
    private boolean theRing;
    private int theRingLevel;
    private int undercityRoomId;
    private int userId;
    private String version;

    public Player() {
        this(null, null, 0, 0, 0, 0, 0, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, false, 0, 0, null, null, false, false, 0, false, 0, false, 0, false, 0, false, 0, false, 0, 0, -1, 8191, null);
    }

    public Player(String version, String name, int i, int i2, int i3, int i4, int i5, boolean z, boolean z2, BackgroundType backgroundType, BackgroundType leftBackgroundType, String backgroundPlainColor, String backgroundCardId, String leftBackgroundCardId, String playmatId, String leftPlaymatId, String photoUri, String leftPhotoUri, String backgroundColor, String leftBackgroundColor, List<? extends MTGColor> backgroundMtgColors, List<Integer> commanderDamageList, List<Integer> commanderDamageListPartner, boolean z3, boolean z4, boolean z5, boolean z6, int i6, int i7, String scryfallId, String leftScryfallId, boolean z7, boolean z8, int i8, boolean z9, int i9, boolean z10, int i10, boolean z11, int i11, boolean z12, int i12, boolean z13, int i13, int i14) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(backgroundType, "backgroundType");
        Intrinsics.checkNotNullParameter(leftBackgroundType, "leftBackgroundType");
        Intrinsics.checkNotNullParameter(backgroundPlainColor, "backgroundPlainColor");
        Intrinsics.checkNotNullParameter(backgroundCardId, "backgroundCardId");
        Intrinsics.checkNotNullParameter(leftBackgroundCardId, "leftBackgroundCardId");
        Intrinsics.checkNotNullParameter(playmatId, "playmatId");
        Intrinsics.checkNotNullParameter(leftPlaymatId, "leftPlaymatId");
        Intrinsics.checkNotNullParameter(photoUri, "photoUri");
        Intrinsics.checkNotNullParameter(leftPhotoUri, "leftPhotoUri");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(leftBackgroundColor, "leftBackgroundColor");
        Intrinsics.checkNotNullParameter(backgroundMtgColors, "backgroundMtgColors");
        Intrinsics.checkNotNullParameter(commanderDamageList, "commanderDamageList");
        Intrinsics.checkNotNullParameter(commanderDamageListPartner, "commanderDamageListPartner");
        Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
        Intrinsics.checkNotNullParameter(leftScryfallId, "leftScryfallId");
        this.version = version;
        this.name = name;
        this.lifeTotal = i;
        this.startingLifeTotal = i2;
        this.poisonCounters = i3;
        this.energyCounters = i4;
        this.stormCount = i5;
        this.monarch = z;
        this.cityBlessing = z2;
        this.backgroundType = backgroundType;
        this.leftBackgroundType = leftBackgroundType;
        this.backgroundPlainColor = backgroundPlainColor;
        this.backgroundCardId = backgroundCardId;
        this.leftBackgroundCardId = leftBackgroundCardId;
        this.playmatId = playmatId;
        this.leftPlaymatId = leftPlaymatId;
        this.photoUri = photoUri;
        this.leftPhotoUri = leftPhotoUri;
        this.backgroundColor = backgroundColor;
        this.leftBackgroundColor = leftBackgroundColor;
        this.backgroundMtgColors = backgroundMtgColors;
        this.commanderDamageList = commanderDamageList;
        this.commanderDamageListPartner = commanderDamageListPartner;
        this.isKO = z3;
        this.hasPartners = z4;
        this.energyEnabled = z5;
        this.stormEnabled = z6;
        this.userId = i6;
        this.deckId = i7;
        this.scryfallId = scryfallId;
        this.leftScryfallId = leftScryfallId;
        this.isPlaneswalker = z7;
        this.leftIsPlaneswalker = z8;
        this.resultid = i8;
        this.taxEnabled = z9;
        this.taxCount = i9;
        this.experienceEnabled = z10;
        this.experienceCount = i10;
        this.radiationEnabled = z11;
        this.radiationCount = i11;
        this.initiative = z12;
        this.undercityRoomId = i12;
        this.theRing = z13;
        this.theRingLevel = i13;
        this.taxCountPartner = i14;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ Player(String str, String str2, int i, int i2, int i3, int i4, int i5, boolean z, boolean z2, BackgroundType backgroundType, BackgroundType backgroundType2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, List list, List list2, List list3, boolean z3, boolean z4, boolean z5, boolean z6, int i6, int i7, String str12, String str13, boolean z7, boolean z8, int i8, boolean z9, int i9, boolean z10, int i10, boolean z11, int i11, boolean z12, int i12, boolean z13, int i13, int i14, int i15, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        String str14 = (i15 & 1) != 0 ? "v8" : str;
        this(str14, (i15 & 2) != 0 ? "" : str2, (i15 & 4) != 0 ? 0 : i, (i15 & 8) != 0 ? 0 : i2, (i15 & 16) != 0 ? 0 : i3, (i15 & 32) != 0 ? 0 : i4, (i15 & 64) != 0 ? 0 : i5, (i15 & 128) != 0 ? false : z, (i15 & 256) != 0 ? false : z2, (i15 & 512) != 0 ? BackgroundType.PLAIN_COLOR : backgroundType, (i15 & 1024) != 0 ? BackgroundType.NONE : backgroundType2, (i15 & 2048) != 0 ? "" : str3, (i15 & 4096) != 0 ? "" : str4, (i15 & 8192) != 0 ? "" : str5, (i15 & 16384) != 0 ? "" : str6, (i15 & 32768) != 0 ? "" : str7, (i15 & 65536) != 0 ? "" : str8, (i15 & 131072) != 0 ? "" : str9, (i15 & 262144) != 0 ? "" : str10, (i15 & 524288) != 0 ? "" : str11, (i15 & 1048576) != 0 ? CollectionsKt.emptyList() : list, (i15 & 2097152) != 0 ? new ArrayList() : list2, (i15 & 4194304) != 0 ? new ArrayList() : list3, (i15 & 8388608) != 0 ? false : z3, (i15 & 16777216) != 0 ? false : z4, (i15 & 33554432) != 0 ? false : z5, (i15 & 67108864) != 0 ? false : z6, (i15 & 134217728) != 0 ? 0 : i6, (i15 & 268435456) != 0 ? -1 : i7, (i15 & 536870912) != 0 ? "" : str12, (i15 & 1073741824) == 0 ? str13 : "", (i15 & Integer.MIN_VALUE) != 0 ? false : z7, (i16 & 1) != 0 ? false : z8, (i16 & 2) != 0 ? -1 : i8, (i16 & 4) != 0 ? false : z9, (i16 & 8) != 0 ? 0 : i9, (i16 & 16) != 0 ? false : z10, (i16 & 32) != 0 ? 0 : i10, (i16 & 64) != 0 ? false : z11, (i16 & 128) != 0 ? 0 : i11, (i16 & 256) != 0 ? false : z12, (i16 & 512) != 0 ? -1 : i12, (i16 & 1024) != 0 ? false : z13, (i16 & 2048) == 0 ? i13 : -1, (i16 & 4096) != 0 ? 0 : i14);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Player copy$default(Player player, String str, String str2, int i, int i2, int i3, int i4, int i5, boolean z, boolean z2, BackgroundType backgroundType, BackgroundType backgroundType2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, List list, List list2, List list3, boolean z3, boolean z4, boolean z5, boolean z6, int i6, int i7, String str12, String str13, boolean z7, boolean z8, int i8, boolean z9, int i9, boolean z10, int i10, boolean z11, int i11, boolean z12, int i12, boolean z13, int i13, int i14, int i15, int i16, Object obj) {
        String str14 = (i15 & 1) != 0 ? player.version : str;
        return player.copy(str14, (i15 & 2) != 0 ? player.name : str2, (i15 & 4) != 0 ? player.lifeTotal : i, (i15 & 8) != 0 ? player.startingLifeTotal : i2, (i15 & 16) != 0 ? player.poisonCounters : i3, (i15 & 32) != 0 ? player.energyCounters : i4, (i15 & 64) != 0 ? player.stormCount : i5, (i15 & 128) != 0 ? player.monarch : z, (i15 & 256) != 0 ? player.cityBlessing : z2, (i15 & 512) != 0 ? player.backgroundType : backgroundType, (i15 & 1024) != 0 ? player.leftBackgroundType : backgroundType2, (i15 & 2048) != 0 ? player.backgroundPlainColor : str3, (i15 & 4096) != 0 ? player.backgroundCardId : str4, (i15 & 8192) != 0 ? player.leftBackgroundCardId : str5, (i15 & 16384) != 0 ? player.playmatId : str6, (i15 & 32768) != 0 ? player.leftPlaymatId : str7, (i15 & 65536) != 0 ? player.photoUri : str8, (i15 & 131072) != 0 ? player.leftPhotoUri : str9, (i15 & 262144) != 0 ? player.backgroundColor : str10, (i15 & 524288) != 0 ? player.leftBackgroundColor : str11, (i15 & 1048576) != 0 ? player.backgroundMtgColors : list, (i15 & 2097152) != 0 ? player.commanderDamageList : list2, (i15 & 4194304) != 0 ? player.commanderDamageListPartner : list3, (i15 & 8388608) != 0 ? player.isKO : z3, (i15 & 16777216) != 0 ? player.hasPartners : z4, (i15 & 33554432) != 0 ? player.energyEnabled : z5, (i15 & 67108864) != 0 ? player.stormEnabled : z6, (i15 & 134217728) != 0 ? player.userId : i6, (i15 & 268435456) != 0 ? player.deckId : i7, (i15 & 536870912) != 0 ? player.scryfallId : str12, (i15 & 1073741824) != 0 ? player.leftScryfallId : str13, (i15 & Integer.MIN_VALUE) != 0 ? player.isPlaneswalker : z7, (i16 & 1) != 0 ? player.leftIsPlaneswalker : z8, (i16 & 2) != 0 ? player.resultid : i8, (i16 & 4) != 0 ? player.taxEnabled : z9, (i16 & 8) != 0 ? player.taxCount : i9, (i16 & 16) != 0 ? player.experienceEnabled : z10, (i16 & 32) != 0 ? player.experienceCount : i10, (i16 & 64) != 0 ? player.radiationEnabled : z11, (i16 & 128) != 0 ? player.radiationCount : i11, (i16 & 256) != 0 ? player.initiative : z12, (i16 & 512) != 0 ? player.undercityRoomId : i12, (i16 & 1024) != 0 ? player.theRing : z13, (i16 & 2048) != 0 ? player.theRingLevel : i13, (i16 & 4096) != 0 ? player.taxCountPartner : i14);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final BackgroundType getBackgroundType() {
        return this.backgroundType;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final BackgroundType getLeftBackgroundType() {
        return this.leftBackgroundType;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getBackgroundPlainColor() {
        return this.backgroundPlainColor;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getBackgroundCardId() {
        return this.backgroundCardId;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getLeftBackgroundCardId() {
        return this.leftBackgroundCardId;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getPlaymatId() {
        return this.playmatId;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getLeftPlaymatId() {
        return this.leftPlaymatId;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getPhotoUri() {
        return this.photoUri;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getLeftPhotoUri() {
        return this.leftPhotoUri;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getLeftBackgroundColor() {
        return this.leftBackgroundColor;
    }

    public final List<MTGColor> component21() {
        return this.backgroundMtgColors;
    }

    public final List<Integer> component22() {
        return this.commanderDamageList;
    }

    public final List<Integer> component23() {
        return this.commanderDamageListPartner;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final boolean getIsKO() {
        return this.isKO;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final boolean getHasPartners() {
        return this.hasPartners;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final boolean getEnergyEnabled() {
        return this.energyEnabled;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final boolean getStormEnabled() {
        return this.stormEnabled;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final int getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final int getDeckId() {
        return this.deckId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getLifeTotal() {
        return this.lifeTotal;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final String getScryfallId() {
        return this.scryfallId;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final String getLeftScryfallId() {
        return this.leftScryfallId;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final boolean getIsPlaneswalker() {
        return this.isPlaneswalker;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final boolean getLeftIsPlaneswalker() {
        return this.leftIsPlaneswalker;
    }

    /* JADX INFO: renamed from: component34, reason: from getter */
    public final int getResultid() {
        return this.resultid;
    }

    /* JADX INFO: renamed from: component35, reason: from getter */
    public final boolean getTaxEnabled() {
        return this.taxEnabled;
    }

    /* JADX INFO: renamed from: component36, reason: from getter */
    public final int getTaxCount() {
        return this.taxCount;
    }

    /* JADX INFO: renamed from: component37, reason: from getter */
    public final boolean getExperienceEnabled() {
        return this.experienceEnabled;
    }

    /* JADX INFO: renamed from: component38, reason: from getter */
    public final int getExperienceCount() {
        return this.experienceCount;
    }

    /* JADX INFO: renamed from: component39, reason: from getter */
    public final boolean getRadiationEnabled() {
        return this.radiationEnabled;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getStartingLifeTotal() {
        return this.startingLifeTotal;
    }

    /* JADX INFO: renamed from: component40, reason: from getter */
    public final int getRadiationCount() {
        return this.radiationCount;
    }

    /* JADX INFO: renamed from: component41, reason: from getter */
    public final boolean getInitiative() {
        return this.initiative;
    }

    /* JADX INFO: renamed from: component42, reason: from getter */
    public final int getUndercityRoomId() {
        return this.undercityRoomId;
    }

    /* JADX INFO: renamed from: component43, reason: from getter */
    public final boolean getTheRing() {
        return this.theRing;
    }

    /* JADX INFO: renamed from: component44, reason: from getter */
    public final int getTheRingLevel() {
        return this.theRingLevel;
    }

    /* JADX INFO: renamed from: component45, reason: from getter */
    public final int getTaxCountPartner() {
        return this.taxCountPartner;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getPoisonCounters() {
        return this.poisonCounters;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getEnergyCounters() {
        return this.energyCounters;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getStormCount() {
        return this.stormCount;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getMonarch() {
        return this.monarch;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getCityBlessing() {
        return this.cityBlessing;
    }

    public final Player copy(String version, String name, int lifeTotal, int startingLifeTotal, int poisonCounters, int energyCounters, int stormCount, boolean monarch, boolean cityBlessing, BackgroundType backgroundType, BackgroundType leftBackgroundType, String backgroundPlainColor, String backgroundCardId, String leftBackgroundCardId, String playmatId, String leftPlaymatId, String photoUri, String leftPhotoUri, String backgroundColor, String leftBackgroundColor, List<? extends MTGColor> backgroundMtgColors, List<Integer> commanderDamageList, List<Integer> commanderDamageListPartner, boolean isKO, boolean hasPartners, boolean energyEnabled, boolean stormEnabled, int userId, int deckId, String scryfallId, String leftScryfallId, boolean isPlaneswalker, boolean leftIsPlaneswalker, int resultid, boolean taxEnabled, int taxCount, boolean experienceEnabled, int experienceCount, boolean radiationEnabled, int radiationCount, boolean initiative, int undercityRoomId, boolean theRing, int theRingLevel, int taxCountPartner) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(backgroundType, "backgroundType");
        Intrinsics.checkNotNullParameter(leftBackgroundType, "leftBackgroundType");
        Intrinsics.checkNotNullParameter(backgroundPlainColor, "backgroundPlainColor");
        Intrinsics.checkNotNullParameter(backgroundCardId, "backgroundCardId");
        Intrinsics.checkNotNullParameter(leftBackgroundCardId, "leftBackgroundCardId");
        Intrinsics.checkNotNullParameter(playmatId, "playmatId");
        Intrinsics.checkNotNullParameter(leftPlaymatId, "leftPlaymatId");
        Intrinsics.checkNotNullParameter(photoUri, "photoUri");
        Intrinsics.checkNotNullParameter(leftPhotoUri, "leftPhotoUri");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(leftBackgroundColor, "leftBackgroundColor");
        Intrinsics.checkNotNullParameter(backgroundMtgColors, "backgroundMtgColors");
        Intrinsics.checkNotNullParameter(commanderDamageList, "commanderDamageList");
        Intrinsics.checkNotNullParameter(commanderDamageListPartner, "commanderDamageListPartner");
        Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
        Intrinsics.checkNotNullParameter(leftScryfallId, "leftScryfallId");
        return new Player(version, name, lifeTotal, startingLifeTotal, poisonCounters, energyCounters, stormCount, monarch, cityBlessing, backgroundType, leftBackgroundType, backgroundPlainColor, backgroundCardId, leftBackgroundCardId, playmatId, leftPlaymatId, photoUri, leftPhotoUri, backgroundColor, leftBackgroundColor, backgroundMtgColors, commanderDamageList, commanderDamageListPartner, isKO, hasPartners, energyEnabled, stormEnabled, userId, deckId, scryfallId, leftScryfallId, isPlaneswalker, leftIsPlaneswalker, resultid, taxEnabled, taxCount, experienceEnabled, experienceCount, radiationEnabled, radiationCount, initiative, undercityRoomId, theRing, theRingLevel, taxCountPartner);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Player)) {
            return false;
        }
        Player player = (Player) other;
        return Intrinsics.areEqual(this.version, player.version) && Intrinsics.areEqual(this.name, player.name) && this.lifeTotal == player.lifeTotal && this.startingLifeTotal == player.startingLifeTotal && this.poisonCounters == player.poisonCounters && this.energyCounters == player.energyCounters && this.stormCount == player.stormCount && this.monarch == player.monarch && this.cityBlessing == player.cityBlessing && this.backgroundType == player.backgroundType && this.leftBackgroundType == player.leftBackgroundType && Intrinsics.areEqual(this.backgroundPlainColor, player.backgroundPlainColor) && Intrinsics.areEqual(this.backgroundCardId, player.backgroundCardId) && Intrinsics.areEqual(this.leftBackgroundCardId, player.leftBackgroundCardId) && Intrinsics.areEqual(this.playmatId, player.playmatId) && Intrinsics.areEqual(this.leftPlaymatId, player.leftPlaymatId) && Intrinsics.areEqual(this.photoUri, player.photoUri) && Intrinsics.areEqual(this.leftPhotoUri, player.leftPhotoUri) && Intrinsics.areEqual(this.backgroundColor, player.backgroundColor) && Intrinsics.areEqual(this.leftBackgroundColor, player.leftBackgroundColor) && Intrinsics.areEqual(this.backgroundMtgColors, player.backgroundMtgColors) && Intrinsics.areEqual(this.commanderDamageList, player.commanderDamageList) && Intrinsics.areEqual(this.commanderDamageListPartner, player.commanderDamageListPartner) && this.isKO == player.isKO && this.hasPartners == player.hasPartners && this.energyEnabled == player.energyEnabled && this.stormEnabled == player.stormEnabled && this.userId == player.userId && this.deckId == player.deckId && Intrinsics.areEqual(this.scryfallId, player.scryfallId) && Intrinsics.areEqual(this.leftScryfallId, player.leftScryfallId) && this.isPlaneswalker == player.isPlaneswalker && this.leftIsPlaneswalker == player.leftIsPlaneswalker && this.resultid == player.resultid && this.taxEnabled == player.taxEnabled && this.taxCount == player.taxCount && this.experienceEnabled == player.experienceEnabled && this.experienceCount == player.experienceCount && this.radiationEnabled == player.radiationEnabled && this.radiationCount == player.radiationCount && this.initiative == player.initiative && this.undercityRoomId == player.undercityRoomId && this.theRing == player.theRing && this.theRingLevel == player.theRingLevel && this.taxCountPartner == player.taxCountPartner;
    }

    public final String getBackgroundCardId() {
        return this.backgroundCardId;
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final List<MTGColor> getBackgroundMtgColors() {
        return this.backgroundMtgColors;
    }

    public final String getBackgroundPlainColor() {
        return this.backgroundPlainColor;
    }

    public final BackgroundType getBackgroundType() {
        return this.backgroundType;
    }

    public final boolean getCityBlessing() {
        return this.cityBlessing;
    }

    public final List<Integer> getCommanderDamageList() {
        return this.commanderDamageList;
    }

    public final List<Integer> getCommanderDamageListPartner() {
        return this.commanderDamageListPartner;
    }

    public final int getDeckId() {
        return this.deckId;
    }

    public final int getEnergyCounters() {
        return this.energyCounters;
    }

    public final boolean getEnergyEnabled() {
        return this.energyEnabled;
    }

    public final int getExperienceCount() {
        return this.experienceCount;
    }

    public final boolean getExperienceEnabled() {
        return this.experienceEnabled;
    }

    public final boolean getHasPartners() {
        return this.hasPartners;
    }

    public final boolean getInitiative() {
        return this.initiative;
    }

    public final String getLeftBackgroundCardId() {
        return this.leftBackgroundCardId;
    }

    public final String getLeftBackgroundColor() {
        return this.leftBackgroundColor;
    }

    public final BackgroundType getLeftBackgroundType() {
        return this.leftBackgroundType;
    }

    public final boolean getLeftIsPlaneswalker() {
        return this.leftIsPlaneswalker;
    }

    public final String getLeftPhotoUri() {
        return this.leftPhotoUri;
    }

    public final String getLeftPlaymatId() {
        return this.leftPlaymatId;
    }

    public final String getLeftScryfallId() {
        return this.leftScryfallId;
    }

    public final int getLifeTotal() {
        return this.lifeTotal;
    }

    public final boolean getMonarch() {
        return this.monarch;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPhotoUri() {
        return this.photoUri;
    }

    public final String getPlaymatId() {
        return this.playmatId;
    }

    public final int getPoisonCounters() {
        return this.poisonCounters;
    }

    public final int getRadiationCount() {
        return this.radiationCount;
    }

    public final boolean getRadiationEnabled() {
        return this.radiationEnabled;
    }

    public final int getResultid() {
        return this.resultid;
    }

    public final String getScryfallId() {
        return this.scryfallId;
    }

    public final int getStartingLifeTotal() {
        return this.startingLifeTotal;
    }

    public final int getStormCount() {
        return this.stormCount;
    }

    public final boolean getStormEnabled() {
        return this.stormEnabled;
    }

    public final int getTaxCount() {
        return this.taxCount;
    }

    public final int getTaxCountPartner() {
        return this.taxCountPartner;
    }

    public final boolean getTaxEnabled() {
        return this.taxEnabled;
    }

    public final boolean getTheRing() {
        return this.theRing;
    }

    public final int getTheRingLevel() {
        return this.theRingLevel;
    }

    public final int getUndercityRoomId() {
        return this.undercityRoomId;
    }

    public final int getUserId() {
        return this.userId;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.version.hashCode() * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.lifeTotal)) * 31) + Integer.hashCode(this.startingLifeTotal)) * 31) + Integer.hashCode(this.poisonCounters)) * 31) + Integer.hashCode(this.energyCounters)) * 31) + Integer.hashCode(this.stormCount)) * 31) + Boolean.hashCode(this.monarch)) * 31) + Boolean.hashCode(this.cityBlessing)) * 31) + this.backgroundType.hashCode()) * 31) + this.leftBackgroundType.hashCode()) * 31) + this.backgroundPlainColor.hashCode()) * 31) + this.backgroundCardId.hashCode()) * 31) + this.leftBackgroundCardId.hashCode()) * 31) + this.playmatId.hashCode()) * 31) + this.leftPlaymatId.hashCode()) * 31) + this.photoUri.hashCode()) * 31) + this.leftPhotoUri.hashCode()) * 31) + this.backgroundColor.hashCode()) * 31) + this.leftBackgroundColor.hashCode()) * 31) + this.backgroundMtgColors.hashCode()) * 31) + this.commanderDamageList.hashCode()) * 31) + this.commanderDamageListPartner.hashCode()) * 31) + Boolean.hashCode(this.isKO)) * 31) + Boolean.hashCode(this.hasPartners)) * 31) + Boolean.hashCode(this.energyEnabled)) * 31) + Boolean.hashCode(this.stormEnabled)) * 31) + Integer.hashCode(this.userId)) * 31) + Integer.hashCode(this.deckId)) * 31) + this.scryfallId.hashCode()) * 31) + this.leftScryfallId.hashCode()) * 31) + Boolean.hashCode(this.isPlaneswalker)) * 31) + Boolean.hashCode(this.leftIsPlaneswalker)) * 31) + Integer.hashCode(this.resultid)) * 31) + Boolean.hashCode(this.taxEnabled)) * 31) + Integer.hashCode(this.taxCount)) * 31) + Boolean.hashCode(this.experienceEnabled)) * 31) + Integer.hashCode(this.experienceCount)) * 31) + Boolean.hashCode(this.radiationEnabled)) * 31) + Integer.hashCode(this.radiationCount)) * 31) + Boolean.hashCode(this.initiative)) * 31) + Integer.hashCode(this.undercityRoomId)) * 31) + Boolean.hashCode(this.theRing)) * 31) + Integer.hashCode(this.theRingLevel)) * 31) + Integer.hashCode(this.taxCountPartner);
    }

    public final boolean isKO() {
        return this.isKO;
    }

    public final boolean isPlaneswalker() {
        return this.isPlaneswalker;
    }

    public final void setBackgroundCardId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.backgroundCardId = str;
    }

    public final void setBackgroundColor(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.backgroundColor = str;
    }

    public final void setBackgroundMtgColors(List<? extends MTGColor> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.backgroundMtgColors = list;
    }

    public final void setBackgroundPlainColor(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.backgroundPlainColor = str;
    }

    public final void setBackgroundType(BackgroundType backgroundType) {
        Intrinsics.checkNotNullParameter(backgroundType, "<set-?>");
        this.backgroundType = backgroundType;
    }

    public final void setCityBlessing(boolean z) {
        this.cityBlessing = z;
    }

    public final void setCommanderDamageList(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.commanderDamageList = list;
    }

    public final void setCommanderDamageListPartner(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.commanderDamageListPartner = list;
    }

    public final void setDeckId(int i) {
        this.deckId = i;
    }

    public final void setEnergyCounters(int i) {
        this.energyCounters = i;
    }

    public final void setEnergyEnabled(boolean z) {
        this.energyEnabled = z;
    }

    public final void setExperienceCount(int i) {
        this.experienceCount = i;
    }

    public final void setExperienceEnabled(boolean z) {
        this.experienceEnabled = z;
    }

    public final void setHasPartners(boolean z) {
        this.hasPartners = z;
    }

    public final void setInitiative(boolean z) {
        this.initiative = z;
    }

    public final void setKO(boolean z) {
        this.isKO = z;
    }

    public final void setLeftBackgroundCardId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.leftBackgroundCardId = str;
    }

    public final void setLeftBackgroundColor(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.leftBackgroundColor = str;
    }

    public final void setLeftBackgroundType(BackgroundType backgroundType) {
        Intrinsics.checkNotNullParameter(backgroundType, "<set-?>");
        this.leftBackgroundType = backgroundType;
    }

    public final void setLeftIsPlaneswalker(boolean z) {
        this.leftIsPlaneswalker = z;
    }

    public final void setLeftPhotoUri(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.leftPhotoUri = str;
    }

    public final void setLeftPlaymatId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.leftPlaymatId = str;
    }

    public final void setLeftScryfallId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.leftScryfallId = str;
    }

    public final void setLifeTotal(int i) {
        this.lifeTotal = i;
    }

    public final void setMonarch(boolean z) {
        this.monarch = z;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setPhotoUri(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.photoUri = str;
    }

    public final void setPlaneswalker(boolean z) {
        this.isPlaneswalker = z;
    }

    public final void setPlaymatId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.playmatId = str;
    }

    public final void setPoisonCounters(int i) {
        this.poisonCounters = i;
    }

    public final void setRadiationCount(int i) {
        this.radiationCount = i;
    }

    public final void setRadiationEnabled(boolean z) {
        this.radiationEnabled = z;
    }

    public final void setResultid(int i) {
        this.resultid = i;
    }

    public final void setScryfallId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.scryfallId = str;
    }

    public final void setStartingLifeTotal(int i) {
        this.startingLifeTotal = i;
    }

    public final void setStormCount(int i) {
        this.stormCount = i;
    }

    public final void setStormEnabled(boolean z) {
        this.stormEnabled = z;
    }

    public final void setTaxCount(int i) {
        this.taxCount = i;
    }

    public final void setTaxCountPartner(int i) {
        this.taxCountPartner = i;
    }

    public final void setTaxEnabled(boolean z) {
        this.taxEnabled = z;
    }

    public final void setTheRing(boolean z) {
        this.theRing = z;
    }

    public final void setTheRingLevel(int i) {
        this.theRingLevel = i;
    }

    public final void setUndercityRoomId(int i) {
        this.undercityRoomId = i;
    }

    public final void setUserId(int i) {
        this.userId = i;
    }

    public final void setVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.version = str;
    }

    public String toString() {
        return "Player(version=" + this.version + ", name=" + this.name + ", lifeTotal=" + this.lifeTotal + ", startingLifeTotal=" + this.startingLifeTotal + ", poisonCounters=" + this.poisonCounters + ", energyCounters=" + this.energyCounters + ", stormCount=" + this.stormCount + ", monarch=" + this.monarch + ", cityBlessing=" + this.cityBlessing + ", backgroundType=" + this.backgroundType + ", leftBackgroundType=" + this.leftBackgroundType + ", backgroundPlainColor=" + this.backgroundPlainColor + ", backgroundCardId=" + this.backgroundCardId + ", leftBackgroundCardId=" + this.leftBackgroundCardId + ", playmatId=" + this.playmatId + ", leftPlaymatId=" + this.leftPlaymatId + ", photoUri=" + this.photoUri + ", leftPhotoUri=" + this.leftPhotoUri + ", backgroundColor=" + this.backgroundColor + ", leftBackgroundColor=" + this.leftBackgroundColor + ", backgroundMtgColors=" + this.backgroundMtgColors + ", commanderDamageList=" + this.commanderDamageList + ", commanderDamageListPartner=" + this.commanderDamageListPartner + ", isKO=" + this.isKO + ", hasPartners=" + this.hasPartners + ", energyEnabled=" + this.energyEnabled + ", stormEnabled=" + this.stormEnabled + ", userId=" + this.userId + ", deckId=" + this.deckId + ", scryfallId=" + this.scryfallId + ", leftScryfallId=" + this.leftScryfallId + ", isPlaneswalker=" + this.isPlaneswalker + ", leftIsPlaneswalker=" + this.leftIsPlaneswalker + ", resultid=" + this.resultid + ", taxEnabled=" + this.taxEnabled + ", taxCount=" + this.taxCount + ", experienceEnabled=" + this.experienceEnabled + ", experienceCount=" + this.experienceCount + ", radiationEnabled=" + this.radiationEnabled + ", radiationCount=" + this.radiationCount + ", initiative=" + this.initiative + ", undercityRoomId=" + this.undercityRoomId + ", theRing=" + this.theRing + ", theRingLevel=" + this.theRingLevel + ", taxCountPartner=" + this.taxCountPartner + ")";
    }
}
