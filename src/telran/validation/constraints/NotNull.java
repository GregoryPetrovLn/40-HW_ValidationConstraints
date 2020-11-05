package telran.validation.constraints;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(FIELD)
/**
 * constraint for any object that cant be null
 */
public @interface NotNull {
String message() default "Field can't be null";

}
