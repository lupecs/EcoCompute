package com.ecocompute.compression;

import com.ecocompute.model.CompressionLevel;
import com.ecocompute.model.CompressionRecommendation;
import com.ecocompute.model.WorkloadProfile;

public class CompressionAnalyzer {

    public CompressionLevel estimateCompressionLevel(
            WorkloadProfile profile
    ) {
        return switch (profile.getFileType()) {
            case DOCUMENT -> CompressionLevel.MEDIUM;

            case DATASET -> CompressionLevel.HIGH;

            case CODE -> CompressionLevel.MEDIUM;

            case IMAGE -> CompressionLevel.LOW;

            case VIDEO -> CompressionLevel.LOW;

            case AUDIO -> CompressionLevel.LOW;

            case ARCHIVE -> CompressionLevel.LOW;

            default -> CompressionLevel.UNKOWN;

        };
    }

    public CompressionRecommendation recommend(
            CompressionLevel level
    ) {
        return switch (level) {

            case HIGH, MEDIUM -> CompressionRecommendation.COMPRESS;

            case LOW -> CompressionRecommendation.SKIP;

            default -> CompressionRecommendation.UNKNOWN;
        };
    }
}
