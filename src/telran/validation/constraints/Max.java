package telran.validation.constraints;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(FIELD)
/**
 * constraint for  integer numbers that cant be grater than a specified value
 */
public @interface Max {
    int value();
    String message() default "Max constraint violation";
}
