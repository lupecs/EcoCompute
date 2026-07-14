package com.ecocompute.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class WorkloadProfile {

    private String filename;
    private String extension;

    private long fileSizeBytes;

    private FileType fileType;

    private CompressionLevel compressionLevel;

    private CompressionRecommendation compressionRecommendation;

    private CpuRequirement cpuRequirement;

    private MemoryRequirement memoryRequirement;

    private ExecutionTarget executionTarget;
}
