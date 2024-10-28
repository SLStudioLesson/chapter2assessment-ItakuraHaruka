package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RecipeFileHandler {
    private String filePath;

    public RecipeFileHandler() {
        filePath = "app/src/main/resources/recipes.txt";
    }

    public RecipeFileHandler(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 設問1: 一覧表示機能
     * recipes.txtからレシピデータを読み込み、それをリスト形式で返します。 <br>
     * IOExceptionが発生したときは<i>Error reading file: 例外のメッセージ</i>とコンソールに表示します。
     *
     * @return レシピデータ
     */
    public ArrayList<String> readRecipes() throws IOException {
        // 1.Main Menu:とディスプレイの出力
        // System.out.println(
        //         Main Menu:
        //         \n 1: Display Recipes
        //         \n 2: Add New Recipe
        //         \n 3: Search Recipe
        //         \n 4: Exit Application
        //         \n Please choose an option: ");

        try {

        //2.番号の入力を受け取る
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int option = Integer.parseInt(reader.readLine());
        System.out.print(option);

        } catch (IOException e) {
            System.out.println("Error reading file:" + e.getMessage());
        }
        return null;

        //3.「Recipes:」と出力
        System.out.println("Recipes:");

        //4.繰り返し処理(データの個数20回繰り返す)
            for (int i = 0; i < 20; i++) {
            // (1)-----------------------------------
            //    Recipe Name: + 「recipes.txt」の各列一単語目
                System.out.println("-----------------------------------" +
                "Recipe Name:");
            }

            // (2)「Main Ingredients: 」と出力
            // (3)上記に続いて2単語目以降を（「,」で区切って）出力
                System.out.println("Main Ingredients:");

    }
    

    /**
     * 設問2: 新規登録機能
     * 新しいレシピをrecipes.txtに追加します。<br>
     * レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。
     *
     * @param recipeName レシピ名
     * @param ingredients 材料名
     */
     //
    public void addRecipe(String recipeName, String ingredients) {
        // 1.Main Menu:とディスプレイを出力
        // System.out.print(
        //         Main Menu:
        //         \n 1: Display Recipes
        //         \n 2: Add New Recipe
        //         \n 3: Search Recipe
        //         \n 4: Exit Application
        //         \n Please choose an option: ");

        // 2.番号を受け付ける
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        

        // 3.ファイル「RecipeFileHandler」に書き込む
        try(BufferedWriter writer = new BufferedWriter(new FilneWriter(recipes ,true))) {
            writer.write(contentTowrite);
            writer.newLine();
            // 4. 「Enter recipe name: 」と出力
            System.out.println("Enter recipe name: ");
            // 5.レシピ名を受け付ける
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            // 6.「recipes.txt」に追加する
            String recipe = reader.readLine();
            // 7.「Enter main ingredients (comma separated): 」と出力
            System.out.println("Enter main ingredients (comma separated): ");
            // 8. 材料を受け付ける
            String ingredient = reader.readLine();
            // 9. 「recipes.txt」に追加する
            
            // 10.「Recipe added successfully.」と出力
            System.out.println("Recipe added successfully.");
        } catch (IOException e) {
            System.out.println("Error reading file:" + e.getMessage());
        }

    }
}
