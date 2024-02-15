package ict.example.annotation.domain;
public class FieldDto {
    private final String fieldStringName;
    private final String fieldName;
    private FieldDto(String fieldStringName, String fieldName) {
        this.fieldStringName = fieldStringName;
        this.fieldName = fieldName;
    }
    public static FieldDto of(String fieldStringName, String fieldName) {
        return new FieldDto(fieldStringName, fieldName);
    }
    public String getFieldStringName() {
        return fieldStringName;
    }
    public String getFieldName() {
        return fieldName;
    }
}