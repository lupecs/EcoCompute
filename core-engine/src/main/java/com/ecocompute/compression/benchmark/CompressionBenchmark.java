package com.ecocompute.compression.benchmark;

import com.ecocompute.compression.algorithm.CompressionAlgorithm;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CompressionBenchmark {

    public BenchmarkReport becnhmark(
            File file,
            List<CompressionAlgorithm> algorithms
    ) throws IOException{

        BenchmarkReport report = new BenchmarkReport();

        for (CompressionAlgorithm algorithm : algorithms) {

            if (!algorithm.supports(file)) {
                continue;
            }

            BenchmarkResult result = algorithm.compress(file);

            report.addResult(result);

        }

        return report;
    }
}
