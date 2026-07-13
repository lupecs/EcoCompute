package com.ecocompute.model;

public class WorkloadProfile {

    private String filename;
    private String extension;

    private long fileSizeBytes;

    private FileType fileType;

    private CompressionLevel compressionLevel;

    private CpuRequirement cpuRequirement;

    private MemoryRequirement memoryRequirement;

    private ExecutionTarget executionTarget;
}
