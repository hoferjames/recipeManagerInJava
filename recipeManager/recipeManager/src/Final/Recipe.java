/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class creates recipes to be added to the recipe list.
 * 
 * @author James
 */
public class Recipe {
    /**
     * This class contains multiple methods, but there are two major methods.
     * 
     * The first is building a recipe that will be added to the recipe list
     * that is created in the RecipeBox class. 
     * 
     * The second allows previously created recipes to be scaled down.
     * 
     * This class represents 3 of the 4 options available in the recipe box.
     * 
    */

    private String recipeName;
    private int servings;
    private ArrayList<Ingredient.addIngredient> recipeIngredients;
    private double totalRecipeCalories;
    private double scaleFactor;
    

    /**
     * @return the recipeName
     */
    public String getRecipeName() {
        return recipeName;
    }

    /**
     * @param recipeName the recipeName to set
     */
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    /**
     * @return the servings
     */
    public int getServings() {
        return servings;
    }

    /**
     * @param servings the servings to set
     */
    public void setServings(int servings) {
        this.servings = servings;
    }

    /**
     * @return the recipeIngredients
     */
    public ArrayList<Ingredient.addIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    /**
     * @param recipeIngredients the recipeIngredients to set
     */
    public void setRecipeIngredients(ArrayList<Ingredient.addIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    /**
     *
     * @return the scaleFactor
     */
    public double getScaleFactor(){
        return scaleFactor;
    }

    /**
     *
     * @param scaleFactor input
     */
    public void setScaleFactor(double scaleFactor){
        this.scaleFactor = scaleFactor;
    }

    /**
     * This is the Recipe constructor initialization.
     */
    public Recipe() {
        this.recipeName = "";
        this.servings = 0;
        this.recipeIngredients = new ArrayList<>();
        this.totalRecipeCalories = 0.0;
    }

    /**
     * This is the Recipe constructor.
     * 
     * 
     * @param recipeName
     * @param servings, total number for recipe
     * @param recipeIngredients
     * @param totalRecipeCalories
     * 
     */
    public Recipe(String recipeName, int servings, ArrayList<Ingredient.addIngredient> recipeIngredients, double totalRecipeCalories) {
        this.recipeName = recipeName;
        this.servings = servings;
        this.recipeIngredients = recipeIngredients;
        this.totalRecipeCalories = totalRecipeCalories;
    }

    /**
     * This method accepts recipe name, number of servings, recipe ingredients as an ArrayList, and the total recipe calories
     * 
     * @return new recipe
     */
    public Recipe createNewRecipe() {
        Scanner scnr = new Scanner(System.in);
         
        // requests the name of the recipe from the user
        System.out.println("Please enter the recipe name: ");
        recipeName = scnr.nextLine();
        
        // requests the number of servings the recipe produces
        // restricted to positive integers less than 100
        System.out.println("How many servings: ");
        for(servings = scnr.nextInt(); (servings < 0) || (servings > 100); ){
            System.out.println("Error: That number is out of range. Please try again!");
            System.out.println("How many servings: ");
            servings = scnr.nextInt(); 
        } 
        
        // creates recipeIngredients within the recipe by activating the addNewIngredient method
        recipeIngredients = new Ingredient().addNewIngredient();
        
        // Calculates the total recipe calories by adding the calories of all ingredients added
        int x = recipeIngredients.size();
           for (int i = 0; i < x; i++){
                Ingredient.addIngredient newIngredient = recipeIngredients.get(i);
                totalRecipeCalories = totalRecipeCalories + newIngredient.ingredientCalories;
                }
           
        //creates the new recipe that will be added to the recipe list
        Recipe newRecipe = new Recipe(recipeName, servings, recipeIngredients, totalRecipeCalories);
        // prints the new recipe
        newRecipe.printRecipe();
        return newRecipe; 

    }

    /**
     * This method prints the recipe that was created
     * 
     */
    public void printRecipe() {
        //prints the recipe name using the accessor
        System.out.println("Recipe: " + getRecipeName());
        
        //prints the number of servings using the accessor
        System.out.println("Yield: " + getServings() + " servings");
        
        //prints all ingredients
        System.out.println("Ingredients:");
        //each ingredient is printed by iterating through the recipe ingredients
        //x is used to match the number of iterations to the number of ingredients
        int x = recipeIngredients.size();
           for (int i = 0; i < x; i++){
            Ingredient.addIngredient newIngredient = recipeIngredients.get(i);
            System.out.println("Ingredient: " + newIngredient.ingredientName  + " Amount: " 
                    + newIngredient.ingredientAmount + " " + newIngredient.unitMeasurement + " Calories: "
                    + newIngredient.ingredientCalories);
        }
           
        //calculates and prints the calories per serving   
        double singleServingCalories; 
        singleServingCalories = totalRecipeCalories / getServings();
        System.out.println("Total Calories per serving: " + singleServingCalories);
    }

    /**
     * This method takes a recipe as an argument and adjusts it based on the percentage
     * that is entered by the user. It also creates a new recipe with a new name indicating
     * the percentage it was scaled to. 
     * 
     * @param input is recipe name that needs to be scaled
     * @return the adjusted recipe based on proportion required
     */
    public Recipe adjustPortion(Recipe input) {
        Scanner scnr = new Scanner(System.in);
        
        //This requests the percentage of the orignal recipe required
        System.out.println("Please enter the percentage you would like to scale the recipe to (do not include % sign): ");
              for(scaleFactor = scnr.nextDouble(); (scaleFactor < 0) || (scaleFactor > 100); ){
                System.out.println("Error: That number is out of range. Please try again!");
                System.out.println("How many servings: ");
                scaleFactor = scnr.nextDouble(); 
              } 

        //sets the scale factor to the input from the user
        setScaleFactor(scaleFactor);
        
        //creates new recipe name for the scaled recipe
        recipeName = input.recipeName + "_Adjusted_" + getScaleFactor() + "%.";
        //scales the number of servings the recipe produces
        servings = (int) (input.servings * getScaleFactor() * 0.01); 
        //passes forward the ingredient names
        recipeIngredients = input.recipeIngredients; 
        //scales the recipe calories
        totalRecipeCalories = input.totalRecipeCalories * getScaleFactor() * 0.01;
        
        //creates two ArrayList, one for editing ingredients, and one for
        //readding the edited ingredients to.
        ArrayList<Ingredient.addIngredient> beforeChange = recipeIngredients;
        ArrayList<Ingredient.addIngredient> afterChange = new ArrayList<>();
        
        //Initializing the arrays used to create the ArrayList.          
            int x = beforeChange.size();  
            String[] ingredientName = new String[x];
            String[] unitMeasurement = new String[x];
            float[] ingredientAmount = new float[x];
            double[] ingredientCalories = new double[x];
        
        //getting, changing/passing, and re-adding the ingredient specifics to an ArrayList
            for (int i = 0; i < x; i++){
                Ingredient.addIngredient newIngredient = recipeIngredients.get(i);
                ingredientName[i] = newIngredient.ingredientName;
                unitMeasurement[i] = newIngredient.unitMeasurement;
                ingredientAmount[i] = (float) (newIngredient.ingredientAmount * getScaleFactor() * 0.01);
                ingredientCalories[i] = newIngredient.ingredientCalories * getScaleFactor() * 0.01;
                //creating object to use the Ingredient class properties
                Ingredient ing = new Ingredient();
                Ingredient.addIngredient tempChange = ing.new addIngredient(ingredientName[i], unitMeasurement[i], ingredientAmount[i], ingredientCalories[i]);
                afterChange.add(tempChange);
            }
        //creating new recipe using the new list of ingredients called afterChange
        Recipe newAdjustedRecipe = new Recipe(recipeName, servings, afterChange, totalRecipeCalories);
        //printing the new recipe
        newAdjustedRecipe.printRecipe();
        return newAdjustedRecipe; 

    }      
}

