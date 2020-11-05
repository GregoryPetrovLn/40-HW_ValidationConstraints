package telran.validation;

import telran.validation.constraints.*;

import java.lang.annotation.Annotation;
import java.util.*;
import java.lang.reflect.*;
import java.util.function.Function;

public class Validator {
    public static DataTransferObject dto;
    public static final Map<Class, Function<DataTransferObject, String>> storage = new HashMap<>();

    static {
        storage.put(NotNull.class, ConstraintsMethodController::notNullAnnotationMethod);
        storage.put(NotEmpty.class, ConstraintsMethodController::notEmptyAnnotationMethod);
        storage.put(Min.class, ConstraintsMethodController::minIntAnnotationMethod);
        storage.put(Max.class, ConstraintsMethodController::maxIntAnnotationMethod);
        storage.put(Email.class, ConstraintsMethodController::emailAnnotationMethod);
        storage.put(Past.class, ConstraintsMethodController::pastAnnotationMethod);
        storage.put(Future.class, ConstraintsMethodController::futureAnnotationMethod);
    }


    /**
     * @param obj
     * @return
     */
    public static List<String> validate(Object obj) {
        List<String> res = new ArrayList<>();
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            for (Annotation annotation : field.getAnnotations()) {
                dto = new DataTransferObject(obj, annotation, field);
                res.add(storage.get(annotation.annotationType()).apply(dto));
            }
        }

        return res;
    }

}


















