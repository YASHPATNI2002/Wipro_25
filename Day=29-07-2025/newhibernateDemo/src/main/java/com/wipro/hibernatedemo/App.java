package com.wipro.hibernatedemo;

import java.util.List;
import java.util.Scanner;

import com.wipro.entity.Pan;
import com.wipro.hibernatedemo.repo.PanRepo;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("-- PAN Menu --");
            System.out.println("1. Create PAN");
            System.out.println("2. Find PAN by Id");
            System.out.println("3. Find PAN by No");
            System.out.println("4. Update PAN");
            System.out.println("5. Delete PAN by No");
            System.out.println("6. List all PAN holder names");
            System.out.println("7. List all PANs");
            System.out.println("9. Exit");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    PanRepo.createPan();
                    break;
                case 2:
                	System.out.println("Enter PAN ID to search:");
                	String idStr = sc.nextLine();  // or sc.nextLine() if you're mixing input types
                	int id = 0;
                	try {
                	    id = Integer.parseInt(idStr);
                	    Pan panById = PanRepo.findById(id);
                	    if (panById != null) {
                	        System.out.println(panById);
                	    } else {
                	        System.out.println("PAN with ID " + id + " not found.");
                	    }
                	} catch (NumberFormatException e) {
                	    System.out.println("Invalid input! Please enter a valid integer ID.");
                	}
                	break;
                    
                case 3:
                    System.out.println("Enter PAN number:");
                    String panNumber = sc.nextLine(); 
                    Pan p = PanRepo.findByPanNumber(panNumber); 
                    if (p != null) {
                        System.out.println("PAN Holder Name: " + p.getPanholderName());
                        System.out.println("PAN Number: " + p.getPanNumber());
                    } else {
                        System.out.println("PAN not found.");
                    }
                    break;

                case 4:
                    PanRepo.updatePan();
                    break;
                case 5:
                    System.out.println("Enter PAN number to delete:");
                    String panNoToDelete = sc.nextLine();
                    PanRepo.deleteByPanNo(panNoToDelete);
                    break;
                case 6:
                    List<String> panHolderNames = PanRepo.findAllPanHolderNames();
                    System.out.println("All PAN Holder Names:");
                    panHolderNames.forEach(System.out::println);
                    break;

                case 7:
                    List<Pan> list = PanRepo.findAll();
                    list.forEach(System.out::println);
                    break;
                    
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 9);

        sc.close();
    }
}
