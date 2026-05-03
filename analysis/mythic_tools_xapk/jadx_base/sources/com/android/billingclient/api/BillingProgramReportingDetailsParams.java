package com.android.billingclient.api;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class BillingProgramReportingDetailsParams {
    private final int billingProgram;

    /* JADX INFO: compiled from: com.android.billingclient:billing@@8.3.0 */
    public static final class Builder {
        private int billingProgram;

        private Builder() {
            this.billingProgram = 0;
        }

        public BillingProgramReportingDetailsParams build() {
            if (this.billingProgram != 0) {
                return new BillingProgramReportingDetailsParams(this);
            }
            throw new IllegalArgumentException("Billing program is not specified.");
        }

        public Builder setBillingProgram(int i) {
            this.billingProgram = i;
            return this;
        }
    }

    private BillingProgramReportingDetailsParams(Builder builder) {
        this.billingProgram = builder.billingProgram;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getBillingProgram() {
        return this.billingProgram;
    }
}
