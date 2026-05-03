package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\bj\b\u0087\b\u0018\u00002\u00020\u0001B\u0097\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\t\u0010V\u001a\u00020\u0005HÆ\u0003J\u0010\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010X\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010Z\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010h\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\bHÆ\u0003J\u009e\u0002\u0010l\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010mJ\u0013\u0010n\u001a\u00020\u00052\b\u0010o\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010p\u001a\u00020\u0003HÖ\u0001J\t\u0010q\u001a\u00020\bHÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b'\u0010\u001f\"\u0004\b(\u0010!R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b-\u0010\u001f\"\u0004\b.\u0010!R\u001c\u0010\n\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010*\"\u0004\b2\u0010,R\u001c\u0010\f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010*\"\u0004\b4\u0010,R\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010*\"\u0004\b6\u0010,R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010*\"\u0004\b<\u0010,R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010*\"\u0004\b>\u0010,R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010*\"\u0004\b@\u0010,R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010*\"\u0004\bB\u0010,R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010*\"\u0004\bD\u0010,R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010*\"\u0004\bF\u0010,R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010*\"\u0004\bH\u0010,R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\bI\u0010\u001f\"\u0004\bJ\u0010!R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\bK\u0010\u001f\"\u0004\bL\u0010!R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010*\"\u0004\bN\u0010,R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010*\"\u0004\bP\u0010,R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010*\"\u0004\bR\u0010,R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010*\"\u0004\bT\u0010,¨\u0006r"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTEditListBodyDeckSettings;", "", "id", "", "replace", "", "bracket", "commander", "", "formatid", "name", "partner", "leftplaymat", "rightplaymat", "type", "commander_card_id", "partner_card_id", "signature_spell_card_id", "partner_signature_spell_card_id", "companion_card_id", "leftplaymat_card_id", "rightplaymat_card_id", "leftplaymat_face_index", "rightplaymat_face_index", "leftplaymat_image", "leftplaymat_image_type", "rightplaymat_image", "rightplaymat_image_type", "<init>", "(Ljava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getReplace", "()Z", "setReplace", "(Z)V", "getBracket", "setBracket", "getCommander", "()Ljava/lang/String;", "setCommander", "(Ljava/lang/String;)V", "getFormatid", "setFormatid", "getName", "setName", "getPartner", "setPartner", "getLeftplaymat", "setLeftplaymat", "getRightplaymat", "setRightplaymat", "getType", "()I", "setType", "(I)V", "getCommander_card_id", "setCommander_card_id", "getPartner_card_id", "setPartner_card_id", "getSignature_spell_card_id", "setSignature_spell_card_id", "getPartner_signature_spell_card_id", "setPartner_signature_spell_card_id", "getCompanion_card_id", "setCompanion_card_id", "getLeftplaymat_card_id", "setLeftplaymat_card_id", "getRightplaymat_card_id", "setRightplaymat_card_id", "getLeftplaymat_face_index", "setLeftplaymat_face_index", "getRightplaymat_face_index", "setRightplaymat_face_index", "getLeftplaymat_image", "setLeftplaymat_image", "getLeftplaymat_image_type", "setLeftplaymat_image_type", "getRightplaymat_image", "setRightplaymat_image", "getRightplaymat_image_type", "setRightplaymat_image_type", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "copy", "(Ljava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/studiolaganne/lengendarylens/MTEditListBodyDeckSettings;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTEditListBodyDeckSettings {
    public static final int $stable = 8;
    private Integer bracket;
    private String commander;
    private String commander_card_id;
    private String companion_card_id;
    private Integer formatid;
    private Integer id;
    private String leftplaymat;
    private String leftplaymat_card_id;
    private Integer leftplaymat_face_index;
    private String leftplaymat_image;
    private String leftplaymat_image_type;
    private String name;
    private String partner;
    private String partner_card_id;
    private String partner_signature_spell_card_id;
    private boolean replace;
    private String rightplaymat;
    private String rightplaymat_card_id;
    private Integer rightplaymat_face_index;
    private String rightplaymat_image;
    private String rightplaymat_image_type;
    private String signature_spell_card_id;
    private int type;

    public MTEditListBodyDeckSettings() {
        this(null, false, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null);
    }

    public MTEditListBodyDeckSettings(Integer num, boolean z, Integer num2, String str, Integer num3, String str2, String str3, String str4, String str5, int i, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Integer num4, Integer num5, String str13, String str14, String str15, String str16) {
        this.id = num;
        this.replace = z;
        this.bracket = num2;
        this.commander = str;
        this.formatid = num3;
        this.name = str2;
        this.partner = str3;
        this.leftplaymat = str4;
        this.rightplaymat = str5;
        this.type = i;
        this.commander_card_id = str6;
        this.partner_card_id = str7;
        this.signature_spell_card_id = str8;
        this.partner_signature_spell_card_id = str9;
        this.companion_card_id = str10;
        this.leftplaymat_card_id = str11;
        this.rightplaymat_card_id = str12;
        this.leftplaymat_face_index = num4;
        this.rightplaymat_face_index = num5;
        this.leftplaymat_image = str13;
        this.leftplaymat_image_type = str14;
        this.rightplaymat_image = str15;
        this.rightplaymat_image_type = str16;
    }

    public /* synthetic */ MTEditListBodyDeckSettings(Integer num, boolean z, Integer num2, String str, Integer num3, String str2, String str3, String str4, String str5, int i, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Integer num4, Integer num5, String str13, String str14, String str15, String str16, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? null : num2, (i2 & 8) != 0 ? null : str, (i2 & 16) != 0 ? null : num3, (i2 & 32) != 0 ? null : str2, (i2 & 64) != 0 ? null : str3, (i2 & 128) != 0 ? null : str4, (i2 & 256) != 0 ? null : str5, (i2 & 512) == 0 ? i : 0, (i2 & 1024) != 0 ? null : str6, (i2 & 2048) != 0 ? null : str7, (i2 & 4096) != 0 ? null : str8, (i2 & 8192) != 0 ? null : str9, (i2 & 16384) != 0 ? null : str10, (i2 & 32768) != 0 ? null : str11, (i2 & 65536) != 0 ? null : str12, (i2 & 131072) != 0 ? null : num4, (i2 & 262144) != 0 ? null : num5, (i2 & 524288) != 0 ? null : str13, (i2 & 1048576) != 0 ? null : str14, (i2 & 2097152) != 0 ? null : str15, (i2 & 4194304) != 0 ? null : str16);
    }

    public static /* synthetic */ MTEditListBodyDeckSettings copy$default(MTEditListBodyDeckSettings mTEditListBodyDeckSettings, Integer num, boolean z, Integer num2, String str, Integer num3, String str2, String str3, String str4, String str5, int i, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Integer num4, Integer num5, String str13, String str14, String str15, String str16, int i2, Object obj) {
        String str17;
        String str18;
        Integer num6 = (i2 & 1) != 0 ? mTEditListBodyDeckSettings.id : num;
        boolean z2 = (i2 & 2) != 0 ? mTEditListBodyDeckSettings.replace : z;
        Integer num7 = (i2 & 4) != 0 ? mTEditListBodyDeckSettings.bracket : num2;
        String str19 = (i2 & 8) != 0 ? mTEditListBodyDeckSettings.commander : str;
        Integer num8 = (i2 & 16) != 0 ? mTEditListBodyDeckSettings.formatid : num3;
        String str20 = (i2 & 32) != 0 ? mTEditListBodyDeckSettings.name : str2;
        String str21 = (i2 & 64) != 0 ? mTEditListBodyDeckSettings.partner : str3;
        String str22 = (i2 & 128) != 0 ? mTEditListBodyDeckSettings.leftplaymat : str4;
        String str23 = (i2 & 256) != 0 ? mTEditListBodyDeckSettings.rightplaymat : str5;
        int i3 = (i2 & 512) != 0 ? mTEditListBodyDeckSettings.type : i;
        String str24 = (i2 & 1024) != 0 ? mTEditListBodyDeckSettings.commander_card_id : str6;
        String str25 = (i2 & 2048) != 0 ? mTEditListBodyDeckSettings.partner_card_id : str7;
        String str26 = (i2 & 4096) != 0 ? mTEditListBodyDeckSettings.signature_spell_card_id : str8;
        String str27 = (i2 & 8192) != 0 ? mTEditListBodyDeckSettings.partner_signature_spell_card_id : str9;
        Integer num9 = num6;
        String str28 = (i2 & 16384) != 0 ? mTEditListBodyDeckSettings.companion_card_id : str10;
        String str29 = (i2 & 32768) != 0 ? mTEditListBodyDeckSettings.leftplaymat_card_id : str11;
        String str30 = (i2 & 65536) != 0 ? mTEditListBodyDeckSettings.rightplaymat_card_id : str12;
        Integer num10 = (i2 & 131072) != 0 ? mTEditListBodyDeckSettings.leftplaymat_face_index : num4;
        Integer num11 = (i2 & 262144) != 0 ? mTEditListBodyDeckSettings.rightplaymat_face_index : num5;
        String str31 = (i2 & 524288) != 0 ? mTEditListBodyDeckSettings.leftplaymat_image : str13;
        String str32 = (i2 & 1048576) != 0 ? mTEditListBodyDeckSettings.leftplaymat_image_type : str14;
        String str33 = (i2 & 2097152) != 0 ? mTEditListBodyDeckSettings.rightplaymat_image : str15;
        if ((i2 & 4194304) != 0) {
            str18 = str33;
            str17 = mTEditListBodyDeckSettings.rightplaymat_image_type;
        } else {
            str17 = str16;
            str18 = str33;
        }
        return mTEditListBodyDeckSettings.copy(num9, z2, num7, str19, num8, str20, str21, str22, str23, i3, str24, str25, str26, str27, str28, str29, str30, num10, num11, str31, str32, str18, str17);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getCommander_card_id() {
        return this.commander_card_id;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getPartner_card_id() {
        return this.partner_card_id;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getSignature_spell_card_id() {
        return this.signature_spell_card_id;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getPartner_signature_spell_card_id() {
        return this.partner_signature_spell_card_id;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getCompanion_card_id() {
        return this.companion_card_id;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getLeftplaymat_card_id() {
        return this.leftplaymat_card_id;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getRightplaymat_card_id() {
        return this.rightplaymat_card_id;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final Integer getLeftplaymat_face_index() {
        return this.leftplaymat_face_index;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final Integer getRightplaymat_face_index() {
        return this.rightplaymat_face_index;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getReplace() {
        return this.replace;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getLeftplaymat_image() {
        return this.leftplaymat_image;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getLeftplaymat_image_type() {
        return this.leftplaymat_image_type;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getRightplaymat_image() {
        return this.rightplaymat_image;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getRightplaymat_image_type() {
        return this.rightplaymat_image_type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getBracket() {
        return this.bracket;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCommander() {
        return this.commander;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getFormatid() {
        return this.formatid;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getPartner() {
        return this.partner;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getLeftplaymat() {
        return this.leftplaymat;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getRightplaymat() {
        return this.rightplaymat;
    }

    public final MTEditListBodyDeckSettings copy(Integer id, boolean replace, Integer bracket, String commander, Integer formatid, String name, String partner, String leftplaymat, String rightplaymat, int type, String commander_card_id, String partner_card_id, String signature_spell_card_id, String partner_signature_spell_card_id, String companion_card_id, String leftplaymat_card_id, String rightplaymat_card_id, Integer leftplaymat_face_index, Integer rightplaymat_face_index, String leftplaymat_image, String leftplaymat_image_type, String rightplaymat_image, String rightplaymat_image_type) {
        return new MTEditListBodyDeckSettings(id, replace, bracket, commander, formatid, name, partner, leftplaymat, rightplaymat, type, commander_card_id, partner_card_id, signature_spell_card_id, partner_signature_spell_card_id, companion_card_id, leftplaymat_card_id, rightplaymat_card_id, leftplaymat_face_index, rightplaymat_face_index, leftplaymat_image, leftplaymat_image_type, rightplaymat_image, rightplaymat_image_type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTEditListBodyDeckSettings)) {
            return false;
        }
        MTEditListBodyDeckSettings mTEditListBodyDeckSettings = (MTEditListBodyDeckSettings) other;
        return Intrinsics.areEqual(this.id, mTEditListBodyDeckSettings.id) && this.replace == mTEditListBodyDeckSettings.replace && Intrinsics.areEqual(this.bracket, mTEditListBodyDeckSettings.bracket) && Intrinsics.areEqual(this.commander, mTEditListBodyDeckSettings.commander) && Intrinsics.areEqual(this.formatid, mTEditListBodyDeckSettings.formatid) && Intrinsics.areEqual(this.name, mTEditListBodyDeckSettings.name) && Intrinsics.areEqual(this.partner, mTEditListBodyDeckSettings.partner) && Intrinsics.areEqual(this.leftplaymat, mTEditListBodyDeckSettings.leftplaymat) && Intrinsics.areEqual(this.rightplaymat, mTEditListBodyDeckSettings.rightplaymat) && this.type == mTEditListBodyDeckSettings.type && Intrinsics.areEqual(this.commander_card_id, mTEditListBodyDeckSettings.commander_card_id) && Intrinsics.areEqual(this.partner_card_id, mTEditListBodyDeckSettings.partner_card_id) && Intrinsics.areEqual(this.signature_spell_card_id, mTEditListBodyDeckSettings.signature_spell_card_id) && Intrinsics.areEqual(this.partner_signature_spell_card_id, mTEditListBodyDeckSettings.partner_signature_spell_card_id) && Intrinsics.areEqual(this.companion_card_id, mTEditListBodyDeckSettings.companion_card_id) && Intrinsics.areEqual(this.leftplaymat_card_id, mTEditListBodyDeckSettings.leftplaymat_card_id) && Intrinsics.areEqual(this.rightplaymat_card_id, mTEditListBodyDeckSettings.rightplaymat_card_id) && Intrinsics.areEqual(this.leftplaymat_face_index, mTEditListBodyDeckSettings.leftplaymat_face_index) && Intrinsics.areEqual(this.rightplaymat_face_index, mTEditListBodyDeckSettings.rightplaymat_face_index) && Intrinsics.areEqual(this.leftplaymat_image, mTEditListBodyDeckSettings.leftplaymat_image) && Intrinsics.areEqual(this.leftplaymat_image_type, mTEditListBodyDeckSettings.leftplaymat_image_type) && Intrinsics.areEqual(this.rightplaymat_image, mTEditListBodyDeckSettings.rightplaymat_image) && Intrinsics.areEqual(this.rightplaymat_image_type, mTEditListBodyDeckSettings.rightplaymat_image_type);
    }

    public final Integer getBracket() {
        return this.bracket;
    }

    public final String getCommander() {
        return this.commander;
    }

    public final String getCommander_card_id() {
        return this.commander_card_id;
    }

    public final String getCompanion_card_id() {
        return this.companion_card_id;
    }

    public final Integer getFormatid() {
        return this.formatid;
    }

    public final Integer getId() {
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

    public final String getName() {
        return this.name;
    }

    public final String getPartner() {
        return this.partner;
    }

    public final String getPartner_card_id() {
        return this.partner_card_id;
    }

    public final String getPartner_signature_spell_card_id() {
        return this.partner_signature_spell_card_id;
    }

    public final boolean getReplace() {
        return this.replace;
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

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        Integer num = this.id;
        int iHashCode = (((num == null ? 0 : num.hashCode()) * 31) + Boolean.hashCode(this.replace)) * 31;
        Integer num2 = this.bracket;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.commander;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num3 = this.formatid;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str2 = this.name;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.partner;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.leftplaymat;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.rightplaymat;
        int iHashCode8 = (((iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31) + Integer.hashCode(this.type)) * 31;
        String str6 = this.commander_card_id;
        int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.partner_card_id;
        int iHashCode10 = (iHashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.signature_spell_card_id;
        int iHashCode11 = (iHashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.partner_signature_spell_card_id;
        int iHashCode12 = (iHashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.companion_card_id;
        int iHashCode13 = (iHashCode12 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.leftplaymat_card_id;
        int iHashCode14 = (iHashCode13 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.rightplaymat_card_id;
        int iHashCode15 = (iHashCode14 + (str12 == null ? 0 : str12.hashCode())) * 31;
        Integer num4 = this.leftplaymat_face_index;
        int iHashCode16 = (iHashCode15 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.rightplaymat_face_index;
        int iHashCode17 = (iHashCode16 + (num5 == null ? 0 : num5.hashCode())) * 31;
        String str13 = this.leftplaymat_image;
        int iHashCode18 = (iHashCode17 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.leftplaymat_image_type;
        int iHashCode19 = (iHashCode18 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.rightplaymat_image;
        int iHashCode20 = (iHashCode19 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.rightplaymat_image_type;
        return iHashCode20 + (str16 != null ? str16.hashCode() : 0);
    }

    public final void setBracket(Integer num) {
        this.bracket = num;
    }

    public final void setCommander(String str) {
        this.commander = str;
    }

    public final void setCommander_card_id(String str) {
        this.commander_card_id = str;
    }

    public final void setCompanion_card_id(String str) {
        this.companion_card_id = str;
    }

    public final void setFormatid(Integer num) {
        this.formatid = num;
    }

    public final void setId(Integer num) {
        this.id = num;
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
        this.name = str;
    }

    public final void setPartner(String str) {
        this.partner = str;
    }

    public final void setPartner_card_id(String str) {
        this.partner_card_id = str;
    }

    public final void setPartner_signature_spell_card_id(String str) {
        this.partner_signature_spell_card_id = str;
    }

    public final void setReplace(boolean z) {
        this.replace = z;
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

    public final void setType(int i) {
        this.type = i;
    }

    public String toString() {
        return "MTEditListBodyDeckSettings(id=" + this.id + ", replace=" + this.replace + ", bracket=" + this.bracket + ", commander=" + this.commander + ", formatid=" + this.formatid + ", name=" + this.name + ", partner=" + this.partner + ", leftplaymat=" + this.leftplaymat + ", rightplaymat=" + this.rightplaymat + ", type=" + this.type + ", commander_card_id=" + this.commander_card_id + ", partner_card_id=" + this.partner_card_id + ", signature_spell_card_id=" + this.signature_spell_card_id + ", partner_signature_spell_card_id=" + this.partner_signature_spell_card_id + ", companion_card_id=" + this.companion_card_id + ", leftplaymat_card_id=" + this.leftplaymat_card_id + ", rightplaymat_card_id=" + this.rightplaymat_card_id + ", leftplaymat_face_index=" + this.leftplaymat_face_index + ", rightplaymat_face_index=" + this.rightplaymat_face_index + ", leftplaymat_image=" + this.leftplaymat_image + ", leftplaymat_image_type=" + this.leftplaymat_image_type + ", rightplaymat_image=" + this.rightplaymat_image + ", rightplaymat_image_type=" + this.rightplaymat_image_type + ")";
    }
}
