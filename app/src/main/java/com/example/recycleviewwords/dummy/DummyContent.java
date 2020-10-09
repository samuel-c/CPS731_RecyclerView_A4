package com.example.recycleviewwords.dummy;

import android.util.Log;

import com.example.recycleviewwords.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 8;

    static {
        // Add content
        initContent();
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(String recipeName, int imageId, String id){
        String dummyText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
                "eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        return new DummyItem(
                imageId,
                recipeName,
                recipeName + " description. " + dummyText,
                recipeName + " recipe. " + dummyText,
                id
        );
    }

    private static void initContent(){

        String [] recipeNames = {"Ham Sandwich", "Italian Salad", "Veggie Soup", "Homemade Pizza"
                , "Plain Muffins", "Cookies", "Pie", "Cake"};
        int [] imageIds = {R.drawable.sandwich, R.drawable.salad, R.drawable.soup,
                R.drawable.pizza, R.drawable.muffin, R.drawable.cookies, R.drawable.pie,
                R.drawable.cake};

        for (int i = 0; i < recipeNames.length; i ++){
            addItem(createDummyItem(recipeNames[i], imageIds[i], String.valueOf(i)));
        }

    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String recipeTitle;
        public final String recipeDesc;
        public final int recipeImage;
        public final String recipeText;
        public final String id;
        /*
        public final String id;
        public final String content;
        public final String details;

         */

        public DummyItem( int recipeImage,String recipeTitle, String recipeDesc,
                         String recipeText, String id) {
            this.recipeTitle = recipeTitle;
            this.recipeDesc = recipeDesc;
            this.recipeImage = recipeImage;
            this.recipeText = recipeText;
            this.id = id;
        }

        @Override
        public String toString() {
            return recipeTitle;
        }
    }
}