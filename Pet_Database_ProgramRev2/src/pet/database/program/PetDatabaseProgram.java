/*
 * Name: Matt Kloeckl, kloecklm@csp.edu
 * Class: CSC 422 Software Engineering
 * School: Concordia University, St. Paul
 * Professor: Susan Furtney, furtney@csp.edu
 * Assignment: Assignment 1, Part 2
 * Date: November 6, 2022
 * 
 * This package allows users to create a test with different
 * types of questions and saves it as a serialized file.
 * Once a test is created, users can take the test from the file.
 * 
 */
package pet.database.program;

import java.util.*;

public class PetDatabaseProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap<String, Integer> petAgeList = new HashMap<>();
        
        System.out.println("PET DATABASE PROGRAM");
        
        
        //Loop through user's input until valid menu selection is entered or user exits program.
        boolean repeat = true;
        while(repeat){
            PrintMenu();
            System.out.println();
            System.out.print("\tYour choice: ");
            
            try{
                int menuSelection = Integer.parseInt(input.nextLine());
                if(menuSelection < 1 || menuSelection > 7){
                    System.out.println("Invalid selection, please try again.");
                }
                
                //Menu options switch.
                switch(menuSelection){
                    
                    //View all pets option
                    case 1 -> {
                        System.out.println("""
                                                 +----------------------+
                                                 | ID | NAME      | AGE |
                                                 +----------------------+""");
                      
                            int x = 0;
                            for(String key: petAgeList.keySet()){
                               System.out.print("|");
                               System.out.printf("%3s", x);
                               System.out.print(" | ");
                               System.out.printf("%-10s", key);
                               System.out.print("|");
                               System.out.printf("%4s",  petAgeList.get(key));
                               System.out.print(" |\n");
                               x++;
                        }
                            System.out.println("+----------------------+");
                            System.out.println(petAgeList.size() + " rows in set");
                    
                                                
                               
                       
                              
                    break;
                    }
                    
                    //Add more pets option
                    case 2 -> {
                        Boolean addPets = true;
                        while(addPets){
                            for (int x = -1; x <= petAgeList.size(); x++ ){    
                                System.out.print("""
                                    To add pet, enter pet name followed by age
                                    (i.e: 'Spot 5') or type 'done' to exit: """);
                                String response  = input.nextLine();
                                String[] petAgeResponse = response.trim().split(" ");
                                String pet = petAgeResponse[0];
                                
                                if("done".equals(pet)){
                                    addPets = false;
                                    System.out.println((x+1) +" pets added");
                                    break;
                                }
                                int petAge = Integer.parseInt(petAgeResponse[1]);
                                petAgeList.put(pet, petAge);

                                }
                            }
                        break;    
                        }

                    //Update an existing pet
                    case 3 -> {
                    }
                    
                    //Remove an existing pet
                    case 4 -> {
                    }
                    
                    //Search pets by name
                    case 5 -> {
                        System.out.println("Enter a name to search: ");
                        String petSearch = input.nextLine();
                        boolean keyIsPresent = petAgeList.containsKey(petSearch);
                        if(keyIsPresent){
                            System.out.println("Yes, " +petSearch+ " exists and is " + petAgeList.get(petSearch) + " years old." );

                        }
                        else{
                            System.out.println(petSearch + " does not exist.");
                        }
                        break;
                    }
                    
                    //Search pets by age
                    case 6 -> {
                        System.out.print("Enter age to search: ");
                        int age = input.nextInt();
                        List listOfKeys = null;
                        if(petAgeList.containsValue(age)){
                                listOfKeys = new ArrayList<>();
                                for(Map.Entry entry : petAgeList.entrySet()){
                                    if(entry.getValue().equals(age)){
                                    listOfKeys.add(entry.getKey());
                                    }
                                }
                                System.out.println("Pet(s) with age of " + age + ":\n" + listOfKeys);
                        }
                        
                        else{
                            System.out.println("There are no pets with the age of " + age);
                        }
                        break;
                    }
            
                    
                    //Exit Program
                    case 7 -> {
                        System.out.println("\nGoodbye!");
                        repeat = false;
                        break;
                    }                       
                }
            
            }catch(Exception ex){
                        System.out.println("Invalid selection, please try again.");
                        }
        }
        
        
      
    }
    
    //Function to display menu to user.
    public static void PrintMenu(){
        System.out.println("""
                           
                           What would you like to do?
                           1. View all pets 
                           2. Add more pets
                           3. Update an existing pet
                           4. Remove an existing pet
                           5. Search pets by name
                           6. Search pets by age
                           7. Exit program""");
    }
    
}
