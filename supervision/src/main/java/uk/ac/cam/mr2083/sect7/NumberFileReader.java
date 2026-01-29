package uk.ac.cam.mr2083.sect7;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class NumberFileReader {
    private static class LineNumbers implements Comparable<LineNumbers> {
        int num1;
        int num2;

        public LineNumbers(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        public LineNumbers(String strNum1, String strNum2) {
            this(Integer.parseInt(strNum1), Integer.parseInt(strNum2));
        }

        public int compareTo(LineNumbers o) {
            return num1 == o.num1 ? num2 - o.num2 : num1 - o.num1;
        }

        public int getNum1() {
            return num1;
        }

        public int getNum2() {
            return num2;
        }
    }

    private LineNumbers processLine(String line, int lineIndex) {
        String[] lineParts = line.split(",");
        if (lineParts.length != 2) {
            throw new RuntimeException("Line " + lineIndex + "(\"" + line + "\") not formatted correctly.");
        }

        int num1 = Integer.parseInt(lineParts[0]);
        int num2 = Integer.parseInt(lineParts[1]);

        return new LineNumbers(num1, num2);
    }

    private LineNumbers processLine(String line) {
        return processLine(line, -1);
    }

    public void processFile(String filename) throws IOException {
        File file = new File(filename);

        List<LineNumbers> lineNumbers = new ArrayList<>();

        int lineIndex = 0;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                lineIndex++;
                lineNumbers.add(processLine(scanner.nextLine(), lineIndex));
            }
        }

        lineNumbers.sort(Comparator.comparingInt(LineNumbers::getNum1).thenComparingInt(LineNumbers::getNum2));

        for (LineNumbers l : lineNumbers) {
            System.out.println(l.getNum1() + " " + l.getNum2());
        }
    }
}
