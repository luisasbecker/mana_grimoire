package com.studiolaganne.lengendarylens;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.window.reflection.WindowExtensionsConstants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JsonStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bd\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BÕ\u0003\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0018\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0006\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b1\u00102J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\u0011\u0010e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0010\u0010f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00109J\u0010\u0010g\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00109J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010i\u001a\u00020\u0003HÆ\u0003J\t\u0010j\u001a\u00020\u0003HÆ\u0003J\t\u0010k\u001a\u00020\u0003HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010r\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00109J\u000b\u0010s\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0010\u0010t\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010JJ\u000b\u0010u\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010v\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010JJ\u0011\u0010w\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010y\u001a\u00020\u0003HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010|\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0006HÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010$HÆ\u0003J\u000b\u0010~\u001a\u0004\u0018\u00010&HÆ\u0003J\u000b\u0010\u007f\u001a\u0004\u0018\u00010(HÆ\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010\u0084\u0001\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\u0012\u0010\u0085\u0001\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010JJ\u0011\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010JJÞ\u0003\u0010\u0088\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00182\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u00062\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0018HÆ\u0001¢\u0006\u0003\u0010\u0089\u0001J\u0007\u0010\u008a\u0001\u001a\u00020\u0007J\u0016\u0010\u008b\u0001\u001a\u00020\u00182\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001HÖ\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0007HÖ\u0001J\n\u0010\u008f\u0001\u001a\u00020\u0003HÖ\u0001J\u001b\u0010\u0090\u0001\u001a\u00030\u0091\u00012\b\u0010\u0092\u0001\u001a\u00030\u0093\u00012\u0007\u0010\u0094\u0001\u001a\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u00104R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010:\u001a\u0004\b8\u00109R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010:\u001a\u0004\b;\u00109R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u00104R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u00104R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u00104R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u00104R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u00104R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u00104R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u00104R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u00104R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u00104R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u00104R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010:\u001a\u0004\bF\u00109R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010K\u001a\u0004\bI\u0010JR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u00104R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010K\u001a\u0004\bM\u0010JR\u0019\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bN\u00107R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bO\u00104R\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bP\u00104R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0013\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bS\u00104R\u0019\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bT\u00107R\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0013\u0010%\u001a\u0004\u0018\u00010&¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0013\u0010'\u001a\u0004\u0018\u00010(¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u0013\u0010)\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b[\u00104R\u0013\u0010*\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\\\u00104R\u0013\u0010+\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b]\u00104R\u0013\u0010,\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b^\u00104R\u0019\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b_\u00107R\u0019\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b`\u00107R\u0015\u0010/\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010K\u001a\u0004\ba\u0010JR\u0015\u00100\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010K\u001a\u0004\bb\u0010J¨\u0006\u0095\u0001"}, d2 = {"Lcom/studiolaganne/lengendarylens/Card;", "Landroid/os/Parcelable;", "id", "", "oracle_id", "multiverse_ids", "", "", "cardmarket_id", "tcgplayer_id", "collector_number", "name", "set", "type_line", "mana_cost", "oracle_text", "printed_text", "printed_name", "flavor_name", "printed_type_line", "cmc", "legalities", "Lcom/studiolaganne/lengendarylens/Legalities;", "foil", "", "image_status", "nonfoil", "finishes", "lang", WindowExtensionsConstants.LAYOUT_PACKAGE, "image_uris", "Lcom/studiolaganne/lengendarylens/ImageUris;", "prints_search_uri", "card_faces", "Lcom/studiolaganne/lengendarylens/CardFace;", "prices", "Lcom/studiolaganne/lengendarylens/Prices;", "related_uris", "Lcom/studiolaganne/lengendarylens/RelatedURIs;", "purchase_uris", "Lcom/studiolaganne/lengendarylens/PurchaseURIs;", "released_at", "rarity", "set_name", "set_uri", "keywords", "color_identity", "reserved", "game_changer", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/Legalities;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/ImageUris;Ljava/lang/String;Ljava/util/List;Lcom/studiolaganne/lengendarylens/Prices;Lcom/studiolaganne/lengendarylens/RelatedURIs;Lcom/studiolaganne/lengendarylens/PurchaseURIs;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getId", "()Ljava/lang/String;", "getOracle_id", "getMultiverse_ids", "()Ljava/util/List;", "getCardmarket_id", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTcgplayer_id", "getCollector_number", "getName", "getSet", "getType_line", "getMana_cost", "getOracle_text", "getPrinted_text", "getPrinted_name", "getFlavor_name", "getPrinted_type_line", "getCmc", "getLegalities", "()Lcom/studiolaganne/lengendarylens/Legalities;", "getFoil", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getImage_status", "getNonfoil", "getFinishes", "getLang", "getLayout", "getImage_uris", "()Lcom/studiolaganne/lengendarylens/ImageUris;", "getPrints_search_uri", "getCard_faces", "getPrices", "()Lcom/studiolaganne/lengendarylens/Prices;", "getRelated_uris", "()Lcom/studiolaganne/lengendarylens/RelatedURIs;", "getPurchase_uris", "()Lcom/studiolaganne/lengendarylens/PurchaseURIs;", "getReleased_at", "getRarity", "getSet_name", "getSet_uri", "getKeywords", "getColor_identity", "getReserved", "getGame_changer", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/Legalities;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/ImageUris;Ljava/lang/String;Ljava/util/List;Lcom/studiolaganne/lengendarylens/Prices;Lcom/studiolaganne/lengendarylens/RelatedURIs;Lcom/studiolaganne/lengendarylens/PurchaseURIs;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/studiolaganne/lengendarylens/Card;", "describeContents", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class Card implements Parcelable {
    private final List<CardFace> card_faces;
    private final Integer cardmarket_id;
    private final Integer cmc;
    private final String collector_number;
    private final List<String> color_identity;
    private final List<String> finishes;
    private final String flavor_name;
    private final Boolean foil;
    private final Boolean game_changer;
    private final String id;
    private final String image_status;
    private final ImageUris image_uris;
    private final List<String> keywords;
    private final String lang;
    private final String layout;
    private final Legalities legalities;
    private final String mana_cost;
    private final List<Integer> multiverse_ids;
    private final String name;
    private final Boolean nonfoil;
    private final String oracle_id;
    private final String oracle_text;
    private final Prices prices;
    private final String printed_name;
    private final String printed_text;
    private final String printed_type_line;
    private final String prints_search_uri;
    private final PurchaseURIs purchase_uris;
    private final String rarity;
    private final RelatedURIs related_uris;
    private final String released_at;
    private final Boolean reserved;
    private final String set;
    private final String set_name;
    private final String set_uri;
    private final Integer tcgplayer_id;
    private final String type_line;
    public static final Parcelable.Creator<Card> CREATOR = new Creator();
    public static final int $stable = 8;

    /* JADX INFO: compiled from: JsonStructs.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Card> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Card createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Integer num;
            Boolean bool;
            ArrayList arrayList2;
            String str;
            Prices prices;
            PurchaseURIs purchaseURIsCreateFromParcel;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i = parcel.readInt();
                arrayList = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList.add(Integer.valueOf(parcel.readInt()));
                }
            }
            ArrayList arrayList3 = arrayList;
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer numValueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            String string7 = parcel.readString();
            String string8 = parcel.readString();
            String string9 = parcel.readString();
            String string10 = parcel.readString();
            String string11 = parcel.readString();
            String string12 = parcel.readString();
            Integer numValueOf3 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Legalities legalitiesCreateFromParcel = parcel.readInt() == 0 ? null : Legalities.CREATOR.createFromParcel(parcel);
            Boolean boolValueOf = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            String string13 = parcel.readString();
            Boolean boolValueOf2 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
            String string14 = parcel.readString();
            String string15 = parcel.readString();
            ImageUris imageUrisCreateFromParcel = parcel.readInt() == 0 ? null : ImageUris.CREATOR.createFromParcel(parcel);
            String string16 = parcel.readString();
            if (parcel.readInt() == 0) {
                num = numValueOf;
                bool = boolValueOf;
                str = string;
                arrayList2 = null;
            } else {
                num = numValueOf;
                int i3 = parcel.readInt();
                bool = boolValueOf;
                arrayList2 = new ArrayList(i3);
                str = string;
                int i4 = 0;
                while (i4 != i3) {
                    arrayList2.add(CardFace.CREATOR.createFromParcel(parcel));
                    i4++;
                    i3 = i3;
                }
            }
            ArrayList arrayList4 = arrayList2;
            Prices pricesCreateFromParcel = parcel.readInt() == 0 ? null : Prices.CREATOR.createFromParcel(parcel);
            RelatedURIs relatedURIsCreateFromParcel = parcel.readInt() == 0 ? null : RelatedURIs.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                prices = pricesCreateFromParcel;
                purchaseURIsCreateFromParcel = null;
            } else {
                prices = pricesCreateFromParcel;
                purchaseURIsCreateFromParcel = PurchaseURIs.CREATOR.createFromParcel(parcel);
            }
            return new Card(str, string2, arrayList3, num, numValueOf2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, numValueOf3, legalitiesCreateFromParcel, bool, string13, boolValueOf2, arrayListCreateStringArrayList, string14, string15, imageUrisCreateFromParcel, string16, arrayList4, prices, relatedURIsCreateFromParcel, purchaseURIsCreateFromParcel, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.createStringArrayList(), parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Card[] newArray(int i) {
            return new Card[i];
        }
    }

    public Card() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 31, null);
    }

    public Card(String id, String oracle_id, List<Integer> list, Integer num, Integer num2, String str, String name, String set, String type_line, String str2, String str3, String str4, String str5, String str6, String str7, Integer num3, Legalities legalities, Boolean bool, String str8, Boolean bool2, List<String> list2, String str9, String layout, ImageUris imageUris, String str10, List<CardFace> list3, Prices prices, RelatedURIs relatedURIs, PurchaseURIs purchaseURIs, String str11, String str12, String str13, String str14, List<String> list4, List<String> list5, Boolean bool3, Boolean bool4) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(oracle_id, "oracle_id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(set, "set");
        Intrinsics.checkNotNullParameter(type_line, "type_line");
        Intrinsics.checkNotNullParameter(layout, "layout");
        this.id = id;
        this.oracle_id = oracle_id;
        this.multiverse_ids = list;
        this.cardmarket_id = num;
        this.tcgplayer_id = num2;
        this.collector_number = str;
        this.name = name;
        this.set = set;
        this.type_line = type_line;
        this.mana_cost = str2;
        this.oracle_text = str3;
        this.printed_text = str4;
        this.printed_name = str5;
        this.flavor_name = str6;
        this.printed_type_line = str7;
        this.cmc = num3;
        this.legalities = legalities;
        this.foil = bool;
        this.image_status = str8;
        this.nonfoil = bool2;
        this.finishes = list2;
        this.lang = str9;
        this.layout = layout;
        this.image_uris = imageUris;
        this.prints_search_uri = str10;
        this.card_faces = list3;
        this.prices = prices;
        this.related_uris = relatedURIs;
        this.purchase_uris = purchaseURIs;
        this.released_at = str11;
        this.rarity = str12;
        this.set_name = str13;
        this.set_uri = str14;
        this.keywords = list4;
        this.color_identity = list5;
        this.reserved = bool3;
        this.game_changer = bool4;
    }

    public /* synthetic */ Card(String str, String str2, List list, Integer num, Integer num2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Integer num3, Legalities legalities, Boolean bool, String str13, Boolean bool2, List list2, String str14, String str15, ImageUris imageUris, String str16, List list3, Prices prices, RelatedURIs relatedURIs, PurchaseURIs purchaseURIs, String str17, String str18, String str19, String str20, List list4, List list5, Boolean bool3, Boolean bool4, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? "" : str4, (i & 128) != 0 ? "" : str5, (i & 256) == 0 ? str6 : "", (i & 512) != 0 ? null : str7, (i & 1024) != 0 ? null : str8, (i & 2048) != 0 ? null : str9, (i & 4096) != 0 ? null : str10, (i & 8192) != 0 ? null : str11, (i & 16384) != 0 ? null : str12, (i & 32768) != 0 ? null : num3, (i & 65536) != 0 ? null : legalities, (i & 131072) != 0 ? null : bool, (i & 262144) != 0 ? null : str13, (i & 524288) != 0 ? true : bool2, (i & 1048576) != 0 ? null : list2, (i & 2097152) != 0 ? null : str14, (i & 4194304) != 0 ? "normal" : str15, (i & 8388608) != 0 ? null : imageUris, (i & 16777216) != 0 ? null : str16, (i & 33554432) != 0 ? null : list3, (i & 67108864) != 0 ? null : prices, (i & 134217728) != 0 ? null : relatedURIs, (i & 268435456) != 0 ? null : purchaseURIs, (i & 536870912) != 0 ? null : str17, (i & 1073741824) != 0 ? null : str18, (i & Integer.MIN_VALUE) != 0 ? null : str19, (i2 & 1) != 0 ? null : str20, (i2 & 2) != 0 ? null : list4, (i2 & 4) != 0 ? null : list5, (i2 & 8) != 0 ? null : bool3, (i2 & 16) != 0 ? null : bool4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Card copy$default(Card card, String str, String str2, List list, Integer num, Integer num2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Integer num3, Legalities legalities, Boolean bool, String str13, Boolean bool2, List list2, String str14, String str15, ImageUris imageUris, String str16, List list3, Prices prices, RelatedURIs relatedURIs, PurchaseURIs purchaseURIs, String str17, String str18, String str19, String str20, List list4, List list5, Boolean bool3, Boolean bool4, int i, int i2, Object obj) {
        Boolean bool5;
        Boolean bool6;
        List list6;
        String str21;
        String str22;
        ImageUris imageUris2;
        String str23;
        List list7;
        Prices prices2;
        RelatedURIs relatedURIs2;
        PurchaseURIs purchaseURIs2;
        String str24;
        String str25;
        String str26;
        String str27;
        List list8;
        List list9;
        String str28;
        String str29;
        String str30;
        String str31;
        String str32;
        String str33;
        String str34;
        String str35;
        String str36;
        String str37;
        Integer num4;
        Legalities legalities2;
        Boolean bool7;
        String str38;
        Boolean bool8;
        String str39;
        List list10;
        Integer num5;
        Integer num6;
        String str40 = (i & 1) != 0 ? card.id : str;
        String str41 = (i & 2) != 0 ? card.oracle_id : str2;
        List list11 = (i & 4) != 0 ? card.multiverse_ids : list;
        Integer num7 = (i & 8) != 0 ? card.cardmarket_id : num;
        Integer num8 = (i & 16) != 0 ? card.tcgplayer_id : num2;
        String str42 = (i & 32) != 0 ? card.collector_number : str3;
        String str43 = (i & 64) != 0 ? card.name : str4;
        String str44 = (i & 128) != 0 ? card.set : str5;
        String str45 = (i & 256) != 0 ? card.type_line : str6;
        String str46 = (i & 512) != 0 ? card.mana_cost : str7;
        String str47 = (i & 1024) != 0 ? card.oracle_text : str8;
        String str48 = (i & 2048) != 0 ? card.printed_text : str9;
        String str49 = (i & 4096) != 0 ? card.printed_name : str10;
        String str50 = (i & 8192) != 0 ? card.flavor_name : str11;
        String str51 = str40;
        String str52 = (i & 16384) != 0 ? card.printed_type_line : str12;
        Integer num9 = (i & 32768) != 0 ? card.cmc : num3;
        Legalities legalities3 = (i & 65536) != 0 ? card.legalities : legalities;
        Boolean bool9 = (i & 131072) != 0 ? card.foil : bool;
        String str53 = (i & 262144) != 0 ? card.image_status : str13;
        Boolean bool10 = (i & 524288) != 0 ? card.nonfoil : bool2;
        List list12 = (i & 1048576) != 0 ? card.finishes : list2;
        String str54 = (i & 2097152) != 0 ? card.lang : str14;
        String str55 = (i & 4194304) != 0 ? card.layout : str15;
        ImageUris imageUris3 = (i & 8388608) != 0 ? card.image_uris : imageUris;
        String str56 = (i & 16777216) != 0 ? card.prints_search_uri : str16;
        List list13 = (i & 33554432) != 0 ? card.card_faces : list3;
        Prices prices3 = (i & 67108864) != 0 ? card.prices : prices;
        RelatedURIs relatedURIs3 = (i & 134217728) != 0 ? card.related_uris : relatedURIs;
        PurchaseURIs purchaseURIs3 = (i & 268435456) != 0 ? card.purchase_uris : purchaseURIs;
        String str57 = (i & 536870912) != 0 ? card.released_at : str17;
        String str58 = (i & 1073741824) != 0 ? card.rarity : str18;
        String str59 = (i & Integer.MIN_VALUE) != 0 ? card.set_name : str19;
        String str60 = (i2 & 1) != 0 ? card.set_uri : str20;
        List list14 = (i2 & 2) != 0 ? card.keywords : list4;
        List list15 = (i2 & 4) != 0 ? card.color_identity : list5;
        Boolean bool11 = (i2 & 8) != 0 ? card.reserved : bool3;
        if ((i2 & 16) != 0) {
            bool6 = bool11;
            bool5 = card.game_changer;
            str21 = str54;
            str22 = str55;
            imageUris2 = imageUris3;
            str23 = str56;
            list7 = list13;
            prices2 = prices3;
            relatedURIs2 = relatedURIs3;
            purchaseURIs2 = purchaseURIs3;
            str24 = str57;
            str25 = str58;
            str26 = str59;
            str27 = str60;
            list8 = list14;
            list9 = list15;
            str28 = str52;
            str30 = str43;
            str31 = str44;
            str32 = str45;
            str33 = str46;
            str34 = str47;
            str35 = str48;
            str36 = str49;
            str37 = str50;
            num4 = num9;
            legalities2 = legalities3;
            bool7 = bool9;
            str38 = str53;
            bool8 = bool10;
            list6 = list12;
            str39 = str41;
            list10 = list11;
            num5 = num7;
            num6 = num8;
            str29 = str42;
        } else {
            bool5 = bool4;
            bool6 = bool11;
            list6 = list12;
            str21 = str54;
            str22 = str55;
            imageUris2 = imageUris3;
            str23 = str56;
            list7 = list13;
            prices2 = prices3;
            relatedURIs2 = relatedURIs3;
            purchaseURIs2 = purchaseURIs3;
            str24 = str57;
            str25 = str58;
            str26 = str59;
            str27 = str60;
            list8 = list14;
            list9 = list15;
            str28 = str52;
            str29 = str42;
            str30 = str43;
            str31 = str44;
            str32 = str45;
            str33 = str46;
            str34 = str47;
            str35 = str48;
            str36 = str49;
            str37 = str50;
            num4 = num9;
            legalities2 = legalities3;
            bool7 = bool9;
            str38 = str53;
            bool8 = bool10;
            str39 = str41;
            list10 = list11;
            num5 = num7;
            num6 = num8;
        }
        return card.copy(str51, str39, list10, num5, num6, str29, str30, str31, str32, str33, str34, str35, str36, str37, str28, num4, legalities2, bool7, str38, bool8, list6, str21, str22, imageUris2, str23, list7, prices2, relatedURIs2, purchaseURIs2, str24, str25, str26, str27, list8, list9, bool6, bool5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getMana_cost() {
        return this.mana_cost;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getOracle_text() {
        return this.oracle_text;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getPrinted_text() {
        return this.printed_text;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getPrinted_name() {
        return this.printed_name;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getFlavor_name() {
        return this.flavor_name;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getPrinted_type_line() {
        return this.printed_type_line;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Integer getCmc() {
        return this.cmc;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Legalities getLegalities() {
        return this.legalities;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final Boolean getFoil() {
        return this.foil;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getImage_status() {
        return this.image_status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOracle_id() {
        return this.oracle_id;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final Boolean getNonfoil() {
        return this.nonfoil;
    }

    public final List<String> component21() {
        return this.finishes;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getLang() {
        return this.lang;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getLayout() {
        return this.layout;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final ImageUris getImage_uris() {
        return this.image_uris;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final String getPrints_search_uri() {
        return this.prints_search_uri;
    }

    public final List<CardFace> component26() {
        return this.card_faces;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final Prices getPrices() {
        return this.prices;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final RelatedURIs getRelated_uris() {
        return this.related_uris;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final PurchaseURIs getPurchase_uris() {
        return this.purchase_uris;
    }

    public final List<Integer> component3() {
        return this.multiverse_ids;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final String getReleased_at() {
        return this.released_at;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final String getRarity() {
        return this.rarity;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final String getSet_name() {
        return this.set_name;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final String getSet_uri() {
        return this.set_uri;
    }

    public final List<String> component34() {
        return this.keywords;
    }

    public final List<String> component35() {
        return this.color_identity;
    }

    /* JADX INFO: renamed from: component36, reason: from getter */
    public final Boolean getReserved() {
        return this.reserved;
    }

    /* JADX INFO: renamed from: component37, reason: from getter */
    public final Boolean getGame_changer() {
        return this.game_changer;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getCardmarket_id() {
        return this.cardmarket_id;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getTcgplayer_id() {
        return this.tcgplayer_id;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCollector_number() {
        return this.collector_number;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getSet() {
        return this.set;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getType_line() {
        return this.type_line;
    }

    public final Card copy(String id, String oracle_id, List<Integer> multiverse_ids, Integer cardmarket_id, Integer tcgplayer_id, String collector_number, String name, String set, String type_line, String mana_cost, String oracle_text, String printed_text, String printed_name, String flavor_name, String printed_type_line, Integer cmc, Legalities legalities, Boolean foil, String image_status, Boolean nonfoil, List<String> finishes, String lang, String layout, ImageUris image_uris, String prints_search_uri, List<CardFace> card_faces, Prices prices, RelatedURIs related_uris, PurchaseURIs purchase_uris, String released_at, String rarity, String set_name, String set_uri, List<String> keywords, List<String> color_identity, Boolean reserved, Boolean game_changer) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(oracle_id, "oracle_id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(set, "set");
        Intrinsics.checkNotNullParameter(type_line, "type_line");
        Intrinsics.checkNotNullParameter(layout, "layout");
        return new Card(id, oracle_id, multiverse_ids, cardmarket_id, tcgplayer_id, collector_number, name, set, type_line, mana_cost, oracle_text, printed_text, printed_name, flavor_name, printed_type_line, cmc, legalities, foil, image_status, nonfoil, finishes, lang, layout, image_uris, prints_search_uri, card_faces, prices, related_uris, purchase_uris, released_at, rarity, set_name, set_uri, keywords, color_identity, reserved, game_changer);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Card)) {
            return false;
        }
        Card card = (Card) other;
        return Intrinsics.areEqual(this.id, card.id) && Intrinsics.areEqual(this.oracle_id, card.oracle_id) && Intrinsics.areEqual(this.multiverse_ids, card.multiverse_ids) && Intrinsics.areEqual(this.cardmarket_id, card.cardmarket_id) && Intrinsics.areEqual(this.tcgplayer_id, card.tcgplayer_id) && Intrinsics.areEqual(this.collector_number, card.collector_number) && Intrinsics.areEqual(this.name, card.name) && Intrinsics.areEqual(this.set, card.set) && Intrinsics.areEqual(this.type_line, card.type_line) && Intrinsics.areEqual(this.mana_cost, card.mana_cost) && Intrinsics.areEqual(this.oracle_text, card.oracle_text) && Intrinsics.areEqual(this.printed_text, card.printed_text) && Intrinsics.areEqual(this.printed_name, card.printed_name) && Intrinsics.areEqual(this.flavor_name, card.flavor_name) && Intrinsics.areEqual(this.printed_type_line, card.printed_type_line) && Intrinsics.areEqual(this.cmc, card.cmc) && Intrinsics.areEqual(this.legalities, card.legalities) && Intrinsics.areEqual(this.foil, card.foil) && Intrinsics.areEqual(this.image_status, card.image_status) && Intrinsics.areEqual(this.nonfoil, card.nonfoil) && Intrinsics.areEqual(this.finishes, card.finishes) && Intrinsics.areEqual(this.lang, card.lang) && Intrinsics.areEqual(this.layout, card.layout) && Intrinsics.areEqual(this.image_uris, card.image_uris) && Intrinsics.areEqual(this.prints_search_uri, card.prints_search_uri) && Intrinsics.areEqual(this.card_faces, card.card_faces) && Intrinsics.areEqual(this.prices, card.prices) && Intrinsics.areEqual(this.related_uris, card.related_uris) && Intrinsics.areEqual(this.purchase_uris, card.purchase_uris) && Intrinsics.areEqual(this.released_at, card.released_at) && Intrinsics.areEqual(this.rarity, card.rarity) && Intrinsics.areEqual(this.set_name, card.set_name) && Intrinsics.areEqual(this.set_uri, card.set_uri) && Intrinsics.areEqual(this.keywords, card.keywords) && Intrinsics.areEqual(this.color_identity, card.color_identity) && Intrinsics.areEqual(this.reserved, card.reserved) && Intrinsics.areEqual(this.game_changer, card.game_changer);
    }

    public final List<CardFace> getCard_faces() {
        return this.card_faces;
    }

    public final Integer getCardmarket_id() {
        return this.cardmarket_id;
    }

    public final Integer getCmc() {
        return this.cmc;
    }

    public final String getCollector_number() {
        return this.collector_number;
    }

    public final List<String> getColor_identity() {
        return this.color_identity;
    }

    public final List<String> getFinishes() {
        return this.finishes;
    }

    public final String getFlavor_name() {
        return this.flavor_name;
    }

    public final Boolean getFoil() {
        return this.foil;
    }

    public final Boolean getGame_changer() {
        return this.game_changer;
    }

    public final String getId() {
        return this.id;
    }

    public final String getImage_status() {
        return this.image_status;
    }

    public final ImageUris getImage_uris() {
        return this.image_uris;
    }

    public final List<String> getKeywords() {
        return this.keywords;
    }

    public final String getLang() {
        return this.lang;
    }

    public final String getLayout() {
        return this.layout;
    }

    public final Legalities getLegalities() {
        return this.legalities;
    }

    public final String getMana_cost() {
        return this.mana_cost;
    }

    public final List<Integer> getMultiverse_ids() {
        return this.multiverse_ids;
    }

    public final String getName() {
        return this.name;
    }

    public final Boolean getNonfoil() {
        return this.nonfoil;
    }

    public final String getOracle_id() {
        return this.oracle_id;
    }

    public final String getOracle_text() {
        return this.oracle_text;
    }

    public final Prices getPrices() {
        return this.prices;
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

    public final String getPrints_search_uri() {
        return this.prints_search_uri;
    }

    public final PurchaseURIs getPurchase_uris() {
        return this.purchase_uris;
    }

    public final String getRarity() {
        return this.rarity;
    }

    public final RelatedURIs getRelated_uris() {
        return this.related_uris;
    }

    public final String getReleased_at() {
        return this.released_at;
    }

    public final Boolean getReserved() {
        return this.reserved;
    }

    public final String getSet() {
        return this.set;
    }

    public final String getSet_name() {
        return this.set_name;
    }

    public final String getSet_uri() {
        return this.set_uri;
    }

    public final Integer getTcgplayer_id() {
        return this.tcgplayer_id;
    }

    public final String getType_line() {
        return this.type_line;
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.oracle_id.hashCode()) * 31;
        List<Integer> list = this.multiverse_ids;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        Integer num = this.cardmarket_id;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.tcgplayer_id;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.collector_number;
        int iHashCode5 = (((((((iHashCode4 + (str == null ? 0 : str.hashCode())) * 31) + this.name.hashCode()) * 31) + this.set.hashCode()) * 31) + this.type_line.hashCode()) * 31;
        String str2 = this.mana_cost;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.oracle_text;
        int iHashCode7 = (iHashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.printed_text;
        int iHashCode8 = (iHashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.printed_name;
        int iHashCode9 = (iHashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.flavor_name;
        int iHashCode10 = (iHashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.printed_type_line;
        int iHashCode11 = (iHashCode10 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num3 = this.cmc;
        int iHashCode12 = (iHashCode11 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Legalities legalities = this.legalities;
        int iHashCode13 = (iHashCode12 + (legalities == null ? 0 : legalities.hashCode())) * 31;
        Boolean bool = this.foil;
        int iHashCode14 = (iHashCode13 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str8 = this.image_status;
        int iHashCode15 = (iHashCode14 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Boolean bool2 = this.nonfoil;
        int iHashCode16 = (iHashCode15 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        List<String> list2 = this.finishes;
        int iHashCode17 = (iHashCode16 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str9 = this.lang;
        int iHashCode18 = (((iHashCode17 + (str9 == null ? 0 : str9.hashCode())) * 31) + this.layout.hashCode()) * 31;
        ImageUris imageUris = this.image_uris;
        int iHashCode19 = (iHashCode18 + (imageUris == null ? 0 : imageUris.hashCode())) * 31;
        String str10 = this.prints_search_uri;
        int iHashCode20 = (iHashCode19 + (str10 == null ? 0 : str10.hashCode())) * 31;
        List<CardFace> list3 = this.card_faces;
        int iHashCode21 = (iHashCode20 + (list3 == null ? 0 : list3.hashCode())) * 31;
        Prices prices = this.prices;
        int iHashCode22 = (iHashCode21 + (prices == null ? 0 : prices.hashCode())) * 31;
        RelatedURIs relatedURIs = this.related_uris;
        int iHashCode23 = (iHashCode22 + (relatedURIs == null ? 0 : relatedURIs.hashCode())) * 31;
        PurchaseURIs purchaseURIs = this.purchase_uris;
        int iHashCode24 = (iHashCode23 + (purchaseURIs == null ? 0 : purchaseURIs.hashCode())) * 31;
        String str11 = this.released_at;
        int iHashCode25 = (iHashCode24 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.rarity;
        int iHashCode26 = (iHashCode25 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.set_name;
        int iHashCode27 = (iHashCode26 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.set_uri;
        int iHashCode28 = (iHashCode27 + (str14 == null ? 0 : str14.hashCode())) * 31;
        List<String> list4 = this.keywords;
        int iHashCode29 = (iHashCode28 + (list4 == null ? 0 : list4.hashCode())) * 31;
        List<String> list5 = this.color_identity;
        int iHashCode30 = (iHashCode29 + (list5 == null ? 0 : list5.hashCode())) * 31;
        Boolean bool3 = this.reserved;
        int iHashCode31 = (iHashCode30 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.game_changer;
        return iHashCode31 + (bool4 != null ? bool4.hashCode() : 0);
    }

    public String toString() {
        return "Card(id=" + this.id + ", oracle_id=" + this.oracle_id + ", multiverse_ids=" + this.multiverse_ids + ", cardmarket_id=" + this.cardmarket_id + ", tcgplayer_id=" + this.tcgplayer_id + ", collector_number=" + this.collector_number + ", name=" + this.name + ", set=" + this.set + ", type_line=" + this.type_line + ", mana_cost=" + this.mana_cost + ", oracle_text=" + this.oracle_text + ", printed_text=" + this.printed_text + ", printed_name=" + this.printed_name + ", flavor_name=" + this.flavor_name + ", printed_type_line=" + this.printed_type_line + ", cmc=" + this.cmc + ", legalities=" + this.legalities + ", foil=" + this.foil + ", image_status=" + this.image_status + ", nonfoil=" + this.nonfoil + ", finishes=" + this.finishes + ", lang=" + this.lang + ", layout=" + this.layout + ", image_uris=" + this.image_uris + ", prints_search_uri=" + this.prints_search_uri + ", card_faces=" + this.card_faces + ", prices=" + this.prices + ", related_uris=" + this.related_uris + ", purchase_uris=" + this.purchase_uris + ", released_at=" + this.released_at + ", rarity=" + this.rarity + ", set_name=" + this.set_name + ", set_uri=" + this.set_uri + ", keywords=" + this.keywords + ", color_identity=" + this.color_identity + ", reserved=" + this.reserved + ", game_changer=" + this.game_changer + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.id);
        dest.writeString(this.oracle_id);
        List<Integer> list = this.multiverse_ids;
        if (list == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list.size());
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                dest.writeInt(it.next().intValue());
            }
        }
        Integer num = this.cardmarket_id;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Integer num2 = this.tcgplayer_id;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        dest.writeString(this.collector_number);
        dest.writeString(this.name);
        dest.writeString(this.set);
        dest.writeString(this.type_line);
        dest.writeString(this.mana_cost);
        dest.writeString(this.oracle_text);
        dest.writeString(this.printed_text);
        dest.writeString(this.printed_name);
        dest.writeString(this.flavor_name);
        dest.writeString(this.printed_type_line);
        Integer num3 = this.cmc;
        if (num3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num3.intValue());
        }
        Legalities legalities = this.legalities;
        if (legalities == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            legalities.writeToParcel(dest, flags);
        }
        Boolean bool = this.foil;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
        dest.writeString(this.image_status);
        Boolean bool2 = this.nonfoil;
        if (bool2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        dest.writeStringList(this.finishes);
        dest.writeString(this.lang);
        dest.writeString(this.layout);
        ImageUris imageUris = this.image_uris;
        if (imageUris == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            imageUris.writeToParcel(dest, flags);
        }
        dest.writeString(this.prints_search_uri);
        List<CardFace> list2 = this.card_faces;
        if (list2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list2.size());
            Iterator<CardFace> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().writeToParcel(dest, flags);
            }
        }
        Prices prices = this.prices;
        if (prices == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            prices.writeToParcel(dest, flags);
        }
        RelatedURIs relatedURIs = this.related_uris;
        if (relatedURIs == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            relatedURIs.writeToParcel(dest, flags);
        }
        PurchaseURIs purchaseURIs = this.purchase_uris;
        if (purchaseURIs == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            purchaseURIs.writeToParcel(dest, flags);
        }
        dest.writeString(this.released_at);
        dest.writeString(this.rarity);
        dest.writeString(this.set_name);
        dest.writeString(this.set_uri);
        dest.writeStringList(this.keywords);
        dest.writeStringList(this.color_identity);
        Boolean bool3 = this.reserved;
        if (bool3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool3.booleanValue() ? 1 : 0);
        }
        Boolean bool4 = this.game_changer;
        if (bool4 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool4.booleanValue() ? 1 : 0);
        }
    }
}
