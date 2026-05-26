package application;

import entities.enums.WorkerLevel;
import entities_.HourContract;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter departament's name: ");
        String departament = sc.next();

        System.out.println("Enter worker data:");
        System.out.println("Name: ");
        String name = sc.next();
        System.out.println("Level (JUNIOR / MID_LEVEL / SENIOR): ");
        WorkerLevel level = WorkerLevel.valueOf(sc.next());

        System.out.println("How many contracts to this worker? ");
        int n = sc.nextInt();

        HourContract[] contract  = new HourContract[n];

        for(int i=0; i<n; i++) {
        System.out.println("Enter worker data #" + (i + 1) + ":");
            System.out.print("Date(DD/MM/YYYY):");
            String date = sc.next();
            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();
            System.out.print("Duration hour: ");
            Double hours = sc.nextDouble();

        }
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        LocalDate d = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("MM/yyyy"));

    }
}