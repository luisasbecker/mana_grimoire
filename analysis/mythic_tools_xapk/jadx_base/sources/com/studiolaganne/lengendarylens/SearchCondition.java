package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.revenuecat.purchases.common.Constants;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SearchData.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0018\u001a\u00020\tJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J;\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0014\"\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/studiolaganne/lengendarylens/SearchCondition;", "Lcom/studiolaganne/lengendarylens/SearchElement;", "include", "", "keyword", "Lcom/studiolaganne/lengendarylens/SearchKeyword;", "operator", "Lcom/studiolaganne/lengendarylens/Operator;", "value", "", "originalToken", "<init>", "(ZLcom/studiolaganne/lengendarylens/SearchKeyword;Lcom/studiolaganne/lengendarylens/Operator;Ljava/lang/String;Ljava/lang/String;)V", "getInclude", "()Z", "getKeyword", "()Lcom/studiolaganne/lengendarylens/SearchKeyword;", "getOperator", "()Lcom/studiolaganne/lengendarylens/Operator;", "getValue", "()Ljava/lang/String;", "getOriginalToken", "setOriginalToken", "(Ljava/lang/String;)V", "toShortString", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SearchCondition extends SearchElement {
    public static final int $stable = 8;
    private final boolean include;
    private final SearchKeyword keyword;
    private final Operator operator;
    private String originalToken;
    private final String value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchCondition(boolean z, SearchKeyword keyword, Operator operator, String value, String originalToken) {
        super(null);
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(operator, "operator");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(originalToken, "originalToken");
        this.include = z;
        this.keyword = keyword;
        this.operator = operator;
        this.value = value;
        this.originalToken = originalToken;
    }

    public static /* synthetic */ SearchCondition copy$default(SearchCondition searchCondition, boolean z, SearchKeyword searchKeyword, Operator operator, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = searchCondition.include;
        }
        if ((i & 2) != 0) {
            searchKeyword = searchCondition.keyword;
        }
        if ((i & 4) != 0) {
            operator = searchCondition.operator;
        }
        if ((i & 8) != 0) {
            str = searchCondition.value;
        }
        if ((i & 16) != 0) {
            str2 = searchCondition.originalToken;
        }
        String str3 = str2;
        Operator operator2 = operator;
        return searchCondition.copy(z, searchKeyword, operator2, str, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getInclude() {
        return this.include;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SearchKeyword getKeyword() {
        return this.keyword;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Operator getOperator() {
        return this.operator;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getOriginalToken() {
        return this.originalToken;
    }

    public final SearchCondition copy(boolean include, SearchKeyword keyword, Operator operator, String value, String originalToken) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(operator, "operator");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(originalToken, "originalToken");
        return new SearchCondition(include, keyword, operator, value, originalToken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchCondition)) {
            return false;
        }
        SearchCondition searchCondition = (SearchCondition) other;
        return this.include == searchCondition.include && this.keyword == searchCondition.keyword && this.operator == searchCondition.operator && Intrinsics.areEqual(this.value, searchCondition.value) && Intrinsics.areEqual(this.originalToken, searchCondition.originalToken);
    }

    public final boolean getInclude() {
        return this.include;
    }

    public final SearchKeyword getKeyword() {
        return this.keyword;
    }

    public final Operator getOperator() {
        return this.operator;
    }

    public final String getOriginalToken() {
        return this.originalToken;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.include) * 31) + this.keyword.hashCode()) * 31) + this.operator.hashCode()) * 31) + this.value.hashCode()) * 31) + this.originalToken.hashCode();
    }

    public final void setOriginalToken(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.originalToken = str;
    }

    public final String toShortString() {
        boolean zContains$default = StringsKt.contains$default((CharSequence) this.value, (CharSequence) " ", false, 2, (Object) null);
        if (this.keyword == SearchKeyword.NAME) {
            if (this.include) {
                return this.value;
            }
            String str = this.value;
            return zContains$default ? "-n:\"" + str + "\"" : "-n:" + str;
        }
        if (this.keyword == SearchKeyword.KEYWORD) {
            return (this.include ? "" : "-") + this.keyword.getShortForm() + this.operator.getSymbol() + "\"" + this.value + "\"";
        }
        if (CollectionsKt.listOf((Object[]) new SearchKeyword[]{SearchKeyword.ALTERED, SearchKeyword.MISPRINT, SearchKeyword.SIGNED, SearchKeyword.PROXY}).contains(this.keyword)) {
            return this.keyword.getShortForm() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + this.value;
        }
        String str2 = this.include ? "" : "-";
        SearchKeyword searchKeyword = this.keyword;
        if (zContains$default) {
            return str2 + searchKeyword.getShortForm() + this.operator.getSymbol() + "\"" + this.value + "\"";
        }
        return str2 + searchKeyword.getShortForm() + this.operator.getSymbol() + this.value;
    }

    public String toString() {
        return "SearchCondition(include=" + this.include + ", keyword=" + this.keyword + ", operator=" + this.operator + ", value=" + this.value + ", originalToken=" + this.originalToken + ")";
    }
}
