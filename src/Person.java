import java.util.Objects;
import java.util.Scanner;

public class Person {
    private String Name;
    private String Gender;
    private int age;
    private int height;
    private double weight;
    private float BMR;
    private float BMI;
    private String checkBMI;

    public String getCheckBMI() {
        return checkBMI;
    }

    public void setCheckBMI(String checkBMI) {
        this.checkBMI = checkBMI;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public float getBMR() {
        return BMR;
    }

    public void setBMR(float BMR) {
        this.BMR = BMR;
    }

    public float getBMI() {
        return BMI;
    }

    public void setBMI(float BMI) {
        this.BMI = BMI;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Person() {
    }
    // Function to calculate the BMR for the users:
    public void checkBMR() {

        if (Objects.equals(this.getGender(), "male")) {
            BMR = (float) (66 + (13.7 * getWeight()) + (5 * getHeight()) - (6.8 * getAge()));
        } else {

            BMR = (float) (655 + (9.6 * getWeight()) + (1.8 * getHeight() - 4.7 * getAge()));
        }
        setBMR(BMR);

    }
    // Function to calculate the BMI for the users and check their weight:
    public void checkBMII(){
                float x = (float) (getWeight()/getHeight());
                float y = (float) getHeight();
        BMI = (x/y)*10000;
        if(18.5<=BMI&&BMI<=25){
            setCheckBMI("Optimal weight");
        } else if (BMI<18.5) {
            setCheckBMI("Underweight");
        }else
        {
            setBMI(BMI);
            setCheckBMI("Overweight");
        }
    }
    Scanner sc = new Scanner(System.in);
    // Function to check that the user enter positive number:
    public float positiveNumber(float number){


        float l =0;
        while(number<=0){
            System.out.println("Enter a positive number:");
            number = sc.nextFloat();
        }
        return number;

    }



}



