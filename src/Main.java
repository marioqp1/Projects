import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<Person> Vector = new ArrayList<>();
        ArrayList<Float> MBMR = new ArrayList<>();
        ArrayList<Float> FBMR = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Number of persons you need to enter: ");
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            Person e = new Person();
            System.out.println("Enter the name: ");
            String Name = sc.next();
            e.setName(Name);
            System.out.println("Enter the Age: ");
            int age = sc.nextInt();
            e.setAge((int) e.positiveNumber(age));
            System.out.println("Enter the height: ");
            int height = sc.nextInt();
            e.setHeight((int) e.positiveNumber(height));
            System.out.println("Enter the weight: ");
            int weight = sc.nextInt();
            e.setWeight(e.positiveNumber(weight));
            System.out.println("Choose the gender with number:");
            System.out.println("1.Male:");
            System.out.println("2.Female:");
            int gender = sc.nextInt();
            if (gender == 1) {
                e.setGender("male");
            } else {
                e.setGender("female");
            }
            e.checkBMII();
            e.checkBMR();
            if (Objects.equals(e.getGender(), "male") && Objects.equals(e.getCheckBMI(), "Optimal weight")) {
                MBMR.add(e.getBMR());
            } else if (Objects.equals(e.getGender(), "female") && Objects.equals(e.getCheckBMI(), "Optimal weight")) {
                FBMR.add(e.getBMR());
            }
            Vector.add(e);
        }
        // Average for Male
        float Sum = 0;
        float Average = 0;
        for (int j = 0; j < MBMR.size(); j++) {
            Sum += MBMR.get(j);
        }
        Average = Sum / MBMR.size();

        // Average for female
        float Sumf = 0;
        float AverageF = 0;
        for (int j = 0; j < FBMR.size(); j++) {
            Sumf += FBMR.get(j);
        }
        AverageF = Sumf / FBMR.size();

//        PrintWriter Writer = new PrintWriter(new File("C:\\Users\\Me\\Desktop\\Report.dat"));
//        for (int i=0;i<Vector.size();i++) {
//            Writer.println("**********************************************************************************************************************************");
//            Writer.print("Name: "+Vector.get(i).getName()+" / ");
//            Writer.print("Gender: "+Vector.get(i).getGender()+" / ");
//            Writer.print("Age: "+Vector.get(i).getAge()+" / ");
//            Writer.print("Height: "+Vector.get(i).getHeight()+" / ");
//            Writer.print("Weight: "+Vector.get(i).getWeight()+" / ");
//            Writer.print("BMI: "+Vector.get(i).getBMI()+" / ");
//            Writer.print("BMR: "+Vector.get(i).getBMR()+" / ");
//            Writer.println("checkBMI: "+Vector.get(i).getCheckBMI());
//        }
//        Writer.println("************************************************************************************************************************************");
//        Writer.println("Average BMR for Male: "+Average);
//        Writer.println("Average BMR for Female: "+AverageF);
//        Writer.close();
        //loop to print on screen
        for (int k = 0; k < Vector.size(); k++) {
            System.out.println("****************************************************************************************************************************");
            System.out.print("Name: " + Vector.get(k).getName() + " - ");
            System.out.print("Gender: " + Vector.get(k).getGender() + " - ");
            System.out.print("Age: " + Vector.get(k).getAge() + " - ");
            System.out.print("Height: " + Vector.get(k).getHeight() + " - ");
            System.out.print("Weight: " + Vector.get(k).getWeight() + " - ");
            System.out.print("BMI: " + Vector.get(k).getBMI() + " - ");
            System.out.print("BMR: " + Vector.get(k).getBMR() + " - ");
            System.out.println("checkBMI: " + Vector.get(k).getCheckBMI());

        }
        System.out.println("Average BMR for Male: " + Average);
        System.out.print("Average BMR for Female: " + AverageF);
        // loop to create and write in text file
        PrintWriter Writer1 = new PrintWriter(new File("C:\\Users\\Me\\Desktop\\Report.txt"));
        for (int i = 0; i < Vector.size(); i++) {
            Writer1.println("************************************************************************************************************************************");
            Writer1.print("Name: " + Vector.get(i).getName() + " / ");
            Writer1.print("Gender: " + Vector.get(i).getGender() + " / ");
            Writer1.print("Age: " + Vector.get(i).getAge() + " / ");
            Writer1.print("Height: " + Vector.get(i).getHeight() + " / ");
            Writer1.print("Weight: " + Vector.get(i).getWeight() + " / ");
            Writer1.print("BMI: " + Vector.get(i).getBMI() + " / ");
            Writer1.print("BMR: " + Vector.get(i).getBMR() + " / ");
            Writer1.println("checkBMI: " + Vector.get(i).getCheckBMI());
        }
        Writer1.println("************************************************************************************************************************************");
        Writer1.println("Average BMR for Male: " + Average);
        Writer1.println("Average BMR for Female: " + AverageF);
        Writer1.close();

        //loop to print in binary file
        FileOutputStream f = new FileOutputStream("C:\\Users\\Me\\Desktop\\Report.dat");
        DataOutputStream d = new DataOutputStream(f);
        for (int i = 0; i < Vector.size(); i++) {
            d.writeUTF(Arrays.toString("Name :".getBytes()));
            d.writeUTF(" ");
            d.writeUTF(Vector.get(i).getName());
            d.writeUTF(" ");
            d.writeUTF("Gender is: ");
            d.writeUTF(Vector.get(i).getGender());
            d.writeUTF(" ");
            d.writeUTF("Age is: ");
            d.writeInt(Vector.get(i).getAge());
            d.writeUTF(" ");
            d.writeUTF("Height is: ");
            d.writeInt(Vector.get(i).getHeight());
            d.writeUTF(" ");
            d.writeUTF("Weight is: ");
            d.writeFloat((float) Vector.get(i).getWeight());
            d.writeUTF(" ");
            d.writeUTF("BMI is: ");
            d.writeFloat(Vector.get(i).getBMI());
            d.writeUTF(" ");
            d.writeUTF("BMR is: ");
            d.writeFloat(Vector.get(i).getBMR());
            d.writeUTF(" ");
            d.writeUTF("chckBMI is: ");
            d.writeUTF(Vector.get(i).getCheckBMI());
            d.writeUTF(" ");
            d.writeUTF("\n ");
        }
        d.writeUTF("Average for males: ");
        d.writeFloat(Average);
        d.writeUTF("\n ");
        d.writeUTF("Average for females: ");
        d.writeFloat(AverageF);
        d.close();
        d.flush();

    }
}
