package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0003\b¼\u0001\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bù\u0003\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\r\u0012\b\b\u0002\u0010\u001e\u001a\u00020\n\u0012\b\b\u0002\u0010\u001f\u001a\u00020\n\u0012\b\b\u0002\u0010 \u001a\u00020\n\u0012\b\b\u0002\u0010!\u001a\u00020\n\u0012\b\b\u0002\u0010\"\u001a\u00020\n\u0012\b\b\u0002\u0010#\u001a\u00020\n\u0012\b\b\u0002\u0010$\u001a\u00020\u0005\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\b\b\u0002\u0010&\u001a\u00020\u0014\u0012\b\b\u0002\u0010'\u001a\u00020\u0005\u0012\b\b\u0002\u0010(\u001a\u00020\n\u0012\b\b\u0002\u0010)\u001a\u00020\n\u0012\b\b\u0002\u0010*\u001a\u00020\u0005\u0012\b\b\u0002\u0010+\u001a\u00020\u0005\u0012\b\b\u0002\u0010,\u001a\u00020\u0014\u0012\b\b\u0002\u0010-\u001a\u00020\u0005\u0012\b\b\u0002\u0010.\u001a\u00020\n\u0012\b\b\u0002\u0010/\u001a\u00020\n\u0012\b\b\u0002\u00100\u001a\u00020\u0003\u0012\b\b\u0002\u00101\u001a\u00020\n\u0012\b\b\u0002\u00102\u001a\u00020\u0003\u0012\b\b\u0002\u00103\u001a\u00020\u0005\u0012\b\b\u0002\u00104\u001a\u00020\u0005\u0012\b\b\u0002\u00105\u001a\u00020\n\u0012\b\b\u0002\u00106\u001a\u00020\u0003\u0012\b\b\u0002\u00107\u001a\u00020\u0005\u0012\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020\u00030\r\u0012\b\b\u0002\u00109\u001a\u00020\u0005¢\u0006\u0004\b:\u0010;J\n\u0010§\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¨\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010©\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010ª\u0001\u001a\u00020\bHÆ\u0003J\n\u0010«\u0001\u001a\u00020\nHÆ\u0003J\n\u0010¬\u0001\u001a\u00020\nHÆ\u0003J\u0010\u0010\u00ad\u0001\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\n\u0010®\u0001\u001a\u00020\nHÆ\u0003J\n\u0010¯\u0001\u001a\u00020\nHÆ\u0003J\n\u0010°\u0001\u001a\u00020\nHÆ\u0003J\n\u0010±\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010²\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010³\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010´\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010µ\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010¶\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010·\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010¸\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¹\u0001\u001a\u00020\u0003HÆ\u0003J\u0010\u0010º\u0001\u001a\b\u0012\u0004\u0012\u00020\u001d0\rHÆ\u0003J\n\u0010»\u0001\u001a\u00020\nHÆ\u0003J\n\u0010¼\u0001\u001a\u00020\nHÆ\u0003J\n\u0010½\u0001\u001a\u00020\nHÆ\u0003J\n\u0010¾\u0001\u001a\u00020\nHÆ\u0003J\n\u0010¿\u0001\u001a\u00020\nHÆ\u0003J\n\u0010À\u0001\u001a\u00020\nHÆ\u0003J\n\u0010Á\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010Â\u0001\u001a\u00020\nHÆ\u0003J\n\u0010Ã\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010Ä\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010Å\u0001\u001a\u00020\nHÆ\u0003J\n\u0010Æ\u0001\u001a\u00020\nHÆ\u0003J\n\u0010Ç\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010È\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010É\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010Ê\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010Ë\u0001\u001a\u00020\nHÆ\u0003J\n\u0010Ì\u0001\u001a\u00020\nHÆ\u0003J\n\u0010Í\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Î\u0001\u001a\u00020\nHÆ\u0003J\n\u0010Ï\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ð\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010Ñ\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010Ò\u0001\u001a\u00020\nHÆ\u0003J\n\u0010Ó\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ô\u0001\u001a\u00020\u0005HÆ\u0003J\u0010\u0010Õ\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\rHÆ\u0003J\n\u0010Ö\u0001\u001a\u00020\u0005HÆ\u0003Jü\u0003\u0010×\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\r2\b\b\u0002\u0010\u001e\u001a\u00020\n2\b\b\u0002\u0010\u001f\u001a\u00020\n2\b\b\u0002\u0010 \u001a\u00020\n2\b\b\u0002\u0010!\u001a\u00020\n2\b\b\u0002\u0010\"\u001a\u00020\n2\b\b\u0002\u0010#\u001a\u00020\n2\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\n2\b\b\u0002\u0010&\u001a\u00020\u00142\b\b\u0002\u0010'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\n2\b\b\u0002\u0010)\u001a\u00020\n2\b\b\u0002\u0010*\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020\u00052\b\b\u0002\u0010,\u001a\u00020\u00142\b\b\u0002\u0010-\u001a\u00020\u00052\b\b\u0002\u0010.\u001a\u00020\n2\b\b\u0002\u0010/\u001a\u00020\n2\b\b\u0002\u00100\u001a\u00020\u00032\b\b\u0002\u00101\u001a\u00020\n2\b\b\u0002\u00102\u001a\u00020\u00032\b\b\u0002\u00103\u001a\u00020\u00052\b\b\u0002\u00104\u001a\u00020\u00052\b\b\u0002\u00105\u001a\u00020\n2\b\b\u0002\u00106\u001a\u00020\u00032\b\b\u0002\u00107\u001a\u00020\u00052\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\b\b\u0002\u00109\u001a\u00020\u0005HÆ\u0001J\u0016\u0010Ø\u0001\u001a\u00020\n2\n\u0010Ù\u0001\u001a\u0005\u0018\u00010Ú\u0001HÖ\u0003J\n\u0010Û\u0001\u001a\u00020\u0005HÖ\u0001J\n\u0010Ü\u0001\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010A\"\u0004\bE\u0010CR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010K\"\u0004\bO\u0010MR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010K\"\u0004\bU\u0010MR\u001a\u0010\u0010\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010K\"\u0004\bW\u0010MR\u001a\u0010\u0011\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010K\"\u0004\bY\u0010MR\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010A\"\u0004\b[\u0010CR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u001a\u0010\u0015\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010]\"\u0004\ba\u0010_R\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010=\"\u0004\bc\u0010?R\u001a\u0010\u0017\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010A\"\u0004\be\u0010CR\u001a\u0010\u0018\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010A\"\u0004\bg\u0010CR\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010A\"\u0004\bi\u0010CR\u001a\u0010\u001a\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010=\"\u0004\bk\u0010?R\u001a\u0010\u001b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010=\"\u0004\bm\u0010?R \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010Q\"\u0004\bo\u0010SR\u001a\u0010\u001e\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010K\"\u0004\bq\u0010MR\u001a\u0010\u001f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010K\"\u0004\bs\u0010MR\u001a\u0010 \u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010K\"\u0004\bu\u0010MR\u001a\u0010!\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010K\"\u0004\bw\u0010MR\u001a\u0010\"\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010K\"\u0004\by\u0010MR\u001a\u0010#\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010K\"\u0004\bz\u0010MR\u001a\u0010$\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010A\"\u0004\b|\u0010CR\u001a\u0010%\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010K\"\u0004\b~\u0010MR\u001b\u0010&\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010]\"\u0005\b\u0080\u0001\u0010_R\u001c\u0010'\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010A\"\u0005\b\u0082\u0001\u0010CR\u001c\u0010(\u001a\u00020\nX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010K\"\u0005\b\u0084\u0001\u0010MR\u001c\u0010)\u001a\u00020\nX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010K\"\u0005\b\u0086\u0001\u0010MR\u001c\u0010*\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010A\"\u0005\b\u0088\u0001\u0010CR\u001c\u0010+\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u0010A\"\u0005\b\u008a\u0001\u0010CR\u001c\u0010,\u001a\u00020\u0014X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0001\u0010]\"\u0005\b\u008c\u0001\u0010_R\u001c\u0010-\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010A\"\u0005\b\u008e\u0001\u0010CR\u001c\u0010.\u001a\u00020\nX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010K\"\u0005\b\u0090\u0001\u0010MR\u001c\u0010/\u001a\u00020\nX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010K\"\u0005\b\u0092\u0001\u0010MR\u001c\u00100\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010=\"\u0005\b\u0094\u0001\u0010?R\u001c\u00101\u001a\u00020\nX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010K\"\u0005\b\u0096\u0001\u0010MR\u001c\u00102\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0001\u0010=\"\u0005\b\u0098\u0001\u0010?R\u001c\u00103\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0001\u0010A\"\u0005\b\u009a\u0001\u0010CR\u001c\u00104\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009b\u0001\u0010A\"\u0005\b\u009c\u0001\u0010CR\u001c\u00105\u001a\u00020\nX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009d\u0001\u0010K\"\u0005\b\u009e\u0001\u0010MR\u001c\u00106\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009f\u0001\u0010=\"\u0005\b \u0001\u0010?R\u001c\u00107\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¡\u0001\u0010A\"\u0005\b¢\u0001\u0010CR\"\u00108\u001a\b\u0012\u0004\u0012\u00020\u00030\rX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b£\u0001\u0010Q\"\u0005\b¤\u0001\u0010SR\u001c\u00109\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0001\u0010A\"\u0005\b¦\u0001\u0010C¨\u0006Ý\u0001"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameState;", "Ljava/io/Serializable;", "version", "", "numberOfPlayers", "", "startingLifeTotal", "layoutType", "Lcom/studiolaganne/lengendarylens/LayoutType;", "hasCommanderDamage", "", "hasPoisonCounters", "players", "", "Lcom/studiolaganne/lengendarylens/Player;", "tossAlreadyDone", "firstSetupDone", "timerEnabled", "timerTotalTime", "gameStartTime", "", "timerStartTime", "creatorCode", "playgroupId", "formatId", "subformatId", "startedAt", "endedAt", "events", "Lcom/studiolaganne/lengendarylens/MTGameEvent;", "usersSeated", "decksSelected", "gameSynced", "gameSyncable", "hasDayNight", "isDay", "pauseTime", "timerPaused", "timerPausedAt", "startingPlayerIndex", "turnTimerEnabled", "turnTimerPromptDismissed", "currentGameTurn", "currentTurnPlayerIndex", "currentTurnStartTime", "currentTurnPauseTime", "gameClosed", "streamingEnabled", "streamingToken", "hasPlanechase", "planechaseFilter", "planechaseSeed", "currentPlaneIndex", "hasArchenemy", "archenemyFilter", "archenemySeed", "ongoingSchemes", "currentSchemeIndex", "<init>", "(Ljava/lang/String;IILcom/studiolaganne/lengendarylens/LayoutType;ZZLjava/util/List;ZZZIJJLjava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/util/List;ZZZZZZIZJIZZIIJIZZLjava/lang/String;ZLjava/lang/String;IIZLjava/lang/String;ILjava/util/List;I)V", "getVersion", "()Ljava/lang/String;", "setVersion", "(Ljava/lang/String;)V", "getNumberOfPlayers", "()I", "setNumberOfPlayers", "(I)V", "getStartingLifeTotal", "setStartingLifeTotal", "getLayoutType", "()Lcom/studiolaganne/lengendarylens/LayoutType;", "setLayoutType", "(Lcom/studiolaganne/lengendarylens/LayoutType;)V", "getHasCommanderDamage", "()Z", "setHasCommanderDamage", "(Z)V", "getHasPoisonCounters", "setHasPoisonCounters", "getPlayers", "()Ljava/util/List;", "setPlayers", "(Ljava/util/List;)V", "getTossAlreadyDone", "setTossAlreadyDone", "getFirstSetupDone", "setFirstSetupDone", "getTimerEnabled", "setTimerEnabled", "getTimerTotalTime", "setTimerTotalTime", "getGameStartTime", "()J", "setGameStartTime", "(J)V", "getTimerStartTime", "setTimerStartTime", "getCreatorCode", "setCreatorCode", "getPlaygroupId", "setPlaygroupId", "getFormatId", "setFormatId", "getSubformatId", "setSubformatId", "getStartedAt", "setStartedAt", "getEndedAt", "setEndedAt", "getEvents", "setEvents", "getUsersSeated", "setUsersSeated", "getDecksSelected", "setDecksSelected", "getGameSynced", "setGameSynced", "getGameSyncable", "setGameSyncable", "getHasDayNight", "setHasDayNight", "setDay", "getPauseTime", "setPauseTime", "getTimerPaused", "setTimerPaused", "getTimerPausedAt", "setTimerPausedAt", "getStartingPlayerIndex", "setStartingPlayerIndex", "getTurnTimerEnabled", "setTurnTimerEnabled", "getTurnTimerPromptDismissed", "setTurnTimerPromptDismissed", "getCurrentGameTurn", "setCurrentGameTurn", "getCurrentTurnPlayerIndex", "setCurrentTurnPlayerIndex", "getCurrentTurnStartTime", "setCurrentTurnStartTime", "getCurrentTurnPauseTime", "setCurrentTurnPauseTime", "getGameClosed", "setGameClosed", "getStreamingEnabled", "setStreamingEnabled", "getStreamingToken", "setStreamingToken", "getHasPlanechase", "setHasPlanechase", "getPlanechaseFilter", "setPlanechaseFilter", "getPlanechaseSeed", "setPlanechaseSeed", "getCurrentPlaneIndex", "setCurrentPlaneIndex", "getHasArchenemy", "setHasArchenemy", "getArchenemyFilter", "setArchenemyFilter", "getArchenemySeed", "setArchenemySeed", "getOngoingSchemes", "setOngoingSchemes", "getCurrentSchemeIndex", "setCurrentSchemeIndex", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "copy", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class GameState implements Serializable {
    public static final int $stable = 8;
    private String archenemyFilter;
    private int archenemySeed;
    private String creatorCode;
    private int currentGameTurn;
    private int currentPlaneIndex;
    private int currentSchemeIndex;
    private int currentTurnPauseTime;
    private int currentTurnPlayerIndex;
    private long currentTurnStartTime;
    private boolean decksSelected;
    private String endedAt;
    private List<MTGameEvent> events;
    private boolean firstSetupDone;
    private int formatId;
    private boolean gameClosed;
    private long gameStartTime;
    private boolean gameSyncable;
    private boolean gameSynced;
    private boolean hasArchenemy;
    private boolean hasCommanderDamage;
    private boolean hasDayNight;
    private boolean hasPlanechase;
    private boolean hasPoisonCounters;
    private boolean isDay;
    private LayoutType layoutType;
    private int numberOfPlayers;
    private List<String> ongoingSchemes;
    private int pauseTime;
    private String planechaseFilter;
    private int planechaseSeed;
    private List<Player> players;
    private int playgroupId;
    private String startedAt;
    private int startingLifeTotal;
    private int startingPlayerIndex;
    private boolean streamingEnabled;
    private String streamingToken;
    private int subformatId;
    private boolean timerEnabled;
    private boolean timerPaused;
    private long timerPausedAt;
    private long timerStartTime;
    private int timerTotalTime;
    private boolean tossAlreadyDone;
    private boolean turnTimerEnabled;
    private boolean turnTimerPromptDismissed;
    private boolean usersSeated;
    private String version;

    public GameState() {
        this(null, 0, 0, null, false, false, null, false, false, false, 0, 0L, 0L, null, 0, 0, 0, null, null, null, false, false, false, false, false, false, 0, false, 0L, 0, false, false, 0, 0, 0L, 0, false, false, null, false, null, 0, 0, false, null, 0, null, 0, -1, 65535, null);
    }

    public GameState(String version, int i, int i2, LayoutType layoutType, boolean z, boolean z2, List<Player> players, boolean z3, boolean z4, boolean z5, int i3, long j, long j2, String creatorCode, int i4, int i5, int i6, String startedAt, String endedAt, List<MTGameEvent> events, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, int i7, boolean z12, long j3, int i8, boolean z13, boolean z14, int i9, int i10, long j4, int i11, boolean z15, boolean z16, String streamingToken, boolean z17, String planechaseFilter, int i12, int i13, boolean z18, String archenemyFilter, int i14, List<String> ongoingSchemes, int i15) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(layoutType, "layoutType");
        Intrinsics.checkNotNullParameter(players, "players");
        Intrinsics.checkNotNullParameter(creatorCode, "creatorCode");
        Intrinsics.checkNotNullParameter(startedAt, "startedAt");
        Intrinsics.checkNotNullParameter(endedAt, "endedAt");
        Intrinsics.checkNotNullParameter(events, "events");
        Intrinsics.checkNotNullParameter(streamingToken, "streamingToken");
        Intrinsics.checkNotNullParameter(planechaseFilter, "planechaseFilter");
        Intrinsics.checkNotNullParameter(archenemyFilter, "archenemyFilter");
        Intrinsics.checkNotNullParameter(ongoingSchemes, "ongoingSchemes");
        this.version = version;
        this.numberOfPlayers = i;
        this.startingLifeTotal = i2;
        this.layoutType = layoutType;
        this.hasCommanderDamage = z;
        this.hasPoisonCounters = z2;
        this.players = players;
        this.tossAlreadyDone = z3;
        this.firstSetupDone = z4;
        this.timerEnabled = z5;
        this.timerTotalTime = i3;
        this.gameStartTime = j;
        this.timerStartTime = j2;
        this.creatorCode = creatorCode;
        this.playgroupId = i4;
        this.formatId = i5;
        this.subformatId = i6;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.events = events;
        this.usersSeated = z6;
        this.decksSelected = z7;
        this.gameSynced = z8;
        this.gameSyncable = z9;
        this.hasDayNight = z10;
        this.isDay = z11;
        this.pauseTime = i7;
        this.timerPaused = z12;
        this.timerPausedAt = j3;
        this.startingPlayerIndex = i8;
        this.turnTimerEnabled = z13;
        this.turnTimerPromptDismissed = z14;
        this.currentGameTurn = i9;
        this.currentTurnPlayerIndex = i10;
        this.currentTurnStartTime = j4;
        this.currentTurnPauseTime = i11;
        this.gameClosed = z15;
        this.streamingEnabled = z16;
        this.streamingToken = streamingToken;
        this.hasPlanechase = z17;
        this.planechaseFilter = planechaseFilter;
        this.planechaseSeed = i12;
        this.currentPlaneIndex = i13;
        this.hasArchenemy = z18;
        this.archenemyFilter = archenemyFilter;
        this.archenemySeed = i14;
        this.ongoingSchemes = ongoingSchemes;
        this.currentSchemeIndex = i15;
    }

    public /* synthetic */ GameState(String str, int i, int i2, LayoutType layoutType, boolean z, boolean z2, List list, boolean z3, boolean z4, boolean z5, int i3, long j, long j2, String str2, int i4, int i5, int i6, String str3, String str4, List list2, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, int i7, boolean z12, long j3, int i8, boolean z13, boolean z14, int i9, int i10, long j4, int i11, boolean z15, boolean z16, String str5, boolean z17, String str6, int i12, int i13, boolean z18, String str7, int i14, List list3, int i15, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "v15" : str, (i16 & 2) != 0 ? 0 : i, (i16 & 4) != 0 ? 40 : i2, (i16 & 8) != 0 ? LayoutType.TYPE_1 : layoutType, (i16 & 16) != 0 ? false : z, (i16 & 32) != 0 ? false : z2, (i16 & 64) != 0 ? new ArrayList() : list, (i16 & 128) != 0 ? false : z3, (i16 & 256) != 0 ? false : z4, (i16 & 512) != 0 ? false : z5, (i16 & 1024) != 0 ? 90 : i3, (i16 & 2048) != 0 ? 0L : j, (i16 & 4096) != 0 ? 0L : j2, (i16 & 8192) != 0 ? "" : str2, (i16 & 16384) != 0 ? -1 : i4, (i16 & 32768) != 0 ? -1 : i5, (i16 & 65536) != 0 ? -1 : i6, (i16 & 131072) != 0 ? "" : str3, (i16 & 262144) != 0 ? "" : str4, (i16 & 524288) != 0 ? new ArrayList() : list2, (i16 & 1048576) != 0 ? false : z6, (i16 & 2097152) != 0 ? false : z7, (i16 & 4194304) != 0 ? false : z8, (i16 & 8388608) != 0 ? false : z9, (i16 & 16777216) != 0 ? false : z10, (i16 & 33554432) != 0 ? true : z11, (i16 & 67108864) != 0 ? 0 : i7, (i16 & 134217728) != 0 ? false : z12, (i16 & 268435456) != 0 ? 0L : j3, (i16 & 536870912) == 0 ? i8 : -1, (i16 & 1073741824) != 0 ? false : z13, (i16 & Integer.MIN_VALUE) != 0 ? false : z14, (i17 & 1) != 0 ? 0 : i9, (i17 & 2) != 0 ? 0 : i10, (i17 & 4) == 0 ? j4 : 0L, (i17 & 8) != 0 ? 0 : i11, (i17 & 16) != 0 ? false : z15, (i17 & 32) != 0 ? false : z16, (i17 & 64) != 0 ? "" : str5, (i17 & 128) != 0 ? false : z17, (i17 & 256) != 0 ? "" : str6, (i17 & 512) != 0 ? 0 : i12, (i17 & 1024) != 0 ? 0 : i13, (i17 & 2048) != 0 ? false : z18, (i17 & 4096) == 0 ? str7 : "", (i17 & 8192) != 0 ? 0 : i14, (i17 & 16384) != 0 ? new ArrayList() : list3, (i17 & 32768) != 0 ? 0 : i15);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GameState copy$default(GameState gameState, String str, int i, int i2, LayoutType layoutType, boolean z, boolean z2, List list, boolean z3, boolean z4, boolean z5, int i3, long j, long j2, String str2, int i4, int i5, int i6, String str3, String str4, List list2, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, int i7, boolean z12, long j3, int i8, boolean z13, boolean z14, int i9, int i10, long j4, int i11, boolean z15, boolean z16, String str5, boolean z17, String str6, int i12, int i13, boolean z18, String str7, int i14, List list3, int i15, int i16, int i17, Object obj) {
        String str8 = (i16 & 1) != 0 ? gameState.version : str;
        int i18 = (i16 & 2) != 0 ? gameState.numberOfPlayers : i;
        int i19 = (i16 & 4) != 0 ? gameState.startingLifeTotal : i2;
        LayoutType layoutType2 = (i16 & 8) != 0 ? gameState.layoutType : layoutType;
        boolean z19 = (i16 & 16) != 0 ? gameState.hasCommanderDamage : z;
        boolean z20 = (i16 & 32) != 0 ? gameState.hasPoisonCounters : z2;
        List list4 = (i16 & 64) != 0 ? gameState.players : list;
        boolean z21 = (i16 & 128) != 0 ? gameState.tossAlreadyDone : z3;
        boolean z22 = (i16 & 256) != 0 ? gameState.firstSetupDone : z4;
        boolean z23 = (i16 & 512) != 0 ? gameState.timerEnabled : z5;
        int i20 = (i16 & 1024) != 0 ? gameState.timerTotalTime : i3;
        long j5 = (i16 & 2048) != 0 ? gameState.gameStartTime : j;
        String str9 = str8;
        int i21 = i18;
        long j6 = (i16 & 4096) != 0 ? gameState.timerStartTime : j2;
        String str10 = (i16 & 8192) != 0 ? gameState.creatorCode : str2;
        int i22 = (i16 & 16384) != 0 ? gameState.playgroupId : i4;
        int i23 = (i16 & 32768) != 0 ? gameState.formatId : i5;
        int i24 = (i16 & 65536) != 0 ? gameState.subformatId : i6;
        String str11 = (i16 & 131072) != 0 ? gameState.startedAt : str3;
        String str12 = (i16 & 262144) != 0 ? gameState.endedAt : str4;
        List list5 = (i16 & 524288) != 0 ? gameState.events : list2;
        boolean z24 = (i16 & 1048576) != 0 ? gameState.usersSeated : z6;
        boolean z25 = (i16 & 2097152) != 0 ? gameState.decksSelected : z7;
        boolean z26 = (i16 & 4194304) != 0 ? gameState.gameSynced : z8;
        boolean z27 = (i16 & 8388608) != 0 ? gameState.gameSyncable : z9;
        boolean z28 = (i16 & 16777216) != 0 ? gameState.hasDayNight : z10;
        boolean z29 = (i16 & 33554432) != 0 ? gameState.isDay : z11;
        int i25 = (i16 & 67108864) != 0 ? gameState.pauseTime : i7;
        boolean z30 = (i16 & 134217728) != 0 ? gameState.timerPaused : z12;
        String str13 = str10;
        int i26 = i22;
        long j7 = (i16 & 268435456) != 0 ? gameState.timerPausedAt : j3;
        return gameState.copy(str9, i21, i19, layoutType2, z19, z20, list4, z21, z22, z23, i20, j5, j6, str13, i26, i23, i24, str11, str12, list5, z24, z25, z26, z27, z28, z29, i25, z30, j7, (i16 & 536870912) != 0 ? gameState.startingPlayerIndex : i8, (i16 & 1073741824) != 0 ? gameState.turnTimerEnabled : z13, (i16 & Integer.MIN_VALUE) != 0 ? gameState.turnTimerPromptDismissed : z14, (i17 & 1) != 0 ? gameState.currentGameTurn : i9, (i17 & 2) != 0 ? gameState.currentTurnPlayerIndex : i10, (i17 & 4) != 0 ? gameState.currentTurnStartTime : j4, (i17 & 8) != 0 ? gameState.currentTurnPauseTime : i11, (i17 & 16) != 0 ? gameState.gameClosed : z15, (i17 & 32) != 0 ? gameState.streamingEnabled : z16, (i17 & 64) != 0 ? gameState.streamingToken : str5, (i17 & 128) != 0 ? gameState.hasPlanechase : z17, (i17 & 256) != 0 ? gameState.planechaseFilter : str6, (i17 & 512) != 0 ? gameState.planechaseSeed : i12, (i17 & 1024) != 0 ? gameState.currentPlaneIndex : i13, (i17 & 2048) != 0 ? gameState.hasArchenemy : z18, (i17 & 4096) != 0 ? gameState.archenemyFilter : str7, (i17 & 8192) != 0 ? gameState.archenemySeed : i14, (i17 & 16384) != 0 ? gameState.ongoingSchemes : list3, (i17 & 32768) != 0 ? gameState.currentSchemeIndex : i15);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getTimerEnabled() {
        return this.timerEnabled;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getTimerTotalTime() {
        return this.timerTotalTime;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final long getGameStartTime() {
        return this.gameStartTime;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final long getTimerStartTime() {
        return this.timerStartTime;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getCreatorCode() {
        return this.creatorCode;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getPlaygroupId() {
        return this.playgroupId;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final int getFormatId() {
        return this.formatId;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final int getSubformatId() {
        return this.subformatId;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getStartedAt() {
        return this.startedAt;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getEndedAt() {
        return this.endedAt;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getNumberOfPlayers() {
        return this.numberOfPlayers;
    }

    public final List<MTGameEvent> component20() {
        return this.events;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final boolean getUsersSeated() {
        return this.usersSeated;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final boolean getDecksSelected() {
        return this.decksSelected;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final boolean getGameSynced() {
        return this.gameSynced;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final boolean getGameSyncable() {
        return this.gameSyncable;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final boolean getHasDayNight() {
        return this.hasDayNight;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final boolean getIsDay() {
        return this.isDay;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final int getPauseTime() {
        return this.pauseTime;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final boolean getTimerPaused() {
        return this.timerPaused;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final long getTimerPausedAt() {
        return this.timerPausedAt;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getStartingLifeTotal() {
        return this.startingLifeTotal;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final int getStartingPlayerIndex() {
        return this.startingPlayerIndex;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final boolean getTurnTimerEnabled() {
        return this.turnTimerEnabled;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final boolean getTurnTimerPromptDismissed() {
        return this.turnTimerPromptDismissed;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final int getCurrentGameTurn() {
        return this.currentGameTurn;
    }

    /* JADX INFO: renamed from: component34, reason: from getter */
    public final int getCurrentTurnPlayerIndex() {
        return this.currentTurnPlayerIndex;
    }

    /* JADX INFO: renamed from: component35, reason: from getter */
    public final long getCurrentTurnStartTime() {
        return this.currentTurnStartTime;
    }

    /* JADX INFO: renamed from: component36, reason: from getter */
    public final int getCurrentTurnPauseTime() {
        return this.currentTurnPauseTime;
    }

    /* JADX INFO: renamed from: component37, reason: from getter */
    public final boolean getGameClosed() {
        return this.gameClosed;
    }

    /* JADX INFO: renamed from: component38, reason: from getter */
    public final boolean getStreamingEnabled() {
        return this.streamingEnabled;
    }

    /* JADX INFO: renamed from: component39, reason: from getter */
    public final String getStreamingToken() {
        return this.streamingToken;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final LayoutType getLayoutType() {
        return this.layoutType;
    }

    /* JADX INFO: renamed from: component40, reason: from getter */
    public final boolean getHasPlanechase() {
        return this.hasPlanechase;
    }

    /* JADX INFO: renamed from: component41, reason: from getter */
    public final String getPlanechaseFilter() {
        return this.planechaseFilter;
    }

    /* JADX INFO: renamed from: component42, reason: from getter */
    public final int getPlanechaseSeed() {
        return this.planechaseSeed;
    }

    /* JADX INFO: renamed from: component43, reason: from getter */
    public final int getCurrentPlaneIndex() {
        return this.currentPlaneIndex;
    }

    /* JADX INFO: renamed from: component44, reason: from getter */
    public final boolean getHasArchenemy() {
        return this.hasArchenemy;
    }

    /* JADX INFO: renamed from: component45, reason: from getter */
    public final String getArchenemyFilter() {
        return this.archenemyFilter;
    }

    /* JADX INFO: renamed from: component46, reason: from getter */
    public final int getArchenemySeed() {
        return this.archenemySeed;
    }

    public final List<String> component47() {
        return this.ongoingSchemes;
    }

    /* JADX INFO: renamed from: component48, reason: from getter */
    public final int getCurrentSchemeIndex() {
        return this.currentSchemeIndex;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getHasCommanderDamage() {
        return this.hasCommanderDamage;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getHasPoisonCounters() {
        return this.hasPoisonCounters;
    }

    public final List<Player> component7() {
        return this.players;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getTossAlreadyDone() {
        return this.tossAlreadyDone;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getFirstSetupDone() {
        return this.firstSetupDone;
    }

    public final GameState copy(String version, int numberOfPlayers, int startingLifeTotal, LayoutType layoutType, boolean hasCommanderDamage, boolean hasPoisonCounters, List<Player> players, boolean tossAlreadyDone, boolean firstSetupDone, boolean timerEnabled, int timerTotalTime, long gameStartTime, long timerStartTime, String creatorCode, int playgroupId, int formatId, int subformatId, String startedAt, String endedAt, List<MTGameEvent> events, boolean usersSeated, boolean decksSelected, boolean gameSynced, boolean gameSyncable, boolean hasDayNight, boolean isDay, int pauseTime, boolean timerPaused, long timerPausedAt, int startingPlayerIndex, boolean turnTimerEnabled, boolean turnTimerPromptDismissed, int currentGameTurn, int currentTurnPlayerIndex, long currentTurnStartTime, int currentTurnPauseTime, boolean gameClosed, boolean streamingEnabled, String streamingToken, boolean hasPlanechase, String planechaseFilter, int planechaseSeed, int currentPlaneIndex, boolean hasArchenemy, String archenemyFilter, int archenemySeed, List<String> ongoingSchemes, int currentSchemeIndex) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(layoutType, "layoutType");
        Intrinsics.checkNotNullParameter(players, "players");
        Intrinsics.checkNotNullParameter(creatorCode, "creatorCode");
        Intrinsics.checkNotNullParameter(startedAt, "startedAt");
        Intrinsics.checkNotNullParameter(endedAt, "endedAt");
        Intrinsics.checkNotNullParameter(events, "events");
        Intrinsics.checkNotNullParameter(streamingToken, "streamingToken");
        Intrinsics.checkNotNullParameter(planechaseFilter, "planechaseFilter");
        Intrinsics.checkNotNullParameter(archenemyFilter, "archenemyFilter");
        Intrinsics.checkNotNullParameter(ongoingSchemes, "ongoingSchemes");
        return new GameState(version, numberOfPlayers, startingLifeTotal, layoutType, hasCommanderDamage, hasPoisonCounters, players, tossAlreadyDone, firstSetupDone, timerEnabled, timerTotalTime, gameStartTime, timerStartTime, creatorCode, playgroupId, formatId, subformatId, startedAt, endedAt, events, usersSeated, decksSelected, gameSynced, gameSyncable, hasDayNight, isDay, pauseTime, timerPaused, timerPausedAt, startingPlayerIndex, turnTimerEnabled, turnTimerPromptDismissed, currentGameTurn, currentTurnPlayerIndex, currentTurnStartTime, currentTurnPauseTime, gameClosed, streamingEnabled, streamingToken, hasPlanechase, planechaseFilter, planechaseSeed, currentPlaneIndex, hasArchenemy, archenemyFilter, archenemySeed, ongoingSchemes, currentSchemeIndex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GameState)) {
            return false;
        }
        GameState gameState = (GameState) other;
        return Intrinsics.areEqual(this.version, gameState.version) && this.numberOfPlayers == gameState.numberOfPlayers && this.startingLifeTotal == gameState.startingLifeTotal && this.layoutType == gameState.layoutType && this.hasCommanderDamage == gameState.hasCommanderDamage && this.hasPoisonCounters == gameState.hasPoisonCounters && Intrinsics.areEqual(this.players, gameState.players) && this.tossAlreadyDone == gameState.tossAlreadyDone && this.firstSetupDone == gameState.firstSetupDone && this.timerEnabled == gameState.timerEnabled && this.timerTotalTime == gameState.timerTotalTime && this.gameStartTime == gameState.gameStartTime && this.timerStartTime == gameState.timerStartTime && Intrinsics.areEqual(this.creatorCode, gameState.creatorCode) && this.playgroupId == gameState.playgroupId && this.formatId == gameState.formatId && this.subformatId == gameState.subformatId && Intrinsics.areEqual(this.startedAt, gameState.startedAt) && Intrinsics.areEqual(this.endedAt, gameState.endedAt) && Intrinsics.areEqual(this.events, gameState.events) && this.usersSeated == gameState.usersSeated && this.decksSelected == gameState.decksSelected && this.gameSynced == gameState.gameSynced && this.gameSyncable == gameState.gameSyncable && this.hasDayNight == gameState.hasDayNight && this.isDay == gameState.isDay && this.pauseTime == gameState.pauseTime && this.timerPaused == gameState.timerPaused && this.timerPausedAt == gameState.timerPausedAt && this.startingPlayerIndex == gameState.startingPlayerIndex && this.turnTimerEnabled == gameState.turnTimerEnabled && this.turnTimerPromptDismissed == gameState.turnTimerPromptDismissed && this.currentGameTurn == gameState.currentGameTurn && this.currentTurnPlayerIndex == gameState.currentTurnPlayerIndex && this.currentTurnStartTime == gameState.currentTurnStartTime && this.currentTurnPauseTime == gameState.currentTurnPauseTime && this.gameClosed == gameState.gameClosed && this.streamingEnabled == gameState.streamingEnabled && Intrinsics.areEqual(this.streamingToken, gameState.streamingToken) && this.hasPlanechase == gameState.hasPlanechase && Intrinsics.areEqual(this.planechaseFilter, gameState.planechaseFilter) && this.planechaseSeed == gameState.planechaseSeed && this.currentPlaneIndex == gameState.currentPlaneIndex && this.hasArchenemy == gameState.hasArchenemy && Intrinsics.areEqual(this.archenemyFilter, gameState.archenemyFilter) && this.archenemySeed == gameState.archenemySeed && Intrinsics.areEqual(this.ongoingSchemes, gameState.ongoingSchemes) && this.currentSchemeIndex == gameState.currentSchemeIndex;
    }

    public final String getArchenemyFilter() {
        return this.archenemyFilter;
    }

    public final int getArchenemySeed() {
        return this.archenemySeed;
    }

    public final String getCreatorCode() {
        return this.creatorCode;
    }

    public final int getCurrentGameTurn() {
        return this.currentGameTurn;
    }

    public final int getCurrentPlaneIndex() {
        return this.currentPlaneIndex;
    }

    public final int getCurrentSchemeIndex() {
        return this.currentSchemeIndex;
    }

    public final int getCurrentTurnPauseTime() {
        return this.currentTurnPauseTime;
    }

    public final int getCurrentTurnPlayerIndex() {
        return this.currentTurnPlayerIndex;
    }

    public final long getCurrentTurnStartTime() {
        return this.currentTurnStartTime;
    }

    public final boolean getDecksSelected() {
        return this.decksSelected;
    }

    public final String getEndedAt() {
        return this.endedAt;
    }

    public final List<MTGameEvent> getEvents() {
        return this.events;
    }

    public final boolean getFirstSetupDone() {
        return this.firstSetupDone;
    }

    public final int getFormatId() {
        return this.formatId;
    }

    public final boolean getGameClosed() {
        return this.gameClosed;
    }

    public final long getGameStartTime() {
        return this.gameStartTime;
    }

    public final boolean getGameSyncable() {
        return this.gameSyncable;
    }

    public final boolean getGameSynced() {
        return this.gameSynced;
    }

    public final boolean getHasArchenemy() {
        return this.hasArchenemy;
    }

    public final boolean getHasCommanderDamage() {
        return this.hasCommanderDamage;
    }

    public final boolean getHasDayNight() {
        return this.hasDayNight;
    }

    public final boolean getHasPlanechase() {
        return this.hasPlanechase;
    }

    public final boolean getHasPoisonCounters() {
        return this.hasPoisonCounters;
    }

    public final LayoutType getLayoutType() {
        return this.layoutType;
    }

    public final int getNumberOfPlayers() {
        return this.numberOfPlayers;
    }

    public final List<String> getOngoingSchemes() {
        return this.ongoingSchemes;
    }

    public final int getPauseTime() {
        return this.pauseTime;
    }

    public final String getPlanechaseFilter() {
        return this.planechaseFilter;
    }

    public final int getPlanechaseSeed() {
        return this.planechaseSeed;
    }

    public final List<Player> getPlayers() {
        return this.players;
    }

    public final int getPlaygroupId() {
        return this.playgroupId;
    }

    public final String getStartedAt() {
        return this.startedAt;
    }

    public final int getStartingLifeTotal() {
        return this.startingLifeTotal;
    }

    public final int getStartingPlayerIndex() {
        return this.startingPlayerIndex;
    }

    public final boolean getStreamingEnabled() {
        return this.streamingEnabled;
    }

    public final String getStreamingToken() {
        return this.streamingToken;
    }

    public final int getSubformatId() {
        return this.subformatId;
    }

    public final boolean getTimerEnabled() {
        return this.timerEnabled;
    }

    public final boolean getTimerPaused() {
        return this.timerPaused;
    }

    public final long getTimerPausedAt() {
        return this.timerPausedAt;
    }

    public final long getTimerStartTime() {
        return this.timerStartTime;
    }

    public final int getTimerTotalTime() {
        return this.timerTotalTime;
    }

    public final boolean getTossAlreadyDone() {
        return this.tossAlreadyDone;
    }

    public final boolean getTurnTimerEnabled() {
        return this.turnTimerEnabled;
    }

    public final boolean getTurnTimerPromptDismissed() {
        return this.turnTimerPromptDismissed;
    }

    public final boolean getUsersSeated() {
        return this.usersSeated;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.version.hashCode() * 31) + Integer.hashCode(this.numberOfPlayers)) * 31) + Integer.hashCode(this.startingLifeTotal)) * 31) + this.layoutType.hashCode()) * 31) + Boolean.hashCode(this.hasCommanderDamage)) * 31) + Boolean.hashCode(this.hasPoisonCounters)) * 31) + this.players.hashCode()) * 31) + Boolean.hashCode(this.tossAlreadyDone)) * 31) + Boolean.hashCode(this.firstSetupDone)) * 31) + Boolean.hashCode(this.timerEnabled)) * 31) + Integer.hashCode(this.timerTotalTime)) * 31) + Long.hashCode(this.gameStartTime)) * 31) + Long.hashCode(this.timerStartTime)) * 31) + this.creatorCode.hashCode()) * 31) + Integer.hashCode(this.playgroupId)) * 31) + Integer.hashCode(this.formatId)) * 31) + Integer.hashCode(this.subformatId)) * 31) + this.startedAt.hashCode()) * 31) + this.endedAt.hashCode()) * 31) + this.events.hashCode()) * 31) + Boolean.hashCode(this.usersSeated)) * 31) + Boolean.hashCode(this.decksSelected)) * 31) + Boolean.hashCode(this.gameSynced)) * 31) + Boolean.hashCode(this.gameSyncable)) * 31) + Boolean.hashCode(this.hasDayNight)) * 31) + Boolean.hashCode(this.isDay)) * 31) + Integer.hashCode(this.pauseTime)) * 31) + Boolean.hashCode(this.timerPaused)) * 31) + Long.hashCode(this.timerPausedAt)) * 31) + Integer.hashCode(this.startingPlayerIndex)) * 31) + Boolean.hashCode(this.turnTimerEnabled)) * 31) + Boolean.hashCode(this.turnTimerPromptDismissed)) * 31) + Integer.hashCode(this.currentGameTurn)) * 31) + Integer.hashCode(this.currentTurnPlayerIndex)) * 31) + Long.hashCode(this.currentTurnStartTime)) * 31) + Integer.hashCode(this.currentTurnPauseTime)) * 31) + Boolean.hashCode(this.gameClosed)) * 31) + Boolean.hashCode(this.streamingEnabled)) * 31) + this.streamingToken.hashCode()) * 31) + Boolean.hashCode(this.hasPlanechase)) * 31) + this.planechaseFilter.hashCode()) * 31) + Integer.hashCode(this.planechaseSeed)) * 31) + Integer.hashCode(this.currentPlaneIndex)) * 31) + Boolean.hashCode(this.hasArchenemy)) * 31) + this.archenemyFilter.hashCode()) * 31) + Integer.hashCode(this.archenemySeed)) * 31) + this.ongoingSchemes.hashCode()) * 31) + Integer.hashCode(this.currentSchemeIndex);
    }

    public final boolean isDay() {
        return this.isDay;
    }

    public final void setArchenemyFilter(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.archenemyFilter = str;
    }

    public final void setArchenemySeed(int i) {
        this.archenemySeed = i;
    }

    public final void setCreatorCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.creatorCode = str;
    }

    public final void setCurrentGameTurn(int i) {
        this.currentGameTurn = i;
    }

    public final void setCurrentPlaneIndex(int i) {
        this.currentPlaneIndex = i;
    }

    public final void setCurrentSchemeIndex(int i) {
        this.currentSchemeIndex = i;
    }

    public final void setCurrentTurnPauseTime(int i) {
        this.currentTurnPauseTime = i;
    }

    public final void setCurrentTurnPlayerIndex(int i) {
        this.currentTurnPlayerIndex = i;
    }

    public final void setCurrentTurnStartTime(long j) {
        this.currentTurnStartTime = j;
    }

    public final void setDay(boolean z) {
        this.isDay = z;
    }

    public final void setDecksSelected(boolean z) {
        this.decksSelected = z;
    }

    public final void setEndedAt(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.endedAt = str;
    }

    public final void setEvents(List<MTGameEvent> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.events = list;
    }

    public final void setFirstSetupDone(boolean z) {
        this.firstSetupDone = z;
    }

    public final void setFormatId(int i) {
        this.formatId = i;
    }

    public final void setGameClosed(boolean z) {
        this.gameClosed = z;
    }

    public final void setGameStartTime(long j) {
        this.gameStartTime = j;
    }

    public final void setGameSyncable(boolean z) {
        this.gameSyncable = z;
    }

    public final void setGameSynced(boolean z) {
        this.gameSynced = z;
    }

    public final void setHasArchenemy(boolean z) {
        this.hasArchenemy = z;
    }

    public final void setHasCommanderDamage(boolean z) {
        this.hasCommanderDamage = z;
    }

    public final void setHasDayNight(boolean z) {
        this.hasDayNight = z;
    }

    public final void setHasPlanechase(boolean z) {
        this.hasPlanechase = z;
    }

    public final void setHasPoisonCounters(boolean z) {
        this.hasPoisonCounters = z;
    }

    public final void setLayoutType(LayoutType layoutType) {
        Intrinsics.checkNotNullParameter(layoutType, "<set-?>");
        this.layoutType = layoutType;
    }

    public final void setNumberOfPlayers(int i) {
        this.numberOfPlayers = i;
    }

    public final void setOngoingSchemes(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.ongoingSchemes = list;
    }

    public final void setPauseTime(int i) {
        this.pauseTime = i;
    }

    public final void setPlanechaseFilter(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.planechaseFilter = str;
    }

    public final void setPlanechaseSeed(int i) {
        this.planechaseSeed = i;
    }

    public final void setPlayers(List<Player> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.players = list;
    }

    public final void setPlaygroupId(int i) {
        this.playgroupId = i;
    }

    public final void setStartedAt(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.startedAt = str;
    }

    public final void setStartingLifeTotal(int i) {
        this.startingLifeTotal = i;
    }

    public final void setStartingPlayerIndex(int i) {
        this.startingPlayerIndex = i;
    }

    public final void setStreamingEnabled(boolean z) {
        this.streamingEnabled = z;
    }

    public final void setStreamingToken(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.streamingToken = str;
    }

    public final void setSubformatId(int i) {
        this.subformatId = i;
    }

    public final void setTimerEnabled(boolean z) {
        this.timerEnabled = z;
    }

    public final void setTimerPaused(boolean z) {
        this.timerPaused = z;
    }

    public final void setTimerPausedAt(long j) {
        this.timerPausedAt = j;
    }

    public final void setTimerStartTime(long j) {
        this.timerStartTime = j;
    }

    public final void setTimerTotalTime(int i) {
        this.timerTotalTime = i;
    }

    public final void setTossAlreadyDone(boolean z) {
        this.tossAlreadyDone = z;
    }

    public final void setTurnTimerEnabled(boolean z) {
        this.turnTimerEnabled = z;
    }

    public final void setTurnTimerPromptDismissed(boolean z) {
        this.turnTimerPromptDismissed = z;
    }

    public final void setUsersSeated(boolean z) {
        this.usersSeated = z;
    }

    public final void setVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.version = str;
    }

    public String toString() {
        return "GameState(version=" + this.version + ", numberOfPlayers=" + this.numberOfPlayers + ", startingLifeTotal=" + this.startingLifeTotal + ", layoutType=" + this.layoutType + ", hasCommanderDamage=" + this.hasCommanderDamage + ", hasPoisonCounters=" + this.hasPoisonCounters + ", players=" + this.players + ", tossAlreadyDone=" + this.tossAlreadyDone + ", firstSetupDone=" + this.firstSetupDone + ", timerEnabled=" + this.timerEnabled + ", timerTotalTime=" + this.timerTotalTime + ", gameStartTime=" + this.gameStartTime + ", timerStartTime=" + this.timerStartTime + ", creatorCode=" + this.creatorCode + ", playgroupId=" + this.playgroupId + ", formatId=" + this.formatId + ", subformatId=" + this.subformatId + ", startedAt=" + this.startedAt + ", endedAt=" + this.endedAt + ", events=" + this.events + ", usersSeated=" + this.usersSeated + ", decksSelected=" + this.decksSelected + ", gameSynced=" + this.gameSynced + ", gameSyncable=" + this.gameSyncable + ", hasDayNight=" + this.hasDayNight + ", isDay=" + this.isDay + ", pauseTime=" + this.pauseTime + ", timerPaused=" + this.timerPaused + ", timerPausedAt=" + this.timerPausedAt + ", startingPlayerIndex=" + this.startingPlayerIndex + ", turnTimerEnabled=" + this.turnTimerEnabled + ", turnTimerPromptDismissed=" + this.turnTimerPromptDismissed + ", currentGameTurn=" + this.currentGameTurn + ", currentTurnPlayerIndex=" + this.currentTurnPlayerIndex + ", currentTurnStartTime=" + this.currentTurnStartTime + ", currentTurnPauseTime=" + this.currentTurnPauseTime + ", gameClosed=" + this.gameClosed + ", streamingEnabled=" + this.streamingEnabled + ", streamingToken=" + this.streamingToken + ", hasPlanechase=" + this.hasPlanechase + ", planechaseFilter=" + this.planechaseFilter + ", planechaseSeed=" + this.planechaseSeed + ", currentPlaneIndex=" + this.currentPlaneIndex + ", hasArchenemy=" + this.hasArchenemy + ", archenemyFilter=" + this.archenemyFilter + ", archenemySeed=" + this.archenemySeed + ", ongoingSchemes=" + this.ongoingSchemes + ", currentSchemeIndex=" + this.currentSchemeIndex + ")";
    }
}
