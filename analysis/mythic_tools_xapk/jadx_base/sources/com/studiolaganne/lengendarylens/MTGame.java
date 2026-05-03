package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\bM\b\u0087\b\u0018\u00002\u00020\u0001BÃ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010S\u001a\u00020\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010Y\u001a\u00020\u000eHÆ\u0003J\t\u0010Z\u001a\u00020\u000eHÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0003J\u000f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013HÆ\u0003J\u0010\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\u0010\u0010_\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0002\u0010KJ\u0011\u0010`\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0013HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u000eHÆ\u0003JÊ\u0001\u0010b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00132\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010cJ\u0013\u0010d\u001a\u00020\u00192\b\u0010e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010f\u001a\u00020\u0003HÖ\u0001J\t\u0010g\u001a\u00020\u000eHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00100\"\u0004\b4\u00102R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u0010\u000f\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00106\"\u0004\b:\u00108R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010@\"\u0004\bD\u0010BR\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010I\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u0010\n\u0002\u0010N\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010@\"\u0004\bP\u0010BR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u00106\"\u0004\bR\u00108¨\u0006h"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTGame;", "", "id", "", "format", "Lcom/studiolaganne/lengendarylens/MTGameFormat;", "subformat", "Lcom/studiolaganne/lengendarylens/MTGameSubformat;", "playgroup", "Lcom/studiolaganne/lengendarylens/MTGamePlaygroup;", "created_by", "Lcom/studiolaganne/lengendarylens/MTUser;", "winner", "started_at", "", "ended_at", "set", "Lcom/studiolaganne/lengendarylens/MTSet;", "players", "", "Lcom/studiolaganne/lengendarylens/MTGamePlayer;", "events", "Lcom/studiolaganne/lengendarylens/MTGameEvent;", "pausetime", "published", "", "tags", "Lcom/studiolaganne/lengendarylens/MTTag;", "note", "<init>", "(ILcom/studiolaganne/lengendarylens/MTGameFormat;Lcom/studiolaganne/lengendarylens/MTGameSubformat;Lcom/studiolaganne/lengendarylens/MTGamePlaygroup;Lcom/studiolaganne/lengendarylens/MTUser;Lcom/studiolaganne/lengendarylens/MTUser;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTSet;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getFormat", "()Lcom/studiolaganne/lengendarylens/MTGameFormat;", "setFormat", "(Lcom/studiolaganne/lengendarylens/MTGameFormat;)V", "getSubformat", "()Lcom/studiolaganne/lengendarylens/MTGameSubformat;", "setSubformat", "(Lcom/studiolaganne/lengendarylens/MTGameSubformat;)V", "getPlaygroup", "()Lcom/studiolaganne/lengendarylens/MTGamePlaygroup;", "setPlaygroup", "(Lcom/studiolaganne/lengendarylens/MTGamePlaygroup;)V", "getCreated_by", "()Lcom/studiolaganne/lengendarylens/MTUser;", "setCreated_by", "(Lcom/studiolaganne/lengendarylens/MTUser;)V", "getWinner", "setWinner", "getStarted_at", "()Ljava/lang/String;", "setStarted_at", "(Ljava/lang/String;)V", "getEnded_at", "setEnded_at", "getSet", "()Lcom/studiolaganne/lengendarylens/MTSet;", "setSet", "(Lcom/studiolaganne/lengendarylens/MTSet;)V", "getPlayers", "()Ljava/util/List;", "setPlayers", "(Ljava/util/List;)V", "getEvents", "setEvents", "getPausetime", "()Ljava/lang/Integer;", "setPausetime", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPublished", "()Ljava/lang/Boolean;", "setPublished", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTags", "setTags", "getNote", "setNote", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(ILcom/studiolaganne/lengendarylens/MTGameFormat;Lcom/studiolaganne/lengendarylens/MTGameSubformat;Lcom/studiolaganne/lengendarylens/MTGamePlaygroup;Lcom/studiolaganne/lengendarylens/MTUser;Lcom/studiolaganne/lengendarylens/MTUser;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTSet;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;)Lcom/studiolaganne/lengendarylens/MTGame;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTGame {
    public static final int $stable = 8;
    private MTUser created_by;
    private String ended_at;
    private List<MTGameEvent> events;
    private MTGameFormat format;
    private int id;
    private String note;
    private Integer pausetime;
    private List<MTGamePlayer> players;
    private MTGamePlaygroup playgroup;
    private Boolean published;
    private MTSet set;
    private String started_at;
    private MTGameSubformat subformat;
    private List<MTTag> tags;
    private MTUser winner;

    public MTGame() {
        this(0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    public MTGame(int i, MTGameFormat mTGameFormat, MTGameSubformat mTGameSubformat, MTGamePlaygroup mTGamePlaygroup, MTUser mTUser, MTUser mTUser2, String started_at, String ended_at, MTSet mTSet, List<MTGamePlayer> players, List<MTGameEvent> events, Integer num, Boolean bool, List<MTTag> list, String str) {
        Intrinsics.checkNotNullParameter(started_at, "started_at");
        Intrinsics.checkNotNullParameter(ended_at, "ended_at");
        Intrinsics.checkNotNullParameter(players, "players");
        Intrinsics.checkNotNullParameter(events, "events");
        this.id = i;
        this.format = mTGameFormat;
        this.subformat = mTGameSubformat;
        this.playgroup = mTGamePlaygroup;
        this.created_by = mTUser;
        this.winner = mTUser2;
        this.started_at = started_at;
        this.ended_at = ended_at;
        this.set = mTSet;
        this.players = players;
        this.events = events;
        this.pausetime = num;
        this.published = bool;
        this.tags = list;
        this.note = str;
    }

    public /* synthetic */ MTGame(int i, MTGameFormat mTGameFormat, MTGameSubformat mTGameSubformat, MTGamePlaygroup mTGamePlaygroup, MTUser mTUser, MTUser mTUser2, String str, String str2, MTSet mTSet, List list, List list2, Integer num, Boolean bool, List list3, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? null : mTGameFormat, (i2 & 4) != 0 ? null : mTGameSubformat, (i2 & 8) != 0 ? null : mTGamePlaygroup, (i2 & 16) != 0 ? null : mTUser, (i2 & 32) != 0 ? null : mTUser2, (i2 & 64) != 0 ? "" : str, (i2 & 128) == 0 ? str2 : "", (i2 & 256) != 0 ? null : mTSet, (i2 & 512) != 0 ? CollectionsKt.emptyList() : list, (i2 & 1024) != 0 ? CollectionsKt.emptyList() : list2, (i2 & 2048) != 0 ? null : num, (i2 & 4096) != 0 ? null : bool, (i2 & 8192) != 0 ? null : list3, (i2 & 16384) != 0 ? null : str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    public final List<MTGamePlayer> component10() {
        return this.players;
    }

    public final List<MTGameEvent> component11() {
        return this.events;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Integer getPausetime() {
        return this.pausetime;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Boolean getPublished() {
        return this.published;
    }

    public final List<MTTag> component14() {
        return this.tags;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getNote() {
        return this.note;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTGameFormat getFormat() {
        return this.format;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTGameSubformat getSubformat() {
        return this.subformat;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MTGamePlaygroup getPlaygroup() {
        return this.playgroup;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final MTUser getCreated_by() {
        return this.created_by;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final MTUser getWinner() {
        return this.winner;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getStarted_at() {
        return this.started_at;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getEnded_at() {
        return this.ended_at;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final MTSet getSet() {
        return this.set;
    }

    public final MTGame copy(int id, MTGameFormat format, MTGameSubformat subformat, MTGamePlaygroup playgroup, MTUser created_by, MTUser winner, String started_at, String ended_at, MTSet set, List<MTGamePlayer> players, List<MTGameEvent> events, Integer pausetime, Boolean published, List<MTTag> tags, String note) {
        Intrinsics.checkNotNullParameter(started_at, "started_at");
        Intrinsics.checkNotNullParameter(ended_at, "ended_at");
        Intrinsics.checkNotNullParameter(players, "players");
        Intrinsics.checkNotNullParameter(events, "events");
        return new MTGame(id, format, subformat, playgroup, created_by, winner, started_at, ended_at, set, players, events, pausetime, published, tags, note);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTGame)) {
            return false;
        }
        MTGame mTGame = (MTGame) other;
        return this.id == mTGame.id && Intrinsics.areEqual(this.format, mTGame.format) && Intrinsics.areEqual(this.subformat, mTGame.subformat) && Intrinsics.areEqual(this.playgroup, mTGame.playgroup) && Intrinsics.areEqual(this.created_by, mTGame.created_by) && Intrinsics.areEqual(this.winner, mTGame.winner) && Intrinsics.areEqual(this.started_at, mTGame.started_at) && Intrinsics.areEqual(this.ended_at, mTGame.ended_at) && Intrinsics.areEqual(this.set, mTGame.set) && Intrinsics.areEqual(this.players, mTGame.players) && Intrinsics.areEqual(this.events, mTGame.events) && Intrinsics.areEqual(this.pausetime, mTGame.pausetime) && Intrinsics.areEqual(this.published, mTGame.published) && Intrinsics.areEqual(this.tags, mTGame.tags) && Intrinsics.areEqual(this.note, mTGame.note);
    }

    public final MTUser getCreated_by() {
        return this.created_by;
    }

    public final String getEnded_at() {
        return this.ended_at;
    }

    public final List<MTGameEvent> getEvents() {
        return this.events;
    }

    public final MTGameFormat getFormat() {
        return this.format;
    }

    public final int getId() {
        return this.id;
    }

    public final String getNote() {
        return this.note;
    }

    public final Integer getPausetime() {
        return this.pausetime;
    }

    public final List<MTGamePlayer> getPlayers() {
        return this.players;
    }

    public final MTGamePlaygroup getPlaygroup() {
        return this.playgroup;
    }

    public final Boolean getPublished() {
        return this.published;
    }

    public final MTSet getSet() {
        return this.set;
    }

    public final String getStarted_at() {
        return this.started_at;
    }

    public final MTGameSubformat getSubformat() {
        return this.subformat;
    }

    public final List<MTTag> getTags() {
        return this.tags;
    }

    public final MTUser getWinner() {
        return this.winner;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.id) * 31;
        MTGameFormat mTGameFormat = this.format;
        int iHashCode2 = (iHashCode + (mTGameFormat == null ? 0 : mTGameFormat.hashCode())) * 31;
        MTGameSubformat mTGameSubformat = this.subformat;
        int iHashCode3 = (iHashCode2 + (mTGameSubformat == null ? 0 : mTGameSubformat.hashCode())) * 31;
        MTGamePlaygroup mTGamePlaygroup = this.playgroup;
        int iHashCode4 = (iHashCode3 + (mTGamePlaygroup == null ? 0 : mTGamePlaygroup.hashCode())) * 31;
        MTUser mTUser = this.created_by;
        int iHashCode5 = (iHashCode4 + (mTUser == null ? 0 : mTUser.hashCode())) * 31;
        MTUser mTUser2 = this.winner;
        int iHashCode6 = (((((iHashCode5 + (mTUser2 == null ? 0 : mTUser2.hashCode())) * 31) + this.started_at.hashCode()) * 31) + this.ended_at.hashCode()) * 31;
        MTSet mTSet = this.set;
        int iHashCode7 = (((((iHashCode6 + (mTSet == null ? 0 : mTSet.hashCode())) * 31) + this.players.hashCode()) * 31) + this.events.hashCode()) * 31;
        Integer num = this.pausetime;
        int iHashCode8 = (iHashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.published;
        int iHashCode9 = (iHashCode8 + (bool == null ? 0 : bool.hashCode())) * 31;
        List<MTTag> list = this.tags;
        int iHashCode10 = (iHashCode9 + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.note;
        return iHashCode10 + (str != null ? str.hashCode() : 0);
    }

    public final void setCreated_by(MTUser mTUser) {
        this.created_by = mTUser;
    }

    public final void setEnded_at(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ended_at = str;
    }

    public final void setEvents(List<MTGameEvent> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.events = list;
    }

    public final void setFormat(MTGameFormat mTGameFormat) {
        this.format = mTGameFormat;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setNote(String str) {
        this.note = str;
    }

    public final void setPausetime(Integer num) {
        this.pausetime = num;
    }

    public final void setPlayers(List<MTGamePlayer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.players = list;
    }

    public final void setPlaygroup(MTGamePlaygroup mTGamePlaygroup) {
        this.playgroup = mTGamePlaygroup;
    }

    public final void setPublished(Boolean bool) {
        this.published = bool;
    }

    public final void setSet(MTSet mTSet) {
        this.set = mTSet;
    }

    public final void setStarted_at(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.started_at = str;
    }

    public final void setSubformat(MTGameSubformat mTGameSubformat) {
        this.subformat = mTGameSubformat;
    }

    public final void setTags(List<MTTag> list) {
        this.tags = list;
    }

    public final void setWinner(MTUser mTUser) {
        this.winner = mTUser;
    }

    public String toString() {
        return "MTGame(id=" + this.id + ", format=" + this.format + ", subformat=" + this.subformat + ", playgroup=" + this.playgroup + ", created_by=" + this.created_by + ", winner=" + this.winner + ", started_at=" + this.started_at + ", ended_at=" + this.ended_at + ", set=" + this.set + ", players=" + this.players + ", events=" + this.events + ", pausetime=" + this.pausetime + ", published=" + this.published + ", tags=" + this.tags + ", note=" + this.note + ")";
    }
}
