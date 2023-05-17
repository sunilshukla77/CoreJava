package com.ps.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class CallableDemo implements Callable {
    /**
     * @return
     * @throws Exception
     */
    @Override
    public List<Integer> call() throws Exception {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        return list;
    }
}
