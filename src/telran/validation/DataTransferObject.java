package telran.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class DataTransferObject {
    private Object obj;
    private Annotation annotation;
    private Field field;

    public DataTransferObject(Object obj, Annotation annotation, Field field) {
        super();
        this.obj = obj;
        this.annotation = annotation;
        this.field = field;
    }

    public Object getObj() {
        return obj;
    }

    public Annotation getAnnotation() {
        return annotation;
    }

    public Field getField() {
        return field;
    }
}
