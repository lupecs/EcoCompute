package com.ecocompute.cli;

import com.ecocompute.analyzer.FileAnalyzer;
import com.ecocompute.model.WorkloadProfile;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("spotify-wrapped-2019.jpg");

        FileAnalyzer analyzer = new FileAnalyzer();

        WorkloadProfile profile = analyzer.analyze(file);

        System.out.println(profile);
    }
}
