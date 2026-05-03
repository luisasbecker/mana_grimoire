package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.messaging.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SearchTabManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u0000 '2\u00020\u0001:\u0002'(B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0018\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"J\u0016\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010%\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u0013J\u000e\u0010&\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006)"}, d2 = {"Lcom/studiolaganne/lengendarylens/SearchTabManager;", "", "context", "Landroid/content/Context;", "deckId", "", "<init>", "(Landroid/content/Context;I)V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "gson", "Lcom/google/gson/Gson;", "tabs", "", "Lcom/studiolaganne/lengendarylens/SearchTab;", "getTabs", "()Ljava/util/List;", "activeTabId", "", "getActiveTabId", "()Ljava/lang/String;", "setActiveTabId", "(Ljava/lang/String;)V", "activeTab", "getActiveTab", "()Lcom/studiolaganne/lengendarylens/SearchTab;", "load", "", "save", "createTab", NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/studiolaganne/lengendarylens/SearchTabParams;", "makeActive", "", "updateTab", "tabId", "closeTab", "switchTab", "Companion", "PersistedTab", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SearchTabManager {
    private static final String KEY_PREFIX = "tabs_";
    private static final int MAX_TABS = 20;
    private static final String PREFS_NAME = "mythic_search_tabs";
    private String activeTabId;
    private final Context context;
    private final int deckId;
    private final Gson gson;
    private final SharedPreferences prefs;
    private final List<SearchTab> tabs;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: SearchTabManager.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/studiolaganne/lengendarylens/SearchTabManager$Companion;", "", "<init>", "()V", "PREFS_NAME", "", "KEY_PREFIX", "MAX_TABS", "", "buildLabel", NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/studiolaganne/lengendarylens/SearchTabParams;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String buildLabel(SearchTabParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            ArrayList arrayList = new ArrayList();
            String fillGap = params.getFillGap();
            if (fillGap != null && !StringsKt.isBlank(fillGap)) {
                String fillGap2 = params.getFillGap();
                Intrinsics.checkNotNull(fillGap2);
                String strReplace$default = StringsKt.replace$default(fillGap2, "_", " ", false, 4, (Object) null);
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
                arrayList.add("Theme: " + strReplace$default);
            }
            String similarTo = params.getSimilarTo();
            if (similarTo != null && !StringsKt.isBlank(similarTo)) {
                String str = Intrinsics.areEqual(params.getSimilarMode(), "deck") ? "Played with" : "Similar";
                String similarToName = params.getSimilarToName();
                if (similarToName == null) {
                    similarToName = "";
                }
                if (!StringsKt.isBlank(similarToName)) {
                    str = str + ": " + similarToName;
                }
                arrayList.add(str);
            }
            String name = params.getName();
            if (name != null && !StringsKt.isBlank(name)) {
                String name2 = params.getName();
                Intrinsics.checkNotNull(name2);
                arrayList.add(name2);
            }
            String scryfall = params.getScryfall();
            if (scryfall != null && !StringsKt.isBlank(scryfall)) {
                String scryfall2 = params.getScryfall();
                Intrinsics.checkNotNull(scryfall2);
                arrayList.add(scryfall2);
            }
            return arrayList.isEmpty() ? "Search" : CollectionsKt.joinToString$default(arrayList, " · ", null, null, 0, null, null, 62, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SearchTabManager.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/studiolaganne/lengendarylens/SearchTabManager$PersistedTab;", "", "id", "", Constants.ScionAnalytics.PARAM_LABEL, NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/studiolaganne/lengendarylens/SearchTabParams;", "orderBy", "orderDirection", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/SearchTabParams;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getLabel", "getParams", "()Lcom/studiolaganne/lengendarylens/SearchTabParams;", "getOrderBy", "getOrderDirection", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final /* data */ class PersistedTab {
        private final String id;
        private final String label;
        private final String orderBy;
        private final String orderDirection;
        private final SearchTabParams params;

        public PersistedTab(String id, String label, SearchTabParams params, String str, String str2) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(params, "params");
            this.id = id;
            this.label = label;
            this.params = params;
            this.orderBy = str;
            this.orderDirection = str2;
        }

        public static /* synthetic */ PersistedTab copy$default(PersistedTab persistedTab, String str, String str2, SearchTabParams searchTabParams, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = persistedTab.id;
            }
            if ((i & 2) != 0) {
                str2 = persistedTab.label;
            }
            if ((i & 4) != 0) {
                searchTabParams = persistedTab.params;
            }
            if ((i & 8) != 0) {
                str3 = persistedTab.orderBy;
            }
            if ((i & 16) != 0) {
                str4 = persistedTab.orderDirection;
            }
            String str5 = str4;
            SearchTabParams searchTabParams2 = searchTabParams;
            return persistedTab.copy(str, str2, searchTabParams2, str3, str5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final SearchTabParams getParams() {
            return this.params;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getOrderBy() {
            return this.orderBy;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getOrderDirection() {
            return this.orderDirection;
        }

        public final PersistedTab copy(String id, String label, SearchTabParams params, String orderBy, String orderDirection) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(params, "params");
            return new PersistedTab(id, label, params, orderBy, orderDirection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PersistedTab)) {
                return false;
            }
            PersistedTab persistedTab = (PersistedTab) other;
            return Intrinsics.areEqual(this.id, persistedTab.id) && Intrinsics.areEqual(this.label, persistedTab.label) && Intrinsics.areEqual(this.params, persistedTab.params) && Intrinsics.areEqual(this.orderBy, persistedTab.orderBy) && Intrinsics.areEqual(this.orderDirection, persistedTab.orderDirection);
        }

        public final String getId() {
            return this.id;
        }

        public final String getLabel() {
            return this.label;
        }

        public final String getOrderBy() {
            return this.orderBy;
        }

        public final String getOrderDirection() {
            return this.orderDirection;
        }

        public final SearchTabParams getParams() {
            return this.params;
        }

        public int hashCode() {
            int iHashCode = ((((this.id.hashCode() * 31) + this.label.hashCode()) * 31) + this.params.hashCode()) * 31;
            String str = this.orderBy;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.orderDirection;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "PersistedTab(id=" + this.id + ", label=" + this.label + ", params=" + this.params + ", orderBy=" + this.orderBy + ", orderDirection=" + this.orderDirection + ")";
        }
    }

    public SearchTabManager(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.deckId = i;
        this.prefs = context.getSharedPreferences(PREFS_NAME, 0);
        this.gson = new Gson();
        this.tabs = new ArrayList();
    }

    public static /* synthetic */ SearchTab createTab$default(SearchTabManager searchTabManager, SearchTabParams searchTabParams, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return searchTabManager.createTab(searchTabParams, z);
    }

    public final void closeTab(String tabId) {
        String id;
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        Iterator<SearchTab> it = this.tabs.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getId(), tabId)) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return;
        }
        this.tabs.remove(i);
        if (Intrinsics.areEqual(this.activeTabId, tabId)) {
            if (this.tabs.isEmpty()) {
                id = null;
            } else {
                int size = this.tabs.size();
                List<SearchTab> list = this.tabs;
                id = i < size ? list.get(i).getId() : ((SearchTab) CollectionsKt.last((List) list)).getId();
            }
            this.activeTabId = id;
        }
        save();
    }

    public final SearchTab createTab(SearchTabParams params, boolean makeActive) {
        Intrinsics.checkNotNullParameter(params, "params");
        SearchTab searchTab = new SearchTab(null, INSTANCE.buildLabel(params), params, null, null, null, null, 0, false, false, TypedValues.PositionType.TYPE_SIZE_PERCENT, null);
        if (this.tabs.size() >= 20) {
            this.tabs.remove(0);
        }
        this.tabs.add(searchTab);
        if (makeActive) {
            this.activeTabId = searchTab.getId();
        }
        save();
        return searchTab;
    }

    public final SearchTab getActiveTab() {
        Object next;
        Iterator<T> it = this.tabs.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((SearchTab) next).getId(), this.activeTabId)) {
                break;
            }
        }
        return (SearchTab) next;
    }

    public final String getActiveTabId() {
        return this.activeTabId;
    }

    public final List<SearchTab> getTabs() {
        return this.tabs;
    }

    public final void load() {
        String string = this.prefs.getString(KEY_PREFIX + this.deckId, null);
        if (string == null) {
            return;
        }
        try {
            List<PersistedTab> list = (List) this.gson.fromJson(string, new TypeToken<List<? extends PersistedTab>>() { // from class: com.studiolaganne.lengendarylens.SearchTabManager$load$type$1
            }.getType());
            if (list == null) {
                return;
            }
            this.tabs.clear();
            for (PersistedTab persistedTab : list) {
                List<SearchTab> list2 = this.tabs;
                String id = persistedTab.getId();
                String label = persistedTab.getLabel();
                SearchTabParams params = persistedTab.getParams();
                String orderBy = persistedTab.getOrderBy();
                if (orderBy == null) {
                    orderBy = "relevance";
                }
                String orderDirection = persistedTab.getOrderDirection();
                if (orderDirection == null) {
                    orderDirection = "desc";
                }
                list2.add(new SearchTab(id, label, params, orderBy, orderDirection, null, null, 0, false, true, 480, null));
            }
            PersistedTab persistedTab2 = (PersistedTab) CollectionsKt.firstOrNull(list);
            this.activeTabId = persistedTab2 != null ? persistedTab2.getId() : null;
        } catch (Exception unused) {
        }
    }

    public final void save() {
        List<SearchTab> list = this.tabs;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (SearchTab searchTab : list) {
            arrayList.add(new PersistedTab(searchTab.getId(), searchTab.getLabel(), searchTab.getParams(), searchTab.getOrderBy(), searchTab.getOrderDirection()));
        }
        this.prefs.edit().putString(KEY_PREFIX + this.deckId, this.gson.toJson(arrayList)).apply();
    }

    public final void setActiveTabId(String str) {
        this.activeTabId = str;
    }

    public final void switchTab(String tabId) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        this.activeTabId = tabId;
    }

    public final void updateTab(String tabId, SearchTabParams params) {
        Object next;
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        Intrinsics.checkNotNullParameter(params, "params");
        Iterator<T> it = this.tabs.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.areEqual(((SearchTab) next).getId(), tabId)) {
                    break;
                }
            }
        }
        SearchTab searchTab = (SearchTab) next;
        if (searchTab == null) {
            return;
        }
        searchTab.setParams(params);
        searchTab.setLabel(INSTANCE.buildLabel(params));
        searchTab.setNeedsRefresh(false);
        save();
    }
}
