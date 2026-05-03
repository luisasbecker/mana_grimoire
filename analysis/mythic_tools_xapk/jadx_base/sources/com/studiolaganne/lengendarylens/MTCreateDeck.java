package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b}\b\u0087\b\u0018\u00002\u00020\u0001B\u0095\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'¢\u0006\u0004\b(\u0010)J\u0010\u0010|\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010+J\t\u0010}\u001a\u00020\u0005HÆ\u0003J\t\u0010~\u001a\u00020\u0007HÆ\u0003J\t\u0010\u007f\u001a\u00020\u0005HÆ\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0007HÆ\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010+J\f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010+J\u0011\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010TJ\u0011\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010TJ\f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010TJ\u0011\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010TJ\f\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u009d\u0001\u001a\u0004\u0018\u00010'HÆ\u0003J\u009e\u0003\u0010\u009e\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'HÆ\u0001¢\u0006\u0003\u0010\u009f\u0001J\u0015\u0010 \u0001\u001a\u00020\u00032\t\u0010¡\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010¢\u0001\u001a\u00020\u0005HÖ\u0001J\n\u0010£\u0001\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00100\"\u0004\b8\u00102R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00104\"\u0004\b:\u00106R\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00104\"\u0004\b<\u00106R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00104\"\u0004\b>\u00106R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b?\u0010+\"\u0004\b@\u0010-R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00104\"\u0004\bB\u00106R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u00104\"\u0004\bD\u00106R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u00104\"\u0004\bF\u00106R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u00104\"\u0004\bH\u00106R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u00104\"\u0004\bJ\u00106R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u00104\"\u0004\bP\u00106R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\bQ\u0010+\"\u0004\bR\u0010-R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010W\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010W\u001a\u0004\bX\u0010T\"\u0004\bY\u0010VR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u00104\"\u0004\b[\u00106R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u00104\"\u0004\b]\u00106R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u00104\"\u0004\b_\u00106R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u00104\"\u0004\ba\u00106R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u00104\"\u0004\bc\u00106R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u00104\"\u0004\be\u00106R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u00104\"\u0004\bg\u00106R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u00104\"\u0004\bi\u00106R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u00104\"\u0004\bk\u00106R\u001e\u0010 \u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010W\u001a\u0004\bl\u0010T\"\u0004\bm\u0010VR\u001e\u0010!\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010W\u001a\u0004\bn\u0010T\"\u0004\bo\u0010VR\u001c\u0010\"\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u00104\"\u0004\bq\u00106R\u001c\u0010#\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u00104\"\u0004\bs\u00106R\u001c\u0010$\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u00104\"\u0004\bu\u00106R\u001c\u0010%\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u00104\"\u0004\bw\u00106R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{¨\u0006¤\u0001"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCreateDeck;", "", "auto_update", "", "formatid", "", "name", "", "type", "colors", "description", "commander", "import", "partner", "signaturespell", "partnersignaturespell", "leftplaymat", "rightplaymat", "temporary", "externalurl", "ghost", "userid", "bracket", "commander_color_override", "partner_color_override", "commander_card_id", "partner_card_id", "signature_spell_card_id", "partner_signature_spell_card_id", "companion_card_id", "leftplaymat_card_id", "rightplaymat_card_id", "leftplaymat_face_index", "rightplaymat_face_index", "leftplaymat_image", "leftplaymat_image_type", "rightplaymat_image", "rightplaymat_image_type", "privacy", "Lcom/studiolaganne/lengendarylens/MTCreateDeckPrivacy;", "<init>", "(Ljava/lang/Boolean;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTCreateDeckPrivacy;)V", "getAuto_update", "()Ljava/lang/Boolean;", "setAuto_update", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getFormatid", "()I", "setFormatid", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getType", "setType", "getColors", "setColors", "getDescription", "setDescription", "getCommander", "setCommander", "getImport", "setImport", "getPartner", "setPartner", "getSignaturespell", "setSignaturespell", "getPartnersignaturespell", "setPartnersignaturespell", "getLeftplaymat", "setLeftplaymat", "getRightplaymat", "setRightplaymat", "getTemporary", "()Z", "setTemporary", "(Z)V", "getExternalurl", "setExternalurl", "getGhost", "setGhost", "getUserid", "()Ljava/lang/Integer;", "setUserid", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getBracket", "setBracket", "getCommander_color_override", "setCommander_color_override", "getPartner_color_override", "setPartner_color_override", "getCommander_card_id", "setCommander_card_id", "getPartner_card_id", "setPartner_card_id", "getSignature_spell_card_id", "setSignature_spell_card_id", "getPartner_signature_spell_card_id", "setPartner_signature_spell_card_id", "getCompanion_card_id", "setCompanion_card_id", "getLeftplaymat_card_id", "setLeftplaymat_card_id", "getRightplaymat_card_id", "setRightplaymat_card_id", "getLeftplaymat_face_index", "setLeftplaymat_face_index", "getRightplaymat_face_index", "setRightplaymat_face_index", "getLeftplaymat_image", "setLeftplaymat_image", "getLeftplaymat_image_type", "setLeftplaymat_image_type", "getRightplaymat_image", "setRightplaymat_image", "getRightplaymat_image_type", "setRightplaymat_image_type", "getPrivacy", "()Lcom/studiolaganne/lengendarylens/MTCreateDeckPrivacy;", "setPrivacy", "(Lcom/studiolaganne/lengendarylens/MTCreateDeckPrivacy;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "copy", "(Ljava/lang/Boolean;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTCreateDeckPrivacy;)Lcom/studiolaganne/lengendarylens/MTCreateDeck;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCreateDeck {
    public static final int $stable = 8;
    private Boolean auto_update;
    private Integer bracket;
    private String colors;
    private String commander;
    private String commander_card_id;
    private String commander_color_override;
    private String companion_card_id;
    private String description;
    private String externalurl;
    private int formatid;
    private Boolean ghost;
    private Boolean import;
    private String leftplaymat;
    private String leftplaymat_card_id;
    private Integer leftplaymat_face_index;
    private String leftplaymat_image;
    private String leftplaymat_image_type;
    private String name;
    private String partner;
    private String partner_card_id;
    private String partner_color_override;
    private String partner_signature_spell_card_id;
    private String partnersignaturespell;
    private MTCreateDeckPrivacy privacy;
    private String rightplaymat;
    private String rightplaymat_card_id;
    private Integer rightplaymat_face_index;
    private String rightplaymat_image;
    private String rightplaymat_image_type;
    private String signature_spell_card_id;
    private String signaturespell;
    private boolean temporary;
    private int type;
    private Integer userid;

    public MTCreateDeck() {
        this(null, 0, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 3, null);
    }

    public MTCreateDeck(Boolean bool, int i, String name, int i2, String str, String description, String str2, Boolean bool2, String str3, String str4, String str5, String str6, String str7, boolean z, String str8, Boolean bool3, Integer num, Integer num2, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, Integer num3, Integer num4, String str18, String str19, String str20, String str21, MTCreateDeckPrivacy mTCreateDeckPrivacy) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        this.auto_update = bool;
        this.formatid = i;
        this.name = name;
        this.type = i2;
        this.colors = str;
        this.description = description;
        this.commander = str2;
        this.import = bool2;
        this.partner = str3;
        this.signaturespell = str4;
        this.partnersignaturespell = str5;
        this.leftplaymat = str6;
        this.rightplaymat = str7;
        this.temporary = z;
        this.externalurl = str8;
        this.ghost = bool3;
        this.userid = num;
        this.bracket = num2;
        this.commander_color_override = str9;
        this.partner_color_override = str10;
        this.commander_card_id = str11;
        this.partner_card_id = str12;
        this.signature_spell_card_id = str13;
        this.partner_signature_spell_card_id = str14;
        this.companion_card_id = str15;
        this.leftplaymat_card_id = str16;
        this.rightplaymat_card_id = str17;
        this.leftplaymat_face_index = num3;
        this.rightplaymat_face_index = num4;
        this.leftplaymat_image = str18;
        this.leftplaymat_image_type = str19;
        this.rightplaymat_image = str20;
        this.rightplaymat_image_type = str21;
        this.privacy = mTCreateDeckPrivacy;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ MTCreateDeck(Boolean bool, int i, String str, int i2, String str2, String str3, String str4, Boolean bool2, String str5, String str6, String str7, String str8, String str9, boolean z, String str10, Boolean bool3, Integer num, Integer num2, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, Integer num3, Integer num4, String str20, String str21, String str22, String str23, MTCreateDeckPrivacy mTCreateDeckPrivacy, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        Boolean bool4 = (i3 & 1) != 0 ? null : bool;
        int i5 = (i3 & 2) != 0 ? -1 : i;
        String str24 = (i3 & 4) != 0 ? "" : str;
        int i6 = (i3 & 8) != 0 ? 0 : i2;
        String str25 = (i3 & 16) != 0 ? "" : str2;
        String str26 = (i3 & 32) == 0 ? str3 : "";
        this(bool4, i5, str24, i6, str25, str26, (i3 & 64) != 0 ? null : str4, (i3 & 128) != 0 ? null : bool2, (i3 & 256) != 0 ? null : str5, (i3 & 512) != 0 ? null : str6, (i3 & 1024) != 0 ? null : str7, (i3 & 2048) != 0 ? null : str8, (i3 & 4096) != 0 ? null : str9, (i3 & 8192) != 0 ? false : z, (i3 & 16384) != 0 ? null : str10, (i3 & 32768) != 0 ? false : bool3, (i3 & 65536) != 0 ? null : num, (i3 & 131072) != 0 ? null : num2, (i3 & 262144) != 0 ? null : str11, (i3 & 524288) != 0 ? null : str12, (i3 & 1048576) != 0 ? null : str13, (i3 & 2097152) != 0 ? null : str14, (i3 & 4194304) != 0 ? null : str15, (i3 & 8388608) != 0 ? null : str16, (i3 & 16777216) != 0 ? null : str17, (i3 & 33554432) != 0 ? null : str18, (i3 & 67108864) != 0 ? null : str19, (i3 & 134217728) != 0 ? null : num3, (i3 & 268435456) != 0 ? null : num4, (i3 & 536870912) != 0 ? null : str20, (i3 & 1073741824) != 0 ? null : str21, (i3 & Integer.MIN_VALUE) != 0 ? null : str22, (i4 & 1) != 0 ? null : str23, (i4 & 2) != 0 ? null : mTCreateDeckPrivacy);
    }

    public static /* synthetic */ MTCreateDeck copy$default(MTCreateDeck mTCreateDeck, Boolean bool, int i, String str, int i2, String str2, String str3, String str4, Boolean bool2, String str5, String str6, String str7, String str8, String str9, boolean z, String str10, Boolean bool3, Integer num, Integer num2, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, Integer num3, Integer num4, String str20, String str21, String str22, String str23, MTCreateDeckPrivacy mTCreateDeckPrivacy, int i3, int i4, Object obj) {
        MTCreateDeckPrivacy mTCreateDeckPrivacy2;
        String str24;
        Integer num5;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        String str31;
        String str32;
        String str33;
        Integer num6;
        Integer num7;
        String str34;
        String str35;
        String str36;
        String str37;
        String str38;
        int i5;
        String str39;
        String str40;
        String str41;
        Boolean bool4;
        String str42;
        String str43;
        String str44;
        String str45;
        String str46;
        boolean z2;
        Boolean bool5;
        Integer num8;
        int i6;
        Boolean bool6 = (i3 & 1) != 0 ? mTCreateDeck.auto_update : bool;
        int i7 = (i3 & 2) != 0 ? mTCreateDeck.formatid : i;
        String str47 = (i3 & 4) != 0 ? mTCreateDeck.name : str;
        int i8 = (i3 & 8) != 0 ? mTCreateDeck.type : i2;
        String str48 = (i3 & 16) != 0 ? mTCreateDeck.colors : str2;
        String str49 = (i3 & 32) != 0 ? mTCreateDeck.description : str3;
        String str50 = (i3 & 64) != 0 ? mTCreateDeck.commander : str4;
        Boolean bool7 = (i3 & 128) != 0 ? mTCreateDeck.import : bool2;
        String str51 = (i3 & 256) != 0 ? mTCreateDeck.partner : str5;
        String str52 = (i3 & 512) != 0 ? mTCreateDeck.signaturespell : str6;
        String str53 = (i3 & 1024) != 0 ? mTCreateDeck.partnersignaturespell : str7;
        String str54 = (i3 & 2048) != 0 ? mTCreateDeck.leftplaymat : str8;
        String str55 = (i3 & 4096) != 0 ? mTCreateDeck.rightplaymat : str9;
        boolean z3 = (i3 & 8192) != 0 ? mTCreateDeck.temporary : z;
        Boolean bool8 = bool6;
        String str56 = (i3 & 16384) != 0 ? mTCreateDeck.externalurl : str10;
        Boolean bool9 = (i3 & 32768) != 0 ? mTCreateDeck.ghost : bool3;
        Integer num9 = (i3 & 65536) != 0 ? mTCreateDeck.userid : num;
        Integer num10 = (i3 & 131072) != 0 ? mTCreateDeck.bracket : num2;
        String str57 = (i3 & 262144) != 0 ? mTCreateDeck.commander_color_override : str11;
        String str58 = (i3 & 524288) != 0 ? mTCreateDeck.partner_color_override : str12;
        String str59 = (i3 & 1048576) != 0 ? mTCreateDeck.commander_card_id : str13;
        String str60 = (i3 & 2097152) != 0 ? mTCreateDeck.partner_card_id : str14;
        String str61 = (i3 & 4194304) != 0 ? mTCreateDeck.signature_spell_card_id : str15;
        String str62 = (i3 & 8388608) != 0 ? mTCreateDeck.partner_signature_spell_card_id : str16;
        String str63 = (i3 & 16777216) != 0 ? mTCreateDeck.companion_card_id : str17;
        String str64 = (i3 & 33554432) != 0 ? mTCreateDeck.leftplaymat_card_id : str18;
        String str65 = (i3 & 67108864) != 0 ? mTCreateDeck.rightplaymat_card_id : str19;
        Integer num11 = (i3 & 134217728) != 0 ? mTCreateDeck.leftplaymat_face_index : num3;
        Integer num12 = (i3 & 268435456) != 0 ? mTCreateDeck.rightplaymat_face_index : num4;
        String str66 = (i3 & 536870912) != 0 ? mTCreateDeck.leftplaymat_image : str20;
        String str67 = (i3 & 1073741824) != 0 ? mTCreateDeck.leftplaymat_image_type : str21;
        String str68 = (i3 & Integer.MIN_VALUE) != 0 ? mTCreateDeck.rightplaymat_image : str22;
        String str69 = (i4 & 1) != 0 ? mTCreateDeck.rightplaymat_image_type : str23;
        if ((i4 & 2) != 0) {
            str24 = str69;
            mTCreateDeckPrivacy2 = mTCreateDeck.privacy;
            str25 = str57;
            str26 = str58;
            str27 = str59;
            str28 = str60;
            str29 = str61;
            str30 = str62;
            str31 = str63;
            str32 = str64;
            str33 = str65;
            num6 = num11;
            num7 = num12;
            str34 = str66;
            str35 = str67;
            str36 = str68;
            str37 = str56;
            i5 = i8;
            str39 = str48;
            str40 = str49;
            str41 = str50;
            bool4 = bool7;
            str42 = str51;
            str43 = str52;
            str44 = str53;
            str45 = str54;
            str46 = str55;
            z2 = z3;
            bool5 = bool9;
            num8 = num9;
            num5 = num10;
            i6 = i7;
            str38 = str47;
        } else {
            mTCreateDeckPrivacy2 = mTCreateDeckPrivacy;
            str24 = str69;
            num5 = num10;
            str25 = str57;
            str26 = str58;
            str27 = str59;
            str28 = str60;
            str29 = str61;
            str30 = str62;
            str31 = str63;
            str32 = str64;
            str33 = str65;
            num6 = num11;
            num7 = num12;
            str34 = str66;
            str35 = str67;
            str36 = str68;
            str37 = str56;
            str38 = str47;
            i5 = i8;
            str39 = str48;
            str40 = str49;
            str41 = str50;
            bool4 = bool7;
            str42 = str51;
            str43 = str52;
            str44 = str53;
            str45 = str54;
            str46 = str55;
            z2 = z3;
            bool5 = bool9;
            num8 = num9;
            i6 = i7;
        }
        return mTCreateDeck.copy(bool8, i6, str38, i5, str39, str40, str41, bool4, str42, str43, str44, str45, str46, z2, str37, bool5, num8, num5, str25, str26, str27, str28, str29, str30, str31, str32, str33, num6, num7, str34, str35, str36, str24, mTCreateDeckPrivacy2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getAuto_update() {
        return this.auto_update;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getSignaturespell() {
        return this.signaturespell;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getPartnersignaturespell() {
        return this.partnersignaturespell;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getLeftplaymat() {
        return this.leftplaymat;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getRightplaymat() {
        return this.rightplaymat;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getTemporary() {
        return this.temporary;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getExternalurl() {
        return this.externalurl;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Boolean getGhost() {
        return this.ghost;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Integer getUserid() {
        return this.userid;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final Integer getBracket() {
        return this.bracket;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getCommander_color_override() {
        return this.commander_color_override;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getFormatid() {
        return this.formatid;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getPartner_color_override() {
        return this.partner_color_override;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getCommander_card_id() {
        return this.commander_card_id;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getPartner_card_id() {
        return this.partner_card_id;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getSignature_spell_card_id() {
        return this.signature_spell_card_id;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final String getPartner_signature_spell_card_id() {
        return this.partner_signature_spell_card_id;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final String getCompanion_card_id() {
        return this.companion_card_id;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final String getLeftplaymat_card_id() {
        return this.leftplaymat_card_id;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final String getRightplaymat_card_id() {
        return this.rightplaymat_card_id;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final Integer getLeftplaymat_face_index() {
        return this.leftplaymat_face_index;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final Integer getRightplaymat_face_index() {
        return this.rightplaymat_face_index;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final String getLeftplaymat_image() {
        return this.leftplaymat_image;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final String getLeftplaymat_image_type() {
        return this.leftplaymat_image_type;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final String getRightplaymat_image() {
        return this.rightplaymat_image;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final String getRightplaymat_image_type() {
        return this.rightplaymat_image_type;
    }

    /* JADX INFO: renamed from: component34, reason: from getter */
    public final MTCreateDeckPrivacy getPrivacy() {
        return this.privacy;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getColors() {
        return this.colors;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getCommander() {
        return this.commander;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Boolean getImport() {
        return this.import;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getPartner() {
        return this.partner;
    }

    public final MTCreateDeck copy(Boolean auto_update, int formatid, String name, int type, String colors, String description, String commander, Boolean bool, String partner, String signaturespell, String partnersignaturespell, String leftplaymat, String rightplaymat, boolean temporary, String externalurl, Boolean ghost, Integer userid, Integer bracket, String commander_color_override, String partner_color_override, String commander_card_id, String partner_card_id, String signature_spell_card_id, String partner_signature_spell_card_id, String companion_card_id, String leftplaymat_card_id, String rightplaymat_card_id, Integer leftplaymat_face_index, Integer rightplaymat_face_index, String leftplaymat_image, String leftplaymat_image_type, String rightplaymat_image, String rightplaymat_image_type, MTCreateDeckPrivacy privacy) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        return new MTCreateDeck(auto_update, formatid, name, type, colors, description, commander, bool, partner, signaturespell, partnersignaturespell, leftplaymat, rightplaymat, temporary, externalurl, ghost, userid, bracket, commander_color_override, partner_color_override, commander_card_id, partner_card_id, signature_spell_card_id, partner_signature_spell_card_id, companion_card_id, leftplaymat_card_id, rightplaymat_card_id, leftplaymat_face_index, rightplaymat_face_index, leftplaymat_image, leftplaymat_image_type, rightplaymat_image, rightplaymat_image_type, privacy);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCreateDeck)) {
            return false;
        }
        MTCreateDeck mTCreateDeck = (MTCreateDeck) other;
        return Intrinsics.areEqual(this.auto_update, mTCreateDeck.auto_update) && this.formatid == mTCreateDeck.formatid && Intrinsics.areEqual(this.name, mTCreateDeck.name) && this.type == mTCreateDeck.type && Intrinsics.areEqual(this.colors, mTCreateDeck.colors) && Intrinsics.areEqual(this.description, mTCreateDeck.description) && Intrinsics.areEqual(this.commander, mTCreateDeck.commander) && Intrinsics.areEqual(this.import, mTCreateDeck.import) && Intrinsics.areEqual(this.partner, mTCreateDeck.partner) && Intrinsics.areEqual(this.signaturespell, mTCreateDeck.signaturespell) && Intrinsics.areEqual(this.partnersignaturespell, mTCreateDeck.partnersignaturespell) && Intrinsics.areEqual(this.leftplaymat, mTCreateDeck.leftplaymat) && Intrinsics.areEqual(this.rightplaymat, mTCreateDeck.rightplaymat) && this.temporary == mTCreateDeck.temporary && Intrinsics.areEqual(this.externalurl, mTCreateDeck.externalurl) && Intrinsics.areEqual(this.ghost, mTCreateDeck.ghost) && Intrinsics.areEqual(this.userid, mTCreateDeck.userid) && Intrinsics.areEqual(this.bracket, mTCreateDeck.bracket) && Intrinsics.areEqual(this.commander_color_override, mTCreateDeck.commander_color_override) && Intrinsics.areEqual(this.partner_color_override, mTCreateDeck.partner_color_override) && Intrinsics.areEqual(this.commander_card_id, mTCreateDeck.commander_card_id) && Intrinsics.areEqual(this.partner_card_id, mTCreateDeck.partner_card_id) && Intrinsics.areEqual(this.signature_spell_card_id, mTCreateDeck.signature_spell_card_id) && Intrinsics.areEqual(this.partner_signature_spell_card_id, mTCreateDeck.partner_signature_spell_card_id) && Intrinsics.areEqual(this.companion_card_id, mTCreateDeck.companion_card_id) && Intrinsics.areEqual(this.leftplaymat_card_id, mTCreateDeck.leftplaymat_card_id) && Intrinsics.areEqual(this.rightplaymat_card_id, mTCreateDeck.rightplaymat_card_id) && Intrinsics.areEqual(this.leftplaymat_face_index, mTCreateDeck.leftplaymat_face_index) && Intrinsics.areEqual(this.rightplaymat_face_index, mTCreateDeck.rightplaymat_face_index) && Intrinsics.areEqual(this.leftplaymat_image, mTCreateDeck.leftplaymat_image) && Intrinsics.areEqual(this.leftplaymat_image_type, mTCreateDeck.leftplaymat_image_type) && Intrinsics.areEqual(this.rightplaymat_image, mTCreateDeck.rightplaymat_image) && Intrinsics.areEqual(this.rightplaymat_image_type, mTCreateDeck.rightplaymat_image_type) && Intrinsics.areEqual(this.privacy, mTCreateDeck.privacy);
    }

    public final Boolean getAuto_update() {
        return this.auto_update;
    }

    public final Integer getBracket() {
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

    public final Boolean getImport() {
        return this.import;
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

    public final String getName() {
        return this.name;
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

    public final MTCreateDeckPrivacy getPrivacy() {
        return this.privacy;
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

    public final String getSignature_spell_card_id() {
        return this.signature_spell_card_id;
    }

    public final String getSignaturespell() {
        return this.signaturespell;
    }

    public final boolean getTemporary() {
        return this.temporary;
    }

    public final int getType() {
        return this.type;
    }

    public final Integer getUserid() {
        return this.userid;
    }

    public int hashCode() {
        Boolean bool = this.auto_update;
        int iHashCode = (((((((bool == null ? 0 : bool.hashCode()) * 31) + Integer.hashCode(this.formatid)) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.type)) * 31;
        String str = this.colors;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.description.hashCode()) * 31;
        String str2 = this.commander;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool2 = this.import;
        int iHashCode4 = (iHashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str3 = this.partner;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.signaturespell;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.partnersignaturespell;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.leftplaymat;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.rightplaymat;
        int iHashCode9 = (((iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31) + Boolean.hashCode(this.temporary)) * 31;
        String str8 = this.externalurl;
        int iHashCode10 = (iHashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Boolean bool3 = this.ghost;
        int iHashCode11 = (iHashCode10 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Integer num = this.userid;
        int iHashCode12 = (iHashCode11 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.bracket;
        int iHashCode13 = (iHashCode12 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str9 = this.commander_color_override;
        int iHashCode14 = (iHashCode13 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.partner_color_override;
        int iHashCode15 = (iHashCode14 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.commander_card_id;
        int iHashCode16 = (iHashCode15 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.partner_card_id;
        int iHashCode17 = (iHashCode16 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.signature_spell_card_id;
        int iHashCode18 = (iHashCode17 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.partner_signature_spell_card_id;
        int iHashCode19 = (iHashCode18 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.companion_card_id;
        int iHashCode20 = (iHashCode19 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.leftplaymat_card_id;
        int iHashCode21 = (iHashCode20 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.rightplaymat_card_id;
        int iHashCode22 = (iHashCode21 + (str17 == null ? 0 : str17.hashCode())) * 31;
        Integer num3 = this.leftplaymat_face_index;
        int iHashCode23 = (iHashCode22 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.rightplaymat_face_index;
        int iHashCode24 = (iHashCode23 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str18 = this.leftplaymat_image;
        int iHashCode25 = (iHashCode24 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.leftplaymat_image_type;
        int iHashCode26 = (iHashCode25 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.rightplaymat_image;
        int iHashCode27 = (iHashCode26 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.rightplaymat_image_type;
        int iHashCode28 = (iHashCode27 + (str21 == null ? 0 : str21.hashCode())) * 31;
        MTCreateDeckPrivacy mTCreateDeckPrivacy = this.privacy;
        return iHashCode28 + (mTCreateDeckPrivacy != null ? mTCreateDeckPrivacy.hashCode() : 0);
    }

    public final void setAuto_update(Boolean bool) {
        this.auto_update = bool;
    }

    public final void setBracket(Integer num) {
        this.bracket = num;
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

    public final void setDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
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

    public final void setImport(Boolean bool) {
        this.import = bool;
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

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
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

    public final void setPrivacy(MTCreateDeckPrivacy mTCreateDeckPrivacy) {
        this.privacy = mTCreateDeckPrivacy;
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

    public final void setSignature_spell_card_id(String str) {
        this.signature_spell_card_id = str;
    }

    public final void setSignaturespell(String str) {
        this.signaturespell = str;
    }

    public final void setTemporary(boolean z) {
        this.temporary = z;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final void setUserid(Integer num) {
        this.userid = num;
    }

    public String toString() {
        return "MTCreateDeck(auto_update=" + this.auto_update + ", formatid=" + this.formatid + ", name=" + this.name + ", type=" + this.type + ", colors=" + this.colors + ", description=" + this.description + ", commander=" + this.commander + ", import=" + this.import + ", partner=" + this.partner + ", signaturespell=" + this.signaturespell + ", partnersignaturespell=" + this.partnersignaturespell + ", leftplaymat=" + this.leftplaymat + ", rightplaymat=" + this.rightplaymat + ", temporary=" + this.temporary + ", externalurl=" + this.externalurl + ", ghost=" + this.ghost + ", userid=" + this.userid + ", bracket=" + this.bracket + ", commander_color_override=" + this.commander_color_override + ", partner_color_override=" + this.partner_color_override + ", commander_card_id=" + this.commander_card_id + ", partner_card_id=" + this.partner_card_id + ", signature_spell_card_id=" + this.signature_spell_card_id + ", partner_signature_spell_card_id=" + this.partner_signature_spell_card_id + ", companion_card_id=" + this.companion_card_id + ", leftplaymat_card_id=" + this.leftplaymat_card_id + ", rightplaymat_card_id=" + this.rightplaymat_card_id + ", leftplaymat_face_index=" + this.leftplaymat_face_index + ", rightplaymat_face_index=" + this.rightplaymat_face_index + ", leftplaymat_image=" + this.leftplaymat_image + ", leftplaymat_image_type=" + this.leftplaymat_image_type + ", rightplaymat_image=" + this.rightplaymat_image + ", rightplaymat_image_type=" + this.rightplaymat_image_type + ", privacy=" + this.privacy + ")";
    }
}
