package com.studiolaganne.lengendarylens;

import android.net.Uri;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeepLinkRouter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeepLinkRoute;", "", "<init>", "()V", "OAuthCallback", "EmailVerify", "EventQR", "UserProfile", "UserDeck", "UserList", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "Lcom/studiolaganne/lengendarylens/DeepLinkRoute$EmailVerify;", "Lcom/studiolaganne/lengendarylens/DeepLinkRoute$EventQR;", "Lcom/studiolaganne/lengendarylens/DeepLinkRoute$OAuthCallback;", "Lcom/studiolaganne/lengendarylens/DeepLinkRoute$Unknown;", "Lcom/studiolaganne/lengendarylens/DeepLinkRoute$UserDeck;", "Lcom/studiolaganne/lengendarylens/DeepLinkRoute$UserList;", "Lcom/studiolaganne/lengendarylens/DeepLinkRoute$UserProfile;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class DeepLinkRoute {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: DeepLinkRouter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeepLinkRoute$EmailVerify;", "Lcom/studiolaganne/lengendarylens/DeepLinkRoute;", "uri", "Landroid/net/Uri;", "<init>", "(Landroid/net/Uri;)V", "getUri", "()Landroid/net/Uri;", "component1", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class EmailVerify extends DeepLinkRoute {
        public static final int $stable = 8;
        private final Uri uri;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmailVerify(Uri uri) {
            super(null);
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.uri = uri;
        }

        public static /* synthetic */ EmailVerify copy$default(EmailVerify emailVerify, Uri uri, int i, Object obj) {
            if ((i & 1) != 0) {
                uri = emailVerify.uri;
            }
            return emailVerify.copy(uri);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Uri getUri() {
            return this.uri;
        }

        public final EmailVerify copy(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return new EmailVerify(uri);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof EmailVerify) && Intrinsics.areEqual(this.uri, ((EmailVerify) other).uri);
        }

        public final Uri getUri() {
            return this.uri;
        }

        public int hashCode() {
            return this.uri.hashCode();
        }

        public String toString() {
            return "EmailVerify(uri=" + this.uri + ")";
        }
    }

    /* JADX INFO: compiled from: DeepLinkRouter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeepLinkRoute$EventQR;", "Lcom/studiolaganne/lengendarylens/DeepLinkRoute;", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class EventQR extends DeepLinkRoute {
        public static final int $stable = 0;
        private final String url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EventQR(String url) {
            super(null);
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
        }

        public static /* synthetic */ EventQR copy$default(EventQR eventQR, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = eventQR.url;
            }
            return eventQR.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final EventQR copy(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new EventQR(url);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof EventQR) && Intrinsics.areEqual(this.url, ((EventQR) other).url);
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "EventQR(url=" + this.url + ")";
        }
    }

    /* JADX INFO: compiled from: DeepLinkRouter.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeepLinkRoute$OAuthCallback;", "Lcom/studiolaganne/lengendarylens/DeepLinkRoute;", "uri", "Landroid/net/Uri;", "code", "", "provider", "<init>", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)V", "getUri", "()Landroid/net/Uri;", "getCode", "()Ljava/lang/String;", "getProvider", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OAuthCallback extends DeepLinkRoute {
        public static final int $stable = 8;
        private final String code;
        private final String provider;
        private final Uri uri;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OAuthCallback(Uri uri, String code, String provider) {
            super(null);
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(provider, "provider");
            this.uri = uri;
            this.code = code;
            this.provider = provider;
        }

        public static /* synthetic */ OAuthCallback copy$default(OAuthCallback oAuthCallback, Uri uri, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                uri = oAuthCallback.uri;
            }
            if ((i & 2) != 0) {
                str = oAuthCallback.code;
            }
            if ((i & 4) != 0) {
                str2 = oAuthCallback.provider;
            }
            return oAuthCallback.copy(uri, str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Uri getUri() {
            return this.uri;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCode() {
            return this.code;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getProvider() {
            return this.provider;
        }

        public final OAuthCallback copy(Uri uri, String code, String provider) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(provider, "provider");
            return new OAuthCallback(uri, code, provider);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OAuthCallback)) {
                return false;
            }
            OAuthCallback oAuthCallback = (OAuthCallback) other;
            return Intrinsics.areEqual(this.uri, oAuthCallback.uri) && Intrinsics.areEqual(this.code, oAuthCallback.code) && Intrinsics.areEqual(this.provider, oAuthCallback.provider);
        }

        public final String getCode() {
            return this.code;
        }

        public final String getProvider() {
            return this.provider;
        }

        public final Uri getUri() {
            return this.uri;
        }

        public int hashCode() {
            return (((this.uri.hashCode() * 31) + this.code.hashCode()) * 31) + this.provider.hashCode();
        }

        public String toString() {
            return "OAuthCallback(uri=" + this.uri + ", code=" + this.code + ", provider=" + this.provider + ")";
        }
    }

    /* JADX INFO: compiled from: DeepLinkRouter.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeepLinkRoute$Unknown;", "Lcom/studiolaganne/lengendarylens/DeepLinkRoute;", "<init>", "()V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Unknown extends DeepLinkRoute {
        public static final int $stable = 0;
        public static final Unknown INSTANCE = new Unknown();

        private Unknown() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: DeepLinkRouter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeepLinkRoute$UserDeck;", "Lcom/studiolaganne/lengendarylens/DeepLinkRoute;", "userId", "", "deckId", "<init>", "(II)V", "getUserId", "()I", "getDeckId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UserDeck extends DeepLinkRoute {
        public static final int $stable = 0;
        private final int deckId;
        private final int userId;

        public UserDeck(int i, int i2) {
            super(null);
            this.userId = i;
            this.deckId = i2;
        }

        public static /* synthetic */ UserDeck copy$default(UserDeck userDeck, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = userDeck.userId;
            }
            if ((i3 & 2) != 0) {
                i2 = userDeck.deckId;
            }
            return userDeck.copy(i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getUserId() {
            return this.userId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getDeckId() {
            return this.deckId;
        }

        public final UserDeck copy(int userId, int deckId) {
            return new UserDeck(userId, deckId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserDeck)) {
                return false;
            }
            UserDeck userDeck = (UserDeck) other;
            return this.userId == userDeck.userId && this.deckId == userDeck.deckId;
        }

        public final int getDeckId() {
            return this.deckId;
        }

        public final int getUserId() {
            return this.userId;
        }

        public int hashCode() {
            return (Integer.hashCode(this.userId) * 31) + Integer.hashCode(this.deckId);
        }

        public String toString() {
            return "UserDeck(userId=" + this.userId + ", deckId=" + this.deckId + ")";
        }
    }

    /* JADX INFO: compiled from: DeepLinkRouter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeepLinkRoute$UserList;", "Lcom/studiolaganne/lengendarylens/DeepLinkRoute;", "userId", "", "listId", "<init>", "(II)V", "getUserId", "()I", "getListId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UserList extends DeepLinkRoute {
        public static final int $stable = 0;
        private final int listId;
        private final int userId;

        public UserList(int i, int i2) {
            super(null);
            this.userId = i;
            this.listId = i2;
        }

        public static /* synthetic */ UserList copy$default(UserList userList, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = userList.userId;
            }
            if ((i3 & 2) != 0) {
                i2 = userList.listId;
            }
            return userList.copy(i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getUserId() {
            return this.userId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getListId() {
            return this.listId;
        }

        public final UserList copy(int userId, int listId) {
            return new UserList(userId, listId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserList)) {
                return false;
            }
            UserList userList = (UserList) other;
            return this.userId == userList.userId && this.listId == userList.listId;
        }

        public final int getListId() {
            return this.listId;
        }

        public final int getUserId() {
            return this.userId;
        }

        public int hashCode() {
            return (Integer.hashCode(this.userId) * 31) + Integer.hashCode(this.listId);
        }

        public String toString() {
            return "UserList(userId=" + this.userId + ", listId=" + this.listId + ")";
        }
    }

    /* JADX INFO: compiled from: DeepLinkRouter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeepLinkRoute$UserProfile;", "Lcom/studiolaganne/lengendarylens/DeepLinkRoute;", "userId", "", "<init>", "(I)V", "getUserId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UserProfile extends DeepLinkRoute {
        public static final int $stable = 0;
        private final int userId;

        public UserProfile(int i) {
            super(null);
            this.userId = i;
        }

        public static /* synthetic */ UserProfile copy$default(UserProfile userProfile, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = userProfile.userId;
            }
            return userProfile.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getUserId() {
            return this.userId;
        }

        public final UserProfile copy(int userId) {
            return new UserProfile(userId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof UserProfile) && this.userId == ((UserProfile) other).userId;
        }

        public final int getUserId() {
            return this.userId;
        }

        public int hashCode() {
            return Integer.hashCode(this.userId);
        }

        public String toString() {
            return "UserProfile(userId=" + this.userId + ")";
        }
    }

    private DeepLinkRoute() {
    }

    public /* synthetic */ DeepLinkRoute(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
