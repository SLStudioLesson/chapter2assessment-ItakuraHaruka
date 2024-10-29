package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RecipeFileHandler {
    private String filePath;

    public RecipeFileHandler() {
        // filePath = "app/src/main/resources/recipes.txt";
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

    //  1. 返却用のリストを初期化する ArrayList<String> recipes = new ArrayList<>();
    ArrayList<String> recipes = new ArrayList<>();
    // 2. BufferedReaderを用いてrecipes.txtを読み込み、変数readerに代入する
    // * IOExceptionが発生したときはコンソールにエラーメッセージを表示する
    // * Error reading file: 例外のメッセージ
    public ArrayList<String> readRecipes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // 3. readerよりreadLine()を呼び出し、結果をlineに代入する（結果がnullとなるまで繰り返す）
            // * レシピデータを1行読み込み、recipesに追加する
            String line;
            while ((line = reader.readLine()) != null) {
                recipes.add(line);//lineをadd、1行分ずつ入ってくる
                // System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file:" + e.getMessage());
        }
        //4. recipesを返却する(readRecipes();実行元に)
        return recipes;
    }

    // /**
    //  * 設問2: 新規登録機能
    //  * 新しいレシピをrecipes.txtに追加します。<br>
    //  * レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。
    //  * IOExceptionが発生したときは`Error reading file: 例外のメッセージ`とコンソールに表示します。 |
    //  *
    //  * @param recipeName レシピ名
    //  * @param ingredients 材料名
    //  */

    public void addRecipe(String recipeName, String ingredients) {
        readRecipes();
        // 1、新しいレシピを`recipes.txt`に追加
        // （1）BufferedWriter を使ってファイルに書き込むコードを記述
        // （2）filePathを利用してrecipes.txtに保存する
        // （3）BuffferedWriterの記述にtrueと書き込み後の改行writer.newLineを追加
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true));) {
            writer.newLine();
        // 2、レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。
        // （1）writer.write()メソッドを使って文字列を保存する
            // writer.write(filePath);
            writer.write(recipeName + "," +ingredients);
        } catch (IOException e) {
        // 3、IOExceptionが発生したときは`Error reading file: 例外のメッセージ`とコンソールに表示 |
        // （1）try、catch構文を使って例外のメッセージを表示
            System.out.println("Error reading file:" + e.getMessage());
        }
    }
}



