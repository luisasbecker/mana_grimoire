package com.revenuecat.purchases.ui.revenuecatui.customercenter.data;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomerCenterState.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012l\u0010\u0002\u001ah\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\n0\t¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\n0\t¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\n0\u0003\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000fJo\u0010\u0015\u001ah\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\n0\t¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\n0\t¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\n0\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u0099\u0001\u0010\u0018\u001a\u00020\u00002n\b\u0002\u0010\u0002\u001ah\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\n0\t¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\n0\t¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\n0\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011Rw\u0010\u0002\u001ah\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\n0\t¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\n0\t¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CreateSupportTicketData;", "", "onSubmit", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "email", "description", "Lkotlin/Function0;", "", "onSuccess", "onError", "onCancel", "onClose", "(Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnCancel", "()Lkotlin/jvm/functions/Function0;", "getOnClose", "getOnSubmit", "()Lkotlin/jvm/functions/Function4;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CreateSupportTicketData {
    public static final int $stable = 0;
    private final Function0<Unit> onCancel;
    private final Function0<Unit> onClose;
    private final Function4<String, String, Function0<Unit>, Function0<Unit>, Unit> onSubmit;

    /* JADX WARN: Multi-variable type inference failed */
    public CreateSupportTicketData(Function4<? super String, ? super String, ? super Function0<Unit>, ? super Function0<Unit>, Unit> onSubmit, Function0<Unit> onCancel, Function0<Unit> onClose) {
        Intrinsics.checkNotNullParameter(onSubmit, "onSubmit");
        Intrinsics.checkNotNullParameter(onCancel, "onCancel");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        this.onSubmit = onSubmit;
        this.onCancel = onCancel;
        this.onClose = onClose;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CreateSupportTicketData copy$default(CreateSupportTicketData createSupportTicketData, Function4 function4, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            function4 = createSupportTicketData.onSubmit;
        }
        if ((i & 2) != 0) {
            function0 = createSupportTicketData.onCancel;
        }
        if ((i & 4) != 0) {
            function02 = createSupportTicketData.onClose;
        }
        return createSupportTicketData.copy(function4, function0, function02);
    }

    public final Function4<String, String, Function0<Unit>, Function0<Unit>, Unit> component1() {
        return this.onSubmit;
    }

    public final Function0<Unit> component2() {
        return this.onCancel;
    }

    public final Function0<Unit> component3() {
        return this.onClose;
    }

    public final CreateSupportTicketData copy(Function4<? super String, ? super String, ? super Function0<Unit>, ? super Function0<Unit>, Unit> onSubmit, Function0<Unit> onCancel, Function0<Unit> onClose) {
        Intrinsics.checkNotNullParameter(onSubmit, "onSubmit");
        Intrinsics.checkNotNullParameter(onCancel, "onCancel");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        return new CreateSupportTicketData(onSubmit, onCancel, onClose);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateSupportTicketData)) {
            return false;
        }
        CreateSupportTicketData createSupportTicketData = (CreateSupportTicketData) other;
        return Intrinsics.areEqual(this.onSubmit, createSupportTicketData.onSubmit) && Intrinsics.areEqual(this.onCancel, createSupportTicketData.onCancel) && Intrinsics.areEqual(this.onClose, createSupportTicketData.onClose);
    }

    public final /* synthetic */ Function0 getOnCancel() {
        return this.onCancel;
    }

    public final /* synthetic */ Function0 getOnClose() {
        return this.onClose;
    }

    public final /* synthetic */ Function4 getOnSubmit() {
        return this.onSubmit;
    }

    public int hashCode() {
        return (((this.onSubmit.hashCode() * 31) + this.onCancel.hashCode()) * 31) + this.onClose.hashCode();
    }

    public String toString() {
        return "CreateSupportTicketData(onSubmit=" + this.onSubmit + ", onCancel=" + this.onCancel + ", onClose=" + this.onClose + ')';
    }
}
