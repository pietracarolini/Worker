package application;

import entities.enums.WorkerLevel;
import entities_.Department;
import entities_.HourContract;
import entities_.Worker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");

        System.out.println("Enter departament's name: ");
        String departmentName = sc.nextLine();
        System.out.println("Enter worker data:");
        System.out.println("Name: ");
        String workName = sc.next();
        System.out.println("Level (JUNIOR / MID_LEVEL / SENIOR): ");
        String workLevel = sc.next();
        System.out.println("Salary base: ");
        double basySalary = sc.nextDouble();

        Worker worker = new Worker(workName,WorkerLevel.valueOf(workLevel), basySalary, new Department(departmentName));

        System.out.println("How many contracts to this worker? ");
        int n = sc.nextInt();



        for(int i=0; i<n; i++) {
        System.out.println("Enter worker data #" + (i + 1) + ":");
            System.out.print("Date(DD/MM/YYYY):");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();
            System.out.print("Duration hour: ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);

        }
        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0,2)); // pra converter uma String em numero inteiro e selecionar a posicao do numero que deseja converter
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: "+ worker.getName());
        System.out.println("Departament: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ":" + String.format("%.2f", worker.income(year, month)));


    }
}
