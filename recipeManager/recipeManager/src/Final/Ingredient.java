/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class feeds the recipe class as the ingredient variable of the recipe.
 * 
 * 
 * @author James
 */


public class Ingredient{
    
    /**
     * This class was created to assemble all information about each ingredient that
     * is added to the recipe.
     * 
     * 
     */
    class addIngredient{
        String ingredientName;
        String unitMeasurement;
        float ingredientAmount;
        double ingredientCalories;  
    
        addIngredient(String ingredientName, String unitMeasurement, float ingredientAmount, double ingredientCalories){
            this.ingredientName = ingredientName;
            this.unitMeasurement = unitMeasurement;
            this.ingredientAmount = ingredientAmount;
            this.ingredientCalories = ingredientCalories;
        }   
    }

    /**
     * 
     * This class was created to assemble all information about each ingredient that
     * is added to the recipe. 
     * The addNewIngredient method requests input for the ingredient name, unit of measure, amount,
     * and calories. Each component is added to a separate array and then they are
     * assembled into an ArrayList.
     * 
     * 
     * @return an ArrayList with name, unit of measure, amount, and calories
     */
    public ArrayList addNewIngredient() {
       Scanner scnr = new Scanner(System.in);
       
       /* This block requires the user to enter the number of ingredients required 
       *  for the recipe. That number is used as the length of each array below.
       *  The number of ingredients is restricted to positive numbers less than 100.
       */
       System.out.println("Please enter the number of ingredients required for this recipe: ");
       int numberOfIngredients;       
       for(numberOfIngredients = scnr.nextInt(); (numberOfIngredients < 0) || (numberOfIngredients > 100); ){
            System.out.println("Error: That number is out of range. Please try again!");
            System.out.println("How many ingredients are required? ");
            numberOfIngredients = scnr.nextInt(); 
        } 
       // Changes the name of numberOfIngredients to x for code readability.
       int x = numberOfIngredients;
       
       //Initializing the arrays used to create the ArrayList.
       String[] ingredientName = new String[x];
       String[] unitMeasurement = new String[x];
       float[] ingredientAmount = new float[x];
       double[] ingredientCalories = new double[x];
       
       //Initializing the ArrayList that is returned as the ingredient 
       ArrayList<addIngredient> recipeIngredients = new ArrayList<>();

       /* 
       *  This block requires the user to enter the ingredient name for the recipe.
       *  It is also contained in a for loop where it is added to the string array.
       *  If "end" is entered the method is exited.
       */
       for(int i = 0; i < x; i++){    
            scnr.nextLine();
            System.out.println("Please enter the ingredient name "
                                 + "or type end if you are finished entering ingredients: ");
            ingredientName[i] = scnr.nextLine();    
                if("end".equals(ingredientName[i].toLowerCase())){
                    break;
                }
            
            // Unit of measurement is requested from user and added to the second string array.
            System.out.print("Please enter the unit of measurement for this ingredient (e.g. cups, oz., etc.): ");
            unitMeasurement[i] = scnr.nextLine();
            
            // Amount is requested from user and added to the float array.
            // Restricted to positive floats less than 999.
            System.out.println("Please enter the ingredient amount: ");
               for(ingredientAmount[i] = scnr.nextFloat(); (ingredientAmount[i] < 0) || (ingredientAmount[i] > 999); ){
                   System.out.println("Error: That number is out of range. Please try again!");
                   System.out.println("Please re-enter the ingredient amount: ");
                   ingredientAmount[i] = scnr.nextFloat(); 
                   } 
            
            // The ingredient calories are requested from the user and added to the double array.
            // Restricted to positive doubles less than 9999.
            System.out.println("Please enter the ingredient calories: ");
               for(ingredientCalories[i] = scnr.nextDouble(); (ingredientCalories[i] < 0) || (ingredientCalories[i] > 9999); ){
                   System.out.println("Error: That number is out of range. Please try again!");
                   System.out.println("Please re-enter the ingredient calories: ");
                   ingredientCalories[i] = scnr.nextDouble();
                   } 
            
            // Adds all inputs to recipeIngredients ArrayList.
            recipeIngredients.add(new addIngredient(ingredientName[i], unitMeasurement[i], ingredientAmount[i], ingredientCalories[i]));
            }
        return recipeIngredients;
    }
}
