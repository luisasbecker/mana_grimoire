package com.revenuecat.purchases.ui.revenuecatui.helpers;

import androidx.compose.material3.ColorScheme;
import androidx.exifinterface.media.ExifInterface;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.FallbackHeaderComponent;
import com.revenuecat.purchases.paywalls.components.HeaderComponent;
import com.revenuecat.purchases.paywalls.components.IconComponent;
import com.revenuecat.purchases.paywalls.components.ImageComponent;
import com.revenuecat.purchases.paywalls.components.PackageComponent;
import com.revenuecat.purchases.paywalls.components.PaywallComponent;
import com.revenuecat.purchases.paywalls.components.PurchaseButtonComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent;
import com.revenuecat.purchases.paywalls.components.TabControlButtonComponent;
import com.revenuecat.purchases.paywalls.components.TabControlComponent;
import com.revenuecat.purchases.paywalls.components.TabControlToggleComponent;
import com.revenuecat.purchases.paywalls.components.TabsComponent;
import com.revenuecat.purchases.paywalls.components.TextComponent;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.paywalls.components.VideoComponent;
import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.LocalizationData;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsConfig;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData;
import com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKey;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.PaywallMode;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.LocalizationKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.FontSpecKt;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.StackComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory;
import com.revenuecat.purchases.ui.revenuecatui.composables.PaywallIconName;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.PackageConfigurationType;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.PaywallTemplate;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfigurationFactory;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableDataProvider;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessor;
import com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PaywallDataExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallValidationResult;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OfferingToStateMapper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Þ\u0001\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\r\u001a\u00020\u000e*\u00020\u000fH\u0000\u001a\f\u0010\r\u001a\u00020\u000e*\u00020\u0010H\u0000\u001a\f\u0010\r\u001a\u00020\u000e*\u00020\u0011H\u0000\u001a$\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0000\u001a*\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001cH\u0002\u001a0\u0010\u001d\u001a\n\u0012\u0004\u0012\u0002H\u001f\u0018\u00010\u001e\"\u0004\b\u0000\u0010\u001f*\b\u0012\u0004\u0012\u0002H\u001f0\u001e2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u0002H\u001f\u0018\u00010\u001eH\u0002\u001a\u0016\u0010!\u001a\u00020\u000e*\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030#0\"H\u0000\u001a`\u0010$\u001a\u00020%*\u00020\u00142\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\t2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010,\u001a\u00020-2\u0014\b\u0002\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020/0\u00012\u0014\b\u0002\u00100\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020/0\u0001H\u0000\u001aJ\u00101\u001a\u000202*\u00020\u00142\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u000e2\b\u0010(\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=H\u0000\u001a\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020:0?*\u000208H\u0002¢\u0006\u0002\u0010@\u001a\u001c\u0010>\u001a\u00020\u0013*\u0002082\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0000\u001a\u000e\u0010>\u001a\u0004\u0018\u00010\u001a*\u00020AH\u0002\u001a\u000e\u0010B\u001a\u0004\u0018\u00010C*\u00020AH\u0002\u001a(\u0010D\u001a\u0016\u0012\u0004\u0012\u00020'\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u001c\u0018\u00010E*\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0000\u001a\u000e\u0010F\u001a\u0004\u0018\u00010:*\u000208H\u0002\u001a\u000e\u0010G\u001a\u0004\u0018\u00010H*\u00020AH\u0002\u001a\u001c\u0010I\u001a\u00020J*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0000\"&\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001*\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"&\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0001*\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006K"}, d2 = {"defaultLocalization", "", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationKey;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData;", "Lcom/revenuecat/purchases/paywalls/components/common/PaywallComponentsData;", "getDefaultLocalization", "(Lcom/revenuecat/purchases/paywalls/components/common/PaywallComponentsData;)Ljava/util/Map;", "defaultVariableLocalization", "Lcom/revenuecat/purchases/paywalls/components/common/VariableLocalizationKey;", "", "Lcom/revenuecat/purchases/Offering$PaywallComponents;", "getDefaultVariableLocalization", "(Lcom/revenuecat/purchases/Offering$PaywallComponents;)Ljava/util/Map;", "containsUnsupportedCondition", "", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "Lcom/revenuecat/purchases/paywalls/components/common/PaywallComponentsConfig;", "fallbackPaywall", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallValidationResult$Legacy;", "Lcom/revenuecat/purchases/Offering;", "currentColorScheme", "Landroidx/compose/material3/ColorScheme;", "resourceProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;", "error", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "errors", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "getMissingElements", "", ExifInterface.GPS_DIRECTION_TRUE, "set", "hasUnsupportedCondition", "", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride;", "toComponentsPaywallState", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "validationResult", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallValidationResult$Components;", "storefrontCountryCode", "dateProvider", "Lkotlin/Function0;", "Ljava/util/Date;", "purchases", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;", "customVariables", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "defaultCustomVariables", "toLegacyPaywallState", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState;", "variableDataProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableDataProvider;", "mode", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;", "validatedPaywallData", "Lcom/revenuecat/purchases/paywalls/PaywallData;", "template", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/PaywallTemplate;", "shouldDisplayDismissButton", "validationWarning", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;", "validate", "Lkotlin/Result;", "(Lcom/revenuecat/purchases/paywalls/PaywallData;)Ljava/lang/Object;", "Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration;", "validateIcons", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$InvalidIcons;", "validatePaywallComponentsDataOrNull", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "validateTemplate", "validateVariables", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$InvalidVariables;", "validatedPaywall", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallValidationResult;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class OfferingToStateMapperKt {

    /* JADX INFO: compiled from: OfferingToStateMapper.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PackageConfigurationType.values().length];
            try {
                iArr[PackageConfigurationType.SINGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PackageConfigurationType.MULTIPLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PackageConfigurationType.MULTITIER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x013e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x022a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0226 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:215:? A[LOOP:2: B:143:0x01d7->B:215:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ boolean containsUnsupportedCondition(PaywallComponent paywallComponent) {
        boolean z;
        boolean z2;
        List overrides;
        boolean z3;
        boolean zContainsUnsupportedCondition;
        boolean z4;
        boolean zContainsUnsupportedCondition2;
        Intrinsics.checkNotNullParameter(paywallComponent, "<this>");
        if (paywallComponent instanceof StackComponent) {
            return containsUnsupportedCondition((StackComponent) paywallComponent);
        }
        if (paywallComponent instanceof TextComponent) {
            return hasUnsupportedCondition(((TextComponent) paywallComponent).getOverrides());
        }
        if (paywallComponent instanceof ImageComponent) {
            return hasUnsupportedCondition(((ImageComponent) paywallComponent).getOverrides());
        }
        if (paywallComponent instanceof VideoComponent) {
            List overrides2 = ((VideoComponent) paywallComponent).getOverrides();
            return overrides2 != null && hasUnsupportedCondition(overrides2);
        }
        if (paywallComponent instanceof IconComponent) {
            return hasUnsupportedCondition(((IconComponent) paywallComponent).getOverrides());
        }
        if (paywallComponent instanceof ButtonComponent) {
            ButtonComponent buttonComponent = (ButtonComponent) paywallComponent;
            if (!containsUnsupportedCondition(buttonComponent.getStack())) {
                ButtonComponent.Action action = buttonComponent.getAction();
                ButtonComponent.Action.NavigateTo navigateTo = action instanceof ButtonComponent.Action.NavigateTo ? (ButtonComponent.Action.NavigateTo) action : null;
                ButtonComponent.Destination destination = navigateTo != null ? navigateTo.getDestination() : null;
                if (destination instanceof ButtonComponent.Destination.Sheet) {
                    zContainsUnsupportedCondition2 = containsUnsupportedCondition(((ButtonComponent.Destination.Sheet) destination).getStack());
                } else {
                    if (!((destination instanceof ButtonComponent.Destination.CustomerCenter ? true : destination instanceof ButtonComponent.Destination.PrivacyPolicy ? true : destination instanceof ButtonComponent.Destination.Terms ? true : destination instanceof ButtonComponent.Destination.Url ? true : destination instanceof ButtonComponent.Destination.Unknown) || destination == null)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    zContainsUnsupportedCondition2 = false;
                }
                if (!zContainsUnsupportedCondition2) {
                    return false;
                }
            }
            return true;
        }
        if (paywallComponent instanceof PackageComponent) {
            PackageComponent packageComponent = (PackageComponent) paywallComponent;
            return hasUnsupportedCondition(packageComponent.getOverrides()) || containsUnsupportedCondition(packageComponent.getStack());
        }
        if (paywallComponent instanceof PurchaseButtonComponent) {
            return containsUnsupportedCondition(((PurchaseButtonComponent) paywallComponent).getStack());
        }
        if (paywallComponent instanceof HeaderComponent) {
            return containsUnsupportedCondition(((HeaderComponent) paywallComponent).getStack());
        }
        if (paywallComponent instanceof StickyFooterComponent) {
            return containsUnsupportedCondition(((StickyFooterComponent) paywallComponent).getStack());
        }
        if (paywallComponent instanceof CarouselComponent) {
            CarouselComponent carouselComponent = (CarouselComponent) paywallComponent;
            if (!hasUnsupportedCondition(carouselComponent.getOverrides())) {
                List pages = carouselComponent.getPages();
                if ((pages instanceof Collection) && pages.isEmpty()) {
                    z4 = false;
                    if (z4) {
                    }
                } else {
                    Iterator it = pages.iterator();
                    while (it.hasNext()) {
                        if (containsUnsupportedCondition((StackComponent) it.next())) {
                            z4 = true;
                            break;
                        }
                    }
                    z4 = false;
                    if (z4) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (paywallComponent instanceof TabsComponent) {
            TabsComponent tabsComponent = (TabsComponent) paywallComponent;
            if (!hasUnsupportedCondition(tabsComponent.getOverrides())) {
                List tabs = tabsComponent.getTabs();
                if ((tabs instanceof Collection) && tabs.isEmpty()) {
                    z3 = false;
                    if (!z3) {
                    }
                } else {
                    Iterator it2 = tabs.iterator();
                    while (it2.hasNext()) {
                        if (containsUnsupportedCondition(((TabsComponent.Tab) it2.next()).getStack())) {
                            z3 = true;
                            break;
                        }
                    }
                    z3 = false;
                    if (!z3) {
                        TabsComponent.TabControl control = tabsComponent.getControl();
                        if (control instanceof TabsComponent.TabControl.Buttons) {
                            zContainsUnsupportedCondition = containsUnsupportedCondition(((TabsComponent.TabControl.Buttons) control).getStack());
                        } else {
                            if (!(control instanceof TabsComponent.TabControl.Toggle)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            zContainsUnsupportedCondition = containsUnsupportedCondition(((TabsComponent.TabControl.Toggle) control).getStack());
                        }
                        if (!zContainsUnsupportedCondition) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        if (!(paywallComponent instanceof TimelineComponent)) {
            if (!(paywallComponent instanceof CountdownComponent)) {
                if (paywallComponent instanceof TabControlButtonComponent) {
                    return containsUnsupportedCondition(((TabControlButtonComponent) paywallComponent).getStack());
                }
                if ((paywallComponent instanceof TabControlToggleComponent) || (paywallComponent instanceof TabControlComponent) || (paywallComponent instanceof FallbackHeaderComponent)) {
                    return false;
                }
                throw new NoWhenBranchMatchedException();
            }
            CountdownComponent countdownComponent = (CountdownComponent) paywallComponent;
            if (!containsUnsupportedCondition(countdownComponent.getCountdownStack())) {
                StackComponent endStack = countdownComponent.getEndStack();
                if (!(endStack != null && containsUnsupportedCondition(endStack))) {
                    StackComponent fallback = countdownComponent.getFallback();
                    if (!(fallback != null && containsUnsupportedCondition(fallback))) {
                        return false;
                    }
                }
            }
            return true;
        }
        TimelineComponent timelineComponent = (TimelineComponent) paywallComponent;
        if (!hasUnsupportedCondition(timelineComponent.getOverrides())) {
            List<TimelineComponent.Item> items = timelineComponent.getItems();
            if ((items instanceof Collection) && items.isEmpty()) {
                z2 = false;
                if (z2) {
                }
            } else {
                for (TimelineComponent.Item item : items) {
                    if (hasUnsupportedCondition(item.getOverrides()) || hasUnsupportedCondition(item.getTitle().getOverrides())) {
                        z = true;
                        if (!z) {
                            z2 = true;
                            break;
                        }
                    } else {
                        TextComponent description = item.getDescription();
                        if (!((description == null || (overrides = description.getOverrides()) == null || !hasUnsupportedCondition(overrides)) ? false : true) && !hasUnsupportedCondition(item.getIcon().getOverrides())) {
                            z = false;
                        }
                        if (!z) {
                        }
                    }
                }
                z2 = false;
                if (z2) {
                    return false;
                }
            }
        }
        return true;
    }

    public static final /* synthetic */ boolean containsUnsupportedCondition(StackComponent stackComponent) {
        Intrinsics.checkNotNullParameter(stackComponent, "<this>");
        if (hasUnsupportedCondition(stackComponent.getOverrides())) {
            return true;
        }
        List components = stackComponent.getComponents();
        if ((components instanceof Collection) && components.isEmpty()) {
            return false;
        }
        Iterator it = components.iterator();
        while (it.hasNext()) {
            if (containsUnsupportedCondition((PaywallComponent) it.next())) {
                return true;
            }
        }
        return false;
    }

    public static final /* synthetic */ boolean containsUnsupportedCondition(PaywallComponentsConfig paywallComponentsConfig) {
        HeaderComponent header;
        StickyFooterComponent stickyFooter;
        StackComponent stack;
        StackComponent stack2;
        Intrinsics.checkNotNullParameter(paywallComponentsConfig, "<this>");
        return containsUnsupportedCondition(paywallComponentsConfig.getStack()) || !(((header = paywallComponentsConfig.getHeader()) == null || (stack2 = header.getStack()) == null || !containsUnsupportedCondition(stack2)) && ((stickyFooter = paywallComponentsConfig.getStickyFooter()) == null || (stack = stickyFooter.getStack()) == null || !containsUnsupportedCondition(stack)));
    }

    public static final /* synthetic */ PaywallValidationResult.Legacy fallbackPaywall(Offering offering, ColorScheme currentColorScheme, ResourceProvider resourceProvider, PaywallValidationError error) {
        Intrinsics.checkNotNullParameter(offering, "<this>");
        Intrinsics.checkNotNullParameter(currentColorScheme, "currentColorScheme");
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(error, "error");
        return fallbackPaywall(offering, currentColorScheme, resourceProvider, (NonEmptyList<? extends PaywallValidationError>) NonEmptyListKt.nonEmptyListOf(error, new PaywallValidationError[0]));
    }

    private static final PaywallValidationResult.Legacy fallbackPaywall(Offering offering, ColorScheme colorScheme, ResourceProvider resourceProvider, NonEmptyList<? extends PaywallValidationError> nonEmptyList) {
        return new PaywallValidationResult.Legacy(PaywallDataExtensionsKt.createDefault(PaywallData.INSTANCE, offering.getAvailablePackages(), colorScheme, resourceProvider), PaywallDataExtensionsKt.getDefaultTemplate(PaywallData.INSTANCE), nonEmptyList);
    }

    private static final Map<LocalizationKey, LocalizationData> getDefaultLocalization(PaywallComponentsData paywallComponentsData) {
        return (Map) LocalizationKt.m10483getBestMatch64pKzr8(paywallComponentsData.getComponentsLocalizations(), paywallComponentsData.getDefaultLocaleIdentifier());
    }

    private static final Map<VariableLocalizationKey, String> getDefaultVariableLocalization(Offering.PaywallComponents paywallComponents) {
        return (Map) LocalizationKt.m10483getBestMatch64pKzr8(paywallComponents.getUiConfig().getLocalizations(), paywallComponents.getData().getDefaultLocaleIdentifier());
    }

    private static final <T> Set<T> getMissingElements(Set<? extends T> set, Set<? extends T> set2) {
        if (set2 == null) {
            set2 = SetsKt.emptySet();
        }
        Set<T> setMinus = SetsKt.minus((Set) set, (Iterable) CollectionsKt.toSet(set2));
        if (setMinus.isEmpty()) {
            return null;
        }
        return setMinus;
    }

    public static final /* synthetic */ boolean hasUnsupportedCondition(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            List conditions = ((ComponentOverride) it.next()).getConditions();
            if (!(conditions instanceof Collection) || !conditions.isEmpty()) {
                Iterator it2 = conditions.iterator();
                while (it2.hasNext()) {
                    if (((ComponentOverride.Condition) it2.next()) instanceof ComponentOverride.Condition.Unsupported) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final PaywallState.Loaded.Components toComponentsPaywallState(Offering offering, PaywallValidationResult.Components validationResult, String str, Function0<? extends Date> dateProvider, PurchasesType purchases, Map<String, ? extends CustomVariableValue> customVariables, Map<String, ? extends CustomVariableValue> defaultCustomVariables) {
        Intrinsics.checkNotNullParameter(offering, "<this>");
        Intrinsics.checkNotNullParameter(validationResult, "validationResult");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        Intrinsics.checkNotNullParameter(defaultCustomVariables, "defaultCustomVariables");
        boolean zContains = str != null ? true ^ validationResult.getZeroDecimalPlaceCountries().contains(str) : true;
        return new PaywallState.Loaded.Components(validationResult.getStack(), validationResult.getHeader(), validationResult.getStickyFooter(), validationResult.getBackground(), validationResult.getMainStackHasHeroImage(), zContains, validationResult.getVariableConfig(), validationResult.getVariableDataProvider(), offering, validationResult.getLocales(), str, dateProvider, validationResult.getPackages(), customVariables, defaultCustomVariables, null, validationResult.getInitialSelectedTabIndex(), null, purchases, 163840, null);
    }

    public static /* synthetic */ PaywallState.Loaded.Components toComponentsPaywallState$default(Offering offering, PaywallValidationResult.Components components, String str, Function0 function0, PurchasesType purchasesType, Map map, Map map2, int i, Object obj) {
        if ((i & 16) != 0) {
            map = MapsKt.emptyMap();
        }
        Map map3 = map;
        if ((i & 32) != 0) {
            map2 = MapsKt.emptyMap();
        }
        return toComponentsPaywallState(offering, components, str, function0, purchasesType, map3, map2);
    }

    public static final PaywallState toLegacyPaywallState(Offering offering, VariableDataProvider variableDataProvider, PaywallMode mode, PaywallData validatedPaywallData, PaywallTemplate template, boolean z, String str, PaywallWarning paywallWarning) {
        Intrinsics.checkNotNullParameter(offering, "<this>");
        Intrinsics.checkNotNullParameter(variableDataProvider, "variableDataProvider");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(validatedPaywallData, "validatedPaywallData");
        Intrinsics.checkNotNullParameter(template, "template");
        Object objM10788createhUnOzRk = TemplateConfigurationFactory.INSTANCE.m10788createhUnOzRk(variableDataProvider, mode, validatedPaywallData, offering.getAvailablePackages(), template, str);
        Throwable thM11448exceptionOrNullimpl = kotlin.Result.m11448exceptionOrNullimpl(objM10788createhUnOzRk);
        if (thM11448exceptionOrNullimpl == null) {
            TemplateConfiguration templateConfiguration = (TemplateConfiguration) objM10788createhUnOzRk;
            return new PaywallState.Loaded.Legacy(offering, templateConfiguration, templateConfiguration.getPackages().getDefault(), z, paywallWarning);
        }
        String message = thM11448exceptionOrNullimpl.getMessage();
        if (message == null) {
            message = "Unknown error";
        }
        return new PaywallState.Error(message);
    }

    private static final PaywallValidationError validate(PaywallData.LocalizedConfiguration localizedConfiguration) {
        PaywallValidationError.InvalidVariables invalidVariablesValidateVariables = validateVariables(localizedConfiguration);
        if (invalidVariablesValidateVariables != null) {
            return invalidVariablesValidateVariables;
        }
        PaywallValidationError.InvalidIcons invalidIconsValidateIcons = validateIcons(localizedConfiguration);
        if (invalidIconsValidateIcons != null) {
            return invalidIconsValidateIcons;
        }
        return null;
    }

    public static final PaywallValidationResult.Legacy validate(PaywallData paywallData, ColorScheme currentColorScheme, ResourceProvider resourceProvider) {
        Intrinsics.checkNotNullParameter(paywallData, "<this>");
        Intrinsics.checkNotNullParameter(currentColorScheme, "currentColorScheme");
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        Object objValidate = validate(paywallData);
        Throwable thM11448exceptionOrNullimpl = kotlin.Result.m11448exceptionOrNullimpl(objValidate);
        if (thM11448exceptionOrNullimpl == null) {
            return new PaywallValidationResult.Legacy(paywallData, (PaywallTemplate) objValidate, null, 4, null);
        }
        PaywallData paywallDataCreateDefaultForIdentifiers = PaywallDataExtensionsKt.createDefaultForIdentifiers(PaywallData.INSTANCE, paywallData.getConfig().getPackageIds(), currentColorScheme, resourceProvider);
        PaywallTemplate defaultTemplate = PaywallDataExtensionsKt.getDefaultTemplate(PaywallData.INSTANCE);
        Intrinsics.checkNotNull(thM11448exceptionOrNullimpl, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError");
        return new PaywallValidationResult.Legacy(paywallDataCreateDefaultForIdentifiers, defaultTemplate, (PaywallValidationError) thM11448exceptionOrNullimpl);
    }

    private static final Object validate(PaywallData paywallData) {
        PaywallTemplate paywallTemplateValidateTemplate = validateTemplate(paywallData);
        if (paywallTemplateValidateTemplate == null) {
            Result.Companion companion = kotlin.Result.INSTANCE;
            return kotlin.Result.m11445constructorimpl(kotlin.ResultKt.createFailure(new PaywallValidationError.InvalidTemplate(paywallData.getTemplateName())));
        }
        int i = WhenMappings.$EnumSwitchMapping$0[paywallTemplateValidateTemplate.getConfigurationType().ordinal()];
        if (i == 1 || i == 2) {
            PaywallValidationError paywallValidationErrorValidate = validate(paywallData.getLocalizedConfiguration().component2());
            if (paywallValidationErrorValidate != null) {
                Result.Companion companion2 = kotlin.Result.INSTANCE;
                return kotlin.Result.m11445constructorimpl(kotlin.ResultKt.createFailure(paywallValidationErrorValidate));
            }
        } else if (i == 3) {
            List<PaywallData.Configuration.Tier> tiers = paywallData.getConfig().getTiers();
            if (tiers == null) {
                tiers = CollectionsKt.emptyList();
            }
            if (tiers.isEmpty()) {
                Result.Companion companion3 = kotlin.Result.INSTANCE;
                return kotlin.Result.m11445constructorimpl(kotlin.ResultKt.createFailure(PaywallValidationError.MissingTiers.INSTANCE));
            }
            List<PaywallData.Configuration.Tier> list = tiers;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((PaywallData.Configuration.Tier) it.next()).getId());
            }
            Set set = CollectionsKt.toSet(arrayList);
            Map<String, PaywallData.Configuration.ColorInformation> colorsByTier = paywallData.getConfig().getColorsByTier();
            Set missingElements = getMissingElements(set, colorsByTier != null ? colorsByTier.keySet() : null);
            if (missingElements != null) {
                Result.Companion companion4 = kotlin.Result.INSTANCE;
                return kotlin.Result.m11445constructorimpl(kotlin.ResultKt.createFailure(new PaywallValidationError.MissingTierConfigurations(missingElements)));
            }
            Map<String, PaywallData.Configuration.Images> imagesByTier = paywallData.getConfig().getImagesByTier();
            Set missingElements2 = getMissingElements(set, imagesByTier != null ? imagesByTier.keySet() : null);
            if (missingElements2 != null) {
                Logger.INSTANCE.w("Missing images for tier(s): " + CollectionsKt.joinToString$default(missingElements2, ",", null, null, 0, null, null, 62, null));
            }
            Map<String, PaywallData.LocalizedConfiguration> mapComponent2 = paywallData.getTieredLocalizedConfiguration().component2();
            Set missingElements3 = getMissingElements(set, mapComponent2.keySet());
            if (missingElements3 != null) {
                Result.Companion companion5 = kotlin.Result.INSTANCE;
                return kotlin.Result.m11445constructorimpl(kotlin.ResultKt.createFailure(new PaywallValidationError.MissingTierConfigurations(missingElements3)));
            }
            Iterator<T> it2 = mapComponent2.entrySet().iterator();
            while (it2.hasNext()) {
                PaywallValidationError paywallValidationErrorValidate2 = validate((PaywallData.LocalizedConfiguration) ((Map.Entry) it2.next()).getValue());
                if (paywallValidationErrorValidate2 != null) {
                    Result.Companion companion6 = kotlin.Result.INSTANCE;
                    return kotlin.Result.m11445constructorimpl(kotlin.ResultKt.createFailure(paywallValidationErrorValidate2));
                }
            }
        }
        Result.Companion companion7 = kotlin.Result.INSTANCE;
        return kotlin.Result.m11445constructorimpl(paywallTemplateValidateTemplate);
    }

    private static final PaywallValidationError.InvalidIcons validateIcons(PaywallData.LocalizedConfiguration localizedConfiguration) {
        List<PaywallData.LocalizedConfiguration.Feature> features = localizedConfiguration.getFeatures();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = features.iterator();
        while (it.hasNext()) {
            String strValidateIcons$validateIcon = validateIcons$validateIcon((PaywallData.LocalizedConfiguration.Feature) it.next());
            if (strValidateIcons$validateIcon != null) {
                arrayList.add(strValidateIcons$validateIcon);
            }
        }
        Set set = CollectionsKt.toSet(arrayList);
        if (set.isEmpty()) {
            return null;
        }
        return new PaywallValidationError.InvalidIcons(set);
    }

    private static final String validateIcons$validateIcon(PaywallData.LocalizedConfiguration.Feature feature) {
        String iconID = feature.getIconID();
        if (iconID == null || PaywallIconName.INSTANCE.fromValue(iconID) != null) {
            return null;
        }
        return iconID;
    }

    /* JADX WARN: Removed duplicated region for block: B:173:0x05c5 A[PHI: r0
      0x05c5: PHI (r0v24 java.lang.Integer) = (r0v23 java.lang.Integer), (r0v28 java.lang.Integer) binds: [B:165:0x05b0, B:169:0x05ba] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Result<PaywallValidationResult.Components, NonEmptyList<PaywallValidationError>> validatePaywallComponentsDataOrNull(Offering offering, ResourceProvider resourceProvider) {
        Integer defaultTabIndex;
        StackComponentStyle stackComponentStyleM10589copyh6c5tkY$default;
        Intrinsics.checkNotNullParameter(offering, "<this>");
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        Offering.PaywallComponents paywallComponents = offering.getPaywallComponents();
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        if (paywallComponents == null) {
            return null;
        }
        Result.Error errorErrorIfNull = ResultKt.errorIfNull(getDefaultLocalization(paywallComponents.getData()), new PaywallValidationError.AllLocalizationsMissing(paywallComponents.getData().getDefaultLocaleIdentifier(), z5 ? 1 : 0));
        boolean z6 = false;
        if (!(errorErrorIfNull instanceof Result.Success)) {
            if (!(errorErrorIfNull instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            errorErrorIfNull = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError.AllLocalizationsMissing) ((Result.Error) errorErrorIfNull).getValue(), new PaywallValidationError.AllLocalizationsMissing[0]));
        }
        if (!(errorErrorIfNull instanceof Result.Success)) {
            if (errorErrorIfNull instanceof Result.Error) {
                return new Result.Error((NonEmptyList) ((Result.Error) errorErrorIfNull).getValue());
            }
            throw new NoWhenBranchMatchedException();
        }
        NonEmptyMap nonEmptyMapNonEmptyMapOf = NonEmptyMapKt.nonEmptyMapOf(TuplesKt.to(LocaleId.m10392boximpl(paywallComponents.getData().getDefaultLocaleIdentifier()), (Map) ((Result.Success) errorErrorIfNull).getValue()), paywallComponents.getData().getComponentsLocalizations());
        Map map = nonEmptyMapNonEmptyMapOf.all;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Result.Error errorErrorIfNull2 = ResultKt.errorIfNull(NonEmptyMapKt.toNonEmptyMapOrNull((Map) entry.getValue()), new PaywallValidationError.AllLocalizationsMissing(((LocaleId) entry.getKey()).m10398unboximpl(), z4 ? 1 : 0));
            if (!(errorErrorIfNull2 instanceof Result.Success)) {
                if (!(errorErrorIfNull2 instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                errorErrorIfNull2 = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError.AllLocalizationsMissing) ((Result.Error) errorErrorIfNull2).getValue(), new PaywallValidationError.AllLocalizationsMissing[0]));
            }
            linkedHashMap.put(key, errorErrorIfNull2);
        }
        NonEmptyMap nonEmptyMapNonEmptyMapOf2 = NonEmptyMapKt.nonEmptyMapOf(TuplesKt.to(nonEmptyMapNonEmptyMapOf.getEntry().getKey(), MapsKt.getValue(linkedHashMap, nonEmptyMapNonEmptyMapOf.getEntry().getKey())), linkedHashMap);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        Result.Success success = (Result) nonEmptyMapNonEmptyMapOf2.getEntry().getValue();
        if (success instanceof Result.Success) {
            success = new Result.Success((NonEmptyMap) ((Result.Success) success).getValue());
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            success = new Result.Success(TuplesKt.to(nonEmptyMapNonEmptyMapOf2.getEntry().getKey(), ((Result.Success) success).getValue()));
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!(success instanceof Result.Success) && (success instanceof Result.Error)) {
            arrayList.addAll((NonEmptyList) ((Result.Error) success).getValue());
        }
        Iterator it = nonEmptyMapNonEmptyMapOf2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            Object key2 = entry2.getKey();
            Result result = (Result) entry2.getValue();
            if (result instanceof Result.Success) {
                if (arrayList.isEmpty() && !Intrinsics.areEqual(key2, nonEmptyMapNonEmptyMapOf2.getEntry().getKey())) {
                    linkedHashMap2.put(key2, (NonEmptyMap) ((Result.Success) result).getValue());
                }
            } else if (result instanceof Result.Error) {
                arrayList.addAll((Collection) ((Result.Error) result).getValue());
            }
        }
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(arrayList);
        Object error = nonEmptyListOrNull != null ? new Result.Error(nonEmptyListOrNull) : new Result.Success(NonEmptyMapKt.nonEmptyMapOf((Pair) ResultKt.getOrThrow(success), linkedHashMap2));
        if (!(error instanceof Result.Success)) {
            if (error instanceof Result.Error) {
                return new Result.Error((NonEmptyList) ((Result.Error) error).getValue());
            }
            throw new NoWhenBranchMatchedException();
        }
        NonEmptyMap nonEmptyMap = (NonEmptyMap) ((Result.Success) error).getValue();
        Result.Error errorErrorIfNull3 = ResultKt.errorIfNull(getDefaultVariableLocalization(paywallComponents), new PaywallValidationError.AllVariableLocalizationsMissing(paywallComponents.getData().getDefaultLocaleIdentifier(), z3 ? 1 : 0));
        if (!(errorErrorIfNull3 instanceof Result.Success)) {
            if (!(errorErrorIfNull3 instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            errorErrorIfNull3 = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError.AllVariableLocalizationsMissing) ((Result.Error) errorErrorIfNull3).getValue(), new PaywallValidationError.AllVariableLocalizationsMissing[0]));
        }
        if (!(errorErrorIfNull3 instanceof Result.Success)) {
            if (errorErrorIfNull3 instanceof Result.Error) {
                return new Result.Error((NonEmptyList) ((Result.Error) errorErrorIfNull3).getValue());
            }
            throw new NoWhenBranchMatchedException();
        }
        NonEmptyMap nonEmptyMapNonEmptyMapOf3 = NonEmptyMapKt.nonEmptyMapOf(TuplesKt.to(LocaleId.m10392boximpl(paywallComponents.getData().getDefaultLocaleIdentifier()), (Map) ((Result.Success) errorErrorIfNull3).getValue()), paywallComponents.getUiConfig().getLocalizations());
        Map map2 = nonEmptyMapNonEmptyMapOf3.all;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(map2.size()));
        for (Map.Entry entry3 : map2.entrySet()) {
            Object key3 = entry3.getKey();
            Result.Error errorErrorIfNull4 = ResultKt.errorIfNull(NonEmptyMapKt.toNonEmptyMapOrNull((Map) entry3.getValue()), new PaywallValidationError.AllLocalizationsMissing(((LocaleId) entry3.getKey()).m10398unboximpl(), z2 ? 1 : 0));
            if (!(errorErrorIfNull4 instanceof Result.Success)) {
                if (!(errorErrorIfNull4 instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                errorErrorIfNull4 = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError.AllLocalizationsMissing) ((Result.Error) errorErrorIfNull4).getValue(), new PaywallValidationError.AllLocalizationsMissing[0]));
            }
            linkedHashMap3.put(key3, errorErrorIfNull4);
        }
        NonEmptyMap nonEmptyMapNonEmptyMapOf4 = NonEmptyMapKt.nonEmptyMapOf(TuplesKt.to(nonEmptyMapNonEmptyMapOf3.getEntry().getKey(), MapsKt.getValue(linkedHashMap3, nonEmptyMapNonEmptyMapOf3.getEntry().getKey())), linkedHashMap3);
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        ArrayList arrayList2 = new ArrayList();
        Result.Success success2 = (Result) nonEmptyMapNonEmptyMapOf4.getEntry().getValue();
        if (success2 instanceof Result.Success) {
            success2 = new Result.Success((NonEmptyMap) ((Result.Success) success2).getValue());
        } else if (!(success2 instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success2 instanceof Result.Success) {
            success2 = new Result.Success(TuplesKt.to(nonEmptyMapNonEmptyMapOf4.getEntry().getKey(), ((Result.Success) success2).getValue()));
        } else if (!(success2 instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!(success2 instanceof Result.Success) && (success2 instanceof Result.Error)) {
            arrayList2.addAll((NonEmptyList) ((Result.Error) success2).getValue());
        }
        Iterator it2 = nonEmptyMapNonEmptyMapOf4.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry4 = (Map.Entry) it2.next();
            Object key4 = entry4.getKey();
            Result result2 = (Result) entry4.getValue();
            if (result2 instanceof Result.Success) {
                if (arrayList2.isEmpty() && !Intrinsics.areEqual(key4, nonEmptyMapNonEmptyMapOf4.getEntry().getKey())) {
                    linkedHashMap4.put(key4, (NonEmptyMap) ((Result.Success) result2).getValue());
                }
            } else if (result2 instanceof Result.Error) {
                arrayList2.addAll((Collection) ((Result.Error) result2).getValue());
            }
        }
        NonEmptyList nonEmptyListOrNull2 = NonEmptyListKt.toNonEmptyListOrNull(arrayList2);
        Object error2 = nonEmptyListOrNull2 != null ? new Result.Error(nonEmptyListOrNull2) : new Result.Success(NonEmptyMapKt.nonEmptyMapOf((Pair) ResultKt.getOrThrow(success2), linkedHashMap4));
        if (!(error2 instanceof Result.Success)) {
            if (error2 instanceof Result.Error) {
                return new Result.Error((NonEmptyList) ((Result.Error) error2).getValue());
            }
            throw new NoWhenBranchMatchedException();
        }
        NonEmptyMap nonEmptyMap2 = (NonEmptyMap) ((Result.Success) error2).getValue();
        Map colors = paywallComponents.getUiConfig().getApp().getColors();
        Map mapDetermineFontSpecs = FontSpecKt.determineFontSpecs(paywallComponents.getUiConfig().getApp().getFonts(), resourceProvider);
        PaywallComponentsConfig base = paywallComponents.getData().getComponentsConfig().getBase();
        boolean zContainsUnsupportedCondition = containsUnsupportedCondition(base);
        if (zContainsUnsupportedCondition) {
            Logger.INSTANCE.w("Unsupported paywall rule encountered. Rendering paywall without conditional overrides.");
        }
        StyleFactory styleFactory = new StyleFactory(nonEmptyMap, colors, mapDetermineFontSpecs, nonEmptyMap2, offering, zContainsUnsupportedCondition);
        Result<StyleFactory.StyleResult, NonEmptyList<PaywallValidationError>> resultCreate = styleFactory.create(base.getStack(), base.getHeader() == null, base.getStickyFooter() == null, true);
        HeaderComponent header = base.getHeader();
        Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(header != null ? StyleFactory.create$default(styleFactory, header, false, false, true, 6, null) : null);
        StickyFooterComponent stickyFooter = base.getStickyFooter();
        Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(stickyFooter != null ? StyleFactory.create$default(styleFactory, stickyFooter, false, true, true, 2, null) : null);
        Result backgroundStyles = BackgroundStyleKt.toBackgroundStyles(base.getBackground(), colors);
        Result.Success success3 = new Result.Success(Unit.INSTANCE);
        Result.Success success4 = new Result.Success(Unit.INSTANCE);
        int i = 2;
        NonEmptyList nonEmptyListOrNull3 = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{resultCreate, resultOrSuccessfullyNull, resultOrSuccessfullyNull2, backgroundStyles, success3, success4})));
        if (nonEmptyListOrNull3 != null) {
            return new Result.Error(nonEmptyListOrNull3);
        }
        Intrinsics.checkNotNull(resultCreate, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) resultCreate).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value2 = ((Result.Success) resultOrSuccessfullyNull).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value3 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
        Intrinsics.checkNotNull(backgroundStyles, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value4 = ((Result.Success) backgroundStyles).getValue();
        Object value5 = success3.getValue();
        BackgroundStyles backgroundStyles2 = (BackgroundStyles) value4;
        StyleFactory.StyleResult styleResult = (StyleFactory.StyleResult) value3;
        StyleFactory.StyleResult styleResult2 = (StyleFactory.StyleResult) value2;
        StyleFactory.StyleResult styleResult3 = (StyleFactory.StyleResult) value;
        StackComponentStyle componentStyle = styleResult3.getComponentStyle();
        ComponentStyle componentStyle2 = styleResult2 != null ? styleResult2.getComponentStyle() : null;
        ComponentStyle componentStyle3 = styleResult != null ? styleResult.getComponentStyle() : null;
        StackComponentStyle stackComponentStyle = componentStyle instanceof StackComponentStyle ? (StackComponentStyle) componentStyle : null;
        if (stackComponentStyle != null) {
            StackComponentStyle stackComponentStyle2 = Intrinsics.areEqual(stackComponentStyle.getSize().getHeight(), SizeConstraint.Fit.INSTANCE) ? stackComponentStyle : null;
            if (stackComponentStyle2 != null && (stackComponentStyleM10589copyh6c5tkY$default = StackComponentStyle.m10589copyh6c5tkY$default(stackComponentStyle2, null, null, false, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fill.INSTANCE), 0.0f, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, false, 16777207, null)) != null) {
                componentStyle = stackComponentStyleM10589copyh6c5tkY$default;
            }
        }
        ComponentStyle componentStyle4 = componentStyle;
        NonEmptySet nonEmptySet = (NonEmptySet) nonEmptyMap.keySet();
        Set set = CollectionsKt.toSet(paywallComponents.getData().getZeroDecimalPlaceCountries());
        UiConfig.VariableConfig variableConfig = paywallComponents.getUiConfig().getVariableConfig();
        VariableDataProvider variableDataProvider = new VariableDataProvider(resourceProvider, z6, i, z ? 1 : 0);
        PaywallState.Loaded.Components.AvailablePackages availablePackagesMerge = styleResult3.getAvailablePackages().merge(styleResult2 != null ? styleResult2.getAvailablePackages() : null).merge(styleResult != null ? styleResult.getAvailablePackages() : null);
        Integer defaultTabIndex2 = styleResult3.getDefaultTabIndex();
        if (defaultTabIndex2 != null) {
            defaultTabIndex = defaultTabIndex2;
        } else {
            defaultTabIndex2 = styleResult2 != null ? styleResult2.getDefaultTabIndex() : null;
            if (defaultTabIndex2 == null) {
                defaultTabIndex = styleResult != null ? styleResult.getDefaultTabIndex() : null;
            }
        }
        return new Result.Success(new PaywallValidationResult.Components(componentStyle4, componentStyle2, componentStyle3, backgroundStyles2, nonEmptySet, set, variableConfig, variableDataProvider, availablePackagesMerge, defaultTabIndex, styleResult3.getHeroImageDetected()));
    }

    private static final PaywallTemplate validateTemplate(PaywallData paywallData) {
        return PaywallTemplate.INSTANCE.fromId(paywallData.getTemplateName());
    }

    private static final PaywallValidationError.InvalidVariables validateVariables(PaywallData.LocalizedConfiguration localizedConfiguration) {
        Set setPlus = SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus((Set) validateVariables$validateVariablesInProperty(localizedConfiguration.getTitle()), (Iterable) validateVariables$validateVariablesInProperty(localizedConfiguration.getSubtitle())), (Iterable) validateVariables$validateVariablesInProperty(localizedConfiguration.getCallToAction())), (Iterable) validateVariables$validateVariablesInProperty(localizedConfiguration.getCallToActionWithIntroOffer())), (Iterable) validateVariables$validateVariablesInProperty(localizedConfiguration.getOfferDetails())), (Iterable) validateVariables$validateVariablesInProperty(localizedConfiguration.getOfferDetailsWithIntroOffer())), (Iterable) validateVariables$validateVariablesInProperty(localizedConfiguration.getOfferName()));
        List<PaywallData.LocalizedConfiguration.Feature> features = localizedConfiguration.getFeatures();
        ArrayList arrayList = new ArrayList();
        for (PaywallData.LocalizedConfiguration.Feature feature : features) {
            CollectionsKt.addAll(arrayList, SetsKt.plus((Set) validateVariables$validateVariablesInProperty(feature.getTitle()), (Iterable) validateVariables$validateVariablesInProperty(feature.getContent())));
        }
        Set setPlus2 = SetsKt.plus(setPlus, (Iterable) arrayList);
        if (setPlus2.isEmpty()) {
            return null;
        }
        return new PaywallValidationError.InvalidVariables(setPlus2);
    }

    private static final Set<String> validateVariables$validateVariablesInProperty(String str) {
        Set<String> setValidateVariables;
        return (str == null || (setValidateVariables = VariableProcessor.INSTANCE.validateVariables(str)) == null) ? SetsKt.emptySet() : setValidateVariables;
    }

    public static final PaywallValidationResult validatedPaywall(Offering offering, ColorScheme currentColorScheme, ResourceProvider resourceProvider) {
        PaywallValidationResult.Legacy legacyFallbackPaywall;
        Intrinsics.checkNotNullParameter(offering, "<this>");
        Intrinsics.checkNotNullParameter(currentColorScheme, "currentColorScheme");
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        Result<PaywallValidationResult.Components, NonEmptyList<PaywallValidationError>> resultValidatePaywallComponentsDataOrNull = validatePaywallComponentsDataOrNull(offering, resourceProvider);
        if (resultValidatePaywallComponentsDataOrNull != null) {
            if (resultValidatePaywallComponentsDataOrNull instanceof Result.Success) {
                legacyFallbackPaywall = (PaywallValidationResult) ((Result.Success) resultValidatePaywallComponentsDataOrNull).getValue();
            } else {
                if (!(resultValidatePaywallComponentsDataOrNull instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                legacyFallbackPaywall = fallbackPaywall(offering, currentColorScheme, resourceProvider, (NonEmptyList<? extends PaywallValidationError>) ((Result.Error) resultValidatePaywallComponentsDataOrNull).getValue());
            }
            if (legacyFallbackPaywall != null) {
                return legacyFallbackPaywall;
            }
        }
        PaywallData paywall = offering.getPaywall();
        return paywall != null ? validate(paywall, currentColorScheme, resourceProvider) : fallbackPaywall(offering, currentColorScheme, resourceProvider, PaywallValidationError.MissingPaywall.INSTANCE);
    }
}
