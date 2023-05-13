/**
 * CSCI1130 Java Assignment 2 Taxation
 *
 * Remark: Name your class, variables, methods, etc. properly.
 * You should write comment for your work and follow good styles. *
 * I declare that the assignment here submitted is original except for source
 * material explicitly acknowledged, and that the same or closely related
 * material has not been previously submitted for another course. I also
 * acknowledge that I am aware of University policy and regulations on honesty
 * in academic work, and of the disciplinary guidelines and procedures
 * applicable to breaches of such policy and regulations, as contained in the * website.
 *
 *University Guideline on Academic Honesty:
 *   http://www.cuhk.edu.hk/policy/academichonesty
 *Faculty of Engineering Guidelines to Academic Honesty:
 *   https://www.erg.cuhk.edu.hk/erg/AcademicHonesty
 *
 * Student Name: Lui Ka Yung
 * Student ID : 1155160217
 * Date : 5/10/2022
 */
/**
 *
 * @author lk
 */
package taxation;

import java.io.PrintStream;
import java.util.Scanner;

public class Taxation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Scanner is a class
        //keyboard is the new object
        //new Scanner is for creating new object under class Scanner
        //(System.in) is indicating where the Scanner get input

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Total Income: $");

        //defining local variable totalIncome = object keyboard
        //nextDouble() is the method imported by Scanner(?)
        double totalIncome = keyboard.nextDouble();
        if (totalIncome < 0) {
            System.out.println("Invalid input !");
            System.exit(0);
        }

        System.out.print("Deductions  : $");
        double deduction = keyboard.nextDouble();
        if (deduction < 0) {
            System.out.println("Invalid input !");
            System.exit(0);
        }

        System.out.print("Allowances  : $");
        double allowances = keyboard.nextDouble();
        if (allowances < 0) {
            System.out.println("Invalid input !");
            System.exit(0);
        }
        double ni = totalIncome - deduction;
        {
            if (ni < 0) {
                ni = 0;
            }
        }
        double standardTax = ni * 0.15;
        double progressiveTax = 0;
        double nci = ni - allowances;
        if (nci < 0) {
            nci = 0;
        } else if (nci >= 0 && nci <= 50000) {
            progressiveTax = nci * 0.02;
        } else if (nci > 50000 && nci <= 100000) {
            progressiveTax = 1000 + (nci - 50000) * 0.06;
        } else if (nci > 100000 && nci <= 1500000) {
            progressiveTax = 4000 + (nci - 100000) * 0.1;
        } else if (nci > 150000 && nci <= 200000) {
            progressiveTax = 9000 + (nci - 150000) * 0.14;
        } else if (nci > 200000) {
            progressiveTax = 16000 + (nci - 200000) * 0.17;
        }

        System.out.println("Progressive Tax  = $" + String.format("%.1f", progressiveTax));
        System.out.println("Standard Tax     = $" + String.format("%.1f", standardTax));;
        System.out.print("Amount of Salaries Tax = $");
        double taxPayable;
        if (progressiveTax >= standardTax) {
            System.out.printf("%.1f\n", standardTax);
            taxPayable = standardTax;
        } else {
            System.out.printf("%.1f\n", progressiveTax);
            taxPayable = progressiveTax;
        }
        
        System.out.print("Final Salaries Tax Payable = $");
        if (taxPayable < 10000) {
            System.out.print(0.0 + "\n");
        } else {
            double temp = taxPayable - 10000;
            System.out.printf("%.1f\n", temp);
        }
    }

}
