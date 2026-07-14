package com.ecocompute.cli;

import com.ecocompute.analyzer.FileAnalyzer;
import com.ecocompute.compression.CompressionAnalyzer;
import com.ecocompute.model.*;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("spotify-wrapped-2019.jpg");

        FileAnalyzer analyzer = new FileAnalyzer();

        WorkloadProfile profile = analyzer.analyze(file);

        CompressionAnalyzer compressionAnalyzer =
                new CompressionAnalyzer();


        CompressionLevel level =
                compressionAnalyzer
                        .estimateCompressionLevel(profile);


        CompressionRecommendation recommendation =
                compressionAnalyzer
                        .recommend(level);


        profile.setCompressionLevel(level);

        profile.setCompressionRecommendation(
                recommendation
        );


        System.out.println(profile);
    }
}
