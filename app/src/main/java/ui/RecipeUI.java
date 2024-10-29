package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import data.RecipeFileHandler;

public class RecipeUI {
    private BufferedReader reader;
    private RecipeFileHandler fileHandler;//(定義している)

    public RecipeUI() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        fileHandler = new RecipeFileHandler();
    }

    public RecipeUI(BufferedReader reader, RecipeFileHandler fileHandler) {
        this.reader = reader;
        this.fileHandler = fileHandler;
    }

    public void displayMenu() {
        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        // 設問1: 一覧表示機能
                        displayRecipes();
                        break;
                    case "2":
                        // 設問2: 新規登録機能
                        addNewRecipe();
                        break;
                    case "3":
                        // 設問3: 検索機能
                        searchRecipe();
                        break;
                    case "4":
                        System.out.println("Exit the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    /**
     * 設問1: 一覧表示機能
     * RecipeFileHandlerから読み込んだレシピデータを整形してコンソールに表示します。
     * 読み込んだレシピデータが空の場合は、 No recipes available. というメッセージを出力します。
     */
    private void displayRecipes()throws IOException {
        //recipesに値を初期値として代入
        ArrayList<String> recipes = fileHandler.readRecipes();

        if(recipes.size() == 0) {
            System.out.println("No recipes available");
        } else {
            System.out.println("Recipes:");
            // 参考
            // String txt  = "Tomatoes, Onion, Garlic, Vegetable Stock";
            // txt.split(???);
            // txt[0] // "Tomato Soup"
            // txt[1] // "Onion, Garlic, Vegetable Stock"
            // System.out.pringln("Recipe Name:" + txt[0]);
            // System.out.pringln("Main Ingredients:" + txt[1]);

            //繰り返し処理(データの個数recipeの数回繰り返す)
            for (String recipe : recipes) {
                System.out.println("-----------------------------------");

                String[] foods = recipe.split(",", 2);
                System.out.println("Recipe Name: " + foods[0]);
                System.out.println("Main Ingredients: " + foods[1]);
                
            }
            System.out.println("-----------------------------------");
        }
    }

    /**
     * 設問2: 新規登録機能
     * ユーザーからレシピ名と主な材料を入力させ、RecipeFileHandlerを使用してrecipes.txtに新しいレシピを追加します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */

    // 【RecipeUI （表示）クラスaddNewRecipe メソッド】
    // 1、ユーザーからレシピ名と主な材料を入力させる
    // （1）BufferedReaderを使って入力を受け取る
    // 2、`RecipeFileHandler`を使用して`recipes.txt`に新しいレシピを追加 |
    // （1）addRecipeメソッドを呼び出す
    // （2）受け取ったレシピ名と材料を`recipes.txt`に追加する
    //     ⓵レシピ名を入力
    //     ⓶材料名を入力
    //     ⓷filePathに代入（UI:入力処理でもらってきてFileHAndlerに渡す）→※不要

    private void addNewRecipe() throws IOException {
        // 1、ユーザーからレシピ名と主な材料を入力させる
        // （1）BufferedReaderを使って入力を受け取る
        // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); → 15行目で定義しているので不要
        // 2、`RecipeFileHandler`を使用して`recipes.txt`に新しいレシピを追加 |
        // （2）受け取ったレシピ名と材料を`recipes.txt`に追加する
        //     ⓵レシピ名を入力
        System.out.print("Enter recipe name: ");
        String recipeName = reader.readLine();//readerを使用する（上部で定義）
        //     ⓶材料名を入力
        System.out.print("Enter main ingredients (comma separated): ");
        String ingredients =reader.readLine();
        
        // （1）addRecipeメソッドを呼び出す(FileHandlerに渡す)
        fileHandler.addRecipe(recipeName, ingredients);
        
        System.out.print("Recipe added successfully.");
    }

    /**
     * 設問3: 検索機能
     * ユーザーから検索クエリを入力させ、そのクエリに基づいてレシピを検索し、一致するレシピをコンソールに表示します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void searchRecipe() throws IOException {

    }

}

