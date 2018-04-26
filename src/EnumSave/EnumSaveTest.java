package EnumSave;

import java.util.EnumSet;
import java.util.Iterator;

/**
 * Created by zhuhe on 2018/4/26.
 */
public class EnumSaveTest {
    public static void main(String[] args) {
        EnumSet<ActivityRejectReason> rejectReasonEnumSet = EnumSet.noneOf(ActivityRejectReason.class);
        rejectReasonEnumSet.add(ActivityRejectReason.IN_RISK);
        rejectReasonEnumSet.add(ActivityRejectReason.EXAMINE_REJECT);

        int encodeVal = encodeAsIntSet(rejectReasonEnumSet);
        System.out.println("encode val:" + encodeVal);

        EnumSet<ActivityRejectReason> decodeSet = decodeInAsEnumSet(encodeVal);
        for (ActivityRejectReason reason : decodeSet
                ) {
            System.out.println(reason.getName() + ":" + reason.getBitValue());
        }
    }

    /**
     * 按位存储枚举值
     * @param enumSet
     * @return
     */
    private static int encodeAsIntSet(EnumSet<ActivityRejectReason> enumSet) {
        Iterator<ActivityRejectReason> it = enumSet.iterator();
        int value = 0;
        while (it.hasNext()) {
            ActivityRejectReason ActivityRejectReason = it.next();
            value |= ActivityRejectReason.getBitValue();
        }
        return value;
    }

    /**
     * 解析枚举值
     * @param encodedValue
     * @return
     */
    private static EnumSet<ActivityRejectReason> decodeInAsEnumSet(int encodedValue) {
        EnumSet<ActivityRejectReason> set = EnumSet.noneOf(ActivityRejectReason.class);
        for (ActivityRejectReason reason : ActivityRejectReason.values()) {
            if ((reason.getBitValue() & encodedValue) > 0) {
                set.add(reason);
            }
        }
        return set;
    }
}
