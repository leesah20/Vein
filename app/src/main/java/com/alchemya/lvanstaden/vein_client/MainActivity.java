package com.alchemya.lvanstaden.vein_client;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private static final Class[] CLASSES = new Class[]{
            //  GoogleSignInActivity.class,
            // FacebookLoginActivity.class,
            // TwitterLoginActivity.class,
            EmailPasswordActivity.class,
            //  AnonymousAuthActivity.class,
            //  FirebaseUIActivity.class,
            //  CustomAuthActivity.class
    };

    private static final int[] LABEL_IDS = new int[]{
            R.string.label_emailpassword
    };


    private static final int[] DESCRIPTION_IDS = new int[]{
//            R.string.desc_google_sign_in,
//            R.string.desc_facebook_login,
//            R.string.desc_twitter_login,
            R.string.desc_emailpassword,
//            R.string.desc_anonymous_auth,
//            R.string.desc_firebase_ui,
//            R.string.desc_custom_auth,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("create", "blahblahblah");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Set up ListView and Adapter
        ListView listView = (ListView) findViewById(R.id.list_view);
        MyArrayAdapter adapter = new MyArrayAdapter(this, android.R.layout.simple_list_item_2, CLASSES);
        adapter.setDescriptionIds(DESCRIPTION_IDS);
        adapter.setLabelIds(LABEL_IDS);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Class clicked = CLASSES[position];
        startActivity(new Intent(this, clicked));
    }




    public static class MyArrayAdapter extends ArrayAdapter<Class> {
        private Context mContext;
        private Class[] mClasses;
        private int[] mLabelIds;
        private int[] mDescriptionIds;
        public MyArrayAdapter(Context context, int resource, Class[] objects) {
            super(context, resource, objects);
            mContext = context;
            mClasses = objects;
        }


        @Override

        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(android.R.layout.simple_list_item_2, null);
            }

            ((TextView) view.findViewById(android.R.id.text1)).setText(mLabelIds[position]);
            ((TextView) view.findViewById(android.R.id.text2)).setText(mDescriptionIds[position]);

            return view;
        }


        public void setDescriptionIds(int[] descriptionIds) {

            mDescriptionIds = descriptionIds;
        }

        public void setLabelIds(int[] labelIds) {
            this.mLabelIds = labelIds;
        }
    }


}
