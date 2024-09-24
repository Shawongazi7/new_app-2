package com.example.new_app_2;
import com.example.new_app_2.Recipe;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

//public class MyAdapter extends ArrayAdapter<String> {
//    private Context context;
//    private List<String> data;
//
//    public MyAdapter(Context context, ArrayList<Recipe> recipes) {
//        super(context, 0, getRecipeNames(recipes));
//        this.context = context;
//        this.data = getRecipeNames(recipes);
//    }
//
//    private static List<String> getRecipeNames(ArrayList<Recipe> recipes) {
//        List<String> recipeNames = new ArrayList<>();
//        for (Recipe recipe : recipes) {
//            recipeNames.add(recipe.getName());
//        }
//        return recipeNames;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View view = convertView;
//        if (view == null) {
//            view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
//        }
//
//        TextView textView = (TextView) view.findViewById(R.id.text_view);
//        textView.setText(data.get(position));
//
//        return view;
//    }
//}


public class MyAdapter extends ArrayAdapter<Recipe> {
    private Context context;
    private List<Recipe> recipes;

    public MyAdapter(Context context, ArrayList<Recipe> recipes) {
        super(context, 0, recipes);
        this.context = context;
        this.recipes = recipes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
        }

        TextView textView = (TextView) view.findViewById(R.id.text_view);
        Recipe recipe = recipes.get(position);
        textView.setText(recipe.getName() + " - " + recipe.getFoodItems().toString());

        return view;
    }
}