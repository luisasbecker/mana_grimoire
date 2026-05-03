package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bR\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0087\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\b\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\u000e\b\u0002\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\b\u0012\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u0002000\b\u0012\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u0002020\b\u0012\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u0002040\b¢\u0006\u0004\b5\u00106J\u0010\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00108J\u0010\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00108J\u000b\u0010h\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000f\u0010i\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010 HÆ\u0003J\u000f\u0010w\u001a\b\u0012\u0004\u0012\u00020\"0\bHÆ\u0003J\u0010\u0010x\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00108J\u0010\u0010y\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00108J\u0010\u0010z\u001a\u0004\u0018\u00010&HÆ\u0003¢\u0006\u0002\u0010ZJ\u0010\u0010{\u001a\u0004\u0018\u00010&HÆ\u0003¢\u0006\u0002\u0010ZJ\u0010\u0010|\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00108J\u0010\u0010}\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00108J\u0010\u0010~\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00108J\u000b\u0010\u007f\u001a\u0004\u0018\u00010,HÆ\u0003J\u0010\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020.0\bHÆ\u0003J\u0010\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u0002000\bHÆ\u0003J\u0010\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u0002020\bHÆ\u0003J\u0010\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u0002040\bHÆ\u0003J\u0090\u0003\u0010\u0084\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\u000e\b\u0002\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\b2\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u0002000\b2\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u0002020\b2\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u0002040\bHÆ\u0001¢\u0006\u0003\u0010\u0085\u0001J\u0016\u0010\u0086\u0001\u001a\u00030\u0087\u00012\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0003HÖ\u0001J\u000b\u0010\u008a\u0001\u001a\u00030\u008b\u0001HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b7\u00108R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b:\u00108R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\bC\u0010BR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\bD\u0010BR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\bE\u0010BR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\b¢\u0006\b\n\u0000\u001a\u0004\bV\u0010>R\u0015\u0010#\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bW\u00108R\u0015\u0010$\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bX\u00108R\u0015\u0010%\u001a\u0004\u0018\u00010&¢\u0006\n\n\u0002\u0010[\u001a\u0004\bY\u0010ZR\u0015\u0010'\u001a\u0004\u0018\u00010&¢\u0006\n\n\u0002\u0010[\u001a\u0004\b\\\u0010ZR\u0015\u0010(\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b]\u00108R\u0015\u0010)\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b^\u00108R\u0015\u0010*\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b_\u00108R\u0013\u0010+\u001a\u0004\u0018\u00010,¢\u0006\b\n\u0000\u001a\u0004\b`\u0010aR\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\b¢\u0006\b\n\u0000\u001a\u0004\bb\u0010>R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u0002000\b¢\u0006\b\n\u0000\u001a\u0004\bc\u0010>R\u0017\u00101\u001a\b\u0012\u0004\u0012\u0002020\b¢\u0006\b\n\u0000\u001a\u0004\bd\u0010>R\u0017\u00103\u001a\b\u0012\u0004\u0012\u0002040\b¢\u0006\b\n\u0000\u001a\u0004\be\u0010>¨\u0006\u008c\u0001"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardManaBaseAnalysis;", "", "landCount", "", "deckSize", "landCountCalculation", "Lcom/studiolaganne/lengendarylens/MTIdCardLandCountCalculation;", "colorAnalysis", "", "Lcom/studiolaganne/lengendarylens/MTIdCardColorAnalysisRow;", "colorFixingFlexibility", "Lcom/studiolaganne/lengendarylens/MTIdCardColorFixingFlexibility;", "commanderCastAnalysis", "Lcom/studiolaganne/lengendarylens/MTIdCardCommanderCastAnalysis;", "partnerCastAnalysis", "commanderCastFiltered", "partnerCastFiltered", "rampAnalysis", "Lcom/studiolaganne/lengendarylens/MTIdCardRampAnalysis;", "tapLandAnalysis", "Lcom/studiolaganne/lengendarylens/MTIdCardTapLandAnalysis;", "pipDensityAnalysis", "Lcom/studiolaganne/lengendarylens/MTIdCardPipDensityAnalysis;", "colorlessLandAnalysis", "Lcom/studiolaganne/lengendarylens/MTIdCardColorlessLandAnalysis;", "fetchTargetAnalysis", "Lcom/studiolaganne/lengendarylens/MTIdCardFetchTargetAnalysis;", "openingHandAnalysis", "Lcom/studiolaganne/lengendarylens/MTIdCardOpeningHandAnalysis;", "landDropAnalysis", "Lcom/studiolaganne/lengendarylens/MTIdCardLandDropAnalysis;", "healthScore", "Lcom/studiolaganne/lengendarylens/MTIdCardManaHealthScore;", "insights", "Lcom/studiolaganne/lengendarylens/MTIdCardManaInsight;", FirebaseAnalytics.Param.SCORE, "totalLands", "effectiveLandCount", "", "mdfcBonus", "recommendedLands", "cheapRampCount", "totalManaProducers", "landDropReliability", "Lcom/studiolaganne/lengendarylens/MTIdCardLandDropReliability;", "colorConsistency", "Lcom/studiolaganne/lengendarylens/MTIdCardColorConsistencyRow;", "hardToCastCards", "Lcom/studiolaganne/lengendarylens/MTIdCardHardToCastCard;", "roleBreakdown", "Lcom/studiolaganne/lengendarylens/MTIdCardRoleBreakdown;", "diagnostics", "Lcom/studiolaganne/lengendarylens/MTIdCardManaDiagnostic;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTIdCardLandCountCalculation;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTIdCardColorFixingFlexibility;Lcom/studiolaganne/lengendarylens/MTIdCardCommanderCastAnalysis;Lcom/studiolaganne/lengendarylens/MTIdCardCommanderCastAnalysis;Lcom/studiolaganne/lengendarylens/MTIdCardCommanderCastAnalysis;Lcom/studiolaganne/lengendarylens/MTIdCardCommanderCastAnalysis;Lcom/studiolaganne/lengendarylens/MTIdCardRampAnalysis;Lcom/studiolaganne/lengendarylens/MTIdCardTapLandAnalysis;Lcom/studiolaganne/lengendarylens/MTIdCardPipDensityAnalysis;Lcom/studiolaganne/lengendarylens/MTIdCardColorlessLandAnalysis;Lcom/studiolaganne/lengendarylens/MTIdCardFetchTargetAnalysis;Lcom/studiolaganne/lengendarylens/MTIdCardOpeningHandAnalysis;Lcom/studiolaganne/lengendarylens/MTIdCardLandDropAnalysis;Lcom/studiolaganne/lengendarylens/MTIdCardManaHealthScore;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTIdCardLandDropReliability;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getLandCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDeckSize", "getLandCountCalculation", "()Lcom/studiolaganne/lengendarylens/MTIdCardLandCountCalculation;", "getColorAnalysis", "()Ljava/util/List;", "getColorFixingFlexibility", "()Lcom/studiolaganne/lengendarylens/MTIdCardColorFixingFlexibility;", "getCommanderCastAnalysis", "()Lcom/studiolaganne/lengendarylens/MTIdCardCommanderCastAnalysis;", "getPartnerCastAnalysis", "getCommanderCastFiltered", "getPartnerCastFiltered", "getRampAnalysis", "()Lcom/studiolaganne/lengendarylens/MTIdCardRampAnalysis;", "getTapLandAnalysis", "()Lcom/studiolaganne/lengendarylens/MTIdCardTapLandAnalysis;", "getPipDensityAnalysis", "()Lcom/studiolaganne/lengendarylens/MTIdCardPipDensityAnalysis;", "getColorlessLandAnalysis", "()Lcom/studiolaganne/lengendarylens/MTIdCardColorlessLandAnalysis;", "getFetchTargetAnalysis", "()Lcom/studiolaganne/lengendarylens/MTIdCardFetchTargetAnalysis;", "getOpeningHandAnalysis", "()Lcom/studiolaganne/lengendarylens/MTIdCardOpeningHandAnalysis;", "getLandDropAnalysis", "()Lcom/studiolaganne/lengendarylens/MTIdCardLandDropAnalysis;", "getHealthScore", "()Lcom/studiolaganne/lengendarylens/MTIdCardManaHealthScore;", "getInsights", "getScore", "getTotalLands", "getEffectiveLandCount", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getMdfcBonus", "getRecommendedLands", "getCheapRampCount", "getTotalManaProducers", "getLandDropReliability", "()Lcom/studiolaganne/lengendarylens/MTIdCardLandDropReliability;", "getColorConsistency", "getHardToCastCards", "getRoleBreakdown", "getDiagnostics", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTIdCardLandCountCalculation;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTIdCardColorFixingFlexibility;Lcom/studiolaganne/lengendarylens/MTIdCardCommanderCastAnalysis;Lcom/studiolaganne/lengendarylens/MTIdCardCommanderCastAnalysis;Lcom/studiolaganne/lengendarylens/MTIdCardCommanderCastAnalysis;Lcom/studiolaganne/lengendarylens/MTIdCardCommanderCastAnalysis;Lcom/studiolaganne/lengendarylens/MTIdCardRampAnalysis;Lcom/studiolaganne/lengendarylens/MTIdCardTapLandAnalysis;Lcom/studiolaganne/lengendarylens/MTIdCardPipDensityAnalysis;Lcom/studiolaganne/lengendarylens/MTIdCardColorlessLandAnalysis;Lcom/studiolaganne/lengendarylens/MTIdCardFetchTargetAnalysis;Lcom/studiolaganne/lengendarylens/MTIdCardOpeningHandAnalysis;Lcom/studiolaganne/lengendarylens/MTIdCardLandDropAnalysis;Lcom/studiolaganne/lengendarylens/MTIdCardManaHealthScore;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTIdCardLandDropReliability;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/studiolaganne/lengendarylens/MTIdCardManaBaseAnalysis;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardManaBaseAnalysis {
    public static final int $stable = 8;
    private final Integer cheapRampCount;
    private final List<MTIdCardColorAnalysisRow> colorAnalysis;
    private final List<MTIdCardColorConsistencyRow> colorConsistency;
    private final MTIdCardColorFixingFlexibility colorFixingFlexibility;
    private final MTIdCardColorlessLandAnalysis colorlessLandAnalysis;
    private final MTIdCardCommanderCastAnalysis commanderCastAnalysis;
    private final MTIdCardCommanderCastAnalysis commanderCastFiltered;
    private final Integer deckSize;
    private final List<MTIdCardManaDiagnostic> diagnostics;
    private final Double effectiveLandCount;
    private final MTIdCardFetchTargetAnalysis fetchTargetAnalysis;
    private final List<MTIdCardHardToCastCard> hardToCastCards;
    private final MTIdCardManaHealthScore healthScore;
    private final List<MTIdCardManaInsight> insights;
    private final Integer landCount;
    private final MTIdCardLandCountCalculation landCountCalculation;
    private final MTIdCardLandDropAnalysis landDropAnalysis;
    private final MTIdCardLandDropReliability landDropReliability;
    private final Double mdfcBonus;
    private final MTIdCardOpeningHandAnalysis openingHandAnalysis;
    private final MTIdCardCommanderCastAnalysis partnerCastAnalysis;
    private final MTIdCardCommanderCastAnalysis partnerCastFiltered;
    private final MTIdCardPipDensityAnalysis pipDensityAnalysis;
    private final MTIdCardRampAnalysis rampAnalysis;
    private final Integer recommendedLands;
    private final List<MTIdCardRoleBreakdown> roleBreakdown;
    private final Integer score;
    private final MTIdCardTapLandAnalysis tapLandAnalysis;
    private final Integer totalLands;
    private final Integer totalManaProducers;

    public MTIdCardManaBaseAnalysis() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LockFreeTaskQueueCore.MAX_CAPACITY_MASK, null);
    }

    public MTIdCardManaBaseAnalysis(Integer num, Integer num2, MTIdCardLandCountCalculation mTIdCardLandCountCalculation, List<MTIdCardColorAnalysisRow> colorAnalysis, MTIdCardColorFixingFlexibility mTIdCardColorFixingFlexibility, MTIdCardCommanderCastAnalysis mTIdCardCommanderCastAnalysis, MTIdCardCommanderCastAnalysis mTIdCardCommanderCastAnalysis2, MTIdCardCommanderCastAnalysis mTIdCardCommanderCastAnalysis3, MTIdCardCommanderCastAnalysis mTIdCardCommanderCastAnalysis4, MTIdCardRampAnalysis mTIdCardRampAnalysis, MTIdCardTapLandAnalysis mTIdCardTapLandAnalysis, MTIdCardPipDensityAnalysis mTIdCardPipDensityAnalysis, MTIdCardColorlessLandAnalysis mTIdCardColorlessLandAnalysis, MTIdCardFetchTargetAnalysis mTIdCardFetchTargetAnalysis, MTIdCardOpeningHandAnalysis mTIdCardOpeningHandAnalysis, MTIdCardLandDropAnalysis mTIdCardLandDropAnalysis, MTIdCardManaHealthScore mTIdCardManaHealthScore, List<MTIdCardManaInsight> insights, Integer num3, Integer num4, Double d, Double d2, Integer num5, Integer num6, Integer num7, MTIdCardLandDropReliability mTIdCardLandDropReliability, List<MTIdCardColorConsistencyRow> colorConsistency, List<MTIdCardHardToCastCard> hardToCastCards, List<MTIdCardRoleBreakdown> roleBreakdown, List<MTIdCardManaDiagnostic> diagnostics) {
        Intrinsics.checkNotNullParameter(colorAnalysis, "colorAnalysis");
        Intrinsics.checkNotNullParameter(insights, "insights");
        Intrinsics.checkNotNullParameter(colorConsistency, "colorConsistency");
        Intrinsics.checkNotNullParameter(hardToCastCards, "hardToCastCards");
        Intrinsics.checkNotNullParameter(roleBreakdown, "roleBreakdown");
        Intrinsics.checkNotNullParameter(diagnostics, "diagnostics");
        this.landCount = num;
        this.deckSize = num2;
        this.landCountCalculation = mTIdCardLandCountCalculation;
        this.colorAnalysis = colorAnalysis;
        this.colorFixingFlexibility = mTIdCardColorFixingFlexibility;
        this.commanderCastAnalysis = mTIdCardCommanderCastAnalysis;
        this.partnerCastAnalysis = mTIdCardCommanderCastAnalysis2;
        this.commanderCastFiltered = mTIdCardCommanderCastAnalysis3;
        this.partnerCastFiltered = mTIdCardCommanderCastAnalysis4;
        this.rampAnalysis = mTIdCardRampAnalysis;
        this.tapLandAnalysis = mTIdCardTapLandAnalysis;
        this.pipDensityAnalysis = mTIdCardPipDensityAnalysis;
        this.colorlessLandAnalysis = mTIdCardColorlessLandAnalysis;
        this.fetchTargetAnalysis = mTIdCardFetchTargetAnalysis;
        this.openingHandAnalysis = mTIdCardOpeningHandAnalysis;
        this.landDropAnalysis = mTIdCardLandDropAnalysis;
        this.healthScore = mTIdCardManaHealthScore;
        this.insights = insights;
        this.score = num3;
        this.totalLands = num4;
        this.effectiveLandCount = d;
        this.mdfcBonus = d2;
        this.recommendedLands = num5;
        this.cheapRampCount = num6;
        this.totalManaProducers = num7;
        this.landDropReliability = mTIdCardLandDropReliability;
        this.colorConsistency = colorConsistency;
        this.hardToCastCards = hardToCastCards;
        this.roleBreakdown = roleBreakdown;
        this.diagnostics = diagnostics;
    }

    public /* synthetic */ MTIdCardManaBaseAnalysis(Integer num, Integer num2, MTIdCardLandCountCalculation mTIdCardLandCountCalculation, List list, MTIdCardColorFixingFlexibility mTIdCardColorFixingFlexibility, MTIdCardCommanderCastAnalysis mTIdCardCommanderCastAnalysis, MTIdCardCommanderCastAnalysis mTIdCardCommanderCastAnalysis2, MTIdCardCommanderCastAnalysis mTIdCardCommanderCastAnalysis3, MTIdCardCommanderCastAnalysis mTIdCardCommanderCastAnalysis4, MTIdCardRampAnalysis mTIdCardRampAnalysis, MTIdCardTapLandAnalysis mTIdCardTapLandAnalysis, MTIdCardPipDensityAnalysis mTIdCardPipDensityAnalysis, MTIdCardColorlessLandAnalysis mTIdCardColorlessLandAnalysis, MTIdCardFetchTargetAnalysis mTIdCardFetchTargetAnalysis, MTIdCardOpeningHandAnalysis mTIdCardOpeningHandAnalysis, MTIdCardLandDropAnalysis mTIdCardLandDropAnalysis, MTIdCardManaHealthScore mTIdCardManaHealthScore, List list2, Integer num3, Integer num4, Double d, Double d2, Integer num5, Integer num6, Integer num7, MTIdCardLandDropReliability mTIdCardLandDropReliability, List list3, List list4, List list5, List list6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : mTIdCardLandCountCalculation, (i & 8) != 0 ? CollectionsKt.emptyList() : list, (i & 16) != 0 ? null : mTIdCardColorFixingFlexibility, (i & 32) != 0 ? null : mTIdCardCommanderCastAnalysis, (i & 64) != 0 ? null : mTIdCardCommanderCastAnalysis2, (i & 128) != 0 ? null : mTIdCardCommanderCastAnalysis3, (i & 256) != 0 ? null : mTIdCardCommanderCastAnalysis4, (i & 512) != 0 ? null : mTIdCardRampAnalysis, (i & 1024) != 0 ? null : mTIdCardTapLandAnalysis, (i & 2048) != 0 ? null : mTIdCardPipDensityAnalysis, (i & 4096) != 0 ? null : mTIdCardColorlessLandAnalysis, (i & 8192) != 0 ? null : mTIdCardFetchTargetAnalysis, (i & 16384) != 0 ? null : mTIdCardOpeningHandAnalysis, (i & 32768) != 0 ? null : mTIdCardLandDropAnalysis, (i & 65536) != 0 ? null : mTIdCardManaHealthScore, (i & 131072) != 0 ? CollectionsKt.emptyList() : list2, (i & 262144) != 0 ? null : num3, (i & 524288) != 0 ? null : num4, (i & 1048576) != 0 ? null : d, (i & 2097152) != 0 ? null : d2, (i & 4194304) != 0 ? null : num5, (i & 8388608) != 0 ? null : num6, (i & 16777216) != 0 ? null : num7, (i & 33554432) != 0 ? null : mTIdCardLandDropReliability, (i & 67108864) != 0 ? CollectionsKt.emptyList() : list3, (i & 134217728) != 0 ? CollectionsKt.emptyList() : list4, (i & 268435456) != 0 ? CollectionsKt.emptyList() : list5, (i & 536870912) != 0 ? CollectionsKt.emptyList() : list6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardManaBaseAnalysis copy$default(MTIdCardManaBaseAnalysis mTIdCardManaBaseAnalysis, Integer num, Integer num2, MTIdCardLandCountCalculation mTIdCardLandCountCalculation, List list, MTIdCardColorFixingFlexibility mTIdCardColorFixingFlexibility, MTIdCardCommanderCastAnalysis mTIdCardCommanderCastAnalysis, MTIdCardCommanderCastAnalysis mTIdCardCommanderCastAnalysis2, MTIdCardCommanderCastAnalysis mTIdCardCommanderCastAnalysis3, MTIdCardCommanderCastAnalysis mTIdCardCommanderCastAnalysis4, MTIdCardRampAnalysis mTIdCardRampAnalysis, MTIdCardTapLandAnalysis mTIdCardTapLandAnalysis, MTIdCardPipDensityAnalysis mTIdCardPipDensityAnalysis, MTIdCardColorlessLandAnalysis mTIdCardColorlessLandAnalysis, MTIdCardFetchTargetAnalysis mTIdCardFetchTargetAnalysis, MTIdCardOpeningHandAnalysis mTIdCardOpeningHandAnalysis, MTIdCardLandDropAnalysis mTIdCardLandDropAnalysis, MTIdCardManaHealthScore mTIdCardManaHealthScore, List list2, Integer num3, Integer num4, Double d, Double d2, Integer num5, Integer num6, Integer num7, MTIdCardLandDropReliability mTIdCardLandDropReliability, List list3, List list4, List list5, List list6, int i, Object obj) {
        List list7;
        List list8;
        Integer num8 = (i & 1) != 0 ? mTIdCardManaBaseAnalysis.landCount : num;
        Integer num9 = (i & 2) != 0 ? mTIdCardManaBaseAnalysis.deckSize : num2;
        MTIdCardLandCountCalculation mTIdCardLandCountCalculation2 = (i & 4) != 0 ? mTIdCardManaBaseAnalysis.landCountCalculation : mTIdCardLandCountCalculation;
        List list9 = (i & 8) != 0 ? mTIdCardManaBaseAnalysis.colorAnalysis : list;
        MTIdCardColorFixingFlexibility mTIdCardColorFixingFlexibility2 = (i & 16) != 0 ? mTIdCardManaBaseAnalysis.colorFixingFlexibility : mTIdCardColorFixingFlexibility;
        MTIdCardCommanderCastAnalysis mTIdCardCommanderCastAnalysis5 = (i & 32) != 0 ? mTIdCardManaBaseAnalysis.commanderCastAnalysis : mTIdCardCommanderCastAnalysis;
        MTIdCardCommanderCastAnalysis mTIdCardCommanderCastAnalysis6 = (i & 64) != 0 ? mTIdCardManaBaseAnalysis.partnerCastAnalysis : mTIdCardCommanderCastAnalysis2;
        MTIdCardCommanderCastAnalysis mTIdCardCommanderCastAnalysis7 = (i & 128) != 0 ? mTIdCardManaBaseAnalysis.commanderCastFiltered : mTIdCardCommanderCastAnalysis3;
        MTIdCardCommanderCastAnalysis mTIdCardCommanderCastAnalysis8 = (i & 256) != 0 ? mTIdCardManaBaseAnalysis.partnerCastFiltered : mTIdCardCommanderCastAnalysis4;
        MTIdCardRampAnalysis mTIdCardRampAnalysis2 = (i & 512) != 0 ? mTIdCardManaBaseAnalysis.rampAnalysis : mTIdCardRampAnalysis;
        MTIdCardTapLandAnalysis mTIdCardTapLandAnalysis2 = (i & 1024) != 0 ? mTIdCardManaBaseAnalysis.tapLandAnalysis : mTIdCardTapLandAnalysis;
        MTIdCardPipDensityAnalysis mTIdCardPipDensityAnalysis2 = (i & 2048) != 0 ? mTIdCardManaBaseAnalysis.pipDensityAnalysis : mTIdCardPipDensityAnalysis;
        MTIdCardColorlessLandAnalysis mTIdCardColorlessLandAnalysis2 = (i & 4096) != 0 ? mTIdCardManaBaseAnalysis.colorlessLandAnalysis : mTIdCardColorlessLandAnalysis;
        MTIdCardFetchTargetAnalysis mTIdCardFetchTargetAnalysis2 = (i & 8192) != 0 ? mTIdCardManaBaseAnalysis.fetchTargetAnalysis : mTIdCardFetchTargetAnalysis;
        Integer num10 = num8;
        MTIdCardOpeningHandAnalysis mTIdCardOpeningHandAnalysis2 = (i & 16384) != 0 ? mTIdCardManaBaseAnalysis.openingHandAnalysis : mTIdCardOpeningHandAnalysis;
        MTIdCardLandDropAnalysis mTIdCardLandDropAnalysis2 = (i & 32768) != 0 ? mTIdCardManaBaseAnalysis.landDropAnalysis : mTIdCardLandDropAnalysis;
        MTIdCardManaHealthScore mTIdCardManaHealthScore2 = (i & 65536) != 0 ? mTIdCardManaBaseAnalysis.healthScore : mTIdCardManaHealthScore;
        List list10 = (i & 131072) != 0 ? mTIdCardManaBaseAnalysis.insights : list2;
        Integer num11 = (i & 262144) != 0 ? mTIdCardManaBaseAnalysis.score : num3;
        Integer num12 = (i & 524288) != 0 ? mTIdCardManaBaseAnalysis.totalLands : num4;
        Double d3 = (i & 1048576) != 0 ? mTIdCardManaBaseAnalysis.effectiveLandCount : d;
        Double d4 = (i & 2097152) != 0 ? mTIdCardManaBaseAnalysis.mdfcBonus : d2;
        Integer num13 = (i & 4194304) != 0 ? mTIdCardManaBaseAnalysis.recommendedLands : num5;
        Integer num14 = (i & 8388608) != 0 ? mTIdCardManaBaseAnalysis.cheapRampCount : num6;
        Integer num15 = (i & 16777216) != 0 ? mTIdCardManaBaseAnalysis.totalManaProducers : num7;
        MTIdCardLandDropReliability mTIdCardLandDropReliability2 = (i & 33554432) != 0 ? mTIdCardManaBaseAnalysis.landDropReliability : mTIdCardLandDropReliability;
        List list11 = (i & 67108864) != 0 ? mTIdCardManaBaseAnalysis.colorConsistency : list3;
        List list12 = (i & 134217728) != 0 ? mTIdCardManaBaseAnalysis.hardToCastCards : list4;
        List list13 = (i & 268435456) != 0 ? mTIdCardManaBaseAnalysis.roleBreakdown : list5;
        if ((i & 536870912) != 0) {
            list8 = list13;
            list7 = mTIdCardManaBaseAnalysis.diagnostics;
        } else {
            list7 = list6;
            list8 = list13;
        }
        return mTIdCardManaBaseAnalysis.copy(num10, num9, mTIdCardLandCountCalculation2, list9, mTIdCardColorFixingFlexibility2, mTIdCardCommanderCastAnalysis5, mTIdCardCommanderCastAnalysis6, mTIdCardCommanderCastAnalysis7, mTIdCardCommanderCastAnalysis8, mTIdCardRampAnalysis2, mTIdCardTapLandAnalysis2, mTIdCardPipDensityAnalysis2, mTIdCardColorlessLandAnalysis2, mTIdCardFetchTargetAnalysis2, mTIdCardOpeningHandAnalysis2, mTIdCardLandDropAnalysis2, mTIdCardManaHealthScore2, list10, num11, num12, d3, d4, num13, num14, num15, mTIdCardLandDropReliability2, list11, list12, list8, list7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getLandCount() {
        return this.landCount;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final MTIdCardRampAnalysis getRampAnalysis() {
        return this.rampAnalysis;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final MTIdCardTapLandAnalysis getTapLandAnalysis() {
        return this.tapLandAnalysis;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final MTIdCardPipDensityAnalysis getPipDensityAnalysis() {
        return this.pipDensityAnalysis;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final MTIdCardColorlessLandAnalysis getColorlessLandAnalysis() {
        return this.colorlessLandAnalysis;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final MTIdCardFetchTargetAnalysis getFetchTargetAnalysis() {
        return this.fetchTargetAnalysis;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final MTIdCardOpeningHandAnalysis getOpeningHandAnalysis() {
        return this.openingHandAnalysis;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final MTIdCardLandDropAnalysis getLandDropAnalysis() {
        return this.landDropAnalysis;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final MTIdCardManaHealthScore getHealthScore() {
        return this.healthScore;
    }

    public final List<MTIdCardManaInsight> component18() {
        return this.insights;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final Integer getScore() {
        return this.score;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getDeckSize() {
        return this.deckSize;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final Integer getTotalLands() {
        return this.totalLands;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final Double getEffectiveLandCount() {
        return this.effectiveLandCount;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final Double getMdfcBonus() {
        return this.mdfcBonus;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final Integer getRecommendedLands() {
        return this.recommendedLands;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final Integer getCheapRampCount() {
        return this.cheapRampCount;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final Integer getTotalManaProducers() {
        return this.totalManaProducers;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final MTIdCardLandDropReliability getLandDropReliability() {
        return this.landDropReliability;
    }

    public final List<MTIdCardColorConsistencyRow> component27() {
        return this.colorConsistency;
    }

    public final List<MTIdCardHardToCastCard> component28() {
        return this.hardToCastCards;
    }

    public final List<MTIdCardRoleBreakdown> component29() {
        return this.roleBreakdown;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTIdCardLandCountCalculation getLandCountCalculation() {
        return this.landCountCalculation;
    }

    public final List<MTIdCardManaDiagnostic> component30() {
        return this.diagnostics;
    }

    public final List<MTIdCardColorAnalysisRow> component4() {
        return this.colorAnalysis;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final MTIdCardColorFixingFlexibility getColorFixingFlexibility() {
        return this.colorFixingFlexibility;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final MTIdCardCommanderCastAnalysis getCommanderCastAnalysis() {
        return this.commanderCastAnalysis;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final MTIdCardCommanderCastAnalysis getPartnerCastAnalysis() {
        return this.partnerCastAnalysis;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final MTIdCardCommanderCastAnalysis getCommanderCastFiltered() {
        return this.commanderCastFiltered;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final MTIdCardCommanderCastAnalysis getPartnerCastFiltered() {
        return this.partnerCastFiltered;
    }

    public final MTIdCardManaBaseAnalysis copy(Integer landCount, Integer deckSize, MTIdCardLandCountCalculation landCountCalculation, List<MTIdCardColorAnalysisRow> colorAnalysis, MTIdCardColorFixingFlexibility colorFixingFlexibility, MTIdCardCommanderCastAnalysis commanderCastAnalysis, MTIdCardCommanderCastAnalysis partnerCastAnalysis, MTIdCardCommanderCastAnalysis commanderCastFiltered, MTIdCardCommanderCastAnalysis partnerCastFiltered, MTIdCardRampAnalysis rampAnalysis, MTIdCardTapLandAnalysis tapLandAnalysis, MTIdCardPipDensityAnalysis pipDensityAnalysis, MTIdCardColorlessLandAnalysis colorlessLandAnalysis, MTIdCardFetchTargetAnalysis fetchTargetAnalysis, MTIdCardOpeningHandAnalysis openingHandAnalysis, MTIdCardLandDropAnalysis landDropAnalysis, MTIdCardManaHealthScore healthScore, List<MTIdCardManaInsight> insights, Integer score, Integer totalLands, Double effectiveLandCount, Double mdfcBonus, Integer recommendedLands, Integer cheapRampCount, Integer totalManaProducers, MTIdCardLandDropReliability landDropReliability, List<MTIdCardColorConsistencyRow> colorConsistency, List<MTIdCardHardToCastCard> hardToCastCards, List<MTIdCardRoleBreakdown> roleBreakdown, List<MTIdCardManaDiagnostic> diagnostics) {
        Intrinsics.checkNotNullParameter(colorAnalysis, "colorAnalysis");
        Intrinsics.checkNotNullParameter(insights, "insights");
        Intrinsics.checkNotNullParameter(colorConsistency, "colorConsistency");
        Intrinsics.checkNotNullParameter(hardToCastCards, "hardToCastCards");
        Intrinsics.checkNotNullParameter(roleBreakdown, "roleBreakdown");
        Intrinsics.checkNotNullParameter(diagnostics, "diagnostics");
        return new MTIdCardManaBaseAnalysis(landCount, deckSize, landCountCalculation, colorAnalysis, colorFixingFlexibility, commanderCastAnalysis, partnerCastAnalysis, commanderCastFiltered, partnerCastFiltered, rampAnalysis, tapLandAnalysis, pipDensityAnalysis, colorlessLandAnalysis, fetchTargetAnalysis, openingHandAnalysis, landDropAnalysis, healthScore, insights, score, totalLands, effectiveLandCount, mdfcBonus, recommendedLands, cheapRampCount, totalManaProducers, landDropReliability, colorConsistency, hardToCastCards, roleBreakdown, diagnostics);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardManaBaseAnalysis)) {
            return false;
        }
        MTIdCardManaBaseAnalysis mTIdCardManaBaseAnalysis = (MTIdCardManaBaseAnalysis) other;
        return Intrinsics.areEqual(this.landCount, mTIdCardManaBaseAnalysis.landCount) && Intrinsics.areEqual(this.deckSize, mTIdCardManaBaseAnalysis.deckSize) && Intrinsics.areEqual(this.landCountCalculation, mTIdCardManaBaseAnalysis.landCountCalculation) && Intrinsics.areEqual(this.colorAnalysis, mTIdCardManaBaseAnalysis.colorAnalysis) && Intrinsics.areEqual(this.colorFixingFlexibility, mTIdCardManaBaseAnalysis.colorFixingFlexibility) && Intrinsics.areEqual(this.commanderCastAnalysis, mTIdCardManaBaseAnalysis.commanderCastAnalysis) && Intrinsics.areEqual(this.partnerCastAnalysis, mTIdCardManaBaseAnalysis.partnerCastAnalysis) && Intrinsics.areEqual(this.commanderCastFiltered, mTIdCardManaBaseAnalysis.commanderCastFiltered) && Intrinsics.areEqual(this.partnerCastFiltered, mTIdCardManaBaseAnalysis.partnerCastFiltered) && Intrinsics.areEqual(this.rampAnalysis, mTIdCardManaBaseAnalysis.rampAnalysis) && Intrinsics.areEqual(this.tapLandAnalysis, mTIdCardManaBaseAnalysis.tapLandAnalysis) && Intrinsics.areEqual(this.pipDensityAnalysis, mTIdCardManaBaseAnalysis.pipDensityAnalysis) && Intrinsics.areEqual(this.colorlessLandAnalysis, mTIdCardManaBaseAnalysis.colorlessLandAnalysis) && Intrinsics.areEqual(this.fetchTargetAnalysis, mTIdCardManaBaseAnalysis.fetchTargetAnalysis) && Intrinsics.areEqual(this.openingHandAnalysis, mTIdCardManaBaseAnalysis.openingHandAnalysis) && Intrinsics.areEqual(this.landDropAnalysis, mTIdCardManaBaseAnalysis.landDropAnalysis) && Intrinsics.areEqual(this.healthScore, mTIdCardManaBaseAnalysis.healthScore) && Intrinsics.areEqual(this.insights, mTIdCardManaBaseAnalysis.insights) && Intrinsics.areEqual(this.score, mTIdCardManaBaseAnalysis.score) && Intrinsics.areEqual(this.totalLands, mTIdCardManaBaseAnalysis.totalLands) && Intrinsics.areEqual((Object) this.effectiveLandCount, (Object) mTIdCardManaBaseAnalysis.effectiveLandCount) && Intrinsics.areEqual((Object) this.mdfcBonus, (Object) mTIdCardManaBaseAnalysis.mdfcBonus) && Intrinsics.areEqual(this.recommendedLands, mTIdCardManaBaseAnalysis.recommendedLands) && Intrinsics.areEqual(this.cheapRampCount, mTIdCardManaBaseAnalysis.cheapRampCount) && Intrinsics.areEqual(this.totalManaProducers, mTIdCardManaBaseAnalysis.totalManaProducers) && Intrinsics.areEqual(this.landDropReliability, mTIdCardManaBaseAnalysis.landDropReliability) && Intrinsics.areEqual(this.colorConsistency, mTIdCardManaBaseAnalysis.colorConsistency) && Intrinsics.areEqual(this.hardToCastCards, mTIdCardManaBaseAnalysis.hardToCastCards) && Intrinsics.areEqual(this.roleBreakdown, mTIdCardManaBaseAnalysis.roleBreakdown) && Intrinsics.areEqual(this.diagnostics, mTIdCardManaBaseAnalysis.diagnostics);
    }

    public final Integer getCheapRampCount() {
        return this.cheapRampCount;
    }

    public final List<MTIdCardColorAnalysisRow> getColorAnalysis() {
        return this.colorAnalysis;
    }

    public final List<MTIdCardColorConsistencyRow> getColorConsistency() {
        return this.colorConsistency;
    }

    public final MTIdCardColorFixingFlexibility getColorFixingFlexibility() {
        return this.colorFixingFlexibility;
    }

    public final MTIdCardColorlessLandAnalysis getColorlessLandAnalysis() {
        return this.colorlessLandAnalysis;
    }

    public final MTIdCardCommanderCastAnalysis getCommanderCastAnalysis() {
        return this.commanderCastAnalysis;
    }

    public final MTIdCardCommanderCastAnalysis getCommanderCastFiltered() {
        return this.commanderCastFiltered;
    }

    public final Integer getDeckSize() {
        return this.deckSize;
    }

    public final List<MTIdCardManaDiagnostic> getDiagnostics() {
        return this.diagnostics;
    }

    public final Double getEffectiveLandCount() {
        return this.effectiveLandCount;
    }

    public final MTIdCardFetchTargetAnalysis getFetchTargetAnalysis() {
        return this.fetchTargetAnalysis;
    }

    public final List<MTIdCardHardToCastCard> getHardToCastCards() {
        return this.hardToCastCards;
    }

    public final MTIdCardManaHealthScore getHealthScore() {
        return this.healthScore;
    }

    public final List<MTIdCardManaInsight> getInsights() {
        return this.insights;
    }

    public final Integer getLandCount() {
        return this.landCount;
    }

    public final MTIdCardLandCountCalculation getLandCountCalculation() {
        return this.landCountCalculation;
    }

    public final MTIdCardLandDropAnalysis getLandDropAnalysis() {
        return this.landDropAnalysis;
    }

    public final MTIdCardLandDropReliability getLandDropReliability() {
        return this.landDropReliability;
    }

    public final Double getMdfcBonus() {
        return this.mdfcBonus;
    }

    public final MTIdCardOpeningHandAnalysis getOpeningHandAnalysis() {
        return this.openingHandAnalysis;
    }

    public final MTIdCardCommanderCastAnalysis getPartnerCastAnalysis() {
        return this.partnerCastAnalysis;
    }

    public final MTIdCardCommanderCastAnalysis getPartnerCastFiltered() {
        return this.partnerCastFiltered;
    }

    public final MTIdCardPipDensityAnalysis getPipDensityAnalysis() {
        return this.pipDensityAnalysis;
    }

    public final MTIdCardRampAnalysis getRampAnalysis() {
        return this.rampAnalysis;
    }

    public final Integer getRecommendedLands() {
        return this.recommendedLands;
    }

    public final List<MTIdCardRoleBreakdown> getRoleBreakdown() {
        return this.roleBreakdown;
    }

    public final Integer getScore() {
        return this.score;
    }

    public final MTIdCardTapLandAnalysis getTapLandAnalysis() {
        return this.tapLandAnalysis;
    }

    public final Integer getTotalLands() {
        return this.totalLands;
    }

    public final Integer getTotalManaProducers() {
        return this.totalManaProducers;
    }

    public int hashCode() {
        Integer num = this.landCount;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.deckSize;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        MTIdCardLandCountCalculation mTIdCardLandCountCalculation = this.landCountCalculation;
        int iHashCode3 = (((iHashCode2 + (mTIdCardLandCountCalculation == null ? 0 : mTIdCardLandCountCalculation.hashCode())) * 31) + this.colorAnalysis.hashCode()) * 31;
        MTIdCardColorFixingFlexibility mTIdCardColorFixingFlexibility = this.colorFixingFlexibility;
        int iHashCode4 = (iHashCode3 + (mTIdCardColorFixingFlexibility == null ? 0 : mTIdCardColorFixingFlexibility.hashCode())) * 31;
        MTIdCardCommanderCastAnalysis mTIdCardCommanderCastAnalysis = this.commanderCastAnalysis;
        int iHashCode5 = (iHashCode4 + (mTIdCardCommanderCastAnalysis == null ? 0 : mTIdCardCommanderCastAnalysis.hashCode())) * 31;
        MTIdCardCommanderCastAnalysis mTIdCardCommanderCastAnalysis2 = this.partnerCastAnalysis;
        int iHashCode6 = (iHashCode5 + (mTIdCardCommanderCastAnalysis2 == null ? 0 : mTIdCardCommanderCastAnalysis2.hashCode())) * 31;
        MTIdCardCommanderCastAnalysis mTIdCardCommanderCastAnalysis3 = this.commanderCastFiltered;
        int iHashCode7 = (iHashCode6 + (mTIdCardCommanderCastAnalysis3 == null ? 0 : mTIdCardCommanderCastAnalysis3.hashCode())) * 31;
        MTIdCardCommanderCastAnalysis mTIdCardCommanderCastAnalysis4 = this.partnerCastFiltered;
        int iHashCode8 = (iHashCode7 + (mTIdCardCommanderCastAnalysis4 == null ? 0 : mTIdCardCommanderCastAnalysis4.hashCode())) * 31;
        MTIdCardRampAnalysis mTIdCardRampAnalysis = this.rampAnalysis;
        int iHashCode9 = (iHashCode8 + (mTIdCardRampAnalysis == null ? 0 : mTIdCardRampAnalysis.hashCode())) * 31;
        MTIdCardTapLandAnalysis mTIdCardTapLandAnalysis = this.tapLandAnalysis;
        int iHashCode10 = (iHashCode9 + (mTIdCardTapLandAnalysis == null ? 0 : mTIdCardTapLandAnalysis.hashCode())) * 31;
        MTIdCardPipDensityAnalysis mTIdCardPipDensityAnalysis = this.pipDensityAnalysis;
        int iHashCode11 = (iHashCode10 + (mTIdCardPipDensityAnalysis == null ? 0 : mTIdCardPipDensityAnalysis.hashCode())) * 31;
        MTIdCardColorlessLandAnalysis mTIdCardColorlessLandAnalysis = this.colorlessLandAnalysis;
        int iHashCode12 = (iHashCode11 + (mTIdCardColorlessLandAnalysis == null ? 0 : mTIdCardColorlessLandAnalysis.hashCode())) * 31;
        MTIdCardFetchTargetAnalysis mTIdCardFetchTargetAnalysis = this.fetchTargetAnalysis;
        int iHashCode13 = (iHashCode12 + (mTIdCardFetchTargetAnalysis == null ? 0 : mTIdCardFetchTargetAnalysis.hashCode())) * 31;
        MTIdCardOpeningHandAnalysis mTIdCardOpeningHandAnalysis = this.openingHandAnalysis;
        int iHashCode14 = (iHashCode13 + (mTIdCardOpeningHandAnalysis == null ? 0 : mTIdCardOpeningHandAnalysis.hashCode())) * 31;
        MTIdCardLandDropAnalysis mTIdCardLandDropAnalysis = this.landDropAnalysis;
        int iHashCode15 = (iHashCode14 + (mTIdCardLandDropAnalysis == null ? 0 : mTIdCardLandDropAnalysis.hashCode())) * 31;
        MTIdCardManaHealthScore mTIdCardManaHealthScore = this.healthScore;
        int iHashCode16 = (((iHashCode15 + (mTIdCardManaHealthScore == null ? 0 : mTIdCardManaHealthScore.hashCode())) * 31) + this.insights.hashCode()) * 31;
        Integer num3 = this.score;
        int iHashCode17 = (iHashCode16 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.totalLands;
        int iHashCode18 = (iHashCode17 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Double d = this.effectiveLandCount;
        int iHashCode19 = (iHashCode18 + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.mdfcBonus;
        int iHashCode20 = (iHashCode19 + (d2 == null ? 0 : d2.hashCode())) * 31;
        Integer num5 = this.recommendedLands;
        int iHashCode21 = (iHashCode20 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.cheapRampCount;
        int iHashCode22 = (iHashCode21 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.totalManaProducers;
        int iHashCode23 = (iHashCode22 + (num7 == null ? 0 : num7.hashCode())) * 31;
        MTIdCardLandDropReliability mTIdCardLandDropReliability = this.landDropReliability;
        return ((((((((iHashCode23 + (mTIdCardLandDropReliability != null ? mTIdCardLandDropReliability.hashCode() : 0)) * 31) + this.colorConsistency.hashCode()) * 31) + this.hardToCastCards.hashCode()) * 31) + this.roleBreakdown.hashCode()) * 31) + this.diagnostics.hashCode();
    }

    public String toString() {
        return "MTIdCardManaBaseAnalysis(landCount=" + this.landCount + ", deckSize=" + this.deckSize + ", landCountCalculation=" + this.landCountCalculation + ", colorAnalysis=" + this.colorAnalysis + ", colorFixingFlexibility=" + this.colorFixingFlexibility + ", commanderCastAnalysis=" + this.commanderCastAnalysis + ", partnerCastAnalysis=" + this.partnerCastAnalysis + ", commanderCastFiltered=" + this.commanderCastFiltered + ", partnerCastFiltered=" + this.partnerCastFiltered + ", rampAnalysis=" + this.rampAnalysis + ", tapLandAnalysis=" + this.tapLandAnalysis + ", pipDensityAnalysis=" + this.pipDensityAnalysis + ", colorlessLandAnalysis=" + this.colorlessLandAnalysis + ", fetchTargetAnalysis=" + this.fetchTargetAnalysis + ", openingHandAnalysis=" + this.openingHandAnalysis + ", landDropAnalysis=" + this.landDropAnalysis + ", healthScore=" + this.healthScore + ", insights=" + this.insights + ", score=" + this.score + ", totalLands=" + this.totalLands + ", effectiveLandCount=" + this.effectiveLandCount + ", mdfcBonus=" + this.mdfcBonus + ", recommendedLands=" + this.recommendedLands + ", cheapRampCount=" + this.cheapRampCount + ", totalManaProducers=" + this.totalManaProducers + ", landDropReliability=" + this.landDropReliability + ", colorConsistency=" + this.colorConsistency + ", hardToCastCards=" + this.hardToCastCards + ", roleBreakdown=" + this.roleBreakdown + ", diagnostics=" + this.diagnostics + ")";
    }
}
