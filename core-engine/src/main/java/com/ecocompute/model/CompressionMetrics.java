package com.ecocompute.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CompressionMetrics {

    private long originalSizeBytes;

    private long estimatedCompressedSizeBytes;

    private double compressionRatio;

    private double savingsPercentage;
}
