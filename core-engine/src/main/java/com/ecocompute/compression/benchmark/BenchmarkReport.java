package com.ecocompute.compression.benchmark;

import java.util.ArrayList;
import java.util.List;

/**
 * This class only responsible for collecting results
 * Single Responsibility Principle
 */

public class BenchmarkReport {

    private List<BenchmarkResult> results = new ArrayList<>();

    public void addResult(BenchmarkResult result) {
        results.add(result);
    }

    public BenchmarkResult getBestCompressionRatio() {

        return results.stream()
                .max((a, b) -> Double.compare(
                        a.getCompressRatio(),
                        b.getCompressRatio()
                ))
                .orElse(null);
    }

    public BenchmarkResult getFastestCompression() {

        return results.stream()
                .min((a, b) -> Long.compare(
                        a.getCompressionTimeMillis(),
                        b.getCompressionTimeMillis()
                )).orElse(null);
    }
}
