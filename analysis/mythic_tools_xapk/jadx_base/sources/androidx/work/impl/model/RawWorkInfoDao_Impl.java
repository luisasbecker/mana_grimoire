package androidx.work.impl.model;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import com.facebook.internal.ServerProtocol;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes3.dex */
public final class RawWorkInfoDao_Impl implements RawWorkInfoDao {
    private final RoomDatabase __db;

    public RawWorkInfoDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipWorkProgressAsandroidxWorkData(HashMap<String, ArrayList<Data>> map) {
        int i;
        Set<String> setKeySet = map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (map.size() > 999) {
            HashMap<String, ArrayList<Data>> map2 = new HashMap<>(999);
            loop0: while (true) {
                i = 0;
                for (String str : setKeySet) {
                    map2.put(str, map.get(str));
                    i++;
                    if (i == 999) {
                        break;
                    }
                }
                __fetchRelationshipWorkProgressAsandroidxWorkData(map2);
                map2 = new HashMap<>(999);
            }
            if (i > 0) {
                __fetchRelationshipWorkProgressAsandroidxWorkData(map2);
                return;
            }
            return;
        }
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
        int size = setKeySet.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size);
        int i2 = 1;
        for (String str2 : setKeySet) {
            if (str2 == null) {
                roomSQLiteQueryAcquire.bindNull(i2);
            } else {
                roomSQLiteQueryAcquire.bindString(i2, str2);
            }
            i2++;
        }
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(cursorQuery, "work_spec_id");
            if (columnIndex == -1) {
                return;
            }
            while (cursorQuery.moveToNext()) {
                ArrayList<Data> arrayList = map.get(cursorQuery.getString(columnIndex));
                if (arrayList != null) {
                    arrayList.add(Data.fromByteArray(cursorQuery.isNull(0) ? null : cursorQuery.getBlob(0)));
                }
            }
        } finally {
            cursorQuery.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipWorkTagAsjavaLangString(HashMap<String, ArrayList<String>> map) {
        int i;
        Set<String> setKeySet = map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (map.size() > 999) {
            HashMap<String, ArrayList<String>> map2 = new HashMap<>(999);
            loop0: while (true) {
                i = 0;
                for (String str : setKeySet) {
                    map2.put(str, map.get(str));
                    i++;
                    if (i == 999) {
                        break;
                    }
                }
                __fetchRelationshipWorkTagAsjavaLangString(map2);
                map2 = new HashMap<>(999);
            }
            if (i > 0) {
                __fetchRelationshipWorkTagAsjavaLangString(map2);
                return;
            }
            return;
        }
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
        int size = setKeySet.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size);
        int i2 = 1;
        for (String str2 : setKeySet) {
            if (str2 == null) {
                roomSQLiteQueryAcquire.bindNull(i2);
            } else {
                roomSQLiteQueryAcquire.bindString(i2, str2);
            }
            i2++;
        }
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(cursorQuery, "work_spec_id");
            if (columnIndex == -1) {
                return;
            }
            while (cursorQuery.moveToNext()) {
                ArrayList<String> arrayList = map.get(cursorQuery.getString(columnIndex));
                if (arrayList != null) {
                    arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                }
            }
        } finally {
            cursorQuery.close();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public List<WorkSpec.WorkInfoPojo> getWorkInfoPojos(SupportSQLiteQuery supportSQLiteQuery) {
        WorkInfo.State stateIntToState;
        Data dataFromByteArray;
        BackoffPolicy backoffPolicyIntToBackoffPolicy;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        NetworkType networkTypeIntToNetworkType;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Set<Constraints.ContentUriTrigger> setByteArrayToSetOfTriggers;
        int i7;
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, supportSQLiteQuery, true, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(cursorQuery, "id");
            int columnIndex2 = CursorUtil.getColumnIndex(cursorQuery, ServerProtocol.DIALOG_PARAM_STATE);
            int columnIndex3 = CursorUtil.getColumnIndex(cursorQuery, "output");
            int columnIndex4 = CursorUtil.getColumnIndex(cursorQuery, "initial_delay");
            int columnIndex5 = CursorUtil.getColumnIndex(cursorQuery, "interval_duration");
            int columnIndex6 = CursorUtil.getColumnIndex(cursorQuery, "flex_duration");
            int columnIndex7 = CursorUtil.getColumnIndex(cursorQuery, "run_attempt_count");
            int columnIndex8 = CursorUtil.getColumnIndex(cursorQuery, "backoff_policy");
            int columnIndex9 = CursorUtil.getColumnIndex(cursorQuery, "backoff_delay_duration");
            int columnIndex10 = CursorUtil.getColumnIndex(cursorQuery, "last_enqueue_time");
            int columnIndex11 = CursorUtil.getColumnIndex(cursorQuery, "period_count");
            int columnIndex12 = CursorUtil.getColumnIndex(cursorQuery, "generation");
            int columnIndex13 = CursorUtil.getColumnIndex(cursorQuery, "next_schedule_time_override");
            int columnIndex14 = CursorUtil.getColumnIndex(cursorQuery, "stop_reason");
            int columnIndex15 = CursorUtil.getColumnIndex(cursorQuery, "required_network_type");
            int columnIndex16 = CursorUtil.getColumnIndex(cursorQuery, "requires_charging");
            int columnIndex17 = CursorUtil.getColumnIndex(cursorQuery, "requires_device_idle");
            int columnIndex18 = CursorUtil.getColumnIndex(cursorQuery, "requires_battery_not_low");
            int columnIndex19 = CursorUtil.getColumnIndex(cursorQuery, "requires_storage_not_low");
            int columnIndex20 = CursorUtil.getColumnIndex(cursorQuery, "trigger_content_update_delay");
            int columnIndex21 = CursorUtil.getColumnIndex(cursorQuery, "trigger_max_content_delay");
            int columnIndex22 = CursorUtil.getColumnIndex(cursorQuery, "content_uri_triggers");
            HashMap<String, ArrayList<String>> map = new HashMap<>();
            int i8 = columnIndex13;
            HashMap<String, ArrayList<Data>> map2 = new HashMap<>();
            while (cursorQuery.moveToNext()) {
                int i9 = columnIndex12;
                String string = cursorQuery.getString(columnIndex);
                if (map.get(string) == null) {
                    i7 = columnIndex11;
                    map.put(string, new ArrayList<>());
                } else {
                    i7 = columnIndex11;
                }
                String string2 = cursorQuery.getString(columnIndex);
                if (map2.get(string2) == null) {
                    map2.put(string2, new ArrayList<>());
                }
                columnIndex12 = i9;
                columnIndex11 = i7;
            }
            int i10 = columnIndex11;
            int i11 = columnIndex12;
            int i12 = -1;
            cursorQuery.moveToPosition(-1);
            __fetchRelationshipWorkTagAsjavaLangString(map);
            __fetchRelationshipWorkProgressAsandroidxWorkData(map2);
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                String string3 = (columnIndex == i12 || cursorQuery.isNull(columnIndex)) ? null : cursorQuery.getString(columnIndex);
                if (columnIndex2 == i12) {
                    stateIntToState = null;
                } else {
                    int i13 = cursorQuery.getInt(columnIndex2);
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    stateIntToState = WorkTypeConverters.intToState(i13);
                }
                if (columnIndex3 == i12) {
                    dataFromByteArray = null;
                } else {
                    dataFromByteArray = Data.fromByteArray(cursorQuery.isNull(columnIndex3) ? null : cursorQuery.getBlob(columnIndex3));
                }
                long j = columnIndex4 == i12 ? 0L : cursorQuery.getLong(columnIndex4);
                long j2 = columnIndex5 == i12 ? 0L : cursorQuery.getLong(columnIndex5);
                long j3 = columnIndex6 == i12 ? 0L : cursorQuery.getLong(columnIndex6);
                int i14 = columnIndex7 == i12 ? 0 : cursorQuery.getInt(columnIndex7);
                if (columnIndex8 == i12) {
                    backoffPolicyIntToBackoffPolicy = null;
                } else {
                    int i15 = cursorQuery.getInt(columnIndex8);
                    WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                    backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i15);
                }
                long j4 = columnIndex9 == i12 ? 0L : cursorQuery.getLong(columnIndex9);
                long j5 = columnIndex10 == i12 ? 0L : cursorQuery.getLong(columnIndex10);
                int i16 = i10;
                if (i16 == i12) {
                    int i17 = i11;
                    i = columnIndex2;
                    i2 = i17;
                    i3 = 0;
                } else {
                    int i18 = i11;
                    i = columnIndex2;
                    i2 = i18;
                    i3 = cursorQuery.getInt(i16);
                }
                if (i2 == i12) {
                    int i19 = i8;
                    i4 = i2;
                    i5 = i19;
                    i6 = 0;
                } else {
                    int i20 = cursorQuery.getInt(i2);
                    int i21 = i8;
                    i4 = i2;
                    i5 = i21;
                    i6 = i20;
                }
                long j6 = i5 == i12 ? 0L : cursorQuery.getLong(i5);
                int i22 = i5;
                int i23 = columnIndex14;
                int i24 = i23 == i12 ? 0 : cursorQuery.getInt(i23);
                columnIndex14 = i23;
                int i25 = columnIndex15;
                if (i25 == i12) {
                    networkTypeIntToNetworkType = null;
                } else {
                    int i26 = cursorQuery.getInt(i25);
                    WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                    networkTypeIntToNetworkType = WorkTypeConverters.intToNetworkType(i26);
                }
                columnIndex15 = i25;
                int i27 = columnIndex16;
                if (i27 == i12) {
                    z = false;
                } else {
                    z = cursorQuery.getInt(i27) != 0;
                }
                columnIndex16 = i27;
                int i28 = columnIndex17;
                if (i28 == i12) {
                    z2 = false;
                } else {
                    z2 = cursorQuery.getInt(i28) != 0;
                }
                columnIndex17 = i28;
                int i29 = columnIndex18;
                if (i29 == i12) {
                    z3 = false;
                } else {
                    z3 = cursorQuery.getInt(i29) != 0;
                }
                columnIndex18 = i29;
                int i30 = columnIndex19;
                if (i30 == i12) {
                    z4 = false;
                } else {
                    z4 = cursorQuery.getInt(i30) != 0;
                }
                columnIndex19 = i30;
                int i31 = columnIndex20;
                long j7 = i31 == i12 ? 0L : cursorQuery.getLong(i31);
                columnIndex20 = i31;
                int i32 = columnIndex21;
                long j8 = i32 != i12 ? cursorQuery.getLong(i32) : 0L;
                columnIndex21 = i32;
                int i33 = columnIndex22;
                long j9 = j8;
                if (i33 == i12) {
                    setByteArrayToSetOfTriggers = null;
                } else {
                    byte[] blob = cursorQuery.isNull(i33) ? null : cursorQuery.getBlob(i33);
                    WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                    setByteArrayToSetOfTriggers = WorkTypeConverters.byteArrayToSetOfTriggers(blob);
                }
                Constraints constraints = new Constraints(networkTypeIntToNetworkType, z, z2, z3, z4, j7, j9, setByteArrayToSetOfTriggers);
                ArrayList<String> arrayList2 = map.get(cursorQuery.getString(columnIndex));
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                }
                HashMap<String, ArrayList<String>> map3 = map;
                ArrayList<Data> arrayList3 = map2.get(cursorQuery.getString(columnIndex));
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList<>();
                }
                arrayList.add(new WorkSpec.WorkInfoPojo(string3, stateIntToState, dataFromByteArray, j, j2, j3, constraints, i14, backoffPolicyIntToBackoffPolicy, j4, j5, i3, i6, j6, i24, arrayList2, arrayList3));
                columnIndex22 = i33;
                columnIndex2 = i;
                map = map3;
                i12 = -1;
                i11 = i4;
                i8 = i22;
                i10 = i16;
            }
            return arrayList;
        } finally {
            cursorQuery.close();
        }
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public Flow<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosFlow(final SupportSQLiteQuery supportSQLiteQuery) {
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, new Callable<List<WorkSpec.WorkInfoPojo>>() { // from class: androidx.work.impl.model.RawWorkInfoDao_Impl.2
            @Override // java.util.concurrent.Callable
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                WorkInfo.State stateIntToState;
                Data dataFromByteArray;
                BackoffPolicy backoffPolicyIntToBackoffPolicy;
                int i;
                int i2;
                int i3;
                int i4;
                int i5;
                int i6;
                long j;
                int i7;
                int i8;
                int i9;
                int i10;
                int i11;
                int i12;
                int i13;
                NetworkType networkTypeIntToNetworkType;
                int i14;
                int i15;
                boolean z;
                int i16;
                int i17;
                boolean z2;
                int i18;
                int i19;
                boolean z3;
                int i20;
                int i21;
                boolean z4;
                long j2;
                int i22;
                int i23;
                Set<Constraints.ContentUriTrigger> setByteArrayToSetOfTriggers;
                int i24;
                Cursor cursorQuery = DBUtil.query(RawWorkInfoDao_Impl.this.__db, supportSQLiteQuery, true, null);
                try {
                    int columnIndex = CursorUtil.getColumnIndex(cursorQuery, "id");
                    int columnIndex2 = CursorUtil.getColumnIndex(cursorQuery, ServerProtocol.DIALOG_PARAM_STATE);
                    int columnIndex3 = CursorUtil.getColumnIndex(cursorQuery, "output");
                    int columnIndex4 = CursorUtil.getColumnIndex(cursorQuery, "initial_delay");
                    int columnIndex5 = CursorUtil.getColumnIndex(cursorQuery, "interval_duration");
                    int columnIndex6 = CursorUtil.getColumnIndex(cursorQuery, "flex_duration");
                    int columnIndex7 = CursorUtil.getColumnIndex(cursorQuery, "run_attempt_count");
                    int columnIndex8 = CursorUtil.getColumnIndex(cursorQuery, "backoff_policy");
                    int columnIndex9 = CursorUtil.getColumnIndex(cursorQuery, "backoff_delay_duration");
                    int columnIndex10 = CursorUtil.getColumnIndex(cursorQuery, "last_enqueue_time");
                    int columnIndex11 = CursorUtil.getColumnIndex(cursorQuery, "period_count");
                    int columnIndex12 = CursorUtil.getColumnIndex(cursorQuery, "generation");
                    int columnIndex13 = CursorUtil.getColumnIndex(cursorQuery, "next_schedule_time_override");
                    int columnIndex14 = CursorUtil.getColumnIndex(cursorQuery, "stop_reason");
                    int columnIndex15 = CursorUtil.getColumnIndex(cursorQuery, "required_network_type");
                    int columnIndex16 = CursorUtil.getColumnIndex(cursorQuery, "requires_charging");
                    int columnIndex17 = CursorUtil.getColumnIndex(cursorQuery, "requires_device_idle");
                    int columnIndex18 = CursorUtil.getColumnIndex(cursorQuery, "requires_battery_not_low");
                    int columnIndex19 = CursorUtil.getColumnIndex(cursorQuery, "requires_storage_not_low");
                    int columnIndex20 = CursorUtil.getColumnIndex(cursorQuery, "trigger_content_update_delay");
                    int columnIndex21 = CursorUtil.getColumnIndex(cursorQuery, "trigger_max_content_delay");
                    int columnIndex22 = CursorUtil.getColumnIndex(cursorQuery, "content_uri_triggers");
                    HashMap map = new HashMap();
                    int i25 = columnIndex13;
                    HashMap map2 = new HashMap();
                    while (cursorQuery.moveToNext()) {
                        int i26 = columnIndex12;
                        String string = cursorQuery.getString(columnIndex);
                        if (((ArrayList) map.get(string)) == null) {
                            i24 = columnIndex11;
                            map.put(string, new ArrayList());
                        } else {
                            i24 = columnIndex11;
                        }
                        String string2 = cursorQuery.getString(columnIndex);
                        if (((ArrayList) map2.get(string2)) == null) {
                            map2.put(string2, new ArrayList());
                        }
                        columnIndex12 = i26;
                        columnIndex11 = i24;
                    }
                    int i27 = columnIndex11;
                    int i28 = columnIndex12;
                    int i29 = -1;
                    cursorQuery.moveToPosition(-1);
                    RawWorkInfoDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(map);
                    RawWorkInfoDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(map2);
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string3 = (columnIndex == i29 || cursorQuery.isNull(columnIndex)) ? null : cursorQuery.getString(columnIndex);
                        if (columnIndex2 == i29) {
                            stateIntToState = null;
                        } else {
                            int i30 = cursorQuery.getInt(columnIndex2);
                            WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                            stateIntToState = WorkTypeConverters.intToState(i30);
                        }
                        if (columnIndex3 == i29) {
                            dataFromByteArray = null;
                        } else {
                            dataFromByteArray = Data.fromByteArray(cursorQuery.isNull(columnIndex3) ? null : cursorQuery.getBlob(columnIndex3));
                        }
                        long j3 = columnIndex4 == i29 ? 0L : cursorQuery.getLong(columnIndex4);
                        long j4 = columnIndex5 == i29 ? 0L : cursorQuery.getLong(columnIndex5);
                        long j5 = columnIndex6 == i29 ? 0L : cursorQuery.getLong(columnIndex6);
                        int i31 = columnIndex7 == i29 ? 0 : cursorQuery.getInt(columnIndex7);
                        if (columnIndex8 == i29) {
                            backoffPolicyIntToBackoffPolicy = null;
                        } else {
                            int i32 = cursorQuery.getInt(columnIndex8);
                            WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                            backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i32);
                        }
                        long j6 = columnIndex9 == i29 ? 0L : cursorQuery.getLong(columnIndex9);
                        long j7 = columnIndex10 == i29 ? 0L : cursorQuery.getLong(columnIndex10);
                        int i33 = i27;
                        if (i33 == i29) {
                            int i34 = i28;
                            i = columnIndex2;
                            i2 = i34;
                            i3 = 0;
                        } else {
                            int i35 = i28;
                            i = columnIndex2;
                            i2 = i35;
                            i3 = cursorQuery.getInt(i33);
                        }
                        if (i2 == i29) {
                            int i36 = i25;
                            i4 = i2;
                            i5 = i36;
                            i6 = 0;
                        } else {
                            int i37 = cursorQuery.getInt(i2);
                            int i38 = i25;
                            i4 = i2;
                            i5 = i38;
                            i6 = i37;
                        }
                        if (i5 == i29) {
                            int i39 = columnIndex14;
                            i7 = i5;
                            i8 = i39;
                            j = 0;
                        } else {
                            j = cursorQuery.getLong(i5);
                            int i40 = columnIndex14;
                            i7 = i5;
                            i8 = i40;
                        }
                        if (i8 == i29) {
                            int i41 = columnIndex15;
                            i9 = i8;
                            i10 = i41;
                            i11 = 0;
                        } else {
                            int i42 = cursorQuery.getInt(i8);
                            int i43 = columnIndex15;
                            i9 = i8;
                            i10 = i43;
                            i11 = i42;
                        }
                        if (i10 == i29) {
                            int i44 = columnIndex16;
                            i12 = i10;
                            i13 = i44;
                            networkTypeIntToNetworkType = null;
                        } else {
                            int i45 = cursorQuery.getInt(i10);
                            WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                            int i46 = columnIndex16;
                            i12 = i10;
                            i13 = i46;
                            networkTypeIntToNetworkType = WorkTypeConverters.intToNetworkType(i45);
                        }
                        if (i13 == i29) {
                            int i47 = columnIndex17;
                            i14 = i13;
                            i15 = i47;
                            z = false;
                        } else {
                            boolean z5 = cursorQuery.getInt(i13) != 0;
                            int i48 = columnIndex17;
                            i14 = i13;
                            i15 = i48;
                            z = z5;
                        }
                        if (i15 == i29) {
                            int i49 = columnIndex18;
                            i16 = i15;
                            i17 = i49;
                            z2 = false;
                        } else {
                            boolean z6 = cursorQuery.getInt(i15) != 0;
                            int i50 = columnIndex18;
                            i16 = i15;
                            i17 = i50;
                            z2 = z6;
                        }
                        if (i17 == i29) {
                            int i51 = columnIndex19;
                            i18 = i17;
                            i19 = i51;
                            z3 = false;
                        } else {
                            boolean z7 = cursorQuery.getInt(i17) != 0;
                            int i52 = columnIndex19;
                            i18 = i17;
                            i19 = i52;
                            z3 = z7;
                        }
                        if (i19 == i29) {
                            int i53 = columnIndex20;
                            i20 = i19;
                            i21 = i53;
                            z4 = false;
                        } else {
                            boolean z8 = cursorQuery.getInt(i19) != 0;
                            int i54 = columnIndex20;
                            i20 = i19;
                            i21 = i54;
                            z4 = z8;
                        }
                        if (i21 == i29) {
                            int i55 = columnIndex21;
                            i22 = i21;
                            i23 = i55;
                            j2 = 0;
                        } else {
                            j2 = cursorQuery.getLong(i21);
                            int i56 = columnIndex21;
                            i22 = i21;
                            i23 = i56;
                        }
                        int i57 = columnIndex22;
                        int i58 = i23;
                        long j8 = i23 != i29 ? cursorQuery.getLong(i23) : 0L;
                        if (i57 == i29) {
                            setByteArrayToSetOfTriggers = null;
                        } else {
                            byte[] blob = cursorQuery.isNull(i57) ? null : cursorQuery.getBlob(i57);
                            WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                            setByteArrayToSetOfTriggers = WorkTypeConverters.byteArrayToSetOfTriggers(blob);
                        }
                        Constraints constraints = new Constraints(networkTypeIntToNetworkType, z, z2, z3, z4, j2, j8, setByteArrayToSetOfTriggers);
                        ArrayList arrayList2 = (ArrayList) map.get(cursorQuery.getString(columnIndex));
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        HashMap map3 = map;
                        ArrayList arrayList3 = (ArrayList) map2.get(cursorQuery.getString(columnIndex));
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        arrayList.add(new WorkSpec.WorkInfoPojo(string3, stateIntToState, dataFromByteArray, j3, j4, j5, constraints, i31, backoffPolicyIntToBackoffPolicy, j6, j7, i3, i6, j, i11, arrayList2, arrayList3));
                        columnIndex22 = i57;
                        columnIndex2 = i;
                        i28 = i4;
                        i25 = i7;
                        columnIndex14 = i9;
                        columnIndex15 = i12;
                        columnIndex16 = i14;
                        columnIndex17 = i16;
                        columnIndex18 = i18;
                        columnIndex19 = i20;
                        columnIndex20 = i22;
                        columnIndex21 = i58;
                        i27 = i33;
                        map = map3;
                        i29 = -1;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosLiveData(final SupportSQLiteQuery supportSQLiteQuery) {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, false, new Callable<List<WorkSpec.WorkInfoPojo>>() { // from class: androidx.work.impl.model.RawWorkInfoDao_Impl.1
            @Override // java.util.concurrent.Callable
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                WorkInfo.State stateIntToState;
                Data dataFromByteArray;
                BackoffPolicy backoffPolicyIntToBackoffPolicy;
                int i;
                int i2;
                int i3;
                int i4;
                int i5;
                int i6;
                long j;
                int i7;
                int i8;
                int i9;
                int i10;
                int i11;
                int i12;
                int i13;
                NetworkType networkTypeIntToNetworkType;
                int i14;
                int i15;
                boolean z;
                int i16;
                int i17;
                boolean z2;
                int i18;
                int i19;
                boolean z3;
                int i20;
                int i21;
                boolean z4;
                long j2;
                int i22;
                int i23;
                Set<Constraints.ContentUriTrigger> setByteArrayToSetOfTriggers;
                int i24;
                Cursor cursorQuery = DBUtil.query(RawWorkInfoDao_Impl.this.__db, supportSQLiteQuery, true, null);
                try {
                    int columnIndex = CursorUtil.getColumnIndex(cursorQuery, "id");
                    int columnIndex2 = CursorUtil.getColumnIndex(cursorQuery, ServerProtocol.DIALOG_PARAM_STATE);
                    int columnIndex3 = CursorUtil.getColumnIndex(cursorQuery, "output");
                    int columnIndex4 = CursorUtil.getColumnIndex(cursorQuery, "initial_delay");
                    int columnIndex5 = CursorUtil.getColumnIndex(cursorQuery, "interval_duration");
                    int columnIndex6 = CursorUtil.getColumnIndex(cursorQuery, "flex_duration");
                    int columnIndex7 = CursorUtil.getColumnIndex(cursorQuery, "run_attempt_count");
                    int columnIndex8 = CursorUtil.getColumnIndex(cursorQuery, "backoff_policy");
                    int columnIndex9 = CursorUtil.getColumnIndex(cursorQuery, "backoff_delay_duration");
                    int columnIndex10 = CursorUtil.getColumnIndex(cursorQuery, "last_enqueue_time");
                    int columnIndex11 = CursorUtil.getColumnIndex(cursorQuery, "period_count");
                    int columnIndex12 = CursorUtil.getColumnIndex(cursorQuery, "generation");
                    int columnIndex13 = CursorUtil.getColumnIndex(cursorQuery, "next_schedule_time_override");
                    int columnIndex14 = CursorUtil.getColumnIndex(cursorQuery, "stop_reason");
                    int columnIndex15 = CursorUtil.getColumnIndex(cursorQuery, "required_network_type");
                    int columnIndex16 = CursorUtil.getColumnIndex(cursorQuery, "requires_charging");
                    int columnIndex17 = CursorUtil.getColumnIndex(cursorQuery, "requires_device_idle");
                    int columnIndex18 = CursorUtil.getColumnIndex(cursorQuery, "requires_battery_not_low");
                    int columnIndex19 = CursorUtil.getColumnIndex(cursorQuery, "requires_storage_not_low");
                    int columnIndex20 = CursorUtil.getColumnIndex(cursorQuery, "trigger_content_update_delay");
                    int columnIndex21 = CursorUtil.getColumnIndex(cursorQuery, "trigger_max_content_delay");
                    int columnIndex22 = CursorUtil.getColumnIndex(cursorQuery, "content_uri_triggers");
                    HashMap map = new HashMap();
                    int i25 = columnIndex13;
                    HashMap map2 = new HashMap();
                    while (cursorQuery.moveToNext()) {
                        int i26 = columnIndex12;
                        String string = cursorQuery.getString(columnIndex);
                        if (((ArrayList) map.get(string)) == null) {
                            i24 = columnIndex11;
                            map.put(string, new ArrayList());
                        } else {
                            i24 = columnIndex11;
                        }
                        String string2 = cursorQuery.getString(columnIndex);
                        if (((ArrayList) map2.get(string2)) == null) {
                            map2.put(string2, new ArrayList());
                        }
                        columnIndex12 = i26;
                        columnIndex11 = i24;
                    }
                    int i27 = columnIndex11;
                    int i28 = columnIndex12;
                    int i29 = -1;
                    cursorQuery.moveToPosition(-1);
                    RawWorkInfoDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(map);
                    RawWorkInfoDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(map2);
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string3 = (columnIndex == i29 || cursorQuery.isNull(columnIndex)) ? null : cursorQuery.getString(columnIndex);
                        if (columnIndex2 == i29) {
                            stateIntToState = null;
                        } else {
                            int i30 = cursorQuery.getInt(columnIndex2);
                            WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                            stateIntToState = WorkTypeConverters.intToState(i30);
                        }
                        if (columnIndex3 == i29) {
                            dataFromByteArray = null;
                        } else {
                            dataFromByteArray = Data.fromByteArray(cursorQuery.isNull(columnIndex3) ? null : cursorQuery.getBlob(columnIndex3));
                        }
                        long j3 = columnIndex4 == i29 ? 0L : cursorQuery.getLong(columnIndex4);
                        long j4 = columnIndex5 == i29 ? 0L : cursorQuery.getLong(columnIndex5);
                        long j5 = columnIndex6 == i29 ? 0L : cursorQuery.getLong(columnIndex6);
                        int i31 = columnIndex7 == i29 ? 0 : cursorQuery.getInt(columnIndex7);
                        if (columnIndex8 == i29) {
                            backoffPolicyIntToBackoffPolicy = null;
                        } else {
                            int i32 = cursorQuery.getInt(columnIndex8);
                            WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                            backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i32);
                        }
                        long j6 = columnIndex9 == i29 ? 0L : cursorQuery.getLong(columnIndex9);
                        long j7 = columnIndex10 == i29 ? 0L : cursorQuery.getLong(columnIndex10);
                        int i33 = i27;
                        if (i33 == i29) {
                            int i34 = i28;
                            i = columnIndex2;
                            i2 = i34;
                            i3 = 0;
                        } else {
                            int i35 = i28;
                            i = columnIndex2;
                            i2 = i35;
                            i3 = cursorQuery.getInt(i33);
                        }
                        if (i2 == i29) {
                            int i36 = i25;
                            i4 = i2;
                            i5 = i36;
                            i6 = 0;
                        } else {
                            int i37 = cursorQuery.getInt(i2);
                            int i38 = i25;
                            i4 = i2;
                            i5 = i38;
                            i6 = i37;
                        }
                        if (i5 == i29) {
                            int i39 = columnIndex14;
                            i7 = i5;
                            i8 = i39;
                            j = 0;
                        } else {
                            j = cursorQuery.getLong(i5);
                            int i40 = columnIndex14;
                            i7 = i5;
                            i8 = i40;
                        }
                        if (i8 == i29) {
                            int i41 = columnIndex15;
                            i9 = i8;
                            i10 = i41;
                            i11 = 0;
                        } else {
                            int i42 = cursorQuery.getInt(i8);
                            int i43 = columnIndex15;
                            i9 = i8;
                            i10 = i43;
                            i11 = i42;
                        }
                        if (i10 == i29) {
                            int i44 = columnIndex16;
                            i12 = i10;
                            i13 = i44;
                            networkTypeIntToNetworkType = null;
                        } else {
                            int i45 = cursorQuery.getInt(i10);
                            WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                            int i46 = columnIndex16;
                            i12 = i10;
                            i13 = i46;
                            networkTypeIntToNetworkType = WorkTypeConverters.intToNetworkType(i45);
                        }
                        if (i13 == i29) {
                            int i47 = columnIndex17;
                            i14 = i13;
                            i15 = i47;
                            z = false;
                        } else {
                            boolean z5 = cursorQuery.getInt(i13) != 0;
                            int i48 = columnIndex17;
                            i14 = i13;
                            i15 = i48;
                            z = z5;
                        }
                        if (i15 == i29) {
                            int i49 = columnIndex18;
                            i16 = i15;
                            i17 = i49;
                            z2 = false;
                        } else {
                            boolean z6 = cursorQuery.getInt(i15) != 0;
                            int i50 = columnIndex18;
                            i16 = i15;
                            i17 = i50;
                            z2 = z6;
                        }
                        if (i17 == i29) {
                            int i51 = columnIndex19;
                            i18 = i17;
                            i19 = i51;
                            z3 = false;
                        } else {
                            boolean z7 = cursorQuery.getInt(i17) != 0;
                            int i52 = columnIndex19;
                            i18 = i17;
                            i19 = i52;
                            z3 = z7;
                        }
                        if (i19 == i29) {
                            int i53 = columnIndex20;
                            i20 = i19;
                            i21 = i53;
                            z4 = false;
                        } else {
                            boolean z8 = cursorQuery.getInt(i19) != 0;
                            int i54 = columnIndex20;
                            i20 = i19;
                            i21 = i54;
                            z4 = z8;
                        }
                        if (i21 == i29) {
                            int i55 = columnIndex21;
                            i22 = i21;
                            i23 = i55;
                            j2 = 0;
                        } else {
                            j2 = cursorQuery.getLong(i21);
                            int i56 = columnIndex21;
                            i22 = i21;
                            i23 = i56;
                        }
                        int i57 = columnIndex22;
                        int i58 = i23;
                        long j8 = i23 != i29 ? cursorQuery.getLong(i23) : 0L;
                        if (i57 == i29) {
                            setByteArrayToSetOfTriggers = null;
                        } else {
                            byte[] blob = cursorQuery.isNull(i57) ? null : cursorQuery.getBlob(i57);
                            WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                            setByteArrayToSetOfTriggers = WorkTypeConverters.byteArrayToSetOfTriggers(blob);
                        }
                        Constraints constraints = new Constraints(networkTypeIntToNetworkType, z, z2, z3, z4, j2, j8, setByteArrayToSetOfTriggers);
                        ArrayList arrayList2 = (ArrayList) map.get(cursorQuery.getString(columnIndex));
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        HashMap map3 = map;
                        ArrayList arrayList3 = (ArrayList) map2.get(cursorQuery.getString(columnIndex));
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        arrayList.add(new WorkSpec.WorkInfoPojo(string3, stateIntToState, dataFromByteArray, j3, j4, j5, constraints, i31, backoffPolicyIntToBackoffPolicy, j6, j7, i3, i6, j, i11, arrayList2, arrayList3));
                        columnIndex22 = i57;
                        columnIndex2 = i;
                        i28 = i4;
                        i25 = i7;
                        columnIndex14 = i9;
                        columnIndex15 = i12;
                        columnIndex16 = i14;
                        columnIndex17 = i16;
                        columnIndex18 = i18;
                        columnIndex19 = i20;
                        columnIndex20 = i22;
                        columnIndex21 = i58;
                        i27 = i33;
                        map = map3;
                        i29 = -1;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }
}
