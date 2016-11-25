package ru.itis.model;

public class UserAuto {
    private Long userId;
    private String name;
    private Long autoId;
    private String model;
    private Long memberId;

    public UserAuto(Long userId, String name, Long autoId, String model, Long memberId) {
        this.userId = userId;
        this.name = name;
        this.autoId = autoId;
        this.model = model;
        this.memberId = memberId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAutoId() {
        return autoId;
    }

    public void setAutoId(Long autoId) {
        this.autoId = autoId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}
