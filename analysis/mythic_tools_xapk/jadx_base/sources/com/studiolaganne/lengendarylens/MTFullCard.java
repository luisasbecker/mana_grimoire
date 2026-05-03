package com.studiolaganne.lengendarylens;

import androidx.core.app.NotificationCompat;
import androidx.window.reflection.WindowExtensionsConstants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0003\bþ\u0001\b\u0087\b\u0018\u00002\u00020\u0001B§\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\b\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\b\u0012\b\b\u0002\u0010'\u001a\u00020\u0003\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u001b\u0012\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\b\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010E\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010H\u0012\u0010\b\u0002\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\u0010\b\u0002\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010K\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u001b\u0012\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\b\u0012\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\b\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010P\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0012\u0018\u00010Q\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010T\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010V\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010X¢\u0006\u0004\bY\u0010ZJ\u0011\u0010\u0086\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u001bJ\u0011\u0010\u0087\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u001bJ\u0011\u0010\u0088\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u001bJ\f\u0010\u0089\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u008a\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010`J\f\u0010\u008b\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010\u008c\u0002\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\f\u0010\u008d\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008e\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010\u008f\u0002\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\u0012\u0010\u0090\u0002\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\f\u0010\u0091\u0002\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\f\u0010\u0092\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0093\u0002\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010yJ\u0011\u0010\u0094\u0002\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010yJ\u0011\u0010\u0095\u0002\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010yJ\u0011\u0010\u0096\u0002\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010yJ\u0011\u0010\u0097\u0002\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010yJ\u0011\u0010\u0098\u0002\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010yJ\f\u0010\u0099\u0002\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u0012\u0010\u009a\u0002\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0003\u0010\u008c\u0001J\u0012\u0010\u009b\u0002\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0003\u0010\u008c\u0001J\f\u0010\u009c\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u009d\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010\u009e\u0002\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\u0012\u0010\u009f\u0002\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0003\u0010\u008c\u0001J\u0011\u0010 \u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010`J\u0011\u0010¡\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010`J\f\u0010¢\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010£\u0002\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\bHÆ\u0003J\u0012\u0010¤\u0002\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\bHÆ\u0003J\n\u0010¥\u0002\u001a\u00020\u0003HÆ\u0003J\u0012\u0010¦\u0002\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0003\u0010\u008c\u0001J\f\u0010§\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010¨\u0002\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0003\u0010\u008c\u0001J\u0012\u0010©\u0002\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0003\u0010\u008c\u0001J\u0012\u0010ª\u0002\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\bHÆ\u0003J\f\u0010«\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¬\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u00ad\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010`J\f\u0010®\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¯\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010°\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010±\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010²\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010³\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010´\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010µ\u0002\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010yJ\u0011\u0010¶\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010`J\u0012\u0010·\u0002\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0003\u0010\u008c\u0001J\f\u0010¸\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¹\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010º\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010»\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¼\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010½\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010`J\f\u0010¾\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¿\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010À\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Á\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Â\u0002\u001a\u0004\u0018\u00010EHÆ\u0003J\f\u0010Ã\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ä\u0002\u001a\u0004\u0018\u00010HHÆ\u0003J\u0012\u0010Å\u0002\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\u0012\u0010Æ\u0002\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010KHÆ\u0003J\u0012\u0010Ç\u0002\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0003\u0010\u008c\u0001J\u0012\u0010È\u0002\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\bHÆ\u0003J\u0012\u0010É\u0002\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\bHÆ\u0003J\u0011\u0010Ê\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010`J\u0018\u0010Ë\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0012\u0018\u00010QHÆ\u0003J\u0012\u0010Ì\u0002\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0003\u0010\u008c\u0001J\f\u0010Í\u0002\u001a\u0004\u0018\u00010THÆ\u0003J\f\u0010Î\u0002\u001a\u0004\u0018\u00010VHÆ\u0003J\f\u0010Ï\u0002\u001a\u0004\u0018\u00010XHÆ\u0003J°\u0007\u0010Ð\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\b2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\b2\b\b\u0002\u0010'\u001a\u00020\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u001b2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\b2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010D\u001a\u0004\u0018\u00010E2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010G\u001a\u0004\u0018\u00010H2\u0010\b\u0002\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\u0010\b\u0002\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010K2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u001b2\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\b2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\b2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010P\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0012\u0018\u00010Q2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010T2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010V2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010XHÆ\u0001¢\u0006\u0003\u0010Ñ\u0002J\u0015\u0010Ò\u0002\u001a\u00020\u00052\t\u0010Ó\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010Ô\u0002\u001a\u00020\u001bHÖ\u0001J\n\u0010Õ\u0002\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010c\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\\\"\u0004\be\u0010^R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\\\"\u0004\bk\u0010^R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\\\"\u0004\bm\u0010^R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010g\"\u0004\bo\u0010iR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010g\"\u0004\bq\u0010iR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010\\\"\u0004\bw\u0010^R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010|\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010|\u001a\u0004\b}\u0010y\"\u0004\b~\u0010{R\u001f\u0010\u0014\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0011\n\u0002\u0010|\u001a\u0004\b\u007f\u0010y\"\u0005\b\u0080\u0001\u0010{R \u0010\u0015\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0012\n\u0002\u0010|\u001a\u0005\b\u0081\u0001\u0010y\"\u0005\b\u0082\u0001\u0010{R \u0010\u0016\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0012\n\u0002\u0010|\u001a\u0005\b\u0083\u0001\u0010y\"\u0005\b\u0084\u0001\u0010{R \u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0012\n\u0002\u0010|\u001a\u0005\b\u0085\u0001\u0010y\"\u0005\b\u0086\u0001\u0010{R \u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R#\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u008f\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R#\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u008c\u0001\"\u0006\b\u0091\u0001\u0010\u008e\u0001R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010\\\"\u0005\b\u0093\u0001\u0010^R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010\\\"\u0005\b\u0095\u0001\u0010^R$\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u0010g\"\u0005\b\u0097\u0001\u0010iR#\u0010 \u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u008f\u0001\u001a\u0006\b\u0098\u0001\u0010\u008c\u0001\"\u0006\b\u0099\u0001\u0010\u008e\u0001R \u0010!\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0012\n\u0002\u0010c\u001a\u0005\b\u009a\u0001\u0010`\"\u0005\b\u009b\u0001\u0010bR \u0010\"\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0012\n\u0002\u0010c\u001a\u0005\b\u009c\u0001\u0010`\"\u0005\b\u009d\u0001\u0010bR\u001e\u0010#\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009e\u0001\u0010\\\"\u0005\b\u009f\u0001\u0010^R$\u0010$\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b \u0001\u0010g\"\u0005\b¡\u0001\u0010iR$\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¢\u0001\u0010g\"\u0005\b£\u0001\u0010iR\u001c\u0010'\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¤\u0001\u0010\\\"\u0005\b¥\u0001\u0010^R#\u0010(\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u008f\u0001\u001a\u0006\b¦\u0001\u0010\u008c\u0001\"\u0006\b§\u0001\u0010\u008e\u0001R\u001e\u0010)\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¨\u0001\u0010\\\"\u0005\b©\u0001\u0010^R#\u0010*\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u008f\u0001\u001a\u0006\bª\u0001\u0010\u008c\u0001\"\u0006\b«\u0001\u0010\u008e\u0001R#\u0010+\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u008f\u0001\u001a\u0006\b¬\u0001\u0010\u008c\u0001\"\u0006\b\u00ad\u0001\u0010\u008e\u0001R$\u0010,\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b®\u0001\u0010g\"\u0005\b¯\u0001\u0010iR\u001e\u0010-\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b°\u0001\u0010\\\"\u0005\b±\u0001\u0010^R\u001e\u0010.\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b²\u0001\u0010\\\"\u0005\b³\u0001\u0010^R \u0010/\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0012\n\u0002\u0010c\u001a\u0005\b´\u0001\u0010`\"\u0005\bµ\u0001\u0010bR\u001e\u00100\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¶\u0001\u0010\\\"\u0005\b·\u0001\u0010^R\u001e\u00101\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¸\u0001\u0010\\\"\u0005\b¹\u0001\u0010^R\u001e\u00102\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bº\u0001\u0010\\\"\u0005\b»\u0001\u0010^R\u001e\u00103\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¼\u0001\u0010\\\"\u0005\b½\u0001\u0010^R\u001e\u00104\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¾\u0001\u0010\\\"\u0005\b¿\u0001\u0010^R\u001e\u00105\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÀ\u0001\u0010\\\"\u0005\bÁ\u0001\u0010^R\u001e\u00106\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÂ\u0001\u0010\\\"\u0005\bÃ\u0001\u0010^R \u00107\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0012\n\u0002\u0010|\u001a\u0005\bÄ\u0001\u0010y\"\u0005\bÅ\u0001\u0010{R \u00108\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0012\n\u0002\u0010c\u001a\u0005\bÆ\u0001\u0010`\"\u0005\bÇ\u0001\u0010bR#\u00109\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u008f\u0001\u001a\u0006\bÈ\u0001\u0010\u008c\u0001\"\u0006\bÉ\u0001\u0010\u008e\u0001R\u001e\u0010:\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÊ\u0001\u0010\\\"\u0005\bË\u0001\u0010^R\u001e\u0010;\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÌ\u0001\u0010\\\"\u0005\bÍ\u0001\u0010^R\u001e\u0010<\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÎ\u0001\u0010\\\"\u0005\bÏ\u0001\u0010^R\u001e\u0010=\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÐ\u0001\u0010\\\"\u0005\bÑ\u0001\u0010^R\u001e\u0010>\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÒ\u0001\u0010\\\"\u0005\bÓ\u0001\u0010^R \u0010?\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0012\n\u0002\u0010c\u001a\u0005\bÔ\u0001\u0010`\"\u0005\bÕ\u0001\u0010bR\u001e\u0010@\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÖ\u0001\u0010\\\"\u0005\b×\u0001\u0010^R\u001e\u0010A\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bØ\u0001\u0010\\\"\u0005\bÙ\u0001\u0010^R\u001e\u0010B\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÚ\u0001\u0010\\\"\u0005\bÛ\u0001\u0010^R\u001e\u0010C\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÜ\u0001\u0010\\\"\u0005\bÝ\u0001\u0010^R \u0010D\u001a\u0004\u0018\u00010EX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÞ\u0001\u0010ß\u0001\"\u0006\bà\u0001\u0010á\u0001R\u001e\u0010F\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bâ\u0001\u0010\\\"\u0005\bã\u0001\u0010^R \u0010G\u001a\u0004\u0018\u00010HX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bä\u0001\u0010å\u0001\"\u0006\bæ\u0001\u0010ç\u0001R$\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bè\u0001\u0010g\"\u0005\bé\u0001\u0010iR$\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010KX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bê\u0001\u0010g\"\u0005\bë\u0001\u0010iR#\u0010L\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u008f\u0001\u001a\u0006\bì\u0001\u0010\u008c\u0001\"\u0006\bí\u0001\u0010\u008e\u0001R$\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bî\u0001\u0010g\"\u0005\bï\u0001\u0010iR$\u0010N\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bð\u0001\u0010g\"\u0005\bñ\u0001\u0010iR \u0010O\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0012\n\u0002\u0010c\u001a\u0005\bò\u0001\u0010`\"\u0005\bó\u0001\u0010bR,\u0010P\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0012\u0018\u00010QX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bô\u0001\u0010õ\u0001\"\u0006\bö\u0001\u0010÷\u0001R#\u0010R\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u008f\u0001\u001a\u0006\bø\u0001\u0010\u008c\u0001\"\u0006\bù\u0001\u0010\u008e\u0001R \u0010S\u001a\u0004\u0018\u00010TX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bú\u0001\u0010û\u0001\"\u0006\bü\u0001\u0010ý\u0001R \u0010U\u001a\u0004\u0018\u00010VX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bþ\u0001\u0010ÿ\u0001\"\u0006\b\u0080\u0002\u0010\u0081\u0002R \u0010W\u001a\u0004\u0018\u00010XX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0082\u0002\u0010\u0083\u0002\"\u0006\b\u0084\u0002\u0010\u0085\u0002¨\u0006Ö\u0002"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTFullCard;", "", "added_at", "", "altered", "", "cardid", "card_faces", "", "Lcom/studiolaganne/lengendarylens/MTFace;", "cmc", "collector_number", "color_identity", "colors", "collection", "Lcom/studiolaganne/lengendarylens/MTCardCollectionStatus;", "condition", "current_value_eur", "", "current_value_usd", "current_value_eur_foil", "current_value_usd_foil", "current_value_eur_etched", "current_value_usd_etched", "values", "Lcom/studiolaganne/lengendarylens/MTCardMarketplaceValues;", "face_index", "", OptionalModuleUtils.FACE, "faceid", "finish", "finishes", "flag", "game_changer", "reserved", WindowExtensionsConstants.LAYOUT_PACKAGE, "images", "Lcom/studiolaganne/lengendarylens/MTImageURIs;", "en_images", "lang", "listid", "list_name", "list_type", "list_card_id", "list_card_ids", AndroidContextPlugin.LOCALE_KEY, "mana_cost", "missprint", "name", "oracle_text", "oracleid", "power", "printed_name", "printed_text", "printed_type_line", "purchase_price", "proxy", FirebaseAnalytics.Param.QUANTITY, "rarity", "scryfallid", "set_code", "set_icon_svg_url", "set_name", "signed", "toughness", "type_line", "loyalty", "defense", "legalities", "Lcom/studiolaganne/lengendarylens/MTLegalities;", "released_at", NotificationCompat.CATEGORY_RECOMMENDATION, "Lcom/studiolaganne/lengendarylens/MTRecommendationData;", "tags", "available_lang", "", "variant_quantity", "variants", "variant_list_card_ids", "incollection", FirebaseAnalytics.Event.PURCHASE, "", "owner_userid", "used_in_deck", "Lcom/studiolaganne/lengendarylens/MTCardUsedInDeck;", "list_owner", "Lcom/studiolaganne/lengendarylens/MTPrivacyUser;", "ranking", "Lcom/studiolaganne/lengendarylens/MTCardRanking;", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTCardCollectionStatus;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Lcom/studiolaganne/lengendarylens/MTCardMarketplaceValues;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTLegalities;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTRecommendationData;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/Map;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTCardUsedInDeck;Lcom/studiolaganne/lengendarylens/MTPrivacyUser;Lcom/studiolaganne/lengendarylens/MTCardRanking;)V", "getAdded_at", "()Ljava/lang/String;", "setAdded_at", "(Ljava/lang/String;)V", "getAltered", "()Ljava/lang/Boolean;", "setAltered", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getCardid", "setCardid", "getCard_faces", "()Ljava/util/List;", "setCard_faces", "(Ljava/util/List;)V", "getCmc", "setCmc", "getCollector_number", "setCollector_number", "getColor_identity", "setColor_identity", "getColors", "setColors", "getCollection", "()Lcom/studiolaganne/lengendarylens/MTCardCollectionStatus;", "setCollection", "(Lcom/studiolaganne/lengendarylens/MTCardCollectionStatus;)V", "getCondition", "setCondition", "getCurrent_value_eur", "()Ljava/lang/Double;", "setCurrent_value_eur", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getCurrent_value_usd", "setCurrent_value_usd", "getCurrent_value_eur_foil", "setCurrent_value_eur_foil", "getCurrent_value_usd_foil", "setCurrent_value_usd_foil", "getCurrent_value_eur_etched", "setCurrent_value_eur_etched", "getCurrent_value_usd_etched", "setCurrent_value_usd_etched", "getValues", "()Lcom/studiolaganne/lengendarylens/MTCardMarketplaceValues;", "setValues", "(Lcom/studiolaganne/lengendarylens/MTCardMarketplaceValues;)V", "getFace_index", "()Ljava/lang/Integer;", "setFace_index", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getFace", "setFace", "getFaceid", "setFaceid", "getFinish", "setFinish", "getFinishes", "setFinishes", "getFlag", "setFlag", "getGame_changer", "setGame_changer", "getReserved", "setReserved", "getLayout", "setLayout", "getImages", "setImages", "getEn_images", "setEn_images", "getLang", "setLang", "getListid", "setListid", "getList_name", "setList_name", "getList_type", "setList_type", "getList_card_id", "setList_card_id", "getList_card_ids", "setList_card_ids", "getLocale", "setLocale", "getMana_cost", "setMana_cost", "getMissprint", "setMissprint", "getName", "setName", "getOracle_text", "setOracle_text", "getOracleid", "setOracleid", "getPower", "setPower", "getPrinted_name", "setPrinted_name", "getPrinted_text", "setPrinted_text", "getPrinted_type_line", "setPrinted_type_line", "getPurchase_price", "setPurchase_price", "getProxy", "setProxy", "getQuantity", "setQuantity", "getRarity", "setRarity", "getScryfallid", "setScryfallid", "getSet_code", "setSet_code", "getSet_icon_svg_url", "setSet_icon_svg_url", "getSet_name", "setSet_name", "getSigned", "setSigned", "getToughness", "setToughness", "getType_line", "setType_line", "getLoyalty", "setLoyalty", "getDefense", "setDefense", "getLegalities", "()Lcom/studiolaganne/lengendarylens/MTLegalities;", "setLegalities", "(Lcom/studiolaganne/lengendarylens/MTLegalities;)V", "getReleased_at", "setReleased_at", "getRecommendation", "()Lcom/studiolaganne/lengendarylens/MTRecommendationData;", "setRecommendation", "(Lcom/studiolaganne/lengendarylens/MTRecommendationData;)V", "getTags", "setTags", "getAvailable_lang", "setAvailable_lang", "getVariant_quantity", "setVariant_quantity", "getVariants", "setVariants", "getVariant_list_card_ids", "setVariant_list_card_ids", "getIncollection", "setIncollection", "getPurchase", "()Ljava/util/Map;", "setPurchase", "(Ljava/util/Map;)V", "getOwner_userid", "setOwner_userid", "getUsed_in_deck", "()Lcom/studiolaganne/lengendarylens/MTCardUsedInDeck;", "setUsed_in_deck", "(Lcom/studiolaganne/lengendarylens/MTCardUsedInDeck;)V", "getList_owner", "()Lcom/studiolaganne/lengendarylens/MTPrivacyUser;", "setList_owner", "(Lcom/studiolaganne/lengendarylens/MTPrivacyUser;)V", "getRanking", "()Lcom/studiolaganne/lengendarylens/MTCardRanking;", "setRanking", "(Lcom/studiolaganne/lengendarylens/MTCardRanking;)V", "getImageUrl", "getArtCropUrl", "getPreviewUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", "component69", "component70", "component71", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTCardCollectionStatus;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Lcom/studiolaganne/lengendarylens/MTCardMarketplaceValues;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTLegalities;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTRecommendationData;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/Map;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTCardUsedInDeck;Lcom/studiolaganne/lengendarylens/MTPrivacyUser;Lcom/studiolaganne/lengendarylens/MTCardRanking;)Lcom/studiolaganne/lengendarylens/MTFullCard;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTFullCard {
    public static final int $stable = 8;
    private String added_at;
    private Boolean altered;
    private List<String> available_lang;
    private List<MTFace> card_faces;
    private String cardid;
    private String cmc;
    private MTCardCollectionStatus collection;
    private String collector_number;
    private List<String> color_identity;
    private List<String> colors;
    private String condition;
    private Double current_value_eur;
    private Double current_value_eur_etched;
    private Double current_value_eur_foil;
    private Double current_value_usd;
    private Double current_value_usd_etched;
    private Double current_value_usd_foil;
    private String defense;
    private List<MTImageURIs> en_images;
    private Integer face;
    private Integer face_index;
    private String faceid;
    private String finish;
    private List<String> finishes;
    private Integer flag;
    private Boolean game_changer;
    private List<MTImageURIs> images;
    private Boolean incollection;
    private String lang;
    private String layout;
    private MTLegalities legalities;
    private Integer list_card_id;
    private List<Integer> list_card_ids;
    private String list_name;
    private MTPrivacyUser list_owner;
    private Integer list_type;
    private Integer listid;
    private String locale;
    private String loyalty;
    private String mana_cost;
    private Boolean missprint;
    private String name;
    private String oracle_text;
    private String oracleid;
    private Integer owner_userid;
    private String power;
    private String printed_name;
    private String printed_text;
    private String printed_type_line;
    private Boolean proxy;
    private Map<String, Double> purchase;
    private Double purchase_price;
    private Integer quantity;
    private MTCardRanking ranking;
    private String rarity;
    private MTRecommendationData recommendation;
    private String released_at;
    private Boolean reserved;
    private String scryfallid;
    private String set_code;
    private String set_icon_svg_url;
    private String set_name;
    private Boolean signed;
    private List<String> tags;
    private String toughness;
    private String type_line;
    private MTCardUsedInDeck used_in_deck;
    private MTCardMarketplaceValues values;
    private List<Integer> variant_list_card_ids;
    private Integer variant_quantity;
    private List<MTFullCard> variants;

    public MTFullCard() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null);
    }

    public MTFullCard(String str, Boolean bool, String str2, List<MTFace> list, String str3, String str4, List<String> list2, List<String> list3, MTCardCollectionStatus mTCardCollectionStatus, String str5, Double d, Double d2, Double d3, Double d4, Double d5, Double d6, MTCardMarketplaceValues mTCardMarketplaceValues, Integer num, Integer num2, String str6, String str7, List<String> list4, Integer num3, Boolean bool2, Boolean bool3, String str8, List<MTImageURIs> list5, List<MTImageURIs> list6, String lang, Integer num4, String str9, Integer num5, Integer num6, List<Integer> list7, String str10, String str11, Boolean bool4, String str12, String str13, String str14, String str15, String str16, String str17, String str18, Double d7, Boolean bool5, Integer num7, String str19, String str20, String str21, String str22, String str23, Boolean bool6, String str24, String str25, String str26, String str27, MTLegalities mTLegalities, String str28, MTRecommendationData mTRecommendationData, List<String> list8, List<String> list9, Integer num8, List<MTFullCard> list10, List<Integer> list11, Boolean bool7, Map<String, Double> map, Integer num9, MTCardUsedInDeck mTCardUsedInDeck, MTPrivacyUser mTPrivacyUser, MTCardRanking mTCardRanking) {
        Intrinsics.checkNotNullParameter(lang, "lang");
        this.added_at = str;
        this.altered = bool;
        this.cardid = str2;
        this.card_faces = list;
        this.cmc = str3;
        this.collector_number = str4;
        this.color_identity = list2;
        this.colors = list3;
        this.collection = mTCardCollectionStatus;
        this.condition = str5;
        this.current_value_eur = d;
        this.current_value_usd = d2;
        this.current_value_eur_foil = d3;
        this.current_value_usd_foil = d4;
        this.current_value_eur_etched = d5;
        this.current_value_usd_etched = d6;
        this.values = mTCardMarketplaceValues;
        this.face_index = num;
        this.face = num2;
        this.faceid = str6;
        this.finish = str7;
        this.finishes = list4;
        this.flag = num3;
        this.game_changer = bool2;
        this.reserved = bool3;
        this.layout = str8;
        this.images = list5;
        this.en_images = list6;
        this.lang = lang;
        this.listid = num4;
        this.list_name = str9;
        this.list_type = num5;
        this.list_card_id = num6;
        this.list_card_ids = list7;
        this.locale = str10;
        this.mana_cost = str11;
        this.missprint = bool4;
        this.name = str12;
        this.oracle_text = str13;
        this.oracleid = str14;
        this.power = str15;
        this.printed_name = str16;
        this.printed_text = str17;
        this.printed_type_line = str18;
        this.purchase_price = d7;
        this.proxy = bool5;
        this.quantity = num7;
        this.rarity = str19;
        this.scryfallid = str20;
        this.set_code = str21;
        this.set_icon_svg_url = str22;
        this.set_name = str23;
        this.signed = bool6;
        this.toughness = str24;
        this.type_line = str25;
        this.loyalty = str26;
        this.defense = str27;
        this.legalities = mTLegalities;
        this.released_at = str28;
        this.recommendation = mTRecommendationData;
        this.tags = list8;
        this.available_lang = list9;
        this.variant_quantity = num8;
        this.variants = list10;
        this.variant_list_card_ids = list11;
        this.incollection = bool7;
        this.purchase = map;
        this.owner_userid = num9;
        this.used_in_deck = mTCardUsedInDeck;
        this.list_owner = mTPrivacyUser;
        this.ranking = mTCardRanking;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ MTFullCard(String str, Boolean bool, String str2, List list, String str3, String str4, List list2, List list3, MTCardCollectionStatus mTCardCollectionStatus, String str5, Double d, Double d2, Double d3, Double d4, Double d5, Double d6, MTCardMarketplaceValues mTCardMarketplaceValues, Integer num, Integer num2, String str6, String str7, List list4, Integer num3, Boolean bool2, Boolean bool3, String str8, List list5, List list6, String str9, Integer num4, String str10, Integer num5, Integer num6, List list7, String str11, String str12, Boolean bool4, String str13, String str14, String str15, String str16, String str17, String str18, String str19, Double d7, Boolean bool5, Integer num7, String str20, String str21, String str22, String str23, String str24, Boolean bool6, String str25, String str26, String str27, String str28, MTLegalities mTLegalities, String str29, MTRecommendationData mTRecommendationData, List list8, List list9, Integer num8, List list10, List list11, Boolean bool7, Map map, Integer num9, MTCardUsedInDeck mTCardUsedInDeck, MTPrivacyUser mTPrivacyUser, MTCardRanking mTCardRanking, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        String str30 = (i & 1) != 0 ? null : str;
        Boolean bool8 = (i & 2) != 0 ? null : bool;
        String str31 = (i & 4) != 0 ? null : str2;
        List list12 = (i & 8) != 0 ? null : list;
        String str32 = (i & 16) != 0 ? null : str3;
        String str33 = (i & 32) != 0 ? null : str4;
        List list13 = (i & 64) != 0 ? null : list2;
        List list14 = (i & 128) != 0 ? null : list3;
        MTCardCollectionStatus mTCardCollectionStatus2 = (i & 256) != 0 ? null : mTCardCollectionStatus;
        String str34 = (i & 512) != 0 ? null : str5;
        Double d8 = (i & 1024) != 0 ? null : d;
        Double d9 = (i & 2048) != 0 ? null : d2;
        Double d10 = (i & 4096) != 0 ? null : d3;
        Double d11 = (i & 8192) != 0 ? null : d4;
        String str35 = str30;
        Double d12 = (i & 16384) != 0 ? null : d5;
        Double d13 = (i & 32768) != 0 ? null : d6;
        MTCardMarketplaceValues mTCardMarketplaceValues2 = (i & 65536) != 0 ? null : mTCardMarketplaceValues;
        Integer num10 = (i & 131072) != 0 ? null : num;
        Integer num11 = (i & 262144) != 0 ? null : num2;
        String str36 = (i & 524288) != 0 ? null : str6;
        String str37 = (i & 1048576) != 0 ? null : str7;
        List list15 = (i & 2097152) != 0 ? null : list4;
        Integer num12 = (i & 4194304) != 0 ? null : num3;
        Boolean bool9 = (i & 8388608) != 0 ? null : bool2;
        Boolean bool10 = (i & 16777216) != 0 ? null : bool3;
        String str38 = (i & 33554432) != 0 ? null : str8;
        List list16 = (i & 67108864) != 0 ? null : list5;
        List list17 = (i & 134217728) != 0 ? null : list6;
        String str39 = (i & 268435456) != 0 ? "en" : str9;
        Integer num13 = (i & 536870912) != 0 ? null : num4;
        String str40 = (i & 1073741824) != 0 ? null : str10;
        Integer num14 = (i & Integer.MIN_VALUE) != 0 ? null : num5;
        Integer num15 = (i2 & 1) != 0 ? null : num6;
        List list18 = (i2 & 2) != 0 ? null : list7;
        String str41 = (i2 & 4) != 0 ? null : str11;
        String str42 = (i2 & 8) != 0 ? null : str12;
        Boolean bool11 = (i2 & 16) != 0 ? null : bool4;
        String str43 = (i2 & 32) != 0 ? null : str13;
        String str44 = (i2 & 64) != 0 ? null : str14;
        Integer num16 = num14;
        String str45 = (i2 & 128) != 0 ? null : str15;
        Boolean bool12 = bool8;
        String str46 = str31;
        List list19 = list12;
        String str47 = str32;
        String str48 = str33;
        List list20 = list13;
        List list21 = list14;
        MTCardCollectionStatus mTCardCollectionStatus3 = mTCardCollectionStatus2;
        String str49 = str34;
        Double d14 = d8;
        Double d15 = d9;
        Double d16 = d10;
        this(str35, bool12, str46, list19, str47, str48, list20, list21, mTCardCollectionStatus3, str49, d14, d15, d16, d11, d12, d13, mTCardMarketplaceValues2, num10, num11, str36, str37, list15, num12, bool9, bool10, str38, list16, list17, str39, num13, str40, num16, num15, list18, str41, str42, bool11, str43, str44, str45, (i2 & 256) != 0 ? null : str16, (i2 & 512) != 0 ? null : str17, (i2 & 1024) != 0 ? null : str18, (i2 & 2048) != 0 ? null : str19, (i2 & 4096) != 0 ? null : d7, (i2 & 8192) != 0 ? null : bool5, (i2 & 16384) != 0 ? 1 : num7, (i2 & 32768) != 0 ? null : str20, (i2 & 65536) != 0 ? null : str21, (i2 & 131072) != 0 ? null : str22, (i2 & 262144) != 0 ? null : str23, (i2 & 524288) != 0 ? null : str24, (i2 & 1048576) != 0 ? null : bool6, (i2 & 2097152) != 0 ? null : str25, (i2 & 4194304) != 0 ? null : str26, (i2 & 8388608) != 0 ? null : str27, (i2 & 16777216) != 0 ? null : str28, (i2 & 33554432) != 0 ? null : mTLegalities, (i2 & 67108864) != 0 ? null : str29, (i2 & 134217728) != 0 ? null : mTRecommendationData, (i2 & 268435456) != 0 ? null : list8, (i2 & 536870912) != 0 ? null : list9, (i2 & 1073741824) != 0 ? null : num8, (i2 & Integer.MIN_VALUE) != 0 ? null : list10, (i3 & 1) != 0 ? null : list11, (i3 & 2) != 0 ? null : bool7, (i3 & 4) != 0 ? null : map, (i3 & 8) != 0 ? null : num9, (i3 & 16) != 0 ? null : mTCardUsedInDeck, (i3 & 32) != 0 ? null : mTPrivacyUser, (i3 & 64) != 0 ? null : mTCardRanking);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTFullCard copy$default(MTFullCard mTFullCard, String str, Boolean bool, String str2, List list, String str3, String str4, List list2, List list3, MTCardCollectionStatus mTCardCollectionStatus, String str5, Double d, Double d2, Double d3, Double d4, Double d5, Double d6, MTCardMarketplaceValues mTCardMarketplaceValues, Integer num, Integer num2, String str6, String str7, List list4, Integer num3, Boolean bool2, Boolean bool3, String str8, List list5, List list6, String str9, Integer num4, String str10, Integer num5, Integer num6, List list7, String str11, String str12, Boolean bool4, String str13, String str14, String str15, String str16, String str17, String str18, String str19, Double d7, Boolean bool5, Integer num7, String str20, String str21, String str22, String str23, String str24, Boolean bool6, String str25, String str26, String str27, String str28, MTLegalities mTLegalities, String str29, MTRecommendationData mTRecommendationData, List list8, List list9, Integer num8, List list10, List list11, Boolean bool7, Map map, Integer num9, MTCardUsedInDeck mTCardUsedInDeck, MTPrivacyUser mTPrivacyUser, MTCardRanking mTCardRanking, int i, int i2, int i3, Object obj) {
        MTCardRanking mTCardRanking2;
        MTPrivacyUser mTPrivacyUser2;
        String str30;
        String str31;
        String str32;
        MTLegalities mTLegalities2;
        String str33;
        MTRecommendationData mTRecommendationData2;
        List list12;
        List list13;
        Integer num10;
        List list14;
        Boolean bool8;
        Map map2;
        Integer num11;
        MTCardUsedInDeck mTCardUsedInDeck2;
        List list15;
        String str34;
        String str35;
        String str36;
        String str37;
        Double d8;
        Boolean bool9;
        Integer num12;
        String str38;
        String str39;
        String str40;
        String str41;
        String str42;
        Boolean bool10;
        String str43;
        List list16;
        List list17;
        String str44;
        Integer num13;
        String str45;
        Integer num14;
        Integer num15;
        List list18;
        String str46;
        String str47;
        Boolean bool11;
        String str48;
        String str49;
        String str50;
        Double d9;
        Double d10;
        Double d11;
        Double d12;
        MTCardMarketplaceValues mTCardMarketplaceValues2;
        Integer num16;
        Integer num17;
        String str51;
        String str52;
        List list19;
        Integer num18;
        Boolean bool12;
        Boolean bool13;
        String str53;
        Boolean bool14;
        String str54;
        List list20;
        String str55;
        String str56;
        List list21;
        List list22;
        MTCardCollectionStatus mTCardCollectionStatus2;
        String str57;
        Double d13;
        Double d14;
        String str58 = (i & 1) != 0 ? mTFullCard.added_at : str;
        Boolean bool15 = (i & 2) != 0 ? mTFullCard.altered : bool;
        String str59 = (i & 4) != 0 ? mTFullCard.cardid : str2;
        List list23 = (i & 8) != 0 ? mTFullCard.card_faces : list;
        String str60 = (i & 16) != 0 ? mTFullCard.cmc : str3;
        String str61 = (i & 32) != 0 ? mTFullCard.collector_number : str4;
        List list24 = (i & 64) != 0 ? mTFullCard.color_identity : list2;
        List list25 = (i & 128) != 0 ? mTFullCard.colors : list3;
        MTCardCollectionStatus mTCardCollectionStatus3 = (i & 256) != 0 ? mTFullCard.collection : mTCardCollectionStatus;
        String str62 = (i & 512) != 0 ? mTFullCard.condition : str5;
        Double d15 = (i & 1024) != 0 ? mTFullCard.current_value_eur : d;
        Double d16 = (i & 2048) != 0 ? mTFullCard.current_value_usd : d2;
        Double d17 = (i & 4096) != 0 ? mTFullCard.current_value_eur_foil : d3;
        String str63 = str58;
        Double d18 = (i & 8192) != 0 ? mTFullCard.current_value_usd_foil : d4;
        Double d19 = (i & 16384) != 0 ? mTFullCard.current_value_eur_etched : d5;
        Double d20 = (i & 32768) != 0 ? mTFullCard.current_value_usd_etched : d6;
        MTCardMarketplaceValues mTCardMarketplaceValues3 = (i & 65536) != 0 ? mTFullCard.values : mTCardMarketplaceValues;
        Integer num19 = (i & 131072) != 0 ? mTFullCard.face_index : num;
        Integer num20 = (i & 262144) != 0 ? mTFullCard.face : num2;
        String str64 = (i & 524288) != 0 ? mTFullCard.faceid : str6;
        String str65 = (i & 1048576) != 0 ? mTFullCard.finish : str7;
        List list26 = (i & 2097152) != 0 ? mTFullCard.finishes : list4;
        Integer num21 = (i & 4194304) != 0 ? mTFullCard.flag : num3;
        Boolean bool16 = (i & 8388608) != 0 ? mTFullCard.game_changer : bool2;
        Boolean bool17 = (i & 16777216) != 0 ? mTFullCard.reserved : bool3;
        String str66 = (i & 33554432) != 0 ? mTFullCard.layout : str8;
        List list27 = (i & 67108864) != 0 ? mTFullCard.images : list5;
        List list28 = (i & 134217728) != 0 ? mTFullCard.en_images : list6;
        String str67 = (i & 268435456) != 0 ? mTFullCard.lang : str9;
        Integer num22 = (i & 536870912) != 0 ? mTFullCard.listid : num4;
        String str68 = (i & 1073741824) != 0 ? mTFullCard.list_name : str10;
        Integer num23 = (i & Integer.MIN_VALUE) != 0 ? mTFullCard.list_type : num5;
        Integer num24 = (i2 & 1) != 0 ? mTFullCard.list_card_id : num6;
        List list29 = (i2 & 2) != 0 ? mTFullCard.list_card_ids : list7;
        String str69 = (i2 & 4) != 0 ? mTFullCard.locale : str11;
        String str70 = (i2 & 8) != 0 ? mTFullCard.mana_cost : str12;
        Boolean bool18 = (i2 & 16) != 0 ? mTFullCard.missprint : bool4;
        String str71 = (i2 & 32) != 0 ? mTFullCard.name : str13;
        String str72 = (i2 & 64) != 0 ? mTFullCard.oracle_text : str14;
        String str73 = (i2 & 128) != 0 ? mTFullCard.oracleid : str15;
        String str74 = (i2 & 256) != 0 ? mTFullCard.power : str16;
        String str75 = (i2 & 512) != 0 ? mTFullCard.printed_name : str17;
        String str76 = (i2 & 1024) != 0 ? mTFullCard.printed_text : str18;
        String str77 = (i2 & 2048) != 0 ? mTFullCard.printed_type_line : str19;
        Double d21 = (i2 & 4096) != 0 ? mTFullCard.purchase_price : d7;
        Boolean bool19 = (i2 & 8192) != 0 ? mTFullCard.proxy : bool5;
        Integer num25 = (i2 & 16384) != 0 ? mTFullCard.quantity : num7;
        String str78 = (i2 & 32768) != 0 ? mTFullCard.rarity : str20;
        String str79 = (i2 & 65536) != 0 ? mTFullCard.scryfallid : str21;
        String str80 = (i2 & 131072) != 0 ? mTFullCard.set_code : str22;
        String str81 = (i2 & 262144) != 0 ? mTFullCard.set_icon_svg_url : str23;
        String str82 = (i2 & 524288) != 0 ? mTFullCard.set_name : str24;
        Boolean bool20 = (i2 & 1048576) != 0 ? mTFullCard.signed : bool6;
        String str83 = (i2 & 2097152) != 0 ? mTFullCard.toughness : str25;
        String str84 = (i2 & 4194304) != 0 ? mTFullCard.type_line : str26;
        String str85 = (i2 & 8388608) != 0 ? mTFullCard.loyalty : str27;
        String str86 = (i2 & 16777216) != 0 ? mTFullCard.defense : str28;
        MTLegalities mTLegalities3 = (i2 & 33554432) != 0 ? mTFullCard.legalities : mTLegalities;
        String str87 = (i2 & 67108864) != 0 ? mTFullCard.released_at : str29;
        MTRecommendationData mTRecommendationData3 = (i2 & 134217728) != 0 ? mTFullCard.recommendation : mTRecommendationData;
        List list30 = (i2 & 268435456) != 0 ? mTFullCard.tags : list8;
        List list31 = (i2 & 536870912) != 0 ? mTFullCard.available_lang : list9;
        Integer num26 = (i2 & 1073741824) != 0 ? mTFullCard.variant_quantity : num8;
        List list32 = (i2 & Integer.MIN_VALUE) != 0 ? mTFullCard.variants : list10;
        Integer num27 = num26;
        List list33 = (i3 & 1) != 0 ? mTFullCard.variant_list_card_ids : list11;
        Boolean bool21 = (i3 & 2) != 0 ? mTFullCard.incollection : bool7;
        Map map3 = (i3 & 4) != 0 ? mTFullCard.purchase : map;
        Integer num28 = (i3 & 8) != 0 ? mTFullCard.owner_userid : num9;
        MTCardUsedInDeck mTCardUsedInDeck3 = (i3 & 16) != 0 ? mTFullCard.used_in_deck : mTCardUsedInDeck;
        MTPrivacyUser mTPrivacyUser3 = (i3 & 32) != 0 ? mTFullCard.list_owner : mTPrivacyUser;
        if ((i3 & 64) != 0) {
            mTPrivacyUser2 = mTPrivacyUser3;
            mTCardRanking2 = mTFullCard.ranking;
            str31 = str85;
            str32 = str86;
            mTLegalities2 = mTLegalities3;
            str33 = str87;
            mTRecommendationData2 = mTRecommendationData3;
            list12 = list30;
            list13 = list31;
            num10 = num27;
            list14 = list33;
            bool8 = bool21;
            map2 = map3;
            num11 = num28;
            mTCardUsedInDeck2 = mTCardUsedInDeck3;
            list15 = list32;
            str35 = str75;
            str36 = str76;
            str37 = str77;
            d8 = d21;
            bool9 = bool19;
            num12 = num25;
            str38 = str78;
            str39 = str79;
            str40 = str80;
            str41 = str81;
            str42 = str82;
            bool10 = bool20;
            str43 = str83;
            str30 = str84;
            list17 = list28;
            str44 = str67;
            num13 = num22;
            str45 = str68;
            num14 = num23;
            num15 = num24;
            list18 = list29;
            str46 = str69;
            str47 = str70;
            bool11 = bool18;
            str48 = str71;
            str49 = str72;
            str50 = str73;
            str34 = str74;
            d9 = d19;
            d11 = d18;
            d12 = d20;
            mTCardMarketplaceValues2 = mTCardMarketplaceValues3;
            num16 = num19;
            num17 = num20;
            str51 = str64;
            str52 = str65;
            list19 = list26;
            num18 = num21;
            bool12 = bool16;
            bool13 = bool17;
            str53 = str66;
            list16 = list27;
            bool14 = bool15;
            str54 = str59;
            list20 = list23;
            str55 = str60;
            str56 = str61;
            list21 = list24;
            list22 = list25;
            mTCardCollectionStatus2 = mTCardCollectionStatus3;
            str57 = str62;
            d13 = d15;
            d14 = d16;
            d10 = d17;
        } else {
            mTCardRanking2 = mTCardRanking;
            mTPrivacyUser2 = mTPrivacyUser3;
            str30 = str84;
            str31 = str85;
            str32 = str86;
            mTLegalities2 = mTLegalities3;
            str33 = str87;
            mTRecommendationData2 = mTRecommendationData3;
            list12 = list30;
            list13 = list31;
            num10 = num27;
            list14 = list33;
            bool8 = bool21;
            map2 = map3;
            num11 = num28;
            mTCardUsedInDeck2 = mTCardUsedInDeck3;
            list15 = list32;
            str34 = str74;
            str35 = str75;
            str36 = str76;
            str37 = str77;
            d8 = d21;
            bool9 = bool19;
            num12 = num25;
            str38 = str78;
            str39 = str79;
            str40 = str80;
            str41 = str81;
            str42 = str82;
            bool10 = bool20;
            str43 = str83;
            list16 = list27;
            list17 = list28;
            str44 = str67;
            num13 = num22;
            str45 = str68;
            num14 = num23;
            num15 = num24;
            list18 = list29;
            str46 = str69;
            str47 = str70;
            bool11 = bool18;
            str48 = str71;
            str49 = str72;
            str50 = str73;
            d9 = d19;
            d10 = d17;
            d11 = d18;
            d12 = d20;
            mTCardMarketplaceValues2 = mTCardMarketplaceValues3;
            num16 = num19;
            num17 = num20;
            str51 = str64;
            str52 = str65;
            list19 = list26;
            num18 = num21;
            bool12 = bool16;
            bool13 = bool17;
            str53 = str66;
            bool14 = bool15;
            str54 = str59;
            list20 = list23;
            str55 = str60;
            str56 = str61;
            list21 = list24;
            list22 = list25;
            mTCardCollectionStatus2 = mTCardCollectionStatus3;
            str57 = str62;
            d13 = d15;
            d14 = d16;
        }
        return mTFullCard.copy(str63, bool14, str54, list20, str55, str56, list21, list22, mTCardCollectionStatus2, str57, d13, d14, d10, d11, d9, d12, mTCardMarketplaceValues2, num16, num17, str51, str52, list19, num18, bool12, bool13, str53, list16, list17, str44, num13, str45, num14, num15, list18, str46, str47, bool11, str48, str49, str50, str34, str35, str36, str37, d8, bool9, num12, str38, str39, str40, str41, str42, bool10, str43, str30, str31, str32, mTLegalities2, str33, mTRecommendationData2, list12, list13, num10, list15, list14, bool8, map2, num11, mTCardUsedInDeck2, mTPrivacyUser2, mTCardRanking2);
    }

    public static /* synthetic */ String getArtCropUrl$default(MTFullCard mTFullCard, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return mTFullCard.getArtCropUrl(i);
    }

    public static /* synthetic */ String getImageUrl$default(MTFullCard mTFullCard, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return mTFullCard.getImageUrl(i);
    }

    public static /* synthetic */ String getPreviewUrl$default(MTFullCard mTFullCard, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return mTFullCard.getPreviewUrl(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAdded_at() {
        return this.added_at;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getCondition() {
        return this.condition;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Double getCurrent_value_eur() {
        return this.current_value_eur;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Double getCurrent_value_usd() {
        return this.current_value_usd;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Double getCurrent_value_eur_foil() {
        return this.current_value_eur_foil;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Double getCurrent_value_usd_foil() {
        return this.current_value_usd_foil;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Double getCurrent_value_eur_etched() {
        return this.current_value_eur_etched;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Double getCurrent_value_usd_etched() {
        return this.current_value_usd_etched;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final MTCardMarketplaceValues getValues() {
        return this.values;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final Integer getFace_index() {
        return this.face_index;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final Integer getFace() {
        return this.face;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getAltered() {
        return this.altered;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getFaceid() {
        return this.faceid;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getFinish() {
        return this.finish;
    }

    public final List<String> component22() {
        return this.finishes;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final Integer getFlag() {
        return this.flag;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final Boolean getGame_changer() {
        return this.game_changer;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final Boolean getReserved() {
        return this.reserved;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final String getLayout() {
        return this.layout;
    }

    public final List<MTImageURIs> component27() {
        return this.images;
    }

    public final List<MTImageURIs> component28() {
        return this.en_images;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final String getLang() {
        return this.lang;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCardid() {
        return this.cardid;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final Integer getListid() {
        return this.listid;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final String getList_name() {
        return this.list_name;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final Integer getList_type() {
        return this.list_type;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final Integer getList_card_id() {
        return this.list_card_id;
    }

    public final List<Integer> component34() {
        return this.list_card_ids;
    }

    /* JADX INFO: renamed from: component35, reason: from getter */
    public final String getLocale() {
        return this.locale;
    }

    /* JADX INFO: renamed from: component36, reason: from getter */
    public final String getMana_cost() {
        return this.mana_cost;
    }

    /* JADX INFO: renamed from: component37, reason: from getter */
    public final Boolean getMissprint() {
        return this.missprint;
    }

    /* JADX INFO: renamed from: component38, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component39, reason: from getter */
    public final String getOracle_text() {
        return this.oracle_text;
    }

    public final List<MTFace> component4() {
        return this.card_faces;
    }

    /* JADX INFO: renamed from: component40, reason: from getter */
    public final String getOracleid() {
        return this.oracleid;
    }

    /* JADX INFO: renamed from: component41, reason: from getter */
    public final String getPower() {
        return this.power;
    }

    /* JADX INFO: renamed from: component42, reason: from getter */
    public final String getPrinted_name() {
        return this.printed_name;
    }

    /* JADX INFO: renamed from: component43, reason: from getter */
    public final String getPrinted_text() {
        return this.printed_text;
    }

    /* JADX INFO: renamed from: component44, reason: from getter */
    public final String getPrinted_type_line() {
        return this.printed_type_line;
    }

    /* JADX INFO: renamed from: component45, reason: from getter */
    public final Double getPurchase_price() {
        return this.purchase_price;
    }

    /* JADX INFO: renamed from: component46, reason: from getter */
    public final Boolean getProxy() {
        return this.proxy;
    }

    /* JADX INFO: renamed from: component47, reason: from getter */
    public final Integer getQuantity() {
        return this.quantity;
    }

    /* JADX INFO: renamed from: component48, reason: from getter */
    public final String getRarity() {
        return this.rarity;
    }

    /* JADX INFO: renamed from: component49, reason: from getter */
    public final String getScryfallid() {
        return this.scryfallid;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getCmc() {
        return this.cmc;
    }

    /* JADX INFO: renamed from: component50, reason: from getter */
    public final String getSet_code() {
        return this.set_code;
    }

    /* JADX INFO: renamed from: component51, reason: from getter */
    public final String getSet_icon_svg_url() {
        return this.set_icon_svg_url;
    }

    /* JADX INFO: renamed from: component52, reason: from getter */
    public final String getSet_name() {
        return this.set_name;
    }

    /* JADX INFO: renamed from: component53, reason: from getter */
    public final Boolean getSigned() {
        return this.signed;
    }

    /* JADX INFO: renamed from: component54, reason: from getter */
    public final String getToughness() {
        return this.toughness;
    }

    /* JADX INFO: renamed from: component55, reason: from getter */
    public final String getType_line() {
        return this.type_line;
    }

    /* JADX INFO: renamed from: component56, reason: from getter */
    public final String getLoyalty() {
        return this.loyalty;
    }

    /* JADX INFO: renamed from: component57, reason: from getter */
    public final String getDefense() {
        return this.defense;
    }

    /* JADX INFO: renamed from: component58, reason: from getter */
    public final MTLegalities getLegalities() {
        return this.legalities;
    }

    /* JADX INFO: renamed from: component59, reason: from getter */
    public final String getReleased_at() {
        return this.released_at;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCollector_number() {
        return this.collector_number;
    }

    /* JADX INFO: renamed from: component60, reason: from getter */
    public final MTRecommendationData getRecommendation() {
        return this.recommendation;
    }

    public final List<String> component61() {
        return this.tags;
    }

    public final List<String> component62() {
        return this.available_lang;
    }

    /* JADX INFO: renamed from: component63, reason: from getter */
    public final Integer getVariant_quantity() {
        return this.variant_quantity;
    }

    public final List<MTFullCard> component64() {
        return this.variants;
    }

    public final List<Integer> component65() {
        return this.variant_list_card_ids;
    }

    /* JADX INFO: renamed from: component66, reason: from getter */
    public final Boolean getIncollection() {
        return this.incollection;
    }

    public final Map<String, Double> component67() {
        return this.purchase;
    }

    /* JADX INFO: renamed from: component68, reason: from getter */
    public final Integer getOwner_userid() {
        return this.owner_userid;
    }

    /* JADX INFO: renamed from: component69, reason: from getter */
    public final MTCardUsedInDeck getUsed_in_deck() {
        return this.used_in_deck;
    }

    public final List<String> component7() {
        return this.color_identity;
    }

    /* JADX INFO: renamed from: component70, reason: from getter */
    public final MTPrivacyUser getList_owner() {
        return this.list_owner;
    }

    /* JADX INFO: renamed from: component71, reason: from getter */
    public final MTCardRanking getRanking() {
        return this.ranking;
    }

    public final List<String> component8() {
        return this.colors;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final MTCardCollectionStatus getCollection() {
        return this.collection;
    }

    public final MTFullCard copy(String added_at, Boolean altered, String cardid, List<MTFace> card_faces, String cmc, String collector_number, List<String> color_identity, List<String> colors, MTCardCollectionStatus collection, String condition, Double current_value_eur, Double current_value_usd, Double current_value_eur_foil, Double current_value_usd_foil, Double current_value_eur_etched, Double current_value_usd_etched, MTCardMarketplaceValues values, Integer face_index, Integer face, String faceid, String finish, List<String> finishes, Integer flag, Boolean game_changer, Boolean reserved, String layout, List<MTImageURIs> images, List<MTImageURIs> en_images, String lang, Integer listid, String list_name, Integer list_type, Integer list_card_id, List<Integer> list_card_ids, String locale, String mana_cost, Boolean missprint, String name, String oracle_text, String oracleid, String power, String printed_name, String printed_text, String printed_type_line, Double purchase_price, Boolean proxy, Integer quantity, String rarity, String scryfallid, String set_code, String set_icon_svg_url, String set_name, Boolean signed, String toughness, String type_line, String loyalty, String defense, MTLegalities legalities, String released_at, MTRecommendationData recommendation, List<String> tags, List<String> available_lang, Integer variant_quantity, List<MTFullCard> variants, List<Integer> variant_list_card_ids, Boolean incollection, Map<String, Double> purchase, Integer owner_userid, MTCardUsedInDeck used_in_deck, MTPrivacyUser list_owner, MTCardRanking ranking) {
        Intrinsics.checkNotNullParameter(lang, "lang");
        return new MTFullCard(added_at, altered, cardid, card_faces, cmc, collector_number, color_identity, colors, collection, condition, current_value_eur, current_value_usd, current_value_eur_foil, current_value_usd_foil, current_value_eur_etched, current_value_usd_etched, values, face_index, face, faceid, finish, finishes, flag, game_changer, reserved, layout, images, en_images, lang, listid, list_name, list_type, list_card_id, list_card_ids, locale, mana_cost, missprint, name, oracle_text, oracleid, power, printed_name, printed_text, printed_type_line, purchase_price, proxy, quantity, rarity, scryfallid, set_code, set_icon_svg_url, set_name, signed, toughness, type_line, loyalty, defense, legalities, released_at, recommendation, tags, available_lang, variant_quantity, variants, variant_list_card_ids, incollection, purchase, owner_userid, used_in_deck, list_owner, ranking);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTFullCard)) {
            return false;
        }
        MTFullCard mTFullCard = (MTFullCard) other;
        return Intrinsics.areEqual(this.added_at, mTFullCard.added_at) && Intrinsics.areEqual(this.altered, mTFullCard.altered) && Intrinsics.areEqual(this.cardid, mTFullCard.cardid) && Intrinsics.areEqual(this.card_faces, mTFullCard.card_faces) && Intrinsics.areEqual(this.cmc, mTFullCard.cmc) && Intrinsics.areEqual(this.collector_number, mTFullCard.collector_number) && Intrinsics.areEqual(this.color_identity, mTFullCard.color_identity) && Intrinsics.areEqual(this.colors, mTFullCard.colors) && Intrinsics.areEqual(this.collection, mTFullCard.collection) && Intrinsics.areEqual(this.condition, mTFullCard.condition) && Intrinsics.areEqual((Object) this.current_value_eur, (Object) mTFullCard.current_value_eur) && Intrinsics.areEqual((Object) this.current_value_usd, (Object) mTFullCard.current_value_usd) && Intrinsics.areEqual((Object) this.current_value_eur_foil, (Object) mTFullCard.current_value_eur_foil) && Intrinsics.areEqual((Object) this.current_value_usd_foil, (Object) mTFullCard.current_value_usd_foil) && Intrinsics.areEqual((Object) this.current_value_eur_etched, (Object) mTFullCard.current_value_eur_etched) && Intrinsics.areEqual((Object) this.current_value_usd_etched, (Object) mTFullCard.current_value_usd_etched) && Intrinsics.areEqual(this.values, mTFullCard.values) && Intrinsics.areEqual(this.face_index, mTFullCard.face_index) && Intrinsics.areEqual(this.face, mTFullCard.face) && Intrinsics.areEqual(this.faceid, mTFullCard.faceid) && Intrinsics.areEqual(this.finish, mTFullCard.finish) && Intrinsics.areEqual(this.finishes, mTFullCard.finishes) && Intrinsics.areEqual(this.flag, mTFullCard.flag) && Intrinsics.areEqual(this.game_changer, mTFullCard.game_changer) && Intrinsics.areEqual(this.reserved, mTFullCard.reserved) && Intrinsics.areEqual(this.layout, mTFullCard.layout) && Intrinsics.areEqual(this.images, mTFullCard.images) && Intrinsics.areEqual(this.en_images, mTFullCard.en_images) && Intrinsics.areEqual(this.lang, mTFullCard.lang) && Intrinsics.areEqual(this.listid, mTFullCard.listid) && Intrinsics.areEqual(this.list_name, mTFullCard.list_name) && Intrinsics.areEqual(this.list_type, mTFullCard.list_type) && Intrinsics.areEqual(this.list_card_id, mTFullCard.list_card_id) && Intrinsics.areEqual(this.list_card_ids, mTFullCard.list_card_ids) && Intrinsics.areEqual(this.locale, mTFullCard.locale) && Intrinsics.areEqual(this.mana_cost, mTFullCard.mana_cost) && Intrinsics.areEqual(this.missprint, mTFullCard.missprint) && Intrinsics.areEqual(this.name, mTFullCard.name) && Intrinsics.areEqual(this.oracle_text, mTFullCard.oracle_text) && Intrinsics.areEqual(this.oracleid, mTFullCard.oracleid) && Intrinsics.areEqual(this.power, mTFullCard.power) && Intrinsics.areEqual(this.printed_name, mTFullCard.printed_name) && Intrinsics.areEqual(this.printed_text, mTFullCard.printed_text) && Intrinsics.areEqual(this.printed_type_line, mTFullCard.printed_type_line) && Intrinsics.areEqual((Object) this.purchase_price, (Object) mTFullCard.purchase_price) && Intrinsics.areEqual(this.proxy, mTFullCard.proxy) && Intrinsics.areEqual(this.quantity, mTFullCard.quantity) && Intrinsics.areEqual(this.rarity, mTFullCard.rarity) && Intrinsics.areEqual(this.scryfallid, mTFullCard.scryfallid) && Intrinsics.areEqual(this.set_code, mTFullCard.set_code) && Intrinsics.areEqual(this.set_icon_svg_url, mTFullCard.set_icon_svg_url) && Intrinsics.areEqual(this.set_name, mTFullCard.set_name) && Intrinsics.areEqual(this.signed, mTFullCard.signed) && Intrinsics.areEqual(this.toughness, mTFullCard.toughness) && Intrinsics.areEqual(this.type_line, mTFullCard.type_line) && Intrinsics.areEqual(this.loyalty, mTFullCard.loyalty) && Intrinsics.areEqual(this.defense, mTFullCard.defense) && Intrinsics.areEqual(this.legalities, mTFullCard.legalities) && Intrinsics.areEqual(this.released_at, mTFullCard.released_at) && Intrinsics.areEqual(this.recommendation, mTFullCard.recommendation) && Intrinsics.areEqual(this.tags, mTFullCard.tags) && Intrinsics.areEqual(this.available_lang, mTFullCard.available_lang) && Intrinsics.areEqual(this.variant_quantity, mTFullCard.variant_quantity) && Intrinsics.areEqual(this.variants, mTFullCard.variants) && Intrinsics.areEqual(this.variant_list_card_ids, mTFullCard.variant_list_card_ids) && Intrinsics.areEqual(this.incollection, mTFullCard.incollection) && Intrinsics.areEqual(this.purchase, mTFullCard.purchase) && Intrinsics.areEqual(this.owner_userid, mTFullCard.owner_userid) && Intrinsics.areEqual(this.used_in_deck, mTFullCard.used_in_deck) && Intrinsics.areEqual(this.list_owner, mTFullCard.list_owner) && Intrinsics.areEqual(this.ranking, mTFullCard.ranking);
    }

    public final String getAdded_at() {
        return this.added_at;
    }

    public final Boolean getAltered() {
        return this.altered;
    }

    public final String getArtCropUrl(int face) {
        String art_crop;
        List<MTImageURIs> list = this.images;
        MTImageURIs mTImageURIs = list != null ? (MTImageURIs) CollectionsKt.getOrNull(list, face) : null;
        List<MTImageURIs> list2 = this.en_images;
        MTImageURIs mTImageURIs2 = list2 != null ? (MTImageURIs) CollectionsKt.getOrNull(list2, face) : null;
        if (mTImageURIs != null && (art_crop = mTImageURIs.getArt_crop()) != null) {
            return art_crop;
        }
        String art_crop2 = mTImageURIs2 != null ? mTImageURIs2.getArt_crop() : null;
        return art_crop2 == null ? "" : art_crop2;
    }

    public final List<String> getAvailable_lang() {
        return this.available_lang;
    }

    public final List<MTFace> getCard_faces() {
        return this.card_faces;
    }

    public final String getCardid() {
        return this.cardid;
    }

    public final String getCmc() {
        return this.cmc;
    }

    public final MTCardCollectionStatus getCollection() {
        return this.collection;
    }

    public final String getCollector_number() {
        return this.collector_number;
    }

    public final List<String> getColor_identity() {
        return this.color_identity;
    }

    public final List<String> getColors() {
        return this.colors;
    }

    public final String getCondition() {
        return this.condition;
    }

    public final Double getCurrent_value_eur() {
        return this.current_value_eur;
    }

    public final Double getCurrent_value_eur_etched() {
        return this.current_value_eur_etched;
    }

    public final Double getCurrent_value_eur_foil() {
        return this.current_value_eur_foil;
    }

    public final Double getCurrent_value_usd() {
        return this.current_value_usd;
    }

    public final Double getCurrent_value_usd_etched() {
        return this.current_value_usd_etched;
    }

    public final Double getCurrent_value_usd_foil() {
        return this.current_value_usd_foil;
    }

    public final String getDefense() {
        return this.defense;
    }

    public final List<MTImageURIs> getEn_images() {
        return this.en_images;
    }

    public final Integer getFace() {
        return this.face;
    }

    public final Integer getFace_index() {
        return this.face_index;
    }

    public final String getFaceid() {
        return this.faceid;
    }

    public final String getFinish() {
        return this.finish;
    }

    public final List<String> getFinishes() {
        return this.finishes;
    }

    public final Integer getFlag() {
        return this.flag;
    }

    public final Boolean getGame_changer() {
        return this.game_changer;
    }

    public final String getImageUrl(int face) {
        String png;
        List<MTImageURIs> list;
        List<MTImageURIs> list2;
        List<MTImageURIs> list3 = this.images;
        MTImageURIs mTImageURIs = list3 != null ? (MTImageURIs) CollectionsKt.getOrNull(list3, face) : null;
        MTImageURIs mTImageURIs2 = (face == 0 || (list2 = this.images) == null) ? null : (MTImageURIs) CollectionsKt.firstOrNull((List) list2);
        List<MTImageURIs> list4 = this.en_images;
        MTImageURIs mTImageURIs3 = list4 != null ? (MTImageURIs) CollectionsKt.getOrNull(list4, face) : null;
        MTImageURIs mTImageURIs4 = (face == 0 || (list = this.en_images) == null) ? null : (MTImageURIs) CollectionsKt.firstOrNull((List) list);
        if (mTImageURIs != null && (png = mTImageURIs.getPng()) != null) {
            return png;
        }
        String normal = mTImageURIs != null ? mTImageURIs.getNormal() : null;
        if (normal == null) {
            normal = mTImageURIs != null ? mTImageURIs.getGatherer() : null;
            if (normal == null) {
                normal = mTImageURIs2 != null ? mTImageURIs2.getPng() : null;
                if (normal == null) {
                    normal = mTImageURIs2 != null ? mTImageURIs2.getNormal() : null;
                    if (normal == null) {
                        normal = mTImageURIs2 != null ? mTImageURIs2.getGatherer() : null;
                        if (normal == null) {
                            normal = mTImageURIs3 != null ? mTImageURIs3.getPng() : null;
                            if (normal == null) {
                                normal = mTImageURIs3 != null ? mTImageURIs3.getNormal() : null;
                                if (normal == null) {
                                    normal = mTImageURIs3 != null ? mTImageURIs3.getGatherer() : null;
                                    if (normal == null) {
                                        normal = mTImageURIs4 != null ? mTImageURIs4.getPng() : null;
                                        if (normal == null) {
                                            normal = mTImageURIs4 != null ? mTImageURIs4.getNormal() : null;
                                            if (normal == null) {
                                                String gatherer = mTImageURIs4 != null ? mTImageURIs4.getGatherer() : null;
                                                return gatherer == null ? "" : gatherer;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return normal;
    }

    public final List<MTImageURIs> getImages() {
        return this.images;
    }

    public final Boolean getIncollection() {
        return this.incollection;
    }

    public final String getLang() {
        return this.lang;
    }

    public final String getLayout() {
        return this.layout;
    }

    public final MTLegalities getLegalities() {
        return this.legalities;
    }

    public final Integer getList_card_id() {
        return this.list_card_id;
    }

    public final List<Integer> getList_card_ids() {
        return this.list_card_ids;
    }

    public final String getList_name() {
        return this.list_name;
    }

    public final MTPrivacyUser getList_owner() {
        return this.list_owner;
    }

    public final Integer getList_type() {
        return this.list_type;
    }

    public final Integer getListid() {
        return this.listid;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getLoyalty() {
        return this.loyalty;
    }

    public final String getMana_cost() {
        return this.mana_cost;
    }

    public final Boolean getMissprint() {
        return this.missprint;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOracle_text() {
        return this.oracle_text;
    }

    public final String getOracleid() {
        return this.oracleid;
    }

    public final Integer getOwner_userid() {
        return this.owner_userid;
    }

    public final String getPower() {
        return this.power;
    }

    public final String getPreviewUrl(int face) {
        String artCropUrl = getArtCropUrl(face);
        return artCropUrl.length() > 0 ? artCropUrl : getImageUrl(face);
    }

    public final String getPrinted_name() {
        return this.printed_name;
    }

    public final String getPrinted_text() {
        return this.printed_text;
    }

    public final String getPrinted_type_line() {
        return this.printed_type_line;
    }

    public final Boolean getProxy() {
        return this.proxy;
    }

    public final Map<String, Double> getPurchase() {
        return this.purchase;
    }

    public final Double getPurchase_price() {
        return this.purchase_price;
    }

    public final Integer getQuantity() {
        return this.quantity;
    }

    public final MTCardRanking getRanking() {
        return this.ranking;
    }

    public final String getRarity() {
        return this.rarity;
    }

    public final MTRecommendationData getRecommendation() {
        return this.recommendation;
    }

    public final String getReleased_at() {
        return this.released_at;
    }

    public final Boolean getReserved() {
        return this.reserved;
    }

    public final String getScryfallid() {
        return this.scryfallid;
    }

    public final String getSet_code() {
        return this.set_code;
    }

    public final String getSet_icon_svg_url() {
        return this.set_icon_svg_url;
    }

    public final String getSet_name() {
        return this.set_name;
    }

    public final Boolean getSigned() {
        return this.signed;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final String getToughness() {
        return this.toughness;
    }

    public final String getType_line() {
        return this.type_line;
    }

    public final MTCardUsedInDeck getUsed_in_deck() {
        return this.used_in_deck;
    }

    public final MTCardMarketplaceValues getValues() {
        return this.values;
    }

    public final List<Integer> getVariant_list_card_ids() {
        return this.variant_list_card_ids;
    }

    public final Integer getVariant_quantity() {
        return this.variant_quantity;
    }

    public final List<MTFullCard> getVariants() {
        return this.variants;
    }

    public int hashCode() {
        String str = this.added_at;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.altered;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.cardid;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<MTFace> list = this.card_faces;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str3 = this.cmc;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.collector_number;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<String> list2 = this.color_identity;
        int iHashCode7 = (iHashCode6 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<String> list3 = this.colors;
        int iHashCode8 = (iHashCode7 + (list3 == null ? 0 : list3.hashCode())) * 31;
        MTCardCollectionStatus mTCardCollectionStatus = this.collection;
        int iHashCode9 = (iHashCode8 + (mTCardCollectionStatus == null ? 0 : mTCardCollectionStatus.hashCode())) * 31;
        String str5 = this.condition;
        int iHashCode10 = (iHashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Double d = this.current_value_eur;
        int iHashCode11 = (iHashCode10 + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.current_value_usd;
        int iHashCode12 = (iHashCode11 + (d2 == null ? 0 : d2.hashCode())) * 31;
        Double d3 = this.current_value_eur_foil;
        int iHashCode13 = (iHashCode12 + (d3 == null ? 0 : d3.hashCode())) * 31;
        Double d4 = this.current_value_usd_foil;
        int iHashCode14 = (iHashCode13 + (d4 == null ? 0 : d4.hashCode())) * 31;
        Double d5 = this.current_value_eur_etched;
        int iHashCode15 = (iHashCode14 + (d5 == null ? 0 : d5.hashCode())) * 31;
        Double d6 = this.current_value_usd_etched;
        int iHashCode16 = (iHashCode15 + (d6 == null ? 0 : d6.hashCode())) * 31;
        MTCardMarketplaceValues mTCardMarketplaceValues = this.values;
        int iHashCode17 = (iHashCode16 + (mTCardMarketplaceValues == null ? 0 : mTCardMarketplaceValues.hashCode())) * 31;
        Integer num = this.face_index;
        int iHashCode18 = (iHashCode17 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.face;
        int iHashCode19 = (iHashCode18 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str6 = this.faceid;
        int iHashCode20 = (iHashCode19 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.finish;
        int iHashCode21 = (iHashCode20 + (str7 == null ? 0 : str7.hashCode())) * 31;
        List<String> list4 = this.finishes;
        int iHashCode22 = (iHashCode21 + (list4 == null ? 0 : list4.hashCode())) * 31;
        Integer num3 = this.flag;
        int iHashCode23 = (iHashCode22 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Boolean bool2 = this.game_changer;
        int iHashCode24 = (iHashCode23 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.reserved;
        int iHashCode25 = (iHashCode24 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str8 = this.layout;
        int iHashCode26 = (iHashCode25 + (str8 == null ? 0 : str8.hashCode())) * 31;
        List<MTImageURIs> list5 = this.images;
        int iHashCode27 = (iHashCode26 + (list5 == null ? 0 : list5.hashCode())) * 31;
        List<MTImageURIs> list6 = this.en_images;
        int iHashCode28 = (((iHashCode27 + (list6 == null ? 0 : list6.hashCode())) * 31) + this.lang.hashCode()) * 31;
        Integer num4 = this.listid;
        int iHashCode29 = (iHashCode28 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str9 = this.list_name;
        int iHashCode30 = (iHashCode29 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Integer num5 = this.list_type;
        int iHashCode31 = (iHashCode30 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.list_card_id;
        int iHashCode32 = (iHashCode31 + (num6 == null ? 0 : num6.hashCode())) * 31;
        List<Integer> list7 = this.list_card_ids;
        int iHashCode33 = (iHashCode32 + (list7 == null ? 0 : list7.hashCode())) * 31;
        String str10 = this.locale;
        int iHashCode34 = (iHashCode33 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.mana_cost;
        int iHashCode35 = (iHashCode34 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Boolean bool4 = this.missprint;
        int iHashCode36 = (iHashCode35 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        String str12 = this.name;
        int iHashCode37 = (iHashCode36 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.oracle_text;
        int iHashCode38 = (iHashCode37 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.oracleid;
        int iHashCode39 = (iHashCode38 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.power;
        int iHashCode40 = (iHashCode39 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.printed_name;
        int iHashCode41 = (iHashCode40 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.printed_text;
        int iHashCode42 = (iHashCode41 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.printed_type_line;
        int iHashCode43 = (iHashCode42 + (str18 == null ? 0 : str18.hashCode())) * 31;
        Double d7 = this.purchase_price;
        int iHashCode44 = (iHashCode43 + (d7 == null ? 0 : d7.hashCode())) * 31;
        Boolean bool5 = this.proxy;
        int iHashCode45 = (iHashCode44 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Integer num7 = this.quantity;
        int iHashCode46 = (iHashCode45 + (num7 == null ? 0 : num7.hashCode())) * 31;
        String str19 = this.rarity;
        int iHashCode47 = (iHashCode46 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.scryfallid;
        int iHashCode48 = (iHashCode47 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.set_code;
        int iHashCode49 = (iHashCode48 + (str21 == null ? 0 : str21.hashCode())) * 31;
        String str22 = this.set_icon_svg_url;
        int iHashCode50 = (iHashCode49 + (str22 == null ? 0 : str22.hashCode())) * 31;
        String str23 = this.set_name;
        int iHashCode51 = (iHashCode50 + (str23 == null ? 0 : str23.hashCode())) * 31;
        Boolean bool6 = this.signed;
        int iHashCode52 = (iHashCode51 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        String str24 = this.toughness;
        int iHashCode53 = (iHashCode52 + (str24 == null ? 0 : str24.hashCode())) * 31;
        String str25 = this.type_line;
        int iHashCode54 = (iHashCode53 + (str25 == null ? 0 : str25.hashCode())) * 31;
        String str26 = this.loyalty;
        int iHashCode55 = (iHashCode54 + (str26 == null ? 0 : str26.hashCode())) * 31;
        String str27 = this.defense;
        int iHashCode56 = (iHashCode55 + (str27 == null ? 0 : str27.hashCode())) * 31;
        MTLegalities mTLegalities = this.legalities;
        int iHashCode57 = (iHashCode56 + (mTLegalities == null ? 0 : mTLegalities.hashCode())) * 31;
        String str28 = this.released_at;
        int iHashCode58 = (iHashCode57 + (str28 == null ? 0 : str28.hashCode())) * 31;
        MTRecommendationData mTRecommendationData = this.recommendation;
        int iHashCode59 = (iHashCode58 + (mTRecommendationData == null ? 0 : mTRecommendationData.hashCode())) * 31;
        List<String> list8 = this.tags;
        int iHashCode60 = (iHashCode59 + (list8 == null ? 0 : list8.hashCode())) * 31;
        List<String> list9 = this.available_lang;
        int iHashCode61 = (iHashCode60 + (list9 == null ? 0 : list9.hashCode())) * 31;
        Integer num8 = this.variant_quantity;
        int iHashCode62 = (iHashCode61 + (num8 == null ? 0 : num8.hashCode())) * 31;
        List<MTFullCard> list10 = this.variants;
        int iHashCode63 = (iHashCode62 + (list10 == null ? 0 : list10.hashCode())) * 31;
        List<Integer> list11 = this.variant_list_card_ids;
        int iHashCode64 = (iHashCode63 + (list11 == null ? 0 : list11.hashCode())) * 31;
        Boolean bool7 = this.incollection;
        int iHashCode65 = (iHashCode64 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
        Map<String, Double> map = this.purchase;
        int iHashCode66 = (iHashCode65 + (map == null ? 0 : map.hashCode())) * 31;
        Integer num9 = this.owner_userid;
        int iHashCode67 = (iHashCode66 + (num9 == null ? 0 : num9.hashCode())) * 31;
        MTCardUsedInDeck mTCardUsedInDeck = this.used_in_deck;
        int iHashCode68 = (iHashCode67 + (mTCardUsedInDeck == null ? 0 : mTCardUsedInDeck.hashCode())) * 31;
        MTPrivacyUser mTPrivacyUser = this.list_owner;
        int iHashCode69 = (iHashCode68 + (mTPrivacyUser == null ? 0 : mTPrivacyUser.hashCode())) * 31;
        MTCardRanking mTCardRanking = this.ranking;
        return iHashCode69 + (mTCardRanking != null ? mTCardRanking.hashCode() : 0);
    }

    public final void setAdded_at(String str) {
        this.added_at = str;
    }

    public final void setAltered(Boolean bool) {
        this.altered = bool;
    }

    public final void setAvailable_lang(List<String> list) {
        this.available_lang = list;
    }

    public final void setCard_faces(List<MTFace> list) {
        this.card_faces = list;
    }

    public final void setCardid(String str) {
        this.cardid = str;
    }

    public final void setCmc(String str) {
        this.cmc = str;
    }

    public final void setCollection(MTCardCollectionStatus mTCardCollectionStatus) {
        this.collection = mTCardCollectionStatus;
    }

    public final void setCollector_number(String str) {
        this.collector_number = str;
    }

    public final void setColor_identity(List<String> list) {
        this.color_identity = list;
    }

    public final void setColors(List<String> list) {
        this.colors = list;
    }

    public final void setCondition(String str) {
        this.condition = str;
    }

    public final void setCurrent_value_eur(Double d) {
        this.current_value_eur = d;
    }

    public final void setCurrent_value_eur_etched(Double d) {
        this.current_value_eur_etched = d;
    }

    public final void setCurrent_value_eur_foil(Double d) {
        this.current_value_eur_foil = d;
    }

    public final void setCurrent_value_usd(Double d) {
        this.current_value_usd = d;
    }

    public final void setCurrent_value_usd_etched(Double d) {
        this.current_value_usd_etched = d;
    }

    public final void setCurrent_value_usd_foil(Double d) {
        this.current_value_usd_foil = d;
    }

    public final void setDefense(String str) {
        this.defense = str;
    }

    public final void setEn_images(List<MTImageURIs> list) {
        this.en_images = list;
    }

    public final void setFace(Integer num) {
        this.face = num;
    }

    public final void setFace_index(Integer num) {
        this.face_index = num;
    }

    public final void setFaceid(String str) {
        this.faceid = str;
    }

    public final void setFinish(String str) {
        this.finish = str;
    }

    public final void setFinishes(List<String> list) {
        this.finishes = list;
    }

    public final void setFlag(Integer num) {
        this.flag = num;
    }

    public final void setGame_changer(Boolean bool) {
        this.game_changer = bool;
    }

    public final void setImages(List<MTImageURIs> list) {
        this.images = list;
    }

    public final void setIncollection(Boolean bool) {
        this.incollection = bool;
    }

    public final void setLang(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lang = str;
    }

    public final void setLayout(String str) {
        this.layout = str;
    }

    public final void setLegalities(MTLegalities mTLegalities) {
        this.legalities = mTLegalities;
    }

    public final void setList_card_id(Integer num) {
        this.list_card_id = num;
    }

    public final void setList_card_ids(List<Integer> list) {
        this.list_card_ids = list;
    }

    public final void setList_name(String str) {
        this.list_name = str;
    }

    public final void setList_owner(MTPrivacyUser mTPrivacyUser) {
        this.list_owner = mTPrivacyUser;
    }

    public final void setList_type(Integer num) {
        this.list_type = num;
    }

    public final void setListid(Integer num) {
        this.listid = num;
    }

    public final void setLocale(String str) {
        this.locale = str;
    }

    public final void setLoyalty(String str) {
        this.loyalty = str;
    }

    public final void setMana_cost(String str) {
        this.mana_cost = str;
    }

    public final void setMissprint(Boolean bool) {
        this.missprint = bool;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setOracle_text(String str) {
        this.oracle_text = str;
    }

    public final void setOracleid(String str) {
        this.oracleid = str;
    }

    public final void setOwner_userid(Integer num) {
        this.owner_userid = num;
    }

    public final void setPower(String str) {
        this.power = str;
    }

    public final void setPrinted_name(String str) {
        this.printed_name = str;
    }

    public final void setPrinted_text(String str) {
        this.printed_text = str;
    }

    public final void setPrinted_type_line(String str) {
        this.printed_type_line = str;
    }

    public final void setProxy(Boolean bool) {
        this.proxy = bool;
    }

    public final void setPurchase(Map<String, Double> map) {
        this.purchase = map;
    }

    public final void setPurchase_price(Double d) {
        this.purchase_price = d;
    }

    public final void setQuantity(Integer num) {
        this.quantity = num;
    }

    public final void setRanking(MTCardRanking mTCardRanking) {
        this.ranking = mTCardRanking;
    }

    public final void setRarity(String str) {
        this.rarity = str;
    }

    public final void setRecommendation(MTRecommendationData mTRecommendationData) {
        this.recommendation = mTRecommendationData;
    }

    public final void setReleased_at(String str) {
        this.released_at = str;
    }

    public final void setReserved(Boolean bool) {
        this.reserved = bool;
    }

    public final void setScryfallid(String str) {
        this.scryfallid = str;
    }

    public final void setSet_code(String str) {
        this.set_code = str;
    }

    public final void setSet_icon_svg_url(String str) {
        this.set_icon_svg_url = str;
    }

    public final void setSet_name(String str) {
        this.set_name = str;
    }

    public final void setSigned(Boolean bool) {
        this.signed = bool;
    }

    public final void setTags(List<String> list) {
        this.tags = list;
    }

    public final void setToughness(String str) {
        this.toughness = str;
    }

    public final void setType_line(String str) {
        this.type_line = str;
    }

    public final void setUsed_in_deck(MTCardUsedInDeck mTCardUsedInDeck) {
        this.used_in_deck = mTCardUsedInDeck;
    }

    public final void setValues(MTCardMarketplaceValues mTCardMarketplaceValues) {
        this.values = mTCardMarketplaceValues;
    }

    public final void setVariant_list_card_ids(List<Integer> list) {
        this.variant_list_card_ids = list;
    }

    public final void setVariant_quantity(Integer num) {
        this.variant_quantity = num;
    }

    public final void setVariants(List<MTFullCard> list) {
        this.variants = list;
    }

    public String toString() {
        return "MTFullCard(added_at=" + this.added_at + ", altered=" + this.altered + ", cardid=" + this.cardid + ", card_faces=" + this.card_faces + ", cmc=" + this.cmc + ", collector_number=" + this.collector_number + ", color_identity=" + this.color_identity + ", colors=" + this.colors + ", collection=" + this.collection + ", condition=" + this.condition + ", current_value_eur=" + this.current_value_eur + ", current_value_usd=" + this.current_value_usd + ", current_value_eur_foil=" + this.current_value_eur_foil + ", current_value_usd_foil=" + this.current_value_usd_foil + ", current_value_eur_etched=" + this.current_value_eur_etched + ", current_value_usd_etched=" + this.current_value_usd_etched + ", values=" + this.values + ", face_index=" + this.face_index + ", face=" + this.face + ", faceid=" + this.faceid + ", finish=" + this.finish + ", finishes=" + this.finishes + ", flag=" + this.flag + ", game_changer=" + this.game_changer + ", reserved=" + this.reserved + ", layout=" + this.layout + ", images=" + this.images + ", en_images=" + this.en_images + ", lang=" + this.lang + ", listid=" + this.listid + ", list_name=" + this.list_name + ", list_type=" + this.list_type + ", list_card_id=" + this.list_card_id + ", list_card_ids=" + this.list_card_ids + ", locale=" + this.locale + ", mana_cost=" + this.mana_cost + ", missprint=" + this.missprint + ", name=" + this.name + ", oracle_text=" + this.oracle_text + ", oracleid=" + this.oracleid + ", power=" + this.power + ", printed_name=" + this.printed_name + ", printed_text=" + this.printed_text + ", printed_type_line=" + this.printed_type_line + ", purchase_price=" + this.purchase_price + ", proxy=" + this.proxy + ", quantity=" + this.quantity + ", rarity=" + this.rarity + ", scryfallid=" + this.scryfallid + ", set_code=" + this.set_code + ", set_icon_svg_url=" + this.set_icon_svg_url + ", set_name=" + this.set_name + ", signed=" + this.signed + ", toughness=" + this.toughness + ", type_line=" + this.type_line + ", loyalty=" + this.loyalty + ", defense=" + this.defense + ", legalities=" + this.legalities + ", released_at=" + this.released_at + ", recommendation=" + this.recommendation + ", tags=" + this.tags + ", available_lang=" + this.available_lang + ", variant_quantity=" + this.variant_quantity + ", variants=" + this.variants + ", variant_list_card_ids=" + this.variant_list_card_ids + ", incollection=" + this.incollection + ", purchase=" + this.purchase + ", owner_userid=" + this.owner_userid + ", used_in_deck=" + this.used_in_deck + ", list_owner=" + this.list_owner + ", ranking=" + this.ranking + ")";
    }
}
