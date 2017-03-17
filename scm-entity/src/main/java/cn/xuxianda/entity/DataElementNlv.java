package cn.xuxianda.entity;

public class DataElementNlv {
    private Integer dataElementNlvId;

    private Long dataElementId;

    private String language;

    private String key;

    private String text;

    public Integer getDataElementNlvId() {
        return dataElementNlvId;
    }

    public void setDataElementNlvId(Integer dataElementNlvId) {
        this.dataElementNlvId = dataElementNlvId;
    }

    public Long getDataElementId() {
        return dataElementId;
    }

    public void setDataElementId(Long dataElementId) {
        this.dataElementId = dataElementId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}