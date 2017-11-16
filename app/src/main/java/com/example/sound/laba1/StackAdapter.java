package com.example.sound.laba1;

/**
 * Created by sound on 20.10.2017.
 */

import java.util.ArrayList;
import java.util.List;
import android.support.v7.app.AppCompatActivity;
        import android.content.Context;
        import android.graphics.Color;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

        import android.view.ContextMenu;
        import android.view.ContextMenu.ContextMenuInfo;
        import android.os.Bundle;
        import android.app.Activity;

        import java.util.List;

public class StackAdapter extends ArrayAdapter<StackItem> {

    private List<StackItem> items;
    private Context context;
    public int positionYEAH;

    public StackAdapter(Context context, int textViewResourceId,
                        List<StackItem> objects) {
        super(context, textViewResourceId, objects);

        this.items = objects;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View itemView = convertView;
        if (itemView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = layoutInflater.inflate(R.layout.stack_item, null);
        }
        StackItem stackItem = items.get(position);
        if (stackItem != null) {
            // TextView defined in the stack_item.xml
            TextView textView = (TextView) itemView.findViewById(R.id.textView4);
            //TextView textView = (TextView) itemView.findViewById(textView4);
            // ImageView defined in the stack_item.xml
            ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView2);
            TextView textView7 = (TextView) itemView.findViewById(R.id.textView7);

            if (textView != null) {
                textView.setText(stackItem.getItemText());
                textView7.setText(stackItem.getItemInfo());
                // "image1", "image2",..
                String imageName = stackItem.getImageName();

                int resId = this.getDrawableResIdByName(imageName);

                imageView.setImageResource(resId);
                imageView.setBackgroundColor(Color.rgb(211, 204, 188));

                //findViewById(R.id.Button_change);
            }

        }

        return itemView;
    }




    // Find Image ID corresponding to the name of the image (in the drawable folder).
    public int getDrawableResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName, "drawable", pkgName);
        Log.i("MyLog", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }

}
