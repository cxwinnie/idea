package cn.xuxianda.entity;

public class DataElement {
    private Long dataElementId;

    private String field;

    private String value;

    public Long getDataElementId() {
        return dataElementId;
    }

    public void setDataElementId(Long dataElementId) {
        this.dataElementId = dataElementId;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}