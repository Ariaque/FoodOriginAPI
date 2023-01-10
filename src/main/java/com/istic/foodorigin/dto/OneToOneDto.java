package com.istic.foodorigin.dto;

public class OneToOneDto {
    private Long mainId;
    private Long foreignId;

    public OneToOneDto() {
    }

    public OneToOneDto(Long mainId, Long foreignId) {
        this.mainId = mainId;
        this.foreignId = foreignId;
    }

    public Long getMainId() {
        return mainId;
    }

    public void setMainId(Long mainId) {
        this.mainId = mainId;
    }

    public Long getForeignId() {
        return foreignId;
    }

    public void setForeignId(Long foreignId) {
        this.foreignId = foreignId;
    }
}
