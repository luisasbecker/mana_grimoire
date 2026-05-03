package com.appsflyer.internal;

import androidx.media3.muxer.WebmConstants;
import java.util.Map;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes3.dex */
public class AFi1gSDK {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static int $10 = 0;
    private static int $11 = 1;
    private static int $12 = 0;
    private static int $13 = 1;
    public static final Map AFInAppEventParameterName;
    private static long afDebugLog;
    private static int afErrorLog;
    private static long afInfoLog;
    private static int afLogForce;
    public static final Map d;
    private static byte[] e;
    private static int force;
    private static Object i;
    private static byte[] unregisterClient;
    private static long v;
    private static Object w;

    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0042 -> B:14:0x0051). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String $$c(short s, byte b, int i2) {
        int i3;
        int i4;
        int i5 = 2 % 2;
        int i6 = $13;
        int i7 = i6 + 7;
        $12 = i7 % 128;
        int i8 = i7 % 2;
        byte[] bArr = $$a;
        int i9 = 1151 - i2;
        int i10 = b + 1;
        int i11 = 119 - s;
        byte[] bArr2 = new byte[i10];
        if (bArr == null) {
            int i12 = i6 + 109;
            $12 = i12 % 128;
            int i13 = i12 % 2;
            int i14 = i9;
            i4 = 0;
            int i15 = i10;
            i11 = (i15 + (-i11)) - 3;
            i9 = i14 + 1;
            i3 = i4;
            i4 = i3 + 1;
            bArr2[i3] = (byte) i11;
            if (i4 == i10) {
                String str = new String(bArr2, 0);
                int i16 = $12 + 93;
                $13 = i16 % 128;
                if (i16 % 2 != 0) {
                    return str;
                }
                Object obj = null;
                obj.hashCode();
                throw null;
            }
            int i17 = bArr[i9];
            int i18 = $12 + 55;
            $13 = i18 % 128;
            int i19 = i18 % 2;
            int i20 = i9;
            i15 = i11;
            i11 = i17;
            i14 = i20;
            i11 = (i15 + (-i11)) - 3;
            i9 = i14 + 1;
            i3 = i4;
            i4 = i3 + 1;
            bArr2[i3] = (byte) i11;
            if (i4 == i10) {
            }
        } else {
            i3 = 0;
            i4 = i3 + 1;
            bArr2[i3] = (byte) i11;
            if (i4 == i10) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:513:0x1733 A[Catch: all -> 0x1759, PHI: r3
      0x1733: PHI (r3v153 java.lang.Object) = (r3v151 java.lang.Object), (r3v154 java.lang.Object) binds: [B:507:0x170f, B:512:0x1731] A[DONT_GENERATE, DONT_INLINE], TryCatch #17 {all -> 0x1759, blocks: (B:501:0x1613, B:506:0x1709, B:513:0x1733, B:511:0x172b, B:516:0x1751, B:518:0x1757, B:519:0x1758, B:493:0x15f7, B:498:0x160e, B:504:0x16ec, B:509:0x1712), top: B:801:0x1613, inners: #14 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02e4 A[Catch: Exception -> 0x1cc6, TRY_ENTER, TRY_LEAVE, TryCatch #61 {Exception -> 0x1cc6, blocks: (B:8:0x012c, B:13:0x014f, B:67:0x034a, B:71:0x038e, B:73:0x0394, B:74:0x0395, B:75:0x0396, B:77:0x03e0, B:79:0x03e7, B:81:0x03ef, B:83:0x0409, B:97:0x0441, B:101:0x044b, B:105:0x0455, B:115:0x0471, B:711:0x1b76, B:715:0x1bdc, B:717:0x1be0, B:718:0x1bec, B:719:0x1bfc, B:724:0x1c4e, B:726:0x1c54, B:727:0x1c55, B:62:0x02e4, B:736:0x1cac, B:738:0x1cb2, B:739:0x1cb3, B:741:0x1cb5, B:743:0x1cbb, B:744:0x1cbc, B:52:0x028c, B:57:0x0299, B:746:0x1cbe, B:748:0x1cc4, B:749:0x1cc5, B:14:0x015e, B:721:0x1c19, B:722:0x1c4c, B:68:0x0358, B:64:0x0324, B:63:0x02f0, B:58:0x02bc), top: B:882:0x012c, inners: #13, #53, #69, #74, #78 }] */
    /* JADX WARN: Removed duplicated region for block: B:857:0x17b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:983:0x1938 A[EDGE_INSN: B:983:0x1938->B:564:0x1938 BREAK  A[LOOP:2: B:279:0x0aa5->B:543:0x18fc], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0447  */
    /* JADX WARN: Type inference failed for: r0v217, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r1v123, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r1v162, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r1v246, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r1v290, types: [int, short] */
    /* JADX WARN: Type inference failed for: r2v269, types: [java.lang.Class[]] */
    /* JADX WARN: Type inference failed for: r2v277, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v119, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r3v120 */
    /* JADX WARN: Type inference failed for: r3v121 */
    /* JADX WARN: Type inference failed for: r3v122, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r3v123 */
    /* JADX WARN: Type inference failed for: r3v124 */
    /* JADX WARN: Type inference failed for: r3v125 */
    /* JADX WARN: Type inference failed for: r3v131 */
    /* JADX WARN: Type inference failed for: r3v132, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r3v133 */
    /* JADX WARN: Type inference failed for: r3v143, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r3v144 */
    /* JADX WARN: Type inference failed for: r3v155 */
    /* JADX WARN: Type inference failed for: r3v156 */
    /* JADX WARN: Type inference failed for: r3v157 */
    /* JADX WARN: Type inference failed for: r3v158 */
    /* JADX WARN: Type inference failed for: r3v162, types: [java.lang.Class[]] */
    /* JADX WARN: Type inference failed for: r3v163 */
    /* JADX WARN: Type inference failed for: r3v167, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v168, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r3v169 */
    /* JADX WARN: Type inference failed for: r3v170 */
    /* JADX WARN: Type inference failed for: r3v179 */
    /* JADX WARN: Type inference failed for: r3v180 */
    /* JADX WARN: Type inference failed for: r3v181 */
    /* JADX WARN: Type inference failed for: r3v182 */
    /* JADX WARN: Type inference failed for: r3v185 */
    /* JADX WARN: Type inference failed for: r3v210 */
    /* JADX WARN: Type inference failed for: r3v219 */
    /* JADX WARN: Type inference failed for: r3v220 */
    /* JADX WARN: Type inference failed for: r3v221 */
    /* JADX WARN: Type inference failed for: r3v222 */
    /* JADX WARN: Type inference failed for: r3v223 */
    /* JADX WARN: Type inference failed for: r3v224 */
    /* JADX WARN: Type inference failed for: r3v225 */
    /* JADX WARN: Type inference failed for: r3v226 */
    /* JADX WARN: Type inference failed for: r49v2 */
    /* JADX WARN: Type inference failed for: r49v3 */
    /* JADX WARN: Type inference failed for: r49v6 */
    /* JADX WARN: Type inference failed for: r49v7 */
    /* JADX WARN: Type inference failed for: r49v8 */
    /* JADX WARN: Type inference failed for: r49v9 */
    /* JADX WARN: Type inference failed for: r4v135, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r5v152, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v139, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r7v91, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r8v29, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r8v33, types: [java.lang.Class] */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:112:0x046b
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:226)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:196)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:63)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    static {
        /*
            Method dump skipped, instruction units count: 7398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFi1gSDK.<clinit>():void");
    }

    private AFi1gSDK() {
    }

    public static int getCurrencyIso4217Code(int i2) throws Throwable {
        int i3 = 2 % 2;
        int i4 = $11;
        int i5 = (i4 ^ 21) + ((i4 & 21) << 1);
        int i6 = i5 % 128;
        $10 = i6;
        int i7 = i5 % 2;
        Object obj = w;
        int i8 = (i6 ^ 11) + ((i6 & 11) << 1);
        $11 = i8 % 128;
        int i9 = i8 % 2;
        try {
            Object[] objArr = {Integer.valueOf(i2)};
            byte[] bArr = $$a;
            int iIntValue = ((Integer) Class.forName($$c(bArr[289], bArr[894], Videoio.CAP_PROP_XI_FFS_ACCESS_KEY), true, (ClassLoader) i).getMethod($$c(bArr[56], bArr[326], bArr[7]), Integer.TYPE).invoke(obj, objArr)).intValue();
            int i10 = $10 + 97;
            $11 = i10 % 128;
            int i11 = i10 % 2;
            return iIntValue;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    private static void getCurrencyIso4217Code(int i2, int i3) {
        int i4 = 2 % 2;
        int i5 = $10 + 119;
        $11 = i5 % 128;
        if (i5 % 2 == 0) {
            int i6 = 21 / 0;
        }
    }

    public static Object getMediationNetwork(int i2, int i3, char c) throws Throwable {
        int i4 = 2 % 2;
        int i5 = $10;
        int i6 = (i5 & 25) + (i5 | 25);
        $11 = i6 % 128;
        if (i6 % 2 == 0) {
            throw null;
        }
        Object obj = w;
        int i7 = (i5 & 73) + (i5 | 73);
        $11 = i7 % 128;
        int i8 = i7 % 2;
        try {
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Character.valueOf(c)};
            byte[] bArr = $$a;
            Class<?> cls = Class.forName($$c(bArr[289], bArr[894], Videoio.CAP_PROP_XI_FFS_ACCESS_KEY), true, (ClassLoader) i);
            byte b = bArr[232];
            byte b2 = bArr[13];
            Object objInvoke = cls.getMethod($$c(b, b2, b2), Integer.TYPE, Integer.TYPE, Character.TYPE).invoke(obj, objArr);
            int i9 = $10;
            int i10 = (i9 & Imgproc.COLOR_YUV2RGBA_YVYU) + (i9 | Imgproc.COLOR_YUV2RGBA_YVYU);
            $11 = i10 % 128;
            int i11 = i10 % 2;
            return objInvoke;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static int getRevenue(Object obj) throws Throwable {
        int i2 = 2 % 2;
        int iCurrentTimeMillis = (int) System.currentTimeMillis();
        int i3 = ~(380291229 | iCurrentTimeMillis);
        int i4 = (-1845393600) + (((i3 & 332130) | (332130 ^ i3)) * 345);
        int i5 = ~iCurrentTimeMillis;
        int i6 = ~((380291229 & i5) | (380291229 ^ i5));
        int i7 = i4 + (((i6 & 310411396) | (i6 ^ 310411396)) * 345);
        int i8 = -(-((~((iCurrentTimeMillis & (-332131)) | ((-332131) ^ iCurrentTimeMillis))) * 345));
        int i9 = ((i7 | i8) << 1) - (i8 ^ i7);
        int iCurrentTimeMillis2 = (int) System.currentTimeMillis();
        int i10 = ~((~iCurrentTimeMillis2) | 875520558);
        int i11 = -(-(((i10 & (-939486207)) | ((-939486207) ^ i10)) * (-712)));
        int i12 = (124585913 ^ i11) + ((i11 & 124585913) << 1);
        int i13 = ~iCurrentTimeMillis2;
        int i14 = (66472924 ^ i13) | (66472924 & i13);
        int i15 = ~((i14 & 875520558) | (i14 ^ 875520558));
        int i16 = ~((iCurrentTimeMillis2 & (-63965649)) | ((-63965649) ^ iCurrentTimeMillis2));
        int i17 = -(-(((i16 & i15) | (i15 ^ i16)) * (-712)));
        int i18 = ((i12 | i17) << 1) - (i17 ^ i12);
        int i19 = -(-(((~(i13 | 875520558)) | 66472924) * 712));
        if (i9 > ((i18 | i19) << 1) - (i19 ^ i18)) {
            throw null;
        }
        Object obj2 = w;
        int i20 = $11 + 47;
        $10 = i20 % 128;
        int i21 = i20 % 2;
        try {
            byte[] bArr = $$a;
            int iIntValue = ((Integer) Class.forName($$c(bArr[289], bArr[894], Videoio.CAP_PROP_XI_FFS_ACCESS_KEY), true, (ClassLoader) i).getMethod($$c(bArr[56], bArr[326], bArr[7]), Object.class).invoke(obj2, obj)).intValue();
            int i22 = $11 + 39;
            $10 = i22 % 128;
            if (i22 % 2 != 0) {
                int i23 = 42 / 0;
            }
            return iIntValue;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    static void init$0() {
        int i2 = 2 % 2;
        int i3 = $11;
        int i4 = (i3 ^ 27) + ((i3 & 27) << 1);
        $10 = i4 % 128;
        int i5 = i4 % 2;
        byte[] bArr = new byte[1172];
        System.arraycopy("\t\u009bf\u000fð\u0007ï\u0000\u0003\u00023Äò\u000eî\u0005ü\u0003íBèÑ\u0000úúò\nýôñÿ;Ëîýú\n÷ð\u0011ð@Ãø÷\fð\u0001\nò:ëøÚ5È\u0010\föõýñÿ<Êîýú\n÷ð\u0011ðð\u0007ï\u0000\u0003\u00023Êîý?êÛì\bð\nòø\"éó\n\u0001úë\u0000ý\nô÷0Îý\u0001\u0000\u0003ÿê\b÷þð\u0007ï\u0000\u0003\u00023Êîý?êÎý&Øú\nþòöÿî(Ø\u0002ò\b\u0005ò(Îý\u0001\u0000\u0003ÿê\b÷þÿî+Úú\u0004ï,Øôÿî.Ñ\bü\u001fßûø\u0000\u001eØôÿî.ßûø\u0000\u001eØôÈ\u0000ê\u0010/È\u0000ê\u0010/\u0006è\u00120Â÷>åÚú\u0004\u0006è\u00120Â÷>·\u0004ú\tøô\u0006è\u00120¿\bð\u00046Ø×\u0003ü\fõÿî!Û\u0000ü\bðûøñ\bü\u0003ùÿûø\u0000ð\u0007ï\u0000\u0003\u00023¼ùBéÊ\tú\u0005=Ë\u000eðü\u0007÷þ\föé\u0013ø÷ÿð\u0014â\u0006ò\f\u0012÷\u0013õ\u0006è\u00120Â÷>â÷\u0007Ê\u0012ûòù\b÷þë\u0000ý\nô÷\u001dèù\u0005\u0015áúý\u0000ó\u0006è\u00120Â÷>åÚú\u0004\u0013×þ\u0001øþ\u001eÜÿ\n\u0001ñôúù\u000b\u0012ú\u0010õËëý\u000bîþAÉñÿ;Ëîýú\n÷ð\u0011ð@Ãø÷\fð\u0001\nò:È/ü÷Ô,Ë)\u0005ûú\u0000÷\u0004Íü3ÿî\u001fêï\u0001÷\u0000\fû\u0006è\u00120½\u0006îCÖ\u0000\u0003ÿî!ìê\t\u0006è\u00120Â÷>éÊ\fýþð\nþ\u0018Øûøþ\u001eÜÿ\n\u0001ñ\u0006è\u00120Â÷>âØûøþ\u001eÜÿ\n\u0001ñ\u0006è\u00120Â÷>çàê\u0010\u0015Øûøþ\u001eÜÿ\n\u0001ñ\n\u0001ú\u001bÎ\u0006ýð\u0006è\u00120Â÷>éÆ\u0002\f!Ìý\u000eå-Øûøþ\u001eÜÿ\n\u0001ññÿ<Êîýú\n÷ð\u0011ðAÂø÷\fð\u0001\nò;êøØ7º\u001e\föñÿ<Êîýú\n÷ð\u0011ðAÂø÷\fð\u0001\nò;êøÚ5È\u0010\föõýÿî$åþø\u0005ê\b÷þ\u001dæîú\u0005ú\u0004\u0005ÿö\n\u0001ú\u000bî\u001fê\u0001ú\u0012Þÿð\u0012ù\u0011õ\u0002\u0006ò\fÿî+ÿ\u0006è\u00120Â÷>åÚú\u0004\u001eÜï\rî\u0006öù\u0002ú÷\b\b\u0000òó\nû:¸÷\u0003ü\fõ<çÜê/Úú\u0004ú\u000bú\u001dÜêÿî0Üì\u0001\u0000ôþ\f\u0012ìê\tüö\u0004î\fÿî.Ô\bëý$Ú\u000búüð\u0006è\u00120¶þ\bú;±\u000eö?Ñîö$Øûøþ\u001eÜÿ\n\u0001ñÿî#æê\u0001,Ô÷ÿö\u0006è\u00120¶þ\bú;±\u000eö?Ñîö(Ô÷ÿöÿî\u001eçì\u0012\u0006è\u00120Â÷>éÆ\u0002\f!Ìý\u000eå'×þ\u0001øþ\u001eÜÿ\n\u0001ñ\u0002*Æ\u0002\f!Ìý\u000eå\u0006è\u00120Â÷>èÔúù\u000b\u0001üó\u0004\u0000òó\nû:¸÷\u0003ü\fõ<âØ\u001eåõûúö2Üê2Ô\bëý$Ú\u000búüð\u0006è\u00120½\u0002÷>éÆ\u0002\f Ê\fýþð\u0006è\u00120¿\bð\u00046èÔ\bëý$Ú\u000búüð\u0002\u000eî\u0000òó\nû:¸÷\u0003ü\fõ<éÞë\u000b\u001eÜê2Ô\bëý$Ú\u000búüð\fê\t\u0019àóü\nê\bð\u000e\u0016à\u0004í\u000eìö2Øô\nÿì\u0002ú\u0006\u0001ï\nê\bð\u000e\u0016à\u0004í\u000eìö&ìê\t Ö\u0004õ\u0005ô÷þÿî.Ñÿúþþ\u0006ô÷\u001dØ\u0006\b\u0012õ\u0015õú\u000bú\u001eÔ\bëýñÿ;Ëîýú\n÷ð\u0011ð@Ãø÷\fð\u0001\nò:ëøÚ5Ç\u0011\fö$·Ëëý\u000bîþAÉñÿ;Ëîýú\n÷ð\u0011ð@Ãø÷\fð\u0001\nò:öÑùþü+\u0003É0Ë2úû\u0001È0Ì4\u0012ö\u0014õ·üL·\u0002òý\u0007þûõõP±\u0004üïHø\u0002Ú\u000fêì\u000eôö\r\u001eàê\u0010ÿî$Ûþ\u0006î\bì\u0016ê\b÷þ\u001dæîú\u0005ú\u0004".getBytes("ISO-8859-1"), 0, bArr, 0, 1172);
        $$a = bArr;
        $$b = WebmConstants.MkvEbmlElement.TRACK_ENTRY;
        int i6 = $11 + 27;
        $10 = i6 % 128;
        int i7 = i6 % 2;
    }
}
