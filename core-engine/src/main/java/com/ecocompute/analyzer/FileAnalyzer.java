package com.ecocompute.analyzer;

import com.ecocompute.model.*;

import java.io.File;

/**
 * Will read dile from disk
 * detects extension
 * determines type (ie IMAGE, VIDEO, DATASET)
 * Measures size
 * Will return a populated WorkloadProfile
 * **/

public class FileAnalyzer {

    public WorkloadProfile analyze(File file) {

        String fileName = file.getName();

        String extension = getExtension(fileName);

        FileType fileType = determineFileType(extension);

        return WorkloadProfile.builder()
                .filename(fileName)
                .extension(extension)
                .fileSizeBytes(file.length())
                .fileType(fileType)
                .compressionLevel(CompressionLevel.UNKOWN)
                .cpuRequirement(CpuRequirement.LOW)
                .memoryRequirement(MemoryRequirement.LOW)
                .executionTarget(ExecutionTarget.UNDECIDED)
                .build();
    }

    private String getExtension(String fileName) {

        int lastDot = fileName.lastIndexOf(".");

        if (lastDot == -1) {
            return "";
        }

        return fileName.substring(lastDot + 1).toLowerCase();
    }

    private FileType determineFileType(String extension) {

        return switch (extension) {
            case "jpg", "jpeg", "png", "gif", "bmp", "webp" -> FileType.IMAGE;

            case "mp4", "mov", "avi", "mkv", "wmv" -> FileType.VIDEO;

            case "mp3", "wav", "aac", "flac" -> FileType.AUDIO;

            case "pdf", "doc", "docx", "txt" -> FileType.DOCUMENT;

            case "zip", "rar", "7z", "tar", "gz" -> FileType.ARCHIVE;

            case "java", "py", "js", "ts", "cpp", "cs" -> FileType.CODE;

            case "csv", "json", "xml", "parquet" -> FileType.DATASET;

            default -> FileType.UNKOWN;
        };
    }
}
