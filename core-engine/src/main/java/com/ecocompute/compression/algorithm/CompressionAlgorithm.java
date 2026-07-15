package com.ecocompute.compression.algorithm;

import com.ecocompute.compression.benchmark.BenchmarkResult;

import java.io.File;
import java.io.IOException;

public interface CompressionAlgorithm {

    String getName();

    BenchmarkResult compress(File inputFile) throws IOException;

    boolean supports(File inputFile);
}
