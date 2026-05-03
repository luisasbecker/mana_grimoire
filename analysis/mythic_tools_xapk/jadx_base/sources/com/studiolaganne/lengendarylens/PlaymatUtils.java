package com.studiolaganne.lengendarylens;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlaymatUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlaymatUtils;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "playmatSets", "", "Lcom/studiolaganne/lengendarylens/PlaymatSet;", "getPlaymatSets", "findSetByName", "name", "", "findSetForPlaymat", "id", "playmatSetIndex", "", "set", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlaymatUtils {
    public static final int $stable = 8;
    private Context context;
    private List<PlaymatSet> playmatSets;

    public PlaymatUtils(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.playmatSets = new ArrayList();
        ArrayList arrayList = new ArrayList();
        String string = this.context.getString(R.string.playmat_basic_plains);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        arrayList.add(new Playmat("playmat_new_plains", string));
        String string2 = this.context.getString(R.string.playmat_basic_island);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        arrayList.add(new Playmat("playmat_new_island", string2));
        String string3 = this.context.getString(R.string.playmat_basic_swamp);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        arrayList.add(new Playmat("playmat_new_swamp", string3));
        String string4 = this.context.getString(R.string.playmat_basic_mountain);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        arrayList.add(new Playmat("playmat_new_mountain", string4));
        String string5 = this.context.getString(R.string.playmat_basic_forest);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        arrayList.add(new Playmat("playmat_new_forest", string5));
        String string6 = this.context.getString(R.string.playmat_basic_wastes);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        arrayList.add(new Playmat("playmat_new_wastes", string6));
        List<PlaymatSet> list = this.playmatSets;
        String string7 = this.context.getString(R.string.basic_playmats);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        list.add(new PlaymatSet(string7, arrayList));
        ArrayList arrayList2 = new ArrayList();
        String string8 = this.context.getString(R.string.playmat_cascade);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        arrayList2.add(new Playmat("playmat_new_cascade", string8));
        String string9 = this.context.getString(R.string.playmat_desert_city);
        Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
        arrayList2.add(new Playmat("playmat_new_desert_city", string9));
        String string10 = this.context.getString(R.string.playmat_lake);
        Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
        arrayList2.add(new Playmat("playmat_new_lake", string10));
        String string11 = this.context.getString(R.string.playmat_spaceshift);
        Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
        arrayList2.add(new Playmat("playmat_new_spaceshift", string11));
        String string12 = this.context.getString(R.string.playmat_castle);
        Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
        arrayList2.add(new Playmat("playmat_new_castle", string12));
        String string13 = this.context.getString(R.string.playmat_desert);
        Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
        arrayList2.add(new Playmat("playmat_new_desert", string13));
        String string14 = this.context.getString(R.string.playmat_lava);
        Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
        arrayList2.add(new Playmat("playmat_new_lava", string14));
        String string15 = this.context.getString(R.string.playmat_witch_cottage);
        Intrinsics.checkNotNullExpressionValue(string15, "getString(...)");
        arrayList2.add(new Playmat("playmat_new_witch_cottage", string15));
        String string16 = this.context.getString(R.string.playmat_cave);
        Intrinsics.checkNotNullExpressionValue(string16, "getString(...)");
        arrayList2.add(new Playmat("playmat_new_cave", string16));
        String string17 = this.context.getString(R.string.playmat_dragon_island);
        Intrinsics.checkNotNullExpressionValue(string17, "getString(...)");
        arrayList2.add(new Playmat("playmat_new_dragon_island", string17));
        String string18 = this.context.getString(R.string.playmat_ocean);
        Intrinsics.checkNotNullExpressionValue(string18, "getString(...)");
        arrayList2.add(new Playmat("playmat_new_ocean", string18));
        String string19 = this.context.getString(R.string.playmat_woods);
        Intrinsics.checkNotNullExpressionValue(string19, "getString(...)");
        arrayList2.add(new Playmat("playmat_new_woods", string19));
        String string20 = this.context.getString(R.string.playmat_city);
        Intrinsics.checkNotNullExpressionValue(string20, "getString(...)");
        arrayList2.add(new Playmat("playmat_new_city", string20));
        String string21 = this.context.getString(R.string.playmat_rocks);
        Intrinsics.checkNotNullExpressionValue(string21, "getString(...)");
        arrayList2.add(new Playmat("playmat_new_flying_rocks", string21));
        String string22 = this.context.getString(R.string.playmat_portal);
        Intrinsics.checkNotNullExpressionValue(string22, "getString(...)");
        arrayList2.add(new Playmat("playmat_new_portal", string22));
        String string23 = this.context.getString(R.string.playmat_coast);
        Intrinsics.checkNotNullExpressionValue(string23, "getString(...)");
        arrayList2.add(new Playmat("playmat_new_coast", string23));
        String string24 = this.context.getString(R.string.playmat_rain_forest);
        Intrinsics.checkNotNullExpressionValue(string24, "getString(...)");
        arrayList2.add(new Playmat("playmat_new_forest_glow", string24));
        String string25 = this.context.getString(R.string.playmat_snow);
        Intrinsics.checkNotNullExpressionValue(string25, "getString(...)");
        arrayList2.add(new Playmat("playmat_new_snow", string25));
        String string26 = this.context.getString(R.string.playmat_dark_castle);
        Intrinsics.checkNotNullExpressionValue(string26, "getString(...)");
        arrayList2.add(new Playmat("playmat_new_dark_castle", string26));
        String string27 = this.context.getString(R.string.playmat_jungle);
        Intrinsics.checkNotNullExpressionValue(string27, "getString(...)");
        arrayList2.add(new Playmat("playmat_new_jungle", string27));
        String string28 = this.context.getString(R.string.playmat_space);
        Intrinsics.checkNotNullExpressionValue(string28, "getString(...)");
        arrayList2.add(new Playmat("playmat_new_space", string28));
        List<PlaymatSet> list2 = this.playmatSets;
        String string29 = this.context.getString(R.string.scenery_playmats);
        Intrinsics.checkNotNullExpressionValue(string29, "getString(...)");
        list2.add(new PlaymatSet(string29, arrayList2));
        ArrayList arrayList3 = new ArrayList();
        String string30 = this.context.getString(R.string.playmat_creature_angel);
        Intrinsics.checkNotNullExpressionValue(string30, "getString(...)");
        arrayList3.add(new Playmat("creature_playmat_angel", string30));
        String string31 = this.context.getString(R.string.playmat_creature_cat);
        Intrinsics.checkNotNullExpressionValue(string31, "getString(...)");
        arrayList3.add(new Playmat("creature_playmat_cat", string31));
        String string32 = this.context.getString(R.string.playmat_creature_demon);
        Intrinsics.checkNotNullExpressionValue(string32, "getString(...)");
        arrayList3.add(new Playmat("creature_playmat_demon", string32));
        String string33 = this.context.getString(R.string.playmat_creature_elf);
        Intrinsics.checkNotNullExpressionValue(string33, "getString(...)");
        arrayList3.add(new Playmat("creature_playmat_elf", string33));
        String string34 = this.context.getString(R.string.playmat_creature_faerie);
        Intrinsics.checkNotNullExpressionValue(string34, "getString(...)");
        arrayList3.add(new Playmat("creature_playmat_faerie", string34));
        String string35 = this.context.getString(R.string.playmat_creature_goblin);
        Intrinsics.checkNotNullExpressionValue(string35, "getString(...)");
        arrayList3.add(new Playmat("creature_playmat_goblin", string35));
        String string36 = this.context.getString(R.string.playmat_creature_human);
        Intrinsics.checkNotNullExpressionValue(string36, "getString(...)");
        arrayList3.add(new Playmat("creature_playmat_human", string36));
        String string37 = this.context.getString(R.string.playmat_creature_merfolk);
        Intrinsics.checkNotNullExpressionValue(string37, "getString(...)");
        arrayList3.add(new Playmat("creature_playmat_merfolk", string37));
        String string38 = this.context.getString(R.string.playmat_creature_pirate);
        Intrinsics.checkNotNullExpressionValue(string38, "getString(...)");
        arrayList3.add(new Playmat("creature_playmat_pirate", string38));
        String string39 = this.context.getString(R.string.playmat_creature_rats);
        Intrinsics.checkNotNullExpressionValue(string39, "getString(...)");
        arrayList3.add(new Playmat("creature_playmat_rats", string39));
        String string40 = this.context.getString(R.string.playmat_creature_vampire);
        Intrinsics.checkNotNullExpressionValue(string40, "getString(...)");
        arrayList3.add(new Playmat("creature_playmat_vampire", string40));
        String string41 = this.context.getString(R.string.playmat_creature_wolves);
        Intrinsics.checkNotNullExpressionValue(string41, "getString(...)");
        arrayList3.add(new Playmat("creature_playmat_wolves", string41));
        String string42 = this.context.getString(R.string.playmat_creature_zombie);
        Intrinsics.checkNotNullExpressionValue(string42, "getString(...)");
        arrayList3.add(new Playmat("creature_playmat_zombie", string42));
        List<PlaymatSet> list3 = this.playmatSets;
        String string43 = this.context.getString(R.string.creature_playmats);
        Intrinsics.checkNotNullExpressionValue(string43, "getString(...)");
        list3.add(new PlaymatSet(string43, arrayList3));
        ArrayList arrayList4 = new ArrayList();
        String string44 = this.context.getString(R.string.playmat_azorius);
        Intrinsics.checkNotNullExpressionValue(string44, "getString(...)");
        arrayList4.add(new Playmat("guild_playmat_azorius", string44));
        String string45 = this.context.getString(R.string.playmat_boros);
        Intrinsics.checkNotNullExpressionValue(string45, "getString(...)");
        arrayList4.add(new Playmat("guild_playmat_boros", string45));
        String string46 = this.context.getString(R.string.playmat_dimir);
        Intrinsics.checkNotNullExpressionValue(string46, "getString(...)");
        arrayList4.add(new Playmat("guild_playmat_dimir", string46));
        String string47 = this.context.getString(R.string.playmat_golgari);
        Intrinsics.checkNotNullExpressionValue(string47, "getString(...)");
        arrayList4.add(new Playmat("guild_playmat_golgari", string47));
        String string48 = this.context.getString(R.string.playmat_gruul);
        Intrinsics.checkNotNullExpressionValue(string48, "getString(...)");
        arrayList4.add(new Playmat("guild_playmat_gruul", string48));
        String string49 = this.context.getString(R.string.playmat_izzet);
        Intrinsics.checkNotNullExpressionValue(string49, "getString(...)");
        arrayList4.add(new Playmat("guild_playmat_izzet", string49));
        String string50 = this.context.getString(R.string.playmat_orzhov);
        Intrinsics.checkNotNullExpressionValue(string50, "getString(...)");
        arrayList4.add(new Playmat("guild_playmat_orzhov", string50));
        String string51 = this.context.getString(R.string.playmat_rakdos);
        Intrinsics.checkNotNullExpressionValue(string51, "getString(...)");
        arrayList4.add(new Playmat("guild_playmat_rakdos", string51));
        String string52 = this.context.getString(R.string.playmat_selesnya);
        Intrinsics.checkNotNullExpressionValue(string52, "getString(...)");
        arrayList4.add(new Playmat("guild_playmat_selesnya", string52));
        String string53 = this.context.getString(R.string.playmat_simic);
        Intrinsics.checkNotNullExpressionValue(string53, "getString(...)");
        arrayList4.add(new Playmat("guild_playmat_simic", string53));
        List<PlaymatSet> list4 = this.playmatSets;
        String string54 = this.context.getString(R.string.guild_playmats);
        Intrinsics.checkNotNullExpressionValue(string54, "getString(...)");
        list4.add(new PlaymatSet(string54, arrayList4));
        List<String> unlockedPlaymats = new PreferencesManager(this.context).getUnlockedPlaymats();
        if (unlockedPlaymats.isEmpty()) {
            return;
        }
        ArrayList arrayList5 = new ArrayList();
        Iterator<T> it = unlockedPlaymats.iterator();
        int i = 0;
        while (it.hasNext()) {
            i++;
            arrayList5.add(new Playmat((String) it.next(), "Playmat " + i));
        }
        List<PlaymatSet> list5 = this.playmatSets;
        String string55 = this.context.getString(R.string.exclusive_playmats);
        Intrinsics.checkNotNullExpressionValue(string55, "getString(...)");
        list5.add(new PlaymatSet(string55, arrayList5));
    }

    private final PlaymatSet findSetByName(String name) {
        Object next;
        Iterator<T> it = this.playmatSets.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((PlaymatSet) next).getName(), name)) {
                break;
            }
        }
        return (PlaymatSet) next;
    }

    private final PlaymatSet findSetForPlaymat(String id) {
        Object obj;
        PlaymatSet next;
        Iterator<PlaymatSet> it = this.playmatSets.iterator();
        do {
            obj = null;
            if (!it.hasNext()) {
                return null;
            }
            next = it.next();
            Iterator<T> it2 = next.getPlaymats().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                if (Intrinsics.areEqual(((Playmat) next2).getId(), id)) {
                    obj = next2;
                    break;
                }
            }
        } while (((Playmat) obj) == null);
        return next;
    }

    private final int playmatSetIndex(PlaymatSet set) {
        int i = 0;
        for (Object obj : this.playmatSets) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(((PlaymatSet) obj).getName(), set.getName())) {
                return i;
            }
            i = i2;
        }
        return 0;
    }

    public final Context getContext() {
        return this.context;
    }

    public final List<PlaymatSet> getPlaymatSets() {
        return this.playmatSets;
    }

    public final void setContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }
}
