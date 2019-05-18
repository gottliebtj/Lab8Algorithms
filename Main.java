import java.math.*;
import java.security.*;
import java.util.*;
import java.io.*;




public class Main{
public static void main(String args[]){
  System.out.println("Hashing gene data with 1.5M Entries 1000 times");
  ArrayList<Double> benchmarks = new ArrayList<Double>();
  for(int i=1;i<1000;i++){
    double benchmark =runBenchMark();
    System.out.println("|-----Trial:"+i+"--"+benchmark+"--------|");
    benchmarks.add(benchmark);
  }
  double average = calculateAverage(benchmarks);
  System.out.println("The Average Of All Results is: "+ average);

  }





public static void hashGenes(){
  List<List<String>> records = new ArrayList<>();
  int total=0;
  Hasher hasher = new Hasher();
try {
BufferedReader br = new BufferedReader(new FileReader("gene_info100000.csv"));

String line;
while ((line = br.readLine()) != null) {
    String[] values = line.split(",");
    records.add(Arrays.asList(values));
}


for(List<String> row: records){
for(String cell:row){
String hashedCell = hasher.hash(cell);
//System.out.println(hashedCell);
total++;
}
}
//System.out.println("Total Strings Counted: "+ total);
}
catch(Exception e){
System.out.print(e);
}
}

public static double runBenchMark(){
   long startTime = System.nanoTime();
   hashGenes();
   long endTime =System.nanoTime();
   double benchmark =(endTime-startTime)*.000000009;
 //  System.out.println("BenchMark For Test of "+testArray.length+" elements using MERGE SORT was "+benchmark+" Seconds.");
   return benchmark;
  }

public static double calculateAverage(List <Double> marks) {
double sum = 0;
if(!marks.isEmpty()) {
  for (Double mark : marks) {
      sum += mark;
  }
  return sum / marks.size();
}
return sum;
}









}
