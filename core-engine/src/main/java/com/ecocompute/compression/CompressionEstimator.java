package com.ecocompute.compression;

import com.ecocompute.model.CompressionMetrics;
import com.ecocompute.model.WorkloadProfile;

/**
 * Compression Ratio: original size / compressed size
 * EX: 500 MB / 80 MB = 6.25 (compressed file is 6.25 times smaller)
 * Savings Percentage: (original - compressed) / original * 100
 * (500 MB - 80 MB) / 500 MB * 100 = 84% (84% of storage usage removed)
 */

public class CompressionEstimator {

    public CompressionMetrics estimate(
            WorkloadProfile profile
    ) {
        double estimatedSavings =
                switch (profile.getFileType()) {
                    case DATASET -> 0.80;
                    case DOCUMENT -> 0.50;
                    case CODE -> 0.60;
                    case IMAGE -> 0.10;
                    case VIDEO -> 0.05;
                    case AUDIO -> 0.10;
                    case ARCHIVE -> 0.02;
                    default -> 0.0;
                };

        long original = profile.getFileSizeBytes();

        long compressed = (long)(original * (1 - estimatedSavings));

        double ratio = original == 0 ? 0 : (double) original / compressed;

        return CompressionMetrics.builder()
                .originalSizeBytes(original)
                .estimatedCompressedSizeBytes(compressed)
                .compressionRatio(ratio)
                .savingsPercentage(
                        estimatedSavings * 100
                )
                .build();
    }
}
