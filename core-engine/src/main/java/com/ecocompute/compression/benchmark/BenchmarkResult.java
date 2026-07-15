package com.ecocompute.compression.benchmark;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class BenchmarkResult {

    private String algorithm;

    private long originalSize;

    private long compressedSize;

    private double compressRatio;

    private long compressionTimeMillis;
}
