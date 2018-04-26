package EnumSave;

/**
 * Created by zhuhe on 2018/4/26.
 */
/**
 * 奖励失败原因
 */
public enum ActivityRejectReason implements HasDefaultInterface<ActivityRejectReason> {
    UNKNOWN_REASON(-1, 0, "未知原因"),
    IN_RISK(1, 1, "风控作废"),
    EXAMINE_REJECT(2, 2, "审核驳回");

    private Integer value;
    private Integer bitValue;
    private String name;

    ActivityRejectReason(Integer value, Integer bitValue, String name) {
        this.value = value;
        this.bitValue = bitValue;
        this.name = name;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    public Integer getBitValue() {
        return bitValue;
    }

    public void setBitValue(Integer bitValue) {
        this.bitValue = bitValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public ActivityRejectReason getDefault() {
        return UNKNOWN_REASON;
    }
}