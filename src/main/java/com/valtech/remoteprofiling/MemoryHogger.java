package com.valtech.remoteprofiling;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.DecimalFormat;
import java.util.ArrayList;

@EnableAsync
@Configuration
public class MemoryHogger {

    private static int BATCH_ALLOC_SIZE = 100_000;

    private ArrayList<SmallEntry> memoryHog = new ArrayList<>();
    private int roundsCompleted = 0;
    private DecimalFormat df = new DecimalFormat("###,###,###");

    @Async
    @Scheduled(fixedRate = 10000)
    public void hogMoreMemoryAsync() throws InterruptedException {
        System.out.println("Hogging more memory" + roundsCompleted);
        for (int i = 0; i < BATCH_ALLOC_SIZE; i++) {
            memoryHog.add(new SmallEntry("entry:" + roundsCompleted + ":" + i, (long) (i + roundsCompleted * i)));
        }
        System.out.println("Hogging more memory. Round " + roundsCompleted + " done. Total objects on heap: "+df.format(memoryHog.size()));
        roundsCompleted++;
    }
}
