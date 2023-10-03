package niodemo.processcsv;

public class CSVFileAnalysisRunner {
    public static void main(String[] args) {
        CSVFileAnalysis csvFileAnalysis = new CSVFileAnalysis();
        csvFileAnalysis.analyseCSVUsingStream("files/data.csv");

//        CSVFileAnalysisTraditional csvFileAnalysisTraditional = new CSVFileAnalysisTraditional();
//        csvFileAnalysisTraditional.analyseCSVTraditionally("files/data.csv");
    }
}
