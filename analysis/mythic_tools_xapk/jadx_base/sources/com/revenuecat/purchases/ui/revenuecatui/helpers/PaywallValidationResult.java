package com.revenuecat.purchases.ui.revenuecatui.helpers;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.PaywallTemplate;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableDataProvider;
import com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaywallValidationResult.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0007\bR\u001a\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallValidationResult;", "", "errors", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "getErrors", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "Components", "Legacy", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallValidationResult$Components;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallValidationResult$Legacy;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PaywallValidationResult {

    /* JADX INFO: compiled from: PaywallValidationResult.kt */
    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J\t\u00103\u001a\u00020\u0003HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010#J\t\u00105\u001a\u00020\u0017HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0007HÆ\u0003J\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\t\u0010;\u001a\u00020\u000fHÆ\u0003J\t\u0010<\u001a\u00020\u0011HÆ\u0003J\t\u0010=\u001a\u00020\u0013HÆ\u0003J\u008e\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017HÆ\u0001¢\u0006\u0002\u0010?J\u0013\u0010@\u001a\u00020\u00172\b\u0010A\u001a\u0004\u0018\u00010BHÖ\u0003J\t\u0010C\u001a\u00020\u0015HÖ\u0001J\t\u0010D\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010!R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010!R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b1\u00102¨\u0006E"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallValidationResult$Components;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallValidationResult;", "stack", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "header", "stickyFooter", "background", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "locales", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptySet;", "Lcom/revenuecat/purchases/paywalls/components/common/LocaleId;", "zeroDecimalPlaceCountries", "", "", "variableConfig", "Lcom/revenuecat/purchases/UiConfig$VariableConfig;", "variableDataProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableDataProvider;", "packages", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages;", "initialSelectedTabIndex", "", "mainStackHasHeroImage", "", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptySet;Ljava/util/Set;Lcom/revenuecat/purchases/UiConfig$VariableConfig;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableDataProvider;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages;Ljava/lang/Integer;Z)V", "getBackground", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "errors", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "getErrors", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "getHeader", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "getInitialSelectedTabIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLocales", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptySet;", "getMainStackHasHeroImage", "()Z", "getPackages", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages;", "getStack", "getStickyFooter", "getVariableConfig", "()Lcom/revenuecat/purchases/UiConfig$VariableConfig;", "getVariableDataProvider", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableDataProvider;", "getZeroDecimalPlaceCountries", "()Ljava/util/Set;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptySet;Ljava/util/Set;Lcom/revenuecat/purchases/UiConfig$VariableConfig;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableDataProvider;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages;Ljava/lang/Integer;Z)Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallValidationResult$Components;", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Components implements PaywallValidationResult {
        public static final int $stable = 8;
        private final BackgroundStyles background;
        private final NonEmptyList<PaywallValidationError> errors;
        private final ComponentStyle header;
        private final Integer initialSelectedTabIndex;
        private final NonEmptySet<LocaleId> locales;
        private final boolean mainStackHasHeroImage;
        private final PaywallState.Loaded.Components.AvailablePackages packages;
        private final ComponentStyle stack;
        private final ComponentStyle stickyFooter;
        private final UiConfig.VariableConfig variableConfig;
        private final VariableDataProvider variableDataProvider;
        private final Set<String> zeroDecimalPlaceCountries;

        public Components(ComponentStyle stack, ComponentStyle componentStyle, ComponentStyle componentStyle2, BackgroundStyles background, NonEmptySet<LocaleId> locales, Set<String> zeroDecimalPlaceCountries, UiConfig.VariableConfig variableConfig, VariableDataProvider variableDataProvider, PaywallState.Loaded.Components.AvailablePackages packages, Integer num, boolean z) {
            Intrinsics.checkNotNullParameter(stack, "stack");
            Intrinsics.checkNotNullParameter(background, "background");
            Intrinsics.checkNotNullParameter(locales, "locales");
            Intrinsics.checkNotNullParameter(zeroDecimalPlaceCountries, "zeroDecimalPlaceCountries");
            Intrinsics.checkNotNullParameter(variableConfig, "variableConfig");
            Intrinsics.checkNotNullParameter(variableDataProvider, "variableDataProvider");
            Intrinsics.checkNotNullParameter(packages, "packages");
            this.stack = stack;
            this.header = componentStyle;
            this.stickyFooter = componentStyle2;
            this.background = background;
            this.locales = locales;
            this.zeroDecimalPlaceCountries = zeroDecimalPlaceCountries;
            this.variableConfig = variableConfig;
            this.variableDataProvider = variableDataProvider;
            this.packages = packages;
            this.initialSelectedTabIndex = num;
            this.mainStackHasHeroImage = z;
        }

        public /* synthetic */ Components(ComponentStyle componentStyle, ComponentStyle componentStyle2, ComponentStyle componentStyle3, BackgroundStyles backgroundStyles, NonEmptySet nonEmptySet, Set set, UiConfig.VariableConfig variableConfig, VariableDataProvider variableDataProvider, PaywallState.Loaded.Components.AvailablePackages availablePackages, Integer num, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(componentStyle, componentStyle2, componentStyle3, backgroundStyles, nonEmptySet, set, variableConfig, variableDataProvider, availablePackages, num, (i & 1024) != 0 ? false : z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Components copy$default(Components components, ComponentStyle componentStyle, ComponentStyle componentStyle2, ComponentStyle componentStyle3, BackgroundStyles backgroundStyles, NonEmptySet nonEmptySet, Set set, UiConfig.VariableConfig variableConfig, VariableDataProvider variableDataProvider, PaywallState.Loaded.Components.AvailablePackages availablePackages, Integer num, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                componentStyle = components.stack;
            }
            if ((i & 2) != 0) {
                componentStyle2 = components.header;
            }
            if ((i & 4) != 0) {
                componentStyle3 = components.stickyFooter;
            }
            if ((i & 8) != 0) {
                backgroundStyles = components.background;
            }
            if ((i & 16) != 0) {
                nonEmptySet = components.locales;
            }
            if ((i & 32) != 0) {
                set = components.zeroDecimalPlaceCountries;
            }
            if ((i & 64) != 0) {
                variableConfig = components.variableConfig;
            }
            if ((i & 128) != 0) {
                variableDataProvider = components.variableDataProvider;
            }
            if ((i & 256) != 0) {
                availablePackages = components.packages;
            }
            if ((i & 512) != 0) {
                num = components.initialSelectedTabIndex;
            }
            if ((i & 1024) != 0) {
                z = components.mainStackHasHeroImage;
            }
            Integer num2 = num;
            boolean z2 = z;
            VariableDataProvider variableDataProvider2 = variableDataProvider;
            PaywallState.Loaded.Components.AvailablePackages availablePackages2 = availablePackages;
            Set set2 = set;
            UiConfig.VariableConfig variableConfig2 = variableConfig;
            NonEmptySet nonEmptySet2 = nonEmptySet;
            ComponentStyle componentStyle4 = componentStyle3;
            return components.copy(componentStyle, componentStyle2, componentStyle4, backgroundStyles, nonEmptySet2, set2, variableConfig2, variableDataProvider2, availablePackages2, num2, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ComponentStyle getStack() {
            return this.stack;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Integer getInitialSelectedTabIndex() {
            return this.initialSelectedTabIndex;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final boolean getMainStackHasHeroImage() {
            return this.mainStackHasHeroImage;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ComponentStyle getHeader() {
            return this.header;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final ComponentStyle getStickyFooter() {
            return this.stickyFooter;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final BackgroundStyles getBackground() {
            return this.background;
        }

        public final NonEmptySet<LocaleId> component5() {
            return this.locales;
        }

        public final Set<String> component6() {
            return this.zeroDecimalPlaceCountries;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final UiConfig.VariableConfig getVariableConfig() {
            return this.variableConfig;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final VariableDataProvider getVariableDataProvider() {
            return this.variableDataProvider;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final PaywallState.Loaded.Components.AvailablePackages getPackages() {
            return this.packages;
        }

        public final Components copy(ComponentStyle stack, ComponentStyle header, ComponentStyle stickyFooter, BackgroundStyles background, NonEmptySet<LocaleId> locales, Set<String> zeroDecimalPlaceCountries, UiConfig.VariableConfig variableConfig, VariableDataProvider variableDataProvider, PaywallState.Loaded.Components.AvailablePackages packages, Integer initialSelectedTabIndex, boolean mainStackHasHeroImage) {
            Intrinsics.checkNotNullParameter(stack, "stack");
            Intrinsics.checkNotNullParameter(background, "background");
            Intrinsics.checkNotNullParameter(locales, "locales");
            Intrinsics.checkNotNullParameter(zeroDecimalPlaceCountries, "zeroDecimalPlaceCountries");
            Intrinsics.checkNotNullParameter(variableConfig, "variableConfig");
            Intrinsics.checkNotNullParameter(variableDataProvider, "variableDataProvider");
            Intrinsics.checkNotNullParameter(packages, "packages");
            return new Components(stack, header, stickyFooter, background, locales, zeroDecimalPlaceCountries, variableConfig, variableDataProvider, packages, initialSelectedTabIndex, mainStackHasHeroImage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Components)) {
                return false;
            }
            Components components = (Components) other;
            return Intrinsics.areEqual(this.stack, components.stack) && Intrinsics.areEqual(this.header, components.header) && Intrinsics.areEqual(this.stickyFooter, components.stickyFooter) && Intrinsics.areEqual(this.background, components.background) && Intrinsics.areEqual(this.locales, components.locales) && Intrinsics.areEqual(this.zeroDecimalPlaceCountries, components.zeroDecimalPlaceCountries) && Intrinsics.areEqual(this.variableConfig, components.variableConfig) && Intrinsics.areEqual(this.variableDataProvider, components.variableDataProvider) && Intrinsics.areEqual(this.packages, components.packages) && Intrinsics.areEqual(this.initialSelectedTabIndex, components.initialSelectedTabIndex) && this.mainStackHasHeroImage == components.mainStackHasHeroImage;
        }

        public final BackgroundStyles getBackground() {
            return this.background;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallValidationResult
        public NonEmptyList<PaywallValidationError> getErrors() {
            return this.errors;
        }

        public final ComponentStyle getHeader() {
            return this.header;
        }

        public final Integer getInitialSelectedTabIndex() {
            return this.initialSelectedTabIndex;
        }

        public final NonEmptySet<LocaleId> getLocales() {
            return this.locales;
        }

        public final boolean getMainStackHasHeroImage() {
            return this.mainStackHasHeroImage;
        }

        public final PaywallState.Loaded.Components.AvailablePackages getPackages() {
            return this.packages;
        }

        public final ComponentStyle getStack() {
            return this.stack;
        }

        public final ComponentStyle getStickyFooter() {
            return this.stickyFooter;
        }

        public final UiConfig.VariableConfig getVariableConfig() {
            return this.variableConfig;
        }

        public final VariableDataProvider getVariableDataProvider() {
            return this.variableDataProvider;
        }

        public final Set<String> getZeroDecimalPlaceCountries() {
            return this.zeroDecimalPlaceCountries;
        }

        public int hashCode() {
            int iHashCode = this.stack.hashCode() * 31;
            ComponentStyle componentStyle = this.header;
            int iHashCode2 = (iHashCode + (componentStyle == null ? 0 : componentStyle.hashCode())) * 31;
            ComponentStyle componentStyle2 = this.stickyFooter;
            int iHashCode3 = (((((((((((((iHashCode2 + (componentStyle2 == null ? 0 : componentStyle2.hashCode())) * 31) + this.background.hashCode()) * 31) + this.locales.hashCode()) * 31) + this.zeroDecimalPlaceCountries.hashCode()) * 31) + this.variableConfig.hashCode()) * 31) + this.variableDataProvider.hashCode()) * 31) + this.packages.hashCode()) * 31;
            Integer num = this.initialSelectedTabIndex;
            return ((iHashCode3 + (num != null ? num.hashCode() : 0)) * 31) + Boolean.hashCode(this.mainStackHasHeroImage);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Components(stack=");
            sb.append(this.stack).append(", header=").append(this.header).append(", stickyFooter=").append(this.stickyFooter).append(", background=").append(this.background).append(", locales=").append(this.locales).append(", zeroDecimalPlaceCountries=").append(this.zeroDecimalPlaceCountries).append(", variableConfig=").append(this.variableConfig).append(", variableDataProvider=").append(this.variableDataProvider).append(", packages=").append(this.packages).append(", initialSelectedTabIndex=").append(this.initialSelectedTabIndex).append(", mainStackHasHeroImage=").append(this.mainStackHasHeroImage).append(')');
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: PaywallValidationResult.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nHÆ\u0003J/\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallValidationResult$Legacy;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallValidationResult;", "displayablePaywall", "Lcom/revenuecat/purchases/paywalls/PaywallData;", "template", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/PaywallTemplate;", "error", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "(Lcom/revenuecat/purchases/paywalls/PaywallData;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/PaywallTemplate;Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;)V", "errors", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "(Lcom/revenuecat/purchases/paywalls/PaywallData;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/PaywallTemplate;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;)V", "getDisplayablePaywall", "()Lcom/revenuecat/purchases/paywalls/PaywallData;", "getErrors", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "getTemplate", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/PaywallTemplate;", "warning", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;", "getWarning", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Legacy implements PaywallValidationResult {
        public static final int $stable = 8;
        private final PaywallData displayablePaywall;
        private final NonEmptyList<PaywallValidationError> errors;
        private final PaywallTemplate template;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Legacy(PaywallData displayablePaywall, PaywallTemplate template, PaywallValidationError error) {
            this(displayablePaywall, template, (NonEmptyList<? extends PaywallValidationError>) NonEmptyListKt.nonEmptyListOf(error, new PaywallValidationError[0]));
            Intrinsics.checkNotNullParameter(displayablePaywall, "displayablePaywall");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(error, "error");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Legacy(PaywallData displayablePaywall, PaywallTemplate template, NonEmptyList<? extends PaywallValidationError> nonEmptyList) {
            Intrinsics.checkNotNullParameter(displayablePaywall, "displayablePaywall");
            Intrinsics.checkNotNullParameter(template, "template");
            this.displayablePaywall = displayablePaywall;
            this.template = template;
            this.errors = nonEmptyList;
        }

        public /* synthetic */ Legacy(PaywallData paywallData, PaywallTemplate paywallTemplate, NonEmptyList nonEmptyList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(paywallData, paywallTemplate, (NonEmptyList<? extends PaywallValidationError>) ((i & 4) != 0 ? null : nonEmptyList));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Legacy copy$default(Legacy legacy, PaywallData paywallData, PaywallTemplate paywallTemplate, NonEmptyList nonEmptyList, int i, Object obj) {
            if ((i & 1) != 0) {
                paywallData = legacy.displayablePaywall;
            }
            if ((i & 2) != 0) {
                paywallTemplate = legacy.template;
            }
            if ((i & 4) != 0) {
                nonEmptyList = legacy.errors;
            }
            return legacy.copy(paywallData, paywallTemplate, nonEmptyList);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PaywallData getDisplayablePaywall() {
            return this.displayablePaywall;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final PaywallTemplate getTemplate() {
            return this.template;
        }

        public final NonEmptyList<PaywallValidationError> component3() {
            return this.errors;
        }

        public final Legacy copy(PaywallData displayablePaywall, PaywallTemplate template, NonEmptyList<? extends PaywallValidationError> errors) {
            Intrinsics.checkNotNullParameter(displayablePaywall, "displayablePaywall");
            Intrinsics.checkNotNullParameter(template, "template");
            return new Legacy(displayablePaywall, template, errors);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Legacy)) {
                return false;
            }
            Legacy legacy = (Legacy) other;
            return Intrinsics.areEqual(this.displayablePaywall, legacy.displayablePaywall) && this.template == legacy.template && Intrinsics.areEqual(this.errors, legacy.errors);
        }

        public final PaywallData getDisplayablePaywall() {
            return this.displayablePaywall;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallValidationResult
        public NonEmptyList<PaywallValidationError> getErrors() {
            return this.errors;
        }

        public final PaywallTemplate getTemplate() {
            return this.template;
        }

        public final PaywallWarning getWarning() {
            PaywallValidationError paywallValidationError;
            NonEmptyList<PaywallValidationError> errors = getErrors();
            if (errors == null || (paywallValidationError = (PaywallValidationError) errors.getHead()) == null) {
                return null;
            }
            return PaywallWarning.INSTANCE.from(paywallValidationError);
        }

        public int hashCode() {
            int iHashCode = ((this.displayablePaywall.hashCode() * 31) + this.template.hashCode()) * 31;
            NonEmptyList<PaywallValidationError> nonEmptyList = this.errors;
            return iHashCode + (nonEmptyList == null ? 0 : nonEmptyList.hashCode());
        }

        public String toString() {
            return "Legacy(displayablePaywall=" + this.displayablePaywall + ", template=" + this.template + ", errors=" + this.errors + ')';
        }
    }

    NonEmptyList<PaywallValidationError> getErrors();
}
