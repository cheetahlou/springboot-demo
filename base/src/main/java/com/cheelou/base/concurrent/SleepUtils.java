package com.cheelou.base.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author louzf
 * @decription
 * @createTime 2019/11/22 13:43
 */

public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }
}
