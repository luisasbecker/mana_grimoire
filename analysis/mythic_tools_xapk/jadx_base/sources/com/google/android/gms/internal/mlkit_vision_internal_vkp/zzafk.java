package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import androidx.credentials.provider.CredentialEntry;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okio.internal.Buffer;
import org.apache.commons.io.FilenameUtils;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzafk implements Closeable {
    private final Reader zzb;
    private long zzi;
    private int zzj;
    private int[] zzk;
    private String[] zzm;
    private int[] zzn;
    private zzaet zzc = zzaet.LEGACY_STRICT;
    private final char[] zzd = new char[1024];
    private int zze = 0;
    private int zzf = 0;
    private int zzg = 0;
    private int zzh = 0;
    int zza = 0;
    private int zzl = 1;

    static {
        zzaev.zza = new zzafj();
    }

    public zzafk(Reader reader) {
        int[] iArr = new int[32];
        this.zzk = iArr;
        iArr[0] = 6;
        this.zzm = new String[32];
        this.zzn = new int[32];
        this.zzb = (Reader) Objects.requireNonNull(reader, "in == null");
    }

    private final int zzo(boolean z) throws IOException {
        int i;
        int i2 = this.zze;
        int i3 = this.zzf;
        while (true) {
            if (i2 == i3) {
                this.zze = i2;
                if (!zzw(1)) {
                    if (z) {
                        throw new EOFException("End of input".concat(zzc()));
                    }
                    return -1;
                }
                i2 = this.zze;
                i3 = this.zzf;
            }
            char[] cArr = this.zzd;
            int i4 = i2 + 1;
            char c = cArr[i2];
            if (c == '\n') {
                this.zzg++;
                this.zzh = i4;
            } else if (c != ' ' && c != '\r' && c != '\t') {
                if (c == '/') {
                    this.zze = i4;
                    if (i4 == i3) {
                        this.zze = i2;
                        boolean zZzw = zzw(2);
                        this.zze++;
                        if (!zZzw) {
                            return 47;
                        }
                    }
                    zzt();
                    int i5 = this.zze;
                    char c2 = cArr[i5];
                    if (c2 == '*') {
                        this.zze = i5 + 1;
                        while (true) {
                            if (this.zze + 2 > this.zzf && !zzw(2)) {
                                throw zzp("Unterminated comment");
                            }
                            char[] cArr2 = this.zzd;
                            int i6 = this.zze;
                            if (cArr2[i6] != '\n') {
                                while (i < 2) {
                                    i = this.zzd[this.zze + i] == "*/".charAt(i) ? i + 1 : 0;
                                }
                                i2 = this.zze + 2;
                                i3 = this.zzf;
                                break;
                            }
                            this.zzg++;
                            this.zzh = i6 + 1;
                            this.zze++;
                        }
                    } else {
                        if (c2 != '/') {
                            return 47;
                        }
                        this.zze = i5 + 1;
                        zzv();
                        i2 = this.zze;
                        i3 = this.zzf;
                    }
                } else {
                    if (c != '#') {
                        this.zze = i4;
                        return c;
                    }
                    this.zze = i4;
                    zzt();
                    zzv();
                    i2 = this.zze;
                    i3 = this.zzf;
                }
            }
            i2 = i4;
        }
    }

    private final zzafn zzp(String str) throws zzafn {
        throw new zzafn(str + zzc() + "\nSee https://github.com/google/gson/blob/main/Troubleshooting.md#malformed-json");
    }

    private final IllegalStateException zzq(String str) throws IOException {
        int iZzn = zzn();
        String strZza = zzafl.zza(zzn());
        String strZzc = zzc();
        StringBuilder sb = new StringBuilder("Expected ");
        sb.append(str);
        sb.append(" but was ");
        sb.append(strZza);
        sb.append(strZzc);
        sb.append("\nSee ");
        sb.append("https://github.com/google/gson/blob/main/Troubleshooting.md#".concat(iZzn == 9 ? "adapter-not-null-safe" : "unexpected-json-structure"));
        return new IllegalStateException(sb.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0144, code lost:
    
        r3 = r1 - r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0146, code lost:
    
        if (r0 != null) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0148, code lost:
    
        r0 = new java.lang.StringBuilder(java.lang.Math.max(r3 + r3, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0154, code lost:
    
        r0.append(r4, r2, r3);
        r10.zze = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00f1, code lost:
    
        throw zzp("Malformed Unicode escape \\u".concat(new java.lang.String(r6, r10.zze, 4)));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String zzr(char c) throws IOException {
        int i;
        StringBuilder sb = null;
        loop0: do {
            int i2 = this.zze;
            int i3 = this.zzf;
            int i4 = i2;
            while (true) {
                char[] cArr = this.zzd;
                if (i2 >= i3) {
                    break;
                }
                int i5 = i2 + 1;
                char c2 = cArr[i2];
                if (this.zzc == zzaet.STRICT && c2 < ' ') {
                    throw zzp("Unescaped control characters (\\u0000-\\u001F) are not allowed in strict mode");
                }
                if (c2 == c) {
                    int i6 = (i5 - i4) - 1;
                    this.zze = i5;
                    if (sb == null) {
                        return new String(cArr, i4, i6);
                    }
                    sb.append(cArr, i4, i6);
                    return sb.toString();
                }
                char c3 = '\n';
                if (c2 == '\\') {
                    int i7 = i5 - i4;
                    int i8 = i7 - 1;
                    this.zze = i5;
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i7 + i7, 16));
                    }
                    sb.append(cArr, i4, i8);
                    if (this.zze == this.zzf && !zzw(1)) {
                        throw zzp("Unterminated escape sequence");
                    }
                    char[] cArr2 = this.zzd;
                    int i9 = this.zze;
                    int i10 = i9 + 1;
                    this.zze = i10;
                    char c4 = cArr2[i9];
                    if (c4 != '\n') {
                        if (c4 == '\"') {
                            c3 = c4;
                            sb.append(c3);
                            i4 = this.zze;
                            i3 = this.zzf;
                            i2 = i4;
                        } else {
                            if (c4 != '\'') {
                                if (c4 != '/' && c4 != '\\') {
                                    if (c4 == 'b') {
                                        c3 = '\b';
                                    } else if (c4 == 'f') {
                                        c3 = '\f';
                                    } else if (c4 != 'n') {
                                        if (c4 == 'r') {
                                            c3 = '\r';
                                        } else if (c4 == 't') {
                                            c3 = '\t';
                                        } else {
                                            if (c4 != 'u') {
                                                throw zzp("Invalid escape sequence");
                                            }
                                            if (i9 + 5 > this.zzf && !zzw(4)) {
                                                throw zzp("Unterminated escape sequence");
                                            }
                                            int i11 = this.zze;
                                            int i12 = i11 + 4;
                                            int i13 = 0;
                                            while (i11 < i12) {
                                                char[] cArr3 = this.zzd;
                                                int i14 = i13 << 4;
                                                char c5 = cArr3[i11];
                                                if (c5 >= '0' && c5 <= '9') {
                                                    i = c5 - '0';
                                                } else if (c5 >= 'a' && c5 <= 'f') {
                                                    i = c5 - 'W';
                                                } else {
                                                    if (c5 < 'A' || c5 > 'F') {
                                                        break loop0;
                                                    }
                                                    i = c5 - '7';
                                                }
                                                i13 = i14 + i;
                                                i11++;
                                            }
                                            this.zze += 4;
                                            c3 = (char) i13;
                                        }
                                    }
                                }
                                sb.append(c3);
                                i4 = this.zze;
                                i3 = this.zzf;
                                i2 = i4;
                            }
                            c3 = c4;
                            sb.append(c3);
                            i4 = this.zze;
                            i3 = this.zzf;
                            i2 = i4;
                        }
                    } else {
                        if (this.zzc == zzaet.STRICT) {
                            throw zzp("Cannot escape a newline character in strict mode");
                        }
                        this.zzg++;
                        this.zzh = i10;
                    }
                    if (this.zzc == zzaet.STRICT) {
                        throw zzp("Invalid escaped character \"'\" in strict mode");
                    }
                    c3 = c4;
                    sb.append(c3);
                    i4 = this.zze;
                    i3 = this.zzf;
                    i2 = i4;
                } else {
                    if (c2 == '\n') {
                        this.zzg++;
                        this.zzh = i5;
                    }
                    i2 = i5;
                }
            }
        } while (zzw(1));
        throw zzp("Unterminated string");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0048, code lost:
    
        zzt();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0042. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String zzs() throws IOException {
        String string;
        int i = 0;
        StringBuilder sb = null;
        do {
            int i2 = 0;
            while (true) {
                int i3 = this.zze + i2;
                if (i3 < this.zzf) {
                    char c = this.zzd[i3];
                    if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                        if (c != '#') {
                            if (c != ',') {
                                if (c != '/' && c != '=') {
                                    if (c != '{' && c != '}' && c != ':') {
                                        if (c != ';') {
                                            switch (c) {
                                                case Imgproc.COLOR_YUV2BGR_NV12 /* 91 */:
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i2++;
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (i2 >= 1024) {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i2, 16));
                    }
                    sb.append(this.zzd, this.zze, i2);
                    this.zze += i2;
                } else if (zzw(i2 + 1)) {
                }
            }
            i = i2;
            char[] cArr = this.zzd;
            if (sb != null) {
                string = new String(cArr, this.zze, i);
            } else {
                sb.append(cArr, this.zze, i);
                string = sb.toString();
            }
            this.zze += i;
            return string;
        } while (zzw(1));
        char[] cArr2 = this.zzd;
        if (sb != null) {
        }
        this.zze += i;
        return string;
    }

    private final void zzt() throws zzafn {
        if (this.zzc != zzaet.LENIENT) {
            throw zzp("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
        }
    }

    private final void zzu(int i) throws zzafn {
        int i2 = this.zzl;
        if (i2 - 1 >= 1280) {
            throw new zzafn("Nesting limit 1280 reached" + zzc());
        }
        int[] iArr = this.zzk;
        if (i2 == iArr.length) {
            int i3 = i2 + i2;
            this.zzk = Arrays.copyOf(iArr, i3);
            this.zzn = Arrays.copyOf(this.zzn, i3);
            this.zzm = (String[]) Arrays.copyOf(this.zzm, i3);
        }
        int[] iArr2 = this.zzk;
        int i4 = this.zzl;
        this.zzl = i4 + 1;
        iArr2[i4] = i;
    }

    private final void zzv() throws IOException {
        char c;
        do {
            if (this.zze >= this.zzf && !zzw(1)) {
                return;
            }
            char[] cArr = this.zzd;
            int i = this.zze;
            int i2 = i + 1;
            this.zze = i2;
            c = cArr[i];
            if (c == '\n') {
                this.zzg++;
                this.zzh = i2;
                return;
            }
        } while (c != '\r');
    }

    private final boolean zzw(int i) throws IOException {
        int i2;
        int i3 = this.zzh;
        int i4 = this.zze;
        this.zzh = i3 - i4;
        char[] cArr = this.zzd;
        int i5 = this.zzf;
        if (i5 != i4) {
            int i6 = i5 - i4;
            this.zzf = i6;
            System.arraycopy(cArr, i4, cArr, 0, i6);
        } else {
            this.zzf = 0;
        }
        this.zze = 0;
        do {
            Reader reader = this.zzb;
            int i7 = this.zzf;
            int i8 = reader.read(cArr, i7, 1024 - i7);
            if (i8 == -1) {
                return false;
            }
            i2 = this.zzf + i8;
            this.zzf = i2;
            if (this.zzg == 0 && this.zzh == 0 && i2 > 0 && cArr[0] == 65279) {
                this.zze++;
                this.zzh = 1;
                i++;
            }
        } while (i2 < i);
        return true;
    }

    private final boolean zzx(char c) throws IOException {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (c != '/' && c != '=') {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case Imgproc.COLOR_YUV2BGR_NV12 /* 91 */:
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        zzt();
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zza = 0;
        this.zzk[0] = 8;
        this.zzl = 1;
        this.zzb.close();
    }

    public final String toString() {
        return String.valueOf(getClass().getSimpleName()).concat(zzc());
    }

    /* JADX WARN: Code restructure failed: missing block: B:161:0x0228, code lost:
    
        if (zzx(r1) == false) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0240, code lost:
    
        if (r3 == 0) goto L176;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0294 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02ae A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final int zza() throws IOException {
        int i;
        int i2;
        int iZzo;
        int iZzo2;
        int i3;
        int iZzo3;
        int i4;
        String str;
        String str2;
        int i5;
        char c;
        char c2;
        long j;
        int i6;
        int i7;
        int i8;
        int i9;
        int[] iArr = this.zzk;
        int i10 = this.zzl - 1;
        int i11 = iArr[i10];
        int i12 = 3;
        int i13 = 1;
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 == 3) {
                    i = 2;
                    i2 = 4;
                } else if (i11 == 5) {
                    i2 = 4;
                    i = 2;
                } else if (i11 == 4) {
                    iArr[i10] = 5;
                    int iZzo4 = zzo(true);
                    if (iZzo4 != 58) {
                        if (iZzo4 != 61) {
                            throw zzp("Expected ':'");
                        }
                        zzt();
                        if (this.zze < this.zzf || zzw(1)) {
                            char[] cArr = this.zzd;
                            int i14 = this.zze;
                            if (cArr[i14] == '>') {
                                this.zze = i14 + 1;
                            }
                        }
                    }
                } else if (i11 == 6) {
                    if (this.zzc == zzaet.LENIENT) {
                        zzo(true);
                        int i15 = this.zze;
                        this.zze = i15 - 1;
                        if (i15 + 4 <= this.zzf || zzw(5)) {
                            int i16 = this.zze;
                            char[] cArr2 = this.zzd;
                            if (cArr2[i16] == ')' && cArr2[i16 + 1] == ']' && cArr2[i16 + 2] == '}' && cArr2[i16 + 3] == '\'' && cArr2[i16 + 4] == '\n') {
                                this.zze = i16 + 5;
                            }
                        }
                    }
                    this.zzk[this.zzl - 1] = 7;
                } else if (i11 == 7) {
                    i3 = 0;
                    if (zzo(false) == -1) {
                        i12 = 17;
                        this.zza = i12;
                        return i12;
                    }
                    zzt();
                    this.zze--;
                } else {
                    i3 = 0;
                    if (i11 == 8) {
                        throw new IllegalStateException("JsonReader is closed");
                    }
                }
                iArr[i10] = i2;
                if (i11 != 5 || (iZzo2 = zzo(true)) == 44) {
                    iZzo = zzo(true);
                    if (iZzo != 34) {
                        i12 = 13;
                    } else {
                        if (iZzo == 39) {
                            zzt();
                            this.zza = 12;
                            return 12;
                        }
                        if (iZzo != 125) {
                            zzt();
                            this.zze--;
                            if (!zzx((char) iZzo)) {
                                throw zzp("Expected name");
                            }
                            i12 = 14;
                        } else {
                            if (i11 == 5) {
                                throw zzp("Expected name");
                            }
                            i12 = i;
                        }
                    }
                } else if (iZzo2 != 59) {
                    if (iZzo2 != 125) {
                        throw zzp("Unterminated object");
                    }
                    i12 = i;
                } else {
                    zzt();
                    iZzo = zzo(true);
                    if (iZzo != 34) {
                    }
                }
                this.zza = i12;
                return i12;
            }
            int iZzo5 = zzo(true);
            if (iZzo5 != 44) {
                if (iZzo5 != 59) {
                    if (iZzo5 != 93) {
                        throw zzp("Unterminated array");
                    }
                    i12 = 4;
                    this.zza = i12;
                    return i12;
                }
                zzt();
            }
            iZzo3 = zzo(true);
            if (iZzo3 == 34) {
                if (iZzo3 == 39) {
                    zzt();
                    this.zza = 8;
                    return 8;
                }
                if (iZzo3 == 44 || iZzo3 == 59) {
                    i4 = 1;
                } else if (iZzo3 != 91) {
                    if (iZzo3 == 93) {
                        i4 = 1;
                        if (i11 == 1) {
                            i12 = 4;
                        }
                    } else if (iZzo3 != 123) {
                        int i17 = this.zze - 1;
                        this.zze = i17;
                        char c3 = this.zzd[i17];
                        if (c3 == 't' || c3 == 'T') {
                            str = "TRUE";
                            str2 = "true";
                            i5 = 5;
                        } else if (c3 == 'f' || c3 == 'F') {
                            str = "FALSE";
                            str2 = CredentialEntry.FALSE_STRING;
                            i5 = 6;
                        } else {
                            if (c3 == 'n' || c3 == 'N') {
                                str = "NULL";
                                str2 = AbstractJsonLexerKt.NULL;
                                i5 = 7;
                            }
                            i5 = i3;
                            if (i5 == 0) {
                                return i5;
                            }
                            char[] cArr3 = this.zzd;
                            int i18 = this.zze;
                            int i19 = this.zzf;
                            int i20 = i3;
                            int i21 = i20;
                            int i22 = i21;
                            boolean z = true;
                            long j2 = 0;
                            while (true) {
                                if (i18 + i20 == i19) {
                                    if (i20 == 1024) {
                                        break;
                                    }
                                    if (!zzw(i20 + 1)) {
                                        j = 0;
                                        break;
                                    }
                                    int i23 = this.zze;
                                    i19 = this.zzf;
                                    i18 = i23;
                                    c2 = cArr3[i18 + i20];
                                    j = 0;
                                    if (c2 != '+') {
                                    }
                                } else {
                                    c2 = cArr3[i18 + i20];
                                    j = 0;
                                    if (c2 != '+') {
                                        i6 = i18;
                                        i7 = 6;
                                        if (i21 != 5) {
                                            break;
                                        }
                                        i21 = i7;
                                        i20++;
                                        i18 = i6;
                                        i13 = 1;
                                    } else if (c2 == 'E' || c2 == 'e') {
                                        i6 = i18;
                                        if (i21 != 2 && i21 != 4) {
                                            break;
                                        }
                                        i21 = 5;
                                        i20++;
                                        i18 = i6;
                                        i13 = 1;
                                    } else if (c2 == '-') {
                                        i6 = i18;
                                        i7 = 6;
                                        if (i21 == 0) {
                                            i21 = 1;
                                            i22 = 1;
                                            i20++;
                                            i18 = i6;
                                            i13 = 1;
                                        } else {
                                            if (i21 != 5) {
                                                break;
                                            }
                                            i21 = i7;
                                            i20++;
                                            i18 = i6;
                                            i13 = 1;
                                        }
                                    } else if (c2 == '.') {
                                        i6 = i18;
                                        if (i21 != 2) {
                                            break;
                                        }
                                        i21 = 3;
                                        i20++;
                                        i18 = i6;
                                        i13 = 1;
                                    } else {
                                        if (c2 < '0' || c2 > '9') {
                                            break;
                                        }
                                        if (i21 == i13 || i21 == 0) {
                                            i6 = i18;
                                            j2 = -(c2 - '0');
                                            i21 = 2;
                                        } else if (i21 != 2) {
                                            i6 = i18;
                                            if (i21 == 3) {
                                                i21 = 4;
                                            } else if (i21 == 5 || i21 == 6) {
                                                i21 = 7;
                                            }
                                        } else {
                                            if (j2 == 0) {
                                                break;
                                            }
                                            i6 = i18;
                                            long j3 = (10 * j2) - ((long) (c2 - '0'));
                                            z &= j2 > Buffer.OVERFLOW_ZONE || (j2 == Buffer.OVERFLOW_ZONE && j3 < j2);
                                            j2 = j3;
                                        }
                                        i20++;
                                        i18 = i6;
                                        i13 = 1;
                                    }
                                }
                                if (i8 == 0) {
                                    return i8;
                                }
                                if (!zzx(this.zzd[this.zze])) {
                                    throw zzp("Expected value");
                                }
                                zzt();
                                this.zza = 10;
                                return 10;
                            }
                            int i24 = 2;
                            if (i21 == 2) {
                                if (z) {
                                    if (j2 != Long.MIN_VALUE) {
                                        i9 = i22;
                                    } else if (i22 != 0) {
                                        i9 = 1;
                                    }
                                    if (j2 != j) {
                                        if (i9 == 0) {
                                        }
                                        this.zzi = j2;
                                        this.zze += i20;
                                        this.zza = 15;
                                        i8 = 15;
                                    }
                                    j2 = -j2;
                                    this.zzi = j2;
                                    this.zze += i20;
                                    this.zza = 15;
                                    i8 = 15;
                                }
                                i24 = 2;
                                i21 = 2;
                                if (i21 != i24) {
                                }
                                this.zzj = i20;
                                i8 = 16;
                                this.zza = 16;
                            } else if (i21 != i24 || i21 == 4 || i21 == 7) {
                                this.zzj = i20;
                                i8 = 16;
                                this.zza = 16;
                            } else {
                                i8 = 0;
                            }
                            if (i8 == 0) {
                            }
                        }
                        zzaet zzaetVar = this.zzc;
                        zzaet zzaetVar2 = zzaet.STRICT;
                        int i25 = i3;
                        while (true) {
                            int length = str2.length();
                            int i26 = this.zze;
                            if (i25 < length) {
                                if ((i26 + i25 >= this.zzf && !zzw(i25 + 1)) || ((c = this.zzd[this.zze + i25]) != str2.charAt(i25) && (zzaetVar == zzaetVar2 || c != str.charAt(i25)))) {
                                    break;
                                }
                                i25++;
                            } else {
                                if ((i26 + length < this.zzf || zzw(length + 1)) && zzx(this.zzd[this.zze + length])) {
                                    break;
                                }
                                this.zze += length;
                                this.zza = i5;
                            }
                        }
                        i5 = i3;
                        if (i5 == 0) {
                        }
                    } else {
                        i12 = 1;
                    }
                }
                if (i11 != i4 && i11 != 2) {
                    throw zzp("Unexpected value");
                }
                zzt();
                this.zze--;
                this.zza = 7;
                return 7;
            }
            i12 = 9;
            this.zza = i12;
            return i12;
        }
        iArr[i10] = 2;
        i3 = 0;
        iZzo3 = zzo(true);
        if (iZzo3 == 34) {
        }
        this.zza = i12;
        return i12;
    }

    public final zzaet zzb() {
        return this.zzc;
    }

    final String zzc() {
        int i = this.zzg + 1;
        int i2 = this.zze - this.zzh;
        StringBuilder sb = new StringBuilder("$");
        for (int i3 = 0; i3 < this.zzl; i3++) {
            int i4 = this.zzk[i3];
            switch (i4) {
                case 1:
                case 2:
                    int i5 = this.zzn[i3];
                    sb.append(AbstractJsonLexerKt.BEGIN_LIST);
                    sb.append(i5);
                    sb.append(AbstractJsonLexerKt.END_LIST);
                    break;
                case 3:
                case 4:
                case 5:
                    sb.append(FilenameUtils.EXTENSION_SEPARATOR);
                    String str = this.zzm[i3];
                    if (str != null) {
                        sb.append(str);
                    }
                    break;
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    throw new AssertionError("Unknown scope value: " + i4);
            }
        }
        return " at line " + i + " column " + (i2 + 1) + " path " + sb.toString();
    }

    public final String zzd() throws IOException {
        String strZzr;
        int iZza = this.zza;
        if (iZza == 0) {
            iZza = zza();
        }
        if (iZza == 14) {
            strZzr = zzs();
        } else if (iZza == 12) {
            strZzr = zzr('\'');
        } else {
            if (iZza != 13) {
                throw zzq("a name");
            }
            strZzr = zzr('\"');
        }
        this.zza = 0;
        this.zzm[this.zzl - 1] = strZzr;
        return strZzr;
    }

    public final String zze() throws IOException {
        String string;
        int iZza = this.zza;
        if (iZza == 0) {
            iZza = zza();
        }
        if (iZza == 10) {
            string = zzs();
        } else if (iZza == 8) {
            string = zzr('\'');
        } else if (iZza == 9) {
            string = zzr('\"');
        } else if (iZza == 11) {
            string = null;
        } else if (iZza == 15) {
            string = Long.toString(this.zzi);
        } else {
            if (iZza != 16) {
                throw zzq("a string");
            }
            String str = new String(this.zzd, this.zze, this.zzj);
            this.zze += this.zzj;
            string = str;
        }
        this.zza = 0;
        int[] iArr = this.zzn;
        int i = this.zzl - 1;
        iArr[i] = iArr[i] + 1;
        return string;
    }

    public final void zzf() throws IOException {
        int iZza = this.zza;
        if (iZza == 0) {
            iZza = zza();
        }
        if (iZza != 3) {
            throw zzq("BEGIN_ARRAY");
        }
        zzu(1);
        this.zzn[this.zzl - 1] = 0;
        this.zza = 0;
    }

    public final void zzg() throws IOException {
        int iZza = this.zza;
        if (iZza == 0) {
            iZza = zza();
        }
        if (iZza != 1) {
            throw zzq("BEGIN_OBJECT");
        }
        zzu(3);
        this.zza = 0;
    }

    public final void zzh() throws IOException {
        int iZza = this.zza;
        if (iZza == 0) {
            iZza = zza();
        }
        if (iZza != 4) {
            throw zzq("END_ARRAY");
        }
        int i = this.zzl;
        this.zzl = i - 1;
        int[] iArr = this.zzn;
        int i2 = i - 2;
        iArr[i2] = iArr[i2] + 1;
        this.zza = 0;
    }

    public final void zzi() throws IOException {
        int iZza = this.zza;
        if (iZza == 0) {
            iZza = zza();
        }
        if (iZza != 2) {
            throw zzq("END_OBJECT");
        }
        int i = this.zzl;
        int i2 = i - 1;
        this.zzl = i2;
        this.zzm[i2] = null;
        int[] iArr = this.zzn;
        int i3 = i - 2;
        iArr[i3] = iArr[i3] + 1;
        this.zza = 0;
    }

    public final void zzj() throws IOException {
        int iZza = this.zza;
        if (iZza == 0) {
            iZza = zza();
        }
        if (iZza != 7) {
            throw zzq(AbstractJsonLexerKt.NULL);
        }
        this.zza = 0;
        int[] iArr = this.zzn;
        int i = this.zzl - 1;
        iArr[i] = iArr[i] + 1;
    }

    public final void zzk(zzaet zzaetVar) {
        Objects.requireNonNull(zzaetVar);
        this.zzc = zzaetVar;
    }

    public final boolean zzl() throws IOException {
        int iZza = this.zza;
        if (iZza == 0) {
            iZza = zza();
        }
        return (iZza == 2 || iZza == 4 || iZza == 17) ? false : true;
    }

    public final boolean zzm() throws IOException {
        int iZza = this.zza;
        if (iZza == 0) {
            iZza = zza();
        }
        if (iZza == 5) {
            this.zza = 0;
            int[] iArr = this.zzn;
            int i = this.zzl - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (iZza != 6) {
            throw zzq("a boolean");
        }
        this.zza = 0;
        int[] iArr2 = this.zzn;
        int i2 = this.zzl - 1;
        iArr2[i2] = iArr2[i2] + 1;
        return false;
    }

    public final int zzn() throws IOException {
        int iZza = this.zza;
        if (iZza == 0) {
            iZza = zza();
        }
        switch (iZza) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
                return 5;
            case 15:
            case 16:
                return 7;
            default:
                return 10;
        }
    }
}
