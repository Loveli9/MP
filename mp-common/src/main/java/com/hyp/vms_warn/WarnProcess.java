package com.hyp.vms_warn;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;


public class WarnProcess {

    public static int countSuccessivePeriods(List<String> periods, Integer earlyWarningPeriod) {
        int count = 0;
        List<Integer> functionIdList = new ArrayList<>();
        CollectionUtils.collect(periods, new Transformer() {
            @Override
            public Object transform(Object o) {
                return Integer.valueOf(o.toString());
            }

        }, functionIdList);
        for (int i = 0; i < functionIdList.size(); i++) {
            int max = functionIdList.get(i);
            int innerCount = 0;
            for (int j = 1; j <= earlyWarningPeriod; j++) {
                if (i + j >= functionIdList.size()) {
                    break;
                }
                if (max - j == functionIdList.get(i + j)) {
                    innerCount++;
                    if (innerCount == earlyWarningPeriod - 1) {
                        count++;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return count;
    }

    @Test
    public void test1() {
        List<String> periods = new ArrayList<>();
        periods.add("4");
        periods.add("3");
        periods.add("2");
        periods.add("1");
        Integer earlyWarningPeriod = 4;
        int result = countSuccessivePeriods(periods,earlyWarningPeriod);
        System.out.println(result);
    }

}
