package javax.annotation;

import androidx.camera.video.AudioStats;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

/* JADX INFO: loaded from: classes6.dex */
@TypeQualifier(applicableTo = Number.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Nonnegative {

    public static class Checker implements TypeQualifierValidator<Nonnegative> {
        @Override // javax.annotation.meta.TypeQualifierValidator
        public When forConstantValue(Nonnegative nonnegative, Object obj) {
            if (!(obj instanceof Number)) {
                return When.NEVER;
            }
            Number number = (Number) obj;
            return (!(number instanceof Long) ? !(!(number instanceof Double) ? !(!(number instanceof Float) ? number.intValue() < 0 : number.floatValue() < 0.0f) : number.doubleValue() < AudioStats.AUDIO_AMPLITUDE_NONE) : number.longValue() < 0) ? When.ALWAYS : When.NEVER;
        }
    }

    When when() default When.ALWAYS;
}
