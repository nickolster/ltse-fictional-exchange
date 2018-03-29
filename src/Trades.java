/**
 * Created by mac on 3/28/18.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class Trades {


        public static void main(String[] args) {
            String readFile = "./trades.csv";
            String line = "";
            String splitBy = ",";
            List<String[]> records = new ArrayList<>();
            List<String[]> acceptedRecords = new ArrayList<>();
            List<String[]> rejectedRecords = new ArrayList<>();



            try (BufferedReader br = new BufferedReader(new FileReader(readFile))) {

                while ((line = br.readLine()) != null) {

                    String[] record = line.split(splitBy);
                    records.add(record);

//                    for(int index = 1; index < record.length; index++){
//                        if(record[index].isEmpty()) {
//                            rejectedRecords.add(record);
//                            System.out.println("rejected !!!!");
//                        }
//                    }
//
//                    if(record[3].equalsIgnoreCase("2"))
//                        rejectedRecords.add(record);

                    //Condition 1 and 2 are met here
                    if(!record[1].isEmpty() && !record[2].isEmpty() && !record[3].isEmpty() && !record[4].isEmpty()
                            && !record[5].isEmpty() && !record[6].isEmpty() && !record[record.length-1].isEmpty()
                            && record[3].equalsIgnoreCase("K")){
                        acceptedRecords.add(record);
                    }else {
                        rejectedRecords.add(record);
                    }


                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("reading done");

            writeToFile(rejectedRecords);


        }

    //Write to a file
    public static void writeToFile(List<String[]> records) {

        String writeFile = "./rejectedRecords.csv";


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(writeFile))) {

            for (String[] record:records) {
                bw.write("\n");
                for (String value:record
                        ) {
                    bw.write(value+",");
                }
            }

            System.out.println("writing done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
