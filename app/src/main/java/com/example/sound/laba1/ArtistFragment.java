package com.example.sound.laba1;

/**
 * Created by sound on 09.11.2017.
 */

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.StackView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ArtistFragment extends Fragment {


    public static final String TITLE = "Artists";
    private StackView stackView;
    private Button buttonChange;
    private ImageButton buttonNext;
    private ImageButton buttonPrevious;
    private final String[] IMAGE_NAMES= {"aim1","aim2", "aim3", "aim4"};
    public static ArtistFragment newInstance() {

        return new ArtistFragment();
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        this.stackView = (StackView) getView().findViewById(R.id.stackView);
        this.buttonNext =(ImageButton) getView().findViewById(R.id.bnext);
        this.buttonPrevious= (ImageButton) getView().findViewById(R.id.bprev);
        List<StackItem> items = new ArrayList<StackItem>();
        List<String> names = new ArrayList<String>();
        names.add("CBL");
        names.add("Bicep");
        names.add("Gilmour");
        names.add("Aphex");
        List<String> info = new ArrayList<String>();
        info.add("Ambient");
        info.add("House");
        info.add("Rock");
        info.add("IDM");
        /*
        for(String imageName: IMAGE_NAMES) {
            items.add(new StackItem(imageName+".jpg", imageName));
        }
        */
        for(int i=0;i<IMAGE_NAMES.length;i++){
            items.add(new StackItem( names.get(i),IMAGE_NAMES[i], info.get(i) ));
        }

        StackAdapter adapt = new StackAdapter(this.getContext(), R.layout.stack_item, items);
        stackView.setAdapter(adapt);
        stackView.setHorizontalScrollBarEnabled(true);
        stackView.setBackgroundColor(Color.rgb(230, 255, 255));

        buttonNext.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                stackView.showNext();
            }
        });

        buttonPrevious.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                stackView.showPrevious();
            }
        });
        registerForContextMenu(stackView);
        getView().findViewById(R.id.Button_change);
        for (int i=0;i<stackView.getCount();i++){
            registerForContextMenu(stackView.getCurrentView());
            stackView.showNext();
        }
        for (int i=0;i<stackView.getCount();i++){
            //registerForContextMenu(stackView.getCurrentView());
            stackView.showPrevious();
        }

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.clear();
        menu.setHeaderTitle("");
        menu.add(0,0,0,R.string.Favorites);
        menu.add(0,1,0,R.string.Change_info);
        menu.add(0,2,0,R.string.Delete);
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                Toast.makeText(this.getContext(), getString(R.string.ChangesYes),
                        Toast.LENGTH_LONG).show();

                break;
            case 1:

                Intent intent = new Intent(this.getContext(), activity_test.class);
                intent.putExtra("img","iam1");
                intent.putExtra("name","David Gilmour");
                intent.putExtra("info","Rock");
                startActivity(intent);
                break;
            case 2:
                Toast.makeText(this.getContext(), getString(R.string.ChangesYes),
                        Toast.LENGTH_LONG).show();
                break;
            /*case ITEM_CANCEL:
                closeContextMenu();
                break;*/
        }

        return true;
    }

    public void onMyButtonClick(View view)
    {
        // выводим сообщение
        Toast.makeText(this.getContext(), R.string.PlayingMusic, Toast.LENGTH_SHORT).show();
        //finish();
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_albums, container, false);
    }
}
