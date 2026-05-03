package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.credentials.provider.CredentialEntry;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import androidx.window.reflection.WindowExtensionsConstants;
import com.caverock.androidsvg.SVGParser;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment;
import com.vanniktech.ui.ColorKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: UnifiedFiltersBottomSheetFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010#\n\u0002\b\u000e\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\b\u0093\u0001\u0094\u0001\u0095\u0001\u0096\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109H\u0016J&\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u001a\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020;2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0010\u0010C\u001a\u00020A2\u0006\u0010B\u001a\u00020;H\u0002J\u0010\u0010E\u001a\u00020A2\u0006\u0010B\u001a\u00020;H\u0002J\u0010\u0010F\u001a\u00020A2\u0006\u0010B\u001a\u00020;H\u0002J\u000e\u0010G\u001a\b\u0012\u0004\u0012\u00020H02H\u0002J\u0010\u0010I\u001a\u00020A2\u0006\u0010B\u001a\u00020;H\u0002J\u0010\u0010J\u001a\u00020A2\u0006\u0010B\u001a\u00020;H\u0002J\u0010\u0010K\u001a\u00020A2\u0006\u0010B\u001a\u00020;H\u0002J\u001e\u0010L\u001a\u00020A2\u0014\u0010M\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010;05H\u0002J\u0010\u0010N\u001a\u00020A2\u0006\u0010B\u001a\u00020;H\u0002J\u001e\u0010O\u001a\u00020A2\u0014\u0010M\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010;05H\u0002JB\u0010P\u001a\u00020A2\b\u0010Q\u001a\u0004\u0018\u00010R2\b\u0010S\u001a\u0004\u0018\u00010R2\b\u0010T\u001a\u0004\u0018\u00010R2\u0006\u0010U\u001a\u00020\t2\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020A0WH\u0002J\u0010\u0010X\u001a\u00020A2\u0006\u0010B\u001a\u00020;H\u0002J\u0010\u0010Y\u001a\u00020A2\u0006\u0010B\u001a\u00020;H\u0002J(\u0010Z\u001a\u00020A2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\t2\u0006\u0010`\u001a\u00020;H\u0002J\u0010\u0010a\u001a\u00020A2\u0006\u0010B\u001a\u00020;H\u0002J\u0010\u0010b\u001a\u00020A2\u0006\u0010B\u001a\u00020;H\u0002J\u0010\u0010c\u001a\u00020A2\u0006\u0010B\u001a\u00020;H\u0002J\u0010\u0010d\u001a\u00020A2\u0006\u0010B\u001a\u00020;H\u0002J\u0010\u0010e\u001a\u00020A2\u0006\u0010B\u001a\u00020;H\u0002J\u0010\u0010f\u001a\u00020A2\u0006\u0010B\u001a\u00020;H\u0002J\u0010\u0010g\u001a\u00020A2\u0006\u0010B\u001a\u00020;H\u0002J\u0010\u0010h\u001a\u00020A2\u0006\u0010B\u001a\u00020;H\u0002J\u0010\u0010i\u001a\u00020A2\u0006\u0010B\u001a\u00020;H\u0002J?\u0010j\u001a\u00020A2\b\u0010k\u001a\u0004\u0018\u00010;2\u0006\u0010l\u001a\u00020\t2\b\u0010m\u001a\u0004\u0018\u00010\f2\u0014\u0010n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020A0WH\u0002¢\u0006\u0002\u0010oJ\u0010\u0010p\u001a\u00020A2\u0006\u0010B\u001a\u00020;H\u0002J\u0010\u0010q\u001a\u00020A2\u0006\u0010B\u001a\u00020;H\u0002J\u0010\u0010r\u001a\u00020\t2\u0006\u0010B\u001a\u00020;H\u0002J6\u0010s\u001a\u00020A2\u0006\u0010B\u001a\u00020;2\u0006\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020u2\u0006\u0010w\u001a\u00020\t2\f\u0010x\u001a\b\u0012\u0004\u0012\u00020\t00H\u0002J\u0012\u0010y\u001a\u00020\t2\b\u0010z\u001a\u0004\u0018\u00010{H\u0002J\u0018\u0010|\u001a\u00020A2\u0006\u0010B\u001a\u00020;2\u0006\u0010}\u001a\u00020\tH\u0002J\u0019\u0010~\u001a\u00020A2\u0006\u0010B\u001a\u00020;2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0002J\u001a\u0010\u0081\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010\u0082\u0001\u001a\u00020\tH\u0002¢\u0006\u0003\u0010\u0083\u0001J*\u0010\u0084\u0001\u001a\u00020A2\u0006\u0010B\u001a\u00020;2\u0006\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020u2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0002J\u001d\u0010\u0085\u0001\u001a\u00020A2\b\u0010z\u001a\u0004\u0018\u00010{2\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0002J\u0019\u0010\u0088\u0001\u001a\u00020R2\u0006\u0010[\u001a\u00020\\2\u0006\u0010_\u001a\u00020\tH\u0002JE\u0010\u0089\u0001\u001a\u00020R2\u0006\u0010[\u001a\u00020\\2\u0006\u0010_\u001a\u00020\t2\r\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020\t0!2\u0007\u0010\u008b\u0001\u001a\u00020\t2\u0012\b\u0002\u0010\u008c\u0001\u001a\u000b\u0012\u0004\u0012\u00020A\u0018\u00010\u008d\u0001H\u0002J#\u0010\u008e\u0001\u001a\u00020A2\u0007\u0010\u008f\u0001\u001a\u00020R2\u0006\u0010[\u001a\u00020\\2\u0007\u0010\u0090\u0001\u001a\u00020\fH\u0002J\"\u0010\u0091\u0001\u001a\u00020A2\b\u0010]\u001a\u0004\u0018\u00010^2\r\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020\t0!H\u0002J\u0012\u0010\u0092\u0001\u001a\u00020u2\u0007\u0010\u0082\u0001\u001a\u00020uH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\t0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010)R\u0012\u0010*\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010)R\u0012\u0010+\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010)R\u0012\u0010,\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010)R\u0012\u0010-\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010)R\u000e\u0010.\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020\t00X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\t02X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020\t02X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t05X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020\t02X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0097\u0001"}, d2 = {"Lcom/studiolaganne/lengendarylens/UnifiedFiltersBottomSheetFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/studiolaganne/lengendarylens/UnifiedFiltersListener;", "mode", "Lcom/studiolaganne/lengendarylens/FilterMode;", "currentFilters", "", "lang", "alwaysKeywordsInEnglish", "", "selectedFillGap", "isSmartDeck", "FA_FONT", "FA_PALETTE", "FA_ID_CARD", "FA_SHAPES", "FA_SCROLL", "FA_HASHTAG", "FA_BOLT", "FA_LAYER_GROUP", "FA_GEM", "FA_KEY", "FA_COLUMNS", "FA_BARCODE", "FA_GLOBE", "FA_GAVEL", "FA_CHECK_CIRCLE", "FA_DOLLAR", "FA_BOX", "selectedColors", "", "colorMode", "selectedIdentity", "identityMode", "selectedLegal", "selectedBanned", "selectedIsProps", "alteredState", "Ljava/lang/Boolean;", "misprintState", "signedState", "proxyState", "inDeckState", "selectedSetCode", "oracleClauses", "", "formats", "", "isProperties", "isPropertyLabels", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "", ViewHierarchyConstants.VIEW_KEY, "setupIcons", "FILL_GAP_CATEGORIES", "setupThemeSection", "setupSectionVisibility", "getSectionDefs", "Lcom/studiolaganne/lengendarylens/UnifiedFiltersBottomSheetFragment$SectionDef;", "updateAllSectionStates", "setupSectionClearButtons", "setupColorSection", "updateColorHighlights", "views", "setupIdentitySection", "updateIdentityHighlights", "setupModeToggle", "btn1", "Landroid/widget/TextView;", "btn2", "btn3", "defaultOp", "onSelected", "Lkotlin/Function1;", "setupTypeChips", "setupOracleSection", "addOracleChip", "ctx", "Landroid/content/Context;", WindowExtensionsConstants.LAYOUT_PACKAGE, "Lcom/google/android/flexbox/FlexboxLayout;", "text", "rootView", "setupNumericSpinners", "setupSetAutoComplete", "setupRaritySection", "setupKeywordAutoComplete", "setupLayoutSpinner", "setupLanguageSpinner", "setupLegalityChips", "setupIsChips", "setupCollectionToggles", "setupTristateRow", "row", Constants.ScionAnalytics.PARAM_LABEL, "initialState", "onChanged", "(Landroid/view/View;Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;)V", "setupButtons", "clearAll", "buildScryfallQuery", "addNumericFilter", "spinnerId", "", "editTextId", "keyword", "parts", "getOperatorFromSpinner", "spinner", "Landroid/widget/Spinner;", "parseAndPopulate", SearchIntents.EXTRA_QUERY, "populateFromCondition", "cond", "Lcom/studiolaganne/lengendarylens/SearchCondition;", "parseBooleanValue", "value", "(Ljava/lang/String;)Ljava/lang/Boolean;", "setNumericField", "setOperatorSpinner", "operator", "Lcom/studiolaganne/lengendarylens/Operator;", "createChip", "createToggleChip", "selectedSet", SubscriberAttributeKt.JSON_NAME_KEY, "onChange", "Lkotlin/Function0;", "updateToggleChipStyle", "chip", "selected", "refreshToggleChips", "dp", "SectionDef", "SetEntry", "SetFilterAdapter", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UnifiedFiltersBottomSheetFragment extends BottomSheetDialogFragment {
    public static final int $stable = 8;
    private Boolean alteredState;
    private boolean alwaysKeywordsInEnglish;
    private Boolean inDeckState;
    private UnifiedFiltersListener listener;
    private Boolean misprintState;
    private Boolean proxyState;
    private String selectedFillGap;
    private Boolean signedState;
    private FilterMode mode = FilterMode.GENERAL;
    private String currentFilters = "";
    private String lang = "en";
    private boolean isSmartDeck = true;
    private final String FA_FONT = "\uf031";
    private final String FA_PALETTE = "\uf53f";
    private final String FA_ID_CARD = "\uf2c2";
    private final String FA_SHAPES = "\uf61f";
    private final String FA_SCROLL = "\uf70e";
    private final String FA_HASHTAG = ColorKt.HEX_PREFIX;
    private final String FA_BOLT = "\uf0e7";
    private final String FA_LAYER_GROUP = "\uf5fd";
    private final String FA_GEM = "\uf3a5";
    private final String FA_KEY = "\uf084";
    private final String FA_COLUMNS = "\uf0db";
    private final String FA_BARCODE = "\uf02a";
    private final String FA_GLOBE = "\uf0ac";
    private final String FA_GAVEL = "\uf0e3";
    private final String FA_CHECK_CIRCLE = "\uf058";
    private final String FA_DOLLAR = "\uf155";
    private final String FA_BOX = "\uf466";
    private final Set<String> selectedColors = new LinkedHashSet();
    private String colorMode = com.revenuecat.purchases.common.Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
    private final Set<String> selectedIdentity = new LinkedHashSet();
    private String identityMode = "<=";
    private final Set<String> selectedLegal = new LinkedHashSet();
    private final Set<String> selectedBanned = new LinkedHashSet();
    private final Set<String> selectedIsProps = new LinkedHashSet();
    private String selectedSetCode = "";
    private final List<String> oracleClauses = new ArrayList();
    private final List<String> formats = CollectionsKt.listOf((Object[]) new String[]{"standard", "pioneer", "modern", "legacy", "vintage", "commander", "pauper", "oathbreaker", "historic", "duel"});
    private final List<String> isProperties = CollectionsKt.listOf((Object[]) new String[]{"spell", "permanent", "vanilla", "hybrid", "phyrexian", "reserved", "gamechanger"});
    private final Map<String, String> isPropertyLabels = MapsKt.mapOf(TuplesKt.to("reserved", "Reserved List"), TuplesKt.to("gamechanger", "Game Changer"));
    private final List<String> FILL_GAP_CATEGORIES = CollectionsKt.listOf((Object[]) new String[]{"ramp", "card_draw", "spot_removal", "board_wipes", "protection", "recursion", "tutor", "counterspell", "graveyard_hate", "finisher"});

    /* JADX INFO: compiled from: UnifiedFiltersBottomSheetFragment.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\tJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\fJ\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\fJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\tR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/studiolaganne/lengendarylens/UnifiedFiltersBottomSheetFragment$Builder;", "", "<init>", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/studiolaganne/lengendarylens/UnifiedFiltersListener;", "mode", "Lcom/studiolaganne/lengendarylens/FilterMode;", "currentFilters", "", "lang", "alwaysKeywordsInEnglish", "", "fillGap", "isSmartDeck", InAppPurchaseConstants.METHOD_SET_LISTENER, "setMode", "setCurrentFilters", "filters", "setLang", "setAlwaysKeywordsInEnglish", "always", "setFillGap", "gap", "setSmartDeck", "build", "Lcom/studiolaganne/lengendarylens/UnifiedFiltersBottomSheetFragment;", "show", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private boolean alwaysKeywordsInEnglish;
        private String fillGap;
        private UnifiedFiltersListener listener;
        private FilterMode mode = FilterMode.GENERAL;
        private String currentFilters = "";
        private String lang = "en";
        private boolean isSmartDeck = true;

        public final UnifiedFiltersBottomSheetFragment build() {
            UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment = new UnifiedFiltersBottomSheetFragment();
            unifiedFiltersBottomSheetFragment.listener = this.listener;
            unifiedFiltersBottomSheetFragment.mode = this.mode;
            unifiedFiltersBottomSheetFragment.currentFilters = this.currentFilters;
            unifiedFiltersBottomSheetFragment.lang = this.lang;
            unifiedFiltersBottomSheetFragment.alwaysKeywordsInEnglish = this.alwaysKeywordsInEnglish;
            unifiedFiltersBottomSheetFragment.selectedFillGap = this.fillGap;
            unifiedFiltersBottomSheetFragment.isSmartDeck = this.isSmartDeck;
            return unifiedFiltersBottomSheetFragment;
        }

        public final Builder setAlwaysKeywordsInEnglish(boolean always) {
            this.alwaysKeywordsInEnglish = always;
            return this;
        }

        public final Builder setCurrentFilters(String filters) {
            Intrinsics.checkNotNullParameter(filters, "filters");
            this.currentFilters = filters;
            return this;
        }

        public final Builder setFillGap(String gap) {
            this.fillGap = gap;
            return this;
        }

        public final Builder setLang(String lang) {
            Intrinsics.checkNotNullParameter(lang, "lang");
            this.lang = lang;
            return this;
        }

        public final Builder setListener(UnifiedFiltersListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listener = listener;
            return this;
        }

        public final Builder setMode(FilterMode mode) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            this.mode = mode;
            return this;
        }

        public final Builder setSmartDeck(boolean isSmartDeck) {
            this.isSmartDeck = isSmartDeck;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(build(), manager, tag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: UnifiedFiltersBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bHÆ\u0003J\u0015\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\bHÆ\u0003J]\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0014R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006\""}, d2 = {"Lcom/studiolaganne/lengendarylens/UnifiedFiltersBottomSheetFragment$SectionDef;", "", "headerId", "", "iconId", "titleId", "clearId", "isActive", "Lkotlin/Function1;", "Landroid/view/View;", "", "onClear", "", "<init>", "(IIIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getHeaderId", "()I", "getIconId", "getTitleId", "getClearId", "()Lkotlin/jvm/functions/Function1;", "getOnClear", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final /* data */ class SectionDef {
        private final int clearId;
        private final int headerId;
        private final int iconId;
        private final Function1<View, Boolean> isActive;
        private final Function1<View, Unit> onClear;
        private final int titleId;

        /* JADX WARN: Multi-variable type inference failed */
        public SectionDef(int i, int i2, int i3, int i4, Function1<? super View, Boolean> isActive, Function1<? super View, Unit> onClear) {
            Intrinsics.checkNotNullParameter(isActive, "isActive");
            Intrinsics.checkNotNullParameter(onClear, "onClear");
            this.headerId = i;
            this.iconId = i2;
            this.titleId = i3;
            this.clearId = i4;
            this.isActive = isActive;
            this.onClear = onClear;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SectionDef copy$default(SectionDef sectionDef, int i, int i2, int i3, int i4, Function1 function1, Function1 function12, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i = sectionDef.headerId;
            }
            if ((i5 & 2) != 0) {
                i2 = sectionDef.iconId;
            }
            if ((i5 & 4) != 0) {
                i3 = sectionDef.titleId;
            }
            if ((i5 & 8) != 0) {
                i4 = sectionDef.clearId;
            }
            if ((i5 & 16) != 0) {
                function1 = sectionDef.isActive;
            }
            if ((i5 & 32) != 0) {
                function12 = sectionDef.onClear;
            }
            Function1 function13 = function1;
            Function1 function14 = function12;
            return sectionDef.copy(i, i2, i3, i4, function13, function14);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getHeaderId() {
            return this.headerId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getIconId() {
            return this.iconId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getTitleId() {
            return this.titleId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getClearId() {
            return this.clearId;
        }

        public final Function1<View, Boolean> component5() {
            return this.isActive;
        }

        public final Function1<View, Unit> component6() {
            return this.onClear;
        }

        public final SectionDef copy(int headerId, int iconId, int titleId, int clearId, Function1<? super View, Boolean> isActive, Function1<? super View, Unit> onClear) {
            Intrinsics.checkNotNullParameter(isActive, "isActive");
            Intrinsics.checkNotNullParameter(onClear, "onClear");
            return new SectionDef(headerId, iconId, titleId, clearId, isActive, onClear);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SectionDef)) {
                return false;
            }
            SectionDef sectionDef = (SectionDef) other;
            return this.headerId == sectionDef.headerId && this.iconId == sectionDef.iconId && this.titleId == sectionDef.titleId && this.clearId == sectionDef.clearId && Intrinsics.areEqual(this.isActive, sectionDef.isActive) && Intrinsics.areEqual(this.onClear, sectionDef.onClear);
        }

        public final int getClearId() {
            return this.clearId;
        }

        public final int getHeaderId() {
            return this.headerId;
        }

        public final int getIconId() {
            return this.iconId;
        }

        public final Function1<View, Unit> getOnClear() {
            return this.onClear;
        }

        public final int getTitleId() {
            return this.titleId;
        }

        public int hashCode() {
            return (((((((((Integer.hashCode(this.headerId) * 31) + Integer.hashCode(this.iconId)) * 31) + Integer.hashCode(this.titleId)) * 31) + Integer.hashCode(this.clearId)) * 31) + this.isActive.hashCode()) * 31) + this.onClear.hashCode();
        }

        public final Function1<View, Boolean> isActive() {
            return this.isActive;
        }

        public String toString() {
            return "SectionDef(headerId=" + this.headerId + ", iconId=" + this.iconId + ", titleId=" + this.titleId + ", clearId=" + this.clearId + ", isActive=" + this.isActive + ", onClear=" + this.onClear + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: UnifiedFiltersBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/UnifiedFiltersBottomSheetFragment$SetEntry;", "", "name", "", "code", "display", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getCode", "getDisplay", InAppPurchaseConstants.METHOD_TO_STRING, "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final /* data */ class SetEntry {
        private final String code;
        private final String display;
        private final String name;

        public SetEntry(String name, String code, String display) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(display, "display");
            this.name = name;
            this.code = code;
            this.display = display;
        }

        public static /* synthetic */ SetEntry copy$default(SetEntry setEntry, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = setEntry.name;
            }
            if ((i & 2) != 0) {
                str2 = setEntry.code;
            }
            if ((i & 4) != 0) {
                str3 = setEntry.display;
            }
            return setEntry.copy(str, str2, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCode() {
            return this.code;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getDisplay() {
            return this.display;
        }

        public final SetEntry copy(String name, String code, String display) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(display, "display");
            return new SetEntry(name, code, display);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SetEntry)) {
                return false;
            }
            SetEntry setEntry = (SetEntry) other;
            return Intrinsics.areEqual(this.name, setEntry.name) && Intrinsics.areEqual(this.code, setEntry.code) && Intrinsics.areEqual(this.display, setEntry.display);
        }

        public final String getCode() {
            return this.code;
        }

        public final String getDisplay() {
            return this.display;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return (((this.name.hashCode() * 31) + this.code.hashCode()) * 31) + this.display.hashCode();
        }

        public String toString() {
            return this.display;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: UnifiedFiltersBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/studiolaganne/lengendarylens/UnifiedFiltersBottomSheetFragment$SetFilterAdapter;", "Landroid/widget/ArrayAdapter;", "Lcom/studiolaganne/lengendarylens/UnifiedFiltersBottomSheetFragment$SetEntry;", "ctx", "Landroid/content/Context;", "allEntries", "", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "filtered", "getCount", "", "getItem", "position", "getFilter", "Landroid/widget/Filter;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final class SetFilterAdapter extends ArrayAdapter<SetEntry> {
        private final List<SetEntry> allEntries;
        private List<SetEntry> filtered;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetFilterAdapter(Context ctx, List<SetEntry> allEntries) {
            super(ctx, android.R.layout.simple_dropdown_item_1line, CollectionsKt.toMutableList((Collection) allEntries));
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            Intrinsics.checkNotNullParameter(allEntries, "allEntries");
            this.allEntries = allEntries;
            this.filtered = allEntries;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            return this.filtered.size();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Filterable
        public Filter getFilter() {
            return new Filter() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$SetFilterAdapter$getFilter$1
                /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
                @Override // android.widget.Filter
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                protected Filter.FilterResults performFiltering(CharSequence constraint) {
                    String lowerCase;
                    ArrayList arrayList;
                    String string;
                    String string2;
                    if (constraint == null || (string = constraint.toString()) == null || (string2 = StringsKt.trim((CharSequence) string).toString()) == null) {
                        lowerCase = "";
                    } else {
                        lowerCase = string2.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        if (lowerCase == null) {
                        }
                    }
                    String str = lowerCase;
                    int length = str.length();
                    UnifiedFiltersBottomSheetFragment.SetFilterAdapter setFilterAdapter = this.this$0;
                    if (length == 0) {
                        arrayList = setFilterAdapter.allEntries;
                    } else {
                        List list = setFilterAdapter.allEntries;
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj : list) {
                            UnifiedFiltersBottomSheetFragment.SetEntry setEntry = (UnifiedFiltersBottomSheetFragment.SetEntry) obj;
                            String lowerCase2 = setEntry.getName().toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                            if (!StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) str, false, 2, (Object) null)) {
                                String lowerCase3 = setEntry.getCode().toLowerCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                                if (StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) str, false, 2, (Object) null)) {
                                }
                            }
                            arrayList2.add(obj);
                        }
                        arrayList = arrayList2;
                    }
                    Filter.FilterResults filterResults = new Filter.FilterResults();
                    filterResults.values = arrayList;
                    filterResults.count = arrayList.size();
                    return filterResults;
                }

                @Override // android.widget.Filter
                protected void publishResults(CharSequence constraint, Filter.FilterResults results) {
                    UnifiedFiltersBottomSheetFragment.SetFilterAdapter setFilterAdapter = this.this$0;
                    Object obj = results != null ? results.values : null;
                    List list = obj instanceof List ? (List) obj : null;
                    if (list == null) {
                        list = this.this$0.allEntries;
                    }
                    setFilterAdapter.filtered = list;
                    boolean zIsEmpty = this.this$0.filtered.isEmpty();
                    UnifiedFiltersBottomSheetFragment.SetFilterAdapter setFilterAdapter2 = this.this$0;
                    if (zIsEmpty) {
                        setFilterAdapter2.notifyDataSetInvalidated();
                    } else {
                        setFilterAdapter2.notifyDataSetChanged();
                    }
                }
            };
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public SetEntry getItem(int position) {
            return this.filtered.get(position);
        }
    }

    /* JADX INFO: compiled from: UnifiedFiltersBottomSheetFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[FilterMode.values().length];
            try {
                iArr[FilterMode.GENERAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FilterMode.COLLECTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FilterMode.LOCAL_DB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FilterMode.SEARCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SearchKeyword.values().length];
            try {
                iArr2[SearchKeyword.NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[SearchKeyword.COLOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[SearchKeyword.IDENTITY.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[SearchKeyword.TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[SearchKeyword.ORACLE_TEXT.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[SearchKeyword.MANA_VALUE.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[SearchKeyword.POWER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[SearchKeyword.TOUGHNESS.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[SearchKeyword.LOYALTY.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[SearchKeyword.DEFENSE.ordinal()] = 10;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[SearchKeyword.SET.ordinal()] = 11;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[SearchKeyword.RARITY.ordinal()] = 12;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr2[SearchKeyword.KEYWORD.ordinal()] = 13;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr2[SearchKeyword.LAYOUT.ordinal()] = 14;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr2[SearchKeyword.NUMBER.ordinal()] = 15;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr2[SearchKeyword.LANGUAGE.ordinal()] = 16;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr2[SearchKeyword.LEGAL.ordinal()] = 17;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr2[SearchKeyword.BANNED.ordinal()] = 18;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr2[SearchKeyword.IS.ordinal()] = 19;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr2[SearchKeyword.PRICE.ordinal()] = 20;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr2[SearchKeyword.ALTERED.ordinal()] = 21;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr2[SearchKeyword.MISPRINT.ordinal()] = 22;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr2[SearchKeyword.SIGNED.ordinal()] = 23;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr2[SearchKeyword.PROXY.ordinal()] = 24;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr2[SearchKeyword.IN_DECK.ordinal()] = 25;
            } catch (NoSuchFieldError unused29) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private final void addNumericFilter(View view, int spinnerId, int editTextId, String keyword, List<String> parts) {
        String string;
        String string2;
        EditText editText = (EditText) view.findViewById(editTextId);
        if (editText == null) {
            return;
        }
        Editable text = editText.getText();
        if (text == null || (string2 = text.toString()) == null || (string = StringsKt.trim((CharSequence) string2).toString()) == null) {
            string = "";
        }
        if (string.length() == 0) {
            return;
        }
        parts.add(keyword + getOperatorFromSpinner((Spinner) view.findViewById(spinnerId)) + string);
    }

    private final void addOracleChip(Context ctx, final FlexboxLayout layout, final String text, final View rootView) {
        final TextView textView = new TextView(ctx);
        textView.setText(text + "  ✕");
        textView.setTextColor(ContextCompat.getColor(ctx, R.color.almost_white));
        textView.setTextSize(13.0f);
        textView.setPadding(dp(10), dp(6), dp(10), dp(6));
        textView.setBackgroundResource(R.drawable.selected_chip_background);
        FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(dp(2), dp(3), dp(2), dp(3));
        textView.setLayoutParams(layoutParams);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda54
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UnifiedFiltersBottomSheetFragment.addOracleChip$lambda$1(this.f$0, text, layout, textView, rootView, view);
            }
        });
        layout.addView(textView);
    }

    static final void addOracleChip$lambda$1(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, String str, FlexboxLayout flexboxLayout, TextView textView, View view, View view2) {
        unifiedFiltersBottomSheetFragment.oracleClauses.remove(str);
        flexboxLayout.removeView(textView);
        unifiedFiltersBottomSheetFragment.updateAllSectionStates(view);
    }

    private final String buildScryfallQuery(View view) {
        String string;
        String string2;
        String string3;
        String string4;
        kotlin.text.MatchResult matchResultFind$default;
        Editable text;
        String string5;
        char c;
        String string6;
        char c2;
        char c3;
        String string7;
        Editable text2;
        String string8;
        Editable text3;
        String string9;
        Editable text4;
        String string10;
        Editable text5;
        String string11;
        String lowerCase;
        Editable text6;
        String string12;
        ArrayList arrayList = new ArrayList();
        EditText editText = (EditText) view.findViewById(R.id.nameEditText);
        if (editText == null || (text6 = editText.getText()) == null || (string12 = text6.toString()) == null || (string = StringsKt.trim((CharSequence) string12).toString()) == null) {
            string = "";
        }
        String str = string;
        char c4 = 2;
        if (str.length() > 0) {
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) " ", false, 2, (Object) null)) {
                arrayList.add("\"" + string + "\"");
            } else {
                arrayList.add(string);
            }
        }
        String lowerCase2 = "colorless";
        if (!this.selectedColors.isEmpty()) {
            if (this.selectedColors.contains("C")) {
                lowerCase = "colorless";
            } else {
                lowerCase = CollectionsKt.joinToString$default(this.selectedColors, "", null, null, 0, null, null, 62, null).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            }
            arrayList.add("c" + this.colorMode + lowerCase);
        }
        if (!this.selectedIdentity.isEmpty()) {
            if (!this.selectedIdentity.contains("C")) {
                lowerCase2 = CollectionsKt.joinToString$default(this.selectedIdentity, "", null, null, 0, null, null, 62, null).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            }
            arrayList.add("id" + this.identityMode + lowerCase2);
        }
        EditText editText2 = (EditText) view.findViewById(R.id.typeEditText);
        if (editText2 == null || (text5 = editText2.getText()) == null || (string11 = text5.toString()) == null || (string2 = StringsKt.trim((CharSequence) string11).toString()) == null) {
            string2 = "";
        }
        String str2 = string2;
        if (str2.length() > 0) {
            List<String> listSplit = new Regex("\\s+").split(str2, 0);
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : listSplit) {
                if (((String) obj).length() > 0) {
                    arrayList2.add(obj);
                }
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add("t:" + ((String) it.next()));
            }
        }
        for (String str3 : this.oracleClauses) {
            if (StringsKt.contains$default((CharSequence) str3, (CharSequence) " ", false, 2, (Object) null)) {
                arrayList.add("o:\"" + str3 + "\"");
            } else {
                arrayList.add("o:" + str3);
            }
        }
        EditText editText3 = (EditText) view.findViewById(R.id.oracleEditText);
        if (editText3 == null || (text4 = editText3.getText()) == null || (string10 = text4.toString()) == null || (string3 = StringsKt.trim((CharSequence) string10).toString()) == null) {
            string3 = "";
        }
        String str4 = string3;
        if (str4.length() > 0) {
            if (StringsKt.contains$default((CharSequence) str4, (CharSequence) " ", false, 2, (Object) null)) {
                arrayList.add("o:\"" + string3 + "\"");
            } else {
                arrayList.add("o:" + string3);
            }
        }
        addNumericFilter(view, R.id.manaValueOperator, R.id.manaValueEditText, "mv", arrayList);
        addNumericFilter(view, R.id.powerOperator, R.id.powerEditText, "pow", arrayList);
        addNumericFilter(view, R.id.toughnessOperator, R.id.toughnessEditText, "tou", arrayList);
        addNumericFilter(view, R.id.loyaltyOperator, R.id.loyaltyEditText, "loy", arrayList);
        addNumericFilter(view, R.id.defenseOperator, R.id.defenseEditText, "def", arrayList);
        if (this.selectedSetCode.length() > 0) {
            arrayList.add("s:" + this.selectedSetCode);
        } else {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) view.findViewById(R.id.setAutoComplete);
            if (autoCompleteTextView == null || (text = autoCompleteTextView.getText()) == null || (string5 = text.toString()) == null || (string4 = StringsKt.trim((CharSequence) string5).toString()) == null) {
                string4 = "";
            }
            String str5 = string4;
            if (str5.length() > 0 && (matchResultFind$default = Regex.find$default(new Regex("\\(([^)]+)\\)"), str5, 0, 2, null)) != null) {
                String lowerCase3 = matchResultFind$default.getGroupValues().get(1).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                arrayList.add("s:" + lowerCase3);
            }
        }
        Spinner spinner = (Spinner) view.findViewById(R.id.raritySpinner);
        Spinner spinner2 = (Spinner) view.findViewById(R.id.rarityOperator);
        char c5 = 7;
        if (spinner == null || spinner.getSelectedItemPosition() <= 0) {
            c = 6;
        } else {
            c = 6;
            arrayList.add("r" + getOperatorFromSpinner(spinner2) + ((String) CollectionsKt.listOf((Object[]) new String[]{"", "c", "u", "r", "m", "s", "b"}).get(spinner.getSelectedItemPosition())));
        }
        AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) view.findViewById(R.id.keywordAutoComplete);
        if (autoCompleteTextView2 == null || (text3 = autoCompleteTextView2.getText()) == null || (string9 = text3.toString()) == null || (string6 = StringsKt.trim((CharSequence) string9).toString()) == null) {
            string6 = "";
        }
        if (string6.length() > 0) {
            Map<String, String> keywords = SearchDataUtils.INSTANCE.getInstance().getKeywords();
            if (Intrinsics.areEqual(this.lang, "fr")) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, String> entry : keywords.entrySet()) {
                    char c6 = c5;
                    if (Intrinsics.areEqual(entry.getValue(), string6)) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                        c4 = c4;
                    }
                    c5 = c6;
                }
                c2 = c5;
                c3 = c4;
                String str6 = (String) CollectionsKt.firstOrNull(linkedHashMap.keySet());
                if (str6 != null) {
                    string6 = str6;
                }
            } else {
                c2 = 7;
                c3 = 2;
            }
            arrayList.add("keyword:\"" + string6 + "\"");
        } else {
            c2 = 7;
            c3 = 2;
        }
        Spinner spinner3 = (Spinner) view.findViewById(R.id.layoutSpinner);
        if (spinner3 != null && spinner3.getSelectedItemPosition() > 0) {
            arrayList.add("l=" + CollectionsKt.plus((Collection) CollectionsKt.listOf(""), (Iterable) SearchDataUtils.INSTANCE.getInstance().getLayoutTypes()).get(spinner3.getSelectedItemPosition()));
        }
        EditText editText4 = (EditText) view.findViewById(R.id.numberEditText);
        if (editText4 == null || (text2 = editText4.getText()) == null || (string8 = text2.toString()) == null || (string7 = StringsKt.trim((CharSequence) string8).toString()) == null) {
            string7 = "";
        }
        if (string7.length() > 0) {
            arrayList.add("cn:" + string7);
        }
        Spinner spinner4 = (Spinner) view.findViewById(R.id.languageSpinner);
        if (spinner4 != null && spinner4.getSelectedItemPosition() > 0) {
            String[] strArr = new String[12];
            strArr[0] = "";
            strArr[1] = "en";
            strArr[c3] = "fr";
            strArr[3] = "es";
            strArr[4] = "de";
            strArr[5] = "it";
            strArr[c] = "pt";
            strArr[c2] = "ja";
            strArr[8] = "ko";
            strArr[9] = "zht";
            strArr[10] = "zhs";
            strArr[11] = "ru";
            arrayList.add("lang:" + CollectionsKt.listOf((Object[]) strArr).get(spinner4.getSelectedItemPosition()));
        }
        Iterator<T> it2 = this.selectedLegal.iterator();
        while (it2.hasNext()) {
            arrayList.add("legal:" + ((String) it2.next()));
        }
        Iterator<T> it3 = this.selectedBanned.iterator();
        while (it3.hasNext()) {
            arrayList.add("banned:" + ((String) it3.next()));
        }
        Iterator<T> it4 = this.selectedIsProps.iterator();
        while (it4.hasNext()) {
            arrayList.add("is:" + ((String) it4.next()));
        }
        addNumericFilter(view, R.id.priceOperator, R.id.priceEditText, FirebaseAnalytics.Param.PRICE, arrayList);
        Boolean bool = this.alteredState;
        if (bool != null) {
            arrayList.add("altered:" + bool.booleanValue());
        }
        Boolean bool2 = this.misprintState;
        if (bool2 != null) {
            arrayList.add("misprint:" + bool2.booleanValue());
        }
        Boolean bool3 = this.signedState;
        if (bool3 != null) {
            arrayList.add("signed:" + bool3.booleanValue());
        }
        Boolean bool4 = this.proxyState;
        if (bool4 != null) {
            arrayList.add("proxy:" + bool4.booleanValue());
        }
        Boolean bool5 = this.inDeckState;
        if (bool5 != null) {
            arrayList.add("in_deck:" + bool5.booleanValue());
        }
        return CollectionsKt.joinToString$default(arrayList, " ", null, null, 0, null, null, 62, null);
    }

    private final void clearAll(View view) {
        EditText editText = (EditText) view.findViewById(R.id.nameEditText);
        if (editText != null) {
            editText.setText("");
        }
        EditText editText2 = (EditText) view.findViewById(R.id.typeEditText);
        if (editText2 != null) {
            editText2.setText("");
        }
        EditText editText3 = (EditText) view.findViewById(R.id.oracleEditText);
        if (editText3 != null) {
            editText3.setText("");
        }
        EditText editText4 = (EditText) view.findViewById(R.id.manaValueEditText);
        if (editText4 != null) {
            editText4.setText("");
        }
        EditText editText5 = (EditText) view.findViewById(R.id.powerEditText);
        if (editText5 != null) {
            editText5.setText("");
        }
        EditText editText6 = (EditText) view.findViewById(R.id.toughnessEditText);
        if (editText6 != null) {
            editText6.setText("");
        }
        EditText editText7 = (EditText) view.findViewById(R.id.loyaltyEditText);
        if (editText7 != null) {
            editText7.setText("");
        }
        EditText editText8 = (EditText) view.findViewById(R.id.defenseEditText);
        if (editText8 != null) {
            editText8.setText("");
        }
        EditText editText9 = (EditText) view.findViewById(R.id.numberEditText);
        if (editText9 != null) {
            editText9.setText("");
        }
        EditText editText10 = (EditText) view.findViewById(R.id.priceEditText);
        if (editText10 != null) {
            editText10.setText("");
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) view.findViewById(R.id.setAutoComplete);
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setText("");
        }
        AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) view.findViewById(R.id.keywordAutoComplete);
        if (autoCompleteTextView2 != null) {
            autoCompleteTextView2.setText("");
        }
        this.selectedSetCode = "";
        this.oracleClauses.clear();
        FlexboxLayout flexboxLayout = (FlexboxLayout) view.findViewById(R.id.oracleTagsLayout);
        if (flexboxLayout != null) {
            flexboxLayout.removeAllViews();
        }
        Spinner spinner = (Spinner) view.findViewById(R.id.manaValueOperator);
        if (spinner != null) {
            spinner.setSelection(0);
        }
        Spinner spinner2 = (Spinner) view.findViewById(R.id.powerOperator);
        if (spinner2 != null) {
            spinner2.setSelection(0);
        }
        Spinner spinner3 = (Spinner) view.findViewById(R.id.toughnessOperator);
        if (spinner3 != null) {
            spinner3.setSelection(0);
        }
        Spinner spinner4 = (Spinner) view.findViewById(R.id.loyaltyOperator);
        if (spinner4 != null) {
            spinner4.setSelection(0);
        }
        Spinner spinner5 = (Spinner) view.findViewById(R.id.defenseOperator);
        if (spinner5 != null) {
            spinner5.setSelection(0);
        }
        Spinner spinner6 = (Spinner) view.findViewById(R.id.priceOperator);
        if (spinner6 != null) {
            spinner6.setSelection(0);
        }
        Spinner spinner7 = (Spinner) view.findViewById(R.id.rarityOperator);
        if (spinner7 != null) {
            spinner7.setSelection(0);
        }
        Spinner spinner8 = (Spinner) view.findViewById(R.id.raritySpinner);
        if (spinner8 != null) {
            spinner8.setSelection(0);
        }
        Spinner spinner9 = (Spinner) view.findViewById(R.id.layoutSpinner);
        if (spinner9 != null) {
            spinner9.setSelection(0);
        }
        Spinner spinner10 = (Spinner) view.findViewById(R.id.languageSpinner);
        if (spinner10 != null) {
            spinner10.setSelection(0);
        }
        this.selectedColors.clear();
        updateColorHighlights(MapsKt.mapOf(TuplesKt.to(ExifInterface.LONGITUDE_WEST, view.findViewById(R.id.colorW)), TuplesKt.to("U", view.findViewById(R.id.colorU)), TuplesKt.to("B", view.findViewById(R.id.colorB)), TuplesKt.to("R", view.findViewById(R.id.colorR)), TuplesKt.to(GameUtils.CONDITION_GOOD, view.findViewById(R.id.colorG)), TuplesKt.to("C", view.findViewById(R.id.colorC))));
        this.selectedIdentity.clear();
        updateIdentityHighlights(MapsKt.mapOf(TuplesKt.to(ExifInterface.LONGITUDE_WEST, view.findViewById(R.id.identityW)), TuplesKt.to("U", view.findViewById(R.id.identityU)), TuplesKt.to("B", view.findViewById(R.id.identityB)), TuplesKt.to("R", view.findViewById(R.id.identityR)), TuplesKt.to(GameUtils.CONDITION_GOOD, view.findViewById(R.id.identityG)), TuplesKt.to("C", view.findViewById(R.id.identityC))));
        this.selectedLegal.clear();
        this.selectedBanned.clear();
        this.selectedIsProps.clear();
        refreshToggleChips((FlexboxLayout) view.findViewById(R.id.legalChipsLayout), this.selectedLegal);
        refreshToggleChips((FlexboxLayout) view.findViewById(R.id.bannedChipsLayout), this.selectedBanned);
        refreshToggleChips((FlexboxLayout) view.findViewById(R.id.isChipsLayout), this.selectedIsProps);
        this.alteredState = null;
        this.misprintState = null;
        this.signedState = null;
        this.proxyState = null;
        this.inDeckState = null;
        setupCollectionToggles(view);
        updateAllSectionStates(view);
    }

    private final TextView createChip(Context ctx, String text) {
        TextView textView = new TextView(ctx);
        textView.setText(text);
        textView.setTextColor(ContextCompat.getColor(ctx, R.color.almost_white));
        textView.setTextSize(13.0f);
        textView.setPadding(dp(8), dp(4), dp(8), dp(4));
        textView.setBackgroundResource(R.drawable.black_box_with_line_small);
        FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(dp(2), dp(2), dp(2), dp(2));
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    private final TextView createToggleChip(final Context ctx, String text, final Set<String> selectedSet, final String key, final Function0<Unit> onChange) {
        final TextView textView = new TextView(ctx);
        textView.setText(text);
        textView.setTextSize(13.0f);
        textView.setPadding(dp(10), dp(6), dp(10), dp(6));
        FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(dp(2), dp(3), dp(2), dp(3));
        textView.setLayoutParams(layoutParams);
        textView.setTag(key);
        updateToggleChipStyle(textView, ctx, selectedSet.contains(key));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UnifiedFiltersBottomSheetFragment.createToggleChip$lambda$0$0(selectedSet, key, this, textView, ctx, onChange, view);
            }
        });
        return textView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ TextView createToggleChip$default(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, Context context, String str, Set set, String str2, Function0 function0, int i, Object obj) {
        if ((i & 16) != 0) {
            function0 = null;
        }
        return unifiedFiltersBottomSheetFragment.createToggleChip(context, str, set, str2, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createToggleChip$lambda$0$0(Set set, String str, UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, TextView textView, Context context, Function0 function0, View view) {
        if (set.contains(str)) {
            set.remove(str);
        } else {
            set.add(str);
        }
        unifiedFiltersBottomSheetFragment.updateToggleChipStyle(textView, context, set.contains(str));
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final int dp(int value) {
        return (int) ((value * getResources().getDisplayMetrics().density) + 0.5f);
    }

    private final String getOperatorFromSpinner(Spinner spinner) {
        if (spinner == null) {
            return "=";
        }
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{"=", "!=", "<", "<=", ">", ">="});
        int selectedItemPosition = spinner.getSelectedItemPosition();
        return (selectedItemPosition < 0 || selectedItemPosition >= listListOf.size()) ? "=" : (String) listListOf.get(selectedItemPosition);
    }

    private final List<SectionDef> getSectionDefs() {
        return CollectionsKt.listOf((Object[]) new SectionDef[]{new SectionDef(R.id.headerName, R.id.iconName, R.id.titleName, R.id.clearSectionName, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda55
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$0((View) obj));
            }
        }, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$1((View) obj);
            }
        }), new SectionDef(R.id.headerColors, R.id.iconColors, R.id.titleColors, R.id.clearSectionColors, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$2(this.f$0, (View) obj));
            }
        }, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$3(this.f$0, (View) obj);
            }
        }), new SectionDef(R.id.headerIdentity, R.id.iconIdentity, R.id.titleIdentity, R.id.clearSectionIdentity, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$4(this.f$0, (View) obj));
            }
        }, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$5(this.f$0, (View) obj);
            }
        }), new SectionDef(R.id.headerType, R.id.iconType, R.id.titleType, R.id.clearSectionType, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$6((View) obj));
            }
        }, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$7((View) obj);
            }
        }), new SectionDef(R.id.headerOracle, R.id.iconOracle, R.id.titleOracle, R.id.clearSectionOracle, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$8(this.f$0, (View) obj));
            }
        }, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$9(this.f$0, (View) obj);
            }
        }), new SectionDef(R.id.headerManaValue, R.id.iconManaValue, R.id.titleManaValue, R.id.clearSectionManaValue, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda59
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$10((View) obj));
            }
        }, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda60
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$11((View) obj);
            }
        }), new SectionDef(R.id.headerStats, R.id.iconStats, R.id.titleStats, R.id.clearSectionStats, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda61
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$12((View) obj));
            }
        }, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda62
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$13((View) obj);
            }
        }), new SectionDef(R.id.headerSet, R.id.iconSet, R.id.titleSet, R.id.clearSectionSet, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$14(this.f$0, (View) obj));
            }
        }, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$15(this.f$0, (View) obj);
            }
        }), new SectionDef(R.id.headerRarity, R.id.iconRarity, R.id.titleRarity, R.id.clearSectionRarity, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$16((View) obj));
            }
        }, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$17((View) obj);
            }
        }), new SectionDef(R.id.headerKeyword, R.id.iconKeyword, R.id.titleKeyword, R.id.clearSectionKeyword, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$18((View) obj));
            }
        }, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$19((View) obj);
            }
        }), new SectionDef(R.id.headerLayout, R.id.iconLayout, R.id.titleLayout, R.id.clearSectionLayout, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$20((View) obj));
            }
        }, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$21((View) obj);
            }
        }), new SectionDef(R.id.headerNumber, R.id.iconNumber, R.id.titleNumber, R.id.clearSectionNumber, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$22((View) obj));
            }
        }, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$23((View) obj);
            }
        }), new SectionDef(R.id.headerLanguage, R.id.iconLanguage, R.id.titleLanguage, R.id.clearSectionLanguage, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$24((View) obj));
            }
        }, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$25((View) obj);
            }
        }), new SectionDef(R.id.headerLegalities, R.id.iconLegalities, R.id.titleLegalities, R.id.clearSectionLegalities, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$26(this.f$0, (View) obj));
            }
        }, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$27(this.f$0, (View) obj);
            }
        }), new SectionDef(R.id.headerIs, R.id.iconIs, R.id.titleIs, R.id.clearSectionIs, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$28(this.f$0, (View) obj));
            }
        }, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$29(this.f$0, (View) obj);
            }
        }), new SectionDef(R.id.headerPrice, R.id.iconPrice, R.id.titlePrice, R.id.clearSectionPrice, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$30((View) obj));
            }
        }, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$31((View) obj);
            }
        }), new SectionDef(R.id.headerCollection, R.id.iconCollection, R.id.titleCollection, R.id.clearSectionCollection, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$32(this.f$0, (View) obj));
            }
        }, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$33(this.f$0, (View) obj);
            }
        })});
    }

    static final boolean getSectionDefs$lambda$0(View v) {
        Editable text;
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(v, "v");
        EditText editText = (EditText) v.findViewById(R.id.nameEditText);
        return (editText == null || (text = editText.getText()) == null || (string = text.toString()) == null || (string2 = StringsKt.trim((CharSequence) string).toString()) == null || string2.length() <= 0) ? false : true;
    }

    static final Unit getSectionDefs$lambda$1(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        EditText editText = (EditText) v.findViewById(R.id.nameEditText);
        if (editText != null) {
            editText.setText("");
        }
        return Unit.INSTANCE;
    }

    static final boolean getSectionDefs$lambda$10(View v) {
        Editable text;
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(v, "v");
        EditText editText = (EditText) v.findViewById(R.id.manaValueEditText);
        return (editText == null || (text = editText.getText()) == null || (string = text.toString()) == null || (string2 = StringsKt.trim((CharSequence) string).toString()) == null || string2.length() <= 0) ? false : true;
    }

    static final Unit getSectionDefs$lambda$11(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        EditText editText = (EditText) v.findViewById(R.id.manaValueEditText);
        if (editText != null) {
            editText.setText("");
        }
        Spinner spinner = (Spinner) v.findViewById(R.id.manaValueOperator);
        if (spinner != null) {
            spinner.setSelection(0);
        }
        return Unit.INSTANCE;
    }

    static final boolean getSectionDefs$lambda$12(View v) {
        Editable text;
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(v, "v");
        List listListOf = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.id.powerEditText), Integer.valueOf(R.id.toughnessEditText), Integer.valueOf(R.id.loyaltyEditText), Integer.valueOf(R.id.defenseEditText)});
        if ((listListOf instanceof Collection) && listListOf.isEmpty()) {
            return false;
        }
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            EditText editText = (EditText) v.findViewById(((Number) it.next()).intValue());
            if (editText != null && (text = editText.getText()) != null && (string = text.toString()) != null && (string2 = StringsKt.trim((CharSequence) string).toString()) != null && string2.length() > 0) {
                return true;
            }
        }
        return false;
    }

    static final Unit getSectionDefs$lambda$13(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        Iterator it = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.id.powerEditText), Integer.valueOf(R.id.toughnessEditText), Integer.valueOf(R.id.loyaltyEditText), Integer.valueOf(R.id.defenseEditText)}).iterator();
        while (it.hasNext()) {
            EditText editText = (EditText) v.findViewById(((Number) it.next()).intValue());
            if (editText != null) {
                editText.setText("");
            }
        }
        Iterator it2 = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.id.powerOperator), Integer.valueOf(R.id.toughnessOperator), Integer.valueOf(R.id.loyaltyOperator), Integer.valueOf(R.id.defenseOperator)}).iterator();
        while (it2.hasNext()) {
            Spinner spinner = (Spinner) v.findViewById(((Number) it2.next()).intValue());
            if (spinner != null) {
                spinner.setSelection(0);
            }
        }
        return Unit.INSTANCE;
    }

    static final boolean getSectionDefs$lambda$14(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, View v) {
        Editable text;
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(v, "v");
        if (unifiedFiltersBottomSheetFragment.selectedSetCode.length() > 0) {
            return true;
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) v.findViewById(R.id.setAutoComplete);
        return (autoCompleteTextView == null || (text = autoCompleteTextView.getText()) == null || (string = text.toString()) == null || (string2 = StringsKt.trim((CharSequence) string).toString()) == null || string2.length() <= 0) ? false : true;
    }

    static final Unit getSectionDefs$lambda$15(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        unifiedFiltersBottomSheetFragment.selectedSetCode = "";
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) v.findViewById(R.id.setAutoComplete);
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setText("");
        }
        return Unit.INSTANCE;
    }

    static final boolean getSectionDefs$lambda$16(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        Spinner spinner = (Spinner) v.findViewById(R.id.raritySpinner);
        return (spinner != null ? spinner.getSelectedItemPosition() : 0) > 0;
    }

    static final Unit getSectionDefs$lambda$17(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        Spinner spinner = (Spinner) v.findViewById(R.id.raritySpinner);
        if (spinner != null) {
            spinner.setSelection(0);
        }
        Spinner spinner2 = (Spinner) v.findViewById(R.id.rarityOperator);
        if (spinner2 != null) {
            spinner2.setSelection(0);
        }
        return Unit.INSTANCE;
    }

    static final boolean getSectionDefs$lambda$18(View v) {
        Editable text;
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(v, "v");
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) v.findViewById(R.id.keywordAutoComplete);
        return (autoCompleteTextView == null || (text = autoCompleteTextView.getText()) == null || (string = text.toString()) == null || (string2 = StringsKt.trim((CharSequence) string).toString()) == null || string2.length() <= 0) ? false : true;
    }

    static final Unit getSectionDefs$lambda$19(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) v.findViewById(R.id.keywordAutoComplete);
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setText("");
        }
        return Unit.INSTANCE;
    }

    static final boolean getSectionDefs$lambda$2(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        return !unifiedFiltersBottomSheetFragment.selectedColors.isEmpty();
    }

    static final boolean getSectionDefs$lambda$20(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        Spinner spinner = (Spinner) v.findViewById(R.id.layoutSpinner);
        return (spinner != null ? spinner.getSelectedItemPosition() : 0) > 0;
    }

    static final Unit getSectionDefs$lambda$21(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        Spinner spinner = (Spinner) v.findViewById(R.id.layoutSpinner);
        if (spinner != null) {
            spinner.setSelection(0);
        }
        return Unit.INSTANCE;
    }

    static final boolean getSectionDefs$lambda$22(View v) {
        Editable text;
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(v, "v");
        EditText editText = (EditText) v.findViewById(R.id.numberEditText);
        return (editText == null || (text = editText.getText()) == null || (string = text.toString()) == null || (string2 = StringsKt.trim((CharSequence) string).toString()) == null || string2.length() <= 0) ? false : true;
    }

    static final Unit getSectionDefs$lambda$23(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        EditText editText = (EditText) v.findViewById(R.id.numberEditText);
        if (editText != null) {
            editText.setText("");
        }
        return Unit.INSTANCE;
    }

    static final boolean getSectionDefs$lambda$24(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        Spinner spinner = (Spinner) v.findViewById(R.id.languageSpinner);
        return (spinner != null ? spinner.getSelectedItemPosition() : 0) > 0;
    }

    static final Unit getSectionDefs$lambda$25(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        Spinner spinner = (Spinner) v.findViewById(R.id.languageSpinner);
        if (spinner != null) {
            spinner.setSelection(0);
        }
        return Unit.INSTANCE;
    }

    static final boolean getSectionDefs$lambda$26(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        return (unifiedFiltersBottomSheetFragment.selectedLegal.isEmpty() && unifiedFiltersBottomSheetFragment.selectedBanned.isEmpty()) ? false : true;
    }

    static final Unit getSectionDefs$lambda$27(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        unifiedFiltersBottomSheetFragment.selectedLegal.clear();
        unifiedFiltersBottomSheetFragment.selectedBanned.clear();
        unifiedFiltersBottomSheetFragment.refreshToggleChips((FlexboxLayout) v.findViewById(R.id.legalChipsLayout), unifiedFiltersBottomSheetFragment.selectedLegal);
        unifiedFiltersBottomSheetFragment.refreshToggleChips((FlexboxLayout) v.findViewById(R.id.bannedChipsLayout), unifiedFiltersBottomSheetFragment.selectedBanned);
        return Unit.INSTANCE;
    }

    static final boolean getSectionDefs$lambda$28(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        return !unifiedFiltersBottomSheetFragment.selectedIsProps.isEmpty();
    }

    static final Unit getSectionDefs$lambda$29(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        unifiedFiltersBottomSheetFragment.selectedIsProps.clear();
        unifiedFiltersBottomSheetFragment.refreshToggleChips((FlexboxLayout) v.findViewById(R.id.isChipsLayout), unifiedFiltersBottomSheetFragment.selectedIsProps);
        return Unit.INSTANCE;
    }

    static final Unit getSectionDefs$lambda$3(final UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, final View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        unifiedFiltersBottomSheetFragment.selectedColors.clear();
        unifiedFiltersBottomSheetFragment.colorMode = com.revenuecat.purchases.common.Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
        unifiedFiltersBottomSheetFragment.updateColorHighlights(MapsKt.mapOf(TuplesKt.to(ExifInterface.LONGITUDE_WEST, v.findViewById(R.id.colorW)), TuplesKt.to("U", v.findViewById(R.id.colorU)), TuplesKt.to("B", v.findViewById(R.id.colorB)), TuplesKt.to("R", v.findViewById(R.id.colorR)), TuplesKt.to(GameUtils.CONDITION_GOOD, v.findViewById(R.id.colorG)), TuplesKt.to("C", v.findViewById(R.id.colorC))));
        unifiedFiltersBottomSheetFragment.setupModeToggle((TextView) v.findViewById(R.id.colorModeAny), (TextView) v.findViewById(R.id.colorModeExact), (TextView) v.findViewById(R.id.colorModeAtMost), com.revenuecat.purchases.common.Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda50
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$3$0(this.f$0, v, (String) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getSectionDefs$lambda$3$0(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, View view, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        unifiedFiltersBottomSheetFragment.colorMode = it;
        unifiedFiltersBottomSheetFragment.updateAllSectionStates(view);
        return Unit.INSTANCE;
    }

    static final boolean getSectionDefs$lambda$30(View v) {
        Editable text;
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(v, "v");
        EditText editText = (EditText) v.findViewById(R.id.priceEditText);
        return (editText == null || (text = editText.getText()) == null || (string = text.toString()) == null || (string2 = StringsKt.trim((CharSequence) string).toString()) == null || string2.length() <= 0) ? false : true;
    }

    static final Unit getSectionDefs$lambda$31(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        EditText editText = (EditText) v.findViewById(R.id.priceEditText);
        if (editText != null) {
            editText.setText("");
        }
        Spinner spinner = (Spinner) v.findViewById(R.id.priceOperator);
        if (spinner != null) {
            spinner.setSelection(0);
        }
        return Unit.INSTANCE;
    }

    static final boolean getSectionDefs$lambda$32(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        return (unifiedFiltersBottomSheetFragment.alteredState == null && unifiedFiltersBottomSheetFragment.misprintState == null && unifiedFiltersBottomSheetFragment.signedState == null && unifiedFiltersBottomSheetFragment.proxyState == null && unifiedFiltersBottomSheetFragment.inDeckState == null) ? false : true;
    }

    static final Unit getSectionDefs$lambda$33(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        unifiedFiltersBottomSheetFragment.alteredState = null;
        unifiedFiltersBottomSheetFragment.misprintState = null;
        unifiedFiltersBottomSheetFragment.signedState = null;
        unifiedFiltersBottomSheetFragment.proxyState = null;
        unifiedFiltersBottomSheetFragment.inDeckState = null;
        unifiedFiltersBottomSheetFragment.setupCollectionToggles(v);
        return Unit.INSTANCE;
    }

    static final boolean getSectionDefs$lambda$4(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        return !unifiedFiltersBottomSheetFragment.selectedIdentity.isEmpty();
    }

    static final Unit getSectionDefs$lambda$5(final UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, final View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        unifiedFiltersBottomSheetFragment.selectedIdentity.clear();
        unifiedFiltersBottomSheetFragment.identityMode = "<=";
        unifiedFiltersBottomSheetFragment.updateIdentityHighlights(MapsKt.mapOf(TuplesKt.to(ExifInterface.LONGITUDE_WEST, v.findViewById(R.id.identityW)), TuplesKt.to("U", v.findViewById(R.id.identityU)), TuplesKt.to("B", v.findViewById(R.id.identityB)), TuplesKt.to("R", v.findViewById(R.id.identityR)), TuplesKt.to(GameUtils.CONDITION_GOOD, v.findViewById(R.id.identityG)), TuplesKt.to("C", v.findViewById(R.id.identityC))));
        unifiedFiltersBottomSheetFragment.setupModeToggle((TextView) v.findViewById(R.id.identityModeAtMost), (TextView) v.findViewById(R.id.identityModeExact), (TextView) v.findViewById(R.id.identityModeAny), "<=", new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda56
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnifiedFiltersBottomSheetFragment.getSectionDefs$lambda$5$0(this.f$0, v, (String) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getSectionDefs$lambda$5$0(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, View view, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        unifiedFiltersBottomSheetFragment.identityMode = it;
        unifiedFiltersBottomSheetFragment.updateAllSectionStates(view);
        return Unit.INSTANCE;
    }

    static final boolean getSectionDefs$lambda$6(View v) {
        Editable text;
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(v, "v");
        EditText editText = (EditText) v.findViewById(R.id.typeEditText);
        return (editText == null || (text = editText.getText()) == null || (string = text.toString()) == null || (string2 = StringsKt.trim((CharSequence) string).toString()) == null || string2.length() <= 0) ? false : true;
    }

    static final Unit getSectionDefs$lambda$7(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        EditText editText = (EditText) v.findViewById(R.id.typeEditText);
        if (editText != null) {
            editText.setText("");
        }
        return Unit.INSTANCE;
    }

    static final boolean getSectionDefs$lambda$8(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, View v) {
        Editable text;
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(v, "v");
        if (!unifiedFiltersBottomSheetFragment.oracleClauses.isEmpty()) {
            return true;
        }
        EditText editText = (EditText) v.findViewById(R.id.oracleEditText);
        return (editText == null || (text = editText.getText()) == null || (string = text.toString()) == null || (string2 = StringsKt.trim((CharSequence) string).toString()) == null || string2.length() <= 0) ? false : true;
    }

    static final Unit getSectionDefs$lambda$9(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        unifiedFiltersBottomSheetFragment.oracleClauses.clear();
        FlexboxLayout flexboxLayout = (FlexboxLayout) v.findViewById(R.id.oracleTagsLayout);
        if (flexboxLayout != null) {
            flexboxLayout.removeAllViews();
        }
        EditText editText = (EditText) v.findViewById(R.id.oracleEditText);
        if (editText != null) {
            editText.setText("");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0$0(Dialog dialog, UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, DialogInterface dialogInterface) {
        View viewFindViewById = dialog.findViewById(com.google.android.material.R.id.design_bottom_sheet);
        FrameLayout frameLayout = viewFindViewById instanceof FrameLayout ? (FrameLayout) viewFindViewById : null;
        if (frameLayout != null) {
            frameLayout.setBackgroundResource(android.R.color.transparent);
            BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(frameLayout);
            Intrinsics.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "from(...)");
            int i = (int) (((double) unifiedFiltersBottomSheetFragment.getResources().getDisplayMetrics().heightPixels) * 0.9d);
            frameLayout.getLayoutParams().height = i;
            bottomSheetBehaviorFrom.setPeekHeight(i);
            bottomSheetBehaviorFrom.setState(3);
            bottomSheetBehaviorFrom.setSkipCollapsed(true);
        }
    }

    private final void parseAndPopulate(View view, String query) {
        SearchElement searchQuery = SearchDataUtils.INSTANCE.getInstance().parseSearchQuery(query);
        if (searchQuery instanceof SearchGroup) {
            for (SearchElement searchElement : ((SearchGroup) searchQuery).getElements()) {
                if (searchElement instanceof SearchCondition) {
                    populateFromCondition(view, (SearchCondition) searchElement);
                }
            }
        }
    }

    private final Boolean parseBooleanValue(String value) {
        String lowerCase = value.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int iHashCode = lowerCase.hashCode();
        if (iHashCode != 48) {
            if (iHashCode != 49) {
                if (iHashCode != 102) {
                    if (iHashCode != 110) {
                        if (iHashCode != 116) {
                            if (iHashCode != 121) {
                                if (iHashCode != 3521) {
                                    if (iHashCode != 119527) {
                                        if (iHashCode != 3569038) {
                                            if (iHashCode != 97196323 || !lowerCase.equals(CredentialEntry.FALSE_STRING)) {
                                                return null;
                                            }
                                        } else if (!lowerCase.equals("true")) {
                                            return null;
                                        }
                                    } else if (!lowerCase.equals("yes")) {
                                        return null;
                                    }
                                } else if (!lowerCase.equals(SVGParser.XML_STYLESHEET_ATTR_ALTERNATE_NO)) {
                                    return null;
                                }
                            } else if (!lowerCase.equals("y")) {
                                return null;
                            }
                        } else if (!lowerCase.equals("t")) {
                            return null;
                        }
                    } else if (!lowerCase.equals("n")) {
                        return null;
                    }
                } else if (!lowerCase.equals("f")) {
                    return null;
                }
            } else if (!lowerCase.equals("1")) {
                return null;
            }
            return true;
        }
        if (!lowerCase.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            return null;
        }
        return false;
    }

    private final void populateFromCondition(View view, SearchCondition cond) {
        FlexboxLayout flexboxLayout;
        Spinner spinner;
        Spinner spinner2;
        Spinner spinner3;
        switch (WhenMappings.$EnumSwitchMapping$1[cond.getKeyword().ordinal()]) {
            case 1:
                EditText editText = (EditText) view.findViewById(R.id.nameEditText);
                if (editText != null) {
                    editText.setText(cond.getValue());
                }
                break;
            case 2:
                List<String> listMapColorValueToIndividualColors = SearchDataUtils.INSTANCE.getInstance().mapColorValueToIndividualColors(cond.getValue());
                if (StringsKt.equals(cond.getValue(), "colorless", true)) {
                    this.selectedColors.add("C");
                } else {
                    Iterator<T> it = listMapColorValueToIndividualColors.iterator();
                    while (it.hasNext()) {
                        this.selectedColors.add((String) it.next());
                    }
                }
                this.colorMode = cond.getOperator().getSymbol();
                updateColorHighlights(MapsKt.mapOf(TuplesKt.to(ExifInterface.LONGITUDE_WEST, view.findViewById(R.id.colorW)), TuplesKt.to("U", view.findViewById(R.id.colorU)), TuplesKt.to("B", view.findViewById(R.id.colorB)), TuplesKt.to("R", view.findViewById(R.id.colorR)), TuplesKt.to(GameUtils.CONDITION_GOOD, view.findViewById(R.id.colorG)), TuplesKt.to("C", view.findViewById(R.id.colorC))));
                break;
            case 3:
                List<String> listMapColorValueToIndividualColors2 = SearchDataUtils.INSTANCE.getInstance().mapColorValueToIndividualColors(cond.getValue());
                if (StringsKt.equals(cond.getValue(), "colorless", true)) {
                    this.selectedIdentity.add("C");
                } else {
                    Iterator<T> it2 = listMapColorValueToIndividualColors2.iterator();
                    while (it2.hasNext()) {
                        this.selectedIdentity.add((String) it2.next());
                    }
                }
                this.identityMode = cond.getOperator().getSymbol();
                updateIdentityHighlights(MapsKt.mapOf(TuplesKt.to(ExifInterface.LONGITUDE_WEST, view.findViewById(R.id.identityW)), TuplesKt.to("U", view.findViewById(R.id.identityU)), TuplesKt.to("B", view.findViewById(R.id.identityB)), TuplesKt.to("R", view.findViewById(R.id.identityR)), TuplesKt.to(GameUtils.CONDITION_GOOD, view.findViewById(R.id.identityG)), TuplesKt.to("C", view.findViewById(R.id.identityC))));
                break;
            case 4:
                EditText editText2 = (EditText) view.findViewById(R.id.typeEditText);
                if (editText2 != null) {
                    editText2.setText(cond.getValue());
                }
                break;
            case 5:
                Context context = getContext();
                if (context != null && (flexboxLayout = (FlexboxLayout) view.findViewById(R.id.oracleTagsLayout)) != null) {
                    this.oracleClauses.add(cond.getValue());
                    addOracleChip(context, flexboxLayout, cond.getValue(), view);
                }
                break;
            case 6:
                setNumericField(view, R.id.manaValueOperator, R.id.manaValueEditText, cond);
                break;
            case 7:
                setNumericField(view, R.id.powerOperator, R.id.powerEditText, cond);
                break;
            case 8:
                setNumericField(view, R.id.toughnessOperator, R.id.toughnessEditText, cond);
                break;
            case 9:
                setNumericField(view, R.id.loyaltyOperator, R.id.loyaltyEditText, cond);
                break;
            case 10:
                setNumericField(view, R.id.defenseOperator, R.id.defenseEditText, cond);
                break;
            case 11:
                this.selectedSetCode = cond.getValue();
                AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) view.findViewById(R.id.setAutoComplete);
                if (autoCompleteTextView != null) {
                    autoCompleteTextView.setText((CharSequence) cond.getValue(), false);
                }
                break;
            case 12:
                List listListOf = CollectionsKt.listOf((Object[]) new String[]{"", "c", "u", "r", "m", "s", "b"});
                String lowerCase = cond.getValue().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                int iIndexOf = listListOf.indexOf(lowerCase);
                if (iIndexOf >= 0 && (spinner = (Spinner) view.findViewById(R.id.raritySpinner)) != null) {
                    spinner.setSelection(iIndexOf);
                }
                setOperatorSpinner((Spinner) view.findViewById(R.id.rarityOperator), cond.getOperator());
                break;
            case 13:
                AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) view.findViewById(R.id.keywordAutoComplete);
                if (autoCompleteTextView2 != null) {
                    autoCompleteTextView2.setText((CharSequence) cond.getValue(), false);
                }
                break;
            case 14:
                int iIndexOf2 = CollectionsKt.plus((Collection) CollectionsKt.listOf(""), (Iterable) SearchDataUtils.INSTANCE.getInstance().getLayoutTypes()).indexOf(cond.getValue());
                if (iIndexOf2 >= 0 && (spinner2 = (Spinner) view.findViewById(R.id.layoutSpinner)) != null) {
                    spinner2.setSelection(iIndexOf2);
                    break;
                }
                break;
            case 15:
                EditText editText3 = (EditText) view.findViewById(R.id.numberEditText);
                if (editText3 != null) {
                    editText3.setText(cond.getValue());
                }
                break;
            case 16:
                int iIndexOf3 = CollectionsKt.listOf((Object[]) new String[]{"", "en", "fr", "es", "de", "it", "pt", "ja", "ko", "zht", "zhs", "ru"}).indexOf(cond.getValue());
                if (iIndexOf3 >= 0 && (spinner3 = (Spinner) view.findViewById(R.id.languageSpinner)) != null) {
                    spinner3.setSelection(iIndexOf3);
                    break;
                }
                break;
            case 17:
                Set<String> set = this.selectedLegal;
                String lowerCase2 = cond.getValue().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                set.add(lowerCase2);
                refreshToggleChips((FlexboxLayout) view.findViewById(R.id.legalChipsLayout), this.selectedLegal);
                break;
            case 18:
                Set<String> set2 = this.selectedBanned;
                String lowerCase3 = cond.getValue().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                set2.add(lowerCase3);
                refreshToggleChips((FlexboxLayout) view.findViewById(R.id.bannedChipsLayout), this.selectedBanned);
                break;
            case 19:
                Set<String> set3 = this.selectedIsProps;
                String lowerCase4 = cond.getValue().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                set3.add(lowerCase4);
                refreshToggleChips((FlexboxLayout) view.findViewById(R.id.isChipsLayout), this.selectedIsProps);
                break;
            case 20:
                setNumericField(view, R.id.priceOperator, R.id.priceEditText, cond);
                break;
            case 21:
                this.alteredState = parseBooleanValue(cond.getValue());
                break;
            case 22:
                this.misprintState = parseBooleanValue(cond.getValue());
                break;
            case 23:
                this.signedState = parseBooleanValue(cond.getValue());
                break;
            case 24:
                this.proxyState = parseBooleanValue(cond.getValue());
                break;
            case 25:
                this.inDeckState = parseBooleanValue(cond.getValue());
                break;
        }
    }

    private final void refreshToggleChips(FlexboxLayout layout, Set<String> selectedSet) {
        Context context;
        if (layout == null || (context = getContext()) == null) {
            return;
        }
        int childCount = layout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = layout.getChildAt(i);
            TextView textView = childAt instanceof TextView ? (TextView) childAt : null;
            if (textView != null) {
                Object tag = textView.getTag();
                String str = tag instanceof String ? (String) tag : null;
                if (str != null) {
                    updateToggleChipStyle(textView, context, selectedSet.contains(str));
                }
            }
        }
    }

    private final void setNumericField(View view, int spinnerId, int editTextId, SearchCondition cond) {
        EditText editText = (EditText) view.findViewById(editTextId);
        if (editText != null) {
            editText.setText(cond.getValue());
        }
        setOperatorSpinner((Spinner) view.findViewById(spinnerId), cond.getOperator());
    }

    private final void setOperatorSpinner(Spinner spinner, Operator operator) {
        int iIndexOf;
        if (spinner != null && (iIndexOf = CollectionsKt.listOf((Object[]) new String[]{"=", "!=", "<", "<=", ">", ">="}).indexOf(operator.getSymbol())) >= 0) {
            spinner.setSelection(iIndexOf);
        }
    }

    private final void setupButtons(final View view) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.clearButton);
        if (materialButton != null) {
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda48
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    UnifiedFiltersBottomSheetFragment.setupButtons$lambda$0(this.f$0, view, view2);
                }
            });
        }
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.applyButton);
        if (materialButton2 != null) {
            materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda49
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    UnifiedFiltersBottomSheetFragment.setupButtons$lambda$1(this.f$0, view, view2);
                }
            });
        }
    }

    static final void setupButtons$lambda$0(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, View view, View view2) {
        unifiedFiltersBottomSheetFragment.clearAll(view);
        if (unifiedFiltersBottomSheetFragment.mode == FilterMode.SEARCH) {
            unifiedFiltersBottomSheetFragment.selectedFillGap = null;
            UnifiedFiltersListener unifiedFiltersListener = unifiedFiltersBottomSheetFragment.listener;
            MythicPlusSearchFragment mythicPlusSearchFragment = unifiedFiltersListener instanceof MythicPlusSearchFragment ? (MythicPlusSearchFragment) unifiedFiltersListener : null;
            if (mythicPlusSearchFragment != null) {
                mythicPlusSearchFragment.onFiltersApplied("", null);
            }
        } else {
            UnifiedFiltersListener unifiedFiltersListener2 = unifiedFiltersBottomSheetFragment.listener;
            if (unifiedFiltersListener2 != null) {
                unifiedFiltersListener2.onFiltersApplied("");
            }
        }
        unifiedFiltersBottomSheetFragment.dismiss();
    }

    static final void setupButtons$lambda$1(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, View view, View view2) {
        String strBuildScryfallQuery = unifiedFiltersBottomSheetFragment.buildScryfallQuery(view);
        if (unifiedFiltersBottomSheetFragment.mode == FilterMode.SEARCH) {
            UnifiedFiltersListener unifiedFiltersListener = unifiedFiltersBottomSheetFragment.listener;
            MythicPlusSearchFragment mythicPlusSearchFragment = unifiedFiltersListener instanceof MythicPlusSearchFragment ? (MythicPlusSearchFragment) unifiedFiltersListener : null;
            if (mythicPlusSearchFragment != null) {
                mythicPlusSearchFragment.onFiltersApplied(strBuildScryfallQuery, unifiedFiltersBottomSheetFragment.selectedFillGap);
            }
        } else {
            UnifiedFiltersListener unifiedFiltersListener2 = unifiedFiltersBottomSheetFragment.listener;
            if (unifiedFiltersListener2 != null) {
                unifiedFiltersListener2.onFiltersApplied(strBuildScryfallQuery);
            }
        }
        unifiedFiltersBottomSheetFragment.dismiss();
    }

    private final void setupCollectionToggles(final View view) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        View viewFindViewById = view.findViewById(R.id.alteredRow);
        String string = context.getString(R.string.filter_altered);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        setupTristateRow(viewFindViewById, string, this.alteredState, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda41
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnifiedFiltersBottomSheetFragment.setupCollectionToggles$lambda$0(this.f$0, view, (Boolean) obj);
            }
        });
        View viewFindViewById2 = view.findViewById(R.id.misprintRow);
        String string2 = context.getString(R.string.filter_misprint);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        setupTristateRow(viewFindViewById2, string2, this.misprintState, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda42
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnifiedFiltersBottomSheetFragment.setupCollectionToggles$lambda$1(this.f$0, view, (Boolean) obj);
            }
        });
        View viewFindViewById3 = view.findViewById(R.id.signedRow);
        String string3 = context.getString(R.string.filter_signed);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        setupTristateRow(viewFindViewById3, string3, this.signedState, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda43
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnifiedFiltersBottomSheetFragment.setupCollectionToggles$lambda$2(this.f$0, view, (Boolean) obj);
            }
        });
        View viewFindViewById4 = view.findViewById(R.id.proxyRow);
        String string4 = context.getString(R.string.filter_proxy);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        setupTristateRow(viewFindViewById4, string4, this.proxyState, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda45
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnifiedFiltersBottomSheetFragment.setupCollectionToggles$lambda$3(this.f$0, view, (Boolean) obj);
            }
        });
        View viewFindViewById5 = view.findViewById(R.id.inDeckRow);
        String string5 = context.getString(R.string.filter_in_deck);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        setupTristateRow(viewFindViewById5, string5, this.inDeckState, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda46
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnifiedFiltersBottomSheetFragment.setupCollectionToggles$lambda$4(this.f$0, view, (Boolean) obj);
            }
        });
    }

    static final Unit setupCollectionToggles$lambda$0(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, View view, Boolean bool) {
        unifiedFiltersBottomSheetFragment.alteredState = bool;
        unifiedFiltersBottomSheetFragment.updateAllSectionStates(view);
        return Unit.INSTANCE;
    }

    static final Unit setupCollectionToggles$lambda$1(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, View view, Boolean bool) {
        unifiedFiltersBottomSheetFragment.misprintState = bool;
        unifiedFiltersBottomSheetFragment.updateAllSectionStates(view);
        return Unit.INSTANCE;
    }

    static final Unit setupCollectionToggles$lambda$2(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, View view, Boolean bool) {
        unifiedFiltersBottomSheetFragment.signedState = bool;
        unifiedFiltersBottomSheetFragment.updateAllSectionStates(view);
        return Unit.INSTANCE;
    }

    static final Unit setupCollectionToggles$lambda$3(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, View view, Boolean bool) {
        unifiedFiltersBottomSheetFragment.proxyState = bool;
        unifiedFiltersBottomSheetFragment.updateAllSectionStates(view);
        return Unit.INSTANCE;
    }

    static final Unit setupCollectionToggles$lambda$4(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, View view, Boolean bool) {
        unifiedFiltersBottomSheetFragment.inDeckState = bool;
        unifiedFiltersBottomSheetFragment.updateAllSectionStates(view);
        return Unit.INSTANCE;
    }

    private final void setupColorSection(final View view) {
        if (getContext() == null) {
            return;
        }
        final Map mapMapOf = MapsKt.mapOf(TuplesKt.to(ExifInterface.LONGITUDE_WEST, view.findViewById(R.id.colorW)), TuplesKt.to("U", view.findViewById(R.id.colorU)), TuplesKt.to("B", view.findViewById(R.id.colorB)), TuplesKt.to("R", view.findViewById(R.id.colorR)), TuplesKt.to(GameUtils.CONDITION_GOOD, view.findViewById(R.id.colorG)), TuplesKt.to("C", view.findViewById(R.id.colorC)));
        for (Map.Entry entry : mapMapOf.entrySet()) {
            final String str = (String) entry.getKey();
            View view2 = (View) entry.getValue();
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda37
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        UnifiedFiltersBottomSheetFragment.setupColorSection$lambda$0$0(str, this, mapMapOf, view, view3);
                    }
                });
            }
        }
        setupModeToggle((TextView) view.findViewById(R.id.colorModeAny), (TextView) view.findViewById(R.id.colorModeExact), (TextView) view.findViewById(R.id.colorModeAtMost), com.revenuecat.purchases.common.Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda38
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnifiedFiltersBottomSheetFragment.setupColorSection$lambda$1(this.f$0, view, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupColorSection$lambda$0$0(String str, UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, Map map, View view, View view2) {
        if (Intrinsics.areEqual(str, "C")) {
            unifiedFiltersBottomSheetFragment.selectedColors.clear();
            unifiedFiltersBottomSheetFragment.selectedColors.add("C");
        } else {
            unifiedFiltersBottomSheetFragment.selectedColors.remove("C");
            if (unifiedFiltersBottomSheetFragment.selectedColors.contains(str)) {
                unifiedFiltersBottomSheetFragment.selectedColors.remove(str);
            } else {
                unifiedFiltersBottomSheetFragment.selectedColors.add(str);
            }
        }
        unifiedFiltersBottomSheetFragment.updateColorHighlights(map);
        unifiedFiltersBottomSheetFragment.updateAllSectionStates(view);
    }

    static final Unit setupColorSection$lambda$1(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, View view, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        unifiedFiltersBottomSheetFragment.colorMode = it;
        unifiedFiltersBottomSheetFragment.updateAllSectionStates(view);
        return Unit.INSTANCE;
    }

    private final void setupIcons(View view) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        Typeface font = ResourcesCompat.getFont(context, R.font.fa6solid);
        setupIcons$setIcon(view, font, R.id.iconName, this.FA_FONT);
        setupIcons$setIcon(view, font, R.id.iconColors, this.FA_PALETTE);
        setupIcons$setIcon(view, font, R.id.iconIdentity, this.FA_ID_CARD);
        setupIcons$setIcon(view, font, R.id.iconType, this.FA_SHAPES);
        setupIcons$setIcon(view, font, R.id.iconOracle, this.FA_SCROLL);
        setupIcons$setIcon(view, font, R.id.iconManaValue, this.FA_HASHTAG);
        setupIcons$setIcon(view, font, R.id.iconStats, this.FA_BOLT);
        setupIcons$setIcon(view, font, R.id.iconSet, this.FA_LAYER_GROUP);
        setupIcons$setIcon(view, font, R.id.iconRarity, this.FA_GEM);
        setupIcons$setIcon(view, font, R.id.iconKeyword, this.FA_KEY);
        setupIcons$setIcon(view, font, R.id.iconLayout, this.FA_COLUMNS);
        setupIcons$setIcon(view, font, R.id.iconNumber, this.FA_BARCODE);
        setupIcons$setIcon(view, font, R.id.iconLanguage, this.FA_GLOBE);
        setupIcons$setIcon(view, font, R.id.iconLegalities, this.FA_GAVEL);
        setupIcons$setIcon(view, font, R.id.iconIs, this.FA_CHECK_CIRCLE);
        setupIcons$setIcon(view, font, R.id.iconPrice, this.FA_DOLLAR);
        setupIcons$setIcon(view, font, R.id.iconCollection, this.FA_BOX);
    }

    private static final void setupIcons$setIcon(View view, Typeface typeface, int i, String str) {
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            textView.setTypeface(typeface);
            textView.setText(str);
        }
    }

    private final void setupIdentitySection(final View view) {
        final Map mapMapOf = MapsKt.mapOf(TuplesKt.to(ExifInterface.LONGITUDE_WEST, view.findViewById(R.id.identityW)), TuplesKt.to("U", view.findViewById(R.id.identityU)), TuplesKt.to("B", view.findViewById(R.id.identityB)), TuplesKt.to("R", view.findViewById(R.id.identityR)), TuplesKt.to(GameUtils.CONDITION_GOOD, view.findViewById(R.id.identityG)), TuplesKt.to("C", view.findViewById(R.id.identityC)));
        for (Map.Entry entry : mapMapOf.entrySet()) {
            final String str = (String) entry.getKey();
            View view2 = (View) entry.getValue();
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda33
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        UnifiedFiltersBottomSheetFragment.setupIdentitySection$lambda$0$0(str, this, mapMapOf, view, view3);
                    }
                });
            }
        }
        setupModeToggle((TextView) view.findViewById(R.id.identityModeAtMost), (TextView) view.findViewById(R.id.identityModeExact), (TextView) view.findViewById(R.id.identityModeAny), "<=", new Function1() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda44
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnifiedFiltersBottomSheetFragment.setupIdentitySection$lambda$1(this.f$0, view, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupIdentitySection$lambda$0$0(String str, UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, Map map, View view, View view2) {
        if (Intrinsics.areEqual(str, "C")) {
            unifiedFiltersBottomSheetFragment.selectedIdentity.clear();
            unifiedFiltersBottomSheetFragment.selectedIdentity.add("C");
        } else {
            unifiedFiltersBottomSheetFragment.selectedIdentity.remove("C");
            if (unifiedFiltersBottomSheetFragment.selectedIdentity.contains(str)) {
                unifiedFiltersBottomSheetFragment.selectedIdentity.remove(str);
            } else {
                unifiedFiltersBottomSheetFragment.selectedIdentity.add(str);
            }
        }
        unifiedFiltersBottomSheetFragment.updateIdentityHighlights(map);
        unifiedFiltersBottomSheetFragment.updateAllSectionStates(view);
    }

    static final Unit setupIdentitySection$lambda$1(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, View view, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        unifiedFiltersBottomSheetFragment.identityMode = it;
        unifiedFiltersBottomSheetFragment.updateAllSectionStates(view);
        return Unit.INSTANCE;
    }

    private final void setupIsChips(final View view) {
        FlexboxLayout flexboxLayout;
        String str;
        Context context = getContext();
        if (context == null || (flexboxLayout = (FlexboxLayout) view.findViewById(R.id.isChipsLayout)) == null) {
            return;
        }
        for (String str2 : this.isProperties) {
            String string = this.isPropertyLabels.get(str2);
            if (string != null) {
                str = string;
            } else if (str2.length() > 0) {
                StringBuilder sb = new StringBuilder();
                String strValueOf = String.valueOf(str2.charAt(0));
                Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
                String upperCase = strValueOf.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                StringBuilder sbAppend = sb.append((Object) upperCase);
                String strSubstring = str2.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                string = sbAppend.append(strSubstring).toString();
                str = string;
            } else {
                str = str2;
            }
            UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment = this;
            flexboxLayout.addView(unifiedFiltersBottomSheetFragment.createToggleChip(context, str, this.selectedIsProps, str2, new Function0() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda58
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return UnifiedFiltersBottomSheetFragment.setupIsChips$lambda$0$1(this.f$0, view);
                }
            }));
            this = unifiedFiltersBottomSheetFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupIsChips$lambda$0$1(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, View view) {
        unifiedFiltersBottomSheetFragment.updateAllSectionStates(view);
        return Unit.INSTANCE;
    }

    private final void setupKeywordAutoComplete(View view) {
        AutoCompleteTextView autoCompleteTextView;
        Context context = getContext();
        if (context == null || (autoCompleteTextView = (AutoCompleteTextView) view.findViewById(R.id.keywordAutoComplete)) == null) {
            return;
        }
        Map<String, String> keywords = SearchDataUtils.INSTANCE.getInstance().getKeywords();
        autoCompleteTextView.setAdapter(new ArrayAdapter(context, android.R.layout.simple_dropdown_item_1line, CollectionsKt.sorted(Intrinsics.areEqual(this.lang, "fr") ? keywords.values() : keywords.keySet())));
        autoCompleteTextView.setInputType(524288);
        autoCompleteTextView.setImportantForAutofill(2);
        autoCompleteTextView.setThreshold(1);
    }

    private final void setupLanguageSpinner(View view) {
        Spinner spinner;
        Context context = getContext();
        if (context == null || (spinner = (Spinner) view.findViewById(R.id.languageSpinner)) == null) {
            return;
        }
        CollectionsKt.listOf((Object[]) new String[]{"", "en", "fr", "es", "de", "it", "pt", "ja", "ko", "zht", "zhs", "ru"});
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.filter_spinner_item, CollectionsKt.listOf((Object[]) new String[]{"—", "English", "Français", "Español", "Deutsch", "Italiano", "Português", "日本語", "한국어", "繁體中文", "简体中文", "Русский"}));
        arrayAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
    }

    private final void setupLayoutSpinner(View view) {
        Spinner spinner;
        Context context = getContext();
        if (context == null || (spinner = (Spinner) view.findViewById(R.id.layoutSpinner)) == null) {
            return;
        }
        List<String> listPlus = CollectionsKt.plus((Collection) CollectionsKt.listOf(""), (Iterable) SearchDataUtils.INSTANCE.getInstance().getLayoutTypes());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listPlus, 10));
        for (String str : listPlus) {
            arrayList.add(str.length() == 0 ? "—" : SearchDataUtils.INSTANCE.getInstance().transformLayout(str, this.lang));
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.filter_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
    }

    private final void setupLegalityChips(final View view) {
        FlexboxLayout flexboxLayout;
        FlexboxLayout flexboxLayout2;
        String string;
        String string2;
        final UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment = this;
        Context context = unifiedFiltersBottomSheetFragment.getContext();
        if (context == null || (flexboxLayout = (FlexboxLayout) view.findViewById(R.id.legalChipsLayout)) == null || (flexboxLayout2 = (FlexboxLayout) view.findViewById(R.id.bannedChipsLayout)) == null) {
            return;
        }
        for (String str : unifiedFiltersBottomSheetFragment.formats) {
            String str2 = str;
            if (str2.length() > 0) {
                StringBuilder sb = new StringBuilder();
                String strValueOf = String.valueOf(str.charAt(0));
                Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
                String upperCase = strValueOf.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                StringBuilder sbAppend = sb.append((Object) upperCase);
                String strSubstring = str.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                string = sbAppend.append(strSubstring).toString();
            } else {
                string = str;
            }
            flexboxLayout.addView(unifiedFiltersBottomSheetFragment.createToggleChip(context, string, unifiedFiltersBottomSheetFragment.selectedLegal, str, new Function0() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return UnifiedFiltersBottomSheetFragment.setupLegalityChips$lambda$0$1(this.f$0, view);
                }
            }));
            if (str2.length() > 0) {
                StringBuilder sb2 = new StringBuilder();
                String strValueOf2 = String.valueOf(str.charAt(0));
                Intrinsics.checkNotNull(strValueOf2, "null cannot be cast to non-null type java.lang.String");
                String upperCase2 = strValueOf2.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                StringBuilder sbAppend2 = sb2.append((Object) upperCase2);
                String strSubstring2 = str.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                string2 = sbAppend2.append(strSubstring2).toString();
            } else {
                string2 = str;
            }
            flexboxLayout2.addView(unifiedFiltersBottomSheetFragment.createToggleChip(context, string2, unifiedFiltersBottomSheetFragment.selectedBanned, str, new Function0() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return UnifiedFiltersBottomSheetFragment.setupLegalityChips$lambda$0$3(this.f$0, view);
                }
            }));
            unifiedFiltersBottomSheetFragment = this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupLegalityChips$lambda$0$1(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, View view) {
        unifiedFiltersBottomSheetFragment.updateAllSectionStates(view);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupLegalityChips$lambda$0$3(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, View view) {
        unifiedFiltersBottomSheetFragment.updateAllSectionStates(view);
        return Unit.INSTANCE;
    }

    private final void setupModeToggle(TextView btn1, TextView btn2, TextView btn3, String defaultOp, Function1<? super String, Unit> onSelected) {
        int i = 0;
        final List listListOf = Intrinsics.areEqual(defaultOp, "<=") ? CollectionsKt.listOf((Object[]) new String[]{"<=", "=", com.revenuecat.purchases.common.Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}) : Intrinsics.areEqual(defaultOp, "=") ? CollectionsKt.listOf((Object[]) new String[]{"=", com.revenuecat.purchases.common.Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, "<="}) : CollectionsKt.listOf((Object[]) new String[]{com.revenuecat.purchases.common.Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, "=", "<="});
        final List listListOf2 = CollectionsKt.listOf((Object[]) new TextView[]{btn1, btn2, btn3});
        final Context context = getContext();
        if (context == null) {
            return;
        }
        final Function1<? super String, Unit> function1 = onSelected;
        setupModeToggle$select(listListOf2, function1, listListOf, context, 0);
        Iterator it = listListOf2.iterator();
        while (true) {
            final int i2 = i;
            if (!it.hasNext()) {
                return;
            }
            Object next = it.next();
            i = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TextView textView = (TextView) next;
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda51
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        UnifiedFiltersBottomSheetFragment.setupModeToggle$select(listListOf2, function1, listListOf, context, i2);
                    }
                });
            }
            function1 = onSelected;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupModeToggle$select(List<? extends TextView> list, Function1<? super String, Unit> function1, List<String> list2, Context context, int i) {
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TextView textView = (TextView) obj;
            if (i2 == i) {
                if (textView != null) {
                    textView.setTextColor(ContextCompat.getColor(context, R.color.almost_white));
                }
                if (textView != null) {
                    textView.setBackgroundResource(R.drawable.selected_chip_background);
                }
            } else {
                if (textView != null) {
                    textView.setTextColor(ContextCompat.getColor(context, R.color.light_grey));
                }
                if (textView != null) {
                    textView.setBackgroundResource(R.drawable.unselected_chip_background);
                }
            }
            i2 = i3;
        }
        function1.invoke(list2.get(i));
    }

    private final void setupNumericSpinners(View view) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{"=", "!=", "<", "<=", ">", ">="});
        setupNumericSpinners$setupSpinner(view, context, listListOf, R.id.manaValueOperator);
        setupNumericSpinners$setupSpinner(view, context, listListOf, R.id.powerOperator);
        setupNumericSpinners$setupSpinner(view, context, listListOf, R.id.toughnessOperator);
        setupNumericSpinners$setupSpinner(view, context, listListOf, R.id.loyaltyOperator);
        setupNumericSpinners$setupSpinner(view, context, listListOf, R.id.defenseOperator);
        setupNumericSpinners$setupSpinner(view, context, listListOf, R.id.priceOperator);
        setupNumericSpinners$setupSpinner(view, context, listListOf, R.id.rarityOperator);
    }

    private static final void setupNumericSpinners$setupSpinner(View view, Context context, List<String> list, int i) {
        Spinner spinner = (Spinner) view.findViewById(i);
        if (spinner != null) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.filter_spinner_item, list);
            arrayAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
            spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        }
    }

    private final void setupOracleSection(final View view) {
        final EditText editText;
        MaterialButton materialButton;
        final FlexboxLayout flexboxLayout;
        final Context context = getContext();
        if (context == null || (editText = (EditText) view.findViewById(R.id.oracleEditText)) == null || (materialButton = (MaterialButton) view.findViewById(R.id.oracleAddButton)) == null || (flexboxLayout = (FlexboxLayout) view.findViewById(R.id.oracleTagsLayout)) == null) {
            return;
        }
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda52
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UnifiedFiltersBottomSheetFragment.setupOracleSection$lambda$0(editText, this, context, flexboxLayout, view, view2);
            }
        });
    }

    static final void setupOracleSection$lambda$0(EditText editText, UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, Context context, FlexboxLayout flexboxLayout, View view, View view2) {
        String string = StringsKt.trim((CharSequence) editText.getText().toString()).toString();
        if (string.length() > 0) {
            unifiedFiltersBottomSheetFragment.oracleClauses.add(string);
            unifiedFiltersBottomSheetFragment.addOracleChip(context, flexboxLayout, string, view);
            editText.setText("");
            unifiedFiltersBottomSheetFragment.updateAllSectionStates(view);
        }
    }

    private final void setupRaritySection(View view) {
        Spinner spinner;
        Context context = getContext();
        if (context == null || (spinner = (Spinner) view.findViewById(R.id.raritySpinner)) == null) {
            return;
        }
        List<String> listListOf = CollectionsKt.listOf((Object[]) new String[]{"", "c", "u", "r", "m", "s", "b"});
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOf, 10));
        for (String str : listListOf) {
            arrayList.add(str.length() == 0 ? "—" : SearchDataUtils.INSTANCE.getInstance().transformRarity(str, this.lang));
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.filter_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
    }

    private final void setupSectionClearButtons(final View view) {
        for (final SectionDef sectionDef : getSectionDefs()) {
            ImageView imageView = (ImageView) view.findViewById(sectionDef.getClearId());
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda39
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        UnifiedFiltersBottomSheetFragment.setupSectionClearButtons$lambda$0(sectionDef, view, this, view2);
                    }
                });
            }
        }
    }

    static final void setupSectionClearButtons$lambda$0(SectionDef sectionDef, View view, UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, View view2) {
        sectionDef.getOnClear().invoke(view);
        unifiedFiltersBottomSheetFragment.updateAllSectionStates(view);
    }

    private final void setupSectionVisibility(View view) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.mode.ordinal()];
        if (i == 1) {
            View viewFindViewById = view.findViewById(R.id.sectionPrice);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
            }
            View viewFindViewById2 = view.findViewById(R.id.sectionCollection);
            if (viewFindViewById2 != null) {
                viewFindViewById2.setVisibility(8);
                return;
            }
            return;
        }
        if (i == 2) {
            View viewFindViewById3 = view.findViewById(R.id.sectionPrice);
            if (viewFindViewById3 != null) {
                viewFindViewById3.setVisibility(0);
            }
            View viewFindViewById4 = view.findViewById(R.id.sectionCollection);
            if (viewFindViewById4 != null) {
                viewFindViewById4.setVisibility(0);
            }
            View viewFindViewById5 = view.findViewById(R.id.sectionLayout);
            if (viewFindViewById5 != null) {
                viewFindViewById5.setVisibility(8);
            }
            View viewFindViewById6 = view.findViewById(R.id.sectionKeyword);
            if (viewFindViewById6 != null) {
                viewFindViewById6.setVisibility(8);
                return;
            }
            return;
        }
        if (i == 3) {
            View viewFindViewById7 = view.findViewById(R.id.sectionPrice);
            if (viewFindViewById7 != null) {
                viewFindViewById7.setVisibility(8);
            }
            View viewFindViewById8 = view.findViewById(R.id.sectionCollection);
            if (viewFindViewById8 != null) {
                viewFindViewById8.setVisibility(8);
            }
            View viewFindViewById9 = view.findViewById(R.id.sectionSet);
            if (viewFindViewById9 != null) {
                viewFindViewById9.setVisibility(8);
            }
            View viewFindViewById10 = view.findViewById(R.id.sectionLegalities);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(8);
            }
            View viewFindViewById11 = view.findViewById(R.id.sectionIs);
            if (viewFindViewById11 != null) {
                viewFindViewById11.setVisibility(8);
                return;
            }
            return;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        View viewFindViewById12 = view.findViewById(R.id.sectionTheme);
        if (viewFindViewById12 != null) {
            viewFindViewById12.setVisibility(this.isSmartDeck ? 0 : 8);
        }
        View viewFindViewById13 = view.findViewById(R.id.sectionIdentity);
        if (viewFindViewById13 != null) {
            viewFindViewById13.setVisibility(8);
        }
        View viewFindViewById14 = view.findViewById(R.id.sectionPrice);
        if (viewFindViewById14 != null) {
            viewFindViewById14.setVisibility(8);
        }
        View viewFindViewById15 = view.findViewById(R.id.sectionCollection);
        if (viewFindViewById15 != null) {
            viewFindViewById15.setVisibility(8);
        }
        View viewFindViewById16 = view.findViewById(R.id.sectionLayout);
        if (viewFindViewById16 != null) {
            viewFindViewById16.setVisibility(8);
        }
        View viewFindViewById17 = view.findViewById(R.id.sectionKeyword);
        if (viewFindViewById17 != null) {
            viewFindViewById17.setVisibility(8);
        }
    }

    private final void setupSetAutoComplete(final View view) {
        final AutoCompleteTextView autoCompleteTextView;
        Context context = getContext();
        if (context == null || (autoCompleteTextView = (AutoCompleteTextView) view.findViewById(R.id.setAutoComplete)) == null) {
            return;
        }
        List<CardSet> listSortedWith = CollectionsKt.sortedWith(CardSetsManager.INSTANCE.getCardSets(), new Comparator() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$setupSetAutoComplete$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((CardSet) t2).getReleased_at(), ((CardSet) t).getReleased_at());
            }
        });
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSortedWith, 10));
        for (CardSet cardSet : listSortedWith) {
            String name = cardSet.getName();
            String upperCase = cardSet.getCode().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            String name2 = cardSet.getName();
            String upperCase2 = cardSet.getCode().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
            arrayList.add(new SetEntry(name, upperCase, name2 + " (" + upperCase2 + ")"));
        }
        autoCompleteTextView.setAdapter(new SetFilterAdapter(context, arrayList));
        autoCompleteTextView.setInputType(524288);
        autoCompleteTextView.setImportantForAutofill(2);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda53
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i, long j) {
                UnifiedFiltersBottomSheetFragment.setupSetAutoComplete$lambda$2(this.f$0, autoCompleteTextView, view, adapterView, view2, i, j);
            }
        });
    }

    static final void setupSetAutoComplete$lambda$2(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, AutoCompleteTextView autoCompleteTextView, View view, AdapterView adapterView, View view2, int i, long j) {
        Object itemAtPosition = adapterView.getItemAtPosition(i);
        Intrinsics.checkNotNull(itemAtPosition, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment.SetEntry");
        SetEntry setEntry = (SetEntry) itemAtPosition;
        String lowerCase = setEntry.getCode().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        unifiedFiltersBottomSheetFragment.selectedSetCode = lowerCase;
        autoCompleteTextView.setText((CharSequence) setEntry.getDisplay(), false);
        unifiedFiltersBottomSheetFragment.updateAllSectionStates(view);
    }

    private final void setupThemeSection(View view) {
        final Context context;
        FlexboxLayout flexboxLayout;
        if (this.mode != FilterMode.SEARCH || !this.isSmartDeck || (context = getContext()) == null || (flexboxLayout = (FlexboxLayout) view.findViewById(R.id.themeChipsLayout)) == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.clearTheme);
        flexboxLayout.removeAllViews();
        final ArrayList arrayList = new ArrayList();
        for (final String str : this.FILL_GAP_CATEGORIES) {
            String strReplace$default = StringsKt.replace$default(str, "_", " ", false, 4, (Object) null);
            if (strReplace$default.length() > 0) {
                StringBuilder sb = new StringBuilder();
                String strValueOf = String.valueOf(strReplace$default.charAt(0));
                Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
                String upperCase = strValueOf.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                StringBuilder sbAppend = sb.append((Object) upperCase);
                String strSubstring = strReplace$default.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                strReplace$default = sbAppend.append(strSubstring).toString();
            }
            final TextView textViewCreateChip = this.createChip(context, strReplace$default);
            if (Intrinsics.areEqual(str, this.selectedFillGap)) {
                this.updateToggleChipStyle(textViewCreateChip, context, true);
            }
            final UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment = this;
            textViewCreateChip.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda35
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    UnifiedFiltersBottomSheetFragment.setupThemeSection$lambda$1(this.f$0, str, arrayList, textViewCreateChip, context, view2);
                }
            });
            arrayList.add(TuplesKt.to(str, textViewCreateChip));
            flexboxLayout.addView(textViewCreateChip);
            this = unifiedFiltersBottomSheetFragment;
        }
        final UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment2 = this;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda36
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    UnifiedFiltersBottomSheetFragment.setupThemeSection$lambda$2(this.f$0, arrayList, context, view2);
                }
            });
        }
    }

    static final void setupThemeSection$lambda$1(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, String str, List list, TextView textView, Context context, View view) {
        boolean zAreEqual = Intrinsics.areEqual(unifiedFiltersBottomSheetFragment.selectedFillGap, str);
        if (zAreEqual) {
            str = null;
        }
        unifiedFiltersBottomSheetFragment.selectedFillGap = str;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            unifiedFiltersBottomSheetFragment.updateToggleChipStyle((TextView) ((Pair) it.next()).component2(), context, false);
        }
        if (zAreEqual) {
            return;
        }
        unifiedFiltersBottomSheetFragment.updateToggleChipStyle(textView, context, true);
    }

    static final void setupThemeSection$lambda$2(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, List list, Context context, View view) {
        unifiedFiltersBottomSheetFragment.selectedFillGap = null;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            unifiedFiltersBottomSheetFragment.updateToggleChipStyle((TextView) ((Pair) it.next()).component2(), context, false);
        }
    }

    private final void setupTristateRow(View row, String label, Boolean initialState, final Function1<? super Boolean, Unit> onChanged) {
        final Context context;
        if (row == null || (context = getContext()) == null) {
            return;
        }
        TextView textView = (TextView) row.findViewById(R.id.tristateLabel);
        if (textView != null) {
            textView.setText(label);
        }
        final TextView textView2 = (TextView) row.findViewById(R.id.tristateAny);
        final TextView textView3 = (TextView) row.findViewById(R.id.tristateYes);
        final TextView textView4 = (TextView) row.findViewById(R.id.tristateNo);
        setupTristateRow$select(onChanged, textView2, textView3, textView4, context, initialState);
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UnifiedFiltersBottomSheetFragment.setupTristateRow$select(onChanged, textView2, textView3, textView4, context, null);
                }
            });
        }
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UnifiedFiltersBottomSheetFragment.setupTristateRow$select(onChanged, textView2, textView3, textView4, context, true);
                }
            });
        }
        if (textView4 != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda22
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UnifiedFiltersBottomSheetFragment.setupTristateRow$select(onChanged, textView2, textView3, textView4, context, false);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupTristateRow$select(Function1<? super Boolean, Unit> function1, TextView textView, TextView textView2, TextView textView3, Context context, Boolean bool) {
        function1.invoke(bool);
        for (TextView textView4 : CollectionsKt.listOf((Object[]) new TextView[]{textView, textView2, textView3})) {
            if (textView4 != null) {
                textView4.setTextColor(ContextCompat.getColor(context, R.color.light_grey));
            }
            if (textView4 != null) {
                textView4.setBackgroundResource(R.drawable.unselected_chip_background);
            }
        }
        if (bool == null) {
            if (textView != null) {
                textView.setTextColor(ContextCompat.getColor(context, R.color.almost_white));
            }
            if (textView != null) {
                textView.setBackgroundResource(R.drawable.selected_chip_background);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual((Object) bool, (Object) true)) {
            if (textView2 != null) {
                textView2.setTextColor(ContextCompat.getColor(context, R.color.almost_white));
            }
            if (textView2 != null) {
                textView2.setBackgroundResource(R.drawable.selected_chip_background);
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual((Object) bool, (Object) false)) {
            throw new NoWhenBranchMatchedException();
        }
        if (textView3 != null) {
            textView3.setTextColor(ContextCompat.getColor(context, R.color.almost_white));
        }
        if (textView3 != null) {
            textView3.setBackgroundResource(R.drawable.selected_chip_background);
        }
    }

    private final void setupTypeChips(final View view) {
        FlexboxLayout flexboxLayout;
        final EditText editText;
        Context context = getContext();
        if (context == null || (flexboxLayout = (FlexboxLayout) view.findViewById(R.id.typeChipsLayout)) == null || (editText = (EditText) view.findViewById(R.id.typeEditText)) == null) {
            return;
        }
        for (final String str : CollectionsKt.listOf((Object[]) new String[]{"creature", "instant", "sorcery", "enchantment", "artifact", "planeswalker", "land", "battle", "legendary", "token", "basic", "snow"})) {
            final String strTranslateTag = SearchDataUtils.INSTANCE.getInstance().translateTag(str, this.lang);
            TextView textViewCreateChip = createChip(context, strTranslateTag);
            textViewCreateChip.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda47
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    UnifiedFiltersBottomSheetFragment.setupTypeChips$lambda$0$0(this.f$0, str, strTranslateTag, editText, view, view2);
                }
            });
            flexboxLayout.addView(textViewCreateChip);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupTypeChips$lambda$0$0(UnifiedFiltersBottomSheetFragment unifiedFiltersBottomSheetFragment, String str, String str2, EditText editText, View view, View view2) {
        if (!unifiedFiltersBottomSheetFragment.alwaysKeywordsInEnglish) {
            str = str2;
        }
        String string = StringsKt.trim((CharSequence) editText.getText().toString()).toString();
        String str3 = string;
        if (!StringsKt.split$default((CharSequence) str3, new String[]{" "}, false, 0, 6, (Object) null).contains(str)) {
            if (str3.length() != 0) {
                str = string + " " + str;
            }
            editText.setText(str);
            editText.setSelection(str.length());
        }
        unifiedFiltersBottomSheetFragment.updateAllSectionStates(view);
    }

    private final void updateAllSectionStates(View view) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        int color = ContextCompat.getColor(context, R.color.selected_color_new);
        int color2 = ContextCompat.getColor(context, R.color.almost_white);
        for (SectionDef sectionDef : getSectionDefs()) {
            View viewFindViewById = view.findViewById(sectionDef.getHeaderId());
            TextView textView = (TextView) view.findViewById(sectionDef.getIconId());
            TextView textView2 = (TextView) view.findViewById(sectionDef.getTitleId());
            ImageView imageView = (ImageView) view.findViewById(sectionDef.getClearId());
            boolean zBooleanValue = sectionDef.isActive().invoke(view).booleanValue();
            if (textView != null) {
                textView.setTextColor(zBooleanValue ? color : color2);
            }
            if (textView2 != null) {
                textView2.setTextColor(zBooleanValue ? color : color2);
            }
            if (imageView != null) {
                imageView.setVisibility(zBooleanValue ? 0 : 8);
            }
            if (viewFindViewById != null) {
                viewFindViewById.setBackgroundResource(zBooleanValue ? R.drawable.black_box_with_line_small : 0);
            }
        }
    }

    private final void updateColorHighlights(Map<String, ? extends View> views) {
        for (Map.Entry<String, ? extends View> entry : views.entrySet()) {
            String key = entry.getKey();
            View value = entry.getValue();
            if (value != null) {
                value.setAlpha(this.selectedColors.contains(key) ? 1.0f : 0.4f);
            }
        }
    }

    private final void updateIdentityHighlights(Map<String, ? extends View> views) {
        for (Map.Entry<String, ? extends View> entry : views.entrySet()) {
            String key = entry.getKey();
            View value = entry.getValue();
            if (value != null) {
                value.setAlpha(this.selectedIdentity.contains(key) ? 1.0f : 0.4f);
            }
        }
    }

    private final void updateToggleChipStyle(TextView chip, Context ctx, boolean selected) {
        if (selected) {
            chip.setTextColor(ContextCompat.getColor(ctx, R.color.almost_white));
            chip.setBackgroundResource(R.drawable.selected_chip_background);
        } else {
            chip.setTextColor(ContextCompat.getColor(ctx, R.color.light_grey));
            chip.setBackgroundResource(R.drawable.unselected_chip_background);
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(dialogOnCreateDialog, "onCreateDialog(...)");
        Window window = dialogOnCreateDialog.getWindow();
        if (window != null) {
            window.setDimAmount(0.8f);
        }
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment$$ExternalSyntheticLambda57
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                UnifiedFiltersBottomSheetFragment.onCreateDialog$lambda$0$0(dialogOnCreateDialog, this, dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.unified_filters_dialog, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setupIcons(view);
        setupSectionVisibility(view);
        setupThemeSection(view);
        setupColorSection(view);
        setupIdentitySection(view);
        setupTypeChips(view);
        setupOracleSection(view);
        setupNumericSpinners(view);
        setupSetAutoComplete(view);
        setupRaritySection(view);
        setupKeywordAutoComplete(view);
        setupLayoutSpinner(view);
        setupLanguageSpinner(view);
        setupLegalityChips(view);
        setupIsChips(view);
        setupCollectionToggles(view);
        setupSectionClearButtons(view);
        setupButtons(view);
        if (!StringsKt.isBlank(this.currentFilters)) {
            parseAndPopulate(view, this.currentFilters);
        }
        updateAllSectionStates(view);
    }
}
