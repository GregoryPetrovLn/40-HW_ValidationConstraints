package telran.validation.constraints;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
/**
 * constraint only for integer numbers that cant be less than value interface function
 */
public @interface Min {
    int value();
    String message() default "Min value violation";
}
