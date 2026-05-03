package com.studiolaganne.lengendarylens;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: GameUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0004\"\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0004¨\u0006\t"}, d2 = {"companionsOracleIds", "", "", "getCompanionsOracleIds", "()Ljava/util/List;", "colorChoosingCommanders", "getColorChoosingCommanders", "fastManaOracleIds", "getFastManaOracleIds", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GameUtilsKt {
    private static final List<String> companionsOracleIds = CollectionsKt.listOf((Object[]) new String[]{"f0587c55-06c1-4930-a62e-668f37464ce9", "35428c77-9731-4d4d-8f75-e939a491cf86", "ca5121b2-e6d9-40bc-a2d2-05852c4efbe8", "913383a1-9c0d-40a1-8c5a-b0a8a95c09a6", "6985c8a9-9299-461b-8bef-bd2b2c739c11", "158a6225-a246-4fd6-aa57-0df8067b4383", "3bc757c1-3adb-4321-8832-8e1cc9e687f7", "e15504a7-2b67-4185-b916-172145f10b19", "7b515c56-7b1e-42a8-82b0-1b30201fb162", "25eaa977-ca85-4f8d-8be5-9297a3edb14f"});
    private static final List<String> colorChoosingCommanders = CollectionsKt.listOf((Object[]) new String[]{"542eae01-058d-4959-92a8-49d6b1e33ecd", "ef220170-c01a-4ca5-b887-f248c50227ee", "b2aeee90-7b8d-47a6-9167-cc21f7fbfd43"});
    private static final List<String> fastManaOracleIds = CollectionsKt.listOf((Object[]) new String[]{"f340cbf7-5bbe-45b9-a4bf-d1caa500ff93", "2c63e4e1-89d2-4bc6-a232-94e75c4b1c8a", "7a43bd27-fdd8-41f0-9bc4-92568f3408f1", "f3c5978a-70fa-431f-933b-b954bd0db0ea", "376ee366-e082-402f-b4db-6592fcfcacd2", "d5fca77c-377f-41b4-a9e9-e91a89d351cc", "0677f49e-f8bf-4349-af52-2ccde9287c2e", "de2440de-e948-4811-903c-0bbe376ff64d", "824597b8-c89a-47ec-8526-7efc6e24ef0e", "ed85fa82-e4fa-434b-92a8-36b6075708d1", "d5ed1233-df87-4b90-8918-13922ec95249", "23216e59-f147-4bb7-a698-12777c2f8584", "32e5339e-9e4f-46f8-b305-f9d6d3ba8bb5", "ee6099b0-fb1f-42f1-b862-7708c6e36d05", "5089ec1a-f881-4d55-af14-5d996171203b", "23467047-6dba-4498-b783-1ebc4f74b8c2", "dba4fd31-8931-42dd-bd86-45479c2abf74", "7c427c3d-ecd8-45ef-bebd-8f10f4a311db", "ba284fe6-bb29-455c-8321-9714a0cdc05e", "e27193b7-1a47-4555-865d-b1fd4c6d597f", "d1b815d1-2848-40d4-a555-66822d1becbc", "6ad8011d-3471-4369-9d68-b264cc027487", "697bcfe1-ecbf-42a1-bfc7-0766d48ca56b", "c0adbddc-b070-4c5f-afe0-0474c72a9251", "736892cb-a34b-4bb9-b56c-e26e3db207a2", "229d6627-1292-4ae1-8849-b0f956fa6540", "2ffc6372-f63b-4f32-8dd0-2d7938aeb412", "f161111d-9747-47b3-bb10-3c8bded32e21", "34187c71-6033-4058-aadc-2bc266f762be", "3c7f2b29-9f42-41ab-a2d4-7a450fb0242d", "6385fd0d-256d-4400-9319-afa8170024db", "53f7c868-b03e-4fc2-8dcf-a75bbfa3272b", "dc671205-f2fa-454f-9957-921a6069ad53", "6b0e23cf-7d68-4329-86db-7adc26abd86b", "44e0ffa3-8915-4c1f-8f1a-4aeea1365f07", "383e3fe4-8558-4561-8632-6eadb5d5963c", "64bf8929-f5f2-4d50-8667-13b1d007bcfc", "3620ab8f-b693-4225-bb96-5ca3cb3fa465", "86ef6474-613f-41fb-931c-d4279b03ed99", "8a2e53f9-8100-488f-8504-b59e9bd1cc29", "5b5bf1fa-6502-4790-b66b-f0f8504ebc7c", "86eb30a0-0beb-42db-9ddf-cf8be6c99dd3", "068b3692-411b-44d4-a7e9-005262760cfc", "dd2f698c-b3b4-4dc8-9950-9be03ca7dc9e", "0fd114c4-092b-4e28-b0dc-ef529f3bc73e", "7140d726-0136-43af-84b5-85005a66a186"});

    public static final List<String> getColorChoosingCommanders() {
        return colorChoosingCommanders;
    }

    public static final List<String> getCompanionsOracleIds() {
        return companionsOracleIds;
    }

    public static final List<String> getFastManaOracleIds() {
        return fastManaOracleIds;
    }
}
