package telran.validation.constraints;

import telran.validation.DataTransferObject;

import java.time.LocalDate;

public class ConstraintsMethodController {
    public static String notNullAnnotationMethod(DataTransferObject dto) {
        NotNull notNullconstraint = (NotNull) dto.getAnnotation();
        String res = null;

        try {
            Object fieldData = dto.getField().get(dto.getObj());
            if (fieldData == null) {
                res = notNullconstraint.message();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static String notEmptyAnnotationMethod(DataTransferObject dto) {
        NotEmpty notEmptyConstraint = (NotEmpty) dto.getAnnotation();
        String res = null;

        try {
            Object fieldData = dto.getField().get(dto.getObj());
            if (fieldData.toString().length() == 0) {
                res = notEmptyConstraint.message();
            }
        } catch (Exception e) {
            res = (String.format("Field %s is not a string", dto.getField().getName()));
        }
        return res;
    }

    public static String minIntAnnotationMethod(DataTransferObject dto) {
        Min minConstraint = (Min) dto.getAnnotation();
        String res = null;

        try {
            int fieldData = dto.getField().getInt(dto.getObj());
            if (fieldData < minConstraint.value()) {
                res = minConstraint.message();
            }
        } catch (Exception e) {
            res = (String.format("Field %s is not a int", dto.getField().getName()));
        }
        return res;
    }

    public static String maxIntAnnotationMethod(DataTransferObject dto) {
        Max maxConstraint = (Max) dto.getAnnotation();
        String res = null;

        try {
            int fieldData = dto.getField().getInt(dto.getObj());
            if (fieldData > maxConstraint.value()) {
                res = maxConstraint.message();
            }
        } catch (Exception e) {
            res = (String.format("Field %s is not a int", dto.getField().getName()));
        }
        return res;
    }

    public static String pastAnnotationMethod(DataTransferObject dto) {
        Past pastConstraint = (Past) dto.getAnnotation();
        String res = null;

        try {
            LocalDate fieldData = (LocalDate) dto.getField().get(dto.getObj());
            if (fieldData.isAfter(LocalDate.now())) {
                res = pastConstraint.message();
            }
        } catch (Exception e) {
            res = e.getMessage();
        }
        return res;
    }

    public static String futureAnnotationMethod(DataTransferObject dto) {
        Future futureConstraint = (Future) dto.getAnnotation();
        String res = null;

        try {
            LocalDate fieldData = (LocalDate) dto.getField().get(dto.getObj());
            if (fieldData.isBefore(LocalDate.now())) {
                res = futureConstraint.message();
            }
        } catch (Exception e) {
            res = e.getMessage();
        }
        return res;
    }

    public static String emailAnnotationMethod(DataTransferObject dto) {
        Email emailConstraint = (Email) dto.getAnnotation();
        String res = null;
        String emailRegex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";

        try {
            String fieldData = dto.getField().get(dto.getObj()).toString();
            if (!fieldData.matches(emailRegex)) {
                res = emailConstraint.message();
            }
        } catch (Exception e) {
            res = (String.format("Field %s is not a string", dto.getField().getName()));
        }
        return res;
    }

}
