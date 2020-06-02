/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class is the driver for interacting with the list of recipes.
 * 
 * @author James
 */
public class RecipeBox {
    // creating private variables
    private ArrayList<Recipe> listOfRecipes;
    private Recipe recipeToAdjust;

    /**
     * @param args the command line arguments
     */
    /**
     * @return the listOfRecipes
     */
    public ArrayList<Recipe> getListOfRecipes() {
        return listOfRecipes;
    }

    /**
     * @param listOfRecipes the listOfRecipes to set
     */
    public void setListOfRecipes(ArrayList<Recipe> listOfRecipes) {
        this.listOfRecipes = listOfRecipes;
    }

    /**
     * Constructor for RecipeBox
     */
    public RecipeBox() {
        this.listOfRecipes = new ArrayList();
    }

    /**
     *
     * @param listOfRecipes
     */
    public RecipeBox(ArrayList<Recipe> listOfRecipes) {
        this.listOfRecipes = listOfRecipes;
    }

    /**
     * This method prints all of the details for a given recipe
     * 
     * @param selectedRecipeName
     */
    public void printAllRecipeDetails(String selectedRecipeName) {
        for (int i = 0; i < listOfRecipes.size(); i++) {
            if (listOfRecipes.get(i).getRecipeName().equals(selectedRecipeName)) {
                listOfRecipes.get(i).printRecipe();
            }
        }
    }
    
    /**
     * This method finds the details associated with the recipe that needs to scaled
     * 
     * @param selectedRecipeName
     * @return the recipe that needs to be adjusted
     */
    public Recipe findRecipeDetails(String selectedRecipeName){
                for (int i = 0; i < listOfRecipes.size(); i++) {
                if (listOfRecipes.get(i).getRecipeName().equals(selectedRecipeName)) {
                Recipe recipeToAdjust = listOfRecipes.get(i);
                printAdjustedRecipeDetails(recipeToAdjust);
            }
        }
        return recipeToAdjust;
    }
    
    /**
     * Adds the adjusted recipe back to the recipe list
     * 
     * @param adjustmentNeeded
     */
    public void printAdjustedRecipeDetails(Recipe adjustmentNeeded) {
        listOfRecipes.add(new Recipe().adjustPortion(adjustmentNeeded));
    }

    /**
     * prints the names of the recipes
     */
    public void printAllRecipeNames() {
        for (Recipe currentRecipe : listOfRecipes) {
            System.out.println(currentRecipe.getRecipeName());
        }
    }

    /**
     * adds new recipes to the recipe list
     */
    public void addNewRecipe() {
        listOfRecipes.add(new Recipe().createNewRecipe());
    }

    /**
     * The main method which creates the recipe box. The recipe box allows the
     * the user to select an option to create, print, print list, or scale recipe.
     * 
     * @param args
     */
    public static void main(String[] args) {
        RecipeBox myRecipeBox = new RecipeBox();
        Scanner menuScnr = new Scanner(System.in);
        //request user to enter their selection
        System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" + "3. Print All Recipe Names\n" 
                    + "4. Print Adjusted Recipe Amount\n" + "\nPlease select a menu item:");
        
        //a while loop that accepts integers, executes based upon input, and returns to the menu
        while (menuScnr.hasNextInt() || menuScnr.hasNextLine()) {
            System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" + "3. Print All Recipe Names\n" 
                    + "4. Print Adjusted Recipe Amount\n" + "\nPlease select a menu item:");
            int input = menuScnr.nextInt();
            System.out.println(input);
            // selecting 1 creates new recipe using the myRecipeBox object and addNewRecipe method
            if (input == 1) {
                myRecipeBox.addNewRecipe();
            // selecting 2 uses the printAllRecipeDetails to print the details of the Recipe name entered
            } else if (input == 2) {
                System.out.println("Which recipe?\n");
                menuScnr.nextLine();
                String selectedRecipeName = menuScnr.nextLine();
                myRecipeBox.printAllRecipeDetails(selectedRecipeName);
            // selecting 3 prints the list of recipe names by iterating through and printing each
            } else if (input == 3) {
                for (int j = 0; j < myRecipeBox.listOfRecipes.size(); j++) {
                    System.out.println((j + 1) + ": " + myRecipeBox.listOfRecipes.get(j).getRecipeName());
                }
            // selecting 4 uses findRecipeDetails to scale the recipe indicated by the user
            } else if (input == 4) {
                System.out.println("Which recipe?\n");
                menuScnr.nextLine();
                String recipeName = menuScnr.nextLine();
                myRecipeBox.findRecipeDetails(recipeName);
            // all other input returns to the menu
            } else {
                System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" + "3. Print All Recipe Names\n" 
                    + "4. Print Adjusted Recipe Amount\n" + "\nPlease select a menu item:");
            }
            //after selecting and exicuting a choice, this returns the user to the menu
            System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" + "3. Print All Recipe Names\n" 
                    + "4. Print Adjusted Recipe Amount\n" + "\nPlease select a menu item:");

        }
    }
}
