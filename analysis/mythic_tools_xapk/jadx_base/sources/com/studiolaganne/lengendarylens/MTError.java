package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b:\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<¨\u0006="}, d2 = {"Lcom/studiolaganne/lengendarylens/MTError;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "SERVER_ERROR", "MISSING_MYTHIC_ID", "GOOGLE_ERROR", "GOOGLE_UNVERIFIED", "GOOGLE_MISSMATCH", "NO_CREDENTIALS", "DB_FAIL", "MALFORMED_REQUEST", "FORBIDDEN", "UPLOAD_MISSING_FILE", "UPLOAD_FAIL", "USER_NOT_FOUND", "USER_NOT_FRIEND", "FRIENDSHIP_EXISTS", "FRIENDSHIP_NOT_FOUND", "USERNAME_EXISTS", "PLAYGROUP_NOT_FOUND", "PLAYGROUP_USER_NOT_IN", "PLAYGROUP_USER_EXISTS", "PLAYGROUP_USER_NOT_FOUND", "PLAYGROUP_CANNOT_LEAVE", "PLAYGROUP_NOT_ADMIN", "PLAYGROUP_CANNOT_REMOVE", "PLAYGROUP_ALREADY_ADMIN", "DECK_CANNOT_CREATE_FOR_USER", "DECK_NOT_FOUND", "GAME_PLAYER_NOT_FOUND", "GAME_NOT_FOUND", "GAME_USER_NOT_IN", "APPLE_UNVERIFIED", "APPLE_ERROR", "APPLE_MISSMATCH", "USERNAME_WRONG_FORMAT", "GAME_NOT_OWNER", "INVALID_PLATFORM", "INVALID_PURCHASE", "THEME_NOT_FOUND", "THEME_ZIP_NOT_FOUND", "DB_NOT_FOUND", "THEME_NOT_FOUND_BY_CODE", "PLAYGROUP_NOT_OWNER", "PLAYGROUP_USER_NOT_ADMIN", "NOT_ENOUGH_PERMISSIONS", "TAG_MISSING_NAME", "TAG_NOT_FOUND", "USER_NOT_IN_GAME", "NOTE_MISSING", "NOTE_ALREADY_EXISTS", "SEARCH_QUERY_MISSING", "DISCORD_UNVERIFIED", "TWITCH_UNVERIFIED", "FIREBASE_TOKEN_EXPIRED", "FIREBASE_ERROR", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MTError {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MTError[] $VALUES;
    private final int code;
    public static final MTError SERVER_ERROR = new MTError("SERVER_ERROR", 0, 0);
    public static final MTError MISSING_MYTHIC_ID = new MTError("MISSING_MYTHIC_ID", 1, 1);
    public static final MTError GOOGLE_ERROR = new MTError("GOOGLE_ERROR", 2, 2);
    public static final MTError GOOGLE_UNVERIFIED = new MTError("GOOGLE_UNVERIFIED", 3, 3);
    public static final MTError GOOGLE_MISSMATCH = new MTError("GOOGLE_MISSMATCH", 4, 4);
    public static final MTError NO_CREDENTIALS = new MTError("NO_CREDENTIALS", 5, 5);
    public static final MTError DB_FAIL = new MTError("DB_FAIL", 6, 6);
    public static final MTError MALFORMED_REQUEST = new MTError("MALFORMED_REQUEST", 7, 7);
    public static final MTError FORBIDDEN = new MTError("FORBIDDEN", 8, 8);
    public static final MTError UPLOAD_MISSING_FILE = new MTError("UPLOAD_MISSING_FILE", 9, 9);
    public static final MTError UPLOAD_FAIL = new MTError("UPLOAD_FAIL", 10, 10);
    public static final MTError USER_NOT_FOUND = new MTError("USER_NOT_FOUND", 11, 11);
    public static final MTError USER_NOT_FRIEND = new MTError("USER_NOT_FRIEND", 12, 12);
    public static final MTError FRIENDSHIP_EXISTS = new MTError("FRIENDSHIP_EXISTS", 13, 13);
    public static final MTError FRIENDSHIP_NOT_FOUND = new MTError("FRIENDSHIP_NOT_FOUND", 14, 14);
    public static final MTError USERNAME_EXISTS = new MTError("USERNAME_EXISTS", 15, 15);
    public static final MTError PLAYGROUP_NOT_FOUND = new MTError("PLAYGROUP_NOT_FOUND", 16, 16);
    public static final MTError PLAYGROUP_USER_NOT_IN = new MTError("PLAYGROUP_USER_NOT_IN", 17, 17);
    public static final MTError PLAYGROUP_USER_EXISTS = new MTError("PLAYGROUP_USER_EXISTS", 18, 18);
    public static final MTError PLAYGROUP_USER_NOT_FOUND = new MTError("PLAYGROUP_USER_NOT_FOUND", 19, 19);
    public static final MTError PLAYGROUP_CANNOT_LEAVE = new MTError("PLAYGROUP_CANNOT_LEAVE", 20, 20);
    public static final MTError PLAYGROUP_NOT_ADMIN = new MTError("PLAYGROUP_NOT_ADMIN", 21, 21);
    public static final MTError PLAYGROUP_CANNOT_REMOVE = new MTError("PLAYGROUP_CANNOT_REMOVE", 22, 22);
    public static final MTError PLAYGROUP_ALREADY_ADMIN = new MTError("PLAYGROUP_ALREADY_ADMIN", 23, 23);
    public static final MTError DECK_CANNOT_CREATE_FOR_USER = new MTError("DECK_CANNOT_CREATE_FOR_USER", 24, 24);
    public static final MTError DECK_NOT_FOUND = new MTError("DECK_NOT_FOUND", 25, 25);
    public static final MTError GAME_PLAYER_NOT_FOUND = new MTError("GAME_PLAYER_NOT_FOUND", 26, 26);
    public static final MTError GAME_NOT_FOUND = new MTError("GAME_NOT_FOUND", 27, 27);
    public static final MTError GAME_USER_NOT_IN = new MTError("GAME_USER_NOT_IN", 28, 28);
    public static final MTError APPLE_UNVERIFIED = new MTError("APPLE_UNVERIFIED", 29, 29);
    public static final MTError APPLE_ERROR = new MTError("APPLE_ERROR", 30, 30);
    public static final MTError APPLE_MISSMATCH = new MTError("APPLE_MISSMATCH", 31, 31);
    public static final MTError USERNAME_WRONG_FORMAT = new MTError("USERNAME_WRONG_FORMAT", 32, 32);
    public static final MTError GAME_NOT_OWNER = new MTError("GAME_NOT_OWNER", 33, 33);
    public static final MTError INVALID_PLATFORM = new MTError("INVALID_PLATFORM", 34, 34);
    public static final MTError INVALID_PURCHASE = new MTError("INVALID_PURCHASE", 35, 35);
    public static final MTError THEME_NOT_FOUND = new MTError("THEME_NOT_FOUND", 36, 36);
    public static final MTError THEME_ZIP_NOT_FOUND = new MTError("THEME_ZIP_NOT_FOUND", 37, 37);
    public static final MTError DB_NOT_FOUND = new MTError("DB_NOT_FOUND", 38, 38);
    public static final MTError THEME_NOT_FOUND_BY_CODE = new MTError("THEME_NOT_FOUND_BY_CODE", 39, 39);
    public static final MTError PLAYGROUP_NOT_OWNER = new MTError("PLAYGROUP_NOT_OWNER", 40, 40);
    public static final MTError PLAYGROUP_USER_NOT_ADMIN = new MTError("PLAYGROUP_USER_NOT_ADMIN", 41, 41);
    public static final MTError NOT_ENOUGH_PERMISSIONS = new MTError("NOT_ENOUGH_PERMISSIONS", 42, 42);
    public static final MTError TAG_MISSING_NAME = new MTError("TAG_MISSING_NAME", 43, 43);
    public static final MTError TAG_NOT_FOUND = new MTError("TAG_NOT_FOUND", 44, 44);
    public static final MTError USER_NOT_IN_GAME = new MTError("USER_NOT_IN_GAME", 45, 45);
    public static final MTError NOTE_MISSING = new MTError("NOTE_MISSING", 46, 46);
    public static final MTError NOTE_ALREADY_EXISTS = new MTError("NOTE_ALREADY_EXISTS", 47, 47);
    public static final MTError SEARCH_QUERY_MISSING = new MTError("SEARCH_QUERY_MISSING", 48, 48);
    public static final MTError DISCORD_UNVERIFIED = new MTError("DISCORD_UNVERIFIED", 49, 49);
    public static final MTError TWITCH_UNVERIFIED = new MTError("TWITCH_UNVERIFIED", 50, 50);
    public static final MTError FIREBASE_TOKEN_EXPIRED = new MTError("FIREBASE_TOKEN_EXPIRED", 51, 51);
    public static final MTError FIREBASE_ERROR = new MTError("FIREBASE_ERROR", 52, 52);

    private static final /* synthetic */ MTError[] $values() {
        return new MTError[]{SERVER_ERROR, MISSING_MYTHIC_ID, GOOGLE_ERROR, GOOGLE_UNVERIFIED, GOOGLE_MISSMATCH, NO_CREDENTIALS, DB_FAIL, MALFORMED_REQUEST, FORBIDDEN, UPLOAD_MISSING_FILE, UPLOAD_FAIL, USER_NOT_FOUND, USER_NOT_FRIEND, FRIENDSHIP_EXISTS, FRIENDSHIP_NOT_FOUND, USERNAME_EXISTS, PLAYGROUP_NOT_FOUND, PLAYGROUP_USER_NOT_IN, PLAYGROUP_USER_EXISTS, PLAYGROUP_USER_NOT_FOUND, PLAYGROUP_CANNOT_LEAVE, PLAYGROUP_NOT_ADMIN, PLAYGROUP_CANNOT_REMOVE, PLAYGROUP_ALREADY_ADMIN, DECK_CANNOT_CREATE_FOR_USER, DECK_NOT_FOUND, GAME_PLAYER_NOT_FOUND, GAME_NOT_FOUND, GAME_USER_NOT_IN, APPLE_UNVERIFIED, APPLE_ERROR, APPLE_MISSMATCH, USERNAME_WRONG_FORMAT, GAME_NOT_OWNER, INVALID_PLATFORM, INVALID_PURCHASE, THEME_NOT_FOUND, THEME_ZIP_NOT_FOUND, DB_NOT_FOUND, THEME_NOT_FOUND_BY_CODE, PLAYGROUP_NOT_OWNER, PLAYGROUP_USER_NOT_ADMIN, NOT_ENOUGH_PERMISSIONS, TAG_MISSING_NAME, TAG_NOT_FOUND, USER_NOT_IN_GAME, NOTE_MISSING, NOTE_ALREADY_EXISTS, SEARCH_QUERY_MISSING, DISCORD_UNVERIFIED, TWITCH_UNVERIFIED, FIREBASE_TOKEN_EXPIRED, FIREBASE_ERROR};
    }

    static {
        MTError[] mTErrorArr$values = $values();
        $VALUES = mTErrorArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(mTErrorArr$values);
    }

    private MTError(String str, int i, int i2) {
        this.code = i2;
    }

    public static EnumEntries<MTError> getEntries() {
        return $ENTRIES;
    }

    public static MTError valueOf(String str) {
        return (MTError) Enum.valueOf(MTError.class, str);
    }

    public static MTError[] values() {
        return (MTError[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }
}
